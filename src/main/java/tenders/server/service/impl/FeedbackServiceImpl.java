package tenders.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tenders.server.dto.FeedbackDto;
import tenders.server.mapper.FeedbackMapper;
import tenders.server.repository.FeedbackRepository;
import tenders.server.service.FeedbackService;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
  private final FeedbackMapper feedbackMapper;
  private final FeedbackRepository feedbackRepository;

  @Override
  public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
    return feedbackMapper.toDto(feedbackRepository.save(feedbackMapper.toEntity(feedbackDto)));
  }
}
