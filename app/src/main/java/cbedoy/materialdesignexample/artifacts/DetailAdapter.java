package cbedoy.materialdesignexample.artifacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import cbedoy.materialdesignexample.ApplicationLoader;
import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.interfaces.ICellViewDelegate;

/**
 * Created by admin on 11/21/14.
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> implements View.OnClickListener{

    private List<HashMap<String, Object>> dataModel;
    private ICellViewDelegate viewDelegate;

    public void setViewDelegate(ICellViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
    }

    public DetailAdapter(List<HashMap<String, Object>> dataModel){
        this.dataModel = dataModel;
    }

    @Override
    public void onClick(View view) {
        if(viewDelegate!=null)
            viewDelegate.didUserSelectedCellAtIndex(view.getId());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconView;
        public TextView titleView;
        public TextView messageView;

        public ViewHolder(View v) {
            super(v);
            iconView = (ImageView) v.findViewById(R.id.view);
            titleView = (TextView) v.findViewById(R.id.textView2);
            messageView = (TextView) v.findViewById(R.id.textView3);
        }
    }

    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_cell, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailAdapter.ViewHolder viewHolder, int position) {
        HashMap<String, Object> information = dataModel.get(position);

        viewHolder.titleView.setText(information.get("Title").toString());
        viewHolder.messageView.setText(information.get("Value").toString());
        viewHolder.iconView.setImageResource(Integer.parseInt(information.get("Icon").toString()));

        viewHolder.titleView.setTypeface(ApplicationLoader.regularFont);
        viewHolder.messageView.setTypeface(ApplicationLoader.regularFont);

    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }
}
