package tenders.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tenders.server.dto.UserDto;
import tenders.server.mapper.UserMapper;
import tenders.server.repository.UserRepository;
import tenders.server.service.UserService;
import tenders.server.utils.JwtUtil;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final UserRepository userRepository;

  @Override
  public String register(UserDto userDto) {
    userRepository.save(userMapper.toEntity(userDto));

    return JwtUtil.createToken(UserDto.builder().name("user").login("user").password("user").build());
  }

  @Override
  public String login(UserDto userDto) {
    UserDto user = userMapper.toDto(userRepository.findByLoginAndPassword(userDto.getLogin(), userDto.getPassword()).orElseThrow(
      () -> new RuntimeException("Не найдено пользователя" + userDto)
    ));

    return JwtUtil.createToken(user);
  }

  @Override
  public UserDetails find(String login) {
    UserDto user = userMapper.toDto(userRepository.findByLogin(login).orElseThrow(
      () -> new RuntimeException("Не найдено пользователя")
    ));

    return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
  }
}
