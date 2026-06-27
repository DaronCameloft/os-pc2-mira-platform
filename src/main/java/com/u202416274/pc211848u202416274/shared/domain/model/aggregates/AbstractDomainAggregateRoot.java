package com.u202416274.pc211848u202416274.shared.domain.model.aggregates;

import org.springframework.data.domain.AbstractAggregateRoot;

public abstract class AbstractDomainAggregateRoot<T extends AbstractAggregateRoot<T>>
        extends AbstractAggregateRoot<T> {
}