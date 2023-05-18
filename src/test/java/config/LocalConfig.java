package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/properties/local.properties")
public interface LocalConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Pixel 6")
    String deviceName();

    @DefaultValue("11.0")
    @Key("osVersion")
    String osVersion();

    @DefaultValue("http://0.0.0.0:4723/wd/hub")
    @Key("url")
    String url();

    @DefaultValue("Android")
    @Key("platformName")
    String platformName();
}
