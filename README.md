# The infamous crash during instrumentation tests

## Background

- Android Kotlin Projet
- Standard instrumentation tests
- Using Mockk !
- Using **Android P+ Emulator** (needed to avoid open on mocked classes)
- Using Hilt

- Emulator info in [here](https://raw.githubusercontent.com/NitroG42/CrashDuringTestSample/master/emulator.log)

## Given

Checkout this project and run the ./gradlew connectedDebugAndroidTest

On Android P emulator, this should result after sometimes :

```
Starting 9 tests on Emulator_API_28(AVD) - 9
Tests on Emulator_API_28(AVD) - 9 failed: Instrumentation run failed due to 'Process crashed.'
```

The logcat extract:
```
W/InputDispatcher: channel 'e07f1ef com.nitro.crashduringtestsample.debug/com.nitro.crashduringtestsample.TestActivity (server)' ~ Consumer closed input channel or an error occurred.  events=0x9
E/InputDispatcher: channel 'e07f1ef com.nitro.crashduringtestsample.debug/com.nitro.crashduringtestsample.TestActivity (server)' ~ Channel is unrecoverably broken and will be disposed!
I/ActivityManager: Process com.nitro.crashduringtestsample.debug (pid 27387) has died: fore TOP 
/? I/Zygote: Process 27387 exited due to signal (11)
W/libprocessgroup: kill(-27387, 9) failed: No such process
I/libprocessgroup: Successfully killed process cgroup uid 10125 pid 27387 in 0ms
I/WindowManager: WIN DEATH: Window{e07f1ef u0 com.nitro.crashduringtestsample.debug/com.nitro.crashduringtestsample.TestActivity}
W/InputDispatcher: Attempted to unregister already unregistered input channel 'e07f1ef com.nitro.crashduringtestsample.debug/com.nitro.crashduringtestsample.TestActivity (server)'
W/ActivityManager: Crash of app com.nitro.crashduringtestsample.debug running instrumentation ComponentInfo{com.nitro.crashduringtestsample.debug.test/com.nitro.crashduringtestsample.MyTestRunner}
I/ActivityManager: Force stopping com.nitro.crashduringtestsample.debug appid=10125 user=0: finished inst
W/Binder: Outgoing transactions from this process must be FLAG_ONEWAY
    java.lang.Throwable
        at android.os.BinderProxy.transact(Binder.java:1114)
        at android.app.IInstrumentationWatcher$Stub$Proxy.instrumentationFinished(IInstrumentationWatcher.java:164)
        at com.android.server.am.InstrumentationReporter$MyThread.run(InstrumentationReporter.java:86)
```

If the tests are launched through Android Studio instead of gradle:

## Result

Right now this bug affect our CI, some of our jobs are regularly crashing in a random way.  
There is no way to understand what's happening, as the logcat doesn't contains a stacktrace or even a native stacktrace.  
It seems to happens only in emulators, and sometimes running test through Android Studio will works but not the connectedDebugAndroidTest command.

## More info

An issue was opened on the [android-test repo](https://github.com/android/android-test), but was closed because there was no info nor reproducible sample.

The developer [ricard-v](https://github.com/ricard-v) gathered more info for this problems, which might have more results that just the above (SIGSEV in logcat, which I got sometimes)
Here are somes of his posts:

https://github.com/mockk/mockk/issues/466  
https://stackoverflow.com/questions/63059986/android-ui-tests-with-espresso-mockk-crash-with-sigsegv

