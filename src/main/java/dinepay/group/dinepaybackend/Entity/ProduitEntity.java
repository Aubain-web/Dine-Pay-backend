package dinepay.group.dinepaybackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Produit")
public class ProduitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "productname")
    private String productname;

    @Column(name = "stock")
    private int stock;
    @Column(name = "prix")
    private int prix;

    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "produitEntityList")
    private List<TableEntity> tableEntities;

    @ManyToMany(mappedBy = "produitEntities")
    private List<FactureEntity> factureEntities;

    public ProduitEntity(int id, String productname, int stock, int prix, String category) {
        this.id = id;
        this.productname = productname;
        this.stock = stock;
        this.prix = prix;
        this.category = category;
    }

    public ProduitEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
