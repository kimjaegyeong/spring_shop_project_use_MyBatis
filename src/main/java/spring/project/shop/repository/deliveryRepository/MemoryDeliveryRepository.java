package spring.project.shop.repository.deliveryRepository;

import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryDeliveryRepository implements DeliveryRepository{
    public static Map<String, Delivery> deliveryMap= new HashMap<>();
    @Override
    public String save(Delivery delivery) {
        deliveryMap.put(delivery.getDeliveryCode(),delivery);
        return delivery.getDeliveryCode();
    }

    @Override
    public Delivery find(String deliveryCode) {

        return  deliveryMap.get(deliveryCode);
    }

    @Override
    public List<Delivery> findByuser(String memberId) {
        ArrayList deliveries=new ArrayList<>(deliveryMap.values());
        ArrayList<Delivery> userDelivery = new ArrayList<Delivery>();

        for(int i=0; i< deliveries.size(); i++){
            Delivery obe= (Delivery) deliveries.get(i);
           if(obe.getMemberId().equals(memberId)){
                //memberId가 null인 경우에 대해 에러처리 필요
                userDelivery.add(obe);
               }

        }
        return userDelivery;
    }

    @Override
    public List<Delivery> findAll() {
        return new ArrayList<>(deliveryMap.values());
    }

    @Override
    public String update(Delivery delivery) {
        deliveryMap.put(delivery.getDeliveryCode(), delivery);
        return delivery.getDeliveryCode();
    }

    @Override
    public String remove(String deliveryCode) {
        deliveryMap.remove(deliveryCode);
        return deliveryCode;
    }

    @Override
    public void storeClear() {
        deliveryMap.clear();
    }
}
