package org.marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="athletics_competition")
@NamedQuery(name= "games_by_winner",query = "SELECT g FROM AthleticsCompetition g GROUP BY g.winner")
@NamedQuery(name= "games_by_participant",query = "SELECT g FROM AthleticsCompetition g GROUP BY g.winner")
public class AthleticsCompetition extends Evento {
   @ManyToMany
   public Set<Persona> athletes;
   @ManyToOne
   public Persona winner;


   public AthleticsCompetition ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> athletes, Persona winner ) {
      super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
      this.athletes = athletes;
      this.winner = winner;
   }
   public AthleticsCompetition(){};
   public Set<Persona> getAthlets () {
      return athletes;
   }

   public void setPersone ( Set<Persona> athlets ) {
      this.athletes = athlets;
   }

   public Persona getWinner () {
      return winner;
   }

   public void setWinner ( Persona winner ) {
      this.winner = winner;
   }
}
