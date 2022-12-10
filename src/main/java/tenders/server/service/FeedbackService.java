package tenders.server.service;

import tenders.server.dto.FeedbackDto;

public interface FeedbackService {
  FeedbackDto saveFeedback(FeedbackDto feedbackDto);
}
