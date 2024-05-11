package ru.gb.hw5_note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.hw5_note.model.Note;
import ru.gb.hw5_note.model.Status;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.status = :status")
    List<Note> findNotesByStatus(Status status);
}
