package com.realhospitalmanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {
  private long id;
    private Long patientId;
    private Long serviceId;
    private LocalDate billingDate;
    private BigDecimal amount;
    private String insuranceCoverage;
    private String paymentStatus;
    private String paymentMethod;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
    private BigDecimal remainingBalance;
    private String billingStatus;
    private Long providerId;
    private String remarks;
}
