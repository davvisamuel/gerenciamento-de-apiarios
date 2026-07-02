package schneider.davi.gerenciamento_de_apiario.exception;

import lombok.Builder;

@Builder
public record ApiError(String timestamp, int status, String error, String message, String path) {
}