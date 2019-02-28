package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import org.xwalk.core.XWalkLibraryLoader.ActivateListener;
import org.xwalk.core.XWalkLibraryLoader.DecompressListener;

public class XWalkInitializer {
    private static final String TAG = "XWalkLib";
    private Context mContext;
    private XWalkInitListener mInitListener;
    private boolean mIsXWalkReady;

    public interface XWalkInitListener {
        void onXWalkInitCancelled();

        void onXWalkInitCompleted();

        void onXWalkInitFailed();

        void onXWalkInitStarted();
    }

    private class XWalkLibraryListener implements ActivateListener, DecompressListener {
        private XWalkLibraryListener() {
        }

        public void onDecompressStarted() {
        }

        public void onDecompressCancelled() {
            XWalkInitializer.this.mInitListener.onXWalkInitCancelled();
        }

        public void onDecompressCompleted() {
        }

        public void onActivateStarted() {
        }

        public void onActivateFailed() {
            XWalkInitializer.this.mInitListener.onXWalkInitFailed();
        }

        public void onActivateCompleted() {
            XWalkInitializer.this.mIsXWalkReady = true;
            XWalkLibraryLoader.finishInit(XWalkInitializer.this.mContext);
            XWalkInitializer.this.mInitListener.onXWalkInitCompleted();
        }
    }

    public XWalkInitializer(XWalkInitListener xWalkInitListener, Context context) {
        this.mInitListener = xWalkInitListener;
        this.mContext = context;
        XWalkLibraryLoader.prepareToInit(this.mContext);
    }

    public boolean initAsync_remove() {
        if (this.mIsXWalkReady) {
            return false;
        }
        if (XWalkLibraryLoader.isInitializing() || XWalkLibraryLoader.isDownloading()) {
            Log.i(TAG, "Other initialization or download is proceeding");
            return false;
        }
        Log.i(TAG, "Initialized by XWalkInitializer");
        this.mInitListener.onXWalkInitStarted();
        return true;
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        XWalkEnvironment.addXWalkInitializeLog(str, str2);
    }

    public static void addXWalkInitializeLog(String str) {
        XWalkEnvironment.addXWalkInitializeLog(str);
    }

    public static String getXWalkInitializeLog() {
        SharedPreferences sharedPreferencesForLog = XWalkEnvironment.getSharedPreferencesForLog();
        if (sharedPreferencesForLog == null) {
            return "";
        }
        return sharedPreferencesForLog.getString("log", "");
    }

    public boolean tryInitSync() {
        if (XWalkEnvironment.hasAvailableVersion()) {
            if (!(XWalkCoreWrapper.attachXWalkCore(XWalkEnvironment.getAvailableVersion()) == 1)) {
                return false;
            }
            XWalkCoreWrapper.dockXWalkCore();
            this.mIsXWalkReady = true;
            XWalkLibraryLoader.finishInit(this.mContext);
            this.mInitListener.onXWalkInitCompleted();
            return true;
        } else if (XWalkEnvironment.getAvailableVersion() == -1) {
            addXWalkInitializeLog("no available version ,need download");
            return false;
        } else {
            addXWalkInitializeLog("sdk not support this apk, need update new");
            return false;
        }
    }

    public boolean isXWalkReady() {
        return this.mIsXWalkReady;
    }

    public boolean isSharedMode() {
        return this.mIsXWalkReady && XWalkLibraryLoader.isSharedLibrary();
    }

    public boolean isDownloadMode() {
        return this.mIsXWalkReady && XWalkEnvironment.isDownloadMode();
    }
}
