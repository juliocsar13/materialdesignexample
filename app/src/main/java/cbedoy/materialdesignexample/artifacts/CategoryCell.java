package cbedoy.materialdesignexample.artifacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import cbedoy.materialdesignexample.R;

/**
 * Created by admin on 11/19/14.
 */
public class CategoryCell extends BaseAdapter
{
    private final Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Integer> dataModel;


    public CategoryCell(Context context, ArrayList<Integer> dataModel, LayoutInflater layoutInflater){
        this.context = context;
        this.dataModel = dataModel;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return dataModel.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.cagory_cell, null);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    static class ViewHolder{
        ImageView categoryImage;
    }
}
