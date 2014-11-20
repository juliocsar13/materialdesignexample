package cbedoy.materialdesignexample.interfaces;

import android.app.Activity;

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
    public void setActionBarIcon(int resource);


}
