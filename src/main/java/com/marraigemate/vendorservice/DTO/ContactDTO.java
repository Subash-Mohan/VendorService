package com.marraigemate.vendorservice.DTO;

import com.marraigemate.vendorservice.collection.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private String name;

    private String email;

    private String phone;

}
