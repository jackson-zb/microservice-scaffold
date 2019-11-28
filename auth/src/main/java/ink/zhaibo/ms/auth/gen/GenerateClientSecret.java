package ink.zhaibo.ms.auth.gen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhaibo
 * @description 生成clientSecret
 */
public class GenerateClientSecret {
    public static void main(String[] args) {
        String clientSecret = "appClientSecret";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(clientSecret));
    }
}
