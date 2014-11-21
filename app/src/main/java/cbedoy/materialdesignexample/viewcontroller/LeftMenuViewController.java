package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import cbedoy.materialdesignexample.ApplicationLoader;
import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.artifacts.DetailAdapter;
import cbedoy.materialdesignexample.artifacts.LeftMenuAdapter;
import cbedoy.materialdesignexample.interfaces.ICellViewDelegate;

/**
 * Created by admin on 11/19/14.
 */
public class LeftMenuViewController  extends AbstractViewController implements ICellViewDelegate
{
    private RecyclerView menuRecyclerView;
    private LeftMenuAdapter menuAdapter;
    private RecyclerView.LayoutManager layoutAdapter;
    private ArrayList<HashMap<String, Object>> dataModel;
    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.left_view_controller,  null);

        menuRecyclerView = (RecyclerView) view.findViewById(R.id.list_view);
        layoutAdapter = new LinearLayoutManager(viewManager.getActivity());
        dataModel = new ArrayList<HashMap<String, Object>>();
        menuRecyclerView.setHasFixedSize(true);
        menuRecyclerView.setLayoutManager(layoutAdapter);

        HashMap<String, Object> data;
        data = new HashMap<String, Object>();
        data.put("Title", "Name");
        data.put("Value", "Carlos Bedoy");
        data.put("Icon", R.drawable.category_one);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Points");
        data.put("Value", "129293");
        data.put("Icon", R.drawable.category_two);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Phone");
        data.put("Value", "4494674121");
        data.put("Icon", R.drawable.category_three);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Nickname");
        data.put("Value", "cbedoy");
        data.put("Icon", R.drawable.category_four);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "University");
        data.put("Value", "UAA");
        data.put("Icon", R.drawable.category_two);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Language");
        data.put("Value", "Java & Objective - C");
        data.put("Icon", R.drawable.category_three);
        dataModel.add(data);

        menuAdapter = new LeftMenuAdapter(dataModel);
        menuAdapter.setViewDelegate(this);
        menuRecyclerView.setAdapter(menuAdapter);

        ((TextView)view.findViewById(R.id.textView4)).setTypeface(ApplicationLoader.regularFont);
        ((TextView)view.findViewById(R.id.textView5)).setTypeface(ApplicationLoader.lightFont);

        ((TextView)view.findViewById(R.id.textView4)).setTextColor(context.getResources().getColor(R.color.primary_material_light));
        ((TextView)view.findViewById(R.id.textView5)).setTextColor(context.getResources().getColor(R.color.primary_material_light));
        return view;
    }

    @Override
    public void reload() {

    }

    @Override
    public void didUserSelectedCellAtIndex(int index) {

    }
}
