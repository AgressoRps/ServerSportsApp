package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.UserFirebase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserFirebaseRepository extends JpaRepository<UserFirebase, Long> {

    Optional<UserFirebase> findById(Long id);

    Optional<UserFirebase> findByUid(String uid);

    Optional<UserFirebase> findByEmail(String email);

    List<UserFirebase> findAll();


}
