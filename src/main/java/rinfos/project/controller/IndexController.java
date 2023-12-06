package rinfos.project.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinfos.project.config.auth.dto.SessionUser;
import rinfos.project.domain.post.Post;
import rinfos.project.domain.post.PostService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final HttpSession httpSession;
    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String title) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        List<Post> posts = null;

        if (!StringUtils.isEmpty(title)) {
            posts = postService.findByTitle(title);

        } else{
            posts = postService.findAll();

        }


        model.addAttribute("posts", posts);
        model.addAttribute("searchTitle", title);



        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }



}
