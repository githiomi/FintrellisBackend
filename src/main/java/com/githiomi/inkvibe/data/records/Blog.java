package com.githiomi.inkvibe.data.records;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    private UUID id;
    private String title;
    private LocalDateTime createdAt;

    public Blog() {
    }

    public Blog(UUID id, String title, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

}
