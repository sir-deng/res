package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.bp.b;
import com.tencent.mm.protocal.c.azf;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String fHE;
    public String fJt;
    public String fqG;
    public int jlI;
    public LinkedList<azf> krz = new LinkedList();
    public int lUc;
    public String lUd;
    public int nJA;
    public b nJB;
    public LinkedList<azf> nJC = new LinkedList();
    public int nJD = 999;
    public LinkedList<d> nJE = new LinkedList();
    public String nJF;
    public String nJG;
    public String nJH;
    public int nJI;
    public boolean nJJ = false;
    public int nJe;
    public long nJf;
    public long nJg;
    public int nJh;
    public int nJi;
    public int nJj;
    public int nJk;
    public String nJl;
    public int nJm;
    public int nJn;
    public int nJo;
    public int nJp;
    public boolean nJq = false;
    public boolean nJr = false;
    public boolean nJs = false;
    public boolean nJt = true;
    public int nJu = 0;
    public int nJv;
    public int nJw;
    public int nJx;
    public b nJy;
    public int nJz;

    public final int aUv() {
        if (this.nJE == null || this.nJE.size() <= 0) {
            return this.nJn;
        }
        return ((d) this.nJE.get(0)).nJn;
    }

    public final int aUw() {
        if (this.nJE == null || this.nJE.size() <= 0) {
            return this.jlI;
        }
        return ((d) this.nJE.get(0)).gRd;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.nJe), Long.valueOf(this.nJf), Long.valueOf(this.nJg), Integer.valueOf(this.nJh), Integer.valueOf(this.nJm), Integer.valueOf(this.nJn), Integer.valueOf(this.nJo), Integer.valueOf(this.jlI), this.lUd, Integer.valueOf(this.lUc), Integer.valueOf(this.nJk)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.fHE, this.nJG}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.krz.iterator();
        while (it.hasNext()) {
            azf azf = (azf) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{azf.wDa, Integer.valueOf(azf.wMQ)}));
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        if (this.nJE == null || this.nJE.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.nJE.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}
