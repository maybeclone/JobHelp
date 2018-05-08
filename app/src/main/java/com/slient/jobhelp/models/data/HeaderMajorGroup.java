package com.slient.jobhelp.models.data;

import java.util.List;

/**
 * Created by silent on 5/7/2018.
 */
public class HeaderMajorGroup {

    public String name;
    public List<Major> majors;

    public HeaderMajorGroup(String name, List<Major> majors){
        this.name = name;
        this.majors = majors;
    }

}
