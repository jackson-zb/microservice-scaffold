package ink.zhaibo.user.repository;

import ink.zhaibo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhaibo
 * @Date 2019/8/16 15:43
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
