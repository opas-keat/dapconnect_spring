package com.praxis.dapconnect.config;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author KevinBlandy
 *
 */

@Configuration
public class GsonConfiguration {

    /**
     * @param customizers    Configuration in application.yaml
     * @return
     */
//    @Bean
//    public GsonBuilder gsonBuilder(List<GsonBuilderCustomizer> customizers) {
//
//        GsonBuilder builder = new GsonBuilder();
//        // Enable the spring.gson.* configuration in the configuration file
//        customizers.forEach((c) -> c.customize(builder));
//
//        /**
//         * Custom Gson configuration
//         */
//        builder.registerTypeHierarchyAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
//
//            DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//            @Override
//            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
//                return new JsonPrimitive(DATE_TIME_FORMATTER.format(src));
//            }
//        });
//
//        return builder;
//    }
}
