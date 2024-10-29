package lk.ijse.itemservice.service.impl;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.repo.ItemRepo;
import lk.ijse.itemservice.service.ItemService;
import lk.ijse.itemservice.util.DataTypeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 11/24/2023
 * Time : 10:17 AM
 */

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;
    private final DataTypeConvertor convertor;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        return convertor.getItemDTO(itemRepo.save(convertor.getItem(itemDTO)));
    }
}
