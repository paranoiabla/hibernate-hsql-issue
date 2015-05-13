package demo;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo.model.AbstractEntityModel;
import demo.model.CategoryModel;
import demo.model.CommerceCustomerModel;
import demo.model.CreditCardPaymentModel;
import demo.model.CustomerModel;
import demo.model.PaymentModel;
import demo.model.PrincipalModel;
import demo.model.ProductModel;
import demo.model.UserModel;

/**
 * @author Steve Ebersole
 */
public class SimpleTestWithoutAllThisUnnecessaryBs {
	protected ServiceRegistry serviceRegistry;
	protected MetadataImplementor metadata;

	@Before
	public void setUp() {
		serviceRegistry = new StandardServiceRegistryBuilder()
				.applySetting("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
				.applySetting("hibernate.connection.username", "sa")
				.applySetting("hibernate.connection.password", "")
				.applySetting("hibernate.connection.url", "jdbc:hsqldb:mem:solarapparel;sql.enforce_strict_size=true;hsqldb.tx=mvcc")
				.build();
		metadata = (MetadataImplementor) new MetadataSources( serviceRegistry )
				.addAnnotatedClass(AbstractEntityModel.class)
				.addAnnotatedClass(CategoryModel.class)
				.addAnnotatedClass(ProductModel.class)
				.addAnnotatedClass(PaymentModel.class)
				.addAnnotatedClass(CreditCardPaymentModel.class)
				.addAnnotatedClass(PrincipalModel.class)
				.addAnnotatedClass(UserModel.class)
				.addAnnotatedClass(CustomerModel.class)
				.addAnnotatedClass(CommerceCustomerModel.class)
				.buildMetadata();

		System.out.println( "********* Starting SchemaExport for START-UP *************************" );
		SchemaExport schemaExport = new SchemaExport( serviceRegistry, metadata );
		schemaExport.create( true, true );
		System.out.println( "********* Completed SchemaExport for START-UP *************************" );
	}

	@After
	public void tearDown() {
		System.out.println( "********* Starting SchemaExport (drop) for TEAR-DOWN *************************" );
		SchemaExport schemaExport = new SchemaExport( serviceRegistry, metadata );
		schemaExport.drop( true, true );
		System.out.println( "********* Completed SchemaExport (drop) for TEAR-DOWN *************************" );

		StandardServiceRegistryBuilder.destroy( serviceRegistry );
		serviceRegistry = null;
	}

	@Test
	public void testWithoutAllTheUnnecessaryBs() {
		System.out.println( "********* Starting SchemaUpdate for TEST *************************" );
		SchemaUpdate schemaUpdate = new SchemaUpdate( serviceRegistry, metadata );
		schemaUpdate.execute( true, true );
		System.out.println( "********* Completed SchemaUpdate for TEST *************************" );
	}
}
