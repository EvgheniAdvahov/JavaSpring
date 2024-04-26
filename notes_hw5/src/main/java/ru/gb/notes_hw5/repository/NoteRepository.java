package ru.gb.notes_hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.notes_hw5.model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    @Query("SELECT n FROM Note n WHERE n.status = :status")
    List<Note> findNotesByStatus(String status);

}
