package lk.ijse.dep8.note.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements Serializable {
    @Null(message = "Id cannot be set")
    private Integer id;
    @NotBlank(message = "text cannot be empty")
    private String text;
    @Pattern(regexp = "[A-Fa-f0-9\\-]{36}", message = "Invalid user id")
    private String userId;
}
