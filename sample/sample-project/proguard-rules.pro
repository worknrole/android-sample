-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn org.simpleframework.xml.stream.**
-dontwarn retrofit2.Platform$Java8

-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}
