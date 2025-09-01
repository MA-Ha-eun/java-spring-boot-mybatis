package coding.spring_boot_mybatis.mapper;

import coding.spring_boot_mybatis.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board")
    List<Post> findAll();

    @Select("SELECT * FROM board where writer = #{writer}")
    Post findByWriter(String writer);

    @Insert("INSERT INTO board (title, content, writer) value (#{title}, #{content}, #{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Post post);

    @Update("Update board SET title = #{title}, content = #{content} WHERE id = #{id}")
    void update(Post post);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void delete(Long id);
}
