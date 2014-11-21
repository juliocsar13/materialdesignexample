package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.artifacts.CategoryAdapter;
import cbedoy.materialdesignexample.interfaces.ICellViewDelegate;


/**
 * Created by admin on 11/19/14.
 */
public class CategoryViewController extends AbstractViewController implements ICellViewDelegate
{

    private RecyclerView catogoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView.LayoutManager layoutAdapter;
    private List<HashMap<String, Object>> dataModel;


    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_view_controller,  null);

        catogoryRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        layoutAdapter = new LinearLayoutManager(viewManager.getActivity());
        dataModel = new ArrayList<HashMap<String, Object>>();
        catogoryRecyclerView.setHasFixedSize(true);
        catogoryRecyclerView.setLayoutManager(layoutAdapter);

        HashMap<String, Object> data = new HashMap<String, Object>();
        dataModel.add(data);
        dataModel.add(data);
        dataModel.add(data);
        dataModel.add(data);

        categoryAdapter = new CategoryAdapter(dataModel);
        categoryAdapter.setViewDelegate(this);
        catogoryRecyclerView.setAdapter(categoryAdapter);
        return view;
    }

    @Override
    public void reload() {
        viewManager.getToolbar().setNavigationIcon(R.drawable.ic_ab_drawer);
        viewManager.getToolbar().setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
    }

    public void initApp(){
        viewManager.presentViewForTag(this.tag);
    }


    @Override
    public void didUserSelectedCellAtIndex(int index) {
        viewManager.presentViewForTag(CONTROLLER.DETAIL_SERVICE);
    }
}
