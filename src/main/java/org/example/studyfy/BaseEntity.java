package org.example.studyfy;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @Getter
    @Comment("PK, 고유 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delete_status", nullable = false)
    @Comment("ROW 삭제 여부")
    private boolean deleteStatus;

    @Column
    @Comment("생성일")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @Comment("수정일")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void delete() {
        this.deleteStatus = true;
    }
}
