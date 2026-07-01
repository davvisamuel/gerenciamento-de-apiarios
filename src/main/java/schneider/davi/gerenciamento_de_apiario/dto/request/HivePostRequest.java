package schneider.davi.gerenciamento_de_apiario.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record HivePostRequest(
        @NotBlank(message = "O nome da colmeia é obrigatório")
        String name,

        @NotBlank(message = "O tipo de quadro é obrigatório")
        String frameType,

        @NotBlank(message = "A origem da colônia é obrigatória")
        String colonyOrigin,

        @NotNull(message = "A quantidade de caixas é obrigatória")
        @Positive(message = "A quantidade de caixas deve ser maior que zero")
        Integer boxCount,

        @Valid
        @NotNull(message = "Os dados da rainha são obrigatórios")
        QueenRequest queenRequest
) {
}
