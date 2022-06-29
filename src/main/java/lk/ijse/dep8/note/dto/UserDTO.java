package lk.ijse.dep8.note.dto;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    @Null(message = "Id cannot be set")
    private String id;
    @Email(message = "Invalid Email")
    @NotNull(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "password cannot be empty")
    @Length(min = 6, message = "Password should be at least 6 characters long")
    private String password;
    @NotNull(message = "Full name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name")
    private String fullName;
}
