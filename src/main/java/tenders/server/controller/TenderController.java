package tenders.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tenders.server.dto.ChangeFavouriteTenderDto;
import tenders.server.dto.TenderDto;
import tenders.server.service.TenderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TenderController {
  private final TenderService tenderService;

  @GetMapping("/tenders")
  public ResponseEntity<List<TenderDto>> getTenders() {
    return ResponseEntity.ok(tenderService.getTenders());
  }

  @GetMapping("/tenders/{id}")
  public ResponseEntity<TenderDto> getTender(@PathVariable String id){
    return ResponseEntity.ok(tenderService.getExactTender(id));
  }

  @GetMapping("/tenders/favourite")
  public ResponseEntity<List<TenderDto>> getFavouritesTenders(){
    return ResponseEntity.ok(tenderService.getFavouriteTenders());
  }

  @PatchMapping("/tenders/favourite")
  public ResponseEntity<TenderDto> changeFavouriteTender(@RequestBody ChangeFavouriteTenderDto changeFavouriteTenderDto) {
    return ResponseEntity.ok(tenderService.changeFavouriteTender(changeFavouriteTenderDto));
  }
}
