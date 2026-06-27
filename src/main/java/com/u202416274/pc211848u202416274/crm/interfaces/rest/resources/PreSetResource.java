package com.u202416274.pc211848u202416274.crm.interfaces.rest.resources;

import java.util.UUID;

/**
 * Resource returned after creating a pre-set.
 *
 * @param id pre-set identifier
 * @param productId product identifier
 * @param miraCustomerId Mira customer identifier
 * @param shortName pre-set short name
 * @param preferredTemperature preferred temperature
 * @param preferredFlow preferred water flow
 * @param preferredDuration preferred duration
 * @author Victor Paredes Maza
 */
public record PreSetResource(
        Long id,
        UUID productId,
        UUID miraCustomerId,
        String shortName,
        Float preferredTemperature,
        Float preferredFlow,
        Integer preferredDuration
) {
}