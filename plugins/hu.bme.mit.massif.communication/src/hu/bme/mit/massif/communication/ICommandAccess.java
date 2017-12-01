/*******************************************************************************
 * Copyright (c) 2010-2017, IncQueryLabs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Peter Lunk - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication;

/**
 * Interface for defining various MATLAB access methods
 * 
 * @author Peter Lunk
 *
 */
public interface ICommandAccess {

    public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws Exception;

    public Object[] executeEval(String command, int numberOfOutputs) throws Exception;
    
}
