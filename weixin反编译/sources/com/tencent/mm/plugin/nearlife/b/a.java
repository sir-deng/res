package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import java.util.LinkedList;

public final class a {
    public int fXe;
    public String fpg;
    public String hMN;
    public int kzz;
    public String oUX;
    public float oUY;
    public int oUZ;
    public LinkedList<Integer> oVa = new LinkedList();
    public int oVb;
    public LinkedList<bet> oVc = new LinkedList();
    public float oVd;
    public String oVe;
    public bes oVf;
    public aos oVg;
    public String odq;

    public a(String str, aos aos) {
        this.odq = str;
        this.oUX = aos.oUX;
        this.fpg = aos.fpg;
        this.oUY = aos.oUY;
        this.oUZ = aos.oUZ;
        this.oVa = aos.oVa;
        this.oVb = aos.oVb;
        this.oVc = aos.oVc;
        this.oVd = aos.oVd;
        this.oVe = aos.oVe;
        this.kzz = aos.kzz;
        this.oVf = aos.oVf;
        this.fXe = aos.wCB;
        this.oVg = aos;
    }
}
