package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static byte[] Acx;
    static byte[] Acy;
    public int AbF = 0;
    public int Aco = 0;
    public int Acp = 0;
    public int Acq = 0;
    public byte[] Acr = null;
    public int Acs = 0;
    public long Act = 0;
    public byte[] Acu = null;
    public int Acv = 0;
    public int Acw = 0;
    public int hvT = 0;
    public int requestType = 0;

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.Aco != 0) {
            jceOutputStream.write(this.Aco, 0);
        }
        jceOutputStream.write(this.AbF, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.Acp != 0) {
            jceOutputStream.write(this.Acp, 3);
        }
        if (this.Acq != 0) {
            jceOutputStream.write(this.Acq, 4);
        }
        if (this.Acr != null) {
            jceOutputStream.write(this.Acr, 5);
        }
        if (this.Acs != 0) {
            jceOutputStream.write(this.Acs, 6);
        }
        if (this.hvT != 0) {
            jceOutputStream.write(this.hvT, 7);
        }
        if (this.Act != 0) {
            jceOutputStream.write(this.Act, 8);
        }
        if (this.Acu != null) {
            jceOutputStream.write(this.Acu, 9);
        }
        if (this.Acv != 0) {
            jceOutputStream.write(this.Acv, 10);
        }
        if (this.Acw != 0) {
            jceOutputStream.write(this.Acw, 11);
        }
    }

    static {
        byte[] bArr = new byte[1];
        Acx = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        Acy = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.Aco = jceInputStream.read(this.Aco, 0, false);
        this.AbF = jceInputStream.read(this.AbF, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.Acp = jceInputStream.read(this.Acp, 3, false);
        this.Acq = jceInputStream.read(this.Acq, 4, false);
        this.Acr = jceInputStream.read(Acx, 5, false);
        this.Acs = jceInputStream.read(this.Acs, 6, false);
        this.hvT = jceInputStream.read(this.hvT, 7, false);
        this.Act = jceInputStream.read(this.Act, 8, false);
        this.Acu = jceInputStream.read(Acy, 9, false);
        this.Acv = jceInputStream.read(this.Acv, 10, false);
        this.Acw = jceInputStream.read(this.Acw, 11, false);
    }
}
