package com.imooc.config.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class DataSourceConfiguration {

    private final static String MASTER_DATASOURCE_KEY = "masterDataSource";

    private final static String SLAVE_DATASOURCE_KEY = "slaveDataSource";

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Primary
    @Bean(value = MASTER_DATASOURCE_KEY)
    @Qualifier(MASTER_DATASOURCE_KEY)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(value = SLAVE_DATASOURCE_KEY)
    @Qualifier(SLAVE_DATASOURCE_KEY)
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

}
