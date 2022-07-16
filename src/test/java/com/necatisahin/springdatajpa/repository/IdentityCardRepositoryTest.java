package com.necatisahin.springdatajpa.repository;

import com.necatisahin.springdatajpa.entity.BirthPlace;
import com.necatisahin.springdatajpa.entity.IdentityCard;
import com.necatisahin.springdatajpa.entity.IssuedBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class IdentityCardRepositoryTest {

    @Autowired
    private IdentityCardRepository identityCardRepository;

    @Test
    public void saveIdentityCardTest() {

        IssuedBy issuedBy = IssuedBy.builder()
                .issuingRegistryOffficeName("MelbourneOffice")
                .issuingRegistryOffficeLocation("AU")
                .build();
        IdentityCard idCard = IdentityCard.builder()
                .identityNo("10831367a784123aaaabcxz132")
                .firstName("Necati")
                .lastName("Sahin")
                .serialNumber("5213123a13asd3323aaabcxz123")
                .issuedBy(issuedBy)
                .transientTestData("Test123")
                .build();
        identityCardRepository.save(idCard);

    }

    @Test
    public void saveIdentityCardWithBirthPlaceTest() {

        BirthPlace birthPlace = BirthPlace.builder()
                .birthPlaceCity("Perth")
                .build();
        IssuedBy issuedBy = IssuedBy.builder()
                .issuingRegistryOffficeName("MelbourneOffice")
                .issuingRegistryOffficeLocation("AU")
                .build();
        IdentityCard idCard = IdentityCard.builder()
                .identityNo("10831367a784123aaaabcxy13")
                .firstName("Necati")
                .lastName("Sahin")
                .serialNumber("5213123a13asd3323aaabcxy13")
                .birthPlace(birthPlace)
                .issuedBy(issuedBy)
                .build();
        identityCardRepository.save(idCard);

    }

    @Test
    public void getIdentityCardByIdentityCardIdTest() {
        List<IdentityCard> identityCardList =
                identityCardRepository.findAll();
        System.out.println("identityCardList = " + identityCardList);
    }

    @Test
    public void getFirstNameByIdentityNoTest() {
        String firstName =
                identityCardRepository.getFirstNameByIdentityNo("10831367784123");
        System.out.println("identityCardList = " + firstName);
    }

    @Test
    public void updateFirstNameByIdentityNoTest() {
       identityCardRepository.updateFirstNameByIdentityNo("Srinivas2","10831367784123");
    }

    @Test
    public void findAllPaginationTest() {
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<IdentityCard> identityCardList =
                identityCardRepository.findAll(firstPagewithThreeRecords)
                        .getContent();

        long totalElements =
                identityCardRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        long totalPages =
                identityCardRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("identityCardList = " + identityCardList);
    }

    @Test
    public void findAllSortingTest() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("name")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("identityCardId").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("name")
                                .descending()
                                .and(Sort.by("identityNo"))
                );

        List<IdentityCard> identityCardList
                = identityCardRepository.findAll(sortByCreditDesc).getContent();

        System.out.println("sorted Identities = " + identityCardList);
    }

    @Test
    public void printfindByTitleContainingTest() {
        Pageable firstPageFiveRecords =
                PageRequest.of(0, 5);

        List<IdentityCard> identityCardList =
                identityCardRepository.findByFirstNameContaining(
                        "S",
                        firstPageFiveRecords).getContent();

        System.out.println("identityCardList = " + identityCardList);
    }


}