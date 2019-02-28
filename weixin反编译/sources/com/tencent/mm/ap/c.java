package com.tencent.mm.ap;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    private HashMap<String, c> hBm = new HashMap();

    static class a implements Runnable {
        private HashMap<String, c> hBm;
        private Bitmap hBn;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap) {
            this.url = str;
            this.hBn = bitmap;
            this.hBm = hashMap;
        }

        public final void run() {
            o.PB();
            c.g(this.url, this.hBn);
            if (this.hBm != null) {
                c cVar = (c) this.hBm.remove(this.url);
                if (cVar != null) {
                    cVar.n(this.hBn);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? "null" : this.url;
            x.i(str, str2, objArr);
        }
    }

    static class b implements Runnable {
        private HashMap<String, c> hBm;
        private String url;

        b(String str, HashMap<String, c> hashMap) {
            this.url = str;
            this.hBm = hashMap;
        }

        public final void run() {
            byte[] Ws = bi.Ws(this.url);
            if (Ws == null) {
                x.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                return;
            }
            Bitmap bn;
            try {
                bn = d.bn(Ws);
            } catch (Exception e) {
                x.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e.getLocalizedMessage());
                bn = null;
            }
            x.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            ah.y(new a(this.url, bn, this.hBm));
        }
    }

    public interface c {
        void n(Bitmap bitmap);
    }

    protected final void finalize() {
        super.finalize();
    }

    public static void g(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.CdnImageService", "push fail, key is null");
        } else {
            com.tencent.mm.cache.e.a.a("local_cdn_img_cache", str, (Object) bitmap);
        }
    }

    public static Bitmap iJ(String str) {
        if (str != null && str.length() != 0) {
            return (Bitmap) com.tencent.mm.cache.e.a.D("local_cdn_img_cache", str);
        }
        x.e("MicroMsg.CdnImageService", "get fail, key is null");
        return null;
    }

    public final void lh(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
        } else {
            this.hBm.remove(str);
        }
    }

    public final void a(String str, c cVar) {
        if (bi.oN(str)) {
            x.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            return;
        }
        Bitmap iJ = iJ(str);
        if (iJ == null || iJ.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (iJ == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
            if (this.hBm.containsKey(str)) {
                x.w("MicroMsg.CdnImageService", "contains url[%s]", str);
                return;
            }
            this.hBm.put(str, cVar);
            e.post(new b(str, this.hBm), "CdnImageService_download");
            return;
        }
        x.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (cVar != null) {
            cVar.n(iJ);
        }
    }
}
