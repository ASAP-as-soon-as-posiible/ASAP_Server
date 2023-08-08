package com.asap.server.domain;

import com.asap.server.domain.enums.TimeSlot;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TimeBlock extends AuditingTimeEntity {
    @Id
    private Long id;
    private TimeSlot time;
    @OneToMany
    private List<User> users;
    private int weight;
}