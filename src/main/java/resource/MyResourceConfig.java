package resource;


import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

import apiService.homeApiService;

import java.util.HashMap;
import java.util.Map;

public class MyResourceConfig extends DefaultResourceConfig {

    public MyResourceConfig() {
        super(homeApiService.class);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, CORSFilter.class);
        maps.put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, JsTokenFilterNeeded.class);
        setPropertiesAndFeatures(maps);
    }
}