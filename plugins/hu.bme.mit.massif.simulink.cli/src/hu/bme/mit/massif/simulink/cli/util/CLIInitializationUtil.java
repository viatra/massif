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
package hu.bme.mit.massif.simulink.cli.util;

import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.viatra.addon.querybasedfeatures.runtime.QueryBasedFeatureSettingDelegateFactory;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.extensibility.IQuerySpecificationProvider;
import org.eclipse.viatra.query.runtime.extensibility.SingletonQuerySpecificationProvider;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchEMFBackendFactory;
import org.eclipse.viatra.query.runtime.registry.QuerySpecificationRegistry;
import org.eclipse.viatra.query.runtime.registry.connector.SpecificationMapSourceConnector;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

import hu.bme.mit.massif.models.simulink.derived.DerivedFeatures;
import hu.bme.mit.massif.simulink.SimulinkPackage;

/**
 * @author Peter Lunk
 *
 */
public class CLIInitializationUtil {

    public static void setupEnvironment() throws ViatraQueryException {
        SimulinkPackage.eINSTANCE.eClass();
        registerQuerySpecifications();
        EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put("org.eclipse.viatra.query.querybasedfeature",
                new QueryBasedFeatureSettingDelegateFactory());
        ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE, LocalSearchEMFBackendFactory.INSTANCE);
    }

    private static void registerQuerySpecifications() throws ViatraQueryException {
        QuerySpecificationRegistry querySpecificationRegistry = (QuerySpecificationRegistry) QuerySpecificationRegistry.getInstance();

        DerivedFeatures group = DerivedFeatures.instance();
        Set<IQuerySpecification<?>> specifications = group.getSpecifications();
        SpecificationMapSourceConnector connector = new SpecificationMapSourceConnector(group.getClass().getName(), true);
        for (IQuerySpecification<?> iQuerySpecification : specifications) {

            IQuerySpecificationProvider provider = new SingletonQuerySpecificationProvider(iQuerySpecification);

            // add specification to source
            connector.addQuerySpecificationProvider(provider);

        }
        querySpecificationRegistry.addSource(connector);
    }
}
