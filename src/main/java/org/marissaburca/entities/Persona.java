package org.marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Persona")
public class Persona {
    @Id //CHIAVE PRIMARIA - OBBLIGATORIA
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String nome;
    @Column(name = "surname")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate dataDiNascita;
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sesso;
    //@Column(name = "participations")
    //private List<Participations> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Evento evento; // <--- FOREIGN KEY

    //Costruttore

    public Persona ( String nome, String cognome, String email, LocalDate dataDiNascita, Sex sesso ) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
        //this.partecipazioni = partecipazioni;
    }


    //Getter

    public String getNome () {
        return nome;
    }

    public String getCognome () {
        return cognome;
    }

    public String getEmail () {
        return email;
    }

    public LocalDate getDataDiNascita () {
        return dataDiNascita;
    }

    public Sex getSesso () {
        return sesso;
    }

    /*public List<Participations> getPartecipazioni () {
        return partecipazioni;
    }*/


    //Setter

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public void setCognome ( String cognome ) {
        this.cognome = cognome;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public void setDataDiNascita ( LocalDate dataDiNascita ) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setSesso ( Sex sesso ) {
        this.sesso = sesso;
    }

    /*public void setPartecipazioni ( List<Participations> partecipazioni ) {
        this.partecipazioni = partecipazioni;
    }*/
}
