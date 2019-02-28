package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b extends JceStruct {
    static byte[] Ack;
    static byte[] Acl;
    static ArrayList<Integer> Acm = new ArrayList();
    static ArrayList<byte[]> Acn = new ArrayList();
    public int AbR = 0;
    public byte[] AbS = null;
    public String AbT = "";
    public byte[] AbU = null;
    public long AbV = 0;
    public String AbW = "";
    public int AbX = 0;
    public String AbY = "";
    public int AbZ = 0;
    public String Aca = "";
    public int Acb = 0;
    public int Acc = 0;
    public int Acd = 0;
    public ArrayList<Integer> Ace = null;
    public int Acf = 0;
    public boolean Acg = false;
    public int Ach = 0;
    public int Aci = 0;
    public ArrayList<byte[]> Acj = null;

    public final JceStruct newInit() {
        return new b();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AbR, 0);
        if (this.AbS != null) {
            jceOutputStream.write(this.AbS, 1);
        }
        if (this.AbT != null) {
            jceOutputStream.write(this.AbT, 2);
        }
        if (this.AbU != null) {
            jceOutputStream.write(this.AbU, 3);
        }
        if (this.AbV != 0) {
            jceOutputStream.write(this.AbV, 4);
        }
        if (this.AbW != null) {
            jceOutputStream.write(this.AbW, 5);
        }
        if (this.AbX != 0) {
            jceOutputStream.write(this.AbX, 6);
        }
        if (this.AbY != null) {
            jceOutputStream.write(this.AbY, 7);
        }
        if (this.AbZ != 0) {
            jceOutputStream.write(this.AbZ, 8);
        }
        if (this.Aca != null) {
            jceOutputStream.write(this.Aca, 9);
        }
        jceOutputStream.write(this.Acb, 10);
        if (this.Acc != 0) {
            jceOutputStream.write(this.Acc, 11);
        }
        if (this.Acd != 0) {
            jceOutputStream.write(this.Acd, 12);
        }
        if (this.Ace != null) {
            jceOutputStream.write(this.Ace, 13);
        }
        if (this.Acf != 0) {
            jceOutputStream.write(this.Acf, 14);
        }
        jceOutputStream.write(this.Acg, 15);
        if (this.Ach != 0) {
            jceOutputStream.write(this.Ach, 16);
        }
        jceOutputStream.write(this.Aci, 17);
        if (this.Acj != null) {
            jceOutputStream.write(this.Acj, 18);
        }
    }

    static {
        byte[] bArr = new byte[1];
        Ack = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        Acl = bArr;
        bArr[0] = (byte) 0;
        Acm.add(Integer.valueOf(0));
        bArr = new byte[1];
        bArr[0] = (byte) 0;
        Acn.add(bArr);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.AbR = jceInputStream.read(this.AbR, 0, true);
        this.AbS = jceInputStream.read(Ack, 1, false);
        this.AbT = jceInputStream.readString(2, false);
        this.AbU = jceInputStream.read(Acl, 3, false);
        this.AbV = jceInputStream.read(this.AbV, 4, false);
        this.AbW = jceInputStream.readString(5, false);
        this.AbX = jceInputStream.read(this.AbX, 6, false);
        this.AbY = jceInputStream.readString(7, false);
        this.AbZ = jceInputStream.read(this.AbZ, 8, false);
        this.Aca = jceInputStream.readString(9, false);
        this.Acb = jceInputStream.read(this.Acb, 10, false);
        this.Acc = jceInputStream.read(this.Acc, 11, false);
        this.Acd = jceInputStream.read(this.Acd, 12, false);
        this.Ace = (ArrayList) jceInputStream.read(Acm, 13, false);
        this.Acf = jceInputStream.read(this.Acf, 14, false);
        this.Acg = jceInputStream.read(this.Acg, 15, false);
        this.Ach = jceInputStream.read(this.Ach, 16, false);
        this.Aci = jceInputStream.read(this.Aci, 17, false);
        this.Acj = (ArrayList) jceInputStream.read(Acn, 18, false);
    }
}
