package tenders.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tenders.server.dto.FeedbackDto;
import tenders.server.service.FeedbackService;

@RestController
@RequiredArgsConstructor
public class FeedbackController {
  private final FeedbackService feedbackService;

  @PostMapping("/feedback")
  public ResponseEntity<FeedbackDto> saveFeedback(@RequestBody FeedbackDto feedbackDto) {
    return ResponseEntity.ok(feedbackService.saveFeedback(feedbackDto));
  }
}
