package com.management.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Prenotazione")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrenotazione", updatable = false, nullable = false)
    public int id;

    @Column (name = "fk_user")
    public int userId;
    @Column (name = "fk_veicolo")
    public int veicoloId;
    @Column (name = "dataInizio")
    public Date dataInizio;
    @Column (name = "dataFine")
    public Date dataFine;


    public Prenotazione(){    }

    public Prenotazione(int user, int veicolo, Date inizio, Date fine){
        this.userId = user;
        this.veicoloId = veicolo;
        this.dataInizio = inizio;
        this.dataFine = fine;
    }

    public int getId() {
        return id;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getVeicoloId(){
        return this.veicoloId;
    }
    public void setVeicoloId(int veicoloId){
        this.veicoloId = veicoloId;
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