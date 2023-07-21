package spring.project.shop.repository.wishlistRepository;

import spring.project.shop.domain.Item;
import spring.project.shop.domain.Wish;

import java.util.List;

public interface WishlistRepository {
    public int save(String itemCode, String memberId);

    public int remove(int wishlistCode);

    public List<Wish> findAll(String memberId);

}
