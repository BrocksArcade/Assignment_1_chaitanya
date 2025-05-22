package com.questionairepro.demo.repositoyes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.questionairepro.demo.models.UserResultModel;

public interface ResultRepo extends JpaRepository<UserResultModel, Long> {
    boolean existsByUID(Long UID);

    
    @Query(name = "getDenseRanks", nativeQuery = true)

    List<UserResultModel> getResultsByOrder();

    Optional<UserResultModel> findByUID(Long uid);

}
