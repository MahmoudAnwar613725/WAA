package edu.miu.restful.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    int principle;
    String operation;
    String exception;

}
