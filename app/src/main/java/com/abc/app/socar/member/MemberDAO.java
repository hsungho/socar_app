package com.abc.app.socar.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2009 on 2016-08-03.
 */
public class MemberDAO extends SQLiteOpenHelper{



    public static final String TABLE_NAME ="member";
    public static final String ID ="id";
    public static final String PW ="pw";
    public static final String NAME ="name";
    public static final String PHONE ="phone";
    public static final String ADDRESS ="address";


    public MemberDAO(Context context){
        super(context,"socardb",null,1);
        Log.d("DdB 생성체크","========여기까지 진입=======");
        this.getWritableDatabase();

     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DAO 생성체트","========생성확인=======");
       String sql = "create table if not exists "
                +TABLE_NAME
                +" ( "
                +ID+" text primary key, "
                +PW+" text, "
                +NAME+" text, "
                +PHONE+" text, "
                +ADDRESS+" text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists "+TABLE_NAME;
        db.execSQL(sql);
        this.onCreate(db);
    }




    public int insert(MemberBean mem) {
        int result = 0;
        String sql = "insert into "+TABLE_NAME
                +String.format("(%s,%s,%s,%s,%s) ",ID,PW,NAME,PHONE,ADDRESS)
                +String.format(" values('%s','%s','%s','%s','%s');"
                ,mem.getId()
                ,mem.getPw()
                ,mem.getName()
                ,mem.getPhone()
                ,mem.getAddress()
                );
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
            return result;

    }

    public MemberBean findById(String pk) {
        String sql = "select "
                +String.format("%s,%s,%s,%s,%s ",ID,PW,NAME,PHONE,ADDRESS)
                +String.format("from "+TABLE_NAME+" where id= '%s' ;",pk);
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor !=null){
            Log.d("DAO FIND_BY_ID ","ID 조회 성공 !!");
            if (cursor.moveToFirst()){
                temp = new MemberBean();
                temp.setId(cursor.getString(0));
                temp.setPw(cursor.getString(1));
                temp.setName(cursor.getString(2));
                temp.setPhone(cursor.getString(3));
                temp.setAddress(cursor.getString(4));

            }
        }
        return temp;
    }


    public int update(MemberBean member) {
        int result = 0;
       String.format(

          member.getPw()
          ,member.getPhone()
           ,member.getAddress()
         ,member.getRegion()
         ,member.getJob()
          ,member.getId()

       );

        return result;
    }

    public boolean login(MemberBean param) {
        boolean loginOk = false;
        String sql = "select "+PW+" from "+TABLE_NAME+String.format(" where id = '%s';",param.getId()) ;
        SQLiteDatabase db = this.getReadableDatabase();
        String pw = "";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()) {
            pw = cursor.getString(0);
        }
        if (pw.equals("")){
            Log.d("DAO 로그인 결과  :", "일치하는 ID가 없음");
            loginOk = false;
        }else {
            Log.d("DAO ID :",param.getId());
            Log.d("DAO PW :",pw);
            loginOk = (pw.equals(param.getPw()))?true :false ;
        }

        System.out.print("LOGIN_OK ?"+loginOk);

        return loginOk;
    }

    private boolean existId(String id) {
        int result = 0;
        boolean existOk = false;
        String sql = "select count(*) as count from member where id = ?";

//
//            pstmt.setString(1, id);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                result = rs.getInt("count");
//                System.out.println("ID카운트 결과"+result);
//            }

        return existOk;
    }



    public int leave(MemberBean member) {
        int result = 0;
        String sql = "delete from member where id = ? and pw = ?";
//        try {
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, member.getId());
//            pstmt.setString(2, member.getPw());
//            result = pstmt.executeUpdate();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        if (result == 1) {
//            System.out.println("성공");
//        }else{
//            System.out.println("실패");
//        }

        return result;
    }

    public List<MemberBean> list() {
        String sql = "select * from member";
        List<MemberBean> list = new ArrayList<MemberBean>();
//        try {
//            pstmt = con.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                MemberBean mem = new MemberBean();
//                mem.setId(rs.getString("ID"));
//                mem.setPw(rs.getString("PW"));
//                mem.setName(rs.getString("NAME"));
//                mem.setPhone(rs.getString("PHONE"));
//                mem.setAddress(rs.getString("ADDRESS"));
//                mem.setRegion(rs.getString("REGION"));
//                mem.setJob(rs.getString("JOB"));
//                mem.setBirth(rs.getString("BIRTH"));
//                mem.setGender(rs.getString("GENDER"));
//                list.add(mem);
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


        return null;
    }

}
