package termproject.heroticketing.performance.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PerformanceForm {
    private Long id;
    private String name;
    private LocalDateTime startPerformanceTime;
    private LocalDateTime endPerformanceTime;
    private LocalDateTime startReservationTime;
    private LocalDateTime endReservationTime;
    private Integer totalSeat;
    private Integer remainingSeat;

    @Builder
    public PerformanceForm(String name, LocalDateTime startPerformanceTime, LocalDateTime endPerformanceTime,
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
