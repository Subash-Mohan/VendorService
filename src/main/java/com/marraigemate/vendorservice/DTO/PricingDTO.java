package com.marraigemate.vendorservice.DTO;

import com.marraigemate.vendorservice.collection.Pricing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricingDTO {
    private Integer price;

    private String unit;

    private String currency;

}
