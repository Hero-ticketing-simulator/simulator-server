package termproject.heroticketing.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SessionConst {
    LOGIN_MEMBER("loginMember")
    ;
    private final String message;
}
