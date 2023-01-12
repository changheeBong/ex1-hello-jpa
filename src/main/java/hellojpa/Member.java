package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "USER") --> 테이블 매핑 방법
public class Member extends BaseEntity{



//    @Column(name = "username")  -- > 컬럼명 매핑 방법
   @Id
   @GeneratedValue
   @Column(name=  "MEMBER_ID")
   private Long id;

   @Column(name = "USERNAME")
   private String username;

   //@Column(name = "TEAM_ID")
   //private Long teamId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team team;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
