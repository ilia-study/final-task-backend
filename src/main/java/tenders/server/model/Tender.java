package tenders.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "tenders")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tender {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "expiration", nullable = false)
  private String expiration;

  @Column(name = "price", nullable = false)
  private String price;

  @Column(name = "region", nullable = false)
  private String region;

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "favourite", nullable = false)
  private boolean favourite;
}
