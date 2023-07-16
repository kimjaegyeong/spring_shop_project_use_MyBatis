package spring.project.shop.repository.wishlistRepository;

import spring.project.shop.domain.Item;

import java.util.List;

public interface WishlistRepository {
    public int save(String itemCode);

    public int remove(int wishlistCode);

    public List<Item> findAll();

}
