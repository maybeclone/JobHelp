package com.slient.jobhelp.utils;

import com.slient.jobhelp.models.data.LabelGroupQuestion;
import com.slient.jobhelp.models.database.data.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by silent on 5/4/2018.
 */
public class GroupQuestionUtils {

    public static ArrayList<LabelGroupQuestion> getMaxPointGroup(Map<LabelGroupQuestion, Integer> mapPoint){
        int maxPoint = 0;
        ArrayList<LabelGroupQuestion> arr = new ArrayList<>();
        for(LabelGroupQuestion key : LabelGroupQuestion.values()){
            if(mapPoint.get(key) > maxPoint){
                arr.clear();
                maxPoint = mapPoint.get(key);
                arr.add(key);
            } else if(mapPoint.get(key) == maxPoint){
                arr.add(key);
            }
        }
        return arr;
    }

}
