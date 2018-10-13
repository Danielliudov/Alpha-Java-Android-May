# Demo

One of the major features of android framework is location API. You can see, the location module widely used in lot of apps those provides services like food ordering, transportation, health tracking, social networking and lot more. The location module is part of Google Play Services and in the same module geofencing and [activity recognition](https://www.androidhive.info/2017/12/android-user-activity-recognition-still-walking-running-driving-etc/) are included.

Earlier, getting location is very easy with couple of API calls. But to provide more accurate locations and optimizing the battery usage, Android introduced set APIs that should be combined to get the best results from the location API. We will be using [Fused Location API](https://developers.google.com/location-context/fused-location-provider/) that combines signals from GPS, Wi-Fi, and cell networks, as well as accelerometer, gyroscope, magnetometer and other sensors to provide more accurate results.

## Code Reference

### Location Permissions

There are two permissions available to request location. The accuracy of the location is determined by the kind of permission requested and priority level.

* ACCESS_COARSE_LOCATION: Gives location approximately equivalent to a city block.
* ACCESS_FINE_LOCATION: Gives precise location, sometimes in few meters or feet when combined with High Priority accuracy.

### Receiving Location Updates

* **getLastLocation()**: Returns the recent available location. When location is not available, it returns null.
* **Location Settings**: In order to get the location, proper settings has to enabled in the device such as GPS or Wifi. Instead of requesting the user to enable them separately, you can use Settings Client to check whether proper settings are enabled or not. If enabled, you can proceed with location updates or user will be shown a dialog to turn on the required hardware as shown below.
* **Update Interval**: This interval defines the rate in milliseconds at which your app prefers the location updates. Your app can receive updates lesser or higher than this rate if other apps requested location updates higher than your value. Let’s say your app requests updates every 10secs, if other app is requesting updates at 5secs, your app might receives the same updates ignoring the 10sec value.
* **Fastest Update Interval**: This is the rate at which your app can handle the location updates. Without this value, you can see inconsistent user experience if your app can’t handle frequent location updates.
* **Priority**: The accuracy of the location depends on the source of the hardware used. To define this, Priority has to be mentioned while requesting the location. The priority can be BALANCED, HIGH, LOW OR NO_POWER.
* [Dexter Permissions](https://www.androidhive.info/2017/12/android-easy-runtime-permissions-with-dexter/)

### Google Maps V2
Before starting a new project, we need to go through some pre required steps. These steps involves importing required library, generating SHA1 fingerprint and configuring maps in google console.

#### Getting the Google Maps API key

Same as in maps v1 we need to generate SHA-1 fingerprint using java keytool. Open your terminal and execute the following command to generate SHA-1 fingerprint.
**On Windows**
```bash
keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
```

**On Linux or Mac OS**
```bash
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
```

[Get API Key](https://developers.google.com/maps/documentation/android-sdk/signup)

### Permissions

* ACCESS_NETWORK_STATE – To check network state whether data can be downloaded or not
* INTERNET – To check internet connection status
* WRITE_EXTERNAL_STORAGE – To write to external storage as google maps store map data in external storage
* ACCESS_COARSE_LOCATION – To determine user’s location using WiFi and mobile cell data
* ACCESS_FINE_LOCATION – To determine user’s location using GPS
* OpenGL ES V2 – Required for Google Maps V2

## Additional Resources
[Location and context overview](https://developer.android.com/training/location/)
[Google Maps V2 Example](https://www.androidhive.info/2013/08/android-working-with-google-maps-v2/)

