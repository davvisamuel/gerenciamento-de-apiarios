package schneider.davi.gerenciamento_de_apiario.dto.response;

public record HiveGetResponse(
        Long id,

        String name,

        String frameType,

        String colonyOrigin,

        Integer boxCount,

        QueenResponse queen
) {
}
