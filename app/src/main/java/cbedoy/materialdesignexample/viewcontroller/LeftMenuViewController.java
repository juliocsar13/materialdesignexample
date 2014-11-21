package cbedoy.materialdesignexample.viewcontroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import cbedoy.materialdesignexample.R;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;

/**
 * Created by admin on 11/19/14.
 */
public class LeftMenuViewController  extends AbstractViewController
{
    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.left_view_controller,  null);

        return view;
    }

    @Override
    public void reload() {

    }
}
