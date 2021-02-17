package cinema.service.mapper;

import cinema.dto.OrderResponseDto;
import cinema.model.Order;
import cinema.model.Ticket;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto orderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderTime().toString());
        List<Long> ticketIds = order.getTickets().stream().map(Ticket::getId)
                .collect(Collectors.toList());
        orderResponseDto.setTicketsId(ticketIds);
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
