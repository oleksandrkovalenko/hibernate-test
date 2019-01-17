package com.test.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class ProductAttributes {

    @Id
    @Column(name = "PRODUCT_ATTRIBUTES_ID")
    protected int id;

    @javax.persistence.OneToMany(
            targetEntity=AuthorizationPosition.class,
            mappedBy = "productAttributes",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    protected Set<AuthorizationPosition> authorizationPositionsByProductAttributes = new HashSet<>();

    public void addAuthorizationPositionByProductAttributes(@NotNull AuthorizationPosition authorizationPositionByProductAttributes) {
        if (this.authorizationPositionsByProductAttributes.add(authorizationPositionByProductAttributes)) {
            authorizationPositionByProductAttributes.setProductAttributes(this);
        }
    }
}
