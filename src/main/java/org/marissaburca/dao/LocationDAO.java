package org.marissaburca.dao;
import org.marissaburca.entities.Location;
import org.marissaburca.entities.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em; //permette interazione con database

    public LocationDAO ( EntityManager em ) {
        this.em = em;
    }
    //****************** SAVE *****************
    public void save( Persona location ){
        //transazione fornita da EntityManger
        EntityTransaction transaction = em.getTransaction();

        transaction.begin(); //inizio transazione
        em.persist(location); //aggiungo evento a db (non ancora salvato)
        transaction.commit(); //concludo transactioin con commit
        System.out.println(location.getNome() + " " + " successfully added to table"); //riscontro
    }

    //****************** FIND BY ID *****************
    public Location findById( long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Location.class, id); // Primo parametro Entity, secondo ID
    }

    //****************** DELETE *****************
    public void findByIdAndDelete(long id){
        Location found = this.findById(id); //cerco studente
        if(found != null){
            //lo elimino con i seguenti passaggi
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( found.getNome() + " " +  " successfully deleted from table");
        }else {
            //in caso evento non trovato
            System.out.println("Location not found");
        }
    }

}
