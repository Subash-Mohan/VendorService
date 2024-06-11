package com.marraigemate.vendorservice.controller;

import com.marraigemate.vendorservice.DTO.VendorDTO;
import com.marraigemate.vendorservice.DTO.VendorUpdateRequest;
import com.marraigemate.vendorservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/register")
    public ResponseEntity<String> registerVendor(@RequestBody VendorDTO vendorDTO) {
        String Id = vendorService.registerVendor(vendorDTO);
        return ResponseEntity.ok(Id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateVendor(@RequestBody List<VendorUpdateRequest> vendorUpdateRequestList, @RequestParam String vendorId) {
        String Id = vendorService.updateVendor(vendorUpdateRequestList, vendorId);
        return ResponseEntity.ok(Id);
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable String vendorId) {
        VendorDTO vendorDTO = vendorService.getVendorById(vendorId);
        return ResponseEntity.ok(vendorDTO);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteVendor(@PathVariable String vendorId) {
        String Id = vendorService.deleteVendor(vendorId);
        return ResponseEntity.ok(Id);
    }
}
