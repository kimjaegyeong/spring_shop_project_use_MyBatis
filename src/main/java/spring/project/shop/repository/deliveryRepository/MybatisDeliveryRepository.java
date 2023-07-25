package spring.project.shop.repository.deliveryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.mapper.DeliveryMapper;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MybatisDeliveryRepository implements DeliveryRepository{

    private final DeliveryMapper deliveryMapper;

    public Item findItem(String itemCode){
        return deliveryMapper.selectItem(itemCode);
    }

    @Override
    public String save(Delivery delivery) {
        deliveryMapper.saveDelivery(delivery);
        return null;
    }

    @Override
    public Delivery find(String deliveryCode) {
        Delivery delivery = deliveryMapper.selectDelivery(deliveryCode);
        return delivery;
    }

    @Override
    public List<Delivery> findByuser(String memberId) {
        return null;
    }

    @Override
    public List<Delivery> findAll() {
        return null;
    }

    @Override
    public String update(Delivery delivery) {
        return null;
    }

    @Override
    public String remove(String DeliveryCode) {
        return null;
    }

    @Override
    public void storeClear() {

    }
}
