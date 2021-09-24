package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemUpdateDto {

    private String itemName;
    private Integer price;
    private Integer quantity;
}
