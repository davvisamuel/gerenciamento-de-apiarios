package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.repository.ApiarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiarioService {

    private final ApiarioRepository apiarioRepository;

    @Transactional
    public Apiario save(Apiario apiario) {
        return apiarioRepository.save(apiario);
    }

    @Transactional
    public void deleteById(User user, Long id) {
        apiarioRepository.deleteByIdAndUser(user, id);
    }

    @Transactional(readOnly = true)
    public List<Apiario> findAll(User user, Pageable pageable) {
        return apiarioRepository.findAllByUser(user, pageable);
    }
}
