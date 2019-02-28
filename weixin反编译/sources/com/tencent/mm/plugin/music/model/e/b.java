package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.au.a;
import com.tencent.mm.au.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public a fBv;
    private e gLE;
    private com.tencent.mm.ad.b hGV;
    public afo oRs;
    public boolean oRt;

    public b(a aVar, boolean z) {
        int i;
        this.fBv = aVar;
        this.oRt = z;
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new afn();
        aVar2.hnU = new afo();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        this.hGV = aVar2.Kf();
        afn afn = (afn) this.hGV.hnQ.hnY;
        afn.wub = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            afn.wuc = n.N(aVar.field_songWebUrl.getBytes());
        }
        if (c.QG()) {
            i = 0;
        } else {
            i = 1;
        }
        afn.wud = i;
        if (c.QF()) {
            i = 1;
        } else {
            i = 0;
        }
        afn.wue = i;
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(afn.wud), Integer.valueOf(afn.wue));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.oRs = (afo) this.hGV.hnR.hnY;
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }
}
