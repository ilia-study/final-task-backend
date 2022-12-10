package tenders.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import tenders.server.dto.ChangeFavouriteTenderDto;
import tenders.server.dto.TenderDto;
import tenders.server.mapper.TenderMapper;
import tenders.server.model.Tender;
import tenders.server.repository.TenderRepository;
import tenders.server.service.TenderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenderServiceImpl implements TenderService {
  private final TenderMapper tenderMapper;
  private final TenderRepository tenderRepository;

  @Override
  public List<TenderDto> getTenders() {
    String login = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

    return tenderMapper.toDtoList(tenderRepository.findAllByLogin(login));
  }

  @Override
  public TenderDto getExactTender(String id) {
    String login = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

    return tenderMapper.toDto(tenderRepository.findByLoginAndId(login, id)
      .orElseThrow(() -> new RuntimeException("Не найден экземлпяр тендера с id = " + id)));
  }

  @Override
  public List<TenderDto> getFavouriteTenders() {
    String login = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

    return tenderMapper.toDtoList(tenderRepository.findAllByLoginAndFavouriteIsTrue(login));
  }

  @Override
  public TenderDto changeFavouriteTender(ChangeFavouriteTenderDto changeFavouriteTenderDto) {
    String login = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

    Tender tender = tenderRepository.findByLoginAndId(login, changeFavouriteTenderDto.getId())
      .orElseThrow(() -> new RuntimeException("Не найден экземлпяр тендера с id = " + changeFavouriteTenderDto.getId()));
    tender.setFavourite(changeFavouriteTenderDto.isFavourite());

    return tenderMapper.toDto(tenderRepository.save(tender));
  }
}
