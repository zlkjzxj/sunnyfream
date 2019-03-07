package com.sunny.sunnyfream.business.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-07 14:10
 */
@Data
@NoArgsConstructor
public class Project {
    private String cpxxwcqk;
    private String createTime;
    private String department;
    private String fawcqk;
    private String hkqk;
    private String hktz;
    private String htje;
    private String htqd;
    private String jcjd;
    private String manager;
    private String ml;
    private String projectName;
    private String projectNumber;
    private String rjkfjd;
    private String sgqr;
    private String whje;
    private String whsx;
    private String yjcg;
    private String yzjhbqd;
    private String zbj;
    private String zbjthqk;
    private String zbzzwcqk;
    //录入人
    private String lrr;

    @Override
    public String toString() {
        return "Project{" +
                "cpxxwcqk='" + cpxxwcqk + '\'' +
                ", createTime='" + createTime + '\'' +
                ", department='" + department + '\'' +
                ", fawcqk='" + fawcqk + '\'' +
                ", hkqk='" + hkqk + '\'' +
                ", hktz='" + hktz + '\'' +
                ", htje='" + htje + '\'' +
                ", htqd='" + htqd + '\'' +
                ", jcjd='" + jcjd + '\'' +
                ", manager='" + manager + '\'' +
                ", ml='" + ml + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectNumber='" + projectNumber + '\'' +
                ", rjkfjd='" + rjkfjd + '\'' +
                ", sgqr='" + sgqr + '\'' +
                ", whje='" + whje + '\'' +
                ", whsx='" + whsx + '\'' +
                ", yjcg='" + yjcg + '\'' +
                ", yzjhbqd='" + yzjhbqd + '\'' +
                ", zbj='" + zbj + '\'' +
                ", zbjthqk='" + zbjthqk + '\'' +
                ", zbzzwcqk='" + zbzzwcqk + '\'' +
                '}';
    }
}
