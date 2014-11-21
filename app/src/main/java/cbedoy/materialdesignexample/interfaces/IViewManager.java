package cbedoy.materialdesignexample.interfaces;

import android.app.Activity;
import android.support.v7.widget.Toolbar;

import cbedoy.materialdesignexample.abstracts.AbstractViewController;

/**
 * Created by Carlos Bedoy on 11/19/14.
 */
public interface IViewManager
{

    public Activity getActivity();
    public void reActivateCurrentView();
    public int getViewControllerWidth();
    public int getViewControllerHeight();
    public void presentViewForTag(AbstractViewController.CONTROLLER tag);
    public void finishWithResult(String result);
    public void addViewWithTag(AbstractViewController controller, AbstractViewController.CONTROLLER tag);
    public void presentLeftMenu();
    public void blockLeftMenu();
    public void presentDetail();
    public Toolbar getToolbar();
    public void disableLeftMenu();

}
