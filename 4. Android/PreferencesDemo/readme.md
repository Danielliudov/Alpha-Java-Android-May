# Demo

**Preferences** functionality is used for storing user’s preferences and using them later, in this case on button click.

For using the Preferences framework the following steps must be followed:

* Create a class that extends [PreferenceActivity](https://developer.android.com/reference/android/preference/PreferenceActivity)
* Use the addPreferencesFromResource method in order to read the config from a resource file
* Create the XML resource file based on the [PreferenceScreen](https://developer.android.com/reference/android/preference/PreferenceScreen) class
* Create another class extending [Activity](https://developer.android.com/reference/android/app/Activity)
* Use the [PreferenceManager](https://developer.android.com/reference/android/preference/PreferenceManager) in order to retrieve the [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences) object


## Additional Resources
* [Android Quick Preferences Tutorial](https://www.javacodegeeks.com/2011/01/android-quick-preferences-tutorial.html)
* [Save key-value data](https://developer.android.com/training/data-storage/shared-preferences)
* [Settings](https://developer.android.com/guide/topics/ui/settings)