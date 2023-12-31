package org.marissaburca.entities;

import javax.persistence.*;

@Entity
@Table(name="participations")
public class Participations {
    @Id //CHIAVE PRIMARIA - OBBLIGATORIA
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="participation_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="eventi")
    private Evento evento;
    @Column(name="stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;

    //Costruttore
    public Participations ( Persona persona,Evento evento, Stato stato ) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }
    public Participations(){}

    //Getter
    public long getId () {
        return id;
    }

    public Persona getPersona () {
        return persona;
    }

    public Evento getEvento () {
        return evento;
    }

    public Stato getStato () {
        return stato;
    }

    //Setter

    public void setPersona ( Persona persona ) {
        this.persona = persona;
    }

   public void setEvento ( Evento evento ) {
        this.evento = evento;
    }

    public void setStato ( Stato stato ) {
        this.stato = stato;
    }
}
