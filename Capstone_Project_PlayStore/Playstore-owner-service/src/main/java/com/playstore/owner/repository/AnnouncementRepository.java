package com.playstore.owner.repository;

import com.playstore.owner.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findTop10ByOrderByCreatedAtDesc();
    List<Announcement> findTop10ByAppIdOrderByCreatedAtDesc(Long appId);
}
