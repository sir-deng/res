package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ap extends af<ap> {
    public String aYT;
    public int aYU;
    private int aYV;
    private String aYW;
    public String aYX;
    private boolean aYY;
    private boolean aYZ;
    private boolean aZa;

    public ap() {
        this((byte) 0);
    }

    private ap(byte b) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                leastSignificantBits = Integer.MAX_VALUE;
            }
        }
        this(false, leastSignificantBits);
    }

    private ap(boolean z, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.aYU = i;
        this.aYZ = false;
    }

    private void pT() {
        if (this.aZa) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public final /* synthetic */ void a(af afVar) {
        String str;
        int i;
        boolean z;
        ap apVar = (ap) afVar;
        if (!TextUtils.isEmpty(this.aYT)) {
            str = this.aYT;
            apVar.pT();
            apVar.aYT = str;
        }
        if (this.aYU != 0) {
            i = this.aYU;
            apVar.pT();
            apVar.aYU = i;
        }
        if (this.aYV != 0) {
            i = this.aYV;
            apVar.pT();
            apVar.aYV = i;
        }
        if (!TextUtils.isEmpty(this.aYW)) {
            str = this.aYW;
            apVar.pT();
            apVar.aYW = str;
        }
        if (!TextUtils.isEmpty(this.aYX)) {
            Object obj = this.aYX;
            apVar.pT();
            if (TextUtils.isEmpty(obj)) {
                apVar.aYX = null;
            } else {
                apVar.aYX = obj;
            }
        }
        if (this.aYY) {
            z = this.aYY;
            apVar.pT();
            apVar.aYY = z;
        }
        if (this.aYZ) {
            z = this.aYZ;
            apVar.pT();
            apVar.aYZ = z;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.aYT);
        hashMap.put("interstitial", Boolean.valueOf(this.aYY));
        hashMap.put("automatic", Boolean.valueOf(this.aYZ));
        hashMap.put("screenId", Integer.valueOf(this.aYU));
        hashMap.put("referrerScreenId", Integer.valueOf(this.aYV));
        hashMap.put("referrerScreenName", this.aYW);
        hashMap.put("referrerUri", this.aYX);
        return af.aj(hashMap);
    }
}
