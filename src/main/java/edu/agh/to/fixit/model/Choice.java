package edu.agh.to.fixit.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Choice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Item> items = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Choice parentChoice;
    @OneToMany(mappedBy = "parentChoice")
    private Set<Choice> subChoices = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Repair> repairs = new HashSet<>();




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
    public Set<Item> getItems() {
        return items;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Choice> getSubChoices() {
        return subChoices;
    }

    public Choice getParentChoice() {
        return parentChoice;
    }

    public void setParentChoice(Choice parentChoice) {
        this.parentChoice = parentChoice;
    }

    public void setSubChoices(Set<Choice> subChoices) {
        this.subChoices = subChoices;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Choice{" +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
