package cbedoy.materialdesignexample;

/**
 * Created by admin on 11/21/14.
 */
import android.content.Intent;
import android.widget.Button;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;


@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

    private MainViewController activity;

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new MainViewController().getResources().getString(R.string.hello_world);
        assertThat(hello, equalTo("Hello world!"));
    }

    @Before
    public void setup()  {
        activity = Robolectric.buildActivity(MainViewController.class)
                .create().get();
    }


    public void testCheckActivityNotNull() throws Exception {
        assertNotNull(activity);
    }
    @Test
    public void testButtonClickShouldStartNewActivity() throws Exception
    {
        Button button = (Button) activity.findViewById(R.id.fav);
        button.performClick();
        Intent intent = Robolectric.shadowOf(activity).peekNextStartedActivity();
        //assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void testButtonClick() throws Exception {
        MainViewController activity = Robolectric.buildActivity(MainViewController.class)
                .create().get();
        Button view = (Button) activity.findViewById(R.id.fav);
        assertNotNull(view);
        view.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(),
                equalTo("Lala"));
    }

}
