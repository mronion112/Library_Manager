package org.example.library_management_backend.Model.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "title")
    private String Title;

    @Column(name = "author")
    private String Author;

    @Column(name = "year")
    private Integer Year;

    @Column(name = "quantity")
    private Integer Quantity;



}
