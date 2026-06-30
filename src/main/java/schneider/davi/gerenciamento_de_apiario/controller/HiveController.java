package schneider.davi.gerenciamento_de_apiario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import schneider.davi.gerenciamento_de_apiario.domain.Inspection;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.InspectionPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionPostResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.InspectionMapper;
import schneider.davi.gerenciamento_de_apiario.service.HiveService;
import schneider.davi.gerenciamento_de_apiario.service.InspectionService;

@RestController
@RequestMapping("/v1/hives")
@RequiredArgsConstructor
public class HiveController {

    private final HiveService hiveService;
    private final InspectionService inspectionService;
    private final InspectionMapper inspectionMapper;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        hiveService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{hiveId}/inspection")
    public ResponseEntity<InspectionPostResponse> saveInspection(@AuthenticationPrincipal User user,
                                                                 @PathVariable Long hiveId,
                                                                 @RequestBody InspectionPostRequest inspectionPostRequest) {


        var inspection = inspectionMapper.toInspection(inspectionPostRequest);

        var savedInspection = inspectionService.saveInspection(user, hiveId, inspection);

        var inspectionPostResponse = inspectionMapper.toInspectionPostResponse(savedInspection);

        return ResponseEntity.status(HttpStatus.CREATED).body(inspectionPostResponse);
    }
}
