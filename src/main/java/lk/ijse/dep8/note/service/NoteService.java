package lk.ijse.dep8.note.service;

import lk.ijse.dep8.note.dto.NoteDTO;
import lk.ijse.dep8.note.service.exception.NotFoundException;

import java.util.List;

public interface NoteService {

    NoteDTO saveNote(NoteDTO note) throws NotFoundException;

    void deleteNote(String userId, int noteId) throws NotFoundException;

    List<NoteDTO> getAllNotes(String userId);

}
