javaaddpath('br.com.embraer.transima.matlab.commandevaluation.base.jar');
javaaddpath('br.com.embraer.transima.matlab.commandevaluation.server.jar');

pid = feature('getpid');
modelProviderServer = br.com.embraer.transima.matlab.commandevaluation.server.ServerEntryPoint;
modelProviderServer.startRMIServer('r2012b',num2str(pid),'');