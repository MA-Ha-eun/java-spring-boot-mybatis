package coding.spring_boot_mybatis.controller;

import coding.spring_boot_mybatis.dto.PostDTO;
import coding.spring_boot_mybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<PostDTO> listPosts() {
        return boardService.getAllPosts();
    }

    @GetMapping("/{writer}")
    public PostDTO getPost(@PathVariable String writer) {
        return boardService.getPostByWriter(writer);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        boardService.createPost(postDTO);
        return postDTO;
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        postDTO.setId(id);
        boardService.updatePost((postDTO));
        return postDTO;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        boardService.deletePost(id);
    }
}
