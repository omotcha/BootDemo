package com.example.bootdemo.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * this is a test of configuration properties annotation
 */
@Component
@ConfigurationProperties(prefix = "url")
public class MicroServiceConfigProp {
    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getShoppingUrl() {
        return shoppingUrl;
    }

    public void setShoppingUrl(String shoppingUrl) {
        this.shoppingUrl = shoppingUrl;
    }
}
