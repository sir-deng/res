package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    public String AcA = "";
    public int AcB = 0;
    public String AcC = "";
    public String Acz = "";
    public int cIB = 0;
    public String hrN = "";
    public String model = "";
    public String platform = "";

    public final JceStruct newInit() {
        return new d();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.Acz != null) {
            jceOutputStream.write(this.Acz, 0);
        }
        if (this.AcA != null) {
            jceOutputStream.write(this.AcA, 1);
        }
        if (this.hrN != null) {
            jceOutputStream.write(this.hrN, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.AcB != 0) {
            jceOutputStream.write(this.AcB, 4);
        }
        if (this.AcC != null) {
            jceOutputStream.write(this.AcC, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.cIB != 0) {
            jceOutputStream.write(this.cIB, 7);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.Acz = jceInputStream.readString(0, false);
        this.AcA = jceInputStream.readString(1, false);
        this.hrN = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.AcB = jceInputStream.read(this.AcB, 4, false);
        this.AcC = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.cIB = jceInputStream.read(this.cIB, 7, false);
    }
}
