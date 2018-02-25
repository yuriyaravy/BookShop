import org.hibernate.SessionFactory;

import com.senla.bookshop.hibernate.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

}
