###############################################################################
# Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
# All rights reserved. This program and the accompanying materials 
# are made available under the terms of the Eclipse Public License v1.0 
# which accompanies this distribution, and is available at 
# http://www.eclipse.org/legal/epl-v10.html 
#
# Contributors: 
#     Abel Hegedus - initial API and implementation 
###############################################################################
TARGETDIR=$WORKSPACE/releng/massif.commandevaluation.server-package
MATLABDIRPARENT=$TARGETDIR
PLUGINSDIR=$WORKSPACE/plugins

mkdir -p $MATLABDIRPARENT/matlab

cp $PLUGINSDIR/br.com.embraer.massif.commandevaluation.base/target/br.com.embraer.massif.commandevaluation.base*-SNAPSHOT.jar $MATLABDIRPARENT/matlab/br.com.embraer.massif.commandevaluation.base.jar
cp $PLUGINSDIR/br.com.embraer.massif.commandevaluation.server/target/br.com.embraer.massif.commandevaluation.server*-SNAPSHOT.jar $MATLABDIRPARENT/matlab/br.com.embraer.massif.commandevaluation.server.jar
cp $PLUGINSDIR/br.com.embraer.massif.commandevaluation.server/setup_remote.m $MATLABDIRPARENT/matlab
cp $PLUGINSDIR/hu.bme.mit.massif.simulink.api/scripts/library_collector.m $MATLABDIRPARENT/matlab
cp $WORKSPACE/tests/br.com.embraer.massif.commandevaluation.tests/testconfig/matlabserverconfig.properties $MATLABDIRPARENT/matlab
cd $MATLABDIRPARENT

zip -r massif.commandevaluation.server.zip ./matlab
