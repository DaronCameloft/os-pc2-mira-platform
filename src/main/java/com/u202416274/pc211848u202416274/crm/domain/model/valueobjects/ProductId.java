package com.u202416274.pc211848u202416274.crm.domain.model.valueobjects;

import java.util.UUID;

/**
 * Value object that represents a product identifier.
 *
 * @param value product identifier value
 * @author Victor Paredes Maza
 */

public record ProductId(UUID value) {

    public ProductId {

        if (value == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }

    }

    public ProductId(String value) {

        this(UUID.fromString(value));
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }



}
