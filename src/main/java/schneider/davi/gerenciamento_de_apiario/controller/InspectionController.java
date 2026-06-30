package schneider.davi.gerenciamento_de_apiario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.InspectionPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionPostResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.InspectionMapper;
import schneider.davi.gerenciamento_de_apiario.service.InspectionService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;
    private final InspectionMapper inspectionMapper;

    @DeleteMapping("/inspections/{id}")
    public ResponseEntity<Void> delete(@AuthenticationPrincipal User user, @PathVariable Long id) {
        inspectionService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hives/{hiveId}/inspections")
    public ResponseEntity<Page<InspectionGetResponse>> findAllInspections(@AuthenticationPrincipal User user, @PathVariable Long hiveId, Pageable pageable) {
        var inspectionPage = inspectionService.findAllInspection(user, hiveId, pageable);

        var inspectionGetResponsePage = inspectionPage.map(inspectionMapper::toInspectionGetResponse);

        return ResponseEntity.ok(inspectionGetResponsePage);
    }

    @PostMapping("/hives/{hiveId}/inspection")
    public ResponseEntity<InspectionPostResponse> saveInspection(@AuthenticationPrincipal User user,
                                                                  @PathVariable Long hiveId,
                                                                  @RequestBody InspectionPostRequest inspectionPostRequest) {

        var inspection = inspectionMapper.toInspection(inspectionPostRequest);

        var savedInspection = inspectionService.saveInspection(user, hiveId, inspection);

        var inspectionPostResponse = inspectionMapper.toInspectionPostResponse(savedInspection);

        return ResponseEntity.status(HttpStatus.CREATED).body(inspectionPostResponse);
    }
}
