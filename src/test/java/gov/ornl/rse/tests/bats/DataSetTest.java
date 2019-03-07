/******************************************************************************
 * Copyright (c) 2019- UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the 3-Clause BSD License, which is available at
 * https://github.com/jayjaybillings/bats/blob/master/LICENSE.
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Jay Jay Billings
 *****************************************************************************/
package gov.ornl.rse.tests.bats;

import static org.junit.Assert.*;

import java.util.UUID;

import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import gov.ornl.rse.bats.DataSet;

/**
 * This is a simple test of the BATS Dataset class. It requires that the Fuseki
 * is running locally on port 3030. The simplest way to do this is to execute
 * the docker-compose.yml file that is in the directory root BATS directory.
 * 
 * @author Jay Jay Billings
 *
 */
public class DataSetTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * This is a utility operation for checking if data sets correctly created
	 * themselves on the remote server.
	 * 
	 * @param dataSet the dataset to check
	 */
	private void checkDataSetCreationOnServer(final DataSet dataSet) {
		// Create the dataset
		try {
			dataSet.create();
		} catch (Exception e) {
			// Complain
			e.printStackTrace();
			fail();
		}

		// Grab the dataset directy from the server
		String name = dataSet.getName();
		String fusekiURI = dataSet.getHost() + ":" + dataSet.getPort() + "/" + name;
		String fusekiGetURI = fusekiURI + "/get";
		RDFConnectionRemoteBuilder getConnBuilder = RDFConnectionFuseki.create().destination(fusekiGetURI);
		try (RDFConnectionFuseki getConn = (RDFConnectionFuseki) getConnBuilder.build()) {
			System.out.println("Pulling " + dataSet.getName());
			getConn.begin(ReadWrite.READ);
			Model model = getConn.fetch(null);
			getConn.commit();

			// The only real check that exists is whether or not the exception is caught.

		} catch (Exception e) {
			e.printStackTrace();
			fail("Data set not found!");
		}
	}

	/**
	 * This operation checks data set creation.
	 */
	@Test
	public void testCreate() {

		// Create a default, empty data set with the default name
		DataSet dataSet = new DataSet();
		// Check the data set creation
		checkDataSetCreationOnServer(dataSet);

		// Configure the name and some other details of a dataset and test that
		// functionality
		DataSet dataSet2 = new DataSet();
		String uuidString = UUID.randomUUID().toString();
		String name = "dataSetTest" + "." + uuidString;
		dataSet2.setName(name);
		dataSet2.setHost("http://127.0.0.1");
		dataSet2.setPort(5);
		// Make sure these work OK
		assertEquals(name, dataSet2.getName());
		assertEquals("http://127.0.0.1", dataSet2.getHost());
		// Just check that the port is set properly since actually testing a port switch
		// is too onerous
		assertEquals(5, dataSet2.getPort());
		// Reset the port to avoid an error since it has been proven that it could be
		// stored correctly.
		dataSet2.setPort(3030);

		// Check creating the dataset on the server with its custom args
		checkDataSetCreationOnServer(dataSet2);

		return;
	}

	/**
	 * This operation tries to pull some models from the data set
	 */
	@Test
	public void testModels() {
		// Create a new data set
		DataSet dataSet = new DataSet();
		checkDataSetCreationOnServer(dataSet);
		Model model = ModelFactory.createDefaultModel();
		dataSet.updateModel("testModel", model);
		
		// Check the root/default model
		Model rootModel = dataSet.getRootModel();
		assertNotNull(rootModel);
		
		// Check the named model
		Model namedModel = dataSet.getModel("testModel");
		assertNotNull(namedModel);
	}
	
	/**
	 * This operation checks loading a pre-existing data set.
	 */
	@Test
	public void testLoad() {

		// Create a new data set
		DataSet referenceDataSet = new DataSet();
		checkDataSetCreationOnServer(referenceDataSet);
		
		// Put something in it
		
		// Upload it to the server
		
		// Load the contenst from the server into a new, empty data set
		
		// Check something!
		
		fail("Not yet implemented.");
		
		return;
	}

}
