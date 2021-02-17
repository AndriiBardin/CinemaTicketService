package cinema.service.mapper;

import cinema.dto.ShoppingCartResponseDto;
import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto cartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketsId(shoppingCart.getTickets().stream()
                .map(Ticket::getId).collect(Collectors.toList()));
        shoppingCartResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        return shoppingCartResponseDto;
    }
}
