package com.blog.SpringBootblog.config.auth;

import com.blog.SpringBootblog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {
    private User user;

    public PrincipalDetail(User user){
        this.user = user;
    }

    // 시큐리티가 로그인 완료 후 UserDetails 타입의 오브젝트를 고유 세션 저장소에 저장함
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정 잠김 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정 활성화 여부 반환
    @Override
    public boolean isEnabled() {
        return true;
    }

    //계정 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_"+user.getRole(); //ROLE_USER -> "ROLE_"+ 는 정해진 법칙
//            }
//        });
        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });
        return collectors;
    }
}
