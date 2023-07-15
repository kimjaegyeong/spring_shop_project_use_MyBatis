package spring.project.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String itemKey;
    private String itemCode;
    private String itemName;
    private String category;
    private Long price;
    private Long stock;

    public Item(){

    }
    public Item(String itemCode, String itemName, String category, long price, long stock){
        this.itemCode= itemCode;
        this.itemName= itemName;
        this.category= category;
        this.price= price;
        this.stock= stock;
    }
    //식별코드, 이름, 분류, 가격, 수량
}

