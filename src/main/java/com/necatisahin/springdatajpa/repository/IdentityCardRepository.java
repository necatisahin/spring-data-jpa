package com.necatisahin.springdatajpa.repository;

import com.necatisahin.springdatajpa.entity.IdentityCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCard, Long> {


    Page<IdentityCard> findByFirstNameContaining(
            String firstNameContainingLetters,
            Pageable pageable);

    //JPQL
    @Query("select i.firstName from IdentityCard i where i.identityNo = ?1")
    String getFirstNameByIdentityNo(String emailId);

    //JPQL
    @Query(
            value = "select i.first_name from identity_card i where i.identitiy_no = ?1",
            nativeQuery = true
    )
    String getFirstNameByIdentityNoNativeNamedParam(String emailId);

    @Query(
            value = "select i.first_name from identity_card i where i.identitiy_no =:identityNo",
            nativeQuery = true
    )
    String getFirstNameByIdentityNoByParam(@Param("identityNo") String identityNo);

    @Modifying
    @Transactional
    @Query(
            value = "update identity_card set last_name = ?1 where identity_no = ?2",
            nativeQuery = true
    )
    int updateFirstNameByIdentityNo(String identityCardName,String identityNo);


}
