package schneider.davi.gerenciamento_de_apiario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import schneider.davi.gerenciamento_de_apiario.domain.Queen;
import schneider.davi.gerenciamento_de_apiario.dto.request.QueenRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.QueenResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QueenMapper {

    Queen toQueen(QueenRequest queenRequest);

    QueenResponse toQueenResponse(Queen queen);
}
