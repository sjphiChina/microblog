/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sjph.life.user.impl;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjph.life.user.UserCacheHandler;
import sjph.life.user.UserService;
import sjph.life.user.database.dao.UserDao;
import sjph.life.user.dto.UserDto;
import sjph.life.user.exception.UserNotFoundException;
import sjph.life.user.model.User;

/**
 * @author shaohuiguo
 *
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired(required = true)
    private UserDao             userDao;

    @Autowired(required = true)
    private UserCacheHandler    userCacheHandler;

    @Override
    public Long createUser(User user) {
        // encodeText(post.getContent(), WebConfig.CHARACTER_ENCODING_SET);
        // Here I still use the original content, the code above is just for checking.
        long id = userDao.createUser(user);
        user.setId(id);
        UserDto userDto = new UserDto(user);
        String auth = userCacheHandler.addUser(userDto);
        LOGGER.info("Created User: " + user.toString() + " auth: " + auth);
        return user.getId();
    }

    @Override
    public UserDto findUser(String userId) throws UserNotFoundException {
        UserDto userDto = userCacheHandler.findUser(userId);
        if (userDto != null) {
            LOGGER.info("Using cache to get UserDto: " + userDto.toString());
            return userDto;
        }
        User user = userDao.findUser(Long.valueOf(userId));
        userDto = new UserDto(user);
        userCacheHandler.addUser(userDto);
        if (user != null) {
            return new UserDto(user);
        }
        throw new UserNotFoundException("Cannot find user: userId=" + userId);
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        User user = userDao.findUserByEmail(email);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("Cannot find user: email=" + email);
    }

    @Override
    public UserDto findUserByUserName(String userName) throws UserNotFoundException {
        String userId = userCacheHandler.findUserId(userName);
        UserDto userDto = userCacheHandler.findUser(String.valueOf(userId));
        if (userDto != null) {
            LOGGER.info("Using cache to get UserDto: " + userDto.toString());
            return userDto;
        }
        User user = userDao.findUserByUserName(userName);
        userDto = new UserDto(user);
        userCacheHandler.addUser(userDto);
        if (user != null) {
            return new UserDto(user);
        }
        throw new UserNotFoundException("Cannot find user: userName=" + userName);
    }

//    @Override
//    public String findUserIdByUserName(String userName) throws UserNotFoundException {
//        String userId = userCacheHandler.findUserId(userName);
//        if (userId != null) {
//            return userId;
//        }
//        User user = userDao.findUserByUserName(userName);
//        UserDto userDto = new UserDto(user);
//        userCacheHandler.addUser(userDto);
//        return String.valueOf(user.getId());
//    }

    @Override
    public boolean updateUser(User user) {
        if (userDao.updateUser(user) == 1) {
            UserDto userDto = new UserDto(user);
            userCacheHandler.addUser(userDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        if (userDao.deleteUser(Long.valueOf(userId)) == 1) {
            userCacheHandler.deleteUser(userId);
            return true;
        }
        return false;
    }
}