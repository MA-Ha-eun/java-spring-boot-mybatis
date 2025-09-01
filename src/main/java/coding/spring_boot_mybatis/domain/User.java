package coding.spring_boot_mybatis.domain;

// domain.User 클래스
// - 데이터베이스 엔티티(객체. 대상 하나하나)를 표현하는 도메인
// - 실제 데이터의 역할이므로 "테이블 구조"와 동일해야 함

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String email;
    private String createdAt;
}
