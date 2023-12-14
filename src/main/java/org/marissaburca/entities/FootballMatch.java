package org.marissaburca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="football_match")
@NamedQuery(name ="matches_won_at_home", query= "SELECT m FROM FootballMatch m WHERE m.homeTeamGoals > m.guestTeamGoals")
@NamedQuery(name ="matches_won_away", query= "SELECT m FROM FootballMatch m WHERE m.homeTeamGoals < m.guestTeamGoals")
@NamedQuery(name ="matches_draws", query= "SELECT m FROM FootballMatch m WHERE m.homeTeamGoals = m.guestTeamGoals")
public class FootballMatch extends Evento {
   @Column(name = "home_team")
   public String homeTeam;
   @Column(name = "guest_team")
   public String guestTeam;
   @Column(name = "winning_team")
   public String winningTeam;
   @Column(name = "home_team_goals")
   public int homeTeamGoals;
   @Column(name = "guest_team_goals")
   public int guestTeamGoals;

   //constructor
  public FootballMatch(){};
   public FootballMatch ( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String homeTeam, String guestTeam, String winningTeam, int homeTeamGoals, int guestTeamGoals ) {
      super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
      this.homeTeam = homeTeam;
      this.guestTeam = guestTeam;
      this.winningTeam = winningTeam;
      this.homeTeamGoals = homeTeamGoals;
      this.guestTeamGoals = guestTeamGoals;
   };


   //setter
   public void setHomeTeam ( String homeTeam ) {
      this.homeTeam = homeTeam;
   }

   public void setGuestTeam ( String gueastTeam ) {
      this.guestTeam = gueastTeam;
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

   public String getGuestTeam () {
      return guestTeam;
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

    @Override
    public String toString () {
        return "Match: " + "homeTeam= " + homeTeam + ", guestTeam= " + guestTeam + ", winningTeam= " + winningTeam  + ", homeTeamGoals=" + homeTeamGoals + ", guestTeamGoals=" + guestTeamGoals + ", stadium: " + location;
    }
}

