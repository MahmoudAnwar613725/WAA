package edu.miu.restful.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transaction;
    Date datetime;
    double duration;
    @ManyToOne
    @JoinColumn(name = "principle_id")
    Users principle;
    String operation;

}
