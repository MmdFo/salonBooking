package com.mmdfo.salonbooking.entity;


import com.mmdfo.salonbooking.enums.LeaveRequestStatus;
import com.mmdfo.salonbooking.enums.ShiftType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LeaveRequestEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity employeeEntity;

    @Column(nullable = false)
    private LocalDate leaveDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShiftType shiftType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveRequestStatus status;

    @Column(length = 1000)
    private String reason;

    @Column(length = 1000)
    private String adminComment;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity reviewedBy;

}
