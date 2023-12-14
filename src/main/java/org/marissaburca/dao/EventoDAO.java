package org.marissaburca.dao;

import org.marissaburca.entities.Concert;
import org.marissaburca.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    //nasconde dettagli implementativi dei metodi che accedono al database
    //per non sovraccaricare database di richieste si opera in uno strato mediano (peristense context)
    //nel quale lo sviluppatore apporta modifiche e poi chiama il metodo che aggiornato tutto in una volta sola

    private final EntityManager em; //permette interazione con database

    public EventoDAO ( EntityManager em ) {
        this.em = em;
    }

    public Concert getConcertInStreaming(){};
    public Concert getConcertPerGenre(){};
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