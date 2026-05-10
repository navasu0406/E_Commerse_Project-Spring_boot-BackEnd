import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dh7ezzmac",
            "api_key", "167571589598853",
            "api_secret", "FTnBUs8E9iegT_ifakSdBx98NAQ",
            "secure", true
        ));
    }
}