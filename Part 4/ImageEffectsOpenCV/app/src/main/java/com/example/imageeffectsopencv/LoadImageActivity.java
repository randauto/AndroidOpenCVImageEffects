package com.example.imageeffectsopencv;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class LoadImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        OpenCVLoader.initDebug();

        displayToast();

    }

    public void displayToast() {
        Mat img;
        try {
            img = Utils.loadResource(this, R.drawable.im1);

            Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2BGRA);

            Mat img_result = img.clone();
//            Imgproc.Canny(img, img_result, 80, 90);
            Bitmap bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(img_result, bitmap);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
