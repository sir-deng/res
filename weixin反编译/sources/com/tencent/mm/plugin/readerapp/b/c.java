package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bg;
import com.tencent.mm.y.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    public final b b(a aVar) {
        List<bg> arrayList;
        int i;
        Object valueOf;
        Throwable th;
        int i2;
        int i3;
        bg bgVar;
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        }
        String str;
        int i4;
        g.bmV().aN((long) bxVar.vNL);
        String a = n.a(bxVar.vNO);
        long Wy = bi.Wy();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i5 = 0;
        arrayList = new ArrayList();
        int i6 = 0;
        try {
            Map y = bj.y(a, "mmreader");
            i5 = 0;
            i = 0;
            while (i5 <= 0) {
                StringBuilder stringBuilder = new StringBuilder(".mmreader.category");
                if (i5 > 0) {
                    valueOf = Integer.valueOf(i5);
                } else {
                    try {
                        valueOf = "";
                    } catch (Throwable e) {
                        th = e;
                        i2 = i;
                        i = i5;
                    }
                }
                String stringBuilder2 = stringBuilder.append(valueOf).toString();
                i6 = bi.getInt((String) y.get(stringBuilder2 + ".$type"), 0);
                if (i6 != 0) {
                    if (i6 != 20 && i6 != 11) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error Type:" + i6);
                        i3 = i5;
                        break;
                    }
                    a = (String) y.get(stringBuilder2 + ".name");
                    if (bi.oN(a)) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".name  error");
                        i = i6;
                        i3 = i5;
                        break;
                    }
                    String str2 = (String) y.get(stringBuilder2 + ".topnew.cover");
                    str = (String) y.get(stringBuilder2 + ".topnew.digest");
                    int i7 = bi.getInt((String) y.get(stringBuilder2 + ".$count"), 0);
                    if (i7 == 0) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$count  error");
                        i = i6;
                        i3 = i5;
                        break;
                    }
                    if (i7 > 1) {
                        stringBuilder2 = stringBuilder2 + (i6 == 20 ? ".newitem" : ".item");
                    } else {
                        stringBuilder2 = stringBuilder2 + ".item";
                    }
                    i4 = 0;
                    while (true) {
                        int i8 = i4;
                        if (i8 >= i7) {
                            break;
                        }
                        String str3 = stringBuilder2 + (i8 > 0 ? Integer.valueOf(i8) : "");
                        bg bgVar2 = new bg();
                        bgVar2.aM((long) bxVar.vNL);
                        bgVar2.title = (String) y.get(str3 + ".title");
                        if (i8 == 0) {
                            long j = bi.getLong((String) y.get(str3 + ".pub_time"), 0);
                            if (j > 0) {
                                Wy = 1000 * j;
                            }
                            bgVar2.hiU = 1;
                            bgVar2.hfO = str2;
                            bgVar2.hfQ = bi.oN(str) ? (String) y.get(str3 + ".digest") : str;
                        } else {
                            bgVar2.hfO = (String) y.get(str3 + ".cover");
                            bgVar2.hfQ = (String) y.get(str3 + ".digest");
                        }
                        bgVar2.hiV = y.containsKey(new StringBuilder().append(str3).append(".vedio").toString()) ? 1 : 0;
                        bgVar2.url = (String) y.get(str3 + ".url");
                        bgVar2.hiP = (String) y.get(str3 + ".shorturl");
                        bgVar2.hiQ = (String) y.get(str3 + ".longurl");
                        bgVar2.hiR = bi.getLong((String) y.get(str3 + ".pub_time"), 0);
                        String str4 = (String) y.get(str3 + ".tweetid");
                        if (str4 == null || "".equals(str4)) {
                            str4 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i8)));
                            x.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + str4);
                        }
                        bgVar2.hiO = str4;
                        bgVar2.hiS = (String) y.get(str3 + ".sources.source.name");
                        bgVar2.hiT = (String) y.get(str3 + ".sources.source.icon");
                        bgVar2.time = ((long) i5) + Wy;
                        bgVar2.type = i6;
                        bgVar2.name = a;
                        arrayList.add(bgVar2);
                        i4 = i8 + 1;
                    }
                    i5++;
                    i = i6;
                } else {
                    x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error");
                    i3 = i5;
                    break;
                }
            }
            i3 = i5;
        } catch (Throwable e2) {
            th = e2;
            i = i5;
            i2 = i6;
        }
        x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i + ", want to receive news? " + bmT());
        for (bg bgVar3 : arrayList) {
            if (bi.oN(bgVar3.getTitle())) {
                if (bi.oN(bgVar3.getUrl())) {
                    x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bgVar3.HN() + ", type = " + bgVar3.type);
                    valueOf = null;
                    break;
                }
            }
            x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bgVar3.HN() + ", type = " + bgVar3.type);
            valueOf = null;
            break;
        }
        i2 = 1;
        if (arrayList.size() > 0 || r4 == null) {
            return null;
        }
        int i9 = 0;
        bg bgVar4 = null;
        i6 = 0;
        while (i6 < arrayList.size()) {
            if (g.bmV().a((bg) arrayList.get(i6))) {
                if (bgVar4 == null) {
                    bgVar3 = (bg) arrayList.get(i6);
                    bgVar3.hiU = 1;
                } else {
                    bgVar3 = bgVar4;
                }
                i4 = i9 + 1;
            } else {
                bgVar3 = bgVar4;
                i4 = i9;
            }
            i6++;
            i9 = i4;
            bgVar4 = bgVar3;
        }
        if (i9 > 0) {
            as.Hm();
            ae XF = com.tencent.mm.y.c.Fk().XF(bg.gW(i));
            if (XF == null || !XF.field_username.equals(bg.gW(i))) {
                ae aeVar = new ae();
                aeVar.setUsername(bg.gW(i));
                aeVar.setContent(bgVar4 == null ? "" : bgVar4.getTitle());
                aeVar.aj(bgVar4 == null ? bi.Wy() : bgVar4.time);
                aeVar.eS(0);
                aeVar.eP(i3);
                as.Hm();
                com.tencent.mm.y.c.Fk().d(aeVar);
            } else {
                XF.setContent(bgVar4.getTitle());
                XF.aj(bgVar4.time);
                XF.eS(0);
                XF.eP(i3 + XF.field_unReadCount);
                as.Hm();
                com.tencent.mm.y.c.Fk().a(XF, bg.gW(i));
            }
            g.bmV().doNotify();
            str = bgVar4.getTitle();
            au auVar = new au();
            auVar.setContent(str);
            auVar.dU(bg.gW(i));
            auVar.setType(1);
            auVar.ao(7377812);
            return new b(auVar, true);
        }
        x.e("MicroMsg.ReaderAppMsgExtension", "insert error");
        return null;
        x.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", th, "", new Object[0]);
        i3 = i;
        i = i2;
        x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i + ", want to receive news? " + bmT());
        for (bg bgVar32 : arrayList) {
            if (bi.oN(bgVar32.getTitle())) {
                if (bi.oN(bgVar32.getUrl())) {
                    x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bgVar32.HN() + ", type = " + bgVar32.type);
                    valueOf = null;
                    break;
                }
            }
            x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bgVar32.HN() + ", type = " + bgVar32.type);
            valueOf = null;
            break;
        }
        i2 = 1;
        if (arrayList.size() > 0) {
        }
        return null;
    }

    public static boolean bmT() {
        return (q.Ge() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final void h(au auVar) {
    }
}
