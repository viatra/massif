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
% Add the simulink CLI package to the classpath
javaaddpath('hu.bme.mit.massif.simulink.cli-package.jar');

% Instantiate an EMF model creator
modelExporter = hu.bme.mit.massif.simulink.cli.CLIEMFCreator;
% Create a new Massif model based on a Simulink model
% Parameters:
%           - modelName : Name of the Simulink model used
%           - modelPath : Location of the Simulink model (the created 
%           Massif model will saved here as well)
%           - importmode : (optional) import mode to be used when creating
%           Massif model ('FLATTENING' by default)
modelExporter.createSimulinkModel('Example_MATLAB', pwd);