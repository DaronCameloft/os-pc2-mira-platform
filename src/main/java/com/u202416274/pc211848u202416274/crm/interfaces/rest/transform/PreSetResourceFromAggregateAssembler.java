package com.u202416274.pc211848u202416274.crm.interfaces.rest.transform;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.resources.PreSetResource;

/**
 * Assembler used to convert a pre-set aggregate into a resource.
 *
 * @author Victor Paredes Maza
 */
public class PreSetResourceFromAggregateAssembler {

    /**
     * Converts a pre-set aggregate into a response resource.
     *
     * @param preSet pre-set aggregate
     * @return pre-set resource
     */
    public static PreSetResource toResourceFromAggregate(PreSet preSet) {
        return new PreSetResource(
                preSet.getId(),
                preSet.getProductId().value(),
                preSet.getMiraCustomerId().value(),
                preSet.getShortName(),
                preSet.getPreferredTemperature().value(),
                preSet.getPreferredFlow().value(),
                preSet.getPreferredDuration().value()
        );
    }
}