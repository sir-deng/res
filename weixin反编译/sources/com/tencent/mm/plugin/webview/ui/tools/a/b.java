package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.f.a.ds;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.du;
import com.tencent.mm.f.a.dx;
import com.tencent.mm.f.a.ed;
import com.tencent.mm.f.a.lb;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static final byte[] lSU = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b tIw;
    public String fsi;
    public boolean hasInit = false;
    public byte[] tIm = null;
    public boolean tIo = false;
    public a tIv;
    public int tIx = -1;
    public boolean tIy = false;

    public static class a {
        private e fCC = null;
        private String fsi = "";
        public c qyk = new c<dr>() {
            {
                this.xmG = dr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return a.this.h((dr) bVar);
            }
        };
        public c tIA = new c<dt>() {
            {
                this.xmG = dt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return a.this.h((dt) bVar);
            }
        };
        public c tIB = new c<lb>() {
            {
                this.xmG = lb.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return a.this.h((lb) bVar);
            }
        };
        public c tIp = new c<ds>() {
            {
                this.xmG = ds.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return a.this.h((ds) bVar);
            }
        };
        public c tIz = new c<du>() {
            {
                this.xmG = du.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                return a.this.h((du) bVar);
            }
        };

        public a(e eVar, String str) {
            this.fCC = eVar;
            this.fsi = str;
        }

        final boolean h(com.tencent.mm.sdk.b.b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.fCC == null) {
                x.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof du) {
                    x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                    du duVar = (du) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", duVar.ftm.ffG);
                    bundle.putByteArray("exdevice_broadcast_data", duVar.ftm.fte);
                    bundle.putBoolean("exdevice_is_complete", duVar.ftm.aow);
                    this.fCC.n(15, bundle);
                } else if (bVar instanceof dt) {
                    x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                    dt dtVar = (dt) bVar;
                    if (bi.oN(dtVar.ftl.ffG) || bi.oN(dtVar.ftl.fsi) || dtVar.ftl.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dtVar.ftl.ffG);
                    bundle.putByteArray("exdevice_data", dtVar.ftl.data);
                    bundle.putString("exdevice_brand_name", dtVar.ftl.fsi);
                    this.fCC.n(16, bundle);
                } else if (bVar instanceof ds) {
                    x.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    ds dsVar = (ds) bVar;
                    if (bi.oN(dsVar.ftk.ffG)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dsVar.ftk.ffG);
                    bundle.putBoolean("exdevice_is_bound", dsVar.ftk.fsf);
                    this.fCC.n(17, bundle);
                } else if (bVar instanceof lb) {
                    lb lbVar = (lb) bVar;
                    if (lbVar.fDh.op != 2) {
                        return true;
                    }
                    if (bi.oN(lbVar.fDh.fAA) || !this.fsi.equals(lbVar.fDh.fAA)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", lbVar.fDh.ffG);
                    bundle.putInt("exdevice_on_state_change_state", lbVar.fDh.ftb);
                    this.fCC.n(1004, bundle);
                } else if (bVar instanceof dr) {
                    dr drVar = (dr) bVar;
                    bundle = new Bundle();
                    if (drVar.fti.ftj == 12) {
                        bundle.putBoolean("exdevice_bt_state", true);
                    } else {
                        bundle.putBoolean("exdevice_bt_state", false);
                    }
                    this.fCC.n(18, bundle);
                }
            } catch (Exception e) {
                x.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
            }
            return true;
        }
    }

    private b() {
    }

    public static b bUd() {
        if (tIw == null) {
            tIw = new b();
        }
        return tIw;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void bUb() {
        com.tencent.mm.sdk.b.b dxVar;
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.tIo));
        if (this.tIo) {
            dxVar = new dx();
            dxVar.ftp.fsj = false;
            dxVar.ftp.fsi = this.fsi;
            com.tencent.mm.sdk.b.a.xmy.m(dxVar);
            if (!dxVar.ftq.fsk) {
                x.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.tIo = false;
        }
        this.hasInit = false;
        if (this.tIv != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.tIv.tIz);
            com.tencent.mm.sdk.b.a.xmy.c(this.tIv.tIA);
            com.tencent.mm.sdk.b.a.xmy.c(this.tIv.tIB);
            com.tencent.mm.sdk.b.a.xmy.c(this.tIv.tIp);
            com.tencent.mm.sdk.b.a.xmy.c(this.tIv.qyk);
            this.tIv = null;
        }
        this.tIm = null;
        dxVar = new ed();
        dxVar.ftG.ffG = "";
        dxVar.ftG.direction = 0;
        dxVar.ftG.clear = true;
        com.tencent.mm.sdk.b.a.xmy.m(dxVar);
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", Boolean.valueOf(dxVar.ftH.fsk));
    }

    public static boolean bb(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void dQ(Context context) {
    }

    public final void bUc() {
    }
}
