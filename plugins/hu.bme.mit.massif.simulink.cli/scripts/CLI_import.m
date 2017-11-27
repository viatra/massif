%##############################################################################
% Copyright (c) 2010-2017, IncQuery Labs Ltd.
% All rights reserved. This program and the accompanying materials 
% are made available under the terms of the Eclipse Public License v1.0 
% which accompanies this distribution, and is available at 
% http://www.eclipse.org/legal/epl-v10.html 
%
% Contributors: 
%     Peter Lunk- initial API and implementation 
%##############################################################################
javaaddpath('hu.bme.mit.massif.simulink.cli-package.jar');

modelImporter = hu.bme.mit.massif.simulink.cli.CLIMatlabCreator;
modelImporter.createMatlabModel('name', 'resultPath')