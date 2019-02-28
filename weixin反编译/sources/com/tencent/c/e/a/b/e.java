package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e extends JceStruct {
    static ArrayList<g> AdP;
    public int AcO = 0;
    public long AdM = 0;
    public ArrayList<g> AdN = null;
    public double AdO = 0.0d;
    public int action = 0;
    public double lat = 0.0d;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AdM, 0);
        jceOutputStream.write(this.AdN, 1);
        if (this.AcO != 0) {
            jceOutputStream.write(this.AcO, 2);
        }
        if (this.action != 0) {
            jceOutputStream.write(this.action, 3);
        }
        if (this.lat != 0.0d) {
            jceOutputStream.write(this.lat, 4);
        }
        if (this.AdO != 0.0d) {
            jceOutputStream.write(this.AdO, 5);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AdM = jceInputStream.read(this.AdM, 0, true);
        if (AdP == null) {
            AdP = new ArrayList();
            AdP.add(new g());
        }
        this.AdN = (ArrayList) jceInputStream.read(AdP, 1, true);
        this.AcO = jceInputStream.read(this.AcO, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.AdO = jceInputStream.read(this.AdO, 5, false);
    }
}
