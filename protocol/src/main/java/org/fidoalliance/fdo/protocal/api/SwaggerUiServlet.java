package org.fidoalliance.fdo.protocol.api;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SwaggerUiServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String swaggerUiPath = "/path/to/swagger-ui"; // 设置 Swagger UI 所在的目录路径
        String swaggerUiFile = swaggerUiPath + "/index.html";

        File file = new File(swaggerUiFile);
        if (file.exists()) {
            resp.setContentType("text/html");
            Files.copy(file.toPath(), resp.getOutputStream());
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
