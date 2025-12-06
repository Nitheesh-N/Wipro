package com.playstore.owner.repository;

import com.playstore.owner.model.DownloadEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DownloadEventRepository extends JpaRepository<DownloadEvent, Long> {

    List<DownloadEvent> findTop10ByOrderByCreatedAtDesc();
}
