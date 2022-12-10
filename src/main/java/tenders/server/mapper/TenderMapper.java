package tenders.server.mapper;

import org.mapstruct.Mapper;
import tenders.server.dto.TenderDto;
import tenders.server.model.Tender;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderMapper {
  Tender toEntity(TenderDto tenderDto);
  TenderDto toDto(Tender tender);

  List<Tender> toEntityList(List<TenderDto> tenderDtoList);
  List<TenderDto> toDtoList(List<Tender> tenderList);
}
