package schneider.davi.gerenciamento_de_apiario.dto.response;

import java.time.LocalDate;

public record QueenResponse(
        String identificationNumber,

        String origin,

        String breed,

        String color,

        LocalDate birthDat
) {
}
