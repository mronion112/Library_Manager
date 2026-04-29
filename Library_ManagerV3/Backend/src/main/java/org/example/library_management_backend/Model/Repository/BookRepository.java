package org.example.library_management_backend.Model.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.library_management_backend.Model.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Book")
public interface BookRepository extends JpaRepository<Book, Integer>
{

}
