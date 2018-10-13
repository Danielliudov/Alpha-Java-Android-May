# Demo

There are two ways to integrate the camera module.

**Using In-built Camera App:**
The easiest way to integrate camera feature is, use the in-built camera app that comes with the device. To launch the camera app, you just need to pass the appropriate intent with necessary flags. Rest will be taken care by the camera app and it will return the data (image or video) to your app. The disadvantage of this method is, you can’t customize the camera interface as you would be launching third party camera app.

**Writing Custom Camera App:**
Building your own camera module takes some effort as you need to build everything from scratch beginning with user interface to integrating camera API (rending camera preview, toggling front and back cameras, flash, focus etc.,). But the advantage over here is, you can build the uniform camera UI which will be same for all the users. You can see custom camera in apps like Instagram, Facebook etc.,

## Code references

### AndroidManifest.xml

Add CAMERA, WRITE_EXTERNAL_STORAGE and RECORD_AUDIO permissions.

Here we also added camera feature that defines the rules to list the app on Playstore. If we keep android:required=”true”, Google Playstore won’t let the users to install the app on the devices that doesn’t have camera feature. Incase of false, the app will be listed but camera feature is optional.

We also need <provider> tag to prepare the file paths properly across all the android platforms.

### CameraUtils.java class
 This is a helper class that provides necessary methods that we need in our camera module.
 
* **refreshGallery()** – Refreshes the image gallery after taking a new picture or video so that they will be instantly available in the gallery. In older android devices, gallery won’t be refreshed until the device is rebooted.
* **checkPermissions()** – Checks whether all the permissions are granted or not. This would be called before requesting the camera.
* **getOutputMediaFile()** – Create a new file in gallery and returns the file. This reference will be passed to camera intent so that newly taken image / video will be stored in this location.
* **optimizeBitmap()** – Compresses the bitmap before displaying it on UI to avoid the OutOfMemory exceptions.

### Camera API

* [Android SurfaceView](https://examples.javacodegeeks.com/android/core/ui/surfaceview/android-surfaceview-example/) - The Android SurfaceView provides a dedicated drawing surface embedded inside of a view hierarchy. You can control the format of this surface, however, the SurfaceView takes care of placing the surface at the correct location on the screen. 


## Additiona Resources
* [Camera](https://developer.android.com/training/camera/)
* [Android Camera Example](https://examples.javacodegeeks.com/android/core/hardware/camera-hardware/android-camera-example/)
* [Control the Camera](https://developer.android.com/training/camera/cameradirect)
* [Dexter Permissions](https://www.androidhive.info/2017/12/android-easy-runtime-permissions-with-dexter/)

