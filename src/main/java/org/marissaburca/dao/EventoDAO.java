package org.marissaburca.dao;

import org.marissaburca.entities.Concert;
import org.marissaburca.entities.Evento;
import org.marissaburca.entities.FootballMatch;
import org.marissaburca.entities.MusicalGenre;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {
    //nasconde dettagli implementativi dei metodi che accedono al database
    //per non sovraccaricare database di richieste si opera in uno strato mediano (peristense context)
    //nel quale lo sviluppatore apporta modifiche e poi chiama il metodo che aggiornato tutto in una volta sola

    private final EntityManager em; //permette interazione con database

    public EventoDAO ( EntityManager em ) {
        this.em = em;
    }

    public List<Concert> getConcertsInStreaming( boolean inStreaming){
        TypedQuery<Concert> getConcertsQuery = em.createQuery("SELECT c FROM Concert c WHERE streaming = :streaming",Concert.class);
        getConcertsQuery.setParameter("inStreaming",inStreaming);
        return getConcertsQuery.getResultList();
    };
    public List<Concert> getConcertsByGenre( MusicalGenre genre ){
        TypedQuery<Concert> getConcertsQuery = em.createQuery("SELECT c FROM Concert c WHERE genre = :genre",Concert.class);
        getConcertsQuery.setParameter("genre",genre);
        return getConcertsQuery.getResultList();
    };
    public List<FootballMatch> getWonMatchesAtHome(){
        TypedQuery<FootballMatch> getHomeWinsQuery = em.createNamedQuery("matches_won_at_home", FootballMatch.class);
        return getHomeWinsQuery.getResultList();
    }
    public List<FootballMatch> getWonMatchesAway(){
        TypedQuery<FootballMatch> getAwayWinsQuery = em.createNamedQuery("matches_won_away", FootballMatch.class);
        return getAwayWinsQuery.getResultList();
    }
    public List<FootballMatch> getDrawsMatches(){
        TypedQuery<FootballMatch> getDrawsQuery = em.createNamedQuery("matches_draws", FootballMatch.class);
        return getDrawsQuery.getResultList();
    }


    public String getConcertPerGenre(){
        return null;
    };
    //****************** SAVE *****************
    public void save( Evento evento ){
        //transazione fornita da EntityManger
        EntityTransaction transaction = em.getTransaction();

        transaction.begin(); //inizio transazione
        em.persist(evento); //aggiungo evento a db (non ancora salvato)
        transaction.commit(); //concludo transactioin con commit
        System.out.println( "Event" + evento.getTitolo() + " successfully added to table"); //riscontro
    }

    //****************** FIND BY ID *****************
    public Evento findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Evento.class, id); // Primo parametro Entity, secondo ID
    }

    //****************** DELETE *****************
    public void findByIdAndDelete(long id){
        Evento found = this.findById(id); //cerco studente
        if(found != null){
            //lo elimino con i seguenti passaggi
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "Event" + found.getTitolo() + " successfully deleted from table");
        }else {
            //in caso evento non trovato
            System.out.println( "Event not found");
        }
    }

}