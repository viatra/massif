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

% Instantiate a MATLAB Simulink model creator
 modelImporter = hu.bme.mit.massif.simulink.cli.CLIMatlabCreator;
% Create a new Simulink model based on a Massif model
% Parameters:
%           - modelName : imported Massif model file name
%           - modelPath : Massif model location
%           - extension : (optional) extension to be used when saving
%           MATLAB model ('slx' by default)
 modelImporter.createMatlabModel('Example', pwd);