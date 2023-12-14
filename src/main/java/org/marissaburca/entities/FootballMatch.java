package org.marissaburca.entities;

import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
public class FootballMatch extends Evento {
   public String homeTeam;
   public String gueastTeam;
   public String winningTeam;
   public int homeTeamGoals;
   public int guestTeamGoals;

   //constructor

   public FootballMatch ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String homeTeam, String gueastTeam, String winningTeam, int homeTeamGoals, int guestTeamGoals ) {
      super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
      this.homeTeam = homeTeam;
      this.gueastTeam = gueastTeam;
      this.winningTeam = winningTeam;
      this.homeTeamGoals = homeTeamGoals;
      this.guestTeamGoals = guestTeamGoals;
   }

   //setter

   public void setHomeTeam ( String homeTeam ) {
      this.homeTeam = homeTeam;
   }

   public void setGueastTeam ( String gueastTeam ) {
      this.gueastTeam = gueastTeam;
   }

   public void setWinningTeam ( String winningTeam ) {
      this.winningTeam = winningTeam;
   }

   public void setHomeTeamGoals ( int homeTeamGoals ) {
      this.homeTeamGoals = homeTeamGoals;
   }

   public void setGuestTeamGoals ( int guestTeamGoals ) {
      this.guestTeamGoals = guestTeamGoals;
   }

   //getter


   public String getHomeTeam () {
      return homeTeam;
   }

   public String getGueastTeam () {
      return gueastTeam;
   }

   public String getWinningTeam () {
      return winningTeam;
   }

   public int getHomeTeamGoals () {
      return homeTeamGoals;
   }

   public int getGuestTeamGoals () {
      return guestTeamGoals;
   }
}
