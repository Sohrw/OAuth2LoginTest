package rinfos.project.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rinfos.project.domain.post.Post;
import rinfos.project.domain.user.User;

@Getter
@NoArgsConstructor
@Setter
public class PostSaveDto {
    private String title;
    private User author;
    private String content;

    @Builder
    public PostSaveDto(String title, User author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
