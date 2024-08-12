package dinepay.group.dinepaybackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Salle")
public class SalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numeroSalle")
    private String numeroSalle;

    @Column(name = "numeroTable")
    private int nombreTable;

    @OneToMany
    private List<TableEntity> tableEntityList;

    @OneToMany
    private List<FactureEntity> factureEntities;

    /*@ManyToMany
    @JoinTable(
            name = "salle_employee",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "employeeId")
    )
    private List<EmployeeEntity> employeeEntityList;
*/

    public SalleEntity(int id, String numeroSalle, int nombreTable) {
        this.id = id;
        this.numeroSalle = numeroSalle;
        this.nombreTable = nombreTable;
    }

    public SalleEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public int getNombreTable() {
        return nombreTable;
    }

    public void setNombreTable(int nombreTable) {
        this.nombreTable = nombreTable;
    }

    public List<FactureEntity> getFactureEntities() {
        return factureEntities;
    }
}
