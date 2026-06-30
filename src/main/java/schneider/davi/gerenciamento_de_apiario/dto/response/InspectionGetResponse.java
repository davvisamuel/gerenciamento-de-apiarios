package schneider.davi.gerenciamento_de_apiario.dto.response;

import java.time.LocalDate;

public record InspectionGetResponse(
        Long id,

        LocalDate inspectionDate,

        Boolean queenSeen,

        Boolean eggsSeen,

        Boolean queenCellsSeen,

        Boolean queenless,

        String broodPattern,

        String colonyStrength,

        String observations
) {
}
