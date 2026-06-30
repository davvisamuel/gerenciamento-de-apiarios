package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Apiario;
import schneider.davi.gerenciamento_de_apiario.domain.Inspection;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.dto.request.ApiarioPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.request.InspectionPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.ApiarioPostResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionPostResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InspectionMapper {

    Inspection toInspection(InspectionPostRequest inspectionPostRequest);

    InspectionPostResponse toInspectionPostResponse(Inspection inspection);

    InspectionGetResponse toInspectionGetResponse(Inspection inspection);
}
