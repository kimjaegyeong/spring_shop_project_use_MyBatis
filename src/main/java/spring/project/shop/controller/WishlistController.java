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
import spring.project.shop.domain.Wish;
import spring.project.shop.service.wishlistservice.MemoryWishlistService;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class WishlistController {
    private final MemoryWishlistService memoryWishlistService;

    @GetMapping("/item/addwishlist/{itemCode}")
    public String addWishlist(@PathVariable String itemCode, Item item, HttpSession httpSession){
        String memberId = httpSession.getAttribute("loginMember").toString();
        int ok =memoryWishlistService.save(item.getItemCode(),memberId);
        return "redirect:/shop/itemList";
    }

    @GetMapping("/mypage/showWishlist")
    public String showWishlist(Model model, HttpSession httpSession){
        String memberId = httpSession.getAttribute("loginMember").toString();
        List<Wish> wishs= memoryWishlistService.findAll(memberId);


        model.addAttribute("wishs",wishs);
        return "shop/wishlist";
    }


}
