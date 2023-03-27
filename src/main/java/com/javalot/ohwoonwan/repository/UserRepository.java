package com.javalot.ohwoonwan.repository;

import java.util.List;

import com.javalot.ohwoonwan.model.BaseModel;
import org.springframework.data.repository.CrudRepository;
import com.javalot.ohwoonwan.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface UserRepository extends CrudRepository<User, Integer> {

    Boolean existsUserByEmail(String email);

    Boolean existsUserByPhone(String phone);

    Boolean existsUserByNickName(String nickName);

}