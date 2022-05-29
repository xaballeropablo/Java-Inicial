package com.finalproyect.coderhouse.dto;

import com.finalproyect.coderhouse.entity.Client;
import com.finalproyect.coderhouse.entity.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Date date;

    private String invoiceType;

    private int total;

    private Client client;

    private Set<InvoiceDetailDto> invoiceDetails;

    private Enterprise enterprise;

}
