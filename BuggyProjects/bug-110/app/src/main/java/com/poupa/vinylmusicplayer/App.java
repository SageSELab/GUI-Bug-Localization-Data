package com.poupa.vinylmusicplayer;

import android.content.Context;
import android.os.Build;

import androidx.multidex.MultiDexApplication;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.poupa.vinylmusicplayer.appshortcuts.DynamicShortcutManager;
import com.poupa.vinylmusicplayer.util.DelayedTaskThread;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class App extends MultiDexApplication {
    public static final String TAG = App.class.getSimpleName();

    private static App app;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        context = getApplicationContext();

        // default theme
        if (!ThemeStore.isConfigured(this, 1)) {
            ThemeStore.editTheme(this)
                    .primaryColorRes(R.color.md_indigo_500)
                    .accentColorRes(R.color.md_pink_A400)
                    .commit();
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }

        DelayedTaskThread.getInstance().start();
    }

    public static App getInstance() {
        return app;
    }

    public static Context getStaticContext() {
        return context;
    }

    @Override
    public void onTerminate() {
        DelayedTaskThread.getInstance().stop();
        super.onTerminate();
    }
}
