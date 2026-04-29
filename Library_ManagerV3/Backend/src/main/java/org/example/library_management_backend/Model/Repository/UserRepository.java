package org.example.library_management_backend.Model.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.library_management_backend.Model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("User")
//@Transactional

public interface UserRepository extends JpaRepository<User, Integer>
{


    Optional<Object> findByUserName(String username);
}
