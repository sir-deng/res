package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.bu.a;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.blc;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bzk;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    private static float mI(String str) {
        if (str == null) {
            return 0.0f;
        }
        return bi.getFloat(str, 0.0f);
    }

    private static String mJ(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static bpb SH() {
        bpb bpb = new bpb();
        pj pjVar = new pj();
        bpb.wYi = new cy();
        bpb.wYj = pjVar;
        bpb.wER = 0;
        bpb.pgR = 0;
        bpb.nMq = "";
        apl apl = new apl();
        apl.vXy = 0.0f;
        apl.vXx = 0.0f;
        bpb.wYh = apl;
        bpb.rRR = "";
        bpb.wYp = new bzk();
        return bpb;
    }

    public static are SI() {
        are are = new are();
        are.nkL = "";
        are.wER = 0;
        return are;
    }

    public static are a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        are are = new are();
        are.nMq = str;
        are.kzz = i;
        are.nlE = str2;
        are.wEP = str3;
        are.wEO = i2;
        are.wEQ = i3;
        are.nkL = str4;
        arg arg = new arg();
        arg.wFG = 0.0f;
        arg.wFF = 0.0f;
        arg.wFH = 0.0f;
        are.wES = arg;
        are.wFd = g.s(str2 == null ? "".getBytes() : str2.getBytes());
        return are;
    }

    public static are a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, arg arg) {
        are are = new are();
        are.nMq = mJ(str);
        are.kzz = i;
        are.nkL = mJ(str4);
        are.nlE = mJ(str2);
        are.wEO = i2;
        are.wEP = mJ(str3);
        are.wEQ = i3;
        are.wER = i4;
        are.wES = arg;
        are.wFd = g.s(str2 == null ? "".getBytes() : str2.getBytes());
        return are;
    }

    public static bpb mK(String str) {
        Map y = bj.y(str, "TimelineObject");
        bpb SH = SH();
        if (y == null) {
            return SH;
        }
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int indexOf;
        int indexOf2;
        bpb bpb;
        SH.nMq = mJ((String) y.get(".TimelineObject.id"));
        SH.kyG = mJ((String) y.get(".TimelineObject.username"));
        SH.wER = bi.getInt((String) y.get(".TimelineObject.private"), 0);
        SH.pgR = bi.getInt((String) y.get(".TimelineObject.createTime"), 0);
        SH.wYg = mJ((String) y.get(".TimelineObject.contentDesc"));
        SH.wYl = bi.getInt((String) y.get(".TimelineObject.contentDescShowType"), 0);
        SH.wYm = bi.getInt((String) y.get(".TimelineObject.contentDescScene"), 0);
        SH.rzD = mJ((String) y.get(".TimelineObject.statExtStr"));
        SH.wYq = bi.getInt((String) y.get(".TimelineObject.sightFolded"), 0);
        apl apl = new apl();
        apl.vXx = mI((String) y.get(".TimelineObject.location.$longitude"));
        apl.vXy = mI((String) y.get(".TimelineObject.location.$latitude"));
        apl.hxg = mJ((String) y.get(".TimelineObject.location.$city"));
        apl.wCU = bi.getInt((String) y.get(".TimelineObject.location.$poiScale"), 0);
        apl.wCS = mJ((String) y.get(".TimelineObject.location.$poiClassifyId"));
        apl.rAj = bi.getInt((String) y.get(".TimelineObject.location.$poiClassifyType"), 0);
        apl.rAh = mJ((String) y.get(".TimelineObject.location.$poiAddress"));
        apl.nYL = mJ((String) y.get(".TimelineObject.location.$poiName"));
        apl.wCV = bi.getInt((String) y.get(".TimelineObject.location.$poiClickableStatus"), 0);
        apl.wCX = mJ((String) y.get(".TimelineObject.location.$poiAddressName"));
        apl.country = mJ((String) y.get(".TimelineObject.location.$country"));
        SH.wYh = apl;
        String str7 = ".TimelineObject.ContentObject.description";
        String str8 = ".TimelineObject.ContentObject.contentStyle";
        String str9 = ".TimelineObject.ContentObject.contentSubStyle";
        String str10 = ".TimelineObject.ContentObject.title";
        String str11 = ".TimelineObject.ContentObject.contentUrl";
        if (SH.wYj == null) {
            SH.wYj = new pj();
        }
        SH.wYj.nkL = mJ((String) y.get(str7));
        SH.wYj.wfg = bi.getInt((String) y.get(str8), 0);
        SH.wYj.wfi = bi.getInt((String) y.get(str9), 0);
        SH.wYj.fpg = mJ((String) y.get(str10));
        SH.wYj.nlE = mJ((String) y.get(str11));
        int i = 0;
        while (true) {
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            if (i != 0) {
                str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".id";
                str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".type";
                str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".title";
                str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".description";
                str16 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url";
                str17 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$videomd5";
                str18 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb";
                str19 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$type";
                str21 = ".TimelineObject.ContentObject.mediaList.media" + i + ".private";
                str22 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
                str24 = ".TimelineObject.ContentObject.mediaList.media" + i;
                str25 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
                str26 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
                str27 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
                str28 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
                str29 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
                str30 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
                str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
                str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
                str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
                str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
                str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
                str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
                str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
                str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
                str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
                str31 = str14;
                str32 = str26;
                str26 = str15;
                str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
                str7 = str24;
                str15 = str8;
                str24 = str30;
                obj = str25;
                str25 = str29;
                obj2 = str16;
                str16 = str9;
                String str33 = str3;
                obj3 = str19;
                str19 = str4;
                obj4 = str17;
                str17 = str10;
                obj5 = str13;
                str13 = str5;
                obj6 = str18;
                str18 = str11;
                obj7 = str12;
                str12 = str6;
                obj8 = str21;
                str21 = str2;
                obj9 = str20;
                str20 = str33;
                String str34 = str22;
                str22 = str28;
                obj10 = str34;
                String str35 = str23;
                str23 = str27;
                obj11 = str35;
            } else {
                str31 = ".TimelineObject.ContentObject.mediaList.media.title";
                str32 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                str26 = ".TimelineObject.ContentObject.mediaList.media.description";
                str14 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                str7 = ".TimelineObject.ContentObject.mediaList.media";
                str15 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                str24 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                str30 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                str25 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                str29 = ".TimelineObject.ContentObject.mediaList.media.url";
                str16 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                str3 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                str19 = ".TimelineObject.ContentObject.mediaList.media.enc";
                str4 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                str17 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                str10 = ".TimelineObject.ContentObject.mediaList.media.type";
                str13 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                str5 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                str18 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                str11 = ".TimelineObject.ContentObject.mediaList.media.id";
                str12 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                str6 = ".TimelineObject.ContentObject.mediaList.media.private";
                str21 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                str2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                str22 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                str28 = ".TimelineObject.ContentObject.mediaList.media.subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                str27 = ".TimelineObject.ContentObject.mediaList.media.userData";
            }
            str8 = str7 + ".size.$width";
            str9 = str7 + ".size.$height";
            String str36 = str7 + ".size.$totalSize";
            str7 = (String) y.get(str8);
            str8 = (String) y.get(str9);
            str9 = (String) y.get(str36);
            arg arg = new arg();
            arg.wFG = 0.0f;
            arg.wFF = 0.0f;
            arg.wFH = 0.0f;
            if (str7 != null) {
                arg.wFF = mI(str7);
            }
            if (str8 != null) {
                arg.wFG = mI(str8);
            }
            if (str9 != null) {
                arg.wFH = mI(str9);
            }
            str7 = (String) y.get(obj7);
            str8 = (String) y.get(obj5);
            str9 = (String) y.get(str31);
            str10 = (String) y.get(str26);
            str11 = (String) y.get(obj2);
            str6 = (String) y.get(obj8);
            str5 = (String) y.get(obj6);
            str4 = (String) y.get(obj4);
            str3 = (String) y.get(obj3);
            str2 = (String) y.get(obj9);
            str30 = (String) y.get(obj);
            str29 = (String) y.get(str32);
            str28 = (String) y.get(obj10);
            str27 = (String) y.get(obj11);
            str23 = (String) y.get(str23);
            str22 = (String) y.get(str22);
            str25 = (String) y.get(str25);
            str24 = (String) y.get(str24);
            str21 = (String) y.get(str21);
            str20 = (String) y.get(str20);
            str19 = (String) y.get(str19);
            str13 = (String) y.get(str13);
            str12 = (String) y.get(str12);
            str18 = (String) y.get(str18);
            str17 = (String) y.get(str17);
            str16 = (String) y.get(str16);
            str15 = (String) y.get(str15);
            str14 = (String) y.get(str14);
            if (str8 == null || str7 == null) {
                indexOf = str.indexOf("<noteinfo>");
                indexOf2 = str.indexOf("</noteinfo>");
            } else {
                are are = new are();
                are.nMq = mJ(str7);
                are.kzz = bi.getInt(str8, 0);
                are.fpg = mJ(str9);
                are.nkL = mJ(str10);
                are.nlE = mJ(str11);
                are.wEO = bi.getInt(str3, 0);
                are.wEP = mJ(str5);
                are.wEQ = bi.getInt(str2, 0);
                are.wER = bi.getInt(str6, 0);
                are.wES = arg;
                are.wET = mJ(str30);
                are.wEU = bi.getInt(str29, 0);
                are.ryq = mJ(str27);
                are.fqh = bi.getInt(str28, 0);
                are.wEW = mJ(str23);
                are.wEY = mJ(str22);
                are.wEX = mJ(str25);
                are.wFk = mJ(str4);
                are.rTh = bi.getInt(str24, 0);
                are.wEZ = mJ(str21);
                are.wFa = mJ(str20);
                are.wFb = bi.getInt(str19, 0);
                are.wFc = bi.getLong(str13, 0);
                are.wFd = g.s(are.nlE == null ? "".getBytes() : are.nlE.getBytes());
                are.wFe = str12;
                are.wFf = bi.getInt(str18, 0);
                are.wFg = str17;
                are.wFh = str16;
                are.wFi = bi.getInt(str15, 0);
                are.wFj = str14;
                SH.wYj.wfh.add(are);
                i++;
            }
        }
        indexOf = str.indexOf("<noteinfo>");
        indexOf2 = str.indexOf("</noteinfo>");
        if (indexOf < 0 || indexOf2 < 0) {
            bpb = SH;
        } else {
            SH.wYj.wfj = str.substring(indexOf, indexOf2 + 11);
            bpb = SH;
        }
        cy cyVar = new cy();
        str10 = mJ((String) y.get(".TimelineObject.appInfo.id"));
        str11 = mJ((String) y.get(".TimelineObject.appInfo.version"));
        str6 = mJ((String) y.get(".TimelineObject.appInfo.appName"));
        str5 = mJ((String) y.get(".TimelineObject.appInfo.installUrl "));
        str7 = mJ((String) y.get(".TimelineObject.appInfo.fromUrl "));
        cyVar.nMq = str10;
        cyVar.noG = str6;
        cyVar.vOC = str5;
        cyVar.vOD = str7;
        cyVar.kzm = str11;
        cyVar.vOE = bi.getInt((String) y.get(".TimelineObject.appInfo.clickable"), 0);
        bpb.wYi = cyVar;
        bzk bzk = new bzk();
        str10 = mJ((String) y.get(".TimelineObject.weappInfo.appUserName"));
        str7 = mJ((String) y.get(".TimelineObject.weappInfo.pagePath"));
        bzk.username = str10;
        bzk.path = str7;
        bpb.wYp = bzk;
        bno bno = new bno();
        str10 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideotitle"));
        str11 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideototaltime"));
        str6 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideourl"));
        str5 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str4 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideowording"));
        str3 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str2 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str7 = mJ((String) y.get(".TimelineObject.streamvideo.streamvideopublishid"));
        bno.hfb = str10;
        bno.hfa = bi.Wo(str11);
        bno.heZ = str6;
        bno.hfd = str5;
        bno.hfc = str4;
        bno.hfe = str3;
        bno.hff = str2;
        bno.hfg = str7;
        bpb.wYo = bno;
        blc blc = new blc();
        str10 = mJ((String) y.get(".TimelineObject.redEnvelopesInfo.sendId"));
        str7 = mJ((String) y.get(".TimelineObject.redEnvelopesInfo.ticket"));
        blc.oeH = str10;
        blc.fsK = str7;
        au auVar = new au();
        int i2 = bi.getInt((String) y.get(".TimelineObject.actionInfo.scene"), 0);
        str11 = mJ((String) y.get(".TimelineObject.actionInfo.appid"));
        int i3 = bi.getInt((String) y.get(".TimelineObject.actionInfo.type"), 0);
        str5 = mJ((String) y.get(".TimelineObject.actionInfo.url"));
        str4 = mJ((String) y.get(".TimelineObject.actionInfo.mediaTagName"));
        str7 = mJ((String) y.get(".TimelineObject.actionInfo.wordingKey"));
        auVar.vMu = str11;
        auVar.sfa = i2;
        auVar.kzz = i3;
        auVar.nlE = str5;
        auVar.vMv = str4;
        auVar.vMw = str7;
        as asVar = new as();
        str11 = mJ((String) y.get(".TimelineObject.actionInfo.appMsg.appid"));
        str6 = mJ((String) y.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        str5 = mJ((String) y.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str7 = mJ((String) y.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        asVar.nlV = str11;
        asVar.vMr = str6;
        asVar.vMs = str5;
        asVar.vMt = str7;
        auVar.vMx = asVar;
        i2 = bi.getInt((String) y.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        int i4 = bi.getInt((String) y.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        str6 = mJ((String) y.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        str5 = mJ((String) y.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        auVar.vMy = mJ((String) y.get(".TimelineObject.actionInfo.newWordingKey"));
        cs csVar = new cs();
        csVar.vOu = i2;
        csVar.vOv = i4;
        da daVar = new da();
        daVar.vOI = str6;
        daVar.vOJ = str5;
        auVar.vMz = csVar;
        auVar.vMA = daVar;
        auVar.vMB = mL((String) y.get(".TimelineObject.actionInfo.installedWording"));
        auVar.vMC = mL((String) y.get(".TimelineObject.actionInfo.uninstalledWording"));
        bpb.rey = auVar;
        bpb.vtA = mJ((String) y.get(".TimelineObject.sourceUserName"));
        bpb.vtB = mJ((String) y.get(".TimelineObject.sourceNickName"));
        bpb.wYk = mJ((String) y.get(".TimelineObject.publicUserName"));
        bpb.wYn = mJ((String) y.get(".TimelineObject.statisticsData"));
        bpb.rRR = mJ((String) y.get(".TimelineObject.canvasInfoXml"));
        bpb.hcR = bi.getInt((String) y.get(".TimelineObject.contentattr"), 0);
        cbj cbj = new cbj();
        cbj.ttO = mJ((String) y.get(".TimelineObject.websearch.relevant_vid"));
        cbj.ttP = mJ((String) y.get(".TimelineObject.websearch.relevant_expand"));
        cbj.ttQ = mJ((String) y.get(".TimelineObject.websearch.relevant_pre_searchid"));
        cbj.ttR = mJ((String) y.get(".TimelineObject.websearch.relevant_shared_openid"));
        cbj.ttS = bi.getLong((String) y.get(".TimelineObject.websearch.rec_category"), 0);
        cbj.lUI = mJ((String) y.get(".TimelineObject.websearch.shareUrl"));
        cbj.lUJ = mJ((String) y.get(".TimelineObject.websearch.shareTitle"));
        cbj.rlx = mJ((String) y.get(".TimelineObject.websearch.shareDesc"));
        cbj.skF = mJ((String) y.get(".TimelineObject.websearch.shareImgUrl"));
        cbj.skG = mJ((String) y.get(".TimelineObject.websearch.shareString"));
        cbj.skH = mJ((String) y.get(".TimelineObject.websearch.shareStringUrl"));
        cbj.bhd = mJ((String) y.get(".TimelineObject.websearch.source"));
        cbj.pka = mJ((String) y.get(".TimelineObject.websearch.sourceUrl"));
        cbj.skL = mJ((String) y.get(".TimelineObject.websearch.strPlayCount"));
        cbj.skM = mJ((String) y.get(".TimelineObject.websearch.titleUrl"));
        bpb.reA = cbj;
        return bpb;
    }

    private static cz mL(String str) {
        if (bi.oN(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        Map y = bj.y("<root>" + stringBuilder.toString() + "</root>", "root");
        cz czVar = new cz();
        czVar.vOF = mJ((String) y.get(".root.en"));
        czVar.vOG = mJ((String) y.get(".root.zh-CN"));
        czVar.vOH = mJ((String) y.get(".root.zh-TW"));
        return czVar;
    }

    public static Pair<Integer, Integer> a(bpb bpb, Context context, boolean z) {
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        int i4;
        int fromDPToPix;
        int fromDPToPix2;
        int i5;
        if (!(bpb == null || bpb.wYj == null || bpb.wYj.wfh == null || bpb.wYj.wfh.size() <= 0)) {
            are are = (are) bpb.wYj.wfh.get(0);
            if (are != null && are.wES != null && are.wES.wFF > 0.0f && are.wES.wFG > 0.0f) {
                i = (int) are.wES.wFF;
                i2 = (int) are.wES.wFG;
                if (i <= 0) {
                    i = 320;
                }
                if (i2 > 0) {
                    i3 = 240;
                } else {
                    i3 = i2;
                }
                if (context != null) {
                    x.e("MicroMsg.TimeLineHelper", "the context is null");
                    return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
                }
                displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics == null) {
                    i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
                } else {
                    i2 = i;
                }
                i4 = (i2 >> 5) << 5;
                if (i < i3 && context != null) {
                    i4 = Math.min(b.b(context, 160.0f), i4);
                }
                i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
                if (!z) {
                    fromDPToPix = a.fromDPToPix(context, 200);
                    fromDPToPix2 = a.fromDPToPix(context, 44);
                    if (i2 < i4) {
                        if (i2 > fromDPToPix) {
                            i2 = fromDPToPix;
                        }
                        i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                        if (i4 < fromDPToPix2) {
                            i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                            x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
                            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                        }
                    }
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        i5 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i5;
                        x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                fromDPToPix2 = i4;
                x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
                return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
            }
        }
        i2 = 0;
        i = 0;
        if (i <= 0) {
            i = 320;
        }
        if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = 240;
        }
        if (context != null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                i2 = i;
            } else {
                i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
            }
            i4 = (i2 >> 5) << 5;
            i4 = Math.min(b.b(context, 160.0f), i4);
            i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
            if (z) {
                fromDPToPix = a.fromDPToPix(context, 200);
                fromDPToPix2 = a.fromDPToPix(context, 44);
                if (i2 < i4) {
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        i5 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i5;
                        x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                if (i2 > fromDPToPix) {
                    i2 = fromDPToPix;
                }
                i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                if (i4 < fromDPToPix2) {
                    i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                    x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
                    return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                }
            }
            fromDPToPix2 = i4;
            x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z));
            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
        }
        x.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
    }
}
