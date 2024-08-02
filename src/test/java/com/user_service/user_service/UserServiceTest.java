package com.user_service.user_service;

import com.user_service.user_service.model.User;
import com.user_service.user_service.repository.UserRepository;
import com.user_service.user_service.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void addUser_Success() {
        User user = createUser();
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User savedUser = userService.addUser(user);
        assertUser(savedUser);
    }

    private User createUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");
        user.setRole("ROLE_USER");
        return user;
    }

    private void assertUser(User user) {
        Assertions.assertNotNull(user);
        Assertions.assertEquals("testUser", user.getUsername());
    }
}
