package termproject.heroticketing.reservation.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.member.repository.MemberRepository;
import termproject.heroticketing.member.service.MemberService;
import termproject.heroticketing.performance.repository.PerformanceRepository;
import termproject.heroticketing.reservation.dto.ReservationRequest;
import termproject.heroticketing.seat.model.Seat;
import termproject.heroticketing.seat.repository.SeatRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final PerformanceRepository performanceRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public boolean reserveSeat(Long memberId, List<ReservationRequest> reservations) {
        Member member = memberRepository.findById(memberId).get();
        if (member == null || reservations == null || reservations.isEmpty()) {
            return false;
        }
        for (ReservationRequest reservation : reservations) {
            Seat reservationSeat = Seat.builder()
                    .seatNum(reservation.getSeatNum())
                    .type(reservation.getType())
                    .build();
            Seat reservedSeat = seatRepository.findBySeatNum(reservation.getSeatNum());
            member.addSeat(reservedSeat);
        }
        return true;
    }
}
