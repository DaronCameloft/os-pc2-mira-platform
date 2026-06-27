package com.u202416274.pc211848u202416274.shared.domain.model.valueobjects;


/**
 * Value object that represents a preferred shower duration in seconds.
 *
 * @param value preferred duration value
 * @author Victor Paredes Maza
 */

public record Duration(Integer value) {

    public Duration {
        if (value == null) {
            throw new IllegalArgumentException("Duration value must not be null");
        }

        if (value < 1 || value > 240) {
            throw new IllegalArgumentException("Duration value must be between 1 and 240");
        }
        }
    }
