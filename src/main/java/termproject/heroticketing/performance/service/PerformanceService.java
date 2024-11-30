package termproject.heroticketing.performance.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import termproject.heroticketing.performance.domain.Performance;
import termproject.heroticketing.performance.dto.PerformanceForm;
import termproject.heroticketing.performance.dto.PerformanceResponse;
import termproject.heroticketing.performance.repository.PerformanceRepository;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public void savePerformance(PerformanceForm form) {
        Performance savePerformance = Performance.builder()
                .name(form.getName())
                .startPerformanceTime(form.getStartPerformanceTime())
                .endPerformanceTime(form.getEndPerformanceTime())
                .startReservationTime(form.getStartReservationTime())
                .endReservationTime(form.getEndReservationTime())
                .totalSeat(form.getTotalSeat())
                .remainingSeat(form.getRemainingSeat())
                .build();
        performanceRepository.save(savePerformance);
    }

    public PerformanceResponse getPerformance(Long id) {
        return performanceRepository.findById(id).map(PerformanceResponse::convertFromEntity).orElse(null);
    }

    public List<PerformanceResponse> showAll() {
        List<Performance> allPerformance = performanceRepository.findAll();
        return allPerformance.stream()
                .map(PerformanceResponse::convertFromEntity)
                .toList();
    }

    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }

    public PerformanceForm editPerformance(PerformanceForm form) {
        Performance performance = performanceRepository.findById(form.getId()).orElse(null);
        if (performance == null) {
            return null;
        }
        performance.setName(form.getName());
        performance.setStartPerformanceTime(form.getStartPerformanceTime());
        performance.setStartPerformanceTime(form.getEndPerformanceTime());
        performance.setStartPerformanceTime(form.getStartReservationTime());
        performance.setStartPerformanceTime(form.getEndReservationTime());
        performance.setTotalSeat(form.getTotalSeat());
        performance.setRemainingSeat(form.getRemainingSeat());
        return form;
    }
}
