package com.realhospitalmanagementsystem.sevice.seviceImpl;


import com.realhospitalmanagementsystem.entity.Billing;
import com.realhospitalmanagementsystem.exception.BillingNotFoundException;
import com.realhospitalmanagementsystem.payload.BillingDTO;
import com.realhospitalmanagementsystem.repository.BillingRepository;
import com.realhospitalmanagementsystem.sevice.BillingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<BillingDTO> getAllBillings(Pageable pageable) {
        Page<Billing> billings = billingRepository.findAll(pageable);
        return billings.map(this::convertToDTO);
    }

    @Override
    public BillingDTO getBillingById(Long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new BillingNotFoundException("Billing not found with ID: " + id));
        return convertToDTO(billing);
    }

    @Override
    public BillingDTO createBilling(BillingDTO billingDTO) {
        Billing billing = convertToEntity(billingDTO);
        Billing savedBilling = billingRepository.save(billing);
        return convertToDTO(savedBilling);
    }

    @Override
    public BillingDTO updateBilling(Long id, BillingDTO billingDTO) {
        Billing existingBilling = billingRepository.findById(id)
                .orElseThrow(() ->
                        new BillingNotFoundException("Billing not found with ID: " + id));
        modelMapper.map(billingDTO, existingBilling);
        existingBilling.setId(id);
        Billing updatedBilling = billingRepository.save(existingBilling);
        return convertToDTO(updatedBilling);
    }

    @Override
    public void deleteBilling(Long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new BillingNotFoundException("Billing not found with ID: " + id));
        billingRepository.delete(billing);
    }

    private BillingDTO convertToDTO(Billing billing) {
        return modelMapper.map(billing, BillingDTO.class);
    }

    private Billing convertToEntity(BillingDTO billingDTO) {
        return modelMapper.map(billingDTO, Billing.class);
    }
}

