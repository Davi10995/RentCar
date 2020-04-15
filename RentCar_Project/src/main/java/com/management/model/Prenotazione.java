package com.management.model;

import com.management.model.Veicolo;
import com.management.model.User;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Prenotazione")
public class Prenotazione {



    @Column(name = "Id", updatable = false, nullable = false)
    public int id;
    public User user;
    public Veicolo veicolo;
    @Column (name = "dataInizio")
    public Date dataInizio;
    @Column (name = "dataFine")
    public Date dataFine;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn( name="fk_user" , referencedColumnName="Id", insertable = false, updatable = false)
    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user= user;
    }

    @ManyToOne(targetEntity=Veicolo.class, fetch=FetchType.EAGER)
    @JoinColumn( name="fk_veicolo" ,  referencedColumnName="Id" , insertable = false, updatable = false)
    public Veicolo getVeicolo(){
        return this.veicolo;
    }
    public void setVeicolo(Veicolo veicolo){
        this.veicolo = veicolo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id= id;
    }

    public Prenotazione(){    }

    public Prenotazione(User user, Veicolo veicolo, Date dataInizio, Date dataFine){
        this.user = user;
        this.veicolo = veicolo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }


    public Date getDataInizio(){
        return this.dataInizio;
    }
    public void setDataInizio(Date dataInizio){
        this.dataInizio = dataInizio;
    }
    public Date getDataFine(){
        return this.dataFine;
    }
    public void setDataFine(Date dataFine){
        this.dataFine = dataFine;
    }
}