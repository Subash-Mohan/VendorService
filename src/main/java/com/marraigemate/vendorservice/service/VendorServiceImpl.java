package com.marraigemate.vendorservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marraigemate.vendorservice.DTO.VendorDTO;
import com.marraigemate.vendorservice.DTO.VendorUpdateRequest;
import com.marraigemate.vendorservice.collection.Vendor;
import com.marraigemate.vendorservice.exception.VendorNotFoundException;
import com.marraigemate.vendorservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public String registerVendor(VendorDTO vendorDTO) {
        Vendor vendor = objectMapper.convertValue(vendorDTO, Vendor.class);
        return vendorRepository.save(vendor).getId();
    }

    @Override
    public String updateVendor(List<VendorUpdateRequest> vendorUpdateRequestList, String vendorId) {

        Update update = new Update();
        vendorUpdateRequestList.forEach(vendorUpdateRequest -> {
            update.set(vendorUpdateRequest.getProperty(), vendorUpdateRequest.getValue());
        });
        mongoTemplate.updateFirst(query(where("id").is(vendorId)), update, Vendor.class);
        return "";
    }

    @Override
    public VendorDTO getVendorById(String vendorId) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(vendorId);
        Vendor vendor = vendorOptional.orElse(null);
        if(vendor == null) {
            throw new VendorNotFoundException("Vendor not found");
        }
        return objectMapper.convertValue(vendor, VendorDTO.class);
    }

    @Override
    public String deleteVendor(String vendorId) {
        vendorRepository.deleteById(vendorId);
        return vendorId;
    }
}
