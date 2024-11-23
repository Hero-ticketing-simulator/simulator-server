package termproject.heroticketing.performance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
}
