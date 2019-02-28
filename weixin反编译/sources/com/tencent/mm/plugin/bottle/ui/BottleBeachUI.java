package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.m;
import com.tencent.mm.af.y;
import com.tencent.mm.ax.g;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.io.Serializable;

@a(1)
public class BottleBeachUI extends MMActivity implements OnClickListener, e, m.a.a, b {
    private View kGT;
    private FrameLayout kGU;
    private ThrowBottleUI kGV;
    private PickBottleUI kGW;
    private OpenBottleUI kGX;
    private BallonImageView kGY;
    private LightHouseImageView kGZ;
    private ImageView kHa;
    private MoonImageView kHb;
    private ImageView kHc;
    private int kHd = 0;
    boolean kHe = true;
    private ImageView kHf;
    private ImageView kHg;
    private ImageView kHh;
    private TextView kHi;
    private d kHj;
    private b kHk;
    private boolean kHl = true;
    private r tipDialog = null;

    protected final int getLayoutId() {
        return R.i.dbz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.Gp()) {
            as.Hm();
            c.Fe().b(new g(11, 1));
        }
        initView();
        as.CN().a((int) d.CTRL_INDEX, (e) this);
        as.CN().a(new com.tencent.mm.plugin.bottle.a.d(), 0);
    }

    protected void onResume() {
        super.onResume();
        asr();
        this.mController.xRd.postDelayed(new Runnable() {
            public final void run() {
                if (BottleBeachUI.this.kGY != null && BottleBeachUI.this.kHd == 0 && BottleBeachUI.this.kHl) {
                    BottleBeachUI.this.asq();
                }
            }
        }, 1000);
        if (this.kHd == 3 && this.kGX != null) {
            OpenBottleUI openBottleUI = this.kGX;
            if (openBottleUI.fou != null && openBottleUI.fou.cjL()) {
                OpenBottleUI.kIB.a(openBottleUI);
            }
            openBottleUI.setScreenEnable(true);
            openBottleUI.kIK = bi.Wz();
        }
        as.Hm();
        c.Fk().a(this);
        y.Mt().a(this);
        as.CN().a(106, (e) this);
    }

    protected void onPause() {
        super.onPause();
        if (this.kHd == 1 && this.kGV != null) {
            this.kGV.asM();
        }
        if (this.kHd == 3 && this.kGX != null) {
            this.kGX.onPause();
        }
        if (as.Hp()) {
            as.Hm();
            c.Fk().b(this);
            as.CN().b(106, (e) this);
        }
        y.Mt().b(this);
    }

    public void onDestroy() {
        if (this.kGV != null) {
            ThrowBottleUI throwBottleUI = this.kGV;
            throwBottleUI.kJL = null;
            throwBottleUI.kJO = null;
            if (throwBottleUI.kJP != null) {
                throwBottleUI.kJP.cancel();
                throwBottleUI.kJP = null;
            }
            if (throwBottleUI.kJQ != null) {
                throwBottleUI.kJQ.release();
            }
            throwBottleUI.kJQ = null;
            throwBottleUI.kJR = null;
            throwBottleUI.kIt = null;
            if (throwBottleUI.kJM != null) {
                throwBottleUI.kJM.release();
            }
            this.kGV = null;
        }
        if (this.kGW != null) {
            PickBottleUI pickBottleUI = this.kGW;
            pickBottleUI.handler.removeCallbacks(pickBottleUI.kIS);
            pickBottleUI.handler.removeCallbacks(pickBottleUI.kIT);
            pickBottleUI.kIt = null;
            pickBottleUI.kIO = null;
            pickBottleUI.kIP = null;
            this.kGW = null;
        }
        if (this.kHj != null) {
            this.kHj.cancel();
            this.kHj.context = null;
            this.kHj = null;
        }
        if (this.kGX != null) {
            b bVar = this.kGX;
            if (bVar.fou != null && bVar.fou.cjL()) {
                bVar.asA();
            }
            bVar.kIt = null;
            if (bVar.kIC != null) {
                bVar.kIC.release();
                bVar.kIC = null;
            }
            OpenBottleUI.kIB = null;
            as.Hm();
            c.Ff().b(bVar);
            this.kGX = null;
        }
        this.kGY = null;
        this.kGZ = null;
        this.kHb = null;
        if (this.kHk != null) {
            this.kHk.dismiss();
            this.kHk = null;
        }
        as.CN().b((int) d.CTRL_INDEX, (e) this);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        int i = 8;
        setMMTitle(R.l.dMO);
        addIconOptionMenu(0, R.l.dCy, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(BottleBeachUI.this, BottlePersonalInfoUI.class);
                intent.putExtra("is_allow_set", false);
                BottleBeachUI.this.startActivity(intent);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottleBeachUI.this.aWY();
                BottleBeachUI.this.finish();
                return false;
            }
        });
        boolean chd = bi.chd();
        if (this.kGY == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.h.bOa);
            ((FrameLayout) frameLayout.getParent()).removeView(frameLayout);
            ((FrameLayout) getWindow().getDecorView()).addView(frameLayout, 0);
            frameLayout.setBackgroundResource(chd ? R.g.bzH : R.g.bzP);
            frameLayout.setVisibility(0);
            this.kGY = (BallonImageView) findViewById(R.h.bNZ);
            this.kGZ = (LightHouseImageView) findViewById(R.h.bOg);
            this.kHa = (ImageView) findViewById(R.h.bOE);
            this.kHb = (MoonImageView) findViewById(R.h.bOi);
        }
        this.kGY.setVisibility(chd ? 0 : 8);
        this.kGZ.setVisibility(chd ? 8 : 0);
        this.kHb.kHa = this.kHa;
        MoonImageView moonImageView = this.kHb;
        if (!chd) {
            i = 0;
        }
        moonImageView.setVisibility(i);
        this.kGT = findViewById(R.h.bOb);
        this.kGT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BottleBeachUI.this.asq();
            }
        });
        this.kHf = (ImageView) findViewById(R.h.bOv);
        this.kHg = (ImageView) findViewById(R.h.bOu);
        this.kHh = (ImageView) findViewById(R.h.bOt);
        this.kHf.setOnClickListener(this);
        this.kHg.setOnClickListener(this);
        this.kHh.setOnClickListener(this);
        this.kHc = (ImageView) findViewById(R.h.bOc);
        this.kHc.setOnClickListener(this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (i2 == -2002 && this.kHd == 0) {
            nD(R.l.dMN);
            return;
        }
        switch (kVar.getType()) {
            case 106:
                x.i("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (!com.tencent.mm.plugin.bottle.a.ihO.a(this.mController.xRr, i, i2, str)) {
                    if (i == 4 && i2 == -4) {
                        h.h(this.mController.xRr, R.l.dDo, R.l.dGZ);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        bfr Sv = ((ac) kVar).Sv();
                        String a = n.a(Sv.wfM);
                        com.tencent.mm.ac.n.JF().f(a, n.a(Sv.vNQ));
                        Intent intent = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Sv, 25);
                        if (bi.oM(a).length() > 0) {
                            if ((Sv.wCq & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.pWK.k(10298, a + ",25");
                            }
                            com.tencent.mm.plugin.bottle.a.ihN.d(intent, this.mController.xRr);
                            return;
                        }
                        return;
                    } else {
                        Toast.makeText(this.mController.xRr, this.mController.xRr.getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                }
                return;
            case d.CTRL_INDEX /*152*/:
                asr();
                return;
            default:
                nC(R.l.dMW);
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            if (this.kHd == 3) {
                x.v("MM.UI.BottleUI", "on key dwon");
                if (i == 25 && this.kGX.asC()) {
                    as.Hn().fA(0);
                    return true;
                } else if (i == 24 && this.kGX.asC()) {
                    as.Hn().fz(0);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (!this.kHe) {
            return true;
        } else {
            if (this.kHd == 0) {
                finish();
                return true;
            }
            nE(0);
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        if (R.h.bOv == id) {
            if (com.tencent.mm.plugin.bottle.a.c.asf() > 0) {
                nE(1);
            } else {
                nD(R.l.dMQ);
            }
        } else if (R.h.bOu == id) {
            if (com.tencent.mm.plugin.bottle.a.c.asg() > 0) {
                nE(2);
            } else {
                nD(R.l.dMP);
            }
        } else if (R.h.bOt == id) {
            if (!this.kHl) {
                asq();
            }
            intent = new Intent();
            intent.setClass(this, BottleConversationUI.class);
            intent.putExtra("conversation_from", "from_beach");
            startActivity(intent);
        } else if (R.h.bOc == id) {
            if (this.kHd == 3) {
                this.kGX.onPause();
                this.kGX.asA();
            }
            nE(0);
            k(0, 8, 8, 8);
        } else if (R.h.bOx == id) {
            String str = ((PickedBottleImageView) view).kID;
            String str2 = ((PickedBottleImageView) view).kGC;
            if (str2 != null && str2.length() > 0) {
                nE(0);
                as.Hm();
                ag Xv = c.Ff().Xv(str2);
                if (Xv == null || ((int) Xv.gKO) == 0 || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    final k acVar = new ac(str2);
                    as.CN().a(acVar, 0);
                    Context context = this.mController.xRr;
                    getString(R.l.dGZ);
                    this.tipDialog = h.a(context, getString(R.l.dDr), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(acVar);
                        }
                    });
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", Xv.field_username);
                if (Xv.ciN()) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(10298, Xv.field_username + ",25");
                    intent.putExtra("Contact_Scene", 25);
                }
                com.tencent.mm.plugin.bottle.a.ihN.d(intent, this.mController.xRr);
            } else if (str != null) {
                nE(3);
                OpenBottleUI openBottleUI = this.kGX;
                if (openBottleUI.kIC == null) {
                    openBottleUI.kIC = (ThrowBottleAnimUI) openBottleUI.kIt.findViewById(R.h.bOG);
                    openBottleUI.kIC.kJE = new ThrowBottleAnimUI.a() {
                        public final void asD() {
                            OpenBottleUI.this.kIC.setVisibility(8);
                            OpenBottleUI.this.kIt.nE(0);
                        }
                    };
                }
                if (openBottleUI.kIu == null) {
                    openBottleUI.kIu = (TextView) openBottleUI.findViewById(R.h.bOn);
                    openBottleUI.kIv = (LinearLayout) openBottleUI.findViewById(R.h.bOq);
                    openBottleUI.kIw = (FrameLayout) openBottleUI.findViewById(R.h.bOs);
                    openBottleUI.kIx = (ImageView) openBottleUI.findViewById(R.h.bOp);
                    openBottleUI.kIy = (TextView) openBottleUI.findViewById(R.h.bOr);
                    openBottleUI.kIz = (TextView) openBottleUI.findViewById(R.h.bOk);
                    openBottleUI.kIA = (TextView) openBottleUI.findViewById(R.h.bOl);
                    openBottleUI.kIw.setOnClickListener(openBottleUI);
                }
                openBottleUI.kID = str;
                x.d("MM.Bottle_OpenBottleUI", str);
                as.Hm();
                openBottleUI.fou = c.Fh().Fd(str);
                if (openBottleUI.fou.cjL()) {
                    float bw;
                    openBottleUI.kIu.setVisibility(8);
                    openBottleUI.kIv.setVisibility(0);
                    openBottleUI.kIw.setMinimumWidth(com.tencent.mm.bu.a.fromDPToPix(openBottleUI.kIt, OpenBottleUI.nJ((int) com.tencent.mm.modelvoice.q.B(openBottleUI.fou))));
                    openBottleUI.kIy.setText(openBottleUI.kIt.getString(R.l.ejB, new Object[]{Integer.valueOf((int) bw)}));
                    OpenBottleUI.kIB.a(openBottleUI);
                    if (openBottleUI.fou != null) {
                        bw = com.tencent.mm.modelvoice.q.bw(new com.tencent.mm.modelvoice.n(openBottleUI.fou.field_content).time);
                        FrameLayout frameLayout = openBottleUI.kIw;
                        openBottleUI.getResources().getString(R.l.dNl);
                        frameLayout.setContentDescription(String.format("%d", new Object[]{Integer.valueOf((int) bw)}));
                    }
                } else {
                    openBottleUI.kIu.setVisibility(0);
                    openBottleUI.kIv.setVisibility(8);
                    openBottleUI.kIu.setText(openBottleUI.fou.field_content);
                    i.f(openBottleUI.kIu, 1);
                }
                openBottleUI.asB();
                if (openBottleUI.kII == null) {
                    openBottleUI.kII = (TextView) openBottleUI.findViewById(R.h.cfL);
                    openBottleUI.kII.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            String substring = bi.oN(OpenBottleUI.this.kID) ? "" : OpenBottleUI.this.kID.substring(0, OpenBottleUI.this.kID.indexOf(58));
                            String substring2 = bi.oN(OpenBottleUI.this.kID) ? "" : OpenBottleUI.this.kID.substring(OpenBottleUI.this.kID.indexOf(58) + 1);
                            intent.putExtra("k_username", substring);
                            Serializable mV = com.tencent.mm.be.a.mV(OpenBottleUI.this.kID);
                            substring = "";
                            if (mV.size() > 0) {
                                substring = (String) mV.get(0);
                            }
                            mV.clear();
                            mV.add(String.format("<exposecontent><bottleid>%s</bottleid><hellomsg>%s</hellomsg></exposecontent>", new Object[]{substring2, substring}));
                            intent.putExtra("k_outside_expose_proof_item_list", mV);
                            intent.putExtra("showShare", false);
                            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(37)}));
                            com.tencent.mm.bl.d.b(OpenBottleUI.this.kIt, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                }
            } else {
                nE(0);
            }
        }
    }

    private void asq() {
        boolean z = this.kHl;
        fullScreenNoTitleBar(z);
        this.kHl = !z;
    }

    private void nC(int i) {
        CharSequence string = i > 0 ? this.mController.xRr.getString(i) : null;
        if (this.kHj == null) {
            this.kHj = new d(this);
        }
        this.kHj.cancel();
        if (string != null) {
            this.kHj.setDuration(0);
            this.kHj.setText(string);
            this.kHj.show();
        }
    }

    public final void nD(int i) {
        if (this.kHk == null) {
            this.kHk = new b(this);
        }
        b bVar = this.kHk;
        bVar.ioR.setText(getString(i));
        this.kHk.show();
    }

    public final void nE(int i) {
        this.kHd = i;
        nC(0);
        if (this.kHl) {
            asq();
        }
        switch (i) {
            case 0:
                this.kHe = true;
                k(0, 8, 8, 8);
                return;
            case 1:
                k(8, 0, 8, 8);
                return;
            case 2:
                k(8, 8, 0, 8);
                return;
            case 3:
                k(8, 8, 8, 0);
                return;
            default:
                k(8, 8, 8, 8);
                return;
        }
    }

    private void k(int i, int i2, int i3, int i4) {
        x.v("MM.UI.BottleUI", "set frame visible");
        if (this.kGU == null) {
            this.kGU = (FrameLayout) findViewById(R.h.bOf);
        }
        this.kGT.setVisibility(i);
        if (i == 0) {
            asr();
            this.kHc.setVisibility(8);
            aWY();
        }
        if (i2 == 0 && this.kGV == null) {
            this.kGV = (ThrowBottleUI) View.inflate(this, R.i.dbD, null);
            this.kGU.addView(this.kGV);
            ThrowBottleUI throwBottleUI = this.kGV;
            throwBottleUI.kJM = new ToneGenerator(1, 60);
            throwBottleUI.kJP = (Vibrator) throwBottleUI.kIt.getSystemService("vibrator");
            throwBottleUI.kJS = (ImageView) throwBottleUI.findViewById(R.h.bOz);
            throwBottleUI.kJT = (TextView) throwBottleUI.findViewById(R.h.bNY);
            throwBottleUI.kJT.setVisibility(8);
            throwBottleUI.kJU = (ImageView) throwBottleUI.findViewById(R.h.bOy);
            throwBottleUI.kJV = (MMEditText) throwBottleUI.findViewById(R.h.bOM);
            throwBottleUI.kJW = throwBottleUI.findViewById(R.h.bOI);
            throwBottleUI.kJZ = (ThrowBottleFooter) throwBottleUI.findViewById(R.h.bON);
            throwBottleUI.kIQ = (ImageView) throwBottleUI.kIt.findViewById(R.h.bOc);
            throwBottleUI.kJY = (ImageButton) throwBottleUI.findViewById(R.h.bNX);
            throwBottleUI.kJY.setOnClickListener(throwBottleUI);
            throwBottleUI.kJX = (Button) throwBottleUI.findViewById(R.h.bOJ);
            throwBottleUI.kJX.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view == ThrowBottleUI.this.kJX) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                if (!ThrowBottleUI.this.kKa) {
                                    x.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(ThrowBottleUI.this.kIt, "android.permission.RECORD_AUDIO", 80, null, null)));
                                    if (com.tencent.mm.pluginsdk.g.a.a(ThrowBottleUI.this.kIt, "android.permission.RECORD_AUDIO", 80, null, null)) {
                                        ThrowBottleUI throwBottleUI = ThrowBottleUI.this;
                                        throwBottleUI.kKa = true;
                                        throwBottleUI.kJX.setBackgroundDrawable(com.tencent.mm.bu.a.b(throwBottleUI.kIt, R.g.bFi));
                                        throwBottleUI.kJX.setText(throwBottleUI.kJF ? R.l.dNi : R.l.dNg);
                                        if (throwBottleUI.kJF) {
                                            if (!com.tencent.mm.o.a.aW(throwBottleUI.getContext()) && !com.tencent.mm.o.a.aU(throwBottleUI.kIt)) {
                                                as.Hm();
                                                if (!c.isSDCardAvailable()) {
                                                    u.fJ(throwBottleUI.kIt);
                                                    break;
                                                }
                                                throwBottleUI.kKi = true;
                                                x.v("MM.Bottle.ThrowBottleUI", "record start");
                                                if (throwBottleUI.kJL != null) {
                                                    throwBottleUI.kJL.kGB = null;
                                                    throwBottleUI.kJL = null;
                                                }
                                                throwBottleUI.kJL = new com.tencent.mm.plugin.bottle.a.h.d(throwBottleUI.getContext(), throwBottleUI);
                                                throwBottleUI.kKg.K(100, 100);
                                                throwBottleUI.kJS.setVisibility(0);
                                                throwBottleUI.kJT.setVisibility(0);
                                                throwBottleUI.kJR = (AnimationDrawable) throwBottleUI.kJT.getBackground();
                                                throwBottleUI.kJR.start();
                                                throwBottleUI.kJU.setVisibility(8);
                                                if (throwBottleUI.kJL != null) {
                                                    af.VI("keep_app_silent");
                                                    throwBottleUI.kJL.cJ("_USER_FOR_THROWBOTTLE_");
                                                    throwBottleUI.kKb = false;
                                                    throwBottleUI.kKh.K(200, 200);
                                                    throwBottleUI.kJM.startTone(24);
                                                    throwBottleUI.handler.postDelayed(new Runnable() {
                                                        public final void run() {
                                                            ThrowBottleUI.this.kJM.stopTone();
                                                        }
                                                    }, 200);
                                                    throwBottleUI.kJP.vibrate(50);
                                                    throwBottleUI.kJL.a(throwBottleUI.kKk);
                                                }
                                                throwBottleUI.kIt.getWindow().getDecorView().setKeepScreenOn(true);
                                                break;
                                            }
                                            x.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                ThrowBottleUI.this.kKa = false;
                                ThrowBottleUI.this.kJX.setBackgroundDrawable(com.tencent.mm.bu.a.b(ThrowBottleUI.this.kIt, R.g.bFh));
                                ThrowBottleUI.this.kJX.setText(ThrowBottleUI.this.kJF ? R.l.dNj : R.l.dNg);
                                if (!ThrowBottleUI.this.kJF) {
                                    ThrowBottleUI.this.dY(false);
                                    String trim = ThrowBottleUI.this.kJV.getText().toString().trim();
                                    if (trim.length() < 5) {
                                        ThrowBottleUI.this.kIt.nD(R.l.dNh);
                                        break;
                                    }
                                    ThrowBottleUI.this.kJV.setText("");
                                    com.tencent.mm.plugin.bottle.a.h.c cVar = new com.tencent.mm.plugin.bottle.a.h.c(trim, ThrowBottleUI.this);
                                    ThrowBottleUI.this.asL();
                                } else if (!ThrowBottleUI.this.kKb) {
                                    ThrowBottleUI.this.asM();
                                }
                                ThrowBottleUI.this.kKi = false;
                                break;
                        }
                    }
                    return false;
                }
            });
            throwBottleUI.setOnClickListener(throwBottleUI);
            if (throwBottleUI.kKc == null) {
                throwBottleUI.kKc = (LayoutParams) throwBottleUI.kJV.getLayoutParams();
                throwBottleUI.kKe = throwBottleUI.kKc.topMargin;
            }
            throwBottleUI.kJZ.kJI = new ThrowBottleFooter.a() {
                public final void asJ() {
                    if (ThrowBottleUI.this.kKd == 0) {
                        ThrowBottleUI.this.kKd = ThrowBottleUI.this.getHeight();
                    }
                    int[] iArr = new int[]{0, 0};
                    int[] iArr2 = new int[]{0, 0};
                    ThrowBottleUI.this.getLocationInWindow(iArr);
                    ThrowBottleUI.this.kJZ.getLocationInWindow(iArr2);
                    if ((((double) (iArr2[1] - iArr[1])) * 1.0d) / ((double) ThrowBottleUI.this.kKd) < 0.5d) {
                        ThrowBottleUI.this.kKc.topMargin = ThrowBottleUI.this.kKe;
                        ThrowBottleUI.this.kKc.bottomMargin = 0;
                        ThrowBottleUI.this.kJW.setVisibility(0);
                        ThrowBottleUI.this.requestLayout();
                        return;
                    }
                    ThrowBottleUI.this.kKc.topMargin = (ThrowBottleUI.this.kKe * 1) / 6;
                    ThrowBottleUI.this.kKc.bottomMargin = ThrowBottleUI.this.kJZ.getHeight();
                    ThrowBottleUI.this.kJW.setVisibility(8);
                    ThrowBottleUI.this.requestLayout();
                }
            };
        }
        if (this.kGV != null) {
            this.kGV.setVisibility(i2);
        }
        if (i3 == 0 && this.kGW == null) {
            this.kGW = (PickBottleUI) View.inflate(this, R.i.dbC, null);
            this.kGU.addView(this.kGW);
            this.kGW.initView();
        }
        if (this.kGW != null) {
            this.kGW.setVisibility(i3);
        }
        if (i3 == 0) {
            this.kGW.density = com.tencent.mm.bu.a.getDensity(this);
            PickBottleUI pickBottleUI = this.kGW;
            pickBottleUI.kIP.setVisibility(8);
            pickBottleUI.kIO.G(Integer.MAX_VALUE, -1, -1);
            pickBottleUI.kIQ.setVisibility(8);
            pickBottleUI.kIt.kHe = false;
            pickBottleUI.handler.postDelayed(pickBottleUI.kIS, 1000);
        }
        if (i4 == 0 && this.kGX == null) {
            this.kGX = (OpenBottleUI) View.inflate(this, R.i.dbB, null);
            this.kGU.addView(this.kGX);
            Object obj = this.kGX;
            ((Button) obj.findViewById(R.h.bOo)).setOnClickListener(obj);
            ((Button) obj.findViewById(R.h.bOm)).setOnClickListener(obj);
            obj.kIJ = this;
        }
        if (this.kGX != null) {
            this.kGX.setVisibility(i4);
        }
    }

    private void asr() {
        if (this.kHi == null) {
            this.kHi = (TextView) findViewById(R.h.bOh);
            this.kHi.setBackgroundResource(s.ge(this.mController.xRr));
        }
        int ash = com.tencent.mm.plugin.bottle.a.c.ash();
        this.kHi.setText(String.valueOf(ash));
        this.kHi.setVisibility(ash > 0 ? 0 : 8);
    }

    public final void kl(String str) {
        if (this.kGW != null) {
            PickBottleUI pickBottleUI = this.kGW;
            if (pickBottleUI.kIP != null) {
                PickedBottleImageView pickedBottleImageView = pickBottleUI.kIP;
                if (str.equals(pickedBottleImageView.kGC)) {
                    pickedBottleImageView.kIW = m.d(pickedBottleImageView.kGC, pickedBottleImageView.iconUrl, R.g.bEl);
                    pickedBottleImageView.update();
                    pickedBottleImageView.invalidate();
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        asr();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BottleBeachUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
