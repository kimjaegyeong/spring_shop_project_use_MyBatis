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
    String DeliveryCode;
    List<Item> Items;
    String memberId;
    String address;
    DeliveryState state;
    String phoneNumber;
    String name;
    int quantity;

    public Delivery(){

    }

    public Delivery(String name, String address, String phoneNumber ,  int quantity){
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name= name;
        this.quantity= quantity;
    }
}

