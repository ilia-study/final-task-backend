package tenders.server.service;

import org.springframework.security.core.userdetails.UserDetails;
import tenders.server.dto.UserDto;

public interface UserService {
  void register(UserDto userDto);
  String login(UserDto userDto);

  UserDetails find(String login);
}
