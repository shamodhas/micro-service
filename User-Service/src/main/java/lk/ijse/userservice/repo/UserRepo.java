package lk.ijse.userservice.repo;

import lk.ijse.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 11/24/2023
 * Time : 10:17 AM
 */

@Repository
public interface UserRepo extends JpaRepository<User,String> {
}
