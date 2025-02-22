package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.entity.User;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
public abstract class UserService<T extends User> {

private final UserRepository<T> userRepository;

    Optional<T> checkUniqueNationalCodeForUpdate(Long nationalCode, Long id) {
        Optional<T> byNationalCode = userRepository.findByNationalCodeAndIdNot(nationalCode, id);

        if (byNationalCode.isPresent()) {
            throw new ConflictException("Professor national code already exists");
        }

        return byNationalCode;
    }

     Optional<T> checkUniqueUsernameForUpdate(String username, Long id) {
        Optional<T> byUsername = userRepository.findByUsernameAndIdNot(username, id);
        if (byUsername.isPresent()) {
            throw new ConflictException("Professor username already exists");
        }

        return byUsername;
    }


     Optional<T> checkUniqueNationalCode(Long nationalCode) {
        Optional<T> byNationalCode = userRepository.findByNationalCode(nationalCode);

        if (byNationalCode.isPresent()) {
            throw new ConflictException("Professor national code already exists");
        }

        return byNationalCode;
    }

     Optional<T> checkUniqueUsername(String username) {
        Optional<T> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            throw new ConflictException("Professor username already exists");
        }

        return byUsername;
    }

}
