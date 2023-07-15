package spring.project.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import spring.project.shop.domain.Item;
import spring.project.shop.mapper.ItemMapper;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback
public class MybatisItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;
    @Test
    public void save(){
        Item item = new Item("0001A","반팔티","상의",18000L,300L);
        itemMapper.save(item);

        List<Item> items = itemMapper.findAll();

        Assertions.assertEquals(items.size(),1);
    }

    @Test
    public void find(){
        Item item = new Item("0001A","반팔티","상의",18000L,300L);
        itemMapper.save(item);

        Item item1 = itemMapper.find(item.getItemCode());

        Assertions.assertEquals(item.getItemCode(), item1.getItemCode());
    }

    @Test
    public void findAll(){
        Item item = new Item("0001A","반팔티","상의",18000L,300L);
        itemMapper.save(item);

        Item item1 = new Item("0002A","반팔티2","상의",18000L,300L);
        itemMapper.save(item1);

        List<Item> items = itemMapper.findAll();

        Assertions.assertEquals(items.size(),2);
    }

    @Test
    public void update(){
        Item item = new Item("0001A","반팔티","상의",18000L,300L);
        itemMapper.save(item);
        
        Item item2 =item;
        item2.setItemName("여름반팔티");
        itemMapper.update(item2);
        Item findItem=itemMapper.find(item.getItemCode());

        Assertions.assertEquals(findItem.getItemName(), item2.getItemName());

    }

    @Test
    public void remove(){
        Item item = new Item("0001A","반팔티","상의",18000L,300L);
        itemMapper.save(item);

        Item item1 = new Item("0002A","반팔티2","상의",18000L,300L);
        itemMapper.save(item1);

        itemMapper.remove(item.getItemCode());

        List<Item> items = itemMapper.findAll();
        Assertions.assertEquals(items.size(),1);
    }
}
