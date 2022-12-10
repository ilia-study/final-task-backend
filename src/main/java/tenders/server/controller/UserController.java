package tenders.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tenders.server.dto.UserDto;
import tenders.server.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/users/register")
  public void registerUser(@RequestBody UserDto userDto) {
    userService.register(userDto);
  }

  @PostMapping("/users/login")
  public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok(userService.login(userDto));
  }
}
