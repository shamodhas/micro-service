package lk.ijse.itemservice.api;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.dto.UserDTO;
import lk.ijse.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 11/24/2023
 * Time : 10:18 AM
 */

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    private final RestTemplate restTemplate;
    private final ItemService itemService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        System.out.println("Request body userDTO : " + userDTO);
        try {
            UserDTO responseUserDTO = restTemplate.postForObject("http://user-service/api/v1/user", userDTO, UserDTO.class);
            System.out.println("Rest Template Response body userDTO : " + responseUserDTO);
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PostMapping
    public ResponseEntity<?> saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("Request body itemDTO : " + itemDTO);
        return ResponseEntity.ok(itemService.saveItem(itemDTO));
    }
}
