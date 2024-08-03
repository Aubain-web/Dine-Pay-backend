package dinepay.group.dinepaybackend.Repository;

import dinepay.group.dinepaybackend.Entity.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity,Long> {
}
