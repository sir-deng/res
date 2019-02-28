package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.lj;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, ac, b {
    protected ag handler;
    public long kMn;
    private boolean mIsPause = true;
    private TextView mXZ;
    private Animation qBt;
    private String talker;
    private boolean vGb = false;
    public boolean vus;
    private c yIZ = new c<gm>() {
        {
            this.xmG = gm.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gm gmVar = (gm) bVar;
            ImageGalleryGridUI.a(ImageGalleryGridUI.this, gmVar.fxt.fxw, gmVar);
            return false;
        }
    };
    private GridView yMA;
    c yMB;
    private WeakReference<a> yMC;
    private Boolean yMD;
    private Boolean yME;
    private TextView yMF;
    private Runnable yMG = new Runnable() {
        public final void run() {
            if (ImageGalleryGridUI.this.yMA != null && ImageGalleryGridUI.this.yMA.getVisibility() != 4) {
                ImageGalleryGridUI.this.yMA.setVisibility(4);
            }
        }
    };
    private Runnable yMH = new Runnable() {
        public final void run() {
            if (ImageGalleryGridUI.this.yMA != null && ImageGalleryGridUI.this.yMA.getVisibility() != 0) {
                ImageGalleryGridUI.this.yMA.setVisibility(0);
            }
        }
    };
    private boolean yMI = false;
    private long yMJ = 0;
    Runnable yMK = new Runnable() {
        @TargetApi(12)
        public final void run() {
            if (ImageGalleryGridUI.this.yML != null) {
                ImageGalleryGridUI.this.yML.setVisibility(8);
                ImageGalleryGridUI.this.yML = null;
            }
        }
    };
    public View yML = null;
    private View yMM;
    private int yMN = -1;
    private View yMO;
    private View yMP;
    private View yMQ;
    private View yMR;
    public int yMz;

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, gm gmVar) {
        if (imageGalleryGridUI.yMA != null) {
            int firstVisiblePosition = imageGalleryGridUI.yMA.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.yMA.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.yMA.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    gmVar.fxu.fpF = iArr[0];
                    gmVar.fxu.fpG = iArr[1];
                    gmVar.fxu.fpH = childAt.getWidth();
                    gmVar.fxu.fpI = childAt.getHeight();
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.cph;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yMI = true;
        this.handler = new ag();
        Gq(0);
        com.tencent.mm.sdk.b.a.xmy.b(this.yIZ);
    }

    protected final boolean cnD() {
        return true;
    }

    protected void onDestroy() {
        this.handler.removeCallbacks(this.yMH);
        this.handler = null;
        o.PG().bp(0);
        com.tencent.mm.sdk.b.a.xmy.c(this.yIZ);
        super.onDestroy();
    }

    protected void onResume() {
        a.yNw.a(this);
        this.mIsPause = false;
        if (this.yMI) {
            if (a.yNw.yNu) {
                cuW();
            } else {
                cuX();
            }
        }
        this.handler.postDelayed(this.yMH, 300);
        super.onResume();
        if (this.yMB != null) {
            this.yMB.yMs = true;
            c cVar = this.yMB;
            if (cVar.yMs) {
                cVar.notifyDataSetChanged();
            }
            if (a.yNw.yNu) {
                setMMTitle(getString(R.l.elR, new Object[]{Integer.valueOf(a.yNw.yLS.size())}));
            }
        }
        this.yMI = false;
        cvq();
    }

    protected void onPause() {
        g cvt = a.yNw;
        if (this != null) {
            cvt.yNv.remove(this);
        }
        this.mIsPause = true;
        super.onPause();
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        Gq(1);
    }

    public void onBackPressed() {
        if (a.yNw.yNu) {
            cuX();
        } else if (this.yMD.booleanValue()) {
            super.onBackPressed();
        } else {
            if (this.yMz >= 0) {
                L(null, this.yMz);
            }
            finish();
        }
    }

    @TargetApi(11)
    private void Gq(int i) {
        Intent intent = getIntent();
        this.yMD = Boolean.valueOf(intent.getIntExtra("kintent_intent_source", 0) == 1);
        this.talker = intent.getStringExtra("kintent_talker");
        this.yMz = intent.getIntExtra("kintent_image_index", 0);
        this.vus = intent.getBooleanExtra("key_is_biz_chat", false);
        this.kMn = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yME = Boolean.valueOf(true);
        setMMTitle(getString(R.l.dDM));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ImageGalleryGridUI.this.onBackPressed();
                return true;
            }
        });
        this.yMM = findViewById(R.h.cxo);
        View findViewById = findViewById(R.h.cgk);
        this.yMO = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.cSS);
        this.yMP = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.cIL);
        this.yMQ = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.bBF);
        this.yMR = findViewById;
        findViewById.setOnClickListener(this);
        this.mXZ = (TextView) findViewById(R.h.bJV);
        this.yMF = (TextView) findViewById(R.h.bJT);
        if (i == 0) {
            this.yMA = (GridView) findViewById(R.h.cph);
            this.yMA.setOnItemClickListener(this);
            this.yMA.setNumColumns(3);
            au auVar = new au();
            if (this.vus) {
                auVar.ar(this.kMn);
            }
            this.yMB = new c(this, auVar, this.talker);
            if (this.yMB.getCount() == 0) {
                this.yMF.setVisibility(0);
                return;
            }
            this.yMF.setVisibility(8);
            this.yMA.setAdapter(this.yMB);
            cvp();
        } else if (this.yMB != null) {
            this.yMB.notifyDataSetChanged();
            cvp();
        }
        this.yMA.setOnScrollListener(new OnScrollListener() {
            private Runnable mYD = new Runnable() {
                public final void run() {
                    ImageGalleryGridUI.this.mXZ.startAnimation(AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.xRr, R.a.bqa));
                    ImageGalleryGridUI.this.mXZ.setVisibility(8);
                }
            };

            private void fu(boolean z) {
                if (z) {
                    ImageGalleryGridUI.this.mXZ.removeCallbacks(this.mYD);
                    if (ImageGalleryGridUI.this.mXZ.getVisibility() != 0) {
                        ImageGalleryGridUI.this.mXZ.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.xRr, R.a.bpZ);
                        ImageGalleryGridUI.this.mXZ.setVisibility(0);
                        ImageGalleryGridUI.this.mXZ.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                ImageGalleryGridUI.this.mXZ.removeCallbacks(this.mYD);
                ImageGalleryGridUI.this.mXZ.postDelayed(this.mYD, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    fu(true);
                } else if (i == 0) {
                    fu(false);
                }
                o.PG().bp(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                Context context = ImageGalleryGridUI.this;
                au auVar = (au) context.yMB.getItem(i);
                if (auVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.gridviewheaders.a.cyc().a(new Date(auVar.field_createTime), context);
                }
                ImageGalleryGridUI.this.mXZ.setText(charSequence);
            }
        });
    }

    private void cvp() {
        int firstVisiblePosition = this.yMA.getFirstVisiblePosition();
        int lastVisiblePosition = this.yMA.getLastVisiblePosition();
        int i = this.yMz;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.yMA.setSelection(i);
        }
    }

    public void finish() {
        super.finish();
        a.yNw.detach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g.a I;
        au auVar = (au) this.yMB.getItem(i);
        String str = auVar.field_content;
        if (str != null) {
            I = g.a.I(str, auVar.field_reserved);
        } else {
            I = null;
        }
        String A;
        String str2;
        int i2;
        long j2;
        String bi;
        Intent intent;
        PackageInfo packageInfo;
        Bundle bundle;
        if (I != null && I.type == 6) {
            bj(auVar);
        } else if (I != null && I.type == 3) {
            str = p.A(I.url, "message");
            A = p.A(I.hcL, "message");
            PackageInfo packageInfo2 = getPackageInfo(this.mController.xRr, I.appId);
            str2 = packageInfo2 == null ? null : packageInfo2.versionName;
            i2 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
            String str3 = I.appId;
            j2 = auVar.field_msgId;
            long j3 = auVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (A == null || A.length() == 0)) {
                x.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
            }
            if (ao.isMobile(this.mController.xRr) ? A != null && A.length() > 0 : str == null || str.length() <= 0) {
                str = A;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("msg_id", j2);
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("version_name", str2);
            intent2.putExtra("version_code", i2);
            intent2.putExtra("usePlugin", true);
            intent2.putExtra("geta8key_username", this.talker);
            intent2.putExtra("KPublisherId", "msg_" + Long.toString(j3));
            intent2.putExtra("KAppId", str3);
            bi = bi(auVar);
            intent2.putExtra("pre_username", bi);
            intent2.putExtra("prePublishId", "msg_" + Long.toString(j3));
            if (auVar != null) {
                intent2.putExtra("preUsername", bi);
            }
            intent2.putExtra("preChatName", this.talker);
            intent2.putExtra("preChatTYPE", t.N(bi, this.talker));
            intent2.putExtra("preMsgIndex", 0);
            d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (I == null || I.type != 5) {
            Intent intent3;
            String w;
            Object obj;
            String str4;
            int i3;
            if (I != null && I.type == 19) {
                intent3 = new Intent();
                intent3.putExtra("message_id", auVar.field_msgId);
                intent3.putExtra("record_xml", I.hdm);
                d.b(this.mController.xRr, "record", ".ui.RecordMsgDetailUI", intent3);
            } else if (I != null && I.type == 24) {
                com.tencent.mm.sdk.b.b ljVar = new lj();
                ljVar.fDA.context = this.mController.xRr;
                ljVar.fDA.frh = auVar.field_msgId;
                ljVar.fDA.fDB = I.hdm;
                com.tencent.mm.sdk.b.a.xmy.m(ljVar);
            } else if (I != null && I.type == 7) {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(I.appId, false);
                if (aZ != null && aZ.YI()) {
                    Object obj2;
                    bi = this.talker;
                    if (s.eX(bi)) {
                        bi = bb.hS(auVar.field_content);
                    }
                    j2 = auVar.field_msgSvrId;
                    int i4 = (aZ == null || !p.m(this.mController.xRr, aZ.field_packageName)) ? 6 : 3;
                    if (I.type == 2) {
                        i4 = 4;
                    } else if (I.type == 5) {
                        i4 = 1;
                    }
                    com.tencent.mm.sdk.b.b njVar = new nj();
                    njVar.fGg.context = this.mController.xRr;
                    njVar.fGg.scene = 1;
                    njVar.fGg.fGh = I.appId;
                    njVar.fGg.packageName = aZ == null ? null : aZ.field_packageName;
                    njVar.fGg.msgType = I.type;
                    njVar.fGg.fAJ = bi;
                    njVar.fGg.fGi = i4;
                    njVar.fGg.mediaTagName = I.mediaTagName;
                    njVar.fGg.fGj = j2;
                    njVar.fGg.fGk = "";
                    com.tencent.mm.sdk.b.a.xmy.m(njVar);
                    j jVar = q.a.vjc;
                    if (com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xRr, aZ) || jVar == null) {
                        obj2 = null;
                    } else {
                        if (!bi.oN(aZ.fRD)) {
                            x.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", aZ.fRD, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aY(this.mController.xRr, aZ.fRD)));
                            if (com.tencent.mm.pluginsdk.model.app.q.aY(this.mController.xRr, aZ.fRD)) {
                                obj2 = 1;
                            }
                        }
                        com.tencent.mm.sdk.b.b gnVar = new gn();
                        gnVar.fxx.actionCode = 2;
                        gnVar.fxx.scene = 1;
                        gnVar.fxx.appId = aZ.field_appId;
                        gnVar.fxx.context = this.mController.xRr;
                        com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                        Intent intent4 = new Intent();
                        ActionBarActivity actionBarActivity = this.mController.xRr;
                        jVar.L(aZ.field_appId, 1, 1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return;
                    }
                    if (I.for == null || I.for.length() == 0) {
                        bi = auVar.field_content;
                        if (auVar.field_isSend == 0) {
                            i4 = auVar.field_isSend;
                            if (!this.vus && s.eX(this.talker) && bi != null && i4 == 0) {
                                bi = bb.hT(bi);
                            }
                        }
                        g.a fV = g.a.fV(bi);
                        f aZ2 = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, true);
                        if (aZ2 == null || !p.m(this.mController.xRr, aZ2.field_packageName)) {
                            w = p.w(this.mController.xRr, fV.appId, "message");
                            intent3 = new Intent();
                            intent3.putExtra("rawUrl", w);
                            d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent3);
                        } else if (aZ2.field_status == 3) {
                            x.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + aZ2.field_packageName);
                        } else if (!p.b(this.mController.xRr, aZ2)) {
                            x.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", aZ2.field_appName);
                            Toast.makeText(this.mController.xRr, getString(R.l.emB, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xRr, aZ2, null)}), 1).show();
                        } else if (!a(auVar, aZ2)) {
                            IMediaObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = fV.extInfo;
                            if (fV.for != null && fV.for.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(fV.for);
                                wXAppExtendObject.filePath = Se == null ? null : Se.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = 620823552;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = fV.title;
                            wXMediaMessage.description = fV.description;
                            wXMediaMessage.messageAction = fV.messageAction;
                            wXMediaMessage.messageExt = fV.messageExt;
                            wXMediaMessage.thumbData = e.d(o.PC().lp(auVar.field_imgPath), 0, -1);
                            new com.tencent.mm.ui.chatting.an(this).a(aZ2.field_packageName, wXMediaMessage, aZ2.field_appId, aZ2.field_openId);
                        }
                    } else if (this.vGb) {
                        intent3 = new Intent();
                        intent3.setClassName(this.mController.xRr, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent3.putExtra("app_msg_id", auVar.field_msgId);
                        startActivityForResult(intent3, i.CTRL_INDEX);
                    } else {
                        u.fJ(this.mController.xRr);
                    }
                }
            } else if (auVar.cjW() || auVar.cjT() || auVar.cjX() || auVar.ckb()) {
                if (I == null || bi.oN(I.heZ)) {
                    obj = null;
                } else {
                    bi = auVar.field_imgPath;
                    intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", I.heZ);
                    intent.putExtra("KThumUrl", I.hfe);
                    intent.putExtra("KThumbPath", bi);
                    intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                    intent.putExtra("KMediaVideoTime", I.hfa);
                    intent.putExtra("StremWebUrl", I.hfd);
                    intent.putExtra("StreamWording", I.hfc);
                    intent.putExtra("KMediaTitle", I.title);
                    str = auVar.field_talker;
                    boolean endsWith = str.endsWith("@chatroom");
                    bi = endsWith ? bb.hS(auVar.field_content) : str;
                    intent.putExtra("KSta_StremVideoAduxInfo", I.hff);
                    intent.putExtra("KSta_StremVideoPublishId", I.hfg);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", endsWith ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
                    intent.putExtra("KSta_FromUserName", bi);
                    intent.putExtra("KSta_ChatName", str);
                    intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                    intent.putExtra("KSta_SnsStatExtStr", I.fHB);
                    if (endsWith) {
                        intent.putExtra("KSta_ChatroomMembercount", m.gn(str));
                    }
                    d.b(this.mController.xRr, "sns", ".ui.VideoAdPlayerUI", intent);
                    obj = 1;
                }
                if (obj == null) {
                    L(view, i);
                }
            } else if (I != null && I.type == 15) {
                obj = I.hdp;
                if (TextUtils.isEmpty(obj)) {
                    obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yN(I.url);
                }
                if (TextUtils.isEmpty(obj)) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                    intent5.putExtra("rawUrl", I.url);
                    d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent5);
                    return;
                }
                x.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                intent3 = new Intent();
                intent3.putExtra("extra_id", obj);
                intent3.putExtra("preceding_scence", 123);
                intent3.putExtra("download_entrance_scene", 23);
                d.b(this.mController.xRr, "emoji", ".ui.EmojiStoreDetailUI", intent3);
                com.tencent.mm.plugin.report.service.g.pWK.h(10993, Integer.valueOf(2), obj);
            } else if (I != null && I.type == 26) {
                i2 = I.tid;
                str = I.heX;
                A = I.desc;
                str2 = I.iconUrl;
                str4 = I.secondUrl;
                i3 = I.pageType;
                if (i2 != 0) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", bi(auVar));
                    intent6.putExtra("rawUrl", I.gkB);
                    intent6.putExtra("topic_id", i2);
                    intent6.putExtra("topic_name", str);
                    intent6.putExtra("topic_desc", A);
                    intent6.putExtra("topic_icon_url", str2);
                    intent6.putExtra("topic_ad_url", str4);
                    intent6.putExtra("extra_scence", 23);
                    d.b(this.mController.xRr, "emoji", ".ui.EmojiStoreTopicUI", intent6);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            } else if (I == null || I.type != 27) {
                x.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.getType()), auVar.field_content);
                if (I.url != null && !I.url.equals("") && I.url != null && !I.url.equals("")) {
                    bi = p.A(I.url, s.eX(this.talker) ? "groupmessage" : "singlemessage");
                    str = I.url;
                    packageInfo = getPackageInfo(this.mController.xRr, I.appId);
                    intent = new Intent();
                    intent.putExtra("rawUrl", bi);
                    intent.putExtra("webpageTitle", I.title);
                    if (I.appId != null && ("wx751a1acca5688ba3".equals(I.appId) || "wxfbc915ff7c30e335".equals(I.appId) || "wx482a4001c37e2b74".equals(I.appId))) {
                        bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", I.appId);
                        intent.putExtra("jsapiargs", bundle);
                    }
                    if (bi.oN(str)) {
                        intent.putExtra("shortUrl", I.url);
                    } else {
                        intent.putExtra("shortUrl", str);
                    }
                    intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                    intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                    if (!bi.oN(I.fHu)) {
                        intent.putExtra("srcUsername", I.fHu);
                        intent.putExtra("srcDisplayname", I.fHv);
                    }
                    intent.putExtra("msg_id", auVar.field_msgId);
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    intent.putExtra("KAppId", I.appId);
                    intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                    intent.putExtra("pre_username", bi(auVar));
                    intent.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    w = bi(auVar);
                    bi = com.tencent.mm.y.q.FY();
                    intent.putExtra("preUsername", w);
                    intent.putExtra("preChatName", bi);
                    intent.putExtra("preChatTYPE", t.N(w, bi));
                    intent.putExtra("preMsgIndex", 0);
                    d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                }
            } else {
                i2 = I.tid;
                str = I.heX;
                A = I.desc;
                str2 = I.iconUrl;
                str4 = I.secondUrl;
                i3 = I.pageType;
                if (i2 != 0) {
                    Intent intent7 = new Intent();
                    intent7.putExtra("geta8key_username", bi(auVar));
                    intent7.putExtra("rawUrl", I.gkB);
                    intent7.putExtra("set_id", i2);
                    intent7.putExtra("set_title", str);
                    intent7.putExtra("set_iconURL", str2);
                    intent7.putExtra("set_desc", A);
                    intent7.putExtra("headurl", str4);
                    intent7.putExtra("pageType", i3);
                    d.b(this.mController.xRr, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent7);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            }
        } else if (I.url != null && !I.url.equals("")) {
            bi = p.A(I.url, this.talker.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            str = I.url;
            packageInfo = getPackageInfo(this.mController.xRr, I.appId);
            intent = new Intent();
            intent.putExtra("rawUrl", bi);
            intent.putExtra("webpageTitle", I.title);
            if (I.appId != null && ("wx751a1acca5688ba3".equals(I.appId) || "wxfbc915ff7c30e335".equals(I.appId) || "wx482a4001c37e2b74".equals(I.appId))) {
                bundle = new Bundle();
                bundle.putString("jsapi_args_appid", I.appId);
                intent.putExtra("jsapiargs", bundle);
            }
            if (bi.oN(str)) {
                intent.putExtra("shortUrl", I.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!bi.oN(I.fHu)) {
                intent.putExtra("srcUsername", I.fHu);
                intent.putExtra("srcDisplayname", I.fHv);
            }
            intent.putExtra("msg_id", auVar.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
            intent.putExtra("KAppId", I.appId);
            intent.putExtra("geta8key_username", this.talker);
            bi = bi(auVar);
            intent.putExtra("pre_username", bi);
            intent.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
            intent.putExtra("preUsername", bi);
            intent.putExtra("preChatName", this.talker);
            intent.putExtra("preChatTYPE", t.N(bi, this.talker));
            intent.putExtra("preMsgIndex", 0);
            d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", av(this.mController.xRr, "com.tencent.mobileqq"));
        intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        as.Hm();
        Object obj = com.tencent.mm.y.c.Db().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        try {
            startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String bi(com.tencent.mm.storage.au r4) {
        /*
        r3 = this;
        r0 = r3.talker;
        r1 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r1);
        r0 = r3.talker;
        r2 = "@chatroom";
        r0 = r0.endsWith(r2);
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        if (r0 == 0) goto L_0x0027;
    L_0x0017:
        r0 = r4.field_content;
        r0 = com.tencent.mm.y.bb.hS(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0027;
    L_0x0025:
        r1 = r0;
        goto L_0x0014;
    L_0x0027:
        r0 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.bi(com.tencent.mm.storage.au):java.lang.String");
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object str22 = packageInfo;
            } else {
                str22 = aZ.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            return packageInfo;
        }
    }

    private void bj(au auVar) {
        long j = this.yMJ + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yMJ = currentTimeMillis;
        if (j < currentTimeMillis) {
            as.Hm();
            this.vGb = com.tencent.mm.y.c.isSDCardAvailable();
        }
        if (this.vGb) {
            Intent intent = new Intent();
            intent.setClassName(this.mController.xRr, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", auVar.field_msgId);
            startActivity(intent);
            return;
        }
        u.fJ(this.mController.xRr);
    }

    private void L(View view, int i) {
        if (this.yMB != null) {
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_biz_chat_id", this.kMn);
            intent.putExtra("key_is_biz_chat", this.vus);
            intent.putExtra("intent.key.with.footer", true);
            au auVar = (au) this.yMB.getItem(i);
            if (auVar != null) {
                int width;
                int height;
                int i2 = getResources().getConfiguration().orientation;
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("img_gallery_msg_id", auVar.field_msgId).putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId).putExtra("img_gallery_talker", auVar.field_talker).putExtra("img_gallery_chatroom_name", auVar.field_talker).putExtra("img_gallery_orientation", i2);
                if (view != null) {
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                } else {
                    intent.putExtra("img_gallery_back_from_grid", true);
                }
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }
    }

    public boolean onPreDraw() {
        a aVar = (a) this.yMC.get();
        if (aVar != null) {
            ViewTreeObserver viewTreeObserver = aVar.qwg.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.qwg.getMeasuredWidth();
                int measuredHeight = aVar.qwg.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.yGY.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.yGY.setLayoutParams(layoutParams);
                    final View view = aVar.yGY;
                    final TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.yML = view;
                        this.handler.postDelayed(new Runnable() {
                            public final void run() {
                                if (VERSION.SDK_INT >= 16) {
                                    view.animate().setDuration(500).alpha(0.0f).withEndAction(ImageGalleryGridUI.this.yMK).withLayer().setInterpolator(decelerateInterpolator);
                                } else if (ImageGalleryGridUI.this.handler != null) {
                                    view.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.yMK, 500);
                                }
                            }
                        }, 700);
                    }
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(R.l.eln))) {
            a.yNw.clear();
            cuW();
        } else {
            cuX();
        }
        return false;
    }

    private void cuW() {
        setMMTitle(getString(R.l.elR, new Object[]{Integer.valueOf(a.yNw.yLS.size())}));
        a.yNw.yNu = true;
        if (this.yMB != null) {
            if (this.qBt == null) {
                this.qBt = AnimationUtils.loadAnimation(this, R.a.bqo);
            }
            c cVar = this.yMB;
            cVar.hMK = false;
            cVar.notifyDataSetChanged();
            this.yMM.setVisibility(0);
            this.yMM.startAnimation(this.qBt);
            this.yMO.setEnabled(false);
            this.yMP.setEnabled(false);
            this.yMQ.setEnabled(false);
            this.yMR.setEnabled(false);
            this.yMN = this.yMA.getPaddingBottom();
            this.yMA.setPadding(this.yMA.getPaddingLeft(), this.yMA.getPaddingTop(), this.yMA.getPaddingRight(), com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvS));
            com.tencent.mm.plugin.report.service.g.pWK.h(11627, Integer.valueOf(2));
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.elm), this);
        }
    }

    private void cvq() {
        boolean z = !a.yNw.yLS.isEmpty() && a.yNw.yNu;
        if (z) {
            this.yMO.setEnabled(true);
            this.yMP.setEnabled(true);
            this.yMQ.setEnabled(true);
            this.yMR.setEnabled(true);
            return;
        }
        this.yMO.setEnabled(false);
        this.yMP.setEnabled(false);
        this.yMQ.setEnabled(false);
        this.yMR.setEnabled(false);
    }

    public final void cuX() {
        a.yNw.yNu = false;
        setMMTitle(getString(R.l.dDM));
        if (this.yMB != null) {
            this.yMB.notifyDataSetChanged();
            if (this.yMN >= 0) {
                this.yMA.setPadding(this.yMA.getPaddingLeft(), this.yMA.getPaddingTop(), this.yMA.getPaddingRight(), this.yMN);
            }
            this.yMM.setVisibility(8);
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.eln), this);
        }
    }

    public void onClick(View view) {
        if (!a.yNw.yLS.isEmpty()) {
            boolean endsWith = this.talker.toLowerCase().endsWith("@chatroom");
            final List<au> list = a.yNw.yLS;
            if (list != null && !list.isEmpty()) {
                au auVar;
                String str;
                if (view.getId() == R.h.bBF) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11627, Integer.valueOf(5));
                    final Set treeSet = new TreeSet();
                    for (au auVar2 : list) {
                        treeSet.add(Long.valueOf(auVar2.field_msgId));
                    }
                    h.a((Context) this, getString(R.l.dUg), "", getString(R.l.dYG), getString(R.l.dEy), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.GalleryGridUI", "delete message");
                            com.tencent.mm.ui.chatting.h.a(ImageGalleryGridUI.this, treeSet, ImageGalleryGridUI.this);
                            ImageGalleryGridUI.this.cuX();
                        }
                    }, null);
                } else if (view.getId() == R.h.cgk) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(219, 18, 1, true);
                    final cg cgVar = new cg();
                    if (com.tencent.mm.pluginsdk.model.h.a(this.mController.xRr, cgVar, this.talker, list, false, false)) {
                        b(cgVar);
                        dk(list);
                    } else if (list.size() > 1) {
                        String string;
                        Context context = this.mController.xRr;
                        String string2 = cgVar.frk.frq >= 0 ? this.mController.xRr.getString(R.l.efH) : this.mController.xRr.getString(R.l.efG);
                        str = "";
                        if (cgVar.frk.frq >= 0) {
                            string = this.mController.xRr.getString(R.l.dUn);
                        } else {
                            string = this.mController.xRr.getString(R.l.eAq);
                        }
                        h.a(context, string2, str, string, this.mController.xRr.getString(R.l.dUl), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (cgVar.frk.type == 14 && cgVar.frk.frm.wlY.size() == 0) {
                                    ImageGalleryGridUI.this.cuX();
                                    return;
                                }
                                ImageGalleryGridUI.this.b(cgVar);
                                ImageGalleryGridUI.dk(list);
                            }
                        }, null);
                    } else {
                        h.h(this.mController.xRr, cgVar.frk.frq, 0);
                    }
                } else if (view.getId() == R.h.cSS) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(219, 19, 1, true);
                    com.tencent.mm.ui.chatting.j.a(this, list, endsWith, this.talker, this);
                    cuX();
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11627, Integer.valueOf(3));
                    final List dp = dp(list);
                    if (dp.size() != list.size()) {
                        h.a(this.mController.xRr, R.l.elH, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.c(ImageGalleryGridUI.this.mController.xRr, dp);
                                ImageGalleryGridUI.this.cuX();
                            }
                        }, null);
                        return;
                    }
                    auVar2 = (au) dp.get(0);
                    if (list.size() == 1 && auVar2 != null && auVar2.aNJ()) {
                        str = auVar2.field_content;
                        g.a aVar = null;
                        if (str != null) {
                            aVar = g.a.I(str, auVar2.field_reserved);
                        }
                        if (aVar != null && aVar.type == 6) {
                            bj(auVar2);
                            return;
                        }
                        return;
                    }
                    b.c(this, list);
                    cuX();
                }
            }
        }
    }

    private static void dk(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
    }

    private static List<au> dp(List<au> list) {
        List<au> arrayList = new ArrayList();
        for (au auVar : list) {
            if (!(b.aY(auVar) || b.aZ(auVar))) {
                arrayList.add(auVar);
            }
        }
        return arrayList;
    }

    private void b(cg cgVar) {
        cgVar.frk.activity = this;
        cgVar.frk.frr = 45;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        if (cgVar.frl.ret != -2 && cgVar.frl.ret <= 0 && cgVar.frl.ret <= 0) {
            cuX();
            if (14 != cgVar.frk.type) {
                x.d("MicroMsg.GalleryGridUI", "not record type, do not report");
            } else if (cgVar.frk.frn == null) {
                x.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.h(11142, Integer.valueOf(cgVar.frk.frn.wmo), Integer.valueOf(cgVar.frk.frn.wmp), Integer.valueOf(cgVar.frk.frn.wmq), Integer.valueOf(cgVar.frk.frn.wmr), Integer.valueOf(cgVar.frk.frn.wms), Integer.valueOf(cgVar.frk.frn.wmt), Integer.valueOf(cgVar.frk.frn.wmu), Integer.valueOf(cgVar.frk.frn.wmv), Integer.valueOf(cgVar.frk.frn.wmw), Integer.valueOf(cgVar.frk.frn.wmx), Integer.valueOf(cgVar.frk.frn.wmy), Integer.valueOf(cgVar.frk.frn.wmz), Integer.valueOf(cgVar.frk.frn.wmA), Integer.valueOf(cgVar.frk.frn.wmB), Integer.valueOf(cgVar.frk.frn.wmC));
            }
        }
    }

    public final void cvr() {
        if (this.yMB != null && this.mIsPause) {
            this.yMB.yMs = true;
        }
        setMMTitle(getString(R.l.elR, new Object[]{Integer.valueOf(a.yNw.yLS.size())}));
        cvq();
    }

    public final void clear() {
        if (this.yMB != null && this.mIsPause) {
            this.yMB.yMs = true;
        }
        cvq();
    }

    public final void csH() {
    }

    public final void a(ac.a aVar) {
    }

    public final boolean csI() {
        return true;
    }

    public final void b(ac.a aVar) {
        if (aVar == ac.a.del) {
            this.yMB.XH();
            this.yMB.notifyDataSetChanged();
        }
        cuX();
    }
}
