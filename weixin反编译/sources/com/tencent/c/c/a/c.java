package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static b AbK = new b();
    public int AbA = 0;
    public int AbB = 0;
    public int AbC = 0;
    public short AbD = (short) 0;
    public String AbE = "";
    public int AbF = 0;
    public String AbG = "";
    public String AbH = "";
    public String AbI = "";
    public String AbJ = "";
    public String Abt = "";
    public String Abu = "";
    public String Abv = "";
    public int Abw = 0;
    public int Abx = 0;
    public b Aby = null;
    public int Abz = 0;
    public String guid = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public String kPP = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String njL = "";
    public String rkf = "";
    public String zmg = "";

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imei, 0);
        if (this.zmg != null) {
            jceOutputStream.write(this.zmg, 1);
        }
        if (this.kPP != null) {
            jceOutputStream.write(this.kPP, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.Abt != null) {
            jceOutputStream.write(this.Abt, 4);
        }
        if (this.Abu != null) {
            jceOutputStream.write(this.Abu, 5);
        }
        if (this.Abv != null) {
            jceOutputStream.write(this.Abv, 6);
        }
        if (this.Abw != 0) {
            jceOutputStream.write(this.Abw, 7);
        }
        if (this.Abx != 0) {
            jceOutputStream.write(this.Abx, 8);
        }
        if (this.Aby != null) {
            jceOutputStream.write(this.Aby, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.Abz != 0) {
            jceOutputStream.write(this.Abz, 12);
        }
        if (this.AbA != 0) {
            jceOutputStream.write(this.AbA, 13);
        }
        if (this.AbB != 0) {
            jceOutputStream.write(this.AbB, 14);
        }
        if (this.AbC != 0) {
            jceOutputStream.write(this.AbC, 15);
        }
        if (this.njL != null) {
            jceOutputStream.write(this.njL, 16);
        }
        if (this.AbD != (short) 0) {
            jceOutputStream.write(this.AbD, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.AbE != null) {
            jceOutputStream.write(this.AbE, 20);
        }
        if (this.AbF != 0) {
            jceOutputStream.write(this.AbF, 21);
        }
        if (this.AbG != null) {
            jceOutputStream.write(this.AbG, 22);
        }
        if (this.AbH != null) {
            jceOutputStream.write(this.AbH, 23);
        }
        if (this.rkf != null) {
            jceOutputStream.write(this.rkf, 24);
        }
        if (this.AbI != null) {
            jceOutputStream.write(this.AbI, 25);
        }
        if (this.AbJ != null) {
            jceOutputStream.write(this.AbJ, 26);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, true);
        this.zmg = jceInputStream.readString(1, false);
        this.kPP = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.Abt = jceInputStream.readString(4, false);
        this.Abu = jceInputStream.readString(5, false);
        this.Abv = jceInputStream.readString(6, false);
        this.Abw = jceInputStream.read(this.Abw, 7, false);
        this.Abx = jceInputStream.read(this.Abx, 8, false);
        this.Aby = (b) jceInputStream.read(AbK, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.Abz = jceInputStream.read(this.Abz, 12, false);
        this.AbA = jceInputStream.read(this.AbA, 13, false);
        this.AbB = jceInputStream.read(this.AbB, 14, false);
        this.AbC = jceInputStream.read(this.AbC, 15, false);
        this.njL = jceInputStream.readString(16, false);
        this.AbD = jceInputStream.read(this.AbD, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.AbE = jceInputStream.readString(20, false);
        this.AbF = jceInputStream.read(this.AbF, 21, false);
        this.AbG = jceInputStream.readString(22, false);
        this.AbH = jceInputStream.readString(23, false);
        this.rkf = jceInputStream.readString(24, false);
        this.AbI = jceInputStream.readString(25, false);
        this.AbJ = jceInputStream.readString(26, false);
    }
}
