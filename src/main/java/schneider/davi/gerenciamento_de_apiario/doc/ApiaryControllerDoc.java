package schneider.davi.gerenciamento_de_apiario.doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.ApiarioPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioPostResponse;

@Tag(
        name = "Apiaries",
        description = "Operações para cadastro, consulta e exclusão de apiarios"
)
public interface ApiaryControllerDoc {

    @Operation(
            summary = "Cadastrar apiario",
            description = "Cria um novo apiario no sistema",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Apiario cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = Error.class))
                    )
            }
    )
    ResponseEntity<ApiarioPostResponse> save(
            User user,
            @RequestBody
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados necessários para cadastrar um apiario",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ApiarioPostRequest.class),
                            examples = @ExampleObject(
                                    name = "Apiario válido",
                                    value = """
                                            {
                                              "apiaryName": "Apiário Santa Clara",
                                              "city": "Cascavel",
                                              "registrationNumber": "API-2026-001",
                                              "territoryRegistration": "TR-458721",
                                              "description": "Apiário localizado próximo a uma área de mata nativa.",
                                              "longitude": -53.4552,
                                              "latitude": -24.9558
                                            }
                                            """
                            )
                    )
            )
            ApiarioPostRequest apiarioPostRequest
    );

    @Operation(
            summary = "Deleta um apiario pelo id",
            description = "Deleta um apiario do sistema pelo id",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Apiario deletado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Apiario não encontrado"
                    )
            }
    )
    ResponseEntity<Void> deleteById(User user, @PathVariable Long id);

    @Operation(
            summary = "Lista os apiarios do usuário",
            description = "Retorna de forma paginada os apiarios cadastrados pelo usuário autenticado",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Apiarios listados com sucesso"
                    )
            }
    )
    ResponseEntity<Page<ApiarioGetResponse>> findAll(User user, Pageable pageable);

}
