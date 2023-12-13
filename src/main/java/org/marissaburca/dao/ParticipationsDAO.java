package org.marissaburca.dao;
import org.marissaburca.entities.Participations;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ParticipationsDAO {
    private final EntityManager em; //permette interazione con database

    public ParticipationsDAO ( EntityManager em ) {
        this.em = em;
    }
    //****************** SAVE *****************
    public void save( Participations participation ){
        //transazione fornita da EntityManger
        EntityTransaction transaction = em.getTransaction();

        transaction.begin(); //inizio transazione
        em.persist(participation); //aggiungo evento a db (non ancora salvato)
        transaction.commit(); //concludo transactioin con commit
        System.out.println(Participations.getPersona() +" successfully added to table"); //riscontro
    }

    //****************** FIND BY ID *****************
    public Participations findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Participations.class, id); // Primo parametro Entity, secondo ID
    }

    //****************** DELETE *****************
    public void findByIdAndDelete(long id){
        Participations found = this.findById(id); //cerco studente
        if(found != null){
            //lo elimino con i seguenti passaggi
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println(Participations.getPersona() +" successfully deleted from table");
        }else {
            //in caso evento non trovato
            System.out.println("Participation not found");
        }
    }
}
