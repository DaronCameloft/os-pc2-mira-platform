package com.u202416274.pc211848u202416274.crm.domain.model.valueobjects;

import java.util.UUID;

/**
 * Value object that represents a Mira customer identifier.
 *
 * @param value customer identifier value
 * @author Victor Paredes Maza
 */

public record MiraCustomerId(UUID value) {

    public MiraCustomerId {
        if (value == null) {
            throw new IllegalArgumentException("MiraCustomerId cannot be null");
        }
    }

    public MiraCustomerId(String value) {
        this(UUID.fromString(value));
    }

    public static MiraCustomerId generate() {
        return new MiraCustomerId(UUID.randomUUID());
    }
}
