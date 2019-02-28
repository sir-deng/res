package com.tencent.mm.loader.stub;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;

public class c {
    public static c hby = new c(null);
    public final SharedPreferences hbz;

    public c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.hbz = ad.getContext().getSharedPreferences(ad.cgf(), 0);
        } else {
            this.hbz = sharedPreferences;
        }
    }

    public final String H(String str, String str2) {
        return this.hbz.getString(str, str2);
    }
}
