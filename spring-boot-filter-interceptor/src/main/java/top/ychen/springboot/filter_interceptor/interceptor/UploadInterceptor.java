package top.ychen.springboot.filter_interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@Component
@Slf4j
public class UploadInterceptor implements HandlerInterceptor {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 20 MB
    private static final Path UPLOAD_LOG_PATH = Paths.get("D:/uploads/upload_log.log");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        if (file == null || file.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter(response, "没有文件被上传或文件为空");
            return false;
        }

        log.info(file.getOriginalFilename());

        try {
            // 检查文件大小
            if (file.getSize() > MAX_FILE_SIZE) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter(response, "文件大小超过限制");
                return false;
            }

            // 记录文件信息
            recordFileInfo(file);

            // 检查并处理图片
            if (isImageFile(file)) {
                processImage(file);
            } else {
                log.info("类型不是图片");
            }
        } catch (IOException e) {
            log.error("处理文件时发生错误", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWriter(response, "内部服务器错误");
            return false;
        }

        return true;
    }

    private void responseWriter(HttpServletResponse response, String message) throws IOException {
        response.getWriter().write(message);
    }

    private void recordFileInfo(MultipartFile file) throws IOException {
        String info = String.format("文件名: %s - 文件大小: %d bytes - MIME类型: %s - 上传时间: %s\n",
                file.getOriginalFilename(), file.getSize(), file.getContentType(), LocalDateTime.now());

        Files.createDirectories(UPLOAD_LOG_PATH.getParent());
        Files.write(UPLOAD_LOG_PATH, info.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }

    private void processImage(MultipartFile file) throws IOException {
        try (var inputStream = file.getInputStream()) {
            BufferedImage image = ImageIO.read(inputStream);
            if (image != null) {
                log.info("图片尺寸: {} x {}", image.getWidth(), image.getHeight());
            }
        }
    }
}