package schneider.davi.gerenciamento_de_apiario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionGetResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.InspectionMapper;
import schneider.davi.gerenciamento_de_apiario.service.InspectionService;

@RestController
@RequestMapping("/v1/inspections")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;
    private final InspectionMapper inspectionMapper;

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> delete(@AuthenticationPrincipal User user, @PathVariable Long id) {
        inspectionService.deleteById(user, id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{hiveId}/inspections")
    public ResponseEntity<Page<InspectionGetResponse>> findAllInspections(@AuthenticationPrincipal User user, @PathVariable Long hiveId, Pageable pageable) {

        var inspectionPage = inspectionService.findAllInspection(user, hiveId, pageable);

        var inspectionGetResponsePage = inspectionPage.map(ip -> inspectionMapper.toInspectionGetResponse(ip));

        return ResponseEntity.ok(inspectionGetResponsePage);
    }

}
