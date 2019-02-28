package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends JceStruct {
    static Map<Integer, ArrayList<f>> AdU;
    public int AdA = 0;
    public long AdR = 0;
    public Map<Integer, ArrayList<f>> AdS = null;
    public int AdT = 0;
    public int Adx = 0;
    public int Ady = 0;
    public int Adz = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AdR, 0);
        jceOutputStream.write(this.AdS, 1);
        jceOutputStream.write(this.Adx, 2);
        jceOutputStream.write(this.Ady, 3);
        jceOutputStream.write(this.Adz, 4);
        jceOutputStream.write(this.AdA, 5);
        if (this.AdT != 0) {
            jceOutputStream.write(this.AdT, 6);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AdR = jceInputStream.read(this.AdR, 0, true);
        if (AdU == null) {
            AdU = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f());
            AdU.put(valueOf, arrayList);
        }
        this.AdS = (Map) jceInputStream.read(AdU, 1, true);
        this.Adx = jceInputStream.read(this.Adx, 2, false);
        this.Ady = jceInputStream.read(this.Ady, 3, false);
        this.Adz = jceInputStream.read(this.Adz, 4, false);
        this.AdA = jceInputStream.read(this.AdA, 5, false);
        this.AdT = jceInputStream.read(this.AdT, 6, false);
    }
}
