package com.tencent.mm.openim.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements com.tencent.mm.openim.a.b {
    private HashMap<String, b> idK = new HashMap();

    private class b {
        LinkedList<String> idN;
        LinkedList<String> idO;

        private b() {
            this.idN = new LinkedList();
            this.idO = new LinkedList();
        }

        /* synthetic */ b(j jVar, byte b) {
            this();
        }
    }

    private class a {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }
    }

    public j() {
        e.bS(Wg());
        c cVar = new com.tencent.mm.openim.d.c();
        cVar.field_appid = "3552365301";
        cVar.field_language = w.eM(ad.getContext());
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (cVar.xrR == -1) {
            oB("3552365301");
        }
    }

    private static String Wg() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("openim/").toString();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 453 && i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            b bVar = (b) this.idK.get(cVar.idF + cVar.ael);
            if (bVar.idN.isEmpty()) {
                this.idK.remove(cVar.idF + cVar.ael);
                return;
            }
            while (bVar.idO.size() < 10 && !bVar.idN.isEmpty()) {
                bVar.idO.add(bVar.idN.removeFirst());
            }
            g.Dp().gRu.a(new c(cVar.idF, cVar.ael, bVar.idO), 0);
        }
    }

    public final SpannableString b(Context context, String str, int i) {
        return i.c(context, str, i);
    }

    public final CharSequence a(Context context, String str, String str2, float f) {
        Bitmap ox = ox(str);
        if (ox == null) {
            return str2;
        }
        CharSequence b = i.b(context, "  " + str2, f);
        int fromDPToPix = (int) (((float) com.tencent.mm.bu.a.fromDPToPix(context, 2)) + f);
        ImageSpan imageSpan = new ImageSpan(ad.getContext(), ox);
        imageSpan.getDrawable().setBounds(0, 0, fromDPToPix, fromDPToPix);
        b.setSpan(imageSpan, 0, 1, 33);
        return b;
    }

    public final Bitmap ox(String str) {
        final a aVar = new a();
        if (bi.oN(str)) {
            return null;
        }
        com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
        aVar2.hFl = true;
        aVar2.hFn = Wg() + com.tencent.mm.a.g.s(str.getBytes());
        o.PG().a(str, null, aVar2.PQ(), new com.tencent.mm.ap.a.c.g() {
            public final void lF(String str) {
            }

            public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
                return null;
            }

            public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
                if (bVar.status == 0 && bVar.bitmap != null && !bVar.bitmap.isRecycled()) {
                    aVar.bitmap = bVar.bitmap;
                }
            }
        });
        return aVar.bitmap;
    }

    public final int oy(String str) {
        c cVar = new com.tencent.mm.openim.d.c();
        cVar.field_appid = str;
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, "appid");
        if (cVar.xrR != -1) {
            return cVar.field_appRec.vOB;
        }
        oB(str);
        return 0;
    }

    public final String h(String str, String str2, int i) {
        c cVar = new com.tencent.mm.openim.d.c();
        cVar.field_appid = str;
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, "appid");
        if (cVar.xrR == -1) {
            oB(str);
            return null;
        }
        String c = c(cVar.field_acctTypeId, str2, i, w.eM(ad.getContext()));
        if (c == null) {
            return c(cVar.field_acctTypeId, str2, i, "en");
        }
        return c;
    }

    public final String J(String str, String str2, int i) {
        String c = c(str, str2, i, w.eM(ad.getContext()));
        if (c == null) {
            return c(str, str2, i, "en");
        }
        return c;
    }

    private static String c(String str, String str2, int i, String str3) {
        c bVar = new com.tencent.mm.openim.d.b();
        bVar.field_acctTypeId = str;
        bVar.field_language = str3;
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAccTypeInfoStg().b(bVar, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (bVar.xrR == -1) {
            return null;
        }
        Iterator it;
        if (i == com.tencent.mm.openim.a.b.a.idv) {
            it = bVar.field_accTypeRec.vMp.iterator();
            while (it.hasNext()) {
                avt avt = (avt) it.next();
                if (str2.equals(avt.aAM)) {
                    return avt.fzT;
                }
            }
            return null;
        }
        it = bVar.field_accTypeRec.vMq.iterator();
        while (it.hasNext()) {
            avs avs = (avs) it.next();
            if (str2.equals(avs.aAM)) {
                return avs.url;
            }
        }
        return null;
    }

    public final String i(String str, String str2, int i) {
        String d = d(str, str2, i, w.eM(ad.getContext()));
        if (d == null) {
            return d(str, str2, i, "en");
        }
        return d;
    }

    private String d(String str, String str2, int i, String str3) {
        c cVar = new com.tencent.mm.openim.d.c();
        cVar.field_appid = str;
        cVar.field_language = str3;
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        Iterator it;
        if (cVar.xrR == -1) {
            aC(str, str3);
            return null;
        } else if (i == com.tencent.mm.openim.a.b.a.idv) {
            it = cVar.field_appRec.vMp.iterator();
            while (it.hasNext()) {
                avt avt = (avt) it.next();
                if (str2.equals(avt.aAM)) {
                    return avt.fzT;
                }
            }
            return null;
        } else {
            it = cVar.field_appRec.vMq.iterator();
            while (it.hasNext()) {
                avs avs = (avs) it.next();
                if (str2.equals(avs.aAM)) {
                    return avs.url;
                }
            }
            return null;
        }
    }

    public final String aB(String str, String str2) {
        String r = r(str, str2, w.eM(ad.getContext()));
        if (r == null) {
            return r(str, str2, "en");
        }
        return r;
    }

    private String r(String str, String str2, String str3) {
        c eVar = new com.tencent.mm.openim.d.e();
        eVar.field_appid = str;
        eVar.field_language = str3;
        eVar.field_wordingId = str2;
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getWordingInfoStg().b(eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
        if (eVar.xrR != -1) {
            return eVar.field_wording;
        }
        s(str, str3, str2);
        return null;
    }

    private void oB(String str) {
        aC(str, w.eM(ad.getContext()));
    }

    private void aC(String str, String str2) {
        s(str, str2, "");
    }

    private void s(String str, String str2, String str3) {
        if (!bi.oN(str)) {
            b bVar;
            if (!this.idK.containsKey(str + str2)) {
                bVar = new b();
                if (!bi.oN(str3)) {
                    bVar.idO.add(str3);
                }
                this.idK.put(str + str2, bVar);
                g.Dp().gRu.a(new c(str, str2, bVar.idO), 0);
            }
            if (!bi.oN(str3)) {
                bVar = (b) this.idK.get(str + str2);
                if (!bVar.idN.contains(str3) && !bVar.idO.contains(str3)) {
                    bVar.idN.add(str3);
                }
            }
        }
    }

    public final void aA(String str, String str2) {
        Object obj;
        Object obj2 = null;
        c cVar = new com.tencent.mm.openim.d.c();
        cVar.field_appid = str;
        cVar.field_language = w.eM(ad.getContext());
        g.Dr();
        ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (cVar.xrR == -1 || bi.bz(cVar.field_updateTime) > 172800) {
            obj2 = 1;
        }
        if (obj2 == null && !bi.oN(str2)) {
            c eVar = new com.tencent.mm.openim.d.e();
            eVar.field_appid = str;
            eVar.field_language = w.eM(ad.getContext());
            eVar.field_wordingId = str2;
            g.Dr();
            ((PluginOpenIM) g.k(PluginOpenIM.class)).getWordingInfoStg().b(eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
            if (eVar.xrR == -1 || bi.bz(cVar.field_updateTime) > 172800) {
                obj = 1;
                if (obj != null) {
                    s(str, w.eM(ad.getContext()), str2);
                }
            }
        }
        obj = obj2;
        if (obj != null) {
            s(str, w.eM(ad.getContext()), str2);
        }
    }
}
