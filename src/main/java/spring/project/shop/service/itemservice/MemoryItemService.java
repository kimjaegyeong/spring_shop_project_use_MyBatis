package spring.project.shop.service.itemservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Item;
import spring.project.shop.repository.itemrepository.MemoryItemRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MemoryItemService implements ItemService{
    public final MemoryItemRepository itemRepository;
    @Override
    public String itemAdd(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item showItemDetail(String itemId) {
        Item itemDetail = itemRepository.find(itemId);
        return itemDetail;
    }

    @Override
    public List<Item> showAllItem() {

        return itemRepository.findAll();
    }

    @Override
    public String updateItem(Item item) {
        //해당 item이 repository에 존재하는지 체크하는 로직 필요

        return itemRepository.update(item);
    }

    @Override
    public String removeItem(String itemCode) {
        return itemRepository.remove(itemCode);
    }
}
