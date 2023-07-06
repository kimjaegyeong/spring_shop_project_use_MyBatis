package spring.project.shop.repository.itemrepository;

import spring.project.shop.domain.Item;


import java.util.List;


public interface ItemRepository {
    //create -> 상품추가 로직
    public String save(Item item);
    //select -> 상세페이지 로직
    public Item find(String id);
    //select ALL -> 목록 로직
    public List<Item> findAll();
    //update -> 상품에 대한 사항 수정
    public String update(Item item);
    //delete -> 상품 품절 또는 문제가 있을 시 상품을 삭제하는 로직
    public String remove(String itemCode);
    public void clearStore();

}
