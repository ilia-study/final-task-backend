package tenders.server.mapper;

import org.mapstruct.Mapper;
import tenders.server.dto.UserDto;
import tenders.server.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toEntity(UserDto userDto);
  UserDto toDto(User user);

  List<User> toEntityList(List<UserDto> userDtoList);
  List<UserDto> toDtoList(List<User> userList);
}
