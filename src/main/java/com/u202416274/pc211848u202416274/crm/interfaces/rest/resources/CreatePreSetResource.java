package com.u202416274.pc211848u202416274.crm.interfaces.rest.resources;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Resource used to create a new pre-set.
 *
 * @param shortName pre-set short name
 * @param preferredTemperature preferred temperature in Celsius degrees
 * @param preferredFlow preferred water flow in liters per minute
 * @param preferredDuration preferred duration in seconds
 * @author Victor Paredes Maza
 */
public record CreatePreSetResource(
        @NotBlank(message = "Short name is required.")
        @Size(max = 60, message = "Short name must have up to 60 characters.")
        String shortName,

        @NotNull(message = "Preferred temperature is required.")
        @DecimalMin(value = "1.0", message = "Preferred temperature must be between 1 and 65 Celsius degrees.")
        @DecimalMax(value = "65.0", message = "Preferred temperature must be between 1 and 65 Celsius degrees.")
        Float preferredTemperature,

        @NotNull(message = "Preferred flow is required.")
        @DecimalMin(value = "4.0", message = "Preferred flow must be between 4 and 16 liters per minute.")
        @DecimalMax(value = "16.0", message = "Preferred flow must be between 4 and 16 liters per minute.")
        Float preferredFlow,

        @NotNull(message = "Preferred duration is required.")
        @Min(value = 1, message = "Preferred duration must be between 1 and 240 seconds.")
        @Max(value = 240, message = "Preferred duration must be between 1 and 240 seconds.")
        Integer preferredDuration
) {
}