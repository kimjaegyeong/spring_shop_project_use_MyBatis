package spring.project.shop.service.wishlistservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Item;
import spring.project.shop.domain.Wish;
import spring.project.shop.repository.wishlistRepository.MemoryWishlistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryWishlistService implements WishlistService{
    public final MemoryWishlistRepository memoryWishlistRepository;

    @Override
    public int save(String itemCode, String memberId) {
        int save_ok = memoryWishlistRepository.save(itemCode,memberId);
        return save_ok;
    }

    @Override
    public int remove(int wishlistCode) {
        int remove_ok= memoryWishlistRepository.remove(wishlistCode);
        return remove_ok;
    }

    @Override
    public List<Wish> findAll(String memberId) {
        List<Wish> wishlist = memoryWishlistRepository.findAll(memberId);
        return wishlist;
    }
}
