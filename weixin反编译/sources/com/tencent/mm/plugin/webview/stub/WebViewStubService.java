package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.y;
import com.tencent.mm.bb.g;
import com.tencent.mm.f.a.cb;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.cz;
import com.tencent.mm.f.a.da;
import com.tencent.mm.f.a.db;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.fa;
import com.tencent.mm.f.a.fd;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.go;
import com.tencent.mm.f.a.gz;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.f.a.km;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.f.a.nk;
import com.tencent.mm.f.a.qp;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.fts.k;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.AnonymousClass68;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewStubService extends Service implements e {
    private List<WebViewStubCallbackWrapper> fwA = new ArrayList();
    private c gNJ = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        private boolean a(mt mtVar) {
            if ((mtVar instanceof mt) && (WebViewStubService.this.ndC == null || WebViewStubService.this.ndC.containsKey(mtVar.fFy.filePath))) {
                if (WebViewStubService.this.ndC != null) {
                    WebViewStubService.this.ndC.remove(mtVar.fFy.filePath);
                }
                x.d("MicroMsg.WebViewStubService", "result: " + mtVar.fFy.result);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        webViewStubCallbackWrapper.tEI.f(mtVar.fFy.filePath, mtVar.fFy.result, mtVar.fFy.fqW, mtVar.fFy.fqX);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
                }
            }
            return false;
        }
    };
    private ag handler;
    private n mKs;
    private Map<String, Integer> ndC;
    private com.tencent.mm.plugin.webview.stub.d.a tBW = new com.tencent.mm.plugin.webview.stub.d.a() {
        public final void q(int i, Bundle bundle) {
            com.tencent.mm.plugin.webview.c.a bSj = f.bSj();
            Map hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    bSj.V(hashMap);
                    return;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", Integer.valueOf(i));
                    return;
            }
        }

        public final void h(int i, Bundle bundle) {
            e bSl = f.bSl();
            switch (i) {
                case 1:
                    bSl.tsL.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    com.tencent.mm.plugin.webview.fts.e.e eVar = bSl.tsR;
                    if (!(!eVar.ttl) || bi.oN(eVar.fEe)) {
                        x.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", eVar.fEe);
                    } else {
                        x.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", Boolean.valueOf(eVar.ttl), eVar.fEe, Boolean.valueOf(eVar.fpa), Boolean.valueOf(eVar.skB), Integer.valueOf(eVar.mVj));
                        g.a(eVar.scene, eVar.fEe, eVar.skB, eVar.fpa, eVar.mVj);
                        eVar.ttl = true;
                    }
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", Integer.valueOf(r4));
                    return;
                case 3:
                    if (bSl.mRL != null) {
                        ((m) com.tencent.mm.kernel.g.k(m.class)).cancelSearchTask(bSl.mRL);
                    }
                    com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                    gVar.fEe = bundle.getString("query");
                    gVar.mRH = bundle.getInt("count");
                    gVar.mRK = bSl.pni;
                    bSl.mRL = ((m) com.tencent.mm.kernel.g.k(m.class)).search(8, gVar);
                    bSl.mRL.mQY = Integer.valueOf(bundle.getInt("webview_id"));
                    d dVar = new d();
                    dVar.scene = bundle.getInt("scene");
                    dVar.foW = bundle.getString("query");
                    dVar.tqs = 1;
                    dVar.fEg = bundle.getInt("webview_id");
                    if (bSl.tsO != null) {
                        as.CN().c(bSl.tsO);
                    }
                    bSl.tsO = new k(dVar);
                    as.CN().a(1161, bSl);
                    as.CN().a(bSl.tsO, 0);
                    return;
                case 5:
                    ((m) com.tencent.mm.kernel.g.k(m.class)).deleteSOSHistory(bundle.getString("history"));
                    return;
                default:
                    return;
            }
        }

        public final Bundle o(int i, Bundle bundle) {
            f.bSl();
            return com.tencent.mm.plugin.webview.fts.e.o(i, bundle);
        }

        public final String gw(String str) {
            as.Hm();
            return com.tencent.mm.y.c.Ff().Xv(str).AW();
        }

        public final boolean gH(String str) {
            return s.gH(str);
        }

        public final boolean hq(String str) {
            return s.hq(str);
        }

        public final boolean gI(String str) {
            boolean Hp = as.Hp();
            x.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + Hp);
            if (Hp) {
                return s.gI(str);
            }
            return false;
        }

        public final boolean zl() {
            return com.tencent.mm.compatible.util.f.zl();
        }

        public final boolean aPk() {
            return as.Hp();
        }

        @Deprecated
        public final void a(final int i, final Bundle bundle, final int i2) {
            x.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", Integer.valueOf(i), Integer.valueOf(i2));
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    int i;
                    int i2;
                    Intent intent;
                    String str;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            WebViewStubService.a(WebViewStubService.this, 2, bundle, i2);
                            return;
                        case 2:
                            u.fJ(WebViewStubService.this);
                            return;
                        case 3:
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("stat_scene", 4);
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i2);
                            if (Bw != null) {
                                bundle2.putString("stat_url", Bw.aeH());
                            }
                            WebViewStubService.this.handler.post(new Runnable(bundle, bundle2) {
                                public final void run() {
                                    Intent intent = new Intent();
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtras(r3);
                                    intent.putExtra("isFromWebView", true);
                                    intent.putExtra("_stat_obj", r4);
                                    com.tencent.mm.plugin.webview.a.a.ihN.t(intent, WebViewStubService.this);
                                }
                            });
                            return;
                        case 4:
                            WebViewStubService.a(WebViewStubService.this, 3, bundle, i2);
                            return;
                        case 5:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.tCa.add(Integer.valueOf(i2));
                            }
                            x.i("MicroMsg.WebViewStubService", "add Scene end, hashCode:[%d], set size:[%d]", Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.tCa.size()));
                            if (i > 0) {
                                WebViewStubService.this.tBX = WebViewStubService.this.tBX + 1;
                                x.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                as.CN().a(233, WebViewStubService.this);
                                as.CN().a(673, WebViewStubService.this);
                                as.CN().a(666, WebViewStubService.this);
                                as.CN().a(1254, WebViewStubService.this);
                                as.CN().a(1373, WebViewStubService.this);
                                return;
                            }
                            return;
                        case 6:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.tCa.remove(Integer.valueOf(i2));
                            }
                            x.i("MicroMsg.WebViewStubService", "remove Scene end, hashCode:[%d], set size:[%d]", Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.tCa.size()));
                            if (i > 0) {
                                WebViewStubService.this.tBX = WebViewStubService.this.tBX - 1;
                                if (WebViewStubService.this.tBX <= 0 && WebViewStubService.this.tCa.size() <= 0) {
                                    x.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                    if (as.Hp()) {
                                        as.CN().b(233, WebViewStubService.this);
                                        as.CN().b(673, WebViewStubService.this);
                                        as.CN().b(666, WebViewStubService.this);
                                        as.CN().b(1254, WebViewStubService.this);
                                        as.CN().b(1373, WebViewStubService.this);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 7:
                            intent = new Intent();
                            intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
                            intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.plugin.webview.a.a.ihN.u(intent, WebViewStubService.this);
                            return;
                        case 8:
                            intent = new Intent();
                            intent.putExtras(bundle);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.plugin.webview.a.a.ihN.v(intent, WebViewStubService.this);
                            return;
                        case 20:
                            bundle.setClassLoader(getClass().getClassLoader());
                            h.Bw(i2).tNQ = bundle.getBundle("jsapiargs");
                            str = (String) bundle.getCharSequence("bizofstartfrom");
                            bundle = bundle.getBundle("startwebviewparams");
                            if (!(str == null || bundle == null)) {
                                com.tencent.mm.sdk.b.b kmVar = new km();
                                kmVar.fCE.fCF = str;
                                kmVar.fCE.fCG = bundle;
                                com.tencent.mm.sdk.b.a.xmy.m(kmVar);
                            }
                            WebViewStubService.this.tCb = bundle.getInt("screen_orientation", -1);
                            return;
                        case 21:
                            h.Bw(i2).bVi().putAll(bundle);
                            return;
                        case 29:
                            str = bundle.getString("srcUsername");
                            y.Ml();
                            com.tencent.mm.af.e.jS(str);
                            y.Ml();
                            com.tencent.mm.af.e.jT(str);
                            y.Mu();
                            if (!bi.oN(str) && com.tencent.mm.af.f.kb(str)) {
                                y.Mu().b(str, null);
                                return;
                            }
                            return;
                        case 30:
                            str = bundle.getString("srcUsername");
                            y.Ml();
                            com.tencent.mm.af.e.jU(str);
                            y.Mu();
                            if (!bi.oN(str) && com.tencent.mm.af.f.kb(str)) {
                                y.Mu();
                                com.tencent.mm.af.k.kg(str);
                                return;
                            }
                            return;
                        case 41:
                            if (as.Hp()) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw2 = h.Bw(i2);
                                bundle = bundle;
                                if (Bw2.tOC != null) {
                                    if (bundle == null || bundle.size() <= 0) {
                                        Bw2.a(Bw2.fCC, Bw2.tOC, "showKeyboard:fail", null, true, true);
                                    } else {
                                        Map hashMap = new HashMap();
                                        hashMap.put("text", bi.oM(bundle.getString("show_kb_input_callback_text")));
                                        Bw2.a(Bw2.fCC, Bw2.tOC, "showKeyboard:ok", hashMap, true, true);
                                    }
                                    Bw2.tOC = null;
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            x.e("MicroMsg.WebViewStubService", "not support action code:[%d]", Integer.valueOf(i));
                            return;
                    }
                }
            });
        }

        public final b R(Bundle bundle) {
            boolean a;
            Object aVar = new a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            cg cgVar = new cg();
            if (Long.MIN_VALUE != j) {
                cgVar.frk.fro = bundle.getInt("message_index", 0);
                a = com.tencent.mm.pluginsdk.model.f.a(cgVar, j);
            } else if (!bi.oN(string)) {
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fIX.fJa = string;
                qpVar.fIX.fJb = cgVar;
                qpVar.fIX.url = bundle.getString("rawUrl");
                qpVar.fIX.fIZ = true;
                com.tencent.mm.sdk.b.a.xmy.m(qpVar);
                a = qpVar.fIY.fqR;
            } else if (i != 0) {
                com.tencent.mm.sdk.b.b mjVar = new mj();
                mjVar.fEZ.opType = 3;
                mjVar.fEZ.fFb = cgVar;
                mjVar.fEZ.fFc = i;
                mjVar.fEZ.fFd = string2;
                com.tencent.mm.sdk.b.a.xmy.m(mjVar);
                a = mjVar.fFa.fqR;
            } else {
                aVar.ndp = true;
                return aVar;
            }
            if (a) {
                string = bi.oM(bundle.getString("prePublishId"));
                String hC = com.tencent.mm.y.u.hC(string);
                com.tencent.mm.y.u.b t = com.tencent.mm.y.u.GQ().t(hC, true);
                t.o("sendAppMsgScene", Integer.valueOf(2));
                t.o("preChatName", bundle.getString("preChatName"));
                t.o("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                t.o("prePublishId", string);
                t.o("preUsername", bundle.getString("preUsername"));
                t.o("getA8KeyScene", bundle.getString("getA8KeyScene"));
                t.o("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    t.o("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                cgVar.frk.frp = hC;
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
            } else {
                if (cgVar.frk.frq == 0) {
                    cgVar.frk.frq = R.l.efC;
                }
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
            }
            aVar.ret = cgVar.frl.ret;
            return aVar;
        }

        public final String Pq(String str) {
            return com.tencent.mm.ac.b.iZ(str);
        }

        public final boolean isSDCardAvailable() {
            as.Hm();
            return com.tencent.mm.y.c.isSDCardAvailable();
        }

        public final int en(int i, int i2) {
            as.Hm();
            return bi.a((Integer) com.tencent.mm.y.c.Db().get(i, null), i2);
        }

        public final void eo(final int i, final int i2) {
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(i, Integer.valueOf(i2));
                }
            });
        }

        public final String aT(int i, String str) {
            as.Hm();
            return bi.aD((String) com.tencent.mm.y.c.Db().get(i, null), str);
        }

        public final boolean r(int i, Bundle bundle) {
            x.i("MicroMsg.WebViewStubService", "doScene, type = %d", Integer.valueOf(i));
            com.tencent.mm.ad.k lVar;
            switch (i) {
                case 233:
                    if (aPk()) {
                        String string = bundle.getString("geta8key_data_req_url");
                        if (!bi.oN(bundle.getString("k_share_url"))) {
                            ak.eS(string, bundle.getString("k_share_url"));
                        }
                        lVar = !bi.oN(string) ? new l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie")) : new l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                        lVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return as.CN().a(lVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 666:
                    if (aPk()) {
                        return WebViewStubService.Q(bundle);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 673:
                    if (aPk()) {
                        com.tencent.mm.ad.k jVar = new j(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                        jVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return as.CN().a(jVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1254:
                    if (aPk()) {
                        com.tencent.mm.ad.k rVar = new r(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene"));
                        rVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return as.CN().a(rVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1373:
                    if (aPk()) {
                        String string2 = bundle.getString("oauth_url");
                        int i2 = bundle.getInt("opt");
                        LinkedList linkedList = new LinkedList(bundle.getStringArrayList("scopes"));
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i3 = 0; i3 < linkedList.size(); i3++) {
                            stringBuilder.append((String) linkedList.get(i3)).append(",");
                        }
                        x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
                        lVar = new com.tencent.mm.plugin.webview.model.s(string2, i2, linkedList);
                        lVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return as.CN().a(lVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 2836:
                    if (aPk()) {
                        return WebViewStubService.a(WebViewStubService.this, bundle);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                default:
                    x.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", Integer.valueOf(i));
                    return false;
            }
        }

        public final boolean Ma() {
            return com.tencent.mm.af.f.Ma();
        }

        public final List<String> LZ() {
            List<String> LZ = com.tencent.mm.af.f.LZ();
            List<String> linkedList = new LinkedList();
            for (String str : LZ) {
                if (!com.tencent.mm.af.f.jY(str)) {
                    linkedList.add(str);
                }
            }
            return linkedList;
        }

        public final void f(int i, List<String> list) {
            com.tencent.mm.plugin.report.service.g.pWK.d(i, list);
        }

        public final boolean a(String str, boolean z, Bundle bundle) {
            return com.tencent.mm.pluginsdk.q.a.vjg.a(WebViewStubService.this, str, z, bundle);
        }

        public final String Pr(String str) {
            if (com.tencent.mm.pluginsdk.q.a.vjh != null) {
                return com.tencent.mm.pluginsdk.q.a.vjh.o(WebViewStubService.this, str);
            }
            return null;
        }

        public final void cA(String str, int i) {
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.a(WebViewStubService.this, 5, null, i);
        }

        public final void aP(String str, boolean z) {
            com.tencent.mm.pluginsdk.q.a.vjg.a(WebViewStubService.this, str, z);
        }

        public final boolean GF() {
            return q.GF();
        }

        public final void i(String str, boolean z, int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i);
            if (!bi.oN(str)) {
                x.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", str);
                Bw.mgx = false;
                Bw.nbS.add(str);
                if (z) {
                    Bw.tNP.add(str);
                }
            }
        }

        public final Bundle AK(int i) {
            return h.Bw(i).bVi();
        }

        public final boolean AL(int i) {
            boolean z = h.Bw(i).mgx;
            if (z) {
                x.w("MicroMsg.WebViewStubService", "isBusy, doingFunction = " + h.Bw(i).tNU);
            }
            return z;
        }

        public final void G(String str, String str2, int i) {
            h.Bw(i).bVi().putString(str, str2);
        }

        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean Pp = WebViewStubService.Pp(str2);
            x.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + Pp);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if (Pp) {
                WebViewStubService.a(WebViewStubService.this, str, str2, str3, jsapiPermissionWrapper, bundle2, i);
                return true;
            }
            i iVar = new i();
            iVar.type = str;
            iVar.tQg = str2;
            iVar.tQe = str3;
            iVar.pug = i.aa(bundle2);
            e eVar = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                e eVar2;
                if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                    eVar2 = eVar;
                } else {
                    eVar2 = webViewStubCallbackWrapper.tEI;
                }
                eVar = eVar2;
            }
            h.Bw(i).a(WebViewStubService.this, eVar);
            Pp = h.Bw(i).a(iVar, jsapiPermissionWrapper);
            x.i("MicroMsg.WebViewStubService", "handleRet = " + Pp);
            return Pp;
        }

        public final void a(String str, Bundle bundle, int i) {
            Bundle bundle2 = new Bundle();
            Parcelable jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.a(WebViewStubService.this, 4, bundle2, i);
        }

        public final void Ps(String str) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, false);
            if (aZ != null && bi.oN(aZ.field_openId)) {
                x.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + str);
                com.tencent.mm.sdk.b.b gzVar = new gz();
                gzVar.fyb.appId = str;
                com.tencent.mm.sdk.b.a.xmy.m(gzVar);
            }
        }

        public final String Pt(String str) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, false);
            return aZ == null ? null : aZ.field_packageName;
        }

        public final boolean cG(String str) {
            return com.tencent.mm.pluginsdk.q.a.vjh.cG(str);
        }

        public final void ab(int i, int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.a(WebViewStubService.this, 6, bundle, i3);
        }

        public final boolean Pu(String str) {
            return com.tencent.mm.bl.d.Pu(str);
        }

        public final void AM(int i) {
            x.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", Integer.valueOf(i));
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                if (webViewStubCallbackWrapper.id == i) {
                    WebViewStubService.this.fwA.remove(webViewStubCallbackWrapper);
                    return;
                }
            }
        }

        public final void a(e eVar, int i) {
            x.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", Integer.valueOf(eVar.hashCode()), Integer.valueOf(i));
            WebViewStubService.this.fwA.add(new WebViewStubCallbackWrapper(eVar, i));
            h.Bw(i);
        }

        public final String[] bSD() {
            String F = com.tencent.mm.j.g.Ag().F("WebViewConfig", "removeJavascriptInterface");
            return bi.oN(F) ? null : F.split(";");
        }

        public final boolean S(Bundle bundle) {
            com.tencent.mm.sdk.b.b cbVar = new cb();
            cbVar.frd.frf = bundle.getLong("fav_local_id", -1);
            com.tencent.mm.sdk.b.a.xmy.m(cbVar);
            x.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", Long.valueOf(cbVar.frd.frf), Boolean.valueOf(cbVar.fre.fqR));
            return cbVar.fre.fqR;
        }

        public final String bSE() {
            as.Hm();
            return (String) com.tencent.mm.y.c.Db().get(-1535680990, null);
        }

        public final String Cu(String str) {
            return ak.Cu(str);
        }

        public final String bSF() {
            return w.d(WebViewStubService.this.getSharedPreferences(ad.cgf(), 0));
        }

        public final String Pv(final String str) {
            boolean Hp = as.Hp();
            x.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + Hp);
            if (Hp) {
                return com.tencent.mm.j.g.Af().getValue(str);
            }
            return (String) new bd<String>() {
                protected final /* synthetic */ Object run() {
                    return as.Hp() ? com.tencent.mm.j.g.Af().getValue(str) : null;
                }
            }.b(WebViewStubService.this.handler);
        }

        public final void Pw(final String str) {
            boolean Hp = as.Hp();
            x.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + Hp);
            bd anonymousClass5 = new bd<Void>() {
                protected final /* synthetic */ Object run() {
                    if (as.Hp()) {
                        as.Hm();
                        com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(str);
                        if (Xv == null || ((int) Xv.gKO) <= 0) {
                            com.tencent.mm.y.ak.a.hhv.a(str, "", null);
                        } else {
                            x.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                        }
                    }
                    return null;
                }
            };
            if (Hp) {
                anonymousClass5.b(null);
            } else {
                anonymousClass5.b(WebViewStubService.this.handler);
            }
        }

        public final String cB(String str, int i) {
            switch (i) {
                case 1:
                    return ai.OW(str);
                case 2:
                    WebViewJSSDKFileItem OS = f.bSo().OS(str);
                    if (OS != null) {
                        x.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", OS.jlG);
                        return OS.iOz;
                    }
                    x.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", str);
                    return null;
                default:
                    return null;
            }
        }

        public final int Px(String str) {
            cg cgVar = new cg();
            com.tencent.mm.pluginsdk.model.f.a(cgVar, 1, str);
            com.tencent.mm.sdk.b.a.xmy.m(cgVar);
            return cgVar.frl.ret;
        }

        public final void favEditTag() {
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 35;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
        }

        public final boolean r(long j, String str) {
            if (j == Long.MIN_VALUE && str == null) {
                return false;
            }
            com.tencent.mm.sdk.b.b diVar = new di();
            if (j != Long.MIN_VALUE) {
                diVar.fsL.frh = j;
            }
            if (str != null) {
                diVar.fsL.fsC = str;
            }
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk) {
                return true;
            }
            if (as.Hp() && j != Long.MIN_VALUE) {
                as.Hm();
                com.tencent.mm.f.b.cg dI = com.tencent.mm.y.c.Fh().dI(j);
                if (dI.getType() == 49) {
                    boolean eX = s.eX(dI.field_talker);
                    String str2 = dI.field_content;
                    int i = dI.field_isSend;
                    if (eX && str2 != null && i == 0) {
                        str2 = bb.hT(str2);
                    }
                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str2);
                    if (fV.type == 3) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ad.getContext(), 16);
                    }
                    if (fV.type == 4) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ad.getContext(), 8);
                    }
                }
            }
            return false;
        }

        public final void Py(String str) {
            if (p.Vw(str)) {
                EmojiInfo yI;
                EmojiInfo yI2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(com.tencent.mm.a.g.bV(str));
                if (yI2 == null || !yI2.clh()) {
                    yI = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yJ(str));
                } else {
                    yI = yI2;
                }
                int bN = yI == null ? 0 : com.tencent.mm.a.e.bN(yI.clq());
                if (yI != null) {
                    str = yI.clq();
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                int i;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.j.b.zL()) && options.outWidth <= com.tencent.mm.j.b.zL()) {
                    i = 0;
                } else {
                    i = true;
                }
                if (bN > com.tencent.mm.j.b.zM() || i != 0) {
                    com.tencent.mm.ui.base.h.a(ad.getContext(), WebViewStubService.this.getString(R.l.dZW), "", WebViewStubService.this.getString(R.l.epx), null);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", yI == null ? "" : yI.Nx());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.ihN.l(intent, WebViewStubService.this);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.a.a.ihN.l(intent2, WebViewStubService.this);
        }

        public final String getLanguage() {
            return w.eM(ad.getContext());
        }

        public final String bSG() {
            com.tencent.mm.sdk.b.b hnVar = new hn();
            com.tencent.mm.sdk.b.a.xmy.m(hnVar);
            return hnVar.fyK.url;
        }

        public final Map bSH() {
            com.tencent.mm.j.d fR = com.tencent.mm.j.g.Ag().fR(1);
            return fR == null ? null : fR.gJR;
        }

        public final String eV(String str, String str2) {
            return "";
        }

        public final int bSI() {
            com.tencent.mm.kernel.g.Do();
            return com.tencent.mm.kernel.a.Cn();
        }

        public final int bSJ() {
            as.Hm();
            return bi.e((Integer) com.tencent.mm.y.c.Db().get(12304, null));
        }

        public final void bSK() {
            Intent intent = new Intent();
            as.Hm();
            String str = (String) com.tencent.mm.y.c.Db().get(2, null);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            as.Hm();
            int a = bi.a((Integer) com.tencent.mm.y.c.Db().get(68389, null), 0);
            as.Hm();
            com.tencent.mm.y.c.Db().set(68389, Integer.valueOf(a + 1));
            intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
            WebViewStubService.this.startActivity(intent);
        }

        public final void bSL() {
            if (((q.Gj() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) && com.tencent.mm.bl.d.Pu("sns")) {
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.addFlags(67108864);
                intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                WebViewStubService.this.startActivity(intent);
            }
        }

        public final void AI(int i) {
            Iterator it;
            String str;
            if (WebViewStubService.this.fwA.size() == 0) {
                com.tencent.mm.sdk.b.b fgVar = new fg();
                fgVar.fvl.fvo = 2;
                com.tencent.mm.sdk.b.a.xmy.m(fgVar);
                fgVar = new fa();
                fgVar.fuO.op = 2;
                com.tencent.mm.sdk.b.a.xmy.m(fgVar);
                fgVar = new fd();
                fgVar.fuV.op = 2;
                com.tencent.mm.sdk.b.a.xmy.m(fgVar);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i);
            x.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            if (Bw.bVo()) {
                WebViewJSSDKFileItem OS = f.bSo().OS(Bw.tOu);
                if (OS != null) {
                    ah.y(new AnonymousClass68(OS));
                }
            }
            Entry entry;
            String str2;
            com.tencent.mm.sdk.b.b dbVar;
            if ((Bw.bSQ() == 8 || Bw.bSQ() == -1) && Bw.aRY() != 27) {
                if (Bw.bSQ() == 8) {
                    if (Bw.tNS == null || Bw.tNS.isEmpty()) {
                        x.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = Bw.tNS.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                dbVar = new db();
                                dbVar.fsn.fsp = str2;
                                dbVar.fsn.ffG = str;
                                com.tencent.mm.sdk.b.a.xmy.m(dbVar);
                                if (!dbVar.fso.fsk) {
                                    try {
                                        dbVar = new cz();
                                        dbVar.fsg.fsj = false;
                                        dbVar.fsg.fsi = str2;
                                        dbVar.fsg.ffG = str;
                                        com.tencent.mm.sdk.b.a.xmy.m(dbVar);
                                        x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        Bw.tNS.clear();
                    }
                }
            } else if ((Bw.tNT == null || Bw.tNT.isEmpty()) && (Bw.tNS == null || Bw.tNS.isEmpty())) {
                x.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(Bw.tNT == null || Bw.tNT.isEmpty())) {
                    for (Entry entry2 : Bw.tNT.entrySet()) {
                        x.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", (String) entry2.getKey(), (String) entry2.getValue());
                        try {
                            dbVar = new da();
                            dbVar.fsl.fsj = false;
                            dbVar.fsl.fsi = str2;
                            dbVar.fsl.ffG = str;
                            com.tencent.mm.sdk.b.a.xmy.m(dbVar);
                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Throwable e2) {
                            x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    Bw.tNT.clear();
                }
                if (!(Bw.tNS == null || Bw.tNS.isEmpty())) {
                    boolean z;
                    com.tencent.mm.sdk.b.b dbVar2;
                    Iterator it2 = Bw.tNS.entrySet().iterator();
                    str = Bw.bVn();
                    if (!bi.oN(str)) {
                        com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(str);
                        if (jV != null) {
                            com.tencent.mm.af.d.b bK = jV.bK(false);
                            if (!(bK == null || bK.LE() == null || !bK.LE().LN())) {
                                z = true;
                                x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(z));
                                if (it2 != null) {
                                    while (it2.hasNext()) {
                                        entry2 = (Entry) it2.next();
                                        str2 = (String) entry2.getKey();
                                        str = (String) entry2.getValue();
                                        x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                        if (z) {
                                            dbVar2 = new db();
                                            dbVar2.fsn.fsp = str2;
                                            dbVar2.fsn.ffG = str;
                                            com.tencent.mm.sdk.b.a.xmy.m(dbVar2);
                                            if (dbVar2.fso.fsk) {
                                            }
                                        }
                                        try {
                                            dbVar2 = new cz();
                                            dbVar2.fsg.fsj = false;
                                            dbVar2.fsg.fsi = str2;
                                            dbVar2.fsg.ffG = str;
                                            com.tencent.mm.sdk.b.a.xmy.m(dbVar2);
                                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                        } catch (Throwable e22) {
                                            x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                            x.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                                        }
                                    }
                                }
                                Bw.tNS.clear();
                            }
                        }
                    }
                    z = false;
                    x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(z));
                    if (it2 != null) {
                        while (it2.hasNext()) {
                            entry2 = (Entry) it2.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                            if (z) {
                                dbVar2 = new db();
                                dbVar2.fsn.fsp = str2;
                                dbVar2.fsn.ffG = str;
                                com.tencent.mm.sdk.b.a.xmy.m(dbVar2);
                                if (dbVar2.fso.fsk) {
                                }
                            }
                            dbVar2 = new cz();
                            dbVar2.fsg.fsj = false;
                            dbVar2.fsg.fsi = str2;
                            dbVar2.fsg.ffG = str;
                            com.tencent.mm.sdk.b.a.xmy.m(dbVar2);
                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        }
                    }
                    Bw.tNS.clear();
                }
            }
            com.tencent.mm.plugin.webview.model.e bRn = a.tyx;
            if (bi.cC(bRn.tyu)) {
                x.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (as.Hp()) {
                List list;
                bRn.tyr = com.tencent.mm.j.g.Af().getInt("MMUxAdLog2GSendSize", 20480);
                bRn.tys = com.tencent.mm.j.g.Af().getInt("MMUxAdLog3GSendSize", 30720);
                bRn.tyt = com.tencent.mm.j.g.Af().getInt("MMUxAdLogWifiSendSize", 51200);
                x.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", Integer.valueOf(bRn.tyr), Integer.valueOf(bRn.tys), Integer.valueOf(bRn.tyt));
                Collection<aob> collection = bRn.tyu;
                if (bi.cC(collection)) {
                    x.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    aob aob;
                    int i2;
                    x.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    x.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (aob aob2 : collection) {
                        stringBuilder.append(aob2.wBF).append(", ");
                    }
                    stringBuilder.append(" }");
                    x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (bi.bB(bRn.tyw) >= 100 || bRn.tyv <= 0) {
                        bRn.tyw = SystemClock.elapsedRealtime();
                        int i3;
                        if (ao.isWifi(ad.getContext())) {
                            i3 = bRn.tyt;
                            bRn.tyv = i3;
                            i2 = i3;
                        } else if (ao.is3G(ad.getContext()) || ao.is4G(ad.getContext())) {
                            i3 = bRn.tys;
                            bRn.tyv = i3;
                            i2 = i3;
                        } else {
                            ao.is2G(ad.getContext());
                            i3 = bRn.tyr;
                            bRn.tyv = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = bRn.tyv;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(collection);
                    List<List> linkedList2 = new LinkedList();
                    LinkedList linkedList3 = null;
                    int i4 = 0;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            aob2 = (aob) linkedList.remove();
                            i4 += aob2.wBG.oz.length;
                            linkedList3.add(aob2);
                            linkedList2.add(linkedList3);
                        } else if (((aob) linkedList.peek()).wBG.oz.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            aob2 = (aob) linkedList.remove();
                            i4 += aob2.wBG.oz.length;
                            linkedList3.add(aob2);
                        }
                    }
                    x.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<aob> list2 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (aob aob22 : list2) {
                            stringBuilder.append(aob22.wBF).append(", ");
                        }
                        stringBuilder.append(" }");
                        x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        x.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    x.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    list = linkedList2;
                }
                if (bi.cC(list)) {
                    x.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list3 : list3) {
                        if (!bi.cC(list3)) {
                            x.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            as.CN().a(new com.tencent.mm.plugin.webview.model.p(list3), 0);
                        }
                    }
                    bRn.tyu.clear();
                }
            } else {
                x.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (Bw.tNQ != null) {
                Bw.tNQ.setClassLoader(Bw.getClass().getClassLoader());
            }
            if (Bw.tNQ != null) {
                Parcelable parcelable = Bw.tNQ.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    snsAdClick.Sz();
                    com.tencent.mm.sdk.b.b nkVar = new nk();
                    nkVar.fGl.fGm = 1;
                    nkVar.fGl.fFZ = snsAdClick;
                    com.tencent.mm.sdk.b.a.xmy.m(nkVar);
                }
            }
            if (Bw.tNQ != null) {
                com.tencent.mm.modelsns.b m = com.tencent.mm.modelsns.b.m(Bw.tNQ);
                if (m != null) {
                    m.update();
                    m.SE();
                }
            }
            for (String str3 : Bw.tOt.keySet()) {
                if (!bi.oN(str3)) {
                    f.bSn();
                    ac.qC(str3);
                    b bVar = (b) Bw.tOt.get(str3);
                    if (bVar != null) {
                        if (bVar.tQa != null) {
                            f.bSn().a(bVar.tQa);
                        }
                        if (bVar.tNN != null) {
                            Bw.a(bVar.tNN, "uploadVideo:cancel", null, false);
                        }
                    }
                }
            }
            Bw.tOt.clear();
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.cdC()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
                aVar.bUb();
            }
            com.tencent.mm.pluginsdk.ui.tools.r.clear();
            com.tencent.mm.sdk.b.a.xmy.c(Bw.qyk);
            com.tencent.mm.sdk.b.a.xmy.c(Bw.tOs);
            com.tencent.mm.sdk.b.a.xmy.c(Bw.tOD);
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.valueOf(false));
            }
            Editor edit = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            Bw.tNO = null;
            Bw.tOr = null;
            Bw.b(Bw.tNN, new int[0]);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tNX = null;
            if (com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tNY != -1) {
                Bw.tNN = Bw.Bs(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tNY).tNN;
                Bw.tNN = null;
                Bw.fCC = Bw.Bs(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tNY).fCC;
                Bw.fCC = null;
            }
            Bw.tNV = null;
            Bw.tOz.clear();
            com.tencent.mm.plugin.webview.modelcache.q bSc = a.tAC;
            List list4 = Bw.tOv;
            if (!(com.tencent.mm.compatible.e.w.zc() == 0 || !as.Hp() || bi.cC(list4))) {
                bSc.Dt().F(new com.tencent.mm.plugin.webview.modelcache.q.AnonymousClass5(list4));
            }
            a.tAC.AI(Bw.fEg);
        }

        public final void cC(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(WebViewStubService.this, 8, bundle, i);
        }

        public final boolean bSM() {
            return q.Gl();
        }

        public final void c(String str, int[] iArr) {
            if (WebViewStubService.this.ndC == null) {
                WebViewStubService.this.ndC = new HashMap();
                com.tencent.mm.sdk.b.a.xmy.b(WebViewStubService.this.gNJ);
            }
            com.tencent.mm.sdk.b.b mrVar = new mr();
            mrVar.fFv.filePath = str;
            if (iArr != null && iArr.length > 0) {
                mrVar.fFv.fFw = new HashSet();
                for (int valueOf : iArr) {
                    mrVar.fFv.fFw.add(Integer.valueOf(valueOf));
                }
            }
            com.tencent.mm.sdk.b.a.xmy.m(mrVar);
            WebViewStubService.this.ndC.put(str, Integer.valueOf(1));
        }

        public final void Pz(String str) {
            if (WebViewStubService.this.ndC == null || !WebViewStubService.this.ndC.containsKey(str)) {
                x.e("MicroMsg.WebViewStubService", "%s is not recognizing", str);
                return;
            }
            com.tencent.mm.sdk.b.b akVar = new com.tencent.mm.f.a.ak();
            akVar.fpp.filePath = str;
            com.tencent.mm.sdk.b.a.xmy.m(akVar);
            WebViewStubService.this.ndC.remove(str);
        }

        public final void g(String str, String str2, String str3, int i, int i2) {
            if (str != null) {
                Intent intent = new Intent();
                intent.setClass(ad.getContext(), WebviewScanImageActivity.class);
                intent.setFlags(872415232);
                intent.putExtra("key_string_for_scan", str);
                intent.putExtra("key_string_for_url", str2);
                intent.putExtra("key_string_for_image_url", str3);
                intent.putExtra("key_codetype_for_scan", i);
                intent.putExtra("key_codeversion_for_scan", i2);
                ad.getContext().startActivity(intent);
            }
        }

        public final String PA(String str) {
            String str2 = "";
            com.tencent.mm.pluginsdk.d.RM(str);
            return str2;
        }

        public final boolean bSN() {
            if (AnonymousClass1.oC("EnableWebviewScanQRCode") == 1) {
                return true;
            }
            return false;
        }

        private static int oC(String str) {
            int i = 1;
            try {
                return bi.getInt(com.tencent.mm.j.g.Af().getValue(str), 1);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + str);
                return i;
            }
        }

        public final void AN(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i);
            Context context = WebViewStubService.this;
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.cdC()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.dQ(context);
            }
            Bw.tOa = false;
            if (Bw.tNQ != null) {
                Parcelable parcelable = Bw.tNQ.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).Sz();
                }
            }
        }

        public final void AO(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i);
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.cdC()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.bUc();
            }
            if (Bw.tNQ != null) {
                Parcelable parcelable = Bw.tNQ.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).hQq = bi.Wz();
                }
            }
        }

        public final Bundle e(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            String oM;
            String string;
            Bundle bundle3;
            FileDownloadTaskInfo bZ;
            int i2;
            Bundle bundle4;
            com.tencent.mm.storage.c cVar;
            int i3;
            int i4;
            com.tencent.mm.sdk.b.b gnVar;
            Map civ;
            com.tencent.mm.sdk.b.b goVar;
            switch (i) {
                case 14:
                    if (bundle == null) {
                        return null;
                    }
                    oM = bi.oM(bundle.getString("task_url"));
                    x.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", oM, bundle.getString("task_name"));
                    if (bi.oN(oM)) {
                        x.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        return null;
                    }
                    com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                    aVar.yr(oM);
                    aVar.yt(string);
                    aVar.et(true);
                    aVar.oP(1);
                    x.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", Long.valueOf(com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp)));
                    bundle3 = new Bundle();
                    bundle3.putLong("download_id", r2);
                    return bundle3;
                case 15:
                    bZ = com.tencent.mm.plugin.downloader.model.f.aAK().bZ(bundle.getLong("download_id", 0));
                    String str = "MicroMsg.WebViewStubService";
                    String str2 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bZ == null);
                    if (bZ == null) {
                        i2 = 0;
                    } else {
                        i2 = bZ.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    x.i(str, str2, objArr);
                    i2 = 0;
                    if (bZ != null) {
                        i2 = bZ.status;
                    }
                    x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(r2), Integer.valueOf(i2));
                    bundle4 = new Bundle();
                    bundle4.putInt("download_state", i2);
                    return bundle4;
                case 16:
                    x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.plugin.downloader.model.f.aAK().bY(bundle.getLong("download_id", 0))));
                    bundle4 = new Bundle();
                    bundle4.putBoolean("cancel_result", com.tencent.mm.plugin.downloader.model.f.aAK().bY(bundle.getLong("download_id", 0)) > 0);
                    return bundle4;
                case 17:
                    bZ = com.tencent.mm.plugin.downloader.model.f.aAK().bZ(bundle.getLong("download_id"));
                    bundle3 = new Bundle();
                    if (bZ == null) {
                        x.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    } else if (bZ.status != 3) {
                        x.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + bZ.status);
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    } else if (com.tencent.mm.a.e.bO(bZ.path)) {
                        bundle3.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.q.e(WebViewStubService.this, Uri.fromFile(new File(bZ.path))));
                        return bundle3;
                    } else {
                        x.e("MicroMsg.WebViewStubService", "file not exists : %s", bZ.path);
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    }
                case 19:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("webview_video_proxy_init", com.tencent.mm.plugin.webview.model.ah.bRE().hasInit);
                    return bundle3;
                case 23:
                    boolean Hp = as.Hp();
                    bd anonymousClass7 = new bd<String>() {
                        protected final /* synthetic */ Object run() {
                            return !as.Hp() ? "" : q.FY();
                        }
                    };
                    if (Hp) {
                        oM = (String) anonymousClass7.b(null);
                    } else {
                        oM = (String) anonymousClass7.b(WebViewStubService.this.handler);
                    }
                    bundle4 = new Bundle();
                    bundle4.putString("config_info_username", oM);
                    return bundle4;
                case 24:
                    bundle4 = new Bundle();
                    cVar = null;
                    try {
                        cVar = com.tencent.mm.y.c.c.IL().fp(com.tencent.mm.plugin.webview.modeltools.b.tAJ);
                    } catch (AssertionFailedError e) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.y.b e2) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", cVar);
                        return bundle4;
                    }
                    Map civ2 = cVar.civ();
                    long j = bi.getLong((String) civ2.get("interval"), 0);
                    long Wx = bi.Wx();
                    as.Hm();
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", Long.valueOf(bi.c((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null))), Long.valueOf(Wx), Long.valueOf(j));
                    if (bi.c((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null)) >= Wx) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        return bundle4;
                    }
                    j += Wx;
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(j));
                    i3 = bi.getInt((String) civ2.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(civ2.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle4.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    return bundle4;
                case 26:
                    bundle3 = new Bundle(1);
                    bundle3.putBoolean("webview_resource_cache_inWhiteList", false);
                    return bundle3;
                case 31:
                    if (!as.Hp()) {
                        return null;
                    }
                    cVar = com.tencent.mm.y.c.c.IL().fp("100036");
                    if (cVar.isValid()) {
                        Map civ3 = cVar.civ();
                        bundle4 = new Bundle();
                        i2 = bi.getInt((String) civ3.get("controlFlag"), 0);
                        bundle4.putInt("webview_ad_intercept_control_flag", i2);
                        if (i2 == 0) {
                            x.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                            return bundle4;
                        }
                        int i5 = bi.getInt((String) civ3.get("blackListCount"), 0);
                        ArrayList arrayList2 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            oM = (String) civ3.get("blackList" + (i4 + 1));
                            if (!(bi.oN(oM) || arrayList2.contains(oM))) {
                                x.i("MicroMsg.WebViewStubService", "add black list domin = %s", oM);
                                arrayList2.add(oM);
                            }
                        }
                        i5 = bi.getInt((String) civ3.get("whiteListCount"), 0);
                        ArrayList arrayList3 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            oM = (String) civ3.get("whiteList" + (i4 + 1));
                            if (!(bi.oN(oM) || arrayList3.contains(oM))) {
                                x.i("MicroMsg.WebViewStubService", "add white list domin = %s", oM);
                                arrayList3.add(oM);
                            }
                        }
                        bundle4.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                        bundle4.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                        return bundle4;
                    }
                    x.d("MicroMsg.WebViewStubService", "test is valid");
                    return null;
                case 50:
                    if (bundle == null) {
                        return null;
                    }
                    string = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
                    if (string == null) {
                        return null;
                    }
                    bundle3 = new Bundle();
                    bundle3.putInt("key_biz_type", com.tencent.mm.af.f.jV(string).field_type);
                    return bundle3;
                case 51:
                    try {
                        if (Looper.myLooper() == null) {
                            Looper.prepare();
                        }
                        com.tencent.mm.modelgeo.c.OV().b(new com.tencent.mm.modelgeo.a.a() {
                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                x.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
                                com.tencent.mm.modelgeo.c.OV().c(this);
                                return false;
                            }
                        });
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.WebViewStubService", e3, "", new Object[0]);
                    }
                    return null;
                case org.xwalk.core.R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    if (bundle == null) {
                        return null;
                    }
                    oM = bundle.getString("enterprise_action");
                    bundle4 = new Bundle();
                    if (oM.equals("enterprise_has_connector")) {
                        String str3 = "enterprise_has_connector";
                        y.Ml();
                        bundle4.putBoolean(str3, com.tencent.mm.af.e.LQ().size() > 0);
                    } else if (oM.equals("enterprise_connectors")) {
                        y.Ml();
                        Collection LQ = com.tencent.mm.af.e.LQ();
                        if (LQ != null) {
                            bundle4.putStringArrayList("enterprise_connectors", new ArrayList(LQ));
                        }
                    }
                    return bundle4;
                case org.xwalk.core.R.styleable.AppCompatTheme_listPopupWindowStyle /*75*/:
                    com.tencent.mm.plugin.webview.model.ah bRE = com.tencent.mm.plugin.webview.model.ah.bRE();
                    if (bRE.hasInit) {
                        bRE.fCC = null;
                        com.tencent.mm.plugin.webview.model.ah.tzc = null;
                        bRE.hasInit = false;
                    }
                    return null;
                case org.xwalk.core.R.styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                    if (bundle == null) {
                        return Bundle.EMPTY;
                    }
                    bundle3 = new Bundle();
                    bundle3.putString("appId", h.Bw(bundle.getInt("webview_binder_id")).qZ(bi.oM(bundle.getString("rawUrl"))));
                    return bundle3;
                case 78:
                    bundle2.putBoolean("isOpenForFaceBook", q.Gx());
                    break;
                case 80:
                    if (bundle != null) {
                        oM = bundle.getString("KAppId");
                        string = bundle.getString("shortcut_user_name");
                        i3 = bundle.getInt("webviewui_binder_id");
                        if (!bi.oN(oM) && !bi.oN(string)) {
                            WebViewStubService.a(WebViewStubService.this, 10, bundle, i3);
                            break;
                        }
                        return null;
                    }
                    return null;
                    break;
                case 82:
                    if (bundle == null) {
                        return null;
                    }
                    oM = bundle.getString("key_last_page");
                    string = bundle.getString("key_last_page_title");
                    i4 = bundle.getInt("key_keep_top_scene", 0);
                    com.tencent.mm.bg.c cVar2 = com.tencent.mm.bg.c.ibc;
                    com.tencent.mm.bg.c.f(oM, string, i4);
                    return new Bundle();
                case 83:
                    WebViewStubService.this.tCb = bundle.getInt("screen_orientation", -1);
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    bundle3 = new Bundle();
                    com.tencent.mm.bg.c cVar3 = com.tencent.mm.bg.c.ibc;
                    bundle3.putBoolean("key_is_webview_keep_top", com.tencent.mm.bg.c.Vi());
                    return bundle3;
                case 91:
                    if (bundle != null) {
                        i2 = bundle.getInt("game_sourceScene");
                        gnVar = new gn();
                        gnVar.fxx.actionCode = 5;
                        gnVar.fxx.scene = i2;
                        com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                        break;
                    }
                    return null;
                case 92:
                    if (bundle != null) {
                        oM = bundle.getString("game_hv_menu_appid");
                        if (!bi.oN(oM)) {
                            gnVar = new go();
                            gnVar.fxy.pK = 3;
                            gnVar.fxy.fxA = oM;
                            com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                            bundle2.putString("game_hv_menu_pbcache", gnVar.fxz.result);
                            break;
                        }
                        return null;
                    }
                    return null;
                case 93:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("is_oauth_native", false);
                    if (!com.tencent.mm.kernel.g.Do().CF()) {
                        x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                        return bundle3;
                    } else if (com.tencent.mm.kernel.g.Dr().gSp.gSI) {
                        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100272");
                        if (fp.isValid()) {
                            civ = fp.civ();
                            if (civ == null) {
                                x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                                return bundle3;
                            } else if (civ.containsKey("isUseNative") && "1".equals(civ.get("isUseNative"))) {
                                bundle3.putBoolean("is_oauth_native", true);
                                return bundle3;
                            } else {
                                x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                                return bundle3;
                            }
                        }
                        x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                        return bundle3;
                    } else {
                        x.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
                        return bundle3;
                    }
                case 94:
                    return com.tencent.mm.plugin.webview.model.y.a.bRx();
                case 96:
                    if (bundle == null) {
                        return null;
                    }
                    Set<String> keySet = bundle.keySet();
                    if (keySet == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String oM2 : keySet) {
                            jSONObject.put(oM2, bundle.get(oM2));
                        }
                        goVar = new go();
                        goVar.fxy.pK = 4;
                        goVar.fxy.fxA = jSONObject.toString();
                        com.tencent.mm.sdk.b.a.xmy.m(goVar);
                        break;
                    } catch (JSONException e4) {
                        return null;
                    }
                case 98:
                    cVar = com.tencent.mm.y.c.c.IL().fp("100376");
                    if (!cVar.isValid()) {
                        x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                        return null;
                    } else if ("true".equals(cVar.civ().get("enabled"))) {
                        return new Bundle();
                    } else {
                        return null;
                    }
                case 129:
                    i3 = bundle.getInt("webview_instance_id");
                    e eVar = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        e eVar2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i3) {
                            eVar2 = eVar;
                        } else {
                            eVar2 = webViewStubCallbackWrapper.tEI;
                        }
                        eVar = eVar2;
                    }
                    h.Bw(i3).a(WebViewStubService.this, eVar);
                    Map hashMap = new HashMap();
                    hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    hashMap.put("webview_instance_id", Integer.valueOf(i3));
                    f.bSl().ac(hashMap);
                    break;
                case 131:
                    civ = new HashMap();
                    civ.put("logString", bundle.getString("logString"));
                    com.tencent.mm.plugin.webview.fts.e bSl = f.bSl();
                    Object r = com.tencent.mm.plugin.webview.fts.f.r(civ, "logString");
                    Map hashMap2 = new HashMap();
                    if (!r.contains("h5version=")) {
                        hashMap2.put("h5version", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(0)));
                    }
                    if (hashMap2.keySet().size() > 0) {
                        r = r.length() > 0 ? r + "&" + com.tencent.mm.bb.b.s(hashMap2) : com.tencent.mm.bb.b.s(hashMap2);
                    }
                    civ.put("logString", r);
                    bSl.ae(civ);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX /*141*/:
                    goVar = new hi();
                    com.tencent.mm.sdk.b.a.xmy.m(goVar);
                    Parcelable gameSettingParams = new GameSettingParams();
                    gameSettingParams.fyv = goVar.fyu.fyv;
                    gameSettingParams.fyw = goVar.fyu.fyw;
                    bundle2.putParcelable("game_setting_params", gameSettingParams);
                    break;
                case 250:
                    if (bundle != null) {
                        if (bundle != null) {
                            try {
                                com.tencent.mm.sdk.f.e.post(new com.tencent.mm.modelstat.a.b.AnonymousClass1(bundle), "web_call_rpt");
                                break;
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.WebViewStubService", e32, "webview call back mm error", new Object[0]);
                                break;
                            }
                        }
                    }
                    return null;
                    break;
                case 251:
                    if (bundle != null) {
                        com.tencent.mm.modelstat.f.Tb().q(WebViewUI.class.getName(), bundle.getLong("key_activity_browse_time", 0));
                        break;
                    }
                    return null;
                case 4006:
                    bundle3 = new Bundle();
                    string = ad.cgh().getString("nfc_open_url", null);
                    x.i("MicroMsg.WebViewStubService", "nfc url=" + bi.oM(string));
                    if (!(bi.oN(string) || bi.oN(string.trim()))) {
                        bundle3.putString("debugConfig", string);
                    }
                    as.Hm();
                    bundle3.putString("config", String.valueOf(com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null)));
                    return bundle3;
                case 10001:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    com.tencent.mm.kernel.g.Do();
                    com.tencent.mm.modelappbrand.b.hli = stringBuilder.append(com.tencent.mm.kernel.a.Cn()).append("_").append(bi.Wy()).toString();
                    x.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", com.tencent.mm.modelappbrand.b.hli);
                    break;
                case 100000:
                    cVar = com.tencent.mm.y.c.c.IL().fp("100248");
                    if (cVar.isValid()) {
                        if (bi.getInt((String) cVar.civ().get("isForceSync"), 0) == 1) {
                            x.d("MicroMsg.ConfigListDecoder", "host list = %s", com.tencent.mm.j.g.Ag().F("WebViewConfig", "forceSyncA8KeyHostPath"));
                            bundle2.putString("force_geta8key_host_path", oM2);
                            break;
                        }
                    }
                    x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    return null;
                    break;
                default:
                    x.e("MicroMsg.WebViewStubService", "unknown action = %d", Integer.valueOf(i));
                    break;
            }
            return bundle2;
        }

        public final boolean bSO() {
            if (!as.Ho() || as.Cz()) {
                return true;
            }
            return false;
        }

        public final void aa(Intent intent) {
            Intent intent2 = new Intent(WebViewStubService.this, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            WebViewStubService.this.startActivity(intent2);
        }

        public final void y(int i, String str, String str2) {
            WebViewJSSDKFileItem x = WebViewJSSDKFileItem.x(i, str, str2);
            x.iOE = false;
            f.bSo().b(x);
            f.bSn().b(null, x.fvn, null);
        }

        public final List<String> bSP() {
            f.bSi();
            com.tencent.mm.plugin.webview.modeltools.i bSp = f.bSp();
            long Wx = bi.Wx();
            x.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + Wx);
            boolean fD = bSp.fD("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + Wx);
            x.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", Boolean.valueOf(fD));
            Cursor a = bSp.gLA.a(bSp.getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
            Collection hashSet = new HashSet();
            if (a == null || !a.moveToFirst()) {
                if (a != null) {
                    a.close();
                }
                return new ArrayList(hashSet);
            }
            do {
                String string = a.getString(0);
                if (!bi.oN(string)) {
                    hashSet.add(string);
                    x.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + string);
                }
            } while (a.moveToNext());
            if (a != null) {
                a.close();
            }
            return new ArrayList(hashSet);
        }

        public final int bSQ() {
            return com.tencent.mm.pluginsdk.wallet.i.bSQ();
        }

        public final boolean bSR() {
            if (AnonymousClass1.oC("WebViewDownLoadFileSwitch") == 1) {
                return true;
            }
            return false;
        }

        public final String[] bSS() {
            String F = com.tencent.mm.j.g.Ag().F("AsyncCheckUrl", "UrlHost");
            return !bi.oN(F) ? F.split(";") : null;
        }
    };
    private int tBX = 0;
    private o tBY;
    private com.tencent.mm.plugin.webview.model.c.a tBZ;
    private Set<Integer> tCa = new HashSet();
    private int tCb = -1;

    private static class a extends com.tencent.mm.plugin.webview.stub.b.a {
        public boolean foB;
        public boolean ndp;
        public int ret;
        public int type;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean bSw() {
            return this.ndp;
        }

        public final boolean getResult() {
            return this.foB;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    public static class b extends com.tencent.mm.plugin.webview.stub.c.a {
        public int errCode;
        public int errType;
        public String foE;
        public Bundle mym;
        public int type;

        public final int getType() {
            return this.type;
        }

        public final int bSx() {
            return this.errType;
        }

        public final int bSy() {
            return this.errCode;
        }

        public final String KS() {
            return this.foE;
        }

        public final Bundle getData() {
            return this.mym;
        }
    }

    static /* synthetic */ boolean Pp(String str) {
        if (str == null) {
            x.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            com.tencent.mm.protocal.c.g TR = com.tencent.mm.protocal.c.TR(str);
            if (TR == null) {
                x.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
            } else if (TR.ceg()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean Q(Bundle bundle) {
        com.tencent.mm.ad.k aaVar = new aa(bundle.getString("emoji_store_jump_url"));
        aaVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
        return as.CN().a(aaVar, 0);
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fwA) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i2) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.tEI != null) {
            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", i);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("webview_binder_id", i2);
            intent.putExtra("screen_orientation", webViewStubService.tCb);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.tEI, new Runnable() {
                public final void run() {
                    WebViewStubService.this.startActivity(intent);
                }
            });
        }
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fwA) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.tEI != null) {
            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", 1);
            intent.putExtra("proxyui_type_key", str);
            intent.putExtra("proxyui_function_key", str2);
            intent.putExtra("proxyui_callback_key", str3);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
            intent.putExtra("webview_binder_id", i);
            intent.putExtra("screen_orientation", webViewStubService.tCb);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.tEI, new Runnable() {
                public final void run() {
                    WebViewStubService.this.startActivity(intent);
                }
            });
        }
    }

    static /* synthetic */ boolean a(WebViewStubService webViewStubService, Bundle bundle) {
        String string = bundle.getString("service_click_tid");
        x.i("MicroMsg.WebViewStubService", "doServiceClick tid = %s, stime = %d, etime = %d", string, Long.valueOf(bundle.getLong("service_click_stime", 0)), Long.valueOf(bundle.getLong("service_click_etime", 0)));
        if (string == null || string.length() == 0) {
            x.e("MicroMsg.WebViewStubService", "doServiceClick fail, tid is null");
            return false;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bhz();
        aVar.hnU = new bia();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/service_click";
        aVar.hnS = 2836;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        bhz bhz = (bhz) Kf.hnQ.hnY;
        bhz.mLk = string;
        bhz.wSK = r4;
        bhz.wSL = r6;
        com.tencent.mm.ad.u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, com.tencent.mm.ad.k kVar) {
                x.i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (!(i == 0 && i2 == 0)) {
                    x.e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
        return true;
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new ag();
        this.tBY = new o() {
            public final void onTaskStarted(long j, String str) {
            }

            public final void c(long j, String str, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
                        bundle.putCharSequence("download_manager_appid", cf != null ? cf.field_appId : "");
                        webViewStubCallbackWrapper.tEI.n(1002, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                }
            }

            public final void c(long j, int i, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
                        bundle.putCharSequence("download_manager_appid", cf != null ? cf.field_appId : "");
                        bundle.putInt("download_manager_errcode", i);
                        webViewStubCallbackWrapper.tEI.n(1003, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                }
            }

            public final void onTaskRemoved(long j) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
                        bundle.putCharSequence("download_manager_appid", cf != null ? cf.field_appId : "");
                        webViewStubCallbackWrapper.tEI.n(1008, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                }
            }

            public final void onTaskPaused(long j) {
            }

            public final void cl(long j) {
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
                        if (cf == null || cf.field_totalSize == 0) {
                            x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + j);
                            return;
                        }
                        int i = (int) ((((double) cf.field_downloadedSize) / ((double) cf.field_totalSize)) * 100.0d);
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", cf.field_appId);
                        webViewStubCallbackWrapper.tEI.n(1007, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                }
            }

            public final void k(long j, String str) {
            }
        };
        com.tencent.mm.plugin.downloader.model.f.aAK();
        com.tencent.mm.plugin.downloader.model.c.a(this.tBY);
        this.tBZ = new com.tencent.mm.plugin.webview.model.c.a() {
            public final void a(boolean z, int i, int i2, String str, String str2) {
                Bundle bundle;
                x.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                            webViewStubCallbackWrapper.tEI.n(2011, bundle);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e.getMessage());
                    }
                }
                switch (i) {
                    case 1:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.this.fwA) {
                                    webViewStubCallbackWrapper2.tEI.n(2003, bundle);
                                }
                                return;
                            } catch (Exception e2) {
                                x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e2.getMessage());
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : WebViewStubService.this.fwA) {
                                webViewStubCallbackWrapper22.tEI.n(TXLiveConstants.PLAY_EVT_PLAY_BEGIN, bundle);
                            }
                            return;
                        } catch (Exception e22) {
                            x.e("MicroMsg.WebViewStubService", "notify download image failed :%s", e22.getMessage());
                            return;
                        }
                    case 2:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : WebViewStubService.this.fwA) {
                                    webViewStubCallbackWrapper222.tEI.n(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
                                }
                                return;
                            } catch (Exception e222) {
                                x.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", e222.getMessage());
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : WebViewStubService.this.fwA) {
                                webViewStubCallbackWrapper2222.tEI.n(TXLiveConstants.PLAY_EVT_PLAY_END, bundle);
                            }
                            return;
                        } catch (Exception e2222) {
                            x.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", e2222.getMessage());
                            return;
                        }
                    case 4:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : WebViewStubService.this.fwA) {
                                    webViewStubCallbackWrapper22222.tEI.n(2010, bundle);
                                }
                                return;
                            } catch (Exception e22222) {
                                x.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", e22222.getMessage());
                                return;
                            }
                        }
                        return;
                    default:
                        x.e("MicroMsg.WebViewStubService", "unsupport media type : %d", Integer.valueOf(i));
                        return;
                }
            }
        };
        this.mKs = new com.tencent.mm.network.n.a() {
            private final byte[] gzU = new byte[0];

            public final void eq(int i) {
                synchronized (this.gzU) {
                    try {
                        String bRI = com.tencent.mm.pluginsdk.ui.tools.s.bRI();
                        Bundle bundle = new Bundle();
                        bundle.putString("webview_network_type", bRI);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.fwA) {
                            webViewStubCallbackWrapper.tEI.n(90, bundle);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e.getMessage());
                    }
                }
            }
        };
        as.a(this.mKs);
        if (as.Hp()) {
            f.bSn().a(this.tBZ);
        }
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        return this.tBW;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        h.detach();
        ak.clear();
        a.tAC.release(false);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAK();
        com.tencent.mm.plugin.downloader.model.c.b(this.tBY);
        if (as.Hp()) {
            f.bSn().b(this.tBZ);
        }
        as.b(this.mKs);
        this.mKs = null;
        this.tBY = null;
        this.fwA.clear();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        int type = kVar.getType();
        x.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d], errCode = %d, errType = %d, errMsg = %s", Integer.valueOf(type), Integer.valueOf(i2), Integer.valueOf(i), str);
        String a;
        Bundle bundle;
        int i3;
        String str2;
        c bVar;
        if (type == 106) {
            as.CN().b(106, (e) this);
            if (i == 0 && i2 == 0) {
                bfr Sv = ((com.tencent.mm.modelsimple.ac) kVar).Sv();
                a = com.tencent.mm.platformtools.n.a(Sv.wfM);
                com.tencent.mm.ac.n.JF().f(a, com.tencent.mm.platformtools.n.a(Sv.vNQ));
                Intent intent = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Sv, 30);
                if (bi.oM(a).length() > 0) {
                    as.Hm();
                    com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(a);
                    if (!(Xv == null || com.tencent.mm.k.a.ga(Xv.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((Sv.wCq & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.k(10298, a + ",30");
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.plugin.webview.a.a.ihN.d(intent, (Context) this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.fwA) {
                            c bVar2 = new b();
                            bVar2.type = type;
                            bVar2.errType = i;
                            bVar2.errCode = i2;
                            bVar2.foE = str;
                            bVar2.mym = bundle;
                            bVar2.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.tEI.a(bVar2);
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
        } else if (type == 233) {
            l lVar = (l) kVar;
            bundle = new Bundle();
            byte[] RO = lVar.RO();
            if (RO == null || RO.length <= 0) {
                x.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            a = "geta8key_result_jsapi_perm_control_bytes";
            if (RO == null) {
                RO = null;
            }
            bundle.putByteArray(a, RO);
            xm xmVar = ((xq) lVar.gLB.hnR.hnY).woS;
            bundle.putInt("geta8key_result_general_ctrl_b1", xmVar == null ? 0 : xmVar.woy);
            bundle.putInt("geta8key_result_reason", ((xp) lVar.gLB.hnQ.hnY).woI);
            bundle.putString("geta8key_result_req_url", lVar.RM());
            bundle.putString("geta8key_result_full_url", lVar.RL());
            bundle.putString("geta8key_result_title", lVar.getTitle());
            bundle.putInt("geta8key_result_action_code", lVar.RN());
            bundle.putString("geta8key_result_content", lVar.wl());
            bundle.putString("geta8key_result_head_img", ((xq) lVar.gLB.hnR.hnY).wpb);
            bundle.putString("geta8key_result_wording", ((xq) lVar.gLB.hnR.hnY).nMr);
            bundle.putLong("geta8key_result_deep_link_bit_set", lVar.RR());
            bundle.putString("geta8key_data_username", ((xq) lVar.gLB.hnR.hnY).kyG);
            bundle.putByteArray("geta8key_result_cookie", lVar.RU());
            x.d("MicroMsg.WebViewStubService", "getA8KeyCookie:%s", bi.bA(lVar.RU()));
            List<akw> RS = lVar.RS();
            if (!bi.cC(RS)) {
                akw akw;
                Object obj;
                for (akw akw2 : RS) {
                    if (akw2 != null && !bi.oN(akw2.vUa)) {
                        if (bi.oN(akw2.pWq)) {
                            x.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    x.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[RS.size()];
                    String[] strArr2 = new String[RS.size()];
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= RS.size()) {
                            break;
                        }
                        akw2 = (akw) RS.get(i3);
                        x.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), akw2.vUa, akw2.pWq);
                        strArr[i3] = r9;
                        strArr2[i3] = str2;
                        i4 = i3 + 1;
                    }
                    bundle.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle.putSerializable("geta8key_result_scope_list", lVar.RQ());
            x.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", lVar.RP(), lVar.RL(), lVar.RM(), Boolean.valueOf(true));
            if (bi.oN(lVar.RP())) {
                x.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", lVar.RL(), lVar.RM());
            } else {
                ak.eS(lVar.RL(), lVar.RP());
            }
            try {
                if (lVar.tag != null) {
                    i3 = ((Integer) lVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.fwA) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper2.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.foE = str;
                        bVar.mym = bundle;
                        bVar.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                        webViewStubCallbackWrapper2.tEI.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "geta8key hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper2.id));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e2));
            }
        } else if (type == 673) {
            j jVar = (j) kVar;
            bundle = new Bundle();
            a = "reading_mode_result_url";
            if (jVar.gLB == null) {
                str2 = null;
            } else {
                str2 = ((afs) jVar.gLB.hnR.hnY).URL;
            }
            bundle.putString(a, str2);
            try {
                if (jVar.tag != null) {
                    i3 = ((Integer) jVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.fwA) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper22.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.foE = str;
                        bVar.mym = bundle;
                        bVar.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                        webViewStubCallbackWrapper22.tEI.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", " get readingmodeinfo, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper22.id));
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e22));
            }
        } else if (type == 666) {
            aa aaVar = (aa) kVar;
            bundle = new Bundle();
            bundle.putString("emoji_stroe_product_id", aaVar.St().vPI);
            if (i == 0 && i2 == 0) {
                str2 = bundle.getString("emoji_stroe_product_id");
                x.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", str2);
                if (!bi.oN(str2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", str2);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.bl.d.b(this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                if (aaVar.tag != null) {
                    i3 = ((Integer) aaVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.fwA) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper222.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.foE = str;
                        bVar.mym = bundle;
                        bVar.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                        webViewStubCallbackWrapper222.tEI.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "jumpEmojiDetail, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper222.id));
                    }
                }
            } catch (Exception e3) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e3.getMessage());
            }
        } else if (type == 1254) {
            try {
                int intValue;
                r rVar = (r) kVar;
                if (rVar.tag != null) {
                    intValue = ((Integer) rVar.tag).intValue();
                } else {
                    intValue = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : this.fwA) {
                    if (intValue == 0 || intValue == webViewStubCallbackWrapper3.id) {
                        c bVar3 = new b();
                        bVar3.type = type;
                        bVar3.errType = i;
                        bVar3.errCode = i2;
                        bVar3.foE = str;
                        Bundle bundle2 = new Bundle();
                        if (i == 0 && i2 == 0 && (kVar instanceof r)) {
                            aue aue = (aue) ((r) kVar).gLB.hnR.hnY;
                            bundle2.putString("oauth_url", ((r) kVar).tyG);
                            bundle2.putSerializable("scope_list", com.tencent.mm.plugin.webview.model.y.ar(aue.wIU));
                            bundle2.putString("appname", aue.hea);
                            bundle2.putString("appicon_url", aue.wIV);
                            bundle2.putString("redirect_url", aue.wbT);
                            bundle2.putBoolean("is_recent_has_auth", aue.wIW);
                            bundle2.putBoolean("is_silence_auth", aue.wIX);
                            bundle2.putBoolean("is_call_server_when_confirm", aue.wIY);
                        }
                        bVar3.mym = bundle2;
                        bVar3.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper3.id);
                        webViewStubCallbackWrapper3.tEI.a(bVar3);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorize, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue), Integer.valueOf(webViewStubCallbackWrapper3.id));
                    }
                }
            } catch (Throwable e222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + Log.getStackTraceString(e222));
            }
        } else if (type == 1373) {
            try {
                int intValue2;
                com.tencent.mm.plugin.webview.model.s sVar = (com.tencent.mm.plugin.webview.model.s) kVar;
                if (sVar.tag != null) {
                    intValue2 = ((Integer) sVar.tag).intValue();
                } else {
                    intValue2 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper4 : this.fwA) {
                    if (intValue2 == 0 || intValue2 == webViewStubCallbackWrapper4.id) {
                        c bVar4 = new b();
                        bVar4.type = type;
                        bVar4.errType = i;
                        bVar4.errCode = i2;
                        bVar4.foE = str;
                        bundle = new Bundle();
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.webview.model.s)) {
                            bundle.putString("redirect_url", ((auc) ((com.tencent.mm.plugin.webview.model.s) kVar).gLB.hnR.hnY).wbT);
                        }
                        bVar4.mym = bundle;
                        bVar4.mym.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper4.id);
                        webViewStubCallbackWrapper4.tEI.a(bVar4);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorizeconfirm, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue2), Integer.valueOf(webViewStubCallbackWrapper4.id));
                    }
                }
            } catch (Throwable e2222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + Log.getStackTraceString(e2222));
            }
        }
    }
}
