package com.necatisahin.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "driver_licence")
@Builder
public class DriverLicence {

    @Id
    @SequenceGenerator(
            name = "driver_licence_sequence",
            sequenceName = "driver_licence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "driver_licence_sequence"
    )
    @Column(name = "driver_licence_id")
    private Long driverLicenceId;

    @Embedded
    private IssuedBy issuedBy;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "identityCardId",
            referencedColumnName = "identity_card_id"
    )
    private IdentityCard IdentityCard;
}
