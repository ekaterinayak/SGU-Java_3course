package com.mirzoeva.ekaterina.ssu.internet.bank.repo;

import com.mirzoeva.ekaterina.ssu.internet.bank.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author mirzoeva.ekaterina
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
}
