package com.intern.spring.repositories;

import com.intern.spring.models.Authorizations;
import com.intern.spring.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorizations, Integer> {

}
