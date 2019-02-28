package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.f.a.il;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class GalleryStubService extends Service {
    private a mXs = new a() {
        private int hGs;

        public final void ap(int i, String str) {
            g.pWK.k(i, str);
        }

        public final void a(String str, String str2, boolean z, int i, boolean z2) {
            if (com.tencent.mm.sdk.b.a.xmy != null) {
                b ilVar = new il();
                ilVar.fzK.fzL = Boolean.valueOf(z);
                ilVar.fzK.imagePath = str;
                ilVar.fzK.fzM = i;
                ilVar.fzK.toUser = str2;
                ilVar.fzK.fzN = Boolean.valueOf(z2);
                com.tencent.mm.sdk.b.a.xmy.m(ilVar);
            }
        }

        public final void aOR() {
            f.vS(19);
        }

        public final int zO() {
            return com.tencent.mm.j.b.zO();
        }

        public final int zM() {
            return com.tencent.mm.j.b.zM();
        }

        public final int zL() {
            return com.tencent.mm.j.b.zL();
        }

        public final boolean ft(boolean z) {
            as.Hm();
            return c.Db().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, z);
        }

        public final int Cb(String str) {
            PInt pInt = new PInt();
            t.a(str, pInt, new PInt());
            return pInt.value;
        }

        public final int aOS() {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.hGs);
            return HardCoderJNI.startPerformance(HardCoderJNI.hcAlbumScrollEnable, HardCoderJNI.hcAlbumScrollDelay, HardCoderJNI.hcAlbumScrollCPU, HardCoderJNI.hcAlbumScrollIO, HardCoderJNI.hcAlbumScrollThr ? Process.myTid() : 0, HardCoderJNI.hcAlbumScrollTimeout, 702, HardCoderJNI.hcAlbumScrollAction, "MicroMsg.GalleryStubService");
        }

        public final int qI(int i) {
            int stopPerformace = HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.hGs);
            this.hGs = 0;
            return stopPerformace;
        }
    };

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", intent);
        return this.mXs;
    }
}
