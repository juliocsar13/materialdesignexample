package cbedoy.materialdesignexample.artifacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;

import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.interfaces.ICellViewDelegate;

/**
 * Created by admin on 11/21/14.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> implements View.OnClickListener{

    private List<HashMap<String, Object>> dataModel;
    private ICellViewDelegate viewDelegate;

    public void setViewDelegate(ICellViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
    }

    public CategoryAdapter(List<HashMap<String, Object>> dataModel){
        this.dataModel = dataModel;
    }

    @Override
    public void onClick(View view) {
        if(viewDelegate!=null)
            viewDelegate.didUserSelectedCellAtIndex(view.getId());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryImage;

        public ViewHolder(View v) {
            super(v);
            categoryImage = (ImageView) v.findViewById(R.id.image);
        }
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cagory_cell, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder viewHolder, int position) {

        HashMap<String, Object> hashMap = dataModel.get(position);
        viewHolder.categoryImage.setImageResource(position == 0 ? R.drawable.category_one : position == 1 ? R.drawable.category_two :position == 2 ? R.drawable.category_three : R.drawable.category_four);
        viewHolder.categoryImage.setId(position);
        viewHolder.categoryImage.setOnClickListener(this);
        viewHolder.categoryImage.setTag(hashMap);

    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }
}
