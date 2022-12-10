package tenders.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenderDto {
  private String id;
  private String name;
  private String description;
  private String expiration;
  private String price;
  private String region;
  private String login;
  private boolean favourite;
}
