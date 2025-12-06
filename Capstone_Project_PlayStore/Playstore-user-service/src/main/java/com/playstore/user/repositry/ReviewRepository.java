package com.playstore.user.repositry;

import com.playstore.user.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByAppId(Long appId);

    List<Review> findByUserId(Long userId);
    @Query("select distinct r.userEmail from Review r where r.appId = :appId")
    List<String> findDistinctUserEmailsByAppId(@Param("appId") Long appId);
}
