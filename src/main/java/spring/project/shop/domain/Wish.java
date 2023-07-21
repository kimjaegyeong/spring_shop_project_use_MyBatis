package spring.project.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Wish {
    int wishCode;
    Item item;
    Member member;

    public Wish(int wishCode, Item item, Member member) {
        this.wishCode=wishCode;
        this.item=item;
        this.member=member;
    }
}
