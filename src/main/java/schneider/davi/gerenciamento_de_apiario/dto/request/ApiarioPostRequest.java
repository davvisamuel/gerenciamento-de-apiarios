package schneider.davi.gerenciamento_de_apiario.dto.request;

import jakarta.validation.constraints.*;

public record ApiarioPostRequest(
        @NotBlank(message = "O nome do apiário é obrigatório")
        @Size(max = 100, message = "O nome do apiário deve ter no máximo 100 caracteres")
        String apiaryName,

        @NotBlank(message = "A cidade é obrigatória")
        @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres")
        String city,

        @NotBlank(message = "O número de registro é obrigatório")
        String registrationNumber,

        @NotBlank(message = "O registro territorial é obrigatório")
        String territoryRegistration,

        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String description,

        @NotNull(message = "A longitude é obrigatória")
        @DecimalMin(value = "-180.0", message = "A longitude deve ser maior ou igual a -180")
        @DecimalMax(value = "180.0", message = "A longitude deve ser menor ou igual a 180")
        Double longitude,

        @NotNull(message = "A latitude é obrigatória")
        @DecimalMin(value = "-90.0", message = "A latitude deve ser maior ou igual a -90")
        @DecimalMax(value = "90.0", message = "A latitude deve ser menor ou igual a 90")
        Double latitude
) {
}
