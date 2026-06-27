package com.u202416274.pc211848u202416274.crm.domain.model.aggregates;

import com.u202416274.pc211848u202416274.crm.domain.model.commands.CreatePreSetCommand;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;
import com.u202416274.pc211848u202416274.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Duration;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Temperature;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.WaterFlow;
import lombok.Getter;

/**
 * Aggregate root that represents a Mira shower pre-set.
 *
 * @author Victor Paredes Maza
 */

@Getter
public class PreSet extends AbstractDomainAggregateRoot<PreSet> {

    private final Long id;
    private final ProductId productId;
    private final MiraCustomerId miraCustomerId;
    private final String shortName;
    private final Temperature preferredTemperature;
    private final WaterFlow preferredFlow;
    private final Duration preferredDuration;

    /**
     * Creates a new pre-set from a command.
     *
     * @param command command containing pre-set creation data
     */

    public PreSet(CreatePreSetCommand command) {
        this(
                null,
                command.productId(),
                command.miraCustomerId(),
                command.shortName(),
                command.preferredTemperature(),
                command.preferredFlow(),
                command.preferredDuration()
        );
    }


    /**
     * Creates a pre-set aggregate.
     *
     * @param id pre-set identifier
     * @param productId product identifier
     * @param miraCustomerId Mira customer identifier
     * @param shortName pre-set short name
     * @param preferredTemperature preferred temperature
     * @param preferredFlow preferred water flow
     * @param preferredDuration preferred duration
     */

    public PreSet(
            Long id,
            ProductId productId,
            MiraCustomerId miraCustomerId,
            String shortName,
            Temperature preferredTemperature,
            WaterFlow preferredFlow,
            Duration preferredDuration
    ) {
        this.id = id;
        this.productId = productId;
        this.miraCustomerId = miraCustomerId;
        this.shortName = shortName;
        this.preferredTemperature = preferredTemperature;
        this.preferredFlow = preferredFlow;
        this.preferredDuration = preferredDuration;
    }

    private String validateShortName(String shortName){
        if (shortName == null || shortName.isEmpty()){
            return "Invalid short name";
        }

        if (shortName.length() > 60){
            return "Short name too long";
        }

        return shortName.trim();
    }


}
