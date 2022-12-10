package tenders.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tenders.server.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
