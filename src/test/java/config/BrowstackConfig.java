package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface BrowstackConfig extends Config {
    String userValue();
    String keyValue();
    String project();
    String build();
    String name();
    String app();
    String device();
    String osVersion();
    String baseUrl();
}
