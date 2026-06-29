package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Role;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.AuthRegisterRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.AuthRegisterResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = Role.class)
public interface UserMapper {

    @Mapping(target = "role", expression = "java(Role.USER)")
    User toUser(AuthRegisterRequest authRegisterRequest);

    AuthRegisterResponse toUserPostResponse(User user);
}
