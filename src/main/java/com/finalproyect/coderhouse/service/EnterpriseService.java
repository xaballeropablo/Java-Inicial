package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Enterprise;

public interface EnterpriseService {

    Enterprise getById(Long id);

    Enterprise getByName(String name);

    Enterprise getByIndustry(String industry);

    Enterprise saveEnterprise(Enterprise enterprise);

    Enterprise putEnterpriseDatabase(Enterprise enterprise);

    String deleteEnterprise(Long id);
}
