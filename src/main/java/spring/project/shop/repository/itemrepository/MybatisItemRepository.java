package spring.project.shop.repository.itemrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Item;
import spring.project.shop.mapper.ItemMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisItemRepository implements ItemRepository{
    private final ItemMapper itemMapper;

    @Override
    public String save(Item item) {
        itemMapper.save(item);
        return item.getItemCode();
    }

    @Override
    public Item find(String id) {
        return itemMapper.find(id);
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public String update(Item item) {
         itemMapper.update(item);
        return item.getItemCode();
    }

    @Override
    public String remove(String itemCode) {
        itemMapper.remove(itemCode);
        return itemCode;
    }

    @Override
    public void clearStore() {

    }
}
