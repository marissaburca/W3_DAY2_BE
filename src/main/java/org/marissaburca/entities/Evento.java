package org.marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // indica che classe va mappata a tabella database
@Table(name = "events") //specifico nome tabella
public class Evento {
    @Id //CHIAVE PRIMARIA - OBBLIGATORIA
    @GeneratedValue
    private long id;
    @Column(name = "title") //personalizza nome colonna - opzionale
    private String titolo;
    @Column(name = "event")
    private LocalDate dataEvento;
    @Column(name = "description")
    private String descrizione;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "max_partecipants")
    private int numeroMassimoPartecipanti;
    /*@ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;*/

    //Costruttore
    public Evento ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
       // this.location = location;
    }


    //setter
    public void setTitolo ( String titolo ) {
        this.titolo = titolo;
    }

    public void setDataEvento ( LocalDate dataEvento ) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione ( String descrizione ) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento ( TipoEvento tipoEvento ) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti ( int numeroMassimoPartecipanti ) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
    //getter

    public String getTitolo () {
        return titolo;
    }

    public LocalDate getDataEvento () {
        return dataEvento;
    }

    public String getDescrizione () {
        return descrizione;
    }

    public TipoEvento getTipoEvento () {
        return tipoEvento;
    }

    public int getNumeroMassimoPartecipanti () {
        return numeroMassimoPartecipanti;
    }
}
