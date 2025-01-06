package com.githiomi.inkvibe.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.githiomi.inkvibe.data.enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Slf4j
@Entity
@SuperBuilder
@Table(name = "blogs")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String author;
    private String category;
    private int likeCounter;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    public Blog(String title, String author, Category category) {
        this.title = title;
        this.author = author;
        this.likeCounter = 0;
        this.category = category.name();
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
