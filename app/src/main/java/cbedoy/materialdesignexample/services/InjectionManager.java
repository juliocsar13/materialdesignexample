package cbedoy.materialdesignexample.services;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import cbedoy.materialdesignexample.MainViewController;
import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.viewcontroller.CategoryViewController;

/**
 * Created by admin on 11/19/14.
 */
public class InjectionManager
{
    private static InjectionManager injectionManager;

    public static InjectionManager getInstance(){
        if(injectionManager == null)
            injectionManager = new InjectionManager();
        return injectionManager;
    }

    public void initApp(MainViewController mainViewController){


        Activity activity = mainViewController.getActivity();
        Context applicationContext = mainViewController.getApplicationContext();
        Bundle extras = mainViewController.getIntent().getExtras();


        CategoryViewController categoryViewController = new CategoryViewController();
        categoryViewController.setAnimation(AbstractViewController.ANIMATION.FADE);
        categoryViewController.setContext(applicationContext);
        categoryViewController.setTag(AbstractViewController.CONTROLLER.CATEGORY);
        categoryViewController.setViewManager(mainViewController);

        mainViewController.addViewWithTag(categoryViewController, AbstractViewController.CONTROLLER.CATEGORY);

        categoryViewController.initApp();

    }
}
