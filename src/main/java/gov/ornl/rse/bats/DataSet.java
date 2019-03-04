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
package gov.ornl.rse.bats;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;

/**
 * This class represents a set of data describing a topic or item of interest.
 * In BATS, data sets are natively distributed across one or more servers. The
 * initial hostname and port of an Apache Jena Fuseki server must be provided in
 * order to pull the root RDF model that describes this data set, as well as an
 * associated metadata models.
 * 
 * Data sets are organized in the Apache Jena style, with each set containing
 * one or more subsets called "Models." This class largely wraps those
 * operations into a more convenient interface that masks Jena's HTTP-based
 * transfer routines and fits the intended use better. However, advanced users
 * may retrieve the Jena dataset by calling getJenaDataset().
 * 
 * Data sets may be "pulled" and "pushed" to synchronize with the remote server.
 * The push() and pull() operations are not presently safe in that they do not
 * merge data coming from or going to the server before executing their tasks.
 * This means that they may overwrite data from either source if used
 * inadvertently.
 * 
 * @author Jay Jay Billings
 *
 */
public class DataSet {

	public static final String DEFAULT_NAME = "unnamed-dataset";

	/**
	 * The default host which holds the dataset.
	 */
	private String host = "http://localhost";

	/**
	 * The default port of the host which holds the dataset.
	 */
	private int port = 3030;

	/**
	 * The default name for a dataset.
	 */
	private String name = DEFAULT_NAME;

	/**
	 * This operation sets the name of the data set. The name of the data set is the
	 * name recognized by the host, not the local machine. It must be set prior to
	 * calling create() or load(), but calling it after those operations does not
	 * change it.
	 * 
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * This operation returns the name of the data set.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This operation returns the host of the data set.
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * This operation sets the host at which the data set should be created or from
	 * which it should be loaded.
	 * 
	 * @param host the URI of the remote Fuseki host that hosts the data set
	 */
	public void setHost(final String host) {
		this.host = host;
	}

	/**
	 * This operation returns the port of the host of this data set.
	 * 
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * This operation sets the expected port of the host of this data set.
	 * 
	 * @param port
	 */
	public void setPort(final int port) {
		this.port = port;
	}

	/**
	 * This operation creates a dataset with the given name. If no name is provided
	 * to setName(), the default name with a UUID appended to it will be used such
	 * that the form of the name will be "unnamed-dataset_<UUID>."
	 * 
	 * @throws Exception this exception is thrown if the data set cannot be created
	 *                   for any reason.
	 */
	public void create() throws Exception {
	}

	/**
	 * This operation loads the data from the remote host. It requires that the name
	 * is provided through the setName() operation.
	 * 
	 * @throws Exception this exception is thrown if the data set cannot be loaded
	 *                   for any reason.
	 */
	public void load() throws Exception {

	}

	/**
	 * This operation attempts to pull the latest changes to the data set from the
	 * remote Fuseki server. WARNING: This is not a safe operation and calling it
	 * may corrupt data that has not been pushed to the server.
	 * 
	 * @throws Exception this exception is thrown if the data set cannot be loaded
	 *                   for any reason.
	 */
	public void pull() throws Exception {

	}

	/**
	 * This operation attempts to push the latest changes to the data set to the
	 * remote Fuseki server. WARNING: This is not a safe operation and calling it
	 * may corrupt data that has been pushed to the server.
	 * 
	 * @throws Exception this exception is thrown if the data set cannot be loaded
	 *                   for any reason.
	 */
	public void push() throws Exception {

	}

	/**
	 * This operation returns the root model in the data set, which is called the
	 * default graph in the Jena jargon. It is referred to as the root model here to
	 * denote that it is the root model in a hierarchy of models describing the same
	 * set.
	 * 
	 * @return the root model
	 */
	public Model getRootModel() {
		Model model = null;
		return model;
	}

	/**
	 * This operation returns the model with the given name if it exists in the data
	 * set.
	 * 
	 * @param modelName the name of the model that should be retrieved from the data
	 *                  set. Note that like Jena, calling with an argument of
	 *                  "default" or "null" will return the default graph/model.
	 * @return the model
	 */
	public Model getModel(final String modelName) {
		Model model = null;
		return model;
	}

	/**
	 * This operation returns the raw Jena data set pulled from Fuseki. This could
	 * be a long-running operation depending on the size of the remote data. This
	 * operation is intended purely as a convenience to advanced users who want to
	 * manipulate the data set directly.
	 * 
	 * @return the raw Jena data set
	 */
	public Dataset getJenaDataset() {
		Dataset set = null;
		return set;
	}

}
