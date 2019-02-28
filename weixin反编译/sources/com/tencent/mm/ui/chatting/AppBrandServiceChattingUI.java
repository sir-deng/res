package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.kz;
import com.tencent.mm.f.a.m;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.p;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class AppBrandServiceChattingUI extends MMFragmentActivity {
    public a yyt;
    public ag yyu = new ag();

    public static class b implements OnCreateContextMenuListener {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public b(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            x.d("MicroMsg.AppBrandServiceChattingUI", "menuListener onCreateCotextMenuListener");
            if (view != null) {
                ar arVar = (ar) view.getTag();
                if (arVar != null) {
                    int i = arVar.position;
                    au auVar = (au) this.yyH.yAM.getItem(i);
                    if (auVar == null) {
                        x.e("MicroMsg.AppBrandServiceChattingUI", "msg is null!");
                        return;
                    }
                    if (auVar.cjV()) {
                        contextMenu.add(i, 102, 0, this.yyH.getMMString(R.l.dQV));
                        contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eEP));
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                        if (g.R(this.yyH.getContext(), auVar.getType())) {
                            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                        }
                    }
                    if (auVar.cjT()) {
                        as.Hm();
                        if (c.isSDCardAvailable()) {
                            contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEP));
                            contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                            com.tencent.mm.sdk.b.b diVar = new di();
                            diVar.fsL.frh = auVar.field_msgId;
                            com.tencent.mm.sdk.b.a.xmy.m(diVar);
                            if (diVar.fsM.fsk || g.R(this.yyH.getContext(), auVar.getType())) {
                                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                            }
                            e eVar = null;
                            if (auVar.field_msgId > 0) {
                                eVar = o.PC().bj(auVar.field_msgId);
                            }
                            if (d.Pu("photoedit") && eVar.status != -1) {
                                int width;
                                int height;
                                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRv));
                                int[] iArr = new int[2];
                                if (view != null) {
                                    width = view.getWidth();
                                    height = view.getHeight();
                                    view.getLocationInWindow(iArr);
                                } else {
                                    height = 0;
                                    width = 0;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                add.setIntent(intent);
                            }
                        }
                    }
                    if (auVar.aNJ()) {
                        contextMenu.add(i, 111, 0, this.yyH.getMMString(R.l.eEP));
                        String str = auVar.field_content;
                        if (str != null) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                            if (fV == null) {
                                return;
                            }
                            if (fV.type == 5) {
                                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                            }
                        } else {
                            return;
                        }
                    }
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
                    contextMenu.add(i, 122, 0, this.yyH.getMMString(R.l.dRV));
                }
            }
        }
    }

    @SuppressLint({"ValidFragment"})
    public static class a extends com.tencent.mm.ui.chatting.ChattingUI.a {
        private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
        private String appId;
        private int fromScene;
        private com.tencent.mm.plugin.appbrand.config.WxaAttributes.b iSz;
        private WxaExposedParams jRg;
        private String jmd;
        private String jme;
        private String jmf;
        private boolean jmg;
        private int jmh;
        private String mSceneId;
        private final ChatFooter.d yyA = new ChatFooter.d() {
            public final boolean lu(boolean z) {
                if (a.this.iSz != null) {
                    com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a aVar = (com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a) a.this.iSz.iSI.get(0);
                    if (a.this.fromScene == 2 && a.this.jRg.username.equals(aVar.userName)) {
                        x.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", aVar.userName, aVar.foj);
                        a.a(a.this, aVar.foj);
                    } else {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1080;
                        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(a.this.getContext(), aVar.userName, "", 0, aVar.version, aVar.foj, appBrandStatObject, a.this.getAppId());
                    }
                } else {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
                }
                return true;
            }
        };
        private f yyB = new f() {
            public final Object a(k kVar) {
                switch (kVar.type) {
                    case 1:
                    case 25:
                    case 30:
                    case 31:
                        return a.this.csn();
                    default:
                        return null;
                }
            }

            public final Object b(k kVar) {
                if (kVar.type != 45) {
                    return null;
                }
                String str = new String(Base64.decode(kVar.url, 0));
                String str2 = new String(Base64.decode(bi.aD((String) kVar.A(String.class), ""), 0));
                x.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", str, str2);
                if (a.this.fromScene == 2 && a.this.jRg.appId.equals(str)) {
                    x.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", str, str2);
                    a.a(a.this, str2);
                    return Boolean.valueOf(true);
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1081;
                ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(a.this.getContext(), null, str, 0, 0, str2, appBrandStatObject);
                return null;
            }
        };
        private com.tencent.mm.ui.appbrand.c yyC;
        private boolean yyx;
        private String yyy = "";
        private com.tencent.mm.sdk.b.c<kz> yyz;

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$a$5 */
        class AnonymousClass5 extends com.tencent.mm.ui.chatting.viewitems.b.d {
            public AnonymousClass5(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.ui.chatting.viewitems.b bVar) {
                super(aVar, bVar);
            }

            public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
                x.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
                view.getTag();
                if (auVar.cjT()) {
                    super.a(view, aVar, auVar);
                } else if (auVar.aNJ()) {
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                        if (fV == null) {
                            return;
                        }
                        if (a.this.fromScene == 2 && fV.type == 33 && a.this.jRg.appId.equals(fV.hfj)) {
                            a.a(a.this, fV.hfh);
                        } else {
                            super.a(view, aVar, auVar);
                        }
                    }
                } else {
                    super.a(view, aVar, auVar);
                }
            }
        }

        static /* synthetic */ void a(a aVar, String str) {
            Intent intent = new Intent();
            intent.putExtra("keyOutPagePath", str);
            aVar.thisActivity().setResult(-1, intent);
            aVar.finish();
        }

        static /* synthetic */ void h(a aVar) {
            Bitmap a;
            com.tencent.mm.x.g.a aVar2 = new com.tencent.mm.x.g.a();
            aVar2.title = aVar.jmd;
            aVar2.type = 33;
            aVar2.hfi = aVar.jRg.username;
            aVar2.hfh = bi.oN(aVar.jme) ? aVar.jRg.fDk : aVar.jme;
            aVar2.hfj = aVar.jRg.appId;
            aVar2.hfp = aVar.jRg.iJa;
            aVar2.hfq = aVar.jRg.iJb;
            aVar2.hfl = aVar.jRg.iSX;
            aVar2.hfk = 2;
            aVar2.url = aVar.jRg.iSY;
            aVar2.hfr = aVar.jRg.iconUrl;
            aVar2.fHA = "wxapp_" + aVar.jRg.appId + aVar.jRg.fDk;
            aVar2.fHu = aVar.jRg.username;
            aVar2.fHv = aVar.jRg.fqG;
            byte[] bArr = new byte[0];
            if (aVar.jmh == 4) {
                a = com.tencent.mm.modelappbrand.a.b.Jp().a(aVar.jmf, null);
            } else if (bi.oN(aVar.jmf)) {
                a = null;
            } else {
                a = com.tencent.mm.modelappbrand.a.b.Jp().a(aVar.jmf, null);
                if (a == null || a.isRecycled()) {
                    a = com.tencent.mm.sdk.platformtools.d.Vs(aVar.jmf);
                    if (aVar.jmh != 2) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(aVar.jmf);
                        x.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", aVar.jmf, Boolean.valueOf(deleteFile));
                    }
                }
            }
            if (a == null || a.isRecycled()) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                x.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            l.a(aVar2, aVar.getAppId(), aVar.jmd, aVar.fBc.field_username, null, bArr);
        }

        public a(byte b) {
            super(true);
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            String str = "app_brand_chatting_expose_params";
            Parcelable parcelable = null;
            if (this.isCurrentActivity && thisActivity() != null) {
                parcelable = thisActivity().getIntent().getParcelableExtra(str);
            }
            if (parcelable == null && getArguments() != null) {
                parcelable = super.getArguments().getParcelable(str);
            }
            this.jRg = (WxaExposedParams) parcelable;
            this.mSceneId = bi.oM(getStringExtra("key_scene_id"));
            this.jmd = getStringExtra("sendMessageTitle");
            this.jme = getStringExtra("sendMessagePath");
            this.jmf = getStringExtra("sendMessageImg");
            this.jmg = getBooleanExtra("showMessageCard", false).booleanValue();
            this.jmh = getIntExtra("isBitmapFrom", 1);
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", this.jRg);
            x.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, isBitmapFrom:%d", this.mSceneId, this.jmd, this.jme, this.jmf, Boolean.valueOf(this.jmg), Integer.valueOf(this.jmh));
        }

        public final void onResume() {
            super.onResume();
            i.a(this.yyB);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (this.fromScene == 2) {
                as.CN().a(new com.tencent.mm.modelsimple.k(csn(), 19, getStringExtra("key_temp_session_from")), 0);
                x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            this.yyz = new com.tencent.mm.sdk.b.c<kz>() {
                {
                    this.xmG = kz.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    boolean z = false;
                    kz kzVar = (kz) bVar;
                    if (kzVar.fDc == null || kzVar.fDc.foe == null) {
                        x.e("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent event is empty");
                        return false;
                    }
                    x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", a.this.fBc.field_username, kzVar.fDc.foe, Integer.valueOf(kzVar.fDc.fDd));
                    if (!kzVar.fDc.foe.equals(a.this.fBc.field_username)) {
                        return true;
                    }
                    a aVar = a.this;
                    if ((kzVar.fDc.fDd & 2) > 0) {
                        z = true;
                    }
                    aVar.yyx = z;
                    a.this.getContext().runOnUiThread(new Runnable() {
                        public final void run() {
                            if (a.this.yyx) {
                                x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(a.this.yyx));
                                a.this.FS(0);
                                return;
                            }
                            x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(a.this.yyx));
                            a.this.FS(8);
                        }
                    });
                    return true;
                }
            };
            com.tencent.mm.sdk.b.a.xmy.b(this.yyz);
        }

        public final void crK() {
            com.tencent.mm.plugin.appbrand.config.WxaAttributes.b bVar;
            boolean z;
            String str = null;
            super.crK();
            this.yEM.ctp().cbZ();
            this.yEM.ctp().cch();
            this.yEM.ctp().cct();
            this.yEM.ctp().ccw();
            this.yEM.ctp().ccm();
            this.yEM.ctp().cci();
            this.yEM.ctp().cck();
            this.yEM.ctp().ccl();
            this.yEM.ctp().ccj();
            this.yEM.ctp().ccm();
            this.yEM.ctp().cci();
            this.yEM.ctp().ccv();
            this.yEM.ctp().tk();
            this.yEM.ctp().ccn();
            this.yEM.ctp().cco();
            this.yEM.ctp().lq(true);
            this.yEM.ctp().lr(true);
            this.yEM.ctp().ccp();
            this.yEM.ctp().ccq();
            this.yEM.ctp().ccr();
            this.yEM.ctp().ccl();
            this.yEM.ctp().ccs();
            this.yEM.ctp().lp(d.cdJ());
            Object csn = csn();
            if (TextUtils.isEmpty(csn)) {
                bVar = null;
            } else {
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(csn);
                if (rf != null) {
                    bVar = rf.acu();
                } else {
                    x.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", csn);
                    bVar = null;
                }
            }
            this.iSz = bVar;
            if (this.iSz != null && this.iSz.iSI.size() == 1) {
                this.yEM.ctp().CF(1);
                this.yEM.ctp().a(this.yyA);
            } else if (this.iSz == null || this.iSz.iSI == null) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", Integer.valueOf(this.iSz.iSI.size()));
            }
            WxaAttributes rf2 = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(this.fBc.field_username);
            if (rf2 == null || (rf2.field_appOpt & 2) <= 0) {
                z = false;
            } else {
                z = true;
            }
            this.yyx = z;
            if (rf2 != null) {
                str = rf2.field_appId;
            }
            this.appId = str;
            if (this.yyx) {
                FS(0);
            } else {
                FS(8);
            }
            if (this.fromScene == 2) {
                String appId = getAppId();
                str = this.fBc.field_username;
                int i = this.fromScene;
                as.Hm();
                ak XF = c.Fk().XF(str);
                if (XF == null) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", str);
                } else {
                    int i2 = XF.field_unReadCount;
                    String oM = bi.oM(this.mSceneId);
                    x.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), appId, Integer.valueOf(i), Integer.valueOf(i2), oM);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13799, appId, Integer.valueOf(i), Integer.valueOf(i2), oM, Long.valueOf(bi.Wx()));
                }
            }
            this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(getContext());
        }

        private String getAppId() {
            if (bi.oN(this.appId)) {
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(this.fBc.field_username);
                this.appId = rf == null ? null : rf.field_appId;
            }
            if (bi.oN(this.appId)) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            return this.appId;
        }

        protected final void crL() {
            super.crL();
            setMMSubTitle(R.l.dEu);
            if (TextUtils.isEmpty(this.yyy)) {
                this.yyy = com.tencent.mm.ui.appbrand.b.Zj(com.tencent.mm.ui.appbrand.b.Zi(this.fBc.field_username));
            }
            if (TextUtils.isEmpty(this.yyy)) {
                setMMSubTitle(R.l.dEu);
            } else {
                setMMSubTitle(getResources().getString(R.l.dEu) + "-" + this.yyy);
            }
        }

        public final void crM() {
            setMMTitle(this.fBc.field_nickname);
            if (this.yyx) {
                FS(0);
            } else {
                FS(8);
            }
        }

        public final void crN() {
            addIconOptionMenu(0, R.l.dEk, R.g.bDJ, new s() {
                public final void bKQ() {
                    int i;
                    boolean hideVKB = a.this.hideVKB();
                    Runnable anonymousClass1 = new Runnable() {
                        public final void run() {
                            String str;
                            String str2;
                            String Zi = com.tencent.mm.ui.appbrand.b.Zi(a.this.fBc.field_username);
                            if (TextUtils.isEmpty(Zi)) {
                                Zi = a.this.fBc.field_username;
                                str = a.this.fBc.field_nickname;
                                str2 = Zi;
                            } else {
                                str = com.tencent.mm.ui.appbrand.b.Zj(Zi);
                                str2 = Zi;
                            }
                            a.this.appBrandServiceActionSheet.username = a.this.fBc.field_username;
                            a.this.appBrandServiceActionSheet.klg = false;
                            a.this.appBrandServiceActionSheet.scene = a.this.fromScene;
                            a.this.appBrandServiceActionSheet.yeh = a.this.mSceneId;
                            if (a.this.fromScene == 2) {
                                a.this.appBrandServiceActionSheet.jRg = a.this.jRg;
                                if (a.this.yyx) {
                                    a.this.appBrandServiceActionSheet.show(1);
                                    return;
                                } else {
                                    a.this.appBrandServiceActionSheet.show(2);
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                            if (TextUtils.isEmpty(str2)) {
                                Zi = null;
                            } else {
                                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(str2);
                                if (rf == null || rf.acq() == null) {
                                    x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
                                    Zi = null;
                                } else {
                                    Zi = rf.field_appId;
                                }
                            }
                            aVar.appId = Zi;
                            aVar.fqZ = 4;
                            aVar.username = str2;
                            aVar.fqG = str;
                            a.this.appBrandServiceActionSheet.jRg = aVar.acv();
                            a.this.appBrandServiceActionSheet.appId = a.this.getAppId();
                            if (a.this.yyx) {
                                a.this.appBrandServiceActionSheet.show(5);
                            } else {
                                a.this.appBrandServiceActionSheet.show(6);
                            }
                        }
                    };
                    if (hideVKB) {
                        i = 100;
                    } else {
                        i = 0;
                    }
                    ah.h(anonymousClass1, (long) i);
                }
            });
            showOptionMenu(true);
        }

        protected final void crO() {
            super.crO();
            com.tencent.mm.sdk.b.b iyVar = new iy();
            iyVar.fAs.fAm = 0;
            iyVar.fAs.ael = w.cfV();
            if (com.tencent.mm.y.s.eX(csn())) {
                iyVar.fAs.fAu = true;
            } else {
                iyVar.fAs.fAu = false;
            }
            com.tencent.mm.sdk.b.a.xmy.m(iyVar);
        }

        protected final boolean crP() {
            com.tencent.mm.sdk.b.b pVar;
            if (this.fromScene == 2) {
                as.Hm();
                ae XF = c.Fk().XF("appbrandcustomerservicemsg");
                if (XF == null || bi.oN(XF.field_username)) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = XF.field_unReadCount;
                    com.tencent.mm.sdk.b.b mVar = new m();
                    mVar.foc.foe = this.fBc.field_username;
                    com.tencent.mm.sdk.b.a.xmy.m(mVar);
                    x.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i), Integer.valueOf(mVar.fod.fof));
                    XF.eP(Math.max(0, i - r2));
                    as.Hm();
                    if (c.Fk().a(XF, XF.field_username) == -1) {
                        x.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        pVar = new p();
                        pVar.fop.foe = this.fBc.field_username;
                        pVar.fop.fof = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(pVar);
                    }
                }
            } else {
                x.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.fBc.field_username);
                pVar = new p();
                pVar.fop.foe = this.fBc.field_username;
                pVar.fop.fof = 0;
                com.tencent.mm.sdk.b.a.xmy.m(pVar);
            }
            return super.crP();
        }

        public final void onViewAttachedToWindow(View view) {
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.jmg) {
                if (this.yyC == null) {
                    this.yyC = new com.tencent.mm.ui.appbrand.c(getActivity(), this.yEM.ctp().getRootView(), this.yEM.ctp(), !bi.oN(this.yEM.ctp().ccf()));
                    this.yyC.vyg = false;
                }
                if (!bi.oN(this.jmf)) {
                    int CI = (int) CI(75);
                    int CI2 = (int) CI(60);
                    if (!(this.jmh == 4 || this.jmf.startsWith("file://"))) {
                        this.jmf = "file://" + this.jmf;
                    }
                    com.tencent.mm.modelappbrand.a.b.Jp().a(this.yyC, this.jmf, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(CI, CI2));
                }
                this.yyC.yeq = new com.tencent.mm.ui.appbrand.c.a() {
                    public final void cpr() {
                        a.this.hideVKB();
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                a.h(a.this);
                            }
                        });
                    }
                };
                com.tencent.mm.ui.appbrand.c cVar = this.yyC;
                x.d("MicroMsg.AppBrandServiceImageBubble", "show");
                as.Dt().F(new Runnable() {
                    public final void run() {
                        c.this.yer.sendEmptyMessage(0);
                    }

                    public final String toString() {
                        return super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
                    }
                });
            }
        }

        private float CI(int i) {
            return TypedValue.applyDimension(1, (float) i, getContext().getResources().getDisplayMetrics());
        }

        public final void onPause() {
            super.onPause();
            i.b(this.yyB);
        }

        public final void onDestroy() {
            super.onDestroy();
            com.tencent.mm.sdk.b.a.xmy.c(this.yyz);
        }
    }

    protected void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.O(this);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        if (getIntent().getStringExtra("Chat_User") == null) {
            finish();
            x.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
            return;
        }
        setContentView(R.i.dex);
        this.yyt = new a((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
        this.yyt.setArguments(extras);
        getSupportFragmentManager().aT().a(R.h.cwx, this.yyt).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ah.h(new Runnable() {
                public final void run() {
                    h.a(AppBrandServiceChattingUI.this, AppBrandServiceChattingUI.this.getString(R.l.ezg), "", AppBrandServiceChattingUI.this.getString(R.l.ezh), AppBrandServiceChattingUI.this.getString(R.l.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new nq());
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new kt());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.Wi().Wj();
        initNavigationSwipeBack();
        this.yyu.post(new Runnable() {
            public final void run() {
                if (AppBrandServiceChattingUI.this.yyt != null) {
                    com.tencent.mm.pluginsdk.e.a(AppBrandServiceChattingUI.this, AppBrandServiceChattingUI.this.yyt.getBodyView());
                }
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", keyEvent);
        if (this.yyt == null || !this.yyt.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
