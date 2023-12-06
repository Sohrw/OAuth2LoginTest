package rinfos.project.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rinfos.project.config.auth.dto.SessionUser;
import rinfos.project.domain.post.Post;
import rinfos.project.domain.post.PostRepository;
import rinfos.project.domain.post.dto.PostSaveDto;
import rinfos.project.domain.post.dto.PostUpdateDto;
import rinfos.project.domain.user.User;
import rinfos.project.domain.user.UserService;
import rinfos.project.domain.post.PostService;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final HttpSession httpSession;
    private final UserService userService;

    @GetMapping("/save")
    public String savePost(Model model) {
        model.addAttribute("post", new PostSaveDto());
        return "/post/save";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute PostSaveDto postSaveDto) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userService.findByName(sessionUser.getName()).orElse(new User());
        postSaveDto.setAuthor(user);

        postService.save(postSaveDto);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String detailPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).get();

        model.addAttribute("post", post);

        return "post/detail";
    }



}
