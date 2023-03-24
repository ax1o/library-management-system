package com.backend.librarymanagementsystem.Entity;

import com.backend.librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Record {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String recordNumber;


    @Enumerated(EnumType.STRING)
    private TransactionStatus recordStatus;

    private boolean isIssuedOperation;

    @CreationTimestamp
    private Date recordDate;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;







}
