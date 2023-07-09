package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
   List<User> AllUser();

   User findUserById(long id);

   User findUserByName(String name);
   User findUserByEmail(String email);

   void saveUser(User user);

   void updateUser(User user);

   void deleteUserById(long id);
}