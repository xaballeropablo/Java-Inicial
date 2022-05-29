package com.finalproyect.coderhouse.dto;

import com.finalproyect.coderhouse.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto {

    private Product product;

    private int amount;

}
