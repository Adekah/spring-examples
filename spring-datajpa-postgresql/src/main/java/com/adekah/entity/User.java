package com.adekah.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {

    @Id
    @SequenceGenerator(name = "seq_user",allocationSize = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 50, name = "name")
    private String name;
    @Column(length = 50, name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_adres_id")
     private List<Address> addresses;
}
