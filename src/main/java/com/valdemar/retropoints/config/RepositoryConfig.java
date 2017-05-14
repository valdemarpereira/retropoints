package com.valdemar.retropoints.config;

import com.valdemar.retropoints.domain.Retropoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    //READ: http://stackoverflow.com/questions/24839760/spring-boot-responsebody-doesnt-serialize-entity-id
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config) {
        config.exposeIdsFor(Retropoint.class);
    }

}
