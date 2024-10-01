package com.malunjkar.security.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcAuthProvider {

    private final DataSource dataSource;

    public JdbcAuthProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public AuthenticationProvider jdbcAuthenticationProvider() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(jdbcDao);
        return provider;
    }
}
