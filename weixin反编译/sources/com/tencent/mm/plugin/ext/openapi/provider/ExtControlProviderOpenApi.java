package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.ac.n;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.eu;
import com.tencent.mm.f.a.ex;
import com.tencent.mm.f.a.ff;
import com.tencent.mm.f.a.qu;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import org.xwalk.core.R;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    public static boolean mfD = false;
    private static final String[] mfE = new String[]{"retCode", "selfId"};
    private static final String[] mfF = new String[]{"retCode", "sportConfig"};
    private static final String[] mfG = new String[]{"openid", "avatar"};
    private static final String[] mfH = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", DownloadInfoColumns.FILEPATH};
    private static final String[] mfI = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private Context context;
    private ag handler;
    private String[] mfJ = null;
    private int mfK = -1;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.mfJ = strArr;
        this.mfK = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        this.handler = new ag();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.mfK));
        a(uri, this.context, this.mfK, this.mfJ);
        String str3 = this.mfS;
        if (uri == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            cw(3, 5);
            return a.BQ(5);
        } else if (bi.oN(this.mfS)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            cw(3, 7);
            return a.BQ(7);
        } else if (bi.oN(aGt())) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            cw(3, 6);
            return a.BQ(6);
        } else if (arF()) {
            int i = 1;
            if (!mfD) {
                i = aGu();
            }
            if (i != 1) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + i);
                cw(2, i);
                return a.BQ(i);
            }
            String str4;
            String str5;
            Intent intent;
            final String[] strArr3;
            long j;
            Intent intent2;
            switch (this.mfK) {
                case 22:
                    return h(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                case 23:
                    return k(strArr2);
                case 25:
                    return l(strArr2);
                case 34:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        str3 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        x.e(str3, str4, objArr);
                        cw(3, 3401);
                        return a.BQ(3401);
                    }
                    Object obj;
                    str5 = strArr2[0];
                    if (bi.oN(str5) || !e.bO(str5)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str5, cVar.qzi, cVar.qzj, cVar.qzk, cVar.qzm, cVar.qzl, cVar.qzl.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        cw(3, 3402);
                        return a.BQ(3402);
                    }
                    intent = new Intent();
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    d.a(this.context, ".ui.transmit.SightForwardUI", intent);
                    J(12, 0, 1);
                    return a.BQ(1);
                case 35:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || bi.oN(strArr2[0])) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        cw(3, 3201);
                        return a.BQ(3201);
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", strArr2[0]);
                    i = new com.tencent.mm.plugin.ext.b.c(this.context, str5).aGp();
                    x.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(i));
                    if (i != -1) {
                        J(14, 0, i);
                        i = 0;
                    } else {
                        J(15, 0, i);
                    }
                    return a.BQ(i);
                case 36:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        cw(3, 3301);
                        return a.BQ(3301);
                    }
                    str5 = strArr2[0];
                    int i2 = bi.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str5, Integer.valueOf(i2), str4);
                    if (bi.oN(str5) || i2 < 0 || bi.oN(str4)) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        cw(3, 3302);
                        return a.BQ(3302);
                    }
                    b quVar = new qu();
                    quVar.fJs.fJt = str5;
                    quVar.fJs.fJu = i2;
                    quVar.fJs.fJv = str4;
                    quVar.fJs.bgo = com.tencent.mm.pluginsdk.a.g(str5, this.context);
                    com.tencent.mm.sdk.b.a.xmy.m(quVar);
                    J(16, 0, 1);
                    return a.BQ(1);
                case 37:
                    x.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME);
                    this.handler = new ag(Looper.getMainLooper());
                    strArr3 = strArr2;
                    MatrixCursor matrixCursor = (MatrixCursor) new bd<MatrixCursor>() {
                        protected final /* synthetic */ Object run() {
                            return aGr();
                        }

                        private MatrixCursor aGr() {
                            try {
                                x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b exVar = new ex();
                                exVar.fuF.fuH = strArr3;
                                exVar.frD = new Runnable() {
                                    public final void run() {
                                        x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (exVar != null && exVar.fuG != null && exVar.fuG.fum != 0) {
                                            x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                            AnonymousClass1.this.bY(exVar.fuG.fuI);
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.xmy.m(exVar)) {
                                    x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    bY(a.BQ(8));
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
                                bY(a.BQ(12));
                            }
                            return null;
                        }
                    }.b(this.handler);
                    if (matrixCursor == null) {
                        J(19, 4, 14);
                        return a.BQ(14);
                    }
                    J(18, 0, 1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    return matrixCursor;
                case 38:
                    x.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.NAME);
                    this.handler = new ag(Looper.getMainLooper());
                    strArr3 = strArr2;
                    Integer num = (Integer) new bd<Integer>() {
                        protected final /* synthetic */ Object run() {
                            return VF();
                        }

                        private Integer VF() {
                            try {
                                x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b euVar = new eu();
                                euVar.fuj.version = bi.getInt(strArr3[0], 0);
                                euVar.fuj.ssid = strArr3[1];
                                euVar.fuj.bssid = strArr3[2];
                                euVar.fuj.ful = bi.getInt(strArr3[3], 0);
                                euVar.frD = new Runnable() {
                                    public final void run() {
                                        x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (euVar != null && euVar.fuk != null && euVar.fuk.fum != 0) {
                                            x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(euVar.fuk.fun), euVar.fuk.fuo);
                                            AnonymousClass2.this.bY(Integer.valueOf(euVar.fuk.fun));
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.xmy.m(euVar)) {
                                    x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    bY(Integer.valueOf(8));
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
                                bY(Integer.valueOf(12));
                            }
                            return Integer.valueOf(0);
                        }
                    }.b(this.handler);
                    if (num == null) {
                        J(21, 4, 14);
                        return a.BQ(14);
                    }
                    J(20, 0, num.intValue());
                    return a.BQ(num.intValue());
                case 40:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        J(23, 3, 2);
                        return a.BQ(2);
                    }
                    long j2 = bi.getLong(strArr2[0], -1);
                    j = bi.getLong(strArr2[1], -1);
                    long j3 = bi.getLong(strArr2[2], -1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                    if (j < 0 || j2 < 0 || j3 < 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        J(23, 3, 2);
                        return a.BQ(2);
                    }
                    aGq();
                    b ffVar = new ff();
                    ffVar.fvd.action = 2;
                    ffVar.fvd.fvf = j;
                    ffVar.fvd.fvg = j2;
                    ffVar.fvd.fvh = j3;
                    if (com.tencent.mm.sdk.b.a.xmy.m(ffVar) && ffVar.fve.fvj) {
                        J(22, 0, ffVar.fve.fvk);
                        return a.BQ(ffVar.fve.fvk);
                    }
                    J(23, 4, 8);
                    return a.BQ(8);
                case 41:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    aGq();
                    b ffVar2 = new ff();
                    ffVar2.fvd.action = 3;
                    if (com.tencent.mm.sdk.b.a.xmy.m(ffVar2) && ffVar2.fve.fvj) {
                        str4 = ffVar2.fve.fvi;
                        Cursor matrixCursor2 = new MatrixCursor(mfF);
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(ffVar2.fve.fvk), bi.oM(str4)});
                        J(22, 0, ffVar2.fve.fvk);
                        x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(ffVar2.fve.fvk));
                        return matrixCursor2;
                    }
                    J(23, 4, 8);
                    return a.BQ(8);
                case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                    intent2 = new Intent();
                    intent2.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", str3);
                    } else {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", strArr2[0], str3);
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str3);
                    d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    g.pWK.h(12097, Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    J(24, 0, 1);
                    return a.BQ(1);
                case 46:
                    x.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", str3);
                    as.Hm();
                    if (com.tencent.mm.y.c.isSDCardAvailable()) {
                        intent2 = new Intent();
                        intent2.putExtra("key_from_openapi", true);
                        intent2.putExtra("key_openapi_appid", str3);
                        d.b(this.context, "clean", ".ui.CleanUI", intent2);
                        J(26, 0, 1);
                        return a.BQ(1);
                    }
                    J(27, 5, 4);
                    return a.BQ(4101);
                case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    com.tencent.mm.plugin.ext.c.e.aGE().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        return a.BQ(4201);
                    }
                    int i3 = bi.getInt(strArr2[0], -1);
                    if (i3 < 0 || !(i3 == 0 || i3 == 1 || i3 == 2)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        J(32, 3, 2);
                        return a.BQ(4201);
                    }
                    str5 = null;
                    if (i3 != 0 && i3 != 1) {
                        str4 = null;
                    } else if (strArr2.length < 2) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        return a.BQ(4205);
                    } else {
                        str3 = strArr2[1];
                        if (i3 != 1) {
                            str4 = str3;
                        } else if (strArr2.length < 3) {
                            x.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            return a.BQ(4208);
                        } else {
                            str5 = strArr2[2];
                            str4 = str3;
                        }
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", Integer.valueOf(i3), str4);
                    com.tencent.mm.plugin.ext.c.e.a Ai;
                    switch (i3) {
                        case 0:
                            com.tencent.mm.plugin.ext.c.e aGE = com.tencent.mm.plugin.ext.c.e.aGE();
                            if (bi.oN(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                com.tencent.mm.plugin.ext.c.e.G(null, -1, 4205);
                                return a.BQ(4205);
                            }
                            com.tencent.mm.plugin.ext.c.e.a aVar;
                            Ai = com.tencent.mm.plugin.ext.c.c.Ai(str4);
                            if (Ai == null || bi.oN(Ai.url)) {
                                b al = com.tencent.mm.plugin.ext.c.e.al(str4, false);
                                if (al == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    com.tencent.mm.plugin.ext.c.e.G(null, -1, 4206);
                                    return a.BQ(4206);
                                }
                                Ai = aGE.a(al);
                                if (Ai == null || bi.oN(Ai.url)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    return a.BQ(4203);
                                }
                                aVar = Ai;
                            } else {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Ai);
                                aVar = Ai;
                            }
                            if (aVar.type != 19) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                return a.BQ(1);
                            } else if (com.tencent.mm.plugin.ext.c.c.Ak(aVar.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", aVar.url.toUpperCase());
                                com.tencent.mm.plugin.ext.c.e.G(aVar.url, aVar.type, 4207);
                                return a.RT(aVar.url);
                            } else if (com.tencent.mm.plugin.ext.c.c.Aj(aVar.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", aVar.url);
                                com.tencent.mm.plugin.ext.c.e.G(aVar.url, aVar.type, 1);
                                return a.BQ(1);
                            } else {
                                j = bi.Wz();
                                b Al = com.tencent.mm.plugin.ext.c.c.Al(aVar.url);
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", Al.toString(), Long.valueOf(bi.bB(j)));
                                if (Al == b.WHITE) {
                                    com.tencent.mm.plugin.ext.c.c.Ag(aVar.url);
                                    com.tencent.mm.plugin.ext.c.e.G(aVar.url, aVar.type, 1);
                                    return a.BQ(1);
                                }
                                if (Al != b.BLACK) {
                                    String str6 = aVar.url;
                                    int i4 = aVar.type;
                                    int i5 = aVar.mhf;
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", str6);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", (Boolean) new com.tencent.mm.plugin.ext.c.e.AnonymousClass2(Boolean.valueOf(true), str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.aGG()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    if (((Boolean) new com.tencent.mm.plugin.ext.c.e.AnonymousClass2(Boolean.valueOf(true), str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.aGG())).booleanValue()) {
                                        com.tencent.mm.plugin.ext.c.c.Ag(aVar.url);
                                        com.tencent.mm.plugin.ext.c.e.G(aVar.url, aVar.type, 1);
                                        return a.BQ(1);
                                    }
                                }
                                com.tencent.mm.plugin.ext.c.c.Ah(aVar.url);
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", aVar.url);
                                com.tencent.mm.plugin.ext.c.e.G(aVar.url, aVar.type, 4207);
                                return a.RT(aVar.url);
                            }
                        case 1:
                            com.tencent.mm.plugin.ext.c.e aGE2 = com.tencent.mm.plugin.ext.c.e.aGE();
                            if (bi.oN(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
                                com.tencent.mm.plugin.ext.c.e.H(null, -1, 4205);
                                return a.BQ(4205);
                            }
                            com.tencent.mm.plugin.ext.c.e.a Ai2 = com.tencent.mm.plugin.ext.c.c.Ai(str4);
                            if (Ai2 != null && !bi.oN(Ai2.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Ai2);
                                Ai = Ai2;
                            } else if (bi.oN(str5)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
                                com.tencent.mm.plugin.ext.c.e.H(null, -1, 4208);
                                return a.BQ(4208);
                            } else {
                                b al2 = com.tencent.mm.plugin.ext.c.e.al(str4, true);
                                if (al2 == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
                                    com.tencent.mm.plugin.ext.c.e.H(null, -1, 4206);
                                    return a.BQ(4206);
                                } else if (bi.oN(al2.frM)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
                                    com.tencent.mm.plugin.ext.c.e.H(null, -1, 4210);
                                    return a.BQ(4210);
                                } else if (al2.frM.equalsIgnoreCase(str5)) {
                                    Ai = aGE2.a(al2);
                                    if (Ai == null || bi.oN(Ai.url)) {
                                        x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                        com.tencent.mm.plugin.ext.c.e.H(null, -1, 4203);
                                        return a.BQ(4203);
                                    }
                                    com.tencent.mm.plugin.ext.c.c.a(str4, Ai);
                                } else {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
                                    com.tencent.mm.plugin.ext.c.e.H(null, -1, 4209);
                                    return a.BQ(4209);
                                }
                            }
                            if (Ai.type == 19 && com.tencent.mm.plugin.ext.c.c.Ak(Ai.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", Ai.url);
                                com.tencent.mm.plugin.ext.c.e.H(Ai.url, Ai.type, 4207);
                                return a.BQ(4207);
                            }
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", Ai.toString());
                            intent = new Intent(aGE2.mContext, RedirectToQrCodeStubUI.class);
                            intent.putExtra("K_STR", Ai.url);
                            intent.putExtra("K_TYPE", Ai.type);
                            intent.putExtra("K_VERSION", Ai.mhf);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            aGE2.mContext.startActivity(intent);
                            com.tencent.mm.plugin.ext.c.e.H(Ai.url, Ai.type, 1);
                            return a.BQ(1);
                        case 2:
                            com.tencent.mm.plugin.ext.c.e.aGE();
                            return com.tencent.mm.plugin.ext.c.e.aGF();
                        default:
                            return null;
                    }
                default:
                    cw(3, 15);
                    return null;
            }
        } else {
            x.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            cw(1, 3);
            return a.BQ(3);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor h(String str, String str2, String str3, String str4) {
        int i = -1;
        x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
        if (this.context == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            cw(4, 2001);
            return a.BQ(2001);
        } else if (bi.oN(str)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            cw(3, 2002);
            return a.BQ(2002);
        } else {
            try {
                i = bi.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                return L(str2, str3, str4);
            }
            if (i == 2) {
                x.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.aGi().Yj(this.mfS) == null) {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.mfS, aGt());
                    return a.BQ(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                }
                boolean z;
                bb aGi = com.tencent.mm.plugin.ext.b.aGi();
                String str5 = this.mfS;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    z = aGi.gLA.delete("OpenMsgListener", "appId=?", new String[]{bi.oL(str5)}) > 0;
                }
                x.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.mfS, aGt());
                if (!z) {
                    return a.BQ(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER);
                }
                J(0, 0, 1);
                return a.BQ(1);
            }
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i));
            cw(3, 2003);
            return a.BQ(2003);
        }
    }

    private Cursor L(String str, String str2, String str3) {
        Exception e;
        x.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (bi.oN(str) || bi.oN(str2) || bi.oN(str3)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", str, str2, str3);
            cw(3, TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
            return a.BQ(TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
        }
        MatrixCursor matrixCursor = null;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + parseInt);
                cw(3, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                return a.BQ(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
            }
            if (com.tencent.mm.plugin.ext.b.aGi().Yj(this.mfS) == null) {
                com.tencent.mm.sdk.e.c baVar = new ba();
                baVar.field_appId = this.mfS;
                baVar.field_packageName = aGt();
                String str4 = this.mfS;
                if (bi.oN(str4) ? false : com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.aZ(str4, true))) {
                    baVar.field_status = 1;
                } else {
                    baVar.field_status = 0;
                }
                baVar.field_sceneFlag = parseInt2;
                baVar.field_msgTypeFlag = parseInt3;
                baVar.field_msgState = parseInt;
                x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", Boolean.valueOf(com.tencent.mm.plugin.ext.b.aGi().b(baVar)), aGt(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(baVar.field_status));
                if (!com.tencent.mm.plugin.ext.b.aGi().b(baVar)) {
                    return a.BQ(TXLiveConstants.PLAY_EVT_PLAY_END);
                }
            }
            x.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", this.mfS, aGt());
            StringBuilder append = new StringBuilder().append(q.FY());
            as.Hm();
            String VF = ac.VF(append.append(com.tencent.mm.y.c.Cn()).toString());
            Cursor matrixCursor2 = new MatrixCursor(mfE);
            try {
                matrixCursor2.addRow(new Object[]{Integer.valueOf(1), bi.oM(VF)});
                J(0, 0, 1);
                x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(1));
                return matrixCursor2;
            } catch (Exception e2) {
                Exception exception = e2;
                Cursor matrixCursor3 = matrixCursor2;
                e = exception;
            }
        } catch (Exception e3) {
            e = e3;
            J(1, 4, 12);
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", e.getMessage());
            if (matrixCursor3 != null) {
                matrixCursor3.close();
            }
            return a.BQ(12);
        }
    }

    private Cursor k(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            cw(3, 3001);
            return a.BQ(3001);
        }
        Cursor matrixCursor = new MatrixCursor(mfG);
        int i = 0;
        while (i < strArr.length && i < 5) {
            if (!bi.oN(strArr[i])) {
                bj Yt = com.tencent.mm.plugin.ext.b.aGj().Yt(strArr[i]);
                if (Yt == null || bi.oN(Yt.field_openId) || bi.oN(Yt.field_username)) {
                    x.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                } else {
                    as.Hm();
                    com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(Yt.field_username);
                    if (Xv == null || Xv.field_username == null || Xv.field_username.length() <= 0) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                    } else {
                        try {
                            n.JF();
                            String x = com.tencent.mm.ac.d.x(Xv.field_username, false);
                            if (bi.oN(x)) {
                                x.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str = Xv.field_username;
                                com.tencent.mm.ac.d.b.jl(x);
                                if (FileOp.mg(x)) {
                                    matrixCursor.addRow(new Object[]{strArr[i], x});
                                } else {
                                    x.w("MicroMsg.ExtControlProviderOpenApi", "hy: copy or replace avatar from sfs to file system failed");
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e.getMessage());
                            J(7, 4, 12);
                            matrixCursor.close();
                            return a.BQ(12);
                        }
                    }
                }
            }
            i++;
        }
        J(6, 0, 1);
        return matrixCursor;
    }

    private Cursor l(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            cw(3, 3101);
            return a.BQ(3101);
        }
        MatrixCursor matrixCursor = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (o.g(str, 0, true)) {
                    String ax;
                    if (matrixCursor == null) {
                        matrixCursor = new MatrixCursor(mfH);
                    }
                    i iVar = new i();
                    String str2 = com.tencent.mm.plugin.ext.b.aGl() + "/" + ac.VF(str);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", str2);
                    if (!e.bO(str2) || bN(str2) == 0) {
                        ax = iVar.ax(str, str2);
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        ax = str2;
                    }
                    if (bN(str2) == 0) {
                        ax = iVar.ax(str, str2);
                    }
                    if (bi.oN(ax)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i));
                        matrixCursor.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.mSampleRate), Integer.valueOf(iVar.fli), Integer.valueOf(2), ax});
                    }
                } else {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i]);
                }
            } catch (Exception e) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e.getMessage());
            }
            i++;
        }
        if (matrixCursor != null) {
            J(8, 0, 1);
            return matrixCursor;
        }
        J(9, 3, 4);
        return a.BQ(4);
    }

    private static int bN(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    private void aGq() {
        String str = (String) com.tencent.mm.plugin.ext.b.aGh().get(w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        x.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, aGt());
        if (str == null) {
            com.tencent.mm.plugin.ext.b.aGh().a(w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, aGt());
        } else if (!com.tencent.mm.compatible.loader.a.a(str.split(";"), r1)) {
            com.tencent.mm.plugin.ext.b.aGh().a(w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + aGt());
        }
    }
}
