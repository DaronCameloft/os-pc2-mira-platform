package com.u202416274.pc211848u202416274.crm.application.commandservices;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.domain.model.commands.CreatePreSetCommand;


/**
 * Application service contract for pre-set commands.
 *
 * @author Victor Paredes Maza
 */

public interface PreSetCommandService {
    PreSet handle(CreatePreSetCommand command);
}
