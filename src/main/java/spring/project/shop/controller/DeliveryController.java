package spring.project.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.enums.DeliveryState;
import spring.project.shop.service.deliveryservice.MemoryDeliveryService;
import spring.project.shop.service.itemservice.MemoryItemService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class DeliveryController {
    private final MemoryDeliveryService memoryDeliveryService;
    private final MemoryItemService memoryItemService;
    static int sq= 1;

    @GetMapping("/item/order/{itemCode}")
    public String itemOrderPage(@PathVariable String itemCode){
        return "shop/order";
    }

    @PostMapping("/item/order/{itemCode}")
    public String itemOrder(@PathVariable String itemCode, Delivery delivery, HttpSession httpSession){
        Delivery userDelivery = new Delivery(delivery.getName(),delivery.getPhoneNumber(),delivery.getAddress(),delivery.getQuantity());
        Item item = memoryItemService.showItemDetail(itemCode);
        if(item.getStock() - delivery.getQuantity() < 0){
            log.warn("수량부족");
            return "redirect:/shop/itemDetail/" + itemCode ;
        }

        userDelivery.setDeliveryCode(Integer.toString(sq));
        List<Item> userItems = new ArrayList<>();
        item.setStock(item.getStock() - delivery.getQuantity());
        userItems.add(item);

        userDelivery.setItems(userItems);
        userDelivery.setMemberId(httpSession.getAttribute("loginMember").toString());
        userDelivery.setState(DeliveryState.OK);

        String deliveryCode =memoryDeliveryService.saveDelivery(userDelivery);
        sq++;

        return "redirect:/shop/mypage/order/"+deliveryCode;

    }

    @GetMapping("/All/orderList")
    public String allOrderList(Model model){
        List<Delivery> deliveries =memoryDeliveryService.allDelivery();
        model.addAttribute("deliveries", deliveries);
        return "shop/allOrderList";
    }

    @GetMapping("/mypage/myDelivery")
    public String myDelivery(Model model, HttpSession httpSession){
        String userId= httpSession.getAttribute("loginMember").toString();
        log.warn(userId);

        List<Delivery> deliveries = memoryDeliveryService.userDelivery(userId);
        log.warn(String.valueOf(deliveries.size()));
        model.addAttribute("deliveries", deliveries);
        return "shop/myDelivery";
    }


}
