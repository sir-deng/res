package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public String AdC = "";
    public int AdI = 0;
    public float AdJ = 0.0f;
    public String ffG = "";

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AdC, 0);
        jceOutputStream.write(this.AdI, 1);
        jceOutputStream.write(this.AdJ, 2);
        if (this.ffG != null) {
            jceOutputStream.write(this.ffG, 3);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AdC = jceInputStream.readString(0, true);
        this.AdI = jceInputStream.read(this.AdI, 1, true);
        this.AdJ = jceInputStream.read(this.AdJ, 2, true);
        this.ffG = jceInputStream.readString(3, false);
    }
}
