package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.j.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

public final class c {
    public static final int hVb = b.zO();
    Context context = null;
    int duration = 0;
    String fileName = null;
    String fwx = null;
    public a hVc = null;
    String hVd = null;
    final AsyncTask<String, Integer, String> hVe = new AsyncTask<String, Integer, String>() {
        int ret = 0;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return TH();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (c.this.hVc != null) {
                c.this.hVc.b(this.ret, c.this.fileName, c.this.hVd, c.this.duration);
            }
        }

        private String TH() {
            com.tencent.mm.compatible.j.a.a j;
            Throwable e;
            this.ret = 0;
            boolean is2G = ao.is2G(ad.getContext());
            try {
                j = com.tencent.mm.compatible.j.a.j(c.this.context, c.this.intent);
            } catch (Throwable e2) {
                x.e("MicroMsg.ImportVideo", "exception:%s", bi.i(e2));
                j = null;
            }
            if (j == null) {
                x.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                g.pWK.a(106, 244, 1, false);
                this.ret = -50005;
                return null;
            }
            c.this.hVd = j.filename;
            int bN = e.bN(c.this.hVd);
            x.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(bN), Integer.valueOf(j.duration), c.this.hVd);
            if (bN <= 0) {
                g.pWK.a(106, 244, 1, false);
                this.ret = -50001;
                return null;
            }
            if (bN > (is2G ? 10485760 : c.hVb)) {
                g.pWK.a(106, 245, 1, false);
                this.ret = -50002;
                return null;
            }
            k.r(c.this.hVd, c.this.videoPath, false);
            c.this.duration = j.duration / 1000;
            Object obj = 1;
            if (j.bitmap != null) {
                try {
                    d.a(j.bitmap, 60, CompressFormat.JPEG, c.this.fwx, true);
                    try {
                        g.pWK.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e2 = e3;
                        obj = null;
                        x.e("MicroMsg.ImportVideo", "exception:%s", bi.i(e2));
                        if (obj != null) {
                            try {
                                g.pWK.a(106, 232, 1, false);
                                d.a(d.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, c.this.fwx, true);
                            } catch (Throwable e22) {
                                x.e("MicroMsg.ImportVideo", "exception:%s", bi.i(e22));
                            }
                        }
                        if (!e.bO(c.this.videoPath)) {
                            this.ret = -50003;
                        }
                        if (!e.bO(c.this.fwx)) {
                            this.ret = -50004;
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    x.e("MicroMsg.ImportVideo", "exception:%s", bi.i(e22));
                    if (obj != null) {
                        g.pWK.a(106, 232, 1, false);
                        d.a(d.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, c.this.fwx, true);
                    }
                    if (e.bO(c.this.videoPath)) {
                        this.ret = -50003;
                    }
                    if (e.bO(c.this.fwx)) {
                        this.ret = -50004;
                    }
                    return null;
                }
            }
            if (obj != null) {
                g.pWK.a(106, 232, 1, false);
                d.a(d.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, c.this.fwx, true);
            }
            if (e.bO(c.this.videoPath)) {
                this.ret = -50003;
            }
            if (e.bO(c.this.fwx)) {
                this.ret = -50004;
            }
            return null;
        }
    };
    Intent intent = null;
    String videoPath = null;

    public interface a {
        void b(int i, String str, String str2, int i2);
    }

    public final void a(Context context, Intent intent, a aVar) {
        this.context = context;
        this.intent = intent;
        this.fileName = s.nw((String) com.tencent.mm.kernel.g.Dq().Db().get(2, (Object) ""));
        o.Ub();
        this.fwx = s.ny(this.fileName);
        o.Ub();
        this.videoPath = s.nx(this.fileName);
        this.hVc = aVar;
        this.hVe.execute(new String[0]);
    }
}
