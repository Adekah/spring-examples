package com.adekah.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "adresss")
    private String address;

    @Enumerated
    private AdressType addressType;

    @Column(name = "isActive")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_adres_id")
    private User user;

    public   enum AdressType {
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }

}
