package com.keysight.es.tool.support.obfuscation.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DotfuscatorInfo")
@Data
public class DotfuscatorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String Version;


}
