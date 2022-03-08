package com.har.springbootjpa3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Store {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String address;


    @JoinColumn(name = "store_id")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Staff> staff;
}
