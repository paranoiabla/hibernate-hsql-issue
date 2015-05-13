package demo;

import demo.model.AbstractEntityModel;
import demo.model.CategoryModel;
import demo.model.CommerceCustomerModel;
import demo.model.CreditCardPaymentModel;
import demo.model.CustomerModel;
import demo.model.PaymentModel;
import demo.model.PrincipalModel;
import demo.model.ProductModel;
import demo.model.UserModel;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.hbm2ddl.Target;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Steve Ebersole
 */
public class SimpleTestWithoutAllThisUnnecessaryBs {
    protected ServiceRegistry serviceRegistry;

    protected MetadataImplementor metadata;

    @Before
    public void setUp() {
        metadata = getHibernateConfiguration();

        System.out.println("********* Starting SchemaExport for START-UP *************************");
        SchemaExport schemaExport = new SchemaExport(serviceRegistry, metadata);
        schemaExport.create(true, true);
        System.out.println("********* Completed SchemaExport for START-UP *************************");
    }

    @After
    public void tearDown() {
        System.out.println("********* Starting SchemaExport (drop) for TEAR-DOWN *************************");
        SchemaExport schemaExport = new SchemaExport(serviceRegistry, metadata);
        schemaExport.drop(true, true);
        System.out.println("********* Completed SchemaExport (drop) for TEAR-DOWN *************************");

        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        serviceRegistry = null;
    }

    @Test
    public void test() {

        final SchemaExport export = new SchemaExport(getHibernateConfiguration());
        export.setDelimiter(";");
        export.setFormat(true);
        export.setOutputFile("schema.sql");
        export.execute(Target.EXPORT, SchemaExport.Type.BOTH);
    }

    @Test
    public void testWithoutAllTheUnnecessaryBs() {
        System.out.println("********* Starting SchemaUpdate for TEST *************************");
        SchemaUpdate schemaUpdate = new SchemaUpdate(serviceRegistry, metadata);
        schemaUpdate.execute(true, true);
        System.out.println("********* Completed SchemaUpdate for TEST *************************");
    }

    public MetadataImplementor getHibernateConfiguration() {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        registryBuilder.applySetting("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        registryBuilder.applySetting("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        registryBuilder.applySetting("hibernate.connection.username", "sa");
        registryBuilder.applySetting("hibernate.connection.password", "");
        registryBuilder.applySetting("hibernate.connection.url", "jdbc:hsqldb:mem:solarapparel;sql.enforce_strict_size=true;hsqldb.tx=mvcc");

        serviceRegistry = registryBuilder.build();
        MetadataSources sources = new MetadataSources(serviceRegistry);

        sources.addAnnotatedClass(AbstractEntityModel.class);
        sources.addAnnotatedClass(CategoryModel.class);
        sources.addAnnotatedClass(ProductModel.class);
        sources.addAnnotatedClass(PaymentModel.class);
        sources.addAnnotatedClass(CreditCardPaymentModel.class);
        sources.addAnnotatedClass(PrincipalModel.class);
        sources.addAnnotatedClass(UserModel.class);
        sources.addAnnotatedClass(CustomerModel.class);
        sources.addAnnotatedClass(CommerceCustomerModel.class);

        return (MetadataImplementor) sources.buildMetadata();
    }
}
