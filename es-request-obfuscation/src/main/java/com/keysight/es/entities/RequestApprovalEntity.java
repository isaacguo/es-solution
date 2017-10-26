package com.keysight.es.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RequestApproval")
public class RequestApprovalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String uuid;

    String userName;
    String projectName;
    boolean containIP;
    boolean exportToExternal;
    boolean winDesktopApplication;
    boolean winCEApplication;
    boolean shouldObfuscate;
    boolean obfuscateAll;
    boolean approved;

}
