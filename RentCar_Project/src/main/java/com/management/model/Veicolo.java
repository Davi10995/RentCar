package com.management.model;

import javax.persistence.*;

@Entity
@Table(name="Veicolo", schema="rentcar")
public class Veicolo{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", updatable = false,nullable=false)
    public int id;

    @Column(name="Targa")
    public String targa;

    @Column(name = "Modello")
    public String modello;

    @Column(name="CasaCostrutt")
    public String casaCostrutt;


    @Column(name="AnnoImm")
    public String annoImm;


    public Veicolo(){}

    public Veicolo(String targa, String modello, String casaCostrutt, String annoImm) {
        this.targa = targa;
        this. modello = modello;
        this.casaCostrutt = casaCostrutt;
        this.annoImm = annoImm;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getCasaCostrutt() {
        return casaCostrutt;
    }
    public void setCasaCostrutt(String casa) {
        this.casaCostrutt = casa;
    }

    public String getAnnoImm() {
        return annoImm;
    }

    public void setAnnoImm(String annoImm) {
        this.annoImm = annoImm;
    }

}