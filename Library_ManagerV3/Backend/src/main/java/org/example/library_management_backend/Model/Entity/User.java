package org.example.library_management_backend.Model.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public enum Role{
        ADMIN,
        MANAGEMENT,
        USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;


    @Column(name = "Cccd")
    private String Cccd;

    @Column(name = "name")
    private String Name;

    @Column(name = "birthdate")
    private String BirthDate;

    @Column(name = "address")
    private String Address;

    @Column(name = "`username`")
    private String UserName;

    @Column(name = "password")
    private String Password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role Role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BorrowBook> listBorrowBook;






}
