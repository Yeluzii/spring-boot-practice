package top.ychen.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Special {
    private Long id;
    private String title;
    private String introduction;
    private Integer viewCount;
    private Integer followersCount;
    private Byte isFollowing;
    private String bannerUrl;
    private String updated;
    private List<Section> sections;
}
