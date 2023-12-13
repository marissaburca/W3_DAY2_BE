package org.marissaburca.dao;
import org.marissaburca.entities.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em; //permette interazione con database

    public PersonaDAO ( EntityManager em ) {
        this.em = em;
    }
    //****************** SAVE *****************
    public void save( Persona persona ){
        //transazione fornita da EntityManger
        EntityTransaction transaction = em.getTransaction();

        transaction.begin(); //inizio transazione
        em.persist(persona); //aggiungo evento a db (non ancora salvato)
        transaction.commit(); //concludo transactioin con commit
        System.out.println(persona.getNome() + " " + persona.getCognome() + " successfully added to table"); //riscontro
    }

    //****************** FIND BY ID *****************
    public Persona findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Persona.class, id); // Primo parametro Entity, secondo ID
    }

    //****************** DELETE *****************
    public void findByIdAndDelete(long id){
        Persona found = this.findById(id); //cerco studente
        if(found != null){
            //lo elimino con i seguenti passaggi
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( found.getNome() + " " + found.getCognome() + " successfully deleted from table");
        }else {
            //in caso evento non trovato
            System.out.println("Person not found");
        }
    }
}
