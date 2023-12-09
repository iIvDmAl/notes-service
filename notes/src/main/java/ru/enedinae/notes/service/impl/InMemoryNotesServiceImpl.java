package ru.enedinae.notes.service.impl;

import ru.enedinae.notes.model.Note;
import ru.enedinae.notes.model.NotesIdsGenerator;
import ru.enedinae.notes.service.NotesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InMemoryNotesServiceImpl implements NotesService {
    private final List<Note> notes = new ArrayList<>();

    public Note createNote(String name, String desc, String deadLine) {
        Note note = new Note(name,desc,deadLine);
        note.setId(NotesIdsGenerator.getInstance().generateId());
        notes.add(note);
        return note;
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Optional<Note> getNoteById(Integer id) {
        return notes.stream().filter(note -> Objects.equals(note.getId(), id)).findFirst();
    }

    public List<Note> getNoteByName(String name) {
        List<Note> newNotes = new ArrayList<>();
        newNotes.add((Note) notes.stream().filter(note -> Objects.equals(note.getName(), name)));
        return newNotes;
    }

    public boolean deleteNoteById(Integer id) {
        return notes.removeIf(note -> note.getId().equals(id));
    }

    public boolean updateNote(Note updateNote) {
        return true;
    }
}
