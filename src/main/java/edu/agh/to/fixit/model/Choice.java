package edu.agh.to.fixit.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Choice parent;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Choice> choices = new ArrayList<>();


    public Choice() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Choice getParent() {
        return parent;
    }

    public void setParent(Choice parent) {
        this.parent = parent;
    }

    public Collection<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Collection<Choice> choices) {
        this.choices = choices;
    }


    public void addSubChoice(Choice choice){
        choices.add(choice);
        choice.setParent(this);
    }

    @Override
    public String toString() {
        return "Choice{" +
                "parent=" + parent +
                ", choices=" + choices +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
