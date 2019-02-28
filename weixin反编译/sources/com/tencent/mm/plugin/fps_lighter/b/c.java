package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import com.b.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class c implements Serializable {
    public static HashMap<String, Integer> mGz;
    public String mGA = "FRAGMENT_UNKNOW";
    String mGB;
    int mGC = 100;
    public float mGr = 60.0f;
    public float mGs = 16.666668f;
    public final long mGt = 8000;
    public final long mGu = 120000;
    boolean mGv = false;
    boolean mGw = false;
    boolean mGx = false;
    public int mGy = 3;

    protected c() {
        int t = b.t(ad.getContext());
        if (t >= 2015) {
            this.mGy = 0;
        } else if (t >= 2013) {
            this.mGy = 1;
        } else if (t > 2010) {
            this.mGy = 2;
        } else {
            this.mGy = 3;
        }
    }

    public static long aLr() {
        return 120000;
    }

    public static long aLs() {
        return TimeUnit.NANOSECONDS.convert(8000, TimeUnit.MILLISECONDS);
    }

    static {
        HashMap hashMap = new HashMap();
        mGz = hashMap;
        hashMap.put("SnsTimeLineUI", Integer.valueOf(0));
        mGz.put("FRAGMENT_MAINUI", Integer.valueOf(1));
        mGz.put("FRAGMENT_ADDRESS", Integer.valueOf(4));
        mGz.put("FRAGMENT_CHATTING", Integer.valueOf(3));
        mGz.put("ChattingUI", Integer.valueOf(3));
        mGz.put("SnsUserUI", Integer.valueOf(5));
    }

    public final void u(Activity activity) {
        this.mGB = activity.getClass().getSimpleName();
    }
}
