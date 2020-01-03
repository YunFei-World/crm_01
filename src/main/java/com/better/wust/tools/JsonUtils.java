package com.better.wust.tools;

import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;

public class JsonUtils {

    public static JsonConfig jsonIntAndDouble(){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor() {
            public Object getDefaultValue(Class type) {
                return null;
            }
        });
        jsonConfig.registerDefaultValueProcessor(Double.class,new DefaultDefaultValueProcessor(){
            public Object getDefaultValue(Class type) {
                return null;
            }
        });
        return  jsonConfig;
    }
}
