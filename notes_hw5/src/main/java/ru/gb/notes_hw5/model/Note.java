package ru.gb.notes_hw5.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private myStatus status;

    private Date createdAt;

    private enum myStatus {
        NOT_STARTED("не начата"),
        IN_PROGRESS("в процессе"),
        COMPLETED("завершена");

        private final String noteDescription;

        myStatus(String noteDescription){
            this.noteDescription = noteDescription;
        }

        public String getNoteDescription() {
            return noteDescription;
        }

    }
    public void changeStatus(String newStatus) {
        switch (newStatus.toLowerCase()) {
            case "не начата":
                this.status = myStatus.NOT_STARTED;
                break;
            case "в процессе":
                this.status = myStatus.IN_PROGRESS;
                break;
            case "завершена":
                this.status = myStatus.COMPLETED;
                break;
            default:
                throw new IllegalArgumentException("Статус не существует: " + newStatus);
        }
    }
}
