package com.marraigemate.vendorservice.DTO;

import com.marraigemate.vendorservice.collection.Catering;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CateringDTO {
    private List<String> cuisines;

    private List<MenuItemDTO> menu;

    private Integer capacityMax;

    private Integer capacityMin;

    private PricingDTO pricingPerPerson;

}
