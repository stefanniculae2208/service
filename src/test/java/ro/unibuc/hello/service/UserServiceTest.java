package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unibuc.hello.data.InformationEntity;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.data.UserEntity;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.dto.UserDto;
import ro.unibuc.hello.data.UserRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class HelloWorldServiceTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserService userService = new UserService();

    @Test
    void test_hello_returnsGreeting(){
        // Arrange
        String name = "Stefan";

        // Act
        UserEntity userEnt = userService.getUser(name);

        // Assert
        Assertions.assertEquals("Stefan", userEnt.getName());
        Assertions.assertEquals("stefan@mail.com", userEnt.getEmail());
        Assertions.assertEquals("Brasov", userEnt.getAddress());
        Assertions.assertEquals("074 888 943", userEnt.getPhone());
    }


}