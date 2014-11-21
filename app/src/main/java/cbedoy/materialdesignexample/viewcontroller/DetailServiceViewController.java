package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import cbedoy.materialdesignexample.ApplicationLoader;
import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.artifacts.DetailAdapter;
import cbedoy.materialdesignexample.interfaces.ICellViewDelegate;

/**
 * Created by admin on 11/19/14.
 */
public class DetailServiceViewController  extends AbstractViewController implements ICellViewDelegate
{
    private FloatingActionButton floatingActionButton;
    private FloatingActionButton informationButton;
    private RecyclerView detailRecyclerView;
    private DetailAdapter detailAdapter;
    private RecyclerView.LayoutManager layoutAdapter;
    private ArrayList<HashMap<String, Object>> dataModel;
    private RelativeLayout relativeLayout;
    private Random random;

    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.detail_service_view_controller,  null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        floatingActionButton.setColorNormal(Color.parseColor("#4CAF50"));
        floatingActionButton.setColorPressed(Color.parseColor("#388E3C"));

        informationButton = (FloatingActionButton) view.findViewById(R.id.info);
        informationButton.setColorNormal(Color.parseColor("#FAFAFA"));
        informationButton.setColorPressed(Color.parseColor("#EEEEEE"));

        detailRecyclerView = (RecyclerView) view.findViewById(R.id.list_view);
        floatingActionButton.attachToRecyclerView(detailRecyclerView);


        layoutAdapter = new LinearLayoutManager(viewManager.getActivity());
        dataModel = new ArrayList<HashMap<String, Object>>();
        detailRecyclerView.setHasFixedSize(true);
        detailRecyclerView.setLayoutManager(layoutAdapter);

        HashMap<String, Object> data;
        data = new HashMap<String, Object>();
        data.put("Title", "Amount");
        data.put("Value", "$10000.00");
        data.put("Icon", R.drawable.category_one);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Fee");
        data.put("Value", "$7.00");
        data.put("Icon", R.drawable.category_two);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Reference");
        data.put("Value", "123456789012345678");
        data.put("Icon", R.drawable.category_three);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Amount");
        data.put("Value", "$10000.00");
        data.put("Icon", R.drawable.category_four);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Phone");
        data.put("Value", "449-467-4121");
        data.put("Icon", R.drawable.category_two);
        dataModel.add(data);
        data = new HashMap<String, Object>();
        data.put("Title", "Birthday");
        data.put("Value", "18/May/1991");
        data.put("Icon", R.drawable.category_three);
        dataModel.add(data);

        detailAdapter = new DetailAdapter(dataModel);
        detailAdapter.setViewDelegate(this);
        detailRecyclerView.setAdapter(detailAdapter);


        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadColorView();
            }
        });

        random = new Random();




        return view;
    }

    private void reloadColorView()
    {
        int randomNumber = this.random.nextInt(3);

        viewManager.getToolbar().setTitle("Service name");
        int randomColor =                           randomNumber == 0 ? context.getResources().getColor(R.color.random_1_color_primary):
                                                    randomNumber == 1 ? context.getResources().getColor(R.color.random_2_color_primary):
                                                    randomNumber == 2 ? context.getResources().getColor(R.color.random_3_color_primary):
                                                                        context.getResources().getColor(R.color.random_4_color_primary);
        viewManager.getToolbar().setBackgroundColor(randomColor);
        relativeLayout.setBackgroundColor(randomColor);

        String format = "$.2f pesos";

        int i = random.nextInt(99999);
        float amount = 9999 * i;

        ((TextView)view.findViewById(R.id.textView)).setTypeface(ApplicationLoader.regularFont);
        ((TextView)view.findViewById(R.id.textView)).setText(String.format(Locale.US, format, amount));
    }

    @Override
    public void reload() {
        viewManager.getToolbar().setNavigationIcon(R.drawable.ic_ab_drawer);
        viewManager.getToolbar().setTitle("Service name");
        relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
    }


    @Override
    public boolean onBackPressed() {
        viewManager.presentViewForTag(CONTROLLER.CATEGORY);
        return false;
    }

    @Override
    public void didUserSelectedCellAtIndex(int index) {

    }
}
