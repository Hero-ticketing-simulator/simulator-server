package termproject.heroticketing.performance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.seat.model.Seat;

@Entity
@Getter
@Setter
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startPerformanceTime;
    private LocalDateTime endPerformanceTime;
    private LocalDateTime startReservationTime;
    private LocalDateTime endReservationTime;
    private Integer totalSeat;
    private Integer remainingSeat;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "performance")
    private List<Seat> seats = new ArrayList<>();

    public Performance() {
    }

    @Builder
    public Performance(String name, LocalDateTime startPerformanceTime, LocalDateTime endPerformanceTime,
                       LocalDateTime startReservationTime, LocalDateTime endReservationTime, Integer totalSeat,
                       Integer remainingSeat) {
        this.name = name;
        this.startPerformanceTime = startPerformanceTime;
        this.endPerformanceTime = endPerformanceTime;
        this.startReservationTime = startReservationTime;
        this.endReservationTime = endReservationTime;
        this.totalSeat = totalSeat;
        this.remainingSeat = remainingSeat;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setPerformance(this);
    }

    public void deleteSeat(Seat seat) {
        seats.remove(seat);
        seat.setPerformance(null);
    }
}
