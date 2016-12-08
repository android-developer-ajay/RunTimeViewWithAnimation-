package com.runtimeview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.label;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private TextView mTextView;
    private TextView mTextView2;

    int width, height;
    Animation Fadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get the application context
        mContext = getApplicationContext();

//         Get the Resources
        mResources = getResources();

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mTextView = (TextView) findViewById(R.id.tv);
        mTextView2 = (TextView) findViewById(R.id.tv2);


        //==================Animation=================//
        Fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);
        Fadein.setAnimationListener(this);






        /*
            public final void measure (int widthMeasureSpec, int heightMeasureSpec)
                This is called to find out how big a view should be. The parent supplies constraint
                 information in the width and height parameters.

                The actual measurement work of a view is performed in onMeasure(int, int), called by
                this method. Therefore, only onMeasure(int, int) can and must be overridden by subclasses.

            Parameters
                widthMeasureSpec : Horizontal space requirements as imposed by the parent
                heightMeasureSpec : Vertical space requirements as imposed by the parent
        */

        // Get the width and height of first TextView
        mTextView.measure(0, 0);

        /*
            public final int getMeasuredWidth ()
                Like getMeasuredWidthAndState(), but only returns the raw width component (that is
                the result is masked by MEASURED_SIZE_MASK).

            Returns
                The raw measured width of this view.
        */
        /*
            public static final int MEASURED_SIZE_MASK
                Bits of getMeasuredWidthAndState() and getMeasuredWidthAndState() that provide
                the actual measured size.
        */
        /*
            public final int getMeasuredWidthAndState ()
                Return the full width measurement information for this view as computed by the most
                recent call to measure(int, int). This result is a bit mask as defined by
                MEASURED_SIZE_MASK and MEASURED_STATE_TOO_SMALL. This should be used during
                measurement and layout calculations only. Use getWidth() to see how wide a view
                is after layout.

            Returns
                The measured width of this view as a bit mask.
        */
        width = mTextView.getMeasuredWidth();

        /*
            public final int getMeasuredHeight ()
                Like getMeasuredHeightAndState(), but only returns the raw width component (that
                is the result is masked by MEASURED_SIZE_MASK).

            Returns
                The raw measured height of this view.
        */
        height = mTextView.getMeasuredHeight();

//        mTextView2.setText(
//                "Width and Height of first TextView\n" +
//                        "Width = " + width + " pixels" +
//                        "\nHeight = " + height + " pixels"
//
//        );

//        final LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
//        final ViewTreeObserver observer = layout.getViewTreeObserver();
//        observer.addOnGlobalLayoutListener(
//                new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        Log.d("Log", "Height: " + layout.getHeight());
//                        height = layout.getHeight();
//                    }
//                });
        runtime();
    }

    public void runtime() {
//        int mainBackgroundColor = Color.parseColor("#2E8B57");
//        int labelTextColor = Color.parseColor("#FF4500");
//        int messageBackgroundColor = Color.parseColor("#3300FF");
//        int messageTextColor = Color.parseColor("#FFFF00");
//        TextView label = new TextView(this);
//
//        LinearLayout.LayoutParams labelLayoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        label.setLayoutParams(labelLayoutParams);
//        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        //label.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
//        label.setText("hey");
//        label.setTextColor(labelTextColor);

        //        getnumber * 100 / totl
        // int percentage = (600 * 100) / 800;
        int percentvalue = (width / 100) * 70;
        mTextView2.setText("70" + "%");



        Log.d("AJAYJOSHI", "" + percentvalue);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);


        // Add textview 1
        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(new LinearLayout.LayoutParams(percentvalue,
                height));
        // textView1.setText("");
        textView1.setBackgroundColor(getResources().getColor(R.color.textColor)); // hex color 0xAARRGGBB
        textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)

        TextView textView2 = new TextView(this);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(5,
                height));
        textView2.setBackgroundColor(getResources().getColor(R.color.white)); // hex color 0xAARRGGBB
        textView2.setPadding(20, 20, 20, 20);
        linearLayout.addView(textView1);
        linearLayout.addView(textView2);

        linearLayout.setAnimation(Fadein);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        Toast.makeText(mContext, "End", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}