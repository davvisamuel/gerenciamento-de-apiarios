package schneider.davi.gerenciamento_de_apiario.dto.request;

public record HivePostRequest(
        String name,

        String frameType,

        String colonyOrigin,

        Integer boxCount,

        QueenRequest queenRequest
) {
}
