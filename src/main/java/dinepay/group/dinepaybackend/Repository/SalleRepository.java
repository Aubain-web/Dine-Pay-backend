package dinepay.group.dinepaybackend.Repository;

import dinepay.group.dinepaybackend.Entity.SalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<SalleEntity, Long> {
}
