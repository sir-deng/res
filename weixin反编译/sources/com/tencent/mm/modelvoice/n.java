package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

public final class n {
    public String hXn;
    public boolean hXo;
    public long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public n(String str) {
        try {
            int i;
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(":");
            if (split.length == 4 && x.gB(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.hXn = split[i];
            }
            if (split.length > i + 1) {
                this.time = bi.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.hXo = split[i + 2].equals("1");
            }
        } catch (Exception e) {
            if (this.hXn == null) {
                this.hXn = "";
            }
            this.hXo = false;
            this.time = 0;
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        }
    }
}
