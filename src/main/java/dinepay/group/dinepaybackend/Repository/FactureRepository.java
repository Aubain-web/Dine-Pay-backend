package dinepay.group.dinepaybackend.Repository;

import dinepay.group.dinepaybackend.Entity.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {

    public List<FactureEntity> findFactureEntitiesByTableEntityId(long tableId);
    Optional<FactureEntity> findByDateCreation(Date date);
}
