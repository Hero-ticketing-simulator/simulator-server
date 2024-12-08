package termproject.heroticketing.reservation.dto;

import lombok.Data;

@Data
public class ReservationRequest {
    private String seatNum;
    private String type;
}
