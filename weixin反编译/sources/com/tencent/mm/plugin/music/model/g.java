package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.au.a;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class g {
    private static final Pattern ndA = Pattern.compile("songid=([0-9]+)");
    private static final String[] oPx = new String[]{"#", "?", "&"};
    private static String oPy = null;
    private static String oPz = null;

    public static String di(Context context) {
        Throwable e;
        String str = "";
        String packageName = ad.getPackageName();
        if (packageName == null) {
            return str;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return str;
            }
            packageName = str + packageInfo.versionName;
            try {
                return packageName + "." + packageInfo.versionCode;
            } catch (Throwable e2) {
                Throwable th = e2;
                str = packageName;
                e = th;
            }
        } catch (NameNotFoundException e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
            return str;
        }
    }

    public static String b(a aVar, boolean z) {
        as.Hm();
        File file = new File(c.FJ(), "music");
        if (!file.exists()) {
            x.i("MicroMsg.Music.MusicUtil", "create file folder:%b for path:%s", Boolean.valueOf(file.mkdirs()), file.getAbsolutePath());
        }
        x.d("MicroMsg.Music.MusicUtil", "music name %s path %s", z ? ac.VF(aVar.field_musicId + "temp") + "-wifi" : ac.VF(aVar.field_musicId + "temp"), new File(file, z ? ac.VF(aVar.field_musicId + "temp") + "-wifi" : ac.VF(aVar.field_musicId + "temp")).getAbsoluteFile());
        return new File(file, z ? ac.VF(aVar.field_musicId + "temp") + "-wifi" : ac.VF(aVar.field_musicId + "temp")).getAbsolutePath();
    }

    public static String Gr(String str) {
        as.Hm();
        File file = new File(c.FJ(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MicroMsg.Music.MusicUtil", "getMusicPieceFilePath music name %s path %s", Gw(str), new File(file, Gw(str)).getAbsoluteFile());
        return new File(file, Gw(str)).getAbsolutePath();
    }

    public static String c(a aVar, boolean z) {
        return b(aVar, false) + "-thumb-" + z;
    }

    public static boolean Gs(String str) {
        if (bi.oN(str)) {
            return false;
        }
        boolean contains;
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            contains = parse.getHost().contains(".qq.com");
            x.w("MicroMsg.Music.MusicUtil", "url %s match ? %B", str, Boolean.valueOf(contains));
        } else {
            x.i("MicroMsg.Music.MusicUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        return contains;
    }

    public static boolean d(a aVar) {
        x.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl);
        if (bi.oN(aVar.field_songWapLinkUrl) && bi.oN(aVar.field_songWebUrl) && bi.oN(aVar.field_songWifiUrl)) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        if (z || bi.oN(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (bi.oN(str3)) {
            return str3;
        }
        PString pString = new PString();
        x.i("MicroMsg.Music.MusicUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", str, str2, Boolean.valueOf(z));
        String Gt = Gt(str3);
        if (Gt != null) {
            if (a(Gt, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        return pString.value;
    }

    private static String Gt(String str) {
        if (bi.oN(str)) {
            return null;
        }
        if (oPy != null && str.equals(oPy)) {
            return oPz;
        }
        int indexOf;
        String str2 = "";
        String str3 = null;
        for (String str22 : oPx) {
            str22 = str22 + "p=";
            if (str.contains(str22)) {
                str3 = str;
            }
            if (str3 != null) {
                break;
            }
        }
        if (str3 == null) {
            return null;
        }
        indexOf = str3.indexOf(str22);
        if (indexOf < 0) {
            x.w("MicroMsg.Music.MusicUtil", "pIndex is %d, return", Integer.valueOf(indexOf));
            return null;
        }
        String substring = str3.substring(str22.length() + indexOf);
        for (String indexOf2 : oPx) {
            int indexOf3 = substring.indexOf(indexOf2);
            if (indexOf3 > 0) {
                substring = substring.substring(0, indexOf3);
            }
        }
        if (substring == null) {
            return substring;
        }
        oPy = str;
        oPz = substring;
        return substring;
    }

    private static boolean a(String str, boolean z, PString pString) {
        String str2 = new String(Gu(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            x.d("MicroMsg.Music.MusicUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            return true;
        } catch (Throwable e) {
            pString.value = str;
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "decodeJson", new Object[0]);
            return false;
        }
    }

    private static byte[] Gu(String str) {
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int i3 = i + 1;
                int m = m(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    i3 = m(str.charAt(i3));
                } else {
                    i = i3;
                    i3 = 0;
                }
                int i4 = i2 + 1;
                bArr[i2] = (byte) (i3 | (m << 4));
                i2 = i4;
            } catch (Exception e) {
                return null;
            }
        }
        return bArr;
    }

    private static int Gv(String str) {
        int i = 0;
        if (bi.oN(str)) {
            return i;
        }
        Matcher matcher = ndA.matcher(str);
        if (!matcher.find()) {
            return i;
        }
        try {
            return Integer.valueOf(matcher.group(1)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getSongId", new Object[i]);
            return i;
        }
    }

    private static int m(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    private static String g(ati ati) {
        String str;
        String Gt;
        if (ati != null) {
            if (!bi.oN(ati.wHz)) {
                str = ati.wHz;
            } else if (!bi.oN(ati.wHB)) {
                str = ati.wHB;
            } else if (!bi.oN(ati.wHA)) {
                str = ati.wHA;
            }
            if (str == null) {
                return null;
            }
            Gt = Gt(ati.wHz);
            if (Gt == null) {
                return Gt;
            }
            Gt = Gt(ati.wHB);
            if (Gt != null) {
                return Gt(ati.wHA);
            }
            return Gt;
        }
        str = null;
        if (str == null) {
            return null;
        }
        Gt = Gt(ati.wHz);
        if (Gt == null) {
            return Gt;
        }
        Gt = Gt(ati.wHB);
        if (Gt != null) {
            return Gt;
        }
        return Gt(ati.wHA);
    }

    public static ati h(ati ati) {
        if (ati != null) {
            ati.wub = Gv(ati.wHz);
            if (ati.wub <= 0) {
                ati.wub = Gv(ati.wHB);
                if (ati.wub <= 0) {
                    ati.wub = Gv(ati.wHA);
                    int i = ati.wub;
                }
            }
        }
        if (!(ati == null || g(ati) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = g(ati);
            if (g != null) {
                x.d("MicroMsg.Music.MusicUtil", "bcdUrl: %s", g);
                String str = new String(Gu(g));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    ati.wub = jSONObject.optInt("song_ID");
                    if (bi.oN(ati.wHv)) {
                        ati.wHv = jSONObject.optString("song_Name");
                    }
                    if (bi.oN(ati.wHA)) {
                        ati.wHA = jSONObject.optString("song_WapLiveURL");
                    }
                    if (bi.oN(ati.wHz)) {
                        ati.wHz = jSONObject.optString("song_WifiURL");
                    }
                    if (bi.oN(ati.wHx)) {
                        ati.wHx = jSONObject.optString("song_Album");
                    }
                    if (bi.oN(ati.wHw)) {
                        ati.wHw = jSONObject.optString("song_Singer");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
                }
                if (ati.wub == 0) {
                    ati.wub = Gv(oPy);
                }
                x.i("MicroMsg.Music.MusicUtil", "parseBCDForMusicWrapper %s: expend: %d %d", ati.wdd, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(ati.wub));
            }
        }
        return ati;
    }

    public static String i(ati ati) {
        if (ati.wHt == 6) {
            return "6_" + ac.VF(ati.wdd);
        }
        return "0_" + ac.VF(ati.wdd);
    }

    public static String Gw(String str) {
        return "piece" + ac.VF(str.hashCode());
    }

    public static void a(ati ati, Activity activity) {
        com.tencent.mm.plugin.report.service.g.pWK.k(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        b cgVar = new cg();
        vn vnVar = new vn();
        vt vtVar = new vt();
        uz uzVar = new uz();
        vtVar.UN(q.FY());
        vtVar.UO(q.FY());
        vtVar.Dl(5);
        vtVar.fD(bi.Wy());
        vtVar.UT(k(ati));
        uzVar.Uc(ati.wHz);
        uzVar.Ud(ati.wHA);
        uzVar.Ub(ati.wHB);
        a Hc = h.beg().Hc(i(ati));
        if (Hc.Qt()) {
            uzVar.Ue(Hc.field_songHAlbumUrl);
        } else {
            uzVar.Ue(Hc.field_songAlbumUrl);
        }
        uzVar.lz(true);
        String j = j(ati);
        if (FileOp.bO(j)) {
            uzVar.Uk(j);
        } else {
            uzVar.lA(true);
        }
        uzVar.TV(ati.wHv);
        uzVar.TW(ati.wHw);
        uzVar.Dc(7);
        cgVar.frk.title = ati.wHv;
        cgVar.frk.desc = ati.wHw;
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 7;
        vnVar.a(vtVar);
        vnVar.wlY.add(uzVar);
        cgVar.frk.activity = activity;
        cgVar.frk.frr = 3;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
    }

    public static boolean b(ati ati, Activity activity) {
        com.tencent.mm.plugin.report.service.g.pWK.k(10910, "4");
        if (ati == null) {
            return false;
        }
        String str;
        String str2 = ati.wHB;
        int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
        if ((indexOf < 0 ? null : str2.substring(indexOf + 3)) == null) {
            x.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", str2);
            str = "androidqqmusic://";
        } else {
            x.i("MicroMsg.Music.MusicUtil", "get qq music data %s", indexOf < 0 ? null : str2.substring(indexOf + 3));
            str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            x.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", str);
            return false;
        }
        com.tencent.mm.au.b.Qv();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bi.k(activity, intent)) {
            activity.startActivity(intent);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", str2);
        b.ihN.j(intent, activity);
        return false;
    }

    public static void A(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        d.a((Context) activity, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    public static void a(ati ati, Intent intent, MMActivity mMActivity) {
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = ati.wHB;
        wXMusicObject.musicDataUrl = ati.wHz;
        wXMusicObject.musicLowBandUrl = ati.wHA;
        wXMusicObject.musicLowBandDataUrl = ati.wHA;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = ati.wHv;
        wXMediaMessage.description = ati.wHw;
        Bitmap bitmap = null;
        String j = j(ati);
        if (j != null && FileOp.bO(j)) {
            int dimension = (int) mMActivity.getResources().getDimension(R.f.bvE);
            bitmap = com.tencent.mm.sdk.platformtools.d.ab(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bi.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bi.U(com.tencent.mm.sdk.platformtools.d.Ds(R.g.bBE));
        }
        b.ihN.a(mMActivity, k(ati), wXMediaMessage, stringExtra, l(ati));
        x.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", stringExtra);
    }

    public static void c(ati ati, Activity activity) {
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = ati.wHB;
        wXMusicObject.musicDataUrl = ati.wHz;
        wXMusicObject.musicLowBandUrl = ati.wHA;
        wXMusicObject.musicLowBandDataUrl = ati.wHA;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = ati.wHv;
        wXMediaMessage.description = ati.wHw;
        Bitmap bitmap = null;
        String j = j(ati);
        if (j != null && FileOp.bO(j)) {
            int dimension = (int) activity.getResources().getDimension(R.f.bvE);
            bitmap = com.tencent.mm.sdk.platformtools.d.ab(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bi.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bi.U(com.tencent.mm.sdk.platformtools.d.Ds(R.g.bBE));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", ati.wdd);
        intent.putExtra("Ksnsupload_appid", k(ati));
        intent.putExtra("Ksnsupload_appname", l(ati));
        String hC = u.hC("music_player");
        u.GQ().t(hC, true).o("prePublishId", "music_player");
        intent.putExtra("reportSessionId", hC);
        b.ihN.n(intent, (Context) activity);
    }

    private static String j(ati ati) {
        String str = "";
        a Hc = h.beg().Hc(i(ati));
        if (Hc != null) {
            str = c(Hc, true);
            if (!FileOp.bO(str)) {
                switch (ati.wHt) {
                    case 0:
                        str = o.PC().B(ati.wHD, true);
                        break;
                    case 4:
                        str = com.tencent.mm.pluginsdk.q.a.bYL().JK(ati.wHy);
                        if (bi.oN(str)) {
                            str = ati.wHD;
                            break;
                        }
                        break;
                    case 5:
                        if (ati.wHD != null) {
                            str = ati.wHD;
                            break;
                        }
                        str = "";
                        break;
                    case 6:
                        if (ati.wHD != null) {
                            str = ati.wHD;
                            break;
                        }
                        str = "";
                        break;
                    case 7:
                    case 10:
                    case 11:
                        if (ati.wHD != null) {
                            str = ati.wHD;
                            break;
                        }
                        str = "";
                        break;
                    default:
                        if (n.qWC != null) {
                            are are = new are();
                            are.nMq = ati.wgu;
                            are.wEP = ati.wHy;
                            are.wEQ = ati.wHF;
                            are.nlE = are.wEP;
                            str = n.qWB.a(are);
                            break;
                        }
                        break;
                }
            }
            x.i("MicroMsg.Music.MusicUtil", "real album path = %s", str);
        }
        return str;
    }

    public static String k(ati ati) {
        String str = ati.nlV;
        if (!bi.oN(str)) {
            return str;
        }
        switch (ati.wHt) {
            case 4:
                return "wx485a97c844086dc9";
            case 5:
                return "wx482a4001c37e2b74";
            default:
                return str;
        }
    }

    private static String l(ati ati) {
        switch (ati.wHt) {
            case 0:
            case 1:
            case 8:
                return ad.getContext().getString(R.l.eQl);
            case 4:
                return ad.getContext().getString(R.l.eOU);
            case 5:
                return ad.getContext().getString(R.l.eIe);
            default:
                return ad.getContext().getString(R.l.dYv);
        }
    }

    public static void B(Activity activity) {
        as.Hm();
        if (((Boolean) c.Db().get(82, Boolean.valueOf(true))).booleanValue()) {
            as.Hm();
            c.Db().set(82, Boolean.valueOf(false));
            switch (h.bef().bdU().field_musicType) {
                case 0:
                    I(activity, R.l.eOu);
                    return;
                case 1:
                case 8:
                    I(activity, R.l.eOx);
                    return;
                case 4:
                    I(activity, R.l.eOw);
                    return;
                case 6:
                    I(activity, R.l.eOv);
                    return;
                default:
                    return;
            }
        } else if (h.bef().mode == 2) {
            Toast.makeText(ad.getContext(), R.l.eQG, 0).show();
        } else {
            Toast.makeText(ad.getContext(), R.l.eQH, 0).show();
        }
    }

    public static boolean tJ(int i) {
        switch (i) {
            case 10:
            case 11:
                return true;
            default:
                return com.tencent.mm.plugin.music.model.g.g.tY(i);
        }
    }

    public static boolean m(ati ati) {
        if (ati == null || TextUtils.isEmpty(ati.protocol)) {
            return false;
        }
        x.d("MicroMsg.Music.MusicUtil", "protocol:%s", ati.protocol);
        if ("hls".equalsIgnoreCase(ati.protocol)) {
            return true;
        }
        return false;
    }

    public static boolean e(a aVar) {
        if (aVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.field_songWifiUrl) && TextUtils.isEmpty(aVar.field_songWapLinkUrl) && TextUtils.isEmpty(aVar.field_songWebUrl)) {
            return false;
        }
        return true;
    }

    public static void E(String str, String str2, int i) {
        x.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", str, str2, Integer.valueOf(i));
        b qrVar = new qr();
        qrVar.fJd.appId = str;
        qrVar.fJd.fJh = -1;
        qrVar.fJd.fJg = i;
        qrVar.fJd.userName = str2;
        qrVar.fJd.scene = 1056;
        if (i == 1) {
            qrVar.fJd.fJj = true;
        }
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    private static i I(Context context, int i) {
        i.a aVar = new i.a(context);
        aVar.ES(R.l.dGZ);
        aVar.ET(i);
        aVar.EV(R.l.ewC).a(null);
        aVar.mp(true);
        i ale = aVar.ale();
        ale.show();
        return ale;
    }

    public static int ck(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.length() <= 0 ? 0 : Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getInt", new Object[0]);
            return 0;
        }
    }
}
