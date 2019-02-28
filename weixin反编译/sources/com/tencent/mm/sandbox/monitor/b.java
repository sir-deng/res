package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

public final class b {

    static class a {
        public String fpV;
        public final String platform = (d.DEVICE_TYPE + "_" + d.vHl + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public String username;
        public boolean xkl;

        public a(String str, String str2, long j, String str3, boolean z) {
            this.username = str;
            this.tag = str2;
            this.timestamp = j;
            this.fpV = str3;
            this.xkl = false;
            this.xkl = z;
        }

        public final String toString() {
            return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.fpV;
        }
    }
}
