package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> AllUser() {
        return entityManager.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByName(String name) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.name = :name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.email = :email", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.remove(findUserById(id));
    }
}