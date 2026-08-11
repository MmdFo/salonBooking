package com.mmdfo.salonbooking.entity;

import com.mmdfo.salonbooking.enums.ServiceCategory;
import com.mmdfo.salonbooking.enums.ServiceStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public class SalonServiceEntity extends BaseEntity {

    private String name;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;
    private Integer estimatedTime;

    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    @Enumerated(EnumType.STRING)
    private ServiceCategory category;
}
