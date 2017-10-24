package com.keysight.es.tool.support.obfuscation.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Registration")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String email;
    String organization;
    String userAccount;

}
