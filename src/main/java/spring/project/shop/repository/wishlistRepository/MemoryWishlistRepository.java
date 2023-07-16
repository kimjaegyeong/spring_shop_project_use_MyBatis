package spring.project.shop.repository.wishlistRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Item;
import spring.project.shop.repository.itemrepository.MemoryItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryWishlistRepository implements WishlistRepository{

    public final MemoryItemRepository memoryItemRepository;
    public static int wishlistCode = 0;
    private final Map<Integer , Item> wishlistMap = new HashMap<>();
    @Override
    public int save(String itemCode) {
        Item item=memoryItemRepository.find(itemCode);
        wishlistCode++;
        wishlistMap.put(wishlistCode, item);
        return wishlistCode;
    }

    @Override
    public int remove(int wishlistCode) {
        wishlistCode--;
        wishlistMap.remove(wishlistCode);
        return this.wishlistCode;
    }

    @Override
    public List<Item> findAll() {
        List<Item> wishlist = new ArrayList<>(wishlistMap.values());
        return wishlist;
    }
}
