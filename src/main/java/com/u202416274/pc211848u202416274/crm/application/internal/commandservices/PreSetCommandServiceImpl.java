package com.u202416274.pc211848u202416274.crm.application.internal.commandservices;

import com.u202416274.pc211848u202416274.crm.application.commandservices.PreSetCommandService;
import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.domain.model.commands.CreatePreSetCommand;
import com.u202416274.pc211848u202416274.crm.domain.repositories.PreSetRepository;
import com.u202416274.pc211848u202416274.shared.domain.model.exceptions.BusinessRuleValidationException;

public class PreSetCommandServiceImpl implements PreSetCommandService {

    private final PreSetRepository preSetRepository;

    public PreSetCommandServiceImpl(PreSetRepository preSetRepository) {
        this.preSetRepository = preSetRepository;
    }

    @Override
    public PreSet handle(CreatePreSetCommand command) {
        var preSet = new PreSet(command);

        if (preSetRepository.countByMiraCustomerId(preSet.getMiraCustomerId()) > 3) {
            throw new BusinessRuleValidationException("Cannot create more than 3 PreSets for the same MiraCustomerId");
        }

        if (preSetRepository.existsByProductIdAndMiraCustomerIdAndShortName(
                preSet.getProductId(),
                preSet.getMiraCustomerId(),
                preSet.getShortName()
        )) {
            throw new BusinessRuleValidationException("A PreSet with the same ProductId, MiraCustomerId and ShortName already exists");
        }

        return preSetRepository.save(preSet);

    }
}
