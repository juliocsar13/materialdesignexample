package cbedoy;

import android.app.Activity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cbedoy.materialdesignexample.FuckinActivity;
import cbedoy.materialdesignexample.MainViewController;

/**
 * Created by vandekr on 11/02/14.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ActivityTest {
    @Before
    public void setup() {

    }

    @Test
    public void testActivityFound() {
        Activity activity = Robolectric.buildActivity(FuckinActivity.class).create().get();

        Assert.assertNotNull(activity);
    }
}