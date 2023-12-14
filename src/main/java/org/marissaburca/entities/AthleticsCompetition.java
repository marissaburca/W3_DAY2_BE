package org.marissaburca.entities;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class AthleticsCompetition extends Evento {
   public Set<Persona> persone;
   public Persona winner;


   public AthleticsCompetition ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> persone, Persona winner ) {
      super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
      this.persone = persone;
      this.winner = winner;
   }

   public Set<Persona> getPersone () {
      return persone;
   }

   public void setPersone ( Set<Persona> persone ) {
      this.persone = persone;
   }

   public Persona getWinner () {
      return winner;
   }

   public void setWinner ( Persona winner ) {
      this.winner = winner;
   }
}
