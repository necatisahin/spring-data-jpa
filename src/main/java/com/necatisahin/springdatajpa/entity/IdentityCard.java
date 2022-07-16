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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "identity_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "serial_number_unique",
                        columnNames = "serial_number"),
                @UniqueConstraint(
                        name = "identity_no_unique",
                        columnNames = "identity_no"),
        }

)
public class IdentityCard {

    @Id
    @SequenceGenerator(
            name = "identity_card_sequence",
            sequenceName = "identity_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "identity_card_sequence"
    )
    @Column(name = "identity_card_id")
    private Long identityCardId;

    private String firstName;
    private String lastName;

    @Column(
            name = "serial_number",
            nullable = false
    )
    private String serialNumber;

    @Column(
            name = "identity_no",
            nullable = false
    )
    private String identityNo;

    @Embedded
    private IssuedBy issuedBy;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "birthPlaceId",
            referencedColumnName = "birth_place_id"
    )
    private BirthPlace birthPlace;

    //Testing the data is transient or not
    @Transient
    private String transientTestData;


}
