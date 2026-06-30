package schneider.davi.gerenciamento_de_apiario.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.User;

import java.util.List;

public interface ApiarioRepository extends JpaRepository<Apiario, Long> {

    void deleteByIdAndUser(User user, Long id);

    List<Apiario> findAllByUser(User user, Pageable pageable);
}
