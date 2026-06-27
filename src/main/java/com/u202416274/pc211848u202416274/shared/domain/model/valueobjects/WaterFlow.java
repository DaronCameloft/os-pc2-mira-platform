package com.u202416274.pc211848u202416274.shared.domain.model.valueobjects;

/**
 * Value object that represents a preferred water flow in liters per minute.
 *
 * @param value preferred water flow value
 * @author Victor Paredes Maza
 */

public record WaterFlow(Float value) {

    public WaterFlow {
        if (value == null) {
            throw new IllegalArgumentException("WaterFlow value must not be null");
        }

        if (Float.isNaN(value) || value < 4.0f || value > 16.0f ) {
            throw new IllegalArgumentException("WaterFlow value must be between 4.0 and 16.0");
        }
    }

}
