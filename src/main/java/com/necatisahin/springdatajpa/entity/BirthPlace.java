package com.necatisahin.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "birth_place")
@Builder
public class BirthPlace {
    @Id
    @SequenceGenerator(
            name = "birth_place_sequence",
            sequenceName = "birth_place_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "birth_place_sequence"
    )
    @Column(name = "birth_place_id")
    private Long birthPlaceId;

    @Column(name = "birth_place_city_name")
    private String birthPlaceCity;

    @Column(name = "birth_place_city_area")
    private String birthPlaceArea;

    /* OneToMany example converted to ManyToOne
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="birthPlaceId",
            referencedColumnName = "birth_place_id"
    )
    private List<IdentityCard> identityCardList;
     */

}
