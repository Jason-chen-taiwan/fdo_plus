package org.fidoalliance.fdo.protocol.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@WebListener
public class SwaggerConfig implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info().title("FIDO Alliance FDO Protocol API")
                        .description("This API provides operations for FDO protocol")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));

        // 将 OpenAPI 对象保存到 ServletContext 中，这一步是可选的，取决于您是否需要在应用的其他部分访问这个 OpenAPI 实例
        sce.getServletContext().setAttribute("openapi", openAPI);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 在这里可以执行资源清理等收尾工作
    }
}
