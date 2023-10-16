package com.company.loanapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JDBCTemplateConfig {

    @Bean("jdbc")
    @Autowired
    public NamedParameterJdbcTemplate getJDBCTemplate(@Qualifier("loanDS") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
