package com.gl.api.core.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for swagger settings. These settings should
 * be discoverable by your IDE for content assist as well.
 */
@ConfigurationProperties("microservice.config.swagger")
public class SwaggerProperties {
    /** Swagger config is enabled by default. Use this to disable it entirely.
     * Apps will be responsible for defining their @EnableSwagger and misc.
     * configuration themselves*/
    private boolean enabled;
    /** Base package to scan for Spring Controllers. Ideally this should just
     * be set to your controller package directly to avoid pulling in any
     * extra autoconfigured controllers.*/
    private String controllerPackage ="com.gl.api.core.customer";
    /** "Author" of the API, as displayed at the top of your Swagger documentation */
    private String author="Globallogic";
    /** Short name of your API. Try to keep this to the microservice name*/
    private String apiName="Default API name";
    /** Longer description of your API. Include likely use cases or describe
     * collaborating services here as well. */
    private String apiDescription="This API Needs a description!";
    /** Version of the API, noted at the bottom of the page. This version has no
     * direct influence on any API wiring, it is purely informational. */
    private String apiVersion="v1";

    public boolean isEnabled() {
        return enabled;
    }

    public SwaggerProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public SwaggerProperties setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public SwaggerProperties setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getApiName() {
        return apiName;
    }

    public SwaggerProperties setApiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public SwaggerProperties setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
        return this;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public SwaggerProperties setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }
}