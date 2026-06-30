package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.Hive;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.repository.ApiarioRepository;
import schneider.davi.gerenciamento_de_apiario.repository.HiveRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiarioService {

    private final ApiarioRepository apiarioRepository;
    private final HiveRepository hiveRepository;

    @Transactional
    public Apiario save(Apiario apiario) {
        return apiarioRepository.save(apiario);
    }

    @Transactional
    public void deleteById(User user, Long id) {
        apiarioRepository.deleteByIdAndUser(id, user);
    }

    @Transactional(readOnly = true)
    public Page<Apiario> findAll(User user, Pageable pageable) {
        return apiarioRepository.findAllByUser(user, pageable);
    }

    @Transactional(readOnly = true)
    public Apiario findById(User user, Long id) {
        return apiarioRepository.findByIdAndUser(id, user).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Page<Hive> findAllHives(User user, Long apiaryId, Pageable pageable) {
        var apiary = findById(user, apiaryId);

        return hiveRepository.findAllByApiary(apiary, pageable);
    }

    @Transactional
    public Hive saveHive(User user, Long apiaryId, Hive hive) {
        var apiary = findById(user, apiaryId);

        hive.setApiary(apiary);

        return hiveRepository.save(hive);
    }
}
