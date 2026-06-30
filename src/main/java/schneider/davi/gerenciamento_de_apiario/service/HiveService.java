package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.repository.HiveRepository;

@Service
@RequiredArgsConstructor
public class HiveService {

    private final ApiarioService apiarioService;
    private final HiveRepository hiveRepository;

    @Transactional
    public void deleteById(User user, Long id) {
        hiveRepository.findByIdAndApiary_User(id, user);
    }

}
