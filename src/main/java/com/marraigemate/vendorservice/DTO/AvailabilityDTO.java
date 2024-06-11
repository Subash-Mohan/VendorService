package com.marraigemate.vendorservice.DTO;

import com.marraigemate.vendorservice.collection.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityDTO {
    private List<String> days;

    private String startTime;

    private String endTime;

}
