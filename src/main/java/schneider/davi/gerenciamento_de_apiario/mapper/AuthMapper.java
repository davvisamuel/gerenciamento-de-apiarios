package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.dto.response.AuthLoginResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthMapper {

    AuthLoginResponse toAuthLoginResponse(String token);
}
