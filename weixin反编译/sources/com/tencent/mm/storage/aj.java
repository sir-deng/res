package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aj {
    public String frM = "-1";
    public String hXn;
    public boolean hXo;
    public long time;
    public boolean xGY;
    public String xGZ = "";

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        StringBuilder append = new StringBuilder().append(str).append(":").append(j).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public final String cjC() {
        int i = 1;
        StringBuilder append = new StringBuilder().append(this.hXn).append(":").append(this.time).append(":").append(this.hXo ? 1 : 0).append(":").append(this.frM).append(":").append(this.xGZ).append(":");
        if (!this.xGY) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public aj(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith("\n")) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.xGZ = str.replace(":", "*#*");
                substring = str;
            }
            String[] split = substring.split(":", 6);
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
            if (split.length > i + 3) {
                this.frM = split[i + 3];
            }
            if (split.length > i + 4) {
                this.xGZ = split[i + 4].replace("*#*", ":");
            }
            if (split.length > i + 5) {
                this.xGY = split[i + 5].equals("1");
            }
        } catch (Throwable e) {
            this.time = 0;
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", str, bi.i(e));
        }
    }

    public static aj XW(String str) {
        return new aj(str);
    }
}
