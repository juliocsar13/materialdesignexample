package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.artifacts.AbstractCell;
import cbedoy.materialdesignexample.artifacts.DetailCell;

/**
 * Created by admin on 11/19/14.
 */
public class DetailServiceViewController  extends AbstractViewController implements AbstractCell.ICellViewDelegate
{
    private FloatingActionButton floatingActionButton;
    private FloatingActionButton informationButton;
    private AbstractCell abstractCell;
    private ListView listView;
    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.detail_service_view_controller,  null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setColorNormal(Color.parseColor("#4CAF50"));
        floatingActionButton.setColorPressed(Color.parseColor("#388E3C"));

        informationButton = (FloatingActionButton) view.findViewById(R.id.info);
        informationButton.setColorNormal(Color.parseColor("#FAFAFA"));
        informationButton.setColorPressed(Color.parseColor("#EEEEEE"));

        listView = (ListView) view.findViewById(R.id.listView);
        floatingActionButton.attachToListView(listView);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0); list.add(1); list.add(3); list.add(4); list.add(4); list.add(4);
        abstractCell = new DetailCell(context, inflater, list);
        abstractCell.setViewDelegate(this);
        listView.setAdapter(abstractCell);



        return view;
    }

    @Override
    public void reload() {
        viewManager.getToolbar().setNavigationIcon(R.drawable.ic_ab_drawer);
        viewManager.getToolbar().setTitle("Service name");
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
