package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.artifacts.CategoryCell;

/**
 * Created by admin on 11/19/14.
 */
public class CategoryViewController extends AbstractViewController
{

    private ListView categoryList;
    private CategoryCell categoryCell;
    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_view_controller,  null);
        categoryList = (ListView) view.findViewById(R.id.list_view);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0); list.add(1); list.add(3); list.add(4);

        categoryCell = new CategoryCell(context, list, inflater);


        categoryList.setAdapter(categoryCell);
        categoryCell.notifyDataSetChanged();


        return view;
    }

    @Override
    public void reload() {

    }

    public void initApp(){
        viewManager.presentViewForTag(this.tag);
    }



}
