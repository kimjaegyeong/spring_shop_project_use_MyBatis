package spring.project.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Item;
import spring.project.shop.enums.DeliveryState;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    public DeliveryState selectState(String deliveryCode);
    public Item selectItem(String item_code);
    public void saveDelivery(Delivery delivery);
    public Delivery selectDelivery(String DeliveryCode);
    public List<Delivery> selectAllDelivery();
    public List<Delivery> selectDeliveryById(String memberId);

    public void updateItemStock(String itemCode, int itemStock);

    public void updateState(Delivery delivery);
}
