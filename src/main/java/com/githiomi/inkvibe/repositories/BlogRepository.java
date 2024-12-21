package com.githiomi.inkvibe.repositories;

import com.githiomi.inkvibe.data.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {

    @Query("SELECT b FROM Blog b WHERE b.author = :username")
    List<Blog> findBlogsByUsername(@Param("username") String username);
}
