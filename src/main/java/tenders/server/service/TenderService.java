package tenders.server.service;

import tenders.server.dto.ChangeFavouriteTenderDto;
import tenders.server.dto.TenderDto;

import java.util.List;

public interface TenderService {
  List<TenderDto> getTenders();
  TenderDto getExactTender(String id);
  List<TenderDto> getFavouriteTenders();
  TenderDto changeFavouriteTender(ChangeFavouriteTenderDto changeFavouriteTenderDto);
}
