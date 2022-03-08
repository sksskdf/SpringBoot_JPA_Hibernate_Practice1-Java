package com.har.springbootjpa3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    /*@Column(name = "store_id")
    private Long storeId;*/

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id" , foreignKey = @ForeignKey(name = "fk1"))
    private Store store;*/
}
