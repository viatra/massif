javaaddpath('br.com.embraer.massif.commandevaluation.base.jar');
javaaddpath('br.com.embraer.massif.commandevaluation.server.jar');

pid = feature('getpid');
modelProviderServer = br.com.embraer.massif.commandevaluation.server.ServerEntryPoint;
modelProviderServer.startRMIServer('r2012b',num2str(pid),'');