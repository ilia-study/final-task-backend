package tenders.server.mapper;

import org.mapstruct.Mapper;
import tenders.server.dto.FeedbackDto;
import tenders.server.model.Feedback;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
  Feedback toEntity(FeedbackDto feedbackDto);
  FeedbackDto toDto(Feedback feedback);

  List<Feedback> toEntityList(List<FeedbackDto> feedbackDtoList);
  List<FeedbackDto> toDtoList(List<Feedback> feedbackList);
}
