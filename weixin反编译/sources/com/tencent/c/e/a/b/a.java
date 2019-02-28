package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static ArrayList<e> AdH;
    public String Abt = "";
    public long AdB = 0;
    public String AdC = "";
    public ArrayList<e> AdD = null;
    public String AdE = "";
    public String AdF = "";
    public int AdG = 0;
    public int fDM = 0;
    public String ffG = "";
    public int hMV = 0;
    public String hrN = "";
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int requestType = 0;
    public int sdkVer = 0;
    public int zYY = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AdB, 0);
        jceOutputStream.write(this.AdC, 1);
        jceOutputStream.write(this.AdD, 2);
        jceOutputStream.write(this.hMV, 3);
        jceOutputStream.write(this.Abt, 4);
        jceOutputStream.write(this.fDM, 5);
        jceOutputStream.write(this.requestType, 6);
        jceOutputStream.write(this.AdE, 7);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 8);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 9);
        }
        if (this.hrN != null) {
            jceOutputStream.write(this.hrN, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.AdF != null) {
            jceOutputStream.write(this.AdF, 12);
        }
        if (this.AdG != 0) {
            jceOutputStream.write(this.AdG, 13);
        }
        if (this.sdkVer != 0) {
            jceOutputStream.write(this.sdkVer, 14);
        }
        if (this.ffG != null) {
            jceOutputStream.write(this.ffG, 15);
        }
        jceOutputStream.write(this.zYY, 16);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AdB = jceInputStream.read(this.AdB, 0, true);
        this.AdC = jceInputStream.readString(1, true);
        if (AdH == null) {
            AdH = new ArrayList();
            AdH.add(new e());
        }
        this.AdD = (ArrayList) jceInputStream.read(AdH, 2, true);
        this.hMV = jceInputStream.read(this.hMV, 3, true);
        this.Abt = jceInputStream.readString(4, true);
        this.fDM = jceInputStream.read(this.fDM, 5, true);
        this.requestType = jceInputStream.read(this.requestType, 6, true);
        this.AdE = jceInputStream.readString(7, true);
        this.imei = jceInputStream.readString(8, false);
        this.imsi = jceInputStream.readString(9, false);
        this.hrN = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.AdF = jceInputStream.readString(12, false);
        this.AdG = jceInputStream.read(this.AdG, 13, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 14, false);
        this.ffG = jceInputStream.readString(15, false);
        this.zYY = jceInputStream.read(this.zYY, 16, false);
    }
}
