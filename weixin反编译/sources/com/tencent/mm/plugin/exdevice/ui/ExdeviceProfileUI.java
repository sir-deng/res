package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int mbF = 0;
    private boolean GO = false;
    private int gVQ = 0;
    private TextPaint gu = new TextPaint(1);
    private String jPV;
    private String jvW;
    private String lUF;
    private boolean lUS;
    private List<String> lVi;
    private List<String> lVj;
    private r lYX = null;
    private String mAppName;
    private Context mContext;
    private boolean maM;
    private boolean maN;
    private int maO;
    private List<ju> maR;
    private int mbA;
    private b<i> mbB = new b<i>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            final i iVar = (i) kVar;
            if (ExdeviceProfileUI.this.isFinishing() || ExdeviceProfileUI.this.GO) {
                ExdeviceProfileUI.this.aFJ();
                x.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                return;
            }
            ExdeviceProfileUI.this.mbu = true;
            if (i == 0 && i2 == 0 && iVar != null) {
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (ExdeviceProfileUI.this.lYX != null) {
                            ExdeviceProfileUI.this.lYX.dismiss();
                        }
                        ExdeviceProfileUI.this.mbk = iVar.lUN;
                        ExdeviceProfileUI.this.mbm.v(ExdeviceProfileUI.this.mbk);
                    }
                });
                ExdeviceProfileUI.this.mbl = iVar.lUM;
                ExdeviceProfileUI.this.mbv = iVar.lUI;
                ExdeviceProfileUI.this.mbw = iVar.lUJ;
                ExdeviceProfileUI.this.mbx = ExdeviceProfileUI.aH(iVar.lUK);
                ExdeviceProfileUI.this.maN = iVar.lUQ;
                ExdeviceProfileUI.this.maR = iVar.lUP;
                ExdeviceProfileUI.this.mbz = iVar.lUO;
                ExdeviceProfileUI.this.mbA = iVar.lUR;
                ExdeviceProfileUI.this.lUS = iVar.lUS;
                ExdeviceProfileUI.this.lUF = iVar.lUF;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceProfileUI.g(ExdeviceProfileUI.this);
                    }
                });
                if (!ExdeviceProfileUI.this.maM) {
                    ExdeviceProfileUI exdeviceProfileUI = ExdeviceProfileUI.this;
                    ExdeviceProfileUI.this.maN;
                    exdeviceProfileUI.aFK();
                }
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceProfileUI.k(ExdeviceProfileUI.this);
                        ExdeviceProfileUI.this.mbs.notifyDataSetChanged();
                    }
                });
                ExdeviceProfileUI.this.aFI();
                ExdeviceProfileUI.this.aFJ();
            }
        }
    };
    private d mbC = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    com.tencent.mm.plugin.sport.b.d.qq(26);
                    ExdeviceProfileUI.s(ExdeviceProfileUI.this);
                    return;
                case 1:
                    com.tencent.mm.plugin.sport.b.d.qq(27);
                    ExdeviceProfileUI.r(ExdeviceProfileUI.this);
                    return;
                case 2:
                    ExdeviceProfileUI.t(ExdeviceProfileUI.this);
                    return;
                case 3:
                    h.a(ExdeviceProfileUI.this.mController.xRr, ExdeviceProfileUI.this.getString(R.l.eec), null, true, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            as.Hm();
                            com.tencent.mm.storage.x Xv = c.Ff().Xv(ExdeviceProfileUI.this.jPV);
                            com.tencent.mm.plugin.sport.b.d.qq(37);
                            s.f(Xv);
                            ExdeviceProfileUI.this.mbK.cfB();
                            if (ExdeviceProfileUI.this.lYX != null) {
                                ExdeviceProfileUI.this.lYX.show();
                            }
                        }
                    }, null);
                    return;
                case 4:
                    ExdeviceProfileUI.this.lUS = true;
                    com.tencent.mm.plugin.sport.b.d.qq(10);
                    ad.aEZ();
                    com.tencent.mm.plugin.exdevice.f.b.c.b("", ExdeviceProfileUI.this.mAppName, ExdeviceProfileUI.this.jPV, 3);
                    return;
                case 5:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ExdeviceProfileUI.this.lUF);
                    com.tencent.mm.bl.d.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    private b<com.tencent.mm.plugin.exdevice.f.a.h> mbD = new b<com.tencent.mm.plugin.exdevice.f.a.h>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
        }
    };
    private b<g> mbE = new b<g>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
        }
    };
    private Runnable mbG = new Runnable() {
        public final void run() {
            BackwardSupportUtil.c.a(ExdeviceProfileUI.this.mbo);
            if (ExdeviceProfileUI.this.mbo.getCount() > 0) {
                BackwardSupportUtil.c.b(ExdeviceProfileUI.this.mbo, ExdeviceProfileUI.this.mbo.getCount() - 1);
            }
        }
    };
    private b<g> mbH = new b<g>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.aFI();
                ExdeviceProfileUI.this.aFJ();
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (ExdeviceProfileUI.this.lYX != null) {
                            ExdeviceProfileUI.this.lYX.dismiss();
                        }
                    }
                });
            }
        }
    };
    private List<String> mbI;
    private b<com.tencent.mm.plugin.exdevice.f.a.k> mbJ = new b<com.tencent.mm.plugin.exdevice.f.a.k>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.exdevice.f.a.k kVar2 = (com.tencent.mm.plugin.exdevice.f.a.k) kVar;
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.mbI = kVar2.lVk;
                ExdeviceProfileUI.this.lVi = kVar2.lVi;
                ExdeviceProfileUI.this.lVj = kVar2.lVj;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (ExdeviceProfileUI.this.lYX != null) {
                            ExdeviceProfileUI.this.lYX.dismiss();
                        }
                    }
                });
                ExdeviceProfileUI.E(ExdeviceProfileUI.this);
            }
        }
    };
    private com.tencent.mm.sdk.b.c<ll> mbK = new com.tencent.mm.sdk.b.c<ll>() {
        {
            this.xmG = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ll llVar = (ll) bVar;
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", Integer.valueOf(llVar.fDF.count), Integer.valueOf(llVar.fDF.ret), llVar.fDF.fDG, llVar.fDF.fDH);
            if (ExdeviceProfileUI.this.lYX != null && ExdeviceProfileUI.this.lYX.isShowing()) {
                ExdeviceProfileUI.this.lYX.dismiss();
            }
            ExdeviceProfileUI.this.mbK.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            ExdeviceProfileUI.this.setResult(-1, intent);
            ExdeviceProfileUI.this.finish();
            return false;
        }
    };
    private GestureDetector mbL;
    private com.tencent.mm.ui.base.MMPullDownView.a mbM = new com.tencent.mm.ui.base.MMPullDownView.a() {
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ExdeviceProfileUI.this.mbL.onTouchEvent(motionEvent);
        }
    };
    private String mbi;
    private com.tencent.mm.plugin.exdevice.f.b.a.a mbj;
    private ArrayList<String> mbk;
    private ceb mbl;
    private ExdeviceProfileAffectedUserView mbm;
    private ImageView mbn;
    private ListView mbo;
    private ExdeviceProfileListHeader mbp;
    private MMSwitchBtn mbq;
    private SportChartView mbr;
    private a mbs;
    private View mbt;
    private volatile boolean mbu;
    private String mbv;
    private String mbw;
    private List<com.tencent.mm.plugin.sport.b.e> mbx;
    private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> mby;
    private List<wk> mbz;

    private class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(ExdeviceProfileUI exdeviceProfileUI, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) < Math.abs(f)) {
                return true;
            }
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.mbo.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.mbo.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (mbF == 0) {
                    mbF = iArr[1];
                }
                int i = iArr[1];
                if (i > (-mbF) / 2) {
                    exdeviceProfileUI.mbm.setAlpha(i > 0 ? ((float) (i * 2)) / (((float) mbF) * 2.0f) : ((float) i) / ((float) mbF));
                    exdeviceProfileUI.mbm.setVisibility(0);
                    return;
                }
                exdeviceProfileUI.mbm.setAlpha(0.0f);
                exdeviceProfileUI.mbm.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void B(ExdeviceProfileUI exdeviceProfileUI) {
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(exdeviceProfileUI.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
        gVar.rQF = new p.c() {
            public final void a(n nVar) {
                if (ExdeviceProfileUI.this.lUS) {
                    nVar.f(1, ExdeviceProfileUI.this.getString(R.l.edJ));
                } else {
                    nVar.f(4, ExdeviceProfileUI.this.getString(R.l.edN));
                }
            }
        };
        gVar.rQG = exdeviceProfileUI.mbC;
        gVar.bUX();
    }

    static /* synthetic */ void E(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        String d = bi.d(exdeviceProfileUI.mbI, ",");
        intent.putExtra("wechat_sport_contact", bi.d(exdeviceProfileUI.lVi, ","));
        intent.putExtra("wechat_sport_recent_like", d);
        d = bi.d(exdeviceProfileUI.lVj, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.l.ecE));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.l.ecF, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.p(2, 4, 1, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, FileUtils.S_IWUSR, 64, 16384));
        intent.putExtra("always_select_contact", d);
        com.tencent.mm.bl.d.a((Context) exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
    }

    static /* synthetic */ List aH(List list) {
        List arrayList = new ArrayList();
        for (bnl bnl : list) {
            com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
            eVar.field_step = bnl.jhF;
            eVar.field_timestamp = ((long) bnl.cRQ) * 1000;
            eVar.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(eVar.field_timestamp));
            arrayList.add(eVar);
        }
        return arrayList;
    }

    static /* synthetic */ void d(ExdeviceProfileUI exdeviceProfileUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bl.d.a((Context) exdeviceProfileUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void g(ExdeviceProfileUI exdeviceProfileUI) {
        exdeviceProfileUI.mController.removeAllOptionMenu();
        if (q.FY().equals(exdeviceProfileUI.jPV)) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(ExdeviceProfileUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            nVar.a(0, ExdeviceProfileUI.this.getString(R.l.edD), R.k.dxb);
                            nVar.a(1, ExdeviceProfileUI.this.getString(R.l.edF), R.k.dwQ);
                        }
                    };
                    gVar.rQG = ExdeviceProfileUI.this.mbC;
                    gVar.bUX();
                    return true;
                }
            });
            return;
        }
        as.Hm();
        boolean Xr = c.Ff().Xr(exdeviceProfileUI.jPV);
        as.Hm();
        boolean AN = c.Ff().Xv(exdeviceProfileUI.jPV).AN();
        if (exdeviceProfileUI.maN && Xr) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(ExdeviceProfileUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            nVar.f(2, ExdeviceProfileUI.this.getString(R.l.edL));
                        }
                    };
                    gVar.rQG = ExdeviceProfileUI.this.mbC;
                    gVar.bUX();
                    return true;
                }
            });
        } else if (!AN) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(ExdeviceProfileUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            if (!bi.oN(ExdeviceProfileUI.this.lUF)) {
                                nVar.f(5, ExdeviceProfileUI.this.getString(R.l.edK));
                            }
                            nVar.f(3, ExdeviceProfileUI.this.getString(R.l.edH));
                        }
                    };
                    gVar.rQG = ExdeviceProfileUI.this.mbC;
                    gVar.bUX();
                    return true;
                }
            });
        }
    }

    static /* synthetic */ void k(ExdeviceProfileUI exdeviceProfileUI) {
        if (exdeviceProfileUI.mbr == null) {
            exdeviceProfileUI.mbr = (SportChartView) exdeviceProfileUI.findViewById(R.h.cfx);
        }
        if (exdeviceProfileUI.mbq == null) {
            exdeviceProfileUI.mbq = (MMSwitchBtn) exdeviceProfileUI.findViewById(R.h.cfz);
        }
        if (exdeviceProfileUI.mbx == null || exdeviceProfileUI.mbx.size() <= 0) {
            exdeviceProfileUI.mbr.saM = false;
            exdeviceProfileUI.mbq.setVisibility(8);
            exdeviceProfileUI.mbr.ce(null);
            return;
        }
        if (exdeviceProfileUI.maM) {
            exdeviceProfileUI.mbr.saM = true;
            exdeviceProfileUI.mbq.setVisibility(0);
            exdeviceProfileUI.mbq.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                public final void cy(boolean z) {
                    if (ExdeviceProfileUI.this.mbx != null) {
                        if (z) {
                            ExdeviceProfileUI.this.mbr.yw(com.tencent.mm.plugin.sport.ui.SportChartView.a.saR);
                        } else {
                            ExdeviceProfileUI.this.mbr.yw(com.tencent.mm.plugin.sport.ui.SportChartView.a.saQ);
                        }
                    }
                    ExdeviceProfileUI.this.mbr.ce(ExdeviceProfileUI.this.mbx);
                }
            };
        } else {
            exdeviceProfileUI.mbr.saM = false;
            exdeviceProfileUI.mbq.setVisibility(8);
            exdeviceProfileUI.mbr.yw(com.tencent.mm.plugin.sport.ui.SportChartView.a.saQ);
            exdeviceProfileUI.mbr.ce(exdeviceProfileUI.mbx);
        }
        exdeviceProfileUI.mbr.saL = ((com.tencent.mm.plugin.sport.b.e) exdeviceProfileUI.mbx.get(exdeviceProfileUI.mbx.size() - 1)).field_step;
        exdeviceProfileUI.mbr.ce(exdeviceProfileUI.mbx);
        com.tencent.mm.plugin.sport.b.e bDQ = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).bDQ();
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        instance.set(10, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        final long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -120);
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        final long timeInMillis2 = instance.getTimeInMillis();
        if (bDQ != null) {
            instance.setTimeInMillis(bDQ.field_timestamp);
            instance.add(5, 2);
            if (instance.getTimeInMillis() > timeInMillis) {
                exdeviceProfileUI.t(timeInMillis2, timeInMillis);
                return;
            }
        }
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).a(timeInMillis2, timeInMillis, new com.tencent.mm.plugin.sport.b.c() {
            public final void aFQ() {
                ExdeviceProfileUI.this.t(timeInMillis2, timeInMillis);
            }
        });
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.mbA);
        String str = "0";
        if (exdeviceProfileUI.mbl != null) {
            str = String.valueOf(exdeviceProfileUI.mbl.score);
        }
        acVar.a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.jvW, new com.tencent.mm.plugin.exdevice.model.ac.a() {
            public final void zA(String str) {
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceProfileUI.this.getString(R.l.eee));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String hC = u.hC("wx_sport");
                u.GQ().t(hC, true).o("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", hC);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bl.d.b(ExdeviceProfileUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
            }
        });
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        String valueOf = String.valueOf(exdeviceProfileUI.mbA);
        String str = "0";
        if (exdeviceProfileUI.mbl != null) {
            str = String.valueOf(exdeviceProfileUI.mbl.score);
        }
        new ac().a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.jvW, new com.tencent.mm.plugin.exdevice.model.ac.a() {
            public final void zA(String str) {
                ExdeviceProfileUI.d(ExdeviceProfileUI.this, str);
            }
        });
    }

    static /* synthetic */ void t(ExdeviceProfileUI exdeviceProfileUI) {
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", exdeviceProfileUI.jPV);
        as.CN().a(new com.tencent.mm.plugin.exdevice.f.a.h(exdeviceProfileUI.jPV, exdeviceProfileUI.mbD), 0);
    }

    public void onCreate(Bundle bundle) {
        CharSequence string;
        super.onCreate(bundle);
        this.mContext = this.mController.xRr;
        Intent intent = getIntent();
        aFI();
        this.jPV = intent.getStringExtra("username");
        this.mbi = intent.getStringExtra("usernickname");
        String FY = q.FY();
        if (FY != null) {
            this.maM = FY.equals(this.jPV);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.maN = ad.aET().zG(this.jPV);
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", Boolean.valueOf(this.maN));
        Assert.assertTrue(!bi.oN(this.jPV));
        this.mbj = ad.aEV().zI(this.jPV);
        this.mbk = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(R.l.dGZ);
        this.lYX = h.a(this, getString(R.l.ctG), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (ExdeviceProfileUI.this.lYX != null) {
                    ExdeviceProfileUI.this.lYX.dismiss();
                    ExdeviceProfileUI.this.lYX = null;
                }
                ExdeviceProfileUI.this.finish();
            }
        });
        this.mbm = (ExdeviceProfileAffectedUserView) findViewById(R.h.ceV);
        this.mbn = (ImageView) findViewById(R.h.ceY);
        this.mbo = (ListView) findViewById(R.h.cfu);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.cEo);
        this.mbm.v(this.mbk);
        aFM();
        this.mbt = findViewById(R.h.cLL);
        this.mbL = new GestureDetector(this.mController.xRr, new a());
        mMPullDownView.mu(false);
        mMPullDownView.mw(false);
        mMPullDownView.mv(false);
        mMPullDownView.mu(false);
        mMPullDownView.mt(false);
        mMPullDownView.ylo = true;
        mMPullDownView.ylr = this.mbM;
        mMPullDownView.ylg = new MMPullDownView.c() {
            public final boolean azT() {
                View childAt = ExdeviceProfileUI.this.mbo.getChildAt(ExdeviceProfileUI.this.mbo.getChildCount() - 1);
                int count = ExdeviceProfileUI.this.mbo.getAdapter().getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.this.mbo.getHeight() || ExdeviceProfileUI.this.mbo.getLastVisiblePosition() < count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.ylh = new MMPullDownView.d() {
            public final boolean azS() {
                if (ExdeviceProfileUI.this.mbo.getFirstVisiblePosition() == 0) {
                    View childAt = ExdeviceProfileUI.this.mbo.getChildAt(ExdeviceProfileUI.this.mbo.getFirstVisiblePosition());
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        mMPullDownView.ykV = new MMPullDownView.e() {
            public final boolean azR() {
                return true;
            }
        };
        mMPullDownView.ylz = new MMPullDownView.b() {
            public final void aFP() {
                ExdeviceProfileUI.A(ExdeviceProfileUI.this);
            }
        };
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int A = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.buP));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.buG) : getResources().getDimensionPixelSize(R.f.buH);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.buR);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.f.buQ);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - A) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.buO);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - A) - dimensionPixelSize));
        this.mbp = exdeviceProfileListHeader;
        this.mbo.addHeaderView(this.mbp, null, false);
        this.mbs = new a(this.mController.xRr, this.mAppName, this.maM, this.jPV);
        this.mbs.maL = this;
        this.mbo.setAdapter(this.mbs);
        this.mbo.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ExdeviceProfileUI.A(ExdeviceProfileUI.this);
            }
        });
        this.mbm.jPV = this.jPV;
        this.mbt.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.f.a.e.b(ExdeviceProfileUI.this);
            }
        });
        mMPullDownView.ylo = false;
        this.mbn.setLayoutParams(new LayoutParams(com.tencent.mm.bu.a.eB(this), ((Integer) this.mbp.getTag()).intValue()));
        aFL();
        ad.aFa().a(this);
        as.CN().a(new i(this.jPV, bi.oM(this.mAppName), this.mbB), 0);
        try {
            this.gVQ = getResources().getDimensionPixelSize(R.f.buV);
            if (this.gVQ <= 0) {
                this.gVQ = 60;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.gVQ <= 0) {
                this.gVQ = 60;
            }
        } catch (Throwable th) {
            if (this.gVQ <= 0) {
                this.gVQ = 60;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", Integer.valueOf(this.gVQ));
        if (this.maM) {
            string = getString(R.l.edO);
        } else {
            dimensionPixelSize = R.l.edR;
            Object[] objArr = new Object[1];
            FY = this.jPV;
            int i = this.gVQ;
            CharSequence gw = com.tencent.mm.y.r.gw(FY);
            string = (!FY.equalsIgnoreCase(gw) || bi.oN(this.mbi)) ? com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xRr, gw) : com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xRr, this.mbi);
            x.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", Integer.valueOf(i), string, TextUtils.ellipsize(string, this.gu, (float) i, TruncateAt.END));
            objArr[0] = gw;
            string = com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, getString(dimensionPixelSize, objArr));
        }
        P(string);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceProfileUI.this.finish();
                return false;
            }
        });
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.jPV);
        if (q.FY().equals(this.jPV)) {
            com.tencent.mm.sdk.b.b qqVar = new qq();
            qqVar.fJc.action = 3;
            com.tencent.mm.sdk.b.a.xmy.a(qqVar, Looper.getMainLooper());
        }
    }

    private void aFI() {
        this.mby = ad.aET().aFf();
        if (this.mby != null) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", Integer.valueOf(this.mby.size()), this.mby.toString());
        } else {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (bi.cC(this.mby)) {
            this.maO = 0;
        } else {
            this.maO = this.mby.size();
        }
    }

    private void aFJ() {
        runOnUiThread(new Runnable() {
            public final void run() {
                a l = ExdeviceProfileUI.this.mbs;
                Object p = ExdeviceProfileUI.this.mby;
                List q = ExdeviceProfileUI.this.maR;
                l.maN = ad.aET().zG(l.jPV);
                l.maQ = p;
                if (bi.cC(p)) {
                    l.maO = 0;
                } else {
                    l.maO = p.size();
                }
                l.maR = q;
                if (!bi.cC(q)) {
                    l.maP = q.size();
                }
                x.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", Boolean.valueOf(l.maN), Integer.valueOf(l.maO), Integer.valueOf(l.maP), l.jPV);
                ExdeviceProfileUI.this.mbs.notifyDataSetChanged();
            }
        });
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        x.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        aFI();
        aFJ();
        if (!this.maM) {
            ad.aET().zG(this.jPV);
            aFK();
        }
    }

    private void aFK() {
        runOnUiThread(new Runnable() {
            public final void run() {
                ExdeviceProfileUI.g(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.mbs.notifyDataSetChanged();
            }
        });
    }

    protected void onDestroy() {
        this.mbK.dead();
        this.GO = true;
        super.onDestroy();
        ad.aFa().b(this);
    }

    private void aFL() {
        String FY = q.FY();
        if (this.mbt != null) {
            this.mbt.setVisibility(8);
        }
        if (!bi.oN(FY) && FY.equals(this.jPV)) {
            if (!(this.mbj == null || !bi.oN(this.mbj.field_championUrl) || this.mbt == null)) {
                this.mbt.setVisibility(0);
            }
            if (this.mbp != null) {
                this.mbp.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.sport.b.d.qq(18);
                        com.tencent.mm.plugin.exdevice.f.a.e.b(ExdeviceProfileUI.this);
                    }
                });
            }
        } else if (this.mbj != null && !bi.oN(this.mbj.field_championUrl) && this.mbp != null) {
            this.mbp.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ExdeviceProfileUI.B(ExdeviceProfileUI.this);
                }
            });
        }
    }

    private void aFM() {
        if (this.mbj == null) {
            this.mbn.setImageResource(R.e.brW);
            this.jvW = null;
        } else if (this.jvW == this.mbj.field_championUrl) {
        } else {
            if (this.jvW == null || !this.jvW.equals(this.mbj.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.mbn, this.mbj.field_championUrl, R.e.brW);
                this.jvW = this.mbj.field_championUrl;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.mAppName)) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        String cx = ac.cx(this);
                        if (str == null || str.length() == 0) {
                            x.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                            return;
                        }
                        ac.a((Context) this, str, cx, intent.getStringExtra("custom_send_text"), this.mbw);
                        h.bu(this.mController.xRr, getResources().getString(R.l.dGR));
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        Toast.makeText(this, R.l.ePw, 1).show();
                        return;
                    }
                    return;
                case 3:
                    if (i2 == -1) {
                        List F = bi.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.lYX != null) {
                                this.lYX.show();
                            }
                            as.CN().a(new g(F, this.mbH), 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dhc;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        if ("HardDeviceChampionInfo".equals(str) && this.jPV.equals(dVar.username)) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.mbj = ad.aEV().zI(this.jPV);
            runOnUiThread(new Runnable() {
                public final void run() {
                    ExdeviceProfileUI.this.aFL();
                    ExdeviceProfileUI.this.mbs.notifyDataSetChanged();
                    ExdeviceProfileUI.this.aFM();
                }
            });
        }
    }

    public final void aFN() {
        runOnUiThread(new Runnable() {
            public final void run() {
                if (ExdeviceProfileUI.this.lYX != null) {
                    ExdeviceProfileUI.this.lYX.show();
                }
            }
        });
        as.CN().a(new com.tencent.mm.plugin.exdevice.f.a.k(this.mbJ), 0);
    }

    public final void aFO() {
        com.tencent.mm.plugin.sport.b.d.qq(17);
        List arrayList = new ArrayList();
        arrayList.add(this.jPV);
        as.CN().a(new g(arrayList, this.mbE), 0);
    }

    private void t(long j, long j2) {
        List<com.tencent.mm.plugin.sport.b.e> D = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).D(j, j2);
        HashSet hashSet = new HashSet();
        List arrayList = new ArrayList();
        if (this.mbx != null) {
            for (com.tencent.mm.plugin.sport.b.e eVar : this.mbx) {
                if (hashSet.add(eVar.field_date)) {
                    arrayList.add(eVar);
                }
            }
        }
        for (com.tencent.mm.plugin.sport.b.e eVar2 : D) {
            if (hashSet.add(eVar2.field_date)) {
                arrayList.add(eVar2);
            }
        }
        Collections.sort(arrayList);
        this.mbx = arrayList;
        this.mbr.ce(this.mbx);
    }
}
