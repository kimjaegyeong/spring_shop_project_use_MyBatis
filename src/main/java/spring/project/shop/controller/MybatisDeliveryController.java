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
import spring.project.shop.service.deliveryservice.MybatisDeliveryService;
import spring.project.shop.service.itemservice.MemoryItemService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class MybatisDeliveryController {
    private final MybatisDeliveryService mybatisDeliveryService;
    private final MemoryItemService memoryItemService;

    @GetMapping("/item/order/{itemCode}")
    public String itemOrderPage(@PathVariable String itemCode){
        return "shop/order";
    }

    @PostMapping("/item/order/{itemCode}")
    public String itemOrder(@PathVariable String itemCode, Delivery delivery, HttpSession httpSession, Model model){
        Delivery userDelivery = new Delivery(delivery.getName(),delivery.getAddress(),delivery.getPhoneNumber(),delivery.getQuantity());
        String deliveryCode =mybatisDeliveryService.saveDelivery(itemCode,userDelivery,httpSession);
        if(deliveryCode.equals("수량부족")){
            return "redirect:/shop/itemList";
        }
            return "redirect:/shop/mypage/order/" + deliveryCode;

    }

    @GetMapping("/All/orderList")
    public String allOrderList(Model model){
        List<Delivery> deliveries =mybatisDeliveryService.allDelivery();
        model.addAttribute("deliveries", deliveries);
        return "shop/allOrderList";
    }

    @GetMapping("/mypage/myDelivery")
    public String myDelivery(Model model, HttpSession httpSession){
        String userId= httpSession.getAttribute("loginMember").toString();
        log.warn(userId);

        List<Delivery> deliveries = mybatisDeliveryService.userDelivery(userId);
        log.warn(String.valueOf(deliveries.size()));
        model.addAttribute("deliveries", deliveries);
        return "shop/myDelivery";
    }

    @GetMapping("/mypage/order/cancel/{deliveryCode}")
    public String deliveryCancel(@PathVariable String deliveryCode){
            Delivery remove_delivery = mybatisDeliveryService.showDelivery(deliveryCode);
            String result=mybatisDeliveryService.cancelDelivery(remove_delivery);
            if(result.equals("already_cancel")){
                log.warn("이미 취소된 상품입니다.");
            }
            return "redirect:/shop/mypage/myDelivery";
    }
}
