package schneider.davi.gerenciamento_de_apiario.dto.request;

import java.time.LocalDate;

public record InspectionPostRequest(
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
