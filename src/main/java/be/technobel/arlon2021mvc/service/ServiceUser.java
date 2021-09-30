package be.technobel.arlon2021mvc.service;

import be.technobel.arlon2021mvc.entities.User;

import java.util.List;
import java.util.Optional;

public interface ServiceUser {
    List<User> findAll();
    Optional<User> findOneById(Long id);
    User updateOne(Long id, User user);
    User insert(User user);
};
