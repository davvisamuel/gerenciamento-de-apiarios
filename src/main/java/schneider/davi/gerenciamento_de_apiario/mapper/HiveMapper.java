package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Hive;
import schneider.davi.gerenciamento_de_apiario.dto.request.HivePostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.HiveGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.HivePostResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HiveMapper {

    Hive toHive(HivePostRequest hivePostRequest);

    HivePostResponse toHivePostResponse(Hive hive);

    HiveGetResponse toHiveGetResponse(Hive hive);
}
