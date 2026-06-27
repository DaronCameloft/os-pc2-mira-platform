package com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.repositories;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.entities.PreSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreSetJpaRepository extends JpaRepository<PreSetEntity,Long> {

    boolean existsByProductIdAndMiraCustomerIdAndShortName(
            UUID productId,
            UUID miraCustomerId,
            String shortName
    );

    long countByMiraCustomerId(UUID miraCustomerId);
}
