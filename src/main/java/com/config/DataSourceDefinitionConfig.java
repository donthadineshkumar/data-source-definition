package com.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
@DataSourceDefinition(
		name="java:global/jdbc/MyOwnDatasource",
		className="com.mysql.jdbc.Driver",
		url="jdbc:mysql://localhost:3306/mydatabase",
		databaseName="mydatabase",
		user="root",
		password="root")
public class DataSourceDefinitionConfig {
}
