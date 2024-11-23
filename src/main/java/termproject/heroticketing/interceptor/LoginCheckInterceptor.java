package termproject.heroticketing.interceptor;

import static termproject.heroticketing.constant.SessionConst.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import termproject.heroticketing.constant.SessionConst;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute(LOGIN_MEMBER.getMessage()) == null) {
            log.info("미인증 사용자 요청");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
