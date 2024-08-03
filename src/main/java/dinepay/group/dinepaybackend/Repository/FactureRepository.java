package dinepay.group.dinepaybackend.Repository;

import dinepay.group.dinepaybackend.Entity.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {
}
