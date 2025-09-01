package coding.spring_boot_mybatis.service;

import coding.spring_boot_mybatis.domain.Post;
import coding.spring_boot_mybatis.dto.PostDTO;
import coding.spring_boot_mybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public List<PostDTO> getAllPosts() {
        List<Post> posts = boardMapper.findAll();

        List<PostDTO> postDTOs = new ArrayList<>();

        for (Post post:posts) {
            PostDTO postDTO = convertToDto(post);
            postDTOs.add(postDTO);
        }

        return postDTOs;
    }

    public PostDTO getPostByWriter(String writer) {
        Post post = boardMapper.findByWriter(writer);

        return convertToDto(post);
    }

    public void createPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        boardMapper.insert(post);
    }

    public void updatePost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        boardMapper.update(post);
    }

    public void deletePost(Long id) {
        boardMapper.delete(id);
    }

    private PostDTO convertToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setWriter(post.getWriter());
        dto.setNo((int) (post.getId() + 100));

        return dto;
    }

    private Post convertToEntity(PostDTO dto) {
        Post post = new Post();
        post.setId((dto.getId()));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setWriter(dto.getWriter());

        return post;
    }
}
