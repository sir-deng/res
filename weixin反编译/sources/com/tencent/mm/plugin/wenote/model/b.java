package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE = null;
    public int tWD = 1;
    private String tWE = "";
    private vl tWF = null;
    private LinkedList<vl> tWG = new LinkedList();
    public int tWH = 0;

    public b(int i, int i2, String str, LinkedList<vl> linkedList, vl vlVar) {
        this.tWG = linkedList;
        this.tWF = vlVar;
        this.tWE = str;
        this.tWD = i2;
        this.tWH = i;
        a aVar = new a();
        aVar.hnT = new vr();
        aVar.hnU = new vs();
        aVar.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        aVar.hnS = 921;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        vr vrVar = (vr) this.gLB.hnQ.hnY;
        vrVar.nne = this.tWD;
        vrVar.wme = this.tWF;
        vrVar.wmd = this.tWG;
        vrVar.wmc = this.tWE;
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        vs vsVar = (vs) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        if (i2 != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", Integer.valueOf(i2));
            this.gLE.a(i2, -1, str, this);
        } else if (vsVar == null || vsVar.wRa == null) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.gLE.a(i2, 0, str, this);
        } else if (vsVar.wRa.vQL != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.gLE.a(i2, 0, str, this);
        } else if (vsVar.wmf > 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.gLE.a(i2, -1, str, this);
        } else {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.gLE.a(i2, 0, str, this);
        }
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final int getType() {
        return 921;
    }
}
