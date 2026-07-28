package com.mmdfo.salonbooking.entity;

import com.mmdfo.salonbooking.entity.enums.ServiceCategory;
import com.mmdfo.salonbooking.entity.enums.ServiceStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
public class SalonService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;
    private BigInteger estimatedTime;

    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    @Enumerated(EnumType.STRING)
    private ServiceCategory category;
}
