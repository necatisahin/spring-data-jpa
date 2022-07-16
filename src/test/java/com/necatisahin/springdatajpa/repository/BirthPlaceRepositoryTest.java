package com.necatisahin.springdatajpa.repository;

import com.necatisahin.springdatajpa.entity.BirthPlace;
import com.necatisahin.springdatajpa.entity.IdentityCard;
import com.necatisahin.springdatajpa.entity.IssuedBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BirthPlaceRepositoryTest {

    @Autowired
    BirthPlaceRepository birthPlaceRepository;

    @Test
    public void saveBirthPlacesTest() {

        IssuedBy issuedBy = IssuedBy.builder()
                .issuingRegistryOffficeName("MelbourneOffice")
                .issuingRegistryOffficeLocation("AU")
                .build();
        IdentityCard identityCard = IdentityCard.builder()
                .identityNo("10831367a784123aaaab4c2e")
                .firstName("Mehmet")
                .lastName("Sahin")
                .serialNumber("5213123a13asd3323aaabce42")
                .issuedBy(issuedBy)
                .build();
        IdentityCard identitySelma = IdentityCard.builder()
                .identityNo("10831367a784123aaaabcd4e2")
                .firstName("Hakan")
                .lastName("Sahin")
                .serialNumber("5213123a13asd3323aaabcd24e")
                .issuedBy(issuedBy)
                .build();
        BirthPlace birthPlace = BirthPlace.builder()
                .birthPlaceCity("Melbourne")
                .build();

        birthPlaceRepository.save(birthPlace);


    }

}