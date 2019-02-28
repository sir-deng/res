package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.qp;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdLandingPagesProxy extends com.tencent.mm.remoteservice.a {
    private static AdLandingPagesProxy qYn;
    private e hpx = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString());
            long longValue;
            if (kVar instanceof c) {
                Object obj;
                String str2 = "";
                if (i == 0 && i2 == 0) {
                    str2 = ((c) kVar).fCU;
                    x.i("AdLandingPagesProxy", "the dynamic string is " + str2 + ", sceneType is " + kVar.getType());
                    obj = str2;
                } else {
                    x.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str + " sceneType is " + kVar.getType());
                    String obj2 = str2;
                }
                if (AdLandingPagesProxy.this.qYp.containsKey(kVar)) {
                    longValue = ((Long) AdLandingPagesProxy.this.qYp.remove(kVar)).longValue();
                    AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", Long.valueOf(longValue), obj2);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a) {
                if (AdLandingPagesProxy.this.qYp.containsKey(kVar)) {
                    byte[] toByteArray;
                    longValue = ((Long) AdLandingPagesProxy.this.qYp.remove(kVar)).longValue();
                    mk mkVar = (mk) ((com.tencent.mm.ad.b) kVar.hoq).hnR.hnY;
                    if (i == 0 && i2 == 0 && mkVar != null) {
                        try {
                            toByteArray = mkVar.toByteArray();
                        } catch (Throwable e) {
                            x.e("AdLandingPagesProxy", bi.i(e));
                            return;
                        }
                    }
                    toByteArray = null;
                    AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
                if (AdLandingPagesProxy.this.qYp.containsKey(kVar)) {
                    long longValue2 = ((Long) AdLandingPagesProxy.this.qYp.remove(kVar)).longValue();
                    AdLandingPagesProxy adLandingPagesProxy = AdLandingPagesProxy.this;
                    String str3 = "onFavOfficialItemEnd";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(longValue2);
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) kVar;
                    objArr[1] = bVar.rtx != null ? bVar.rtx : "";
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(i2);
                    adLandingPagesProxy.CLIENT_CALL(str3, objArr);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.sns.a.b.e) {
                x.i("AdLandingPagesProxy", "real time report done.");
            }
        }
    };
    private Map<Long, a> qYo = new HashMap();
    private Map<k, Long> qYp = new HashMap();
    private d qYq;
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> qYr = new HashMap();
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> qYs = new HashMap();

    public interface a {
        void as(Object obj);

        void e(int i, int i2, Object obj);
    }

    private class b implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a {
        public long id;

        private b() {
        }

        /* synthetic */ b(AdLandingPagesProxy adLandingPagesProxy, byte b) {
            this();
        }

        public final void start() {
            AdLandingPagesProxy.this.CLIENT_CALL("start", Long.valueOf(this.id));
        }

        public final void wQ(int i) {
            x.v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i));
            AdLandingPagesProxy.this.CLIENT_CALL("progress", Long.valueOf(this.id), Integer.valueOf(i));
        }

        public final void bvc() {
            AdLandingPagesProxy.this.CLIENT_CALL("paused", Long.valueOf(this.id));
        }

        public final void bvd() {
            AdLandingPagesProxy.this.CLIENT_CALL("stopped", Long.valueOf(this.id));
        }

        public final void bve() {
            AdLandingPagesProxy.this.CLIENT_CALL("succeed", Long.valueOf(this.id));
        }

        public final void bvf() {
            AdLandingPagesProxy.this.CLIENT_CALL("failed", Long.valueOf(this.id));
        }

        public final void bvg() {
            AdLandingPagesProxy.this.CLIENT_CALL("resumed", Long.valueOf(this.id));
        }
    }

    static /* synthetic */ void a(AdLandingPagesProxy adLandingPagesProxy, String str) {
        long Wo;
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                Wo = (long) bi.Wo(str.substring(indexOf + 10, indexOf2));
                if (Wo > 0) {
                    x.i("AdLandingPagesProxy", "caching canvasId %d", Long.valueOf(Wo));
                    i.byA().o(Wo, str);
                }
            }
        }
        Wo = 0;
        if (Wo > 0) {
            x.i("AdLandingPagesProxy", "caching canvasId %d", Long.valueOf(Wo));
            i.byA().o(Wo, str);
        }
    }

    public static void create(d dVar) {
        qYn = new AdLandingPagesProxy(dVar);
    }

    public AdLandingPagesProxy(d dVar) {
        super(dVar);
        if (dVar == null) {
            g.Dr();
            g.Dp().gRu.a(1337, this.hpx);
            g.Dr();
            g.Dp().gRu.a(1210, this.hpx);
            g.Dr();
            g.Dp().gRu.a(2874, this.hpx);
            g.Dr();
            g.Dp().gRu.a(2721, this.hpx);
            g.Dr();
            g.Dp().gRu.a(1802, this.hpx);
        }
        this.qYq = dVar;
    }

    public static AdLandingPagesProxy getInstance() {
        if (qYn != null) {
            return qYn;
        }
        throw new IllegalStateException("init first");
    }

    public boolean isConnected() {
        return this.qYq == null ? false : this.qYq.isConnected();
    }

    public void onRelease() {
        g.Dr();
        g.Dp().gRu.b(1337, this.hpx);
        g.Dr();
        g.Dp().gRu.b(1210, this.hpx);
        g.Dr();
        g.Dp().gRu.b(2874, this.hpx);
        g.Dr();
        g.Dp().gRu.b(2721, this.hpx);
        g.Dr();
        g.Dp().gRu.b(1802, this.hpx);
    }

    public Object getCfg(int i, Object obj) {
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", Integer.valueOf(i), obj);
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    @f
    public Object getCfgMM(int i, Object obj) {
        g.Dr();
        return g.Dq().Db().get(i, obj);
    }

    public int contactGetTypeTextFromUserName(String str) {
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", str);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int contactGetTypeTextFromUserNameMM(String str) {
        return s.hs(str);
    }

    public String getSnsStatExtBySnsId(long j) {
        return (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", Long.valueOf(j));
    }

    @f
    public String getSnsStatExtBySnsIdMM(long j) {
        com.tencent.mm.plugin.sns.storage.e eL = ae.bwi().eL(j);
        if (eL != null) {
            return com.tencent.mm.plugin.sns.a.b.f.a(eL.byF());
        }
        x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", Long.valueOf(j));
        return "";
    }

    public String getAccSnsPath() {
        return (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    }

    @f
    public String getAccSnsPathMM() {
        return ae.getAccSnsPath();
    }

    public String getSnsAid(String str) {
        return (String) REMOTE_CALL("getSnsAidMM", str);
    }

    @f
    public String getSnsAidMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            return LQ.bzf();
        }
        return "";
    }

    public int getSnsAdType(String str) {
        return ((Integer) REMOTE_CALL("getSnsAdTypeMM", str)).intValue();
    }

    @f
    public int getSnsAdTypeMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            return LQ.bzn();
        }
        return 0;
    }

    public void doOpenAppBrand(String str, String str2, String str3) {
        REMOTE_CALL("doOpenAppBrandMM", str, str2, str3);
    }

    @f
    public void doOpenAppBrandMM(String str, String str2, String str3) {
        com.tencent.mm.sdk.b.b qrVar = new qr();
        qrVar.fJd.userName = str;
        qrVar.fJd.fJf = str2;
        qrVar.fJd.scene = 1084;
        qrVar.fJd.foi = str3;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(ad.getContext(), SnsTransparentUI.class);
            intent.putExtra("phoneNum", str);
            intent.putExtra("op", 4);
            activity.startActivity(intent);
        }
    }

    public String getSnsTraceid(String str) {
        return (String) REMOTE_CALL("getSnsTraceidMM", str);
    }

    @f
    public String getSnsTraceidMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            return LQ.bzg();
        }
        return "";
    }

    public boolean isRecExpAd(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isRecExpAdMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ == null) {
            return false;
        }
        return LQ.bxo();
    }

    public m getSnsInfo(String str) {
        Bundle bundle = (Bundle) REMOTE_CALL("getSnsInfoMM", str);
        if (bundle == null) {
            return null;
        }
        m mVar = new m();
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            mVar.field_snsId = contentValues.getAsLong("snsId").longValue();
            mVar.field_userName = contentValues.getAsString("userName");
            mVar.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            mVar.field_createTime = contentValues.getAsInteger("createTime").intValue();
            mVar.field_head = contentValues.getAsInteger("head").intValue();
            mVar.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            mVar.field_type = contentValues.getAsInteger(Columns.TYPE).intValue();
            mVar.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            mVar.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            mVar.field_pravited = contentValues.getAsInteger("pravited").intValue();
            mVar.field_stringSeq = contentValues.getAsString("stringSeq");
            mVar.field_content = contentValues.getAsByteArray("content");
            mVar.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            mVar.field_postBuf = contentValues.getAsByteArray("postBuf");
            mVar.field_subType = contentValues.getAsInteger("subType").intValue();
            if (contentValues.containsKey("rowid")) {
                mVar.xrR = contentValues.getAsLong("rowid").longValue();
            }
            mVar.ruM = bundle.getInt("localid");
            bundle = bundle.getBundle("adValues");
            if (bundle != null) {
                com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                eVar.E(bundle);
                mVar.ruW = eVar;
            }
        }
        return mVar;
    }

    @f
    public Bundle getSnsInfoMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ == null) {
            return null;
        }
        return LQ.byI();
    }

    public String getUin() {
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        return REMOTE_CALL == null ? "" : (String) REMOTE_CALL;
    }

    @f
    public String getUinMM() {
        g.Do();
        return com.tencent.mm.kernel.a.Co();
    }

    public boolean useOnlineStreamPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean useOnlineStreamPlayerMM() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100208");
        if (!fp.isValid()) {
            return false;
        }
        int i = bi.getInt((String) fp.civ().get("useOnlineVideoPlayer"), 0);
        x.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @f
    public int getExpValueByKeyMM(String str, int i) {
        return com.tencent.mm.y.c.c.IM().dd(str, i);
    }

    public int getExpValueByKey(String str, int i) {
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", str, Integer.valueOf(i));
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public String getExpIdByKeyMM(String str) {
        return com.tencent.mm.y.c.c.IM().getExpIdByKey(str);
    }

    public String getExpIdByKey(String str) {
        return (String) REMOTE_CALL("getExpIdByKeyMM", str);
    }

    public int isAutoAdDownload() {
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    public void favEditTag() {
        REMOTE_CALL("favEditTagMM", new Object[0]);
    }

    @f
    public void favEditTagMM() {
        com.tencent.mm.sdk.b.b fwVar = new fw();
        fwVar.fwl.type = 35;
        com.tencent.mm.sdk.b.a.xmy.m(fwVar);
    }

    @f
    public int isAutoAdDownloadMM() {
        return ae.bwc().b(null, null);
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7, str8);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        boolean z = false;
        cg cgVar = new cg();
        if ((i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) && !bi.oN(str)) {
            com.tencent.mm.sdk.b.b qpVar = new qp();
            qpVar.fIX.fJa = str;
            qpVar.fIX.fJb = cgVar;
            qpVar.fIX.url = str2;
            com.tencent.mm.sdk.b.a.xmy.m(qpVar);
            z = qpVar.fIY.fqR;
        } else if ((i == 5 || i == 6) && j != -2147483648L) {
            z = ((q) g.h(q.class)).a(cgVar, j);
        } else if (i == 13 || i == 14 || i == 15) {
            z = ((q) g.h(q.class)).a(cgVar, str4.hashCode(), com.tencent.mm.y.q.FY(), str4, str5, str6, str7);
        }
        if (z) {
            cgVar.frk.frp = u.hC(str3);
            cgVar.frk.title = str4;
            cgVar.frk.desc = str5;
            vn vnVar = cgVar.frk.frm;
            if (!(vnVar == null || vnVar.wlY == null || vnVar.wlY.size() <= 0 || vnVar.wlY.get(0) == null)) {
                ((uz) vnVar.wlY.get(0)).Uu(str6);
                ((uz) vnVar.wlY.get(0)).TV(str4);
                ((uz) vnVar.wlY.get(0)).TW(str5);
                ((uz) vnVar.wlY.get(0)).Ut(str8);
            }
            if (vnVar != null) {
                vnVar.UL(str4);
                vnVar.UM(str5);
            }
            cgVar.frk.frr = i2;
            com.tencent.mm.sdk.b.a.xmy.m(cgVar);
            return cgVar.frk.frq;
        }
        if (cgVar.frk.frq == 0) {
            cgVar.frk.frq = j.efC;
        }
        return cgVar.frk.frq;
    }

    public int doFav(Intent intent, int i) {
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", intent, Integer.valueOf(i));
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavMM(Intent intent, int i) {
        cg cgVar = new cg();
        ((q) g.h(q.class)).a(cgVar, intent);
        cgVar.frk.frr = i;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        return cgVar.frk.frq;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(ad.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
    }

    @f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, a aVar) {
        this.qYo.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", Long.valueOf(r0), str, str2, str3);
    }

    @f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        k cVar = new c(str, str2, str3);
        this.qYp.put(cVar, Long.valueOf(j));
        g.Dr();
        g.Dp().gRu.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j, String str) {
        a aVar = (a) this.qYo.remove(Long.valueOf(j));
        if (aVar != null && !bi.oN(str)) {
            aVar.as(str);
        }
    }

    public void doSearchDynamicUpdateScene(String str, a aVar) {
        this.qYo.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", Long.valueOf(r0), str);
    }

    @f
    public void doSearchDynamicUpdateSceneMM(long j, String str) {
        k cVar = new c(str);
        this.qYp.put(cVar, Long.valueOf(j));
        g.Dr();
        g.Dp().gRu.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        a aVar = (a) this.qYo.remove(Long.valueOf(j));
        if (aVar != null) {
            aVar.e(i, i2, obj);
        }
    }

    public void doAdChannelScene(String str, String str2, a aVar) {
        this.qYo.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doAdChannelSceneMM", Long.valueOf(r0), str, str2);
    }

    @f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        k aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2);
        this.qYp.put(aVar, Long.valueOf(j));
        g.Dr();
        g.Dp().gRu.a(aVar, 0);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            x.e("AdLandingPagesProxy", "exception:%s", bi.i(e));
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isApkExistMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        return (yo == null || TextUtils.isEmpty(yo.path) || !new File(yo.path).exists()) ? false : true;
    }

    @f
    public boolean isDownloadingMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        return yo != null && yo.status == 1;
    }

    public boolean isDownloading(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPkgInstalledMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        Context context = ad.getContext();
        return (context == null || TextUtils.isEmpty(str)) ? false : p.m(context, str);
    }

    public boolean isPkgInstalled(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPausedMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        return yo != null && yo.status == 2;
    }

    public boolean isPaused(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.start();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j, int i) {
        x.v("AdLandingPagesProxy", "progress client id %d , progress %d", Long.valueOf(j), Integer.valueOf(i));
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.wQ(i);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bvc();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bvd();
            this.qYs.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bve();
            this.qYs.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bvf();
            this.qYs.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.qYs.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bvg();
        }
    }

    @f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        b bVar = new b();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        com.tencent.mm.plugin.downloader.model.g.a aVar2 = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar2.setAppId(str);
        aVar2.cu(str2);
        aVar2.yu(str3);
        aVar2.yr(str4);
        aVar2.yt(str5);
        aVar2.et(z);
        long a = com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar2.lyp);
        aVar.rlB.put(Long.valueOf(a), new WeakReference(bVar));
        aVar.rlC.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str6, str7));
        this.qYr.put(Long.valueOf(a), bVar);
        x.v("AdLandingPagesProxy", "startDownloadMM, id %d", Long.valueOf(a));
        bVar.id = a;
        return a;
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str6, String str7) {
        x.v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7);
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.qYs.put(Long.valueOf(longValue), aVar);
        return longValue;
    }

    @f
    public void stopTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        if (yo != null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(yo.id);
        }
    }

    public void stopTask(String str) {
        REMOTE_CALL("stopTaskMM", str);
    }

    public void stopTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(j);
    }

    public void stopTask(long j) {
        REMOTE_CALL("stopTaskMM", Long.valueOf(j));
    }

    @f
    public long queryIdByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        return com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
    }

    public long queryIdByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", str);
        return REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
    }

    @f
    public boolean pauseTaskByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        return com.tencent.mm.plugin.downloader.model.f.aAK().ca(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTaskByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskByAppidMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        return com.tencent.mm.plugin.downloader.model.f.aAK().ca(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTask(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        return com.tencent.mm.plugin.downloader.model.f.aAK().ca(j);
    }

    public boolean pauseTask(long j) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", Long.valueOf(j));
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public int getTaskProgressMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        return yo.fxb != 0 ? (int) ((yo.fxa * 100) / yo.fxb) : 0;
    }

    public int getTaskProgress(String str) {
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", str);
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        b bVar = new b();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        this.qYr.put(Long.valueOf(queryIdByAppid), bVar);
        bVar.id = queryIdByAppid;
        aVar = c.rlE;
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        if (yo == null) {
            return false;
        }
        aVar.rlB.put(Long.valueOf(yo.id), new WeakReference(bVar));
        aVar.rlC.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str2, str3));
        return com.tencent.mm.plugin.downloader.model.f.aAK().cb(yo.id);
    }

    public boolean resumeTask(String str, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str2, String str3) {
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", str, str2, str3);
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.qYs.put(Long.valueOf(queryIdByAppid(str)), aVar);
        }
        return booleanValue;
    }

    @f
    public boolean installAppMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        Context context = ad.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str);
        if (yo == null || yo.status != 3 || TextUtils.isEmpty(yo.path)) {
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(yo.path));
        aVar.H(4, yo.id);
        return com.tencent.mm.pluginsdk.model.app.q.e(context, fromFile);
    }

    public boolean installApp(Context context, String str) {
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public void reportDownloadInfoMM(int i, String str, String str2, String str3, String str4) {
        c.rlE.d(i, str, str2, str4);
    }

    public void reportDownloadInfo(int i, String str, String str2, String str3, String str4) {
        REMOTE_CALL("reportDownloadInfoMM", Integer.valueOf(i), str, str2, str3, str4);
    }

    @f
    public void addReportInfoMM(String str, String str2, String str3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.rlE;
        if (str != null && str.length() != 0) {
            aVar.rlC.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str2, str3));
        }
    }

    public void addReportInfo(String str, String str2, String str3) {
        REMOTE_CALL("addReportInfoMM", str, str2, str3);
    }

    public void writeDeferredDeepLink(String str, String str2) {
        REMOTE_CALL("writeDeferredDeepLinkMM", str, str2);
    }

    @f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        bvb().edit().putString(str, str2).commit();
    }

    public void deleteDeferredDeepLink(String str) {
        REMOTE_CALL("deleteDeferredDeepLinkMM", str);
    }

    @f
    public void deleteDeferredDeepLinkMM(String str) {
        bvb().edit().remove(str).commit();
    }

    private static SharedPreferences bvb() {
        return ad.getContext().getSharedPreferences(ad.getPackageName() + "_comm_preferences", 0);
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j, String str) {
        REMOTE_CALL("addCanvasCacheMM", Long.valueOf(j), str);
    }

    @f
    public void addCanvasCacheMM(long j, String str) {
        i.byA().o(j, str);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        REMOTE_CALL("asyncCacheXmlMM", str);
    }

    @f
    public void asyncCacheXmlMM(final String str) {
        g.Dr();
        g.Dt().g(new Runnable() {
            public final void run() {
                if (g.Do().CF()) {
                    m LQ = ae.bwf().LQ(str);
                    if (LQ != null) {
                        com.tencent.mm.plugin.sns.storage.b byB = LQ.byB();
                        if (byB != null) {
                            AdLandingPagesProxy.a(AdLandingPagesProxy.this, byB.bxl());
                            AdLandingPagesProxy.a(AdLandingPagesProxy.this, byB.bxm());
                        }
                    }
                }
            }
        }, 5000);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        return ((Integer) REMOTE_CALL("getAdVoteIndexMM", str, str2, str3)).intValue();
    }

    @f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        return com.tencent.mm.plugin.sns.storage.u.Z(str, str2, str3);
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        return (String) REMOTE_CALL("getAdVoteInfoMM", str, str2, str3);
    }

    @f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        return com.tencent.mm.plugin.sns.storage.u.aa(str, str2, str3);
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i, int i2) {
        REMOTE_CALL("saveAdVoteInfoMM", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
    }

    @f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i, int i2) {
        com.tencent.mm.plugin.sns.storage.u.f(str, str2, str3, i, i2);
    }

    public void doFavOfficialItemScene(String str, a aVar) {
        if (bi.oN(str)) {
            x.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            return;
        }
        this.qYo.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doFavOfficialItemSceneMM", Long.valueOf(r0), str);
    }

    @f
    public void doFavOfficialItemSceneMM(long j, String str) {
        k bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str);
        this.qYp.put(bVar, Long.valueOf(j));
        g.Dr();
        g.Dp().gRu.a(bVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onFavOfficialItemEnd(long j, String str, int i, int i2) {
        a aVar = (a) this.qYo.remove(Long.valueOf(j));
        if (i == 0 && i2 == 0) {
            x.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", str);
        } else {
            x.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        if (aVar != null) {
            aVar.e(i, i2, null);
        }
    }

    public String getSnsAdCanvasExtXml(String str) {
        return (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", str);
    }

    @f
    public String getSnsAdCanvasExtXmlMM(String str) {
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            return LQ.byD().rkg;
        }
        return "";
    }

    public void doCgiReportCanvasBrowseInfo(int i, String str) {
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", Integer.valueOf(i), str);
    }

    @f
    public void doCgiReportCanvasBrowseInfoMM(int i, String str) {
        aob aob = new aob();
        aob.wBF = i;
        aob.wBN = (int) (System.currentTimeMillis() / 1000);
        aob.kyA = 1;
        aob.wBG = new com.tencent.mm.bp.b(str.getBytes());
        List arrayList = new ArrayList();
        arrayList.add(aob);
        k eVar = new com.tencent.mm.plugin.sns.a.b.e(arrayList);
        g.Dr();
        g.Dp().gRu.a(eVar, 0);
    }
}
