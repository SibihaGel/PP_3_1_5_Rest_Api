package ru.kata.spring.boot_security.demo.initUsers;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class IniyUsers {

    private final UserService userService;

    public IniyUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void iniy() {

        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        userService.saveRole(admin);
        userService.saveRole(user);

        userService.saveUser(new User(
                "sergey",
                "sibiha@mail.ru",
                "Casella2011",
                List.of(admin, user)));
        userService.saveUser(new User(
                "Gulnara",
                "gulena@mail.ru",
                "Casella",
                List.of(user)));
    }
}
