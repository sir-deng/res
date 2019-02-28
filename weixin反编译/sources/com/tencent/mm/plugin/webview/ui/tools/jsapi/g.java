package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.DatePicker;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.bb.j;
import com.tencent.mm.f.a.am;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.cm;
import com.tencent.mm.f.a.cz;
import com.tencent.mm.f.a.da;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.de;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.a.dh;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.dl;
import com.tencent.mm.f.a.dq;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.f.a.dw;
import com.tencent.mm.f.a.dx;
import com.tencent.mm.f.a.dz;
import com.tencent.mm.f.a.ea;
import com.tencent.mm.f.a.ed;
import com.tencent.mm.f.a.en;
import com.tencent.mm.f.a.fa;
import com.tencent.mm.f.a.fd;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.go;
import com.tencent.mm.f.a.gp;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.f.a.gr;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.f.a.hl;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.f.a.ir;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.f.a.kk;
import com.tencent.mm.f.a.lc;
import com.tencent.mm.f.a.lh;
import com.tencent.mm.f.a.lp;
import com.tencent.mm.f.a.lx;
import com.tencent.mm.f.a.mh;
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.pw;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.qv;
import com.tencent.mm.f.a.ss;
import com.tencent.mm.f.a.ti;
import com.tencent.mm.f.a.tt;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.bqh;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.btl;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bys;
import com.tencent.mm.protocal.c.byt;
import com.tencent.mm.protocal.c.byu;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.protocal.c.cdf;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.at;
import com.tencent.mm.y.q;
import com.tencent.mm.y.t;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class g implements com.tencent.mm.ui.MMActivity.a {
    private static final char[] jXA = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jXB = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final HashSet<String> jnD;
    public static Context tNX;
    public static int tNY = -1;
    private static final LinkedList<Runnable> tOw = new LinkedList();
    private static boolean tOx = false;
    private static a tOy = new a() {
        public final void afS() {
            a.tAC.Dt().F(new Runnable() {
                public final void run() {
                    Runnable runnable = (Runnable) g.tOw.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    x.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
                    g.tOx = false;
                }
            });
        }
    };
    private Context context;
    public e fCC;
    public final int fEg;
    private WXMediaMessage fzX;
    private com.tencent.mm.modelgeo.c gAg = null;
    private Map<String, alg> gAk = new ConcurrentHashMap();
    private ProgressDialog inI = null;
    private com.tencent.mm.sdk.b.c jfV;
    private String kMt = null;
    private ag mNt;
    public boolean mgx = false;
    private ProgressDialog nOr;
    public HashSet<String> nbS;
    private float qez = 0.0f;
    private com.tencent.mm.sdk.b.c qyj = new com.tencent.mm.sdk.b.c<dl>() {
        {
            this.xmG = dl.class.getName().hashCode();
        }

        private boolean a(dl dlVar) {
            if (dlVar != null && (dlVar instanceof dl)) {
                System.currentTimeMillis();
                g.this.tOk;
                g.this.tOk = System.currentTimeMillis();
                String str = dlVar.fsT.fsR;
                int i = dlVar.fsT.fsU;
                int i2 = dlVar.fsT.fsV & 65535;
                double d = dlVar.fsT.fsX;
                double d2 = dlVar.fsT.fsW;
                x.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", str + "," + i + "," + i2 + "," + d);
                String str2 = str + "," + i + "," + i2;
                boolean z = false;
                List<alh> list;
                Iterator it;
                alj alj;
                if (g.this.gAk.containsKey(str2)) {
                    list = (List) g.this.tOh.get(str + "," + i);
                    if (list != null) {
                        for (alh alh : list) {
                            if (alh != null && alh.wzh != null && !alh.wzh.isEmpty()) {
                                it = alh.wzh.iterator();
                                while (it.hasNext()) {
                                    alj = (alj) it.next();
                                    if (i2 >= alj.wzi && i2 <= alj.wzj) {
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                } else {
                    alg alg = new alg();
                    alg.njL = str;
                    alg.major = i;
                    alg.minor = i2;
                    g.this.gAk.put(str2, alg);
                    if (g.this.tOh.containsKey(str + "," + i)) {
                        list = (List) g.this.tOh.get(str + "," + i);
                        if (list != null) {
                            for (alh alh2 : list) {
                                boolean z2;
                                if (!(alh2 == null || alh2.wzh == null || alh2.wzh.isEmpty())) {
                                    Iterator it2 = alh2.wzh.iterator();
                                    while (it2.hasNext()) {
                                        alj = (alj) it2.next();
                                        if (i2 >= alj.wzi && i2 <= alj.wzj) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = z;
                                if (z2) {
                                    z = z2;
                                    break;
                                }
                                z = z2;
                            }
                        }
                    }
                    if (!z) {
                        g.this.tOi.add(alg);
                        String str3 = null;
                        if (!(g.this.tNN == null || g.this.tNN.pug == null)) {
                            Object obj = g.this.tNN.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            str3 = bi.oM(g.this.tNZ.Qf(obj != null ? obj.toString() : ""));
                        }
                        if (!g.this.tOj) {
                            g.this.tOj = true;
                            final k hVar = new h(g.this.tOi, bi.oM(str3));
                            g.this.tOi.clear();
                            as.CN().a(1704, new com.tencent.mm.ad.e() {
                                public final void a(int i, int i2, String str, k kVar) {
                                    if (i == 0 && i2 == 0) {
                                        zh zhVar = (zh) hVar.hGV.hnR.hnY;
                                        if (zhVar.lUc == 0) {
                                            List<alh> list = zhVar.wpW;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            for (alh alh : list) {
                                                List list2;
                                                String str2 = alh.njL + "," + alh.major;
                                                if (g.this.tOh.containsKey(str2)) {
                                                    list2 = (List) g.this.tOh.get(str2);
                                                } else {
                                                    list2 = new ArrayList();
                                                    g.this.tOh.put(str2, list2);
                                                }
                                                list2.add(alh);
                                                stringBuilder.append("{uuid:" + alh.njL + ",major:" + alh.major + ",minors:[");
                                                Iterator it = alh.wzh.iterator();
                                                while (it.hasNext()) {
                                                    alj alj = (alj) it.next();
                                                    stringBuilder.append(alj.wzi + "-" + alj.wzj + ",");
                                                }
                                                stringBuilder.append("]},");
                                            }
                                            x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
                                        }
                                    }
                                    as.CN().b(1704, (com.tencent.mm.ad.e) this);
                                    g.this.tOj = false;
                                }
                            });
                            as.CN().a(hVar, 0);
                        }
                    }
                }
                x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", String.valueOf(z) + "," + str2);
                try {
                    if (g.tNY != -1) {
                        e eVar = g.this.Bs(g.tNY).fCC;
                        if (eVar != null && z) {
                            Bundle bundle = new Bundle();
                            bundle.putString("uuid", str);
                            bundle.putInt("major", i);
                            bundle.putInt("minor", i2);
                            bundle.putDouble("accuracy", d2);
                            bundle.putDouble("rssi", d);
                            bundle.putFloat("heading", g.this.qez);
                            eVar.n(40002, bundle);
                        }
                    }
                } catch (RemoteException e) {
                    x.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", e.getMessage());
                }
                x.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", g.this.gAk.get(str2), Integer.valueOf(g.this.gAk.size()));
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c qyk = new com.tencent.mm.sdk.b.c<dr>() {
        {
            this.xmG = dr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dr drVar = (dr) bVar;
            if (drVar != null && (drVar instanceof dr)) {
                x.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(drVar.fti.ftj));
                if (drVar.fti.ftj != 10 && drVar.fti.ftj == 12 && g.this.tOo) {
                    g.this.a(g.this.tNO, 1);
                }
            }
            return false;
        }
    };
    public i tNN;
    public i tNO;
    public HashSet<String> tNP;
    public Bundle tNQ;
    private String tNR = null;
    public HashMap<String, String> tNS = null;
    public HashMap<String, String> tNT = null;
    public String tNU = null;
    public e tNV;
    private e tNW;
    private c tNZ = null;
    private int tOA = 0;
    private int tOB = 1000;
    public volatile i tOC = null;
    public final com.tencent.mm.sdk.b.c tOD = new com.tencent.mm.sdk.b.c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        private boolean a(jt jtVar) {
            x.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", jtVar.fBu.state);
            int i = (int) (jtVar.fBu.duration / 1000);
            if (jtVar.fBu.fBw) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("background_audio_state_player_state", r2);
                    bundle.putInt("background_audio_state_player_duration", i);
                    if (jtVar.fBu.fBq != null) {
                        bundle.putString("background_audio_state_player_src", jtVar.fBu.fBq.wHz);
                        bundle.putString("background_audio_state_player_src_id", jtVar.fBu.fBq.hJD);
                    }
                    bundle.putInt("background_audio_state_player_err_code", jtVar.fBu.errCode);
                    String str = "";
                    if (!TextUtils.isEmpty(jtVar.fBu.foE)) {
                        str = jtVar.fBu.foE;
                    }
                    bundle.putString("background_audio_state_player_err_msg", str);
                    if (g.this.fCC != null) {
                        x.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
                        g.this.fCC.n(2100, bundle);
                    } else {
                        x.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", e.getMessage());
                    return false;
                }
            }
            x.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
            return false;
        }
    };
    public boolean tOa = false;
    private final j tOb;
    private final com.tencent.mm.plugin.webview.modeltools.d tOc;
    private long tOd = 0;
    private int tOe;
    private int tOf = -1;
    private Map<String, String> tOg = new ConcurrentHashMap();
    private Map<String, List<alh>> tOh = new ConcurrentHashMap();
    private List<alg> tOi = new CopyOnWriteArrayList();
    private boolean tOj = false;
    private long tOk = 0;
    LocationManager tOl = null;
    private String tOm = "-1000.0";
    private String tOn = "-1000.0";
    private boolean tOo = false;
    private SensorEventListener tOp = new SensorEventListener() {
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                g.this.qez = sensorEvent.values[0];
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private com.tencent.mm.modelgeo.a.b tOq = null;
    public i tOr;
    public com.tencent.mm.sdk.b.c tOs = new com.tencent.mm.sdk.b.c<qv>() {
        {
            this.xmG = qv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qv qvVar = (qv) bVar;
            if (qvVar != null && (qvVar instanceof qv)) {
                x.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", Integer.valueOf(qvVar.fJw.status));
                g.b(g.this, qvVar.fJw.status);
            }
            return false;
        }
    };
    public final Map<String, b> tOt = new HashMap();
    public String tOu;
    public final List<String> tOv = new LinkedList();
    public final Map<Integer, c> tOz = new HashMap();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$116 */
    class AnonymousClass116 implements com.tencent.mm.t.a.d.a<com.tencent.mm.t.a.d> {
        final /* synthetic */ int iWq;
        final /* synthetic */ i tOE;
        final /* synthetic */ a tOI;

        AnonymousClass116(i iVar, a aVar, int i) {
            this.tOE = iVar;
            this.tOI = aVar;
            this.iWq = i;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.t.a.d dVar = (com.tencent.mm.t.a.d) kVar;
            x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                g.this.a(this.tOE, "login:fail", null);
                this.tOI.afS();
            } else if (!(dVar instanceof com.tencent.mm.t.a.d)) {
            } else {
                if (this.iWq == 2) {
                    x.d("MicroMsg.MsgHandler", "press reject button");
                    this.tOI.afS();
                    return;
                }
                amy Cf = dVar.Cf();
                int i3 = Cf.wAp.fun;
                String str2 = Cf.wAp.fuo;
                x.i("MicroMsg.MsgHandler", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    String str3 = Cf.wAs;
                    Map hashMap = new HashMap();
                    hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str3);
                    g.this.a(this.tOE, "login:ok", hashMap);
                    this.tOI.afS();
                    x.d("MicroMsg.MsgHandler", "resp data code [%s]", str3);
                    return;
                }
                g.this.a(this.tOE, "login:fail", null);
                this.tOI.afS();
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$68 */
    class AnonymousClass68 implements Runnable {
        final /* synthetic */ WebViewJSSDKFileItem tPw;

        public AnonymousClass68(WebViewJSSDKFileItem webViewJSSDKFileItem) {
            this.tPw = webViewJSSDKFileItem;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b fdVar = new fd();
            fdVar.fuV.op = 2;
            fdVar.fuV.filePath = this.tPw.iOz;
            com.tencent.mm.sdk.b.a.xmy.m(fdVar);
            g.this.tOu = null;
        }
    }

    public interface a {
        void afS();
    }

    private static final class b {
        public i tNN;
        public com.tencent.mm.plugin.webview.model.c.b tQa;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private class c {
        public e fCC;
        public i tNN;

        public c(i iVar, e eVar) {
            this.tNN = iVar;
            this.fCC = eVar;
        }
    }

    private static class d implements com.tencent.mm.pluginsdk.model.app.g.a {
        volatile boolean fzZ;
        volatile boolean hpc;
        volatile boolean jgD;
        volatile boolean jgE;
        a tQb;

        interface a {
            void n(boolean z, boolean z2);
        }

        d(a aVar) {
            this.tQb = aVar;
        }

        public final void cI(boolean z) {
            this.hpc = true;
            this.jgD = z;
            if (this.jgE && this.tQb != null) {
                this.tQb.n(this.fzZ, z);
            }
        }

        final void cJ(boolean z) {
            this.fzZ = z;
            this.jgE = true;
            if (this.hpc && this.tQb != null) {
                this.tQb.n(z, this.jgD);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$3 */
    class AnonymousClass3 implements com.tencent.mm.t.a.b.a<com.tencent.mm.t.a.b> {
        final /* synthetic */ int iWq;
        final /* synthetic */ i tOE;
        final /* synthetic */ a tOI;

        AnonymousClass3(i iVar, a aVar, int i) {
            this.tOE = iVar;
            this.tOI = aVar;
            this.iWq = i;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.t.a.b bVar = (com.tencent.mm.t.a.b) kVar;
            x.d("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                g.this.a(this.tOE, "authorize:fail", null);
                this.tOI.afS();
            } else if (!(bVar instanceof com.tencent.mm.t.a.b)) {
            } else {
                if (this.iWq == 2) {
                    x.d("MicroMsg.MsgHandler", "press reject button");
                    this.tOI.afS();
                    return;
                }
                amu Cd = bVar.Cd();
                int i3 = Cd.wAp.fun;
                String str2 = Cd.wAp.fuo;
                x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    g.this.a(this.tOE, "authorize:ok", null);
                    this.tOI.afS();
                    return;
                }
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                g.this.a(this.tOE, "authorize:fail", null);
                this.tOI.afS();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$106 */
    class AnonymousClass106 implements com.tencent.mm.pluginsdk.ui.applet.o.a {
        final /* synthetic */ String fhe;
        final /* synthetic */ String hCD;
        final /* synthetic */ String jgs;
        final /* synthetic */ f tON;
        final /* synthetic */ String tOO;
        final /* synthetic */ String tOP;
        final /* synthetic */ String tOQ;
        final /* synthetic */ boolean tPR = true;
        final /* synthetic */ String tPS;
        final /* synthetic */ String tPT;

        AnonymousClass106(f fVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
            this.tON = fVar;
            this.jgs = str;
            this.fhe = str2;
            this.hCD = str3;
            this.tOO = str4;
            this.tOP = str5;
            this.tOQ = str6;
            this.tPS = str7;
            this.tPT = str8;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                g.this.a(this.tON, this.jgs, this.fhe, this.hCD, this.tOO, this.tOP, str, this.tOQ);
                if (this.tPR) {
                    com.tencent.mm.bl.d.a(g.this.context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.fhe));
                } else if (g.this.context != null) {
                    com.tencent.mm.ui.base.h.bu(g.this.context, g.this.context.getResources().getString(R.l.dGR));
                }
                g.this.ep(1, 1);
                g.this.a(g.this.tNN, this.tPS, null);
                return;
            }
            g.this.ep(1, 3);
            g.this.a(g.this.tNN, this.tPT, null);
        }
    }

    static /* synthetic */ void B(g gVar) {
        try {
            gVar.fCC.e(12, new Bundle(0));
            gVar.fCC.e(11, new Bundle(0));
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "clearCloseWindowConfirmDialogInfo, exception = %s", e);
        }
    }

    static /* synthetic */ boolean B(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) iVar.pug.get("pid");
        String str2 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(bi.getInt((String) iVar.pug.get(Columns.TYPE), 0));
        int i = bi.getInt((String) iVar.pug.get("view_type"), 0);
        String str3 = (String) iVar.pug.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        return gVar.a(valueOf, 8, i, str3, intent);
    }

    static /* synthetic */ boolean C(g gVar, i iVar) {
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        x.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            gVar2.fDR = 4;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 7, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean D(g gVar, i iVar) {
        String str = (String) iVar.pug.get(Columns.TYPE);
        x.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", str);
        if (bi.oN(str) || jnD.contains(str)) {
            gVar.gAg = com.tencent.mm.modelgeo.c.OV();
            if (gVar.gAg == null) {
                x.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
                gVar.a(iVar, "geo_location:fail", null);
            } else {
                str = (String) gVar.tNN.pug.get(Columns.TYPE);
                if (gVar.tOq == null) {
                    gVar.tOq = new com.tencent.mm.modelgeo.a.b() {
                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            return false;
                        }

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, Bundle bundle) {
                            if (!z) {
                                return true;
                            }
                            x.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
                            if (g.this.gAg != null) {
                                g.this.gAg.c(g.this.tOq);
                            }
                            if (g.this.tOq == null) {
                                x.w("MicroMsg.MsgHandler", "already callback");
                                return false;
                            }
                            g.this.tOq = null;
                            Map hashMap = new HashMap();
                            hashMap.put("longitude", Float.valueOf(f));
                            g.this.tOn = String.valueOf(f);
                            hashMap.put("latitude", Float.valueOf(f2));
                            g.this.tOm = String.valueOf(f2);
                            hashMap.put("speed", Double.valueOf(d));
                            hashMap.put("accuracy", Double.valueOf(d2));
                            hashMap.put(Columns.TYPE, str);
                            if (bundle != null) {
                                hashMap.put("indoor_building_id", bundle.getString("indoor_building_id"));
                                hashMap.put("indoor_building_floor", bundle.getString("indoor_building_floor"));
                                hashMap.put("indoor_building_type", Integer.valueOf(bundle.getInt("indoor_building_type")));
                            }
                            g.this.a(g.this.tNN, "geo_location:ok", hashMap);
                            return false;
                        }
                    };
                }
                if (gVar.mNt == null) {
                    gVar.mNt = new ag(Looper.getMainLooper());
                }
                gVar.mNt.postDelayed(new Runnable() {
                    public final void run() {
                        if (g.this.gAg != null) {
                            g.this.gAg.c(g.this.tOq);
                        }
                        if (g.this.tOq == null) {
                            x.w("MicroMsg.MsgHandler", "already callback");
                            return;
                        }
                        g.this.tOq = null;
                        g.this.a(g.this.tNN, "geo_location:fail_timeout", null);
                    }
                }, 20000);
                if (bi.oN(str) || str.equalsIgnoreCase("gcj02")) {
                    gVar.gAg.b(gVar.tOq, false);
                } else if (str.equalsIgnoreCase("wgs84")) {
                    gVar.gAg.a(gVar.tOq, false);
                } else {
                    x.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
                    gVar.tOq = null;
                    gVar.a(gVar.tNN, "geo_location:fail_unsupported_type_startgeo", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", str);
            gVar.a(iVar, "geo_location:fail_unsupported_type", null);
        }
        return true;
    }

    static /* synthetic */ boolean I(g gVar, i iVar) {
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        x.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            gVar2.fDR = 6;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 9, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean J(g gVar, final i iVar) {
        if (gVar.tNQ == null) {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        } else if (gVar.tNQ.getBoolean("isFromService", false)) {
            String string = gVar.tNQ.getString("jsapi_args_appid");
            String string2 = gVar.tNQ.getString("sendAppMsgToUserName");
            k.a(iVar.tQf, false, null, string);
            gVar.fzX = f(iVar);
            if (gVar.fzX == null) {
                x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                gVar.a(iVar, "send_service_app_msg:fail", null);
            } else {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(string, true);
                if (bi.oN(string2)) {
                    x.e("MicroMsg.MsgHandler", "toUser is null");
                    gVar.a(iVar, "send_service_app_msg:fail", null);
                } else {
                    final String str = (String) iVar.pug.get("img_url");
                    com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(13), aZ.field_appId, Integer.valueOf(1));
                    if (bi.oN(str)) {
                        gVar.a(aZ, "", string2, str, null, null, null, null);
                        com.tencent.mm.ui.base.h.bu(gVar.context, gVar.context.getString(R.l.dGJ));
                        gVar.a(iVar, "send_service_app_msg:ok", null);
                        gVar.aT(iVar);
                    } else {
                        final ProgressDialog a = com.tencent.mm.ui.base.h.a(gVar.context, gVar.context.getResources().getString(R.l.dGM), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                o.PB().lh(str);
                                g.this.a(iVar, "send_service_app_msg:fail", null);
                            }
                        });
                        final f fVar = aZ;
                        final String str2 = string2;
                        final String str3 = str;
                        final i iVar2 = iVar;
                        o.PB().a(str, new com.tencent.mm.ap.c.c() {
                            public final void n(Bitmap bitmap) {
                                if (a != null) {
                                    a.dismiss();
                                }
                                g.this.a(fVar, "", str2, str3, null, null, null, null);
                                g.this.a(iVar2, "send_service_app_msg:ok", null);
                                g.this.aT(iVar2);
                            }
                        });
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean L(g gVar, i iVar) {
        String str = (String) iVar.pug.get("title");
        String str2 = (String) iVar.pug.get("singer");
        String str3 = (String) iVar.pug.get("epname");
        String str4 = (String) iVar.pug.get("coverImgUrl");
        String str5 = (String) iVar.pug.get("dataUrl");
        String str6 = (String) iVar.pug.get("lowbandUrl");
        String str7 = (String) iVar.pug.get("webUrl");
        String str8 = (String) iVar.pug.get("appId");
        String str9 = str4 == null ? "" : str4;
        k.a(iVar.tQf, false, null, str8);
        x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", str, str2, str3, str9, str5, str6, str7, str8);
        if (bi.oN(str) || bi.oN(str2) || bi.oN(str3) || bi.oN(str9) || bi.oN(str6) || bi.oN(str5) || bi.oN(str7)) {
            gVar.a(iVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.au.b.Qv();
            com.tencent.mm.au.a.a aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
            String str10 = str5.hashCode();
            String str11 = com.tencent.mm.compatible.util.e.bnF;
            StringBuilder stringBuilder = new StringBuilder();
            as.Hm();
            com.tencent.mm.au.b.b(aVar.a(7, str9, str, str2, str7, str6, str5, str10, str11, stringBuilder.append(com.tencent.mm.y.c.Fp()).append(str9.hashCode()).toString(), str3, str8));
            gVar.a(iVar, "playMusic:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean M(g gVar, i iVar) {
        boolean z = false;
        final String str = (String) iVar.pug.get("ssid");
        final String str2 = (String) iVar.pug.get("password");
        x.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", str, str2, (String) iVar.pug.get(Columns.TYPE), (String) iVar.pug.get("isHidden"));
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "ssid is null");
            gVar.a(iVar, "connecttowifi:failed_ssid_invalid", null);
        } else {
            final int i = bi.getInt(r0, 0);
            if (i == 0 || !bi.oN(str2)) {
                if (bi.getInt(r1, 0) == 1) {
                    z = true;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ssid", str);
                        intent.putExtra("free_wifi_source", 3);
                        intent.putExtra("free_wifi_passowrd", str2);
                        intent.putExtra("free_wifi_hide_ssid", z);
                        intent.putExtra("free_wifi_encrypt_type", i);
                        intent.addFlags(67108864);
                        com.tencent.mm.bl.d.b(g.this.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                gVar.a(iVar, "connecttowifi:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                gVar.a(iVar, "connecttowifi:failed_password_invalid", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean N(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.frE);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.b(gVar.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        return true;
    }

    static /* synthetic */ boolean O(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.frE);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        return true;
    }

    static /* synthetic */ boolean P(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) iVar.pug.get("app_id");
        int i = bi.getInt((String) iVar.pug.get("location_id"), 0);
        String str2 = (String) iVar.pug.get("sign_type");
        String str3 = (String) iVar.pug.get("card_sign");
        int i2 = bi.getInt((String) iVar.pug.get("time_stamp"), 0);
        String str4 = (String) iVar.pug.get("nonce_str");
        String str5 = (String) iVar.pug.get("card_id");
        String str6 = (String) iVar.pug.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            gVar.a(iVar, "choose_card:fail", new HashMap());
            return false;
        }
        int i3 = bi.getInt((String) iVar.pug.get("can_multi_select"), 0);
        k.a(iVar.tQf, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        return true;
    }

    static /* synthetic */ boolean Q(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("signType");
        String str3 = (String) iVar.pug.get("cardSign");
        int i = bi.getInt((String) iVar.pug.get("timestamp"), 0);
        String str4 = (String) iVar.pug.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        return true;
    }

    static /* synthetic */ boolean R(g gVar, i iVar) {
        String str = (String) iVar.pug.get("card_list");
        String str2 = (String) iVar.pug.get("src_username");
        String str3 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str4 = (String) iVar.pug.get("tempalate_id");
        x.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", (String) iVar.pug.get("consumedCardId"));
        x.i("MicroMsg.MsgHandler", "doBatchAddCard %s", iVar.pug.toString());
        x.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", str2, Integer.valueOf(bi.getInt((String) iVar.pug.get("webview_scene"), 0) == 25 ? 16 : 7), Integer.valueOf(bi.getInt((String) iVar.pug.get("stastic_scene"), 0)));
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", r6);
        intent.putExtra("key_stastic_scene", r7);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        return true;
    }

    static /* synthetic */ boolean V(g gVar, i iVar) {
        String str = (String) iVar.pug.get("appId");
        final String str2 = (String) iVar.pug.get("localId");
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", str, str2);
        if (bi.oN(str) || bi.oN(str2)) {
            gVar.a(iVar, "playVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
            if (OS != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.sdk.b.b faVar = new fa();
                        faVar.fuO.op = 1;
                        faVar.fuO.fileName = OS.fileName;
                        faVar.fuO.fjJ = true;
                        faVar.fuO.fuR = new com.tencent.mm.ad.g.a() {
                            public final void vi() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:ok");
                                    bundle.putString("localId", str2);
                                    g.this.fCC.n(2002, bundle);
                                } catch (Exception e) {
                                    x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", e.getMessage());
                                }
                            }
                        };
                        faVar.fuO.fuS = new com.tencent.mm.ad.g.b() {
                            public final void onError() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:fail");
                                    bundle.putString("localId", str2);
                                    g.this.fCC.n(2002, bundle);
                                } catch (Exception e) {
                                    x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", e.getMessage());
                                }
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.m(faVar);
                    }
                });
                gVar.a(iVar, "playVoice:ok", null);
            } else {
                gVar.a(iVar, "playVoice:fail_arguments error", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean W(g gVar, i iVar) {
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", str, str2);
        if (bi.oN(str) || bi.oN(str2)) {
            gVar.a(iVar, "pauseVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
            if (OS != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.sdk.b.b faVar = new fa();
                        faVar.fuO.op = 4;
                        faVar.fuO.fileName = OS.fileName;
                        com.tencent.mm.sdk.b.a.xmy.m(faVar);
                    }
                });
                gVar.a(iVar, "pauseVoice:ok", null);
            } else {
                gVar.a(iVar, "pauseVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean X(g gVar, i iVar) {
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", str, str2);
        k.a(iVar.tQf, false, null, str);
        if (bi.oN(str) || bi.oN(str2)) {
            gVar.a(iVar, "stopVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
            if (OS != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.sdk.b.b faVar = new fa();
                        faVar.fuO.op = 2;
                        faVar.fuO.fileName = OS.fileName;
                        com.tencent.mm.sdk.b.a.xmy.m(faVar);
                    }
                });
                gVar.a(iVar, "stopVoice:ok", null);
            } else {
                gVar.a(iVar, "stopVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ i a(g gVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (gVar.context == null || gVar.context.getResources() == null) {
            x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
            return null;
        } else if (gVar.context instanceof Activity) {
            String bVk = gVar.bVk();
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            return com.tencent.mm.pluginsdk.ui.applet.e.a(((MMActivity) gVar.context).mController, str2, str3, str5, null, true, gVar.context.getResources().getString(R.l.dGL), (com.tencent.mm.pluginsdk.ui.applet.o.a) new AnonymousClass106(aZ, str, str4, str3, str6, str7, bVk, true, str8, str9));
        } else {
            x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
            return null;
        }
    }

    static /* synthetic */ void a(g gVar, e eVar, i iVar, String str) {
        String str2 = null;
        gVar.mgx = false;
        if (iVar != null) {
            str2 = iVar.tQe;
        }
        try {
            eVar.a(str2, str, i.ap(null), true);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void a(g gVar, String str, String str2, String str3) {
        as.Hm();
        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", str);
        EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(str);
        if (YB == null && com.tencent.mm.a.e.bO(I)) {
            int i = p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.xIH;
            emojiInfo.field_type = i;
            emojiInfo.field_size = com.tencent.mm.a.e.bN(I);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            if (!bi.oN(str3)) {
                emojiInfo.field_activityid = str3;
            }
            com.tencent.mm.plugin.emoji.model.i.aCl().lCw.n(emojiInfo);
            YB = emojiInfo;
        }
        if (YB != null) {
            x.i("MicroMsg.MsgHandler", "doAddAction %b", Boolean.valueOf(com.tencent.mm.plugin.emoji.model.i.aCh().a(gVar.context, YB, 18, q.FY())));
            if (com.tencent.mm.plugin.emoji.model.i.aCh().a(gVar.context, YB, 18, q.FY())) {
                gVar.a(gVar.tNN, "addToEmoticon:ok", null);
                return;
            } else {
                gVar.a(gVar.tNN, "addToEmoticon:fail", null);
                return;
            }
        }
        gVar.a(gVar.tNN, "addToEmoticon:fail", null);
    }

    static /* synthetic */ boolean a(g gVar, i iVar, int i) {
        String str = "";
        if (iVar.pug.containsKey("canvasId")) {
            str = iVar.pug.get("canvasId").toString();
        }
        int i2 = 0;
        if (iVar.pug.containsKey("preLoad")) {
            i2 = bi.Wo(iVar.pug.get("preLoad").toString());
        }
        int i3 = 0;
        if (iVar.pug.containsKey("noStore")) {
            i3 = bi.Wo(iVar.pug.get("noStore").toString());
        }
        String str2 = "";
        if (iVar.pug.containsKey("extraData")) {
            str2 = iVar.pug.get("extraData").toString();
        }
        String str3 = "";
        if (iVar.pug.containsKey("adInfoXml")) {
            str3 = iVar.pug.get("adInfoXml").toString();
        }
        String str4 = "";
        if (iVar.pug.containsKey("sessionId")) {
            str4 = iVar.pug.get("sessionId").toString();
        }
        String str5 = "";
        if (iVar.pug.containsKey("adBuffer")) {
            str5 = iVar.pug.get("adBuffer").toString();
        }
        String str6 = "";
        if (iVar.pug.containsKey("canvasExt")) {
            str6 = iVar.pug.get("canvasExt").toString();
        }
        x.i("MicroMsg.MsgHandler", "doOpenCanvas canvasid %s, getCanvasSource %d, preLoad %d, noStore %d, extra %s source %d adInfoXml %s, sessionId %s, adBuffer %s, canvasExt %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i), str3, str4, str5, str6);
        Map hashMap = new HashMap();
        if (bi.oN(str) || "0".equals(str)) {
            hashMap.put("ret", Integer.valueOf(-1));
            hashMap.put("ret_msg", "invalid page id = " + str);
            gVar.a(iVar, "doOpenCanvas:fail", hashMap);
            return false;
        }
        com.tencent.mm.sdk.b.b lcVar = new lc();
        lcVar.fDi.fDk = str;
        lcVar.fDi.fra = str6;
        lcVar.fDi.fDl = i2;
        lcVar.fDi.fDm = i3;
        lcVar.fDi.cPf = i;
        com.tencent.mm.sdk.b.a.xmy.m(lcVar);
        if (i2 != 1) {
            String str7 = lcVar.fDj.fDn;
            Intent intent = new Intent();
            String str8 = "sns_landing_pages_xml";
            if (str7 == null) {
                str7 = "";
            }
            intent.putExtra(str8, str7);
            if (i == 1) {
                intent.putExtra("sns_landing_pages_canvasid", str);
                intent.putExtra("sns_landig_pages_from_source", 15);
                intent.putExtra("sns_landing_pages_search_extra", str2);
                intent.putExtra("sns_landing_pages_sessionId", str4);
                intent.putExtra("sns_landing_pages_ad_buffer", str5);
                intent.putExtra("sns_landing_pages_canvas_ext", str6);
            } else {
                intent.putExtra("sns_landing_pages_pageid", bi.Wp(str));
                intent.putExtra("sns_landig_pages_from_source", 13);
                intent.putExtra("sns_landing_pages_extra", str2);
            }
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            intent.putExtra("sns_landing_pages_no_store", i3);
            intent.putExtra("sns_landing_pages_ad_info", str3);
            com.tencent.mm.bl.d.b(gVar.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        }
        hashMap.put("ret", Integer.valueOf(0));
        gVar.a(iVar, "doOpenCanvas:succ", hashMap);
        return true;
    }

    static /* synthetic */ boolean a(g gVar, i iVar, boolean z) {
        String str = (String) iVar.pug.get("designerId");
        int i = bi.getInt((String) iVar.pug.get("designerUin"), 0);
        String str2 = (String) iVar.pug.get("tagId");
        String str3 = (String) iVar.pug.get("tagDesc");
        String str4 = (String) iVar.pug.get("keyword");
        int i2 = bi.getInt((String) iVar.pug.get("tid"), 0);
        String aD = bi.aD((String) iVar.pug.get("title"), "");
        String aD2 = bi.aD((String) iVar.pug.get("desc"), "");
        String aD3 = bi.aD((String) iVar.pug.get("iconUrl"), "");
        String aD4 = bi.aD((String) iVar.pug.get("secondUrl"), "");
        int i3 = bi.getInt((String) iVar.pug.get("pageType"), 0);
        long j = bi.getLong((String) iVar.pug.get("searchID"), 0);
        x.d("MicroMsg.MsgHandler", "cpan emoji openDesignerEmojiView:%d", Long.valueOf(j));
        Intent intent = new Intent();
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
        intent.putExtra("headurl", aD4);
        intent.putExtra("set_iconURL", aD3);
        intent.putExtra("set_desc", aD2);
        intent.putExtra("pageType", i3);
        intent.putExtra("set_title", aD);
        intent.putExtra("set_id", i2);
        x.i("MicroMsg.MsgHandler", "openDesignerEmojiView event: designerID:%s tagID:%s tagDesc:%s keyword:%s", str, str2, str3, str4);
        if (!bi.oN(str4)) {
            intent.putExtra("keyword", str4);
            intent.putExtra("searchID", j);
            com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str4, null);
            if (z) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13055, Integer.valueOf(2), "", "", "", Integer.valueOf(com.tencent.mm.aj.a.Np()), Long.valueOf(j));
            }
            return true;
        } else if (!bi.oN(str)) {
            intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
            intent.putExtra("searchID", j);
            com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str, null);
            return true;
        } else if (bi.oN(str2)) {
            com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok", null);
            return true;
        } else {
            intent.putExtra("tag_id", str2);
            intent.putExtra("tag_desc", str3);
            com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str2, null);
            return true;
        }
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT >= 18 && defaultAdapter != null) {
            com.tencent.mm.sdk.b.a.xmy.b(gVar.qyj);
            String oM = bi.oM(str);
            gVar.tOg.put(oM, oM);
            x.i("MicroMsg.MsgHandler", "[MsgHandler][doStartIBeaconRange]op=true,iBeacon = %s", oM);
            Editor edit = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", true);
            edit.commit();
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.valueOf(true));
            }
            com.tencent.mm.sdk.b.b dkVar = new dk();
            dkVar.fsP.fsR = oM;
            dkVar.fsP.fsO = true;
            com.tencent.mm.sdk.b.a.xmy.m(dkVar);
        }
        return true;
    }

    static /* synthetic */ boolean aF(g gVar, i iVar) {
        String str = (String) iVar.pug.get("gameId");
        if (bi.oN(str)) {
            str = (String) iVar.pug.get("appId");
        }
        x.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", str);
        if (bi.oN(str)) {
            gVar.a(iVar, "openGameDetail:fail", null);
        } else {
            com.tencent.mm.sdk.b.b gnVar = new gn();
            gnVar.fxx.appId = str;
            gnVar.fxx.scene = 5;
            gnVar.fxx.actionCode = 2;
            gnVar.fxx.context = gVar.context;
            com.tencent.mm.sdk.b.a.xmy.m(gnVar);
            gVar.a(iVar, "openGameDetail:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aG(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.pug.get("jumpView"), 0);
        int i2 = bi.getInt((String) iVar.pug.get("jumpType"), 0);
        String str = (String) iVar.pug.get("extInfo");
        com.tencent.mm.sdk.b.b lhVar = new lh();
        lhVar.fDy.fDz = i;
        lhVar.fDy.jumpType = i2;
        lhVar.fDy.extraInfo = str;
        lhVar.fDy.context = gVar.context;
        com.tencent.mm.sdk.b.a.xmy.m(lhVar);
        gVar.a(iVar, "gameCenterJump:ok", null);
        return true;
    }

    static /* synthetic */ boolean aH(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.pug.get("downloaderType"), 0);
        String str = (String) iVar.pug.get("countryCode");
        int i2 = bi.getInt((String) iVar.pug.get("showAllLog"), 0);
        com.tencent.mm.sdk.b.b gpVar = new gp();
        gpVar.fxB.fxC = i;
        gpVar.fxB.fxD = i2;
        gpVar.fxB.countryCode = str;
        com.tencent.mm.sdk.b.a.xmy.m(gpVar);
        gVar.a(iVar, "setGameDebugConfig:ok", null);
        return true;
    }

    static /* synthetic */ boolean aJ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        return true;
    }

    static /* synthetic */ boolean aK(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (gVar.context != null) {
            String str = (String) iVar.pug.get("deviceType");
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "deviceType is null");
                gVar.a(iVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) iVar.pug.get("deviceId");
                if (bi.oN(str2)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    gVar.a(iVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(gVar.context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.bl.d.b(gVar.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    gVar.a(iVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "context is null");
            gVar.a(iVar, "openMyDeviceProfile:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean aL(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            gVar2.vGv = 2;
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 27, gVar);
            long j = bi.getLong((String) iVar.pug.get("message_id"), 0);
            int i = bi.getInt((String) iVar.pug.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pWK.h(10593, gVar2.fDP, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fDQ), gVar2.url);
            gVar.tOf = gVar.aU(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean aM(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            gVar.tOe = bi.getInt((String) iVar.pug.get("closeWebAfterPayDetailBack"), 0);
            MMActivity mMActivity = (MMActivity) gVar.context;
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            mMActivity.jCj = gVar;
            com.tencent.mm.bl.d.a(mMActivity, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent, 25, true);
            long j = bi.getLong((String) iVar.pug.get("message_id"), 0);
            int i = bi.getInt((String) iVar.pug.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pWK.h(10593, gVar2.fDP, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fDQ), gVar2.url);
        }
        return true;
    }

    static /* synthetic */ boolean aN(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.bl.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, false);
            gVar.a(iVar, "jump_to_wx_wallet:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aO(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doScanCover");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (com.tencent.mm.o.a.aV(gVar.context) || com.tencent.mm.at.a.Qq()) {
            x.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            gVar.a(iVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.bl.d.a(gVar.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            gVar.a(iVar, "sacnCover:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aP(g gVar, i iVar) {
        if (gVar.f("nfcIsConnect", 4001, new Bundle())) {
            gVar.a(iVar, "nfcIsConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aQ(g gVar, i iVar) {
        if (gVar.f("nfcConnect", 4002, new Bundle())) {
            gVar.a(iVar, "nfcConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aR(g gVar, i iVar) {
        if (gVar.f("nfcTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) iVar.pug.get("apdu"));
            Bundle e = gVar.e("nfcTransceive", 4003, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aS(g gVar, i iVar) {
        if (gVar.f("nfcBatchTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) iVar.pug.get("apdus"));
            bundle.putBoolean("breakIfFail", bi.getInt((String) iVar.pug.get("breakIfFail"), 1) == 1);
            Bundle e = gVar.e("nfcBatchTransceive", 4004, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcBatchTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aT(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetId", 4002, bundle)) {
            bundle = gVar.e("nfcGetId", 4005, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.ID, bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                gVar.a(iVar, "nfcGetId:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcGetId:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aU(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetInfo", 4002, bundle)) {
            bundle = gVar.e("nfcGetInfo", 4008, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                gVar.a(iVar, "nfcGetInfo:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                gVar.a(iVar, "nfcGetInfo:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aV(g gVar, final i iVar) {
        int i = 0;
        boolean z = bi.getInt((String) iVar.pug.get("isShowNfcSwitchGuide"), 1) == 1;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(gVar.context);
        if (defaultAdapter == null) {
            gVar.a(iVar, "nfcCheckState:nfc_not_support", null);
        } else {
            as.Hm();
            int intValue = ((Integer) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            as.Hm();
            int intValue2 = ((Integer) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            if (intValue == 2 || (intValue == 0 && intValue2 != 1)) {
                i = 1;
            }
            if (i != 0) {
                if (z) {
                    ah.y(new Runnable() {
                        public final void run() {
                            com.tencent.mm.ui.base.h.a(g.this.context, g.this.context.getString(R.l.eyd), "", g.this.context.getString(R.l.eyf), g.this.context.getString(R.l.dEy), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.bl.d.y(g.this.context, "setting", ".ui.setting.SettingsAboutSystemUI");
                                    g.this.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    g.this.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            });
                        }
                    });
                } else {
                    gVar.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                }
            } else if (defaultAdapter.isEnabled()) {
                gVar.a(iVar, "nfcCheckState:nfc_ok", null);
            } else if (z) {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.h.a(g.this.context, g.this.context.getString(R.l.eye), "", g.this.context.getString(R.l.eyf), g.this.context.getString(R.l.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.this.context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                                g.this.a(iVar, "nfcCheckState:nfc_off", null);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.this.a(iVar, "nfcCheckState:nfc_off", null);
                            }
                        });
                    }
                });
            } else {
                gVar.a(iVar, "nfcCheckState:nfc_off", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean al(g gVar, i iVar) {
        if (gVar.context instanceof MMActivity) {
            String str = (String) iVar.pug.get("key");
            int i = bi.getInt((String) iVar.pug.get("procint"), 0);
            int i2 = bi.getInt((String) iVar.pug.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.b(gVar.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            gVar.a(iVar, "configWXDeviceWiFi:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean ao(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("scene", 1);
            intent.putExtra("pay_channel", gVar2.frE);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        return true;
    }

    static /* synthetic */ boolean ap(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fDO);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.frE);
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        return true;
    }

    static /* synthetic */ boolean aq(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) iVar.pug.get("card_list");
        String str2 = (String) iVar.pug.get("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        }
        gVar.mgx = false;
        return true;
    }

    static /* synthetic */ boolean ar(g gVar, i iVar) {
        Object obj = iVar.pug.get(Columns.TYPE);
        final String obj2 = obj == null ? "0" : obj.toString();
        x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", obj2);
        final String str = (String) iVar.pug.get("src_username");
        if (obj2.equals("0") || obj2.equals("1") || obj2.equals("2")) {
            String str2 = (String) iVar.pug.get("apKey");
            x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", str2);
            final String str3 = bi.oN(str2) ? "" : str2;
            if (obj2.equals("0") && bi.oN(str3)) {
                gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
            } else {
                final String str4 = (String) iVar.pug.get("sessionKey");
                ah.y(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_jsapi_param_type", obj2);
                        intent.putExtra("free_wifi_ap_key", str3);
                        intent.putExtra("free_wifi_jsapi_param_username", str);
                        intent.putExtra("free_wifi_sessionkey", str4);
                        intent.putExtra("free_wifi_source", 4);
                        intent.addFlags(67108864);
                        if (!(bi.oN(obj2) || !obj2.equalsIgnoreCase("2") || bi.oN(str3))) {
                            Uri parse = Uri.parse(str3);
                            String host = parse.getHost();
                            String query = parse.getQuery();
                            if (!bi.oN(host) && "connectToFreeWifi".equals(host) && !bi.oN(query) && query.startsWith("apKey=")) {
                                host = parse.getQueryParameter("apKey");
                                x.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", host);
                                query = parse.getQueryParameter("ticket");
                                if (!bi.oN(host) && host.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                                    intent.putExtra("free_wifi_ap_key", host);
                                    intent.putExtra("free_wifi_source", 5);
                                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                                    if (!bi.oN(query)) {
                                        intent.putExtra("free_wifi_schema_ticket", query);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.bl.d.b(g.this.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                gVar.a(iVar, "connectToFreeWifi:ok", null);
            }
        } else {
            gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
        }
        return true;
    }

    static /* synthetic */ void b(g gVar, int i) {
        if (i == 1) {
            gVar.a(gVar.tOr, "startVoipCall:cancel", null);
        } else if (i == 2) {
            gVar.a(gVar.tOr, "startVoipCall:hangup", null);
        } else if (i == 3) {
            gVar.a(gVar.tOr, "startVoipCall:network error", null);
        } else if (i == 4) {
            gVar.a(gVar.tOr, "startVoipCall:param not match", null);
        } else {
            gVar.a(gVar.tOr, "startVoipCall:unknow", null);
        }
    }

    static /* synthetic */ boolean b(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pug.get("username");
        gVar.Qm((String) iVar.pug.get("scene"));
        return gVar.Qp(str);
    }

    static /* synthetic */ boolean b(g gVar, i iVar, boolean z) {
        x.i("MicroMsg.MsgHandler", "openDesignerProfile");
        String str = (String) iVar.pug.get("designerId");
        x.d("MicroMsg.MsgHandler", "cpan emoji openDesignerProfile:%d", Long.valueOf(bi.getLong((String) iVar.pug.get("searchID"), 0)));
        if (bi.oN(str)) {
            x.w("MicroMsg.MsgHandler", "openDesignerProfile failed designer id is null.");
            gVar.a(iVar, "openDesignerProfile", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
        intent.putExtra("extra_scence", 12);
        intent.putExtra("searchID", r4);
        com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        gVar.a(iVar, "openDesignerProfile", null);
        if (z) {
            com.tencent.mm.plugin.report.service.g.pWK.h(13055, Integer.valueOf(3), "", str, "", Integer.valueOf(com.tencent.mm.aj.a.Np()), Long.valueOf(r4));
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean bA(com.tencent.mm.plugin.webview.ui.tools.jsapi.g r11, com.tencent.mm.plugin.webview.ui.tools.jsapi.i r12) {
        /*
        r10 = 9;
        r9 = 1;
        r8 = 0;
        r11.mgx = r8;
        r1 = com.tencent.mm.plugin.webview.modeltools.f.bSl();
        r0 = r12.pug;
        r2 = "MicroMsg.FTS.FTSWebViewLogic";
        r3 = "clickSnsMusicPlayButton %s";
        r4 = new java.lang.Object[r9];
        r5 = r0.toString();
        r4[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = "isLoop";
        r2 = com.tencent.mm.plugin.webview.fts.f.t(r0, r2);
        r3 = "needStartMusicUI";
        r3 = com.tencent.mm.plugin.webview.fts.f.t(r0, r3);
        r4 = "snsid";
        r4 = com.tencent.mm.plugin.webview.fts.f.r(r0, r4);
        r5 = "webview_instance_id";
        r5 = r0.get(r5);
        r6 = -1;
        r5 = com.tencent.mm.sdk.platformtools.bi.p(r5, r6);
        r6 = com.tencent.mm.au.b.Qx();
        if (r6 == 0) goto L_0x005a;
    L_0x0044:
        r6 = com.tencent.mm.au.b.Qz();
        r7 = r6.wHt;
        if (r7 != r10) goto L_0x005a;
    L_0x004c:
        r6 = r6.wdd;
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        com.tencent.mm.au.b.Qv();
        if (r3 != 0) goto L_0x005a;
    L_0x0059:
        return r8;
    L_0x005a:
        if (r3 == 0) goto L_0x006a;
    L_0x005c:
        r4 = r1.tsS;
        if (r4 == 0) goto L_0x006a;
    L_0x0060:
        r4 = r1.tsS;
        r6 = new com.tencent.mm.au.b$9;
        r6.<init>(r4, r9);
        com.tencent.mm.sdk.platformtools.ah.y(r6);
    L_0x006a:
        r4 = "objectXmlDesc";
        r4 = com.tencent.mm.plugin.webview.fts.f.r(r0, r4);
        r0 = com.tencent.mm.plugin.sns.b.m.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.sns.b.m) r0;
        r4 = r0.mK(r4);
        r0 = com.tencent.mm.au.a.a.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.au.a.a) r0;
        com.tencent.mm.y.as.Hm();
        r6 = com.tencent.mm.y.c.FJ();
        r0 = r0.a(r6, r4, r10);
        r0.wHL = r2;
        com.tencent.mm.au.b.a(r0);
        if (r3 == 0) goto L_0x00b5;
    L_0x0097:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "key_scene";
        r3 = 4;
        r0.putExtra(r2, r3);
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r2);
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "music";
        r4 = ".ui.MusicMainUI";
        com.tencent.mm.bl.d.b(r2, r3, r4, r0);
    L_0x00b5:
        r0 = r1.tsL;
        r1 = java.lang.Integer.valueOf(r5);
        r0.add(r1);
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.bA(com.tencent.mm.plugin.webview.ui.tools.jsapi.g, com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    static /* synthetic */ boolean bJ(g gVar, i iVar) {
        gVar.mgx = false;
        String str = (String) iVar.pug.get("brandUsername");
        Intent QT = com.tencent.mm.bb.b.QT();
        QT.putExtra("ftsneedkeyboard", true);
        QT.putExtra("ftsbizscene", 19);
        QT.putExtra("ftsType", 2);
        Map b = com.tencent.mm.bb.b.b(19, true, 2);
        b.put("userName", str);
        QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
        QT.putExtra("key_load_js_without_delay", true);
        QT.putExtra("ftsbizusername", str);
        com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
        return false;
    }

    static /* synthetic */ boolean bN(g gVar, final i iVar) {
        final String str = (String) iVar.pug.get("cardType");
        if (bi.oN(str) || gVar.context == null) {
            gVar.a(iVar, "scanLicence:fail", null);
        } else {
            if (!gVar.tOc.a(str, gVar.context, new com.tencent.mm.plugin.webview.modeltools.d.a() {
                public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                    if (!bi.oM(str).equalsIgnoreCase(str)) {
                        x.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", str, str);
                    } else if (jSONObject == null) {
                        x.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", str);
                        LE(str);
                    } else {
                        Map hashMap = new HashMap(2);
                        hashMap.put("cardType", str);
                        hashMap.put("cardInfo", jSONObject);
                        g.this.a(iVar, "scanLicence:ok", hashMap);
                    }
                }

                public final void Pl(String str) {
                    if (bi.oM(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        g.this.a(iVar, "scanLicence:cancel", hashMap);
                    }
                }

                public final void LE(String str) {
                    if (bi.oM(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        g.this.a(iVar, "scanLicence:fail", hashMap);
                    }
                }
            })) {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                gVar.a(iVar, "scanLicence:type not supported", hashMap);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bP(g gVar, final i iVar) {
        x.i("MicroMsg.MsgHandler", "do ecard jsapi check");
        final com.tencent.mm.sdk.b.b cmVar = new cm();
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        cmVar.frw.appId = gVar2.appId;
        cmVar.frw.fry = gVar2.timeStamp;
        cmVar.frw.nonceStr = gVar2.nonceStr;
        cmVar.frw.packageExt = gVar2.packageExt;
        cmVar.frw.signature = gVar2.fDO;
        cmVar.frw.signType = gVar2.signType;
        cmVar.frw.frz = gVar2.url;
        cmVar.frw.frA = (String) iVar.pug.get("ecardType");
        cmVar.frw.frB = (String) iVar.pug.get("openScene");
        cmVar.frw.frC = new WeakReference(gVar.context);
        cmVar.frw.token = (String) iVar.pug.get("token");
        cmVar.frw.frD = new Runnable() {
            public final void run() {
                x.i("MicroMsg.MsgHandler", "run ecard jsapi check callback");
                if (cmVar.frx.retCode == 0) {
                    g.this.a(iVar, "openECard:ok", null);
                } else {
                    g.this.a(iVar, "openECard:fail", null);
                }
            }
        };
        cmVar.frw.frE = gVar2.frE;
        com.tencent.mm.sdk.b.a.xmy.m(cmVar);
        return true;
    }

    static /* synthetic */ boolean bc(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.fts.c bSm = com.tencent.mm.plugin.webview.modeltools.f.bSm();
        Map map = iVar.pug;
        int p = bi.p(map.get("webview_instance_id"), -1);
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "poiId");
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a bgn = new bgn();
        bgn.wSe = r2;
        bgn.vWw = r;
        aVar.hnT = bgn;
        aVar.hnU = new bgo();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchpoi";
        aVar.hnS = 2608;
        u.a(aVar.Kf(), new com.tencent.mm.plugin.webview.fts.c.AnonymousClass1(p, r, r2));
        return false;
    }

    static /* synthetic */ boolean bo(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        Map map = iVar.pug;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", map.toString());
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, "logId", 0);
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", Integer.valueOf(c), com.tencent.mm.plugin.webview.fts.f.r(map, "logString"));
        com.tencent.mm.bb.g.t(c, r0);
        return false;
    }

    static /* synthetic */ boolean bq(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.fts.e bSl = com.tencent.mm.plugin.webview.modeltools.f.bSl();
        Map map = iVar.pug;
        boolean t = com.tencent.mm.plugin.webview.fts.f.t(map, "hasResult");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "query");
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 0);
        x.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", Boolean.valueOf(t), r, Integer.valueOf(c));
        com.tencent.mm.plugin.webview.fts.e.e eVar = bSl.tsR;
        if (eVar.scene == c2 && eVar.fEe != null && eVar.fEe.equals(r) && eVar.mVj == c) {
            eVar.fpa = t;
        } else {
            x.w("MicroMsg.FTS.FTSWebViewLogic", "setHahResultNotSame: %s VS %s | %d VS %d | %d VS %d", eVar.fEe, r, Integer.valueOf(eVar.mVj), Integer.valueOf(c), Integer.valueOf(eVar.scene), Integer.valueOf(c2));
        }
        return false;
    }

    static /* synthetic */ boolean bs(g gVar, i iVar) {
        boolean z = true;
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        Map map = iVar.pug;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", map);
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 0);
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "activityId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("extra_scence", c2);
        intent.putExtra("extra_type", c);
        intent.putExtra("searchID", r);
        intent.putExtra("docID", com.tencent.mm.plugin.webview.fts.f.r(map, "docID"));
        intent.putExtra("activityId", r2);
        switch (c) {
            case 1:
                intent.putExtra("extra_id", com.tencent.mm.plugin.webview.fts.f.r(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", bi.getLong(r, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.fts.f.r(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.fts.f.r(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.fts.f.r(map, "designerId"));
                intent.putExtra("extra_product_id", com.tencent.mm.plugin.webview.fts.f.r(map, "productID"));
                intent.putExtra("productUrl", com.tencent.mm.plugin.webview.fts.f.r(map, "productUrl"));
                intent.putExtra("extra_product_name", com.tencent.mm.plugin.webview.fts.f.r(map, "productName"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.fts.f.r(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.fts.f.r(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.fts.f.r(map, "designerId"));
                intent.putExtra("name", com.tencent.mm.plugin.webview.fts.f.r(map, "designerName"));
                intent.putExtra("headurl", com.tencent.mm.plugin.webview.fts.f.r(map, "designerThumb"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra("extra_article_name", com.tencent.mm.plugin.webview.fts.f.r(map, "sourceTitle"));
                intent.putExtra("extra_article_url", com.tencent.mm.plugin.webview.fts.f.r(map, "articleSource"));
                intent.putExtra("disableAddSticker", com.tencent.mm.plugin.webview.fts.f.c(map, "disableAddSticker", 0) > 0);
                str = "needSavePhotosAlbum";
                if (com.tencent.mm.plugin.webview.fts.f.c(map, "needSavePhotosAlbum", 0) <= 0) {
                    z = false;
                }
                intent.putExtra(str, z);
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!bi.oN(str)) {
            com.tencent.mm.bl.d.b(ad.getContext(), "emoji", str, intent);
        }
        return false;
    }

    static /* synthetic */ boolean bt(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        return com.tencent.mm.plugin.webview.fts.e.ah(iVar.pug);
    }

    static /* synthetic */ boolean bx(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.pug.get("cmd"), 0);
        String str = (String) iVar.pug.get("param");
        com.tencent.mm.sdk.b.b grVar = new gr();
        grVar.fxF.pK = i;
        grVar.fxF.fxA = str;
        com.tencent.mm.sdk.b.a.xmy.m(grVar);
        Map hashMap = new HashMap();
        hashMap.put("result", grVar.fxG.fxH);
        gVar.a(iVar, "getGameMessages:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean by(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.frE);
        ((MMActivity) gVar.context).jCj = gVar;
        com.tencent.mm.bl.d.a(gVar.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        return true;
    }

    static /* synthetic */ boolean bz(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.fts.e bSl = com.tencent.mm.plugin.webview.modeltools.f.bSl();
        Map map = iVar.pug;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, SlookAirButtonFrequentContactAdapter.DATA);
        boolean t = com.tencent.mm.plugin.webview.fts.f.t(map, "append");
        Runnable aVar = new a(bSl, (byte) 0);
        aVar.data = r;
        aVar.ttd = t;
        com.tencent.mm.sdk.f.e.post(aVar, "append_music_list_task");
        return false;
    }

    static /* synthetic */ boolean c(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGoVideoPlayerUI");
        String str = (String) iVar.pug.get("streamingUrl");
        int i = (int) bi.getDouble((String) iVar.pug.get("streamingVideoTime"), 0.0d);
        String str2 = (String) iVar.pug.get("btnTitle");
        String str3 = (String) iVar.pug.get("jumpUrl");
        String str4 = (String) iVar.pug.get("shareTitle");
        String str5 = (String) iVar.pug.get("shareThumbUrl");
        int i2 = bi.getInt((String) iVar.pug.get("shareBtnHidden"), 0);
        String str6 = (String) iVar.pug.get("reportArgs");
        int i3 = bi.getInt((String) iVar.pug.get("needReportData"), 0);
        Intent intent = new Intent();
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", str);
        intent.putExtra("StreamWording", str2);
        intent.putExtra("StremWebUrl", str3);
        intent.putExtra("KThumUrl", str5);
        intent.putExtra("KMediaId", "fakeid_" + str5.hashCode());
        intent.putExtra("KMediaVideoTime", i);
        intent.putExtra("KMediaTitle", str4);
        intent.putExtra("ShareBtnHidden", i2);
        intent.putExtra("ReportArgs", str6);
        intent.putExtra("NeedReportData", i3);
        com.tencent.mm.bl.d.b(gVar.context, "sns", ".ui.VideoAdPlayerUI", intent);
        gVar.a(iVar, "playStreamingVideo:ok", null);
        return true;
    }

    static /* synthetic */ boolean c(g gVar, i iVar, boolean z) {
        ((MMActivity) gVar.context).jCj = gVar;
        int i = z ? 49 : 48;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", q.Gb());
        bundle.putInt("k_server_scene", 2);
        bundle.putBoolean("key_is_need_video", z);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("key_function_name", iVar.tQg);
        bundle.putInt("key_business_type", 1);
        x.v("MicroMsg.MsgHandler", "alvinluo facedetect current url: %s", gVar.aeH());
        String qZ = gVar.qZ(qZ);
        if (qZ == null) {
            qZ = (String) iVar.pug.get("appId");
        }
        bundle.putString("k_app_id", qZ);
        bundle.putString("request_verify_pre_info", (String) iVar.pug.get("request_verify_pre_info"));
        com.tencent.mm.sdk.b.b noVar = new no();
        noVar.fGv.context = gVar.context;
        noVar.fGv.fGx = i;
        noVar.fGv.extras = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(noVar);
        x.i("MicroMsg.MsgHandler", "start face detect event result: %b", Boolean.valueOf(noVar.fGw.fGy));
        if (!noVar.fGw.fGy) {
            ((MMActivity) gVar.context).jCj = null;
            gVar.a(iVar, z ? "requestWxFacePictureVerifyUnionVideo:fail" : "requestWxFacePictureVerify:fail", i.aa(noVar.fGw.extras));
        }
        return true;
    }

    static /* synthetic */ boolean cB(g gVar, i iVar) {
        String oM = bi.oM((String) iVar.pug.get("toUsername"));
        String oM2 = bi.oM((String) iVar.pug.get("scene"));
        String oM3 = bi.oM((String) iVar.pug.get(Columns.TYPE));
        String oM4 = bi.oM((String) iVar.pug.get("allowBackCamera"));
        String oM5 = bi.oM((String) iVar.pug.get("showOther"));
        String oM6 = bi.oM((String) iVar.pug.get("avatarUrl"));
        String oM7 = bi.oM((String) iVar.pug.get("context"));
        x.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + oM + ",scene:" + oM2 + ",type:" + oM3 + ",allowBackCamera:" + oM4 + ",showOther:" + oM5 + ",avatarUrl:" + oM6 + ",voipCSContext:" + oM7);
        String str = (String) iVar.pug.get("appId");
        if (str == null || str.equals("") || oM == null || oM.equals("")) {
            gVar.a(iVar, "startVoipCall:param invalid", null);
        } else {
            gVar.tOr = iVar;
            com.tencent.mm.sdk.b.a.xmy.b(gVar.tOs);
            if (oM.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.bl.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", oM);
                intent2.putExtra("voipCSScene", oM2);
                intent2.putExtra("voipCSType", oM3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", oM4);
                intent2.putExtra("voipCSShowOther", oM5);
                intent2.putExtra("voipCSAvatarUrl", oM6);
                intent2.putExtra("voipCSContext", oM7);
                com.tencent.mm.bl.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
            }
        }
        return true;
    }

    static /* synthetic */ boolean cF(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) iVar.pug.get("sendId");
        int parseInt = Integer.parseInt((String) iVar.pug.get("hbKind"));
        if (bi.oN(str)) {
            gVar.a(iVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            x.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", str, Integer.valueOf(parseInt));
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (parseInt == 2) {
                com.tencent.mm.bl.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.bl.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            }
            gVar.a(iVar, "openLuckyMoneyDetailView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cG(g gVar, final i iVar) {
        x.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        final String str = (String) iVar.pug.get("transactionId");
        final String str2 = (String) iVar.pug.get("receiverName");
        if (bi.oN(str) || bi.oN(str2)) {
            gVar.a(iVar, "doResendRemittanceMsg:fail", null);
        } else {
            com.tencent.mm.ui.base.h.a(gVar.context, R.l.eQw, R.l.dGE, R.l.eQx, R.l.dEy, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("transaction_id", str);
                    intent.putExtra("receiver_name", str2);
                    com.tencent.mm.bl.d.b(g.this.context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                    g.this.a(iVar, "doResendRemittanceMsg:ok", null);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    static /* synthetic */ boolean cJ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", (String) iVar.pug.get("localId"));
        WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(r0);
        if (OS == null) {
            x.e("MicroMsg.MsgHandler", "the item is null");
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (TextUtils.isEmpty(OS.iOz)) {
            x.e("MicroMsg.MsgHandler", "the File item not exist for localId:%s", OS.fvn);
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (new File(OS.iOz).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", OS.iOz);
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).jCj = gVar;
                com.tencent.mm.bl.d.b(gVar.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", OS.iOz);
            gVar.a(iVar, "previewVideo:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean cP(g gVar, final i iVar) {
        x.i("MicroMsg.MsgHandler", "getLocalWePkgInfo call");
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.webview.wepkg.model.g.a(new com.tencent.mm.plugin.webview.wepkg.model.g.a() {
                    public final void H(JSONObject jSONObject) {
                        Map hashMap = new HashMap();
                        hashMap.put("wepkg_info", jSONObject);
                        g.this.a(iVar, "getLocalWePkgInfo:ok", hashMap);
                    }
                });
            }
        });
        return true;
    }

    static /* synthetic */ boolean cQ(g gVar, i iVar) {
        boolean z = false;
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openGameWebView:fail_invalid_url", null);
        } else {
            int i;
            boolean z2;
            String oM;
            final Intent intent;
            com.tencent.mm.sdk.b.b goVar;
            String oM2 = bi.oM((String) iVar.pug.get("orientation"));
            if (!bi.oN(oM2)) {
                if (oM2.equals("horizontal")) {
                    i = 0;
                } else if (oM2.equals("vertical")) {
                    i = 1;
                } else if (oM2.equals("sensor")) {
                    i = 4;
                }
                z2 = bi.oM((String) iVar.pug.get("fullscreen")).equals("true");
                if (bi.oM((String) iVar.pug.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                oM = bi.oM((String) iVar.pug.get("gameAppid"));
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_scene", 32);
                intent.putExtra("KPublisherId", "game_webview");
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                intent.putExtra("game_hv_menu_appid", oM);
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.fCC, new Runnable() {
                    public final void run() {
                        com.tencent.mm.bl.d.b(g.this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                    }
                });
                goVar = new go();
                goVar.fxy.pK = 2;
                goVar.fxy.fxA = oM;
                com.tencent.mm.sdk.b.a.xmy.m(goVar);
                gVar.a(iVar, "openGameWebView:ok", null);
            }
            i = -1;
            if (bi.oM((String) iVar.pug.get("fullscreen")).equals("true")) {
            }
            if (bi.oM((String) iVar.pug.get("disable_swipe_back")).equals("1")) {
                z = true;
            }
            oM = bi.oM((String) iVar.pug.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", "game_webview");
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            intent.putExtra("game_hv_menu_appid", oM);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.fCC, /* anonymous class already generated */);
            goVar = new go();
            goVar.fxy.pK = 2;
            goVar.fxy.fxA = oM;
            com.tencent.mm.sdk.b.a.xmy.m(goVar);
            gVar.a(iVar, "openGameWebView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cS(g gVar, final i iVar) {
        x.i("MicroMsg.MsgHandler", "doLoginOrAuthorize!");
        Runnable anonymousClass115 = new Runnable() {
            public final void run() {
                if (iVar.tQg.equals("login")) {
                    g.this.a(iVar, g.tOy);
                } else if (iVar.tQg.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME)) {
                    g.this.b(iVar, g.tOy);
                }
            }
        };
        if (tOx) {
            tOw.add(anonymousClass115);
            x.i("MicroMsg.MsgHandler", "add to authJsApiQueue!");
        } else {
            tOx = true;
            anonymousClass115.run();
        }
        return true;
    }

    static /* synthetic */ boolean cT(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start do check is support face detect");
        com.tencent.mm.sdk.b.b hlVar = new hl();
        com.tencent.mm.sdk.b.a.xmy.m(hlVar);
        boolean z = hlVar.fyD.fyE;
        int i = hlVar.fyD.fyF;
        x.i("MicroMsg.MsgHandler", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(z), Integer.valueOf(i), hlVar.fyD.fyG, Integer.valueOf(hlVar.fyD.fyH));
        Map hashMap = new HashMap();
        hashMap.put("err_code", String.valueOf(i));
        hashMap.put("err_msg", r3);
        hashMap.put("lib_version_code", String.valueOf(r0));
        gVar.a(iVar, "doCheckIsSupportFaceDetect: ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean cX(g gVar, i iVar) {
        final String oM = bi.oM((String) iVar.pug.get("base64DataString"));
        final String oM2 = bi.oM((String) iVar.pug.get("thumbUrl"));
        final String oM3 = bi.oM((String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        final String oM4 = bi.oM((String) iVar.pug.get("activityId"));
        if (!bi.oN(oM)) {
            final i iVar2 = iVar;
            as.Dt().F(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
                    int indexOf = oM.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = oM.substring(indexOf + 8, oM.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bi.by(decode)) {
                            g.this.a(iVar2, "addToEmoticon:fail", null);
                            return;
                        }
                        String s = com.tencent.mm.a.g.s(decode);
                        as.Hm();
                        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", s);
                        if (!(com.tencent.mm.a.e.bO(I) && com.tencent.mm.a.g.bV(I).equalsIgnoreCase(s))) {
                            com.tencent.mm.a.e.b(I, decode, decode.length);
                        }
                        g.a(g.this, s, oM2, oM4);
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + e.getMessage());
                        g.this.a(iVar2, "addToEmoticon:fail_" + e.getMessage(), null);
                    }
                }
            });
        } else if (bi.oN(oM3)) {
            x.e("MicroMsg.MsgHandler", "doAddToEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "addToEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doAddToEmoticon use url:%s", oM3);
            final File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.s(oM3.getBytes()));
            if (file.exists()) {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        String i = com.tencent.mm.a.g.i(file);
                        as.Hm();
                        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", i);
                        if (!FileOp.bO(I)) {
                            FileOp.x(file.getAbsolutePath(), I);
                        }
                        g.a(g.this, i, oM2, oM4);
                    }
                });
            } else {
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFl = true;
                aVar.hFn = file.getAbsolutePath();
                aVar.hFO = new Object[]{file.getAbsolutePath()};
                final i iVar3 = iVar;
                com.tencent.mm.plugin.emoji.model.i.aBL().a(oM3, null, aVar.PQ(), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        x.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", str);
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            g.this.a(iVar3, "addToEmoticon:fail", null);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            g.this.a(iVar3, "addToEmoticon:fail", null);
                        } else if (str.equals(oM3)) {
                            File file = new File(objArr[0].toString());
                            if (file.exists()) {
                                String i = com.tencent.mm.a.g.i(file);
                                as.Hm();
                                FileOp.x(file.getAbsolutePath(), EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", i));
                                g.a(g.this, i, oM2, oM4);
                                return;
                            }
                            g.this.a(iVar3, "addToEmoticon:fail", null);
                        } else {
                            g.this.a(iVar3, "addToEmoticon:fail", null);
                        }
                    }
                });
            }
        }
        return true;
    }

    static /* synthetic */ boolean cY(g gVar, final i iVar) {
        final String oM = bi.oM((String) iVar.pug.get("base64DataString"));
        final String oM2 = bi.oM((String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        final String oM3 = bi.oM((String) iVar.pug.get("activityId"));
        if (!bi.oN(oM)) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
                    int indexOf = oM.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = oM.substring(indexOf + 8, oM.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bi.by(decode)) {
                            g.this.a(iVar, "shareEmoticon:fail", null);
                            return;
                        }
                        String s = com.tencent.mm.a.g.s(decode);
                        if (bi.oN(s)) {
                            g.this.a(iVar, "shareEmoticon:fail empty buffer", null);
                            return;
                        }
                        as.Hm();
                        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", s);
                        if (!(com.tencent.mm.a.e.bO(I) && com.tencent.mm.a.g.bV(I).equalsIgnoreCase(s))) {
                            com.tencent.mm.a.e.b(I, decode, decode.length);
                        }
                        ah.y(new Runnable(s, oM3) {
                            public final void run() {
                                Intent intent = new Intent();
                                intent.putExtra("scene_from", 4);
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("Retr_Msg_Type", 5);
                                intent.putExtra("Retr_Msg_thumb_path", r2);
                                intent.putExtra("emoji_activity_id", r3);
                                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                                if (g.this.context instanceof MMActivity) {
                                    com.tencent.mm.bl.d.a((MMActivity) g.this.context, ".ui.transmit.SelectConversationUI", intent, 52, g.this);
                                }
                            }
                        });
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + e.getMessage());
                        g.this.a(iVar, "shareEmoticon:fail_" + e.getMessage(), null);
                    }
                }
            });
        } else if (bi.oN(oM2)) {
            x.e("MicroMsg.MsgHandler", "doShareEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "shareEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doShareEmoticon use url:%s", oM2);
            final File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.s(oM2.getBytes()));
            if (file.exists()) {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        String i = com.tencent.mm.a.g.i(file);
                        as.Hm();
                        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", i);
                        if (!FileOp.bO(I)) {
                            FileOp.x(file.getAbsolutePath(), I);
                        }
                        ah.y(/* anonymous class already generated */);
                    }
                });
            } else {
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFl = true;
                aVar.hFn = file.getAbsolutePath();
                aVar.hFO = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.i.aBL().a(oM2, null, aVar.PQ(), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        x.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", str);
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            g.this.a(iVar, "shareEmoticon:fail", null);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            g.this.a(iVar, "shareEmoticon:fail", null);
                        } else if (str.equals(oM2)) {
                            File file = new File(objArr[0].toString());
                            if (file.exists()) {
                                String i = com.tencent.mm.a.g.i(file);
                                as.Hm();
                                FileOp.x(file.getAbsolutePath(), EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", i));
                                ah.y(/* anonymous class already generated */);
                                return;
                            }
                            g.this.a(iVar, "shareEmoticon:fail", null);
                        } else {
                            g.this.a(iVar, "shareEmoticon:fail", null);
                        }
                    }
                });
            }
        }
        return true;
    }

    static /* synthetic */ boolean cZ(g gVar, i iVar) {
        ((MMActivity) gVar.context).jCj = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 3);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.pug.get("request_ticket"));
        com.tencent.mm.sdk.b.b noVar = new no();
        noVar.fGv.context = gVar.context;
        noVar.fGv.fGx = 50;
        noVar.fGv.extras = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(noVar);
        x.i("MicroMsg.MsgHandler", "hy: start face register rsa event result: %b", Boolean.valueOf(noVar.fGw.fGy));
        if (!noVar.fGw.fGy) {
            ((MMActivity) gVar.context).jCj = null;
            gVar.a(iVar, "requestWxFaceRegisterInternal:fail", i.aa(noVar.fGw.extras));
        }
        return true;
    }

    static /* synthetic */ boolean ca(g gVar, final i iVar) {
        String str = (String) iVar.pug.get("username");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "user name is null or nil");
            gVar.a(iVar, "add_contact:fail", null);
            return false;
        }
        String str2 = (String) iVar.pug.get("profileReportInfo");
        x.i("MicroMsg.MsgHandler", "get scene = %s", (String) iVar.pug.get("scene"));
        final com.tencent.mm.pluginsdk.ui.applet.b bVar = new com.tencent.mm.pluginsdk.ui.applet.b(gVar.context, str, bi.getInt(r0, 91), new l() {
            public final void ks(int i) {
                switch (i) {
                    case -2:
                        g.this.a(iVar, "quickly_add_contact:added", null);
                        return;
                    case -1:
                        g.this.a(iVar, "quickly_add_contact:fail", null);
                        return;
                    case 0:
                        g.this.a(iVar, "quickly_add_contact:cancel", null);
                        return;
                    case 1:
                        g.this.a(iVar, "quickly_add_contact:ok", null);
                        return;
                    default:
                        g.this.a(iVar, "quickly_add_contact:fail", null);
                        return;
                }
            }
        }, false, str2);
        ah.y(new Runnable() {
            public final void run() {
                bVar.show();
            }
        });
        return true;
    }

    static /* synthetic */ boolean cb(g gVar, i iVar) {
        String str = (String) iVar.pug.get("consumedCardId");
        String str2 = (String) iVar.pug.get("consumedCode");
        x.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is " + str);
        if (bi.oN(str) || bi.oN(str2)) {
            x.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", str, str2);
            gVar.a(iVar, "consumedShareCard:fail", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) gVar.context).jCj = gVar;
        com.tencent.mm.bl.d.b(gVar.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        return true;
    }

    static /* synthetic */ boolean cc(g gVar, i iVar) {
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str2 = (String) iVar.pug.get("open_game_webview");
        x.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s", str);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openUrlWithExtraWebview:fail_invalid_url", null);
        } else {
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("convertActivityFromTranslucent", false);
            if (bi.oM(str2).equals("1")) {
                com.tencent.mm.sdk.b.b kkVar = new kk();
                kkVar.fCB.type = 0;
                kkVar.fCB.context = gVar.context;
                kkVar.fCB.intent = intent;
                kkVar.fCB.fCC = gVar.fCC;
                com.tencent.mm.sdk.b.a.xmy.m(kkVar);
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", gVar.fCC, new Runnable() {
                    public final void run() {
                        com.tencent.mm.bl.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
            gVar.a(iVar, "openUrlWithExtraWebview:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean ch(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", Integer.valueOf(bi.getInt((String) iVar.pug.get("selectMode"), 0)));
        Intent intent = new Intent();
        if (bi.getInt((String) iVar.pug.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", 263);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", 259);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", q.FY());
        intent.putExtra("scene_from", 4);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bl.d.a((MMActivity) gVar.context, ".ui.transmit.SelectConversationUI", intent, 30, (com.tencent.mm.ui.MMActivity.a) gVar);
        }
        return true;
    }

    static /* synthetic */ boolean cm(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = bi.getInt((String) iVar.pug.get("tid"), 0);
        String str = (String) iVar.pug.get("title");
        String str2 = (String) iVar.pug.get("desc");
        String str3 = (String) iVar.pug.get("iconUrl");
        String str4 = (String) iVar.pug.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        gVar.a(iVar, "openEmoticonTopicList", null);
        return true;
    }

    static /* synthetic */ boolean cn(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) iVar.pug.get("ProductId");
        x.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", Long.valueOf(bi.getLong((String) iVar.pug.get("searchID"), 0)));
        if (bi.oN(str)) {
            x.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            gVar.a(iVar, "openEmotionDetailView", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (gVar.tOa) {
            x.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.bl.d.b(gVar.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            gVar.tOa = true;
        }
        gVar.a(iVar, "openEmotionDetailView", null);
        com.tencent.mm.plugin.report.service.g.pWK.h(13055, Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.aj.a.Np()), Long.valueOf(r4));
        return true;
    }

    static /* synthetic */ boolean co(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.modeltools.f.bSj();
        Map map = iVar.pug;
        String Nn = com.tencent.mm.aj.a.Nn();
        if (bi.oN(Nn)) {
            x.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            return false;
        }
        int s = com.tencent.mm.plugin.webview.c.a.s(map, Columns.TYPE);
        String r = com.tencent.mm.plugin.webview.c.a.r(map, "pageName");
        String r2 = com.tencent.mm.plugin.webview.c.a.r(map, "keyword");
        int s2 = com.tencent.mm.plugin.webview.c.a.s(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + Nn + "/" + r + "?type=" + s + "&keyword=" + r2 + "&scene=" + s2 + "&lang=" + w.eM(ad.getContext()) + "&clientType=1&version=" + com.tencent.mm.aj.a.Np());
        intent.putExtra("keyword", r2);
        intent.putExtra(Columns.TYPE, s);
        intent.putExtra("sence", s2);
        com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.pWK.h(13055, Integer.valueOf(1), "", "", Integer.valueOf(s), Integer.valueOf(com.tencent.mm.aj.a.Np()), Long.valueOf(0));
        com.tencent.mm.sdk.b.b lxVar = new lx();
        lxVar.fEd.type = s;
        lxVar.fEd.fEe = r2;
        lxVar.fEd.fEf = "";
        com.tencent.mm.sdk.b.a.xmy.m(lxVar);
        return true;
    }

    static /* synthetic */ boolean cq(g gVar, i iVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.modeltools.f.bSj();
        String r = com.tencent.mm.plugin.webview.c.a.r(iVar.pug, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", r);
        com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return false;
    }

    static /* synthetic */ boolean cu(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) gVar.context).jCj = gVar;
        Bundle ap = i.ap(iVar.pug);
        Intent intent = new Intent();
        intent.putExtras(ap);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        String qZ = gVar.qZ(gVar.aeH());
        if (qZ == null) {
            qZ = (String) iVar.pug.get("appId");
        }
        intent.putExtra("key_app_id", qZ);
        com.tencent.mm.bl.d.b(gVar.context, "soter_mp", ".ui.SoterAuthenticationUI", intent, 38);
        return true;
    }

    static /* synthetic */ boolean cv(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: do get soter support");
        com.tencent.mm.sdk.b.b hmVar = new hm();
        com.tencent.mm.sdk.b.a.xmy.m(hmVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(hmVar.fyI.fyJ));
        gVar.a(iVar, "getSupportSoter", hashMap);
        gVar.a(iVar, 0, hmVar.fyI.fyJ == 1 ? 1 : 0);
        return true;
    }

    static /* synthetic */ boolean cw(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        String str = (String) iVar.pug.get("appId");
        if (gVar.tNQ != null) {
            if (TextUtils.isEmpty(str)) {
                str = gVar.tNQ.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = gVar.tNZ.Qf(gVar.aeH());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.aeH());
        ((MMActivity) gVar.context).jCj = gVar;
        com.tencent.mm.bl.d.a(gVar.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        return true;
    }

    static /* synthetic */ boolean cy(g gVar, i iVar) {
        gVar.mgx = false;
        String obj = iVar.pug.get("chat_username").toString();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", obj);
        intent.putExtra("finish_direct", true);
        intent.putExtra("expose_edit_mode", true);
        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bl.d.a((MMActivity) gVar.context, ".ui.chatting.ChattingUI", intent, 40, (com.tencent.mm.ui.MMActivity.a) gVar);
        }
        return true;
    }

    static /* synthetic */ boolean d(g gVar, final i iVar) {
        int i = 33;
        String str = (String) iVar.pug.get("webtype");
        String str2 = (String) iVar.pug.get("username");
        String str3 = (String) iVar.pug.get("scene");
        String str4 = (String) iVar.pug.get("profileReportInfo");
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            gVar.Qm(str3);
            int i2 = bi.getInt(str, -1);
            if (i2 != -1) {
                k.a(iVar.tQf, false, str2, null);
                switch (i2) {
                    case 1:
                        if (gVar.tNQ != null) {
                            i = gVar.tNQ.getInt("Contact_Scene", 33);
                        }
                        new com.tencent.mm.pluginsdk.ui.applet.b(gVar.context, str2, i, new l() {
                            public final void ks(int i) {
                                switch (i) {
                                    case -2:
                                        g.this.a(iVar, "add_contact:added", null);
                                        return;
                                    case -1:
                                        g.this.a(iVar, "add_contact:fail", null);
                                        return;
                                    case 0:
                                        g.this.a(iVar, "add_contact:cancel", null);
                                        return;
                                    case 1:
                                        g.this.a(iVar, "add_contact:ok", null);
                                        return;
                                    default:
                                        g.this.a(iVar, "add_contact:fail", null);
                                        return;
                                }
                            }
                        }, str4).show();
                        break;
                    default:
                        x.e("MicroMsg.MsgHandler", "unknown addScene = " + i2);
                        gVar.a(iVar, "add_contact:fail", null);
                        break;
                }
            }
            x.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = " + str);
            gVar.a(iVar, "add_contact:fail", null);
        } else {
            x.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            gVar.a(iVar, "add_contact:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean d(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        final String str = (String) iVar.pug.get("appid");
        String str2 = (String) iVar.pug.get("extInfo");
        final String str3 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        final String str4 = (String) iVar.pug.get("task_url");
        if (!ao.isNetworkConnected(gVar.context)) {
            Toast.makeText(gVar.context, gVar.context.getString(R.l.emu), 0).show();
            gVar.a(iVar, "doResumeDownloadTask:fail_network_not_connected", null);
            x.i("MicroMsg.MsgHandler", "doResumeDownloadTask fail, network not ready");
            v(str, com.tencent.mm.plugin.downloader.model.d.lxM, str2);
        } else if (ao.isWifi(gVar.context)) {
            gVar.x(iVar);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(14217, str, Integer.valueOf(4), str3, str4, Integer.valueOf(3));
            Context context = gVar.context;
            String string = gVar.context.getString(R.l.eWR);
            String string2 = gVar.context.getString(R.l.eWS);
            String string3 = gVar.context.getString(R.l.eWM);
            String string4 = gVar.context.getString(R.l.dEy);
            final i iVar2 = iVar;
            final JsapiPermissionWrapper jsapiPermissionWrapper2 = jsapiPermissionWrapper;
            AnonymousClass43 anonymousClass43 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14217, str, Integer.valueOf(5), str3, str4, Integer.valueOf(3));
                    g.this.x(iVar2);
                    dialogInterface.dismiss();
                }
            };
            final String str5 = str;
            final String str6 = str3;
            final String str7 = str4;
            final i iVar3 = iVar;
            AnonymousClass44 anonymousClass44 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14217, str5, Integer.valueOf(6), str6, str7, Integer.valueOf(3));
                    dialogInterface.dismiss();
                    g.this.a(iVar3, "doResumeDownloadTask:fail_network_not_wifi", null);
                }
            };
            com.tencent.mm.ui.base.h.a(context, string, string2, string3, string4, false, (OnClickListener) anonymousClass43, (OnClickListener) anonymousClass44, R.e.buj);
        }
        return true;
    }

    static /* synthetic */ boolean dC(g gVar, i iVar) {
        gVar.mgx = false;
        if ("1".equals(iVar.pug.get("isDeleteAll"))) {
            com.tencent.mm.plugin.webview.modeltools.f.bSl();
            ((m) com.tencent.mm.kernel.g.k(m.class)).deleteSOSHistory();
        } else {
            com.tencent.mm.plugin.webview.modeltools.f.bSl();
            ((m) com.tencent.mm.kernel.g.k(m.class)).deleteSOSHistory((String) iVar.pug.get("query"));
        }
        return false;
    }

    static /* synthetic */ boolean dF(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do open offline pay view");
        ((MMActivity) gVar.context).jCj = gVar;
        Context context = gVar.context;
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("key_from_scene", 6);
        intent.putExtra("pay_channel", gVar2.frE);
        com.tencent.mm.bl.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent, 60);
        return true;
    }

    static /* synthetic */ boolean dG(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.frE);
        intent.putExtra("intent_jump_package", "wallet");
        x.i("MicroMsg.MsgHandler", "appid %s timeStamp %s nonceStr %s packageExt %s signType %s", bi.aD((String) iVar.pug.get("appid"), ""), gVar2.timeStamp, gVar2.nonceStr, gVar2.packageExt, gVar2.signType);
        intent.putExtra("intent_jump_ui", ".bind.ui.WalletBankcardManageUI");
        ((MMActivity) gVar.context).jCj = gVar;
        com.tencent.mm.bl.d.b(gVar.context, "wallet", ".ui.WalletJsApiAdapterUI", intent, 59);
        return true;
    }

    static /* synthetic */ void dN(g gVar, final i iVar) {
        if (gVar.context == null) {
            gVar.a(iVar, "chooseIdCard:fail", null);
            return;
        }
        if (!gVar.tOc.a("identity_pay_auth", gVar.context, new com.tencent.mm.plugin.webview.modeltools.d.a() {
            public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                if (bitmap == null) {
                    g.this.a(iVar, "chooseIdCard:fail", null);
                    return;
                }
                try {
                    String str2 = com.tencent.mm.compatible.util.e.hbv + "tmpScanLicense/";
                    x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", str2);
                    if (FileOp.bO(str2)) {
                        FileOp.G(str2, true);
                    }
                    FileOp.ml(str2);
                    FileOp.mn(str2);
                    str2 = str2 + System.currentTimeMillis() + ".jpg";
                    x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", str2);
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, str2, true);
                    WebViewJSSDKFileItem OP = WebViewJSSDKFileItem.OP(str2);
                    com.tencent.mm.plugin.webview.modeltools.f.bSo().b(OP);
                    Map hashMap = new HashMap();
                    hashMap.put("sourceType", "scan");
                    hashMap.put("localId", OP.fvn);
                    g.this.a(iVar, "chooseIdCard:ok", hashMap);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "save scan license error: %s", e.getMessage());
                    g.this.a(iVar, "chooseIdCard:fail", null);
                }
            }

            public final void Pl(String str) {
                g.this.a(iVar, "chooseIdCard:cancel", null);
            }

            public final void LE(String str) {
                g.this.a(iVar, "chooseIdCard:fail", null);
            }
        })) {
            gVar.a(iVar, "chooseIdCard:fail", null);
        }
    }

    static /* synthetic */ void dO(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "real scene = %d", Integer.valueOf(3));
        x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")));
        if (com.tencent.mm.pluginsdk.g.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_capture", 3);
            intent.putExtra("key_pick_local_pic_query_source_type", 8);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_pick_local_pic_count", 1);
            x.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", Integer.valueOf(3), Integer.valueOf(8));
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).jCj = gVar;
                com.tencent.mm.bl.d.a(gVar.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
                return;
            }
            return;
        }
        gVar.a(iVar, "chooseIdCard:fail", null);
    }

    static /* synthetic */ boolean da(g gVar, i iVar) {
        ((MMActivity) gVar.context).jCj = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", ar.hhz.H("login_user_name", ""));
        bundle.putInt("k_server_scene", 4);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.pug.get("request_ticket"));
        com.tencent.mm.sdk.b.b noVar = new no();
        noVar.fGv.context = gVar.context;
        noVar.fGv.fGx = 51;
        noVar.fGv.extras = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(noVar);
        x.i("MicroMsg.MsgHandler", "hy: start face verify rsa event result: %b", Boolean.valueOf(noVar.fGw.fGy));
        if (!noVar.fGw.fGy) {
            ((MMActivity) gVar.context).jCj = null;
            gVar.a(iVar, "requestWxFaceVerifyInternal:fail", i.aa(noVar.fGw.extras));
        }
        return true;
    }

    static /* synthetic */ boolean dc(g gVar, i iVar) {
        gVar.mgx = false;
        String str = (String) iVar.pug.get("selected_user_name");
        Intent intent = new Intent();
        intent.putExtra("list_type", 15);
        intent.putExtra("already_select_contact", str);
        intent.putExtra("titile", gVar.context.getString(R.l.dDz));
        intent.putExtra("list_attr", s.p(16384, 1, 4, 1048576));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bl.d.a((MMActivity) gVar.context, ".ui.contact.SelectContactUI", intent, 54, (com.tencent.mm.ui.MMActivity.a) gVar);
        }
        return true;
    }

    static /* synthetic */ boolean dd(g gVar, i iVar) {
        gVar.mgx = false;
        String str = (String) iVar.pug.get("phoneNumber");
        x.d("MicroMsg.MsgHandler", "jsapi makePhoneCall num %s", str);
        if (TextUtils.isEmpty(str)) {
            gVar.a(iVar, "makePhoneCall:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bi.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
            gVar.a(iVar, "makePhoneCall:succ", null);
        }
        return true;
    }

    static /* synthetic */ boolean de(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        intent.putExtra("appId", bi.aD((String) iVar.pug.get("appid"), ""));
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("reset_pwd_token", gVar2.vGw);
        intent.putExtra("pay_channel", gVar2.frE);
        ((MMActivity) gVar.context).jCj = gVar;
        com.tencent.mm.bl.d.b(gVar.context, "wallet", ".pwd.ui.WalletResetPwdAdapterUI", intent, 55);
        return true;
    }

    static /* synthetic */ boolean df(g gVar, i iVar) {
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        x.i("MicroMsg.MsgHandler", "doChooseInvoiceTitle");
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "address", ".ui.InvoiceListUI", intent, 56, false);
        }
        return true;
    }

    static /* synthetic */ boolean do(g gVar, i iVar) {
        gVar.mgx = false;
        Map hashMap = new HashMap();
        hashMap.put("query", com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "query"));
        hashMap.put("scene", Integer.valueOf(33));
        if (iVar.pug.containsKey(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
            com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr = new cbg();
            com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr.xhj = new io();
            com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr.xhj.vVt = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, SlookSmartClipMetaTag.TAG_TYPE_URL);
        }
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        String r = com.tencent.mm.plugin.webview.fts.f.r(hashMap, "query");
        if (!bi.oN(r)) {
            int c = com.tencent.mm.plugin.webview.fts.f.c(hashMap, "scene", 3);
            int c2 = com.tencent.mm.plugin.webview.fts.f.c(hashMap, Columns.TYPE, 0);
            String zZ = com.tencent.mm.plugin.aj.a.g.zZ(c);
            Intent QT = com.tencent.mm.bb.b.QT();
            QT.putExtra("ftsbizscene", c);
            QT.putExtra("ftsType", c2);
            QT.putExtra("sessionId", zZ);
            QT.putExtra("ftsQuery", r);
            QT.putExtra("ftsInitToSearch", true);
            hashMap = com.tencent.mm.bb.b.b(c, true, 0);
            hashMap.put("query", r);
            hashMap.put("sessionId", zZ);
            QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(hashMap));
            com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QT);
        }
        return false;
    }

    static /* synthetic */ boolean dw(g gVar, final i iVar) {
        x.i("MicroMsg.MsgHandler", "do handle wcpay buffer");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        final com.tencent.mm.sdk.b.b ssVar = new ss();
        ssVar.fLp.action = (String) iVar.pug.get("action");
        ssVar.fLp.buffer = (String) iVar.pug.get("buffer");
        ssVar.fLp.fLt = bi.getInt((String) iVar.pug.get("walletRegion"), 0);
        ssVar.fLp.appId = gVar2.appId;
        ssVar.fLp.fry = gVar2.timeStamp;
        ssVar.fLp.nonceStr = gVar2.nonceStr;
        ssVar.fLp.fLs = gVar2.fDO;
        ssVar.fLp.signType = gVar2.signType;
        ssVar.fLp.fLr = gVar2.packageExt;
        ssVar.fLp.url = gVar2.url;
        ssVar.fLq.fLu = new Runnable() {
            public final void run() {
                if (ssVar.fLq.retCode == 0) {
                    Map hashMap = new HashMap();
                    hashMap.put("buffer", ssVar.fLq.buffer);
                    g.this.a(iVar, "handleWCPayWalletBuffer:ok", hashMap);
                } else if (ssVar.fLq.retCode == -2) {
                    g.this.a(iVar, "handleWCPayWalletBuffer:null", null);
                } else {
                    g.this.a(iVar, "handleWCPayWalletBuffer:fail", null);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(ssVar);
        return true;
    }

    static /* synthetic */ void e(g gVar) {
        com.tencent.mm.sdk.b.a.xmy.b(gVar.qyk);
        gVar.tOl = (LocationManager) gVar.context.getSystemService("location");
        tNY = gVar.aU(gVar.tNN);
        gVar.tNV = gVar.fCC;
        tNX = gVar.context;
        gVar.tNO = gVar.tNN;
    }

    static /* synthetic */ boolean f(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "jslog : " + iVar.pug.get("msg"));
        gVar.mgx = false;
        return false;
    }

    static /* synthetic */ boolean f(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        iVar.pug.put(Columns.TYPE, Integer.valueOf(262144));
        com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr = new cbg();
        com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr.xhj = new io();
        com.tencent.mm.plugin.webview.modeltools.f.bSm().tsr.xhj.vVq = 1;
        return gVar.aV(iVar);
    }

    static /* synthetic */ boolean g(g gVar) {
        gVar.mgx = false;
        com.tencent.mm.plugin.webview.fts.e bSl = com.tencent.mm.plugin.webview.modeltools.f.bSl();
        x.i("MicroMsg.FTS.FTSWebViewLogic", "getSearchHistory count %d, webviewId %d", Integer.valueOf(20), Integer.valueOf(gVar.fEg));
        com.tencent.mm.plugin.fts.a.a.g fVar = new f(bSl, (byte) 0);
        fVar.fEe = "";
        fVar.mRH = 20;
        fVar.mRK = bSl.tsM;
        fVar.ttm = r1;
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(8, fVar);
        return false;
    }

    static /* synthetic */ boolean g(g gVar, i iVar) {
        if (ao.isConnected(gVar.context)) {
            x.i("MicroMsg.MsgHandler", "getNetworkType, type = " + ao.getNetType(gVar.context));
            Map hashMap = new HashMap();
            if (ao.is2G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.is3G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.is4G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.isWifi(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                gVar.a(iVar, "network_type:wifi", null);
            } else {
                x.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                gVar.a(iVar, "network_type:fail", null);
            }
        } else {
            x.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            gVar.a(iVar, "network_type:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean h(g gVar) {
        if (gVar.context != null && (gVar.context instanceof MMActivity)) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.c(gVar.context, "setting", ".ui.setting.SettingsModifyEmailAddrUI", 58);
        }
        return true;
    }

    static /* synthetic */ boolean h(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        final String str = (String) iVar.pug.get("appid");
        final String str2 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str3 = (String) iVar.pug.get("extInfo");
        final String str4 = (String) iVar.pug.get("task_url");
        if (!ao.isNetworkConnected(gVar.context)) {
            Toast.makeText(gVar.context, gVar.context.getString(R.l.emu), 0).show();
            gVar.a(iVar, "add_download_task_straight:fail_network_not_connected", null);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, network not ready");
            v(str, com.tencent.mm.plugin.downloader.model.d.lxM, str3);
        } else if (ao.isWifi(gVar.context)) {
            gVar.w(iVar);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(14217, str, Integer.valueOf(4), str2, str4, Integer.valueOf(3));
            Context context = gVar.context;
            String string = gVar.context.getString(R.l.eWR);
            String string2 = gVar.context.getString(R.l.eWS);
            String string3 = gVar.context.getString(R.l.eWM);
            String string4 = gVar.context.getString(R.l.dEy);
            final i iVar2 = iVar;
            final JsapiPermissionWrapper jsapiPermissionWrapper2 = jsapiPermissionWrapper;
            AnonymousClass36 anonymousClass36 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14217, str, Integer.valueOf(5), str2, str4, Integer.valueOf(3));
                    g.this.w(iVar2);
                    dialogInterface.dismiss();
                }
            };
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str4;
            final i iVar3 = iVar;
            AnonymousClass37 anonymousClass37 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14217, str5, Integer.valueOf(6), str6, str7, Integer.valueOf(3));
                    dialogInterface.dismiss();
                    g.this.a(iVar3, "add_download_task_straight:fail_network_not_wifi", null);
                }
            };
            com.tencent.mm.ui.base.h.a(context, string, string2, string3, string4, false, (OnClickListener) anonymousClass36, (OnClickListener) anonymousClass37, R.e.buj);
        }
        return true;
    }

    static /* synthetic */ boolean l(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bi.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
        }
        gVar.mgx = false;
        return false;
    }

    static /* synthetic */ boolean m(g gVar, i iVar) {
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        x.i("MicroMsg.MsgHandler", "doPay");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            gVar2.vGv = 1;
            x.i("MicroMsg.MsgHandler", "doPay, pay channel: %s, scene: %s", Integer.valueOf(gVar2.frE), Integer.valueOf(gVar2.fDQ));
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 4, gVar);
            long j = bi.getLong((String) iVar.pug.get("message_id"), 0);
            int i = bi.getInt((String) iVar.pug.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pWK.h(10593, gVar2.fDP, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fDQ), gVar2.url);
            gVar.tOf = gVar.aU(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean n(g gVar, i iVar) {
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        x.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        intent.putExtra("req_app_id", (String) iVar.pug.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        return true;
    }

    static /* synthetic */ boolean o(g gVar, i iVar) {
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.e.vDM == null) {
            x.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = new com.tencent.mm.pluginsdk.ui.tools.e();
            r.a(eVar);
            com.tencent.mm.pluginsdk.ui.tools.e.vDM = eVar;
            eVar.eq(gVar.context);
            com.tencent.mm.pluginsdk.ui.tools.e.vDM = eVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vDM.cdj()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vDM.getPitch()));
        x.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vDM.cdj()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vDM.getPitch()));
        gVar.a(iVar, "get_heading_and_pitch:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean q(g gVar, i iVar) {
        if (bi.chp()) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, GP Version not allowed to download");
            gVar.a(iVar, "system:access_denied", null);
            return true;
        }
        String str = (String) iVar.pug.get("task_name");
        String str2 = (String) iVar.pug.get("task_url");
        String str3 = (String) iVar.pug.get("alternative_url");
        long j = bi.getLong((String) iVar.pug.get("task_size"), 0);
        String str4 = (String) iVar.pug.get("file_md5");
        String str5 = (String) iVar.pug.get("extInfo");
        String str6 = (String) iVar.pug.get("fileType");
        String str7 = (String) iVar.pug.get("appid");
        String str8 = (String) iVar.pug.get("package_name");
        String str9 = (String) iVar.pug.get("thumb_url");
        String str10 = (String) iVar.pug.get("title");
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        if (gVar.tNQ != null) {
            int i = gVar.tNQ.getInt("key_download_restrict", 0);
            if (!bi.oN(gVar.tNQ.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14596, r15, Integer.valueOf(i), Integer.valueOf(0));
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                gVar.a(iVar, "add_download_task:fail", null);
                return true;
            }
        }
        if (ao.isNetworkConnected(gVar.context)) {
            as.Hm();
            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                gVar.a(iVar, "add_download_task:fail_sdcard_not_ready", null);
                ah.y(new Runnable() {
                    public final void run() {
                        Toast.makeText(g.this.context, g.this.context.getString(R.l.emw), 0).show();
                    }
                });
                v(str7, com.tencent.mm.plugin.downloader.model.d.lxN, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, sdcard not ready");
                return true;
            } else if (j > 0 && !com.tencent.mm.compatible.util.f.aD(j)) {
                gVar.a(iVar, "add_download_task:fail_sdcard_has_not_enough_space", null);
                ah.y(new Runnable() {
                    public final void run() {
                        Toast.makeText(g.this.context, g.this.context.getString(R.l.emv), 0).show();
                    }
                });
                v(str7, com.tencent.mm.plugin.downloader.model.d.lxN, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, not enough space, require size = " + j);
                return true;
            } else if (bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
                gVar.a(iVar, "add_download_task:fail_invalid_url", null);
                v(str7, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, str5);
                return true;
            } else {
                Intent intent = new Intent();
                intent.setClass(gVar.context, WebViewDownloadUI.class);
                intent.putExtra("task_name", str);
                intent.putExtra("task_url", str2);
                intent.putExtra("alternative_url", str3);
                intent.putExtra("task_size", j);
                intent.putExtra("file_md5", str4);
                intent.putExtra("extInfo", str5);
                intent.putExtra("fileType", str6);
                intent.putExtra("appid", str7);
                intent.putExtra("package_name", str8);
                intent.putExtra("thumb_url", str9);
                intent.putExtra("title", str10);
                intent.putExtra("page_url", (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                intent.putExtra("page_scene", 0);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                gVar.context.startActivity(intent);
                final i iVar2 = iVar;
                gVar.jfV = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.i>() {
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        com.tencent.mm.f.a.i iVar = (com.tencent.mm.f.a.i) bVar;
                        if (!(iVar instanceof com.tencent.mm.f.a.i)) {
                            x.w("MicroMsg.MsgHandler", "mismatched event");
                        } else if (iVar.fnQ.scene != 0) {
                            x.i("MicroMsg.MsgHandler", "not jsapi api callback");
                        } else if (iVar.fnQ.fnR) {
                            x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
                            g.this.a(iVar2, "add_download_task:cancel", null);
                        } else {
                            if (iVar.fnQ.fnS > 0) {
                                Map hashMap = new HashMap();
                                hashMap.put("download_id", Long.valueOf(iVar.fnQ.fnS));
                                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
                                g.this.a(iVar2, "add_download_task:ok", hashMap);
                            } else {
                                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
                                g.this.a(iVar2, "add_download_task:fail", null);
                            }
                            com.tencent.mm.sdk.b.a.xmy.c(g.this.jfV);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.a(gVar.jfV);
                return true;
            }
        }
        gVar.a(iVar, "add_download_task:fail_network_not_connected", null);
        ah.y(new Runnable() {
            public final void run() {
                Toast.makeText(g.this.context, g.this.context.getString(R.l.emu), 0).show();
            }
        });
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, network not ready");
        v(str7, com.tencent.mm.plugin.downloader.model.d.lxM, str5);
        return true;
    }

    static /* synthetic */ boolean r(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.pug.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "cancel_download_task:fail", null);
        } else {
            int bY = com.tencent.mm.plugin.downloader.model.f.aAK().bY(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + bY);
            if (bY <= 0) {
                gVar.a(iVar, "cancel_download_task:fail", null);
            } else {
                gVar.a(iVar, "cancel_download_task:ok", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean s(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.pug.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "pause_download_task:fail", null);
        } else {
            boolean ca = com.tencent.mm.plugin.downloader.model.f.aAK().ca(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + ca);
            if (ca) {
                gVar.a(iVar, "pause_download_task:ok", null);
            } else {
                gVar.a(iVar, "pause_download_task:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean t(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.pug.get("download_id"), -1);
        String str = (String) iVar.pug.get("appid");
        String str2 = (String) iVar.pug.get("appIdArray");
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
        if (!bi.oN(str2)) {
            return gVar.a(str2, iVar);
        }
        FileDownloadTaskInfo bZ;
        if (j > 0) {
            bZ = com.tencent.mm.plugin.downloader.model.f.aAK().bZ(j);
        } else if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
            gVar.a(iVar, "query_download_task:fail", null);
            return true;
        } else {
            bZ = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        }
        switch (bZ.status) {
            case -1:
                x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                gVar.a(iVar, "query_download_task:fail_apilevel_too_low", null);
                return true;
            case 1:
                str2 = "downloading";
                break;
            case 2:
                str2 = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.bO(bZ.path)) {
                    str2 = "default";
                    break;
                }
                str2 = "download_succ";
                break;
            case 4:
                str2 = "download_fail";
                break;
            default:
                str2 = "default";
                break;
        }
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str2);
        Map hashMap = new HashMap();
        hashMap.put("state", str2);
        hashMap.put("download_id", Long.valueOf(bZ.id));
        if (str2 == "downloading" && bZ.fxb != 0) {
            hashMap.put("progress", Long.valueOf((long) ((((float) bZ.fxa) / ((float) bZ.fxb)) * 100.0f)));
        }
        gVar.a(iVar, "query_download_task:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean u(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.pug.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = " + j);
        } else {
            FileDownloadTaskInfo bZ = com.tencent.mm.plugin.downloader.model.f.aAK().bZ(j);
            if (bZ.status == -1) {
                x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                gVar.a(iVar, "install_download_task:fail_apilevel_too_low", null);
            } else if (bZ.status != 3) {
                x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + bZ.status);
            } else if (com.tencent.mm.a.e.bO(bZ.path)) {
                gVar.a(iVar, com.tencent.mm.pluginsdk.model.app.q.e(gVar.context, Uri.fromFile(new File(bZ.path))) ? "install_download_task:ok" : "install_download_task:fail", null);
            }
            return true;
        }
        gVar.a(iVar, "install_download_task:fail", null);
        return true;
    }

    static /* synthetic */ boolean v(g gVar, i iVar) {
        String str = (String) iVar.pug.get("specificview");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            gVar.a(iVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            Bundle bundle = new Bundle();
            String str2 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            String str3 = (String) iVar.pug.get("extinfo");
            bundle.putInt("webview_scene", bi.getInt((String) iVar.pug.get("webview_scene"), 0));
            bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str2);
            bundle.putString("extinfo", str3);
            x.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.ihN.a(gVar.context, str, bundle)));
            if (com.tencent.mm.plugin.webview.a.a.ihN.a(gVar.context, str, bundle)) {
                gVar.a(iVar, "specific_view:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                gVar.a(iVar, "specific_view:not_supported", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean x(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("funcId");
        String str3 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        k.a(iVar.tQf, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jCj = gVar;
            com.tencent.mm.bl.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        return true;
    }

    static /* synthetic */ boolean y(g gVar, i iVar) {
        String str = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
        } else {
            String str2 = (String) iVar.pug.get(SlookAirButtonFrequentContactAdapter.DATA);
            boolean commit = gVar.context.getSharedPreferences(ad.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(str2 == null ? 0 : str2.length());
            x.i(str3, str4, objArr);
            if (commit) {
                gVar.a(iVar, "write_comm_data:ok", null);
                return true;
            }
        }
        gVar.a(iVar, "write_comm_data:fail", null);
        return true;
    }

    static {
        HashSet hashSet = new HashSet();
        jnD = hashSet;
        hashSet.add("gcj02");
        jnD.add("wgs84");
    }

    g(int i) {
        this.fEg = i;
        this.mgx = false;
        this.tNP = new HashSet();
        this.nbS = new HashSet();
        this.tNZ = new c(this.fEg);
        this.tOb = new j();
        this.tOc = new com.tencent.mm.plugin.webview.modeltools.d();
    }

    public final void a(Context context, e eVar) {
        String str = "MicroMsg.MsgHandler";
        String str2 = "set context and callbacker, callbacker %s";
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? "null" : eVar.toString();
        x.i(str, str2, objArr);
        this.context = context;
        if (this.tNZ != null) {
            this.tNZ.a(context, eVar);
        }
        this.fCC = eVar;
    }

    public final void a(Context context, e eVar, e eVar2) {
        x.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.tNZ != null) {
            this.tNZ.a(context, eVar);
        }
        this.fCC = eVar;
        this.tNW = eVar2;
    }

    public final Bundle bVi() {
        if (this.tNQ == null) {
            this.tNQ = new Bundle();
        }
        return this.tNQ;
    }

    public final String qZ(String str) {
        if (this.tNZ != null) {
            return this.tNZ.Qf(str);
        }
        x.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
        return null;
    }

    private void Qm(String str) {
        if (this.tNQ == null) {
            this.tNQ = new Bundle();
        }
        int i = bi.getInt(str, 33);
        if (this.tNQ.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.tNQ.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.tNQ.putInt("Contact_Scene", i);
    }

    private boolean Qn(String str) {
        x.i("MicroMsg.MsgHandler", "getFromMenu, functionName = " + str);
        if (!this.tNP.contains(str)) {
            return false;
        }
        this.tNP.remove(str);
        return true;
    }

    public final boolean Qo(String str) {
        x.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", str, Boolean.valueOf(this.nbS.remove(str)));
        return this.nbS.remove(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r21, com.tencent.mm.protocal.JsapiPermissionWrapper r22) {
        /*
        r20 = this;
        r0 = r20;
        r4 = r0.mgx;
        if (r4 == 0) goto L_0x000f;
    L_0x0006:
        r4 = "MicroMsg.MsgHandler";
        r5 = "handleMsg, MsgHandler is busy, old msg will be overrided";
        com.tencent.mm.sdk.platformtools.x.w(r4, r5);
    L_0x000f:
        r0 = r20;
        r4 = r0.tNQ;
        if (r4 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r20;
        r4 = r0.tNQ;
        r5 = r20.getClass();
        r5 = r5.getClassLoader();
        r4.setClassLoader(r5);
    L_0x0024:
        r0 = r21;
        r1 = r20;
        r1.tNN = r0;
        r4 = 1;
        r0 = r20;
        r0.mgx = r4;
        r0 = r21;
        r4 = r0.type;
        r5 = "call";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0189;
    L_0x003c:
        r0 = r21;
        r4 = r0.tQg;
        r0 = r20;
        r0.tNU = r4;
        r0 = r21;
        r4 = r0.tQg;
        r4 = com.tencent.mm.plugin.webview.ui.tools.a.PB(r4);
        r5 = -1;
        if (r5 == r4) goto L_0x005a;
    L_0x004f:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r8 = (long) r4;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);
    L_0x005a:
        r0 = r20;
        r4 = r0.tNU;
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r4);
        r5 = com.tencent.mm.protocal.c.TR(r4);
        if (r5 != 0) goto L_0x0089;
    L_0x0068:
        r4 = "MicroMsg.MsgHandler";
        r5 = "unknown function = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r20;
        r8 = r0.tNU;
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);
        r4 = "system:function_not_exist";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
    L_0x0088:
        return r4;
    L_0x0089:
        r4 = r5.getName();
        r6 = "recordHistory";
        if (r4 != r6) goto L_0x00b3;
    L_0x0092:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r4, r6, r7);
        r4 = "system:access_denied";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
        goto L_0x0088;
    L_0x00b3:
        r4 = r5.getName();
        r0 = r20;
        r6 = r0.nbS;
        r4 = r6.contains(r4);
        if (r4 != 0) goto L_0x00ee;
    L_0x00c1:
        r4 = r5.cef();
        r0 = r22;
        r4 = r0.CY(r4);
        if (r4 != 0) goto L_0x00ee;
    L_0x00cd:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r4, r6, r7);
        r4 = "system:access_denied";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
        goto L_0x0088;
    L_0x00ee:
        r4 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$1;	 Catch:{ Exception -> 0x0169 }
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r4.<init>(r1, r2, r5);	 Catch:{ Exception -> 0x0169 }
        r0 = r20;
        r0 = r0.tNZ;	 Catch:{ Exception -> 0x0169 }
        r18 = r0;
        r0 = r20;
        r6 = r0.fCC;	 Catch:{ Exception -> 0x0169 }
        r7 = r6.aeH();	 Catch:{ Exception -> 0x0169 }
        r5 = r5.cef();	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r9 = r0.tQg;	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r9);	 Catch:{ Exception -> 0x0169 }
        if (r6 == 0) goto L_0x0133;
    L_0x0115:
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "jsapi is null, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0169 }
        r9 = 0;
        r8[r9] = r7;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r8);	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
    L_0x012d:
        r4 = r4.bUY();	 Catch:{ Exception -> 0x0169 }
        goto L_0x0088;
    L_0x0133:
        if (r22 == 0) goto L_0x0141;
    L_0x0135:
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r7);	 Catch:{ Exception -> 0x0169 }
        if (r6 != 0) goto L_0x0141;
    L_0x013b:
        r0 = r22;
        r6 = r0.vHC;	 Catch:{ Exception -> 0x0169 }
        if (r6 != 0) goto L_0x01ad;
    L_0x0141:
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
        r5 = 3;
        r10 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0169 }
        r5 = 0;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0169 }
        r5 = 1;
        r10[r5] = r9;	 Catch:{ Exception -> 0x0169 }
        r7 = 2;
        if (r22 == 0) goto L_0x01ab;
    L_0x0153:
        r5 = 1;
    L_0x0154:
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0169 }
        r10[r7] = r5;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.e(r6, r8, r10);	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0169 }
        r6 = "localParameters";
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0169:
        r4 = move-exception;
        r5 = "MicroMsg.MsgHandler";
        r6 = "handleMsg excpetion %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.getMessage();
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
        r5 = "MicroMsg.MsgHandler";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
    L_0x0189:
        r4 = "MicroMsg.MsgHandler";
        r5 = new java.lang.StringBuilder;
        r6 = "unknown type = ";
        r5.<init>(r6);
        r0 = r21;
        r6 = r0.type;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = 0;
        r0 = r20;
        r0.mgx = r4;
        r4 = 0;
        goto L_0x0088;
    L_0x01ab:
        r5 = 0;
        goto L_0x0154;
    L_0x01ad:
        r0 = r22;
        r17 = r0.CY(r5);	 Catch:{ Exception -> 0x0169 }
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s";
        r10 = 4;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0169 }
        r11 = 0;
        r10[r11] = r9;	 Catch:{ Exception -> 0x0169 }
        r11 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0169 }
        r10[r11] = r5;	 Catch:{ Exception -> 0x0169 }
        r5 = 2;
        r11 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0169 }
        r10[r5] = r11;	 Catch:{ Exception -> 0x0169 }
        r5 = 3;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r8, r10);	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r5 = r0.tMW;	 Catch:{ Exception -> 0x0169 }
        r5 = r5.get(r7);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r5);	 Catch:{ Exception -> 0x0169 }
        if (r6 == 0) goto L_0x03b3;
    L_0x01e3:
        r0 = r21;
        r5 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r6 = "verifyAppId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r12 = r5;
    L_0x01f1:
        r0 = r21;
        r5 = r0.tQf;	 Catch:{ Exception -> 0x0169 }
        r6 = "permissionValue";
        r8 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0169 }
        r5.put(r6, r8);	 Catch:{ Exception -> 0x0169 }
        r6 = "appId";
        r5.put(r6, r12);	 Catch:{ Exception -> 0x0169 }
        switch(r17) {
            case 0: goto L_0x0257;
            case 1: goto L_0x022d;
            case 2: goto L_0x0238;
            case 3: goto L_0x028f;
            case 4: goto L_0x0262;
            default: goto L_0x0208;
        };	 Catch:{ Exception -> 0x0169 }
    L_0x0208:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0169 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0169 }
        r7 = "unkonwPermission_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0169 }
        r0 = r17;
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "unknow permission";
        com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x022d:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0238:
        r5 = "preVerifyJSAPI";
        r5 = r9.equals(r5);	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x024c;
    L_0x0241:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x024c:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0257:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0262:
        r0 = r18;
        r5 = r0.tMV;	 Catch:{ Exception -> 0x0169 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0169 }
        r6.<init>();	 Catch:{ Exception -> 0x0169 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0169 }
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (com.tencent.mm.protocal.c.ame) r5;	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x028f;
    L_0x027f:
        r5 = r5.vQj;	 Catch:{ Exception -> 0x0169 }
        r6 = 1;
        if (r5 != r6) goto L_0x028f;
    L_0x0284:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x028f:
        r0 = r21;
        r5 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r6 = "verifySignature";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r6 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r8 = "verifyNonceStr";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0169 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r8 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r10 = "verifyTimestamp";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0169 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r10 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r11 = "verifySignType";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0169 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r11 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r13 = "scope";
        r16 = r11.get(r13);	 Catch:{ Exception -> 0x0169 }
        r16 = (java.lang.String) r16;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r11 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r13 = "addrSign";
        r11 = r11.get(r13);	 Catch:{ Exception -> 0x0169 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0169 }
        r13 = "MicroMsg.webview.JSVerifyHelper";
        r14 = "handleJSVerify addrSign = %s, signature = %s";
        r15 = 2;
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x0169 }
        r19 = 0;
        r15[r19] = r11;	 Catch:{ Exception -> 0x0169 }
        r19 = 1;
        r15[r19] = r5;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.i(r13, r14, r15);	 Catch:{ Exception -> 0x0169 }
        r15 = 0;
        r13 = com.tencent.mm.sdk.platformtools.bi.oN(r5);	 Catch:{ Exception -> 0x0169 }
        if (r13 == 0) goto L_0x037c;
    L_0x02f8:
        r11 = com.tencent.mm.sdk.platformtools.bi.oN(r11);	 Catch:{ Exception -> 0x0169 }
        if (r11 != 0) goto L_0x037c;
    L_0x02fe:
        r15 = 1;
        r0 = r21;
        r5 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r6 = "appId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r6 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r8 = "addrSign";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0169 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r8 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r10 = "signType";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0169 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r10 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r11 = "timeStamp";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0169 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r11 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r12 = "nonceStr";
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x0169 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0169 }
        r13 = r8;
        r12 = r6;
        r8 = r5;
    L_0x0343:
        r14 = 0;
        r0 = r21;
        r5 = r0.pug;	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.U(r5);	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x0356;
    L_0x034e:
        r5 = r5.toString();	 Catch:{ Exception -> 0x0169 }
        r14 = r5.getBytes();	 Catch:{ Exception -> 0x0169 }
    L_0x0356:
        r5 = 4;
        r0 = r17;
        if (r0 != r5) goto L_0x0389;
    L_0x035b:
        r5 = new com.tencent.mm.plugin.webview.model.l;	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r0 = r0.tyA;	 Catch:{ Exception -> 0x0169 }
        r17 = r0;
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.y.as.CN();	 Catch:{ Exception -> 0x0169 }
        r7 = 1095; // 0x447 float:1.534E-42 double:5.41E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.y.as.CN();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x037c:
        r11 = com.tencent.mm.sdk.platformtools.bi.oN(r5);	 Catch:{ Exception -> 0x0169 }
        if (r11 != 0) goto L_0x03ad;
    L_0x0382:
        r15 = 2;
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x0343;
    L_0x0389:
        r5 = 3;
        r0 = r17;
        if (r0 != r5) goto L_0x0208;
    L_0x038e:
        r5 = new com.tencent.mm.plugin.webview.model.n;	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r15 = r0.tyA;	 Catch:{ Exception -> 0x0169 }
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.y.as.CN();	 Catch:{ Exception -> 0x0169 }
        r7 = 1094; // 0x446 float:1.533E-42 double:5.405E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.y.as.CN();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x03ad:
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x0343;
    L_0x03b3:
        r12 = r5;
        goto L_0x01f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, com.tencent.mm.protocal.JsapiPermissionWrapper):boolean");
    }

    private boolean b(final i iVar) {
        x.d("MicroMsg.MsgHandler", "doShowDatePicker");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str;
            String str2;
            String str3;
            String str4 = (String) iVar.pug.get("current");
            if (bi.oN(str4)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str4;
            }
            str4 = (String) iVar.pug.get("range");
            if (bi.oN(str4)) {
                str = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str4);
                String optString = jSONObject.optString("start", "2013-01-01");
                str = jSONObject.optString("end", format);
                str2 = optString;
            }
            str4 = (String) iVar.pug.get("fields");
            if (bi.oN(str4)) {
                str3 = "month";
            } else {
                str3 = str4;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                x.e("MicroMsg.MsgHandler", "context error!");
                return false;
            }
            com.tencent.mm.ui.widget.h hVar = new com.tencent.mm.ui.widget.h(this.context, new OnDateSetListener() {
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    x.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3));
                    Map hashMap = new HashMap();
                    hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}));
                    g.this.a(iVar, "showDatePickerView:ok", hashMap);
                }
            }, instance.get(1), instance.get(2), instance.get(5), simpleDateFormat.parse(str2).getTime(), str3);
            hVar.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    x.i("MicroMsg.MsgHandler", "cancel date set");
                    g.this.a(iVar, "showDatePickerView:cancel", null);
                }
            });
            if (!bi.oN(str2)) {
                x.d("MicroMsg.MsgHandler", "min date: %s", str2);
                hVar.getDatePicker().setMinDate(simpleDateFormat.parse(str2).getTime());
            }
            if (!bi.oN(str)) {
                x.d("MicroMsg.MsgHandler", "max date: %s", str);
                hVar.getDatePicker().setMaxDate(simpleDateFormat.parse(str).getTime());
            }
            hVar.show();
            return true;
        } catch (JSONException e) {
        } catch (ParseException e2) {
        }
    }

    private boolean c(i iVar) {
        try {
            String str = (String) this.tNN.pug.get("link");
            k.a(this.tNN.tQf, Qn("shareTimeline"), str, null);
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.tNN, "timeline_check_in:fail", null);
                return true;
            }
            int intValue;
            truncate((String) this.tNN.pug.get("desc"));
            x.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.tNN.pug.get("img_url")) + ", title = " + ((String) this.tNN.pug.get("title")) + ", desc = " + ((String) this.tNN.pug.get("desc")));
            str = (String) this.tNN.pug.get("img_width");
            String str2 = (String) this.tNN.pug.get("img_height");
            x.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", (String) this.tNN.pug.get("link"), ak.Cu((String) this.tNN.pug.get("link")));
            String str3 = (String) this.tNN.pug.get(Columns.TYPE);
            this.tNN.pug.get("desc");
            String str4 = (String) this.tNN.pug.get("title");
            String str5 = (String) this.tNN.pug.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!bi.oN(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!bi.oN(str3) && str3.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.tNN.pug.get("poiId");
            str2 = (String) this.tNN.pug.get("poiName");
            str3 = (String) this.tNN.pug.get("poiAddress");
            float f = bi.getFloat((String) iVar.pug.get("latitude"), 0.0f);
            float f2 = bi.getFloat((String) iVar.pug.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.bl.d.b(this.context, "sns", ".ui.SnsUploadUI", intent);
            this.mgx = false;
            return false;
        } catch (Exception e3) {
            return true;
        }
    }

    private boolean d(i iVar) {
        int i = 0;
        try {
            float f = bi.getFloat((String) iVar.pug.get("latitude"), 0.0f);
            float f2 = bi.getFloat((String) iVar.pug.get("longitude"), 0.0f);
            String vk = vk((String) iVar.pug.get("name"));
            String vk2 = vk((String) iVar.pug.get("address"));
            String vk3 = vk((String) iVar.pug.get("infoUrl"));
            try {
                i = bi.getInt((String) iVar.pug.get("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (bi.getInt((String) this.tNN.pug.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", vk3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", vk);
            intent.putExtra("Kwebmap_locaion", vk2);
            com.tencent.mm.bl.d.b(this.context, "location", ".ui.RedirectUI", intent);
            a(this.tNN, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.tNN, "open_location:invalid_coordinate", null);
        }
        return true;
    }

    private static String vk(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jXA.length) {
                String str2 = jXB[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jXA.length) {
                stringBuffer.append(jXA[i2]);
                i = jXB[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    private boolean e(i iVar) {
        try {
            String str = (String) iVar.pug.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.bl.d.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.tNN, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        return true;
    }

    private boolean b(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.fzX = f(iVar);
        if (this.fzX == null) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(iVar, "send_app_msg:fail", null);
        } else {
            String string = bVi().getString("scene");
            bVi().remove("scene");
            if (!"friend".equals(string)) {
                k.a(iVar.tQf, Qn(GameJsApiSendAppMessage.NAME), null, (String) iVar.pug.get("appid"));
            }
            x.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", string);
            String string2;
            if ("connector".equals(string)) {
                x.i("MicroMsg.MsgHandler", "directly send to %s", bVj());
                b(1, -1, new Intent().putExtra("Select_Conv_User", string2));
            } else if ("favorite".equals(string)) {
                x.i("MicroMsg.MsgHandler", "favorite url");
                com.tencent.mm.sdk.b.b cgVar = new cg();
                com.tencent.mm.plugin.webview.model.b.a aVar = new com.tencent.mm.plugin.webview.model.b.a();
                x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", (String) this.tNN.pug.get("link"), ak.Cu((String) this.tNN.pug.get("link")));
                aVar.url = r4;
                aVar.thumbUrl = (String) this.tNN.pug.get("img_url");
                aVar.title = (String) this.tNN.pug.get("title");
                aVar.desc = (String) this.tNN.pug.get("desc");
                aVar.fGh = (String) this.tNN.pug.get("appid");
                if (this.tNQ != null) {
                    string2 = this.tNQ.getString("key_snsad_statextstr");
                    aVar.fHB = string2;
                } else {
                    string2 = null;
                }
                try {
                    Bundle e = this.fCC.e(18, null);
                    if (e != null) {
                        String hC = com.tencent.mm.y.u.hC(bi.oM(e.getString("KPublisherId")));
                        com.tencent.mm.y.u.b t = com.tencent.mm.y.u.GQ().t(hC, true);
                        t.o("sendAppMsgScene", Integer.valueOf(2));
                        t.o("preChatName", e.getString("preChatName"));
                        t.o("preMsgIndex", Integer.valueOf(e.getInt("preMsgIndex")));
                        t.o("prePublishId", e.getString("prePublishId"));
                        t.o("preUsername", e.getString("preUsername"));
                        t.o("getA8KeyScene", Integer.valueOf(e.getInt("getA8KeyScene")));
                        t.o("referUrl", e.getString("referUrl"));
                        if (!bi.oN(string2)) {
                            t.o("adExtStr", string2);
                        }
                        cgVar.frk.frp = hC;
                    }
                } catch (RemoteException e2) {
                    x.e("MicroMsg.MsgHandler", "try to report error, %s", e2);
                }
                if (this.context instanceof Activity) {
                    cgVar.frk.activity = (Activity) this.context;
                    cgVar.frk.frr = 36;
                }
                com.tencent.mm.plugin.webview.model.b.a(cgVar, aVar);
                cgVar.frk.frt = new com.tencent.mm.ui.snackbar.b.c() {
                    public final void onShow() {
                    }

                    public final void onHide() {
                        g.this.a(g.this.tNN, "send_app_msg:ok", null);
                    }

                    public final void aPu() {
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                if (cgVar.frl.ret == 0) {
                    ep(3, 1);
                    try {
                        a(aVar.fGh, aVar.thumbUrl, 4, this.fCC.e(85, null));
                    } catch (RemoteException e22) {
                        x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", e22);
                    }
                } else {
                    ep(3, 2);
                    a(this.tNN, "send_fav_msg:fail", null);
                }
            } else if ("enterprise".equals(string)) {
                String bVj = bVj();
                Serializable hashMap = new HashMap();
                hashMap.put("img_url", (String) iVar.pug.get("img_url"));
                hashMap.put("desc", (String) iVar.pug.get("desc"));
                hashMap.put("title", (String) iVar.pug.get("title"));
                hashMap.put("src_username", (String) iVar.pug.get("src_username"));
                hashMap.put("src_displayname", (String) iVar.pug.get("src_displayname"));
                x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s", (String) iVar.pug.get("img_url"), (String) iVar.pug.get("desc"), (String) iVar.pug.get("title"));
                Intent intent;
                if (com.tencent.mm.af.f.eG(bVj)) {
                    intent = new Intent();
                    intent.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                    intent.putExtra("enterprise_biz_name", bVj);
                    intent.putExtra("biz_chat_scene", 1);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).jCj = this;
                        ((MMActivity) this.context).b(this, intent, 37);
                    }
                } else if (com.tencent.mm.af.f.ka(bVj)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", bVj);
                    intent.putExtra("enterprise_scene", 3);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).jCj = this;
                        com.tencent.mm.bl.d.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 37);
                    }
                }
            } else if ("wework".equals(string)) {
                ah(iVar);
            } else if ("facebook".equals(string)) {
                Intent intent2 = new Intent();
                intent2.putExtra("title", (String) iVar.pug.get("title"));
                intent2.putExtra("digest", (String) iVar.pug.get("desc"));
                intent2.putExtra("img", (String) iVar.pug.get("img_url"));
                intent2.putExtra("link", (String) iVar.pug.get("link"));
                intent2.setClassName(this.context, "com.tencent.mm.plugin.accountsync.ui.ShareToFacebookRedirectUI");
                this.context.startActivity(intent2);
                a(iVar, "shareQZone:ok", null);
            } else if ("qq".equals(string)) {
                ai(iVar);
            } else {
                x.i("MicroMsg.MsgHandler", "select user to send");
                Serializable hashMap2 = new HashMap();
                if (a(iVar, jsapiPermissionWrapper.go(89))) {
                    this.fzX = f(iVar);
                }
                if (jsapiPermissionWrapper.go(JsApiDestroyInstanceAudio.CTRL_INDEX)) {
                    this.tNN.pug.put("share_callback_with_scene", Boolean.valueOf(true));
                } else {
                    this.tNN.pug.put("share_callback_with_scene", Boolean.valueOf(false));
                }
                hashMap2.put("img_url", (String) iVar.pug.get("img_url"));
                hashMap2.put("desc", (String) iVar.pug.get("desc"));
                hashMap2.put("title", (String) iVar.pug.get("title"));
                hashMap2.put(SlookSmartClipMetaTag.TAG_TYPE_URL, (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s, url=%s", (String) iVar.pug.get("img_url"), (String) iVar.pug.get("desc"), (String) iVar.pug.get("title"), (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                com.tencent.mm.plugin.report.service.g.pWK.a(157, 5, 1, false);
                Intent intent3 = new Intent();
                intent3.putExtra("Select_Conv_Type", 3);
                intent3.putExtra("scene_from", 2);
                intent3.putExtra("mutil_select_is_ret", true);
                intent3.putExtra("webview_params", hashMap2);
                intent3.putExtra("Retr_Msg_Type", 2);
                if (this.context instanceof MMActivity) {
                    iVar.tQf.put("Internal@AsyncReport", Boolean.valueOf(true));
                    if (bi.getInt((String) iVar.pug.get("open_from_scene"), 0) == 4) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(0));
                    }
                    com.tencent.mm.bl.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent3, 1, (com.tencent.mm.ui.MMActivity.a) this);
                }
            }
        }
        return true;
    }

    private boolean a(i iVar, boolean z) {
        Object string;
        int i;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d dVar = null;
        Object obj = iVar.pug.get("__jsapi_fw_ext_info");
        String str = (String) iVar.pug.get("link");
        if (obj instanceof Bundle) {
            string = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            string = null;
        }
        c cVar = this.tNZ;
        if (!TextUtils.isEmpty(string)) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d dVar2 = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.nfh.get(string);
            if (dVar2 == null) {
                dVar2 = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.nfh.get(c.Cv(string));
            }
            dVar = dVar2;
        }
        if (TextUtils.isEmpty(str) || dVar == null || dVar.tNg == null || dVar.tNg.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = str.indexOf("://");
            if (indexOf == -1) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            String substring = str.substring(i2 + indexOf);
            for (String str2 : dVar.tNg) {
                String str22;
                x.i("MicroMsg.MsgHandler", "now domain : %s", str22);
                if (!TextUtils.isEmpty(str22)) {
                    int i3;
                    int indexOf2 = str22.indexOf("://");
                    if (indexOf2 == -1) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                    str22 = str22.substring(i3 + indexOf2);
                    if (!str22.contains("/")) {
                        linkedList.add(str22);
                    } else if (substring.equals(str22)) {
                        i2 = 0;
                        break;
                    } else {
                        if (!str22.endsWith("/")) {
                            str22 = str22 + "/";
                        }
                        if (substring.startsWith(str22)) {
                            i2 = 0;
                            break;
                        }
                    }
                }
            }
            boolean z2 = true;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                URI create = URI.create(str);
                String host = create.getHost();
                int port = create.getPort();
                substring = host + ":" + port;
                x.i("MicroMsg.MsgHandler", "share domain : %s", host);
                if (!bi.oN(host)) {
                    for (String str3 : linkedList) {
                        if (host.equals(str3) || host.endsWith("." + str3) || (port != -1 && (substring.equals(str3) || substring.endsWith("." + str3)))) {
                            i = 0;
                            break;
                        }
                    }
                }
            }
            i = i2;
        }
        if (!(i == 0 && z)) {
            try {
                Bundle e = this.fCC.e(84, null);
                if (e != null) {
                    if (TextUtils.isEmpty(string)) {
                        string = ak.Cu(e.getString("webview_current_url"));
                    }
                    iVar.pug.put("img_url", "");
                    iVar.pug.put("link", string);
                    iVar.pug.put("desc", e.getString("webview_current_desc"));
                    iVar.pug.put("title", e.getString("webview_current_title"));
                    return true;
                }
            } catch (RemoteException e2) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", e2);
            }
        }
        return false;
    }

    private String bVj() {
        String string = bVi().getString("connector_local_send");
        bVi().remove("connector_local_send");
        bVi().putString("connector_local_report", string);
        return string;
    }

    private String bVk() {
        String string = bVi().getString("connector_local_report");
        bVi().remove("connector_local_report");
        return string;
    }

    private static WXMediaMessage f(i iVar) {
        String str = (String) iVar.pug.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "convert fail, link is null");
            return null;
        }
        x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", str, ak.Cu(str));
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) iVar.pug.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) iVar.pug.get("title");
        wXMediaMessage.description = (String) iVar.pug.get("desc");
        return wXMediaMessage;
    }

    private boolean g(i iVar) {
        int i = 0;
        this.mgx = false;
        String obj = iVar.pug.get("list").toString();
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(obj);
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    aup aup = new aup();
                    aup.wJm = optJSONObject.optInt("cmdId");
                    Object optString = optJSONObject.optString("cmdBuffer");
                    if (TextUtils.isEmpty(optString)) {
                        x.e("MicroMsg.MsgHandler", "doUxSearchOpLog cmdId " + aup.wJm + " , cmdBuffer is empty");
                    } else {
                        aup.wJn = new com.tencent.mm.bp.b(optString.getBytes());
                        linkedList.add(aup);
                    }
                }
                i++;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", bi.i(e));
        }
        if (!linkedList.isEmpty()) {
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new bys();
            aVar.hnU = new byt();
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_opsearch";
            aVar.hnS = 1865;
            com.tencent.mm.ad.b Kf = aVar.Kf();
            ((bys) Kf.hnQ.hnY).xfO = linkedList;
            u.a(Kf, new com.tencent.mm.ad.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    x.i("MicroMsg.MsgHandler", "doUxSearchOpLog rsp errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    return 0;
                }
            });
        }
        a(iVar, "uxSearchOpLog:succ", null);
        return true;
    }

    private boolean h(i iVar) {
        this.mgx = false;
        if (iVar.pug.containsKey("actionSheetId")) {
            int Wo = bi.Wo((String) iVar.pug.get("actionSheetId"));
            Bundle bundle = new Bundle();
            bundle.putInt("actionSheetId", Wo);
            try {
                this.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, bundle);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
        }
        a(iVar, "", null);
        return true;
    }

    private boolean i(i iVar) {
        this.mgx = false;
        Bundle bundle = new Bundle();
        if (iVar.pug.containsKey("title")) {
            bundle.putString("title", (String) iVar.pug.get("title"));
        }
        if (iVar.pug.containsKey("desc")) {
            bundle.putString("desc", (String) iVar.pug.get("desc"));
        }
        if (iVar.pug.containsKey("items")) {
            bundle.putString("items", (String) iVar.pug.get("items"));
        }
        try {
            this.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Map hashMap = new HashMap();
        hashMap.put("actionSheetId", Integer.valueOf(bundle.getInt("actionSheetId")));
        a(iVar, iVar.tQg + ":ok", hashMap);
        return true;
    }

    public final boolean Qp(final String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.mgx = false;
            return false;
        } else if (bi.oN(str)) {
            Toast.makeText(ad.getContext(), this.context.getString(R.l.ejt, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.mgx = false;
            return false;
        } else {
            if (this.tNN != null) {
                k.a(this.tNN.tQf, Qn("profile"), str, null);
            }
            if (as.Ho()) {
                com.tencent.mm.f.b.ag Xs;
                as.Hm();
                com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                if (Xv == null || ((int) Xv.gKO) <= 0) {
                    as.Hm();
                    Xs = com.tencent.mm.y.c.Ff().Xs(str);
                } else {
                    Xs = Xv;
                }
                final Intent intent = new Intent();
                String str2 = "";
                if (!(this.tNN == null || this.tNN.pug == null || this.tNN.pug.get("profileReportInfo") == null)) {
                    str2 = (String) this.tNN.pug.get("profileReportInfo");
                }
                if (!bi.oN(str2)) {
                    intent.putExtra("key_add_contact_report_info", str2);
                }
                if (this.tNQ != null && this.tNQ.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.tNQ.getBundle("KBizSearchExtArgs"));
                }
                if (Xs == null || ((int) Xs.gKO) <= 0) {
                    com.tencent.mm.y.ak.a.hhv.a(str, "", new com.tencent.mm.y.ak.b.a() {
                        public final void v(String str, boolean z) {
                            int i = 42;
                            if (g.this.context == null) {
                                x.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
                                g.this.a(g.this.tNN, "profile:fail", null);
                                return;
                            }
                            if (g.this.inI != null) {
                                g.this.inI.dismiss();
                            }
                            as.Hm();
                            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                            if (Xv == null || ((int) Xv.gKO) <= 0) {
                                as.Hm();
                                Xv = com.tencent.mm.y.c.Ff().Xs(str);
                            }
                            if (Xv == null || ((int) Xv.gKO) <= 0) {
                                z = false;
                            } else {
                                str = Xv.field_username;
                            }
                            if (z) {
                                com.tencent.mm.ac.b.I(str, 3);
                                n.JY().jb(str);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("Contact_User", str);
                                if (Xv.ciN()) {
                                    if (g.this.tNQ != null) {
                                        i = g.this.tNQ.getInt("Contact_Scene", 42);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.k(10298, Xv.field_username + "," + i);
                                    intent.putExtra("Contact_Scene", i);
                                }
                                g.this.ab(intent);
                                g.this.a(g.this.tNN, "profile:ok", null);
                                return;
                            }
                            Toast.makeText(ad.getContext(), g.this.context.getString(R.l.ejt, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            g.this.a(g.this.tNN, "profile:fail", null);
                        }
                    });
                    Context context = this.context;
                    this.context.getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.y.ak.a.hhv.hN(str);
                            g.this.a(g.this.tNN, "profile:cancel", null);
                        }
                    });
                    return true;
                }
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("Contact_User", Xs.field_username);
                if (Xs.ciN()) {
                    int i;
                    if (this.tNQ == null) {
                        i = 42;
                    } else {
                        i = this.tNQ.getInt("Contact_Scene", 42);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.k(10298, Xs.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.k.a.ga(Xs.field_type)) {
                    com.tencent.mm.sdk.b.b ozVar = new oz();
                    ozVar.fHJ.intent = intent;
                    ozVar.fHJ.username = Xs.field_username;
                    com.tencent.mm.sdk.b.a.xmy.m(ozVar);
                }
                ab(intent);
                a(this.tNN, "profile:ok", null);
                return false;
            }
            x.e("MicroMsg.MsgHandler", "doProfile, MMCore.hasCfgDefaultUin() is false");
            this.mgx = false;
            return false;
        }
    }

    private void ab(final Intent intent) {
        com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "profile", ".ui.ContactInfoUI", this.fCC, new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.webview.a.a.ihN.d(intent, g.this.context);
            }
        });
    }

    private boolean j(final i iVar) {
        i a;
        if (q.GF()) {
            as.Hm();
            bc FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
            if (FE == null || bi.oM(FE.name).length() == 0) {
                a = com.tencent.mm.ui.base.h.a(this.context, R.l.eYp, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                a.setCancelable(false);
                a.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        g.this.a(iVar, "share_weibo:no_weibo", null);
                    }
                });
            } else {
                int i;
                int i2;
                String aD = bi.aD((String) iVar.pug.get(Columns.TYPE), "40");
                if (aD == null || aD.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = bi.getInt(aD, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                aD = (String) iVar.pug.get("content");
                String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (aD == null || aD.trim().length() == 0) {
                    aD = "";
                }
                if (str == null || str.length() == 0) {
                    x.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + aD + ", url = " + str);
                    a(iVar, "share_weibo:fail_-2", null);
                } else {
                    k.a(iVar.tQf, Qn("shareWeibo"), null, null);
                    str = ak.Cu(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra(Columns.TYPE, i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("content", aD);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).b(this, intent, 2);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = com.tencent.mm.ui.base.h.a(this.context, R.l.eYr, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.webview.a.a.ihN.h(new Intent(), g.this.context);
                }
            }, null);
            a.setCancelable(false);
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    g.this.a(iVar, "share_weibo:not_bind_qq", null);
                }
            });
        }
        return true;
    }

    private boolean c(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        a(iVar, jsapiPermissionWrapper.go(88));
        this.fzX = f(iVar);
        if (this.fzX == null) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) iVar.pug.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            a(iVar, "share_timeline:fail", null);
            return true;
        }
        String str2;
        Bundle e;
        String str3 = (String) iVar.pug.get("desc");
        if (str3 != null) {
            truncate(str3);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) iVar.pug.get("img_url")) + ", title = " + ((String) iVar.pug.get("title")) + ", desc = " + ((String) iVar.pug.get("desc")));
        int i = 1;
        String str4 = "";
        int i2 = 0;
        if (this.tNQ != null) {
            this.tNQ.setClassLoader(getClass().getClassLoader());
            i = this.tNQ.getInt("snsWebSource", 1);
            str4 = this.tNQ.getString("jsapi_args_appid");
            i2 = bi.getInt(this.tNQ.getString("urlAttribute"), 0);
            this.tNQ.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        str3 = str4;
        if (bi.oN(str3)) {
            str2 = (String) iVar.pug.get("appid");
        } else {
            str2 = str3;
        }
        k.a(iVar.tQf, Qn("shareTimeline"), str, str2);
        str3 = (String) iVar.pug.get("img_width");
        str4 = (String) iVar.pug.get("img_height");
        String Cu = ak.Cu((String) iVar.pug.get("link"));
        x.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", r3, Cu);
        String str5 = (String) iVar.pug.get(Columns.TYPE);
        iVar.pug.get("desc");
        String str6 = (String) iVar.pug.get("title");
        String str7 = (String) iVar.pug.get("img_url");
        String str8 = (String) iVar.pug.get("src_username");
        String str9 = (String) iVar.pug.get("src_displayname");
        try {
            i2 = Integer.valueOf(str3).intValue();
            try {
                Integer.valueOf(str4);
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            i2 = -1;
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", Cu);
        intent.putExtra("Ksnsupload_title", str6);
        intent.putExtra("Ksnsupload_imgurl", str7);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (com.tencent.mm.y.s.gI(str8)) {
            intent.putExtra("src_username", str8);
            intent.putExtra("src_displayname", str9);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bi.oN(str5) && str5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bi.oN(str5) && str5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str4 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.tNQ == null);
        x.i(str4, str5, objArr);
        str3 = null;
        if (this.tNQ != null) {
            str4 = this.tNQ.getString("K_sns_thumb_url");
            str5 = this.tNQ.getString("K_sns_raw_url");
            str6 = bi.aD(this.tNQ.getString("KSnsStrId"), "");
            str7 = bi.aD(this.tNQ.getString("KSnsLocalId"), "");
            str3 = this.tNQ.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str3);
            x.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", str, str5, str4);
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str4);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.tNQ.getParcelable("KSnsAdTag");
            x.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", parcelable);
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.tNQ.getBoolean("KFromTimeline", false)) {
                com.tencent.mm.sdk.b.b pwVar = new pw();
                pwVar.fIs.fAR = str6;
                pwVar.fIs.fsC = str7;
                com.tencent.mm.sdk.b.a.xmy.m(pwVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.fCC.bSz());
            e = this.fCC.e(18, null);
            intent.putExtra("KPublisherId", e == null ? "" : bi.oM(e.getString("KPublisherId")));
            str = this.fCC.aeH();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.tNZ.Qf(str));
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                e = this.fCC.e(18, null);
                if (e != null) {
                    str4 = com.tencent.mm.y.u.hC(bi.oM(e.getString("KPublisherId")));
                    com.tencent.mm.y.u.b t = com.tencent.mm.y.u.GQ().t(str4, true);
                    t.o("sendAppMsgScene", Integer.valueOf(2));
                    t.o("preChatName", e.getString("preChatName"));
                    t.o("preMsgIndex", Integer.valueOf(e.getInt("preMsgIndex")));
                    t.o("prePublishId", e.getString("prePublishId"));
                    t.o("preUsername", e.getString("preUsername"));
                    t.o(SlookSmartClipMetaTag.TAG_TYPE_URL, Cu);
                    t.o("getA8KeyScene", Integer.valueOf(e.getInt("getA8KeyScene")));
                    t.o("referUrl", e.getString("referUrl"));
                    if (!bi.oN(str3)) {
                        t.o("adExtStr", str3);
                    }
                    intent.putExtra("reportSessionId", str4);
                }
            } catch (RemoteException e5) {
                x.e("MicroMsg.MsgHandler", "try to attach report args error, %s", e5);
            }
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.a(this.context, "sns", ".ui.SnsUploadUI", intent, 24, false);
        }
        return true;
    }

    private boolean k(i iVar) {
        String str = (String) iVar.pug.get("ad_info");
        String str2 = str + ",";
        String FY = q.FY();
        try {
            String str3;
            Bundle bundle;
            Bundle e = this.fCC.e(18, null);
            if (e != null) {
                String string = e.getString("prePublishId");
                String string2 = e.getString("preChatName");
                String string3 = e.getString("preUsername");
                str3 = str2 + string + "," + string2 + "," + string3 + "," + e.getInt("getA8KeyScene") + ",";
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            long parseLong = Long.parseLong(string.substring(4));
                            as.Hm();
                            com.tencent.mm.f.b.cg G = com.tencent.mm.y.c.Fh().G(string2, parseLong);
                            str3 = str3 + G.getType() + "," + com.tencent.mm.y.m.gn(G.field_talker) + "," + t.N(string3, string2) + "," + aj.bRH() + ",";
                            str3 = str3 + FY;
                            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bi.Wx());
                            if (Integer.parseInt(bi.aD((String) iVar.pug.get("need_record_page_operation"), "0")) != 0) {
                                bundle = new Bundle();
                                bundle.putString("traceid", str);
                                bundle.putString("username", FY);
                                try {
                                    this.fCC.e(90002, bundle);
                                } catch (RemoteException e2) {
                                }
                            }
                            a(iVar, "adDataReport：ok", null);
                            return true;
                        }
                    } catch (Throwable e3) {
                        Throwable th = e3;
                        str2 = str3;
                        x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    }
                }
                str3 = str3 + ",,,,";
                str3 = str3 + FY;
                ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bi.Wx());
                if (Integer.parseInt(bi.aD((String) iVar.pug.get("need_record_page_operation"), "0")) != 0) {
                    bundle = new Bundle();
                    bundle.putString("traceid", str);
                    bundle.putString("username", FY);
                    this.fCC.e(90002, bundle);
                }
                a(iVar, "adDataReport：ok", null);
                return true;
            }
            str3 = str2;
            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bi.Wx());
            if (Integer.parseInt(bi.aD((String) iVar.pug.get("need_record_page_operation"), "0")) != 0) {
                bundle = new Bundle();
                bundle.putString("traceid", str);
                bundle.putString("username", FY);
                this.fCC.e(90002, bundle);
            }
            a(iVar, "adDataReport：ok", null);
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
            a(iVar, "adDataReport：fail", null);
        }
        return true;
    }

    private boolean l(i iVar) {
        try {
            if (this.fCC != null) {
                Bundle e = this.fCC.e(87, null);
                if (e != null) {
                    if (bi.oM(e.getString("result")).equals("not_return")) {
                        a(iVar, "getWePkgAuthResult:fail_auth_result_not_return", null);
                    } else {
                        String string = e.getString("full_url");
                        int i = e.getInt("set_cookie");
                        if (bi.oN(string)) {
                            a(iVar, "getWePkgAuthResult:fail_full_url_empty", null);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("full_url", string);
                            hashMap.put("set_cookie", Integer.valueOf(i));
                            a(iVar, "getWePkgAuthResult:ok", hashMap);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "doGetWePkgAuthResult exception, " + e2.getMessage());
            a(iVar, "getWePkgAuthResult:fail", null);
        }
        return true;
    }

    private boolean m(i iVar) {
        String str = (String) iVar.pug.get("reportId");
        boolean equals = bi.oM((String) iVar.pug.get("reportInstantly")).equals("1");
        boolean equals2 = bi.oM((String) iVar.pug.get("reportTimeBegin")).equals("1");
        String str2 = (String) iVar.pug.get("reportFormatData");
        String str3 = (String) iVar.pug.get("reportTabsFormatData");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "reportId is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportId", null);
        } else if (bi.oN(str2) && bi.oN(str3)) {
            x.e("MicroMsg.MsgHandler", "reportFormatData && reportTabsFormatData is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportFormatData_reportTabsFormatData", null);
        } else {
            x.i("MicroMsg.MsgHandler", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", str, Boolean.valueOf(equals), Boolean.valueOf(equals2), str2, str3);
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", str);
            bundle.putBoolean("game_page_report_instantly", equals);
            bundle.putBoolean("game_page_report_time_begin", equals2);
            bundle.putString("game_page_report_format_data", str2);
            bundle.putString("game_page_report_tabs_format_data", str3);
            try {
                this.fCC.e(95, bundle);
                a(iVar, "reportGamePageTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "reportGamePageTime, exception = %s", e);
                a(iVar, "reportGamePageTime:fail", null);
            }
        }
        return true;
    }

    private static String truncate(String str) {
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        if (str.startsWith("https://")) {
            return str.substring(8);
        }
        return str;
    }

    private boolean n(i iVar) {
        String str = (String) iVar.pug.get("current");
        String[] strArr = (String[]) iVar.pug.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.mgx = false;
        } else {
            Bundle e;
            x.d("MicroMsg.MsgHandler", "doImgPreview ok");
            int i = 0;
            while (i < strArr.length) {
                if (bi.oN(strArr[i]) || strArr[i].equalsIgnoreCase("null")) {
                    x.e("MicroMsg.MsgHandler", "null url, i = %d", Integer.valueOf(i));
                } else {
                    if (bi.oM(strArr[i]).startsWith("weixin://resourceid/")) {
                        strArr[i] = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(strArr[i]).iOz;
                    }
                    arrayList.add(strArr[i]);
                }
                i++;
            }
            strArr = (String[]) arrayList.toArray(strArr);
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bi.oN(str)) {
                str = strArr[0];
            } else if (str.startsWith("weixin://resourceid/")) {
                str = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str).iOz;
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr2);
            intent.putExtra(Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("shouldShowScanQrCodeMenu", true);
            try {
                e = this.fCC.e(90001, new Bundle());
                if (e != null) {
                    str = e.getString("cookie", null);
                    if (!bi.oN(str)) {
                        intent.putExtra("cookie", str);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "getCookie fail : %s", e2.getMessage());
            }
            if (this.context instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            e = new Bundle();
            e.putInt("stat_scene", 4);
            e.putString("stat_url", aeH());
            intent.putExtra("_stat_obj", e);
            com.tencent.mm.plugin.webview.a.a.ihN.t(intent, this.context);
            this.mgx = false;
        }
        return false;
    }

    private boolean o(i iVar) {
        try {
            Bundle ap = i.ap(iVar.pug);
            this.fCC.bSB();
            this.fCC.O(ap);
            com.tencent.mm.sdk.b.a.xmy.m(new tt());
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(iVar, "close_window:ok", null);
        return true;
    }

    private void a(i iVar, int i, int i2) {
        String str = iVar.tQg;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String qZ = qZ(aeH());
            com.tencent.mm.plugin.soter.c.g gVar = com.tencent.mm.plugin.soter.c.g.rYr;
            com.tencent.mm.plugin.soter.c.g.o(str, qZ, i, i2);
        }
    }

    private boolean p(i iVar) {
        this.mgx = false;
        int Wo = bi.Wo(iVar.pug.get("voteResultIndex").toString());
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sns_landing_pages_ad_vote_index", Wo);
            this.fCC.n(150, bundle);
        } catch (Exception e) {
        }
        return false;
    }

    private boolean q(i iVar) {
        String str = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
        if (bi.oN(str)) {
            x.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(iVar, "get_install_state:no", null);
            return true;
        }
        int i;
        k.a(iVar.tQf, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                int i2;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                i = 0;
                int i3 = 0;
                while (true) {
                    i2 = i;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    String string = jSONArray.getString(i3);
                    PackageInfo packageInfo = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, string);
                    int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str2 = packageInfo == null ? "null" : packageInfo.versionName;
                    x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + packageInfo + ", version = " + i4 + ", versionName = " + str2);
                    if (i2 == 0 && i4 > 0) {
                    }
                    jSONObject.put(string, i4);
                    jSONObject2.put(string, str2);
                    i = i3 + 1;
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (i2 != 0) {
                    a(iVar, "get_install_state:yes", hashMap);
                } else {
                    a(iVar, "get_install_state:no", null);
                }
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo packageInfo2 = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, str);
        i = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str3 = packageInfo2 == null ? "null" : packageInfo2.versionName;
        x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + packageInfo2 + ", version = " + i + ", versionName = " + str3);
        if (packageInfo2 == null) {
            a(iVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(iVar, "get_install_state:yes_" + i, hashMap2);
        }
        return true;
    }

    private boolean r(i iVar) {
        boolean z;
        boolean z2;
        int i;
        Intent intent;
        String str = (String) iVar.pug.get("desc");
        int i2 = bi.getInt((String) iVar.pug.get("needResult"), 1);
        String str2 = (String) iVar.pug.get("scanType");
        x.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", str, Integer.valueOf(i2), str2);
        if (bi.oN(str2)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        boolean z3;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                z3 = z;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    try {
                        str = (String) jSONArray.get(i3);
                        if (str.equalsIgnoreCase("qrCode")) {
                            z = z3;
                            z3 = true;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            z = true;
                            z3 = z2;
                        } else {
                            z = z3;
                            z3 = z2;
                        }
                        i3++;
                        z2 = z3;
                        z3 = z;
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                z3 = z;
                x.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                if (!z2) {
                }
                if (!z2) {
                }
                i = 1;
                if (i2 == 0) {
                    x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    com.tencent.mm.bl.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
                    a(iVar, "scanQRCode:ok", null);
                } else if (i2 != 1) {
                    x.e("MicroMsg.MsgHandler", "unkown scene");
                    a(iVar, "scanQRCode:fail_invalid_scene", null);
                } else {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    intent.putExtra("key_is_finish_on_scanned", true);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
                    WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fEg);
                }
                return true;
            }
        }
        z3 = z;
        if (!z2 && !r1) {
            i = 8;
        } else if (z2 || !r1) {
            i = 1;
        } else {
            i = 4;
        }
        if (i2 == 0) {
            x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(com.tencent.mm.o.a.aV(this.context) || com.tencent.mm.at.a.Qq())) {
                com.tencent.mm.bl.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            }
            a(iVar, "scanQRCode:ok", null);
        } else if (i2 != 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(com.tencent.mm.o.a.aV(this.context) || com.tencent.mm.at.a.Qq())) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fEg);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "unkown scene");
            a(iVar, "scanQRCode:fail_invalid_scene", null);
        }
        return true;
    }

    private boolean s(i iVar) {
        String str = (String) iVar.pug.get("fontSize");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.mgx = false;
        } else {
            x.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = " + str);
            try {
                this.fCC.Po(str);
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.mgx = false;
        }
        return false;
    }

    private boolean t(i iVar) {
        x.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
            com.tencent.mm.sdk.b.b lpVar = new lp();
            lpVar.fDN.appId = gVar.appId;
            lpVar.fDN.partnerId = gVar.partnerId;
            lpVar.fDN.signType = gVar.signType;
            lpVar.fDN.nonceStr = gVar.nonceStr;
            lpVar.fDN.timeStamp = gVar.timeStamp;
            lpVar.fDN.packageExt = gVar.packageExt;
            lpVar.fDN.fDO = gVar.fDO;
            lpVar.fDN.url = gVar.url;
            lpVar.fDN.fDP = gVar.fDP;
            lpVar.fDN.fDQ = gVar.fDQ;
            lpVar.fDN.frE = gVar.frE;
            lpVar.fDN.fDR = gVar.fDR;
            com.tencent.mm.sdk.b.a.xmy.m(lpVar);
            b(21, -1, null);
        }
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        return true;
    }

    private boolean u(i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) iVar.pug.get("productInfo");
        String str2 = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 3, 0, null, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.Integer r7, int r8, int r9, java.lang.String r10, android.content.Intent r11) {
        /*
        r6 = this;
        r3 = 0;
        r5 = 1;
        r4 = 0;
        r0 = "key_product_scene";
        r11.putExtra(r0, r8);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        r0 = r6.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x005a;
    L_0x001c:
        r0 = r6.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.jCj = r6;
        r0 = r7.intValue();
        switch(r0) {
            case 0: goto L_0x0043;
            case 10000: goto L_0x0092;
            case 20000: goto L_0x0092;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        r0 = 8;
        if (r8 != r0) goto L_0x00a6;
    L_0x003a:
        r0 = r6.tNN;
        r1 = "open_product_view_with_id:fail";
        r6.a(r0, r1, r4);
    L_0x0042:
        return r5;
    L_0x0043:
        switch(r9) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0077;
            default: goto L_0x0046;
        };
    L_0x0046:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d, viewType = %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r2[r3] = r7;
        r3 = java.lang.Integer.valueOf(r9);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
    L_0x005a:
        r0 = r6.tNN;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0063:
        r0 = r6.context;
        r1 = "product";
        r2 = ".ui.MallProductUI";
        com.tencent.mm.bl.d.b(r0, r1, r2, r11);
        r0 = r6.tNN;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0077:
        r0 = "key_Qrcode_Url";
        r11.putExtra(r0, r10);
        r0 = "key_ProductUI_getProductInfoScene";
        r1 = 4;
        r11.putExtra(r0, r1);
        r0 = r6.context;
        r1 = "scanner";
        r2 = ".ui.ProductUI";
        r3 = 10;
        com.tencent.mm.bl.d.b(r0, r1, r2, r11, r3);
        goto L_0x0042;
    L_0x0092:
        r0 = r6.context;
        r1 = "card";
        r2 = ".ui.CardProductUI";
        com.tencent.mm.bl.d.b(r0, r1, r2, r11);
        r0 = r6.tNN;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x00a6:
        r0 = r6.tNN;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(java.lang.Integer, int, int, java.lang.String, android.content.Intent):boolean");
    }

    private boolean a(final i iVar, int... iArr) {
        if (tNY != -1) {
            this.tNN = Bs(tNY).tNN;
            this.fCC = Bs(tNY).fCC;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(iVar, "startMonitoringBeacons:system unsupported", null);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(iVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(iVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr == null || iArr.length == 0) {
                if (!this.tOl.isProviderEnabled("gps")) {
                    a(iVar, "startMonitoringBeacons:location service disable", null);
                }
                SensorManager sensorManager = (SensorManager) tNX.getSystemService("sensor");
                sensorManager.registerListener(this.tOp, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.tOo) {
                a(iVar, "startMonitoringBeacons:already started", null);
            } else {
                this.tOo = true;
                a(iVar, "startMonitoringBeacons:ok", null);
            }
            if (!(iVar == null || iVar.pug == null)) {
                Object obj = iVar.pug.get("uuid");
                Object obj2 = iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                Object obj3 = iVar.pug.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                com.tencent.mm.plugin.report.service.g.pWK.h(12101, bi.oM(this.tNZ.Qf(obj4)), obj4, this.tOm, this.tOn, obj3 != null ? obj3.toString() : "");
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0").append("}");
                final k xVar = new com.tencent.mm.plugin.webview.model.x(obj4, r4, r1);
                as.CN().a(1702, new com.tencent.mm.ad.e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            btl btl = (btl) xVar.hGV.hnR.hnY;
                            if (btl.lUc == 0) {
                                List<String> list = btl.xbp;
                                if (list == null || list.isEmpty()) {
                                    g.this.a(iVar, "startMonitoringBeacons:no uuids", null);
                                } else {
                                    for (String a : list) {
                                        g.a(g.this, a);
                                    }
                                }
                            } else {
                                g.this.a(iVar, "startMonitoringBeacons:system error", null);
                                x.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", btl.lUd);
                            }
                            as.CN().b(1702, (com.tencent.mm.ad.e) this);
                        }
                    }
                });
                as.CN().a(xVar, 0);
            }
        }
        return true;
    }

    public final boolean b(i iVar, int... iArr) {
        if (tNY != -1) {
            this.tNN = Bs(tNY).tNN;
            this.fCC = Bs(tNY).fCC;
        }
        if (VERSION.SDK_INT >= 18) {
            boolean a;
            com.tencent.mm.sdk.b.a.xmy.c(this.qyj);
            if (as.Hp()) {
                as.Hm();
                a = bi.a((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false);
            } else {
                a = false;
            }
            for (String str : this.tOg.keySet()) {
                com.tencent.mm.sdk.b.b dkVar = new dk();
                x.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", str);
                dkVar.fsP.fsR = str;
                dkVar.fsP.fsO = false;
                if (!a) {
                    com.tencent.mm.sdk.b.a.xmy.m(dkVar);
                }
            }
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.valueOf(false));
            }
            Editor edit = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.tOg.clear();
            this.gAk.clear();
            this.tOh.clear();
            this.tOi.clear();
            this.tOo = false;
            if (iArr == null || iArr.length == 0) {
                a(iVar, "stopMonitoringBeacons:ok", null);
                this.tOo = false;
            }
        }
        if (!(tNX == null || this.tOp == null)) {
            ((SensorManager) tNX.getSystemService("sensor")).unregisterListener(this.tOp);
        }
        return true;
    }

    private boolean bVl() {
        String aeH;
        x.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            aeH = this.fCC.aeH();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = str;
        }
        final String str2 = "get_recently_used_address:";
        if (aeH == null) {
            a(this.tNN, str2 + "fail", null);
        } else {
            final com.tencent.mm.sdk.b.b mhVar = new mh();
            mhVar.fEO.appId = (String) this.tNN.pug.get("appId");
            mhVar.fEO.url = aeH;
            mhVar.fEP.errCode = -119;
            mhVar.frD = new Runnable() {
                public final void run() {
                    x.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(mhVar.fEP.errCode), Boolean.valueOf(mhVar.fEP.fEQ));
                    if (mhVar.fEP.errCode != -119) {
                        if (mhVar.fEP.errCode != 0) {
                            g.this.a(g.this.tNN, str2 + "fail", null);
                        } else if (mhVar.fEP.fEQ) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", mhVar.fEP.fER);
                            hashMap.put("userName", mhVar.fEP.userName);
                            hashMap.put("telNumber", mhVar.fEP.fES);
                            hashMap.put("addressPostalCode", mhVar.fEP.fET);
                            hashMap.put("proviceFirstStageName", mhVar.fEP.fEU);
                            hashMap.put("addressCitySecondStageName", mhVar.fEP.fEV);
                            hashMap.put("addressCountiesThirdStageName", mhVar.fEP.fEW);
                            hashMap.put("addressDetailInfo", mhVar.fEP.fEX);
                            g.this.a(g.this.tNN, str2 + "ok", hashMap);
                        } else {
                            g.this.a(g.this.tNN, str2 + "cancel", null);
                        }
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xmy.a(mhVar, Looper.getMainLooper());
        }
        return true;
    }

    private boolean v(i iVar) {
        k.a(iVar.tQf, Qn("sendEmail"), null, null);
        String str = (String) iVar.pug.get("title");
        String str2 = "";
        try {
            str2 = ak.Cu(this.fCC.aeH());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.bl.d.a(this.context, "qqmail", ".ui.ComposeUI", intent, false);
        a(iVar, "send_email:ok", null);
        return true;
    }

    private boolean w(i iVar) {
        if (bi.chp()) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, GP Version not allowed to download");
            a(iVar, "system:access_denied", null);
            return true;
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(157, 27, 1, false);
        String str = (String) iVar.pug.get("task_name");
        String str2 = (String) iVar.pug.get("task_url");
        String str3 = (String) iVar.pug.get("alternative_url");
        long j = bi.getLong((String) iVar.pug.get("task_size"), 0);
        String str4 = (String) iVar.pug.get("file_md5");
        String str5 = (String) iVar.pug.get("extInfo");
        String str6 = (String) iVar.pug.get("fileType");
        String str7 = (String) iVar.pug.get("appid");
        String str8 = (String) iVar.pug.get("package_name");
        int i = bi.getInt((String) iVar.pug.get("scene"), 1000);
        x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6 + ", reportScene = " + i);
        if (this.tNQ != null) {
            int i2 = this.tNQ.getInt("key_download_restrict", 0);
            if (!bi.oN(this.tNQ.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14596, r14, Integer.valueOf(i2), Integer.valueOf(0));
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                a(iVar, "add_download_task_straight:fail", null);
                return true;
            }
        }
        as.Hm();
        if (!com.tencent.mm.y.c.isSDCardAvailable()) {
            Toast.makeText(this.context, this.context.getString(R.l.emw), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_not_ready", null);
            v(str7, com.tencent.mm.plugin.downloader.model.d.lxN, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, sdcard not ready");
            return true;
        } else if (j > 0 && !com.tencent.mm.compatible.util.f.aD(j)) {
            Toast.makeText(this.context, this.context.getString(R.l.emv), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_has_not_enough_space", null);
            v(str7, com.tencent.mm.plugin.downloader.model.d.lxN, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, not enough space, require size = " + j);
            return true;
        } else if (bi.oN(str2)) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, url is null");
            a(iVar, "add_download_task_straight:fail_invalid_url", null);
            v(str7, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, str5);
            return true;
        } else {
            com.tencent.mm.sdk.b.b gqVar = new gq();
            gqVar.fxE.url = str2;
            gqVar.fxE.frM = str4;
            gqVar.fxE.extInfo = str5;
            gqVar.fxE.appId = str7;
            gqVar.fxE.scene = i;
            com.tencent.mm.sdk.b.a.xmy.m(gqVar);
            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
            aVar.yr(str2);
            aVar.ys(str3);
            aVar.cj(j);
            aVar.yt(str);
            aVar.yu(str4);
            aVar.setAppId(str7);
            aVar.cu(str8);
            aVar.et(true);
            aVar.oP(bi.getInt(str6, 1));
            aVar.lO(i);
            long a = com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, downloadId = " + a);
            if (a <= 0) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, downloadId = " + a);
                a(iVar, "add_download_task_straight:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(a));
                a(iVar, "add_download_task_straight:ok", hashMap);
            }
            return true;
        }
    }

    private static void v(String str, int i, String str2) {
        com.tencent.mm.sdk.b.b guVar = new gu();
        guVar.fxN.appId = str;
        guVar.fxN.opType = 2;
        guVar.fxN.fxO = i;
        guVar.fxN.fra = str2;
        com.tencent.mm.sdk.b.a.xmy.m(guVar);
    }

    private boolean x(i iVar) {
        long j = bi.getLong((String) iVar.pug.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doResumeDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "resume_download_task:fail", null);
        } else {
            boolean cb = com.tencent.mm.plugin.downloader.model.f.aAK().cb(j);
            x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, ret = " + cb);
            if (cb) {
                a(iVar, "resume_download_task:ok", null);
            } else {
                a(iVar, "resume_download_task:fail", null);
            }
        }
        return true;
    }

    private boolean a(String str, i iVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < jSONArray.length()) {
                        String str2;
                        String string = jSONArray.getString(i2);
                        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(string);
                        JSONObject jSONObject2 = new JSONObject();
                        switch (yo.status) {
                            case -1:
                                str2 = "api_not_support";
                                break;
                            case 1:
                                str2 = "downloading";
                                break;
                            case 2:
                                str2 = "download_pause";
                                break;
                            case 3:
                                if (!com.tencent.mm.a.e.bO(yo.path)) {
                                    str2 = "default";
                                    break;
                                }
                                str2 = "download_succ";
                                break;
                            case 4:
                                str2 = "download_fail";
                                break;
                            default:
                                str2 = "default";
                                break;
                        }
                        jSONObject2.put("download_id", yo.id);
                        jSONObject2.put("state", str2);
                        if (str2 == "downloading" && yo.fxb != 0) {
                            jSONObject2.put("progress", (yo.fxa / yo.fxb) * 100);
                        }
                        jSONObject.put(string, jSONObject2);
                        i = i2 + 1;
                    } else {
                        Map hashMap = new HashMap();
                        hashMap.put("result", jSONObject);
                        a(iVar, "query_download_task:ok", hashMap);
                    }
                }
            } else {
                a(iVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            x.e("MicroMsg.MsgHandler", e.getMessage());
            a(iVar, "query_download_task:fail", null);
        }
        return true;
    }

    private boolean y(final i iVar) {
        String str;
        int i;
        IMediaObject wXAppExtendObject;
        WXMediaMessage wXMediaMessage;
        com.tencent.mm.sdk.b.b irVar;
        if (this.tNQ != null) {
            int i2 = this.tNQ.getInt("key_download_restrict", 0);
            if (!bi.oN(this.tNQ.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14596, r1, Integer.valueOf(i2), Integer.valueOf(1));
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow tolaunch 3rd app");
                a(iVar, "launch_3rdApp:fail", null);
                return true;
            }
        }
        String str2 = (String) iVar.pug.get(Columns.TYPE);
        String str3 = (String) iVar.pug.get("appID");
        x.i("MicroMsg.MsgHandler", "lauchTimeInterval = %d", Long.valueOf(bi.Wx() - this.tOd));
        String str4 = "";
        String str5 = "";
        if (bi.Wx() - this.tOd < 2 && this.tOd > 0) {
            try {
                str4 = this.fCC.aeH();
                str5 = this.tNZ.Qf(str4);
                str4 = URLEncoder.encode(str4, "UTF-8");
                com.tencent.mm.plugin.report.service.g.pWK.h(13983, Integer.valueOf(5), str4, "");
                str = str4;
                str4 = str5;
            } catch (Exception e) {
                str4 = "";
                x.e("MicroMsg.MsgHandler", "report lauch3rd failed");
            }
            k.a(iVar.tQf, false, null, str3);
            if (!bi.oN(str2)) {
                try {
                    i = bi.getInt(str2, 0);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "invalid type", e2.getMessage());
                }
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str2);
                if (i != 0) {
                    str2 = (String) iVar.pug.get("extInfo");
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", str3, str2);
                    if (!bi.oN(str3)) {
                        x.e("MicroMsg.MsgHandler", "appid is null or nil");
                        a(iVar, "launch_3rdApp:fail", null);
                    } else if (com.tencent.mm.plugin.webview.a.a.ihO.m(ad.getContext(), str3)) {
                        x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", str3);
                        a(iVar, "launch_3rdApp:fail", null);
                    } else {
                        wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = str2;
                        wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                        wXMediaMessage.sdkVer = 620823552;
                        wXMediaMessage.messageExt = str2;
                        irVar = new ir();
                        irVar.fzV.fzX = wXMediaMessage;
                        irVar.fzV.appId = str3;
                        irVar.fzV.context = this.context;
                        irVar.fzV.fzY = new com.tencent.mm.pluginsdk.model.app.g.a() {
                            public final void cI(boolean z) {
                                g.this.a(iVar, "launch_3rdApp:ok", null);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.m(irVar);
                    }
                } else if (i != 1) {
                    str2 = (String) iVar.pug.get("signature");
                    str3 = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", str2, str3, (String) iVar.pug.get("param"));
                    if (!bi.oN(str2) || bi.oN(str3)) {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                        a(iVar, "launch_3rdApp:fail_invalid_args", null);
                    } else if (com.tencent.mm.pluginsdk.model.app.p.m(this.context, str3)) {
                        Signature[] aX = com.tencent.mm.pluginsdk.model.app.p.aX(this.context, str3);
                        if (!(aX == null || aX[0] == null)) {
                            String s = com.tencent.mm.a.g.s(aX[0].toByteArray());
                            if (s != null && s.equalsIgnoreCase(str2)) {
                                try {
                                    Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str3);
                                    if (launchIntentForPackage != null) {
                                        Bundle bundle = new Bundle();
                                        com.tencent.mm.pluginsdk.model.app.p.g(bundle, str5);
                                        launchIntentForPackage.putExtras(bundle);
                                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        bundle = new Bundle();
                                        bundle.putString("current_page_url", str);
                                        bundle.putString("current_page_appid", str4);
                                        com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage, null, new com.tencent.mm.pluginsdk.model.app.g.a() {
                                            public final void cI(boolean z) {
                                                g.this.a(iVar, "launch_3rdApp:ok", null);
                                            }
                                        }, bundle);
                                    }
                                } catch (Exception e3) {
                                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", e3.getMessage());
                                }
                                a(iVar, "launch_3rdApp:fail", null);
                            }
                        }
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                        a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                        a(iVar, "launch_3rdApp:fail_not_install", null);
                    }
                } else {
                    a(iVar, "launch_3rdApp:fail_invalid_type", null);
                }
                return true;
            }
            i = 0;
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str2);
            if (i != 0) {
                str2 = (String) iVar.pug.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", str3, str2);
                if (!bi.oN(str3)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ihO.m(ad.getContext(), str3)) {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.messageExt = str2;
                    irVar = new ir();
                    irVar.fzV.fzX = wXMediaMessage;
                    irVar.fzV.appId = str3;
                    irVar.fzV.context = this.context;
                    irVar.fzV.fzY = /* anonymous class already generated */;
                    com.tencent.mm.sdk.b.a.xmy.m(irVar);
                } else {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", str3);
                    a(iVar, "launch_3rdApp:fail", null);
                }
            } else if (i != 1) {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            } else {
                str2 = (String) iVar.pug.get("signature");
                str3 = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", str2, str3, (String) iVar.pug.get("param"));
                if (bi.oN(str2)) {
                }
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            }
            return true;
        }
        str = str4;
        str4 = str5;
        k.a(iVar.tQf, false, null, str3);
        if (bi.oN(str2)) {
            i = bi.getInt(str2, 0);
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str2);
            if (i != 0) {
                str2 = (String) iVar.pug.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", str3, str2);
                if (!bi.oN(str3)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ihO.m(ad.getContext(), str3)) {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", str3);
                    a(iVar, "launch_3rdApp:fail", null);
                } else {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.messageExt = str2;
                    irVar = new ir();
                    irVar.fzV.fzX = wXMediaMessage;
                    irVar.fzV.appId = str3;
                    irVar.fzV.context = this.context;
                    irVar.fzV.fzY = /* anonymous class already generated */;
                    com.tencent.mm.sdk.b.a.xmy.m(irVar);
                }
            } else if (i != 1) {
                str2 = (String) iVar.pug.get("signature");
                str3 = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", str2, str3, (String) iVar.pug.get("param"));
                if (bi.oN(str2)) {
                }
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            } else {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        i = 0;
        x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str2);
        if (i != 0) {
            str2 = (String) iVar.pug.get("extInfo");
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", str3, str2);
            if (!bi.oN(str3)) {
                x.e("MicroMsg.MsgHandler", "appid is null or nil");
                a(iVar, "launch_3rdApp:fail", null);
            } else if (com.tencent.mm.plugin.webview.a.a.ihO.m(ad.getContext(), str3)) {
                wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = str2;
                wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823552;
                wXMediaMessage.messageExt = str2;
                irVar = new ir();
                irVar.fzV.fzX = wXMediaMessage;
                irVar.fzV.appId = str3;
                irVar.fzV.context = this.context;
                irVar.fzV.fzY = /* anonymous class already generated */;
                com.tencent.mm.sdk.b.a.xmy.m(irVar);
            } else {
                x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", str3);
                a(iVar, "launch_3rdApp:fail", null);
            }
        } else if (i != 1) {
            a(iVar, "launch_3rdApp:fail_invalid_type", null);
        } else {
            str2 = (String) iVar.pug.get("signature");
            str3 = (String) iVar.pug.get(DownloadInfoColumns.PACKAGENAME);
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", str2, str3, (String) iVar.pug.get("param"));
            if (bi.oN(str2)) {
            }
            x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
            a(iVar, "launch_3rdApp:fail_invalid_args", null);
        }
        return true;
    }

    private boolean z(i iVar) {
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(iVar, "open_url_by_ext_browser:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                this.context.startActivity(intent);
                a(iVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(iVar, "open_url_by_ext_browser:fail", null);
            }
        }
        return true;
    }

    private static byte[] bVm() {
        try {
            com.tencent.mm.sdk.platformtools.h hVar = new com.tencent.mm.sdk.platformtools.h("softtype");
            x.d("MicroMsg.AndroidDevicesReport", "cpu %s", bi.aD((String) com.tencent.mm.compatible.e.n.yA().get("Processor"), ""));
            hVar.bN("cpu", r0);
            hVar.bN(TencentLocationListener.RADIO, com.tencent.mm.compatible.e.q.yT());
            hVar.bN("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
            String yV = com.tencent.mm.compatible.e.q.yV();
            String yW = com.tencent.mm.compatible.e.q.yW();
            hVar.bN("deviceId", deviceID);
            hVar.bN("imsi", yV);
            hVar.bN("iccid", yW);
            hVar.bN("androidid", com.tencent.mm.compatible.e.q.getAndroidId());
            hVar.bN("serial", com.tencent.mm.compatible.e.q.yX());
            hVar.bN("model", com.tencent.mm.compatible.e.q.yQ());
            hVar.bN("core_count", com.tencent.mm.compatible.e.n.yF());
            hVar.bN("cpuhardware", bi.aD((String) com.tencent.mm.compatible.e.n.yG().get("Hardware"), ""));
            hVar.bN("cpureversion", bi.aD((String) com.tencent.mm.compatible.e.n.yG().get("CPU revision"), ""));
            hVar.bN("cpuserial", bi.aD((String) com.tencent.mm.compatible.e.n.yG().get("Serial"), ""));
            hVar.bN("Features", bi.aD((String) com.tencent.mm.compatible.e.n.yG().get("Features"), ""));
            hVar.bN("wifi-mac", bi.aD(com.tencent.mm.compatible.e.q.yN(), ""));
            hVar.bN("bluetooth", bi.aD(com.tencent.mm.compatible.e.q.yO(), ""));
            if (!bi.oN(hVar.xmX)) {
                hVar.vZ(hVar.xmX);
                hVar.xmX = "";
            }
            x.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", hVar.ksI.toString());
            x.i("MicroMsg.MsgHandler", "xml %s", deviceID);
            bqg bqg = new bqg();
            bqg.wZb = com.tencent.mm.bp.b.be(com.tencent.mm.compatible.e.q.yM().getBytes()).CW(16);
            x.i("MicroMsg.MsgHandler", bi.bA(bqg.wZb.oz));
            bqg.wZc = deviceID;
            SharedPreferences Ht = at.Ht();
            x.i("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", bi.bA(r2), com.tencent.mm.a.g.s(bi.Wj(Ht.getString("_auth_key", ""))), Integer.valueOf(Ht.getInt("_auth_uin", 0)));
            x.i("MicroMsg.MsgHandler", "aat len:%d", Integer.valueOf(r2.length));
            bqg.wZd = com.tencent.mm.bp.b.be(r2);
            bqg.uin = r0;
            ac cey = ac.cey();
            byte[] toByteArray = bqg.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, cey.vIK.getBytes(), cey.vIL.getBytes())) {
                toByteArray = pByteArray.value;
            }
            x.d("MicroMsg.MsgHandler", "cpan buf string:%s ", bi.bA(toByteArray));
            bqh bqh = new bqh();
            bqh.wZf = cey.ver;
            bqh.wZe = com.tencent.mm.protocal.d.vHl;
            bqh.wZg = com.tencent.mm.protocal.d.DEVICE_TYPE;
            bqh.wZh = com.tencent.mm.bp.b.be(toByteArray);
            x.i("MicroMsg.MsgHandler", "getdevice done");
            return bqh.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", "report error");
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            return null;
        }
    }

    private boolean A(i iVar) {
        String str = "";
        try {
            str = this.fCC.aeH();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        x.i("MicroMsg.MsgHandler", "currentUrl %s", str);
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                x.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(bVm(), 0);
            } catch (Throwable e2) {
                x.e("MicroMsg.MsgHandler", "device info get error %s", e2.getMessage());
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(iVar, "mmsf0001:ok", hashMap);
        } else {
            a(iVar, "system:access_denied", null);
        }
        return true;
    }

    private boolean B(i iVar) {
        Map map = null;
        if (this.context instanceof MMActivity) {
            String map2;
            x.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", (String) iVar.pug.get("tousername"), (String) iVar.pug.get("extmsg"));
            try {
                map2 = this.fCC.aeH();
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra("extInfo", r1);
            intent.putExtra("fromURL", map2);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.ihN.a(intent, (com.tencent.mm.ui.MMActivity.a) this, (MMActivity) this.context);
        } else {
            a(iVar, "jump_to_biz_profile:fail", map2);
        }
        return true;
    }

    private boolean C(i iVar) {
        x.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", (String) iVar.pug.get("switch"), (String) iVar.pug.get("title_cn"), (String) iVar.pug.get("title_eng"), (String) iVar.pug.get("ok_cn"), (String) iVar.pug.get("ok_eng"), (String) iVar.pug.get("cancel_cn"), (String) iVar.pug.get("cancel_eng"));
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.fCC.n(13, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", e.getMessage());
        }
        a(iVar, "setCloseWindowConfirmDialogInfo:ok", null);
        return true;
    }

    private boolean d(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pug.get("verifyAppId");
        String str2 = (String) iVar.pug.get("verifyJsApiList");
        x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", str, (String) iVar.pug.get("verifySignature"), (String) iVar.pug.get("verifyNonceStr"), (String) iVar.pug.get("verifyTimestamp"), (String) iVar.pug.get("verifySignType"));
        k.a(iVar.tQf, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", Integer.valueOf(jSONArray.length()));
            if (jSONArray.length() == 0) {
                a(iVar, "checkJsApi:param is empty", null);
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!bi.oN(string)) {
                    linkedList.add(string);
                }
            }
            String aeH = this.fCC.aeH();
            int i2 = 0;
            String str3 = "";
            try {
                Bundle e = this.fCC.e(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, null);
                i2 = e.getInt("key_webview_preverify_info_scene", 0);
                str3 = e.getString("key_webview_preverify_info_source_appid", "");
            } catch (Exception e2) {
                x.e("TAG", "doPreVerifyJSAPI: %s", e2);
            }
            com.tencent.mm.ad.e eVar = this.tNZ;
            final JsapiPermissionWrapper jsapiPermissionWrapper2 = jsapiPermissionWrapper;
            final i iVar2 = iVar;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a anonymousClass49 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c() {
                public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a aVar, String str, LinkedList<bto> linkedList, int i, int i2) {
                    if (aVar != com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK || jsapiPermissionWrapper2.vHC == null) {
                        if (g.this.fCC != null) {
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper2.vHC);
                            try {
                                x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
                                g.this.fCC.n(1006, bundle);
                            } catch (Exception e) {
                                x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", e.getMessage());
                            }
                        }
                        if (bi.oN(str)) {
                            g.this.a(iVar2, "pre_verify_jsapi:fail", null);
                            return;
                        } else {
                            g.this.a(iVar2, "pre_verify_jsapi:fail_" + str, null);
                            return;
                        }
                    }
                    int i3;
                    g.this.tOd = bi.Wx();
                    if (linkedList == null || linkedList.size() <= 0) {
                        i3 = 0;
                    } else {
                        Iterator it = linkedList.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            bto bto = (bto) it.next();
                            com.tencent.mm.protocal.c.g TR = com.tencent.mm.protocal.c.TR(bi.oM(bto.wzP));
                            if (TR != null) {
                                int i4;
                                if (jsapiPermissionWrapper2.CY(TR.cef()) != bto.state) {
                                    jsapiPermissionWrapper2.a(TR.cef(), (byte) bto.state);
                                    i4 = 1;
                                } else {
                                    i4 = i3;
                                }
                                i3 = i4;
                            }
                        }
                    }
                    if (!(i3 == 0 || g.this.fCC == null)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper2.vHC);
                        try {
                            String str2 = "MicroMsg.MsgHandler";
                            String str3 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(jsapiPermissionWrapper2.vHC == null ? 0 : jsapiPermissionWrapper2.vHC.length);
                            objArr[1] = jsapiPermissionWrapper2;
                            x.i(str2, str3, objArr);
                            g.this.fCC.n(1006, bundle2);
                        } catch (Exception e2) {
                            x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", e2.getMessage());
                        }
                    }
                    g.this.a(iVar2, "pre_verify_jsapi:ok", null);
                }

                public final boolean bUY() {
                    return this.tNf;
                }
            };
            if (bi.oN(str) || linkedList.size() <= 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", str);
                anonymousClass49.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL, null, null, 0, 0);
            } else {
                as.CN().a(1093, eVar);
                as.CN().a(new com.tencent.mm.plugin.webview.model.m(anonymousClass49, aeH, str, linkedList, r9, r10, r11, r12, i2, str3, eVar.tyA), 0);
            }
            return true;
        } catch (Exception e22) {
            x.w("MicroMsg.MsgHandler", "exception occur " + e22.getMessage());
            a(iVar, "pre_verify_jsapi:fail", null);
            return true;
        }
    }

    private boolean D(i iVar) {
        Map hashMap = new HashMap();
        try {
            com.tencent.mm.sdk.b.b ddVar = new dd();
            ddVar.fss.fsj = true;
            com.tencent.mm.sdk.b.a.xmy.m(ddVar);
            if (ddVar.fst.fsk) {
                hashMap.put("currentSSID", ddVar.fst.fsu);
                a(iVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(iVar, "getCurrentSSID:fail", hashMap);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(iVar, "getCurrentSSID:fail", hashMap);
        }
        return true;
    }

    private boolean E(i iVar) {
        int bSQ = bSQ();
        int aRY = aRY();
        String bVn = bVn();
        x.i("MicroMsg.MsgHandler", "Key Scene(%d)", Integer.valueOf(aRY));
        if (aRY == 27) {
            this.tNR = (String) iVar.pug.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", this.tNR);
        } else if (!(bSQ == 8 || bSQ == -1)) {
            this.kMt = (String) iVar.pug.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", this.kMt);
            if (!(bi.oN(bVn) || bi.oN(this.kMt))) {
                x.i("MicroMsg.MsgHandler", "Chat name(%s)", bVn);
                com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(bVn);
                if (jV != null) {
                    com.tencent.mm.af.d.b bK = jV.bK(false);
                    if (!(bK == null || bK.LE() == null || !bK.LE().LN() || bVn.equals(this.kMt))) {
                        a(iVar, "openWXDeviceLib:fail_UsernameError", null);
                        return true;
                    }
                }
            }
        }
        bVn = O(iVar);
        x.i("MicroMsg.MsgHandler", "srcUsername(%s)", bVn);
        if (bi.oN(bVn)) {
            a(iVar, "openWXDeviceLib:fail_UsernameError", null);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(11533, bVn, "openWXDeviceLib");
            String str = "";
            if (iVar.pug.containsKey("connType")) {
                str = (String) iVar.pug.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.tNT == null) {
                    this.tNT = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a bUa = com.tencent.mm.plugin.webview.ui.tools.a.a.bUa();
                    e eVar = this.fCC;
                    x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (bUa.tIk == null) {
                        bUa.tIk = new com.tencent.mm.plugin.webview.ui.tools.a.a.a(eVar, bVn);
                        com.tencent.mm.sdk.b.a.xmy.b(bUa.tIk.tIp);
                        com.tencent.mm.sdk.b.a.xmy.b(bUa.tIk.tIq);
                        com.tencent.mm.sdk.b.a.xmy.b(bUa.tIk.tIs);
                        com.tencent.mm.sdk.b.a.xmy.b(bUa.tIk.tIr);
                        com.tencent.mm.sdk.b.a.xmy.b(bUa.tIk.tIt);
                    }
                    com.tencent.mm.sdk.b.b dwVar = new dw();
                    dwVar.fto.fsj = true;
                    com.tencent.mm.sdk.b.a.xmy.m(dwVar);
                    bUa.hasInit = true;
                    bUa.fsi = bVn;
                    bUa.tIm = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.a.bUa());
                    if (ao.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(iVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", e.getMessage());
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            } else {
                if (this.tNS == null) {
                    this.tNS = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b bUd = com.tencent.mm.plugin.webview.ui.tools.a.b.bUd();
                    e eVar2 = this.fCC;
                    x.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (bUd.tIv == null) {
                        bUd.tIv = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, bVn);
                        com.tencent.mm.sdk.b.a.xmy.b(bUd.tIv.tIz);
                        com.tencent.mm.sdk.b.a.xmy.b(bUd.tIv.tIA);
                        com.tencent.mm.sdk.b.a.xmy.b(bUd.tIv.tIB);
                        com.tencent.mm.sdk.b.a.xmy.b(bUd.tIv.tIp);
                        com.tencent.mm.sdk.b.a.xmy.b(bUd.tIv.qyk);
                    }
                    com.tencent.mm.sdk.b.b dqVar = new dq();
                    dqVar.fth.op = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(dqVar);
                    bUd.hasInit = true;
                    bUd.fsi = bVn;
                    bUd.tIm = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.b.bUd());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                        }
                    }
                    obj = "unknow";
                    x.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", Boolean.valueOf(ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")));
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (bSQ == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(iVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", e2.getMessage());
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            }
        }
        return true;
    }

    private boolean F(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "closeWXDeviceLib");
                com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().bUb();
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", e.getMessage());
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        } else {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "closeWXDeviceLib");
                com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().bUb();
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", e2.getMessage());
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        }
        a(iVar, "closeWXDeviceLib:ok", null);
        return true;
    }

    private boolean G(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                try {
                    x.i("MicroMsg.MsgHandler", "srcUsername(%s)", O(iVar));
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "startScanWXDevice");
                    if (bi.oN(O(iVar))) {
                        a(iVar, "startScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b enVar = new en();
                        enVar.ftY.fsj = true;
                        com.tencent.mm.sdk.b.a.xmy.m(enVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().tIo = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", e.getMessage());
                    a(iVar, "startScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(iVar, "startScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.compatible.util.f.fN(23) && !((LocationManager) this.context.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            x.d("MicroMsg.MsgHandler", "Android version realse code: %s", VERSION.RELEASE);
            x.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(iVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            try {
                String O = O(iVar);
                str = (String) iVar.pug.get("btVersion");
                x.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", str, O);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "startScanWXDevice");
                if (bi.oN(O)) {
                    a(iVar, "startScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dxVar = new dx();
                    dxVar.ftp.fsj = true;
                    dxVar.ftp.fsi = O;
                    if (bi.oM(str).equals("ble")) {
                        dxVar.ftp.ftr = 0;
                    } else if (bi.oM(str).equals("bc")) {
                        dxVar.ftp.ftr = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().tIx = dxVar.ftp.ftr;
                    com.tencent.mm.sdk.b.a.xmy.m(dxVar);
                    if (dxVar.ftq.fsk) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().tIo = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    } else {
                        a(iVar, "startScanWXDevice:fail", null);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", e2.getMessage());
                a(iVar, "startScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(iVar, "startScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean H(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                try {
                    str = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "stopScanWXDevice");
                    if (bi.oN(str)) {
                        a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b enVar = new en();
                        enVar.ftY.fsj = false;
                        com.tencent.mm.sdk.b.a.xmy.m(enVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().tIo = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", e.getMessage());
                    a(iVar, "stopScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(iVar, "stopScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "stopScanWXDevice");
                if (bi.oN(str)) {
                    a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dxVar = new dx();
                    dxVar.ftp.fsj = false;
                    dxVar.ftp.fsi = str;
                    dxVar.ftp.ftr = com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().tIx;
                    com.tencent.mm.sdk.b.a.xmy.m(dxVar);
                    if (dxVar.ftq.fsk) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().tIo = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(iVar, "stopScanWXDevice:fail", null);
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", e2.getMessage());
                a(iVar, "stopScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(iVar, "stopScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean I(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        String O;
        com.tencent.mm.sdk.b.b daVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                str = (String) iVar.pug.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", str);
                if (bi.oN(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "connectWXDevice:fail_noDeviceId", null);
                } else {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "connectWXDevice");
                    if (bi.oN(O)) {
                        a(iVar, "connectWXDevice:fail_UsernameError", null);
                    } else {
                        if (!(this.tNT == null || this.tNT.containsKey(O))) {
                            this.tNT.put(O, str);
                        }
                        try {
                            daVar = new da();
                            daVar.fsl.fsj = true;
                            daVar.fsl.fsi = O;
                            daVar.fsl.ffG = str;
                            com.tencent.mm.sdk.b.a.xmy.m(daVar);
                            if (daVar.fsm.fsk) {
                                a(iVar, "connectWXDevice:ok", null);
                            } else {
                                a(iVar, "connectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", e.getMessage());
                            a(iVar, "connectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(iVar, "connectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            str = (String) iVar.pug.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", str);
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "connectWXDevice:fail_noDeviceId", null);
            } else {
                O = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "connectWXDevice");
                if (bi.oN(O)) {
                    a(iVar, "connectWXDevice:fail_UsernameError", null);
                } else {
                    if (!(this.tNS == null || this.tNS.containsValue(str))) {
                        this.tNS.put(O, str);
                    }
                    try {
                        daVar = new cz();
                        daVar.fsg.fsj = true;
                        daVar.fsg.fsi = O;
                        daVar.fsg.ffG = str;
                        com.tencent.mm.sdk.b.a.xmy.m(daVar);
                        if (daVar.fsh.fsk) {
                            a(iVar, "connectWXDevice:ok", null);
                        } else {
                            a(iVar, "connectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", e2.getMessage());
                        a(iVar, "connectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(iVar, "connectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean J(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        String O;
        com.tencent.mm.sdk.b.b daVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                str = (String) iVar.pug.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", str);
                if (bi.oN(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                } else {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "disconnectWXDevice");
                    if (bi.oN(O)) {
                        a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                    } else {
                        try {
                            daVar = new da();
                            daVar.fsl.fsj = false;
                            daVar.fsl.fsi = O;
                            daVar.fsl.ffG = str;
                            com.tencent.mm.sdk.b.a.xmy.m(daVar);
                            if (daVar.fsm.fsk) {
                                a(iVar, "disconnectWXDevice:ok", null);
                                if (this.tNT != null && this.tNT.containsKey(O)) {
                                    this.tNT.remove(O);
                                }
                            } else {
                                a(iVar, "disconnectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", e.getMessage());
                            a(iVar, "disconnectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(iVar, "disconnectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            str = (String) iVar.pug.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", str);
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
            } else {
                O = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "disconnectWXDevice");
                if (bi.oN(O)) {
                    a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                } else {
                    try {
                        daVar = new cz();
                        daVar.fsg.fsj = false;
                        daVar.fsg.fsi = O;
                        daVar.fsg.ffG = str;
                        com.tencent.mm.sdk.b.a.xmy.m(daVar);
                        if (daVar.fsh.fsk) {
                            a(iVar, "disconnectWXDevice:ok", null);
                            if (this.tNS != null && this.tNS.containsKey(O)) {
                                this.tNS.remove(O);
                            }
                        } else {
                            a(iVar, "disconnectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", e2.getMessage());
                        a(iVar, "disconnectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(iVar, "disconnectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean K(final i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
            String str = (String) iVar.pug.get("deviceId");
            String str2 = (String) iVar.pug.get(Columns.TYPE);
            x.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", str, str2);
            if (bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(iVar, "getWXDeviceTicket:fail_wrongParams", null);
            } else {
                try {
                    String O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "getWXDeviceTicket");
                    if (bi.oN(O)) {
                        a(iVar, "getWXDeviceTicket:fail_UsernameError", null);
                    } else {
                        final com.tencent.mm.sdk.b.b dhVar = new dh();
                        dhVar.fsG.type = bi.getInt(str2, 0);
                        dhVar.fsG.fsi = O;
                        dhVar.fsG.ffG = str;
                        dhVar.fsG.fsI = iVar.tQe;
                        dhVar.frD = new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", Boolean.valueOf(dhVar.fsH.fsJ), dhVar.fsH.fsK);
                                if (!dhVar.fsH.fsJ) {
                                    return;
                                }
                                if (bi.oN(dhVar.fsH.fsK)) {
                                    g.this.a(iVar, "getWXDeviceTicket:fail", null);
                                    return;
                                }
                                Map hashMap = new HashMap();
                                x.i("MicroMsg.MsgHandler", "ticket %s", dhVar.fsH.fsK);
                                hashMap.put("ticket", dhVar.fsH.fsK);
                                g.this.a(iVar, "getWXDeviceTicket:ok", hashMap);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.a(dhVar, Looper.getMainLooper());
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", e.getMessage());
                    a(iVar, "getWXDeviceTicket:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(iVar, "getWXDeviceTicket:fail_notInit", null);
        }
        return true;
    }

    private boolean L(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        com.tencent.mm.sdk.b.b dfVar;
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                try {
                    str = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "getWXDeviceInfos");
                    x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", str);
                    if (bi.oN(str)) {
                        a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                    } else {
                        dfVar = new df();
                        dfVar.fsy.fsi = str;
                        dfVar.fsy.context = this.context;
                        com.tencent.mm.sdk.b.a.xmy.m(dfVar);
                        if (!dfVar.fsz.fsk || dfVar.fsz.fsx == null) {
                            a(iVar, "getWXDeviceInfos:fail", null);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", dfVar.fsz.fsx.toString());
                            a(iVar, "getWXDeviceInfos:ok", hashMap);
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", e.getMessage());
                    a(iVar, "getWXDeviceInfos:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(iVar, "getWXDeviceInfos:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pWK.h(11533, str, "getWXDeviceInfos");
                x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", str);
                if (bi.oN(str)) {
                    a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                } else {
                    dfVar = new de();
                    dfVar.fsv.fsi = str;
                    dfVar.fsv.context = this.context;
                    com.tencent.mm.sdk.b.a.xmy.m(dfVar);
                    if (!dfVar.fsw.fsk || dfVar.fsw.fsx == null) {
                        a(iVar, "getWXDeviceInfos:fail", null);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", dfVar.fsw.fsx.toString());
                        a(iVar, "getWXDeviceInfos:ok", hashMap);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", e2.getMessage());
                a(iVar, "getWXDeviceInfos:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(iVar, "getWXDeviceInfos:fail_notInit", null);
        }
        return true;
    }

    private boolean M(i iVar) {
        String str = "";
        if (iVar.pug.containsKey("connType")) {
            str = (String) iVar.pug.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        boolean z;
        String O;
        com.tencent.mm.sdk.b.b eaVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bUa().hasInit) {
                str = (String) iVar.pug.get("deviceId");
                str2 = (String) iVar.pug.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                if (bi.oN(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str3, str4, objArr);
                if (bi.oN(str) || str2 == null) {
                    x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                } else {
                    try {
                        O = O(iVar);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "sendDataToWXDevice");
                        if (bi.oN(O)) {
                            a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                        } else {
                            eaVar = new ea();
                            eaVar.ftw.fsi = O;
                            eaVar.ftw.data = str2;
                            eaVar.ftw.ffG = str;
                            com.tencent.mm.sdk.b.a.xmy.m(eaVar);
                            if (eaVar.ftx.fsk) {
                                a(iVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(iVar, "sendDataToWXDevice:fail", null);
                            }
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", e.getMessage());
                        a(iVar, "sendDataToWXDevice:fail_exception", null);
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(iVar, "sendDataToWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            str = (String) iVar.pug.get("deviceId");
            str2 = (String) iVar.pug.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            if (bi.oN(str2)) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str3, str4, objArr);
            if (bi.oN(str) || str2 == null) {
                x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
            } else {
                try {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "sendDataToWXDevice");
                    if (bi.oN(O)) {
                        a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                    } else {
                        eaVar = new dz();
                        eaVar.ftu.fsi = O;
                        eaVar.ftu.data = Base64.decode(str2, 0);
                        eaVar.ftu.ffG = str;
                        com.tencent.mm.sdk.b.a.xmy.m(eaVar);
                        if (eaVar.ftv.fsk) {
                            a(iVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(iVar, "sendDataToWXDevice:fail", null);
                        }
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", e2.getMessage());
                    a(iVar, "sendDataToWXDevice:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(iVar, "sendDataToWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean N(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().hasInit) {
            try {
                String str = (String) iVar.pug.get("deviceId");
                String str2 = (String) iVar.pug.get(TencentLocation.EXTRA_DIRECTION);
                x.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", str, str2);
                if (bi.oN(str) || bi.oN(str2)) {
                    x.e("MicroMsg.MsgHandler", "wrong args");
                    a(iVar, "setSendDataDirection:fail_wrongParams", null);
                } else {
                    int i = bi.getInt(str2, 0);
                    String O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11533, O, "setSendDataDirection");
                    if (bi.oN(O)) {
                        a(iVar, "setSendDataDirection:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b edVar = new ed();
                        edVar.ftG.ffG = str;
                        edVar.ftG.direction = i;
                        edVar.ftG.clear = false;
                        com.tencent.mm.sdk.b.a.xmy.m(edVar);
                        if (edVar.ftH.fsk) {
                            a(iVar, "setSendDataDirection:ok", null);
                        } else {
                            a(iVar, "setSendDataDirection:fail", null);
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", e.getMessage());
                a(iVar, "setSendDataDirection:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(iVar, "setSendDataDirection:fail_notInit", null);
        }
        return true;
    }

    public String bVn() {
        try {
            if (this.fCC == null) {
                return null;
            }
            Bundle e = this.fCC.e(18, null);
            if (e != null) {
                return e.getString("preChatName");
            }
            return null;
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e2);
            return null;
        }
    }

    public int bSQ() {
        try {
            if (this.fCC == null) {
                return -1;
            }
            Bundle e = this.fCC.e(22, null);
            if (e != null) {
                return e.getInt("pay_channel");
            }
            return -1;
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e2);
            return -1;
        }
    }

    public int aRY() {
        try {
            if (this.fCC == null) {
                return 0;
            }
            Bundle e = this.fCC.e(25, null);
            if (e != null) {
                return e.getInt("scene");
            }
            return 0;
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e2);
            return 0;
        }
    }

    private int aim() {
        try {
            if (this.fCC == null) {
                return 0;
            }
            Bundle e = this.fCC.e(99, null);
            if (e != null) {
                return e.getInt("geta8key_scene");
            }
            return 0;
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e2);
            return 0;
        }
    }

    private String O(i iVar) {
        String bVn = bVn();
        if (aRY() == 27) {
            return this.tNR;
        }
        String str;
        if (bSQ() == 8 || bSQ() == -1) {
            if (iVar == null) {
                return null;
            }
            str = (String) iVar.pug.get("src_username");
            x.i("MicroMsg.MsgHandler", "key_src_username(%s)", (String) iVar.pug.get("src_username"));
            return str;
        } else if (this.kMt != null) {
            return this.kMt;
        } else {
            if (bi.oN(bVn)) {
                return null;
            }
            x.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(bVn);
            if (jV == null) {
                return null;
            }
            com.tencent.mm.af.d.b bK = jV.bK(false);
            if (bK == null || bK.LE() == null || !bK.LE().LN()) {
                return null;
            }
            str = (String) iVar.pug.get("src_username");
            x.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", (String) iVar.pug.get("src_username"));
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean P(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r14) {
        /*
        r13 = this;
        r6 = 7;
        r12 = 2;
        r2 = 3;
        r11 = 1;
        r5 = 0;
        r0 = r14.pug;
        r1 = "sourceType";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = "MicroMsg.MsgHandler";
        r3 = "source Type = %s";
        r4 = new java.lang.Object[r11];
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 != 0) goto L_0x019c;
    L_0x0023:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0052 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0052 }
        r1 = r5;
        r0 = r5;
    L_0x002a:
        r4 = r3.length();	 Catch:{ Exception -> 0x0192 }
        if (r1 >= r4) goto L_0x005d;
    L_0x0030:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "album";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x0042;
    L_0x003d:
        r0 = r0 | 1;
    L_0x003f:
        r1 = r1 + 1;
        goto L_0x002a;
    L_0x0042:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "camera";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x003f;
    L_0x004f:
        r0 = r0 | 2;
        goto L_0x003f;
    L_0x0052:
        r0 = move-exception;
        r0 = r5;
    L_0x0054:
        r1 = "MicroMsg.MsgHandler";
        r3 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
    L_0x005d:
        if (r0 != 0) goto L_0x0199;
    L_0x005f:
        r1 = r2;
    L_0x0060:
        r0 = "MicroMsg.MsgHandler";
        r3 = "real scene = %d";
        r4 = new java.lang.Object[r11];
        r7 = java.lang.Integer.valueOf(r1);
        r4[r5] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        if (r1 == r12) goto L_0x0075;
    L_0x0073:
        if (r1 != r2) goto L_0x009c;
    L_0x0075:
        r0 = r13.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r7 = "";
        r8 = "";
        r0 = com.tencent.mm.pluginsdk.g.a.a(r0, r3, r4, r7, r8);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r7 = new java.lang.Object[r11];
        r8 = java.lang.Boolean.valueOf(r0);
        r7[r5] = r8;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r7);
        if (r0 != 0) goto L_0x009c;
    L_0x009b:
        return r11;
    L_0x009c:
        r0 = r14.pug;
        r3 = "count";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r7 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r5);
        r0 = r14.pug;
        r3 = "sizeType";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r4 = java.lang.Boolean.valueOf(r5);
        r3 = java.lang.Boolean.valueOf(r5);
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r8 != 0) goto L_0x0195;
    L_0x00c4:
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00fa }
        r8.<init>(r0);	 Catch:{ Exception -> 0x00fa }
        r0 = r3;
        r3 = r4;
        r4 = r5;
    L_0x00cc:
        r9 = r8.length();	 Catch:{ Exception -> 0x018f }
        if (r4 >= r9) goto L_0x0106;
    L_0x00d2:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "original";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e7;
    L_0x00df:
        r9 = 1;
        r3 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
    L_0x00e4:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x00e7:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "compressed";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e4;
    L_0x00f4:
        r9 = 1;
        r0 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
        goto L_0x00e4;
    L_0x00fa:
        r0 = move-exception;
        r0 = r3;
        r3 = r4;
    L_0x00fd:
        r4 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.x.e(r4, r8);
    L_0x0106:
        r4 = r3.booleanValue();
        if (r4 == 0) goto L_0x0175;
    L_0x010c:
        r4 = r0.booleanValue();
        if (r4 != 0) goto L_0x0175;
    L_0x0112:
        r0 = java.lang.Boolean.valueOf(r11);
        r4 = r6;
    L_0x0117:
        r3 = new android.content.Intent;
        r3.<init>();
        r6 = "key_pick_local_pic_capture";
        r3.putExtra(r6, r1);
        r6 = "key_pick_local_pic_count";
        r3.putExtra(r6, r7);
        r6 = "key_pick_local_pic_query_source_type";
        r3.putExtra(r6, r4);
        r6 = "key_pick_local_pic_send_raw";
        r3.putExtra(r6, r0);
        r6 = "query_media_type";
        r3.putExtra(r6, r11);
        r6 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r1 = java.lang.Integer.valueOf(r1);
        r9[r5] = r1;
        r1 = java.lang.Integer.valueOf(r7);
        r9[r11] = r1;
        r1 = java.lang.Integer.valueOf(r4);
        r9[r12] = r1;
        r9[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r6, r8, r9);
        r0 = r13.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x009b;
    L_0x0160:
        r0 = r13.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.jCj = r13;
        r0 = r13.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 14;
        com.tencent.mm.bl.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x009b;
    L_0x0175:
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0187;
    L_0x017b:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0187;
    L_0x0181:
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r6;
        goto L_0x0117;
    L_0x0187:
        r3 = 8;
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r3;
        goto L_0x0117;
    L_0x018f:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x0192:
        r1 = move-exception;
        goto L_0x0054;
    L_0x0195:
        r0 = r3;
        r3 = r4;
        goto L_0x0106;
    L_0x0199:
        r1 = r0;
        goto L_0x0060;
    L_0x019c:
        r0 = r5;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.P(com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    private boolean Q(i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            k.a(iVar.tQf, false, null, str);
            x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadImage:fail_missing arguments", null);
            } else {
                a(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadImage", z);
            }
            return true;
        }
        z = true;
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadImage:fail_missing arguments", null);
        return true;
    }

    private boolean R(final i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        final String str2 = (String) iVar.pug.get("serverId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            k.a(iVar.tQf, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", str, str2);
            if (!bi.oN(str) || bi.oN(str2)) {
                a(iVar, "downloadImage:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.model.c.b anonymousClass53 = new com.tencent.mm.plugin.webview.model.c.b() {
                    public final void a(boolean z, String str, String str2, String str3) {
                        x.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", Boolean.valueOf(z), str, str2);
                        if (!bi.oN(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (g.this.inI != null) {
                                g.this.inI.dismiss();
                                g.this.inI = null;
                            }
                            if (z) {
                                WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str);
                                if ((OS instanceof WebViewJSSDKImageItem) && bi.oN(OS.jlG)) {
                                    ((WebViewJSSDKImageItem) OS).bRD();
                                }
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                g.this.a(iVar, "downloadImage:ok", hashMap);
                                return;
                            }
                            g.this.a(iVar, "downloadImage:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, anonymousClass53);
                x.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", Boolean.valueOf(true));
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYz), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a(anonymousClass53);
                            com.tencent.mm.plugin.webview.modeltools.f.bSn();
                            com.tencent.mm.plugin.webview.model.ac.OO(str2);
                            g.this.a(iVar, "downloadImage:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", str, str2);
        if (bi.oN(str)) {
        }
        a(iVar, "downloadImage:fail_missing arguments", null);
        return true;
    }

    private boolean S(i iVar) {
        boolean z;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (bi.oN(str) && !bi.oN(str2)) {
                k.a(iVar.tQf, false, null, str);
                WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
                if (OS != null) {
                    switch (OS.fuz) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.hty, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hty, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hty, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                }
                x.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", str2);
                a(iVar, "uploadEncryptMediaFile:file_not_exist", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        return true;
    }

    private boolean T(final i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseMedia()");
        x.i("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", "")));
        if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", "")) {
            return true;
        }
        x.i("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")));
        if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")) {
            return true;
        }
        int i;
        String str;
        String oM = bi.oM((String) iVar.pug.get("sourceType"));
        String oM2 = bi.oM((String) iVar.pug.get("mediaType"));
        int min = Math.min(bi.getInt((String) iVar.pug.get("maxDuration"), 10), 10);
        final String oM3 = bi.oM((String) iVar.pug.get("camera"));
        int i2 = bi.getInt((String) iVar.pug.get("count"), 1);
        String oM4 = bi.oM((String) iVar.pug.get("sizeType"));
        x.i("MicroMsg.MsgHandler", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", oM, oM2, Integer.valueOf(min), oM3, Integer.valueOf(i2), oM4);
        final Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_count", i2);
        if (min <= 0) {
            i = 10;
        } else {
            i = min;
        }
        intent.putExtra("key_pick_local_media_duration", i);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("key_pick_local_media_video_type", 2);
        intent.putExtra("key_pick_local_media_sight_type", oM2);
        intent.putExtra("key_pick_local_pic_query_source_type", (oM4.contains("original") ^ oM4.contains("compressed")) != 0 ? 7 : 8);
        intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(oM4.contains("compressed")));
        if (bi.oN(oM)) {
            str = "album|camera";
        } else {
            str = oM;
        }
        if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
            com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.context);
            lVar.b(null, new OnCreateContextMenuListener() {
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 1, 0, g.this.context.getString(R.l.dFh));
                    contextMenu.add(0, 2, 1, g.this.context.getString(R.l.dFl));
                }
            }, new com.tencent.mm.ui.base.p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            g.this.a(oM3, intent);
                            return;
                        case 2:
                            g.this.J(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            lVar.e(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.this.a(iVar, "doChooseMedia:cancel", null);
                }
            });
            lVar.bCH();
            return true;
        } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            J(intent);
            return true;
        } else if (str.contains("camera")) {
            a(oM3, intent);
            return true;
        } else {
            a(iVar, "chooseMedia:fail_sourceType_error", null);
            return true;
        }
    }

    private void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.MsgHandler", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        ((MMActivity) this.context).jCj = this;
        com.tencent.mm.bl.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    private void J(Intent intent) {
        x.i("MicroMsg.MsgHandler", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        ((MMActivity) this.context).jCj = this;
        com.tencent.mm.bl.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r13, int r14) {
        /*
        r12 = this;
        r1 = 60;
        r11 = 3;
        r10 = 2;
        r5 = 0;
        r6 = 1;
        r0 = r13.pug;
        r2 = "sourceType";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
        r0 = r13.pug;
        r2 = "camera";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
        r0 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d";
        r7 = new java.lang.Object[r11];
        r7[r5] = r3;
        r7[r6] = r4;
        r8 = java.lang.Integer.valueOf(r14);
        r7[r10] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r7);
        r0 = r13.pug;
        r2 = "maxDuration";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
        r0 = "album";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x01ba;
    L_0x0051:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x0053:
        r7 = "camera";
        r3 = r3.contains(r7);
        if (r3 == 0) goto L_0x0071;
    L_0x005c:
        if (r2 > 0) goto L_0x0066;
    L_0x005e:
        r0 = "chooseVideo:fail";
        r1 = 0;
        r12.a(r13, r0, r1);
    L_0x0065:
        return r6;
    L_0x0066:
        r3 = "front";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0176;
    L_0x006f:
        r0 = r0 | 16;
    L_0x0071:
        if (r0 != 0) goto L_0x01b7;
    L_0x0073:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        r7 = r0;
    L_0x0076:
        r0 = 16;
        if (r7 == r0) goto L_0x0082;
    L_0x007a:
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r7 == r0) goto L_0x0082;
    L_0x007e:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        if (r7 != r0) goto L_0x00d0;
    L_0x0082:
        if (r14 != r6) goto L_0x017a;
    L_0x0084:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.g.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00aa:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.RECORD_AUDIO";
        r4 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.g.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkMicroPhone[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00d0:
        r0 = r13.pug;
        r3 = "quality";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r6);
        if (r0 == 0) goto L_0x01b4;
    L_0x00e1:
        if (r0 == r6) goto L_0x01b4;
    L_0x00e3:
        r4 = r6;
    L_0x00e4:
        if (r2 <= r1) goto L_0x01b1;
    L_0x00e6:
        r0 = r1;
    L_0x00e7:
        r1 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r8 = java.lang.Integer.valueOf(r7);
        r3[r5] = r8;
        r8 = java.lang.Integer.valueOf(r6);
        r3[r6] = r8;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r10] = r8;
        r8 = java.lang.Integer.valueOf(r0);
        r3[r11] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r3 = new android.content.Intent;
        r3.<init>();
        r1 = "key_pick_local_pic_capture";
        r3.putExtra(r1, r7);
        r1 = "key_pick_local_pic_count";
        r3.putExtra(r1, r6);
        r1 = "key_pick_local_pic_query_source_type";
        r2 = 7;
        r3.putExtra(r1, r2);
        r1 = "key_pick_local_media_quality";
        r3.putExtra(r1, r4);
        r1 = "key_pick_local_media_duration";
        r3.putExtra(r1, r0);
        r0 = "query_media_type";
        r3.putExtra(r0, r10);
        r0 = "key_pick_local_media_video_type";
        r3.putExtra(r0, r14);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doChooseVideo: realScene: %d, count: %d, querySourceType: %d";
        r2 = new java.lang.Object[r11];
        r4 = java.lang.Integer.valueOf(r7);
        r2[r5] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r2[r6] = r4;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r10] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r12.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x0065;
    L_0x015f:
        r0 = r12.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.jCj = r12;
        if (r14 != r6) goto L_0x01a2;
    L_0x0167:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 45;
        com.tencent.mm.bl.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x0176:
        r0 = r0 | 256;
        goto L_0x0071;
    L_0x017a:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.g.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 != 0) goto L_0x00d0;
    L_0x01a0:
        goto L_0x0065;
    L_0x01a2:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 32;
        com.tencent.mm.bl.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x01b1:
        r0 = r2;
        goto L_0x00e7;
    L_0x01b4:
        r4 = r0;
        goto L_0x00e4;
    L_0x01b7:
        r7 = r0;
        goto L_0x0076;
    L_0x01ba:
        r0 = r5;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, int):boolean");
    }

    private boolean U(i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (bi.oN(str) && !bi.oN(str2)) {
                k.a(iVar.tQf, false, null, str);
                WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
                if (OS != null) {
                    switch (OS.fuz) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.htA, 202, 2, bd.NAME, z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.htB, 202, 2, bd.NAME, z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.htD, 202, 2, bd.NAME, z);
                            break;
                    }
                }
                a(iVar, "uploadMediaFile:fail", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadMediaFile:fail_missing arguments", null);
        return true;
    }

    private void a(final i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final String str5 = str2;
        AnonymousClass59 anonymousClass59 = new com.tencent.mm.plugin.webview.model.c.b() {
            public final void a(boolean z, String str, String str2, String str3) {
                x.i("MicroMsg.MsgHandler", str4 + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!bi.oN(str) && str.equals(str5)) {
                    com.tencent.mm.plugin.webview.modeltools.f.bSn().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (g.this.inI != null) {
                        g.this.inI.dismiss();
                        g.this.inI = null;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        g.this.a(iVar, str4 + ":ok", hashMap);
                        return;
                    }
                    g.this.a(iVar, str4 + ":fail", null);
                }
            }
        };
        WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
        if (OS == null) {
            a(iVar, str3 + ":fail", null);
            return;
        }
        com.tencent.mm.ap.e b = o.PC().b(Long.valueOf(o.PC().a(OS.iOz, OS.iOD ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str6 = OS.iOz;
        OS.iOz = o.PC().m(b.hBB, "", "");
        x.i("MicroMsg.MsgHandler", "Image Inserted: %s", r2);
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, i, i2, i3, anonymousClass59)));
        if (!com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, i, i2, i3, anonymousClass59)) {
            a(iVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(R.l.dGZ);
            final AnonymousClass59 anonymousClass592 = anonymousClass59;
            final String str7 = str2;
            final i iVar2 = iVar;
            final String str8 = str3;
            this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYV), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.plugin.webview.modeltools.f.bSn().a(anonymousClass592);
                    com.tencent.mm.plugin.webview.modeltools.f.bSn();
                    com.tencent.mm.plugin.webview.model.ac.qC(str7);
                    g.this.a(iVar2, str8 + ":fail", null);
                }
            });
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.fCC = this.tNW;
        }
        OS.iOz = str6;
    }

    private void b(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
        if (OS == null || bi.oN(OS.iOz) || !com.tencent.mm.a.e.bO(OS.iOz)) {
            a(iVar, str3 + ":fail_file not exist", null);
        } else if (ab.bC(this.context)) {
            c(iVar, str, str2, i, i2, i3, str3, z);
        } else {
            String fL = bi.fL((long) com.tencent.mm.a.e.bN(OS.iOz));
            final i iVar2 = iVar;
            final String str4 = str;
            final String str5 = str2;
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str6 = str3;
            final boolean z2 = z;
            final i iVar3 = iVar;
            final String str7 = str3;
            com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.eXl, new Object[]{fL}), this.context.getString(R.l.dGZ), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.this.c(iVar2, str4, str5, i4, i5, i6, str6, z2);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.this.a(iVar3, str7 + ":cancel", null);
                }
            });
        }
    }

    private void c(final i iVar, String str, final String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass64 = new com.tencent.mm.plugin.webview.model.c.b() {
            public final void a(boolean z, String str, String str2, String str3) {
                x.i("MicroMsg.MsgHandler", str4 + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!bi.oN(str) && str.equals(str2)) {
                    g.this.tOt.remove(str2);
                    com.tencent.mm.plugin.webview.modeltools.f.bSn().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (g.this.inI != null) {
                        g.this.inI.dismiss();
                        g.this.inI = null;
                    }
                    g.B(g.this);
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        g.this.a(iVar, str4 + ":ok", hashMap);
                        return;
                    }
                    g.this.a(iVar, str4 + ":fail", null);
                }
            }
        };
        boolean a = com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, i, i2, i3, anonymousClass64);
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", Boolean.valueOf(a));
        if (a) {
            b bVar = new b();
            bVar.tNN = iVar;
            bVar.tQa = anonymousClass64;
            this.tOt.put(str2, bVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(R.l.eXm));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(R.l.eXm));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(R.l.eXj));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(R.l.eXj));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(R.l.eXk));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(R.l.eXk));
            try {
                this.fCC.n(13, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", e.getMessage());
            }
            if (z) {
                Context context = this.context;
                this.context.getString(R.l.dGZ);
                final String str5 = str2;
                final i iVar2 = iVar;
                final String str6 = str3;
                this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYV), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.webview.modeltools.f.bSn().a(anonymousClass64);
                        com.tencent.mm.plugin.webview.modeltools.f.bSn();
                        com.tencent.mm.plugin.webview.model.ac.qC(str5);
                        g.B(g.this);
                        g.this.a(iVar2, str6 + ":cancel", null);
                    }
                });
                this.inI.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        com.tencent.mm.ui.base.h.a(g.this.context, true, g.this.context.getString(R.l.eXm), "", g.this.context.getString(R.l.eXj), g.this.context.getString(R.l.eXk), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.this.inI.cancel();
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return true;
                    }
                });
                return;
            } else if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.fCC = this.tNW;
                return;
            } else {
                return;
            }
        }
        a(iVar, str3 + ":fail", null);
    }

    private boolean V(i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occurred : %s", e.getMessage());
            }
            x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVideo:fail_missing arguments", null);
            } else {
                b(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadVideo", z);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVideo:fail_missing arguments", null);
        return true;
    }

    public final boolean bVo() {
        boolean z = !bi.oN(this.tOu);
        if (z) {
            x.e("MicroMsg.MsgHandler", "in recording state.");
        }
        return z;
    }

    private boolean W(final i iVar) {
        if (bVo()) {
            try {
                this.fCC.n(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(iVar, "startRecord:fail_recording", null);
        } else {
            String str = (String) iVar.pug.get("appId");
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(iVar, "startRecord:fail_missing arguments", null);
            } else {
                k.a(iVar.tQf, false, null, str);
                if (com.tencent.mm.pluginsdk.g.a.aZ(this.context, "android.permission.RECORD_AUDIO")) {
                    final WebViewJSSDKFileItem OQ = WebViewJSSDKFileItem.OQ(ai.OZ(str));
                    OQ.appId = str;
                    com.tencent.mm.plugin.webview.modeltools.f.bSo().b(OQ);
                    x.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", str, r1, OQ.iOz);
                    this.tOu = OQ.fvn;
                    ah.y(new Runnable() {
                        public final void run() {
                            final com.tencent.mm.sdk.b.b fdVar = new fd();
                            fdVar.fuV.op = 1;
                            fdVar.fuV.filePath = OQ.iOz;
                            fdVar.fuV.duration = bi.getInt((String) iVar.pug.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION), 60);
                            fdVar.fuV.fif = new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", OQ.fvn);
                                    try {
                                        g.this.tOu = null;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("localId", OQ.fvn);
                                        String str = "recordResult";
                                        StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
                                        String str2 = (fdVar.fuW.fuX != 2 || fdVar.fuW.fuX == 3) ? "ok" : "fail";
                                        bundle.putString(str, stringBuilder.append(str2).toString());
                                        if (g.this.fCC != null) {
                                            g.this.fCC.n(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER, bundle);
                                        } else {
                                            x.e("MicroMsg.MsgHandler", "callbacker is null");
                                        }
                                    } catch (Exception e) {
                                        x.e("MicroMsg.MsgHandler", "callback stop record failed");
                                    }
                                }
                            };
                            com.tencent.mm.sdk.b.a.xmy.m(fdVar);
                        }
                    });
                    try {
                        this.fCC.n(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(iVar, "startRecord:ok", null);
                } else {
                    WebViewStubTempUI.a(this.context, this.fCC, new String[]{"android.permission.RECORD_AUDIO"}, this.fEg);
                }
            }
        }
        return true;
    }

    private boolean X(i iVar) {
        if (bVo()) {
            String str = (String) iVar.pug.get("appId");
            x.i("MicroMsg.MsgHandler", "stop record appId : %s", str);
            k.a(iVar.tQf, false, null, str);
            final WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(this.tOu);
            if (OS == null || !str.equals(OS.appId)) {
                x.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", str);
                a(iVar, "stopRecord:fail", null);
            } else {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.sdk.b.b fdVar = new fd();
                        fdVar.fuV.op = 2;
                        fdVar.fuV.filePath = OS.iOz;
                        com.tencent.mm.sdk.b.a.xmy.m(fdVar);
                        g.this.tOu = null;
                    }
                });
                x.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", OS.fileName, OS.iOz, OS.fvn);
                Map hashMap = new HashMap();
                hashMap.put("localId", OS.fvn);
                try {
                    this.fCC.n(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, null);
                } catch (RemoteException e) {
                    x.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(iVar, "stopRecord:ok", hashMap);
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(iVar, "stopRecord:fail", null);
        }
        return true;
    }

    private boolean Y(final i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        final String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            k.a(iVar.tQf, false, null, str);
            x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVoice:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.model.c.b anonymousClass73 = new com.tencent.mm.plugin.webview.model.c.b() {
                    public final void a(boolean z, String str, String str2, String str3) {
                        x.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", Boolean.valueOf(z), str2, str);
                        if (!bi.oN(str) && str.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (g.this.inI != null) {
                                g.this.inI.dismiss();
                                g.this.inI = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("serverId", str2);
                                g.this.a(iVar, "uploadVoice:ok", hashMap);
                                return;
                            }
                            g.this.a(iVar, "uploadVoice:fail", null);
                        }
                    }
                };
                x.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.f.bSn().b(str, str2, anonymousClass73)));
                if (!com.tencent.mm.plugin.webview.modeltools.f.bSn().b(str, str2, anonymousClass73)) {
                    a(iVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYV), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a(anonymousClass73);
                            com.tencent.mm.plugin.webview.modeltools.f.bSn();
                            com.tencent.mm.plugin.webview.model.ac.qC(str2);
                            g.this.a(iVar, "uploadVoice:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVoice:fail_missing arguments", null);
        return true;
    }

    private boolean Z(final i iVar) {
        boolean z;
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass76;
        Context context;
        String str = (String) iVar.pug.get("appId");
        final String str2 = (String) iVar.pug.get("serverId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            k.a(iVar.tQf, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", str, str2, Boolean.valueOf(z));
            if (bi.oN(str2)) {
                anonymousClass76 = new com.tencent.mm.plugin.webview.model.c.b() {
                    public final void a(boolean z, String str, String str2, String str3) {
                        x.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", Boolean.valueOf(z), str, str2);
                        if (!bi.oN(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (g.this.inI != null) {
                                g.this.inI.dismiss();
                                g.this.inI = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                g.this.a(iVar, "downloadVoice:ok", hashMap);
                                return;
                            }
                            g.this.a(iVar, "downloadVoice:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, anonymousClass76);
                x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", Boolean.valueOf(true));
                if (z) {
                    context = this.context;
                    this.context.getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYz), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSn().a(anonymousClass76);
                            com.tencent.mm.plugin.webview.modeltools.f.bSn();
                            com.tencent.mm.plugin.webview.model.ac.OO(str2);
                            g.this.a(iVar, "downloadVoice:fail", null);
                        }
                    });
                }
            } else {
                a(iVar, "downloadVoice:fail_invaild_serverId", null);
            }
            return true;
        }
        z = true;
        k.a(iVar.tQf, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", str, str2, Boolean.valueOf(z));
        if (bi.oN(str2)) {
            anonymousClass76 = /* anonymous class already generated */;
            com.tencent.mm.plugin.webview.modeltools.f.bSn().a(str, str2, anonymousClass76);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", Boolean.valueOf(true));
            if (z) {
                context = this.context;
                this.context.getString(R.l.dGZ);
                this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eYz), true, /* anonymous class already generated */);
            }
        } else {
            a(iVar, "downloadVoice:fail_invaild_serverId", null);
        }
        return true;
    }

    private boolean aa(i iVar) {
        String str = (String) iVar.pug.get("menuList");
        if (bi.oN(str)) {
            a(iVar, "hideMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.fCC.p(3001, bundle);
                a(iVar, "hideMenuItems:ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "hideMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                a(iVar, "hideMenuItems:param is empty", null);
            }
        }
        return true;
    }

    private boolean ab(i iVar) {
        String str = (String) iVar.pug.get("menuList");
        if (bi.oN(str)) {
            a(iVar, "showMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.fCC.p(3002, bundle);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "showMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                x.w("MicroMsg.MsgHandler", "RemoteException : %s", e2.getMessage());
                a(iVar, "showMenuItems:param is empty", null);
            }
            a(iVar, "showMenuItems:ok", null);
        }
        return true;
    }

    private boolean bVp() {
        try {
            this.fCC.p(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", e.getMessage());
        }
        this.mgx = false;
        return false;
    }

    private boolean bVq() {
        try {
            this.fCC.p(TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
        }
        this.mgx = false;
        return false;
    }

    private boolean ac(i iVar) {
        try {
            this.fCC.p(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
            a(iVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "hideAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean ad(i iVar) {
        try {
            this.fCC.p(TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
            a(iVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "showAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean ae(i iVar) {
        String str = (String) iVar.pug.get("jsApiList");
        if (bi.oN(str)) {
            a(iVar, "checkJsApi:param is empty", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(iVar, "checkJsApi:param is empty", null);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.TR(string) == null) {
                            if (kz.vHd == null) {
                                Set hashSet = new HashSet();
                                kz.vHd = hashSet;
                                hashSet.add("menu:share:QZone");
                                kz.vHd.add("onImageDownloadProgress");
                                kz.vHd.add("onVoiceUploadProgress");
                                kz.vHd.add("onVoiceDownloadProgress");
                                kz.vHd.add("onVoiceRecordEnd");
                                kz.vHd.add("onVoicePlayBegin");
                                kz.vHd.add("onVoicePlayEnd");
                                kz.vHd.add("onLocalImageUploadProgress");
                                kz.vHd.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
                                kz.vHd.add(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME);
                                kz.vHd.add("hdOnDeviceStateChanged");
                                kz.vHd.add("activity:state_change");
                                kz.vHd.add("onWXDeviceBluetoothStateChange");
                                kz.vHd.add("onWXDeviceLanStateChange");
                                kz.vHd.add("onWXDeviceBindStateChange");
                                kz.vHd.add("onReceiveDataFromWXDevice");
                                kz.vHd.add("onScanWXDeviceResult");
                                kz.vHd.add("onWXDeviceStateChange");
                                kz.vHd.add("onGetKeyboardHeight");
                                kz.vHd.add("onGetSmiley");
                                kz.vHd.add("onAddShortcutStatus");
                                kz.vHd.add("onMediaFileUploadProgess");
                                kz.vHd.add("onGetA8KeyUrl");
                                kz.vHd.add("onPageStateChange");
                                kz.vHd.add("onGetMsgProofItems");
                                kz.vHd.add("onNavigationBarRightButtonClick");
                                kz.vHd.add("onBackgroundAudioStateChange");
                                kz.vHd.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                                kz.vHd.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                                kz.vHd.add("onArticleReadingBtnClicked");
                                kz.vHd.add("onRecordHistory");
                                kz.vHd.add("onBeaconsInRange");
                            }
                            if (!kz.vHd.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(iVar, "checkJsApi:ok", hashMap);
                }
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "checkJsApi:param is empty", null);
            }
        }
        return true;
    }

    private boolean af(i iVar) {
        try {
            int intValue;
            String str = (String) iVar.pug.get("userName");
            try {
                intValue = ((Integer) iVar.pug.get(Columns.TYPE)).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(iVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.bl.d.a(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent, false);
        } catch (Exception e2) {
            x.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", e2.getMessage());
        }
        return false;
    }

    private boolean ag(i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("appId");
        final String str2 = (String) iVar.pug.get("localId");
        Object obj = iVar.pug.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", Boolean.valueOf(z));
            k.a(iVar.tQf, false, null, str);
            if (!bi.oN(str) || bi.oN(str2)) {
                x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", str2, str);
                a(iVar, "translateVoice:fail_missing arguments", null);
            } else {
                final WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str2);
                if (OS != null) {
                    final i iVar2 = iVar;
                    ah.y(new Runnable() {
                        public final void run() {
                            if (z) {
                                g gVar = g.this;
                                Context i = g.this.context;
                                g.this.context.getString(R.l.dGZ);
                                gVar.inI = com.tencent.mm.ui.base.h.a(i, g.this.context.getString(R.l.eYU), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.sdk.b.b fgVar = new fg();
                                        fgVar.fvl.fvo = 3;
                                        com.tencent.mm.sdk.b.a.xmy.m(fgVar);
                                        g.this.a(iVar2, "translateVoice:fail", null);
                                    }
                                });
                            }
                            final com.tencent.mm.sdk.b.b fgVar = new fg();
                            fgVar.fvl.fvn = str2;
                            fgVar.fvl.fileName = OS.fileName;
                            fgVar.fvl.fvo = 0;
                            fgVar.fvl.scene = 8;
                            fgVar.fvl.fvp = new Runnable() {
                                public final void run() {
                                    if (fgVar.fvm.aow) {
                                        if (g.this.inI != null) {
                                            g.this.inI.dismiss();
                                            g.this.inI = null;
                                        }
                                        if (bi.oN(fgVar.fvm.content)) {
                                            g.this.a(iVar2, "translateVoice:fail", null);
                                            return;
                                        }
                                        Map hashMap = new HashMap();
                                        hashMap.put("translateResult", fgVar.fvm.content);
                                        g.this.a(iVar2, "translateVoice:ok", hashMap);
                                    }
                                }
                            };
                            com.tencent.mm.sdk.b.a.xmy.m(fgVar);
                        }
                    });
                } else {
                    a(iVar, "translateVoice:fail_arguments error", null);
                }
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", Boolean.valueOf(z));
        k.a(iVar.tQf, false, null, str);
        if (bi.oN(str)) {
        }
        x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", str2, str);
        a(iVar, "translateVoice:fail_missing arguments", null);
        return true;
    }

    private boolean ah(i iVar) {
        BaseMessage wWMediaLink = new WWMediaLink();
        wWMediaLink.thumbUrl = (String) iVar.pug.get("img_url");
        try {
            wWMediaLink.webpageUrl = ak.Cu(this.fCC.aeH());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) iVar.pug.get("link");
        }
        wWMediaLink.title = (String) iVar.pug.get("title");
        wWMediaLink.description = (String) iVar.pug.get("desc");
        WWAPIFactory.iP(this.context).a(wWMediaLink);
        a(iVar, "shareWeWork:ok", null);
        return true;
    }

    private boolean ai(i iVar) {
        if (com.tencent.mm.plugin.webview.stub.a.dP(this.context)) {
            String str = (String) iVar.pug.get("img_url");
            String str2 = (String) iVar.pug.get("title");
            String str3 = (String) iVar.pug.get("desc");
            String string = this.context.getResources().getString(R.l.app_name);
            String str4 = (String) iVar.pug.get("link");
            try {
                if (bi.oN(str4)) {
                    str4 = this.fCC.aeH();
                }
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", e.getMessage());
            }
            str4 = ak.Cu(str4);
            if (bi.oN(str4) || bi.oN(str2) || bi.oN(str3)) {
                x.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", str4, str2, str3);
                a(iVar, "shareQQ:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("image_url", com.tencent.mm.pluginsdk.ui.tools.s.Tx(str));
                hashMap.put("title", com.tencent.mm.pluginsdk.ui.tools.s.Tx(str2));
                hashMap.put("description", com.tencent.mm.pluginsdk.ui.tools.s.Tx(str3));
                hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.Tx(str4));
                hashMap.put("app_name", com.tencent.mm.pluginsdk.ui.tools.s.Tx(string));
                hashMap.put("req_type", com.tencent.mm.pluginsdk.ui.tools.s.Tx("1"));
                if (iVar.tQg.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", com.tencent.mm.pluginsdk.ui.tools.s.Tx("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ar(hashMap));
                x.d("MicroMsg.MsgHandler", "Uri : %s", stringBuilder.toString());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bi.k(this.context, intent) && (this.context instanceof Activity)) {
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(iVar, iVar.tQg + ":ok", null);
                } else {
                    a(iVar, iVar.tQg + ":fail", null);
                }
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(iVar, "shareQQ:fail", null);
        }
        return true;
    }

    private boolean aj(i iVar) {
        String str = (String) iVar.pug.get("desc");
        String str2 = (String) iVar.pug.get("img_url");
        String str3 = (String) iVar.pug.get("link");
        try {
            if (bi.oN(str3)) {
                str3 = this.fCC.aeH();
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", e.getMessage());
        }
        str3 = ak.Cu(str3);
        if (bi.oN(str3)) {
            x.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(iVar, "shareWeiboApp:fail", null);
        } else {
            if (bi.oN(str)) {
                str = ((String) iVar.pug.get("title")) + " " + str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(Columns.TYPE, Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put("content", com.tencent.mm.pluginsdk.ui.tools.s.Tw(str));
            hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.Tw(str2));
            hashMap.put("thumbnailurl", com.tencent.mm.pluginsdk.ui.tools.s.Tw(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ar(hashMap));
            x.i("MicroMsg.MsgHandler", "Uri : %s", stringBuilder.toString());
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bi.k(this.context, intent)) {
                this.context.startActivity(intent);
                a(iVar, "shareWeiboApp:ok", null);
            } else {
                a(iVar, "shareWeiboApp:fail", null);
            }
        }
        return true;
    }

    private boolean ak(i iVar) {
        String str = (String) iVar.pug.get("sessionFrom");
        if (bi.oN((String) iVar.pug.get("sessionId"))) {
            a(iVar, "startTempSession:fail_missing arguments", null);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = iVar.pug.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = bi.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = bi.getInt(bi.oM((String) iVar.pug.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.tNZ.Qf(this.fCC.aeH()), bi.oM(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            }
            intValue = 0;
            i = bi.getInt(bi.oM((String) iVar.pug.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.tNZ.Qf(this.fCC.aeH()), bi.oM(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", 4);
                } else {
                    intent.putExtra("translate_link_scene", i);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(iVar, "startTempSession:fail_exception", null);
            }
        }
        return true;
    }

    private boolean al(i iVar) {
        try {
            String str = (String) iVar.pug.get("userName");
            String str2 = (String) iVar.pug.get("nickName");
            if (bi.oN(str)) {
                a(iVar, "setPageOwner:missing_arguments", null);
            } else {
                this.fCC.eT(str, str2);
                a(iVar, "setPageOwner:ok", null);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", e.getMessage());
        }
        return false;
    }

    private boolean am(final i iVar) {
        try {
            String str = (String) iVar.pug.get("appId");
            String str2 = (String) iVar.pug.get("signature");
            k.a(iVar.tQf, false, null, str);
            if (bi.oN(str)) {
                a(iVar, "get_wechat_verify_ticket:fail ticket", null);
            } else {
                as.CN().a(1097, new com.tencent.mm.ad.e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.webview.model.g gVar = (com.tencent.mm.plugin.webview.model.g) kVar;
                            Map hashMap = new HashMap();
                            hashMap.put("ticket", ((yn) gVar.lSH.hnR.hnY).fsK);
                            g.this.a(iVar, "get_wechat_verify_ticket:ok ticket", hashMap);
                        } else {
                            x.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
                            g.this.a(iVar, "get_wechat_verify_ticket:fail ticket", null);
                        }
                        as.CN().b(1097, (com.tencent.mm.ad.e) this);
                    }
                });
                as.CN().a(new com.tencent.mm.plugin.webview.model.g(str, str2), 0);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", e.getMessage());
        }
        return false;
    }

    public final boolean an(i iVar) {
        x.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            x.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        return true;
    }

    private Bundle e(String str, int i, Bundle bundle) {
        try {
            return this.fCC.e(i, bundle);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f(java.lang.String r6, int r7, android.os.Bundle r8) {
        /*
        r5 = this;
        r0 = -1;
        r4 = 0;
        r1 = r5.e(r6, r7, r8);
        if (r1 == 0) goto L_0x004e;
    L_0x0008:
        r2 = "status";
        r0 = r1.getInt(r2, r0);
    L_0x000f:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " result status : ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x0086;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00b9;
            case 4: goto L_0x00bb;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r5.tNN;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":fail";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x004c:
        r0 = 0;
    L_0x004d:
        return r0;
    L_0x004e:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " callback fail!";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);
        goto L_0x000f;
    L_0x006c:
        r0 = r5.tNN;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x0086:
        r0 = r5.tNN;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_off";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x00a0:
        r0 = r5.tNN;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":disconnect";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x00b9:
        r0 = 1;
        goto L_0x004d;
    L_0x00bb:
        r0 = r5.tNN;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":card_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.f(java.lang.String, int, android.os.Bundle):boolean");
    }

    private boolean ao(i iVar) {
        try {
            Bundle e = this.fCC.e(5001, null);
            if (e != null) {
                int i = e.getInt("webview_video_proxy_init");
                x.i("MicroMsg.MsgHandler", "int webview video proxy : %d", Integer.valueOf(i));
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i));
                if (i == 0) {
                    com.tencent.mm.plugin.webview.model.ah bRE = com.tencent.mm.plugin.webview.model.ah.bRE();
                    bRE.fCC = this.fCC;
                    bRE.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, false);
                    a(iVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.a.AQ(i));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    com.tencent.mm.plugin.report.service.g.pWK.a(arrayList2, false);
                    a(iVar, "videoProxyInit:fail", hashMap);
                }
                return false;
            }
        } catch (Exception e2) {
            x.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", e2.getMessage());
        }
        a(iVar, "videoProxyInit:fail", null);
        return false;
    }

    private boolean ap(i iVar) {
        if (com.tencent.mm.plugin.webview.model.ah.bRE().hasInit) {
            String str = (String) iVar.pug.get("webviewVideoProxyCdnUrls");
            x.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", str, (String) iVar.pug.get("webviewVideoProxyFileId"), Integer.valueOf(bi.getInt((String) iVar.pug.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(bi.getInt((String) iVar.pug.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(bi.getInt((String) iVar.pug.get("webviewVideoProxyFileType"), 1)));
            if (bi.oN(str)) {
                a(iVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle e = this.fCC.e(5002, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (e != null) {
                        int i = e.getInt("webview_video_proxy_play_data_id");
                        str = e.getString("webview_video_proxy_local_url");
                        x.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", Integer.valueOf(i), str);
                        if (i > 0 && !bi.oN(str)) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(iVar, "videoProxyStartPlay:ok", hashMap);
                            com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, false);
                        }
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "proxy start play failed : %s", e2.getMessage());
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(142);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, false);
                a(iVar, "videoProxyStartPlay:fail", null);
            }
        } else {
            a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        }
        return false;
    }

    private boolean aq(i iVar) {
        if (com.tencent.mm.plugin.webview.model.ah.bRE().hasInit) {
            int i = bi.getInt((String) iVar.pug.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.fCC.e(5003, bundle);
                    a(iVar, "videoProxyStopPlay:ok", null);
                    return false;
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", e.getMessage());
                }
            }
            a(iVar, "videoProxyStopPlay:fail", null);
            return false;
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean ar(i iVar) {
        if (com.tencent.mm.plugin.webview.model.ah.bRE().hasInit) {
            String str = (String) iVar.pug.get("webviewVideoProxyPlayState");
            x.i("MicroMsg.MsgHandler", "set player state : %s", str);
            if (bi.oN(str)) {
                a(iVar, "videoProxySetPlayerState:fail", null);
                return true;
            }
            int i = bi.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.fCC.e(5004, bundle);
                a(iVar, "videoProxySetPlayerState:ok", null);
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set player state failed : %s", e.getMessage());
                a(iVar, "videoProxySetPlayerState:fail", null);
                return false;
            }
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean as(i iVar) {
        if (com.tencent.mm.plugin.webview.model.ah.bRE().hasInit) {
            int i = bi.getInt((String) iVar.pug.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = bi.getInt((String) iVar.pug.get("webviewVideoProxyRemainTime"), 0);
            x.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", r0, r1);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.fCC.e(5006, bundle);
                a(iVar, "videoProxySetRemainTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set remain time faild : %s", e.getMessage());
                a(iVar, "videoProxySetRemainTime:fail", null);
            }
        } else {
            a(iVar, "videoProxySetRemainTime:fail_has_not_init", null);
        }
        return false;
    }

    private boolean at(i iVar) {
        if (com.tencent.mm.plugin.webview.model.ah.bRE().hasInit) {
            String str = (String) iVar.pug.get("webviewVideoProxyPlaydataId");
            x.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", str, Integer.valueOf(bi.getInt((String) iVar.pug.get("webviewVideoProxyPreloadTime"), 0)));
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(iVar, "videoProxyPreload:fail_invaild_play_data_id", null);
            } else {
                try {
                    int i = bi.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    x.i("MicroMsg.MsgHandler", "preload video result = %d", Integer.valueOf(this.fCC.e(5007, bundle).getInt("webview_video_proxy_pre_load_result")));
                    if (this.fCC.e(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(iVar, "videoProxyPreload:ok", null);
                    } else {
                        a(iVar, "videoProxyPreload:fail", null);
                    }
                } catch (Exception e) {
                    a(iVar, "videoProxyPreload:fail", null);
                }
            }
        } else {
            a(iVar, "videoProxyPreload:fail_has_not_init", null);
        }
        return false;
    }

    public final void z(int i, String str, String str2) {
        c Bs = Bs(i);
        if (Bs == null) {
            x.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            return;
        }
        i iVar = Bs.tNN;
        Bt(i);
        if (!bi.oM(str2).equalsIgnoreCase("ok")) {
            int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.m.AH(a);
            }
        }
        if (this.fCC != null) {
            a(this.fCC, iVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
    }

    private boolean au(i iVar) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        String str = (String) iVar.pug.get("actionKey");
        String str2 = (String) iVar.pug.get("actionValue");
        x.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", str, str2);
        if (bi.oN(str) || bi.oN(str2)) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle e = this.fCC.e(77, null);
                if (e != null) {
                    str3 = bi.oM(e.getString("KSessionId"));
                    str4 = bi.oM(e.getString("KUserAgent"));
                    str5 = bi.oM(e.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        x.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(iVar, "reportActionInfo:fail", null);
                        return true;
                    }
                    x.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", str3, str4, str5);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "get sessionId error, %s", e2);
            }
            if (TextUtils.isEmpty(qZ(str5))) {
                x.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(iVar, "reportActionInfo:fail", null);
                return true;
            }
            x.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", qZ(str5));
            int i = 0;
            if (ao.isConnected(this.context)) {
                if (ao.isWifi(this.context)) {
                    i = 1;
                } else if (ao.is4G(this.context)) {
                    i = 4;
                } else if (ao.is3G(this.context)) {
                    i = 3;
                } else if (ao.is2G(this.context)) {
                    i = 2;
                }
                x.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", Integer.valueOf(i));
            }
            long Wx = bi.Wx();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Integer.valueOf(13379), Long.valueOf(Wx), r10, Integer.valueOf(i), str4, str5, str3, str, str2);
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(bi.oM(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (Throwable e3) {
                    str2 = str4;
                    str5 = str6;
                    th = e3;
                    str = str8;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj = str5;
                    obj2 = str4;
                    obj3 = str6;
                } catch (Throwable e32) {
                    str2 = str4;
                    th = e32;
                    str = str5;
                    str5 = str6;
                    x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.pWK.h(13379, Long.valueOf(Wx), r10, Integer.valueOf(i), obj3, obj2, str3, obj, str);
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
            } catch (Throwable e322) {
                th = e322;
                str2 = str7;
                str5 = str6;
                str = str8;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13379, Long.valueOf(Wx), r10, Integer.valueOf(i), obj3, obj2, str3, obj, str);
            a(iVar, "reportActionInfo:ok", null);
            return true;
        }
    }

    private boolean av(i iVar) {
        int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
        if (-1 == a) {
            a(this.fCC, iVar, "cache:fail", null, true, false);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            com.tencent.mm.plugin.report.service.g.pWK.a(238, (long) i, 1, false);
        }
        x.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.m.AH(a);
        a(this.fCC, iVar, "cache:not in white list", null, true, false);
        return true;
    }

    private boolean aw(i iVar) {
        x.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (iVar.pug.containsKey("hideMenu")) {
            i = bi.getInt((String) iVar.pug.get("hideMenu"), 0);
            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=" + i);
            if (kJ(i == 1)) {
                a(iVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(iVar, "doAddCustomMenuItems:fail", null);
            }
        } else {
            kJ(false);
            String str = (String) iVar.pug.get("itemList");
            if (bi.oN(str)) {
                x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(iVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (bi.oN(optString) || bi.oN("title")) {
                                x.e("MicroMsg.MsgHandler", "key or title is null,ignore item: " + i);
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.fCC.P(bundle);
                            a(iVar, "doAddCustomMenuItems:ok", null);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(iVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(iVar, "doAddCustomMenuItems:params parse error", null);
                }
            }
        }
        return true;
    }

    private boolean ax(i iVar) {
        String str = (String) iVar.pug.get("key");
        if (bi.oN(str)) {
            a(iVar, "getLocalData:fail_key_is_null", null);
        } else {
            try {
                String aeH = this.fCC.aeH();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.tNZ.Qf(aeH);
                af bSr = com.tencent.mm.plugin.webview.modeltools.f.bSr();
                String WF = bi.WF(aeH);
                x.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", str2, str, WF);
                if (bi.oN(str2) || bi.oN(str) || bi.oN(aeH) || bi.oN(WF)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = " + af.ac(str, WF, str2);
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bSr.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        x.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        x.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", str, str2);
                    }
                }
                if (bi.oN(str)) {
                    a(iVar, "getLocalData:fail", null);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str3);
                    x.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", str2, str3);
                    a(iVar, "getLocalData:ok", hashMap);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
                a(iVar, "getLocalData:fail", null);
            }
        }
        return true;
    }

    private boolean ay(i iVar) {
        String str = (String) iVar.pug.get("key");
        String str2 = (String) iVar.pug.get(SlookAirButtonFrequentContactAdapter.DATA);
        x.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", str, str2);
        if (bi.oN(str) || bi.oN(str2)) {
            a(iVar, "setLocalData:fail_param_should_not_null", null);
            return true;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            a(iVar, "setLocalData:fail_param_lenght_too_long", null);
            return true;
        } else {
            try {
                String aeH = this.fCC.aeH();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.tNZ.Qf(aeH);
                af bSr = com.tencent.mm.plugin.webview.modeltools.f.bSr();
                String WF = bi.WF(aeH);
                x.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", str3, str4, aeH, str2, WF);
                if (bi.oN(str3) || bi.oN(aeH) || bi.oN(str2) || bi.oN(WF)) {
                    str = "fail_params_invalid";
                } else {
                    int ac = af.ac(str2, WF, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + WF + "'";
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bSr.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            x.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", Integer.valueOf(rawQuery.getInt(0)));
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                str = "fail_exceed_max_count";
                            } else {
                                rawQuery = bSr.rawQuery("select count(*) from WebviewLocalData where recordId =" + ac, new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", r7, Integer.valueOf(rawQuery.getInt(0)));
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ac, Boolean.valueOf(bSr.fD("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ac)));
                                            str = bSr.fD("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ac) ? "ok" : "fail";
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    com.tencent.mm.sdk.e.c aeVar = new ae();
                    aeVar.field_appId = str2;
                    aeVar.field_domin = WF;
                    aeVar.field_key = str3;
                    aeVar.field_value = str4;
                    aeVar.field_recordId = ac;
                    x.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", Boolean.valueOf(bSr.b(aeVar)));
                    str = "ok";
                }
                x.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", str);
                a(iVar, "setLocalData:" + str, null);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
                a(iVar, "setLocalData:fail", null);
                return true;
            }
        }
    }

    private boolean az(i iVar) {
        try {
            String aeH = this.fCC.aeH();
            af bSr = com.tencent.mm.plugin.webview.modeltools.f.bSr();
            String Qf = this.tNZ.Qf(aeH);
            String WF = bi.WF(aeH);
            x.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", Qf, aeH, WF);
            if (bi.oN(Qf) || bi.oN(aeH) || bi.oN(WF)) {
                aeH = "fail";
            } else {
                aeH = bSr.fD("WebviewLocalData", new StringBuilder("delete from WebviewLocalData where appId = '").append(Qf).append("' and domin = '").append(WF).append("'").toString()) ? "ok" : "fail";
            }
            x.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", aeH);
            a(iVar, "clearLocalData:" + aeH, null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
            a(iVar, "clearLocalData:fail", null);
        }
        return true;
    }

    private boolean aA(final i iVar) {
        String aeH;
        String str = (String) iVar.pug.get("useridlist");
        String str2 = (String) iVar.pug.get("chatname");
        final String str3 = (String) iVar.pug.get("chatscene");
        try {
            aeH = this.fCC.aeH();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        aeH = bi.oM(this.tNZ.Qf(aeH));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(iVar, "openEnterpriseChat:fail", null);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        y.Mr();
        com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.af.a.t(aeH, str2, linkedList, new com.tencent.mm.af.n() {
            public final void a(int i, k kVar) {
                if (i != 0) {
                    g.this.a(iVar, "openEnterpriseChat:fail", null);
                    return;
                }
                alu MH = ((com.tencent.mm.af.a.t) kVar).MH();
                String str;
                if (MH != null && MH.vUn != null && MH.vUn.ret == 0) {
                    str = MH.vUh;
                    String str2 = ((com.tencent.mm.af.a.t) kVar).htd;
                    if (str2 == null) {
                        g.this.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.af.a.c ko = y.Mn().ko(str2);
                    if (ko == null || bi.oN(str)) {
                        g.this.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    Intent intent;
                    if (bi.oN(str3) || !str3.equals("long")) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("key_biz_chat_id", ko.field_bizChatLocalId);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bl.d.a(g.this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                        intent.putExtra("Main_User", str);
                        intent.putExtra("biz_chat_chat_id", ko.field_bizChatLocalId);
                        intent.putExtra("biz_chat_from_scene", 8);
                        com.tencent.mm.bl.d.a(g.this.context, ".ui.LauncherUI", intent);
                    }
                    Map hashMap = new HashMap();
                    if (!(bi.oN(MH.wfn) || bi.oN(MH.wfo))) {
                        hashMap.put("chat_type", MH.wfn);
                        hashMap.put("chat_id", MH.wfo);
                    }
                    g.this.a(iVar, "openEnterpriseChat:ok", hashMap);
                } else if (MH == null || MH.vUn == null) {
                    g.this.a(iVar, "openEnterpriseChat:fail", null);
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("err_code", Integer.valueOf(MH.vUn.ret));
                    str = "openEnterpriseChat:fail";
                    if (MH.vUn.fuo != null) {
                        str = MH.vUn.fuo;
                    }
                    g.this.a(iVar, str, hashMap2);
                }
            }
        }), 0);
        return true;
    }

    private boolean aB(final i iVar) {
        String aeH;
        String str = (String) iVar.pug.get("chatId");
        String str2 = (String) iVar.pug.get("chatType");
        try {
            aeH = this.fCC.aeH();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        aeH = bi.oM(this.tNZ.Qf(aeH));
        if (bi.oN(str) || bi.oN(str2) || bi.oN(aeH)) {
            a(iVar, "enterEnterpriseChat:fail_params error", null);
        } else {
            y.Mr();
            com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.af.a.m(aeH, str, str2, new com.tencent.mm.af.n() {
                public final void a(int i, k kVar) {
                    if (i != 0) {
                        g.this.a(iVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    pn ME = ((com.tencent.mm.af.a.m) kVar).ME();
                    String str = "enterEnterpriseChat:fail";
                    if (i < 0) {
                        if (!(ME == null || ME.vUn == null || !bi.oN(ME.vUn.fuo))) {
                            str = "enterEnterpriseChat:fail_" + ME.vUn.fuo;
                        }
                        g.this.a(iVar, str, null);
                        return;
                    }
                    String str2 = ME.vUh;
                    String str3 = ((com.tencent.mm.af.a.m) kVar).htd;
                    if (str3 == null) {
                        g.this.a(iVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.af.a.c ko = y.Mn().ko(str3);
                    if (ko == null || bi.oN(str2)) {
                        g.this.a(iVar, str, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    intent.putExtra("key_biz_chat_id", ko.field_bizChatLocalId);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    intent.putExtra("key_is_biz_chat", true);
                    com.tencent.mm.bl.d.a(g.this.context, ".ui.chatting.ChattingUI", intent);
                    g.this.a(iVar, "enterEnterpriseChat:ok", null);
                }
            }), 0);
        }
        return true;
    }

    private boolean aC(final i iVar) {
        try {
            String oM = bi.oM(this.tNZ.Qf(this.fCC.aeH()));
            if (bi.oN(oM)) {
                a(iVar, "getEnterpriseChat:fail", null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.fCC.e(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String bb = com.tencent.mm.af.a.e.bb(bundle.getLong("enterprise_context_bizchatid", -1));
                if (bi.oN(string) || bi.oN(bb)) {
                    a(iVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                } else {
                    com.tencent.mm.ad.e anonymousClass86 = new com.tencent.mm.ad.e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            String str2;
                            zz zzVar;
                            int i3;
                            com.tencent.mm.af.s.a(this);
                            String str3 = "getEnterpriseChat:fail";
                            if (i == 0 && i2 == 0) {
                                zz zzVar2;
                                com.tencent.mm.af.s sVar = (com.tencent.mm.af.s) kVar;
                                if (sVar.gLB == null || sVar.gLB.hnR.hnY == null) {
                                    zzVar2 = null;
                                } else {
                                    zzVar2 = (zz) sVar.gLB.hnR.hnY;
                                }
                                if (zzVar2 == null || zzVar2.vUn == null) {
                                    str2 = str3;
                                    zzVar = zzVar2;
                                    i3 = -1;
                                } else {
                                    int i4 = zzVar2.vUn.ret;
                                    if (zzVar2.vUn.fuo == null || zzVar2.vUn.fuo.length() <= 0) {
                                        str2 = str3;
                                        zzVar = zzVar2;
                                        i3 = i4;
                                    } else {
                                        str2 = "getEnterpriseChat:fail_" + zzVar2.vUn.fuo;
                                        zzVar = zzVar2;
                                        i3 = i4;
                                    }
                                }
                            } else {
                                str2 = str3;
                                i3 = -1;
                                zzVar = null;
                            }
                            if (i3 != 0) {
                                g.this.a(iVar, str2, null);
                                return;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("result", zzVar.result);
                            g.this.a(iVar, "getEnterpriseChat:ok", hashMap);
                        }
                    };
                    com.tencent.mm.kernel.g.Dp().gRu.a(1285, anonymousClass86);
                    if (!com.tencent.mm.af.s.k(oM, string, bb)) {
                        com.tencent.mm.af.s.a(anonymousClass86);
                        a(iVar, "getEnterpriseChat:fail", null);
                    }
                }
            }
        } catch (Exception e) {
            a(iVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    private boolean aD(final i iVar) {
        String aeH;
        try {
            aeH = this.fCC.aeH();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        String oM = bi.oM(this.tNZ.Qf(aeH));
        if (bi.oN(oM)) {
            a(iVar, "openEnterpriseContact:fail", null);
        }
        final k iVar2 = new com.tencent.mm.plugin.webview.model.i(oM, aeH, iVar.pug);
        as.CN().a(1393, new com.tencent.mm.ad.e() {
            public final void a(int i, int i2, String str, k kVar) {
                zx bRo;
                int i3 = -1;
                if (g.this.inI != null && g.this.inI.isShowing()) {
                    g.this.inI.dismiss();
                    g.this.inI = null;
                }
                as.CN().b(1393, (com.tencent.mm.ad.e) this);
                String str2 = "openEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    bRo = ((com.tencent.mm.plugin.webview.model.i) kVar).bRo();
                    if (!(bRo == null || bRo.vUn == null)) {
                        i3 = bRo.vUn.ret;
                        if (bRo.vUn.fuo != null && bRo.vUn.fuo.length() > 0) {
                            str2 = bRo.vUn.fuo;
                        }
                    }
                } else {
                    bRo = null;
                }
                if (i3 != 0) {
                    g.this.a(iVar, str2, null);
                    return;
                }
                str2 = bRo.wbT;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) g.this.context).jCj = this;
                com.tencent.mm.bl.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent, 31);
            }
        });
        as.CN().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(iVar2);
            }
        });
        return true;
    }

    private boolean aE(final i iVar) {
        String aeH;
        try {
            aeH = this.fCC.aeH();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        String oM = bi.oM(this.tNZ.Qf(aeH));
        if (bi.oN(oM)) {
            a(iVar, "selectEnterpriseContact:fail", null);
        }
        iVar.pug.put("groupId", "");
        iVar.pug.put("timestamp", "");
        iVar.pug.put("nonceStr", "");
        iVar.pug.put("signature", "");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray((String) iVar.pug.get(Columns.TYPE));
            jSONObject.put("fromDepartmentId", Integer.parseInt((String) iVar.pug.get("fromDepartmentId")));
            jSONObject.put("mode", (String) iVar.pug.get("mode"));
            jSONObject.put(Columns.TYPE, jSONArray);
            String str = (String) iVar.pug.get("selectedDepartmentIds");
            if (str != null) {
                jSONObject.put("selectedDepartmentIds", new JSONArray(str));
            }
            str = (String) iVar.pug.get("selectedUserIds");
            if (str != null) {
                jSONObject.put("selectedUserIds", new JSONArray(str));
            }
            iVar.pug.put("params", jSONObject);
        } catch (JSONException e2) {
        } catch (NumberFormatException e3) {
        }
        final k iVar2 = new com.tencent.mm.plugin.webview.model.i(oM, aeH, iVar.pug);
        final com.tencent.mm.ad.e anonymousClass89 = new com.tencent.mm.ad.e() {
            public final void a(int i, int i2, String str, k kVar) {
                zx bRo;
                int i3 = -1;
                if (g.this.inI != null && g.this.inI.isShowing()) {
                    g.this.inI.dismiss();
                    g.this.inI = null;
                }
                as.CN().b(1393, (com.tencent.mm.ad.e) this);
                String str2 = "selectEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    bRo = ((com.tencent.mm.plugin.webview.model.i) kVar).bRo();
                    if (!(bRo == null || bRo.vUn == null)) {
                        i3 = bRo.vUn.ret;
                        if (bRo.vUn.fuo != null && bRo.vUn.fuo.length() > 0) {
                            str2 = bRo.vUn.fuo;
                        }
                    }
                } else {
                    bRo = null;
                }
                if (i3 != 0) {
                    g.this.a(iVar, str2, null);
                    return;
                }
                str2 = bRo.wbT;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) g.this.context).jCj = this;
                com.tencent.mm.bl.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent, 53);
            }
        };
        as.CN().a(1393, anonymousClass89);
        as.CN().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(iVar2);
                as.CN().b(1393, anonymousClass89);
            }
        });
        return true;
    }

    private boolean aF(i iVar) {
        if (this.fCC == null) {
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.fCC.e(71, bundle);
            final String string = bundle.getString("enterprise_context_biz");
            final long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (bi.oN(string) || j < 0) {
                a(iVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                return true;
            }
            String str = (String) iVar.pug.get(Columns.TYPE);
            if ("text".equals(str)) {
                return a(iVar, string, j);
            }
            if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) iVar.pug.get(SlookAirButtonFrequentContactAdapter.DATA));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                final String optString3 = jSONObject.optString("imgUrl");
                if (bi.oN(optString) && bi.oN(optString2)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else if (bi.oN(str)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else {
                    String str2;
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.fzX = new WXMediaMessage();
                    this.fzX.mediaObject = wXWebpageObject;
                    this.fzX.title = optString;
                    this.fzX.description = optString2;
                    str = (String) iVar.pug.get("appid");
                    if (this.tNQ == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.tNQ.getString("jsapi_args_appid");
                    }
                    final f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    } else if (this.context instanceof Activity) {
                        final i iVar2 = iVar;
                        com.tencent.mm.pluginsdk.ui.applet.e.a(((MMActivity) this.context).mController, optString, optString3, optString2, null, true, this.context.getResources().getString(R.l.dGL), (com.tencent.mm.pluginsdk.ui.applet.o.a) new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                            public final void a(boolean z, final String str, int i) {
                                if (!z) {
                                    g.this.a(iVar2, "sendEnterpriseChat:cancel", null);
                                } else if (bi.oN(optString3)) {
                                    com.tencent.mm.af.a.c ag = y.Mn().ag(j);
                                    synchronized (com.tencent.mm.af.a.e.hsB) {
                                        String HJ = com.tencent.mm.af.a.e.HJ();
                                        com.tencent.mm.af.a.e.d(ag);
                                        g.this.a(aZ, str2, string, optString3, null, null, str, null);
                                        com.tencent.mm.af.a.e.kv(HJ);
                                    }
                                    g.this.a(iVar2, "sendEnterpriseChat:ok", null);
                                    if (g.this.context != null) {
                                        com.tencent.mm.ui.base.h.bu(g.this.context, g.this.context.getResources().getString(R.l.dGR));
                                    }
                                } else {
                                    o.PB().a(optString3, new com.tencent.mm.ap.c.c() {
                                        public final void n(Bitmap bitmap) {
                                            if (g.this.nOr != null) {
                                                g.this.nOr.dismiss();
                                            }
                                            com.tencent.mm.af.a.c ag = y.Mn().ag(j);
                                            synchronized (com.tencent.mm.af.a.e.hsB) {
                                                String HJ = com.tencent.mm.af.a.e.HJ();
                                                com.tencent.mm.af.a.e.d(ag);
                                                g.this.a(aZ, str2, string, optString3, null, null, str, null);
                                                com.tencent.mm.af.a.e.kv(HJ);
                                            }
                                            g.this.a(iVar2, "sendEnterpriseChat:ok", null);
                                            if (g.this.context != null) {
                                                com.tencent.mm.ui.base.h.bu(g.this.context, g.this.context.getResources().getString(R.l.dGR));
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    } else {
                        x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    }
                }
            }
            a(iVar, "sendEnterpriseChat:fail_params error", null);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", e.getMessage());
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
    }

    private boolean a(i iVar, String str, long j) {
        String optString = new JSONObject((String) iVar.pug.get(SlookAirButtonFrequentContactAdapter.DATA)).optString("content");
        if (bi.oN(optString)) {
            a(iVar, "sendEnterpriseChat:fail_params error", null);
        } else {
            boolean m;
            com.tencent.mm.af.a.c ag = y.Mn().ag(j);
            synchronized (com.tencent.mm.af.a.e.hsB) {
                String HJ = com.tencent.mm.af.a.e.HJ();
                com.tencent.mm.af.a.e.d(ag);
                com.tencent.mm.sdk.b.b otVar = new ot();
                otVar.fHD.fHE = str;
                otVar.fHD.content = optString;
                otVar.fHD.type = com.tencent.mm.y.s.hs(str);
                otVar.fHD.flags = 0;
                m = com.tencent.mm.sdk.b.a.xmy.m(otVar);
                com.tencent.mm.af.a.e.kv(HJ);
            }
            if (m) {
                a(iVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    com.tencent.mm.ui.base.h.bu(this.context, this.context.getResources().getString(R.l.dGR));
                }
            } else {
                a(iVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    private boolean aG(i iVar) {
        x.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.sdk.b.b amVar = new am();
        String str = (String) iVar.pug.get("showInfo");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            amVar.fpt.fpv = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            x.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            amVar.fpt.fpw = bi.getInt(str, 0) > 0;
            com.tencent.mm.f.a.am.a aVar = amVar.fpt;
            if (bi.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.fpx = z;
            com.tencent.mm.f.a.am.a aVar2 = amVar.fpt;
            if (bi.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.fpy = z;
            com.tencent.mm.sdk.b.a.xmy.m(amVar);
            if (amVar.fpu.foB) {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(iVar, "changePayActivityView:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(iVar, "changePayActivityView:fail", null);
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
    }

    private boolean aH(i iVar) {
        String str = (String) iVar.pug.get("idKeyDataInfo");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "idkey data is null");
            a(iVar, "reportIDKey:fail_invaild_parms", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(bi.getInt(optJSONObject.optString(SlookAirButtonFrequentContactAdapter.ID), 0));
                    iDKey.SetKey(bi.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue((long) bi.getInt(optJSONObject.optString(Columns.VALUE), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
                    a(iVar, "reportIDKey:ok", null);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "parse json array faild : %s", e.getMessage());
            }
            a(iVar, "reportIDKey:fail", null);
        }
        return false;
    }

    private boolean aI(i iVar) {
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openCunstonWebview:fail_invalid_url", null);
            return true;
        }
        int i;
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        String oM;
        String oM2;
        boolean z5;
        String oM3;
        Intent intent;
        com.tencent.mm.sdk.b.b kkVar;
        String oM4 = bi.oM((String) iVar.pug.get("orientation"));
        if (!bi.oN(oM4)) {
            if (oM4.equals("horizontal")) {
                i = 0;
            } else if (oM4.equals("vertical")) {
                i = 1;
            } else if (oM4.equals("sensor")) {
                i = 4;
            }
            if (bi.oM((String) iVar.pug.get("fullscreen")).equals("true")) {
                z = false;
            } else {
                z = true;
            }
            str2 = (String) iVar.pug.get("top_url");
            oM4 = (String) iVar.pug.get("top_title");
            z2 = false;
            if (this.fCC != null) {
                z2 = this.fCC.e(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
            obj = null;
            if (bi.oM((String) iVar.pug.get("finish_recent_webview")).equals("1")) {
                obj = 1;
            }
            z4 = false;
            if (bi.oM((String) iVar.pug.get("disable_swipe_back")).equals("1")) {
                z4 = true;
            }
            oM = bi.oM((String) iVar.pug.get("username"));
            oM2 = bi.oM((String) iVar.pug.get("open_game_webview"));
            z2 = false;
            if (this.fCC != null) {
                z2 = this.fCC.e(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
            oM3 = bi.oM((String) iVar.pug.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z);
            intent.putExtra("disable_swipe_back", z4);
            intent.putExtra("from_shortcut", z3);
            intent.putExtra("shortcut_user_name", oM);
            if (!(bi.oN(str2) || bi.oN(oM4))) {
                intent.putExtra("keep_top_scene", 2);
                intent.putExtra("custom_keep_top_url", str2);
                intent.putExtra("custom_keep_top_title", oM4);
            }
            intent.putExtra("is_from_keep_top", z5);
            intent.putExtra("game_hv_menu_appid", oM3);
            if (z3) {
                com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
            } else if (bi.oM(oM2).equals("1")) {
                com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                kkVar = new kk();
                kkVar.fCB.type = 0;
                kkVar.fCB.context = this.context;
                kkVar.fCB.intent = intent;
                kkVar.fCB.fCC = this.fCC;
                com.tencent.mm.sdk.b.a.xmy.m(kkVar);
            }
            if (!(obj == null || z3)) {
                ah.h(new Runnable() {
                    public final void run() {
                        try {
                            g.this.o(new i());
                        } catch (Exception e) {
                            x.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", e.getMessage());
                        }
                    }
                }, 200);
            }
            kkVar = new go();
            kkVar.fxy.pK = 2;
            kkVar.fxy.fxA = oM3;
            com.tencent.mm.sdk.b.a.xmy.m(kkVar);
            a(iVar, "openCunstonWebview:ok", null);
            return true;
        }
        i = -1;
        if (bi.oM((String) iVar.pug.get("fullscreen")).equals("true")) {
            z = false;
        } else {
            z = true;
        }
        str2 = (String) iVar.pug.get("top_url");
        oM4 = (String) iVar.pug.get("top_title");
        z2 = false;
        try {
            if (this.fCC != null) {
                z2 = this.fCC.e(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from shortcut exception : %s", e.getMessage());
            z3 = false;
        }
        obj = null;
        if (bi.oM((String) iVar.pug.get("finish_recent_webview")).equals("1")) {
            obj = 1;
        }
        z4 = false;
        if (bi.oM((String) iVar.pug.get("disable_swipe_back")).equals("1")) {
            z4 = true;
        }
        oM = bi.oM((String) iVar.pug.get("username"));
        oM2 = bi.oM((String) iVar.pug.get("open_game_webview"));
        z2 = false;
        try {
            if (this.fCC != null) {
                z2 = this.fCC.e(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from keep top exception : %s", e2.getMessage());
            z5 = false;
        }
        oM3 = bi.oM((String) iVar.pug.get("gameAppid"));
        intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("screen_orientation", i);
        intent.putExtra("show_full_screen", z);
        intent.putExtra("disable_swipe_back", z4);
        intent.putExtra("from_shortcut", z3);
        intent.putExtra("shortcut_user_name", oM);
        intent.putExtra("keep_top_scene", 2);
        intent.putExtra("custom_keep_top_url", str2);
        intent.putExtra("custom_keep_top_title", oM4);
        intent.putExtra("is_from_keep_top", z5);
        intent.putExtra("game_hv_menu_appid", oM3);
        if (z3) {
            com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
        } else if (bi.oM(oM2).equals("1")) {
            com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            kkVar = new kk();
            kkVar.fCB.type = 0;
            kkVar.fCB.context = this.context;
            kkVar.fCB.intent = intent;
            kkVar.fCB.fCC = this.fCC;
            com.tencent.mm.sdk.b.a.xmy.m(kkVar);
        }
        ah.h(/* anonymous class already generated */, 200);
        kkVar = new go();
        kkVar.fxy.pK = 2;
        kkVar.fxy.fxA = oM3;
        com.tencent.mm.sdk.b.a.xmy.m(kkVar);
        a(iVar, "openCunstonWebview:ok", null);
        return true;
    }

    private boolean aJ(i iVar) {
        String oM = bi.oM((String) iVar.pug.get("orientation"));
        int i = -1;
        if (!bi.oN(oM)) {
            if (oM.equals("horizontal")) {
                i = 0;
            } else if (oM.equals("vertical")) {
                i = 1;
            } else if (oM.equals("sensor")) {
                i = 4;
            } else if (oM.equals("horizontal_unforced")) {
                i = 1001;
            } else if (oM.equals("vertical_unforced")) {
                i = 1002;
            }
        }
        try {
            if (this.fCC != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", i);
                this.fCC.e(HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION, bundle);
                a(iVar, "setScreenOrientation:ok", null);
            } else {
                a(iVar, "setScreenOrientation:fail", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetScreenOrientation exception, " + e.getMessage());
            a(iVar, "setScreenOrientation:fail", null);
        }
        return true;
    }

    private boolean aK(i iVar) {
        x.i("MicroMsg.MsgHandler", "setNavigationBarColor");
        boolean equals = "1".equals((String) iVar.pug.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) iVar.pug.get("color")) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (bi.getFloat((String) iVar.pug.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.fCC.e(53, bundle);
            a(iVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            x.e("MicroMsg.MsgHandler", e22.getMessage());
            a(iVar, "setNavigationBarColor:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        x.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", Long.valueOf(j));
        try {
            if (this.fCC != null) {
                this.fCC.n(80001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
        }
    }

    private boolean kJ(boolean z) {
        x.e("MicroMsg.MsgHandler", "hideMenuEntry:" + z);
        try {
            this.fCC.kx(z);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return false;
        } catch (Throwable th) {
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        }
    }

    private boolean aL(final i iVar) {
        x.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) iVar.pug.get("openid");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
        } else {
            String str2 = (String) iVar.pug.get("appId");
            if (this.tNQ != null && TextUtils.isEmpty(str2)) {
                str2 = this.tNQ.getString("jsapi_args_appid");
            }
            if (bi.oN(str2)) {
                x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
            } else {
                this.fzX = f(iVar);
                final k vVar = new v(str2, str);
                as.CN().a(1142, new com.tencent.mm.ad.e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        if (g.this.inI != null && g.this.inI.isShowing()) {
                            g.this.inI.dismiss();
                            g.this.inI = null;
                        }
                        if (i == 0 && i2 == 0) {
                            bpu bpu;
                            v vVar = (v) kVar;
                            if (vVar.gLB == null) {
                                bpu = null;
                            } else {
                                bpu = (bpu) vVar.gLB.hnR.hnY;
                            }
                            if (bpu != null) {
                                String str2 = bpu.username;
                                if (bi.oN(str2)) {
                                    x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                                } else if (g.this.context instanceof MMActivity) {
                                    if (g.a(g.this, str2, (String) iVar.pug.get("title"), (String) iVar.pug.get("img_url"), str2, (String) iVar.pug.get("desc"), (String) iVar.pug.get("src_username"), (String) iVar.pug.get("src_displayname"), "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") == null) {
                                        x.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                                        g.this.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            x.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
                        } else {
                            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
                        }
                        g.this.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                    }
                });
                as.CN().a(vVar, 0);
                Context context = this.context;
                this.context.getString(R.l.dGZ);
                this.inI = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(vVar);
                    }
                });
            }
        }
        return true;
    }

    private boolean bVr() {
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.fCC.bSB();
            this.fCC.O(bundle);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean aM(i iVar) {
        x.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.fCC.aeH();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bi.oN(str)) {
            intent.putExtra("appId", this.tNZ.Qf(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fDO);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.fCC.aeH());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("pay_channel", gVar.frE);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        return true;
    }

    public final boolean bVs() {
        x.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).jCj = this;
        com.tencent.mm.bl.d.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        return true;
    }

    private boolean aN(i iVar) {
        boolean z;
        String str = (String) iVar.pug.get("clearCookie");
        x.i("MicroMsg.MsgHandler", "clearflag = %s", str);
        if (bi.oN(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bi.oN(str)) {
            str = com.tencent.mm.plugin.webview.modelcache.p.Pc(str);
            if (bi.oN(str)) {
                str = null;
            } else {
                Uri parse = Uri.parse(str);
                str = parse.getHost() + ":" + parse.getPort();
            }
            if (!bi.oN(str)) {
                a.tAC.Dt().F(new Runnable() {
                    public final void run() {
                        List list = null;
                        a.tAC;
                        String str = str;
                        if (!bi.oN(str)) {
                            com.tencent.mm.plugin.webview.modelcache.k bRZ = com.tencent.mm.plugin.webview.modelcache.k.bRZ();
                            if (bRZ.jbr && !bi.oN(str)) {
                                list = bRZ.n(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), str);
                            }
                            if (!bi.cC(list)) {
                                for (com.tencent.mm.plugin.webview.modelcache.f fVar : list) {
                                    com.tencent.mm.plugin.webview.modelcache.a Pb = com.tencent.mm.plugin.webview.modelcache.a.Pb(fVar.field_appId);
                                    if (Pb != null) {
                                        String str2 = fVar.field_localPath;
                                        if (!bi.oN(str2)) {
                                            long mi = str2.startsWith(Pb.path) ? FileOp.mi(str2) : 0;
                                            if (FileOp.deleteFile(str2) && str2.startsWith(Pb.path)) {
                                                b bVar = Pb.tzP;
                                                String str3 = Pb.appId;
                                                if (bVar.jbr) {
                                                    com.tencent.mm.sdk.e.c aVar = new a();
                                                    aVar.field_appId = str3;
                                                    if (bVar.b(aVar, new String[0])) {
                                                        aVar.field_occupation = Math.max(0, aVar.field_occupation - mi);
                                                        bVar.c(aVar, new String[0]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.webview.modelcache.k bRZ2 = com.tencent.mm.plugin.webview.modelcache.k.bRZ();
                                if (bRZ2.jbr && !bi.oN(str)) {
                                    com.tencent.mm.sdk.e.c fVar2 = new com.tencent.mm.plugin.webview.modelcache.f();
                                    fVar2.field_domain = str;
                                    bRZ2.a(fVar2, "domain");
                                }
                            }
                        }
                        WebViewCacheDownloadHelper.bSe();
                    }
                });
            }
        }
        if (this.fCC != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.fCC.e(6001, bundle);
                a(iVar, "clearWebviewCache:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", e.getMessage());
                a(iVar, "clearWebviewCache:fail", null);
            }
        } else {
            a(iVar, "clearWebviewCache:fail", null);
        }
        return true;
    }

    public final boolean aO(i iVar) {
        x.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pug);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.fCC.aeH();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bi.oN(str)) {
            intent.putExtra("appId", this.tNZ.Qf(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fDO);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.fCC.aeH());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("pay_channel", gVar.frE);
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        return true;
    }

    public final boolean aP(i iVar) {
        a(iVar, "uploadIdCardSuccess:ok", null);
        x.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        com.tencent.mm.sdk.b.b tiVar = new ti();
        tiVar.fME.result = -1;
        com.tencent.mm.sdk.b.a.xmy.m(tiVar);
        return true;
    }

    public final boolean aQ(i iVar) {
        x.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = bi.getInt((String) iVar.pug.get("cmd"), 0);
        String str = (String) iVar.pug.get("param");
        Map hashMap;
        if (i != 10002) {
            com.tencent.mm.sdk.b.b goVar = new go();
            goVar.fxy.pK = i;
            goVar.fxy.fxA = str;
            goVar.fxy.context = this.context;
            com.tencent.mm.sdk.b.a.xmy.m(goVar);
            x.i("MicroMsg.MsgHandler", "gameCommInfo:%s", goVar.fxz.result);
            if (bi.oN(goVar.fxz.result)) {
                a(iVar, "getGameCommInfo:fail", null);
            } else {
                try {
                    hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(goVar.fxz.result);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    a(iVar, "getGameCommInfo:ok", hashMap);
                } catch (JSONException e) {
                    a(iVar, "getGameCommInfo:fail", null);
                }
            }
        } else if (this.fCC != null) {
            try {
                Bundle e2 = this.fCC.e(97, null);
                if (e2 != null) {
                    int i2 = e2.getInt("web_page_count");
                    hashMap = new HashMap();
                    hashMap.put("webpageCount", Integer.valueOf(i2));
                    a(iVar, "getGameCommInfo:ok", hashMap);
                }
            } catch (RemoteException e3) {
                x.e("MicroMsg.MsgHandler", "doGetGameCommInfo exception, " + e3.getMessage());
                a(iVar, "getGameCommInfo:fail", null);
            }
        }
        return true;
    }

    public final boolean bVt() {
        x.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        return true;
    }

    public final boolean aR(final i iVar) {
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.context);
        lVar.b(null, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 1, 0, g.this.context.getString(R.l.eHI));
                contextMenu.add(0, 2, 1, g.this.context.getString(R.l.eHD));
            }
        }, new com.tencent.mm.ui.base.p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        g.dN(g.this, iVar);
                        return;
                    case 2:
                        g.dO(g.this, iVar);
                        return;
                    default:
                        return;
                }
            }
        });
        lVar.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.this.a(iVar, "chooseIdCard:cancel", null);
            }
        });
        lVar.bCH();
        return true;
    }

    private boolean aS(i iVar) {
        String str;
        if (this.tNQ != null) {
            int i = this.tNQ.getInt("key_download_restrict", 0);
            if (!bi.oN(this.tNQ.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14596, str, Integer.valueOf(i), Integer.valueOf(1));
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to launch application");
                a(iVar, "launchApplication:fail", null);
                return true;
            }
        }
        x.i("MicroMsg.MsgHandler", "launchTimeInterval = %d", Long.valueOf(bi.Wx() - this.tOd));
        if (bi.Wx() - this.tOd < 2 && this.tOd > 0) {
            try {
                String encode = URLEncoder.encode(this.fCC.aeH(), "UTF-8");
                com.tencent.mm.plugin.report.service.g.pWK.h(13983, Integer.valueOf(5), encode, "");
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "report launchApplication failed");
            }
        }
        final String str2 = (String) iVar.pug.get("appID");
        final String str3 = (String) iVar.pug.get("schemeUrl");
        final String str4 = (String) iVar.pug.get("parameter");
        int i2 = bi.getInt((String) iVar.pug.get("alertType"), 0);
        k.a(iVar.tQf, false, null, str2);
        final String str5 = (String) iVar.pug.get("extInfo");
        x.i("MicroMsg.MsgHandler", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s", str2, str3, str5, str4);
        if (bi.oN(str2) && bi.oN(str3)) {
            x.e("MicroMsg.MsgHandler", "appid and scheme is null or nil");
            a(iVar, "launchApplication:fail", null);
            return true;
        }
        Object obj = iVar.pug.get("__jsapi_fw_ext_info");
        str = null;
        if (obj instanceof Bundle) {
            str = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        }
        String Qf = this.tNZ.Qf(str);
        final Bundle bundle = new Bundle();
        if (!bi.oN(str)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
            }
        }
        bundle.putString("current_page_appid", Qf);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ami();
        aVar.hnU = new amj();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.hnS = 1125;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        ami ami = (ami) Kf.hnQ.hnY;
        ami.fGh = Qf;
        ami.wzZ = str2;
        ami.scene = aim();
        ami.url = str;
        ami.wAa = str3;
        ami.low = i2;
        ami.wAb = 0;
        x.i("MicroMsg.MsgHandler", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", Qf, str2, Integer.valueOf(ami.scene), ami.url, ami.wAa, Integer.valueOf(ami.low));
        final i iVar2 = iVar;
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.MsgHandler", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    amj amj = (amj) bVar.hnR.hnY;
                    switch (amj.fun) {
                        case 0:
                            List y;
                            Object b;
                            boolean a;
                            Object dVar = new d(new a() {
                                public final void n(boolean z, boolean z2) {
                                    x.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                    if (z) {
                                        g.this.a(iVar2, "launchApplication:ok", null);
                                    } else {
                                        g.this.a(iVar2, "launchApplication:fail", null);
                                    }
                                }
                            });
                            x.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(amj.wAc), Integer.valueOf(amj.fun));
                            if (!bi.oN(str3)) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                y = bi.y(g.this.context, intent);
                                if (!(y == null || y.isEmpty())) {
                                    if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                        b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) y.get(0));
                                    } else {
                                        b = intent.getPackage();
                                    }
                                    if (!bi.oM(ad.getPackageName()).equals(b)) {
                                        dVar.cJ(com.tencent.mm.pluginsdk.model.app.g.a(g.this.context, intent, null, amj.wAc, dVar, bundle));
                                        return 0;
                                    }
                                }
                            }
                            IMediaObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = str5;
                            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                            wXMediaMessage.sdkVer = 620823552;
                            wXMediaMessage.messageExt = str5;
                            com.tencent.mm.sdk.b.b irVar = new ir();
                            irVar.fzV.fzX = wXMediaMessage;
                            irVar.fzV.appId = str2;
                            irVar.fzV.showType = amj.wAc;
                            irVar.fzV.context = g.this.context;
                            irVar.fzV.frc = bundle;
                            irVar.fzV.fzY = dVar;
                            com.tencent.mm.sdk.b.a.xmy.m(irVar);
                            boolean z = irVar.fzW.fzZ;
                            if (!z) {
                                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str2 + "://" + str4));
                                x.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                y = bi.y(g.this.context, intent2);
                                if (!(y == null || y.isEmpty())) {
                                    if (TextUtils.isEmpty(intent2.getPackage()) && y.size() == 1) {
                                        b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) y.get(0));
                                    } else {
                                        b = intent2.getPackage();
                                    }
                                    if (!bi.oM(ad.getPackageName()).equals(b)) {
                                        dVar.hpc = false;
                                        dVar.jgD = false;
                                        dVar.jgE = false;
                                        dVar.fzZ = false;
                                        a = com.tencent.mm.pluginsdk.model.app.g.a(g.this.context, intent2, null, dVar, bundle);
                                        dVar.cJ(a);
                                        return 0;
                                    }
                                }
                            }
                            a = z;
                            dVar.cJ(a);
                            return 0;
                        case 2:
                            g.this.a(iVar2, "launchApplication:fail_check fail forbidden scene", null);
                            return 0;
                        default:
                            g.this.a(iVar2, "launchApplication:fail_check fail", null);
                            return 0;
                    }
                }
                g.this.a(iVar2, "launchApplication:fail_check fail", null);
                return 0;
            }
        });
        return true;
    }

    private boolean a(final i iVar, final a aVar) {
        String aeH;
        x.i("MicroMsg.MsgHandler", "doLogin!");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        try {
            aeH = this.fCC.aeH();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        final String oM = bi.oM(this.tNZ.Qf(aeH));
        if (bi.oN(oM)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "doLogin:fail", null);
            aVar.afS();
            return false;
        }
        as.CN().a(new com.tencent.mm.t.a.c(oM, linkedList, str2, str, new com.tencent.mm.t.a.c.a<com.tencent.mm.t.a.c>() {
            public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                com.tencent.mm.t.a.c cVar = (com.tencent.mm.t.a.c) kVar;
                x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i != 0 || i2 != 0) {
                    g.this.a(iVar, "login:fail", null);
                    aVar.afS();
                } else if (cVar instanceof com.tencent.mm.t.a.c) {
                    final ana Ce = cVar.Ce();
                    int i3 = Ce.wAp.fun;
                    String str2 = Ce.wAp.fuo;
                    final String str3 = Ce.wAr;
                    x.i("MicroMsg.MsgHandler", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        ah.y(new Runnable() {
                            public final void run() {
                                LinkedList linkedList = Ce.woV;
                                x.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", Ce.noG, Ce.vML);
                                com.tencent.mm.plugin.webview.ui.tools.widget.h hVar = new com.tencent.mm.plugin.webview.ui.tools.widget.h(g.this.context);
                                com.tencent.mm.plugin.webview.ui.tools.widget.h.a anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.h.a() {
                                    public final void d(int i, Bundle bundle) {
                                        x.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                g gVar = g.this;
                                                String str = oM;
                                                String str2 = str3;
                                                i iVar = iVar;
                                                a aVar = aVar;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                as.CN().a(new com.tencent.mm.t.a.d(str, linkedList, 0, str2, 0, i, new AnonymousClass116(iVar, aVar, i)), 0);
                                                if (i == 2) {
                                                    x.e("MicroMsg.MsgHandler", "fail auth deny!");
                                                    g.this.a(iVar, "login:fail auth deny", null);
                                                    aVar.afS();
                                                    return;
                                                }
                                                return;
                                            default:
                                                x.i("MicroMsg.MsgHandler", "press back button!");
                                                g.this.a(iVar, "login:fail auth cancel", null);
                                                aVar.afS();
                                                return;
                                        }
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                    g.this.a(iVar, "login:fail", null);
                                    aVar.afS();
                                } else if (!hVar.a(linkedList, r1, r2, anonymousClass1)) {
                                    aVar.afS();
                                }
                            }
                        });
                    } else if (i3 == 0) {
                        String str4 = Ce.wAs;
                        Map hashMap = new HashMap();
                        hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str4);
                        g.this.a(iVar, "login:ok", hashMap);
                        x.d("MicroMsg.MsgHandler", "resp data code [%s]", str4);
                        aVar.afS();
                    } else {
                        g.this.a(iVar, "login:fail", null);
                        x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLogin %s", str2);
                        aVar.afS();
                    }
                }
            }
        }), 0);
        return true;
    }

    private boolean b(final i iVar, final a aVar) {
        x.i("MicroMsg.MsgHandler", "doOauthAuthorize!");
        String str = (String) iVar.pug.get("scope");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "scope is null!");
            a(iVar, "authorize:fail", null);
            aVar.afS();
            return true;
        }
        String aeH;
        try {
            aeH = this.fCC.aeH();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            aeH = null;
        }
        aeH = bi.oM(this.tNZ.Qf(aeH));
        if (bi.oN(aeH)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "authorize:fail", null);
            aVar.afS();
            return false;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            as.CN().a(new com.tencent.mm.t.a.a(aeH, linkedList, new com.tencent.mm.t.a.a.a<com.tencent.mm.t.a.a>() {
                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    com.tencent.mm.t.a.a aVar = (com.tencent.mm.t.a.a) kVar;
                    x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        g.this.a(iVar, "authorize:fail", null);
                        aVar.afS();
                    } else if (aVar instanceof com.tencent.mm.t.a.a) {
                        final amw Cc = aVar.Cc();
                        int i3 = Cc.wAp.fun;
                        String str2 = Cc.wAp.fuo;
                        x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == -12000) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    LinkedList linkedList = Cc.woV;
                                    String str = Cc.noG;
                                    String str2 = Cc.vML;
                                    com.tencent.mm.plugin.webview.ui.tools.widget.h hVar = new com.tencent.mm.plugin.webview.ui.tools.widget.h(g.this.context);
                                    com.tencent.mm.plugin.webview.ui.tools.widget.h.a anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.h.a() {
                                        public final void d(int i, Bundle bundle) {
                                            x.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                            switch (i) {
                                                case 1:
                                                case 2:
                                                    g gVar = g.this;
                                                    String str = aeH;
                                                    i iVar = iVar;
                                                    a aVar = aVar;
                                                    ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                    LinkedList linkedList = new LinkedList();
                                                    Iterator it = arrayList.iterator();
                                                    while (it.hasNext()) {
                                                        linkedList.add((String) it.next());
                                                    }
                                                    as.CN().a(new com.tencent.mm.t.a.b(str, linkedList, 0, i, new AnonymousClass3(iVar, aVar, i)), 0);
                                                    if (i == 2) {
                                                        g.this.a(iVar, "authorize:fail auth deny", null);
                                                        aVar.afS();
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    x.d("MicroMsg.MsgHandler", "press back button!");
                                                    g.this.a(iVar, "authorize:fail auth cancel", null);
                                                    aVar.afS();
                                                    return;
                                            }
                                        }
                                    };
                                    if (linkedList == null || linkedList.size() <= 0) {
                                        x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                        g.this.a(iVar, "authorize:fail", null);
                                        aVar.afS();
                                    } else if (!hVar.a(linkedList, str, str2, anonymousClass1)) {
                                        aVar.afS();
                                    }
                                }
                            });
                        } else if (i3 == 0) {
                            g.this.a(iVar, "authorize:ok", null);
                            aVar.afS();
                        } else {
                            x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                            g.this.a(iVar, "authorize:fail", null);
                            aVar.afS();
                        }
                    }
                }
            }), 0);
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "Exception %s", e2.getMessage());
            a(iVar, "authorize:fail", null);
            return true;
        }
    }

    public final void ep(int i, int i2) {
        String str = "";
        String str2 = " ";
        Bundle bundle = null;
        try {
            if (this.fCC != null) {
                bundle = this.fCC.e(77, null);
            }
            if (bundle != null) {
                str = bundle.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    x.e("MicroMsg.MsgHandler", "url is empty");
                    return;
                }
                x.i("MicroMsg.MsgHandler", "sessionId %s", bi.oM(bundle.getString("KSessionId")));
                if (!bundle.getBoolean("KReportPage", false)) {
                    x.i("MicroMsg.MsgHandler", "not enable report page event control bytes");
                    return;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get sessionId error, %s", e);
        }
        if (TextUtils.isEmpty(qZ(str))) {
            x.i("MicroMsg.MsgHandler", "appId is null or empty");
            return;
        }
        x.i("MicroMsg.MsgHandler", "appId %s", qZ(str));
        x.i("MicroMsg.MsgHandler", "type %d", Integer.valueOf(this.fzX.mediaObject.type()));
        if (this.fzX.mediaObject.type() == 5) {
            long Wx = bi.Wx();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(Wx), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2));
            String str3 = "";
            try {
                str = URLEncoder.encode(bi.oM(str), "UTF-8");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str3;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13377, Long.valueOf(Wx), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void b(int r26, int r27, android.content.Intent r28) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r25 = this;
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "mmOnActivityResult, requestCode = ";
        r3.<init>(r4);
        r0 = r26;
        r3 = r3.append(r0);
        r4 = ", resultCode = ";
        r3 = r3.append(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = 1;
        r0 = r26;
        if (r0 != r2) goto L_0x02a6;
    L_0x002a:
        r0 = r25;
        r2 = r0.fzX;
        if (r2 != 0) goto L_0x0047;
    L_0x0030:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, appmsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
    L_0x0046:
        return;
    L_0x0047:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "appid";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = 0;
        r0 = r25;
        r4 = r0.tNQ;
        if (r4 == 0) goto L_0x2586;
    L_0x005d:
        r0 = r25;
        r3 = r0.tNQ;
        r4 = "KSnsAdTag";
        r3 = r3.getParcelable(r4);
        r3 = (com.tencent.mm.modelsns.SnsAdClick) r3;
        r4 = android.text.TextUtils.isEmpty(r2);
        if (r4 == 0) goto L_0x2586;
    L_0x0070:
        r0 = r25;
        r2 = r0.tNQ;
        r4 = "jsapi_args_appid";
        r2 = r2.getString(r4);
        r15 = r2;
    L_0x007c:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.bVA();
        r4 = "Internal@AsyncReport";
        r2 = r2.get(r4);
        r0 = r25;
        r4 = r0.tNN;
        r4 = r4.pug;
        r5 = "link";
        r4.get(r5);
        switch(r27) {
            case -1: goto L_0x009b;
            case 0: goto L_0x00c7;
            default: goto L_0x009a;
        };
    L_0x009a:
        goto L_0x0046;
    L_0x009b:
        if (r3 == 0) goto L_0x00a1;
    L_0x009d:
        r4 = 7;
        r3.iw(r4);
    L_0x00a1:
        r14 = com.tencent.mm.pluginsdk.model.app.g.HL(r15);
        if (r28 != 0) goto L_0x0111;
    L_0x00a7:
        r5 = 0;
    L_0x00a8:
        if (r5 == 0) goto L_0x00b0;
    L_0x00aa:
        r3 = r5.length();
        if (r3 != 0) goto L_0x011b;
    L_0x00b0:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, toUser is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x00c7:
        if (r3 == 0) goto L_0x00ce;
    L_0x00c9:
        r4 = 8;
        r3.iw(r4);
    L_0x00ce:
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.bVA();
        r4 = "sendAppMessage";
        r0 = r25;
        r4 = r0.Qn(r4);
        r5 = 0;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a(r3, r4, r5, r15);
        if (r2 == 0) goto L_0x00fb;
    L_0x00e5:
        r3 = r2 instanceof java.lang.Boolean;
        if (r3 == 0) goto L_0x00fb;
    L_0x00e9:
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x00fb;
    L_0x00f1:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 1;
        r0 = r25;
        r0.b(r2, r3);
    L_0x00fb:
        r2 = 1;
        r3 = 3;
        r0 = r25;
        r0.ep(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0111:
        r3 = "Select_Conv_User";
        r0 = r28;
        r5 = r0.getStringExtra(r3);
        goto L_0x00a8;
    L_0x011b:
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.pug;
        r4 = "img_url";
        r6 = r3.get(r4);
        r6 = (java.lang.String) r6;
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.pug;
        r4 = "desc";
        r3.get(r4);
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.pug;
        r4 = "src_username";
        r7 = r3.get(r4);
        r7 = (java.lang.String) r7;
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.pug;
        r4 = "src_displayname";
        r8 = r3.get(r4);
        r8 = (java.lang.String) r8;
        r10 = r25.bVk();
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.bVA();
        r4 = "sendAppMessage";
        r0 = r25;
        r4 = r0.Qn(r4);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a(r3, r4, r5, r15);
        if (r2 == 0) goto L_0x0184;
    L_0x016e:
        r3 = r2 instanceof java.lang.Boolean;
        if (r3 == 0) goto L_0x0184;
    L_0x0172:
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0184;
    L_0x017a:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 1;
        r0 = r25;
        r0.b(r2, r3);
    L_0x0184:
        r2 = ",";
        r11 = r5.split(r2);
        r3 = 0;
        r4 = 0;
        r12 = r11.length;
        r2 = 0;
        r9 = r2;
    L_0x0190:
        if (r9 >= r12) goto L_0x01ae;
    L_0x0192:
        r2 = r11[r9];
        r13 = "@chatroom";
        r2 = r2.endsWith(r13);
        if (r2 == 0) goto L_0x01a6;
    L_0x019d:
        r2 = r3 + 1;
        r3 = r4;
    L_0x01a0:
        r4 = r9 + 1;
        r9 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0190;
    L_0x01a6:
        r2 = r4 + 1;
        r24 = r3;
        r3 = r2;
        r2 = r24;
        goto L_0x01a0;
    L_0x01ae:
        r21 = new java.util.HashMap;
        r21.<init>();
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r9 = "share_callback_with_scene";
        r2 = r2.get(r9);
        if (r2 == 0) goto L_0x01ef;
    L_0x01c2:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r9 = "share_callback_with_scene";
        r2 = r2.get(r9);
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x01ef;
    L_0x01d7:
        r2 = "groupCount";
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r21;
        r0.put(r2, r3);
        r2 = "singleCount";
        r3 = java.lang.Integer.valueOf(r4);
        r0 = r21;
        r0.put(r2, r3);
    L_0x01ef:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r2 == 0) goto L_0x023d;
    L_0x01f5:
        if (r28 != 0) goto L_0x0233;
    L_0x01f7:
        r9 = 0;
    L_0x01f8:
        r3 = 0;
        r4 = "";
        r2 = r25;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r25;
        r2 = r0.context;
        if (r2 == 0) goto L_0x021c;
    L_0x0207:
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r3 = r3.getResources();
        r4 = com.tencent.mm.R.l.dGR;
        r3 = r3.getString(r4);
        com.tencent.mm.ui.base.h.br(r2, r3);
    L_0x021c:
        r2 = 1;
        r3 = 1;
        r0 = r25;
        r0.ep(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:ok";
        r0 = r25;
        r1 = r21;
        r0.a(r2, r3, r1);
        goto L_0x0046;
    L_0x0233:
        r2 = "custom_send_text";
        r0 = r28;
        r9 = r0.getStringExtra(r2);
        goto L_0x01f8;
    L_0x023d:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r2 == 0) goto L_0x026e;
    L_0x0243:
        r3 = 0;
        r4 = "";
        r9 = 0;
        r2 = r25;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r4 = com.tencent.mm.R.l.dGJ;
        r3 = r3.getString(r4);
        com.tencent.mm.ui.base.h.br(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:ok";
        r0 = r25;
        r1 = r21;
        r0.a(r2, r3, r1);
        goto L_0x0046;
    L_0x026e:
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r3 = r3.getResources();
        r4 = com.tencent.mm.R.l.dGM;
        r3 = r3.getString(r4);
        r4 = 1;
        r9 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$5;
        r0 = r25;
        r9.<init>(r6);
        r13 = com.tencent.mm.ui.base.h.a(r2, r3, r4, r9);
        r2 = com.tencent.mm.ap.o.PB();
        r11 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$6;
        r12 = r25;
        r16 = r5;
        r17 = r6;
        r18 = r7;
        r19 = r8;
        r20 = r10;
        r11.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21);
        r2.a(r6, r11);
        goto L_0x0046;
    L_0x02a6:
        r2 = 2;
        r0 = r26;
        if (r0 != r2) goto L_0x0336;
    L_0x02ab:
        switch(r27) {
            case -1: goto L_0x02dd;
            case 0: goto L_0x0301;
            case 1: goto L_0x0310;
            default: goto L_0x02ae;
        };
    L_0x02ae:
        r0 = r25;
        r2 = r0.tNN;
        r3 = new java.lang.StringBuilder;
        r4 = "share_weibo:fail_";
        r3.<init>(r4);
        r4 = "err_code";
        r5 = 0;
        r0 = r28;
        r4 = r0.getIntExtra(r4, r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = "MicroMsg.MsgHandler";
        r3 = "unknown resultCode";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x0046;
    L_0x02dd:
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r3 = r3.getResources();
        r4 = com.tencent.mm.R.l.dGR;
        r3 = r3.getString(r4);
        com.tencent.mm.ui.base.h.br(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "share_weibo:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0301:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "share_weibo:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0310:
        r0 = r25;
        r2 = r0.tNN;
        r3 = new java.lang.StringBuilder;
        r4 = "share_weibo:fail_";
        r3.<init>(r4);
        r4 = "err_code";
        r5 = 0;
        r0 = r28;
        r4 = r0.getIntExtra(r4, r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0336:
        r2 = 3;
        r0 = r26;
        if (r0 != r2) goto L_0x0480;
    L_0x033b:
        r2 = "MicroMsg.MsgHandler";
        r3 = "get callback address, result code = %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0460;
    L_0x0353:
        if (r28 == 0) goto L_0x0460;
    L_0x0355:
        r2 = "nationalCode";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r3);
        r3 = "userName";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r3, r4);
        r4 = "telNumber";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        r5 = "";
        r4 = com.tencent.mm.sdk.platformtools.bi.aD(r4, r5);
        r5 = "addressPostalCode";
        r0 = r28;
        r5 = r0.getStringExtra(r5);
        r6 = "";
        r5 = com.tencent.mm.sdk.platformtools.bi.aD(r5, r6);
        r6 = "proviceFirstStageName";
        r0 = r28;
        r6 = r0.getStringExtra(r6);
        r7 = "";
        r6 = com.tencent.mm.sdk.platformtools.bi.aD(r6, r7);
        r7 = "addressCitySecondStageName";
        r0 = r28;
        r7 = r0.getStringExtra(r7);
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.bi.aD(r7, r8);
        r8 = "addressCountiesThirdStageName";
        r0 = r28;
        r8 = r0.getStringExtra(r8);
        r9 = "";
        r8 = com.tencent.mm.sdk.platformtools.bi.aD(r8, r9);
        r9 = "addressDetailInfo";
        r0 = r28;
        r9 = r0.getStringExtra(r9);
        r10 = "";
        r9 = com.tencent.mm.sdk.platformtools.bi.aD(r9, r10);
        r10 = "MicroMsg.MsgHandler";
        r11 = new java.lang.StringBuilder;
        r12 = "first =  ";
        r11.<init>(r12);
        r11 = r11.append(r6);
        r12 = " ; detail =";
        r11 = r11.append(r12);
        r11 = r11.append(r9);
        r12 = "; second = ";
        r11 = r11.append(r12);
        r11 = r11.append(r7);
        r12 = " ; tel = ";
        r11 = r11.append(r12);
        r11 = r11.append(r4);
        r12 = "; third = ";
        r11 = r11.append(r12);
        r11 = r11.append(r8);
        r11 = r11.toString();
        com.tencent.mm.sdk.platformtools.x.i(r10, r11);
        r10 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r10 != 0) goto L_0x0460;
    L_0x041d:
        r10 = new java.util.HashMap;
        r10.<init>();
        r11 = "nationalCode";
        r10.put(r11, r2);
        r2 = "userName";
        r10.put(r2, r3);
        r2 = "telNumber";
        r10.put(r2, r4);
        r2 = "addressPostalCode";
        r10.put(r2, r5);
        r2 = "proviceFirstStageName";
        r10.put(r2, r6);
        r2 = "addressCitySecondStageName";
        r10.put(r2, r7);
        r2 = "addressCountiesThirdStageName";
        r10.put(r2, r8);
        r2 = "addressDetailInfo";
        r10.put(r2, r9);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "edit_address:ok";
        r0 = r25;
        r0.a(r2, r3, r10);
        goto L_0x0046;
    L_0x0460:
        if (r27 != 0) goto L_0x0471;
    L_0x0462:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "edit_address:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0471:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "edit_address:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0480:
        r2 = 4;
        r0 = r26;
        if (r0 != r2) goto L_0x054a;
    L_0x0485:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request pay, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tOf;
        r3 = -1;
        if (r2 == r3) goto L_0x04d2;
    L_0x04a4:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: has blocked ";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r0 = r25;
        r2 = r0.tOf;
        r0 = r25;
        r2 = r0.Bs(r2);
        r2 = r2.tNN;
        r0 = r25;
        r0.tNN = r2;
        r0 = r25;
        r2 = r0.tOf;
        r0 = r25;
        r2 = r0.Bs(r2);
        r2 = r2.fCC;
        r0 = r25;
        r0.fCC = r2;
        r2 = -1;
        r0 = r25;
        r0.tOf = r2;
    L_0x04d2:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x04e6;
    L_0x04d7:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_brand_wcpay_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x04e6:
        r2 = 5;
        r0 = r27;
        if (r0 != r2) goto L_0x053b;
    L_0x04eb:
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "key_jsapi_pay_err_code";
        r4 = 0;
        r0 = r28;
        r3 = r0.getIntExtra(r3, r4);
        r4 = "key_jsapi_pay_err_msg";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r4);
        r5 = "err_code";
        r6 = java.lang.Integer.valueOf(r3);
        r2.put(r5, r6);
        r5 = "err_desc";
        r2.put(r5, r4);
        r5 = "MicroMsg.MsgHandler";
        r6 = "hy: pay jsapi failed. errCode: %d, errMsg: %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r8] = r3;
        r3 = 1;
        r7[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "get_brand_wcpay_request:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x053b:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_brand_wcpay_request:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x054a:
        r2 = 27;
        r0 = r26;
        if (r0 != r2) goto L_0x05f2;
    L_0x0550:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request ibg prepay request, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tOf;
        r3 = -1;
        if (r2 == r3) goto L_0x059d;
    L_0x056f:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: has blocked ";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r0 = r25;
        r2 = r0.tOf;
        r0 = r25;
        r2 = r0.Bs(r2);
        r2 = r2.tNN;
        r0 = r25;
        r0.tNN = r2;
        r0 = r25;
        r2 = r0.tOf;
        r0 = r25;
        r2 = r0.Bs(r2);
        r2 = r2.fCC;
        r0 = r25;
        r0.fCC = r2;
        r2 = -1;
        r0 = r25;
        r0.tOf = r2;
    L_0x059d:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x05e3;
    L_0x05a2:
        if (r28 == 0) goto L_0x05d4;
    L_0x05a4:
        r2 = "url";
        r0 = r28;
        r2 = r0.hasExtra(r2);
        if (r2 == 0) goto L_0x05d4;
    L_0x05af:
        r2 = 0;
        r3 = "view_port_code";
        r0 = r28;
        r3 = r0.hasExtra(r3);
        if (r3 == 0) goto L_0x05c4;
    L_0x05bb:
        r2 = "view_port_code";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
    L_0x05c4:
        r0 = r25;	 Catch:{ RemoteException -> 0x2575 }
        r3 = r0.fCC;	 Catch:{ RemoteException -> 0x2575 }
        r4 = "url";	 Catch:{ RemoteException -> 0x2575 }
        r0 = r28;	 Catch:{ RemoteException -> 0x2575 }
        r4 = r0.getStringExtra(r4);	 Catch:{ RemoteException -> 0x2575 }
        r3.eU(r4, r2);	 Catch:{ RemoteException -> 0x2575 }
    L_0x05d4:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_h5_prepay_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x05e3:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_h5_prepay_request:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x05f2:
        r2 = 5;
        r0 = r26;
        if (r0 != r2) goto L_0x0632;
    L_0x05f7:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request jump to mall, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0623;
    L_0x0614:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_wcmall:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0623:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_wcmall:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0632:
        r2 = 6;
        r0 = r26;
        if (r0 != r2) goto L_0x0672;
    L_0x0637:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request jump to product view, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0663;
    L_0x0654:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "open_product_view:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0663:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "open_product_view:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0672:
        r2 = 7;
        r0 = r26;
        if (r0 != r2) goto L_0x06ee;
    L_0x0677:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request bind card, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x06c3;
    L_0x0694:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_brand_wcpay_bind_card_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_brand_wcpay_bind_card_request:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x06b8:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x06be:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x06c3:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_brand_wcpay_bind_card_request:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x06b8;
    L_0x06d6:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_brand_wcpay_bind_card_request:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x06b8;
    L_0x06ee:
        r2 = 9;
        r0 = r26;
        if (r0 != r2) goto L_0x072f;
    L_0x06f4:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request open wxcredit, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0720;
    L_0x0711:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_wcpay_create_credit_card_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0720:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_wcpay_create_credit_card_request:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x072f:
        r2 = 8;
        r0 = r26;
        if (r0 != r2) goto L_0x0795;
    L_0x0735:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request jumpToBizProfile, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        switch(r27) {
            case -1: goto L_0x0768;
            case 0: goto L_0x0777;
            case 1: goto L_0x0750;
            case 2: goto L_0x0786;
            case 3: goto L_0x0786;
            default: goto L_0x0750;
        };
    L_0x0750:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_to_biz_profile:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = "MicroMsg.MsgHandler";
        r3 = "unknown resultCode";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x0046;
    L_0x0768:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_to_biz_profile:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0777:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_to_biz_profile:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0786:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "jump_to_biz_profile:check_fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0795:
        r2 = 10;
        r0 = r26;
        if (r0 != r2) goto L_0x07b5;
    L_0x079b:
        if (r27 != 0) goto L_0x0046;
    L_0x079d:
        r2 = "MicroMsg.MsgHandler";
        r3 = "open scan product ui back";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "open_scan_product_view:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x07b5:
        r2 = 11;
        r0 = r26;
        if (r0 != r2) goto L_0x0832;
    L_0x07bb:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request transfer_money, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0807;
    L_0x07d8:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_transfer_money_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_transfer_money_request:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x07fc:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x0802:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x0807:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_transfer_money_request:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x07fc;
    L_0x081a:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_transfer_money_request:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x07fc;
    L_0x0832:
        r2 = 17;
        r0 = r26;
        if (r0 != r2) goto L_0x08af;
    L_0x0838:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request open_wcpay_specific_view, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0884;
    L_0x0855:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "open_wcpay_specific_view:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "open_wcpay_specific_view:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x0879:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x087f:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x0884:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "open_wcpay_specific_view:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0879;
    L_0x0897:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "open_wcpay_specific_view:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x0879;
    L_0x08af:
        r2 = 18;
        r0 = r26;
        if (r0 != r2) goto L_0x0953;
    L_0x08b5:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request request_wcpay_send_c2c_msg, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0901;
    L_0x08d2:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_send_c2c_message_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_send_c2c_message_request:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x08f6:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x08fc:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x0901:
        if (r27 != 0) goto L_0x0928;
    L_0x0903:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_send_c2c_message_request:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_send_c2c_message_request:cancel";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x08f6;
    L_0x0928:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_send_c2c_message_request:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x08f6;
    L_0x093b:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_send_c2c_message_request:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x08f6;
    L_0x0953:
        r2 = 13;
        r0 = r26;
        if (r0 != r2) goto L_0x09bf;
    L_0x0959:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request choose card, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = -1;
        r0 = r27;
        if (r0 != r3) goto L_0x09a1;
    L_0x097b:
        if (r28 == 0) goto L_0x0993;
    L_0x097d:
        r3 = "choose_card_info";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r3, r4);
        r4 = "choose_card_info";
        r2.put(r4, r3);
    L_0x0993:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_card:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x09a1:
        if (r27 != 0) goto L_0x09b1;
    L_0x09a3:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_card:cancel";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x09b1:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_card:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x09bf:
        r2 = 36;
        r0 = r26;
        if (r0 != r2) goto L_0x0a2b;
    L_0x09c5:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request choose invoice, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = -1;
        r0 = r27;
        if (r0 != r3) goto L_0x0a0d;
    L_0x09e7:
        if (r28 == 0) goto L_0x09ff;
    L_0x09e9:
        r3 = "choose_invoice_info";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r3, r4);
        r4 = "choose_invoice_info";
        r2.put(r4, r3);
    L_0x09ff:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_invoice:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x0a0d:
        if (r27 != 0) goto L_0x0a1d;
    L_0x0a0f:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_invoice:cancel";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x0a1d:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "choose_invoice:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x0a2b:
        r2 = 16;
        r0 = r26;
        if (r0 != r2) goto L_0x0aa5;
    L_0x0a31:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request batch add card, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r3 = new java.util.HashMap;
        r3.<init>();
        if (r28 == 0) goto L_0x0a66;
    L_0x0a50:
        r2 = "card_list";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r4 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r4);
        r4 = "card_list";
        r3.put(r4, r2);
    L_0x0a66:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0a79;
    L_0x0a6b:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "batch_add_card:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0a79:
        r2 = 2;
        if (r28 == 0) goto L_0x0a86;
    L_0x0a7c:
        r2 = "result_code";
        r4 = 2;
        r0 = r28;
        r2 = r0.getIntExtra(r2, r4);
    L_0x0a86:
        r4 = 2;
        if (r2 != r4) goto L_0x0a97;
    L_0x0a89:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "batch_add_card:fail";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0a97:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "batch_add_card:cancel";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0aa5:
        r2 = 23;
        r0 = r26;
        if (r0 != r2) goto L_0x0ace;
    L_0x0aab:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x0abf;
    L_0x0ab0:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "batch_view_card:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0abf:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "batch_view_card:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0ace:
        r2 = 15;
        r0 = r26;
        if (r0 != r2) goto L_0x0b61;
    L_0x0ad4:
        r0 = r25;
        r2 = r0.tNN;
        if (r2 == 0) goto L_0x0ae6;
    L_0x0ada:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.tQg;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x0af1;
    L_0x0ae6:
        r2 = "MicroMsg.MsgHandler";
        r3 = "msg is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x0046;
    L_0x0af1:
        r2 = "MicroMsg.MsgHandler";
        r3 = "request to scan qr code, result code = %d, function is %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        r5 = 1;
        r0 = r25;
        r6 = r0.tNN;
        r6 = r6.tQg;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.tQg;
        r3 = "scanQRCode";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0046;
    L_0x0b1c:
        switch(r27) {
            case -1: goto L_0x0b2e;
            case 0: goto L_0x0b52;
            default: goto L_0x0b1f;
        };
    L_0x0b1f:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "scanQRCode:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0b2e:
        r2 = new java.util.HashMap;
        r2.<init>();
        if (r28 == 0) goto L_0x0b44;
    L_0x0b35:
        r3 = "resultStr";
        r4 = "key_scan_result";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        r2.put(r3, r4);
    L_0x0b44:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "scanQRCode:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x0b52:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "scanQRCode:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0b61:
        r2 = 14;
        r0 = r26;
        if (r0 != r2) goto L_0x0c03;
    L_0x0b67:
        if (r28 != 0) goto L_0x0ba7;
    L_0x0b69:
        r2 = 0;
    L_0x0b6a:
        r3 = "MicroMsg.MsgHandler";
        r4 = "request to open file chooser, result code = %d, hasShowMemoryWarning = %b";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r27);
        r5[r6] = r7;
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r2);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = new java.util.HashMap;
        r3.<init>();
        if (r2 == 0) goto L_0x0b96;
    L_0x0b8b:
        r2 = "memoryWarning";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r3.put(r2, r4);
    L_0x0b96:
        switch(r27) {
            case -1: goto L_0x0bb2;
            case 0: goto L_0x0bf5;
            default: goto L_0x0b99;
        };
    L_0x0b99:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "chooseImage:fail";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0ba7:
        r2 = "key_pick_local_media_show_memory_warning";
        r3 = 0;
        r0 = r28;
        r2 = r0.getBooleanExtra(r2, r3);
        goto L_0x0b6a;
    L_0x0bb2:
        r2 = "key_pick_local_pic_callback_local_ids";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r4 = "MicroMsg.MsgHandler";
        r5 = "localIds = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r4 != 0) goto L_0x0b99;
    L_0x0bd0:
        r4 = "localIds";
        r3.put(r4, r2);
        r2 = "key_pick_local_pic_source_type";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        if (r2 == 0) goto L_0x0be7;
    L_0x0be1:
        r4 = "sourceType";
        r3.put(r4, r2);
    L_0x0be7:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "chooseImage:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0bf5:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "chooseImage:cancel";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0c03:
        r2 = 32;
        r0 = r26;
        if (r0 != r2) goto L_0x0ca1;
    L_0x0c09:
        switch(r27) {
            case -1: goto L_0x0c2a;
            case 0: goto L_0x0c1b;
            default: goto L_0x0c0c;
        };
    L_0x0c0c:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseVideo:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0c1b:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseVideo:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0c2a:
        r2 = "key_pick_local_media_local_id";
        r0 = r28;
        r3 = r0.getStringExtra(r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r2 != 0) goto L_0x0c92;
    L_0x0c39:
        r2 = com.tencent.mm.plugin.webview.modeltools.f.bSo();
        r2 = r2.OS(r3);
        if (r2 == 0) goto L_0x0c92;
    L_0x0c43:
        r4 = r2 instanceof com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
        if (r4 == 0) goto L_0x0c92;
    L_0x0c47:
        r2 = (com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem) r2;
        r4 = new java.util.HashMap;
        r4.<init>();
        r5 = "localId";
        r4.put(r5, r3);
        r3 = "duration";
        r5 = r2.duration;
        r5 = java.lang.Integer.valueOf(r5);
        r4.put(r3, r5);
        r3 = "height";
        r5 = r2.height;
        r5 = java.lang.Integer.valueOf(r5);
        r4.put(r3, r5);
        r3 = "size";
        r5 = r2.size;
        r5 = java.lang.Integer.valueOf(r5);
        r4.put(r3, r5);
        r3 = "width";
        r2 = r2.width;
        r2 = java.lang.Integer.valueOf(r2);
        r4.put(r3, r2);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseVideo:ok";
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0c92:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseVideo:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0ca1:
        r2 = 45;
        r0 = r26;
        if (r0 != r2) goto L_0x0d6c;
    L_0x0ca7:
        switch(r27) {
            case -1: goto L_0x0cc8;
            case 0: goto L_0x0cb9;
            default: goto L_0x0caa;
        };
    L_0x0caa:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0cb9:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0cc8:
        r2 = "key_pick_local_media_local_id";
        r0 = r28;
        r3 = r0.getStringExtra(r2);
        r2 = "key_pick_local_media_thumb_local_id";
        r0 = r28;
        r4 = r0.getStringExtra(r2);
        r2 = "MicroMsg.MsgHandler";
        r5 = "localId:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);
        r2 = "MicroMsg.MsgHandler";
        r5 = "thumbLocalId:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r2 != 0) goto L_0x0d5d;
    L_0x0cfe:
        r2 = com.tencent.mm.plugin.webview.modeltools.f.bSo();
        r2 = r2.OS(r3);
        if (r2 == 0) goto L_0x0d5d;
    L_0x0d08:
        r5 = r2 instanceof com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
        if (r5 == 0) goto L_0x0d5d;
    L_0x0d0c:
        r2 = (com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem) r2;
        r5 = new java.util.HashMap;
        r5.<init>();
        r6 = "localId";
        r5.put(r6, r3);
        r3 = "duration";
        r6 = r2.duration;
        r6 = java.lang.Integer.valueOf(r6);
        r5.put(r3, r6);
        r3 = "height";
        r6 = r2.height;
        r6 = java.lang.Integer.valueOf(r6);
        r5.put(r3, r6);
        r3 = "size";
        r6 = r2.size;
        r6 = java.lang.Integer.valueOf(r6);
        r5.put(r3, r6);
        r3 = "width";
        r2 = r2.width;
        r2 = java.lang.Integer.valueOf(r2);
        r5.put(r3, r2);
        r2 = "thumbLocalId";
        r5.put(r2, r4);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:ok";
        r0 = r25;
        r0.a(r2, r3, r5);
        goto L_0x0046;
    L_0x0d5d:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0d6c:
        r2 = 47;
        r0 = r26;
        if (r0 != r2) goto L_0x0eef;
    L_0x0d72:
        switch(r27) {
            case -1: goto L_0x0d93;
            case 0: goto L_0x0d84;
            default: goto L_0x0d75;
        };
    L_0x0d75:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0d84:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0d93:
        if (r28 != 0) goto L_0x0dad;
    L_0x0d95:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0dad:
        r2 = "key_pick_local_media_callback_type";
        r3 = 0;
        r0 = r28;
        r2 = r0.getIntExtra(r2, r3);
        r3 = 1;
        if (r2 != r3) goto L_0x0e70;
    L_0x0dba:
        r2 = "key_pick_local_media_local_id";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "key_pick_local_media_thumb_local_id";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "MicroMsg.MsgHandler";
        r5 = "video localId:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = "MicroMsg.MsgHandler";
        r5 = "video thumbLocalId:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r4 == 0) goto L_0x0e08;
    L_0x0df0:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0e08:
        r4 = com.tencent.mm.plugin.webview.modeltools.f.bSo();
        r4 = r4.OS(r2);
        if (r4 == 0) goto L_0x0e58;
    L_0x0e12:
        r5 = r4 instanceof com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
        if (r5 == 0) goto L_0x0e58;
    L_0x0e16:
        r7 = r4;
        r7 = (com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem) r7;
        r4 = r7.duration;
        r5 = r7.height;
        r6 = r7.width;
        r7 = r7.size;
        r2 = com.tencent.mm.plugin.webview.model.ai.b(r2, r3, r4, r5, r6, r7);
        r3 = "MicroMsg.MsgHandler";
        r4 = "after parse to json data : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "type";
        r5 = 1;
        r5 = java.lang.Integer.valueOf(r5);
        r3.put(r4, r5);
        r4 = "localIds";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "chooseMedia:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0e58:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0e70:
        r3 = 2;
        if (r2 != r3) goto L_0x0ecd;
    L_0x0e73:
        r2 = "key_pick_local_media_local_ids";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "MicroMsg.MsgHandler";
        r4 = "chooseMedia localIds:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r3 == 0) goto L_0x0ea9;
    L_0x0e91:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0ea9:
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "type";
        r5 = 2;
        r5 = java.lang.Integer.valueOf(r5);
        r3.put(r4, r5);
        r4 = "localIds";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "chooseMedia:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x0ecd:
        r3 = "MicroMsg.MsgHandler";
        r4 = "type:%d is error";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0eef:
        r2 = 46;
        r0 = r26;
        if (r0 != r2) goto L_0x0f25;
    L_0x0ef5:
        switch(r27) {
            case -1: goto L_0x0f16;
            case 0: goto L_0x0f07;
            default: goto L_0x0ef8;
        };
    L_0x0ef8:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "previewVideo:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0f07:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "previewVideo:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0f16:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "previewVideo:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0f25:
        r2 = 19;
        r0 = r26;
        if (r0 != r2) goto L_0x0f91;
    L_0x0f2b:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request to config exdevice wifi connection, result code = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        switch(r27) {
            case -1: goto L_0x0f48;
            case 0: goto L_0x0f57;
            case 1: goto L_0x0f82;
            default: goto L_0x0f46;
        };
    L_0x0f46:
        goto L_0x0046;
    L_0x0f48:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "configWXDeviceWiFi:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0f57:
        r2 = 0;
        if (r28 == 0) goto L_0x0f74;
    L_0x0f5a:
        r3 = "is_wifi_connected";
        r4 = 1;
        r0 = r28;
        r3 = r0.getBooleanExtra(r3, r4);
        if (r3 != 0) goto L_0x0f74;
    L_0x0f66:
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "desc";
        r4 = "wifi_not_connected";
        r2.put(r3, r4);
    L_0x0f74:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "configWXDeviceWiFi:cancel";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x0f82:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "configWXDeviceWiFi:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x0f91:
        r2 = 20;
        r0 = r26;
        if (r0 != r2) goto L_0x1079;
    L_0x0f97:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request request_verify_wcpay_password, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r3 = new java.util.HashMap;
        r3.<init>();
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1045;
    L_0x0fb9:
        r2 = "";
        if (r28 == 0) goto L_0x0fce;
    L_0x0fbe:
        r2 = "token";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r4 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r4);
    L_0x0fce:
        r4 = android.text.TextUtils.isEmpty(r2);
        if (r4 != 0) goto L_0x1011;
    L_0x0fd4:
        r4 = "token";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "verifyWCPayPassword:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "verifyWCPayPassword:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
        r2 = "MicroMsg.MsgHandler";
        r3 = "checkPwdToken is valid, verifyWCPayPassword:ok";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
    L_0x1006:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x100c:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x1011:
        r2 = "MicroMsg.MsgHandler";
        r3 = "checkPwdToken is empty, verifyWCPayPassword:fail";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "verifyWCPayPassword:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x1006;
    L_0x102d:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "verifyWCPayPassword:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x1006;
    L_0x1045:
        r2 = "MicroMsg.MsgHandler";
        r3 = "resultCode is canlcel, verifyWCPayPassword:fail";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "verifyWCPayPassword:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x1006;
    L_0x1061:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "verifyWCPayPassword:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x1006;
    L_0x1079:
        r2 = 21;
        r0 = r26;
        if (r2 != r0) goto L_0x1097;
    L_0x107f:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: callback to see order. directly finish";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "see_order_ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1097:
        r2 = 22;
        r0 = r26;
        if (r0 != r2) goto L_0x10e9;
    L_0x109d:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request get_recevie_biz_hongbao_request, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x10c9;
    L_0x10ba:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_recevie_biz_hongbao_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x10c9:
        if (r26 != 0) goto L_0x10da;
    L_0x10cb:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_recevie_biz_hongbao_request:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x10da:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_recevie_biz_hongbao_request:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x10e9:
        r2 = 24;
        r0 = r26;
        if (r0 != r2) goto L_0x11b5;
    L_0x10ef:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x119f;
    L_0x10f4:
        r2 = 2;
        r3 = 1;
        r0 = r25;
        r0.ep(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "open_from_scene";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r3);
        r3 = 4;
        if (r2 != r3) goto L_0x1134;
    L_0x1112:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 10651; // 0x299b float:1.4925E-41 double:5.2623E-320;
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = 5;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x1134:
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x118e }
        if (r2 == 0) goto L_0x117f;	 Catch:{ RemoteException -> 0x118e }
    L_0x113a:
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r2 = r0.tNN;	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.pug;	 Catch:{ RemoteException -> 0x118e }
        r3 = "appId";	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.get(r3);	 Catch:{ RemoteException -> 0x118e }
        r2 = (java.lang.String) r2;	 Catch:{ RemoteException -> 0x118e }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x118e }
        if (r3 == 0) goto L_0x2583;	 Catch:{ RemoteException -> 0x118e }
    L_0x114f:
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r2 = r0.tNN;	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.pug;	 Catch:{ RemoteException -> 0x118e }
        r3 = "appid";	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.get(r3);	 Catch:{ RemoteException -> 0x118e }
        r2 = (java.lang.String) r2;	 Catch:{ RemoteException -> 0x118e }
        r3 = r2;	 Catch:{ RemoteException -> 0x118e }
    L_0x115f:
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r2 = r0.tNN;	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.pug;	 Catch:{ RemoteException -> 0x118e }
        r4 = "img_url";	 Catch:{ RemoteException -> 0x118e }
        r2 = r2.get(r4);	 Catch:{ RemoteException -> 0x118e }
        r2 = (java.lang.String) r2;	 Catch:{ RemoteException -> 0x118e }
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r4 = r0.fCC;	 Catch:{ RemoteException -> 0x118e }
        r5 = 85;	 Catch:{ RemoteException -> 0x118e }
        r6 = 0;	 Catch:{ RemoteException -> 0x118e }
        r4 = r4.e(r5, r6);	 Catch:{ RemoteException -> 0x118e }
        r5 = 1;	 Catch:{ RemoteException -> 0x118e }
        r0 = r25;	 Catch:{ RemoteException -> 0x118e }
        r0.a(r3, r2, r5, r4);	 Catch:{ RemoteException -> 0x118e }
    L_0x117f:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "share_timeline:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x118e:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = "invokeAsResult : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        goto L_0x117f;
    L_0x119f:
        r2 = 2;
        r3 = 3;
        r0 = r25;
        r0.ep(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "share_timeline:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x11b5:
        r2 = 26;
        r0 = r26;
        if (r0 != r2) goto L_0x1219;
    L_0x11bb:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "select pedometer source resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x11e7;
    L_0x11d8:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectPedometerSource:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x11e7:
        if (r27 != 0) goto L_0x1201;
    L_0x11e9:
        r2 = "MicroMsg.MsgHandler";
        r3 = "selectPedometerSource result cancel";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectPedometerSource:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1201:
        r2 = "MicroMsg.MsgHandler";
        r3 = "selectPedometerSource result fail";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectPedometerSource:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1219:
        r2 = 25;
        r0 = r26;
        if (r0 != r2) goto L_0x127f;
    L_0x121f:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: get ibg order finish. result code: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1271;
    L_0x1237:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_h5_transaction_request:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
    L_0x1244:
        r0 = r25;
        r2 = r0.tOe;
        r3 = 1;
        if (r2 != r3) goto L_0x0046;
    L_0x124b:
        r0 = r25;
        r2 = r0.fCC;
        if (r2 == 0) goto L_0x0046;
    L_0x1251:
        r0 = r25;	 Catch:{ RemoteException -> 0x1262 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1262 }
        r2.bSB();	 Catch:{ RemoteException -> 0x1262 }
        r0 = r25;	 Catch:{ RemoteException -> 0x1262 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1262 }
        r3 = 0;	 Catch:{ RemoteException -> 0x1262 }
        r2.O(r3);	 Catch:{ RemoteException -> 0x1262 }
        goto L_0x0046;
    L_0x1262:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0046;
    L_0x1271:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_h5_transaction_request:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x1244;
    L_0x127f:
        r2 = 28;
        r0 = r26;
        if (r0 != r2) goto L_0x1327;
    L_0x1285:
        r2 = "MicroMsg.MsgHandler";
        r3 = "get web pay checkout counter request finish. result code: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x12fc;
    L_0x129d:
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "token";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r3, r4);
        r4 = "bind_serial";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        r5 = "";
        r4 = com.tencent.mm.sdk.platformtools.bi.aD(r4, r5);
        r5 = "token";
        r2.put(r5, r3);
        r3 = "bind_serial";
        r2.put(r3, r4);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "getWebPayCheckoutCounterRequst:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "getWebPayCheckoutCounterRequst:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x12f1:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x12f7:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x12fc:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "getWebPayCheckoutCounterRequst:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x12f1;
    L_0x130f:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "getWebPayCheckoutCounterRequst:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x12f1;
    L_0x1327:
        r2 = 31;
        r0 = r26;
        if (r0 != r2) goto L_0x137b;
    L_0x132d:
        r2 = -1;
        r0 = r27;
        if (r0 == r2) goto L_0x1341;
    L_0x1332:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "openEnterpriseContact:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1341:
        r2 = "result_data";
        r0 = r28;
        r2 = r0.getBundleExtra(r2);
        if (r2 == 0) goto L_0x136c;
    L_0x134c:
        r3 = "result";
        r2 = r2.getString(r3);
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "result";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "openEnterpriseContact:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x136c:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "openEnterpriseContact:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x137b:
        r2 = 53;
        r0 = r26;
        if (r0 != r2) goto L_0x13cf;
    L_0x1381:
        r2 = -1;
        r0 = r27;
        if (r0 == r2) goto L_0x1395;
    L_0x1386:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectEnterpriseContact:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1395:
        r2 = "result_data";
        r0 = r28;
        r2 = r0.getBundleExtra(r2);
        if (r2 == 0) goto L_0x13c0;
    L_0x13a0:
        r3 = "result";
        r2 = r2.getString(r3);
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "result";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "selectEnterpriseContact:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x13c0:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectEnterpriseContact:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x13cf:
        r2 = 29;
        r0 = r26;
        if (r0 != r2) goto L_0x1413;
    L_0x13d5:
        r3 = "MicroMsg.MsgHandler";
        r4 = "consumedShareCard:ok(r : %b)";
        r2 = 1;
        r5 = new java.lang.Object[r2];
        r6 = 0;
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1402;
    L_0x13e4:
        r2 = 1;
    L_0x13e5:
        r2 = java.lang.Boolean.valueOf(r2);
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1404;
    L_0x13f3:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "consumedShareCard:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1402:
        r2 = 0;
        goto L_0x13e5;
    L_0x1404:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "consumedShareCard:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1413:
        r2 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x1438;
    L_0x1419:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1429;
    L_0x141e:
        r0 = r25;
        r2 = r0.tNN;
        r0 = r25;
        r0.P(r2);
        goto L_0x0046;
    L_0x1429:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseImage:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1438:
        r2 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x145d;
    L_0x143e:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x144e;
    L_0x1443:
        r0 = r25;
        r2 = r0.tNN;
        r0 = r25;
        r0.W(r2);
        goto L_0x0046;
    L_0x144e:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "startRecord:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x145d:
        r2 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x1483;
    L_0x1463:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1474;
    L_0x1468:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 0;
        r0 = r25;
        r0.a(r2, r3);
        goto L_0x0046;
    L_0x1474:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseVideo:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1483:
        r2 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x14a9;
    L_0x1489:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x149a;
    L_0x148e:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 1;
        r0 = r25;
        r0.a(r2, r3);
        goto L_0x0046;
    L_0x149a:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x14a9:
        r2 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x14cf;
    L_0x14af:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x14c0;
    L_0x14b4:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 1;
        r0 = r25;
        r0.a(r2, r3);
        goto L_0x0046;
    L_0x14c0:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "recordVideo:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x14cf:
        r2 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x14fd;
    L_0x14d5:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x14e5;
    L_0x14da:
        r0 = r25;
        r2 = r0.tNN;
        r0 = r25;
        r0.T(r2);
        goto L_0x0046;
    L_0x14e5:
        r2 = "MicroMsg.MsgHandler";
        r3 = "chooseMedia:fail_android_permission_denied:CAMERA";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x14fd:
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0 = r26;
        if (r0 != r2) goto L_0x152b;
    L_0x1503:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1513;
    L_0x1508:
        r0 = r25;
        r2 = r0.tNN;
        r0 = r25;
        r0.T(r2);
        goto L_0x0046;
    L_0x1513:
        r2 = "MicroMsg.MsgHandler";
        r3 = "chooseMedia:fail_android_permission_denied:MICROPHONE";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseMedia:fail_android_permission_denied";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x152b:
        r2 = 30;
        r0 = r26;
        if (r0 != r2) goto L_0x166d;
    L_0x1531:
        r2 = "MicroMsg.MsgHandler";
        r3 = "doSelectSingleContact activtiy callback";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "appId";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r25;
        r3 = r0.tNQ;
        if (r3 == 0) goto L_0x2580;
    L_0x154f:
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x2580;
    L_0x1555:
        r0 = r25;
        r2 = r0.tNQ;
        r3 = "jsapi_args_appid";
        r2 = r2.getString(r3);
        r3 = r2;
    L_0x1561:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r4 = "selectMode";
        r2 = r2.get(r4);
        r2 = (java.lang.String) r2;
        r4 = 0;
        r5 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r4);
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r4 = "busiId";
        r2 = r2.get(r4);
        r2 = (java.lang.String) r2;
        r4 = "MicroMsg.MsgHandler";
        r6 = "select single contact : appId:%s, busiId:%s, selectedMode:%d";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r3;
        r8 = 1;
        r7[r8] = r2;
        r8 = 2;
        r9 = java.lang.Integer.valueOf(r5);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        switch(r27) {
            case -1: goto L_0x15a2;
            case 0: goto L_0x15c5;
            default: goto L_0x15a0;
        };
    L_0x15a0:
        goto L_0x0046;
    L_0x15a2:
        if (r28 != 0) goto L_0x15d4;
    L_0x15a4:
        r4 = 0;
    L_0x15a5:
        if (r4 == 0) goto L_0x15ad;
    L_0x15a7:
        r6 = r4.length();
        if (r6 != 0) goto L_0x15de;
    L_0x15ad:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult,selectSingleContact fail, user is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectSingleContact:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x15c5:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectSingleContact:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x15d4:
        r4 = "Select_Conv_User";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        goto L_0x15a5;
    L_0x15de:
        if (r5 != 0) goto L_0x1625;
    L_0x15e0:
        r2 = new com.tencent.mm.plugin.webview.model.k;
        r2.<init>(r3, r4);
        r3 = com.tencent.mm.y.as.CN();
        r4 = 1566; // 0x61e float:2.194E-42 double:7.737E-321;
        r5 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$7;
        r0 = r25;
        r5.<init>();
        r3.a(r4, r5);
        r3 = com.tencent.mm.y.as.CN();
        r3.d(r2);
        r0 = r25;
        r3 = r0.context;
        r0 = r25;
        r4 = r0.context;
        r5 = com.tencent.mm.R.l.dGZ;
        r4.getString(r5);
        r0 = r25;
        r4 = r0.context;
        r5 = com.tencent.mm.R.l.dHn;
        r4 = r4.getString(r5);
        r5 = 1;
        r6 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$8;
        r0 = r25;
        r6.<init>(r2);
        r2 = com.tencent.mm.ui.base.h.a(r3, r4, r5, r6);
        r0 = r25;
        r0.inI = r2;
        goto L_0x0046;
    L_0x1625:
        r6 = 1;
        if (r5 != r6) goto L_0x0046;
    L_0x1628:
        r5 = new com.tencent.mm.plugin.webview.model.q;
        r5.<init>(r3, r2, r4);
        r2 = com.tencent.mm.y.as.CN();
        r3 = 1177; // 0x499 float:1.65E-42 double:5.815E-321;
        r4 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$9;
        r0 = r25;
        r4.<init>();
        r2.a(r3, r4);
        r2 = com.tencent.mm.y.as.CN();
        r2.d(r5);
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r4 = com.tencent.mm.R.l.dGZ;
        r3.getString(r4);
        r0 = r25;
        r3 = r0.context;
        r4 = com.tencent.mm.R.l.dHn;
        r3 = r3.getString(r4);
        r4 = 1;
        r6 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$10;
        r0 = r25;
        r6.<init>(r5);
        r2 = com.tencent.mm.ui.base.h.a(r2, r3, r4, r6);
        r0 = r25;
        r0.inI = r2;
        goto L_0x0046;
    L_0x166d:
        r2 = 34;
        r0 = r26;
        if (r0 != r2) goto L_0x16fc;
    L_0x1673:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x16a7;
    L_0x1678:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_wcpay_realname_verify:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_wcpay_realname_verify:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x169c:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x16a2:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x16a7:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x16d7;
    L_0x16ac:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_wcpay_realname_verify:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x169c;
    L_0x16bf:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_wcpay_realname_verify:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x169c;
    L_0x16d7:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get_wcpay_realname_verify:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "get_wcpay_realname_verify:cancel";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x169c;
    L_0x16fc:
        r2 = 35;
        r0 = r26;
        if (r0 != r2) goto L_0x1748;
    L_0x1702:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1739;
    L_0x1707:
        r2 = new com.tencent.mm.f.a.nm;
        r2.<init>();
        r3 = r2.fGp;
        r0 = r25;
        r4 = r0.context;
        r3.context = r4;
        r3 = com.tencent.mm.sdk.b.a.xmy;
        r3.m(r2);
        r0 = r25;	 Catch:{ RemoteException -> 0x172a }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x172a }
        r2.bSB();	 Catch:{ RemoteException -> 0x172a }
        r0 = r25;	 Catch:{ RemoteException -> 0x172a }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x172a }
        r3 = 0;	 Catch:{ RemoteException -> 0x172a }
        r2.O(r3);	 Catch:{ RemoteException -> 0x172a }
        goto L_0x0046;
    L_0x172a:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0046;
    L_0x1739:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "selectWalletCurrency:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1748:
        r2 = 37;
        r0 = r26;
        if (r0 != r2) goto L_0x191a;
    L_0x174e:
        r0 = r25;
        r2 = r0.fzX;
        if (r2 != 0) goto L_0x176c;
    L_0x1754:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, appmsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x176c:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "appid";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = 0;
        r0 = r25;
        r4 = r0.tNQ;
        if (r4 == 0) goto L_0x257d;
    L_0x1782:
        r0 = r25;
        r3 = r0.tNQ;
        r4 = "KSnsAdTag";
        r3 = r3.getParcelable(r4);
        r3 = (com.tencent.mm.modelsns.SnsAdClick) r3;
        r4 = android.text.TextUtils.isEmpty(r2);
        if (r4 == 0) goto L_0x257d;
    L_0x1795:
        r0 = r25;
        r2 = r0.tNQ;
        r4 = "jsapi_args_appid";
        r2 = r2.getString(r4);
        r4 = r2;
    L_0x17a1:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.bVA();
        r5 = "Internal@AsyncReport";
        r2 = r2.get(r5);
        switch(r27) {
            case -1: goto L_0x17b5;
            case 0: goto L_0x17fe;
            default: goto L_0x17b3;
        };
    L_0x17b3:
        goto L_0x0046;
    L_0x17b5:
        if (r3 == 0) goto L_0x17bb;
    L_0x17b7:
        r5 = 7;
        r3.iw(r5);
    L_0x17bb:
        r3 = com.tencent.mm.pluginsdk.model.app.g.HL(r4);
        if (r28 == 0) goto L_0x0046;
    L_0x17c1:
        r5 = "enterprise_biz_name";
        r0 = r28;
        r5 = r0.getStringExtra(r5);
        r6 = "key_biz_chat_id";
        r8 = -1;
        r0 = r28;
        r14 = r0.getLongExtra(r6, r8);
        r6 = "enterprise_share_append_text";
        r0 = r28;
        r9 = r0.getStringExtra(r6);
        if (r5 == 0) goto L_0x17e6;
    L_0x17e0:
        r6 = r5.length();
        if (r6 != 0) goto L_0x1841;
    L_0x17e6:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, toUser is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x17fe:
        if (r3 == 0) goto L_0x1805;
    L_0x1800:
        r5 = 8;
        r3.iw(r5);
    L_0x1805:
        r0 = r25;
        r3 = r0.tNN;
        r3 = r3.bVA();
        r5 = "sendAppMessage";
        r0 = r25;
        r5 = r0.Qn(r5);
        r6 = 0;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a(r3, r5, r6, r4);
        if (r2 == 0) goto L_0x1832;
    L_0x181c:
        r3 = r2 instanceof java.lang.Boolean;
        if (r3 == 0) goto L_0x1832;
    L_0x1820:
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x1832;
    L_0x1828:
        r0 = r25;
        r2 = r0.tNN;
        r3 = 1;
        r0 = r25;
        r0.b(r2, r3);
    L_0x1832:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1841:
        r0 = r25;
        r6 = r0.tNN;
        r6 = r6.pug;
        r7 = "img_url";
        r6 = r6.get(r7);
        r6 = (java.lang.String) r6;
        r0 = r25;
        r7 = r0.tNN;
        r7 = r7.pug;
        r8 = "desc";
        r7.get(r8);
        r0 = r25;
        r7 = r0.tNN;
        r7 = r7.pug;
        r8 = "src_username";
        r7 = r7.get(r8);
        r7 = (java.lang.String) r7;
        r0 = r25;
        r8 = r0.tNN;
        r8 = r8.pug;
        r10 = "src_displayname";
        r8 = r8.get(r10);
        r8 = (java.lang.String) r8;
        r10 = r25.bVk();
        r0 = r25;
        r11 = r0.tNN;
        r11 = r11.bVA();
        r12 = "sendAppMessage";
        r0 = r25;
        r12 = r0.Qn(r12);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a(r11, r12, r5, r4);
        if (r2 == 0) goto L_0x18aa;
    L_0x1894:
        r11 = r2 instanceof java.lang.Boolean;
        if (r11 == 0) goto L_0x18aa;
    L_0x1898:
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x18aa;
    L_0x18a0:
        r0 = r25;
        r2 = r0.tNN;
        r11 = 1;
        r0 = r25;
        r0.b(r2, r11);
    L_0x18aa:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r2 == 0) goto L_0x18fa;
    L_0x18b0:
        r12 = 0;
        r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r2 < 0) goto L_0x18f4;
    L_0x18b6:
        r2 = com.tencent.mm.af.y.Mn();
        r2 = r2.ag(r14);
        r11 = com.tencent.mm.af.a.e.hsB;
        monitor-enter(r11);
        r12 = com.tencent.mm.af.a.e.HJ();	 Catch:{ all -> 0x18f1 }
        com.tencent.mm.af.a.e.d(r2);	 Catch:{ all -> 0x18f1 }
        r2 = r25;	 Catch:{ all -> 0x18f1 }
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x18f1 }
        com.tencent.mm.af.a.e.kv(r12);	 Catch:{ all -> 0x18f1 }
        monitor-exit(r11);	 Catch:{ all -> 0x18f1 }
    L_0x18d1:
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r3 = r0.context;
        r4 = com.tencent.mm.R.l.dUo;
        r3 = r3.getString(r4);
        com.tencent.mm.ui.base.h.br(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "send_app_msg:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x18f1:
        r2 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x18f1 }
        throw r2;
    L_0x18f4:
        r2 = r25;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x18d1;
    L_0x18fa:
        r2 = com.tencent.mm.ap.o.PB();
        r12 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$11;
        r13 = r25;
        r16 = r3;
        r17 = r4;
        r18 = r5;
        r19 = r6;
        r20 = r7;
        r21 = r8;
        r22 = r9;
        r23 = r10;
        r12.<init>(r14, r16, r17, r18, r19, r20, r21, r22, r23);
        r2.a(r6, r12);
        goto L_0x0046;
    L_0x191a:
        r2 = 38;
        r0 = r26;
        if (r0 != r2) goto L_0x1987;
    L_0x1920:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1944;
    L_0x1925:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: soter auth ok";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = r28.getExtras();
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "soter_biometric_authentication:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1944:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1968;
    L_0x1949:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: soter auth failed";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "soter_biometric_authentication:fail";
        r4 = r28.getExtras();
        r4 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r4);
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1968:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: soter user cancelled";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "soter_biometric_authentication:cancel";
        r4 = r28.getExtras();
        r4 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r4);
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1987:
        r2 = 39;
        r0 = r26;
        if (r0 != r2) goto L_0x19c8;
    L_0x198d:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x19a7;
    L_0x1992:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "unbind_bank_card:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
    L_0x199f:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x19a5:
        goto L_0x0046;
    L_0x19a7:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x19ba;
    L_0x19ac:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "unbind_bank_card:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x199f;
    L_0x19ba:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "unbind_bank_card:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x199f;
    L_0x19c8:
        r2 = 40;
        r0 = r26;
        if (r0 != r2) goto L_0x1af8;
    L_0x19ce:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1ae9;
    L_0x19d3:
        r4 = new android.os.Bundle;
        r4.<init>();
        if (r28 == 0) goto L_0x1ada;
    L_0x19da:
        r2 = "k_outside_expose_proof_item_list";
        r0 = r28;
        r2 = r0.getLongArrayExtra(r2);
        r5 = com.tencent.mm.be.a.b(r2);
        r6 = r5.size();
        r7 = new java.lang.String[r6];
        r8 = new java.lang.String[r6];
        r9 = new java.lang.String[r6];
        r10 = new int[r6];
        r11 = new int[r6];
        r2 = 0;
        r3 = r2;
    L_0x19f7:
        if (r3 >= r6) goto L_0x1a74;
    L_0x19f9:
        r2 = r5.get(r3);
        r2 = (com.tencent.mm.storage.au) r2;
        r12 = r2.wh();
        r12 = java.lang.String.valueOf(r12);
        r7[r3] = r12;
        r12 = "k_is_group_chat";
        r13 = 0;
        r0 = r28;
        r12 = r0.getBooleanExtra(r12, r13);
        if (r12 == 0) goto L_0x1a60;
    L_0x1a15:
        r12 = r2.wl();
        r12 = com.tencent.mm.y.bb.hT(r12);
        r8[r3] = r12;
        r12 = r2.wl();
        r12 = com.tencent.mm.y.bb.hS(r12);
        r9[r3] = r12;
    L_0x1a29:
        r12 = r2.wi();
        r13 = 1;
        if (r12 != r13) goto L_0x1a36;
    L_0x1a30:
        r12 = com.tencent.mm.y.q.FY();
        r9[r3] = r12;
    L_0x1a36:
        r12 = r8[r3];
        if (r12 != 0) goto L_0x1a3f;
    L_0x1a3a:
        r12 = "";
        r8[r3] = r12;
    L_0x1a3f:
        r12 = r9[r3];
        if (r12 != 0) goto L_0x1a48;
    L_0x1a43:
        r12 = "";
        r9[r3] = r12;
    L_0x1a48:
        r12 = r2.aNJ();
        if (r12 == 0) goto L_0x1a6d;
    L_0x1a4e:
        r12 = 49;
        r10[r3] = r12;
    L_0x1a52:
        r12 = r2.wj();
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r2 = (int) r12;
        r11[r3] = r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x19f7;
    L_0x1a60:
        r12 = r2.wl();
        r8[r3] = r12;
        r12 = r2.wk();
        r9[r3] = r12;
        goto L_0x1a29;
    L_0x1a6d:
        r12 = r2.getType();
        r10[r3] = r12;
        goto L_0x1a52;
    L_0x1a74:
        r2 = "msgIds";
        r4.putStringArray(r2, r7);
        r2 = "contents";
        r4.putStringArray(r2, r8);
        r2 = "senders";
        r4.putStringArray(r2, r9);
        r2 = "msgTypes";
        r4.putIntArray(r2, r10);
        r2 = "msgTimes";
        r4.putIntArray(r2, r11);
        r0 = r25;	 Catch:{ RemoteException -> 0x1ab0 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1ab0 }
        if (r2 == 0) goto L_0x1aa1;	 Catch:{ RemoteException -> 0x1ab0 }
    L_0x1a98:
        r0 = r25;	 Catch:{ RemoteException -> 0x1ab0 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1ab0 }
        r3 = 48;	 Catch:{ RemoteException -> 0x1ab0 }
        r2.n(r3, r4);	 Catch:{ RemoteException -> 0x1ab0 }
    L_0x1aa1:
        r0 = r25;	 Catch:{ RemoteException -> 0x1ab0 }
        r2 = r0.tNN;	 Catch:{ RemoteException -> 0x1ab0 }
        r3 = "select chat record:ok";	 Catch:{ RemoteException -> 0x1ab0 }
        r4 = 0;	 Catch:{ RemoteException -> 0x1ab0 }
        r0 = r25;	 Catch:{ RemoteException -> 0x1ab0 }
        r0.a(r2, r3, r4);	 Catch:{ RemoteException -> 0x1ab0 }
        goto L_0x0046;
    L_0x1ab0:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = new java.lang.StringBuilder;
        r5 = "onGetMsgProofItems exception";
        r4.<init>(r5);
        r2 = r2.getMessage();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.w(r3, r2);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "select chat record:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1ada:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "select chat record:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1ae9:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "select chat record:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1af8:
        r2 = 41;
        r0 = r26;
        if (r0 != r2) goto L_0x1b87;
    L_0x1afe:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1b32;
    L_0x1b03:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "id_card_realname_verify:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "id_card_realname_verify:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x1b27:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x1b2d:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x1b32:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1b62;
    L_0x1b37:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "id_card_realname_verify:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x1b27;
    L_0x1b4a:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "id_card_realname_verify:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x1b27;
    L_0x1b62:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "id_card_realname_verify:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "id_card_realname_verify:cancel";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x1b27;
    L_0x1b87:
        r2 = 42;
        r0 = r26;
        if (r0 != r2) goto L_0x1bef;
    L_0x1b8d:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1bcc;
    L_0x1b92:
        if (r28 == 0) goto L_0x1bbd;
    L_0x1b94:
        r2 = "gameRegionName";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r3);
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "gameRegionName";
        r3.put(r4, r2);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "get game region:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x1bbd:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get game region:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1bcc:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1be0;
    L_0x1bd1:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get game region:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1be0:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "get game region:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1bef:
        r2 = 43;
        r0 = r26;
        if (r0 != r2) goto L_0x1cc7;
    L_0x1bf5:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request to open file chooser for id card image, result code = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        switch(r27) {
            case -1: goto L_0x1c1f;
            case 0: goto L_0x1cb8;
            default: goto L_0x1c10;
        };
    L_0x1c10:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseImage:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1c1f:
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "key_pick_local_pic_callback_local_ids";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "MicroMsg.MsgHandler";
        r5 = "localIds = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r4 == 0) goto L_0x1c51;
    L_0x1c42:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseIdCard:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1c51:
        r4 = new org.json.JSONArray;	 Catch:{ Exception -> 0x1c8d }
        r4.<init>(r3);	 Catch:{ Exception -> 0x1c8d }
        r3 = r4.length();	 Catch:{ Exception -> 0x1c8d }
        if (r3 <= 0) goto L_0x1ca9;	 Catch:{ Exception -> 0x1c8d }
    L_0x1c5c:
        r3 = "localId";	 Catch:{ Exception -> 0x1c8d }
        r5 = 0;	 Catch:{ Exception -> 0x1c8d }
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x1c8d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x1c8d }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x1c8d }
        r3 = "key_pick_local_pic_source_type";	 Catch:{ Exception -> 0x1c8d }
        r0 = r28;	 Catch:{ Exception -> 0x1c8d }
        r3 = r0.getStringExtra(r3);	 Catch:{ Exception -> 0x1c8d }
        if (r3 == 0) goto L_0x1c7f;	 Catch:{ Exception -> 0x1c8d }
    L_0x1c76:
        r3 = "sourceType";	 Catch:{ Exception -> 0x1c8d }
        r4 = "album";	 Catch:{ Exception -> 0x1c8d }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x1c8d }
    L_0x1c7f:
        r0 = r25;	 Catch:{ Exception -> 0x1c8d }
        r3 = r0.tNN;	 Catch:{ Exception -> 0x1c8d }
        r4 = "chooseIdCard:ok";	 Catch:{ Exception -> 0x1c8d }
        r0 = r25;	 Catch:{ Exception -> 0x1c8d }
        r0.a(r3, r4, r2);	 Catch:{ Exception -> 0x1c8d }
        goto L_0x0046;
    L_0x1c8d:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseImage:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1ca9:
        r0 = r25;	 Catch:{ Exception -> 0x1c8d }
        r2 = r0.tNN;	 Catch:{ Exception -> 0x1c8d }
        r3 = "chooseImage:fail";	 Catch:{ Exception -> 0x1c8d }
        r4 = 0;	 Catch:{ Exception -> 0x1c8d }
        r0 = r25;	 Catch:{ Exception -> 0x1c8d }
        r0.a(r2, r3, r4);	 Catch:{ Exception -> 0x1c8d }
        goto L_0x0046;
    L_0x1cb8:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "chooseIdCard:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1cc7:
        r2 = 48;
        r0 = r26;
        if (r0 != r2) goto L_0x1d3a;
    L_0x1ccd:
        r2 = "MicroMsg.MsgHandler";
        r3 = "alvinluo: requestWxFacePictureVerify resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1cff;
    L_0x1ce5:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerify:ok";
        if (r28 == 0) goto L_0x1cfd;
    L_0x1cee:
        r2 = r28.getExtras();
    L_0x1cf2:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1cfd:
        r2 = 0;
        goto L_0x1cf2;
    L_0x1cff:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1d1e;
    L_0x1d04:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerify:fail";
        if (r28 == 0) goto L_0x1d1c;
    L_0x1d0d:
        r2 = r28.getExtras();
    L_0x1d11:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1d1c:
        r2 = 0;
        goto L_0x1d11;
    L_0x1d1e:
        if (r27 != 0) goto L_0x0046;
    L_0x1d20:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerify:cancel";
        if (r28 == 0) goto L_0x1d38;
    L_0x1d29:
        r2 = r28.getExtras();
    L_0x1d2d:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1d38:
        r2 = 0;
        goto L_0x1d2d;
    L_0x1d3a:
        r2 = 49;
        r0 = r26;
        if (r0 != r2) goto L_0x1dad;
    L_0x1d40:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: REQUEST_FACE_DETECT_WITH_VIDEO resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1d72;
    L_0x1d58:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerifyUnionVideo:ok";
        if (r28 == 0) goto L_0x1d70;
    L_0x1d61:
        r2 = r28.getExtras();
    L_0x1d65:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1d70:
        r2 = 0;
        goto L_0x1d65;
    L_0x1d72:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1d91;
    L_0x1d77:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerifyUnionVideo:fail";
        if (r28 == 0) goto L_0x1d8f;
    L_0x1d80:
        r2 = r28.getExtras();
    L_0x1d84:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1d8f:
        r2 = 0;
        goto L_0x1d84;
    L_0x1d91:
        if (r27 != 0) goto L_0x0046;
    L_0x1d93:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFacePictureVerifyUnionVideo:cancel";
        if (r28 == 0) goto L_0x1dab;
    L_0x1d9c:
        r2 = r28.getExtras();
    L_0x1da0:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1dab:
        r2 = 0;
        goto L_0x1da0;
    L_0x1dad:
        r2 = 52;
        r0 = r26;
        if (r0 != r2) goto L_0x1eb0;
    L_0x1db3:
        r2 = "MicroMsg.MsgHandler";
        r3 = "share emmotion resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        switch(r27) {
            case -1: goto L_0x1dd8;
            case 0: goto L_0x1ea1;
            default: goto L_0x1dc9;
        };
    L_0x1dc9:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "shareEmoticon:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1dd8:
        r2 = "Select_Conv_User";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "";
        r4 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r3);
        r2 = "emoji_thumb_path";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r3);
        r2 = "emoji_activity_id";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r5 = "";
        r5 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r5);
        r2 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r2 = r2.aqJ();
        r2 = r2.YB(r3);
        if (r2 != 0) goto L_0x257a;
    L_0x1e16:
        com.tencent.mm.y.as.Hm();
        r6 = com.tencent.mm.y.c.Fw();
        r7 = "";
        r6 = com.tencent.mm.plugin.emoji.model.EmojiLogic.I(r6, r7, r3);
        r7 = com.tencent.mm.a.e.bO(r6);
        if (r7 == 0) goto L_0x257a;
    L_0x1e2a:
        r2 = com.tencent.mm.sdk.platformtools.p.Vw(r6);
        if (r2 == 0) goto L_0x1e8f;
    L_0x1e30:
        r2 = com.tencent.mm.storage.emotion.EmojiInfo.xIP;
    L_0x1e32:
        r7 = new com.tencent.mm.storage.emotion.EmojiInfo;
        r7.<init>();
        r7.kT(r3);
        r3 = com.tencent.mm.storage.emotion.EmojiInfo.xIH;
        r7.DO(r3);
        r7.setType(r2);
        r2 = com.tencent.mm.a.e.bN(r6);
        r7.setSize(r2);
        r2 = 1;
        r7.DP(r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r2 != 0) goto L_0x1e55;
    L_0x1e53:
        r7.field_activityid = r5;
    L_0x1e55:
        r2 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r2 = r2.aqJ();
        r2 = r2.n(r7);
        r3 = r2;
    L_0x1e62:
        r2 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aD(r4, r2);
        r4 = ",";
        r2 = r2.split(r4);
        r2 = com.tencent.mm.sdk.platformtools.bi.F(r2);
        r4 = r2.iterator();
    L_0x1e78:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x1e92;
    L_0x1e7e:
        r2 = r4.next();
        r2 = (java.lang.String) r2;
        if (r3 == 0) goto L_0x1e78;
    L_0x1e86:
        r5 = com.tencent.mm.plugin.emoji.model.i.aCh();
        r6 = 0;
        r5.a(r2, r3, r6);
        goto L_0x1e78;
    L_0x1e8f:
        r2 = com.tencent.mm.storage.emotion.EmojiInfo.xIO;
        goto L_0x1e32;
    L_0x1e92:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "shareEmoticon:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1ea1:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "shareEmoticon:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1eb0:
        r2 = 50;
        r0 = r26;
        if (r0 != r2) goto L_0x1f23;
    L_0x1eb6:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: requestWxFaceRegisterInternal resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1ee8;
    L_0x1ece:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceRegisterInternal:ok";
        if (r28 == 0) goto L_0x1ee6;
    L_0x1ed7:
        r2 = r28.getExtras();
    L_0x1edb:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1ee6:
        r2 = 0;
        goto L_0x1edb;
    L_0x1ee8:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1f07;
    L_0x1eed:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceRegisterInternal:fail";
        if (r28 == 0) goto L_0x1f05;
    L_0x1ef6:
        r2 = r28.getExtras();
    L_0x1efa:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1f05:
        r2 = 0;
        goto L_0x1efa;
    L_0x1f07:
        if (r27 != 0) goto L_0x0046;
    L_0x1f09:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceRegisterInternal:cancel";
        if (r28 == 0) goto L_0x1f21;
    L_0x1f12:
        r2 = r28.getExtras();
    L_0x1f16:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1f21:
        r2 = 0;
        goto L_0x1f16;
    L_0x1f23:
        r2 = 51;
        r0 = r26;
        if (r0 != r2) goto L_0x1f96;
    L_0x1f29:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: requestWxFaceVerifyInternal resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x1f5b;
    L_0x1f41:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceVerifyInternal:ok";
        if (r28 == 0) goto L_0x1f59;
    L_0x1f4a:
        r2 = r28.getExtras();
    L_0x1f4e:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1f59:
        r2 = 0;
        goto L_0x1f4e;
    L_0x1f5b:
        r2 = 1;
        r0 = r27;
        if (r0 != r2) goto L_0x1f7a;
    L_0x1f60:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceVerifyInternal:fail";
        if (r28 == 0) goto L_0x1f78;
    L_0x1f69:
        r2 = r28.getExtras();
    L_0x1f6d:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1f78:
        r2 = 0;
        goto L_0x1f6d;
    L_0x1f7a:
        if (r27 != 0) goto L_0x0046;
    L_0x1f7c:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "requestWxFaceVerifyInternal:cancel";
        if (r28 == 0) goto L_0x1f94;
    L_0x1f85:
        r2 = r28.getExtras();
    L_0x1f89:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x1f94:
        r2 = 0;
        goto L_0x1f89;
    L_0x1f96:
        r2 = 54;
        r0 = r26;
        if (r0 != r2) goto L_0x2011;
    L_0x1f9c:
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x2002;
    L_0x1fa1:
        if (r28 == 0) goto L_0x2002;
    L_0x1fa3:
        r2 = "Select_Contact";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = com.tencent.mm.y.r.gw(r2);
        r4 = new android.os.Bundle;
        r4.<init>();
        r5 = "username";
        r4.putString(r5, r2);
        r2 = "nickname";
        r4.putString(r2, r3);
        r2 = "ret";
        r3 = 0;
        r4.putInt(r2, r3);
        r0 = r25;	 Catch:{ RemoteException -> 0x1fe6 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1fe6 }
        if (r2 == 0) goto L_0x1fd7;	 Catch:{ RemoteException -> 0x1fe6 }
    L_0x1fce:
        r0 = r25;	 Catch:{ RemoteException -> 0x1fe6 }
        r2 = r0.fCC;	 Catch:{ RemoteException -> 0x1fe6 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ RemoteException -> 0x1fe6 }
        r2.n(r3, r4);	 Catch:{ RemoteException -> 0x1fe6 }
    L_0x1fd7:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x1fe6:
        r2 = move-exception;
        r3 = "MicroMsg.MsgHandler";
        r4 = new java.lang.StringBuilder;
        r5 = "onSearchDataReady exception";
        r4.<init>(r5);
        r2 = r2.getMessage();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.w(r3, r2);
        goto L_0x1fd7;
    L_0x2002:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "slectContact:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x2011:
        r2 = 55;
        r0 = r26;
        if (r0 != r2) goto L_0x20ec;
    L_0x2017:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: REQUEST_SET_RESET_WALLET_PWD_REQUEST resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x2083;
    L_0x202f:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "setWCPayPassword:ok";
        if (r28 == 0) goto L_0x2081;
    L_0x2038:
        r2 = r28.getExtras();
    L_0x203c:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "setWCPayPassword:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x205c:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x2065;
    L_0x2062:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
    L_0x2065:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "WalletJsApiReqKey: ";
        r3.<init>(r4);
        r4 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        goto L_0x0046;
    L_0x2081:
        r2 = 0;
        goto L_0x203c;
    L_0x2083:
        if (r27 != 0) goto L_0x20b5;
    L_0x2085:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "setWCPayPassword:cancel";
        if (r28 == 0) goto L_0x20b3;
    L_0x208e:
        r2 = r28.getExtras();
    L_0x2092:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "setWCPayPassword:cancel";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x205c;
    L_0x20b3:
        r2 = 0;
        goto L_0x2092;
    L_0x20b5:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "setWCPayPassword:fail";
        if (r28 == 0) goto L_0x20ea;
    L_0x20be:
        r2 = r28.getExtras();
    L_0x20c2:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x205c;
    L_0x20d1:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "setWCPayPassword:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x205c;
    L_0x20ea:
        r2 = 0;
        goto L_0x20c2;
    L_0x20ec:
        r2 = 56;
        r0 = r26;
        if (r0 != r2) goto L_0x2158;
    L_0x20f2:
        r2 = "MicroMsg.MsgHandler";
        r3 = new java.lang.StringBuilder;
        r4 = "request choose invoice title, resultCode = ";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = -1;
        r0 = r27;
        if (r0 != r3) goto L_0x213a;
    L_0x2114:
        if (r28 == 0) goto L_0x212c;
    L_0x2116:
        r3 = "choose_invoice_title_info";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = "";
        r3 = com.tencent.mm.sdk.platformtools.bi.aD(r3, r4);
        r4 = "choose_invoice_title_info";
        r2.put(r4, r3);
    L_0x212c:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "chooseInvoiceTitle:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x213a:
        if (r27 != 0) goto L_0x214a;
    L_0x213c:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "chooseInvoiceTitle:cancel";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x214a:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "chooseInvoiceTitle:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x2158:
        r2 = 57;
        r0 = r26;
        if (r0 != r2) goto L_0x2204;
    L_0x215e:
        r2 = "MicroMsg.MsgHandler";
        r3 = "request voice login verify, resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r3 = new java.util.HashMap;
        r3.<init>();
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x21be;
    L_0x217b:
        r2 = "err_code";
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r2, r4);
        r2 = "err_msg";
        r4 = "verify ok";
        r3.put(r2, r4);
        r0 = r25;
        r2 = r0.context;
        r2 = r2 instanceof com.tencent.mm.ui.MMActivity;
        if (r2 == 0) goto L_0x21b0;
    L_0x2197:
        r0 = r25;
        r2 = r0.context;
        r2 = (com.tencent.mm.ui.MMActivity) r2;
        r2 = r2.getIntent();
        r4 = "VoiceLoginAuthPwd";
        r5 = "VoiceLoginAuthPwd";
        r0 = r28;
        r5 = r0.getStringExtra(r5);
        r2.putExtra(r4, r5);
    L_0x21b0:
        r0 = r25;
        r2 = r0.tNN;
        r4 = "request voice login verify:ok";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x21be:
        if (r27 != 0) goto L_0x21e2;
    L_0x21c0:
        r2 = "err_code";
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r2, r4);
        r2 = "err_msg";
        r4 = "verify cancel";
        r3.put(r2, r4);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "request voice login verify:cancel";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x21e2:
        r2 = "err_code";
        r4 = 2;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r2, r4);
        r2 = "err_msg";
        r4 = "verify error";
        r3.put(r2, r4);
        r0 = r25;
        r2 = r0.tNN;
        r4 = "request voice login verify:error";
        r0 = r25;
        r0.a(r2, r4, r3);
        goto L_0x0046;
    L_0x2204:
        r2 = 59;
        r0 = r26;
        if (r0 != r2) goto L_0x22ca;
    L_0x220a:
        r2 = "MicroMsg.MsgHandler";
        r3 = "hy: REQUEST_OPEN_CARD_LIST resultCode: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x225c;
    L_0x2222:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openWCPayCardList:ok";
        if (r28 == 0) goto L_0x225a;
    L_0x222b:
        r2 = r28.getExtras();
    L_0x222f:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "openWCPayCardList:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x224f:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x2255:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x225a:
        r2 = 0;
        goto L_0x222f;
    L_0x225c:
        if (r27 != 0) goto L_0x2294;
    L_0x225e:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openWCPayCardList:fail";
        if (r28 == 0) goto L_0x2292;
    L_0x2267:
        r2 = r28.getExtras();
    L_0x226b:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x224f;
    L_0x227a:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "openWCPayCardList:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x224f;
    L_0x2292:
        r2 = 0;
        goto L_0x226b;
    L_0x2294:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openWCPayCardList:fail";
        if (r28 == 0) goto L_0x22c8;
    L_0x229d:
        r2 = r28.getExtras();
    L_0x22a1:
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(r2);
        r0 = r25;
        r0.a(r3, r4, r2);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x224f;
    L_0x22b0:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "openWCPayCardList:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x224f;
    L_0x22c8:
        r2 = 0;
        goto L_0x22a1;
    L_0x22ca:
        r2 = 60;
        r0 = r26;
        if (r0 != r2) goto L_0x234e;
    L_0x22d0:
        if (r28 == 0) goto L_0x2323;
    L_0x22d2:
        r2 = "key_callback";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r3 = "MicroMsg.MsgHandler";
        r4 = "open offline pay view callback: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openOfflinePayView:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        r2 = java.lang.String.format(r4, r5);
        r4 = 0;
        r0 = r25;
        r0.a(r3, r2, r4);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "openOfflinePayView:ok";
        r4[r5] = r6;
        r2.h(r3, r4);
    L_0x2318:
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x0046;
    L_0x231e:
        com.tencent.mm.pluginsdk.wallet.f.cdI();
        goto L_0x0046;
    L_0x2323:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "openOfflinePayView:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        r2 = com.tencent.mm.pluginsdk.wallet.f.cdG();
        if (r2 != 0) goto L_0x2318;
    L_0x2336:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14954; // 0x3a6a float:2.0955E-41 double:7.3883E-320;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.pluginsdk.wallet.f.cdH();
        r4[r5] = r6;
        r5 = 1;
        r6 = "openOfflinePayView:fail";
        r4[r5] = r6;
        r2.h(r3, r4);
        goto L_0x2318;
    L_0x234e:
        r2 = 58;
        r0 = r26;
        if (r0 != r2) goto L_0x238a;
    L_0x2354:
        r2 = "MicroMsg.MsgHandler";
        r3 = "request bind email, resultCode %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = -1;
        r0 = r27;
        if (r0 != r2) goto L_0x237b;
    L_0x236c:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "bindEmail:ok";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x237b:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "bindEmail:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x238a:
        r2 = 62;
        r0 = r26;
        if (r0 != r2) goto L_0x247f;
    L_0x2390:
        r2 = "MicroMsg.MsgHandler";
        r3 = "[openRealnameAuth]resultCode:%d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r27);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = -1;
        r0 = r27;
        if (r0 != r3) goto L_0x2401;
    L_0x23ad:
        r3 = "MicroMsg.MsgHandler";
        r4 = "openRealnameAuth ok";
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);
        r3 = "intent_auth_token";
        r0 = r28;
        r3 = r0.getStringExtra(r3);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r4 != 0) goto L_0x23f3;
    L_0x23c5:
        r4 = "err_code";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        r4 = "auth_token";
        r2.put(r4, r3);
        r4 = "MicroMsg.MsgHandler";
        r5 = "authToken:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openRealnameAuth:ok";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x23f3:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openRealnameAuth:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x2401:
        if (r27 != 0) goto L_0x241a;
    L_0x2403:
        r3 = "MicroMsg.MsgHandler";
        r4 = "openRealnameAuth cancel";
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openRealnameAuth:cancel";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x241a:
        r3 = 1;
        r0 = r27;
        if (r0 != r3) goto L_0x0046;
    L_0x241f:
        r3 = "MicroMsg.MsgHandler";
        r4 = "openRealnameAuth fail";
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);
        if (r28 == 0) goto L_0x2471;
    L_0x242a:
        r3 = "intent_err_code";
        r4 = -1;
        r0 = r28;
        r3 = r0.getIntExtra(r3, r4);
        r4 = "intent_err_msg";
        r0 = r28;
        r4 = r0.getStringExtra(r4);
        r5 = "err_code";
        r6 = java.lang.Integer.valueOf(r3);
        r2.put(r5, r6);
        r5 = "err_msg";
        r2.put(r5, r4);
        r0 = r25;
        r5 = r0.tNN;
        r6 = "openRealnameAuth:fail";
        r0 = r25;
        r0.a(r5, r6, r2);
        r2 = "MicroMsg.MsgHandler";
        r5 = "openRealnameAuth errCode:%d, errMsg:%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r7] = r3;
        r3 = 1;
        r6[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);
        goto L_0x0046;
    L_0x2471:
        r0 = r25;
        r3 = r0.tNN;
        r4 = "openRealnameAuth:fail";
        r0 = r25;
        r0.a(r3, r4, r2);
        goto L_0x0046;
    L_0x247f:
        r2 = 61;
        r0 = r26;
        if (r0 != r2) goto L_0x0046;
    L_0x2485:
        r0 = r25;
        r2 = r0.fzX;
        if (r2 != 0) goto L_0x24a3;
    L_0x248b:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, appmsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "sendSingleAppMessage:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x24a3:
        switch(r27) {
            case -1: goto L_0x24c4;
            case 0: goto L_0x24b5;
            default: goto L_0x24a6;
        };
    L_0x24a6:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "sendSingleAppMessage:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x24b5:
        r0 = r25;
        r2 = r0.tNN;
        r3 = "sendSingleAppMessage:cancel";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x24c4:
        if (r28 != 0) goto L_0x24e8;
    L_0x24c6:
        r2 = 0;
        r4 = r2;
    L_0x24c8:
        if (r4 == 0) goto L_0x24d0;
    L_0x24ca:
        r2 = r4.length();
        if (r2 != 0) goto L_0x24f3;
    L_0x24d0:
        r2 = "MicroMsg.MsgHandler";
        r3 = "mmOnActivityResult fail, toUser is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r0 = r25;
        r2 = r0.tNN;
        r3 = "sendSingleAppMessage:fail";
        r4 = 0;
        r0 = r25;
        r0.a(r2, r3, r4);
        goto L_0x0046;
    L_0x24e8:
        r2 = "Select_Conv_User";
        r0 = r28;
        r2 = r0.getStringExtra(r2);
        r4 = r2;
        goto L_0x24c8;
    L_0x24f3:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "__jsapi_fw_ext_info";
        r2 = r2.get(r3);
        r3 = 0;
        r5 = r2 instanceof android.os.Bundle;
        if (r5 == 0) goto L_0x2578;
    L_0x2505:
        r2 = (android.os.Bundle) r2;
        r3 = "__jsapi_fw_ext_info_key_current_url";
        r2 = r2.getString(r3);
    L_0x250e:
        r0 = r25;
        r3 = r0.tNZ;
        r2 = r3.Qf(r2);
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r3 == 0) goto L_0x252b;
    L_0x251c:
        r0 = r25;
        r2 = r0.tNN;
        r2 = r2.pug;
        r3 = "appId";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
    L_0x252b:
        r3 = new com.tencent.mm.plugin.webview.model.q;
        r5 = "";
        r3.<init>(r2, r5, r4);
        r2 = com.tencent.mm.y.as.CN();
        r5 = 1177; // 0x499 float:1.65E-42 double:5.815E-321;
        r6 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$12;
        r0 = r25;
        r1 = r28;
        r6.<init>(r1, r4);
        r2.a(r5, r6);
        r2 = com.tencent.mm.y.as.CN();
        r2.d(r3);
        r0 = r25;
        r2 = r0.context;
        r0 = r25;
        r4 = r0.context;
        r5 = com.tencent.mm.R.l.dGZ;
        r4.getString(r5);
        r0 = r25;
        r4 = r0.context;
        r5 = com.tencent.mm.R.l.dHn;
        r4 = r4.getString(r5);
        r5 = 1;
        r6 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$14;
        r0 = r25;
        r6.<init>(r3);
        r2 = com.tencent.mm.ui.base.h.a(r2, r4, r5, r6);
        r0 = r25;
        r0.inI = r2;
        goto L_0x0046;
    L_0x2575:
        r2 = move-exception;
        goto L_0x05d4;
    L_0x2578:
        r2 = r3;
        goto L_0x250e;
    L_0x257a:
        r3 = r2;
        goto L_0x1e62;
    L_0x257d:
        r4 = r2;
        goto L_0x17a1;
    L_0x2580:
        r3 = r2;
        goto L_0x1561;
    L_0x2583:
        r3 = r2;
        goto L_0x115f;
    L_0x2586:
        r15 = r2;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b(int, int, android.content.Intent):void");
    }

    private void aT(i iVar) {
        Bundle ap = i.ap(iVar.pug);
        try {
            this.fCC.bSB();
            this.fCC.O(ap);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
        }
    }

    private boolean a(f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.fzX == null) {
            x.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            return false;
        }
        o.PB();
        Bitmap iJ = com.tencent.mm.ap.c.iJ(str3);
        if (!(iJ == null || iJ.isRecycled())) {
            x.i("MicroMsg.MsgHandler", "thumb image is not null");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            iJ.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.fzX.thumbData = byteArrayOutputStream.toByteArray();
        }
        com.tencent.mm.sdk.b.b orVar = new or();
        orVar.fHs.fzX = this.fzX;
        orVar.fHs.appId = str;
        orVar.fHs.appName = fVar == null ? "" : fVar.field_appName;
        orVar.fHs.toUser = str2;
        orVar.fHs.fHt = 2;
        if (bi.oN(str4)) {
            orVar.fHs.fHw = null;
        } else {
            orVar.fHs.fHu = str4;
            orVar.fHs.fHv = str5;
        }
        try {
            String string = this.tNQ.getString("key_snsad_statextstr");
            orVar.fHs.fHB = string;
            orVar.fHs.fHx = this.fCC.bSz();
            Bundle e = this.fCC.e(18, null);
            if (e != null) {
                com.tencent.mm.f.a.or.a aVar = orVar.fHs;
                String oM = bi.oM(e.getString("KPublisherId"));
                aVar.fHA = oM;
                String hC = com.tencent.mm.y.u.hC(oM);
                com.tencent.mm.y.u.b t = com.tencent.mm.y.u.GQ().t(hC, true);
                t.o("sendAppMsgScene", Integer.valueOf(2));
                t.o("preChatName", e.getString("preChatName"));
                t.o("preMsgIndex", Integer.valueOf(e.getInt("preMsgIndex")));
                t.o("prePublishId", e.getString("prePublishId"));
                t.o("preUsername", e.getString("preUsername"));
                t.o("getA8KeyScene", Integer.valueOf(e.getInt("getA8KeyScene")));
                t.o("referUrl", e.getString("referUrl"));
                if (!bi.oN(string)) {
                    t.o("adExtStr", string);
                }
                orVar.fHs.frp = hC;
            }
            string = this.fCC.aeH();
            orVar.fHs.fHy = string;
            orVar.fHs.fHz = this.tNZ.Qf(string);
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "init bunddata failed : %s", e2.getMessage());
        }
        boolean m = com.tencent.mm.sdk.b.a.xmy.m(orVar);
        if (!bi.oN(str6)) {
            orVar = new ot();
            orVar.fHD.fHE = str2;
            orVar.fHD.content = str6;
            orVar.fHD.type = com.tencent.mm.y.s.hs(str2);
            orVar.fHD.flags = 0;
            com.tencent.mm.sdk.b.a.xmy.m(orVar);
        }
        if (m) {
            try {
                if (this.fCC != null) {
                    a(str, str3, com.tencent.mm.y.s.eX(str2) ? 2 : 3, this.fCC.e(85, null));
                }
            } catch (RemoteException e3) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult : %s", e3);
            }
        }
        if (bi.oN(str7)) {
            return m;
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(10424, Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), str7);
        return m;
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("share_report_pre_msg_url");
            String string2 = bundle.getString("share_report_pre_msg_title");
            String string3 = bundle.getString("share_report_pre_msg_desc");
            String string4 = bundle.getString("share_report_pre_msg_icon_url");
            String string5 = bundle.getString("share_report_pre_msg_appid");
            int i2 = bundle.getInt("share_report_from_scene", 0);
            String string6 = bundle.getString("share_report_biz_username");
            String string7 = bundle.getString("share_report_current_url");
            String string8 = bundle.getString("share_report_current_title");
            String str3 = this.fzX.mediaObject instanceof WXWebpageObject ? ((WXWebpageObject) this.fzX.mediaObject).webpageUrl : "";
            String str4 = this.fzX.title;
            String str5 = this.fzX.description;
            com.tencent.mm.plugin.report.service.g.pWK.h(14062, string, string2, string3, string4, string5, Integer.valueOf(i2), string6, string7, string8, str, str3, str4, str5, str2, Integer.valueOf(i));
        }
    }

    private void a(i iVar, String str, Map<String, Object> map) {
        a(iVar, str, (Map) map, true);
    }

    public final void a(i iVar, String str, Map<String, Object> map, boolean z) {
        this.mgx = false;
        try {
            if (this.fCC != null) {
                this.fCC.a(iVar == null ? null : iVar.tQe, str, i.ap(map), z);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    public final void a(e eVar, i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        if (!z2) {
            this.mgx = false;
        }
        try {
            eVar.a(iVar == null ? null : iVar.tQe, str, i.ap(map), z);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r14, boolean r15) {
        /*
        r13 = this;
        r3 = 0;
        r1 = 0;
        if (r14 != 0) goto L_0x000e;
    L_0x0004:
        r0 = "MicroMsg.MsgHandler";
        r1 = "msg is null when report.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x000d:
        return;
    L_0x000e:
        r9 = r14.tQg;
        r12 = r14.tQf;
        r0 = "isSuccess";
        r2 = java.lang.Boolean.valueOf(r15);
        r12.put(r0, r2);
        r6 = r13.fCC;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r9);
        if (r0 == 0) goto L_0x00b2;
    L_0x0024:
        r0 = "MicroMsg.WebViewSecurityUtil";
        r2 = "function name is null or nil.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
    L_0x002d:
        r0 = "";
        r2 = r13.tNQ;
        if (r2 == 0) goto L_0x003d;
    L_0x0034:
        r0 = r13.tNQ;
        r2 = "key_webview_container_env";
        r0 = r0.getString(r2);
    L_0x003d:
        r2 = "miniProgram";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0046:
        r0 = r13.fCC;
        if (r0 == 0) goto L_0x000d;
    L_0x004a:
        r2 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        r3 = 0;
        r0 = r0.e(r2, r3);	 Catch:{ Exception -> 0x022d }
        if (r0 == 0) goto L_0x000d;
    L_0x0053:
        r2 = "key_webview_apbrand_jsapi_report_args";
        r2 = r0.getStringArray(r2);
        if (r2 == 0) goto L_0x000d;
    L_0x005c:
        r0 = r2.length;
        r3 = 19;
        if (r0 != r3) goto L_0x000d;
    L_0x0061:
        r0 = 10;
        r2[r0] = r9;
        r3 = 11;
        r0 = -1;
        r4 = r9.hashCode();
        switch(r4) {
            case -1008737020: goto L_0x023a;
            default: goto L_0x006f;
        };
    L_0x006f:
        r1 = r0;
    L_0x0070:
        switch(r1) {
            case 0: goto L_0x0245;
            default: goto L_0x0073;
        };
    L_0x0073:
        r0 = "";
    L_0x0076:
        r2[r3] = r0;
        r1 = 12;
        r0 = "true";
        r3 = "isSuccess";
        r3 = com.tencent.mm.plugin.webview.ui.tools.jsapi.l.a(r14, r3);
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0254;
    L_0x008a:
        r0 = "1";
    L_0x008d:
        r2[r1] = r0;
        r0 = 13;
        r1 = "permissionValue";
        r1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.l.a(r14, r1);
        r2[r0] = r1;
        r0 = 14;
        r1 = "jsapiErrorCode";
        r1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.l.a(r14, r1);
        r2[r0] = r1;
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14993; // 0x3a91 float:2.101E-41 double:7.4075E-320;
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.l.h(r2);
        r0.h(r1, r2);
        goto L_0x000d;
    L_0x00b2:
        if (r6 != 0) goto L_0x01ec;
    L_0x00b4:
        r0 = 1;
    L_0x00b5:
        r5 = "";
        r4 = "";
        r8 = "";
        r2 = "";
        if (r0 == 0) goto L_0x01ef;
    L_0x00c3:
        r5 = "";
    L_0x00c6:
        if (r0 == 0) goto L_0x01f5;
    L_0x00c8:
        r4 = "";
    L_0x00cb:
        if (r0 == 0) goto L_0x01fb;
    L_0x00cd:
        r0 = "";
    L_0x00d0:
        r8 = r0;
        r10 = r4;
        r11 = r5;
    L_0x00d3:
        if (r12 == 0) goto L_0x0259;
    L_0x00d5:
        r0 = "fromMenu";
        r0 = r12.get(r0);
        r0 = (java.lang.Boolean) r0;
        r7 = com.tencent.mm.sdk.platformtools.bi.c(r0);
        r0 = "keyParam";
        r0 = r12.get(r0);
        r0 = (java.lang.String) r0;
        r6 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
        r0 = "appId";
        r0 = r12.get(r0);
        r0 = (java.lang.String) r0;
        r2 = "";
        r5 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r2);
        r0 = "isSuccess";
        r0 = r12.get(r0);
        r0 = (java.lang.Boolean) r0;
        r4 = com.tencent.mm.sdk.platformtools.bi.c(r0);
        r0 = "permissionValue";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.e(r0);
        r0 = "baseErrorCode";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r2 = com.tencent.mm.sdk.platformtools.bi.e(r0);
        r0 = "jsapiErrorCode";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.e(r0);
    L_0x0133:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r11 = com.tencent.mm.sdk.platformtools.bi.oM(r11);
        r11 = java.net.URLEncoder.encode(r11);
        r12.append(r11);
        r11 = ",";
        r12.append(r11);
        r10 = com.tencent.mm.sdk.platformtools.bi.oM(r10);
        r10 = java.net.URLEncoder.encode(r10);
        r12.append(r10);
        r10 = ",";
        r12.append(r10);
        if (r8 != 0) goto L_0x015f;
    L_0x015c:
        r8 = "";
    L_0x015f:
        r12.append(r8);
        r8 = ",";
        r12.append(r8);
        if (r9 != 0) goto L_0x0220;
    L_0x016a:
        r8 = "";
    L_0x016d:
        r12.append(r8);
        r8 = ",";
        r12.append(r8);
        if (r7 == 0) goto L_0x0223;
    L_0x0178:
        r7 = "1";
    L_0x017b:
        r12.append(r7);
        r7 = ",";
        r12.append(r7);
        if (r6 != 0) goto L_0x0189;
    L_0x0186:
        r6 = "";
    L_0x0189:
        r12.append(r6);
        r6 = ",";
        r12.append(r6);
        r12.append(r5);
        r5 = ",";
        r12.append(r5);
        if (r4 == 0) goto L_0x0228;
    L_0x019d:
        r5 = "1";
    L_0x01a0:
        r12.append(r5);
        r5 = ",";
        r12.append(r5);
        r12.append(r3);
        if (r4 != 0) goto L_0x01c9;
    L_0x01ae:
        r3 = ",";
        r12.append(r3);
        r12.append(r1);
        r3 = ",";
        r12.append(r3);
        r12.append(r2);
        r2 = ",";
        r12.append(r2);
        r12.append(r0);
    L_0x01c9:
        r0 = r12.toString();
        r2 = "MicroMsg.WebViewSecurityUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "report: ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 10417; // 0x28b1 float:1.4597E-41 double:5.1467E-320;
        r2.k(r3, r0);
        goto L_0x002d;
    L_0x01ec:
        r0 = r1;
        goto L_0x00b5;
    L_0x01ef:
        r5 = r6.bSz();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00c6;
    L_0x01f5:
        r4 = r6.aeH();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00cb;
    L_0x01fb:
        r0 = r6.bSA();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00d0;
    L_0x0201:
        r0 = move-exception;
        r6 = "MicroMsg.WebViewSecurityUtil";
        r7 = new java.lang.StringBuilder;
        r10 = "report, ex = ";
        r7.<init>(r10);
        r0 = r0.getMessage();
        r0 = r7.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.w(r6, r0);
        r10 = r4;
        r11 = r5;
        goto L_0x00d3;
    L_0x0220:
        r8 = r9;
        goto L_0x016d;
    L_0x0223:
        r7 = "0";
        goto L_0x017b;
    L_0x0228:
        r5 = "0";
        goto L_0x01a0;
    L_0x022d:
        r0 = move-exception;
        r1 = "kv_14993";
        r0 = java.lang.String.valueOf(r0);
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x000d;
    L_0x023a:
        r4 = "getBrandWCPayRequest";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x006f;
    L_0x0243:
        goto L_0x0070;
    L_0x0245:
        r0 = r14.pug;
        r1 = "package";
        r0 = r0.get(r1);
        r0 = r0.toString();
        goto L_0x0076;
    L_0x0254:
        r0 = "2";
        goto L_0x008d;
    L_0x0259:
        r0 = r1;
        r4 = r1;
        r5 = r2;
        r6 = r3;
        r7 = r1;
        r2 = r1;
        r3 = r1;
        goto L_0x0133;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, boolean):void");
    }

    private int aU(i iVar) {
        int hashCode = iVar.hashCode();
        this.tOz.put(Integer.valueOf(hashCode), new c(iVar, this.fCC));
        this.mgx = false;
        try {
            this.fCC.bSC();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", e.getMessage());
        }
        return hashCode;
    }

    public final c Bs(int i) {
        return (c) this.tOz.get(Integer.valueOf(i));
    }

    private void Bt(int i) {
        c cVar = (c) this.tOz.remove(Integer.valueOf(i));
        if (cVar != null) {
            cVar.tNN = null;
            cVar.fCC = null;
        }
    }

    private boolean aV(i iVar) {
        this.mgx = false;
        if (com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "scene", 3) == 21) {
            return com.tencent.mm.plugin.webview.fts.l.bPY().W(iVar.pug);
        }
        return com.tencent.mm.plugin.webview.modeltools.f.bSm().W(iVar.pug);
    }

    private boolean aW(i iVar) {
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        com.tencent.mm.plugin.webview.fts.e.c(iVar.pug, hashMap);
        a(iVar, "getSearchDisplayName:ok", hashMap);
        return true;
    }

    private boolean aX(i iVar) {
        int i;
        com.tencent.mm.protocal.c.oz ozVar;
        JSONObject jSONObject;
        JSONArray jSONArray;
        this.mgx = false;
        com.tencent.mm.plugin.webview.fts.c bSm = com.tencent.mm.plugin.webview.modeltools.f.bSm();
        Map map = iVar.pug;
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "parseGoToRecVideoListParams, params: %s", map);
        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
        dVar.foW = com.tencent.mm.plugin.webview.fts.f.r(map, "query");
        dVar.offset = com.tencent.mm.plugin.webview.fts.f.c(map, "offset", 0);
        dVar.hMM = com.tencent.mm.plugin.webview.fts.f.c(map, Columns.TYPE, 0);
        dVar.scene = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 3);
        dVar.tqv = com.tencent.mm.plugin.webview.fts.f.r(map, "sugId");
        dVar.tqx = com.tencent.mm.plugin.webview.fts.f.c(map, "sugType", 0);
        dVar.tqw = com.tencent.mm.plugin.webview.fts.f.r(map, "prefixSug");
        dVar.tqs = com.tencent.mm.plugin.webview.fts.f.t(map, "isHomePage") ? 1 : 0;
        dVar.lKv = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        dVar.tqu = com.tencent.mm.plugin.webview.fts.f.c(map, "sceneActionType", 1);
        dVar.tqz = com.tencent.mm.plugin.webview.fts.f.c(map, "displayPattern", 2);
        dVar.tqA = com.tencent.mm.plugin.webview.fts.f.c(map, "sugPosition", 0);
        dVar.tqB = com.tencent.mm.plugin.webview.fts.f.r(map, "sugBuffer");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "extReqParams");
        if (!bi.oN(r)) {
            try {
                JSONArray jSONArray2 = new JSONArray(r);
                for (i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    com.tencent.mm.protocal.c.oz ozVar2 = new com.tencent.mm.protocal.c.oz();
                    ozVar2.aAM = jSONObject2.optString("key", "");
                    ozVar2.weB = (long) jSONObject2.optInt("uintValue", 0);
                    ozVar2.weC = jSONObject2.optString("textValue", "");
                    dVar.tqD.add(ozVar2);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "videoId");
        if (!bi.oN(r2)) {
            ozVar = new com.tencent.mm.protocal.c.oz();
            ozVar.aAM = "relevant_vid";
            ozVar.weC = r2;
            dVar.tqD.add(ozVar);
        }
        String r3 = com.tencent.mm.plugin.webview.fts.f.r(map, "expand");
        if (!bi.oN(r3)) {
            ozVar = new com.tencent.mm.protocal.c.oz();
            ozVar.aAM = "relevant_expand";
            ozVar.weC = r3;
            dVar.tqD.add(ozVar);
        }
        String r4 = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        if (!bi.oN(r4)) {
            ozVar = new com.tencent.mm.protocal.c.oz();
            ozVar.aAM = "relevant_pre_searchid";
            ozVar.weC = r4;
            dVar.tqD.add(ozVar);
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "shareOpenID");
        if (!bi.oN(r)) {
            com.tencent.mm.protocal.c.oz ozVar3 = new com.tencent.mm.protocal.c.oz();
            ozVar3.aAM = "relevant_shared_openid";
            ozVar3.weC = r;
            dVar.tqD.add(ozVar3);
        }
        long a = com.tencent.mm.plugin.webview.fts.f.a(map, "relevant_category", -1);
        if (a >= 0) {
            ozVar = new com.tencent.mm.protocal.c.oz();
            ozVar.aAM = "rec_category";
            ozVar.weB = a;
            dVar.tqD.add(ozVar);
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "matchUser");
        if (!bi.oN(r)) {
            try {
                jSONObject = new JSONObject(r);
                btb btb = new btb();
                btb.kyG = jSONObject.optString("userName");
                btb.xbi = jSONObject.optString("matchWord");
                if (!TextUtils.isEmpty(btb.kyG)) {
                    dVar.tqt.add(btb);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "prefixQuery");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    dVar.tqy.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "tagInfo");
        if (!bi.oN(r)) {
            try {
                jSONObject = new JSONObject(r);
                dVar.tqC = new bon();
                dVar.tqC.wXV = jSONObject.optString("tagText");
                dVar.tqC.wXU = jSONObject.optInt("tagType");
                dVar.tqC.wXW = jSONObject.optString("tagExtValue");
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "numConditions");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    aty aty = new aty();
                    aty.wIK = optJSONObject.optLong("from");
                    aty.wIL = optJSONObject.optLong("to");
                    aty.wIJ = optJSONObject.optInt("field");
                    dVar.tqE.add(aty);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fEg = bi.p(map.get("webview_instance_id"), -1);
        dVar.ael = w.eM(ad.getContext());
        dVar.mRc = com.tencent.mm.plugin.webview.fts.f.c(map, "subType", 0);
        if (com.tencent.mm.bb.m.Rq()) {
            dVar.tqF = com.tencent.mm.plugin.webview.fts.f.c(map, "isWeAppMore", 0);
            if (dVar.tqF == 1) {
                dVar.tqG = new cdf();
                com.tencent.mm.sdk.b.b hxVar = new hx();
                com.tencent.mm.sdk.b.a.xmy.m(hxVar);
                dVar.tqG.xiy = hxVar.fzj.fzk;
                dVar.tqG.xiA = com.tencent.mm.modelappbrand.b.hli;
                dVar.tqG.xiz = com.tencent.mm.plugin.webview.fts.f.c(map, "subType", 0);
                dVar.tqG.wZx = com.tencent.mm.modelappbrand.b.hlh;
                dVar.tqG.xiB = dVar.tqA;
                as.Hm();
                Object obj = com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tqG.xhO = (String) obj;
                }
            }
        }
        if (bSm.tsq == 1) {
            dVar.tqH = bSm.tqH;
        } else {
            dVar.tqH = null;
        }
        com.tencent.mm.plugin.webview.fts.topstory.a.b.d(dVar);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray3 = new JSONArray(com.tencent.mm.plugin.webview.fts.f.r(map, "videoUrls"));
            if (jSONArray3.length() > 0) {
                for (i = 0; i < jSONArray3.length(); i++) {
                    arrayList.add(jSONArray3.getString(i));
                }
            }
        } catch (JSONException e3) {
        }
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "parseGoToRecVideoListParams, videoUrls: %s", arrayList);
        if (!bi.oN(r2)) {
            r = "http://shp.qpic.cn/qqvideo_ori/0/" + r2 + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
            com.tencent.mm.plugin.topstory.a.a.d dVar2 = new com.tencent.mm.plugin.topstory.a.a.d();
            dVar2.title = com.tencent.mm.plugin.webview.fts.f.r(map, "title");
            dVar2.skC = r;
            dVar2.skD = com.tencent.mm.plugin.webview.fts.f.c(map, "mediaDuration", 0);
            dVar2.skE = r2;
            dVar2.hcZ = 496;
            dVar2.hcY = 280;
            dVar2.skL = com.tencent.mm.plugin.webview.fts.f.r(map, "strPlayCount");
            dVar2.lUI = com.tencent.mm.plugin.webview.fts.f.r(map, "shareUrl");
            dVar2.lUJ = com.tencent.mm.plugin.webview.fts.f.r(map, "shareTitle");
            dVar2.skM = com.tencent.mm.plugin.webview.fts.f.r(map, "titleUrl");
            dVar2.rlx = com.tencent.mm.plugin.webview.fts.f.r(map, "shareDesc");
            dVar2.skF = com.tencent.mm.plugin.webview.fts.f.r(map, "shareImgUrl");
            dVar2.skG = com.tencent.mm.plugin.webview.fts.f.r(map, "shareString");
            dVar2.skH = com.tencent.mm.plugin.webview.fts.f.r(map, "shareStringUrl");
            dVar2.bhd = com.tencent.mm.plugin.webview.fts.f.r(map, "source");
            dVar2.pka = com.tencent.mm.plugin.webview.fts.f.r(map, "sourceUrl");
            dVar2.skI = com.tencent.mm.plugin.webview.fts.f.a(map, "relevant_category", -1);
            dVar2.skJ = com.tencent.mm.plugin.webview.fts.f.r(map, "shareOpenId");
            dVar2.skQ = com.tencent.mm.plugin.webview.fts.f.r(map, "docID");
            dVar2.skS = com.tencent.mm.plugin.webview.fts.f.a(map, "videoSize", 0);
            dVar2.timestamp = bi.Wz();
            try {
                JSONObject jSONObject3 = new JSONObject(com.tencent.mm.plugin.webview.fts.f.r(map, "block"));
                dVar2.skR = jSONObject3.optLong("resultType");
                dVar2.foX = jSONObject3.optLong(Columns.TYPE);
            } catch (JSONException e4) {
            }
            dVar2.skK = r3;
            if (!bi.oN(dVar2.videoUrl) && dVar2.skD > 0) {
                com.tencent.mm.plugin.webview.fts.topstory.a.e.bQg().Ow(dVar2.videoUrl);
            }
            com.tencent.mm.plugin.webview.fts.topstory.a.b.a(arrayList, dVar2, r3, r4);
        }
        com.tencent.mm.ui.e.i.xMT = true;
        Intent intent = new Intent();
        intent.putExtra("key_proxy_fts_rec_ui", true);
        intent.putExtra("key_scene", 1);
        com.tencent.mm.bl.d.b(this.context, "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        a(iVar, "0", hashMap);
        return false;
    }

    private boolean aY(i iVar) {
        this.mgx = false;
        try {
            if (!(this.fCC == null || iVar.pug == null || !iVar.pug.containsKey("view"))) {
                Bundle bundle = new Bundle();
                bundle.putString("fts_key_data", (String) iVar.pug.get("view"));
                this.fCC.n(138, bundle);
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean aZ(i iVar) {
        this.mgx = false;
        int Wo = bi.Wo((String) iVar.pug.get("x"));
        int Wo2 = bi.Wo((String) iVar.pug.get("y"));
        String str = (String) iVar.pug.get("eventId");
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.pug.get("widgetId"));
        bundle.putInt("x", Wo);
        bundle.putInt("y", Wo2);
        bundle.putString("eventId", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(100002, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doTapSearchWAWidgetView exception" + e.getMessage());
        }
        a(iVar, "tapSearchWAWidgetView:ok", null);
        return true;
    }

    private boolean ba(i iVar) {
        this.mgx = false;
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.pug.get("widgetId"));
        try {
            if (this.fCC != null) {
                this.fCC.n(100001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOpenSearchWAWidgetLogView exception" + e.getMessage());
        }
        a(iVar, "openSearchWAWidgetLogView:ok", null);
        return true;
    }

    private boolean bb(i iVar) {
        this.mgx = false;
        this.tOA++;
        String str = ((String) iVar.pug.get("appid")) + "_" + this.tOA;
        JSONObject jSONObject = new JSONObject(iVar.pug);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(60, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "insertSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bc(i iVar) {
        this.mgx = false;
        int i = this.tOB;
        this.tOB = i + 1;
        Bundle ap = i.ap(iVar.pug);
        if (ap.containsKey("playerId")) {
            i = bi.Wo(ap.getString("playerId"));
        } else {
            ap.putString("playerId", String.valueOf(i));
        }
        x.i("MicroMsg.MsgHandler", "inserting video player id %d, params %s", Integer.valueOf(i), iVar.pug);
        try {
            if (this.fCC != null) {
                this.fCC.n(200000, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("playerId", Integer.valueOf(i));
        a(iVar, "insertVideoPlayer:ok", hashMap);
        return true;
    }

    private boolean bd(i iVar) {
        this.mgx = false;
        Bundle ap = i.ap(iVar.pug);
        x.i("MicroMsg.MsgHandler", "update video player  params %s", iVar.pug);
        try {
            if (this.fCC != null) {
                this.fCC.n(200001, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "updateVideoPlayer:ok", null);
        return true;
    }

    private boolean be(i iVar) {
        this.mgx = false;
        Bundle ap = i.ap(iVar.pug);
        x.i("MicroMsg.MsgHandler", "remove video player   params %s", iVar.pug);
        try {
            if (this.fCC != null) {
                this.fCC.n(200002, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doRemoveVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "removeVideoPlayer:ok", null);
        return true;
    }

    private boolean bf(i iVar) {
        this.mgx = false;
        Bundle ap = i.ap(iVar.pug);
        x.i("MicroMsg.MsgHandler", "operate video player  params %s", iVar.pug);
        try {
            if (this.fCC != null) {
                this.fCC.n(200003, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOperateVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "operateVideoPlayer:ok", null);
        return true;
    }

    private boolean bg(i iVar) {
        this.mgx = false;
        JSONObject jSONObject = new JSONObject(iVar.pug);
        String str = (String) iVar.pug.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(61, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "removeSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bh(i iVar) {
        this.mgx = false;
        JSONObject jSONObject = new JSONObject(iVar.pug);
        String str = (String) iVar.pug.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(62, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "updateSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bi(i iVar) {
        this.mgx = false;
        com.tencent.mm.plugin.appbrand.n.a aVar = (com.tencent.mm.plugin.appbrand.n.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.a.class);
        String.valueOf(iVar.pug.get("appId"));
        aVar.Zl();
        a(iVar, "preloadMiniProgramEnv:ok", null);
        return true;
    }

    private boolean bj(i iVar) {
        String str;
        List list;
        this.mgx = false;
        Object obj = iVar.pug.get("userNames");
        String str2 = ":ok";
        if (obj instanceof String) {
            try {
                List A = A(new JSONArray((String) obj));
                str = str2;
                list = A;
            } catch (Exception e) {
                list = null;
                str = ":fail:param type mismatch";
            }
        } else if (obj instanceof JSONArray) {
            str = str2;
            list = A((JSONArray) obj);
        } else if (obj instanceof String[]) {
            str = str2;
            Object list2 = bi.F((String[]) obj);
        } else {
            list2 = null;
            str = ":fail:empty param";
        }
        if (!bi.cC(list2)) {
            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).ab(list2);
        }
        a(iVar, "preloadMiniProgramContacts" + str, null);
        return true;
    }

    private static List<String> A(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        return linkedList;
    }

    private boolean bk(i iVar) {
        this.mgx = false;
        com.tencent.mm.sdk.b.b qrVar = new qr();
        qrVar.fJd.context = this.context;
        qrVar.fJd.userName = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "userName");
        qrVar.fJd.appId = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "appId");
        qrVar.fJd.fJf = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "relativeURL");
        qrVar.fJd.fJh = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "appVersion", 0);
        qrVar.fJd.scene = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "scene", 1018);
        qrVar.fJd.foi = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "sceneNote");
        if (bi.oN(qrVar.fJd.foi)) {
            qrVar.fJd.foi = com.tencent.mm.compatible.util.p.encode(bi.oM(aeH()));
        }
        qrVar.fJd.fwM = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "downloadURL");
        qrVar.fJd.fJg = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "openType", 0);
        qrVar.fJd.fJi = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "checkSumMd5");
        qrVar.fJd.fJk = false;
        qrVar.fJd.fJl.hll = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "extJsonInfo");
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
        if (qrVar.fJe.fJp) {
            a(iVar, "openWeApp:ok", null);
        } else {
            a(iVar, "openWeApp:fail:" + bi.oM(qrVar.fJe.fJq), null);
        }
        return true;
    }

    private boolean bl(i iVar) {
        this.mgx = false;
        x.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", iVar.pug);
        String r = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "userName");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "relativeURL");
        int c = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "appVersion", 0);
        String r3 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "searchId");
        String r4 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "docId");
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "position", 1);
        int c3 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "scene", 1000);
        int c4 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "debugMode", 0);
        if (com.tencent.mm.plugin.webview.modeltools.f.bSm().tqH != null) {
            c4 = 1;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (c3 == 201) {
            appBrandStatObject.scene = 1006;
        } else if (c3 == 3) {
            appBrandStatObject.scene = 1005;
        } else if (c3 == 16) {
            appBrandStatObject.scene = 1042;
        } else if (c3 == 20) {
            appBrandStatObject.scene = 1053;
        } else {
            appBrandStatObject.scene = 1000;
        }
        String r5 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "statSessionId");
        String r6 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "statKeywordId");
        appBrandStatObject.foi = r5 + ":" + r6 + ":" + r3 + ":" + r4 + ":" + c2 + ":" + com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "subScene");
        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(this.context, r, null, c4, c, r2, appBrandStatObject);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new byu();
        aVar.hnU = new byv();
        aVar.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar.hnS = 1873;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        byu byu = (byu) Kf.hnQ.hnY;
        byu.xfP = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "statSessionId");
        byu.xfQ = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "statKeywordId");
        byu.wDX = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "searchId");
        byu.wQr = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "docId");
        byu.xfR = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "position", 1);
        byu.pho = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "userName");
        byu.xfS = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "appVersion", 0);
        byu.xfT = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "adBuffer");
        byu.sfa = c3;
        byu.xfU = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "clickExtInfo");
        final com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20StatSessionId", byu.xfP + ",");
        dVar.q("21KeywordId", byu.xfQ + ",");
        dVar.q("22SearchId", byu.wDX + ",");
        dVar.q("23DocId", byu.wQr + ",");
        dVar.q("24Pos", byu.xfR + ",");
        dVar.q("25AppUserName", byu.pho + ",");
        dVar.q("26AppVersion", byu.xfS + ",");
        dVar.q("27AdBuffer", byu.xfT + ",");
        dVar.q("28AdClickBuffer", byu.xfU + ",");
        dVar.q("29scene", c3 + ",");
        x.i("MicroMsg.MsgHandler", "doClickReportScene oreh" + dVar.SG());
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (!(i == 0 && i2 == 0)) {
                    x.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
                    com.tencent.mm.plugin.report.service.g.pWK.h(13927, dVar);
                    com.tencent.mm.plugin.report.service.g.pWK.a(457, 0, 1, false);
                }
                return 0;
            }
        });
        a(iVar, "openWeAppPage:ok", null);
        return true;
    }

    private boolean bm(i iVar) {
        int c = com.tencent.mm.plugin.webview.fts.f.c(iVar.pug, "logId", 0);
        x.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", Integer.valueOf(c), com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "logString"), iVar.pug);
        aob aob = new aob();
        aob.wBF = c;
        aob.wBN = (int) (System.currentTimeMillis() / 1000);
        aob.kyA = 1;
        aob.wBG = new com.tencent.mm.bp.b(r1.getBytes());
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bj();
        aVar.hnU = new bk();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.hnS = 1802;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        bj bjVar = (bj) Kf.hnQ.hnY;
        aoa aoa = new aoa();
        aoa.vUW = com.tencent.mm.protocal.d.vHf;
        aoa.vUX = com.tencent.mm.protocal.d.vHe;
        aoa.vUY = com.tencent.mm.protocal.d.vHh;
        aoa.vUZ = com.tencent.mm.protocal.d.vHi;
        aoa.vVa = w.cfV();
        aoa.wBM = (int) (System.currentTimeMillis() / 1000);
        bjVar.vNq = aoa;
        bjVar.vNr.add(aob);
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (!(i == 0 && i2 == 0)) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(457, 1, 1, false);
                }
                return 0;
            }
        });
        a(iVar, "reportWeAppSearchRealtime:ok", null);
        return true;
    }

    private boolean bn(i iVar) {
        String str = (String) iVar.pug.get("name");
        String str2 = (String) iVar.pug.get("arg");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            str = "arg";
            if (bi.oN(str2)) {
                str2 = "{}";
            }
            jSONObject.put(str, new JSONObject(str2));
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            this.fCC.e(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, bundle);
            a(iVar, "invokeMiniProgramAPI:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doInvokeMiniProgramApi: %s", e);
            a(iVar, "invokeMiniProgramAPI:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("fts_key_json_data", str);
        bundle2.putString("fts_key_req_id", str2);
        bundle2.putBoolean("fts_key_new_query", z);
        if (bundle != null) {
            bundle2.putBundle("fts_key_data", bundle);
        }
        try {
            if (this.fCC != null) {
                this.fCC.n(119, bundle2);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, Map<String, Object> map) {
        Bundle bundle = new Bundle();
        bundle.putInt("FTS_KEY_onStartWebSearch_type", i);
        bundle.putString("FTS_KEY_onStartWebSearch_query", str);
        bundle.putSerializable("FTS_KEY_onStartWebSearch_params", new HashMap(map));
        try {
            if (this.fCC != null) {
                this.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void Qi(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(124, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }

    public final void cN(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.fCC != null) {
                this.fCC.n(125, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
        }
    }

    public final void aU(int i, String str) {
        x.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", Integer.valueOf(i), str);
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", i);
        bundle.putString("fts_key_data", str);
        try {
            if (this.fCC != null) {
                this.fCC.n(120, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        bundle.putString("requestId", str2);
        try {
            if (this.fCC != null) {
                this.fCC.n(121, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
        }
    }

    public final void W(String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i);
        bundle.putInt("fts_key_is_expired", i2);
        try {
            if (this.fCC != null) {
                this.fCC.n(142, bundle);
            }
        } catch (Exception e) {
        }
    }

    public final boolean bo(i iVar) {
        boolean z = false;
        int i = bi.getInt(bi.bZ(iVar.pug.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "kvReport:fail", null);
        } else {
            boolean z2;
            String bZ = bi.bZ(iVar.pug.get(Columns.VALUE));
            if (bi.getInt(bi.bZ(iVar.pug.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bi.getInt(bi.bZ(iVar.pug.get("is_report_now")), 0) > 0) {
                z = true;
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(i, bZ, z, z2);
            a(iVar, "kvReport:ok", null);
        }
        return true;
    }

    public final String aeH() {
        String str = null;
        if (this.fCC == null) {
            x.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
            return str;
        }
        try {
            return this.fCC.aeH();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", e);
            return str;
        }
    }

    private boolean bp(i iVar) {
        int i;
        String str = (String) iVar.pug.get("miniProgramAppId");
        if (bi.oN(str)) {
            i = 0;
        } else {
            i = ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.a.class)).pO(str);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("reportId", Integer.valueOf(i));
        a(iVar, "reportMiniProgramPageData:ok", hashMap);
        return true;
    }

    private boolean bq(i iVar) {
        int i = 0;
        String r = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "targetAppId");
        String aeH = aeH();
        String qZ = qZ(aeH);
        if (bi.oN(qZ)) {
            qZ = com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "referrerAppId");
        }
        if (bi.oN(r)) {
            a(iVar, "launchMiniProgram:fail_invalid_targetAppId", null);
        } else if (bi.oN(qZ)) {
            a(iVar, "launchMiniProgram:fail_invalid_referrerAppId", null);
        } else {
            String oM = bi.oM(com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "envVersion"));
            int i2 = -1;
            switch (oM.hashCode()) {
                case 110628630:
                    if (oM.equals("trial")) {
                        boolean i22 = true;
                        break;
                    }
                    break;
                case 1559690845:
                    if (oM.equals("develop")) {
                        i22 = 0;
                        break;
                    }
                    break;
            }
            switch (i22) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(this.context, aeH, qZ, r, i, com.tencent.mm.plugin.webview.fts.f.r(iVar.pug, "path"));
            a(iVar, "launchMiniProgram:ok", null);
        }
        return true;
    }

    private boolean br(i iVar) {
        String str = (String) iVar.pug.get("username");
        if (!bi.oN(str)) {
            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rg(str);
        }
        a(iVar, "forceUpdateWxaAttr:ok", null);
        return true;
    }

    private boolean bs(i iVar) {
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) iVar.pug.get("title"));
        bundle.putString("set_page_title_color", (String) iVar.pug.get("color"));
        try {
            this.fCC.e(43, bundle);
            a(iVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", e);
            a(iVar, "setPageTitle:fail", null);
        }
        return true;
    }

    @Deprecated
    private boolean bt(i iVar) {
        String str = (String) iVar.pug.get("color");
        if (bi.oN(str)) {
            x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(iVar, "setStatusBarStyle:fail", null);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.fCC.e(i, Bundle.EMPTY);
                    a(iVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", e);
                    a(iVar, "setStatusBarStyle:fail", null);
                }
            } else {
                x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(iVar, "setStatusBarStyle:fail", null);
            }
        }
        return true;
    }

    private boolean bu(i iVar) {
        if (iVar.pug.containsKey("enable")) {
            try {
                boolean parseBoolean = Boolean.parseBoolean((String) iVar.pug.get("enable"));
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("enable_fullscreen_params_enable", parseBoolean);
                this.fCC.e(45, bundle);
                a(iVar, "enableFullScreen:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", e);
                a(iVar, "enableFullScreen:fail", null);
            }
        } else {
            a(iVar, "enableFullScreen:fail_invalid_arguments", null);
        }
        return true;
    }

    private boolean bv(i iVar) {
        String str = (String) iVar.pug.get("left");
        String str2 = (String) iVar.pug.get("right");
        if (bi.oN(str) && bi.oN(str2)) {
            a(iVar, "setNavigationBarButtons:fail", null);
        } else {
            Bundle bundle = new Bundle();
            try {
                str = new JSONObject(str).optString("color", "");
                if (!bi.oN(str)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", str);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String oM = bi.oM(com.tencent.mm.pluginsdk.ui.tools.s.Ty(jSONObject.optString("iconData", "")));
                str = jSONObject.optString("color", "");
                if (optBoolean) {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                } else {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", oM);
                    bundle.putString("set_navigation_bar_buttons_text_color", str);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                a(iVar, "setNavigationBarButtons:fail_invalid_params", null);
            } else {
                try {
                    this.fCC.e(44, bundle);
                    a(iVar, "setNavigationBarButtons:ok", null);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e22, " setNavigationBarButtons invoke ", new Object[0]);
                    a(iVar, "setNavigationBarButtons:fail_invoke", null);
                }
            }
        }
        return true;
    }

    public final boolean bw(i iVar) {
        try {
            this.fCC.e(34, Bundle.EMPTY);
            a(iVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", e);
            a(iVar, "enablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bx(i iVar) {
        try {
            this.fCC.e(35, Bundle.EMPTY);
            a(iVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", e);
            a(iVar, "startPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean by(i iVar) {
        try {
            this.fCC.e(36, Bundle.EMPTY);
            a(iVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", e);
            a(iVar, "stopPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bVu() {
        try {
            this.fCC.e(47, Bundle.EMPTY);
            a(this.tNN, "disablePullDownRefresh:ok", null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.tNN, "disablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bz(i iVar) {
        this.mgx = false;
        String oM = bi.oM((String) iVar.pug.get("placeholder"));
        int i = bi.getInt((String) iVar.pug.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", oM);
            bundle.putInt("show_kb_max_length", i);
            this.fCC.e(37, bundle);
            this.tOC = iVar;
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", e);
            a(this.fCC, iVar, "showKeyboard:fail", null, true, true);
        }
        return true;
    }

    public final boolean bA(i iVar) {
        this.mgx = false;
        try {
            Bundle e = this.fCC.e(79, new Bundle());
            Map hashMap = new HashMap();
            int i = e.getInt("height", 0);
            if (i > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bu.a.ad(ad.getContext(), i)));
                a(this.fCC, iVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.fCC, iVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e2) {
            x.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", e2);
            a(this.fCC, iVar, "showSmileyPanel:fail", null, true, true);
        }
        return true;
    }

    public final boolean bB(i iVar) {
        String str = (String) iVar.pug.get("place");
        if (bi.oN(str)) {
            a(iVar, "disableBounceScroll:fail", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(iVar, "disableBounceScroll:ok", null);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.fCC.e(38, bundle);
                        a(iVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", e);
                        a(iVar, "disableBounceScroll:fail", null);
                    }
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", str);
                a(iVar, "disableBounceScroll:fail", null);
            }
        }
        return true;
    }

    public final boolean bC(i iVar) {
        try {
            this.fCC.e(39, new Bundle(0));
            a(iVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", e);
            a(iVar, "clearBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bD(i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) iVar.pug.get("backgroundColor"));
        try {
            this.fCC.e(72, bundle);
            a(iVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", e);
            a(iVar, "setBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bE(i iVar) {
        int i = bi.getInt(bi.bZ(iVar.pug.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "realtimeReport:fail", null);
            return true;
        }
        Object obj;
        String bZ = bi.bZ(iVar.pug.get(Columns.VALUE));
        int i2 = bi.getInt(bi.bZ(iVar.pug.get(Columns.TYPE)), 0);
        com.tencent.mm.plugin.webview.model.e bRn = a.tyx;
        if (as.Hp()) {
            long longValue;
            com.tencent.mm.plugin.webview.model.d bSq = com.tencent.mm.plugin.webview.modeltools.f.bSq();
            Long l = (Long) bSq.typ.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor a = bSq.hiZ.a(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)}, 2);
                if (a == null) {
                    longValue = 0;
                } else if (a.moveToFirst()) {
                    longValue = a.getLong(0);
                    a.close();
                } else {
                    a.close();
                    longValue = 0;
                }
            }
            if (longValue != 0 && longValue < bi.Wx()) {
                av avVar = bSq.typ;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    throw new NullPointerException("key == null");
                }
                if (avVar.get(valueOf) != null) {
                    avVar.r(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < bi.Wx()) {
                aob aob = new aob();
                aob.wBF = i;
                aob.wBG = com.tencent.mm.bp.b.TQ(bZ);
                aob.wBO = i2;
                bRn.tyu.add(aob);
                obj = 1;
                if (obj == null) {
                    a(iVar, "realtimeReport:ok", null);
                } else {
                    a(iVar, "realtimeReport:fail", null);
                }
                return true;
            }
        }
        x.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
            a(iVar, "realtimeReport:fail", null);
        } else {
            a(iVar, "realtimeReport:ok", null);
        }
        return true;
    }

    public final boolean bF(i iVar) {
        String str = (String) iVar.pug.get("latitude");
        String str2 = (String) iVar.pug.get("longitude");
        final String str3 = (String) iVar.pug.get("destinationName");
        if (bi.oN(str) || bi.oN(str2)) {
            a(iVar, "openMapNavigateMenu:fail", null);
        } else {
            try {
                final double parseDouble = Double.parseDouble(str);
                final double parseDouble2 = Double.parseDouble(str2);
                final int i = bi.getInt((String) iVar.pug.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.TencentMap.code);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(iVar, "openMapNavigateMenu:fail", null);
                } else {
                    final int aU = aU(iVar);
                    ah.y(new Runnable() {
                        public final void run() {
                            byte b = (byte) 0;
                            if (!(g.this.context == null || !(g.this.context instanceof Activity) || ((Activity) g.this.context).isFinishing())) {
                                j E = g.this.tOb;
                                Context i = g.this.context;
                                int i2 = i;
                                double d = parseDouble;
                                double d2 = parseDouble2;
                                String str = str3;
                                int i3 = aU;
                                d anonymousClass1 = new d() {
                                    public final void Bu(int i) {
                                        aV(i, "cancel");
                                    }

                                    public final void qi(int i) {
                                        aV(i, "fail");
                                    }

                                    public final void vt(int i) {
                                        aV(i, "ok");
                                    }

                                    private void aV(int i, String str) {
                                        c a = g.this.Bs(i);
                                        if (a != null && a.tNN != null && a.fCC != null) {
                                            g.a(g.this, g.this.fCC, g.this.tNN, "openMapNavigateMenu:" + bi.aD(str, "fail"));
                                        }
                                    }

                                    public final void Bv(int i) {
                                        g.this.Bt(i);
                                    }
                                };
                                if (!(i == null || !(i instanceof MMActivity) || ((MMActivity) i).isFinishing())) {
                                    E.tzZ = i3;
                                    E.tQh = true;
                                    E.tQi = i2;
                                    E.tQk = new e(d, d2, (byte) 0);
                                    E.tQl = str;
                                    E.frC = new WeakReference(i);
                                    E.tQm = anonymousClass1;
                                    E.hry = null;
                                    if (E.hry == null) {
                                        E.bVB();
                                    } else {
                                        E.tQp = new com.tencent.mm.modelgeo.a.a() {
                                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                                if (j.this.hry != null) {
                                                    j.this.hry.c(this);
                                                }
                                                if (z) {
                                                    j.this.tQj = new e((double) f2, (double) f, (byte) 0);
                                                    if (j.this.obF != null) {
                                                        j.this.tQn = new com.tencent.mm.modelgeo.b.a() {
                                                            public final void b(Addr addr) {
                                                                if (j.this.tQj != null && j.this.tQn != null) {
                                                                    j.this.tQj.tQt = addr.OS();
                                                                    j.this.bVB();
                                                                }
                                                            }
                                                        };
                                                        j.this.obF.a((double) f2, (double) f, j.this.tQn);
                                                        return false;
                                                    }
                                                }
                                                j.this.bVB();
                                                return false;
                                            }
                                        };
                                        if (E.obF != null) {
                                            E.tQo = new com.tencent.mm.modelgeo.b.a() {
                                                public final void b(Addr addr) {
                                                    if (j.this.tQk != null && j.this.tQo != null) {
                                                        j.this.tQk.tQt = addr.OS();
                                                    }
                                                }
                                            };
                                            E.obF.a(E.tQk.latitude, E.tQk.longitude, E.tQo);
                                        }
                                        ah.y(new Runnable() {
                                            public final void run() {
                                                if (j.this.frC != null && j.this.frC.get() != null) {
                                                    Toast.makeText((Context) j.this.frC.get(), R.l.eKV, 0).show();
                                                }
                                            }
                                        });
                                        E.hry.b(E.tQp);
                                        ah.h(E.tQq, 4000);
                                    }
                                    b = (byte) 1;
                                }
                            }
                            if (b == (byte) 0) {
                                c a = g.this.Bs(aU);
                                if (a.fCC != null && a.tNN != null) {
                                    g.a(g.this, a.fCC, a.tNN, "openMapNavigateMenu:fail");
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(iVar, "openMapNavigateMenu:fail", null);
            }
        }
        return true;
    }

    public final Bundle bVv() {
        Bundle bundle = null;
        try {
            bundle = this.fCC.e(33, null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", bundle);
        return bundle;
    }

    private boolean bG(i iVar) {
        String str = (String) iVar.pug.get("operationType");
        String str2 = (String) iVar.pug.get("dataUrl");
        k.a(iVar.tQf, false, null, "");
        if (bi.oN(str) || bi.oN(str2)) {
            a(iVar, "operateMusicPlayer:fail", null);
            return true;
        }
        Object obj;
        if (str.equalsIgnoreCase("play")) {
            String str3 = (String) iVar.pug.get("title");
            String str4 = (String) iVar.pug.get("singer");
            String str5 = (String) iVar.pug.get("epname");
            String str6 = (String) iVar.pug.get("coverImgUrl");
            String str7 = (String) iVar.pug.get("lowbandUrl");
            String str8 = (String) iVar.pug.get("webUrl");
            iVar.pug.get("lyric");
            x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", str3, str4, str5, str6, str2, str7, str8, "");
            if (bi.oN(str3) || bi.oN(str4) || bi.oN(str5) || bi.oN(str6) || bi.oN(str7) || bi.oN(str2) || bi.oN(str8)) {
                a(iVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.au.b.Qv();
                com.tencent.mm.au.a.a aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
                String str9 = str2.hashCode();
                String str10 = com.tencent.mm.compatible.util.e.bnF;
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                com.tencent.mm.au.b.b(aVar.a(7, str6, str3, str4, str8, str7, str2, str9, str10, stringBuilder.append(com.tencent.mm.y.c.Fp()).append(str6.hashCode()).toString(), str5, ""));
                a(iVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.au.c.lO(str2) && com.tencent.mm.au.b.Qy() && !com.tencent.mm.au.b.Qx()) {
                com.tencent.mm.au.b.ya();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.au.c.lO(str2) && com.tencent.mm.au.b.Qx()) {
                com.tencent.mm.au.b.xZ();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.au.b.Qw();
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            if (com.tencent.mm.au.c.lO(str2) ? com.tencent.mm.au.b.ii(bi.getInt(bi.bZ(iVar.pug.get("position")), -1) * 1000) : false) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (com.tencent.mm.au.c.lO(str2) && com.tencent.mm.au.b.Qy()) {
                com.tencent.mm.au.b.Qv();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(iVar, "operateMusicPlayer:fail", null);
        }
        return true;
    }

    private boolean bH(i iVar) {
        String str = (String) iVar.pug.get("dataUrl");
        k.a(iVar.tQf, false, null, (String) iVar.pug.get("appId"));
        if (bi.oN(str)) {
            a(iVar, "getMusicPlayerState:fail_dataUrl_null", null);
        } else {
            x.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", str, r1);
            ati Qz = com.tencent.mm.au.b.Qz();
            if (Qz == null || !Qz.wHz.equals(str)) {
                a(iVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                int i2;
                com.tencent.mm.au.d QA = com.tencent.mm.au.b.QA();
                if (QA != null) {
                    i = QA.mDuration;
                    i2 = QA.mPosition;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (QA == null || i < 0 || i2 < 0) {
                    a(iVar, "getMusicPlayerState:fail", null);
                } else {
                    i /= 1000;
                    i2 /= 1000;
                    int i3 = QA.mStatus;
                    int i4 = QA.hJL;
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentPosition", Integer.valueOf(i2));
                    hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(iVar, "getMusicPlayerState:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bI(i iVar) {
        String str = (String) iVar.pug.get("localId");
        if (bi.oN(str)) {
            a(iVar, "getLocalImgData:fail_invaild_localid", null);
        } else {
            WebViewJSSDKFileItem OS = com.tencent.mm.plugin.webview.modeltools.f.bSo().OS(str);
            if (!(OS == null || OS.jlG == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(OS.jlG);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    x.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length()));
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(iVar, "getLocalImgData:ok", hashMap);
                    decodeFile.recycle();
                }
            }
            a(iVar, "getLocalImgData:fail", null);
        }
        return true;
    }

    private boolean bJ(i iVar) {
        int i = 0;
        this.mgx = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = bi.getInt(iVar.pug.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            x.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", Integer.valueOf(i2));
            if (-1 == bundle.getInt("scene")) {
                a(iVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.fCC.e(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(iVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case org.xwalk.core.R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                            break;
                        case 33:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case 34:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            hashMap.put("content", bundle.getString("content"));
                            x.i("MicroMsg.MsgHandler", "content = " + bundle.getString("content"));
                            break;
                        case 51:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            a(iVar, "doExposePreparation fail:unknown scene", null);
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("content");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    if (hashMap.get("content") == null) {
                        hashMap.put("content", jSONArray.toString());
                    }
                    a(iVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(iVar, "doExposePreparation fail", null);
        }
        return true;
    }

    private boolean bK(i iVar) {
        try {
            String obj = iVar.pug.get(Columns.TYPE).toString();
            Intent intent;
            if (bi.oN(obj)) {
                a(iVar, "openLuckyMoneyHistory:fail", null);
            } else if (obj.equals("send")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bl.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            } else if (obj.equals("receive")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                com.tencent.mm.bl.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenLuckyMoneyHistory error %s", e);
            a(iVar, "openLuckyMoneyHistory:fail", null);
        }
        return true;
    }

    private boolean bL(i iVar) {
        this.mgx = false;
        String trim = iVar.pug.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(iVar, "openSecurityView fail, scene error : " + trim, null);
        } else if (iVar.pug.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(iVar.pug.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                com.tencent.mm.bl.d.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(iVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(iVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(iVar, "openSecurityView fail, no userData", null);
        }
        return true;
    }

    private boolean bM(i iVar) {
        String qZ = qZ(aeH());
        String yL = com.tencent.mm.compatible.e.q.yL();
        String yM = com.tencent.mm.compatible.e.q.yM();
        if (bi.oN(yL) || bi.oN(qZ) || bi.oN(yM)) {
            a(iVar, "getOpenDeviceId:fail", null);
        } else {
            yL = com.tencent.mm.sdk.platformtools.ac.VF(com.tencent.mm.sdk.platformtools.ac.VF(qZ + yL));
            qZ = com.tencent.mm.sdk.platformtools.ac.VF(com.tencent.mm.sdk.platformtools.ac.VF(qZ + yM));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", yL);
            hashMap.put("newDeviceId", qZ);
            a(iVar, "getOpenDeviceId:ok", hashMap);
        }
        return true;
    }

    private boolean bN(i iVar) {
        try {
            Bundle e = this.fCC.e(90000, null);
            if (e != null) {
                String str;
                String str2;
                String str3;
                Object[] objArr;
                Map hashMap;
                JSONArray jSONArray;
                String[] stringArray = e.getStringArray("webview_get_route_url_list");
                int i = e.getInt("webview_get_route_url_geta8key_scene");
                if (i == 7) {
                    String string = e.getString("geta8key_username");
                    if (!bi.oN(string)) {
                        com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(string);
                        if (jV != null) {
                            str = jV.field_appId;
                            str2 = "MicroMsg.MsgHandler";
                            str3 = "routeUrl length = %d, scene = %d, appid = %s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = str;
                            x.i(str2, str3, objArr);
                            if (stringArray != null && stringArray.length > 0) {
                                hashMap = new HashMap();
                                jSONArray = new JSONArray();
                                for (Object put : stringArray) {
                                    jSONArray.put(put);
                                }
                                hashMap.put("urls", jSONArray.toString());
                                hashMap.put("scene", Integer.valueOf(i));
                                if (!bi.oN(str)) {
                                    hashMap.put("appid", str);
                                }
                                a(iVar, "getRouteUrl:ok", hashMap);
                                return true;
                            }
                        }
                    }
                }
                str = null;
                str2 = "MicroMsg.MsgHandler";
                str3 = "routeUrl length = %d, scene = %d, appid = %s";
                objArr = new Object[3];
                if (stringArray == null) {
                }
                objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str;
                x.i(str2, str3, objArr);
                hashMap = new HashMap();
                jSONArray = new JSONArray();
                while (r0 < r8) {
                    jSONArray.put(put);
                }
                hashMap.put("urls", jSONArray.toString());
                hashMap.put("scene", Integer.valueOf(i));
                if (bi.oN(str)) {
                    hashMap.put("appid", str);
                }
                a(iVar, "getRouteUrl:ok", hashMap);
                return true;
            }
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", e2.getMessage());
        }
        a(iVar, "getRouteUrl:fail", null);
        return true;
    }

    private boolean bO(i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetBackgroundAudioState()");
        if (bQ(iVar)) {
            ati Qz = com.tencent.mm.au.b.Qz();
            if (Qz != null) {
                int i;
                int i2;
                com.tencent.mm.au.d QA = com.tencent.mm.au.b.QA();
                if (QA != null) {
                    i = QA.mDuration;
                    i2 = QA.mPosition;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (QA == null || i < 0 || i2 < 0) {
                    x.e("MicroMsg.MsgHandler", "return parameter is invalid");
                    a(iVar, "getBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.sdk.b.a.xmy.b(this.tOD);
                    i /= 1000;
                    int i3 = i2 / 1000;
                    int i4 = QA.mStatus;
                    i2 = QA.hJL;
                    if (i > 0) {
                        i2 = (i2 * i) / 100;
                    } else {
                        i2 = 0;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentTime", Integer.valueOf(i3));
                    hashMap.put("paused", Integer.valueOf(i4 == 1 ? 0 : 1));
                    hashMap.put("src", Qz.wHz);
                    hashMap.put("buffered", Integer.valueOf(i2));
                    hashMap.put("title", Qz.wHv);
                    hashMap.put("epname", Qz.wHx);
                    hashMap.put("singer", Qz.wHw);
                    hashMap.put("coverImgUrl", Qz.wHy);
                    hashMap.put("isLive", Integer.valueOf(0));
                    hashMap.put("startTime", Integer.valueOf(Qz.hmd / 1000));
                    hashMap.put("srcId", Qz.hJD);
                    hashMap.put("protocol", Qz.protocol == null ? "" : Qz.protocol);
                    hashMap.put("webUrl", Qz.wHB);
                    hashMap.put("playState", QA.hJM);
                    x.i("MicroMsg.MsgHandler", "getBackgroundAudioState ok");
                    a(iVar, "getBackgroundAudioState:ok", hashMap);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                a(iVar, "getBackgroundAudioState:fail", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "no permission to do get state");
            a(iVar, "getBackgroundAudioState:fail", null);
        }
        return true;
    }

    private boolean e(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String Qf;
        String str;
        String Pe;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        String str10;
        boolean go;
        String str11;
        x.i("MicroMsg.MsgHandler", "doSetBackgroundAudioState()");
        com.tencent.mm.sdk.b.a.xmy.b(this.tOD);
        CharSequence charSequence = (String) iVar.pug.get("appId");
        if (this.tNQ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.tNQ.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                Qf = this.tNZ.Qf(aeH());
                x.i("MicroMsg.MsgHandler", "appId:%s", Qf);
                k.a(iVar.tQf, false, null, Qf);
                str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (bi.oN(str)) {
                    Pe = com.tencent.mm.plugin.webview.modelcache.p.Pe(str);
                } else {
                    Pe = null;
                }
                str2 = (String) iVar.pug.get("src");
                str3 = (String) iVar.pug.get("lowbandSrc");
                str4 = (String) iVar.pug.get("title");
                str5 = (String) iVar.pug.get("epname");
                str6 = (String) iVar.pug.get("singer");
                str = (String) iVar.pug.get("coverImgUrl");
                str7 = (String) iVar.pug.get("webUrl");
                i = bi.getInt((String) iVar.pug.get("startTime"), 0);
                str8 = (String) iVar.pug.get("srcId");
                str9 = (String) iVar.pug.get("protocol");
                str10 = (String) iVar.pug.get("musicbar_url");
                go = jsapiPermissionWrapper.go(308);
                if (str != null) {
                    str11 = "";
                } else {
                    str11 = str;
                }
                x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(go), str10);
                if (!bi.oN(str2) || bi.oN(str4)) {
                    x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
                    a(iVar, "setBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.au.a.a aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
                    String str12 = str2.hashCode();
                    String str13 = com.tencent.mm.compatible.util.e.bnF;
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    ati a = aVar.a(10, str11, str4, str6, str7, str3, str2, str12, str13, stringBuilder.append(com.tencent.mm.y.c.Fp()).append(str11.hashCode()).toString(), str5, Qf);
                    a.wHN = Pe;
                    a.hmd = i * 1000;
                    a.hJD = str8;
                    a.protocol = str9;
                    a.wHO = go;
                    a.wHP = str10;
                    com.tencent.mm.au.b.b(a);
                    x.i("MicroMsg.MsgHandler", "setBackgroundAudioState ok");
                    a(iVar, "setBackgroundAudioState:ok", null);
                }
                return true;
            }
        }
        CharSequence Qf2 = charSequence;
        x.i("MicroMsg.MsgHandler", "appId:%s", Qf2);
        k.a(iVar.tQf, false, null, Qf2);
        str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            Pe = null;
        } else {
            Pe = com.tencent.mm.plugin.webview.modelcache.p.Pe(str);
        }
        str2 = (String) iVar.pug.get("src");
        str3 = (String) iVar.pug.get("lowbandSrc");
        str4 = (String) iVar.pug.get("title");
        str5 = (String) iVar.pug.get("epname");
        str6 = (String) iVar.pug.get("singer");
        str = (String) iVar.pug.get("coverImgUrl");
        str7 = (String) iVar.pug.get("webUrl");
        i = bi.getInt((String) iVar.pug.get("startTime"), 0);
        str8 = (String) iVar.pug.get("srcId");
        str9 = (String) iVar.pug.get("protocol");
        str10 = (String) iVar.pug.get("musicbar_url");
        go = jsapiPermissionWrapper.go(308);
        if (str != null) {
            str11 = str;
        } else {
            str11 = "";
        }
        x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(go), str10);
        if (bi.oN(str2)) {
        }
        x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
        a(iVar, "setBackgroundAudioState:fail", null);
        return true;
    }

    private boolean bP(i iVar) {
        String str = (String) iVar.pug.get("operationType");
        x.i("MicroMsg.MsgHandler", "doOperateBackgroundAudio(), optype:%s", str);
        String str2 = (String) iVar.pug.get("appId");
        if (this.tNQ != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.tNQ.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.tNZ.Qf(aeH());
            }
        }
        k.a(iVar.tQf, false, null, str2);
        if (!bQ(iVar)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio getMusicPermission is false");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio optype is empty");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else {
            com.tencent.mm.sdk.b.a.xmy.b(this.tOD);
            if (str.equalsIgnoreCase("play")) {
                if (com.tencent.mm.au.c.QB()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio play fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                if (com.tencent.mm.au.c.QB()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio resume fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (com.tencent.mm.au.c.QC()) {
                    com.tencent.mm.au.b.Qw();
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio pause fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("seek")) {
                int i = bi.getInt((String) iVar.pug.get("currentTime"), -1);
                x.i("MicroMsg.MsgHandler", "currentTime:%d", Integer.valueOf(i));
                if (i < 0) {
                    x.e("MicroMsg.MsgHandler", "currentTime is invalid!");
                    a(iVar, "operateBackgroundAudio:fail", null);
                } else if (com.tencent.mm.au.b.ii(i * 1000)) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio seek fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (!str.equalsIgnoreCase("stop")) {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio fail, invalid opeType");
                a(iVar, "operateBackgroundAudio:fail", null);
            } else if (com.tencent.mm.au.c.QD()) {
                a(iVar, "operateBackgroundAudio:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio stop fail");
                a(iVar, "operateBackgroundAudio:fail", null);
            }
        }
        return true;
    }

    private boolean bQ(i iVar) {
        Object Qf;
        String str;
        Object obj;
        String Pe;
        String str2;
        boolean z;
        String str3;
        String str4;
        Object[] objArr;
        int i = 1;
        ati Qz = com.tencent.mm.au.b.Qz();
        CharSequence charSequence = (String) iVar.pug.get("appId");
        if (this.tNQ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.tNQ.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                Qf = this.tNZ.Qf(aeH());
                str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                obj = null;
                if (!bi.oN(str)) {
                    obj = com.tencent.mm.plugin.webview.modelcache.p.Pe(str);
                }
                if (Qz == null) {
                    str = Qz.nlV;
                    Pe = com.tencent.mm.plugin.webview.modelcache.p.Pe(Qz.wHB);
                    str2 = Qz.wHN;
                    x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", Qf, str);
                    x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", obj, Pe, str2);
                    if (TextUtils.isEmpty(Qf) && Qf.equalsIgnoreCase(str)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(Pe)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str2)) {
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                    z = false;
                }
                str3 = "MicroMsg.MsgHandler";
                str4 = "getMusicPermission hasPermmision:%d";
                objArr = new Object[1];
                if (!z) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                x.i(str3, str4, objArr);
                return z;
            }
        }
        CharSequence Qf2 = charSequence;
        str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        obj = null;
        if (bi.oN(str)) {
            obj = com.tencent.mm.plugin.webview.modelcache.p.Pe(str);
        }
        if (Qz == null) {
            x.e("MicroMsg.MsgHandler", "currentWrapper is null");
            z = false;
        } else {
            str = Qz.nlV;
            Pe = com.tencent.mm.plugin.webview.modelcache.p.Pe(Qz.wHB);
            str2 = Qz.wHN;
            x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", Qf2, str);
            x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", obj, Pe, str2);
            if (TextUtils.isEmpty(Qf2)) {
            }
            z = false;
            z = true;
            z = true;
        }
        str3 = "MicroMsg.MsgHandler";
        str4 = "getMusicPermission hasPermmision:%d";
        objArr = new Object[1];
        if (z) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        x.i(str3, str4, objArr);
        return z;
    }

    private boolean bR(i iVar) {
        String H = ar.hhz.H("login_user_name", "");
        String str = (String) iVar.pug.get("request_ticket");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "requestVoiceLoginVerify, ticket is null");
            a(iVar, "requestVoiceLoginVerify:ticket is null", null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Kusername", H);
            intent.putExtra("Kvertify_key", str);
            if (this.context instanceof MMActivity) {
                ((MMActivity) this.context).jCj = this;
                com.tencent.mm.bl.d.b(this.context, "voiceprint", ".ui.VoiceLoginUI", intent, 57);
            }
        }
        return true;
    }

    private boolean bS(i iVar) {
        Map hashMap = new HashMap();
        try {
            o(iVar);
            String str = (String) iVar.pug.get("next_step");
            x.i("MicroMsg.MsgHandler", "next_step: %s", str);
            if (!bi.oN(str)) {
                if ("auth_again".equals(str)) {
                    if (this.context != null && (this.context instanceof MMActivity)) {
                        Intent intent = new Intent();
                        if (((MMActivity) this.context).getIntent().hasExtra("VoiceLoginAuthPwd")) {
                            intent.putExtra("VoiceLoginAuthPwd", ((MMActivity) this.context).getIntent().getStringExtra("VoiceLoginAuthPwd"));
                        }
                        ((MMActivity) this.context).setResult(-1);
                    }
                } else if ("get_reg_verify_code".equals(str)) {
                    if (this.context != null && (this.context instanceof MMActivity)) {
                        ((MMActivity) this.context).setResult(-1);
                    }
                } else if ("go_reg_from_login".equals(str) && this.context != null && (this.context instanceof MMActivity)) {
                    ((MMActivity) this.context).setResult(-1);
                }
            }
            hashMap.put("err_code", Integer.valueOf(0));
            hashMap.put("err_msg", "ok");
            a(iVar, "close window and next:ok", hashMap);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
            hashMap.put("err_code", Integer.valueOf(1));
            hashMap.put("err_msg", "fail");
            a(iVar, "close window and next:fail", hashMap);
        }
        return true;
    }

    private boolean bT(i iVar) {
        String str = (String) iVar.pug.get("username");
        if (bi.oN(str)) {
            a(iVar, "open_biz_chat:param_err", null);
        } else {
            as.Hm();
            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
            if (Xv == null || !Xv.ciN()) {
                a(iVar, "open_biz_chat:not biz username", null);
            } else if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.bl.d.a(this.context, ".ui.chatting.ChattingUI", intent);
                a(iVar, "open_biz_chat:ok", null);
            } else {
                a(iVar, "open_biz_chat:unfollow", null);
            }
        }
        return true;
    }

    private boolean bU(i iVar) {
        String str = (String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(str)) {
            x.i("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView, url is null");
            a(iVar, "openGameUrlWithExtraWebView:fail", null);
        } else {
            int i;
            String str2 = (String) iVar.pug.get("statusBarColor");
            if (bi.oN(str2)) {
                i = 0;
            } else {
                try {
                    i = Color.parseColor(str2);
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView: " + e.getMessage());
                    a(iVar, "openGameUrlWithExtraWebView:fail_invalid_color", null);
                }
            }
            str2 = (String) iVar.pug.get("statusBarStyle");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("customize_status_bar_color", i);
            intent.putExtra("status_bar_style", str2);
            com.tencent.mm.sdk.b.b kkVar = new kk();
            kkVar.fCB.type = 0;
            kkVar.fCB.context = this.context;
            kkVar.fCB.intent = intent;
            kkVar.fCB.fCC = this.fCC;
            com.tencent.mm.sdk.b.a.xmy.m(kkVar);
            a(iVar, "openGameUrlWithExtraWebView:ok", null);
        }
        return true;
    }

    private boolean bV(i iVar) {
        String qZ = qZ(aeH());
        if (bi.oN(qZ)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "setGameData:fail_appid_null", null);
        } else {
            String str = (String) iVar.pug.get("key");
            String str2 = (String) iVar.pug.get(Columns.VALUE);
            String str3 = (String) iVar.pug.get("weight");
            String str4 = (String) iVar.pug.get("expireTime");
            boolean z = bi.getBoolean((String) iVar.pug.get("autoClean"), true);
            if (bi.oN(str) || bi.oN(str2)) {
                x.i("MicroMsg.MsgHandler", "key or value is null");
                a(iVar, "setGameData:fail_null_key", null);
            } else if (com.tencent.mm.plugin.webview.b.b.bPO().a(qZ, str, str2, str3, str4, z)) {
                a(iVar, "setGameData:ok", null);
            } else {
                a(iVar, "setGameData:fail_exceed_size", null);
            }
        }
        return true;
    }

    private boolean bW(i iVar) {
        String qZ = qZ(aeH());
        if (bi.oN(qZ)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "getGameData:fail", null);
        } else {
            String str = (String) iVar.pug.get("key");
            if (bi.oN(str)) {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "getGameData:fail", null);
            } else {
                com.tencent.mm.plugin.webview.b.a eO = com.tencent.mm.plugin.webview.b.b.bPO().eO(qZ, str);
                if (bi.oN(eO.field_value)) {
                    a(iVar, "getGameData:ok", null);
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put(Columns.VALUE, eO.field_value);
                    hashMap.put("weight", eO.field_weight);
                    hashMap.put("expireTime", Long.valueOf(eO.field_expireTime - (System.currentTimeMillis() / 1000)));
                    a(iVar, "getGameData:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bX(i iVar) {
        String qZ = qZ(aeH());
        if (bi.oN(qZ)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "clearData:fail", null);
        } else {
            String str = (String) iVar.pug.get("keys");
            boolean z = bi.getBoolean((String) iVar.pug.get("clearAllData"), false);
            if (!bi.oN(str)) {
                try {
                    com.tencent.mm.plugin.webview.b.b.bPO().b(qZ, new JSONArray(str));
                    a(iVar, "clearGameData:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doClearData: " + e.getMessage());
                    a(iVar, "clearGameData:fail", null);
                }
            } else if (z) {
                com.tencent.mm.plugin.webview.b.b.bPO().OA(qZ);
                a(iVar, "clearGameData:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "clearGameData:fail", null);
            }
        }
        return true;
    }

    private boolean bY(i iVar) {
        this.mgx = false;
        a(iVar, "recordHistory:ok", null);
        if (j.Rj().Rk()) {
            String Cu = ak.Cu((String) iVar.pug.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
            if (bi.oN(Cu)) {
                a(iVar, "recordHistory:fail", null);
            } else {
                boolean z;
                String str;
                String oM;
                int i = bi.getInt((String) iVar.pug.get("webview_scene"), 0);
                if (i == 33 || i == 46) {
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission false, getA8keyScene = " + i);
                    z = false;
                } else if (Cu.startsWith("http")) {
                    Uri parse = Uri.parse(Cu);
                    str = parse.getHost() + parse.getPath();
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission, hostPath: " + str);
                    String string = com.tencent.mm.plugin.webview.model.y.a.bRx().getString("oauth_host_paths");
                    if (bi.oN(string)) {
                        string = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    String[] split = string.split(";");
                    if (str.contains("weixin110.qq.com")) {
                        z = false;
                    } else if ("weixin110.qq.com;res.wx.qq.com;weops.qq.com;wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;payapp.weixin.qq.com;pay.weixin.qq.com;wx.tenpay.com".contains(parse.getHost().toLowerCase())) {
                        x.i("MicroMsg.MsgHandler", "forbidden host %s", parse.getHost());
                        z = false;
                    } else {
                        for (String oM2 : split) {
                            if (str.equalsIgnoreCase(oM2)) {
                                z = false;
                                break;
                            }
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    oM2 = bi.oM((String) iVar.pug.get("title"));
                    str = bi.oM((String) iVar.pug.get("source"));
                    String oM3 = bi.oM((String) iVar.pug.get("img_url"));
                    x.i("MicroMsg.MsgHandler", "doRecordHistory link %s,title %s,source %s,imgUrl %s", Cu, oM2, str, oM3);
                    com.tencent.mm.plugin.webview.b.e bSs = com.tencent.mm.plugin.webview.modeltools.f.bSs();
                    com.tencent.mm.sdk.e.c dVar = new com.tencent.mm.plugin.webview.b.d();
                    dVar.field_link = Cu;
                    if (!bSs.b(dVar, "link")) {
                        dVar = null;
                    }
                    if (dVar != null) {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory update");
                        dVar.field_link = Cu;
                        dVar.field_title = oM2;
                        dVar.field_source = str;
                        dVar.field_imgUrl = oM3;
                        dVar.field_timeStamp = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.webview.modeltools.f.bSs().c(dVar, new String[0]);
                    } else {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory insert");
                        com.tencent.mm.plugin.webview.b.e bSs2 = com.tencent.mm.plugin.webview.modeltools.f.bSs();
                        com.tencent.mm.sdk.e.c dVar2 = new com.tencent.mm.plugin.webview.b.d();
                        dVar2.field_link = Cu;
                        dVar2.field_title = oM2;
                        dVar2.field_source = str;
                        dVar2.field_imgUrl = oM3;
                        dVar2.field_timeStamp = System.currentTimeMillis() / 1000;
                        dVar2.field_recordId = Cu.hashCode() + "_" + System.currentTimeMillis();
                        x.i("MicroMsg.WebViewHistoryStorage", "insert: " + bSs2.b(dVar2));
                        com.tencent.mm.by.a.post(new Runnable() {
                            public final void run() {
                                String str = "WebViewHistory";
                                e.this.fD(str, "delete from WebViewHistory where  timeStamp < " + ((System.currentTimeMillis() / 1000) - 604800));
                                e.a(e.this);
                            }
                        });
                    }
                    a(iVar, "recordHistory:ok", null);
                } else {
                    a(iVar, "recordHistory:fail", null);
                }
            }
        } else {
            x.i("MicroMsg.MsgHandler", "doRecordHistory switch close");
        }
        return true;
    }

    private boolean bZ(i iVar) {
        Map hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(com.b.a.a.a.hM()));
        hashMap.put("cpuFreqHz", Integer.valueOf(com.b.a.a.a.hN()));
        hashMap.put("memory", Long.valueOf(com.b.a.a.a.s(ad.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        a(iVar, "getCpuMenInfo:ok", hashMap);
        return true;
    }

    private boolean ca(i iVar) {
        try {
            x.i("MicroMsg.MsgHandler", "doServiceClick, tid = %s", (String) iVar.pug.get("tid"));
            Bundle bundle = new Bundle();
            bundle.putString("service_click_tid", r0);
            this.fCC.n(70, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        this.mgx = false;
        return false;
    }

    private boolean cb(i iVar) {
        String qZ = qZ(aeH());
        if (bi.oN(qZ)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]appid is null, return");
            a(iVar, "openRealnameAuth:fail appid is null", null);
            return false;
        }
        String str = (String) iVar.pug.get("categoryId");
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]categoryId is null, return");
            a(iVar, "openRealnameAuth:fail categoryId is null", null);
            return false;
        }
        Intent putExtra = new Intent().putExtra("intent_appid", qZ).putExtra("intent_category_id", str);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jCj = this;
            com.tencent.mm.bl.d.b(this.context, "appbrand", ".ui.autofill.AppBrandIDCardUI", putExtra, 62);
            return true;
        }
        x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]context is err, return");
        a(iVar, "openRealnameAuth:fail context is err", null);
        return false;
    }

    private boolean cc(i iVar) {
        this.fzX = f(iVar);
        if (this.fzX == null) {
            x.e("MicroMsg.MsgHandler", "doSendSingleAppMessage fail, appmsg is null");
            a(iVar, "sendSingleAppMessage:fail", null);
        } else {
            Serializable hashMap = new HashMap();
            hashMap.put("img_url", (String) iVar.pug.get("img_url"));
            hashMap.put("desc", (String) iVar.pug.get("desc"));
            hashMap.put("title", (String) iVar.pug.get("title"));
            hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, (String) iVar.pug.get("link"));
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 7);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("Select_block_List", q.FY());
            intent.putExtra("Select_block_List", "filehelper," + q.FY());
            intent.putExtra("scene_from", 10);
            intent.putExtra("webview_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            if (this.context instanceof MMActivity) {
                com.tencent.mm.bl.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 61, (com.tencent.mm.ui.MMActivity.a) this);
            }
        }
        return true;
    }
}
