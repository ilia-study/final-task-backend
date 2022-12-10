package tenders.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import tenders.server.dto.TenderDto;
import tenders.server.mapper.TenderMapper;
import tenders.server.repository.TenderRepository;
import tenders.server.service.SearchService;
import tenders.server.utils.Utils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
  private final TenderMapper tenderMapper;
  private final TenderRepository tenderRepository;
  @Override
  public List<TenderDto> searchTenders(String name) {
    String login = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

    return tenderMapper.toDtoList(tenderRepository.findAllByLoginAndNameLikeIgnoreCase(login, Utils.wrapStringLikeExpression(name)));
  }
}
