package com.tencent.xweb.xwalk.a;

import android.content.Context;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class d implements XWalkInitListener, XWalkBackgroundUpdateListener {
    public static boolean ADa = true;
    private static boolean ADb = false;
    private static d ADc;
    XWalkInitializer ACF;
    XWalkUpdater ACG;
    Context mContext;

    private d(Context context) {
        this.mContext = context;
        this.ACF = new XWalkInitializer(this, context);
        this.ACG = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
    }

    public final void onXWalkInitStarted() {
    }

    public final void onXWalkInitCancelled() {
    }

    public final void onXWalkInitFailed() {
    }

    public final void onXWalkInitCompleted() {
    }

    public final void onXWalkUpdateStarted() {
        e.cKc();
    }

    public final void onXWalkUpdateProgress(int i) {
    }

    public final void onXWalkUpdateCancelled() {
        e.cKd();
    }

    public final void onXWalkUpdateFailed(int i) {
        e.JA(i);
    }

    public final void onXWalkUpdateCompleted() {
        e.cKe();
    }

    public static boolean isXWalkReady() {
        if (!ADb || ADc == null) {
            return false;
        }
        return ADc.ACF.isXWalkReady();
    }

    public static boolean iV(Context context) {
        if (ADb) {
            return ADb;
        }
        ADb = true;
        ADc = new d(context);
        XWalkEnvironment.init(context);
        if (!XWalkEnvironment.isDownloadMode()) {
            return false;
        }
        d dVar = ADc;
        if (!ADa) {
            new e(dVar.ACG).execute(new String[0]);
        }
        if (!dVar.ACF.tryInitSync()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
        return true;
    }
}
