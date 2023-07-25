package spring.project.shop.service.deliveryservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Delivery;
import spring.project.shop.enums.DeliveryState;
import spring.project.shop.repository.deliveryRepository.DeliveryRepository;
import spring.project.shop.repository.deliveryRepository.MemoryDeliveryRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MemoryDeliveryService implements DeliveryService{

    public final MemoryDeliveryRepository deliveryRepository;
    @Override
    public String saveDelivery(Delivery delivery) {

        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> userDelivery(String memberId) {
       List<Delivery> userDelivery =deliveryRepository.findByuser(memberId);
        return userDelivery;
    }

    @Override
    public Delivery showDelivery(String deliveryCode) {
        Delivery delivery = deliveryRepository.find(deliveryCode);
        return delivery;
        }

    @Override
    public List<Delivery> allDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public String cancelDelivery(Delivery delivery) {
        Delivery updateDelivery = delivery;
        updateDelivery.setState(DeliveryState.CANCEL);
        deliveryRepository.update(updateDelivery);
        return updateDelivery.getDeliveryCode();
    }

    @Override
    public String removeDelivery(String deliveryCode) {

        return deliveryRepository.remove(deliveryCode);
    }

    @Override
    public String updateDelivery(Delivery delivery) {
        return deliveryRepository.update(delivery);
    }
}
