package cbedoy;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cbedoy.materialdesignexample.FuckinActivity;
import cbedoy.materialdesignexample.MainViewController;
import cbedoy.materialdesignexample.R;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


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

        Button pressMeButton = (Button) activity.findViewById(R.id.press_me_button);
        TextView results = (TextView) activity.findViewById(R.id.results_text_view);

        pressMeButton.performClick();
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Testing Android Rocks!"));

        Assert.assertNotNull(activity);
    }
}