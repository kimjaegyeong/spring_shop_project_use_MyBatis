package spring.project.shop.service.itemservice;

import spring.project.shop.domain.Item;

import java.util.List;

public interface ItemService {
    public String itemAdd(Item item);
    public Item showItemDetail(String itemId);
    public List<Item> showAllItem();
    public String updateItem(Item item);
    public String removeItem(String itemCode);
}
