package com.aitesting.crm;

import com.unitTesting.crm.domain.User;
import com.unitTesting.crm.repository.UserRepository;
import com.unitTesting.crm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTest {

  private UserRepository userRepository;
  private UserService userService;

  @BeforeEach
  public void setUp() {
    userRepository = Mockito.mock(UserRepository.class);
    userService = new UserService(userRepository);
  }

  @Test
  public void testGetUserName_UserExists() {
    // Arrange
    Long userId = 1L;
    User user = new User(userId, "John Doe", "0606060606", "user");
    when(userRepository.findById(userId)).thenReturn(user);

    // Act
    String result = userService.getUserName(userId);

    // Assert
    Assertions.assertEquals("John Doe", result);
  }

  @Test
  public void testGetUserName_UserDoesNotExist() {
    Long userId = 1L;
    when(userRepository.findById(userId)).thenReturn(null);

    // Act
    String result = userService.getUserName(userId);
    Assertions.assertEquals("User not found", result);

    // Comportement si l'utilisateur n'existe pas  à l'appel de userService.getUserName
  }

  @Test
  public void testCreateNewUser_ValidUser() {

    Long userId = 1L;
    User user = new User(userId, "John Doe", "0606060606", "user");
    userService.createNewUser(user);
    when(userRepository.findByPhoneNumber(user.phoneNumber)).thenReturn( null);
    doNothing().when(userRepository).save(user);
    verify(userRepository).save(user);
    // Comportement si l'utilisateur est valide à l'appel de userService.createNewUser

  }

  @Test
  public void testCreateNewUser_MissingInfo() {
    // TODO :: test à écrire
    // Comportement si l'utilisateur est incomplet à l'appel de userService.createNewUser

  }

  @Test
  public void testCreateNewUser_PhoneNumberExists() {
    // TODO :: test à écrire
    // Comportement si un utilisateur existe déjà avec le même numéro de téléphone à l'appel de userService.createNewUser
  }

  //========================= Deuxième partie : Delete a User  ============================

  @Test
  public void testDeleteUser_UserDoesNotExist() {
    // TODO :: test à écrire
    // Comportement si l'utilisateur n'existe pas à l'appel de userService.deleteUser
  }

  @Test
  public void testDeleteUser_AdminUser() {
    // TODO :: test à écrire
    // Comportement si l'utilisateur est Admin à l'appel de userService.deleteUser
  }

  @Test
  public void testDeleteUser_RegularUser() {
    // TODO :: test à écrire
    // Comportement si l'utilisateur a le rôle User à l'appel de userService.deleteUser
  }

}
