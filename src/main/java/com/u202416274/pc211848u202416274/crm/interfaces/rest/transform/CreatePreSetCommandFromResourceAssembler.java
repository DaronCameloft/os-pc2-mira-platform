package com.u202416274.pc211848u202416274.crm.interfaces.rest.transform;

import com.u202416274.pc211848u202416274.crm.domain.model.commands.CreatePreSetCommand;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.resources.CreatePreSetResource;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Duration;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Temperature;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.WaterFlow;

/**
 * Assembler used to convert a create pre-set resource into a command.
 *
 * @author Victor Paredes Maza
 */
public class CreatePreSetCommandFromResourceAssembler {

    /**
     * Converts path variables and request body into a create pre-set command.
     *
     * @param customerId customer identifier from path
     * @param productId product identifier from path
     * @param resource request body resource
     * @return create pre-set command
     */
    public static CreatePreSetCommand toCommandFromResource(
            String customerId,
            String productId,
            CreatePreSetResource resource
    ) {
        return new CreatePreSetCommand(
                new ProductId(productId),
                new MiraCustomerId(customerId),
                resource.shortName(),
                new Temperature(resource.preferredTemperature()),
                new Duration(resource.preferredDuration()),
                new WaterFlow(resource.preferredFlow())
        );
    }
}