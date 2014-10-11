package br.com.embraer.massif.commandevaluation.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * Interface class used to invoke methods from Psapi
 * 
 * @author ldnascim
 */
public interface Psapi32 extends StdCallLibrary {
	Psapi32 INSTANCE = (Psapi32) Native.loadLibrary("psapi", Psapi32.class, 
            W32APIOptions.UNICODE_OPTIONS);

	/*
     * http://msdn.microsoft.com/en-us/library/ms683198(VS.85).aspx
     */
    int GetModuleFileNameExW(Pointer hProcess, Pointer hModule, char[] lpImageFileName, int nSize);
}
