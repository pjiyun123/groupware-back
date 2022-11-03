package com.team4.groupwareproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
public class User extends AuditingFields {

    @Id
    @Column(length = 20)
    private int userId;

    @Setter @ManyToOne(optional = false) @JoinColumn(name = "deptNo") private Dept dept; // 부서 정보
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "authorId") private Authorization authorization; // 권한 정보
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "rankId") private Rank rank; // 직급 정보

    @Setter @Column(nullable = false) private String userName;
    @Setter @Column(nullable = false) private String password;
    @Setter @Column private LocalDateTime birthDate;
    @Setter @Column(length = 20) private String phone;
    @Setter @Column(length = 250) private String email;
    @Setter private String picture;

    protected User() {}
    private User(int userId, String userName, String password, LocalDateTime birthDate, String phone, String email, String picture) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.picture = picture;
    }
    public static User of(int userId, String userName, String password, LocalDateTime birthDate, String phone, String email, String picture) {
        return new User(userId, userName, password, birthDate, phone, email, picture);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return userId != 0 && userId == that.getUserId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}