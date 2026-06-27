package com.u202416274.pc211848u202416274.shared.infrastructure.persistence.jpa.configuration.strategy;

import io.github.encryptorcode.pluralize.Pluralize;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategySnakeCaseImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * Physical naming strategy that converts database object names to snake case
 * and pluralizes table names.
 *
 * @author Victor Paredes Maza
 */
public class SnakeCaseWithPluralizedTablePhysicalNamingStrategy extends PhysicalNamingStrategySnakeCaseImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        Identifier identifier = super.toPhysicalTableName(name, jdbcEnvironment);

        if (identifier == null) {
            return null;
        }

        String tableName = identifier.getText();
        String pluralizedTableName = Pluralize.plural(tableName);

        return Identifier.toIdentifier(pluralizedTableName, identifier.isQuoted());
    }
}