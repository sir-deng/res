package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.z;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.aj;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.j.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class NoteEditorUI extends BaseFavDetailReportUI implements e, com.tencent.mm.plugin.wenote.model.nativenote.b.a, com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a, a {
    private static final long mzv = ((long) b.zN());
    private View Iv = null;
    OnGlobalLayoutListener OE = new OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - NoteEditorUI.this.udo));
            ah Dt = as.Dt();
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    NoteEditorUI.this.kN(false);
                }
            };
            if (NoteEditorUI.this.uaN == 1) {
                currentTimeMillis = 100;
            } else {
                currentTimeMillis = 0;
            }
            Dt.g(anonymousClass1, currentTimeMillis);
            NoteEditorUI.this.Va.getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.OE);
        }
    };
    private RecyclerView Va;
    private long frh = -1;
    private long hBA = -1;
    private ag hbP;
    private float iTY = 0.0f;
    private float iTZ = 0.0f;
    private ProgressDialog inI = null;
    private String lRH = "";
    private r lYX = null;
    private int mZw = 0;
    private String mqO;
    protected com.tencent.mm.ui.snackbar.b.b nfQ = new com.tencent.mm.ui.snackbar.b.b() {
        public final void aQv() {
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 35;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
        }
    };
    private boolean tWW = false;
    private int uaN;
    private k ucQ;
    private c ucR;
    private LinearLayout ucS;
    private c ucT = null;
    private RelativeLayout ucU = null;
    private g ucV = null;
    private boolean ucW = false;
    private boolean ucX = false;
    private boolean ucY = false;
    private String ucZ = "";
    private boolean udA = false;
    private com.tencent.mm.plugin.wenote.ui.nativenote.a.a uda;
    private boolean udb = false;
    private boolean udc = false;
    private a udd;
    private uz ude;
    private boolean udf = false;
    private final Object udg = new Object();
    private LinearLayout udh = null;
    private String udi = "";
    private int udj = 0;
    private int udk = 0;
    private int udl = 0;
    private String[] udm = null;
    private boolean udn = true;
    private long udo = 0;
    private boolean udp = false;
    private String udq;
    private boolean udr = false;
    private boolean uds = false;
    private boolean udt = false;
    private boolean udu = true;
    private int udv = 0;
    private RecyclerView.k udw = null;
    OnTouchListener udx = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                NoteEditorUI.this.iTY = motionEvent.getX();
                NoteEditorUI.this.iTZ = motionEvent.getY();
            }
            float abs;
            float abs2;
            if (motionEvent.getAction() == 1 && NoteEditorUI.this.Va.j(motionEvent.getX(), motionEvent.getY()) == null) {
                abs = Math.abs(NoteEditorUI.this.iTY - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.iTZ - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    if (NoteEditorUI.this.ucU.getVisibility() != 8) {
                        if (NoteEditorUI.this.ucV != null) {
                            NoteEditorUI.this.ucV.tZF.dismiss();
                        }
                        NoteEditorUI.this.ucU.setVisibility(8);
                    } else {
                        int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().size();
                        com.tencent.mm.plugin.wenote.model.a.b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(size - 1);
                        if (BL != null) {
                            boolean z = BL.tXR;
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXf();
                            BL.tXR = true;
                            BL.tXX = false;
                            BL.tXT = -1;
                            NoteEditorUI.this.ucR.bj(size - 1);
                            NoteEditorUI.this.f(true, 50);
                            NoteEditorUI.this.P(1, 0);
                            if (NoteEditorUI.this.udu && z) {
                                NoteEditorUI.this.hbP.postDelayed(new Runnable() {
                                    public final void run() {
                                        com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kU(true);
                                        com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kT(true);
                                    }
                                }, 100);
                            }
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                abs = Math.abs(NoteEditorUI.this.iTY - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.iTZ - motionEvent.getY());
                if (abs > 120.0f || abs2 > 120.0f) {
                    if (NoteEditorUI.this.udu) {
                        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXR() == 1) {
                            NoteEditorUI.this.bWR();
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXW();
                        }
                    } else if (!NoteEditorUI.this.udb) {
                        NoteEditorUI.this.bWR();
                    }
                }
            }
            return false;
        }
    };
    private boolean udy = false;
    private int udz = -1;

    class a extends com.tencent.mm.plugin.wenote.ui.nativenote.a.b {
        a() {
        }

        public final void bYy() {
            as.Dt().F(new Runnable() {
                public final void run() {
                    int i = -1;
                    try {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) NoteEditorUI.this.Va.TV;
                        View a = linearLayoutManager.a(linearLayoutManager.getChildCount() - 1, -1, true, false);
                        if (a != null) {
                            i = h.bd(a);
                        }
                        com.tencent.mm.plugin.wenote.model.a.b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(i);
                        if (BL != null && BL.getType() == 4 && !((com.tencent.mm.plugin.wenote.model.a.k) BL).tYo) {
                            NoteEditorUI.this.BE(i);
                        }
                    } catch (NullPointerException e) {
                    }
                }
            });
        }

        public final void bYz() {
            as.Dt().F(/* anonymous class already generated */);
        }

        public final void bYA() {
            NoteEditorUI.this.muu.mtT = true;
        }

        public final void e(RecyclerView recyclerView, int i) {
            super.e(recyclerView, i);
            if (recyclerView.TV != null) {
                View childAt = ((LinearLayoutManager) NoteEditorUI.this.Va.TV).getChildAt(0);
                if (childAt != null) {
                    NoteEditorUI.this.udj = childAt.getTop();
                    NoteEditorUI.this.mZw = h.bd(childAt);
                }
            }
        }
    }

    static /* synthetic */ void a(NoteEditorUI noteEditorUI, n nVar) {
        if (noteEditorUI.c(com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bXw().bXx())) {
            nVar.f(6, noteEditorUI.getString(R.l.eXV));
        } else {
            nVar.f(5, noteEditorUI.getString(R.l.eXX));
        }
    }

    static /* synthetic */ void b(NoteEditorUI noteEditorUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 15);
        intent.putExtra("need_result", true);
        String Rv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Rv(noteEditorUI.getString(R.l.eXY));
        intent.putExtra("fav_note_xml", str);
        intent.putExtra("Ksnsupload_title", Rv);
        intent.putExtra("Ksnsupload_link", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");
        intent.putExtra("fav_note_link_description", "note description");
        intent.putExtra("Ksnsupload_imgbuf", com.tencent.mm.a.e.e(noteEditorUI.mqO, 0, -1));
        d.b(noteEditorUI, "sns", ".ui.SnsUploadUI", intent, 4354);
    }

    public void onCreate(Bundle bundle) {
        this.uaN = getIntent().getIntExtra("note_open_from_scene", 2);
        this.frh = getIntent().getLongExtra("note_msgid", -1);
        this.uds = getIntent().getBooleanExtra("record_show_share", false);
        this.hBA = getIntent().getLongExtra("note_fav_localid", -1);
        this.lRH = getIntent().getStringExtra("note_link_sns_localid");
        this.tWW = getIntent().getBooleanExtra("edit_status", false);
        this.udi = getIntent().getStringExtra("fav_note_xml");
        this.udk = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
        this.udl = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
        this.mqO = getIntent().getStringExtra("fav_note_thumbpath");
        this.udn = getIntent().getBooleanExtra("show_share", true);
        this.udq = getIntent().getStringExtra("fav_note_link_sns_xml");
        String stringExtra = getIntent().getStringExtra("fav_note_link_source_info");
        this.udt = getIntent().getBooleanExtra("fav_note_out_of_date", false);
        if (!bi.oN(stringExtra)) {
            this.udm = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.udp = true;
        }
        com.tencent.mm.plugin.wenote.model.d.tWY = false;
        if (this.udm == null && this.hBA > 0) {
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 30;
            fwVar.fwl.fws = 3;
            fwVar.fwl.frf = this.hBA;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            this.udm = bi.oN(fwVar.fwm.path) ? null : fwVar.fwm.path.split(";");
        }
        if (this.udm == null || this.udm.length >= 3) {
            View inflate;
            this.hbP = new ag();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c bXc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();
            bXc.jXe = new ArrayList();
            bXc.tZc = this;
            bXc.tZd = new uz();
            bXc.tZe = 0;
            bXc.tZf = 0;
            bXc.tZg = 0;
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            com.tencent.mm.pluginsdk.e.h(this);
            super.onCreate(bundle);
            dg(this.hBA);
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
            hVar.content = "";
            hVar.tXR = true;
            hVar.tXX = false;
            if (this.tWW) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(hVar);
                this.udp = true;
            }
            this.Iv = this.mController.contentView;
            this.Iv.getRootView().setBackgroundColor(-1);
            this.Va = (RecyclerView) findViewById(R.h.cZL);
            this.ucS = (LinearLayout) this.Iv.findViewById(R.h.cdh);
            this.ucS.setVisibility(8);
            this.udh = (LinearLayout) this.ucS.findViewById(R.h.cBp);
            this.udh.setVisibility(8);
            this.ucU = (RelativeLayout) findViewById(R.h.cZC);
            this.ucU.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (NoteEditorUI.this.ucV != null) {
                        NoteEditorUI.this.ucV.tZF.dismiss();
                    }
                    NoteEditorUI.this.ucU.setVisibility(8);
                }
            });
            this.ucV = new g(this, this.ucU);
            this.ucV.tZG = this;
            this.uda = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a(this);
            this.uda.uem = j.aT(this)[1];
            this.Va.a(this.uda);
            this.Va.Ub = true;
            this.udd = new a();
            this.Va.a(this.udd);
            this.ucQ = new k(this);
            this.ucQ.frf = this.hBA;
            this.ucQ.uaN = this.uaN;
            this.ucQ.uaO = this.udp;
            this.ucR = new c(this.ucQ);
            this.Va.a(this.ucR);
            if (this.uaN == 2) {
                this.Va.setOnTouchListener(this.udx);
            }
            this.Va.Ur.UV = 0;
            this.Va.Ur.UY = 0;
            this.Va.Ur.UX = 0;
            this.Va.Ur.UW = 120;
            ((aj) this.Va.Ur).XL = false;
            this.udv = com.tencent.mm.bu.a.fromDPToPix(this, 48);
            if (this.udu) {
                x.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.uaN == 2 && this.udp;
                int color = getResources().getColor(R.e.btw);
                com.tencent.mm.plugin.wenote.model.nativenote.c.e bXS = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
                x.i("NoteSelectManager", "onInit start");
                if (this == null || this == null) {
                    x.e("NoteSelectManager", "context or listener is null");
                } else {
                    bXS.ubn = z;
                    bXS.ubq = 14;
                    bXS.ubr = 32;
                    bXS.ubs = com.tencent.mm.bu.a.fromDPToPix(this, 21) - bXS.ubr;
                    bXS.ubt = com.tencent.mm.bu.a.fromDPToPix(this, 40) + (bXS.ubr * 2);
                    bXS.ubu = com.tencent.mm.bu.a.fromDPToPix(this, 240) + (bXS.ubr * 2);
                    bXS.ubo = com.tencent.mm.bu.a.fromDPToPix(this, 22);
                    bXS.ubp = com.tencent.mm.bu.a.fromDPToPix(this, 1);
                    bXS.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                    bXS.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                    bXS.uby = new int[]{-1, -1};
                    bXS.ubz = new int[]{-1, -1};
                    bXS.ubA = new int[]{-1, -1};
                    bXS.ubB = new int[]{-1, -1};
                    View aVar = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, bXS.ubo, bXS.ubp, color, bXS);
                    bXS.ubC = new PopupWindow(aVar, aVar.bDr(), aVar.bud(), false);
                    bXS.ubC.setClippingEnabled(false);
                    bXS.ubC.setAnimationStyle(R.m.eZr);
                    bXS.ubw = (aVar.ljP + aVar.uaW) + 1;
                    bXS.ubx = com.tencent.mm.bu.a.fromDPToPix(this, 6);
                    View aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, bXS.ubo, bXS.ubp, color, bXS);
                    bXS.ubD = new PopupWindow(aVar2, aVar2.bDr(), aVar.bud(), false);
                    bXS.ubD.setClippingEnabled(false);
                    bXS.ubD.setAnimationStyle(R.m.eZq);
                    aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, bXS.ubo, bXS.ubp, color, bXS);
                    bXS.ubE = new PopupWindow(aVar2, aVar2.bDr(), aVar.bud(), false);
                    bXS.ubE.setClippingEnabled(false);
                    bXS.ubE.setAnimationStyle(R.m.eZs);
                    inflate = LayoutInflater.from(this).inflate(R.i.dpn, null);
                    inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    bXS.ubF = new PopupWindow(inflate, -2, -2, false);
                    bXS.ubF.setBackgroundDrawable(getResources().getDrawable(R.g.bGz));
                    bXS.ubF.setClippingEnabled(false);
                    bXS.ubF.setAnimationStyle(R.m.eZt);
                    bXS.ubL = (TextView) inflate.findViewById(R.h.cAM);
                    bXS.ubM = (TextView) inflate.findViewById(R.h.cBi);
                    bXS.ubN = (TextView) inflate.findViewById(R.h.cBf);
                    bXS.ubO = (TextView) inflate.findViewById(R.h.cBe);
                    bXS.ubP = (TextView) inflate.findViewById(R.h.cAU);
                    bXS.ubQ = (TextView) inflate.findViewById(R.h.cAT);
                    bXS.ubR = (TextView) inflate.findViewById(R.h.cAS);
                    bXS.ubS = (TextView) inflate.findViewById(R.h.cBa);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubL, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubM, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubN, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubO, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubP, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubQ, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubR, bXS.ubq);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXS.ubS, bXS.ubq);
                    bXS.ubL.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "bold");
                            e.this.bXY();
                        }
                    });
                    bXS.ubM.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "unbold");
                            e.this.bXY();
                        }
                    });
                    bXS.ubN.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.wenote.model.a.b bVar = null;
                            x.i("NoteSelectManager", "select");
                            e.this.bXY();
                            if (!e.mHasInit) {
                                x.e("NoteSelectManager", "select: not init");
                            } else if (e.this.bXR() != 1) {
                                x.e("NoteSelectManager", "select: not insert");
                                e.this.bYe();
                            } else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(e.this.ubH.hna) == null) {
                                x.e("NoteSelectManager", "select: item is null");
                                e.this.bYe();
                            } else {
                                RecyclerView a = e.this.byq();
                                if (a == null) {
                                    x.e("NoteSelectManager", "select: recyclerView is null");
                                    e.this.bYe();
                                    return;
                                }
                                c cW = f.cW(f.g(a, e.this.ubH.hna));
                                if (cW == null) {
                                    x.e("NoteSelectManager", "select: rteInfo is null");
                                    e.this.bYe();
                                } else if (cW.ubi != null) {
                                    Editable text = cW.ubi.getText();
                                    if (text == null) {
                                        x.e("NoteSelectManager", "select: text is null");
                                        e.this.bYe();
                                    } else if (text.length() > 0) {
                                        cW.ubi.Z(e.this.ubH.startOffset, true);
                                    } else {
                                        com.tencent.mm.plugin.wenote.model.a.b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(e.this.ubH.hna - 1);
                                        if (BL != null && BL.getType() == -3) {
                                            BL = null;
                                        }
                                        com.tencent.mm.plugin.wenote.model.a.b BL2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(e.this.ubH.hna + 1);
                                        if (BL2 == null || BL2.getType() != -2) {
                                            bVar = BL2;
                                        }
                                        if (BL != null) {
                                            if (BL.getType() == 1) {
                                                Spanned Rs = a.Rs(((com.tencent.mm.plugin.wenote.model.a.h) BL).content);
                                                if (Rs == null) {
                                                    x.e("NoteSelectManager", "select: spanned is null");
                                                    e.this.bYe();
                                                    return;
                                                }
                                                e.this.t(e.this.ubH.hna - 1, Rs.length(), e.this.ubH.hna, 0);
                                            } else {
                                                e.this.t(e.this.ubH.hna - 1, 0, e.this.ubH.hna, 0);
                                            }
                                        } else if (bVar == null) {
                                            x.e("NoteSelectManager", "select: no neighbor");
                                            e.this.bYe();
                                            return;
                                        } else if (bVar.getType() == 1) {
                                            e.this.t(e.this.ubH.hna, 0, e.this.ubH.hna + 1, 0);
                                        } else {
                                            e.this.t(e.this.ubH.hna, 0, e.this.ubH.hna + 1, 1);
                                        }
                                        e.this.bXV();
                                        e.this.N(true, true);
                                    }
                                } else if (cW.ubj == null || cW.ubk == null) {
                                    x.e("NoteSelectManager", "select: rteInfo invalid");
                                    e.this.bYe();
                                } else {
                                    e.this.bXV();
                                    e.this.t(e.this.ubH.hna, 0, e.this.ubH.hna, 1);
                                    e.this.N(true, true);
                                }
                            }
                        }
                    });
                    bXS.ubO.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "select all");
                            e.this.bXY();
                            if (e.mHasInit) {
                                int bXm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXm();
                                int bXn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXn();
                                com.tencent.mm.plugin.wenote.model.a.b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXm);
                                com.tencent.mm.plugin.wenote.model.a.b BL2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXn);
                                if (BL == null || BL2 == null) {
                                    x.e("NoteSelectManager", "select all: item is null");
                                    e.this.bYe();
                                    return;
                                }
                                int length;
                                if (BL2.getType() == 1) {
                                    Spanned Rs = a.Rs(((com.tencent.mm.plugin.wenote.model.a.h) BL2).content);
                                    if (Rs == null) {
                                        x.e("NoteSelectManager", "select all: spanned is null");
                                        e.this.bYe();
                                        return;
                                    }
                                    length = Rs.length();
                                } else {
                                    length = 1;
                                }
                                e.this.bXV();
                                e.this.t(bXm, 0, bXn, length);
                                e.this.bYa();
                                e.this.bXY();
                                e.this.g(true, 300);
                                e.this.kU(false);
                                e.this.h(false, 50);
                                return;
                            }
                            x.e("NoteSelectManager", "select all: not init");
                        }
                    });
                    bXS.ubP.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "delete");
                            if (!e.mHasInit || !e.this.ubn) {
                                x.e("NoteSelectManager", "delete: not init or not editable");
                                e.this.bXY();
                            } else if (e.l(e.this)) {
                                if (e.this.ubG != null) {
                                    e.this.ubG.bWO();
                                }
                            } else if (e.this.ubG != null) {
                                e.this.ubG.bWP();
                            } else {
                                e.this.bYf();
                            }
                        }
                    });
                    bXS.ubQ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "cut");
                            if (!e.mHasInit || !e.this.ubn) {
                                x.e("NoteSelectManager", "cut: not init or not editable");
                                e.this.bXY();
                            } else if (!e.l(e.this)) {
                                e.this.bXY();
                                int bXR = e.this.bXR();
                                ArrayList arrayList;
                                if (bXR == 2) {
                                    Object a = e.this.a(true, null, "");
                                    if (bi.N(a)) {
                                        x.e("NoteSelectManager", "cut: selectedSpan is null or empty");
                                        e.this.bYe();
                                        return;
                                    }
                                    com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                                    hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                                    hVar.tXT = -1;
                                    hVar.tXR = false;
                                    arrayList = new ArrayList();
                                    arrayList.add(hVar);
                                    f.c(ad.getContext(), arrayList);
                                } else if (bXR == 3) {
                                    arrayList = e.this.b(true, null, "");
                                    if (arrayList == null || arrayList.size() <= 0) {
                                        x.e("NoteSelectManager", "cut: dataList is null or empty");
                                        e.this.bYe();
                                        return;
                                    }
                                    f.c(ad.getContext(), arrayList);
                                } else {
                                    x.e("NoteSelectManager", "cut: not in select");
                                    e.this.bYe();
                                }
                            } else if (e.this.ubG != null) {
                                e.this.ubG.bWO();
                            }
                        }
                    });
                    bXS.ubR.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "copy");
                            if (!e.mHasInit) {
                                x.e("NoteSelectManager", "copy: not init");
                                e.this.bXY();
                            } else if (!e.l(e.this)) {
                                e.this.bXY();
                                int bXR = e.this.bXR();
                                ArrayList arrayList;
                                if (bXR == 2) {
                                    Object a = e.this.a(false, null, "");
                                    if (bi.N(a)) {
                                        x.e("NoteSelectManager", "copy: selectedSpan is null or empty");
                                        e.this.bYe();
                                        return;
                                    }
                                    com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                                    hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                                    hVar.tXT = -1;
                                    hVar.tXR = false;
                                    arrayList = new ArrayList();
                                    arrayList.add(hVar);
                                    f.c(ad.getContext(), arrayList);
                                } else if (bXR == 3) {
                                    arrayList = e.this.b(false, null, "");
                                    if (arrayList == null || arrayList.size() <= 0) {
                                        x.e("NoteSelectManager", "copy: dataList is null or empty");
                                        e.this.bYe();
                                        return;
                                    }
                                    f.c(ad.getContext(), arrayList);
                                } else {
                                    x.e("NoteSelectManager", "copy: not in select");
                                    e.this.bYe();
                                }
                            } else if (e.this.ubG != null) {
                                e.this.ubG.bWO();
                            }
                        }
                    });
                    bXS.ubS.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("NoteSelectManager", "paste");
                            if (!e.mHasInit || !e.this.ubn) {
                                x.e("NoteSelectManager", "paste: not init or not editable");
                                e.this.bXY();
                            } else if (!e.l(e.this)) {
                                String str;
                                ArrayList arrayList;
                                e.this.bXY();
                                String str2 = "";
                                int dV = f.dV(ad.getContext());
                                if (dV == 2) {
                                    if (e.this.ubG == null || !f.dU(ad.getContext())) {
                                        ClipboardManager clipboardManager = (ClipboardManager) ad.getContext().getSystemService("clipboard");
                                        if (clipboardManager == null) {
                                            x.e("NoteSelectManager", "paste: clipboard is null");
                                            e.this.bYe();
                                            return;
                                        }
                                        try {
                                            String a;
                                            CharSequence text = clipboardManager.getText();
                                            if (text instanceof Spanned) {
                                                a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) text);
                                            } else {
                                                a = text.toString();
                                            }
                                            if (bi.oN(a)) {
                                                a = "";
                                            }
                                            f.abi();
                                            str = a;
                                            arrayList = null;
                                        } catch (Exception e) {
                                            x.e("NoteSelectManager", "get clipboard data error : ", e);
                                            e.this.bYe();
                                            return;
                                        }
                                    }
                                    e.this.ubG.bWM();
                                    return;
                                } else if (dV == 3) {
                                    ArrayList bXr = f.bXr();
                                    if (bXr.size() <= 0) {
                                        x.e("NoteSelectManager", "paste: tempDataList is null or empty");
                                        e.this.bYe();
                                        return;
                                    } else if (bXr.size() == 1 && bXr.get(0) != null && ((com.tencent.mm.plugin.wenote.model.a.b) bXr.get(0)).getType() == 1) {
                                        str = ((com.tencent.mm.plugin.wenote.model.a.h) bXr.get(0)).content;
                                        arrayList = null;
                                    } else {
                                        arrayList = bXr;
                                        str = str2;
                                    }
                                } else {
                                    x.e("NoteSelectManager", "paste: no data");
                                    e.this.bYe();
                                    return;
                                }
                                if (bi.oN(str) && (arrayList == null || arrayList.size() == 0)) {
                                    x.e("NoteSelectManager", "paste: no useful data");
                                    e.this.bYe();
                                } else if (e.this.ubG == null || !e.a(e.this, arrayList, str)) {
                                    int bXR = e.this.bXR();
                                    if (bXR == 1 || bXR == 2) {
                                        e.this.a(true, arrayList, str);
                                    } else if (bXR == 3) {
                                        e.this.b(true, arrayList, str);
                                    } else {
                                        x.e("NoteSelectManager", "paste: invalid selection");
                                        e.this.bYe();
                                    }
                                } else {
                                    e.this.ubG.bWM();
                                }
                            } else if (e.this.ubG != null) {
                                e.this.ubG.bWO();
                            }
                        }
                    });
                    bXS.ubv = aVar.ljP;
                    bXS.ubG = this;
                    bXS.ubH = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
                    bXS.ubI = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
                    bXS.mHandler = new ag();
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
                    x.i("NoteSelectManager", "onInit end");
                }
                this.udw = new RecyclerView.k() {
                    public final void e(RecyclerView recyclerView, int i) {
                        super.e(recyclerView, i);
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kU(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXZ());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kT(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXX());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().g(false, 50);
                                return;
                            case 1:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bYa();
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXY();
                                return;
                            default:
                                return;
                        }
                    }

                    public final void c(RecyclerView recyclerView, int i, int i2) {
                        super.c(recyclerView, i, i2);
                        if (i2 > 30) {
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bYa();
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXY();
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.c.d bXU = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXU();
                        if ((NoteEditorUI.this.udc || (NoteEditorUI.this.ucS != null && NoteEditorUI.this.ucS.getVisibility() == 0)) && bXU.bXR() == 2 && com.tencent.mm.plugin.wenote.model.nativenote.c.f.g(recyclerView, bXU.hna) == null) {
                            NoteEditorUI.this.bWR();
                        }
                    }
                };
                this.Va.a(this.udw);
            }
            if (this.lYX != null) {
                this.lYX.dismiss();
                this.lYX = null;
            }
            if (!(this.tWW || this.udt)) {
                this.lYX = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eYK), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (NoteEditorUI.this.lYX != null) {
                            NoteEditorUI.this.lYX.dismiss();
                            NoteEditorUI.this.lYX = null;
                        }
                    }
                });
            }
            if (this.udt) {
                x.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
                com.tencent.mm.ui.base.h.b(this.mController.xRr, this.mController.xRr.getString(R.l.eyy), null, true);
            }
            if (this.udn) {
                addIconOptionMenu(1, R.l.eRy, R.g.bDJ, new OnMenuItemClickListener() {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean onMenuItemClick(android.view.MenuItem r7) {
                        /*
                        r6 = this;
                        r4 = 2;
                        r1 = 0;
                        r2 = new com.tencent.mm.ui.widget.g;
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.mController;
                        r0 = r0.xRr;
                        r3 = com.tencent.mm.ui.widget.g.zCt;
                        r2.<init>(r0, r3, r1);
                        r0 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$1;
                        r0.<init>();
                        r2.rQF = r0;
                        r0 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2;
                        r0.<init>();
                        r2.rQG = r0;
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.uaN;
                        if (r0 != r4) goto L_0x0037;
                    L_0x0025:
                        r0 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();
                        r3 = r0.tZg;
                        if (r3 > 0) goto L_0x0031;
                    L_0x002d:
                        r0 = r0.tZf;
                        if (r0 <= 0) goto L_0x0035;
                    L_0x0031:
                        r0 = 1;
                    L_0x0032:
                        if (r0 != 0) goto L_0x0037;
                    L_0x0034:
                        return r1;
                    L_0x0035:
                        r0 = r1;
                        goto L_0x0032;
                    L_0x0037:
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.uaN;
                        if (r0 != r4) goto L_0x0071;
                    L_0x003f:
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0.bWR();
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.ucV;
                        if (r0 == 0) goto L_0x0057;
                    L_0x004c:
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.ucV;
                        r0 = r0.tZF;
                        r0.dismiss();
                    L_0x0057:
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.ucU;
                        r3 = 8;
                        r0.setVisibility(r3);
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.udu;
                        if (r0 == 0) goto L_0x0071;
                    L_0x006a:
                        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
                        r0.bXW();
                    L_0x0071:
                        r0 = com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.this;
                        r0 = r0.hbP;
                        r3 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$3;
                        r3.<init>(r2);
                        r4 = 100;
                        r0.postDelayed(r3, r4);
                        goto L_0x0034;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.onMenuItemClick(android.view.MenuItem):boolean");
                    }
                });
            }
            setMMTitle(getString(R.l.ehk));
            mc(true);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (NoteEditorUI.this.bYr()) {
                        NoteEditorUI.this.goBack();
                        NoteEditorUI.this.finish();
                    }
                    return true;
                }
            }, R.g.byz);
            com.tencent.mm.pluginsdk.e.i(this);
            if (this.tWW) {
                f(true, 300);
                P(1, 0);
            }
            if (this.uaN == 2 && this.udp) {
                this.ucT = new c();
                c cVar = this.ucT;
                inflate = this.ucS;
                cVar.iqC = inflate;
                k.bXM().uaI = cVar;
                cVar.udS = (LinearLayout) inflate.findViewById(R.h.cBp);
                cVar.udR = (ImageButton) inflate.findViewById(R.h.cZJ);
                cVar.udT = (ImageButton) inflate.findViewById(R.h.cZF);
                cVar.udU = (ImageButton) inflate.findViewById(R.h.cZH);
                cVar.udV = (ImageButton) inflate.findViewById(R.h.cZG);
                cVar.udW = (ImageButton) inflate.findViewById(R.h.cZI);
                cVar.udX = (LinearLayout) cVar.udS.findViewById(R.h.cZP);
                cVar.udY = (LinearLayout) cVar.udS.findViewById(R.h.cZS);
                cVar.udZ = (LinearLayout) cVar.udS.findViewById(R.h.cZQ);
                cVar.uea = (LinearLayout) cVar.udS.findViewById(R.h.cZR);
                cVar.ueb = (LinearLayout) cVar.udS.findViewById(R.h.cxp);
                cVar.udR.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass1(this));
                cVar.udV.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass6(this));
                cVar.udW.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass7(this, this));
                cVar.udT.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass8(this));
                cVar.udU.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass9(this));
                cVar.ueb.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass10(this));
                cVar.udX.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass11(this));
                cVar.udY.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass12(this));
                cVar.udZ.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass13(this));
                cVar.uea.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass2(this));
                getWindow().setSoftInputMode(18);
            } else {
                this.ucS.setVisibility(8);
            }
            this.Va.getViewTreeObserver().addOnGlobalLayoutListener(this.OE);
            this.udo = System.currentTimeMillis();
            x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", Long.valueOf(this.udo));
            as.CN().a(921, (e) this);
        }
    }

    private boolean c(p pVar) {
        if (pVar == null) {
            return false;
        }
        if (pVar.tYq != (this.uaN == 1)) {
            return false;
        }
        if ((this.uaN == 1 && pVar.tYs == this.frh) || (this.uaN == 2 && pVar.tYr == this.hBA)) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        if (bYr()) {
            goBack();
            super.onBackPressed();
        }
    }

    protected final int getLayoutId() {
        return R.i.dpk;
    }

    public final void bWO() {
        com.tencent.mm.ui.base.h.b(this.mController.xRr, getString(R.l.eyB), null, true);
    }

    private boolean bYr() {
        if (this.ucT == null || !this.ucT.uec) {
            return true;
        }
        bWO();
        return false;
    }

    private void goBack() {
        if (this.uaN == 2 && this.ucQ.uaO) {
            if (!(this.ucX || this.tWW)) {
                com.tencent.mm.sdk.b.b fwVar = new fw();
                fwVar.fwl.type = 19;
                fwVar.fwl.frf = this.hBA;
                fwVar.fwl.fws = -1;
                com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                if (!(!fwVar.fwm.fwD)) {
                    this.ucX = true;
                    this.ucY = true;
                } else {
                    return;
                }
            }
            bYs();
            finish();
        }
    }

    public final void bYs() {
        this.ucT.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) this);
        final String bXj = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXj();
        String Ry = com.tencent.mm.plugin.wenote.b.b.Ry(Pattern.compile("<object[^>]*>", 2).matcher(bXj).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (!(bi.oN(Ry) || Ry.length() == 0)) {
            Ry = Pattern.compile("\\s*|\t|\r|\n").matcher(Ry).replaceAll("");
        }
        if ((bi.oN(Ry) ? 1 : null) != null) {
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 12;
            fwVar.fwl.frf = this.hBA;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
        } else if (this.tWW) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
            as.Dt().F(new Runnable() {
                public final void run() {
                    NoteEditorUI.this.aX(bXj, true);
                }
            });
        } else if (this.ucX) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
            as.Dt().F(new Runnable() {
                public final void run() {
                    NoteEditorUI.this.aX(bXj, false);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.udu) {
            if (this.Va != null) {
                RecyclerView recyclerView = this.Va;
                RecyclerView.k kVar = this.udw;
                if (recyclerView.UD != null) {
                    recyclerView.UD.remove(kVar);
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e bXS = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
            x.i("NoteSelectManager", "onDestroy");
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = false;
            if (bXS.ubJ != null) {
                bXS.ubJ.TN();
            }
            if (bXS.ubK != null) {
                bXS.ubK.TN();
            }
            if (bXS.ubC != null) {
                bXS.ubC.dismiss();
            }
            if (bXS.ubD != null) {
                bXS.ubD.dismiss();
            }
            if (bXS.ubE != null) {
                bXS.ubE.dismiss();
            }
            if (bXS.ubF != null) {
                bXS.ubF.dismiss();
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.ubm = null;
        }
        as.CN().b(921, (e) this);
        if (this.ucQ != null) {
            k kVar2 = this.ucQ;
            kVar2.uaQ.TN();
            kVar2.uaG = -1;
            k.uaB = null;
        }
        if (com.tencent.mm.plugin.wenote.model.c.bWA().tWL != null) {
            com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWR.clear();
            com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWQ.clear();
            com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWP.clear();
        }
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a bYD = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bYD();
        bYD.stopPlay();
        bYD.kIB = null;
        bYD.kIF = null;
        bYD.gzt.clear();
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.ufn = null;
        if (com.tencent.mm.plugin.wenote.model.k.bWE() != null) {
            com.tencent.mm.plugin.wenote.model.k.destroy();
        }
    }

    public final void bWX() {
        if (this.ucT != null) {
            this.ucT.a(null);
        }
    }

    public final void BE(final int i) {
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                    NoteEditorUI.this.ucR.bj(i);
                    x.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                }
            }, 0);
        }
    }

    public final void BG(int i) {
        try {
            this.ucR.bl(i);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", Integer.valueOf(i));
        }
    }

    public final void BF(int i) {
        try {
            this.ucR.bk(i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", Integer.valueOf(i));
        }
    }

    public final void eq(int i, int i2) {
        try {
            this.ucR.W(i, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void er(int i, int i2) {
        try {
            this.ucR.U(i, i2);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void bYt() {
        try {
            this.ucR.UR.notifyChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
        }
    }

    public final void kN(boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", Boolean.valueOf(z));
        if (this.ucW || com.tencent.mm.plugin.wenote.model.c.bWA().tWL == null) {
            boolean z2;
            String str = "MicroMsg.Note.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.ucW);
            if (com.tencent.mm.plugin.wenote.model.c.bWA().tWL == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.e(str, str2, objArr);
            return;
        }
        v vVar;
        if (this.uaN != 1) {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWO == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWP.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWO.field_localId));
        } else {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWN == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWP.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWN.frh));
        }
        if (vVar != null && !this.tWW) {
            this.udf = vVar.tYH;
            if (vVar.tYH) {
                l(vVar.tYG, false);
                return;
            }
            this.ucW = true;
            l(vVar.tYG, true);
        }
    }

    public final synchronized void l(Object obj, final boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", Boolean.valueOf(z));
        synchronized (this.udg) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXd();
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList == null) {
            } else {
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                if (this.uaN == 2 && !this.udp) {
                    l lVar = com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWN;
                    if (lVar == null) {
                    } else {
                        com.tencent.mm.plugin.wenote.model.a.b dVar = new com.tencent.mm.plugin.wenote.model.a.d(lVar.tYk);
                        dVar.tXR = false;
                        dVar.tXX = false;
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(dVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.wenote.model.a.n nVar = (com.tencent.mm.plugin.wenote.model.a.n) it.next();
                    switch (nVar.type) {
                        case -3:
                        case -2:
                            break;
                        case -1:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.g) nVar);
                            break;
                        case 1:
                            com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.h) nVar;
                            if (bi.oN(bVar.content)) {
                                bVar.content = "";
                            }
                            bVar.content = bVar.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                            if (bVar.content.length() > 100) {
                                com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(bVar.content);
                            } else {
                                Object obj2;
                                String str = bVar.content;
                                String str2 = "<br/>";
                                int length = str2.length();
                                if (bi.oN(str) || str.length() < length) {
                                    obj2 = null;
                                } else {
                                    int i = 0;
                                    while (i < str.length()) {
                                        int i2 = i + length;
                                        if (i2 > str.length()) {
                                            obj2 = null;
                                        } else if (str2.equalsIgnoreCase(str.substring(i, i2))) {
                                            i = i2;
                                        } else {
                                            obj2 = null;
                                        }
                                    }
                                    i = 1;
                                }
                                if (obj2 != null) {
                                    bVar.content = bVar.content.substring(0, bVar.content.length() - 5);
                                }
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(bVar);
                            break;
                        case 2:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.e) nVar);
                            break;
                        case 3:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.f) nVar);
                            break;
                        case 4:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.k) nVar);
                            break;
                        case 5:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.c) nVar);
                            break;
                        case 6:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.j) nVar);
                            break;
                        default:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((i) nVar);
                            break;
                    }
                }
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                if (!z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bXc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();
                    synchronized (bXc) {
                        bXc.tZh = true;
                    }
                }
                ah.y(new Runnable() {
                    public final void run() {
                        synchronized (NoteEditorUI.this.udg) {
                            NoteEditorUI.this.bYt();
                            NoteEditorUI.this.ucW = true;
                            x.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", Boolean.valueOf(z), Boolean.valueOf(NoteEditorUI.this.udf));
                            if (NoteEditorUI.this.lYX != null && z) {
                                NoteEditorUI.this.lYX.dismiss();
                            }
                        }
                    }
                });
                if (this.udk > 0 || this.udl != 0) {
                    this.hbP.postDelayed(new Runnable() {
                        public final void run() {
                            if (NoteEditorUI.this.uda != null) {
                                NoteEditorUI.this.uda.N(NoteEditorUI.this.udk, NoteEditorUI.this.udl);
                                NoteEditorUI.this.mZw = NoteEditorUI.this.udk;
                                NoteEditorUI.this.udj = NoteEditorUI.this.udl;
                            }
                        }
                    }, 100);
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXi();
            }
        }
    }

    public final RecyclerView bYu() {
        return this.Va;
    }

    public final Context bYv() {
        return this.mController.xRr;
    }

    public final com.tencent.mm.plugin.wenote.model.nativenote.b.a bYw() {
        return this;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.udz = i;
        if (i2 != -1) {
            this.udy = false;
            return;
        }
        int i3;
        this.udy = true;
        final String stringExtra;
        String str;
        Context context;
        com.tencent.mm.plugin.wenote.model.a.b fVar;
        String stringExtra2;
        final Dialog a;
        com.tencent.mm.sdk.b.b fwVar;
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                final String stringExtra3 = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oN(stringExtra)) {
                    as.Hm();
                    final cg dI = com.tencent.mm.y.c.Fh().dI(this.frh);
                    if (dI.field_msgId == this.frh) {
                        final Dialog a2 = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                com.tencent.mm.sdk.b.b mvVar = new mv();
                                mvVar.fFz.type = 4;
                                mvVar.fFz.fFE = dI;
                                mvVar.fFz.toUser = stringExtra;
                                mvVar.fFz.fwr = stringExtra3;
                                com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                                ah.y(new Runnable() {
                                    public final void run() {
                                        a2.dismiss();
                                        com.tencent.mm.ui.snackbar.a.h(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.eip));
                                    }
                                });
                            }

                            public final String toString() {
                                return super.toString() + "|onActivityResult";
                            }
                        });
                        i3 = 2;
                        break;
                    }
                    x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                    return;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4097:
                x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                if (intent.getParcelableExtra("key_req_result") == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    x.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14547, Integer.valueOf(i3));
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().et(0, stringArrayListExtra.size())) {
                        bWM();
                        i3 = 0;
                        break;
                    }
                    Context context2 = this.mController.xRr;
                    getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a(context2, getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            if (NoteEditorUI.this.inI != null) {
                                NoteEditorUI.this.inI.dismiss();
                                NoteEditorUI.this.inI = null;
                            }
                        }
                    });
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < stringArrayListExtra.size(); i++) {
                                String str = (String) stringArrayListExtra.get(i);
                                com.tencent.mm.plugin.wenote.model.a.e eVar = new com.tencent.mm.plugin.wenote.model.a.e();
                                eVar.tYo = true;
                                eVar.type = 2;
                                eVar.tYn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXi();
                                eVar.mBr = com.tencent.mm.plugin.wenote.model.f.Rn(eVar.toString());
                                NoteEditorUI.this.ude = new uz();
                                NoteEditorUI.this.ude.Ui(eVar.mBr);
                                eVar.tYp = com.tencent.mm.plugin.wenote.b.c.fh(str, com.tencent.mm.plugin.wenote.model.f.o(NoteEditorUI.this.ude));
                                eVar.fCV = com.tencent.mm.plugin.wenote.b.c.fi(eVar.tYp, com.tencent.mm.plugin.wenote.model.f.i(NoteEditorUI.this.ude));
                                arrayList.add(eVar);
                            }
                            if (NoteEditorUI.this.inI == null || !NoteEditorUI.this.inI.isShowing()) {
                                x.i("MicroMsg.Note.NoteEditorUI", "user canceled");
                                return;
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(arrayList, NoteEditorUI.this.ucQ.bXP(), true, true, false, true, false);
                            NoteEditorUI.this.f(true, 100);
                            NoteEditorUI.this.P(1, 0);
                        }
                    });
                }
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra4 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!bi.oN(stringExtra4) && stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(stringExtra4);
                }
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14547, Integer.valueOf(i3));
                    if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().et(0, stringArrayListExtra.size())) {
                        str = (String) stringArrayListExtra.get(0);
                        com.tencent.mm.plugin.sight.base.a JX = com.tencent.mm.plugin.sight.base.d.JX(str);
                        if (JX != null) {
                            long btk = (long) JX.btk();
                            final com.tencent.mm.plugin.wenote.model.a.j jVar = new com.tencent.mm.plugin.wenote.model.a.j();
                            jVar.tYo = true;
                            jVar.fwx = "";
                            jVar.fCV = "";
                            jVar.duration = btk;
                            jVar.type = 6;
                            jVar.tYn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXi();
                            jVar.tYd = com.tencent.mm.a.e.bQ(str);
                            jVar.mBr = com.tencent.mm.plugin.wenote.model.f.Rn(jVar.toString());
                            this.ude = new uz();
                            this.ude.Ui(jVar.mBr);
                            this.ude.Uf(jVar.tYd);
                            stringExtra4 = com.tencent.mm.plugin.wenote.model.f.i(this.ude);
                            stringExtra = com.tencent.mm.plugin.wenote.model.f.o(this.ude);
                            if (!bi.oN(str)) {
                                x.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", str);
                                List arrayList = new ArrayList();
                                arrayList.add(str);
                                final Runnable dVar = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(arrayList, stringExtra4, stringExtra, jVar, new com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a() {
                                    public final void a(String str, com.tencent.mm.plugin.wenote.model.a.j jVar) {
                                        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                                        if (!bi.oN(str) && FileOp.bO(str) && jVar != null) {
                                            jVar.fwx = str;
                                        }
                                    }

                                    public final void b(String str, com.tencent.mm.plugin.wenote.model.a.j jVar) {
                                        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                                        if (NoteEditorUI.this.inI != null) {
                                            NoteEditorUI.this.inI.dismiss();
                                            NoteEditorUI.this.inI = null;
                                        }
                                        if (bi.oN(str) || !com.tencent.mm.a.e.bO(str) || jVar == null || jVar.tYe) {
                                            x.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                                        } else if (new File(str).length() < NoteEditorUI.mzv) {
                                            jVar.fCV = str;
                                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((com.tencent.mm.plugin.wenote.model.a.b) jVar, NoteEditorUI.this.ucQ.bXP(), false, true, false);
                                        } else {
                                            Toast.makeText(NoteEditorUI.this.mController.xRr, NoteEditorUI.this.getString(R.l.ehb), 1).show();
                                        }
                                        NoteEditorUI.this.f(true, 100);
                                        NoteEditorUI.this.P(1, 0);
                                    }
                                });
                                context = this.mController.xRr;
                                getString(R.l.dGZ);
                                this.inI = com.tencent.mm.ui.base.h.a(context, getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = dVar;
                                        dVar.isStop = true;
                                        dVar.interrupt();
                                        jVar.tYe = true;
                                        NoteEditorUI.this.f(true, 100);
                                        NoteEditorUI.this.P(1, 0);
                                    }
                                });
                                com.tencent.mm.sdk.f.e.post(dVar, "NoteEditor_importVideo");
                                i3 = 0;
                                break;
                            }
                            x.e("MicroMsg.Note.NoteEditorUI", "video is null");
                            i3 = 0;
                            break;
                        }
                        x.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", bi.oM(str));
                        i3 = 0;
                        break;
                    }
                    bWM();
                    i3 = 0;
                    break;
                }
                x.i("MicroMsg.Note.NoteEditorUI", "no video selected");
                i3 = 0;
                break;
                break;
            case 4098:
                com.tencent.mm.plugin.report.service.g.pWK.h(14547, Integer.valueOf(4));
                if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().et(0, 1)) {
                    fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                    fVar.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                    fVar.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                    fVar.tYB = (double) intent.getIntExtra("kwebmap_scale", 0);
                    fVar.hzf = bi.aD(intent.getStringExtra("Kwebmap_locaion"), "");
                    fVar.nYL = intent.getStringExtra("kPoiName");
                    fVar.tYn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXi();
                    fVar.type = 3;
                    fVar.tYo = true;
                    fVar.fCV = "";
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(fVar, this.ucQ.bXP(), false, false, false);
                    i3 = 0;
                    break;
                }
                bWM();
                i3 = 0;
                break;
            case 4099:
                com.tencent.mm.plugin.report.service.g.pWK.h(14547, Integer.valueOf(5));
                str = intent.getStringExtra("choosed_file_path");
                if (!bi.oN(str)) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (file.length() < mzv) {
                            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().et(0, 1)) {
                                if (this.inI != null) {
                                    this.inI.dismiss();
                                    this.inI = null;
                                }
                                context = this.mController.xRr;
                                getString(R.l.dGZ);
                                this.inI = com.tencent.mm.ui.base.h.a(context, getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        if (NoteEditorUI.this.inI != null) {
                                            NoteEditorUI.this.inI.dismiss();
                                            NoteEditorUI.this.inI = null;
                                        }
                                    }
                                });
                                fVar = new com.tencent.mm.plugin.wenote.model.a.c();
                                fVar.title = file.getName();
                                fVar.content = com.tencent.mm.plugin.wenote.model.f.ah((float) com.tencent.mm.a.e.bN(str));
                                fVar.tYl = com.tencent.mm.plugin.wenote.model.h.Rr(com.tencent.mm.a.e.bQ(str));
                                fVar.tYn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXi();
                                fVar.type = 5;
                                fVar.tYo = true;
                                fVar.tYd = com.tencent.mm.a.e.bQ(str);
                                fVar.mBr = com.tencent.mm.plugin.wenote.model.f.Rn(fVar.toString());
                                this.ude = new uz();
                                this.ude.Ui(fVar.mBr);
                                this.ude.Uf(fVar.tYd);
                                fVar.fCV = com.tencent.mm.plugin.wenote.model.f.o(this.ude);
                                FileOp.x(str, fVar.fCV);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(fVar, this.ucQ.bXP(), false, true, false);
                                i3 = 2;
                                break;
                            }
                            bWM();
                            i3 = 2;
                            break;
                        }
                        i3 = 3;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = 1;
                break;
            case 4101:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oN(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                    fwVar = new fw();
                    fwVar.fwl.type = 13;
                    fwVar.fwl.context = this.mController.xRr;
                    fwVar.fwl.toUser = stringExtra2;
                    fwVar.fwl.fwr = str;
                    fwVar.fwl.frf = this.hBA;
                    fwVar.fwl.fwq = new Runnable() {
                        public final void run() {
                            a.dismiss();
                            com.tencent.mm.ui.snackbar.a.h(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.eip));
                        }
                    };
                    com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                    i3 = 2;
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4354:
                this.hbP.post(new Runnable() {
                    public final void run() {
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.ePw), 0).show();
                    }
                });
                i3 = 2;
                break;
            case 4355:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oN(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                    fwVar = new fw();
                    fwVar.fwl.type = 13;
                    fwVar.fwl.context = this.mController.xRr;
                    fwVar.fwl.toUser = stringExtra2;
                    fwVar.fwl.fwr = str;
                    fwVar.fwl.frf = this.hBA;
                    fwVar.fwl.frm = com.tencent.mm.plugin.wenote.model.c.bWA().tWL.tWX;
                    fwVar.fwl.fwq = new Runnable() {
                        public final void run() {
                            a.dismiss();
                            com.tencent.mm.ui.snackbar.a.h(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.eip));
                        }
                    };
                    com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                return;
        }
        i3 = 2;
        if (i3 == 0) {
            return;
        }
        if (1 == i3) {
            com.tencent.mm.ui.base.h.bu(this.mController.xRr, getString(R.l.eft));
        } else if (3 == i3) {
            Toast.makeText(this.mController.xRr, getString(R.l.ehb), 1).show();
        }
    }

    public final void aX(String str, boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", str, Boolean.valueOf(z));
        com.tencent.mm.sdk.b.b fwVar;
        if (z || !str.equals(this.ucZ)) {
            vn Ru = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Ru(str);
            if (Ru == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                return;
            }
            com.tencent.mm.sdk.b.b fwVar2;
            if (z) {
                fwVar2 = new fw();
                fwVar2.fwl.type = 19;
                fwVar2.fwl.frm = Ru;
                fwVar2.fwl.title = str;
                fwVar2.fwl.frf = this.hBA;
                fwVar2.fwl.desc = "fav_add_new_note";
                com.tencent.mm.sdk.b.a.xmy.m(fwVar2);
            } else {
                fwVar2 = new fw();
                fwVar2.fwl.type = 19;
                fwVar2.fwl.frm = Ru;
                fwVar2.fwl.title = str;
                fwVar2.fwl.frf = this.hBA;
                fwVar2.fwl.desc = "";
                if (this.ucY) {
                    fwVar2.fwl.fws = -2;
                }
                com.tencent.mm.sdk.b.a.xmy.m(fwVar2);
            }
            x.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
            if (z) {
                boolean z2;
                fwVar = new fw();
                fwVar.fwl.type = 30;
                fwVar.fwl.fws = 6;
                fwVar.fwl.frf = this.hBA;
                com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                if (fwVar.fwm.ret == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.tWW = false;
                    this.ucX = true;
                }
            }
            this.ucZ = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXj();
        } else if (!this.udr && this.ucQ.uaK > 0 && !bi.oN(this.ucQ.uaL) && this.ucQ.uaM > 0) {
            fwVar = new fw();
            fwVar.fwl.type = 19;
            fwVar.fwl.fws = -3;
            fwVar.fwl.frf = this.hBA;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.ucQ.uaK);
            intent.putExtra("fav_note_xml", this.ucQ.uaL);
            intent.putExtra("fav_note_item_updatetime", this.ucQ.uaM);
            fwVar.fwl.fwo = intent;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.uaN == 2) {
            switch (this.udz) {
                case -1:
                    if (this.udA) {
                        f(true, 100);
                        P(1, 0);
                        break;
                    }
                    break;
                case 4097:
                    if (!this.udy) {
                        f(true, 100);
                        P(1, 0);
                        break;
                    }
                    break;
                case 4098:
                case 4099:
                    f(true, 100);
                    P(1, 0);
                    break;
            }
        }
        this.udz = -1;
        this.udy = false;
    }

    protected void onPause() {
        super.onPause();
        if (this.ucT != null) {
            this.ucT.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) this);
        }
        if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bYD().aJh()) {
            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bYD().stopPlay();
        }
        this.udA = this.udc;
        f(false, 0);
        p bXx = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bXw().bXx();
        if (c(bXx)) {
            bXx.tYu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Rv(getString(R.l.eXY));
            bXx.tYw = this.mZw;
            bXx.tYx = this.udj;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bXw().a(bXx);
        }
    }

    public void onDrag() {
        super.onDrag();
        if (this.udu) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bYa();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXY();
        }
    }

    public void onCancel() {
        super.onCancel();
        if (this.udu) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kU(false);
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kT(false);
        }
    }

    public final void bWP() {
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eyw), "", getString(R.l.eyv), getString(R.l.eyu), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bYf();
            }
        }, null);
    }

    public final void bWQ() {
        Toast.makeText(this.mController.xRr, getString(R.l.eyz), 0).show();
    }

    public final int bWS() {
        if (this.udc) {
            return j.aN(this);
        }
        return 0;
    }

    public final int bWT() {
        int i = 0;
        if (this.ucS != null && this.ucS.getVisibility() == 0) {
            i = this.udv + 0;
        }
        if (this.udh == null || this.udh.getVisibility() != 0) {
            return i;
        }
        return i + this.udv;
    }

    public final boolean bWU() {
        return (this.ucQ == null || this.ucQ.bXL() == null) ? false : true;
    }

    public final RecyclerView bWV() {
        return this.Va;
    }

    public final void bWR() {
        if (this.uaN == 2 && this.ucQ.uaO) {
            int bXe = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXe();
            com.tencent.mm.plugin.wenote.model.a.b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXe);
            if (BL != null) {
                BL.tXR = false;
                BL.tXX = false;
                BE(bXe);
            }
            this.hbP.post(new Runnable() {
                public final void run() {
                    WXRTEditText bXL = NoteEditorUI.this.ucQ.bXL();
                    if (bXL != null) {
                        bXL.clearFocus();
                    }
                }
            });
            f(false, 0);
            P(0, 0);
        }
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        if (this.uaN == 2 && this.ucQ.uaO) {
            ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Va.TV).uen = z;
            if (this.udb) {
                ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Va.TV).uen = false;
            }
            if (z) {
                if (!(this.tWW || this.ucX)) {
                    this.ucZ = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXj();
                    this.ucX = true;
                }
                if (wXRTEditText == null || wXRTEditText.tZU != 1) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Y(i, false);
                    return;
                } else {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Y(i, true);
                    return;
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().X(-1, false);
        }
    }

    public final void bWW() {
        if (!this.tWW && !this.ucX) {
            this.ucZ = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXj();
            this.ucX = true;
        }
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        this.udc = this.mController.xRL == 1;
        if (this.udc) {
            P(1, 0);
        }
        if (this.udu) {
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kU(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXZ());
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().kT(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXX());
                }
            }, 200);
        }
    }

    public final void f(final boolean z, long j) {
        if (this.uaN == 2 && this.ucQ.uaO) {
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    if (z && !NoteEditorUI.this.udc) {
                        NoteEditorUI.this.showVKB();
                    } else if (!z && NoteEditorUI.this.udc) {
                        NoteEditorUI.this.aWY();
                    }
                }
            }, j);
        }
    }

    public final void P(final int i, long j) {
        if (this.uaN == 2 && this.ucQ.uaO) {
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    switch (i) {
                        case 0:
                            NoteEditorUI.this.udh.setVisibility(8);
                            if (NoteEditorUI.this.ucT.uec) {
                                NoteEditorUI.this.ucS.setVisibility(0);
                                return;
                            } else {
                                NoteEditorUI.this.ucS.setVisibility(8);
                                return;
                            }
                        case 1:
                            NoteEditorUI.this.ucS.setVisibility(0);
                            NoteEditorUI.this.udh.setVisibility(8);
                            return;
                        case 2:
                            NoteEditorUI.this.ucS.setVisibility(0);
                            NoteEditorUI.this.udh.setVisibility(8);
                            return;
                        case 3:
                            NoteEditorUI.this.ucS.setVisibility(0);
                            NoteEditorUI.this.udh.setVisibility(0);
                            return;
                        default:
                            return;
                    }
                }
            }, j);
        }
    }

    public final void bWK() {
        if (!this.ucT.uec) {
            bWR();
            final Context context = this.mController.xRr;
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().size();
                    int childCount = NoteEditorUI.this.Va.getChildCount();
                    if (size == childCount) {
                        size = childCount - 1;
                        float f = 0.0f;
                        int i = size;
                        while (i >= 0) {
                            View childAt = NoteEditorUI.this.Va.getChildAt(i);
                            float R = z.R(childAt);
                            i--;
                            f = f > ((float) childAt.getBottom()) + R ? f : ((float) childAt.getBottom()) + R;
                        }
                        if (f < ((float) j.aT(context)[1]) && f > 0.0f) {
                            LayoutParams layoutParams = (LayoutParams) NoteEditorUI.this.ucU.getLayoutParams();
                            layoutParams.height = (int) f;
                            NoteEditorUI.this.ucU.setLayoutParams(layoutParams);
                        }
                    }
                    NoteEditorUI.this.ucU.setVisibility(0);
                    if (NoteEditorUI.this.ucV != null) {
                        g a = NoteEditorUI.this.ucV;
                        int[] iArr = new int[]{0, 0};
                        a.mParentView.getLocationOnScreen(iArr);
                        a.tZF.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
                    }
                }
            }, 400);
        }
    }

    public final void a(WXRTEditText wXRTEditText) {
        if (wXRTEditText != null) {
            boolean z;
            if (f.jRO == null || f.jRO.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList bXr = f.bXr();
                if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().ab(bXr)) {
                    bWM();
                    return;
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(bXr, wXRTEditText, true, true, true, false, false);
                int bXB = wXRTEditText.bXB();
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().eu(bXB, (bXr.size() + bXB) + 1);
                bWR();
                if (this.udu) {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXW();
                }
            }
        }
    }

    public final void bXv() {
        int dV = f.dV(this.mController.xRr);
        if (dV == 2) {
            if (f.dU(this)) {
                bWM();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXd();
            f.abi();
            com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
            hVar.content = "";
            hVar.tXR = false;
            hVar.tXX = false;
            hVar.tXT = 0;
            hVar.tXZ = true;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(hVar);
            bYt();
        } else if (dV == 3) {
            ArrayList bXr = f.bXr();
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().ab(bXr)) {
                bWM();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXd();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(bXr, null, false, true, false, false, false);
            bWR();
        }
    }

    public final void bXs() {
        com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
        hVar.content = "";
        hVar.tXR = true;
        hVar.tXX = false;
        hVar.tXT = 0;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXd();
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(hVar);
        bYt();
        f(true, 50);
        P(1, 0);
    }

    public final void bXt() {
        f.c(this.mController.xRr, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXk());
    }

    public final void bXu() {
        f.c(this.mController.xRr, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXk());
        bXs();
    }

    public final void es(int i, int i2) {
        this.udb = Math.abs(i2 - i) > 0;
    }

    public final void BH(final int i) {
        if (i >= 0 && i < com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().size()) {
            this.hbP.post(new Runnable() {
                public final void run() {
                    NoteEditorUI.this.Va.be(i);
                }
            });
        }
    }

    public final void bWL() {
        this.hbP.post(new Runnable() {
            public final void run() {
                if (NoteEditorUI.this.inI != null) {
                    NoteEditorUI.this.inI.dismiss();
                    NoteEditorUI.this.inI = null;
                }
            }
        });
    }

    public final void bWM() {
        if (this.tWW || this.ucX) {
            bWR();
            if (this.udu) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS().bXW();
            }
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.ui.base.h.b(NoteEditorUI.this.mController.xRr, NoteEditorUI.this.getString(R.l.eYf), null, true);
                }
            }, 100);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Note.NoteEditorUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    bWN();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void bWN() {
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                NoteEditorUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int r15, int r16, java.lang.String r17, com.tencent.mm.ad.k r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r2 = r18.getType();	 Catch:{ all -> 0x0083 }
        r3 = 921; // 0x399 float:1.29E-42 double:4.55E-321;
        if (r2 == r3) goto L_0x000b;
    L_0x0009:
        monitor-exit(r14);
        return;
    L_0x000b:
        r0 = r18;
        r2 = r0 instanceof com.tencent.mm.plugin.wenote.model.b;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0009;
    L_0x0011:
        r18 = (com.tencent.mm.plugin.wenote.model.b) r18;	 Catch:{ all -> 0x0083 }
        r0 = r18;
        r2 = r0.tWD;	 Catch:{ all -> 0x0083 }
        r3 = 1;
        if (r2 != r3) goto L_0x0009;
    L_0x001a:
        if (r16 != 0) goto L_0x045e;
    L_0x001c:
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlong pic , allow";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x0083 }
        r2 = r14.Va;	 Catch:{ all -> 0x0083 }
        r5 = r2.fn();	 Catch:{ all -> 0x0083 }
        if (r5 == 0) goto L_0x040b;
    L_0x002d:
        r6 = r5.getItemCount();	 Catch:{ all -> 0x0083 }
        if (r6 > 0) goto L_0x0088;
    L_0x0033:
        r14.aFy();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.xRr;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.xRr;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0086;
    L_0x0078:
        r2 = 1;
    L_0x0079:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        goto L_0x0009;
    L_0x0083:
        r2 = move-exception;
        monitor-exit(r14);
        throw r2;
    L_0x0086:
        r2 = 0;
        goto L_0x0079;
    L_0x0088:
        r3 = 0;
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r8 = r2.maxMemory();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r8 = r8 / r10;
        r2 = (int) r8;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2 / 8;
        r7 = new com.tencent.mm.sdk.platformtools.aa;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r7.<init>(r2);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = 0;
        r4 = r2;
        r2 = r3;
    L_0x009f:
        if (r4 >= r6) goto L_0x0267;
    L_0x00a1:
        r3 = r14.Va;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r8 = r5.getItemViewType(r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r8 = r5.d(r3, r8);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5.a(r8, r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r9 = r14.Va;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r9 = r9.getWidth();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = 0;
        r11 = 0;
        r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.measure(r9, r10);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r9 = 0;
        r10 = 0;
        r11 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r11 = r11.getMeasuredWidth();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12 = r12.getMeasuredHeight();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.layout(r9, r10, r11, r12);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r9 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r9 = r9.getHeight();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r3 <= 0) goto L_0x0106;
    L_0x00e6:
        if (r9 <= 0) goto L_0x0106;
    L_0x00e8:
        r10 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Throwable -> 0x010a, Exception -> 0x0143 }
        r9 = android.graphics.Bitmap.createBitmap(r3, r9, r10);	 Catch:{ Throwable -> 0x010a, Exception -> 0x0143 }
        r3 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.<init>(r9);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = r8.VU;	 Catch:{ Exception -> 0x01b8, Throwable -> 0x020a }
        r10.draw(r3);	 Catch:{ Exception -> 0x01b8, Throwable -> 0x020a }
    L_0x00f8:
        r3 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r7.put(r3, r9);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r8.VU;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.getMeasuredHeight();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2 + r3;
    L_0x0106:
        r3 = r4 + 1;
        r4 = r3;
        goto L_0x009f;
    L_0x010a:
        r2 = move-exception;
        r2 = 0;
        r3 = r2;
    L_0x010d:
        if (r3 >= r4) goto L_0x0128;
    L_0x010f:
        r2 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x0124;
    L_0x011b:
        r5 = r2.isRecycled();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r5 != 0) goto L_0x0124;
    L_0x0121:
        r2.recycle();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
    L_0x0124:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x010d;
    L_0x0128:
        r14.aFy();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2.show();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        goto L_0x0009;
    L_0x0143:
        r2 = move-exception;
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlongpic fail,Exception error msg a";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aFy();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.xRr;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.xRr;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 2;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0405;
    L_0x0192:
        r2 = 1;
    L_0x0193:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
    L_0x019c:
        r2 = r14.ucQ;	 Catch:{ all -> 0x0083 }
        r0 = r18;
        r3 = r0.tWH;	 Catch:{ all -> 0x0083 }
        r2.uaN = r3;	 Catch:{ all -> 0x0083 }
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();	 Catch:{ all -> 0x0083 }
        r3 = r3.size();	 Catch:{ all -> 0x0083 }
        r3 = r3 + -1;
        r4 = 0;
        r2.W(r3, r4);	 Catch:{ all -> 0x0083 }
        goto L_0x0009;
    L_0x01b8:
        r3 = move-exception;
        r14.aFy();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = r10.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r11 = com.tencent.mm.R.l.eyA;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = r10.getString(r11);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r11 = 1;
        r3 = android.widget.Toast.makeText(r3, r10, r11);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.show();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r11 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r3 = 5;
        r12 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = 0;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = 1;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = 2;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = 3;
        r13 = 1;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r13 = 4;
        r3 = r14.udp;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r3 == 0) goto L_0x0265;
    L_0x01fe:
        r3 = 1;
    L_0x01ff:
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r12[r13] = r3;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r10.h(r11, r12);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        goto L_0x00f8;
    L_0x020a:
        r2 = move-exception;
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlongpic fail,Throwable error msg throw";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aFy();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.xRr;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.xRr;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 2;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0408;
    L_0x0259:
        r2 = 1;
    L_0x025a:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        goto L_0x019c;
    L_0x0265:
        r3 = 0;
        goto L_0x01ff;
    L_0x0267:
        r3 = r14.mController;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = 14;
        r3 = com.tencent.mm.bu.a.fromDPToPix(r3, r4);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = r14.Va;	 Catch:{ Throwable -> 0x02bf, Exception -> 0x0352 }
        r4 = r4.getMeasuredWidth();	 Catch:{ Throwable -> 0x02bf, Exception -> 0x0352 }
        r4 = r4 + 0;
        r5 = r2 + r3;
        r8 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Throwable -> 0x02bf, Exception -> 0x0352 }
        r2 = android.graphics.Bitmap.createBitmap(r4, r5, r8);	 Catch:{ Throwable -> 0x02bf, Exception -> 0x0352 }
        r5 = r2;
    L_0x0282:
        r8 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r8.<init>(r5);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = -1;
        r8.drawColor(r2);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r2.xRr;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = 8;
        r3 = com.tencent.mm.bu.a.fromDPToPix(r2, r3);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 0;
        r4 = r2;
    L_0x0297:
        if (r4 >= r6) goto L_0x03bb;
    L_0x0299:
        r2 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x02b9;
    L_0x02a5:
        r9 = 0;
        r10 = (float) r3;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r11 = 0;
        r8.drawBitmap(r2, r9, r10, r11);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r9 = r2.getHeight();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = r3 + r9;
        r9 = r2.isRecycled();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        if (r9 != 0) goto L_0x02b9;
    L_0x02b6:
        r2.recycle();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
    L_0x02b9:
        r2 = r3;
        r3 = r4 + 1;
        r4 = r3;
        r3 = r2;
        goto L_0x0297;
    L_0x02bf:
        r4 = move-exception;
        r4 = "MicroMsg.Note.NoteEditorUI";
        r5 = "favorite, note, gen long pic ,rgb 888  error,errormsg ";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = r14.Va;	 Catch:{ Throwable -> 0x02da, Exception -> 0x0352 }
        r4 = r4.getMeasuredWidth();	 Catch:{ Throwable -> 0x02da, Exception -> 0x0352 }
        r4 = r4 + 0;
        r2 = r2 + r3;
        r3 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ Throwable -> 0x02da, Exception -> 0x0352 }
        r2 = android.graphics.Bitmap.createBitmap(r4, r2, r3);	 Catch:{ Throwable -> 0x02da, Exception -> 0x0352 }
        r5 = r2;
        goto L_0x0282;
    L_0x02da:
        r2 = move-exception;
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 0;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 1;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 2;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 3;
        r8 = 2;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r8 = 4;
        r2 = r14.udp;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x0350;
    L_0x0307:
        r2 = 1;
    L_0x0308:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r5[r8] = r2;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3.h(r4, r5);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "favorite, note, gen long pic , 565 error,errormsg is er:";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r14.aFy();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r2.xRr;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2.show();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = 0;
        r3 = r2;
    L_0x0335:
        if (r3 >= r6) goto L_0x0009;
    L_0x0337:
        r2 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x034c;
    L_0x0343:
        r4 = r2.isRecycled();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
        if (r4 != 0) goto L_0x034c;
    L_0x0349:
        r2.recycle();	 Catch:{ Exception -> 0x0352, Throwable -> 0x020a }
    L_0x034c:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0335;
    L_0x0350:
        r2 = 0;
        goto L_0x0308;
    L_0x0352:
        r2 = move-exception;
        r3 = "MicroMsg.Note.NoteEditorUI";
        r4 = "genlongpic fail,error msg Exception";
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = "MicroMsg.Note.NoteEditorUI";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r14.aFy();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2.show();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x03b9;
    L_0x03ad:
        r2 = 1;
    L_0x03ae:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r5[r6] = r2;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.h(r4, r5);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        goto L_0x0009;
    L_0x03b9:
        r2 = 0;
        goto L_0x03ae;
    L_0x03bb:
        r2 = r14.lYX;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x03f8;
    L_0x03bf:
        r2 = r14.lYX;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2.isShowing();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r2 == 0) goto L_0x03f8;
    L_0x03c7:
        r14.aFy();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = r2.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.xRr;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = com.tencent.mm.R.l.dYb;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r7 = 0;
        r8 = com.tencent.mm.platformtools.d.Wl();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = r3.getString(r4, r6);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2.show();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2 = com.tencent.mm.y.as.Dt();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$29;	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        r2.F(r3);	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        goto L_0x019c;
    L_0x03f8:
        if (r5 == 0) goto L_0x019c;
    L_0x03fa:
        r2 = r5.isRecycled();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        if (r2 != 0) goto L_0x019c;
    L_0x0400:
        r5.recycle();	 Catch:{ Exception -> 0x0143, Throwable -> 0x020a }
        goto L_0x019c;
    L_0x0405:
        r2 = 0;
        goto L_0x0193;
    L_0x0408:
        r2 = 0;
        goto L_0x025a;
    L_0x040b:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x045c;
    L_0x0437:
        r2 = 1;
    L_0x0438:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        r14.aFy();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.xRr;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.xRr;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        goto L_0x019c;
    L_0x045c:
        r2 = 0;
        goto L_0x0438;
    L_0x045e:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 4;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.udp;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x04b8;
    L_0x048a:
        r2 = 1;
    L_0x048b:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlong pic , not allow";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aFy();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.xRr;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.xRr;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.eyA;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        goto L_0x019c;
    L_0x04b8:
        r2 = 0;
        goto L_0x048b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    private void aFy() {
        if (this.lYX != null) {
            this.lYX.dismiss();
            this.lYX = null;
        }
    }

    protected final String i(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null) {
            try {
                return fVar.field_datatotalsize;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "getInfoLength [%s]", e.toString());
            }
        }
        return super.i(fVar);
    }
}
