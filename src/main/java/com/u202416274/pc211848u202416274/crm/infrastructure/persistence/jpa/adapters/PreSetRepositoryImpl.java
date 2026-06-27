package com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.adapters;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;
import com.u202416274.pc211848u202416274.crm.domain.repositories.PreSetRepository;
import com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.entities.PreSetEntity;
import com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.repositories.PreSetJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository adapter that implements the domain repository using Spring Data JPA.
 *
 * @author Victor Paredes Maza
 */
@Repository
public class PreSetRepositoryImpl implements PreSetRepository {

    private final PreSetJpaRepository preSetJpaRepository;

    /**
     * Creates a new repository adapter.
     *
     * @param preSetJpaRepository Spring Data JPA repository
     */
    public PreSetRepositoryImpl(PreSetJpaRepository preSetJpaRepository) {
        this.preSetJpaRepository = preSetJpaRepository;
    }

    /**
     * Saves a pre-set aggregate.
     *
     * @param preSet pre-set aggregate
     * @return saved pre-set aggregate
     */
    @Override
    public PreSet save(PreSet preSet) {
        var entity = new PreSetEntity(preSet);
        var savedEntity = preSetJpaRepository.save(entity);
        return savedEntity.toAggregate();
    }

    /**
     * Checks whether a pre-set already exists with the same product, customer and short name.
     *
     * @param productId product identifier
     * @param miraCustomerId Mira customer identifier
     * @param shortName pre-set short name
     * @return true if it exists; otherwise false
     */
    @Override
    public boolean existsByProductIdAndMiraCustomerIdAndShortName(
            ProductId productId,
            MiraCustomerId miraCustomerId,
            String shortName
    ) {
        return preSetJpaRepository.existsByProductIdAndMiraCustomerIdAndShortName(
                productId.value(),
                miraCustomerId.value(),
                shortName
        );
    }

    /**
     * Counts the pre-sets registered by a customer.
     *
     * @param miraCustomerId Mira customer identifier
     * @return number of pre-sets registered by the customer
     */
    @Override
    public long countByMiraCustomerId(MiraCustomerId miraCustomerId) {
        return preSetJpaRepository.countByMiraCustomerId(miraCustomerId.value());
    }
}