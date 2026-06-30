package schneider.davi.gerenciamento_de_apiario.dto.request;

public record ApiarioPostRequest(
        String apiaryName,

        String city,

        String registrationNumber,

        String territoryRegistration,

        String description,

        Double longitude,

        Double latitude
) {
}
