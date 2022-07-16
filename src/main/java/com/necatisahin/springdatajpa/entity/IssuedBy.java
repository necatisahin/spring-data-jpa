package com.necatisahin.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "issuingRegistryOffficeName",
                column = @Column(name = "issuing_registry_offfice_name")
        ),
        @AttributeOverride(
                name = "issuingRegistryOffficeLocation",
                column = @Column(name = "issuing_registry_offfice_location")
        )
})
public class IssuedBy {

    private String issuingRegistryOffficeName;
    private String issuingRegistryOffficeLocation;

}
