package schneider.davi.gerenciamento_de_apiario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.ApiarioPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.request.HivePostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioPostResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.HiveGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.HivePostResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.ApiarioMapper;
import schneider.davi.gerenciamento_de_apiario.mapper.HiveMapper;
import schneider.davi.gerenciamento_de_apiario.service.ApiarioService;

import java.util.List;

@RestController
@RequestMapping("/v1/apiaries")
@RequiredArgsConstructor
public class ApiarioController {

    private final ApiarioService apiarioService;
    private final ApiarioMapper apiarioMapper;
    private final HiveMapper hiveMapper;

    @PostMapping
    public ResponseEntity<ApiarioPostResponse> save(@AuthenticationPrincipal User user, @RequestBody ApiarioPostRequest apiarioPostRequest) {
        var apiario = apiarioMapper.toApiario(user, apiarioPostRequest);

        var savedApiario = apiarioService.save(apiario);

        var apiarioPostResponse = apiarioMapper.toApiarioPostResponse(savedApiario);

        return ResponseEntity.status(HttpStatus.CREATED).body(apiarioPostResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        apiarioService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ApiarioGetResponse>> findAll(@AuthenticationPrincipal User user, Pageable pageable) {
        var apiarios = apiarioService.findAll(user, pageable);

        var apiarioGetResponseList = apiarios.stream().map(apiarioMapper::toApiarioGetResponse).toList();

        return ResponseEntity.ok(apiarioGetResponseList);
    }

    @GetMapping("/{apiaryId}/hives")
    public ResponseEntity<List<HiveGetResponse>> findAllHives(@AuthenticationPrincipal User user, @PathVariable Long apiaryId, Pageable pageable) {
        var hiveList = apiarioService.findAllHives(user, apiaryId, pageable);

        var hiveGetResponseList = hiveList.stream().map(hiveMapper::toHiveGetResponse).toList();

        return ResponseEntity.ok(hiveGetResponseList);

    }

    @PostMapping("/{apiaryId}/hives")
    public ResponseEntity<HivePostResponse> saveHive(@AuthenticationPrincipal User user, @PathVariable Long apiaryId, @RequestBody HivePostRequest hivePostRequest) {
        var hive = hiveMapper.toHive(hivePostRequest);

        var savedHive = apiarioService.saveHive(user, apiaryId, hive);

        var hivePostResponse = hiveMapper.toHivePostResponse(savedHive);

        return ResponseEntity.status(HttpStatus.CREATED).body(hivePostResponse);
    }
}
