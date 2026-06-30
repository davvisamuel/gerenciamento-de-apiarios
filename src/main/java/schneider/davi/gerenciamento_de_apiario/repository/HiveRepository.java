package schneider.davi.gerenciamento_de_apiario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.Hive;
import schneider.davi.gerenciamento_de_apiario.domain.User;

import java.util.Optional;

@Repository
public interface HiveRepository extends JpaRepository<Hive, Long> {

    Optional<Hive> findByIdAndApiary_User(Long id, User user);

    Page<Hive> findAllByApiary(Apiario apiary, Pageable pageable);
}
