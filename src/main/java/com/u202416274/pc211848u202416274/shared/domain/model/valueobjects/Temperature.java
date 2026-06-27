package com.u202416274.pc211848u202416274.shared.domain.model.valueobjects;

/**
 * Value object that represents a preferred temperature in Celsius degrees.
 *
 * @param value preferred temperature value
 * @author Victor Paredes Maza
 */

public record Temperature(Float value) {

    public Temperature {
        if (value == null) {
            throw new IllegalArgumentException("Temperature value must not be null");
        }

        if (Float.isNaN(value) || value < 1.0f || value > 65.0f) {
            throw new IllegalArgumentException("Temperature value must be between 0.0 and 65.0");
        }

    }

}
