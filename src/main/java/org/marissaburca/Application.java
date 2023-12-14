package org.marissaburca;

import org.marissaburca.dao.EventoDAO;
import org.marissaburca.dao.LocationDAO;
import org.marissaburca.dao.ParticipationsDAO;
import org.marissaburca.dao.PersonaDAO;
import org.marissaburca.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {
    //persistence unit name deve corrisponderre al nome che ho dato in persistence.xml
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

    public static void main(String[] args){
        EntityManager em = emf.createEntityManager(); // Entity Manager è responsabile della gestione delle interazioni col DB
        EventoDAO ed = new EventoDAO (em);
        LocationDAO ld = new LocationDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        ParticipationsDAO psd = new ParticipationsDAO(em);

        Location location1 = new Location("Stadio San Siro", "Milano");
       // ld.saveLocation(location1);
        Location location2 = new Location("Teatro La Scala", "Milano");
       // ld.saveLocation(location2);
        Location location1FromDB = ld.findById(16);
        Location location2FromDB = ld.findById(17);



        Persona persona1 = new Persona("giulia","DeAndre", "gliulia@gmail.com", LocalDate.now(), Sex.FEMALE);
        //pd.save(persona1);
        Persona persona2 = new Persona("maria","DeFilippi", "maria@gmail.com", LocalDate.now(), Sex.FEMALE);
        //pd.save(persona2);
        Persona persona1FromDB = pd.findById(15);
        Persona persona2FromDB = pd.findById(18);

        FootballMatch derby1 = new FootballMatch("Derby",LocalDate.of(2023,10,15),"bella partita",TipoEvento.PUBBLICO,50000,location1FromDB,"milan","inter","milan",5,0);
        FootballMatch derby2 = new FootballMatch("Derby",LocalDate.of(2023,10,15),"bella partita",TipoEvento.PUBBLICO,50000,location1FromDB,"torino","juve","juve",1,4);
        FootballMatch derby3 = new FootballMatch("Derby",LocalDate.of(2023,10,15),"bella partita",TipoEvento.PUBBLICO,50000,location1FromDB,"real madrid","barcelona",null,2,2);
        //ed.save(derby1);
        //ed.save(derby2);
        //ed.save(derby3);

        List<FootballMatch> homeWins = ed.getWonMatchesAtHome();
        System.out.println("*******  Matches won at home  ******* ");
        homeWins.forEach(System.out::println);

        List<FootballMatch> awayWins = ed.getWonMatchesAway();
        System.out.println("*******  Matches won away  ******* ");
        awayWins.forEach(System.out::println);

        List<FootballMatch> draws = ed.getDrawsMatches();
        System.out.println("*******  Matches draws  ******* ");
        draws.forEach(System.out::println);








        //Participations partecipate = new Participations(persona1,nuovo,Stato.DA_CONFERMARE );
        //psd.save(partecipate);
    }
}
