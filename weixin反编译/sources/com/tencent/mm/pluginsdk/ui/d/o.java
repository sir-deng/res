package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class o {
    private static final f<String, SpannableString> vBV = new f(500);
    String iNG;
    private TextView kO;
    private Context mContext;
    private ArrayList<k> vBW;
    private ArrayList<a> vBX;
    private ArrayList<p> vBY;
    boolean vBZ;
    boolean vCa;
    boolean vCb;
    boolean vCc;
    boolean vCd;
    boolean vCe;
    boolean vCf;
    boolean vCg;
    boolean vCh;
    boolean vCi;
    boolean vCj;
    int vCk;
    private int vCl;
    boolean vCm;
    Object vCn;

    class a {
        int end;
        int start;

        a(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    public o(Context context) {
        this.vBW = new ArrayList();
        this.vBX = new ArrayList();
        this.vBY = new ArrayList();
        this.kO = null;
        this.vBZ = false;
        this.vCa = false;
        this.vCb = false;
        this.vCc = true;
        this.vCd = true;
        this.vCe = false;
        this.vCf = false;
        this.vCg = false;
        this.vCh = false;
        this.vCi = false;
        this.vCj = true;
        this.vCk = 0;
        this.vCl = 0;
        this.mContext = null;
        this.vCm = false;
        this.vBW = new ArrayList();
        this.vBX = new ArrayList();
        this.vBY = new ArrayList();
        this.mContext = context;
    }

    public final o j(TextView textView) {
        this.kO = textView;
        if (textView != null) {
            this.mContext = this.kO.getContext();
        }
        return this;
    }

    public final SpannableString a(CharSequence charSequence, int i, boolean z) {
        if (charSequence == null) {
            return new SpannableString("");
        }
        int i2;
        CharSequence charSequence2;
        CharSequence spannableString;
        Iterator it;
        k kVar;
        Iterator it2;
        p pVar;
        Drawable drawable;
        int i3;
        e eVar;
        this.vCl = i;
        String str = charSequence + "@" + this.vCl + "@" + this.vBZ + "@" + this.vCb + "@" + this.vCc + "@" + this.vCd + "@" + this.vCk + "@" + this.vCm + "@" + this.vCg + "@" + this.vCh + "@" + this.vCi;
        if (z) {
            SpannableString spannableString2 = (SpannableString) vBV.get(str);
            if (spannableString2 != null) {
                e(spannableString2);
                f(spannableString2);
                cdf();
                return spannableString2;
            }
        }
        this.vBW = new ArrayList();
        if (this.vCl <= 0) {
            if (this.kO != null) {
                this.vCl = (int) this.kO.getTextSize();
            } else {
                this.vCl = com.tencent.mm.bu.a.aa(this.mContext, c.bvL);
            }
        }
        if (this.vBW == null) {
            this.vBW = new ArrayList();
        }
        if (this.vBX == null) {
            this.vBX = new ArrayList();
        }
        this.vBW.clear();
        this.vBX.clear();
        if (charSequence != null) {
            if (q.gHP.gGC == 1) {
                i2 = 1;
            } else if (VERSION.SDK_INT == 16 && bi.aD(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
                i2 = 1;
            }
            if (i2 != 0 && this.vCj && com.tencent.mm.pluginsdk.ui.d.d.a.vBb != null && (com.tencent.mm.pluginsdk.ui.d.d.a.vBb.x(charSequence) || com.tencent.mm.pluginsdk.ui.d.d.a.vBb.w(charSequence))) {
                charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
            if (this.vBZ) {
                charSequence = charSequence.toString().contains("data-miniprogram-appid") ? F(charSequence) : E(charSequence);
            }
            if (this.vCg) {
                charSequence = C(charSequence);
            }
            if (this.vCi) {
                charSequence = D(charSequence);
            }
            if (this.vCj || com.tencent.mm.pluginsdk.ui.d.d.a.vBb == null) {
                charSequence2 = charSequence;
            } else {
                charSequence2 = com.tencent.mm.pluginsdk.ui.d.d.a.vBb.b(this.mContext, charSequence, this.vCl);
            }
            if (this.vCc) {
                this.vBX.addAll(G(charSequence2));
            }
            if (this.vBZ) {
                this.vBX.addAll(H(charSequence2));
            }
            if (this.vCa) {
                this.vBX.addAll(I(charSequence2));
            }
            if (this.vCf) {
                this.vBX.addAll(M(charSequence2));
            }
            if (this.vCd) {
                this.vBX.addAll(J(charSequence2));
            }
            if (this.vCb) {
                this.vBX.addAll(K(charSequence2));
            }
            if (this.vCe) {
                this.vBX.addAll(L(charSequence2));
            }
            spannableString = charSequence2 instanceof Spannable ? (SpannableString) charSequence2 : new SpannableString(charSequence2);
            if (this.vCm) {
                it = this.vBW.iterator();
                while (it.hasNext()) {
                    kVar = (k) it.next();
                    kVar.iNG = this.iNG;
                    if (bi.oN(kVar.url)) {
                        spannableString.setSpan(new ForegroundColorSpan(kVar.linkColor), kVar.start, kVar.end, 33);
                    } else if (kVar.start <= spannableString.length() && kVar.end <= spannableString.length()) {
                        spannableString.setSpan(new m(this.vCk, kVar), kVar.start, kVar.end, 33);
                    }
                }
            }
            it2 = this.vBY.iterator();
            while (it2.hasNext()) {
                pVar = (p) it2.next();
                if (pVar.start <= spannableString.length() && pVar.end <= spannableString.length()) {
                    drawable = this.mContext.getResources().getDrawable(pVar.id);
                    if (pVar.width > 0 || pVar.height <= 0) {
                        if (this.kO != null) {
                            i3 = (int) (((float) this.vCl) * 1.3f);
                        } else {
                            i3 = (int) (this.kO.getTextSize() * 1.3f);
                        }
                        drawable.setBounds(0, 0, i3, i3);
                    } else {
                        drawable.setBounds(0, 0, com.tencent.mm.bu.a.fromDPToPix(this.mContext, pVar.width), com.tencent.mm.bu.a.fromDPToPix(this.mContext, pVar.height));
                    }
                    eVar = new e(drawable, 1);
                    eVar.zCd = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 2);
                    spannableString.setSpan(eVar, pVar.start, pVar.start + 1, 18);
                }
            }
            f(spannableString);
            cdf();
            if (z) {
                vBV.l(str, new SpannableString(spannableString));
            }
            return spannableString;
        }
        i2 = 0;
        charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
        if (this.vBZ) {
            if (charSequence.toString().contains("data-miniprogram-appid")) {
            }
        }
        if (this.vCg) {
            charSequence = C(charSequence);
        }
        if (this.vCi) {
            charSequence = D(charSequence);
        }
        if (this.vCj) {
        }
        charSequence2 = charSequence;
        if (this.vCc) {
            this.vBX.addAll(G(charSequence2));
        }
        if (this.vBZ) {
            this.vBX.addAll(H(charSequence2));
        }
        if (this.vCa) {
            this.vBX.addAll(I(charSequence2));
        }
        if (this.vCf) {
            this.vBX.addAll(M(charSequence2));
        }
        if (this.vCd) {
            this.vBX.addAll(J(charSequence2));
        }
        if (this.vCb) {
            this.vBX.addAll(K(charSequence2));
        }
        if (this.vCe) {
            this.vBX.addAll(L(charSequence2));
        }
        if (charSequence2 instanceof Spannable) {
        }
        if (this.vCm) {
            it = this.vBW.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                kVar.iNG = this.iNG;
                if (bi.oN(kVar.url)) {
                    spannableString.setSpan(new ForegroundColorSpan(kVar.linkColor), kVar.start, kVar.end, 33);
                } else {
                    spannableString.setSpan(new m(this.vCk, kVar), kVar.start, kVar.end, 33);
                }
            }
        }
        it2 = this.vBY.iterator();
        while (it2.hasNext()) {
            pVar = (p) it2.next();
            drawable = this.mContext.getResources().getDrawable(pVar.id);
            if (pVar.width > 0) {
            }
            if (this.kO != null) {
                i3 = (int) (this.kO.getTextSize() * 1.3f);
            } else {
                i3 = (int) (((float) this.vCl) * 1.3f);
            }
            drawable.setBounds(0, 0, i3, i3);
            eVar = new e(drawable, 1);
            eVar.zCd = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 2);
            spannableString.setSpan(eVar, pVar.start, pVar.start + 1, 18);
        }
        f(spannableString);
        cdf();
        if (z) {
            vBV.l(str, new SpannableString(spannableString));
        }
        return spannableString;
    }

    private static void e(Spannable spannable) {
        int i = 0;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            if (!((spans[i] instanceof e) || (spans[i] instanceof m))) {
                spannable.removeSpan(spans[i]);
            }
            i++;
        }
    }

    private CharSequence C(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBj.matcher(charSequence.toString());
        while (true) {
            Matcher matcher2 = matcher;
            if (!matcher2.find()) {
                return charSequence;
            }
            if (this.vCh) {
                matcher = charSequence.toString().replace(matcher2.group(0), "");
            } else {
                matcher = charSequence.toString().replace(matcher2.group(0), "  ");
                String group = matcher2.group(1);
                int start = matcher2.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    p pVar = new p(start, i, identifier);
                    if (!bi.oN(group) && "original_label".equals(group)) {
                        pVar.height = 15;
                        pVar.width = 35;
                    }
                    this.vBY.add(pVar);
                } else {
                    x.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher2 = com.tencent.mm.pluginsdk.ui.d.h.a.vBe.matcher(matcher);
        }
    }

    private CharSequence D(CharSequence charSequence) {
        int parseColor;
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBh.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Object group4 = matcher.group(3);
            CharSequence replace = charSequence2.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                charSequence2 = replace;
            } else {
                try {
                    parseColor = Color.parseColor(group2);
                } catch (Exception e) {
                    x.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group2);
                    parseColor = 0;
                }
                k kVar;
                if (bi.oN(group3)) {
                    kVar = new k(start, length);
                    kVar.linkColor = parseColor;
                    this.vBW.add(kVar);
                    this.vBX.add(new a(start, length));
                } else {
                    kVar = a.a(this.mContext, group3, start, length, parseColor, parseColor & -1711276033);
                    if (kVar != null) {
                        if (this.vCn != null) {
                            kVar.data = this.vCn;
                        }
                        this.vBW.add(kVar);
                        this.vBX.add(new a(start, length));
                    }
                }
                charSequence2 = replace;
                matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBh.matcher(replace);
                i = 1;
            }
        }
        if (i == 0) {
            Matcher matcher2 = com.tencent.mm.pluginsdk.ui.d.h.a.vBi.matcher(charSequence);
            while (matcher2.find()) {
                CharSequence group5 = matcher2.group(0);
                String group6 = matcher2.group(1);
                Object group7 = matcher2.group(2);
                if (group6.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group5, group7);
                    int start2 = matcher2.start(0);
                    parseColor = group7.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        Z(group6, start2, parseColor);
                        matcher2 = com.tencent.mm.pluginsdk.ui.d.h.a.vBh.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence E(CharSequence charSequence) {
        Matcher matcher;
        CharSequence charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBe.matcher(charSequence2);
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBd.matcher(charSequence2);
        }
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            Object group3 = matcher.group(2);
            if (group2.length() >= 2) {
                charSequence2 = charSequence2.toString().replace(group, group3);
                int start = matcher.start(0);
                int length = group3.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    Z(group2, start, length);
                    if (charSequence2.length() < 1500) {
                        matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBe.matcher(charSequence2);
                    } else {
                        matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBd.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence F(CharSequence charSequence) {
        Matcher matcher;
        CharSequence charSequence2;
        CharSequence charSequence3 = charSequence.toString();
        if (charSequence3.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBg.matcher(charSequence3);
            charSequence2 = charSequence3;
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBf.matcher(charSequence3);
            charSequence2 = charSequence3;
        }
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map y = bj.y(group.replace(group2, " ").replace(group3, " "), "a");
            if (y == null) {
                x.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                int i;
                String str = (String) y.get(".a.$data-miniprogram-appid");
                String str2 = (String) y.get(".a.$data-miniprogram-path");
                int i2 = !bi.oN(group2) ? 1 : 0;
                if (bi.oN(str)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i2 == 0 || i != 0) {
                    int length;
                    if (i == 0) {
                        x.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.vCh) {
                        charSequence3 = charSequence2.toString().replace(group, group3);
                        int start = matcher.start(0);
                        length = group3.length() + start;
                        k kVar = new k(group2, 45, null);
                        kVar.start = start;
                        kVar.end = length;
                        this.vBW.add(kVar);
                    } else {
                        Object obj = "    " + group3;
                        String replace = charSequence2.toString().replace(group, obj);
                        length = matcher.start(0);
                        i2 = obj.length() + length;
                        this.vBY.add(new p(length + 1, length + 3, g.iAH));
                        k kVar2 = new k(str, 45, str2);
                        kVar2.start = length + 4;
                        kVar2.end = i2;
                        this.vBW.add(kVar2);
                        Object obj2 = replace;
                    }
                } else if (group2.length() >= 2) {
                    str = charSequence2.toString().replace(group, group3);
                    int start2 = matcher.start(0);
                    int length2 = group3.length() + start2;
                    if (start2 < 0 || length2 > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start2), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                        charSequence2 = str;
                    } else {
                        Z(group2, start2, length2);
                        charSequence3 = str;
                    }
                }
                if (charSequence3.length() < 1500) {
                    matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBg.matcher(charSequence3);
                    charSequence2 = charSequence3;
                } else {
                    matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBf.matcher(charSequence3);
                    charSequence2 = charSequence3;
                }
            }
        }
        return charSequence2;
    }

    private ArrayList<a> G(CharSequence charSequence) {
        int i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        ArrayList<a> arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.d.h.a.vBn;
        if (charSequence.length() <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            k kVar = new k(matcher.group(), 24, null);
            kVar.start = start;
            kVar.end = end;
            if (!a(this.vBX, new a(start, end))) {
                this.vBW.add(kVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> H(CharSequence charSequence) {
        Matcher matcher;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBm.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBl.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vBX, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                k kVar = new k(charSequence2.substring(start, end), 1, this.vCn);
                kVar.start = start;
                kVar.end = end;
                this.vBW.add(kVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> I(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 200) {
            Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBs.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.vBX, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    k kVar = new k(charSequence2.substring(start, end), 44, this.vCn);
                    kVar.start = start;
                    kVar.end = end;
                    this.vBW.add(kVar);
                    arrayList.add(new a(start, end));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<a> J(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBp.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vBX, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                k kVar = new k(charSequence2.substring(start, end), 28, null);
                kVar.start = start;
                kVar.end = end;
                this.vBW.add(kVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> K(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBo.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Object group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains(group)) && i < 24 && !a(this.vBX, new a(start, end))) {
                k kVar = new k(group, 25, this.vCn);
                kVar.start = start;
                kVar.end = end;
                this.vBW.add(kVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> L(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = a.bc(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            a aVar = new a(kVar.start, kVar.end);
            if (!a(this.vBX, aVar)) {
                this.vBW.add(kVar);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a> M(CharSequence charSequence) {
        int start;
        int end;
        a aVar;
        k kVar;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBr.matcher(charSequence2);
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            aVar = new a(start, end);
            if (!a(this.vBX, aVar) && start >= 0 && end <= charSequence2.length()) {
                kVar = new k(charSequence2.substring(start, end), 30, null);
                kVar.start = start;
                kVar.end = end;
                this.vBW.add(kVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBq.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(start, end);
                if (!a(this.vBX, aVar) && start >= 0 && end <= charSequence2.length()) {
                    kVar = new k(charSequence2.substring(start, end), 30, null);
                    kVar.start = start;
                    kVar.end = end;
                    this.vBW.add(kVar);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean Z(String str, int i, int i2) {
        k a = a.a(this.mContext, str, i, i2);
        if (a == null) {
            return false;
        }
        if (this.vCn != null) {
            a.data = this.vCn;
        }
        this.vBW.add(a);
        this.vBX.add(new a(i, i2));
        return true;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            a aVar2 = (a) it.next();
            if (aVar2.end <= aVar.start || aVar.end <= aVar2.start) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void f(Spannable spannable) {
        if (this.kO != null && !bi.oN(spannable.toString())) {
            if (r.igm) {
                this.kO.setText(spannable, BufferType.SPANNABLE);
            } else {
                this.kO.setText(spannable);
            }
        }
    }

    private void cdf() {
        if (this.kO != null) {
            OnTouchListener lVar = new l();
            lVar.iNG = this.iNG;
            this.kO.setOnTouchListener(lVar);
        }
    }

    public static void clearCache() {
        vBV.clear();
    }
}
