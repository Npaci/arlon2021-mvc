package be.technobel.arlon2021mvc.service;

import be.technobel.arlon2021mvc.entities.User;
import be.technobel.arlon2021mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserImpl implements ServiceUser {
    private UserRepository repository;

    @Autowired
    public ServiceUserImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updateOne(Long id, User user) {
        if (user.getId() != null) {
            return this.repository.save(user);
        }
        User u = this.repository.findById(id).get();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setCreatedAt(user.getCreatedAt());

        return this.repository.save(u);
    }

    @Override
    public User insert(User user) {
        if (user == null)
            return null;

        if(!repository.existsById(user.getId())) {
            User u = new User();
            user.setId(0L);
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setCreatedAt(user.getCreatedAt());

            return repository.save(user);
        }else
            return null;

    }


}
