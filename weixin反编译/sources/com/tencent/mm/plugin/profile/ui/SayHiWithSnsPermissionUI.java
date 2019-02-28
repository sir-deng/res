package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.be.f;
import com.tencent.mm.be.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.qd;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkUpdater;

public class SayHiWithSnsPermissionUI extends MMActivity implements e {
    private String bgo;
    private String bgp;
    private String chatroomName;
    private ProgressDialog inI = null;
    private String nVw;
    private String oTD;
    private int[] ofG = new int[8];
    private int pnn;
    private EditText pqH;
    private EditText pqI;
    private View pqJ;
    private TextView pqK;
    private MMSwitchBtn pqL;
    private boolean pqM;
    private boolean pqN;
    private boolean pqO;
    private TextView pqP;
    private MMTagPanel pqQ;
    private List<String> pqR;
    private b pqS = new b() {
        public final void a(int i, m mVar, Object obj) {
            SayHiWithSnsPermissionUI.this.bkt();
        }
    };
    private CharSequence pqT = null;
    private String userName;

    private class a extends ClickableSpan {
        public String iLo;

        public a(String str) {
            this.iLo = str;
        }

        public final void onClick(View view) {
            SayHiWithSnsPermissionUI.this.pqI.setText(i.b(SayHiWithSnsPermissionUI.this, bi.oM(this.iLo), SayHiWithSnsPermissionUI.this.pqI.getTextSize()));
            SayHiWithSnsPermissionUI.this.pqI.setSelection(SayHiWithSnsPermissionUI.this.pqI.getText().length());
            SayHiWithSnsPermissionUI.this.pqJ.setVisibility(8);
            SayHiWithSnsPermissionUI.this.ofG[4] = 1;
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(R.e.brA));
            textPaint.setUnderlineText(false);
        }
    }

    static /* synthetic */ void c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.nVw);
        if (sayHiWithSnsPermissionUI.pqR != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.pqR);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        d.b(sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
    }

    static /* synthetic */ String g(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        String trim = sayHiWithSnsPermissionUI.pqH.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dre;
    }

    protected void onResume() {
        if (this.pqO) {
            as.Hm();
            c.Ff().a(this.pqS);
            bkt();
        }
        as.CN().a(30, (e) this);
        as.CN().a((int) g.CTRL_INDEX, (e) this);
        as.CN().a(853, (e) this);
        super.onResume();
    }

    public void onStop() {
        as.CN().b(30, (e) this);
        as.CN().b((int) g.CTRL_INDEX, (e) this);
        as.CN().b(853, (e) this);
        if (this.pqO) {
            as.Hm();
            c.Ff().b(this.pqS);
        }
        super.onStop();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.report.service.g.pWK.h(14036, Integer.valueOf(this.ofG[0]), Integer.valueOf(this.ofG[1]), Integer.valueOf(this.ofG[2]), Integer.valueOf(this.ofG[3]), Integer.valueOf(this.ofG[4]), Integer.valueOf(this.ofG[5]), Integer.valueOf(this.ofG[6]), Integer.valueOf(this.ofG[7]));
        super.onDestroy();
    }

    protected final void initView() {
        String str;
        String string;
        this.pqL = (MMSwitchBtn) findViewById(R.h.cAJ).findViewById(R.h.checkbox);
        this.pqL.nJ(false);
        this.pqM = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.pqN = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.pqO = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.pnn = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.bgp = getIntent().getStringExtra("Contact_RemarkName");
        this.bgo = getIntent().getStringExtra("Contact_Nick");
        this.oTD = getIntent().getStringExtra("Contact_RoomNickname");
        this.pqJ = findViewById(R.h.cxb);
        this.pqK = (TextView) findViewById(R.h.cxc);
        setMMTitle(getString(R.l.app_name));
        if (x.Xg(this.userName)) {
            View findViewById = findViewById(R.h.cAK);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        if (this.pqM) {
            setMMTitle(getString(R.l.eKt));
            this.pqH = (EditText) findViewById(R.h.cIN);
            this.pqH.setMinHeight(this.mController.xRr.getResources().getDimensionPixelSize(R.f.bvB));
            com.tencent.mm.ui.tools.a.c.d(this.pqH).Hg(100).a(null);
            this.pqH.setFilters(h.vEv);
            ((LinearLayout) this.pqH.getParent()).setVisibility(0);
            as.Hm();
            str = (String) c.Db().get(294913, null);
            String Ga = q.Ga();
            if (Ga == null) {
                Ga = "";
            }
            string = getString(R.l.eKn);
            if (string.length() + Ga.length() > 50) {
                Ga = Ga.substring(0, 50 - string.length());
            }
            this.pqT = i.b(this.mController.xRr, String.format(string, new Object[]{Ga}), this.pqH.getTextSize());
            if (bi.oN(str)) {
                this.pqH.setText(this.pqT);
            } else {
                this.pqH.setText(i.b(this.mController.xRr, str, this.pqH.getTextSize()));
            }
            this.pqH.requestFocus();
            this.pqH.postDelayed(new Runnable() {
                public final void run() {
                    SayHiWithSnsPermissionUI.this.showVKB();
                }
            }, 100);
        }
        if (this.pqN) {
            this.pqI = (EditText) findViewById(R.h.cIQ);
            ((LinearLayout) this.pqI.getParent()).setVisibility(0);
            if (!this.pqM) {
                this.pqI.clearFocus();
            }
            this.pqI.setMinHeight(this.mController.xRr.getResources().getDimensionPixelSize(R.f.bvB));
            com.tencent.mm.ui.tools.a.c.d(this.pqI).Hg(100).a(null);
            this.pqI.setFilters(h.vEv);
            if (!this.pqM) {
                this.ofG[0] = 1;
                setMMTitle(getString(R.l.dXK));
                LayoutParams layoutParams = (LayoutParams) ((View) this.pqI.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (bi.oN(this.bgp)) {
                CharSequence jVar;
                if (!bi.oN(this.bgo)) {
                    this.pqI.setHint(i.b(this.mController.xRr, this.bgo, this.pqI.getTextSize()));
                    this.pqI.setOnFocusChangeListener(new OnFocusChangeListener() {
                        public final void onFocusChange(View view, boolean z) {
                            if (z && !bi.N(SayHiWithSnsPermissionUI.this.pqI.getHint()) && bi.N(SayHiWithSnsPermissionUI.this.pqI.getText())) {
                                SayHiWithSnsPermissionUI.this.pqI.setText(SayHiWithSnsPermissionUI.this.pqI.getHint());
                                SayHiWithSnsPermissionUI.this.pqI.setOnFocusChangeListener(null);
                                SayHiWithSnsPermissionUI.this.pqI.setHint(null);
                            }
                        }
                    });
                }
                boolean z;
                switch (this.pnn) {
                    case 8:
                    case 14:
                        if (!bi.oN(this.oTD) && !this.oTD.equals(this.pqI.getText().toString())) {
                            this.pqJ.setVisibility(0);
                            this.pqK.setText(i.b(this, bi.oM(getString(R.l.dWE, new Object[]{this.oTD})), this.pqK.getTextSize()));
                            CharSequence jVar2 = new j(getString(R.l.eYg));
                            jVar2.setSpan(new a(this.oTD), 0, jVar2.length(), 17);
                            this.pqK.append(" ");
                            this.pqK.append(jVar2);
                            this.pqK.setMovementMethod(LinkMovementMethod.getInstance());
                            this.ofG[3] = 2;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                    case 11:
                    case 13:
                        com.tencent.mm.modelfriend.b kU = af.OJ().kU(this.userName);
                        if (kU != null && !bi.oN(kU.Nz()) && !kU.Nz().equals(this.pqI.getText().toString())) {
                            this.pqJ.setVisibility(0);
                            this.pqK.setText(i.b(this, bi.oM(getString(R.l.dWF, new Object[]{kU.Nz()})), this.pqK.getTextSize()));
                            jVar = new j(getString(R.l.eYg));
                            jVar.setSpan(new a(kU.Nz()), 0, jVar.length(), 17);
                            this.pqK.append(" ");
                            this.pqK.append(jVar);
                            this.pqK.setMovementMethod(LinkMovementMethod.getInstance());
                            this.ofG[3] = 1;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (!(this.pqM || z)) {
                    f nb = l.TD().nb(this.userName);
                    if (nb != null) {
                        com.tencent.mm.pluginsdk.ui.preference.b a = com.tencent.mm.pluginsdk.ui.preference.b.a((Context) this, nb);
                        if (!(bi.oN(a.hfQ) || a.hfQ.equals(getString(R.l.eit)))) {
                            string = getString(R.l.eKn).substring(0, getString(R.l.eKn).indexOf("%s"));
                            str = a.hfQ;
                            if (a.hfQ.startsWith(string)) {
                                str = a.hfQ.substring(string.length());
                            }
                            this.pqJ.setVisibility(0);
                            this.pqK.setText(i.b(this, bi.oM(getString(R.l.dWG, new Object[]{a.hfQ})), this.pqK.getTextSize()));
                            jVar = new j(getString(R.l.eYg));
                            jVar.setSpan(new a(str), 0, jVar.length(), 17);
                            this.pqK.append(" ");
                            this.pqK.append(jVar);
                            this.pqK.setMovementMethod(LinkMovementMethod.getInstance());
                            this.ofG[3] = 3;
                        }
                    }
                }
            } else {
                this.pqI.setText(i.b(this.mController.xRr, this.bgp, this.pqI.getTextSize()));
                this.ofG[6] = 1;
            }
        }
        if (x.Xg(this.userName)) {
            this.pqO = false;
        }
        if (this.pqO) {
            this.pqP = (TextView) findViewById(R.h.cwX);
            this.pqQ = (MMTagPanel) findViewById(R.h.bYk);
            this.pqQ.niO = false;
            ((LinearLayout) ((FrameLayout) this.pqQ.getParent()).getParent()).setVisibility(0);
            this.pqP.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this);
                }
            });
            this.pqQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this);
                }
            });
        }
        bkt();
        if (!bi.oN(this.nVw)) {
            this.ofG[7] = 1;
        }
        str = getString(R.l.dGL);
        if (!this.pqM) {
            str = getString(R.l.dFw);
        }
        a(0, str, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                final k fVar;
                SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI;
                Context context;
                if (SayHiWithSnsPermissionUI.this.pqM) {
                    int i;
                    List linkedList = new LinkedList();
                    linkedList.add(SayHiWithSnsPermissionUI.this.userName);
                    List linkedList2 = new LinkedList();
                    linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.this.pnn));
                    String g = SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this);
                    Map hashMap = new HashMap();
                    if (SayHiWithSnsPermissionUI.this.pqL.zEk) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    hashMap.put(SayHiWithSnsPermissionUI.this.userName, Integer.valueOf(i));
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", Integer.valueOf(i));
                    if (x.Xg(SayHiWithSnsPermissionUI.this.userName)) {
                        fVar = new com.tencent.mm.openim.b.f(SayHiWithSnsPermissionUI.this.userName, g, SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(com.tencent.mm.ui.e.a.xML));
                        as.CN().a(fVar, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.xRr;
                        SayHiWithSnsPermissionUI.this.getString(R.l.dGZ);
                        sayHiWithSnsPermissionUI.inI = com.tencent.mm.ui.base.h.a(context, SayHiWithSnsPermissionUI.this.getString(R.l.eKs), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(fVar);
                            }
                        });
                    } else {
                        final k oVar = new o(2, linkedList, linkedList2, g, "", hashMap, SayHiWithSnsPermissionUI.this.chatroomName);
                        String stringExtra = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                        String stringExtra2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                        if (!bi.oN(stringExtra)) {
                            oVar.fj(stringExtra, stringExtra2);
                        }
                        as.CN().a(oVar, 0);
                        SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.xRr;
                        SayHiWithSnsPermissionUI.this.getString(R.l.dGZ);
                        sayHiWithSnsPermissionUI2.inI = com.tencent.mm.ui.base.h.a(context, SayHiWithSnsPermissionUI.this.getString(R.l.eKs), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(oVar);
                            }
                        });
                    }
                } else if (SayHiWithSnsPermissionUI.this.pqN) {
                    String stringExtra3 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
                    if (x.Xg(SayHiWithSnsPermissionUI.this.userName)) {
                        fVar = new com.tencent.mm.openim.b.g(SayHiWithSnsPermissionUI.this.userName, stringExtra3);
                        as.CN().a(fVar, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.xRr;
                        SayHiWithSnsPermissionUI.this.getString(R.l.dGZ);
                        sayHiWithSnsPermissionUI.inI = com.tencent.mm.ui.base.h.a(context, SayHiWithSnsPermissionUI.this.getString(R.l.dUY), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(fVar);
                            }
                        });
                    } else {
                        fVar = new o(SayHiWithSnsPermissionUI.this.userName, stringExtra3, SayHiWithSnsPermissionUI.this.pnn);
                        as.CN().a(fVar, 0);
                        sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                        context = SayHiWithSnsPermissionUI.this.mController.xRr;
                        SayHiWithSnsPermissionUI.this.getString(R.l.dGZ);
                        sayHiWithSnsPermissionUI.inI = com.tencent.mm.ui.base.h.a(context, SayHiWithSnsPermissionUI.this.getString(R.l.dUY), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(fVar);
                            }
                        });
                    }
                }
                return false;
            }
        }, p.b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (SayHiWithSnsPermissionUI.this.pqN) {
                    SayHiWithSnsPermissionUI.this.ofG[1] = 1;
                }
                SayHiWithSnsPermissionUI.this.finish();
                return true;
            }
        });
    }

    private void bkt() {
        as.Hm();
        bf FF = c.Fg().FF(this.userName);
        if (FF != null) {
            this.nVw = FF.field_contactLabels;
            this.pqR = (ArrayList) com.tencent.mm.plugin.label.a.a.aVD().DV(this.nVw);
        }
        if (!this.pqO) {
            return;
        }
        if (bi.oN(this.nVw)) {
            this.pqQ.setVisibility(4);
            this.pqP.setVisibility(0);
            return;
        }
        this.pqQ.setVisibility(0);
        this.pqP.setVisibility(4);
        this.pqQ.a(this.pqR, this.pqR);
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (this.pqM) {
                String trim = this.pqH.getText().toString().trim();
                if (bi.oN(trim) || trim.equals(this.pqT)) {
                    as.Hm();
                    c.Db().set(294913, "");
                } else {
                    as.Hm();
                    c.Db().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, R.l.eix, 0).show();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, R.l.eKq, 0).show();
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bu(this, getString(R.l.eKr));
                if (this.pqN) {
                    int i3;
                    String str2 = "";
                    if (this.pqI.getText() != null) {
                        str2 = this.pqI.getText().toString();
                    }
                    if (!bi.oN(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!bi.oN(str2)) {
                        as.Hm();
                        x Xv = c.Ff().Xv(this.userName);
                        Xv.da(str2);
                        as.Hm();
                        com.tencent.mm.sdk.e.c FF = c.Fg().FF(this.userName);
                        FF.field_encryptUsername = this.userName;
                        FF.field_conRemark = str2;
                        as.Hm();
                        c.Fg().a(FF);
                        as.Hm();
                        c.Ff().R(Xv);
                        this.ofG[2] = 1;
                        if (!(bi.oN(this.bgo) || str2.equals(this.bgo))) {
                            this.ofG[5] = 1;
                        }
                    } else if (bi.oN(this.bgo)) {
                        this.ofG[2] = 2;
                    } else {
                        this.ofG[2] = 0;
                    }
                    List linkedList = new LinkedList();
                    if (kVar instanceof o) {
                        int i4 = ((o) kVar).fvG;
                        i3 = i4;
                        linkedList = ((o) kVar).vkg;
                    } else {
                        if (kVar instanceof com.tencent.mm.openim.b.g) {
                            linkedList.add(((com.tencent.mm.openim.b.g) kVar).idC);
                        }
                        i3 = 0;
                    }
                    if (i3 == 3 || (kVar instanceof com.tencent.mm.openim.b.g)) {
                        f nb = l.TD().nb(this.userName);
                        as.Hm();
                        x Xv2 = c.Ff().Xv(this.userName);
                        if (linkedList != null && linkedList.contains(this.userName)) {
                            if (((int) Xv2.gKO) == 0) {
                                Xv2 = com.tencent.mm.pluginsdk.ui.preference.b.b(nb);
                                as.Hm();
                                if (!c.Ff().S(Xv2)) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            s.p(Xv2);
                            as.getNotification().xf();
                            l.TE().T(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.aV(this.userName, this.pnn);
                        }
                        as.Hm();
                        Xv2 = c.Ff().Xv(this.userName);
                        com.tencent.mm.sdk.b.b qdVar = new qd();
                        qdVar.fIC.fIE = true;
                        qdVar.fIC.fID = false;
                        qdVar.fIC.username = this.userName;
                        com.tencent.mm.sdk.b.a.xmy.m(qdVar);
                        if (this.pqL.zEk) {
                            s.j(Xv2);
                        } else {
                            s.k(Xv2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bqB);
                            intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqA);
                            d.b(this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !bi.oN(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || bi.oN(str))) {
                Toast.makeText(this, R.l.eKq, 0).show();
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.l.dGZ), getString(R.l.dGf), null);
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.ofG[0] = 1;
        finish();
        return true;
    }
}
