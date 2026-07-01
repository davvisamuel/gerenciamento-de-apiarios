package schneider.davi.gerenciamento_de_apiario.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record QueenRequest(
        @NotBlank(message = "O número de identificação é obrigatório")
        String identificationNumber,

        @NotBlank(message = "A origem é obrigatória")
        String origin,

        @NotBlank(message = "A raça é obrigatória")
        String breed,

        @NotBlank(message = "A cor é obrigatória")
        String color,

        @NotNull(message = "A data de nascimento é obrigatória")
        @PastOrPresent(message = "A data de nascimento não pode estar no futuro")
        LocalDate birthDat
) {
}
