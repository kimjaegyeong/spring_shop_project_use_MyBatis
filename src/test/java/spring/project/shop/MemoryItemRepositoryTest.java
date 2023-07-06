package spring.project.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.project.shop.domain.Item;
import spring.project.shop.repository.itemrepository.MemoryItemRepository;

import java.util.List;


public class MemoryItemRepositoryTest {

    MemoryItemRepository itemRepository = new MemoryItemRepository();

    @BeforeEach
    public void BeforeEach() {
        itemRepository.clearStore();
    }
    @Test
    public void 아이템_추가_테스트(){
        Item item = new Item("000001","파란여름원피스","원피스",18000L,1000L);
        itemRepository.save(item);
        Assertions.assertEquals(itemRepository.findAll().size(), 1);
    }

    @Test
    public void 아이템_1개_찾기_테스트(){
        Item item = new Item("000001","파란여름원피스","원피스",18000L,1000L);
        itemRepository.save(item);
        Item findItem = itemRepository.find(item.getItemCode());
        Assertions.assertEquals(item.getItemCode(), findItem.getItemCode());
    }

    @Test
    public void 모든_아이템_찾기_테스트(){
        Item item = new Item("000001","파란여름원피스","원피스",18000L,1000L);
        itemRepository.save(item);
        Item item2 = new Item("000002","여름꽃무늬원피스","원피스",21000L,1000L);
        itemRepository.save(item2);

        List<Item> items = itemRepository.findAll();

        Assertions.assertEquals(items.size(),2);
    }

    @Test
    public void 아이템_변경_테스트(){
        Item item = new Item("000001","파란여름원피스","원피스",18000L,1000L);
        itemRepository.save(item);
        Item item2 = new Item("000001","노란여름원피스","원피스",18000L,1200L);
        String updateItemId =itemRepository.update(item2);
        Item updateItem = itemRepository.find(updateItemId);

        Assertions.assertEquals(itemRepository.findAll().size(),1);
        Assertions.assertEquals(item2.getItemName(),updateItem.getItemName());
    }

    @Test
    public void 아이템_삭제_테스트(){
        Item item = new Item("000001","파란여름원피스","원피스",18000L,1000L);
        itemRepository.save(item);
        String itemCode =itemRepository.remove(item);
        Assertions.assertNull(itemRepository.find(itemCode));
    }
}
