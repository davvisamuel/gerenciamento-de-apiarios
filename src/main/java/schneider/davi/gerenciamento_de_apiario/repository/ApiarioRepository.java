package schneider.davi.gerenciamento_de_apiario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiarioRepository extends JpaRepository<Apiario, Long> {

    void deleteByIdAndUser(Long id, User user);

    Optional<Apiario> findByIdAndUser(Long id, User user);

    Page<Apiario> findAllByUser(User user, Pageable pageable);
}
