package com.senla.bookshop.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static HibernateUtil instance;
	private static SessionFactory sessionFactory;
	
	private HibernateUtil(){
		
	}
	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	static{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.openSession();
		
	}
	
	public void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
