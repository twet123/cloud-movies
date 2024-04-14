package com.example.cloudmovies;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableNameConfig {
    @Value("${movies.table.name}")
    private String moviesTableName;

    @Bean
    public PhysicalNamingStrategyStandardImpl physicalNamingStrategyStandard() {
        return new PhysicalNamingImpl();
    }
    class PhysicalNamingImpl extends PhysicalNamingStrategyStandardImpl {
        @Override
        public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
            if (name.getText().equals("Movie")) {
                return new Identifier(moviesTableName, name.isQuoted());
            }

            return super.toPhysicalTableName(name, context);
        }
    }
}

