package ru.enedinae.notes.mapper;

import ru.enedinae.notes.enumeration.NoteStatus;
import ru.enedinae.notes.model.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteMapper {

    public List<Note> map(ResultSet resultSet) {
        List<Note> notes = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setName(resultSet.getString("name"));
                note.setStatus(NoteStatus.valueOf(resultSet.getString("status")));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return notes;
    }
}
