package edu.agh.to.fixit.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mkuligowski on 20.05.16.
 */
@Entity
public class Repair {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String noteFromCustomer;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "repairs")
    private Set<Choice> choices = new HashSet<>();

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteFromCustomer() {
        return noteFromCustomer;
    }

    public void setNoteFromCustomer(String noteFromCustomer) {
        this.noteFromCustomer = noteFromCustomer;
    }
}
