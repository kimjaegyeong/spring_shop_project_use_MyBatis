package spring.project.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.project.shop.domain.Delivery;
import spring.project.shop.enums.DeliveryState;
import spring.project.shop.repository.deliveryRepository.DeliveryRepository;
import spring.project.shop.repository.deliveryRepository.MemoryDeliveryRepository;

import java.util.List;

public class MemoryDeliveryRepositoryTest {
    public final DeliveryRepository deliveryRepository = new MemoryDeliveryRepository();
    @BeforeEach
    public void BeforeEach(){
        deliveryRepository.storeClear();
    }
    @Test
    public void 배달사항저장_테스트(){
        Delivery delivery = new Delivery();
        String save_code=deliveryRepository.save(delivery);

        Assertions.assertEquals(delivery.getDeliveryCode(),save_code );
    }

    @Test
    public void 배달사항찾기_테스트(){
        Delivery delivery = new Delivery();
        deliveryRepository.save(delivery);

        Delivery findDelivery=deliveryRepository.find(delivery.getDeliveryCode());

        Assertions.assertEquals(delivery.getDeliveryCode(), findDelivery.getDeliveryCode());

    }

    @Test
    public void 배달사항모두찾기_테스트(){
        Delivery delivery = new Delivery();
        delivery.setDeliveryCode("111");
        deliveryRepository.save(delivery);

        Delivery delivery2 = new Delivery();
        delivery2.setDeliveryCode("222");
        deliveryRepository.save(delivery2);

        List<Delivery> list_delivery = deliveryRepository.findAll();

        Assertions.assertEquals(list_delivery.size(),2);
    }

    @Test
    public void 멤버배달사항_찾기_테스트(){
        Delivery delivery = new Delivery();
        delivery.setDeliveryCode("111");
        delivery.setMemberId("member1");
        deliveryRepository.save(delivery);

        Delivery delivery2 = new Delivery();
        delivery2.setDeliveryCode("222");
        delivery2.setMemberId("member1");
        deliveryRepository.save(delivery2);

        List<Delivery> list_user_delivery = deliveryRepository.findByuser("member1");
        Assertions.assertEquals(list_user_delivery.size(),2);

    }

    @Test
    public void 배달사항변경() {
        Delivery delivery = new Delivery();
        deliveryRepository.save(delivery);
        DeliveryState DelState = delivery.getState();
        delivery.setState(DeliveryState.CANCEL);
        String updateDelCode = deliveryRepository.update(delivery);

        Assertions.assertEquals(DeliveryState.CANCEL, deliveryRepository.find(updateDelCode).getState());
    }

    @Test
    public void 배달사항삭제(){
        Delivery delivery = new Delivery();
        deliveryRepository.save(delivery);
        deliveryRepository.remove(delivery.getDeliveryCode());

        Assertions.assertNull(deliveryRepository.find(delivery.getDeliveryCode()));
    }
}
