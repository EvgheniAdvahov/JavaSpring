package ru.gb.hw5_note.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw5_note.model.Note;
import ru.gb.hw5_note.model.Status;
import ru.gb.hw5_note.service.NoteService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note) {
        note.setCreatedAt(new Date());
        noteService.addNote(note);
    }

    @PostMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @GetMapping("findstatus/{status}")
    public List<Note> getNotesByStatus(@PathVariable String status) {
        if (status.equals("NOT_STARTED") || status.equals("IN_PROGRESS") || status.equals("COMPLETED")) {
            return noteService.findNotesByStatus(Status.valueOf(status));
        } else {
            throw new IllegalArgumentException("Статус не существует: " + status);
        }
    }

    @PostMapping("updatestatus")
    public void updateStatus(@RequestParam Long id, @RequestParam String status) {
        if (status.equals("NOT_STARTED") || status.equals("IN_PROGRESS") || status.equals("COMPLETED")) {
            if (noteService.findNoteById(id) != null) {
                noteService.updateByID(id, Status.valueOf(status));
            } else {
                throw new IllegalArgumentException("Id не существует: " + id);
            }
        } else {
            throw new IllegalArgumentException("Статус не существует: " + status);
        }


    }


}
