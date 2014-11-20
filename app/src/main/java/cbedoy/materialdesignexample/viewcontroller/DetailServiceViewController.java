package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;

/**
 * Created by admin on 11/19/14.
 */
public class DetailServiceViewController  extends AbstractViewController
{
    private FloatingActionButton floatingActionButton;
    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.detail_service_view_controller,  null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setColorNormal(Color.parseColor("#4CAF50"));
        floatingActionButton.setColorPressed(Color.parseColor("#388E3C"));

        return view;
    }

    @Override
    public void reload() {

    }


    @Override
    public boolean onBackPressed() {
        viewManager.presentViewForTag(CONTROLLER.CATEGORY);
        return false;
    }
}
