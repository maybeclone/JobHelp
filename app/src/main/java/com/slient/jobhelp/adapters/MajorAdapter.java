package com.slient.jobhelp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.slient.jobhelp.R;
import com.slient.jobhelp.models.data.HeaderMajorGroup;
import com.slient.jobhelp.models.data.Major;

import java.util.List;

/**
 * Created by silent on 5/7/2018.
 */
public class MajorAdapter extends BaseExpandableListAdapter {

    private List<HeaderMajorGroup> headerMajorGroupList;

    public MajorAdapter(List<HeaderMajorGroup> headerMajorGroupList){
        this.headerMajorGroupList = headerMajorGroupList;
    }

    @Override
    public int getGroupCount() {
        if(headerMajorGroupList == null){
            return 0;
        }
        return headerMajorGroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(headerMajorGroupList == null){
            return 0;
        }
        return headerMajorGroupList.get(groupPosition).majors.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerMajorGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return headerMajorGroupList.get(groupPosition).majors.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_major_row, parent, false);
        }

        HeaderMajorGroup headerMajorGroup = headerMajorGroupList.get(groupPosition);
        TextView headingText = convertView.findViewById(R.id.headingText);
        headingText.setText(headerMajorGroup.name);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_major_row, parent, false);
        }
        Major major = headerMajorGroupList.get(groupPosition).majors.get(childPosition);
        TextView majorNameText = convertView.findViewById(R.id.majorNameText);
        majorNameText.setText(major.name);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void swapList(List<HeaderMajorGroup> headerMajorGroupList){
        this.headerMajorGroupList = headerMajorGroupList;
        notifyDataSetChanged();
    }
}
