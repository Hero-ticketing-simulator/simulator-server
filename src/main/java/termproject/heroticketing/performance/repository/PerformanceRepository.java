package termproject.heroticketing.performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import termproject.heroticketing.performance.domain.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
