package com.u202416274.pc211848u202416274.crm.domain.repositories;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;


/**
 * Repository contract for pre-set aggregates.
 *
 * @author Victor Paredes Maza
 */

public interface PreSetRepository {

    PreSet save(PreSet preSet);

    boolean existsByProductIdAndMiraCustomerIdAndShortName(
            ProductId productId,
            MiraCustomerId miraCustomerId,
            String shortName
    );

    long countByMiraCustomerId(MiraCustomerId miraCustomerId);

}
