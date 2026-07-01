package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schneider.davi.gerenciamento_de_apiario.domain.Inspection;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.exception.NotFoundException;
import schneider.davi.gerenciamento_de_apiario.repository.InspectionRepository;

@Service
@RequiredArgsConstructor
public class InspectionService {

    private final HiveService hiveService;
    private final InspectionRepository inspectionRepository;

    @Transactional
    public Inspection saveInspection(User user, Long hiveId, Inspection inspection) {
        var hive = hiveService.findByIdAndUser(hiveId, user);

        inspection.setHive(hive);

        return inspectionRepository.save(inspection);
    }

    @Transactional(readOnly = true)
    public Inspection findByIdAndUser(Long id, User user) {
        return inspectionRepository.findByIdAndHive_Apiary_User(id, user).orElseThrow(() -> new NotFoundException("Inspection not found"));
    }

    @Transactional
    public void deleteById(User user, Long id) {
        var inspection = findByIdAndUser(id, user);
        inspectionRepository.delete(inspection);
    }

    public Page<Inspection> findAllInspection(User user, Long hiveId, Pageable pageable) {
        return inspectionRepository.findAllByHive_IdAndHive_Apiary_User(hiveId, user, pageable);
    }
}
