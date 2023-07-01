package com.realhospitalmanagementsystem.controller;
import com.realhospitalmanagementsystem.payload.BillingDTO;
import com.realhospitalmanagementsystem.sevice.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping
    public ResponseEntity<Page<BillingDTO>> getAllBillings(Pageable pageable) {
        Page<BillingDTO> billings = billingService.getAllBillings(pageable);
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingDTO> getBillingById(@PathVariable Long id) {
        BillingDTO billing = billingService.getBillingById(id);
        return new ResponseEntity<>(billing, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BillingDTO> createBilling(@RequestBody BillingDTO billingDTO) {
        BillingDTO billing = billingService.createBilling(billingDTO);
        return new ResponseEntity<>(billing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingDTO> updateBilling(@PathVariable Long id, @RequestBody BillingDTO billingDTO) {
        BillingDTO billing = billingService.updateBilling(id, billingDTO);
        return new ResponseEntity<>(billing, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        billingService.deleteBilling(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
