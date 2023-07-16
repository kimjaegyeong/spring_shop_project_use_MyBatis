package spring.project.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spring.project.shop.enums.DeliveryState;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Delivery {
    Long deliveryKey;
    String deliveryCode;
    List<Item> Items;
    String memberId; //주문자
    String address; //발신자
    DeliveryState state; 
    String phoneNumber;//발신자
    String name;//발신자
    int quantity;

    public Delivery(){

    }

    public Delivery(String name, String address, String phoneNumber, int quantity){
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name= name;
        this.quantity= quantity;
    }


    public Delivery(String deliveryCode, String name, String address, String phoneNumber, int quantity){
        this.deliveryCode = deliveryCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name= name;
        this.quantity= quantity;
    }
}

