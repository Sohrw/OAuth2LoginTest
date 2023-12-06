package rinfos.project.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rinfos.project.domain.post.dto.PostUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

    List<Post> findAll();

    @Query("select p from Post p where p.title like %:title%")
    List<Post> findByTitle(@Param("title") String title);
}
