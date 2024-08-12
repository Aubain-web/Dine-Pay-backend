package dinepay.group.dinepaybackend.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Facture")
public class FactureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "montant")
    private int montant;

    @Column(name = "dateCreation")
    @CreationTimestamp
    private LocalDateTime dateCreation;

    @OneToOne
    @JoinColumn(name = "table_numero")
    private TableEntity tableEntity;

    @ManyToOne
    @JoinColumn(name = "salle_numero")
    private SalleEntity salleEntity;

    @ManyToMany
    @JoinTable(
            name = "facture_produit",
            joinColumns = @JoinColumn(name = "facture_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<ProduitEntity> produitEntities;

    public FactureEntity(int id, int montant, LocalDateTime dateCreation) {
        this.id = id;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public FactureEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
