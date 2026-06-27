package com.u202416274.pc211848u202416274.crm.domain.model.commands;


import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Duration;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Temperature;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.WaterFlow;


/**
 * Command used to create a new pre-set.
 *
 * @param productId product identifier
 * @param miraCustomerId Mira customer identifier
 * @param shortName pre-set short name
 * @param preferredTemperature preferred temperature
 * @param preferredFlow preferred water flow
 * @param preferredDuration preferred duration
 * @author Victor Paredes Maza
 */

public record CreatePreSetCommand(
        ProductId productId,
        MiraCustomerId miraCustomerId,
        String shortName,
        Temperature preferredTemperature,
        Duration preferredDuration,
        WaterFlow preferredFlow
    ) {

    public CreatePreSetCommand {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        if (miraCustomerId == null) {
            throw new IllegalArgumentException("miraCustomerId cannot be null");
        }
        if (preferredTemperature == null) {
            throw new IllegalArgumentException("preferredTemperature cannot be null");
        }
        if (preferredDuration == null) {
            throw new IllegalArgumentException("preferredDuration cannot be null");
        }
        if (preferredFlow == null) {
            throw new IllegalArgumentException("preferredFlow cannot be null");
        }

    }
}
