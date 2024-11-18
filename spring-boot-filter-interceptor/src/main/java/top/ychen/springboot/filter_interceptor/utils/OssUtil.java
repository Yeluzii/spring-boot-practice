package top.ychen.springboot.filter_interceptor.utils;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.ychen.springboot.filter_interceptor.config.OssConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.UUID;



@Slf4j
@Component
public class OssUtil {
    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    public String uploadFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名不能为空");
            }
            String fileName = "upload/" + UUID.randomUUID() + "_" + originalFilename;
// 将MultipartFile转换为BufferedImage
            BufferedImage originalImage = ImageIO.read(file.getInputStream());

            // 创建一个新的BufferedImage对象，用于绘制水印
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();
            BufferedImage watermarkedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = watermarkedImage.createGraphics();

            // 绘制原始图片
            g2d.drawImage(originalImage, 0, 0, null);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 40));

            // 添加水印文本
            String watermarkText = "ychen";
            g2d.rotate(-Math.PI / 4);
            g2d.drawString(watermarkText, 0, height/3);
            g2d.setColor(Color.RED);
            g2d.drawString(watermarkText, 0, height/2);
            g2d.setColor(Color.BLUE);
            g2d.drawString(watermarkText, 0, height*2/3);
            g2d.setColor(Color.GREEN);
            g2d.drawString(watermarkText, 0, height*3/4);

            // 释放资源
            g2d.dispose();

            // 将BufferedImage保存为MultipartFile
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(watermarkedImage, "jpg", bao);
            byte[] watermarkedImageBytes = bao.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(watermarkedImageBytes);
            ossClient.putObject(ossConfig.getBucketName(), fileName, bais);
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint() + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }

}
