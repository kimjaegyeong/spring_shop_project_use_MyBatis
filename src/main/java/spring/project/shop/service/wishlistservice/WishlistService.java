package spring.project.shop.service.wishlistservice;

import spring.project.shop.domain.Item;

import java.util.List;

public interface WishlistService {
    public int save(String itemCode);

    public int remove(int wishlistCode);

    public List<Item> findAll();
}
