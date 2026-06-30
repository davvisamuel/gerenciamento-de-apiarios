package schneider.davi.gerenciamento_de_apiario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import schneider.davi.gerenciamento_de_apiario.domain.Inspection;
import schneider.davi.gerenciamento_de_apiario.domain.User;

import java.util.Optional;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {

    Optional<Inspection> findByIdAndHive_Apiary_User(Long id, User user);

    Page<Inspection> findAllByHive_IdAndHive_Apiary_User(Long hiveId, User user, Pageable pageable);
}
