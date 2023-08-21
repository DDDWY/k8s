package com.imooc.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("determineCurrentLookupKey:  " + DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }

}
