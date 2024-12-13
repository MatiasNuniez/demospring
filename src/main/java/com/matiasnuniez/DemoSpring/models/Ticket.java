package com.matiasnuniez.DemoSpring.models;

import jakarta.persistence.*;

@Entity(name = "ticketEntity")
@Table(name = "TICKETS")

public class Ticket {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }

    public void setNameResponsible(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }

    public Long getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(Long idResponsible) {
        this.idResponsible = idResponsible;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_RESPONSIBLE", nullable = false)
    public String nameResponsible;

    @Column(name = "ID_RESPONSIBLE", nullable = false)
    public Long idResponsible;

    @Column(name = "STATUS_TICKET")
    public boolean status;

}