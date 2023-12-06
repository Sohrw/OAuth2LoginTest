package rinfos.project.domain.post;

import org.springframework.stereotype.Service;
import rinfos.project.domain.post.Post;
import rinfos.project.domain.post.dto.PostSaveDto;
import rinfos.project.domain.post.dto.PostUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Long save(PostSaveDto postSaveDto);

    void update(Long id, PostUpdateDto postUpdateDto);

    List<Post> findAll();

    Optional<Post> findById(Long id);

    List<Post> findByTitle(String title);

}
