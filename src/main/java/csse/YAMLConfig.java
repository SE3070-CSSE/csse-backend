package csse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAMMA on 9/15/2018.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

    private List<String> itempolicies = new ArrayList<>();

    public List<String> getItempolicies() {
        return itempolicies;
    }

    public void setItempolicies(List<String> itempolicies) {
        this.itempolicies = itempolicies;
    }
}
