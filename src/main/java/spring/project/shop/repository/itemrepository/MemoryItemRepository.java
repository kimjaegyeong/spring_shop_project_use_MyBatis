package spring.project.shop.repository.itemrepository;

import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Item;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryItemRepository implements ItemRepository{
    private static Map<String , Item> ItemMap = new HashMap<>();
    @Override
    public String save(Item item) {
        ItemMap.put(item.getItemCode(), item);
        return item.getItemCode();
    }

    @Override
    public Item find(String id) {
        Item findItem = ItemMap.get(id);
        return findItem;
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(ItemMap.values());
    }

    @Override
    public String update(Item item) {
        ItemMap.put(item.getItemCode(), item);
        return item.getItemCode();
    }

    @Override
    public String remove(String itemCode) {
        ItemMap.remove(itemCode);
        return itemCode;
    }

    @Override
    public void clearStore() {
        ItemMap.clear();
    }
}
