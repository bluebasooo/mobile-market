package ru.bluebasooo.market.mobilemarket.rest.basket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketResponse;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketUpdateRequest;
import ru.bluebasooo.market.mobilemarket.service.basket.BasketService;

@RestController
@RequestMapping("/basket")
public class BasketController {

    public final BasketService basketService;

    public BasketController(
            BasketService basketService
    ) {
        this.basketService = basketService;
    }

    @GetMapping("/{id}/update")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody BasketUpdateRequest request) {
        basketService.updateBasket(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/clean")
    public ResponseEntity<Void> clean(@PathVariable String id) {
        basketService.cleanBasket(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/read")
    public ResponseEntity<BasketResponse> read(@PathVariable String id) {
        return ResponseEntity.ok(basketService.readBasket(id));
    }

}
