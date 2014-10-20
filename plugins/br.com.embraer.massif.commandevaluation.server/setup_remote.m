%##############################################################################
% Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
% All rights reserved. This program and the accompanying materials 
% are made available under the terms of the Eclipse Public License v1.0 
% which accompanies this distribution, and is available at 
% http://www.eclipse.org/legal/epl-v10.html 
%
% Contributors: 
%     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
%##############################################################################
javaaddpath('br.com.embraer.massif.commandevaluation.base.jar');
javaaddpath('br.com.embraer.massif.commandevaluation.server.jar');

pid = feature('getpid');
ver = strcat('r',version('-release'))

modelProviderServer = br.com.embraer.massif.commandevaluation.server.ServerEntryPoint;
modelProviderServer.startRMIServer(ver,num2str(pid),'')