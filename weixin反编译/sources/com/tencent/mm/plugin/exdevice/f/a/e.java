package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e {
    public static void a(final Context context, final ImageView imageView, final String str, final int i) {
        Assert.assertTrue(imageView != null);
        if (ah.isMainThread()) {
            b(imageView, str, i);
        } else {
            ah.y(new Runnable() {
                public final void run() {
                    e.b(imageView, str, i);
                }
            });
        }
    }

    static void b(ImageView imageView, String str, int i) {
        if (bi.oN(str) || "#".equals(str)) {
            x.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            return;
        }
        x.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", str);
        ad.aEU().a(str, imageView, ad.zB(str));
    }

    public static void b(final MMActivity mMActivity) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(R.l.ecU));
        linkedList2.add(Integer.valueOf(0));
        h.a((Context) mMActivity, "", linkedList, linkedList2, null, true, new d() {
            public final void cr(int i, int i2) {
                switch (i2) {
                    case 0:
                        Context context = mMActivity;
                        Intent intent = new Intent();
                        intent.putExtra("query_source_type", 9);
                        intent.putExtra("query_media_type", 1);
                        intent.putExtra("max_select_count", 1);
                        com.tencent.mm.bl.d.b(context, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        if (i == 1001 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                return false;
            }
            String str2 = (String) stringArrayListExtra.get(0);
            Intent intent2 = new Intent();
            intent2.putExtra("CropImageMode", 1);
            intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gJn + "temp.cover");
            intent2.putExtra("CropImage_ImgPath", str2);
            com.tencent.mm.bl.d.a((Context) mMActivity, ".ui.tools.CropImageNewUI", intent2, 1002);
            return true;
        } else if (i != 1002 || i2 != -1) {
            return false;
        } else {
            String zD = d.zD(com.tencent.mm.compatible.util.e.gJn + "temp.cover");
            a aFb = ad.aFb();
            aFb.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            aFb.lUy = com.tencent.mm.modelcdntran.d.a("uploadexdeivce", currentTimeMillis, q.GE().field_username, String.valueOf(currentTimeMillis));
            String str3 = aFb.lUy;
            i iVar = new i();
            iVar.hve = aFb;
            iVar.field_mediaId = str3;
            iVar.field_fullpath = zD;
            iVar.field_thumbpath = "";
            iVar.field_fileType = b.htE;
            iVar.field_talker = "";
            iVar.field_priority = b.htt;
            iVar.field_needStorage = true;
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 200;
            iVar.field_bzScene = 2;
            if (!g.MP().c(iVar)) {
                x.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", str3);
            }
            return true;
        }
    }
}
