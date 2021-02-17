package cinema.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsIds;
    }

    public void setTicketsId(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
