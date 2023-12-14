package org.marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="concert")
public class Concert extends Evento{
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    public MusicalGenre genre;
    @Column(name = "streaming")
    public boolean streaming;

    public Concert ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, MusicalGenre genre, Boolean streaming ) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genre = genre;
        this.streaming = streaming;
    }
    public Concert(){};

    public MusicalGenre getGenre () {
        return genre;
    }

    public void setGenre ( MusicalGenre genre ) {
        this.genre = genre;
    }

    public boolean getStreaming () {
        return streaming;
    }

    public void setStreaming ( boolean streaming ) {
        this.streaming = streaming;
    }
}
