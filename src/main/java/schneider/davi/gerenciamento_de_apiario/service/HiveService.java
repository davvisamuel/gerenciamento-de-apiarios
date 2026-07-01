package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schneider.davi.gerenciamento_de_apiario.domain.Hive;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.exception.NotFoundException;
import schneider.davi.gerenciamento_de_apiario.repository.HiveRepository;

@Service
@RequiredArgsConstructor
public class HiveService {

    private final HiveRepository hiveRepository;

    @Transactional
    public void deleteById(User user, Long id) {
        var hive = findByIdAndUser(id, user);
        hiveRepository.delete(hive);
    }

    public Hive findByIdAndUser(Long id, User user) {
        return hiveRepository.findByIdAndApiary_User(id, user).orElseThrow(() -> new NotFoundException("Hive not found"));
    }
}
