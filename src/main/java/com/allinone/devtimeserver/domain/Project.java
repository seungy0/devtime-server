package com.allinone.devtimeserver.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
