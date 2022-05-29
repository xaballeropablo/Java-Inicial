package com.finalproyect.coderhouse.controller;

import com.finalproyect.coderhouse.entity.Enterprise;
import com.finalproyect.coderhouse.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Validated
@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterpriseId/{id}")
    public Enterprise getEnterpriseId(@PathVariable(value = "id") @Min(1) Long id){
        return enterpriseService.getById(id);
    }

    @GetMapping("/enterpriseName/{name}")
    public Enterprise getEnterpriseName(@PathVariable(value = "name") @NotBlank @Pattern(regexp = "[a-zA-Z0-9]+") String name){
        return enterpriseService.getByName(name);
    }

    @GetMapping("/enterpriseIndustry/{industry}")
    public Enterprise getEnterpriseIndustry(@PathVariable(value = "industry") @NotBlank @Pattern(regexp = "[a-zA-Z]+") String industry){
        return enterpriseService.getByIndustry(industry);
    }

    @PostMapping("/enterpriseSet")
    public Enterprise setEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseService.saveEnterprise(enterprise);
    }

    @PutMapping("/enterprisePut")
    public Enterprise putEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseService.putEnterpriseDatabase(enterprise);
    }

    @DeleteMapping("/enterpriseDelete/{id}")
    public String enterpriseDelete(@PathVariable(value = "id") @Min(1) Long id){
        return enterpriseService.deleteEnterprise(id);
    }
}
