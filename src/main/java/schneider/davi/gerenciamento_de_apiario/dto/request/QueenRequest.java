package schneider.davi.gerenciamento_de_apiario.dto.request;

import java.time.LocalDate;

public record QueenRequest(
        String identificationNumber,

        String origin,

        String breed,

        String color,

        LocalDate birthDat
) {
}
