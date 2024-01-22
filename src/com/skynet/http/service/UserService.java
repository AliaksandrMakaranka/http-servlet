package com.skynet.http.service;

import com.skynet.http.dao.UserDao;
import com.skynet.http.dto.CreateUserDto;
import com.skynet.http.entity.User;
import com.skynet.http.exception.ValidationException;
import com.skynet.http.mapper.CreateUserMapper;
import com.skynet.http.validator.CreateUserValidator;
import com.skynet.http.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
