package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.ApiarioPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioPostResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiarioMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    Apiario toApiario(User user, ApiarioPostRequest apiarioPostRequest);

    ApiarioPostResponse toApiarioPostResponse(Apiario apiario);

    ApiarioGetResponse toApiarioGetResponse(Apiario apiario);
}
