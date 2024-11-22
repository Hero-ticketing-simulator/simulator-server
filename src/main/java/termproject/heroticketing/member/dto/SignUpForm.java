package termproject.heroticketing.member.dto;

import lombok.Data;

@Data
public class SignUpForm {
    private String username;
    private String password;
    private String role;
}
