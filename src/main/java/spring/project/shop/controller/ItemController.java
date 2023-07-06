package spring.project.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.project.shop.domain.Item;
import spring.project.shop.service.itemservice.MemoryItemService;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class ItemController {
    private final MemoryItemService memoryItemService;

    @GetMapping("/save")
    public String saveItemPage(){
        return "shop/save";

    }
    @PostMapping("/save")
    public String saveItem(Item item){

        memoryItemService.itemAdd(item);
        return "redirect:/shop/itemList";
    }

    @GetMapping("/itemList")
    public String itemList(Model model){
        List<Item> items = memoryItemService.showAllItem();
        model.addAttribute("items", items);
        return "shop/itemList";
    }

    @GetMapping("/itemDetail/{itemCode}")
    public String detailPage(@PathVariable String itemCode, Model model){
        Item item = memoryItemService.showItemDetail(itemCode);
        model.addAttribute("item", item);
        return "shop/itemDetail";
    }

    @GetMapping("/item/modify/{itemCode}")
    public String itemModifyPage(@PathVariable String itemCode, Model model){
        Item item=memoryItemService.showItemDetail(itemCode);
        model.addAttribute("item", item);
        return "shop/itemModify";
    }

    @PostMapping("/item/modify/{itemCode}")
    public String itemModify(@PathVariable String itemCode, Item item){
        memoryItemService.updateItem(item);
        return "shop/itemDetail";
    }


    @GetMapping("/item/remove/{itemCode}")
    public String itemRemove(@PathVariable String itemCode){
        String removeItemCode = memoryItemService.removeItem(itemCode);
        return "redirect:/shop/itemList";
    }


    /**
     *
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        Item item = new Item("0002","분홍여름원피스","원피스",20111L, 399L);
        memoryItemService.itemAdd(item);
    }
}