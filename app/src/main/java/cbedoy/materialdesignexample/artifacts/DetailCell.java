package cbedoy.materialdesignexample.artifacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.HashMap;

import cbedoy.materialdesignexample.R;

/**
 * Created by admin on 11/20/14.
 */
public class DetailCell extends AbstractCell
{


    public DetailCell(Context context, LayoutInflater layoutInflater, ArrayList<HashMap<String, Object>> dataModel) {
        super(context, layoutInflater, dataModel);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.cagory_cell, null);
            viewHolder.categoryImage = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.rippleView = (RippleView) convertView.findViewById(R.id.more);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rippleView.setId(position);
        viewHolder.categoryImage.setId(position);
        viewHolder.rippleView.setOnClickListener(clickListener);
        viewHolder.categoryImage.setImageResource(position == 0 ? R.drawable.category_one : position == 1 ? R.drawable.category_two : position == 2 ? R.drawable.category_three : R.drawable.category_four);
        return convertView;
    }

    static class ViewHolder{
        ImageView categoryImage;
        RippleView rippleView;
    }

}
