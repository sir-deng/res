package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    static b AdL;
    public b AdK = null;
    public int errorCode = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.errorCode, 0);
        if (this.AdK != null) {
            jceOutputStream.write(this.AdK, 1);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (AdL == null) {
            AdL = new b();
        }
        this.AdK = (b) jceInputStream.read(AdL, 1, false);
    }
}
