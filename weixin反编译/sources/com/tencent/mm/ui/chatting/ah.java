package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;
import java.util.List;

public final class ah {

    /* renamed from: com.tencent.mm.ui.chatting.ah$4 */
    static class AnonymousClass4 implements d {
        final /* synthetic */ au hgB;
        final /* synthetic */ Context val$context;

        public AnonymousClass4(au auVar, Context context) {
            this.hgB = auVar;
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            String str = menuItem.getTitle();
            if (bi.oN(this.hgB.field_imgPath)) {
                x.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                return;
            }
            p og = q.og(this.hgB.field_imgPath);
            x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", str, q.e(str, this.hgB.field_imgPath, og == null ? 0 : og.hZq));
            as.CN().a(new f(r0, 1), 0);
            g.pWK.h(10424, Integer.valueOf(34), Integer.valueOf(2), str);
            h.bu(this.val$context, this.val$context.getString(R.l.dGJ));
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ah$8 */
    static class AnonymousClass8 implements d {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String yGr;

        public AnonymousClass8(String str, Context context) {
            this.yGr = str;
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int i2 = 66;
            String str = menuItem.getTitle();
            x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", str, this.yGr);
            a XY = a.XY(this.yGr);
            as.CN().a(new j(str, this.yGr, com.tencent.mm.storage.x.Xg(XY.sfb) ? 66 : 42), 0);
            g gVar = g.pWK;
            Object[] objArr = new Object[3];
            if (!com.tencent.mm.storage.x.Xg(XY.sfb)) {
                i2 = 42;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(32);
            objArr[2] = str;
            gVar.h(10424, objArr);
            h.bu(this.val$context, this.val$context.getString(R.l.dGJ));
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ah$7 */
    static class AnonymousClass7 implements d {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String yGq;

        public AnonymousClass7(String str, Context context) {
            this.yGq = str;
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), this.yGq);
            as.CN().a(new j(r0, this.yGq, 48), 0);
            g.pWK.h(10424, Integer.valueOf(48), Integer.valueOf(16), r0);
            h.bu(this.val$context, this.val$context.getString(R.l.dGJ));
        }
    }

    static /* synthetic */ void a(String str, au auVar, String str2) {
        int i = 1;
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(str2));
        if (fV == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            return;
        }
        byte[] d;
        b bVar;
        long j;
        String str3;
        com.tencent.mm.x.g.a a;
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            String B = o.PC().B(auVar.field_imgPath, i);
            try {
                d = e.d(B, 0, e.bN(B));
            } catch (Exception e) {
                x.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
            }
            bVar = new b();
            if (!bi.oN(fV.for)) {
                j = bi.getLong(fV.for, -1);
                if (j == -1) {
                    an.aqK().b(j, (c) bVar);
                    if (bVar.xrR != j) {
                        bVar = an.aqK().Se(fV.for);
                        if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
                            bVar = null;
                        }
                    }
                } else {
                    bVar = an.aqK().Se(fV.for);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
                        bVar = null;
                    }
                }
            }
            str3 = "";
            if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
                as.Hm();
                str3 = l.ad(com.tencent.mm.y.c.FB(), fV.title, fV.hcN);
                k.r(bVar.field_fileFullPath, str3, false);
            }
            a = com.tencent.mm.x.g.a.a(fV);
            a.hcP = 3;
            l.a(a, fV.appId, fV.appName, str, str3, d, null);
        }
        d = null;
        bVar = new b();
        if (bi.oN(fV.for)) {
            j = bi.getLong(fV.for, -1);
            if (j == -1) {
                bVar = an.aqK().Se(fV.for);
                bVar = null;
            } else {
                an.aqK().b(j, (c) bVar);
                if (bVar.xrR != j) {
                    bVar = an.aqK().Se(fV.for);
                    bVar = null;
                }
            }
        }
        str3 = "";
        as.Hm();
        str3 = l.ad(com.tencent.mm.y.c.FB(), fV.title, fV.hcN);
        k.r(bVar.field_fileFullPath, str3, false);
        a = com.tencent.mm.x.g.a.a(fV);
        a.hcP = 3;
        l.a(a, fV.appId, fV.appName, str, str3, d, null);
    }

    public static void k(final String str, final Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
        } else if (bi.oN(str)) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
        } else {
            a(dn(y.Ml().ht(1)), context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    String str = menuItem.getTitle();
                    x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", str, str);
                    as.CN().a(new j(str, str, s.hs(str)), 0);
                    g.pWK.h(10424, Integer.valueOf(1), Integer.valueOf(1), str);
                    h.bu(context, context.getString(R.l.dGJ));
                }
            });
        }
    }

    public static void a(final au auVar, final Context context, final String str, final boolean z) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
        } else {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                a(dn(y.Ml().ht(4)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        com.tencent.mm.ap.e bj;
                        com.tencent.mm.ap.e bi;
                        int i2 = true;
                        String str = menuItem.getTitle();
                        if (auVar.field_msgId > 0) {
                            bj = o.PC().bj(auVar.field_msgId);
                        } else {
                            bj = null;
                        }
                        if ((bj == null || bj.hBA <= 0) && auVar.field_msgSvrId > 0) {
                            bi = o.PC().bi(auVar.field_msgSvrId);
                        } else {
                            bi = bj;
                        }
                        if (bi == null) {
                            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                        } else if (bi.offset < bi.hmZ || bi.hmZ == 0) {
                            String str2;
                            Bundle bundle;
                            Intent intent = new Intent(context, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", auVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                            intent.putExtra("img_gallery_is_restransmit_after_download", true);
                            intent.putExtra("img_gallery_directly_send_name", str);
                            intent.putExtra("start_chatting_ui", false);
                            str = auVar.field_talker;
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (s.gI(str)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str2, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                            bundle2.putString("stat_chat_talker_username", str);
                            bundle2.putString("stat_send_msg_user", str);
                            intent.putExtra("_stat_obj", bundle2);
                            context.startActivity(intent);
                        } else {
                            int i3;
                            if (auVar.field_isSend == 1) {
                                boolean z;
                                if (bi.Pk()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                i3 = z;
                            } else if (!bi.Pk()) {
                                i3 = 0;
                            } else if (e.bO(com.tencent.mm.ap.f.a(bi).hBB)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            String FY = com.tencent.mm.y.q.FY();
                            String m = o.PC().m(com.tencent.mm.ap.f.c(bi), "", "");
                            if (!bi.oN(m)) {
                                x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", str, m);
                                as.CN().a(new com.tencent.mm.ap.l(4, FY, str, m, i3, null, 0, "", "", true, R.g.bAI), 0);
                                bp.HY().c(bp.hjo, null);
                            }
                            g.pWK.h(10424, Integer.valueOf(3), Integer.valueOf(4), str);
                            h.bu(context, context.getString(R.l.dGJ));
                        }
                    }
                });
                return;
            }
            u.fJ(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
        }
    }

    public static void a(final au auVar, final Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
        } else {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                a(dn(y.Ml().ht(8)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        String str = menuItem.getTitle();
                        r nJ = t.nJ(auVar.field_imgPath);
                        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", str, auVar.field_imgPath);
                        final MsgRetransmitUI.a aVar = new MsgRetransmitUI.a();
                        Context context = context;
                        context.getResources().getString(R.l.dGZ);
                        Dialog a = h.a(context, context.getResources().getString(R.l.dGM), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                aVar.zxS = true;
                            }
                        });
                        aVar.context = context;
                        aVar.fileName = auVar.field_imgPath;
                        aVar.ion = a;
                        aVar.userName = str;
                        aVar.zxp = nJ.hXz;
                        aVar.hXv = nJ.hXv;
                        aVar.execute(new Object[0]);
                        bp.HY().c(bp.hjp, null);
                        h.bu(context, context.getString(R.l.dGJ));
                    }
                });
                return;
            }
            u.fJ(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
        }
    }

    public static void b(final au auVar, final Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
        } else {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                a(dn(y.Ml().ht(64)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        String str;
                        String str2 = menuItem.getTitle();
                        String str3 = aj.XW(auVar.field_content).frM;
                        if (str3 == null || str3.endsWith("-1")) {
                            str = auVar.field_imgPath;
                        } else {
                            str = str3;
                        }
                        if (str == null) {
                            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                            return;
                        }
                        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", str2, str);
                        if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().n(context, str2, str)) {
                            g.pWK.h(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                            h.bu(context, "");
                        }
                        g.pWK.h(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                        h.bu(context, context.getString(R.l.dGJ));
                    }
                });
                return;
            }
            u.fJ(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
        }
    }

    public static void a(au auVar, String str, Context context) {
        a(auVar, str, context, (int) WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public static void b(au auVar, String str, Context context) {
        a(auVar, str, context, 256);
    }

    public static void c(au auVar, String str, Context context) {
        a(auVar, str, context, (int) FileUtils.S_IWUSR);
    }

    private static void a(final au auVar, final String str, final Context context, final int i) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
        } else {
            List list = null;
            switch (i) {
                case FileUtils.S_IWUSR /*128*/:
                    list = dn(com.tencent.mm.af.f.LZ());
                    break;
                case 256:
                    list = dn(y.Ml().ht(256));
                    break;
                case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                    list = dn(y.Ml().ht(WXMediaMessage.TITLE_LENGTH_LIMIT));
                    break;
            }
            a(list, context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    ah.a(menuItem.getTitle(), auVar, str);
                    switch (i) {
                        case FileUtils.S_IWUSR /*128*/:
                            g.pWK.h(10424, Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), r0);
                            break;
                        case 256:
                            g.pWK.h(10424, Integer.valueOf(49), Integer.valueOf(256), r0);
                            break;
                        case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                            g.pWK.h(10424, Integer.valueOf(49), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT), r0);
                            break;
                    }
                    h.bu(context, context.getString(R.l.dGJ));
                }
            });
        }
    }

    public static List<String> dn(List<String> list) {
        List<String> linkedList = new LinkedList();
        for (String str : list) {
            if (!com.tencent.mm.af.f.jY(str)) {
                linkedList.add(str);
            }
        }
        x.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    public static void a(final List<String> list, final Context context, d dVar) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            return;
        }
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
        lVar.zux = new com.tencent.mm.ui.base.p.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, menuItem.getTitle());
            }
        };
        lVar.zuy = new com.tencent.mm.ui.base.p.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                if (textView != null) {
                    as.Hm();
                    com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(menuItem.getTitle());
                    if (Xv == null || ((int) Xv.gKO) <= 0) {
                        textView.setText(menuItem.getTitle());
                    } else {
                        textView.setText(i.b(context, Xv.AW(), textView.getTextSize()));
                    }
                }
            }
        };
        lVar.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(n nVar) {
                for (CharSequence add : list) {
                    nVar.add(add);
                }
            }
        };
        lVar.rQG = dVar;
        lVar.bCH();
    }
}
