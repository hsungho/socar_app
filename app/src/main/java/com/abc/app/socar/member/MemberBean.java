package com.abc.app.socar.member;

/**
 * Created by hb2009 on 2016-08-03.
 */
public class MemberBean {

    String id,pw,name,phone,address,region,job,licenceVal,licenceLocal,licenceNum,licenceEnd,licenceStart,birth,gender;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLicenceVal() {
        return licenceVal;
    }

    public void setLicenceVal(String licenceVal) {
        this.licenceVal = licenceVal;
    }

    public String getLicenceLocal() {
        return licenceLocal;
    }

    public void setLicenceLocal(String licenceLocal) {
        this.licenceLocal = licenceLocal;
    }

    public String getLicenceNum() {
        return licenceNum;
    }

    public void setLicenceNum(String licenceNum) {
        this.licenceNum = licenceNum;
    }

    public String getLicenceEnd() {
        return licenceEnd;
    }

    public void setLicenceEnd(String licenceEnd) {
        this.licenceEnd = licenceEnd;
    }

    public String getLicenceStart() {
        return licenceStart;
    }

    public void setLicenceStart(String licenceStart) {
        this.licenceStart = licenceStart;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", address=" + address
                + ", region=" + region + ", job=" + job + ", licenceVal=" + licenceVal + ", licenceLocal="
                + licenceLocal + ", licenceNum=" + licenceNum + ", licenceEnd=" + licenceEnd + ", licenceStart="
                + licenceStart + ", birth=" + birth + ", gender=" + gender + "]";
    }


}
