package ex.config;

import ex.db2.DB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = DB2.class,
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager"
)
public class PersistenceDB2Configuration {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.db2-datasource")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(db2DataSource());
        emf.setPackagesToScan(DB2.class.getPackage().getName());
        emf.setPersistenceUnitName("db2PersistenceUnit"); // optional

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        emf.setJpaPropertyMap(properties);

        return emf;
    }

    // TODO 반드시 @Transactional(transactionNamager = "db2TransactionManager") 로 지정해 주어야 함
    // TODO transactionManager를 지정하지 않으면 @Primary 로 지정된 db1TransactionManager가 적용됨
    @Bean
    public PlatformTransactionManager db2TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(db2EntityManagerFactory().getObject());
        return transactionManager;
    }
}
