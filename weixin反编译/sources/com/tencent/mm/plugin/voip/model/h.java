package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;

public final class h {
    long beginTime = 0;
    public int sqW;
    public int sqX;
    public int sqY;
    public int sqZ;
    long srA;
    long srB;
    long srC;
    public long srD;
    long srE;
    long srF;
    long srG;
    byte sra;
    byte srb;
    byte srd;
    byte sre;
    byte srf;
    byte srg;
    byte srh;
    int sri;
    public int srj;
    public int srk;
    public int srl;
    public int srm;
    public int srn;
    public int sro;
    public int srp;
    int srq;
    int srr;
    int srs;
    int srt;
    int sru;
    int srv;
    int srw;
    int srx;
    public long sry;
    long srz;

    public h() {
        reset();
        bHq();
    }

    public final void bHp() {
        if (this.srD == 0) {
            this.srt = 0;
        } else {
            this.srt = (int) (System.currentTimeMillis() - this.srD);
        }
        a.eA("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        a.eA("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.srt);
    }

    public final void reset() {
        this.beginTime = 0;
        this.sqW = 0;
        this.sqX = 0;
        this.sqY = 0;
        this.sqZ = 0;
        this.sra = (byte) 0;
        this.srb = (byte) 0;
        this.srd = (byte) 0;
        this.sre = (byte) 0;
        this.srf = (byte) 0;
        this.srg = (byte) 0;
        this.srh = (byte) 0;
        this.sri = 0;
    }

    public final void bHq() {
        this.sry = 0;
        this.srC = 0;
        this.srD = 0;
        this.srE = 0;
        this.srF = 0;
        this.srG = 0;
        this.srz = 0;
        this.srA = 0;
        this.srB = 0;
        this.srj = 0;
        this.srk = 0;
        this.srl = 0;
        this.srm = 0;
        this.srn = 0;
        this.sro = 0;
        this.srp = 0;
        this.srq = 0;
        this.srr = 0;
        this.srs = 0;
        this.srt = 0;
        this.sru = 0;
        this.srv = 0;
        this.srw = 0;
        this.srx = 0;
    }

    public final String bHr() {
        return "," + this.srh;
    }
}
