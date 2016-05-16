/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package hibernate5.demo.event.fetchtype;

import hibernate5.demo.event.CustomPhysicalNamingStrategy.Event2;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 *
 * @author Steve Ebersole
 */
public class FetchTypeTest extends TestCase {
	private EntityManagerFactory entityManagerFactory;

	@Override
	protected void setUp() throws Exception {
		// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
		// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
		entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate5.demo.event.jpa" );
	}

	@Override
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	public void testBasicUsage() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Book book = new Book(1,"计算机组成原理");
		User u = new User(5,"王明",book);
		entityManager.persist(u);
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class,5);

		/**
		 * 打印该语句之前,hibernate会查询数据库读取懒加载的字段
		 */
		System.out.println(user.getBook().getName());
		assertEquals(user.getName(),"王明");
	}
}
