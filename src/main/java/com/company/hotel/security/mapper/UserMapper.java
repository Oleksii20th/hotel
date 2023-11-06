package com.company.hotel.security.mapper;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User mapDtoToEntity(UserDTO dto);

    UserDTO mapEntityToDto(User user);

}
