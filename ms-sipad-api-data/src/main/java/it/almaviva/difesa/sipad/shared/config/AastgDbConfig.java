package it.almaviva.difesa.sipad.shared.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "aastgEntityManagerFactory",
        transactionManagerRef = "aastgTransactionManager",
        basePackages = {"it.almaviva.difesa.sipad.aastg.*.repository"}
)
public class AastgDbConfig {

    @Bean(name = "aastgDataSourceProperties")
    @ConfigurationProperties("spring.datasource.aastg")
    public DataSourceProperties aastgDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "aastgDataSource")
    @ConfigurationProperties("spring.datasource.aastg.configuration")
    public DataSource aastgDataSource(@Qualifier("aastgDataSourceProperties") DataSourceProperties aastgDataSourceProperties) {
        return aastgDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "aastgEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean aastgEntityManagerFactory(
            EntityManagerFactoryBuilder aastgEntityManagerFactoryBuilder, @Qualifier("aastgDataSource") DataSource aastgDataSource) {

        Map<String, String> aastgJpaProperties = new HashMap<>();
        aastgJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");

        return aastgEntityManagerFactoryBuilder
                .dataSource(aastgDataSource)
                .packages("it.almaviva.difesa.sipad.aastg.*.entity")
                .persistenceUnit("aastgDataSource")
                .properties(aastgJpaProperties)
                .build();
    }

    @Bean(name = "aastgTransactionManager")
    public PlatformTransactionManager aastgTransactionManager(
            @Qualifier("aastgEntityManagerFactory") EntityManagerFactory aastgEntityManagerFactory) {

        return new JpaTransactionManager(aastgEntityManagerFactory);
    }
}
