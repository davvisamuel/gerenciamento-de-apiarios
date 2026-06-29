package schneider.davi.gerenciamento_de_apiario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import schneider.davi.gerenciamento_de_apiario.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}
