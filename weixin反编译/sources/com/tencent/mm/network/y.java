package com.tencent.mm.network;

import com.tencent.mm.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.f.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class y {
    private static final byte[] icr = n.eh(7);
    public m ics;

    public final void onPush(int i, byte[] bArr) {
        x.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.ics.d(138, icr);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.ics.d(10, bArr);
                    return;
                }
                return;
            case 24:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", bi.bx(bArr));
                this.ics.d(138, bArr);
                return;
            case 39:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.ics.d(39, null);
                return;
            case 61:
                this.ics.d(GameJsApiOperateGameCenterMsg.CTRL_BYTE, bArr);
                return;
            case 120:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.ics.d(120, bArr);
                    return;
                }
                return;
            case 122:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.ics.d(268369921, bArr);
                    return;
                }
                return;
            case ar.CTRL_INDEX /*192*/:
                this.ics.d(ar.CTRL_INDEX, bArr);
                return;
            case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.ics.d(GameJsApiGetGameCommInfo.CTRL_BYTE, bArr);
                return;
            case a.CTRL_INDEX /*244*/:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.ics.d(a.CTRL_INDEX, bArr);
                return;
            case 311:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.ics.d(311, bArr);
                return;
            case b.CTRL_INDEX /*318*/:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.ics.d(b.CTRL_INDEX, bArr);
                return;
            case 319:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.ics.d(319, bArr);
                return;
            case 268369923:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.ics.d(268369923, bArr);
                return;
            case 1000000205:
                this.ics.d(1000000205, bArr);
                return;
            case 2147480001:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", bi.bx(bArr));
                this.ics.d(2147480001, bArr);
                return;
            default:
                return;
        }
    }
}
