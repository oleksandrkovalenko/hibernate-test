package com.test.domain;

import javax.persistence.*;

@Entity
@Table
public class AuthorizationPosition {

    @Id
    protected int id;

    @ManyToOne(fetch = FetchType.LAZY , optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ATTRIBUTES_ID", referencedColumnName="PRODUCT_ATTRIBUTES_ID")
    protected ProductAttributes productAttributes;

    public void setProductAttributes(ProductAttributes productAttributes) {
        this.productAttributes = productAttributes;
    }

}
