package dinepay.group.dinepaybackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Table-restau")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "numeroTable")
    private String numeroTable;

    @Column(name = "nombrePlaces")
    private int nombrePlaces;

    @Column(name = "posX")
    private int posX;

    @Column(name = "posY")
    private int posY;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private SalleEntity salleEntity;

    @OneToOne(mappedBy = "tableEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private FactureEntity factureEntity;

    @ManyToMany
    @JoinTable(
            name = "table_produit",
            joinColumns = @JoinColumn(name = "table_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<ProduitEntity> produitEntityList;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;



    public TableEntity(int id, String numeroTable, int nombrePlaces, int posX, int posY, SalleEntity salleEntity, FactureEntity factureEntity, List<ProduitEntity> produitEntityList, EmployeeEntity employeeEntity) {
        this.id = id;
        this.numeroTable = numeroTable;
        this.nombrePlaces = nombrePlaces;
        this.posX = posX;
        this.posY = posY;
    }

    public TableEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(String numeroTable) {
        this.numeroTable = numeroTable;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public SalleEntity getSalleEntity() {
        return salleEntity;
    }

    public void setSalleEntity(SalleEntity salleEntity) {
        this.salleEntity = salleEntity;
    }

    public FactureEntity getFactureEntity() {
        return factureEntity;
    }

    public void setFactureEntity(FactureEntity factureEntity) {
        this.factureEntity = factureEntity;
    }

    public List<ProduitEntity> getProduitEntityList() {
        return produitEntityList;
    }

    public void setProduitEntityList(List<ProduitEntity> produitEntityList) {
        this.produitEntityList = produitEntityList;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }


}
