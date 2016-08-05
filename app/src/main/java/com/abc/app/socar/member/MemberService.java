package com.abc.app.socar.member;

import java.util.List;

/**
 * Created by hb2009 on 2016-08-03.
 */
public interface MemberService {

    public MemberBean findById(String findID);//회원정보보기
    public void regist(MemberBean member);//회원가입
    public void updateInfo(MemberBean member);//회원정보수정
    public boolean login(MemberBean member);//로그인
    public void logout();//로그아웃
    public void leave(MemberBean member);//계정삭제
    public MemberBean getSession();
    public List<?> list();
}
