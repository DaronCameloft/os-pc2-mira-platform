package com.u202416274.pc211848u202416274.crm.infrastructure.persistence.jpa.entities;

import com.u202416274.pc211848u202416274.crm.domain.model.aggregates.PreSet;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.MiraCustomerId;
import com.u202416274.pc211848u202416274.crm.domain.model.valueobjects.ProductId;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Duration;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.Temperature;
import com.u202416274.pc211848u202416274.shared.domain.model.valueobjects.WaterFlow;
import com.u202416274.pc211848u202416274.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pre_set")
public class PreSetEntity extends AuditableAbstractPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "mira_customer_id", nullable = false)
    private UUID miraCustomerId;

    @Column(name = "short_name", nullable = false, length = 60)
    private String shortName;

    @Column(name = "preferred_temperature", nullable = false)
    private Float preferredTemperature;

    @Column(name = "preferred_flow", nullable = false)
    private Float preferredFlow;

    @Column(name = "preferred_duration", nullable = false)
    private Integer preferredDuration;


    public PreSetEntity(PreSet preSet) {
        this.id = preSet.getId();
        this.productId = preSet.getProductId().value();
        this.miraCustomerId = preSet.getMiraCustomerId().value();
        this.shortName = preSet.getShortName();
        this.preferredTemperature = preSet.getPreferredTemperature().value();
        this.preferredFlow = preSet.getPreferredFlow().value();
        this.preferredDuration = preSet.getPreferredDuration().value();
    }

    public PreSet toAggregate() {
        return new PreSet(
                this.id,
                new ProductId(this.productId),
                new MiraCustomerId(this.miraCustomerId),
                this.shortName,
                new Temperature(this.preferredTemperature),
                new WaterFlow(this.preferredFlow),
                new Duration(this.preferredDuration)

        );
    }

}
