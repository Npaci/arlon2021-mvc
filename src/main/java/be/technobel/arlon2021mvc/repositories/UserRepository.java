package be.technobel.arlon2021mvc.repositories;

import be.technobel.arlon2021mvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
