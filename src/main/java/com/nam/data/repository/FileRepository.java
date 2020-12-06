package com.nam.data.repository;

import com.nam.data.model.TFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<TFile, Long> {
}
