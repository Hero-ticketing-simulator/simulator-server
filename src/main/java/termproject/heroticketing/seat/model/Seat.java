package termproject.heroticketing.seat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.performance.domain.Performance;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNum;
    private String type;

    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Seat() {
    }

    @Builder
    public Seat(String seatNum, String type) {
        this.seatNum = seatNum;
        this.type = type;
    }
}
