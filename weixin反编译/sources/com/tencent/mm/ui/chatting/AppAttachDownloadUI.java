package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.bb.m;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppAttachDownloadUI extends MMActivity implements e, a, j.a {
    private String fAJ;
    private boolean fCQ;
    private String fEK;
    private au fFE;
    private String fileName;
    private long frh;
    private String hda;
    private int hvd;
    private String iKK;
    private ProgressBar lFV;
    private f lFW;
    private Button mBI;
    private View mBM;
    private Button mNx;
    private String mediaId;
    private String nGW;
    private MMImageView pvT;
    private ImageView pvU;
    private ab vle;
    private TextView ycX;
    private View yxR;
    private TextView yxS;
    private TextView yxT;
    private boolean yxU;
    private g.a yxV;
    private boolean yxW = false;
    private boolean yxX = false;
    private boolean yxY = true;
    private int yxZ = 5000;
    private LinearLayout yya;
    private LinearLayout yyb;

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (z) {
            b diVar = new di();
            diVar.fsL.frh = appAttachDownloadUI.frh;
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            switch (appAttachDownloadUI.hvd) {
                case 0:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEP));
                    arrayList.add(appAttachDownloadUI.getString(R.l.dZn));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    if (diVar.fsM.fsk) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.dZr));
                        arrayList2.add(Integer.valueOf(4));
                        break;
                    }
                    break;
                case 6:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEP));
                    arrayList.add(appAttachDownloadUI.getString(R.l.dZn));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    Long RH = com.tencent.mm.pluginsdk.b.a.RH(appAttachDownloadUI.iKK);
                    if (diVar.fsM.fsk || (RH != null && com.tencent.mm.pluginsdk.model.app.g.m(appAttachDownloadUI.mController.xRr, RH.longValue()))) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.dZr));
                        arrayList2.add(Integer.valueOf(4));
                    }
                    if (d.Pu("favorite")) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.eAq));
                        arrayList2.add(Integer.valueOf(2));
                        break;
                    }
                    break;
                default:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEP));
                    arrayList2.add(Integer.valueOf(0));
                    break;
            }
        } else if (d.Pu("favorite")) {
            arrayList.add(appAttachDownloadUI.getString(R.l.eAq));
            arrayList2.add(Integer.valueOf(2));
        }
        if (com.tencent.mm.sdk.a.b.cfx()) {
            if (appAttachDownloadUI.fileName.startsWith("fts_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dZh));
                arrayList2.add(Integer.valueOf(5));
            } else if (appAttachDownloadUI.fileName.startsWith("was_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dZi));
                arrayList2.add(Integer.valueOf(6));
            }
            if (appAttachDownloadUI.fileName.startsWith("fts_feature") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dZg));
                arrayList2.add(Integer.valueOf(7));
            }
            if (appAttachDownloadUI.fileName.startsWith("wrd_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dZf));
                arrayList2.add(Integer.valueOf(8));
            }
        }
        h.a((Context) appAttachDownloadUI, null, arrayList, arrayList2, null, false, new h.d() {
            public final void cr(int i, int i2) {
                switch (i2) {
                    case 0:
                        AppAttachDownloadUI.c(AppAttachDownloadUI.this);
                        return;
                    case 2:
                        AppAttachDownloadUI.d(AppAttachDownloadUI.this);
                        return;
                    case 3:
                        AppAttachDownloadUI.e(AppAttachDownloadUI.this);
                        return;
                    case 4:
                        AppAttachDownloadUI.f(AppAttachDownloadUI.this);
                        return;
                    case 5:
                        AppAttachDownloadUI.g(AppAttachDownloadUI.this);
                        return;
                    case 6:
                        AppAttachDownloadUI.i(AppAttachDownloadUI.this);
                        return;
                    case 7:
                        AppAttachDownloadUI.h(AppAttachDownloadUI.this);
                        return;
                    case 8:
                        AppAttachDownloadUI.j(AppAttachDownloadUI.this);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void c(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z;
        if (appAttachDownloadUI.yxV != null) {
            z = appAttachDownloadUI.yxV.hcQ != 0 || appAttachDownloadUI.yxV.hcM > 26214400;
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[6];
            objArr[0] = appAttachDownloadUI.yxV.hcT;
            objArr[1] = Integer.valueOf(appAttachDownloadUI.yxV.hcQ == 1 ? 7 : 5);
            objArr[2] = Integer.valueOf(appAttachDownloadUI.yxV.hcM);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - appAttachDownloadUI.fFE.field_createTime) / 1000);
            objArr[5] = appAttachDownloadUI.iKK;
            gVar.h(14665, objArr);
        } else {
            z = false;
        }
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.fEK);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fFE.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void d(AppAttachDownloadUI appAttachDownloadUI) {
        cg cgVar = new cg();
        com.tencent.mm.pluginsdk.model.f.a(cgVar, appAttachDownloadUI.fFE);
        cgVar.frk.activity = appAttachDownloadUI;
        cgVar.frk.frr = 39;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        com.tencent.mm.plugin.report.service.g.pWK.h(11168, Integer.valueOf(6), Integer.valueOf(1));
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fFE.field_msgId);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        if (appAttachDownloadUI.crH() != null) {
            b ixVar = new ix();
            ixVar.fAr.fqg = 27;
            ixVar.fAr.fqh = 1;
            if (appAttachDownloadUI.crH() != null) {
                ixVar.fAr.filePath = appAttachDownloadUI.crH().field_fileFullPath;
            }
            com.tencent.mm.sdk.b.a.xmy.m(ixVar);
            u.makeText(ad.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(0))}), 1).show();
        }
    }

    static /* synthetic */ void h(AppAttachDownloadUI appAttachDownloadUI) {
        b bcVar = new bc();
        bcVar.fqf.fqg = 35;
        bcVar.fqf.fqh = 1;
        if (appAttachDownloadUI.crH() != null) {
            bcVar.fqf.filePath = appAttachDownloadUI.crH().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xmy.m(bcVar);
        u.makeText(ad.getContext(), String.format("apply success", new Object[0]), 1).show();
    }

    static /* synthetic */ void i(AppAttachDownloadUI appAttachDownloadUI) {
        b ixVar = new ix();
        ixVar.fAr.fqg = 40;
        ixVar.fAr.fqh = 1;
        if (appAttachDownloadUI.crH() != null) {
            ixVar.fAr.filePath = appAttachDownloadUI.crH().field_fileFullPath;
            ixVar.fAr.filePath = appAttachDownloadUI.crH().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xmy.m(ixVar);
        u.makeText(ad.getContext(), String.format("current wxa template is %d", new Object[]{Integer.valueOf(m.Rp())}), 1).show();
    }

    static /* synthetic */ void j(AppAttachDownloadUI appAttachDownloadUI) {
        b ixVar = new ix();
        ixVar.fAr.fqg = 27;
        ixVar.fAr.fqh = 2;
        if (appAttachDownloadUI.crH() != null) {
            ixVar.fAr.filePath = appAttachDownloadUI.crH().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xmy.m(ixVar);
        u.makeText(ad.getContext(), String.format("current browse template is %d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(1))}), 1).show();
    }

    static /* synthetic */ void u(AppAttachDownloadUI appAttachDownloadUI) {
        com.tencent.mm.pluginsdk.model.app.b crH = appAttachDownloadUI.crH();
        if (crH == null) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
        } else if (crH.field_fileFullPath == null || crH.field_fileFullPath.length() == 0) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.b(appAttachDownloadUI, crH.field_fileFullPath, appAttachDownloadUI.iKK, 1);
            appAttachDownloadUI.mBI.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        boolean z;
        setMMTitle(R.l.ccU);
        this.frh = getIntent().getLongExtra("app_msg_id", -1);
        if (this.frh == -1) {
            z = false;
        } else {
            as.Hm();
            this.fFE = c.Fh().dI(this.frh);
            if (this.fFE == null || this.fFE.field_msgId == 0 || this.fFE.field_content == null) {
                z = false;
            } else {
                this.yxU = s.eX(this.fFE.field_talker);
                this.fEK = this.fFE.field_content;
                if (this.yxU && this.fFE.field_isSend == 0) {
                    String str = this.fFE.field_content;
                    if (this.yxU && str != null) {
                        str = bb.hT(str);
                    }
                    this.fEK = str;
                }
                this.yxV = g.a.fV(this.fEK);
                if (this.yxV == null) {
                    x.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", this.fEK);
                    z = false;
                } else {
                    if (t.oN(this.yxV.for) && !t.oN(this.yxV.hcT)) {
                        x.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", this.fEK);
                        this.yxV.for = this.yxV.hcT.hashCode();
                    }
                    this.hvd = this.yxV.type;
                    this.mediaId = this.yxV.for;
                    this.fileName = t.oM(this.yxV.title);
                    this.iKK = t.oM(this.yxV.hcN).toLowerCase();
                    this.nGW = t.oM(this.yxV.filemd5);
                    this.fAJ = t.oM(this.yxV.fAJ);
                    this.hda = t.oM(this.yxV.hda);
                    x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", Long.valueOf(this.frh), Integer.valueOf(this.fFE.field_isSend), this.fEK, Integer.valueOf(this.hvd), this.mediaId, this.fileName);
                    com.tencent.mm.pluginsdk.model.app.b crH = crH();
                    if (crH == null) {
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
                        this.yxX = false;
                    } else {
                        File file = new File(crH.field_fileFullPath);
                        if (crH.field_offset > 0) {
                            this.yxX = true;
                        } else {
                            this.yxX = false;
                        }
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", crH.field_fileFullPath, Long.valueOf(crH.field_offset), Boolean.valueOf(this.yxX));
                    }
                    z = a(crH) ? com.tencent.mm.pluginsdk.ui.tools.a.a(this, crH.field_fileFullPath, this.iKK, 1) : true;
                }
            }
        }
        if (z) {
            File file2 = new File(com.tencent.mm.compatible.util.e.gJd);
            if (!file2.exists()) {
                file2.mkdir();
            }
            an.aqK().c(this);
            initView();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        an.aqK().j(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(221, (e) this);
        as.CN().a(728, (e) this);
        b lnVar = new ln();
        lnVar.fDI.fDJ = true;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.mBI.setEnabled(true);
    }

    protected void onPause() {
        as.CN().b(221, (e) this);
        as.CN().b(728, (e) this);
        super.onPause();
        b lnVar = new ln();
        lnVar.fDI.fDJ = false;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void initView() {
        this.pvT = (MMImageView) findViewById(R.h.ccV);
        this.mBM = findViewById(R.h.ccM);
        this.lFV = (ProgressBar) findViewById(R.h.ccL);
        this.pvU = (ImageView) findViewById(R.h.ccQ);
        this.mNx = (Button) findViewById(R.h.ccA);
        this.mBI = (Button) findViewById(R.h.ccK);
        this.yxR = findViewById(R.h.ccB);
        this.ycX = (TextView) findViewById(R.h.ccH);
        this.yxS = (TextView) findViewById(R.h.ccC);
        this.yxT = (TextView) findViewById(R.h.ccG);
        this.yya = (LinearLayout) findViewById(R.h.ccI);
        this.yyb = (LinearLayout) findViewById(R.h.ctr);
        this.pvU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppAttachDownloadUI.this.mBM.setVisibility(8);
                AppAttachDownloadUI.this.mNx.setVisibility(0);
                AppAttachDownloadUI.this.yxR.setVisibility(8);
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn downloadAppAttachScene[%s]", AppAttachDownloadUI.this.vle);
                if (AppAttachDownloadUI.this.vle != null) {
                    ab a = AppAttachDownloadUI.this.vle;
                    a aVar = AppAttachDownloadUI.this;
                    if (!a.vls) {
                        com.tencent.mm.modelcdntran.g.MP().kL(a.hCY);
                        a.vlm = an.aqK().Se(a.mediaId);
                    }
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", aVar, a.vlm, Boolean.valueOf(a.vls), bi.chl());
                    if (a.vlm != null) {
                        if (a.vlm.field_status == 101 && aVar != null) {
                            aVar.bZB();
                        }
                        a.vlm.field_status = 102;
                        if (!a.vls) {
                            an.aqK().c(a.vlm, new String[0]);
                        }
                    }
                    com.tencent.mm.kernel.g.CN().c(AppAttachDownloadUI.this.vle);
                    return;
                }
                com.tencent.mm.sdk.e.c o = AppAttachDownloadUI.this.crH();
                if (o != null && o.field_status != 199) {
                    x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn onClick but scene is null and set status[%d] paused", Long.valueOf(o.field_status));
                    o.field_status = 102;
                    an.aqK().c(o, new String[0]);
                }
            }
        });
        this.mNx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppAttachDownloadUI.this.mBM.setVisibility(0);
                AppAttachDownloadUI.this.mNx.setVisibility(8);
                AppAttachDownloadUI.this.yxR.setVisibility(0);
                if (AppAttachDownloadUI.this.crG()) {
                    com.tencent.mm.sdk.e.c o = AppAttachDownloadUI.this.crH();
                    if (o != null) {
                        o.field_status = 101;
                        o.field_lastModifyTime = bi.Wx();
                        an.aqK().c(o, new String[0]);
                    }
                    AppAttachDownloadUI.this.vle = new ab(AppAttachDownloadUI.this.frh, AppAttachDownloadUI.this.mediaId, AppAttachDownloadUI.this.lFW);
                    as.CN().a(AppAttachDownloadUI.this.vle, 0);
                }
            }
        });
        this.mBI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppAttachDownloadUI.this.yxY = true;
                AppAttachDownloadUI.u(AppAttachDownloadUI.this);
            }
        });
        switch (this.hvd) {
            case 0:
            case 7:
                if (!bi.WC(this.iKK)) {
                    this.pvT.setImageResource(R.k.dvI);
                    break;
                } else {
                    this.pvT.setImageResource(R.g.byW);
                    break;
                }
            case 2:
                this.pvT.setImageResource(R.g.byW);
                break;
            case 4:
                this.pvT.setImageResource(R.k.dvL);
                break;
            case 6:
                this.pvT.setImageResource(r.Sd(this.iKK));
                break;
            default:
                this.pvT.setImageResource(R.k.dvI);
                break;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (AppAttachDownloadUI.this.vle != null) {
                    as.CN().c(AppAttachDownloadUI.this.vle);
                }
                AppAttachDownloadUI.this.finish();
                return true;
            }
        });
        this.fCQ = getIntent().getBooleanExtra("app_show_share", true);
        if (this.fCQ) {
            addIconOptionMenu(0, R.k.dvj, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.this.yxW);
                    return false;
                }
            });
        }
        this.yxW = false;
        com.tencent.mm.pluginsdk.model.app.b crH = crH();
        boolean z = (crH == null || !new File(crH.field_fileFullPath).exists()) ? false : crH.aPj() || (this.fFE.field_isSend == 1 && crH.field_isUpload);
        if (z) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            this.yxW = true;
            crI();
        } else if (crH != null && crH.aPj() && !new File(crH.field_fileFullPath).exists()) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp set fail info[%s]", crH);
            this.yya.setVisibility(8);
            this.yyb.setVisibility(0);
        } else if (!this.yxW) {
            this.lFW = new f() {
                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    if (i < i2 && AppAttachDownloadUI.this.mBM.getVisibility() != 0) {
                        AppAttachDownloadUI.this.mBM.setVisibility(0);
                        AppAttachDownloadUI.this.mNx.setVisibility(8);
                        AppAttachDownloadUI.this.yxR.setVisibility(0);
                    }
                    AppAttachDownloadUI.this.lFV.setProgress((int) f);
                }
            };
            switch (this.hvd) {
                case 0:
                case 6:
                    if (this.yxX) {
                        this.mNx.setVisibility(0);
                    } else {
                        this.mNx.setVisibility(8);
                    }
                    this.mBM.setVisibility(8);
                    this.yxR.setVisibility(8);
                    this.mBI.setVisibility(8);
                    this.ycX.setVisibility(8);
                    this.yxT.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.yxT.setText(getString(R.l.ezX));
                    } else {
                        this.yxT.setText(this.fileName);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals("")) {
                        this.ycX.setText(getString(R.l.dZj));
                    } else {
                        this.ycX.setText(getString(R.l.dZk));
                    }
                    if (bi.WC(this.iKK)) {
                        this.ycX.setVisibility(8);
                        break;
                    }
                    break;
                case 2:
                    this.mBM.setVisibility(8);
                    this.yxR.setVisibility(8);
                    if (this.yxX) {
                        this.mNx.setVisibility(0);
                    } else {
                        this.mNx.setVisibility(8);
                    }
                    this.mBI.setVisibility(8);
                    this.yxT.setVisibility(8);
                    this.ycX.setVisibility(8);
                    break;
                case 7:
                    if (this.yxX) {
                        this.mNx.setVisibility(0);
                    } else {
                        this.mNx.setVisibility(8);
                    }
                    this.mBM.setVisibility(8);
                    this.yxR.setVisibility(8);
                    this.mBI.setVisibility(8);
                    this.yxT.setVisibility(8);
                    this.ycX.setVisibility(8);
                    this.ycX.setText(getString(R.l.dZk));
                    break;
            }
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", this.lFW, Boolean.valueOf(this.yxW), Boolean.valueOf(this.yxX));
            if (this.hvd == 2 || !(this.yxW || this.yxX)) {
                this.mBM.setVisibility(0);
                this.mNx.setVisibility(8);
                this.yxR.setVisibility(0);
                if (crG()) {
                    this.vle = new ab(this.frh, this.mediaId, this.lFW);
                    as.CN().a(this.vle, 0);
                    aj.t(this.fFE);
                }
            }
        }
    }

    private boolean crG() {
        com.tencent.mm.pluginsdk.model.app.b bVar;
        boolean z;
        int i = -1;
        com.tencent.mm.pluginsdk.model.app.b crH = crH();
        String str;
        if (crH == null) {
            l.c(this.frh, this.fEK, null);
            crH = crH();
            if (crH != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(crH.xrR);
                objArr[1] = Long.valueOf(crH.field_totalLen);
                objArr[2] = crH.field_fileFullPath;
                objArr[3] = Long.valueOf(crH.field_type);
                objArr[4] = crH.field_mediaId;
                objArr[5] = Long.valueOf(crH.field_msgInfoId);
                objArr[6] = Boolean.valueOf(crH.field_isUpload);
                if (crH.field_signature != null) {
                    i = crH.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                x.i(str2, str, objArr);
                if (this.yxV.hcQ != 0 || this.yxV.hcM > 26214400) {
                    boolean z2;
                    if (t.oN(crH.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    bVar = crH;
                    z = z2;
                }
            }
            z = true;
            bVar = crH;
        } else {
            File file = new File(crH.field_fileFullPath);
            if (crH.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                l.c(this.frh, this.fEK, null);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(crH.xrR);
            objArr2[1] = Long.valueOf(crH.field_totalLen);
            objArr2[2] = crH.field_fileFullPath;
            objArr2[3] = Long.valueOf(crH.field_type);
            objArr2[4] = crH.field_mediaId;
            objArr2[5] = Long.valueOf(crH.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(crH.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(crH.field_status);
            if (crH.field_signature != null) {
                i = crH.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            x.i(str, str3, objArr2);
            z = true;
            bVar = crH;
        }
        if (!z) {
            as.CN().a(new y(bVar, this.hda, this.nGW, this.fileName, this.iKK, this.fAJ), 0);
        }
        return z;
    }

    private String getMimeType() {
        g.a fV = g.a.fV(this.fEK);
        String str = null;
        if (fV.hcN != null && fV.hcN.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fV.hcN);
        }
        if (str != null && str.length() != 0) {
            return str;
        }
        x.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + fV.hcN;
    }

    private com.tencent.mm.pluginsdk.model.app.b crH() {
        com.tencent.mm.pluginsdk.model.app.b fp = an.aqK().fp(this.frh);
        if (fp != null) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", Long.valueOf(this.frh), t.WB());
        } else {
            fp = l.Sn(this.mediaId);
            if (fp == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", t.WB());
            } else if (!(fp.field_msgInfoId == this.frh || com.tencent.mm.a.e.bO(fp.field_fileFullPath))) {
                l.c(this.frh, this.fEK, null);
                final com.tencent.mm.pluginsdk.model.app.b fp2 = an.aqK().fp(this.frh);
                if (fp2 == null) {
                    x.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", t.WB());
                } else {
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            boolean c;
                            long currentTimeMillis = System.currentTimeMillis();
                            long x = com.tencent.mm.a.e.x(fp.field_fileFullPath, fp2.field_fileFullPath);
                            if (x > 0) {
                                fp2.field_offset = x;
                                if (AppAttachDownloadUI.a(fp2)) {
                                    fp2.field_status = 199;
                                }
                                c = an.aqK().c(fp2, new String[0]);
                            } else {
                                c = false;
                            }
                            x.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", Long.valueOf(x), Long.valueOf(fp.field_msgInfoId), Long.valueOf(fp2.field_msgInfoId), Boolean.valueOf(c), Long.valueOf(fp2.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        }
                    }, "copyAttachFromLocal");
                }
            }
        }
        return fp;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.yxY, R.l.dZp, R.l.dZq, 1);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b crH = crH();
        if (crH != null) {
            long j = crH.field_totalLen;
            this.yxS.setText(getString(R.l.dZl, new Object[]{t.by(crH.field_offset), t.by(j)}));
            int i = crH.field_totalLen == 0 ? 0 : (int) ((crH.field_offset * 100) / crH.field_totalLen);
            x.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + r4 + " totallen:" + j);
            this.lFV.setProgress(i);
            if (crH.field_status == 199 && i >= 100 && !this.yxW) {
                this.yxW = true;
                if (crH != null) {
                    Toast.makeText(this, getString(R.l.dZu) + " : " + crH.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.bnD, com.tencent.mm.compatible.util.e.gJc), this.yxZ).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.a(this, crH.field_fileFullPath, this.iKK, 1);
                }
                ah.h(new Runnable() {
                    public final void run() {
                        AppAttachDownloadUI.this.crI();
                    }
                }, 200);
            }
            if (this.mBM.getVisibility() != 0 && i < 100 && !crH.field_isUpload && crH.field_status == 101) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", Integer.valueOf(i));
                this.mBM.setVisibility(0);
                this.mNx.setVisibility(8);
                this.yxR.setVisibility(0);
            }
        }
    }

    private void crI() {
        Intent intent;
        switch (this.hvd) {
            case 0:
            case 6:
                if (!crJ()) {
                    return;
                }
                if (bi.WC(this.iKK)) {
                    com.tencent.mm.pluginsdk.model.app.b crH = crH();
                    Intent intent2 = new Intent(this, ShowImageUI.class);
                    intent2.putExtra("key_message_id", this.fFE.field_msgId);
                    intent2.putExtra("key_image_path", crH.field_fileFullPath);
                    intent2.putExtra("key_favorite", true);
                    startActivity(intent2);
                    finish();
                    return;
                }
                String mimeType = getMimeType();
                this.ycX.setVisibility(0);
                this.mBM.setVisibility(8);
                this.yxR.setVisibility(8);
                this.mNx.setVisibility(8);
                this.yxT.setVisibility(0);
                if (this.fileName.equals("")) {
                    this.yxT.setText(getString(R.l.ezX));
                } else {
                    this.yxT.setText(this.fileName);
                }
                if (mimeType == null || mimeType.equals("")) {
                    this.mBI.setVisibility(8);
                    this.ycX.setText(getString(R.l.dZj));
                    return;
                }
                this.mBI.setVisibility(0);
                this.ycX.setText(getString(R.l.dZk));
                return;
            case 2:
                if (crJ()) {
                    intent = new Intent(this, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", this.fFE.field_msgId);
                    intent.putExtra("img_gallery_talker", this.fFE.field_talker);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("App_MsgId", this.frh);
                setResult(-1, intent);
                finish();
                return;
            default:
                this.mBI.setVisibility(0);
                this.mBM.setVisibility(8);
                this.yxR.setVisibility(8);
                return;
        }
    }

    private boolean crJ() {
        com.tencent.mm.pluginsdk.model.app.b crH = crH();
        if (crH == null) {
            return true;
        }
        if (com.tencent.mm.a.e.bO(crH.field_fileFullPath)) {
            this.mBM.setVisibility(8);
            this.yxR.setVisibility(8);
            this.mNx.setVisibility(8);
            return true;
        }
        this.yya.setVisibility(8);
        this.yyb.setVisibility(0);
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dfD;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() != 221 && kVar.getType() != 728) {
            return;
        }
        if (kVar.getType() == 728 && i == 0 && i2 == 0) {
            com.tencent.mm.pluginsdk.model.app.b crH = crH();
            if (crH == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(crH.field_signature == null ? -1 : crH.field_signature.length());
                x.i(str2, str3, objArr);
            }
            this.vle = new ab(this.frh, this.mediaId, this.lFW);
            as.CN().a(this.vle, 0);
            return;
        }
        if (this.vle == null && (kVar instanceof ab)) {
            ab abVar = (ab) kVar;
            com.tencent.mm.pluginsdk.model.app.b crH2 = crH();
            if (!(crH2 == null || t.oN(crH2.field_mediaSvrId) || !crH2.field_mediaSvrId.equals(abVar.getMediaId()))) {
                this.vle = abVar;
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", this.vle, crH2.field_mediaSvrId);
            }
        }
        com.tencent.mm.plugin.report.service.g gVar;
        Object[] objArr2;
        if (i == 0 && i2 == 0) {
            gVar = com.tencent.mm.plugin.report.service.g.pWK;
            objArr2 = new Object[6];
            objArr2[0] = this.yxV.hcT;
            objArr2[1] = Integer.valueOf(this.yxV.hcQ == 1 ? 7 : 5);
            objArr2[2] = Integer.valueOf(this.yxV.hcM);
            objArr2[3] = Integer.valueOf(0);
            objArr2[4] = Integer.valueOf(0);
            objArr2[5] = this.iKK;
            gVar.h(14665, objArr2);
            return;
        }
        if (i2 != 0 && com.tencent.mm.sdk.a.b.cfx()) {
            Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
        }
        if (i2 == -5103059) {
            this.yyb.setVisibility(0);
            this.yya.setVisibility(8);
            if (this.hvd == 6) {
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr2 = new Object[6];
                objArr2[0] = this.yxV.hcT;
                objArr2[1] = Integer.valueOf(this.yxV.hcQ == 1 ? 7 : 5);
                objArr2[2] = Integer.valueOf(this.yxV.hcM);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = Integer.valueOf(0);
                objArr2[5] = this.iKK;
                gVar.h(14665, objArr2);
                return;
            }
            return;
        }
        this.mBM.setVisibility(8);
        this.mNx.setVisibility(0);
        this.yxR.setVisibility(8);
        x.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + kVar.getType() + " errType = " + i + ", errCode = " + i2);
    }

    public final void bZB() {
        Toast.makeText(this, R.l.dZs, 0).show();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private static boolean a(com.tencent.mm.pluginsdk.model.app.b bVar) {
        if (bVar == null) {
            return false;
        }
        File file = new File(bVar.field_fileFullPath);
        if (file.exists() && file.length() == bVar.field_totalLen) {
            return true;
        }
        return false;
    }
}
