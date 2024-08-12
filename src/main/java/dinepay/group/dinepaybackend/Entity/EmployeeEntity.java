package dinepay.group.dinepaybackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "password")
    private String password;

    @OneToOne
    private TableEntity tableEntity;

    /*
    manyToManyn entre employee et salle
    mais je ne pense pas que ce soit nécessaire
    let's check it out
     */


    public EmployeeEntity() {

    }

    public EmployeeEntity(int id, String nom, String password) {
        this.id = id;
        this.nom = nom;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TableEntity getTableEntity() {
        return tableEntity;
    }
}
