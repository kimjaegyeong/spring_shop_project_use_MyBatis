package spring.project.shop.service.itemservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Item;
import spring.project.shop.repository.itemrepository.MybatisItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MybatisItemService implements ItemService{

    private final MybatisItemRepository mybatisItemRepository;
    @Override
    public String itemAdd(Item item) {
        mybatisItemRepository.save(item);
        return item.getItemCode();
    }

    @Override
    public Item showItemDetail(String itemId) {
        return mybatisItemRepository.find(itemId);
    }

    @Override
    public List<Item> showAllItem() {
        return mybatisItemRepository.findAll();
    }

    @Override
    public String updateItem(Item item) {
        mybatisItemRepository.update(item);
        return item.getItemCode();
    }

    @Override
    public String removeItem(String itemCode) {
        mybatisItemRepository.remove(itemCode);
        return itemCode;
    }
}
