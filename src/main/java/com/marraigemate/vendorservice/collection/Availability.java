package com.marraigemate.vendorservice.collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    private List<String> days;

    private String startTime;

    private String endTime;
}
