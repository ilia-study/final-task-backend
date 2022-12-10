package tenders.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tenders.server.dto.TenderDto;
import tenders.server.service.SearchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {
  private final SearchService searchService;

  @GetMapping("/tenders/search")
  public ResponseEntity<List<TenderDto>> searchTenders(@RequestParam String name) {
    return ResponseEntity.ok(searchService.searchTenders(name));
  }
}