package com.telerikacademy.camerademo;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;


public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Camera deviceCamera = Camera.open();

        ImageSurfaceView imageSurfaceView = new ImageSurfaceView(CameraActivity.this, deviceCamera);
        FrameLayout cameraPreviewLayout = findViewById(R.id.camera_preview);
        cameraPreviewLayout.addView(imageSurfaceView);

        Button captureButton = findViewById(R.id.button);
        captureButton.setOnClickListener(v -> takePicture(deviceCamera));
    }

    private void takePicture(Camera deviceCamera) {
        deviceCamera.takePicture(
                null,
                null,
                (data, camera) -> {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    if (bitmap == null) {
                        Toast.makeText(CameraActivity.this, "Captured image is empty", Toast.LENGTH_LONG).show();
                        return;
                    }
                    ImageView capturedImageHolder = findViewById(R.id.captured_image);
                    capturedImageHolder.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 300, 200, true));
                });
    }
}
