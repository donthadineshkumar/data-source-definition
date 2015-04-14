package com.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Test;

import com.service.BlogService;

public class TestDataSource {

	@Test
	public void testDataSourceDefintion() {

		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));

		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {

			Context ctx = ec.getContext();

			// Check JNDI dependencies (Datasource)
			try {
				assertNotNull(ctx.lookup("java:global/classes/DataSourceDefinitionConfig"));
				assertNotNull(ctx.lookup("java:global/jdbc/MyOwnDatasource"));
				BlogService bs = (BlogService) ctx.lookup("java:global/classes/BlogService");
				Assert.assertTrue(bs.saveBlog());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
