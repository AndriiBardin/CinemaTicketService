package cinema.dto;

import cinema.model.Role;
import cinema.security.EmailValidation;
import cinema.security.PasswordValidation;
import javax.validation.constraints.NotNull;

@PasswordValidation(field = "password", fieldRepeat = "repeatPassword")
public class UserRequestDto {
    @EmailValidation
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;
    @NotNull
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
