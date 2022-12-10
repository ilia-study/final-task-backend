package tenders.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tenders.server.model.Tender;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenderRepository extends JpaRepository<Tender, String> {
  Optional<Tender> findByLoginAndId(String login, String id);
  List<Tender> findAllByLogin(String login);
  List<Tender> findAllByLoginAndFavouriteIsTrue(String login);
  List<Tender> findAllByLoginAndNameLikeIgnoreCase(String login, String name);
}
