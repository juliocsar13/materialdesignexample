package cbedoy.materialdesignexample.abstracts;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import cbedoy.materialdesignexample.interfaces.IViewManager;

/**
 * Created by admin on 11/19/14.
 */
public abstract class AbstractViewController
{
    protected Context context;
    protected CONTROLLER tag;
    protected IViewManager viewManager;
    protected View view;
    protected Bitmap backgroundBitmap;
    protected boolean buttons_status;
    protected ANIMATION animation;


    public void setAnimation(ANIMATION animation) {
        this.animation = animation;
    }


    public enum CONTROLLER
    {
        LOGIN,
        PAYMENT_ORIGINS,
        TICKET,
        OTP,
        WALLET_SELECTOR,
        LEFT_PAYMENT_ORIGINS,
        LEFT_SIGN_UP_LOGIN,
        LEFT_SIGN_UP_CONFIRMATION,
        LEFT_SIGN_UP_PIN,
        CARD_WALLET,
        COINBASE_WALLET,
        BLOCKCHAIN_WALLET,

        LEFT_MENU,
        CATEGORY,
        SERVICE_LIST,
        DETAIL_SERVICE,
        FAVORITES,
        BARCODE

    }

    public enum  ANIMATION{
        FADE,
        SLIDE,
        NONE,
        EXPAND
    }

    protected abstract View init();
    public abstract void reload();



    public void setTag(CONTROLLER tag) {
        this.tag = tag;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setViewManager(IViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public void setBackgroundBitmap(Bitmap backgroundBitmap) {
        this.backgroundBitmap = backgroundBitmap;
    }

    public void setButtons_status(boolean buttons_status) {
        this.buttons_status = buttons_status;
    }


    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        if(view == null)
            view = init();
        return view;
    }

    public void backPressed() {
        this.viewManager.getActivity().finish();
    }

    public void nextPressed() {

    }

    public void toogleButtons(boolean status) {
        this.buttons_status = status;
    }

    public boolean onBackPressed() {
        return true;
    }

    public ANIMATION getAnimation() {
        return animation;
    }

    public CONTROLLER getTag() {
        return tag;
    }
}
