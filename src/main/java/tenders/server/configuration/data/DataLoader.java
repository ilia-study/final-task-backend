package tenders.server.configuration.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tenders.server.repository.TenderRepository;
import tenders.server.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
  private final TenderRepository tenderRepository;
  private final UserRepository userRepository;

  public void run(ApplicationArguments args) {
    tenderRepository.saveAll(InitialData.TENDERS);
    userRepository.saveAll(InitialData.USERS);
  }
}
