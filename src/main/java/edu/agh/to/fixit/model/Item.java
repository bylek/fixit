package edu.agh.to.fixit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Item {

    private int id;
    private String name;
    private String type;

    @JsonIgnore
    private Set<Choice> choices;

    public Item(){

    }

    public Item(int id, String name){
        this.name = name;
        this.id = id;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="items")
    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }






}
