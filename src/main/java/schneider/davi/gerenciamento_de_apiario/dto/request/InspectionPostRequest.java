package schneider.davi.gerenciamento_de_apiario.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record InspectionPostRequest(
        @NotNull(message = "A data da inspeção é obrigatória")
        @PastOrPresent(message = "A data da inspeção não pode estar no futuro")
        LocalDate inspectionDate,

        @NotNull(message = "É obrigatório informar se a rainha foi vista")
        Boolean queenSeen,

        @NotNull(message = "É obrigatório informar se ovos foram vistos")
        Boolean eggsSeen,

        @NotNull(message = "É obrigatório informar se células de rainha foram vistas")
        Boolean queenCellsSeen,

        @NotNull(message = "É obrigatório informar se a colônia está órfã")
        Boolean queenless,

        @NotBlank(message = "O padrão de postura da cria é obrigatório")
        String broodPattern,

        @NotBlank(message = "A força da colônia é obrigatória")
        String colonyStrength,

        @Size(max = 1000, message = "As observações devem ter no máximo 1000 caracteres")
        String observations
) {
}
