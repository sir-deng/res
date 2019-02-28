package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bz;
import com.tencent.mm.f.a.es;
import com.tencent.mm.f.a.et;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.h;
import com.tencent.mm.f.a.ie;
import com.tencent.mm.f.a.oe;
import com.tencent.mm.f.a.of;
import com.tencent.mm.f.a.og;
import com.tencent.mm.f.a.tk;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.xwalk.core.R;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String PREF_NAME = (ad.getPackageName() + "_comm_preferences");
    private static final String[] kAK = new String[]{DownloadInfoColumns.PACKAGENAME, SlookAirButtonFrequentContactAdapter.DATA};
    private static final UriMatcher kAM = new UriMatcher(-1);
    private static volatile boolean kAN = false;
    protected static boolean kAO = false;
    private static final Object lock = new Object();
    private ag handler;
    private SharedPreferences hbz;
    protected MatrixCursor kAL = new MatrixCursor(new String[0]);

    static {
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", c.NAME, 37);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", a.NAME, 38);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
        kAM.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
    }

    public boolean onCreate() {
        x.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new ag();
        x.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.hbz = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                ap apVar;
                if (System.currentTimeMillis() - ap.vmm >= 600000) {
                    x.e("MicroMsg.AppUtil", "hy: get comm model time expired");
                    apVar = null;
                } else {
                    apVar = ap.vml;
                }
                if (apVar != null) {
                    x.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                    Cursor a = WXCommProvider.this.a(apVar.uri, apVar.projection, apVar.selection, apVar.selectionArgs, apVar.vmj, apVar.code, apVar.vmk);
                    if (a != null) {
                        a.close();
                    }
                    p.bZz();
                }
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.hbz != null) {
            return true;
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            return null;
        }
        String[] arD = arD();
        if (arD == null || arD.length <= 0) {
            x.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            return null;
        }
        int match = kAM.match(uri);
        if (com.tencent.mm.sdk.b.a.xmy == null) {
            new al(Looper.getMainLooper(), new al.a() {
                public final boolean uG() {
                    if (com.tencent.mm.sdk.b.a.xmy == null || !com.tencent.mm.sdk.b.a.xmy.B(es.class)) {
                        return true;
                    }
                    synchronized (WXCommProvider.lock) {
                        x.i("MicroMsg.WXCommProvider", "The lock was released.");
                        WXCommProvider.kAN = true;
                        WXCommProvider.lock.notifyAll();
                    }
                    return false;
                }
            }, true).K(50, 50);
            try {
                synchronized (lock) {
                    x.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    while (!kAN) {
                        lock.wait();
                    }
                    kAN = false;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            }
        }
        return a(uri, strArr, str, strArr2, str2, match, arD);
    }

    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        Cursor matrixCursor;
        b etVar;
        b tkVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case R.styleable.AppCompatTheme_dialogTheme /*42*/:
            case 46:
            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                long currentTimeMillis = System.currentTimeMillis();
                if (arF()) {
                    b ezVar = new ez();
                    ezVar.fuM.fuh = i;
                    ezVar.fuM.uri = uri;
                    ezVar.fuM.selectionArgs = strArr2;
                    ezVar.fuM.context = getContext();
                    ezVar.fuM.fnP = strArr3;
                    if (com.tencent.mm.sdk.b.a.xmy.m(ezVar)) {
                        x.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return ezVar.fuN.fui;
                    }
                    x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.mfw);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(8)});
                    return matrixCursor;
                }
                String oM = bi.oM(uri.getQueryParameter("appid"));
                if ("1".equals(bi.aD(uri.getQueryParameter("autoLogin"), "0"))) {
                    x.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    ap.vml = new ap(uri, strArr, str, strArr2, str2, i, strArr3);
                    ap.vmm = System.currentTimeMillis();
                    d.b(getContext(), "accountsync", "com.tencent.mm.ui.account.LoginUI", new Intent());
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.mfw);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(9)});
                    return matrixCursor;
                }
                x.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", oM, Integer.valueOf(i), Integer.valueOf(3));
                g.pWK.h(10505, bi.oM(strArr3[0]), oM, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.mfw);
                matrixCursor.addRow(new Object[]{Integer.valueOf(3)});
                return matrixCursor;
            case 18:
            case 19:
            case 20:
                if (!arE()) {
                    return null;
                }
                etVar = new et();
                etVar.fuf.fuh = i;
                etVar.fuf.uri = uri;
                etVar.fuf.selectionArgs = strArr2;
                etVar.fuf.context = getContext();
                etVar.fuf.fnP = strArr3;
                if (com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    return etVar.fug.fui;
                }
                x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                return null;
            case 21:
                etVar = new es();
                etVar.fud.op = 21;
                etVar.fud.cPf = 1;
                etVar.fud.selectionArgs = strArr2;
                etVar.fud.context = getContext();
                etVar.fud.fnP = strArr3;
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 24:
                if (!arE()) {
                    return this.kAL;
                }
                tkVar = new tk();
                tkVar.fMG.fuh = i;
                tkVar.fMG.uri = uri;
                tkVar.fMG.context = getContext();
                for (int i2 = 0; i2 < strArr3.length; i2++) {
                    if (strArr3[i2] != null) {
                        tkVar.fMG.fMI = strArr3[i2];
                        if (!com.tencent.mm.sdk.b.a.xmy.m(tkVar)) {
                            return tkVar.fMH.fui;
                        }
                        x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                        return null;
                    }
                }
                if (!com.tencent.mm.sdk.b.a.xmy.m(tkVar)) {
                    return tkVar.fMH.fui;
                }
                x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                return null;
            case 26:
                etVar = new h();
                etVar.fnO.selectionArgs = strArr2;
                etVar.fnO.fnP = strArr3;
                etVar.fnO.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    x.e("MicroMsg.WXCommProvider", "wrong args");
                    return null;
                }
                etVar = new es();
                etVar.fud.op = 27;
                etVar.fud.cPf = 1;
                etVar.fud.selectionArgs = strArr2;
                etVar.fud.context = getContext();
                etVar.fud.fnP = strArr3;
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 28:
                etVar = new es();
                etVar.fud.op = i;
                etVar.fud.selectionArgs = strArr2;
                etVar.fud.context = getContext();
                etVar.fud.fnP = strArr3;
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 30:
            case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                tkVar = new og();
                tkVar.fGV.selectionArgs = strArr2;
                tkVar.fGV.fnP = strArr3;
                tkVar.fGV.context = getContext();
                tkVar.fGV.fGW = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    com.tencent.mm.pluginsdk.d.viN = strArr2[2];
                }
                if (!com.tencent.mm.sdk.b.a.xmy.m(tkVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 31:
                etVar = new of();
                etVar.fGU.selectionArgs = strArr2;
                etVar.fGU.fnP = strArr3;
                etVar.fGU.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                return null;
            case 32:
                etVar = new bz();
                etVar.fqU.action = 1;
                etVar.fqU.selectionArgs = strArr2;
                etVar.fqU.fnP = strArr3;
                etVar.fqU.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 33:
                etVar = new bz();
                etVar.fqU.action = 2;
                etVar.fqU.selectionArgs = strArr2;
                etVar.fqU.fnP = strArr3;
                etVar.fqU.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 39:
                etVar = new com.tencent.mm.f.a.bi();
                etVar.fqx.selectionArgs = strArr2;
                etVar.fqx.fnP = strArr3;
                etVar.fqx.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                return null;
            case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                etVar = new ie();
                etVar.fzw.selectionArgs = strArr2;
                etVar.fzw.fnP = strArr3;
                etVar.fzw.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    ah.h(new Runnable() {
                        public final void run() {
                            if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                                x.e("MicroMsg.WXCommProvider", "handle scan result failed again");
                            }
                        }
                    }, 200);
                }
                return null;
            case 47:
                etVar = new oe();
                etVar.fGT.selectionArgs = strArr2;
                etVar.fGT.fnP = strArr3;
                etVar.fGT.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xmy.m(etVar)) {
                    x.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                return null;
            default:
                final MatrixCursor matrixCursor2 = new MatrixCursor(kAK);
                final Uri uri2 = uri;
                final int i3 = i;
                final String[] strArr4 = strArr3;
                matrixCursor = (Cursor) new bd<Cursor>() {
                    protected final /* synthetic */ Object run() {
                        x.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri2.toString(), Integer.valueOf(i3));
                        if (i3 != 1) {
                            x.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i3));
                            return null;
                        }
                        for (String string : strArr4) {
                            String string2 = WXCommProvider.this.hbz.getString(string, "");
                            matrixCursor2.addRow(new String[]{string, string2});
                        }
                        x.d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor2.getCount()));
                        return matrixCursor2;
                    }
                }.b(this.handler);
                if (matrixCursor != null) {
                    return matrixCursor;
                }
                matrixCursor2.close();
                return matrixCursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            return 0;
        }
        final int match = kAM.match(uri);
        final String[] arD = arD();
        final Uri uri2 = uri;
        return ((Integer) new bd<Integer>(Integer.valueOf(0)) {
            protected final /* synthetic */ Object run() {
                x.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri2.toString(), Integer.valueOf(match));
                if (match != 1) {
                    x.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    return null;
                }
                int i = 0;
                for (String str : arD) {
                    if (!bi.oN(str)) {
                        int i2 = (WXCommProvider.this.hbz.contains(str) && WXCommProvider.this.hbz.edit().remove(str).commit()) ? 1 : 0;
                        if (i2 != 0) {
                            i++;
                        }
                    }
                }
                x.d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i));
                return Integer.valueOf(i);
            }
        }.b(this.handler)).intValue();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] arD() {
        try {
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            x.i(str, str2, objArr);
            if (packagesForUid == null) {
                x.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                return new String[0];
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                x.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            return packagesForUid;
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            return new String[0];
        }
    }

    private boolean arE() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (kAO || ((Boolean) new bd<Boolean>(Boolean.valueOf(false)) {
                protected final /* synthetic */ Object run() {
                    return ajW();
                }

                private Boolean ajW() {
                    try {
                        x.i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (!as.Hp()) {
                            return Boolean.valueOf(false);
                        }
                        x.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                        return Boolean.valueOf(as.CN().a(new be(new be.a() {
                            public final void a(e eVar) {
                                x.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.kAO));
                                AnonymousClass6.this.bY(Boolean.valueOf(true));
                            }
                        }), 0));
                    } catch (Exception e) {
                        x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        bY(Boolean.valueOf(false));
                        return Boolean.valueOf(false);
                    }
                }
            }.b(this.handler)).booleanValue()) {
                if (as.Hp() && as.Ho() && !as.Cz()) {
                    kAO = true;
                } else {
                    kAO = false;
                }
                x.i("MicroMsg.WXCommProvider", "hasLogin = " + kAO);
                return kAO;
            }
            x.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            kAO = false;
            return false;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }

    private boolean arF() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!kAO) {
                final com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
                bVar.b(4000, new Runnable() {
                    public final void run() {
                        try {
                            if (as.Hp()) {
                                as.CN().a(new be(new be.a() {
                                    public final void a(e eVar) {
                                        x.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                                        bVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                        }
                    }
                });
            }
            if (as.Hp() && as.Ho() && !as.Cz()) {
                kAO = true;
            } else {
                kAO = false;
            }
            x.i("MicroMsg.WXCommProvider", "hasLogin = " + kAO);
            return kAO;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }
}
