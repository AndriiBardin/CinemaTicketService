package cinema.dto;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    private String orderDate;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsId) {
        this.ticketsIds = ticketsId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
