package ink.zhaibo.ms.user.svc.repository;

import ink.zhaibo.ms.user.svc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhaibo
 * @Date 2019/8/16 15:43
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
