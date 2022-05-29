package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Enterprise;
import com.finalproyect.coderhouse.exception.DbException;
import com.finalproyect.coderhouse.repository.EnterpriseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    public Enterprise getById(Long id) {
        log.info("Searching enterprise by id {}", id);
        Optional<Enterprise> enterpriseFound = enterpriseRepository.findById(id);
        if (enterpriseFound.isPresent()) {
            log.info("Enterprise by id {} found", id);
            return enterpriseFound.get();
        } else {
            log.error("Enterprise by id {} not found", id);
            throw new DbException("(Get) Enterprise id not found");
        }
    }

    public Enterprise getByName(String name) {
        log.info("Searching enterprise by name {}", name);
        Optional<Enterprise> enterpriseFound = Optional.ofNullable(enterpriseRepository.findByName(name));
        if (enterpriseFound.isPresent()) {
            log.info("Enterprise by name {} found", name);
            return enterpriseFound.get();
        } else {
            log.error("Enterprise by name {} not found", name);
            throw new DbException("(Get) Enterprise name not found");
        }
    }

    public Enterprise getByIndustry(String industry) {
        log.info("Searching enterprise by industry {}", industry);
        Optional<Enterprise> enterpriseFound = Optional.ofNullable(enterpriseRepository.findByIndustry(industry));
        if (enterpriseFound.isPresent()) {
            log.info("Enterprise by industry {} found", industry);
            return enterpriseFound.get();
        } else {
            log.error("Enterprise by industry {} not found", industry);
            throw new DbException("(Get) Enterprise industry not found");
        }
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        log.info("Saving new enterprise");
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise putEnterpriseDatabase(Enterprise enterprise) {
        log.info("Searching enterprise by id {}", enterprise.getId());
        Optional<Enterprise> enterpriseFound = enterpriseRepository.findById(enterprise.getId());
        if (enterpriseFound.isPresent()) {
            log.info("Enterprise by id {} found", enterprise.getId());
            Enterprise putEnterprise = enterpriseFound.get();
            log.info("Set name {} to enterprise id {}", enterprise.getName(), enterprise.getId() );
            putEnterprise.setName(enterprise.getName());
            log.info("Set industry {} to enterprise id {}", enterprise.getIndustry(), enterprise.getId());
            putEnterprise.setIndustry(enterprise.getIndustry());
            log.info("Saving new data enterprise");
            return enterpriseRepository.save(enterprise);
        } else {
            log.error("Enterprise by id {} not found", enterprise.getId());
            throw new DbException("(Put) Enterprise id not found");
        }
    }

    public String deleteEnterprise(Long id) {
        log.info("Searching enterprise by id {}", id);
        Optional<Enterprise> enterpriseFound = enterpriseRepository.findById(id);
        if (enterpriseFound.isPresent()) {
            log.info("Enterprise by id {} found", id);
            Enterprise deleteEnterprise = enterpriseFound.get();
            enterpriseRepository.deleteById(id);
            return "Enterprise " + deleteEnterprise.getName() + " " + deleteEnterprise.getIndustry() + " Deleted";
        } else {
            log.error("Enterprise by id {} not found", id);
            throw new DbException("(Delete) Enterprise id not found");
        }
    }
}
