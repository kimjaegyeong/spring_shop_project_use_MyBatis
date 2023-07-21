package spring.project.shop.repository.wishlistRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Item;
import spring.project.shop.domain.Member;
import spring.project.shop.domain.Wish;
import spring.project.shop.repository.itemrepository.MemoryItemRepository;
import spring.project.shop.repository.memberrepository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryWishlistRepository implements WishlistRepository{

    public final MemoryItemRepository memoryItemRepository;
    public final MemoryMemberRepository memoryMemberRepository;
    public static int wishCode = 0;
    private final Map<Integer , Wish> wishlistMap = new HashMap<>();
    @Override
    public int save(String itemCode, String memberId) {
        Member member = memoryMemberRepository.find(memberId);

        Item item =memoryItemRepository.find(itemCode);
        Wish wish = new Wish(wishCode,item,member);
        wishCode++;
        wishlistMap.put(wishCode, wish);
        return wishCode;
    }

    @Override
    public int remove(int wishlistCode) {
        wishlistCode--;
        wishlistMap.remove(wishlistCode);
        return this.wishCode;
    }

    @Override
    public List<Wish> findAll(String memberId) {
        List<Wish> wishlist = new ArrayList<>();
        for(Integer key : wishlistMap.keySet()){
            Wish wish=wishlistMap.get(key);

            if(wish.getMember().getMemberId().equals(memberId)){
                wishlist.add(wish);
            }
        }
        return wishlist;
    }
}
