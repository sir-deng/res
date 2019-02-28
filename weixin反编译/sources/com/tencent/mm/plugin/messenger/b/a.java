package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a implements e {
    private Map<String, b> ouL = new HashMap();
    private Map<String, com.tencent.mm.plugin.messenger.a.e.a> ouM = new HashMap();
    private com.tencent.mm.ap.a.d.a<Long, CharSequence> ouN = new com.tencent.mm.ap.a.d.a(200);
    private com.tencent.mm.ap.a.d.a<Long, CharSequence> ouO = new com.tencent.mm.ap.a.d.a(500);
    public m ouP = new m() {
        public final void b(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", map.toString());
            a.d(aVar);
        }
    };

    static /* synthetic */ boolean d(com.tencent.mm.ad.d.a aVar) {
        if (aVar == null || aVar.hoa == null) {
            x.e("MicroMsg.SysMsgTemplateImp", "hy: addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            return false;
        }
        bx bxVar = aVar.hoa;
        String a = n.a(bxVar.vNO);
        String a2 = n.a(bxVar.vNM);
        au G = ((h) g.h(h.class)).aZO().G(a2, bxVar.vNT);
        boolean z = G.field_msgId > 0;
        G.ap(bxVar.vNT);
        if (!(aVar.hob && aVar.hod)) {
            G.aq(bb.n(a2, (long) bxVar.pgR));
        }
        G.setType(570425393);
        G.setContent(a);
        G.eS(0);
        G.dU(a2);
        G.ea(bxVar.vNR);
        bb.a(G, aVar);
        if (z) {
            ((h) g.h(h.class)).aZO().b(bxVar.vNT, G);
            return true;
        }
        bb.i(G);
        return true;
    }

    public final void a(String str, b bVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", str);
        this.ouL.put(str, bVar);
    }

    public final void EU(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", str);
        this.ouL.remove(str);
    }

    public final void a(String str, com.tencent.mm.plugin.messenger.a.e.a aVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", str);
        this.ouM.put(str, aVar);
    }

    public final void EV(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", str);
        this.ouM.remove(str);
    }

    public final CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<TextView> weakReference2) {
        if (bi.oN(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            return null;
        }
        Map y = bj.y(str, "sysmsg");
        if (y == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        if (!bi.oN(str2) && "sysmsgtemplate".equals(str2)) {
            return a(y, bundle, weakReference, 0, weakReference2);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", str2);
        return null;
    }

    public final CharSequence EW(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            return null;
        }
        Map y = bj.y(str, "sysmsg");
        if (y == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        if (!bi.oN(str2) && "sysmsgtemplate".equals(str2)) {
            return a(y, null, null, 1, null);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", str2);
        return null;
    }

    private CharSequence a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i, WeakReference<TextView> weakReference2) {
        String str = ".sysmsg.sysmsgtemplate.content_template";
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String str2 = str + ((i3 == 0 ? "" : Integer.valueOf(i3)));
            if (bi.oN((String) map.get(str2))) {
                break;
            }
            String str3 = (String) map.get(str2 + ".$type");
            Object obj = ("tmpl_type_profile".equals(str3) || "tmpl_type_profilewithrevoke".equals(str3) || "tmpl_type_profilewithrevokeqrcode".equals(str3) || "tmpl_type_wxappnotifywithview".equals(str3)) ? 1 : null;
            if (obj == null) {
                x.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", str3);
                arrayList.add(h(str2, map));
            }
            x.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", (String) map.get(str2 + ".template"));
            ArrayList FI = b.FI(str3);
            str2 = "MicroMsg.SysMsgTemplateImp";
            String str4 = "hy: parsed %d models";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(FI == null ? 0 : FI.size());
            x.d(str2, str4, objArr);
            if (FI == null || FI.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = FI.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.type == 0) {
                        arrayList2.add(new SpannableString(i.a(ad.getContext(), aVar.content)));
                    } else if (aVar.type == 1) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            String str5 = str + ".link_list.link";
                            if (i5 != 0) {
                                str4 = str5 + i5;
                            } else {
                                str4 = str5;
                            }
                            if (bi.oN((String) map.get(str4))) {
                                break;
                            }
                            if (aVar.content.equals((String) map.get(str4 + ".$name"))) {
                                str5 = (String) map.get(str4 + ".$type");
                                if (i == 0) {
                                    b bVar = (b) this.ouL.get(str5);
                                    if (!FH(str5) || bVar == null) {
                                        String str6 = "MicroMsg.SysMsgTemplateImp";
                                        String str7 = "alvinluo not support link type: %s or listener == null: %b";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = bi.aD(str5, "");
                                        objArr2[1] = Boolean.valueOf(bVar == null);
                                        x.i(str6, str7, objArr2);
                                        arrayList2.add(h(str4, map));
                                    } else {
                                        obj = bVar.a(map, str4, bundle, weakReference);
                                        z(obj);
                                        if (obj == null || obj.length() == 0) {
                                            obj = new SpannableString("");
                                        }
                                        arrayList2.add(obj);
                                    }
                                } else if (i == 1) {
                                    com.tencent.mm.plugin.messenger.a.e.a aVar2 = (com.tencent.mm.plugin.messenger.a.e.a) this.ouM.get(str5);
                                    if (!FH(str5) || aVar2 == null) {
                                        arrayList2.add(h(str4, map));
                                    } else {
                                        arrayList2.add(bi.oM(aVar2.g(map, str4)));
                                    }
                                } else {
                                    x.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i4 = i5 + 1;
                        }
                    } else {
                        x.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                x.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", H(arrayList2));
                arrayList.add(r3);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() != 0) {
            return H(arrayList);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
        return new SpannableString("");
    }

    private static void z(CharSequence charSequence) {
        int i = 0;
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                int length = clickableSpanArr.length;
                while (i < length) {
                    if (clickableSpanArr[i] instanceof com.tencent.mm.ui.base.a.a) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                    }
                }
            }
        }
    }

    private static CharSequence H(ArrayList<CharSequence> arrayList) {
        CharSequence spannableString = new SpannableString("");
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (!it.hasNext()) {
                return charSequence;
            }
            spannableString = (CharSequence) it.next();
            spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
        }
    }

    private static CharSequence h(String str, Map<String, String> map) {
        if ((bi.getInt((String) map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1 ? 1 : 0) != 0) {
            x.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            return new SpannableString("");
        }
        return new SpannableString(i.a(ad.getContext(), bi.oM((String) map.get(str + ".plain"))));
    }

    private static boolean FH(String str) {
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str)) {
            return true;
        }
        return false;
    }
}
