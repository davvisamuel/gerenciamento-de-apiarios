package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Hive;
import schneider.davi.gerenciamento_de_apiario.dto.request.HivePostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.HiveGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.HivePostResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = QueenMapper.class)
public interface HiveMapper {

    @Mapping(target = "queen", source = "queenRequest")
    Hive toHive(HivePostRequest hivePostRequest);

    HivePostResponse toHivePostResponse(Hive hive);

    HiveGetResponse toHiveGetResponse(Hive hive);
}
