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

	@Test
	public void testCreate() {
		DataSet dataSet = new DataSet();
		try {
			dataSet.create();
		} catch (Exception e) {
			// Complain
			e.printStackTrace();
			fail();
		}
		
		fail("Not yet implemented");
	}

}
