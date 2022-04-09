package edu.miu.restful.entity.dto;

import edu.miu.restful.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    long id;
    String name;
    private List<Role> roles;

}
