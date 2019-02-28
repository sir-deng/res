package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.nb;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ nb mhI;
    final /* synthetic */ a mhJ;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, nb nbVar) {
        this.mhJ = aVar;
        this.mhI = nbVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        x.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.mhI.fFQ.fFR.SO(null);
        } else if (f.zl()) {
            as.Hg();
            b bVar = (b) bq.ib("plugin.extaccessories");
            if (bVar == null) {
                x.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                as.Hg().a("plugin.extaccessories", bVar);
            }
            String str = System.currentTimeMillis();
            String str2 = (!as.Hp() || bi.oN(str)) ? "" : bVar.gRT + "image/spen/spen_" + str;
            if (bi.oN(str2)) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.mhI.fFQ.fFR.SO(null);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                d.a(bitmap, 55, CompressFormat.JPEG, str2, true);
                x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", str2);
                this.mhI.fFQ.fFR.SO(str2);
            } catch (Throwable e) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.mhI.fFQ.fFR.SO(null);
            }
        } else {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.mhI.fFQ.fFR.SO(null);
        }
    }
}
