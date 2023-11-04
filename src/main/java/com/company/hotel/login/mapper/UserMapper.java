package com.company.hotel.login.mapper;

import com.company.hotel.login.dto.UserDTO;
import com.company.hotel.login.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User mapDtoToEntity(UserDTO dto);

    UserDTO mapEntityToDto(User user);

}
