package spring.project.shop.service.deliveryservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.enums.DeliveryState;
import spring.project.shop.repository.deliveryRepository.MybatisDeliveryRepository;
import spring.project.shop.repository.itemrepository.MybatisItemRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MybatisDeliveryService{
    static int sq= 1;
    private final MybatisDeliveryRepository mybatisDeliveryRepository;
    private final MybatisItemRepository mybatisItemRepository;
    public String saveDelivery(String itemCode, Delivery userDelivery, HttpSession httpSession) {
        //db접근만 3번 있음. 줄일 필요성

        Item item = mybatisDeliveryRepository.findItem(itemCode); // delivery table에서 item 참조해서 item 정보 끌어오기
        if(item.getStock() - userDelivery.getQuantity() < 0){
            log.warn("수량부족");
            return itemCode;
        }

        userDelivery.setDeliveryCode(Integer.toString(sq));
        List<Item> userItems = new ArrayList<>();
        item.setStock(item.getStock() - userDelivery.getQuantity());
        userItems.add(item);

        userDelivery.setItems(userItems);
        userDelivery.setMemberId(httpSession.getAttribute("loginMember").toString());
        userDelivery.setState(DeliveryState.OK);
        userDelivery.setDeliveryCode(Integer.toString(sq));

        sq++;

        mybatisItemRepository.update(userItems.get(0));
        mybatisDeliveryRepository.save(userDelivery);

        return userDelivery.getDeliveryCode();
    }


    public List<Delivery> userDelivery(String memberId) {
        return null;
    }


    public Delivery showDelivery(String deliveryCode) {

        return mybatisDeliveryRepository.find(deliveryCode);
    }


    public List<Delivery> allDelivery() {
        return null;
    }


    public String cancelDelivery(Delivery delivery) {
        return null;
    }


    public String removeDelivery(String deliveryCode) {
        return null;
    }


    public String updateDelivery(Delivery delivery) {
        return null;
    }
}
