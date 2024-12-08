package termproject.heroticketing.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import termproject.heroticketing.seat.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    public Seat findBySeatNum(String seatNum);
}
