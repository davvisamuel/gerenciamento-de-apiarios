package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Inspection;
import schneider.davi.gerenciamento_de_apiario.dto.request.InspectionPostRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionGetResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.InspectionPostResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InspectionMapper {

    Inspection toInspection(InspectionPostRequest inspectionPostRequest);

    InspectionPostResponse toInspectionPostResponse(Inspection inspection);

    InspectionGetResponse toInspectionGetResponse(Inspection inspection);
}
