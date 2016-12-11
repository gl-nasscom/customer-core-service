/**
 * 
 */
package com.gl.api.core.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


/**
 * @author saurabh.malik
 *
 */
@RefreshScope
@Configuration
public class MicroserviceConfig {

	@Value("${message.callbackUrl}")
    private String callbackUrl;

    public String getCallbackUrl() {
        return callbackUrl;
    }
}
