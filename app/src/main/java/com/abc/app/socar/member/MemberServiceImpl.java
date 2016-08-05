package com.abc.app.socar.member;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by hb2009 on 2016-08-03.
 */
public class MemberServiceImpl implements MemberService{

    MemberDAO dao;
    MemberBean session;

    public MemberServiceImpl(Context context) {

        dao = new MemberDAO(context);
    }



    @Override
    public MemberBean findById(String findID) {
        return dao.findById(findID);
    }

    @Override
    public void regist(MemberBean member) {

        dao.insert(member);
    }

    @Override
    public void updateInfo(MemberBean member) {
        int result = dao.update(member);
        if (result == 1) {
            System.out.println("서비스 수정결과 성공");
        }else{
            System.out.println("서비스 수정결과 실패");
        }

    }

    @Override
    public boolean login(MemberBean member) {
            session = findById(member.getId());
        Log.d("session", session.toString());
            return dao.login(member);
    }

    @Override
    public void logout() {

        session = null;


    }

    @Override
    public void leave(MemberBean member) {
        if (dao.leave(member)==1) {
            session = null;
        }
    }

    @Override
    public List<?> list() {

        return dao.list();
    }
    public MemberBean getSession() {
        return session;
    }

}

