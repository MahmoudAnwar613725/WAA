package edu.miu.restful.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transaction;
    Date date;
    Time time;
    @ManyToOne
    @JoinColumn(name = "principle_id")
    @JsonBackReference
    Users principle;

    String operation;
    String exception;

}
