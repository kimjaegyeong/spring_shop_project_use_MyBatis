package spring.project.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.enums.DeliveryState;

@Mapper
public interface DeliveryMapper {
    public DeliveryState selectState(String deliveryCode);

    public Item selectItem(String item_code);
    public void saveDelivery(Delivery delivery);
    public Delivery selectDelivery(String DeliveryCode);
}
