package lk.ijse.dep8.note.service.util;

import lk.ijse.dep8.note.dto.NoteDTO;
import lk.ijse.dep8.note.dto.UserDTO;
import lk.ijse.dep8.note.entity.Note;
import lk.ijse.dep8.note.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOTransformer {

    private final ModelMapper mapper;

    public EntityDTOTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User getUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    public UserDTO getUserDTO(User userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }
    
    public Note getNoteEntity(NoteDTO noteDTO) {
        return mapper.map(noteDTO, Note.class);
    }
    
    public NoteDTO getNoteDTO(Note noteEntity) {
        return mapper.typeMap(Note.class, NoteDTO.class).addMapping(note -> note.getUser().getId(), NoteDTO::setUserId).map(noteEntity);
    }
}
