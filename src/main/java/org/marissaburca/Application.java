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
        ld.saveLocation(location1);

        Evento nuovo = new Evento("Festa Laurea", LocalDate.of(2023,12,23),"Nuova festa laurea super cool", TipoEvento.PUBBLICO,50,location1);
        ed.save(nuovo);

        Persona persona1 = new Persona("giulia","DeAndre", "gliulia@gmail.com", LocalDate.now(), Sex.FEMALE);
        pd.save(persona1);

        //Participations partecipate = new Participations(persona1,nuovo,Stato.DA_CONFERMARE );
        //psd.save(partecipate);
    }
}
