package lk.ijse.dep8.note.api;

import lk.ijse.dep8.note.dto.NoteDTO;
import lk.ijse.dep8.note.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users/{userId:[A-Fa-f0-9-]{36}}/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public NoteDTO addNote(@PathVariable String userId, @RequestBody @Valid NoteDTO note, Errors errors) {
        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }
        if (!userId.equals(note.getUserId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User id mismatch");
        return noteService.saveNote(note);
    }

    @GetMapping(produces = "application/json")
    public List<NoteDTO> getAllNotes(@PathVariable String userId) {
        return noteService.getAllNotes(userId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{noteId:\\d+}")
    public void deleteNote(@PathVariable String userId, @PathVariable int noteId) {
        noteService.deleteNote(userId, noteId);
    }
}
