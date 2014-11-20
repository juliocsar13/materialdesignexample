package cbedoy.materialdesignexample.artifacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 11/20/14.
 */
public abstract class AbstractCell extends BaseAdapter
{
    protected Context context;
    protected LayoutInflater layoutInflater;
    protected ArrayList<HashMap<String, Object>>dataModel;
    protected ICellViewDelegate viewDelegate;

    public AbstractCell(Context context, LayoutInflater layoutInflater, ArrayList<HashMap<String, Object>> dataModel){
        this.dataModel = dataModel;
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    public void setViewDelegate(ICellViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
    }

    @Override
    public int getCount() {
        return dataModel.size();
    }

    @Override
    public Object getItem(int i) {
        return dataModel.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }



    protected View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            viewDelegate.didUserSelectedCellAtIndex(view.getId());
        }
    };

    public interface ICellViewDelegate
    {
        public void didUserSelectedCellAtIndex(int index);
    }
}
