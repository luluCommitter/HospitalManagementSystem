package com.realhospitalmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "billings")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "billing_date")
    private LocalDate billingDate;

    private BigDecimal amount;

    @Column(name = "insurance_coverage")
    private String insuranceCoverage;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @Column(name = "remaining_balance")
    private BigDecimal remainingBalance;

    @Column(name = "billing_status")
    private String billingStatus;

    @Column(name = "provider_id")
    private Long providerId;

    private String remarks;

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", serviceId=" + serviceId +
                ", billingDate=" + billingDate +
                ", amount=" + amount +
                ", insuranceCoverage='" + insuranceCoverage + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                ", remainingBalance=" + remainingBalance +
                ", billingStatus='" + billingStatus + '\'' +
                ", providerId=" + providerId +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

