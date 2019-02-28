package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class d {
    public static Context mContext;
    private static final HashMap<String, Integer> szu;
    public Object szv = new Object();
    public ToneGenerator szw;
    private final int szx = 250;

    static {
        HashMap hashMap = new HashMap();
        szu = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        szu.put("2", Integer.valueOf(2));
        szu.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Integer.valueOf(3));
        szu.put("4", Integer.valueOf(4));
        szu.put("5", Integer.valueOf(5));
        szu.put("6", Integer.valueOf(6));
        szu.put("7", Integer.valueOf(7));
        szu.put("8", Integer.valueOf(8));
        szu.put("9", Integer.valueOf(9));
        szu.put("0", Integer.valueOf(0));
        szu.put("#", Integer.valueOf(11));
        szu.put("*", Integer.valueOf(10));
    }

    public d(Context context) {
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.szv) {
                    if (bJm() && this.szw == null) {
                        this.szw = new ToneGenerator(3, 66);
                    }
                }
            } catch (Exception e) {
                x.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                x.d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.szw = null;
            }
        }
    }

    private d() {
    }

    public static boolean bJm() {
        return System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
    }

    public static int Nm(String str) {
        if (str == null || str.equals("") || !szu.containsKey(str)) {
            return -1;
        }
        return ((Integer) szu.get(str)).intValue();
    }
}
