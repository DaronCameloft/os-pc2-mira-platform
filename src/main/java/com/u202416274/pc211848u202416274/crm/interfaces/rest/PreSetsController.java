package com.u202416274.pc211848u202416274.crm.interfaces.rest;

import com.u202416274.pc211848u202416274.crm.application.commandservices.PreSetCommandService;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.resources.CreatePreSetResource;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.resources.PreSetResource;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.transform.CreatePreSetCommandFromResourceAssembler;
import com.u202416274.pc211848u202416274.crm.interfaces.rest.transform.PreSetResourceFromAggregateAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for pre-set endpoints.
 *
 * @author Victor Paredes Maza
 */
@RestController
@RequestMapping("/api/v1/customers/{customerId}/products/{productId}/pre-sets")
@Tag(name = "Pre-Sets", description = "Pre-set management endpoints")
public class PreSetsController {

    private final PreSetCommandService preSetCommandService;

    /**
     * Creates a new pre-sets controller.
     *
     * @param preSetCommandService command service for pre-set operations
     */
    public PreSetsController(PreSetCommandService preSetCommandService) {
        this.preSetCommandService = preSetCommandService;
    }

    /**
     * Creates a new pre-set for a customer and product.
     *
     * @param customerId customer identifier
     * @param productId product identifier
     * @param resource create pre-set request body
     * @return created pre-set resource
     */
    @PostMapping
    @Operation(summary = "Create a pre-set", description = "Creates a new pre-set for a customer and product.")
    public ResponseEntity<PreSetResource> createPreSet(
            @PathVariable String customerId,
            @PathVariable String productId,
            @Valid @RequestBody CreatePreSetResource resource
    ) {
        var command = CreatePreSetCommandFromResourceAssembler.toCommandFromResource(
                customerId,
                productId,
                resource
        );

        var preSet = preSetCommandService.handle(command);
        var preSetResource = PreSetResourceFromAggregateAssembler.toResourceFromAggregate(preSet);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(preSetResource);
    }
}