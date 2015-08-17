package com.atsamour.habitatweave.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.common.base.Optional;


public class HibernateUtil {

	private static Optional<SessionFactory> sessionFactory = Optional.absent();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml

			Configuration cfg = new Configuration();
			cfg.configure();


		   	String DB_USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		 	String DB_PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		 	String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		  	String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");

			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + DB_HOST + ":" + DB_PORT +"/awesomedb");
			cfg.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			cfg.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
			SessionFactory sessionFactory = cfg.buildSessionFactory();

			return sessionFactory;
			//return new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory.isPresent()) {
			return sessionFactory.get();
		}
		sessionFactory = Optional.fromNullable(buildSessionFactory());
		return sessionFactory.get();
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
