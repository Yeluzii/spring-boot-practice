package top.ychen.springboot.configure.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import top.ychen.springboot.configure.loader.YamlPropertyLoader;

@Data
@Component
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = YamlPropertyLoader.class)
@Validated
public class Family {
    @Length(min = 5, max = 10, message = "家庭名称必须在5到10之间！")
    private String familyName;
    private String father;
    private String mother;
    private String child;

    @Range(min = 3, message = "年龄必须大于3年！")
    private Integer age;

//    @Value("${family.family-name}")
//    private String familyName;
//    @Value("${family.father}")
//    private String father;
//    @Value("${family.mother}")
//    private String mother;
//    @Value("${family.child}")
//    private String child;
//    @Value("${family.age}")
//    private Integer age;
}
