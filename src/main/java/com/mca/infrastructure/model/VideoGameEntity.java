package com.mca.infrastructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Builder
@Getter
@Setter
@Entity(name = "VIDEOGAME")
@NoArgsConstructor
@AllArgsConstructor
public class VideoGameEntity {
    @Id
    private String id;
    @Column(name = "title")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VideoGameEntity that = (VideoGameEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
