package com.example.apx.webservice.dao.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apx.webservice.domain.api.Holding;
@Repository
@Transactional
public interface HoldingRepository extends JpaRepository<Holding, Long> {

}
