package com.necatisahin.springdatajpa.repository;

import com.necatisahin.springdatajpa.entity.DriverLicence;
import com.necatisahin.springdatajpa.entity.IdentityCard;
import com.necatisahin.springdatajpa.entity.IssuedBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DriverLicenceRepositoryTest {

    @Autowired
    DriverLicenceRepository driverLicenceRepository;

    @Test
    public void saveDriverLicenceTest() {
        IssuedBy issuedBy = IssuedBy.builder()
                .issuingRegistryOffficeName("MelbourneOffice")
                .issuingRegistryOffficeLocation("AU")
                .build();
        IdentityCard identityCard = IdentityCard.builder()
                .identityNo("1083136778412312")
                .firstName("Necati")
                .lastName("Sahin")
                .serialNumber("5213125552677221334")
                .issuedBy(issuedBy)
                .build();

        DriverLicence driverLicence = DriverLicence.builder()
                .issuedBy(issuedBy)
                .IdentityCard(identityCard)
                .build();

        driverLicenceRepository.save(driverLicence);
        System.out.println(driverLicence);
    }

}