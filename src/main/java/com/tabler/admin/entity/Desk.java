package com.tabler.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "desks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "desk_id")
    private Long deskId;
    @Column
    private String name;
}
