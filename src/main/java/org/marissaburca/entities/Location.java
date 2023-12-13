package org.marissaburca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="location")
public class Location {
    @Id //CHIAVE PRIMARIA - OBBLIGATORIA
    @GeneratedValue
    private long id;
    @Column(name="name")
    private String nome;
    @Column(name="city")
    private String città;
    /*@OneToMany(mappedBy = "location")
    private List<Evento> eventi = new ArrayList<>();*/

    //Costruttore
    public Location ( String nome, String città ) {
        this.nome = nome;
        this.città = città;
    }

    //getter
    public long getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public String getCittà () {
        return città;
    }

    //setter

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public void setCittà ( String città ) {
        this.città = città;
    }
}
