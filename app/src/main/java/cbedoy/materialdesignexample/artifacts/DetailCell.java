package cbedoy.materialdesignexample.artifacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.HashMap;
import cbedoy.materialdesignexample.R;

/**
 * Created by admin on 11/20/14.
 */
public class DetailCell extends AbstractCell
{


    public DetailCell(Context context, LayoutInflater layoutInflater, ArrayList<Integer> dataModel) {
        super(context, layoutInflater, dataModel);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.detail_cell, null);
            viewHolder.detailImage = (ImageView) convertView.findViewById(R.id.view);
            viewHolder.rippleView = (RippleView) convertView.findViewById(R.id.more);
            viewHolder.titleView = (TextView) convertView.findViewById(R.id.textView2);
            viewHolder.valueView = (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rippleView.setId(position);
        viewHolder.rippleView.setOnClickListener(clickListener);
        viewHolder.detailImage.setImageResource(position == 0 ? R.drawable.category_one : position == 1 ? R.drawable.category_two : position == 2 ? R.drawable.category_three : R.drawable.category_four);
        return convertView;
    }

    static class ViewHolder{
        ImageView detailImage;
        RippleView rippleView;
        TextView titleView;
        TextView valueView;
    }

}
