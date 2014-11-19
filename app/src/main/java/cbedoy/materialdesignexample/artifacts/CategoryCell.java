package cbedoy.materialdesignexample.artifacts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admin on 11/19/14.
 */
public class CategoryCell extends BaseAdapter
{
    private final Context context;
    private ArrayList<HashMap<String, Object>> dataModel;


    private CategoryCell(Context context, ArrayList<HashMap<String, Object>> dataModel){
        this.context = context;
        this.dataModel = dataModel;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
