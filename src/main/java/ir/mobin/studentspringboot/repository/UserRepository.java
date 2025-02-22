package ir.mobin.studentspringboot.repository;

import ir.mobin.studentspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByUsername(String username);
    Optional<T> findByNationalCode(Long nationalCode);

    Optional<T> findByUsernameAndIdNot(String username, Long id);
    Optional<T> findByNationalCodeAndIdNot(Long nationalCode, Long id);

}
