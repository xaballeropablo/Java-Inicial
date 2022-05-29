package com.finalproyect.coderhouse.repository;

import com.finalproyect.coderhouse.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    Enterprise findByName(String name);

    Enterprise findByIndustry(String industry);
}
