package tenders.server.service;

import tenders.server.dto.TenderDto;

import java.util.List;

public interface SearchService {
  List<TenderDto> searchTenders(String name);
}