package schneider.davi.gerenciamento_de_apiario.dto.response;

public record ApiarioGetResponse(
        Long id,

        String apiaryName,

        String city,

        String registrationNumber,

        String territoryRegistration,

        String description,

        Double longitude,

        Double latitude
) {
}
