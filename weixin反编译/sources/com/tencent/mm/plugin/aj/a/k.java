package com.tencent.mm.plugin.aj.a;

import com.tencent.mm.loader.stub.a;
import java.io.File;

public final class k {
    private int tqZ = 1;
    private long tra;
    private String trb;
    String trc;
    String trd;

    public k(String str, String str2, String str3) {
        this.trb = str;
        this.trc = str2;
        this.trd = str3;
    }

    public final int Np() {
        if (this.tqZ <= 1 || bPM().lastModified() > this.tra) {
            bPL();
        }
        return this.tqZ;
    }

    public final int bPL() {
        this.tqZ = Integer.valueOf(g.o(bPM()).getProperty("version", "1")).intValue();
        this.tra = System.currentTimeMillis();
        return this.tqZ;
    }

    private File bPM() {
        return new File(Ro(), "config.conf");
    }

    public final String Ro() {
        File file = new File(a.hbw.replace("/data/user/0", "/data/data"), this.trb);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public final String bPN() {
        return new File(Ro(), this.trc).getAbsolutePath();
    }
}
