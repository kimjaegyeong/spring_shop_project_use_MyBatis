package spring.project.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String itemCode;
    private String itemName;
    private String category;
    private Long price;
    private Long stock;

    public Item(){

    }
    public Item(String itemCode, String itemName, String category){
        this.itemCode= itemCode;
        this.itemName= itemName;
        this.category= category;
        this.price= 100000000000L;
        this.stock= 0L;
    }
    //식별코드, 이름, 분류, 가격, 수량
}

