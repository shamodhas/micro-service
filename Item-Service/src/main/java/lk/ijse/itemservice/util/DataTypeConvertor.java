package lk.ijse.itemservice.util;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.entity.Item;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 11/29/2023
 * Time : 3:24 PM
 */

@Component
@RequiredArgsConstructor
public class DataTypeConvertor {
    private final ModelMapper modelMapper;

    public ItemDTO getItemDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    public Item getItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO,Item.class);
    }
}
