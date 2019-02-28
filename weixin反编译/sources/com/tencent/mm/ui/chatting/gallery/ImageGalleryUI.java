package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.f;
import com.tencent.mm.f.a.aj;
import com.tencent.mm.f.a.ak;
import com.tencent.mm.f.a.aq;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.kh;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, com.tencent.mm.sdk.platformtools.al.a {
    protected String chatroomName;
    public long frh;
    private int jAq;
    private int jAr;
    public long kMn;
    Bundle kXK;
    private boolean kXL = false;
    g kXM;
    int kXN = 0;
    int kXO = 0;
    int kXP = 0;
    int kXQ = 0;
    private d lKE = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            cg cvm;
            r nJ;
            switch (menuItem.getItemId()) {
                case 0:
                    cvm = ImageGalleryUI.this.yLG.cvm();
                    if (cvm == null || !cvm.cjW()) {
                        ImageGalleryUI.this.yLG.Gf(ImageGalleryUI.this.mZy.yF);
                        return;
                    }
                    nJ = t.nJ(cvm.field_imgPath);
                    if (nJ.status == 199 || nJ.status == 199) {
                        ImageGalleryUI.this.yLG.Gf(ImageGalleryUI.this.mZy.yF);
                        return;
                    }
                    ImageGalleryUI.this.yNX = t.d(cvm.field_msgId, 1);
                    ImageGalleryUI.this.yLG.Gk(ImageGalleryUI.this.mZy.yF);
                    return;
                case 1:
                    cvm = ImageGalleryUI.this.yLG.cvm();
                    if (cvm == null || !cvm.cjW()) {
                        List arrayList = new ArrayList();
                        arrayList.add(ImageGalleryUI.this.yLG.cvm());
                        b.hRo.y((au) arrayList.get(0));
                        b.c(ImageGalleryUI.this.mController.xRr, arrayList);
                        return;
                    }
                    nJ = t.nJ(cvm.field_imgPath);
                    if (nJ.status == 199 || nJ.status == 199) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(ImageGalleryUI.this.yLG.cvm());
                        b.c(ImageGalleryUI.this.mController.xRr, arrayList2);
                        return;
                    }
                    ImageGalleryUI.this.yNX = t.d(cvm.field_msgId, 2);
                    ImageGalleryUI.this.yLG.Gk(ImageGalleryUI.this.mZy.yF);
                    return;
                case 2:
                    if (com.tencent.mm.bl.d.Pu("favorite")) {
                        ImageGalleryUI.this.yLG.Gh(ImageGalleryUI.this.mZy.yF);
                        return;
                    }
                    return;
                case 3:
                    x.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    ca caVar = new ca();
                    caVar.fqV.activity = ImageGalleryUI.this;
                    caVar.fqV.fpo = ImageGalleryUI.this.ryI;
                    caVar.fqV.fqW = ImageGalleryUI.this.jAq;
                    caVar.fqV.fqX = ImageGalleryUI.this.jAr;
                    caVar.fqV.scene = 37;
                    caVar.fqV.frc = ImageGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                    ImageGalleryUI.a(ImageGalleryUI.this, caVar);
                    ImageGalleryUI.b(ImageGalleryUI.this, caVar);
                    com.tencent.mm.sdk.b.a.xmy.m(caVar);
                    return;
                case 4:
                    ImageGalleryUI.this.yLG.Gg(ImageGalleryUI.this.mZy.yF);
                    return;
                case 5:
                    ImageGalleryUI.x(ImageGalleryUI.this);
                    return;
                case 6:
                    if (b.aW(ImageGalleryUI.this.yLG.cvm())) {
                        ImageGalleryUI.this.cvS();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private ImageView mDh;
    private ag mHandler = new ag(Looper.getMainLooper());
    protected MMViewPager mZy;
    private c myb = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mt mtVar = (mt) bVar;
            if (ImageGalleryUI.this.ryE == null || ImageGalleryUI.this.ryF == null) {
                x.e("MicroMsg.ImageGalleryUI", "not in recoging");
            } else if (mtVar == null || !(mtVar instanceof mt)) {
                x.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
            } else if (mtVar == null || mtVar.fFy.filePath.equals(ImageGalleryUI.this.ryF)) {
                x.i("MicroMsg.ImageGalleryUI", "recog result: " + mtVar.fFy.result);
                if (!bi.oN(mtVar.fFy.result)) {
                    ImageGalleryUI.this.ryI = mtVar.fFy.result;
                    ImageGalleryUI.this.jAq = mtVar.fFy.fqW;
                    ImageGalleryUI.this.jAr = mtVar.fFy.fqX;
                    if (!(ImageGalleryUI.this.ryI == null || ImageGalleryUI.this.ryE == null)) {
                        ImageGalleryUI.this.ryJ = true;
                    }
                    ImageGalleryUI.this.na(false);
                }
                ImageGalleryUI.this.ryF = null;
            } else {
                x.e("MicroMsg.ImageGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private boolean ovY;
    int rFi;
    int rFj;
    int rFk = 0;
    private float rFl = 1.0f;
    private int rFm = 0;
    private int rFn = 0;
    private com.tencent.mm.ui.widget.g ryE;
    private String ryF;
    private String ryI;
    private boolean ryJ = false;
    private c ryL = new c<kh>() {
        {
            this.xmG = kh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kh khVar = (kh) bVar;
            if (khVar != null && (khVar instanceof kh)) {
                x.i("MicroMsg.ImageGalleryUI", "notify Event: %d", Integer.valueOf(khVar.fCx.fCv));
                if (khVar.fCx.activity == ImageGalleryUI.this && khVar.fCx.fpo.equals(ImageGalleryUI.this.ryI)) {
                    switch (khVar.fCx.fCv) {
                        case 3:
                            ImageGalleryUI.this.finish();
                            break;
                    }
                }
                x.e("MicroMsg.ImageGalleryUI", "not the same");
            } else {
                x.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            return false;
        }
    };
    protected String talker;
    public boolean vus = false;
    private boolean yAH = false;
    protected boolean yJq = false;
    private HashSet<Long> yKm = new HashSet();
    public b yLG;
    private final boolean yLQ = false;
    private b.b yNA;
    private RelativeLayout yNB;
    private RelativeLayout yNC;
    private boolean yND;
    private boolean yNE = false;
    private ImageView yNF;
    private RelativeLayout yNG;
    private RelativeLayout yNH;
    private FrameLayout yNI;
    View yNJ;
    Button yNK;
    Button yNL;
    View yNM;
    private View yNN;
    protected VideoPlayerSeekBar yNO;
    private MultiTouchImageView yNP;
    int yNQ = 0;
    int yNR = 0;
    boolean yNS;
    ArrayList<Integer> yNT = new ArrayList();
    protected boolean yNU = false;
    protected boolean yNV = false;
    private boolean yNW;
    private String yNX = null;
    public a yNY;
    private View yNZ;
    private CheckBox yOa;
    private View yOb;
    private boolean yOc = true;
    private int yOd = 0;
    private e yOe = new e() {
        private boolean yOo = false;

        public final void a(int i, float f, int i2) {
        }

        public final void ae(int i) {
            if (ImageGalleryUI.this.yLG != null) {
                View Fj = ImageGalleryUI.this.yLG.Fj(i);
                if (Fj == null) {
                    x.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", Integer.valueOf(i));
                }
                ImageGalleryUI.q(ImageGalleryUI.this);
                ImageGalleryUI.this.yOd = i;
                if (ImageGalleryUI.this.yLG != null) {
                    b f = ImageGalleryUI.this.yLG;
                    f.yLN.cvu();
                    f.yLO.cvu();
                    cg Ge = ImageGalleryUI.this.yLG.Ge(i);
                    if (!((!b.aW(Ge) && !b.aZ(Ge)) || Fj == null || Fj.getTag() == null)) {
                        ((j) Fj.getTag()).yPm.cqG();
                    }
                    if (Ge != null) {
                        ImageGalleryUI.this.go(Ge.field_msgId);
                    }
                    if (ImageGalleryUI.this.yLG != null) {
                        com.tencent.mm.ap.e f2 = ImageGalleryUI.this.yLG.f(Ge, false);
                        ImageGalleryUI.this.yLG;
                        if (b.a(Ge, f2)) {
                            f2 = f.a(f2);
                            int i2 = f2.hmZ;
                            x.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) f2.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis()));
                            ImageGalleryUI.this.Gy(r0);
                        } else if (Ge == null || Ge.cjW() || !ImageGalleryUI.this.yLG.bb(Ge)) {
                            ImageGalleryUI.this.fx(true);
                        } else {
                            ImageGalleryUI.this.fx(false);
                        }
                    } else {
                        x.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                    }
                    if (Ge == null) {
                        x.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + i);
                    } else {
                        ImageGalleryUI.this.bp(Ge);
                        ImageGalleryUI.this.cvA();
                    }
                }
                if (ImageGalleryUI.this.yLG != null) {
                    ImageGalleryUI.this.yLG.ae(i);
                }
            }
        }

        public final void af(int i) {
            x.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i));
            if (i == 2) {
                this.yOo = true;
                ImageGalleryUI.this.cvP();
                ImageGalleryUI.this.cvL();
                ImageGalleryUI.this.cvM();
            }
            if (i == 0) {
                if (this.yOo) {
                    ImageGalleryUI.this.cvO();
                }
                this.yOo = false;
            }
            if (ImageGalleryUI.this.yLG != null) {
                b f = ImageGalleryUI.this.yLG;
                if (f.yLM != null) {
                    d dVar = f.yLM;
                    dVar.yi = i;
                    if (dVar.yNa != null) {
                        dVar.yNa.af(i);
                    }
                }
            }
        }
    };
    boolean yOf = false;
    al yOg = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (ImageGalleryUI.this.yOf) {
                ImageGalleryUI.this.cvG();
            }
            return false;
        }
    }, false);
    private HashMap<Long, String> yOh = new HashMap();
    private boolean yOi = false;
    private boolean yOj = false;
    private al yOk;
    private boolean yOl = false;
    private boolean yOm = false;

    public interface a {
        void j(Boolean bool);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, ca caVar) {
        int i;
        String str;
        int i2 = 2;
        x.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", imageGalleryUI.talker, imageGalleryUI.chatroomName);
        String str2 = "";
        if (!bi.oN(imageGalleryUI.chatroomName) && s.eX(imageGalleryUI.chatroomName)) {
            x.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", imageGalleryUI.chatroomName);
            i = 2;
            str = imageGalleryUI.chatroomName;
        } else if (bi.oN(imageGalleryUI.talker)) {
            x.e("MicroMsg.ImageGalleryUI", "unknow source");
            str = str2;
            i = -1;
        } else {
            if (s.gI(imageGalleryUI.talker)) {
                x.d("MicroMsg.ImageGalleryUI", "is biz: %s", imageGalleryUI.talker);
                i2 = 4;
            } else if (s.eX(imageGalleryUI.talker)) {
                x.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", imageGalleryUI.talker);
            } else {
                x.d("MicroMsg.ImageGalleryUI", "is single chat: %s", imageGalleryUI.talker);
                i2 = 1;
            }
            i = i2;
            str = imageGalleryUI.talker;
        }
        caVar.fqV.fqY = i;
        caVar.fqV.bhd = str;
    }

    static /* synthetic */ void b(ImageGalleryUI imageGalleryUI, ca caVar) {
        com.tencent.mm.ap.e f = imageGalleryUI.yLG.f(imageGalleryUI.yLG.cvm(), true);
        if (f != null && !bi.oN(f.hBL)) {
            Map y = bj.y(f.hBL, "msg");
            if (y != null) {
                caVar.fqV.frb = (String) y.get(".msg.img.$aeskey");
                caVar.fqV.imagePath = (String) y.get(".msg.img.$cdnmidimgurl");
            }
        }
    }

    static /* synthetic */ void h(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.cvD()) {
            try {
                if (imageGalleryUI.yLG.cvn().cvZ().yPb.getVisibility() == 0) {
                    x.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", Integer.valueOf(imageGalleryUI.hashCode()));
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.yOf) {
                imageGalleryUI.cvG();
                return;
            } else {
                imageGalleryUI.cvF();
                return;
            }
        }
        imageGalleryUI.onBackPressed();
    }

    static /* synthetic */ void m(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cvD()) {
            try {
                if (imageGalleryUI.yLG.cvn().cvZ().yOZ.getVisibility() == 0) {
                    imageGalleryUI.yLG.cvn().cvZ().yOZ.setVisibility(8);
                    imageGalleryUI.yOi = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yOf) {
            imageGalleryUI.cvG();
            imageGalleryUI.yOj = true;
        }
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        final View a = imageGalleryUI.a(imageGalleryUI.yLG, imageGalleryUI.mZy);
        imageGalleryUI.mZy.ynk = new MMViewPager.b() {
            public final void E(float f, float f2) {
                float f3 = 1.0f;
                float height = 1.0f - (f2 / ((float) ImageGalleryUI.this.mZy.getHeight()));
                if (height <= 1.0f) {
                    f3 = height;
                }
                ImageGalleryUI.this.rFl = f3;
                if (a != null) {
                    if (f == 0.0f && f2 == 0.0f) {
                        ImageGalleryUI.r(ImageGalleryUI.this);
                    } else {
                        ImageGalleryUI.m(ImageGalleryUI.this);
                    }
                    a.setPivotX((float) (ImageGalleryUI.this.mZy.getWidth() / 2));
                    a.setPivotY((float) (ImageGalleryUI.this.mZy.getHeight() / 2));
                    a.setScaleX(f3);
                    a.setScaleY(f3);
                    a.setTranslationX(f);
                    a.setTranslationY(f2);
                    ImageGalleryUI.this.mDh.setAlpha(f3);
                    return;
                }
                x.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
            }

            public final void F(float f, float f2) {
                ImageGalleryUI.this.rFm = (int) f;
                ImageGalleryUI.this.rFn = (int) f2;
            }
        };
    }

    static /* synthetic */ void r(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cvD() && imageGalleryUI.yOi) {
            try {
                if (imageGalleryUI.yLG.cvn().cvZ().yOZ.getVisibility() == 8) {
                    imageGalleryUI.yLG.cvn().cvZ().yOZ.setVisibility(0);
                    imageGalleryUI.yOi = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yOj) {
            imageGalleryUI.cvF();
            imageGalleryUI.yOj = false;
        }
    }

    static /* synthetic */ void x(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.talker, Long.valueOf(imageGalleryUI.yLG.Ge(imageGalleryUI.yOd).field_msgId));
        Intent intent = new Intent(imageGalleryUI.mController.xRr, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.cvz());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.vus);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.kMn);
        as.Hm();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.yNU) {
            com.tencent.mm.plugin.report.service.g.pWK.a(219, 16, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(219, 17, 1, true);
        }
    }

    protected void onPause() {
        x.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.yLG == null)) {
            b bVar = this.yLG;
            bVar.yLN.yOD.sendEmptyMessageAtTime(1, 200);
            bVar.yLO.cvu();
        }
        if (this.ryI != null) {
            com.tencent.mm.sdk.b.b ajVar = new aj();
            ajVar.fpn.activity = this;
            ajVar.fpn.fpo = this.ryI;
            com.tencent.mm.sdk.b.a.xmy.m(ajVar);
            this.ryI = null;
            this.jAr = 0;
            this.jAq = 0;
        }
    }

    final ImageGalleryUI cvv() {
        if (this.yNJ == null) {
            this.yNJ = ((ViewStub) findViewById(R.h.cpc)).inflate();
            this.yNK = (Button) this.yNJ.findViewById(R.h.bZX);
            this.yNL = (Button) this.yNJ.findViewById(R.h.bZY);
            this.yNM = this.yNJ.findViewById(R.h.bZZ);
        }
        return this;
    }

    protected final ImageGalleryUI cvw() {
        if (this.yNN == null) {
            this.yNN = ((ViewStub) findViewById(R.h.cVc)).inflate();
            this.yNO = (VideoPlayerSeekBar) findViewById(R.h.cVp);
            this.yNO.m((OnClickListener) this);
        }
        return this;
    }

    private ImageGalleryUI cvx() {
        if (this.yNG == null) {
            this.yNG = (RelativeLayout) ((ViewStub) findViewById(R.h.cnP)).inflate();
        }
        return this;
    }

    private ImageGalleryUI cvy() {
        if (this.yNH == null) {
            this.yNH = (RelativeLayout) ((ViewStub) findViewById(R.h.cpb)).inflate();
            this.yNH.findViewById(R.h.ccx).setOnClickListener(this);
        }
        return this;
    }

    private static void M(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private static int dp(View view) {
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.yOc = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.ovY = true;
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.ovY = false;
        }
        initView();
        this.kXK = bundle;
        com.tencent.mm.sdk.b.a.xmy.b(this.myb);
        com.tencent.mm.sdk.b.a.xmy.b(this.ryL);
        this.yNE = false;
        x.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.yOc || this.yLG == null)) {
            Gu(this.mZy.yF);
        }
        this.yOc = false;
        if (this.yLG != null) {
            this.yLG.cvo();
        }
    }

    public void onStart() {
        this.yNV = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.yND) {
            Bundle bundle = this.kXK;
            if (!this.kXL) {
                this.kXL = true;
                if (VERSION.SDK_INT >= 12) {
                    this.kXN = getIntent().getIntExtra("img_gallery_top", 0);
                    this.kXO = getIntent().getIntExtra("img_gallery_left", 0);
                    this.kXP = getIntent().getIntExtra("img_gallery_width", 0);
                    this.kXQ = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.kXN == 0 && this.kXO == 0 && this.kXP == 0 && this.kXQ == 0) {
                        au Ge = this.yLG.Ge(this.mZy.yF);
                        if (Ge != null) {
                            com.tencent.mm.sdk.b.b aqVar = new aq();
                            aqVar.fpD.fou = Ge;
                            com.tencent.mm.sdk.b.a.xmy.m(aqVar);
                            this.kXP = aqVar.fpE.fpH;
                            this.kXQ = aqVar.fpE.fpI;
                            this.kXO = aqVar.fpE.fpF;
                            this.kXN = aqVar.fpE.fpG;
                        }
                    }
                    this.kXM.r(this.kXO, this.kXN, this.kXP, this.kXQ);
                    if (bundle == null) {
                        this.mZy.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            public final boolean onPreDraw() {
                                ImageGalleryUI.this.mZy.getViewTreeObserver().removeOnPreDrawListener(this);
                                ImageGalleryUI.this.rFi = ImageGalleryUI.this.mZy.getWidth();
                                ImageGalleryUI.this.rFj = ImageGalleryUI.this.mZy.getHeight();
                                if (ImageGalleryUI.this.yLG.cvm().cjX()) {
                                    ImageGalleryUI.this.rFj = (int) ((((float) ImageGalleryUI.this.rFi) / ((float) ImageGalleryUI.this.kXP)) * ((float) ImageGalleryUI.this.kXQ));
                                }
                                if (ImageGalleryUI.this.yLG.cvm().cjT()) {
                                    ImageGalleryUI.this.yNP = ImageGalleryUI.this.yLG.qP(ImageGalleryUI.this.mZy.yF);
                                }
                                if (ImageGalleryUI.this.yNP != null) {
                                    ImageGalleryUI.this.rFj = (int) ((((float) ImageGalleryUI.this.rFi) / ((float) ImageGalleryUI.this.yNP.imageWidth)) * ((float) ImageGalleryUI.this.yNP.imageHeight));
                                    if (ImageGalleryUI.this.rFj > ImageGalleryUI.this.mZy.getHeight()) {
                                        ImageGalleryUI.this.rFj = ImageGalleryUI.this.mZy.getHeight();
                                    }
                                }
                                ImageGalleryUI.this.kXM.fj(ImageGalleryUI.this.rFi, ImageGalleryUI.this.rFj);
                                if (!ImageGalleryUI.this.yNV) {
                                    ImageGalleryUI.m(ImageGalleryUI.this);
                                    ImageGalleryUI.this.yOi = false;
                                    ImageGalleryUI.this.kXM.a(ImageGalleryUI.this.mZy, ImageGalleryUI.this.mDh, new g.b() {
                                        public final void onAnimationStart() {
                                            if (ImageGalleryUI.this.yNY != null) {
                                                ImageGalleryUI.this.yNY.j(Boolean.valueOf(true));
                                            }
                                        }

                                        public final void onAnimationEnd() {
                                            ImageGalleryUI.this.mHandler.post(new Runnable() {
                                                public final void run() {
                                                    if (ImageGalleryUI.this.yNY != null) {
                                                        ImageGalleryUI.this.yNY.j(Boolean.valueOf(false));
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                                ImageGalleryUI.q(ImageGalleryUI.this);
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
    }

    protected void onDestroy() {
        x.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        if (this.yLG != null) {
            this.yLG.detach();
            this.yLG = null;
        }
        cvP();
        this.yOg.TN();
        com.tencent.mm.sdk.b.a.xmy.c(this.myb);
        com.tencent.mm.sdk.b.a.xmy.c(this.ryL);
        if (this.yNO != null) {
            this.yNO.m(null);
        }
        this.yNO = null;
        super.onDestroy();
    }

    public void onBackPressed() {
        x.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.yNU) {
            Gv(1);
            return;
        }
        try {
            a.yNw.detach();
            awC();
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", e.getMessage());
        }
    }

    private String cvz() {
        return (this.chatroomName == null || this.chatroomName.length() <= 0) ? this.talker : this.chatroomName;
    }

    protected final void initView() {
        this.kXM = new g(this.mController.xRr);
        this.yOk = new al(this, false);
        this.kXL = false;
        this.talker = getIntent().getStringExtra("img_gallery_talker");
        this.yNU = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.yJq = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.yNW = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.yAH = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.vus = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.kMn = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yND = getIntent().getBooleanExtra("img_preview_only", false);
        if (!this.yND) {
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bi.chl(), this.talker != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.yNV = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.yNX = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.frh = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.frh > 0 || longExtra != 0) {
            if (this.frh == 0) {
                as.Hm();
                this.frh = com.tencent.mm.y.c.Fh().G(cvz(), longExtra).field_msgId;
            }
            as.Hm();
            cg dI = com.tencent.mm.y.c.Fh().dI(this.frh);
            if (dI.field_msgId <= 0) {
                x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.frh + ", msgSvrId = " + longExtra + ", stack = " + bi.chl());
                finish();
                return;
            }
            this.yLG = new b(this, this.frh, cvz(), this.vus, this.kMn, booleanExtra, stringExtra, Boolean.valueOf(this.yNV));
            this.yLG.yLQ = false;
            this.yLG.yLK = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.yLG.yLP = new b.c() {
                public final void hY() {
                    if (ImageGalleryUI.this.yLG != null) {
                        ImageGalleryUI.this.cvA();
                        ImageGalleryUI.this.yLG.ae(100000);
                    }
                }
            };
            this.yNB = (RelativeLayout) findViewById(R.h.bZW);
            this.yNC = (RelativeLayout) findViewById(R.h.bZV);
            this.yNF = (ImageView) findViewById(R.h.cUO);
            this.yNF.setOnClickListener(this);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            x.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight()));
            if (((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0 ? null : 1) != null) {
                cvQ();
            } else {
                cvR();
            }
            this.mDh = (ImageView) findViewById(R.h.ckx);
            this.mDh.setLayerType(2, null);
            this.mZy = (MMViewPager) findViewById(R.h.ckv);
            this.mZy.setLayerType(2, null);
            this.mZy.setVerticalFadingEdgeEnabled(false);
            this.mZy.setHorizontalFadingEdgeEnabled(false);
            this.mZy.yne = new MMViewPager.e() {
                public final void awD() {
                    ImageGalleryUI.h(ImageGalleryUI.this);
                }

                public final void aPg() {
                    ImageGalleryUI.this.awC();
                }
            };
            if (!this.yND) {
                this.mZy.yng = this.yOe;
                this.mZy.ynf = new MMViewPager.c() {
                    public final void aJP() {
                        ImageGalleryUI.this.na(true);
                    }
                };
            }
            this.mZy.xw(1);
            this.mZy.a(this.yLG);
            Gu(100000);
            this.mZy.ah(100000);
            this.mZy.postDelayed(new Runnable() {
                public final void run() {
                    if (ImageGalleryUI.this.yLG != null) {
                        if (a.yNw.yNu && ImageGalleryUI.this.yOa != null) {
                            ImageGalleryUI.this.yOa.setChecked(a.yNw.bo(ImageGalleryUI.this.yLG.cvm()));
                            ImageGalleryUI.this.yOb.setOnClickListener(ImageGalleryUI.this);
                        }
                        if (ImageGalleryUI.this.mZy.yF == 100000) {
                            ImageGalleryUI.this.cvO();
                            b.b bc = b.bc(ImageGalleryUI.this.yLG.Ge(100000));
                            if (!ImageGalleryUI.this.yNV && bc == b.b.video) {
                                ImageGalleryUI.this.yLG.Gj(100000);
                            }
                            if (bc == b.b.sight) {
                                ImageGalleryUI.this.yLG.Gn(100000);
                            }
                        }
                    }
                }
            }, 0);
            if (a.yNw.yNu) {
                this.yNZ = ((ViewStub) findViewById(R.h.cLr)).inflate();
                this.yNZ.setVisibility(0);
                this.yOa = (CheckBox) this.yNZ.findViewById(R.h.cvA);
                this.yOb = this.yNZ.findViewById(R.h.cvB);
            }
            this.yNS = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            com.tencent.mm.ap.e f = this.yLG.f(dI, true);
            if (f == null) {
                x.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", Boolean.valueOf(this.yNS));
            }
            if (this.yNS && f != null && f.Pj()) {
                cvS();
                this.yNS = false;
                return;
            } else if (this.yNS) {
                x.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.frh + ", msgSvrId = " + longExtra + ", stack = " + bi.chl());
        finish();
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        x.d(str, str2, objArr);
        if (bVar == null || mMViewPager == null) {
            x.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (bVar.cvm() == null) {
            return null;
        } else {
            if (bVar.cvm().cjT() || bVar.cvm().ckb()) {
                view = bVar.qP(mMViewPager.yF);
            } else {
                if (bVar.cvm().cjW() || bVar.cvm().cjX()) {
                    view = bVar.Gi(mMViewPager.yF);
                }
                view = null;
            }
        }
        return view;
    }

    private void awC() {
        if (this.yNE || this.yLG == null) {
            x.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
        } else if (this.yND) {
            finish();
            com.tencent.mm.ui.base.b.fG(this.mController.xRr);
        } else {
            int i;
            int i2;
            x.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
            int width = this.mZy.getWidth() / 2;
            int height = this.mZy.getHeight() / 2;
            this.yLG.cvk();
            com.tencent.mm.sdk.b.b gmVar;
            if (this.yNU) {
                gmVar = new gm();
                gmVar.fxt.frh = this.yLG.Ge(this.mZy.yF).field_msgId;
                com.tencent.mm.sdk.b.a.xmy.m(gmVar);
                i = gmVar.fxu.fpH;
                i2 = gmVar.fxu.fpI;
                width = gmVar.fxu.fpF;
                height = gmVar.fxu.fpG;
            } else {
                cg Ge = this.yLG.Ge(this.mZy.yF);
                if (Ge != null) {
                    gmVar = new aq();
                    gmVar.fpD.fou = Ge;
                    com.tencent.mm.sdk.b.a.xmy.m(gmVar);
                    i = gmVar.fpE.fpH;
                    i2 = gmVar.fpE.fpI;
                    width = gmVar.fpE.fpF;
                    height = gmVar.fpE.fpG;
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (width == 0 && height == 0) {
                    width = this.mZy.getWidth() / 2;
                    height = this.mZy.getHeight() / 2;
                } else if (Ge != null) {
                    if (Ge.field_isSend == 0) {
                        this.yNQ = com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 5);
                    }
                    if (Ge.field_isSend == 1) {
                        this.yNR = com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 5);
                    }
                }
            }
            this.rFi = this.mZy.getWidth();
            this.rFj = this.mZy.getHeight();
            if (this.yLG.cvm() != null) {
                if (this.yLG.cvm().cjX() || this.yLG.cvm().cjW()) {
                    this.rFj = (int) ((((float) this.rFi) / ((float) i)) * ((float) i2));
                }
                if (this.yLG.cvm().cjT() || this.yLG.cvm().ckb()) {
                    this.yNP = this.yLG.qP(this.mZy.yF);
                }
            }
            if (this.yNP != null) {
                this.rFj = (int) ((((float) this.rFi) / ((float) this.yNP.imageWidth)) * ((float) this.yNP.imageHeight));
                if (this.rFj > this.mZy.getHeight()) {
                    if (((double) this.rFj) < ((double) this.mZy.getHeight()) * 1.5d) {
                        if (this.yNU) {
                            this.rFk = this.rFj - this.mZy.getHeight();
                        } else {
                            i2 = (i2 * this.mZy.getHeight()) / this.rFj;
                        }
                    }
                    this.rFj = this.mZy.getHeight();
                }
            }
            g gVar = this.kXM;
            int i3 = this.yNQ;
            int i4 = this.yNR;
            gVar.rvL = i3;
            gVar.rvM = i4;
            gVar.rvN = 0;
            gVar.rvO = 0;
            this.kXM.rvK = this.rFk;
            this.kXM.fj(this.rFi, this.rFj);
            this.kXM.r(width, height, i, i2);
            View view = this.mZy;
            View a = a(this.yLG, this.mZy);
            if (a == null) {
                a = view;
            } else if (((double) this.rFl) != 1.0d) {
                this.kXM.ztQ = 1.0f / this.rFl;
                if (!(this.rFm == 0 && this.rFn == 0)) {
                    this.kXM.fk(((int) (((float) (this.mZy.getWidth() / 2)) * (1.0f - this.rFl))) + this.rFm, (int) (((float) ((this.mZy.getHeight() / 2) + this.rFn)) - (((float) (this.rFj / 2)) * this.rFl)));
                }
            }
            this.kXM.a(a, this.mDh, new g.b() {
                public final void onAnimationStart() {
                    ImageGalleryUI.this.yNE = true;
                    ImageGalleryUI.M(ImageGalleryUI.this.yNC, 8);
                    ImageGalleryUI.M(ImageGalleryUI.this.yNB, 8);
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            if (ImageGalleryUI.this.yNP != null) {
                                ImageGalleryUI.this.yNP.cqG();
                            }
                        }
                    }, 20);
                }

                public final void onAnimationEnd() {
                    x.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
                    ImageGalleryUI.this.mHandler.post(new Runnable() {
                        public final void run() {
                            ImageGalleryUI.this.finish();
                            ImageGalleryUI.this.overridePendingTransition(0, 0);
                        }
                    });
                    ImageGalleryUI.this.yNE = false;
                }
            }, null);
        }
    }

    protected final void na(boolean z) {
        if (this.yLG != null && this.yOd >= 0) {
            cg Ge = this.yLG.Ge(this.yOd);
            int bk = this.yLG.yLM.bk(Ge);
            if (bk == 5 || bk == 6) {
                x.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
            } else if (this.yLG.bb(Ge)) {
                x.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
            } else if (b.aX(Ge) && i.bq(Ge) == null) {
                x.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
            } else {
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(R.l.eET));
                if (com.tencent.mm.bl.d.Pu("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(R.l.eAq));
                }
                if (b.aW(Ge) || b.ba(Ge)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHr));
                } else if (b.aX(Ge) || b.aY(Ge)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHu));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHt));
                }
                if (b.aW(Ge) || b.aY(Ge)) {
                    com.tencent.mm.sdk.b.b diVar = new di();
                    diVar.fsL.frh = Ge.field_msgId;
                    com.tencent.mm.sdk.b.a.xmy.m(diVar);
                    if (diVar.fsM.fsk || com.tencent.mm.pluginsdk.model.app.g.R(this.mController.xRr, Ge.getType())) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(R.l.dRX));
                    }
                }
                if (b.aW(Ge)) {
                    arrayList.add(Integer.valueOf(6));
                    arrayList2.add(getString(R.l.dRv));
                }
                if (!(this.ryI == null || this.yNW)) {
                    Object string;
                    arrayList.add(Integer.valueOf(3));
                    if (com.tencent.mm.plugin.scanner.a.aF(this.jAq, this.ryI)) {
                        string = getString(R.l.eCE);
                    } else {
                        string = getString(R.l.eCD);
                    }
                    arrayList2.add(string);
                }
                if (!(this.yAH || this.vus || a.yNw.yNu || this.yNW)) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(R.l.dRu));
                }
                if (this.ryE == null || !this.ryJ) {
                    this.ryE = new com.tencent.mm.ui.widget.g(this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                } else {
                    this.ryJ = false;
                }
                this.ryE.rQF = new p.c() {
                    public final void a(n nVar) {
                        nVar.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                nVar.f(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                };
                this.ryE.rQG = this.lKE;
                this.ryE.bUX();
                this.ryE.zCF = new com.tencent.mm.ui.widget.g.a() {
                    public final void onDismiss() {
                        com.tencent.mm.sdk.b.b akVar = new ak();
                        akVar.fpp.filePath = ImageGalleryUI.this.ryF;
                        com.tencent.mm.sdk.b.a.xmy.m(akVar);
                        ImageGalleryUI.this.ryE = null;
                        ImageGalleryUI.this.ryF = null;
                        ImageGalleryUI.this.ryI = null;
                        ImageGalleryUI.this.jAq = ImageGalleryUI.this.jAr = 0;
                    }
                };
                if ((b.aW(Ge) || b.ba(Ge)) && true == z && as.CN().Ks() != 0 && !this.yNW) {
                    String str = null;
                    if (b.aW(Ge)) {
                        com.tencent.mm.ap.e f = this.yLG.f(Ge, true);
                        if (f != null) {
                            str = d.d(Ge, f);
                        }
                    } else {
                        str = b.bg(Ge);
                    }
                    if (str != null) {
                        com.tencent.mm.sdk.b.b mrVar = new mr();
                        mrVar.fFv.filePath = str;
                        this.ryF = str;
                        com.tencent.mm.sdk.b.a.xmy.m(mrVar);
                    }
                }
            }
        }
    }

    public final void fx(boolean z) {
        int i = 8;
        if (!z || this.yNB.getVisibility() != 0) {
            if (z || this.yNB.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.yNB;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                this.yNB.startAnimation(AnimationUtils.loadAnimation(this.mController.xRr, z ? R.a.bpO : R.a.bpP));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dlK;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
    }

    private void cvA() {
        if (this.yLG != null && !this.yND && this.yLG.cvl() && cvx().yNG != null) {
            if (a.yNw.yNu) {
                cvC();
            } else if (this.yAH || this.yNW) {
                cvC();
            } else {
                x.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", Integer.valueOf(hashCode()), Boolean.valueOf(cvD()));
                cvB();
                cvO();
            }
        }
    }

    private void cvB() {
        int i = 0;
        M(cvx().yNG, 0);
        View view = cvy().yNH;
        if (this.yNA != b.b.image) {
            i = 8;
        }
        M(view, i);
    }

    private void cvC() {
        M(cvx().yNG, 8);
        M(cvy().yNH, 8);
    }

    private static boolean e(au auVar, com.tencent.mm.ap.e eVar) {
        if (eVar == null) {
            return false;
        }
        try {
            if (b.b(auVar, eVar) == 0 && eVar.Pk() && !auVar.ckh()) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            x.e("MicroMsg.ImageGalleryUI", "error:" + e);
            return false;
        }
    }

    public final void Gu(int i) {
        bp(this.yLG.Ge(i));
    }

    private boolean cvD() {
        if (this.yNA == b.b.video) {
            return true;
        }
        return false;
    }

    protected final void cvE() {
        if (this.yOf) {
            this.yOg.K(4000, 4000);
        }
    }

    public final void cvF() {
        x.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        fx(true);
        nb(true);
        M(this.yNJ, 8);
        M(cvw().yNN, 0);
        M(this.yNF, 0);
        cvx().yNG.clearAnimation();
        if (this.yND) {
            cvC();
        } else {
            cvB();
        }
        cvP();
        this.yOf = true;
        cvE();
    }

    public final void cvG() {
        x.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        nb(false);
        M(cvw().yNN, 8);
        M(this.yNF, 8);
        if (cvD()) {
            cvP();
            cvC();
        }
        this.yOf = false;
    }

    private void nb(boolean z) {
        x.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        if (z) {
            this.yNC.setBackgroundResource(R.g.bDe);
            this.yNB.setBackgroundResource(R.g.bDd);
            return;
        }
        dq(this.yNC);
        dq(this.yNB);
    }

    private static void dq(View view) {
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            view.setBackground(null);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public final synchronized void bp(au auVar) {
        int i = 0;
        synchronized (this) {
            this.yNA = b.bc(auVar);
            x.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.yNA);
            if (a.yNw.yNu && this.yOa != null) {
                this.yOa.setChecked(a.yNw.bo(auVar));
            }
            switch (this.yNA) {
                case video:
                    cvG();
                    M(this.yNJ, 8);
                    nc(true);
                    r bq = i.bq(auVar);
                    if (bq != null) {
                        cvw().yNO.wD(bq.hXv);
                        try {
                            if (!(this.yLG.cvn() == null || this.yLG.cvn().yPa == null)) {
                                i = this.yLG.cvn().yPa.getCurrentPosition() / 1000;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        cvw().yNO.seek(i);
                        break;
                    }
                    break;
                case image:
                    com.tencent.mm.ap.e f = this.yLG.f(auVar, false);
                    cvG();
                    cvA();
                    if (f != null) {
                        i = this.mZy.yF;
                        if (e(auVar, f) && !auVar.ckh() && f.Pj()) {
                            cvv().yNK.setVisibility(0);
                            cvv().yNL.setVisibility(8);
                            cvv().yNM.setVisibility(8);
                            String str = (String) this.yOh.get(Long.valueOf(f.hBA));
                            if (str == null) {
                                Map y = bj.y(f.hBL, "msg");
                                if (y == null) {
                                    x.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", f.hBL);
                                    i = -1;
                                } else {
                                    i = bi.getInt((String) y.get(".msg.img.$hdlength"), 0);
                                }
                                long j = (long) i;
                                if (j < 0) {
                                    str = "";
                                } else {
                                    BigDecimal bigDecimal = new BigDecimal(j);
                                    float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                                    str = floatValue > 1.0f ? ((int) floatValue) + "M" : ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
                                }
                                this.yOh.put(Long.valueOf(f.hBA), str);
                            }
                            cvv().yNK.setText(getString(R.l.dYe, new Object[]{str}));
                            M(this.yNJ, 0);
                        } else {
                            M(this.yNJ, 8);
                        }
                        if (!this.yNS || !f.Pj() || this.yLG.cvm() == null || auVar.field_msgId != this.yLG.cvm().field_msgId) {
                            cg cvm = this.yLG.cvm();
                            String str2 = "MicroMsg.ImageGalleryUI";
                            String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Boolean.valueOf(this.yNS);
                            objArr[1] = Long.valueOf(auVar.field_msgId);
                            objArr[2] = cvm == null ? "null" : Long.valueOf(cvm.field_msgId);
                            objArr[3] = Boolean.valueOf(f.Pj());
                            x.w(str2, str3, objArr);
                            break;
                        }
                        x.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", Long.valueOf(auVar.field_msgId));
                        cvS();
                        this.yNS = false;
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    break;
                    break;
                case appimage:
                    cvG();
                    cvA();
                    break;
                case sight:
                    cvG();
                    cvA();
                    M(this.yNJ, 8);
                    this.yLG.Gn(this.mZy.yF);
                    break;
            }
        }
    }

    private void Gv(int i) {
        x.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + i);
        if (this.yLG == null) {
            x.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            return;
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(219, 13, 1, true);
        int aDx = this.yLG.aDx();
        if (this.yLG.cvm() == null) {
            x.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            return;
        }
        int Go = this.yLG.yLI.Go(this.mZy.yF);
        if (this.yNU) {
            awC();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.mController.xRr, MediaHistoryGalleryUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", cvz());
        intent.putExtra("kintent_image_count", aDx);
        intent.putExtra("kintent_image_index", Go);
        intent.putExtra("key_biz_chat_id", this.kMn);
        intent.putExtra("key_is_biz_chat", this.vus);
        startActivity(intent);
        com.tencent.mm.ui.base.b.fG(this.mController.xRr);
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                ImageGalleryUI.this.finish();
            }
        }, 50);
    }

    public final int cvH() {
        return this.mZy.yF;
    }

    public void onClick(View view) {
        boolean z = true;
        if (this.yLG != null) {
            if (view.getId() == R.h.cnP) {
                Gv(0);
            } else if (view.getId() == R.h.ccx) {
                x.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", Integer.valueOf(this.mZy.yF));
                M(cvy().yNH, 8);
                au Ge = this.yLG.Ge(this.mZy.yF);
                com.tencent.mm.ap.e f = this.yLG.f(Ge, false);
                int i = this.mZy.yF;
                if (e(Ge, f) && !Ge.ckh() && f.Pj()) {
                    this.yLG.ai(this.mZy.yF, true);
                } else {
                    b.b(this.mController.xRr, this.yLG.cvm(), true);
                }
            } else if (view.getId() == R.h.bZX) {
                this.yLG.ai(this.mZy.yF, false);
            } else if (view.getId() == R.h.bZY) {
                this.yLG.Gm(this.mZy.yF);
                Gu(this.mZy.yF);
                cvL();
                cvM();
                cvO();
            } else if (view.getId() == R.h.bIW) {
                onBackPressed();
            } else if (view.getId() == R.h.cUO) {
                onBackPressed();
            } else if (view.getId() == R.h.cvB) {
                boolean isChecked = this.yOa.isChecked();
                if (isChecked || a.yNw.yLS.size() < 9) {
                    CheckBox checkBox = this.yOa;
                    if (isChecked) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    if (this.yOa.isChecked()) {
                        a.yNw.bm(this.yLG.cvm());
                        return;
                    } else {
                        a.yNw.bn(this.yLG.cvm());
                        return;
                    }
                }
                Toast.makeText(this, getResources().getString(R.l.elL, new Object[]{Integer.valueOf(9)}), 1).show();
            } else if (view.getId() == R.h.cCK) {
                this.yLG.Gj(this.mZy.yF);
            }
        }
    }

    public static void cvI() {
    }

    public final void nc(boolean z) {
        try {
            cvw().yNO.dd(!z);
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
        }
    }

    public final boolean bQT() {
        return cvw().yNO.fwB;
    }

    public final void Gw(final int i) {
        if (cvw().yNN != null) {
            cvw().yNN.post(new Runnable() {
                public final void run() {
                    if (ImageGalleryUI.this.yLG != null) {
                        b f = ImageGalleryUI.this.yLG;
                        f.yLN.pause(i);
                    }
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.ryE != null) {
            this.ryE.bxR();
            this.ryE = null;
            return true;
        }
        na(true);
        return true;
    }

    final void cvJ() {
        if (cvx().yNG != null && !this.yOl) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeOutEnterGirdBtn: %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.yNG.getVisibility() == 0);
            x.d(str, str2, objArr);
            Animation Gx = Gx(300);
            Gx.setFillAfter(false);
            Gx.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    ImageGalleryUI.this.cvC();
                    ImageGalleryUI.this.yOl = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            cvx().yNG.startAnimation(Gx);
            this.yOl = true;
        }
    }

    final void cvK() {
        if (cvx().yNI != null && !this.yOm) {
            cvx().yNI.startAnimation(Gx(300));
            this.yOm = true;
        }
    }

    private void cvL() {
        if (cvx().yNG != null && this.yOl && !cvD()) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInEnterGirdBtn: %B %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(cvx().yNG.getVisibility() == 0);
            objArr[1] = bi.chl();
            x.d(str, str2, objArr);
            cvx().yNG.startAnimation(cvN());
            cvy().yNH.startAnimation(cvN());
            this.yOl = false;
        }
    }

    private void cvM() {
        boolean z = true;
        if (cvx().yNI != null && this.yOm) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInPositionAtChatRecordBtn: %B";
            Object[] objArr = new Object[1];
            if (cvx().yNI.getVisibility() != 0) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            cvx().yNI.startAnimation(cvN());
            this.yOm = false;
        }
    }

    private static Animation cvN() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    static Animation Gx(int i) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        return alphaAnimation;
    }

    public final boolean uG() {
        cvJ();
        cvK();
        return false;
    }

    protected final void cvO() {
        Object obj = (dp(this.yNJ) == 0 && dp(this.yNK) == 0) ? 1 : null;
        if (obj == null && this.yLG != null) {
            x.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
            this.yOk.K(4000, 4000);
        }
    }

    private void cvP() {
        x.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.yOk.TN();
    }

    public final void Gy(int i) {
        fx(true);
        cvG();
        cvv().yNJ.setVisibility(0);
        cvv().yNK.setVisibility(8);
        cvv().yNL.setVisibility(0);
        cvv().yNM.setVisibility(8);
        cvJ();
        cvK();
        cvv().yNL.setText(i + "%");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void finish() {
        this.yKm.clear();
        super.finish();
    }

    public final int gn(long j) {
        if (bi.oN(this.yNX)) {
            return 0;
        }
        try {
            int f = t.f(j, this.yNX);
            if (f == -1) {
                this.yNX = null;
                f = 0;
            }
            x.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(f), this.yNX);
            return f;
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e.toString());
            return 0;
        }
    }

    public final void go(long j) {
        if (!bi.oN(this.yNX) && j != 0 && t.f(j, this.yNX) == -1) {
            this.yNX = null;
            x.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.yNX);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            cvQ();
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            cvR();
        }
    }

    private void cvQ() {
        x.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.ovY), Boolean.valueOf(ae.fz(this)), Integer.valueOf(ae.fy(this)));
        if (this.ovY && r0) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yNB.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.yNB.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yNC.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.yNC.setLayoutParams(layoutParams);
        }
    }

    private void cvR() {
        boolean fz = ae.fz(this);
        int fy = ae.fy(this);
        x.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.ovY), Boolean.valueOf(fz), Integer.valueOf(fy));
        if (this.ovY && fz) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yNB.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fy, 0);
            this.yNB.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yNC.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fy, layoutParams.bottomMargin);
            this.yNC.setLayoutParams(layoutParams);
        }
    }

    private void cvS() {
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        cg cvm = this.yLG.cvm();
        x.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", d.d(cvm, d.bl(cvm)), Long.valueOf(cvm.field_msgId));
        intent.putExtra("before_photo_edit", r4);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", JsApiCreateAudioInstance.CTRL_INDEX);
        intent.putExtra("after_photo_edit", "");
        com.tencent.mm.bl.d.b(this, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4369);
        overridePendingTransition(0, 0);
    }

    protected final int getForceOrientation() {
        return 2;
    }
}
