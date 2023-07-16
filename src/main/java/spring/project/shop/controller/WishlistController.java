package spring.project.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.project.shop.domain.Item;
import spring.project.shop.service.wishlistservice.MemoryWishlistService;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class WishlistController {
    private final MemoryWishlistService memoryWishlistService;

    @GetMapping("/item/addwishlist")
    public String AddWishlist(Item item){
        int ok =memoryWishlistService.save(item.getItemCode());
        return "redirect:/shop/itemList";
    }


}
