package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void clearAll() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("아이템A", 5000, 20);

        //when
        itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(item);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("아이템A", 5000, 20);
        itemRepository.save(item);
        ItemUpdateDto itemUpdateDto = new ItemUpdateDto("아이템A", 122200, 1);

        //when
        itemRepository.updateItem(item.getId(), itemUpdateDto);
        Item findItem = itemRepository.findById(item.getId());

        //then
        assertAll(
                () -> assertThat(findItem).isEqualTo(item),
                () -> assertThat(findItem.getId()).isEqualTo(item.getId()),
                () -> assertThat(findItem.getPrice()).isEqualTo(itemUpdateDto.getPrice()),
                () -> assertThat(findItem.getQuantity()).isEqualTo(itemUpdateDto.getQuantity())
        );
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("아이템A", 5000, 20);
        Item item2 = new Item("아이템B", 10000, 5);
        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
    }
}