package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static c AbO = new c();
    static ArrayList<b> AbP = new ArrayList();
    static d AbQ = new d();
    public c AbL = null;
    public ArrayList<b> AbM = null;
    public d AbN = null;

    public final JceStruct newInit() {
        return new a();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.AbL != null) {
            jceOutputStream.write(this.AbL, 0);
        }
        if (this.AbM != null) {
            jceOutputStream.write(this.AbM, 1);
        }
        if (this.AbN != null) {
            jceOutputStream.write(this.AbN, 2);
        }
    }

    static {
        AbP.add(new b());
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AbL = (c) jceInputStream.read(AbO, 0, false);
        this.AbM = (ArrayList) jceInputStream.read(AbP, 1, false);
        this.AbN = (d) jceInputStream.read(AbQ, 2, false);
    }
}
