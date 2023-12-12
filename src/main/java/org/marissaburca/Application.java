package org.marissaburca;

import org.marissaburca.dao.EventoDAO;
import org.marissaburca.entities.Evento;
import org.marissaburca.entities.TipoEvento;

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

        Evento nuovo = new Evento("Festa Laurea", LocalDate.of(2023,12,23),"Nuova festa laurea super cool", TipoEvento.PUBBLICO,50 );
        ed.save(nuovo);
    }
}
