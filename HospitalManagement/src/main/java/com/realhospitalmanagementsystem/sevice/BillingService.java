package com.realhospitalmanagementsystem.sevice;

import com.realhospitalmanagementsystem.payload.BillingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BillingService {
    Page<BillingDTO> getAllBillings(Pageable pageable);
    BillingDTO getBillingById(Long id);
    BillingDTO createBilling(BillingDTO billingDTO);
    BillingDTO updateBilling(Long id, BillingDTO billingDTO);
    void deleteBilling(Long id);
}
