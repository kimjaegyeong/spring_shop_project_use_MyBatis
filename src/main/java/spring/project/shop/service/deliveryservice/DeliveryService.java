package spring.project.shop.service.deliveryservice;

import spring.project.shop.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    //배송저장
    public String saveDelivery(Delivery delivery);
    //배송확인(유저용, 관리자용)

    public List<Delivery> userDelivery(String memberId);

    public Delivery showDelivery(String deliveryCode);

    public List<Delivery> allDelivery();

    //배송취소
    public String cancelDelivery(Delivery delivery);

    //배송삭제
    public String removeDelivery(String deliveryCode);
    //배송정보변경

    public String updateDelivery(Delivery delivery);





}
