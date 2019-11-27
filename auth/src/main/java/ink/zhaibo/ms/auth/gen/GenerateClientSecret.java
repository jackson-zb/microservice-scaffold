package ink.zhaibo.ms.auth.gen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhaibo
 * @description 生成clientSecret
 */
public class GenerateClientSecret {
    public static void main(String[] args) {
        String clientId = "webApp";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String clientSecret = encoder.encode(clientId);
        System.out.println(clientSecret);
    }
}
