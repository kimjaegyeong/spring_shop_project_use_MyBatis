package spring.project.shop.repository.deliveryRepository;

import spring.project.shop.domain.Delivery;

import java.util.List;

public interface DeliveryRepository {

    public String save(Delivery delivery);

    public Delivery find(String deliveryCode);

    public List<Delivery> findByuser(String memberId);
    public List<Delivery> findAll();

    //상품 주문 후 변동사항(stock) 또는 수정사항 로직
    public String update(Delivery delivery);
    public String remove(String DeliveryCode);
    public void storeClear();



}
