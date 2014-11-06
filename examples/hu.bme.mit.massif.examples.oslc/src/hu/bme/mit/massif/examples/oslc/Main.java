/*******************************************************************************
 * Copyright (c) 2010-2014, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.examples.oslc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import net.oauth.OAuthException;

import org.apache.wink.client.ClientResponse;
import org.eclipse.lyo.client.exception.ResourceNotFoundException;
import org.eclipse.lyo.client.oslc.OSLCConstants;
import org.eclipse.lyo.client.oslc.OslcClient;

/**
 * This is a basic example on creating an OSLC client for the Matlab Simulink OSLC Adaptor. This example assumes a Matlab Server running
 * at localhost with the service context of OSLCSimulinkAdaptor, while the simulink model is open in the matlab.
 * 
 * @author Robert Doczi
 *
 */
public class Main {

    public static void main(String[] args) {

        // Create a basic OSLC client
        OslcClient client = new OslcClient();

        try {
            // The URL of the OSLC Adaptor catalog
            String catalogUrl = "http://localhost:8080/OSLCSimulinkAdaptor/services/catalog/";
            // The title of the service provider
            String serviceProviderTitle = "SimulinkProvider: simulink(/simulinkId)";

            // Search for a service provider from the specified catalog
            final String simuServiceProvider = client.lookupServiceProviderUrl(catalogUrl, serviceProviderTitle);

            // The resource type we want to query
            String resourceType = "triggerBlockResources";

            // Get every trigger block in the specified model in an RDF format
            ClientResponse resource = client.getResource(simuServiceProvider + '/' + resourceType, OSLCConstants.CT_RDF);
            // Get an InputStream from the client response to read its contents
            InputStream is = resource.getEntity(InputStream.class);
            
            // Read the contents of the response and print it out on standard output
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            String str;

            while ((str = br.readLine()) != null && str.length() != 0) {
                System.out.println(str);
            }
            
            // The resource type we want to query
            resourceType = "subSystemResources";
            // The OSLC id of the specific resource
            String resourceId = "simulink$1SL1$Commonly$1S1$Used$1S1$Blocks$1SL1$Subsystem";
            
            // Get the specific resource identified by the id and of the specified type
            resource = client.getResource(simuServiceProvider + '/' + resourceType + '/' + resourceId, OSLCConstants.CT_RDF);
            
            // Read the contents as before
            is = resource.getEntity(InputStream.class);            
            br = new BufferedReader(new InputStreamReader(is));
            
            str = "";

            while ((str = br.readLine()) != null && str.length() != 0) {
                System.out.println(str);
            }
            
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OAuthException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
