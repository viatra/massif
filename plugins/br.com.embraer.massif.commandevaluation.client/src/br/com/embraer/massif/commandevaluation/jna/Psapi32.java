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
