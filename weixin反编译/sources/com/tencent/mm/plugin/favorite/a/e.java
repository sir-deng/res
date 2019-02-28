package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ly;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.f.a.ri;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e {

    /* renamed from: com.tencent.mm.plugin.favorite.a.e$2 */
    static class AnonymousClass2 implements com.tencent.mm.plugin.favorite.a.s.a {
        final /* synthetic */ Runnable fgt;
        final /* synthetic */ f mvo;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(f fVar, Context context, Runnable runnable) {
            this.mvo = fVar;
            this.val$context = context;
            this.fgt = runnable;
        }

        public final void a(SparseArray<String> sparseArray) {
            String str = (String) sparseArray.get(this.mvo.field_id);
            x.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", Integer.valueOf(this.mvo.field_id), str);
            if (!bi.oN(str)) {
                if (4 == this.mvo.field_type) {
                    uz p = j.p(this.mvo);
                    String aD = bi.aD(p.title, this.val$context.getString(R.l.ehf));
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", str);
                    intent.putExtra("Ksnsupload_title", aD);
                    intent.putExtra("Ksnsupload_imgbuf", com.tencent.mm.a.e.e(j.i(p), 0, -1));
                    d.ihN.m(intent, this.val$context);
                    str = "fav_" + q.FY() + "_" + this.mvo.field_id;
                    String hC = u.hC(str);
                    u.GQ().t(hC, true).o("prePublishId", str);
                    intent.putExtra("reportSessionId", hC);
                    g.pWK.h(10651, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0));
                } else {
                    x.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", Integer.valueOf(this.mvo.field_type), Integer.valueOf(this.mvo.field_id));
                }
            }
            if (this.fgt != null) {
                ah.y(this.fgt);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.favorite.a.e$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ Runnable fgt;
        final /* synthetic */ String fhe;
        final /* synthetic */ String hCE;
        final /* synthetic */ int jtz;
        final /* synthetic */ String mvq;
        final /* synthetic */ String mvr;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
            this.val$context = context;
            this.fhe = str;
            this.mvq = str2;
            this.hCE = str3;
            this.jtz = i;
            this.mvr = str4;
            this.fgt = runnable;
        }

        public final void run() {
            Context context = this.val$context;
            String str = this.fhe;
            String str2 = this.mvq;
            String str3 = this.hCE;
            int i = this.jtz;
            String str4 = this.mvr;
            File file = new File(str2);
            if (file.exists()) {
                File file2 = new File(str3);
                x.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", file.getAbsolutePath(), file2.getAbsolutePath());
                com.tencent.mm.plugin.messenger.a.f.aZN().a(context, str, file.getAbsolutePath(), str3, 1, i, str4);
            }
            ah.y(this.fgt);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    /* renamed from: com.tencent.mm.plugin.favorite.a.e$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Runnable fgt;
        final /* synthetic */ String fhe;
        final /* synthetic */ uz mvp;
        final /* synthetic */ Context val$context;

        public AnonymousClass3(uz uzVar, Context context, String str, Runnable runnable) {
            this.mvp = uzVar;
            this.val$context = context;
            this.fhe = str;
            this.fgt = runnable;
        }

        public final void run() {
            if (this.mvp.bjS == 15) {
                e.a(this.val$context, this.fhe, this.mvp);
            } else {
                e.b(this.val$context, this.fhe, this.mvp);
            }
            ah.y(this.fgt);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    public static class a {
        public String desc;
        public String fwx;
        public String mvs;
        public String title;

        private static boolean AB(String str) {
            return new File(str).exists();
        }

        public static a a(Context context, f fVar) {
            int i;
            String str;
            String i2;
            int di;
            StringBuilder append;
            Iterator it;
            if (fVar.field_type == 18) {
                a aVar = new a();
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (fVar.field_type == 18) {
                    aVar.title = fVar.field_favProto.title;
                }
                List linkedList = new LinkedList();
                i = 0;
                int i3 = 0;
                for (uz uzVar : fVar.field_favProto.wlY) {
                    if (fVar.field_type != 18 || bi.oN(uzVar.wkc) || !uzVar.wkc.equals(".htm")) {
                        sparseIntArray.put(uzVar.bjS, sparseIntArray.get(uzVar.bjS) + 1);
                        switch (uzVar.bjS) {
                            case 1:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                str = uzVar.desc;
                                if (!bi.oN(str)) {
                                    linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + "\n");
                                    break;
                                }
                                break;
                            case 2:
                                linkedList.size();
                                if (i != 0) {
                                    break;
                                }
                                i2 = j.i(uzVar);
                                if (!AB(i2)) {
                                    aVar.fwx = j.h(uzVar);
                                    i = 1;
                                    break;
                                }
                                aVar.fwx = i2;
                                i = 1;
                                break;
                            case 3:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                di = (int) j.di((long) uzVar.duration);
                                linkedList.add(context.getString(R.l.dHj) + context.getString(R.l.ejB, new Object[]{Integer.valueOf(di)}) + "\n");
                                break;
                            case 4:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.l.dHi) + "\n");
                                break;
                            case 6:
                                if (linkedList.size() < 4) {
                                    vg vgVar = uzVar.wkH.wld;
                                    append = new StringBuilder().append(context.getString(R.l.dFK));
                                    str = (bi.oN(vgVar.fEp) || vgVar.fEp.equals(context.getString(R.l.etu))) ? vgVar.label : vgVar.fEp;
                                    linkedList.add(append.append(str).append("\n").toString());
                                }
                                if (i3 != 0) {
                                    break;
                                }
                                i3 = 1;
                                break;
                                break;
                            case 8:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.l.dFu) + uzVar.title + "\n");
                                }
                                if (i3 != 0) {
                                    break;
                                }
                                i3 = 1;
                                break;
                            case 17:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.l.dGD) + "\n");
                                break;
                            default:
                                break;
                        }
                    }
                }
                str = "";
                aVar.desc = "";
                it = linkedList.iterator();
                while (true) {
                    i2 = str;
                    if (it.hasNext()) {
                        str = i2 + ((String) it.next());
                    } else {
                        str = i2.trim();
                        if (linkedList.size() >= 4) {
                            str = str + "...";
                        }
                        aVar.desc = str;
                        aVar.title = ad.getContext().getString(R.l.ehj);
                        return aVar;
                    }
                }
            }
            a aVar2 = new a();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            if (fVar.field_type == 14) {
                aVar2.title = fVar.field_favProto.title;
            }
            List linkedList2 = new LinkedList();
            i = 0;
            for (uz uzVar2 : fVar.field_favProto.wlY) {
                sparseIntArray2.put(uzVar2.bjS, sparseIntArray2.get(uzVar2.bjS) + 1);
                switch (uzVar2.bjS) {
                    case 1:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(uzVar2.wkJ + ":" + uzVar2.desc + "\n");
                        break;
                    case 2:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dGu) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str = j.i(uzVar2);
                        if (AB(str)) {
                            aVar2.fwx = str;
                            di = 1;
                        } else {
                            di = i;
                        }
                        i = di;
                        break;
                    case 3:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        int bw = (int) j.bw((long) uzVar2.duration);
                        linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dHj) + context.getString(R.l.ejB, new Object[]{Integer.valueOf(bw)}) + "\n");
                        break;
                    case 4:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dHi) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str = j.i(uzVar2);
                        if (AB(str)) {
                            aVar2.fwx = str;
                            di = 1;
                        } else {
                            di = i;
                        }
                        i = di;
                        break;
                    case 5:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dHf) + uzVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        i2 = j.i(uzVar2);
                        if (AB(i2)) {
                            aVar2.fwx = i2;
                        } else {
                            wc wcVar = uzVar2.wkH.wlf;
                            i2 = wcVar == null ? "" : wcVar.thumbUrl;
                            if (bi.oN(i2)) {
                                i2 = bi.aD(uzVar2.fra, "");
                            }
                            a(aVar2, i2);
                        }
                        i = 1;
                        break;
                    case 6:
                        if (linkedList2.size() < 4) {
                            vg vgVar2 = uzVar2.wkH.wld;
                            append = new StringBuilder().append(uzVar2.wkJ).append(":").append(context.getString(R.l.dFK));
                            str = (bi.oN(vgVar2.fEp) || vgVar2.fEp.equals(context.getString(R.l.etu))) ? vgVar2.label : vgVar2.fEp;
                            linkedList2.add(append.append(str).append("\n").toString());
                        }
                        if (i != 0) {
                            break;
                        }
                        i = 1;
                        break;
                        break;
                    case 7:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dFU) + uzVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        a(aVar2, uzVar2.fra);
                        i = 1;
                        break;
                    case 8:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dFu) + uzVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        i = 1;
                        break;
                    case 10:
                    case 11:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dGw) + uzVar2.wkH.wlh.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        vm vmVar = uzVar2.wkH.wlh;
                        if (vmVar != null) {
                            a(aVar2, vmVar.thumbUrl);
                        }
                        i = 1;
                        break;
                    case 14:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dDY) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        vw vwVar = uzVar2.wkH.wlj;
                        if (vwVar != null) {
                            a(aVar2, vwVar.thumbUrl);
                        }
                        i = 1;
                        break;
                    case 15:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dGS) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str = j.i(uzVar2);
                        if (AB(str)) {
                            aVar2.fwx = str;
                            di = 1;
                        } else {
                            di = i;
                        }
                        i = di;
                        break;
                    case 16:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dFy) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        as.Hm();
                        aVar2.mvs = c.Fh().Fq(uzVar2.desc).sfb;
                        i = 1;
                        break;
                    case 17:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(uzVar2.wkJ + ":" + context.getString(R.l.dGD) + "\n");
                        break;
                    default:
                        break;
                }
            }
            str = "";
            aVar2.desc = "";
            it = linkedList2.iterator();
            while (true) {
                i2 = str;
                if (it.hasNext()) {
                    str = i2 + ((String) it.next());
                } else {
                    str = i2.trim();
                    if (linkedList2.size() >= 4) {
                        str = str + "...";
                    }
                    aVar2.desc = str;
                    return aVar2;
                }
            }
        }

        private static void a(a aVar, String str) {
            String str2 = j.aJl() + com.tencent.mm.a.g.s(bi.aD(str, "").getBytes());
            if (AB(str2)) {
                aVar.fwx = str2;
            }
        }
    }

    static /* synthetic */ void a(Context context, String str, uz uzVar) {
        File file = new File(j.h(uzVar));
        if (file.exists()) {
            String d = d(uzVar);
            x.d("MicroMsg.FavSendLogic", "send fav short Video::data path[%s] thumb path[%s]", file.getAbsolutePath(), d);
            bnp bnp = null;
            vc vcVar = uzVar.wkN;
            if (vcVar != null) {
                bnp = new bnp();
                bnp.hfe = vcVar.hfe;
                bnp.hfb = vcVar.hfb;
                bnp.wlG = vcVar.wlG;
                bnp.heZ = vcVar.heZ;
                bnp.hfc = vcVar.hfc;
                bnp.hff = vcVar.hff;
                bnp.hfg = vcVar.hfg;
                bnp.hfd = vcVar.hfd;
            }
            if (bnp != null) {
                com.tencent.mm.plugin.messenger.a.f.aZN().a(context, str, file.getAbsolutePath(), d, 62, uzVar.duration, bnp, false, false, uzVar.fHB);
                return;
            }
            com.tencent.mm.plugin.messenger.a.f.aZN().a(context, str, file.getAbsolutePath(), d, 62, uzVar.duration, uzVar.fHB);
            return;
        }
        x.w("MicroMsg.FavSendLogic", "sendShortVideo, error! data not existed");
    }

    static /* synthetic */ void a(String str, f fVar, uz uzVar) {
        String h = j.h(uzVar);
        IMediaObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(h);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = uzVar.title;
        if (bi.oN(wXMediaMessage.title)) {
            wXMediaMessage.title = fVar.field_favProto.title;
        }
        wXMediaMessage.description = uzVar.desc;
        wXMediaMessage.thumbData = bi.readFromFile(j.i(uzVar));
        l.a(wXMediaMessage, "", "", str, 3, null);
    }

    static /* synthetic */ void b(Context context, String str, uz uzVar) {
        File file = new File(j.h(uzVar));
        if (file.exists()) {
            File file2 = new File(j.i(uzVar));
            String absolutePath = file2.exists() ? file2.getAbsolutePath() : j.aJl() + com.tencent.mm.a.g.s(bi.aD(uzVar.fra, "").getBytes());
            x.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", file.getAbsolutePath(), absolutePath);
            bnp bnp = null;
            vc vcVar = uzVar.wkN;
            if (vcVar != null) {
                bnp = new bnp();
                bnp.hfe = vcVar.hfe;
                bnp.hfb = vcVar.hfb;
                bnp.wlG = vcVar.wlG;
                bnp.heZ = vcVar.heZ;
                bnp.hfc = vcVar.hfc;
                bnp.hff = vcVar.hff;
                bnp.hfg = vcVar.hfg;
            }
            if (bnp != null) {
                com.tencent.mm.plugin.messenger.a.f.aZN().a(context, str, file.getAbsolutePath(), absolutePath, 1, uzVar.duration, bnp, false, false, uzVar.fHB);
                return;
            } else {
                com.tencent.mm.plugin.messenger.a.f.aZN().a(context, str, file.getAbsolutePath(), absolutePath, 1, uzVar.duration, uzVar.fHB);
                return;
            }
        }
        String str2 = uzVar.wjU;
        if (!bi.oN(str2)) {
            IMediaObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            String aD = bi.aD(uzVar.title, context.getResources().getString(R.l.ehf));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = aD;
            wXMediaMessage.description = uzVar.desc;
            wXMediaMessage.thumbData = bi.readFromFile(j.i(uzVar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(bi.aD(uzVar.fra, "").getBytes()));
            }
            com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
            aVar.hcP = 3;
            vc vcVar2 = uzVar.wkN;
            if (vcVar2 != null) {
                aVar.hfe = vcVar2.hfe;
                aVar.hfb = vcVar2.hfb;
                aVar.hfa = vcVar2.wlG;
                aVar.heZ = vcVar2.heZ;
                aVar.hfc = vcVar2.hfc;
                aVar.hff = vcVar2.hff;
                aVar.hfg = vcVar2.hfg;
            }
            l.a(aVar, wXMediaMessage, str);
        }
    }

    public static void a(Context context, String str, String str2, f fVar, Runnable runnable) {
        List linkedList = new LinkedList();
        linkedList.add(fVar);
        a(context, str, str2, linkedList, runnable);
    }

    public static void a(Context context, String str, String str2, List<f> list, Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            ah.y(runnable);
        } else if (bi.oN(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            ah.y(runnable);
        } else if (list.isEmpty()) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            ah.y(runnable);
        } else {
            final String str3 = str;
            final List<f> list2 = list;
            final Context context2 = context;
            final String str4 = str2;
            final Runnable runnable2 = runnable;
            as.Dt().F(new Runnable() {
                public final void run() {
                    for (String str : bi.F(str3.split(","))) {
                        for (f fVar : list2) {
                            if (fVar != null) {
                                g.pWK.h(10925, Integer.valueOf(fVar.field_type), Integer.valueOf(fVar.field_id));
                                String str2;
                                byte[] readFromFile;
                                String hC;
                                Context context;
                                vm vmVar;
                                b lyVar;
                                byte[] readFromFile2;
                                switch (fVar.field_type) {
                                    case 1:
                                        com.tencent.mm.plugin.messenger.a.f.aZN().C(str, fVar.field_favProto.desc, s.hs(str));
                                        break;
                                    case 2:
                                        Iterator it = fVar.field_favProto.wlY.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.plugin.messenger.a.f.aZN().a(context2, str, j.h((uz) it.next()), 0, "", "");
                                        }
                                        break;
                                    case 4:
                                        e.b(context2, str, j.p(fVar));
                                        break;
                                    case 5:
                                        if (fVar != null) {
                                            uz p = j.p(fVar);
                                            wc wcVar = fVar.field_favProto.wlf;
                                            vt vtVar = fVar.field_favProto.wlW;
                                            com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
                                            if (wcVar != null) {
                                                aVar.title = wcVar.title;
                                                str2 = wcVar.thumbUrl;
                                                if (bi.oN(str2)) {
                                                    str2 = bi.aD(p.fra, "");
                                                }
                                                aVar.thumburl = str2;
                                            }
                                            if (bi.oN(aVar.title) && p != null) {
                                                aVar.title = p.title;
                                            }
                                            if (wcVar != null) {
                                                aVar.description = wcVar.desc;
                                            }
                                            if (bi.oN(aVar.description) && p != null) {
                                                aVar.description = p.desc;
                                            }
                                            if (fVar.field_favProto.wlf != null) {
                                                aVar.url = fVar.field_favProto.wlf.wmD;
                                            }
                                            if (vtVar != null && bi.oN(aVar.url)) {
                                                aVar.url = vtVar.hPT;
                                            }
                                            if (!(p == null || bi.oN(p.canvasPageXml))) {
                                                aVar.canvasPageXml = p.canvasPageXml;
                                            }
                                            aVar.action = "view";
                                            aVar.type = 5;
                                            aVar.fHB = p.fHB;
                                            readFromFile = bi.readFromFile(j.i(p));
                                            if (readFromFile == null) {
                                                str2 = wcVar == null ? null : wcVar.thumbUrl;
                                                if (bi.oN(str2)) {
                                                    str2 = bi.aD(p.fra, "");
                                                }
                                                readFromFile = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(str2.getBytes()));
                                            }
                                            String str3 = "fav_" + q.FY() + "_" + fVar.field_id;
                                            hC = u.hC(str3);
                                            u.b t = u.GQ().t(hC, true);
                                            t.o("prePublishId", str3);
                                            t.o("preUsername", fVar.field_fromUser);
                                            t.o("sendAppMsgScene", Integer.valueOf(1));
                                            t.o("adExtStr", p.fHB);
                                            com.tencent.mm.plugin.messenger.a.f.aZN().a(str, readFromFile, com.tencent.mm.x.g.a.a(aVar, null, null), hC);
                                            break;
                                        }
                                        x.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                        break;
                                    case 6:
                                        vg vgVar = fVar.field_favProto.wld;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("<msg>");
                                        stringBuilder.append("<location ");
                                        stringBuilder.append("x=\"").append(vgVar.lat).append("\" ");
                                        stringBuilder.append("y=\"").append(vgVar.lng).append("\" ");
                                        stringBuilder.append("scale=\"").append(vgVar.fAq).append("\" ");
                                        stringBuilder.append("label=\"").append(bi.aD(vgVar.label, "")).append("\" ");
                                        stringBuilder.append("maptype=\"0\" ");
                                        stringBuilder.append("poiname=\"").append(bi.aD(vgVar.fEp, "")).append("\" ");
                                        stringBuilder.append("/>");
                                        stringBuilder.append("</msg>");
                                        com.tencent.mm.plugin.messenger.a.f.aZN().C(str, stringBuilder.toString(), 48);
                                        break;
                                    case 7:
                                        Context context2 = context2;
                                        uz p2 = j.p(fVar);
                                        IMediaObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = p2.wjU;
                                        wXMusicObject.musicDataUrl = p2.wjW;
                                        wXMusicObject.musicLowBandUrl = p2.wjY;
                                        wXMusicObject.musicLowBandDataUrl = p2.wjY;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = p2.title;
                                        wXMediaMessage.description = p2.desc;
                                        readFromFile = bi.readFromFile(j.i(p2));
                                        if (readFromFile == null) {
                                            readFromFile = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(bi.aD(p2.fra, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile;
                                        hC = fVar.field_favProto.wlW.appId;
                                        l.a(wXMediaMessage, hC, com.tencent.mm.y.ab.a.hht.l(context2, hC), str, 3, null);
                                        break;
                                    case 8:
                                        e.a(str, fVar, j.p(fVar));
                                        break;
                                    case 10:
                                        context = context2;
                                        vmVar = fVar.field_favProto.wlh;
                                        lyVar = new ly();
                                        lyVar.fEi.opType = 0;
                                        lyVar.fEi.fEk = vmVar.info;
                                        lyVar.fEi.context = context;
                                        com.tencent.mm.sdk.b.a.xmy.m(lyVar);
                                        if (!lyVar.fEj.fqR) {
                                            break;
                                        }
                                        readFromFile2 = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(bi.aD(vmVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bi.readFromFile(lyVar.fEj.fwx);
                                        }
                                        com.tencent.mm.plugin.messenger.a.f.aZN().a(str, readFromFile2, lyVar.fEj.fEl, null);
                                        break;
                                    case 11:
                                        context = context2;
                                        vmVar = fVar.field_favProto.wlh;
                                        lyVar = new ly();
                                        lyVar.fEi.opType = 1;
                                        lyVar.fEi.fEk = vmVar.info;
                                        lyVar.fEi.context = context;
                                        com.tencent.mm.sdk.b.a.xmy.m(lyVar);
                                        if (!lyVar.fEj.fqR) {
                                            break;
                                        }
                                        readFromFile2 = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(bi.aD(vmVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bi.readFromFile(lyVar.fEj.fwx);
                                        }
                                        com.tencent.mm.plugin.messenger.a.f.aZN().a(str, readFromFile2, lyVar.fEj.fEl, null);
                                        break;
                                    case 14:
                                    case 18:
                                        x.i("MicroMsg.FavSendLogic", "want send record, fav id %d", Integer.valueOf(fVar.field_id));
                                        if (fVar.field_id <= 0 && !com.tencent.mm.pluginsdk.model.c.vjO) {
                                            break;
                                        }
                                        a a = a.a(context2, fVar);
                                        vn vnVar = new vn();
                                        try {
                                            x.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            vnVar.aH(fVar.field_favProto.toByteArray());
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                            x.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", e.getMessage());
                                        }
                                        b mvVar = new mv();
                                        mvVar.fFz.type = 2;
                                        mvVar.fFz.toUser = str;
                                        mvVar.fFz.fFC = vnVar;
                                        mvVar.fFz.title = a.title;
                                        mvVar.fFz.desc = a.desc;
                                        mvVar.fFz.fwx = a.fwx;
                                        mvVar.fFz.fFH = a.mvs;
                                        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                                        break;
                                        break;
                                    case 15:
                                        context = context2;
                                        vw vwVar = fVar.field_favProto.wlj;
                                        lyVar = new ri();
                                        lyVar.fJS.opType = 0;
                                        lyVar.fJS.fJU = vwVar.info;
                                        lyVar.fJS.context = context;
                                        com.tencent.mm.sdk.b.a.xmy.m(lyVar);
                                        x.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", Boolean.valueOf(lyVar.fJT.fqR), vwVar.thumbUrl);
                                        if (!lyVar.fJT.fqR) {
                                            break;
                                        }
                                        readFromFile2 = bi.readFromFile(j.aJl() + com.tencent.mm.a.g.s(bi.aD(vwVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bi.readFromFile(lyVar.fJT.fwx);
                                        }
                                        com.tencent.mm.plugin.messenger.a.f.aZN().a(str, readFromFile2, lyVar.fJT.fEl, null);
                                        break;
                                    case 16:
                                        e.a(context2, str, j.p(fVar));
                                        break;
                                    case 17:
                                        str2 = j.p(fVar).desc;
                                        com.tencent.mm.plugin.messenger.a.f.aZN().C(str, str2, com.tencent.mm.storage.x.Xg(com.tencent.mm.storage.au.a.XY(str2).sfb) ? 66 : 42);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            x.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", Integer.valueOf(list2.size()));
                        }
                        if (!bi.oN(str4)) {
                            com.tencent.mm.plugin.messenger.a.f.aZN().C(str, str4, s.hs(str));
                        }
                    }
                    ah.y(runnable2);
                }

                public final String toString() {
                    return super.toString() + "|sendFavMsg";
                }
            });
        }
    }

    public static void a(Context context, final String str, final f fVar, final uz uzVar, final Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
        } else if (bi.oN(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
        } else {
            if (fVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (uzVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
            } else {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        e.a(str, fVar, uzVar);
                        ah.y(runnable);
                    }

                    public final String toString() {
                        return super.toString() + "|sendFavFile";
                    }
                });
            }
        }
    }

    public static String d(uz uzVar) {
        File file = new File(j.i(uzVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return j.aJl() + com.tencent.mm.a.g.s(bi.aD(uzVar.fra, "").getBytes());
    }
}
