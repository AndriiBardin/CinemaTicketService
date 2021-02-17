package cinema.service.mapper;

import cinema.dto.UserResponseDto;
import cinema.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto userToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
