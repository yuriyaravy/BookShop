package com.senla.bookshop.utils.hibernate;

import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getInstance().getSessionFactory();
	}

}
