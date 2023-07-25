package spring.project.shop;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.enums.DeliveryState;
import spring.project.shop.mapper.DeliveryMapper;
import spring.project.shop.repository.deliveryRepository.MybatisDeliveryRepository;
import spring.project.shop.repository.itemrepository.MybatisItemRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback
public class MybatisDeliveryTest {
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private MybatisDeliveryRepository mybatisDeliveryRepository;
    @Autowired
    private MybatisItemRepository mybatisItemRepository;
    @Test
    public void selectItem(){
        String itemCode= "0001";
        Item item=mybatisDeliveryRepository.findItem(itemCode);
        System.out.println(item.toString());

    }

    @Test
    public void selectState(){
        DeliveryState state=deliveryMapper.selectState("1");
        System.out.println(state);
    }

    @Test
    public void selectDelivery(){
        Delivery delivery = mybatisDeliveryRepository.find("1");
        System.out.println(delivery);
    }
    @Test
    public void saveDelivery(){
        int sq=2;

        Item item = mybatisDeliveryRepository.findItem("0002"); // delivery table에서 item 참조해서 item 정보 끌어오기
        Delivery userDelivery = new Delivery("주문자","주문자주소","010-2222-2222",3);
        userDelivery.setDeliveryCode(Integer.toString(sq));
        List<Item> userItems = new ArrayList<>();

        item.setStock(item.getStock() - userDelivery.getQuantity());
        userItems.add(item);

        userDelivery.setItems(userItems);
        userDelivery.setMemberId("user1");
        userDelivery.setState(DeliveryState.OK);

        mybatisItemRepository.update(userItems.get(0));
        sq++;
        mybatisDeliveryRepository.save(userDelivery);

        Item findItem = mybatisItemRepository.find(item.getItemCode());
        Delivery findDelivery = mybatisDeliveryRepository.find(userDelivery.getDeliveryCode());
        System.out.println(findItem.getStock());
        System.out.println(findDelivery.getPhoneNumber());
    }
}
