package rinfos.project.domain.post;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rinfos.project.domain.post.dto.PostSaveDto;
import rinfos.project.domain.post.dto.PostUpdateDto;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Long save(PostSaveDto postSaveDto) {

        return postRepository.save(postSaveDto.toEntity()).getId();
    }

    @Override
    public void update(Long id, PostUpdateDto postUpdateDto) {
        if (postRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id);
        }
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        post.setTitle(postUpdateDto.getTitle());
        post.setContent(postUpdateDto.getContent());
        postRepository.save(post);
    }


    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }
}
