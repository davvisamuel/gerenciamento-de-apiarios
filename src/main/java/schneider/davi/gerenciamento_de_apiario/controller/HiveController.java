package schneider.davi.gerenciamento_de_apiario.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import schneider.davi.gerenciamento_de_apiario.doc.HiveControllerDoc;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.HivePostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.HiveGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.HivePostResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.HiveMapper;
import schneider.davi.gerenciamento_de_apiario.service.ApiarioService;
import schneider.davi.gerenciamento_de_apiario.service.HiveService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HiveController implements HiveControllerDoc {

    private final HiveService hiveService;
    private final ApiarioService apiarioService;
    private final HiveMapper hiveMapper;

    @DeleteMapping("/hives/{id}")
    public ResponseEntity<Void> deleteById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        hiveService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/apiaries/{apiaryId}/hives")
    public ResponseEntity<Page<HiveGetResponse>> findAllHives(@AuthenticationPrincipal User user, @PathVariable Long apiaryId, Pageable pageable) {
        var hivePage = apiarioService.findAllHives(user, apiaryId, pageable);

        var hiveGetResponsePage = hivePage.map(hiveMapper::toHiveGetResponse);

        return ResponseEntity.ok(hiveGetResponsePage);
    }

    @PostMapping("/apiaries/{apiaryId}/hives")
    public ResponseEntity<HivePostResponse> saveHive(@AuthenticationPrincipal User user, @PathVariable Long apiaryId, @RequestBody @Valid HivePostRequest hivePostRequest) {
        var hive = hiveMapper.toHive(hivePostRequest);

        var savedHive = apiarioService.saveHive(user, apiaryId, hive);

        var hivePostResponse = hiveMapper.toHivePostResponse(savedHive);

        return ResponseEntity.status(HttpStatus.CREATED).body(hivePostResponse);
    }
}
