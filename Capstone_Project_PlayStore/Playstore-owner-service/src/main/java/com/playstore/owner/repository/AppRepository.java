package com.playstore.owner.repository;

import com.playstore.owner.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByOwnerId(Long ownerId);
    List<App> findByVisibleTrue();

    List<App> findByVisibleTrueAndNameContainingIgnoreCase(String name);

    List<App> findByVisibleTrueAndGenreIgnoreCase(String genre);

    List<App> findByVisibleTrueAndNameContainingIgnoreCaseAndGenreIgnoreCase(String name, String genre);
}
