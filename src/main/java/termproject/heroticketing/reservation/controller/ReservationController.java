package termproject.heroticketing.reservation.controller;

import static termproject.heroticketing.constant.SessionConst.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import termproject.heroticketing.constant.SessionConst;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.reservation.dto.ReservationRequest;
import termproject.heroticketing.reservation.service.ReservationService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/add")
    public String getReservationPage(Model model) {
        return "details";
    }

    @PostMapping("/add")
    public String addReservation(@RequestParam List<ReservationRequest> reservations, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        Member sessionMember = (Member) session.getAttribute(LOGIN_MEMBER.getMessage());
        boolean reservationSuccess = reservationService.reserveSeat(sessionMember.getId(), reservations);
        if (!reservationSuccess) {
            return "details";
        }
        return "reservation-info";
    }
}
