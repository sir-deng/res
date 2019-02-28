package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a extends JceStruct {
    public int Abo = 0;
    public int Abp = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Abo, 0);
        jceOutputStream.write(this.Abp, 1);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.Abo = jceInputStream.read(this.Abo, 0, true);
        this.Abp = jceInputStream.read(this.Abp, 1, false);
    }
}
