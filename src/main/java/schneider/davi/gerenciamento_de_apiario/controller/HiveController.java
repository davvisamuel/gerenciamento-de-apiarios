package schneider.davi.gerenciamento_de_apiario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.service.HiveService;

@RestController
@RequestMapping("/v1/hive")
@RequiredArgsConstructor
public class HiveController {

    private final HiveService hiveService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        hiveService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }
}
