package lt.e2projects.portfolio.api.configurations;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.constants.FilesFolder;
import lt.e2projects.portfolio.api.constants.Headers;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableOpenApi
@RequiredArgsConstructor
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {

    private final SwaggerProperties properties;

    @Bean
    Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .directModelSubstitute(LocalDateTime.class, String.class)
                .groupName("Portfolio Data")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    @Bean
    UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.NONE)
                .operationsSorter(OperationsSorter.ALPHA)
                .defaultModelRendering(ModelRendering.MODEL)
                .displayRequestDuration(true)
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .version(properties.getVersion())
                .title(properties.getTitle())
                .description(properties.getDescription())
                .build();
    }

//    private RequestParameterBuilder headerParameterBuilder(String name) {
//        return new RequestParameterBuilder()
//                .name(name)
//                .description(name)
//                .required(false)
//                .in(ParameterType.HEADER);
//    }
//
//    private RequestParameter folderRequestParameter() {
//        return headerParameterBuilder(Headers.STORAGE_FOLDER_NAME)
//                .query(q ->
//                q.model(m -> m.scalarModel(ScalarType.STRING))
//                        .defaultValue("")
//                        .enumerationFacet(e -> e.allowedValues(
//                                new AllowableListValues(List.of(FilesFolder.PROFILE_PICTURE, FilesFolder.CV), "string")))
//                ).build();
//    }

}
