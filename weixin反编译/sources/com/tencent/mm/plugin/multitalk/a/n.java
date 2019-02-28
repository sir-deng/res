package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    byte[] fLf;
    private final b gLB;
    private e gLE;
    int lPH;
    int lPI;

    public n(int i, int i2, byte[] bArr) {
        String str;
        this.lPH = i;
        this.lPI = i2;
        a aVar = new a();
        aVar.hnT = new atg();
        aVar.hnU = new ath();
        switch (i2) {
            case 1918:
                str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
                break;
            case 1919:
                str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
                break;
            case 1927:
                str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
                break;
            case 1928:
                str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
                break;
            case 1929:
                str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
                break;
            case 1931:
                str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
                break;
            case 1932:
                str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
                break;
            case 1933:
                str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
                break;
            case 1935:
                str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
                break;
            case 1937:
                str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
                break;
            case 1938:
                str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
                break;
            case 1939:
                str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
                break;
            default:
                str = "";
                break;
        }
        x.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", Integer.valueOf(i2), str);
        aVar.uri = str;
        aVar.hnS = this.lPI;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((atg) this.gLB.hnQ.hnY).vQW = new bes().bl(bArr);
    }

    public final int getType() {
        return this.lPI;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " " + this.lPI);
        this.fLf = com.tencent.mm.platformtools.n.a(((ath) ((b) qVar).hnR.hnY).vQW);
        this.gLE.a(i2, i3, str, this);
    }
}
