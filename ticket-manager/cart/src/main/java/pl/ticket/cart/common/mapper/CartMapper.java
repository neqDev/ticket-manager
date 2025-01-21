package pl.ticket.cart.common.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ticket.cart.common.model.Cart;
import pl.ticket.cart.common.model.CartItem;
import pl.ticket.dto.CartSummaryDto;
import pl.ticket.dto.CartSummaryItemDto;
import pl.ticket.dto.ProductDto;
import pl.ticket.dto.SummaryDto;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CartMapper
{
    public CartSummaryDto mapToCartSummary(Cart cart)
    {
        return CartSummaryDto.builder()
                .id(cart.getId())
                .items(mapToCartItems(cart.getItems()))
                .summary(mapToSummary(cart.getItems()))
                .build();
    }

    private SummaryDto mapToSummary(List<CartItem> items)
    {
        return SummaryDto.builder()
                .grossValue(sumValues(items))
                .build();
    }

    private BigDecimal sumValues(List<CartItem> items)
    {
        return items.stream().map(this::calculateLineValue).reduce(BigDecimal::add).orElseThrow();
    }

    private List<CartSummaryItemDto> mapToCartItems(List<CartItem> items)
    {
       return items.stream().map(this::mapToCartSummaryItemDto).toList();
    }

    private CartSummaryItemDto mapToCartSummaryItemDto(CartItem cartItem)
    {
        return CartSummaryItemDto.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .product(ProductDto.builder()
                        .id(cartItem.getProductId())
                        .price(cartItem.getProductPrice())
                        .build())
                .lineValue(calculateLineValue(cartItem))
                .build();
    }

    private BigDecimal calculateLineValue(CartItem cartItem)
    {
        return cartItem.getProductPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
    }
}
