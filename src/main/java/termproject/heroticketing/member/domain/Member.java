package termproject.heroticketing.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import termproject.heroticketing.seat.model.Seat;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String role;
    @OneToMany(mappedBy = "member")
    private List<Seat> seats = new ArrayList<>();


    public Member() {
    }

    @Builder
    public Member(String loginId, String password, String role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setMember(this);
    }

    public void deleteSeat(Seat seat) {
        seats.remove(seat);
        seat.setMember(null);
    }
}
