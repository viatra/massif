/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.util.bus;

import static com.google.common.base.Preconditions.checkArgument;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.GenericQueryGroup;
import org.eclipse.viatra.query.runtime.api.IQueryGroup;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import hu.bme.mit.massif.models.simulink.util.FirstOutPortFromBusSpecification;
import hu.bme.mit.massif.models.simulink.util.NextOutPortInPath;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;

/**
 * TODO: use logger!
 * 
 * 
 * @author Abel Hegedus
 * 
 */
public class BusSignalMapper {
    protected AdvancedViatraQueryEngine viatraEngine;
    protected NextOutPortInPath.Matcher nextOutPortInPathMatcher;
    private FirstOutPortFromBusSpecification.Matcher firstOutPortFromBusSpecificationMatcher;
    private ISimulinkAPILogger logger;

    /**
     * Creates a mapper for bus signals in models contained by the given resource set.
     * 
     * @param busMappingResourceSet
     * @throws IllegalStateException
     *             if the provided resource set cannot be used for initializing an EMF-IncQuery engine
     */
    public BusSignalMapper(ResourceSet busMappingResourceSet) {
        checkArgument(busMappingResourceSet != null, "Resource set for bus mapping path finder cannot be null!");
        try {
            viatraEngine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(busMappingResourceSet));
            IQueryGroup group = GenericQueryGroup.of(NextOutPortInPath.instance(),
                    FirstOutPortFromBusSpecification.instance());
            group.prepare(viatraEngine);

            nextOutPortInPathMatcher = NextOutPortInPath.Matcher.on(viatraEngine);
            firstOutPortFromBusSpecificationMatcher = FirstOutPortFromBusSpecification.Matcher.on(viatraEngine);
        } catch (ViatraQueryException e) {
            throw new IllegalStateException("Could not initialize matcher for bus mapping path finder!", e);
        }
    }

    public AdvancedViatraQueryEngine getEngine() {
        return viatraEngine;
    }

    protected NextOutPortInPath.Matcher getNextOutPortInPathMatcher() {
        return nextOutPortInPathMatcher;
    }

    protected FirstOutPortFromBusSpecification.Matcher getFirstOutPortFromBusSpecificationMatcher() {
        return firstOutPortFromBusSpecificationMatcher;
    }

    public OutPort getConnectedOutPort(InPort selectorInport) {
        SingleConnection connection = selectorInport.getConnection();
        OutPort previousOutPort = null;
        if (connection != null) {
            MultiConnection parent = connection.getParent();
            if (parent != null) {
                previousOutPort = parent.getFrom();
            } else {
                previousOutPort = connection.getFrom();
            }
        }
        return previousOutPort;
    }

    public String getCollisionFreeLineName(InPort inport) {
        Block creator = inport.getContainer();
        int portNumber = creator.getInports().indexOf(inport) + 1;
        String lineName = getNonEmptyLineName(inport, portNumber);
        boolean collision = checkForLineNameCollision(creator, portNumber, lineName);
        if (collision) {
            lineName = lineName + " (signal " + portNumber + ")";
        }
        return lineName;
    }

    public String getNonEmptyLineName(InPort inport, int portNumber) {
        String lineName = inport.getConnection().getLineName();
        if (lineName == null || lineName.startsWith("DERIVED_LINE_NAME")) { // FIXME change to nullOrEmpty
            lineName = "signal" + portNumber;
        }
        lineName = lineName.replace('.', ':').replace(',', ';');
        return lineName;
    }

    public boolean checkForLineNameCollision(Block creator, int portNumber, String lineName) {
        EList<InPort> inports = creator.getInports();
        for (int index = 0; index < inports.size(); index++) {
            int portNo = index + 1;
            if (portNo != portNumber) {
                InPort iP = inports.get(index);
                String otherName = getNonEmptyLineName(iP, portNo);
                if (otherName.equals(lineName)) {
                    // the real or derived name of an other incoming line is the same as the current line
                    return true;
                }
            }
        }
        return false;
    }

    public void logDebug(String formatMessage, Object... arguments) {
        if (logger != null) {
            String formattedMessage = String.format(formatMessage, arguments);
            logger.debug(formattedMessage);
        }
    }

    public boolean isDebugging() {
        return logger != null ? logger.isDebugging() : false;
    }

    public void setLogger(ISimulinkAPILogger logger) {
        this.logger = logger;
    }

    public String getFQNOrEmpty(SimulinkElement element) {
        String fqn = "NULL ELEMENT";
        if (element != null) {
            SimulinkReference ref = element.getSimulinkRef();
            if (ref == null) {
                fqn = String.format("NO REF(%s)", element);
            } else {
                fqn = ref.getFQN();
            }
        }
        return fqn;
    }
}