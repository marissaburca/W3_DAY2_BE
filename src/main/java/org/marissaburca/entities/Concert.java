package org.marissaburca.entities;

import java.time.LocalDate;

public class Concert extends Evento{
    public MusicalGenre genre;
    public Boolean streaming;

    public Concert ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, MusicalGenre genre, Boolean streaming ) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genre = genre;
        this.streaming = streaming;
    }

    public MusicalGenre getGenre () {
        return genre;
    }

    public void setGenre ( MusicalGenre genre ) {
        this.genre = genre;
    }

    public Boolean getStreaming () {
        return streaming;
    }

    public void setStreaming ( Boolean streaming ) {
        this.streaming = streaming;
    }
}
