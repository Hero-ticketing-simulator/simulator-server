package termproject.heroticketing.performance.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
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

    // Setter 메서드 추가
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartPerformanceTime(LocalDateTime startPerformanceTime) {
        this.startPerformanceTime = startPerformanceTime;
    }

    public void setEndPerformanceTime(LocalDateTime endPerformanceTime) {
        this.endPerformanceTime = endPerformanceTime;
    }

    public void setStartReservationTime(LocalDateTime startReservationTime) {
        this.startReservationTime = startReservationTime;
    }

    public void setEndReservationTime(LocalDateTime endReservationTime) {
        this.endReservationTime = endReservationTime;
    }

    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }

    public void setRemainingSeat(Integer remainingSeat) {
        this.remainingSeat = remainingSeat;
    }
}
