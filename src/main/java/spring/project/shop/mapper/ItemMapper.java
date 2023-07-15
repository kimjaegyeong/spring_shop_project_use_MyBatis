package spring.project.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.project.shop.domain.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    public void save(Item item);

    public Item find(String id);

    public List<Item> findAll();

    public void update(Item item);

    public void remove(String itemCode);
}
