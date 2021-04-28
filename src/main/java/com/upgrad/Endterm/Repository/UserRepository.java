package com.upgrad.Endterm.Repository;

import com.upgrad.Endterm.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT p FROM User p WHERE  p.Name LIKE %?1%")
    public List<User> search(String keyword);
}
