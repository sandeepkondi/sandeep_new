package com.beyontec.mol.config.security;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:route-acl.properties", name = "route-acl.props")
public class RouteAclConfig {

    @Autowired
    private Environment env;

    public Properties getProperties() {
        AbstractEnvironment ae = (AbstractEnvironment) env;
        org.springframework.core.env.PropertySource<?> source = ae.getPropertySources().get("route-acl.props");
        return (Properties) source.getSource();
    }
}
