package com.tencent.mm.ap.a.f;

import com.tencent.mm.ap.a.a.b;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements Runnable {
    private final b hEG = this.hFT.hEG;
    private final c hEY;
    private final com.tencent.mm.ap.a.b hFT;
    private final com.tencent.mm.ap.a.c.c hFU;
    private final com.tencent.mm.ap.a.c.a hFa;
    private final com.tencent.mm.ap.a.c.b hFb;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.ap.a.b bVar, com.tencent.mm.ap.a.c.c cVar2) {
        this.url = str;
        this.hFT = bVar;
        if (cVar == null) {
            this.hEY = this.hEG.hEY;
        } else {
            this.hEY = cVar;
        }
        this.hFU = cVar2;
        if (this.hEY.hFb != null) {
            this.hFb = this.hEY.hFb;
        } else {
            this.hFb = this.hEG.hFb;
        }
        this.hFa = this.hEG.hFa;
    }

    public final void run() {
        com.tencent.mm.ap.a.d.b bVar = new com.tencent.mm.ap.a.d.b();
        bVar = this.hFb.lD(this.url);
        if (bVar == null) {
            this.hFU.a(false, this.hEY.hFO);
        } else if (!(d.decodeByteArray(bVar.data, 10, 10) == null && this.hEY.hFM) && this.hFa.a(this.url, bVar.data, this.hEY)) {
            if (this.hFU != null) {
                this.hFU.a(true, this.hEY.hFO);
            }
        } else if (this.hFU != null) {
            this.hFU.a(false, this.hEY.hFO);
        }
    }
}
