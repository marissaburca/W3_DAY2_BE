package org.marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // indica che classe va mappata a tabella database
@Table(name = "events") //specifico nome tabella
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "event_type")
public abstract class Evento {
    @Id //CHIAVE PRIMARIA - OBBLIGATORIA
    @GeneratedValue
    protected long id;
    @Column(name = "title") //personalizza nome colonna - opzionale
    protected String titolo;
    @Column(name = "event")
    protected LocalDate dataEvento;
    @Column(name = "description")
    protected String descrizione;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    protected TipoEvento tipoEvento;
    @Column(name = "max_partecipants")
    protected int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location location;
    @OneToMany(mappedBy="evento")
    protected List<Participations> participations;

    //Costruttore
    public Evento ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }
    public Evento(){};

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

    public void setLocation ( Location location ) {
        this.location = location;
    }

    public void setParticipations ( List<Participations> participations ) {
        this.participations = participations;
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
    public Location getLocation () {
        return location;
    }

    public List<Participations> getParticipations () {
        return participations;
    }

    @Override
    public String toString () {
        return "Event " + "id= " + id + ", titolo= " + titolo + ", dataEvento= " + dataEvento + ", descrizione= " + descrizione + ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti= " + numeroMassimoPartecipanti + ", location= " + location + '}';
    }
}
