package org.example.library_management_backend.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrow_book")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUser", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdBook", nullable = false)
    private Book book;

    @Column(name = "QuantityBorrow")
    private Integer QuantityBorrow;


    @Column(name = "isDelete")
    private Boolean isDelete;
}