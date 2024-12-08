package termproject.heroticketing.performance.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import termproject.heroticketing.performance.domain.Performance;

@RequiredArgsConstructor
@Getter
@ToString
public class PerformanceResponse {
    private String name;
    private LocalDateTime startPerformanceTime;
    private LocalDateTime endPerformanceTime;
    private LocalDateTime startReservationTime;
    private LocalDateTime endReservationTime;
    private Integer totalSeat;
    private Integer remainingSeat;

    @Builder
    public PerformanceResponse(String name, LocalDateTime startPerformanceTime, LocalDateTime endPerformanceTime,
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

    public static PerformanceResponse convertFromEntity(Performance performance) {
        return PerformanceResponse.builder()
                .name(performance.getName())
                .startPerformanceTime(performance.getStartPerformanceTime())
                .endPerformanceTime(performance.getEndPerformanceTime())
                .startReservationTime(performance.getStartReservationTime())
                .endReservationTime(performance.getEndReservationTime())
                .totalSeat(performance.getTotalSeat())
                .remainingSeat(performance.getRemainingSeat())
                .build();
    }
}
