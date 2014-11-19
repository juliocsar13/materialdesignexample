package cbedoy.materialdesignexample;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.HashMap;
import java.util.Map;

import cbedoy.materialdesignexample.abstracts.AbstractViewController;
import cbedoy.materialdesignexample.interfaces.IViewManager;
import cbedoy.materialdesignexample.services.ImageService;
import cbedoy.materialdesignexample.services.InjectionManager;


public class MainViewController extends Activity implements IViewManager {


    private HashMap<AbstractViewController.CONTROLLER, AbstractViewController> viewModel;
    private int view_controller_height;
    private int view_controller_width;
    private ViewFlipper viewFlipper;
    private DrawerLayout leftMenuDrawer;
    private ListView leftMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageService.init(this);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.viewModel = new HashMap<AbstractViewController.CONTROLLER, AbstractViewController>();
        this.view_controller_height = ImageService.getScreenHeight();
        this.view_controller_width = ImageService.getScreenWidth();
        this.setContentView(R.layout.main_view_controller);

        this.viewFlipper = (ViewFlipper) findViewById(R.id.main_view_controller_view_flipper);
        this.leftMenuDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.leftMenu = (ListView) findViewById(R.id.left_drawer);

        TranslateAnimation in = new TranslateAnimation(ImageService.getScreenWidth(), 0, 0, 0);
        in.setDuration(3000);
        in.setZAdjustment(Animation.ZORDER_TOP);
        this.viewFlipper.setInAnimation(in);
        TranslateAnimation out = new TranslateAnimation(0, -ImageService.getScreenWidth(), 0, 0);
        out.setDuration(3000);
        out.setZAdjustment(Animation.ZORDER_TOP);
        this.viewFlipper.setOutAnimation(out);

        InjectionManager.getInstance().initApp(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.primary_dark);

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public void setLeftMenuView(AbstractViewController controller) {
        this.leftMenu.addView(controller.getView());
    }

    @Override
    public void finish() {
        long delay = 200;
        final MainViewController self = this;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                self.terminateInApp();
            }
        }, delay);
    }

    private void terminateInApp() {
        super.finish();

        //this.overridePendingTransition(R.anim.exit_in_anim, R.anim.exit_out_anim);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {


        super.onPause();
    }

    @Override
    protected void onResume() {


        super.onResume();
    }

    @Override
    public void onBackPressed() {
        boolean allowBack = true;
        int displayed_child = this.viewFlipper.getDisplayedChild();
        View view = this.viewFlipper.getChildAt(displayed_child);

        for(Map.Entry<AbstractViewController.CONTROLLER, AbstractViewController> entry : this.viewModel.entrySet()) {
            AbstractViewController child = entry.getValue();
            if(child.getView() == view) {
                allowBack = child.onBackPressed();
                break;
            }
        }

        if(allowBack)
            super.onBackPressed();
    }

    @Override
    public int getViewControllerWidth() {
        return this.view_controller_width;
    }

    @Override
    public int getViewControllerHeight() {
        return this.view_controller_height;
    }

    @Override
    public void reActivateCurrentView() {
        final MainViewController self = this;

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int displayed_child = self.viewFlipper.getDisplayedChild();
                View view = self.viewFlipper.getChildAt(displayed_child);

                for(Map.Entry<AbstractViewController.CONTROLLER, AbstractViewController> entry : self.viewModel.entrySet()) {
                    AbstractViewController child = entry.getValue();

                    if(child.getView() == view) {
                        child.toogleButtons(true);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void presentViewForTag(AbstractViewController.CONTROLLER tag) {
        final MainViewController self = this;
        final AbstractViewController.CONTROLLER final_tag = tag;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AbstractViewController child = self.viewModel.get(final_tag);
                View view = child.getView();

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);

                int child_index = self.viewFlipper.indexOfChild(view);
                if(child_index < 0) {
                    self.viewFlipper.addView(view);
                    child_index = self.viewFlipper.indexOfChild(view);
                }

                int displayed_child = self.viewFlipper.getDisplayedChild();
                if(child_index != displayed_child) {
                    int width = self.view_controller_width;
                    int ltr = child_index > displayed_child ? 1 : -1;

                    if(child.getAnimation() == AbstractViewController.ANIMATION.EXPAND)
                    {
                        self.viewFlipper.setInAnimation(null);
                        self.viewFlipper.setOutAnimation(null);
                    }
                    else if(child.getAnimation() == AbstractViewController.ANIMATION.SLIDE)
                    {
                        TranslateAnimation in = new TranslateAnimation(width * ltr, 0, 0, 0);
                        in.setDuration(400);
                        in.setZAdjustment(Animation.ZORDER_TOP);
                        self.viewFlipper.setInAnimation(in);

                        TranslateAnimation out = new TranslateAnimation(0, -width * ltr, 0, 0);
                        out.setDuration(400);
                        out.setZAdjustment(Animation.ZORDER_TOP);
                        self.viewFlipper.setOutAnimation(out);

                    }
                    else
                    {
                        AlphaAnimation in = new AlphaAnimation(0.0f, 1.0f);
                        in.setDuration(750);
                        in.setZAdjustment(Animation.ZORDER_TOP);
                        self.viewFlipper.setInAnimation(in);

                        AlphaAnimation out = new AlphaAnimation(1.0f, 0.0f);
                        out.setDuration(750);
                        out.setZAdjustment(Animation.ZORDER_TOP);
                        self.viewFlipper.setOutAnimation(out);
                    }

                    self.viewFlipper.setDisplayedChild(child_index);
                }

                child.reload();
            }
        });
    }

    @Override
    public void finishWithResult(String result) {
        Intent intent = new Intent();
        intent.putExtra("result", result);

        this.setResult(RESULT_OK, intent);
        this.finish();
    }

    @Override
    public void addViewWithTag(AbstractViewController controller, AbstractViewController.CONTROLLER tag) {
        this.viewModel.put(tag, controller);
    }

    @Override
    public void presentLeftMenu() {
        if(leftMenuDrawer != null)
        {
            leftMenuDrawer.setVisibility(View.VISIBLE);
            /*if (leftMenuDrawer.is())
                leftMenuDrawer.closePane();
            else
                leftMenuDrawer.openPane();*/
        }
    }

    @Override
    public void blockLeftMenu() {
        if(leftMenuDrawer !=null)
            leftMenuDrawer.setVisibility(View.GONE);
    }

    @Override
    public void presentDetail() {
        final MainViewController self = this;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AbstractViewController child = self.viewModel.get(AbstractViewController.CONTROLLER.SERVICE_LIST);
                View view = child.getView();

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);

                int child_index = self.viewFlipper.indexOfChild(view);
                if(child_index < 0) {
                    self.viewFlipper.addView(view);
                    child_index = self.viewFlipper.indexOfChild(view);
                }

                int displayed_child = self.viewFlipper.getDisplayedChild();
                if(child_index != displayed_child) {
                    int width = self.view_controller_width;
                    int ltr = child_index > displayed_child ? 1 : -1;
                }
                AlphaAnimation in = new AlphaAnimation(0.0f, 1.0f);
                in.setDuration(750);
                in.setZAdjustment(Animation.ZORDER_TOP);
                self.viewFlipper.setInAnimation(in);

                AlphaAnimation out = new AlphaAnimation(1.0f, 0.0f);
                out.setDuration(750);
                out.setZAdjustment(Animation.ZORDER_TOP);
                self.viewFlipper.setOutAnimation(out);

                self.viewFlipper.setDisplayedChild(child_index);
            }});


    }

    @Override
    public Activity getActivity() {
        return this;
    }



}
