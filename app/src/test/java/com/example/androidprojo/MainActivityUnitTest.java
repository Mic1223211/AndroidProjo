package com.example.androidprojo;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 27, manifest = "src/main/AndroidManifest.xml", packageName = "com.example.androidprojo")
public class MainActivityUnitTest {

    @Test
    public void clickingButton_shouldChangeViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Button btn = activity.findViewById(R.id.changeTextBt);

        TextView tv = activity.findViewById(R.id.textToBeChanged);
        btn.performClick();

        assertEquals(tv.getText().toString(),"");
    }
}
