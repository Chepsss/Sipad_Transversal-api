package it.almaviva.difesa.sipad.shared.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "aadbaEntityManagerFactory",
        transactionManagerRef = "aadbaTransactionManager",
        basePackages = {"it.almaviva.difesa.sipad.aadba.*.repository"}
)
public class AadbaDbConfig {

    @Primary
    @Bean(name = "aadbaDataSourceProperties")
    @ConfigurationProperties("spring.datasource.aadba")
    public DataSourceProperties aadbaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "aadbaDataSource")
    @ConfigurationProperties("spring.datasource.aadba.configuration")
    public DataSource aadbaDataSource(@Qualifier("aadbaDataSourceProperties") DataSourceProperties aadbaDataSourceProperties) {
        return aadbaDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "aadbaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean aadbaEntityManagerFactory(
            @Qualifier("aadbaDataSource") DataSource aadbaDataSource,
            EntityManagerFactoryBuilder aadbaEntityManagerFactoryBuilder) {

        Map<String, String> aadbaJpaProperties = new HashMap<>();
        aadbaJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");

        return aadbaEntityManagerFactoryBuilder
                .dataSource(aadbaDataSource)
                .packages("it.almaviva.difesa.sipad.aadba.*.entity")
                .persistenceUnit("aadbaDataSource")
                .properties(aadbaJpaProperties)
                .build();
    }

    @Primary
    @Bean(name = "aadbaTransactionManager")
    public PlatformTransactionManager aadbaTransactionManager(
            @Qualifier("aadbaEntityManagerFactory") EntityManagerFactory aadbaEntityManagerFactory) {

        return new JpaTransactionManager(aadbaEntityManagerFactory);
    }
}
