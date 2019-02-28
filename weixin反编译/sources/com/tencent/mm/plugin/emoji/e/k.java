package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ap.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class k {

    /* renamed from: com.tencent.mm.plugin.emoji.e.k$2 */
    static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity fhm;
        final /* synthetic */ String jBQ;
        final /* synthetic */ String jtX;
        final /* synthetic */ String lCl;
        final /* synthetic */ String lCn;
        final /* synthetic */ String lCo;
        final /* synthetic */ int lCp;
        final /* synthetic */ String lCq;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.lCn = str;
            this.lCo = str2;
            this.jtX = str3;
            this.lCp = i;
            this.lCl = str4;
            this.jBQ = str5;
            this.lCq = str6;
            this.fhm = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.lCn;
                String str3 = this.lCo;
                String str4 = this.jtX;
                int i2 = this.lCp;
                String str5 = this.lCl;
                String str6 = this.jBQ;
                String str7 = this.lCq;
                x.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                IMediaObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                o.PB();
                Bitmap iJ = c.iJ(str7);
                if (!(iJ == null || iJ.isRecycled())) {
                    x.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    iJ.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                b orVar = new or();
                orVar.fHs.fzX = wXMediaMessage;
                orVar.fHs.toUser = str2;
                orVar.fHs.fHt = 49;
                orVar.fHs.fHu = str2;
                orVar.fHs.fHv = "";
                com.tencent.mm.sdk.b.a.xmy.m(orVar);
                if (!TextUtils.isEmpty(str)) {
                    orVar = new ot();
                    orVar.fHD.fHE = str2;
                    orVar.fHD.content = str;
                    orVar.fHD.type = s.hs(str2);
                    orVar.fHD.flags = 0;
                    com.tencent.mm.sdk.b.a.xmy.m(orVar);
                }
                h.bu(this.fhm, this.fhm.getString(R.l.dGR));
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.k$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ MMActivity fhm;
        final /* synthetic */ String jPS;
        final /* synthetic */ String lCh;
        final /* synthetic */ String lCi;
        final /* synthetic */ String lCj;
        final /* synthetic */ String lCk;
        final /* synthetic */ String lCl;
        final /* synthetic */ int lCm;

        public AnonymousClass1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
            this.lCh = str;
            this.lCi = str2;
            this.lCj = str3;
            this.lCk = str4;
            this.jPS = str5;
            this.lCl = str6;
            this.lCm = i;
            this.fhm = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.lCh;
                String str3 = this.lCi;
                String str4 = this.lCj;
                String str5 = this.lCk;
                String str6 = this.jPS;
                String str7 = this.lCl;
                int i2 = this.lCm;
                x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str4;
                wXMediaMessage.description = str5;
                IMediaObject wXEmojiSharedObject = new WXEmojiSharedObject();
                wXEmojiSharedObject.packageflag = i2;
                wXEmojiSharedObject.packageid = str3;
                wXEmojiSharedObject.thumburl = str6;
                wXEmojiSharedObject.url = str7;
                wXMediaMessage.mediaObject = wXEmojiSharedObject;
                o.PB();
                Bitmap iJ = c.iJ(str6);
                if (!(iJ == null || iJ.isRecycled())) {
                    x.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    iJ.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                b orVar = new or();
                orVar.fHs.fzX = wXMediaMessage;
                orVar.fHs.toUser = str2;
                orVar.fHs.fHt = 49;
                orVar.fHs.fHu = str2;
                orVar.fHs.fHv = "";
                com.tencent.mm.sdk.b.a.xmy.m(orVar);
                if (!TextUtils.isEmpty(str)) {
                    orVar = new ot();
                    orVar.fHD.fHE = str2;
                    orVar.fHD.content = str;
                    orVar.fHD.type = s.hs(str2);
                    orVar.fHD.flags = 0;
                    com.tencent.mm.sdk.b.a.xmy.m(orVar);
                }
                g.pWK.h(10993, Integer.valueOf(0), str3);
                h.bu(this.fhm, this.fhm.getString(R.l.dGR));
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String hC = u.hC("emoje_stroe");
        u.GQ().t(hC, true).o("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", hC);
        d.a(context, "sns", ".ui.SnsUploadUI", intent, false);
    }

    public static void cv(Context context) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        d.a(context, ".ui.transmit.SelectConversationUI", intent, 2002);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        final String str7 = str;
        final int i4 = i;
        final int i5 = i2;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final int i6 = i3;
        final String str12 = str6;
        final MMActivity mMActivity2 = mMActivity;
        e.b(mMActivity.mController, str2, str4, str3, "", mMActivity.getString(R.l.dGL), new a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = str7;
                    int i2 = i4;
                    int i3 = i5;
                    String str3 = str8;
                    String str4 = str9;
                    String str5 = str10;
                    String str6 = str11;
                    int i4 = i6;
                    String str7 = str12;
                    x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.title = str3;
                    wXMediaMessage.description = str4;
                    IMediaObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
                    wXEmojiPageSharedObject.type = i2;
                    wXEmojiPageSharedObject.tid = i3;
                    wXEmojiPageSharedObject.title = str3;
                    wXEmojiPageSharedObject.desc = str4;
                    wXEmojiPageSharedObject.iconUrl = str5;
                    wXEmojiPageSharedObject.secondUrl = str6;
                    wXEmojiPageSharedObject.pageType = i4;
                    wXEmojiPageSharedObject.url = str7;
                    wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
                    o.PB();
                    Bitmap iJ = c.iJ(str5);
                    if (!(iJ == null || iJ.isRecycled())) {
                        x.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        iJ.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    b orVar = new or();
                    orVar.fHs.fzX = wXMediaMessage;
                    orVar.fHs.toUser = str2;
                    orVar.fHs.fHt = 49;
                    orVar.fHs.fHu = str2;
                    orVar.fHs.fHv = "";
                    com.tencent.mm.sdk.b.a.xmy.m(orVar);
                    if (!TextUtils.isEmpty(str)) {
                        orVar = new ot();
                        orVar.fHD.fHE = str2;
                        orVar.fHD.content = str;
                        orVar.fHD.type = s.hs(str2);
                        orVar.fHD.flags = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(orVar);
                    }
                    h.bu(mMActivity2, mMActivity2.getString(R.l.dGR));
                }
            }
        });
    }
}
