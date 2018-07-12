/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.client.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.embraer.massif.commandevaluation.exception.MatlabError;
import br.com.embraer.massif.commandevaluation.exception.MatlabRegistryException;
import br.com.embraer.massif.commandevaluation.jna.Psapi32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;

/**
 * Class used to retrieve the current running matlabs processes with its version and file path
 * 
 * @author ldnascim
 */
public class MatlabRunningManager {

    // Required to retrieve certain information about a process
    public static final int PROCESS_QUERY_INFORMATION = 0x0400;
    // Required to read information about a process
    public static final int PROCESS_VM_READ = 0x0010;

    private static Map<String, String> matlabVersions = new HashMap<String, String>();

    /**
     * Initialize the map with all matlab versions
     */
    static {
        matlabVersions.put("5.1.1", "R9.1");
        matlabVersions.put("5.2", "R10");
        matlabVersions.put("5.2.1", "R10.1");
        matlabVersions.put("5.3", "R11");
        matlabVersions.put("5.3.1", "R11.1");
        matlabVersions.put("6.0", "R12");
        matlabVersions.put("6.1", "R12.1");
        matlabVersions.put("6.5", "R13");
        matlabVersions.put("6.5.1", "R13SP1");
        matlabVersions.put("6.5.2", "R13SP2");
        matlabVersions.put("7.0", "R14");
        matlabVersions.put("7.0.1", "R14SP1");
        matlabVersions.put("7.0.4", "R14SP2");
        matlabVersions.put("7.1", "R14SP3");
        matlabVersions.put("7.2", "R2006a");
        matlabVersions.put("7.3", "R2006b");
        matlabVersions.put("7.4", "R2007a");
        matlabVersions.put("7.5", "R2007b");
        matlabVersions.put("7.6", "R2008a");
        matlabVersions.put("7.7", "R2008b");
        matlabVersions.put("7.8", "R2009a");
        matlabVersions.put("7.9", "R2009b");
        matlabVersions.put("7.9.1", "R2009bSP");
        matlabVersions.put("7.10", "R2010a");
        matlabVersions.put("7.11", "R2010b");
        matlabVersions.put("7.11.1", "R2010bSP");
        matlabVersions.put("7.12", "R2011a");
        matlabVersions.put("7.13", "R2011b");
        matlabVersions.put("7.14", "R2012a");
        matlabVersions.put("8.0", "R2012b");
        matlabVersions.put("8.1", "R2013a");
        matlabVersions.put("8.2", "R2013b");
        matlabVersions.put("8.3", "R2014a");
        matlabVersions.put("8.4", "R2014b");
        matlabVersions.put("8.5", "R2015a");
        matlabVersions.put("8.6", "R2015b");
        matlabVersions.put("9.0", "R2016a");
        matlabVersions.put("9.1", "R2016b");
        matlabVersions.put("9.2", "R2017a");
        matlabVersions.put("9.3", "R2017b");
        matlabVersions.put("9.4", "R2018a");
    }

    /**
     * Returns a map containing the current matlab running processes. The key is the process file path, and the value is
     * the matlab version
     * 
     * @return
     * @throws MatlabRegistryException
     */
    public static List<MatlabProcessInformation> getRunningMatlabs() throws MatlabRegistryException {
        Kernel32 kernel32 = (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
        Map<String, Integer> processes = findProcessPIDs(kernel32);
        AvailableVersions versions = findAvailableMatlabVersions(kernel32);
        List<MatlabProcessInformation> runningMatlabs = findRunningMatlabsFromPIDs(versions, processes);
        return runningMatlabs;
    }

    private static boolean isWow64Machine(Kernel32 kernel32) {
        HANDLE curProcessHandle = kernel32.GetCurrentProcess();
    
        // create value to be passed as reference, and initialize with a value
        // different from a "BOOL" one (0 or 1)
        IntByReference isWow64 = new IntByReference(42);
        kernel32.IsWow64Process(curProcessHandle, isWow64);
    
        // check if it is running on a 32-bits or 64-bits machine
        boolean isWow64Process = (isWow64.getValue() == 1);
        boolean isWow64Pointer = (Pointer.SIZE == 8);
        boolean isWow64Machine = isWow64Process || isWow64Pointer;
        return isWow64Machine;
    }

    private static AvailableVersions findAvailableMatlabVersions(Kernel32 kernel32) throws MatlabRegistryException {
        AvailableVersions versions = new AvailableVersions();
        versions.isWow64Machine = isWow64Machine(kernel32);
        try {
            findAvailableVersions(versions);
        } catch (IllegalAccessException e) {
            throwMatlabRegistryException(e, versions.currentKey);
        } catch (InvocationTargetException e) {
            throwMatlabRegistryException(e, versions.currentKey);
        }
        return versions;
    }

    private static void findAvailableVersions(AvailableVersions versions) throws IllegalAccessException,
            InvocationTargetException {
        // Retrieves the current matlab 64-bits installed, if is a 64-bits machine
        // if is a 32-bits machine, retrieves the current 32-bits installed
        versions.currentKey = "SOFTWARE\\MathWorks\\MATLAB";
        List<String> currentVersions64or32bits = WinRegistry.readStringSubKeys(WinRegistry.HKEY_LOCAL_MACHINE,
            versions.currentKey, 0);
        if (currentVersions64or32bits != null) {
            for (String version64or32bits : currentVersions64or32bits) {
                versions.currentKey = "SOFTWARE\\MathWorks\\MATLAB\\" + version64or32bits;
                String folderPath = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE, versions.currentKey,
                    "MATLABROOT",
                    WinRegistry.KEY_WOW64_64KEY);
                if (folderPath != null && !folderPath.isEmpty()) {
                    if (versions.isWow64Machine) {
                        versions.availableVersions64bits.put(version64or32bits, folderPath);
                    } else {
                        versions.availableVersions32bits.put(version64or32bits, folderPath);
                    }
                }
            }
        }

        // Retrieves the current matlab 32-bits installed
        versions.currentKey = "SOFTWARE\\Wow6432Node\\MathWorks\\MATLAB";
        List<String> currentVersions32bits = WinRegistry.readStringSubKeys(WinRegistry.HKEY_LOCAL_MACHINE,
            versions.currentKey,
            0);
        if (currentVersions32bits != null) {
            for (String version32bits : currentVersions32bits) {
                versions.currentKey = "SOFTWARE\\MathWorks\\MATLAB\\" + version32bits;
                String folderPath = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE, versions.currentKey,
                    "MATLABROOT",
                    WinRegistry.KEY_WOW64_32KEY);
                if (folderPath != null && !folderPath.isEmpty()) {
                    versions.availableVersions32bits.put(version32bits, folderPath);
                }
            }
        }
    }

    private static void throwMatlabRegistryException(Exception excp, String currentKey) throws MatlabRegistryException {
        MatlabRegistryException exception = new MatlabRegistryException(MatlabError.READING_REGISTRY_ERROR, excp);
        exception.set("key", currentKey);
        throw exception;
    }

    private static Map<String, Integer> findProcessPIDs(Kernel32 kernel32) {
        Map<String, Integer> processes = new HashMap<String, Integer>();
        String matlabExe = "matlab.exe";

        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();

        // gets all current running processes
        WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        if (kernel32.Process32First(snapshot, processEntry)) {
            while (kernel32.Process32Next(snapshot, processEntry)) {
                String exePath = Native.toString(processEntry.szExeFile);
                exePath = exePath.toLowerCase();

                // check if its a matlab process
                if (!exePath.equalsIgnoreCase(matlabExe)) {
                    continue;
                }

                WinNT.HANDLE hProcess = kernel32.OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, false,
                    processEntry.th32ProcessID.intValue());

                // gets process path
                if (hProcess != null && hProcess.getPointer() != null) {
                    char[] filePath = new char[1024];
                    Psapi32.INSTANCE.GetModuleFileNameExW(hProcess.getPointer(), null, filePath, 256);
                    String processPath = Native.toString(filePath);
                    int pid = kernel32.GetProcessId(hProcess);
                    processes.put(processPath, pid);
                }
            }
        }
        return processes;
    }

    private static List<MatlabProcessInformation> findRunningMatlabsFromPIDs(AvailableVersions versions,
        Map<String, Integer> processes) {
        List<MatlabProcessInformation> runningMatlabs = new ArrayList<MatlabProcessInformation>();

        // retrieves the version of the current matlab processes
        for (Entry<String, Integer> processEntry : processes.entrySet()) {
            String processPath = processEntry.getKey();
            Integer processPID = processEntry.getValue();
            MatlabProcessInformation info = findRunningMatlabFromPID(versions, processPath, processPID);
            if (!info.isEmpty()) {
                runningMatlabs.add(info);
            }
        }
        return runningMatlabs;
    }

    private static MatlabProcessInformation findRunningMatlabFromPID(AvailableVersions versions, String processPath,
        Integer processPID) {
        MatlabProcessInformation info = findRunningMatlab(versions.availableVersions32bits, processPath, processPID);
        if (!info.isEmpty()) {
            info.is32bits = true;
        } else {
            // if is not a 32-bits matlab version, check if
            // is a 64-bits one(it should be)
            info = findRunningMatlab(versions.availableVersions64bits, processPath, processPID);
            if (!info.isEmpty()) {
                info.is32bits = false;
            }
        }
        return info;
    }

    private static MatlabProcessInformation findRunningMatlab(Map<String, String> availableVersions,
        String processPath, Integer processPID) {
        for (Entry<String, String> versionEntry : availableVersions.entrySet()) {
            String version = versionEntry.getKey();
            String folder = versionEntry.getValue();
            MatlabProcessInformation information = prepareMatlabInformation(processPath, processPID, version, folder);
            if (!information.isEmpty()) {
            	return information;
            }
        }
        return new MatlabProcessInformation();
    }

    private static MatlabProcessInformation prepareMatlabInformation(String processPath, Integer processPID,
        String version, String folder) {
        // if this formatting is not performed a 64-bits executable could be
        // considered as a 32-bits one, since the begin of the
        // folder path for both are the same:
        // Example: "C:\MATLAB\R2012b" and "C:\MATLAB\R2012b-x64"
        String folderEndedWithSeparator = folder;
        if (!folder.endsWith(File.separator)) {
            folderEndedWithSeparator = folder + File.separator;
        }

        MatlabProcessInformation info = new MatlabProcessInformation();
        if (processPath.toUpperCase().startsWith(folderEndedWithSeparator.toUpperCase()) && matlabVersions.containsKey(version)) {
            String release = matlabVersions.get(version);
            info.path = processPath;
            info.pid = processPID;
            info.release = release;
        }
        return info;
    }

    private static class AvailableVersions {
        Map<String, String> availableVersions64bits = new HashMap<String, String>();
        Map<String, String> availableVersions32bits = new HashMap<String, String>();
        boolean isWow64Machine;
        String currentKey = "";
    }
}