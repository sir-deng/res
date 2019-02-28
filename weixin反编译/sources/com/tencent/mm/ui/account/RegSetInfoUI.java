package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private Button lXK;
    private String liu;
    private ProgressBar lvk;
    private String mFy;
    private int sceneType = 0;
    private SecurityImage xSF = null;
    private String xXB;
    private a xXp;
    private boolean xYV = false;
    private EditText xZG;
    private LinkedList<String> yaA = new LinkedList();
    private ImageView yaB;
    private String yaC = "";
    private ImageView yaD;
    private View yaE;
    private TextView yaF;
    private String yaG = null;
    private boolean yaH = false;
    private q yaI;
    private View yaJ;
    private boolean yaK = false;
    private al yaL = new al(Looper.myLooper(), new al.a() {
        public final boolean uG() {
            String str;
            String trim = RegSetInfoUI.this.yao.getText().toString().trim();
            String trim2 = RegSetInfoUI.this.xZG.getText().toString().trim();
            if (bi.oN(trim) && !bi.oN(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (bi.oN(trim) || !bi.oN(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!bi.oN(trim) && RegSetInfoUI.this.coT() && RegSetInfoUI.this.coW()) {
                int e = RegSetInfoUI.this.cpa();
                String f = RegSetInfoUI.this.cpb();
                as.CN().a(429, RegSetInfoUI.this);
                as.CN().a(new x(f, RegSetInfoUI.this.liu, e, str, trim, "", ""), 0);
                RegSetInfoUI.this.lvk.setVisibility(0);
            }
            return false;
        }
    }, true);
    private EditText yao;
    private String yap;
    private String yaq;
    private int yar;
    private String yas;
    private TextView yat;
    private View yau;
    private boolean yav = false;
    private ImageView yax;
    private int yay = 3;
    private int yaz;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void p(com.tencent.mm.ui.account.RegSetInfoUI r18) {
        /*
        r0 = r18;
        r1 = r0.xZG;
        r1 = r1.getText();
        r1 = r1.toString();
        r4 = r1.trim();
        r0 = r18;
        r1 = r0.yao;
        r1 = r1.getText();
        r1 = r1.toString();
        r12 = r1.trim();
        if (r4 == 0) goto L_0x0028;
    L_0x0022:
        r1 = r4.length();
        if (r1 > 0) goto L_0x0032;
    L_0x0028:
        r1 = com.tencent.mm.R.l.eSV;
        r2 = com.tencent.mm.R.l.eEe;
        r0 = r18;
        com.tencent.mm.ui.base.h.h(r0, r1, r2);
    L_0x0031:
        return;
    L_0x0032:
        r0 = r18;
        r1 = r0.lvk;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x005e;
    L_0x003c:
        r1 = com.tencent.mm.R.l.dGZ;
        r0 = r18;
        r0.getString(r1);
        r1 = com.tencent.mm.R.l.eEu;
        r0 = r18;
        r1 = r0.getString(r1);
        r2 = 1;
        r3 = new com.tencent.mm.ui.account.RegSetInfoUI$6;
        r0 = r18;
        r3.<init>();
        r0 = r18;
        r1 = com.tencent.mm.ui.base.h.a(r0, r1, r2, r3);
        r0 = r18;
        r0.inI = r1;
        goto L_0x0031;
    L_0x005e:
        r1 = r18.coT();
        if (r1 == 0) goto L_0x00b1;
    L_0x0064:
        r1 = r18.coW();
        if (r1 == 0) goto L_0x00b1;
    L_0x006a:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
        if (r1 != 0) goto L_0x00b1;
    L_0x0070:
        r0 = r18;
        r1 = r0.yat;
        r1 = r1.getText();
        r1 = r1.toString();
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 != 0) goto L_0x0090;
    L_0x0082:
        r2 = com.tencent.mm.R.l.eED;
        r0 = r18;
        r2 = r0.getString(r2);
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x00a2;
    L_0x0090:
        r0 = r18;
        r1 = r0.yaG;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x00ac;
    L_0x009a:
        r1 = com.tencent.mm.R.l.eEF;
        r0 = r18;
        r1 = r0.getString(r1);
    L_0x00a2:
        r2 = "";
        r3 = 1;
        r0 = r18;
        com.tencent.mm.ui.base.h.b(r0, r1, r2, r3);
        goto L_0x0031;
    L_0x00ac:
        r0 = r18;
        r1 = r0.yaG;
        goto L_0x00a2;
    L_0x00b1:
        r18.aWY();
        r1 = r18.coW();
        if (r1 == 0) goto L_0x0169;
    L_0x00ba:
        r0 = r18;
        r1 = r0.yaA;
        if (r1 == 0) goto L_0x00ca;
    L_0x00c0:
        r0 = r18;
        r1 = r0.yaA;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0155;
    L_0x00ca:
        r1 = 0;
        r17 = r1;
    L_0x00cd:
        r11 = r18.cpa();
        r1 = com.tencent.mm.y.as.CN();
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = r18;
        r1.a(r2, r0);
        r1 = new com.tencent.mm.modelsimple.y;
        r2 = "";
        r0 = r18;
        r3 = r0.mFy;
        r0 = r18;
        r5 = r0.yar;
        r0 = r18;
        r6 = r0.yaq;
        r0 = r18;
        r7 = r0.yap;
        r8 = "";
        r9 = "";
        r0 = r18;
        r10 = r0.liu;
        r13 = "";
        r14 = "";
        r0 = r18;
        r15 = r0.yav;
        r0 = r18;
        r0 = r0.xYV;
        r16 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r2 = r1.hoZ;
        r2 = r2.Kh();
        r2 = (com.tencent.mm.protocal.y.a) r2;
        r2 = r2.vIE;
        r0 = r17;
        r2.wIi = r0;
        r0 = r18;
        r2 = r0.xXB;
        r1.mB(r2);
        r0 = r18;
        r2 = r0.yaz;
        r1.iv(r2);
        r2 = com.tencent.mm.y.as.CN();
        r3 = 0;
        r2.a(r1, r3);
        r2 = com.tencent.mm.R.l.dGZ;
        r0 = r18;
        r0.getString(r2);
        r2 = com.tencent.mm.R.l.eEu;
        r0 = r18;
        r2 = r0.getString(r2);
        r3 = 1;
        r4 = new com.tencent.mm.ui.account.RegSetInfoUI$7;
        r0 = r18;
        r4.<init>(r1);
        r0 = r18;
        r1 = com.tencent.mm.ui.base.h.a(r0, r2, r3, r4);
        r0 = r18;
        r0.inI = r1;
        goto L_0x0031;
    L_0x0155:
        r0 = r18;
        r1 = r0.yaA;
        r1 = r1.contains(r12);
        if (r1 == 0) goto L_0x0164;
    L_0x015f:
        r1 = 1;
        r17 = r1;
        goto L_0x00cd;
    L_0x0164:
        r1 = 2;
        r17 = r1;
        goto L_0x00cd;
    L_0x0169:
        r11 = r18.cpa();
        r1 = com.tencent.mm.y.as.CN();
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = r18;
        r1.a(r2, r0);
        r1 = new com.tencent.mm.modelsimple.y;
        r2 = "";
        r0 = r18;
        r3 = r0.mFy;
        r0 = r18;
        r5 = r0.yar;
        r0 = r18;
        r6 = r0.yaq;
        r0 = r18;
        r7 = r0.yap;
        r8 = "";
        r9 = "";
        r0 = r18;
        r10 = r0.liu;
        r12 = "";
        r13 = "";
        r14 = "";
        r0 = r18;
        r15 = r0.yav;
        r0 = r18;
        r0 = r0.xYV;
        r16 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r0 = r18;
        r2 = r0.xXB;
        r1.mB(r2);
        r0 = r18;
        r2 = r0.yaz;
        r1.iv(r2);
        r2 = com.tencent.mm.y.as.CN();
        r3 = 0;
        r2.a(r1, r3);
        r2 = com.tencent.mm.R.l.dGZ;
        r0 = r18;
        r0.getString(r2);
        r2 = com.tencent.mm.R.l.eEu;
        r0 = r18;
        r2 = r0.getString(r2);
        r3 = 1;
        r4 = new com.tencent.mm.ui.account.RegSetInfoUI$8;
        r0 = r18;
        r4.<init>(r1);
        r0 = r18;
        r1 = com.tencent.mm.ui.base.h.a(r0, r2, r3, r4);
        r0 = r18;
        r0.inI = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegSetInfoUI.p(com.tencent.mm.ui.account.RegSetInfoUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.eEE);
        if (d.vHo) {
            string = getString(R.l.app_name) + getString(R.l.dDO);
        }
        setMMTitle(string);
        com.tencent.mm.plugin.c.a.ihO.uq();
        this.yap = getIntent().getStringExtra("regsetinfo_user");
        this.yaq = getIntent().getStringExtra("regsetinfo_bind_email");
        this.liu = getIntent().getStringExtra("regsetinfo_ticket");
        this.mFy = getIntent().getStringExtra("regsetinfo_pwd");
        this.yas = getIntent().getStringExtra("regsetinfo_binduin");
        this.yaz = getIntent().getIntExtra("mobile_check_type", 0);
        if (!bi.oN(this.yas)) {
            this.yar = o.bY(this.yas);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.yav = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.yay = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.xXB = getIntent().getStringExtra("regsession_id");
        initView();
        if (this.sceneType == 1) {
            b.b(true, as.CI() + "," + getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",1");
            b.oY("R200_900_phone");
        } else if (this.sceneType == 2) {
            b.b(true, as.CI() + "," + getClass().getName() + ",R4_QQ," + as.fJ("R4_QQ") + ",1");
            b.oY("R4_QQ");
        } else if (this.sceneType == 3) {
            b.b(true, as.CI() + "," + getClass().getName() + ",R200_900_email," + as.fJ("R200_900_email") + ",1");
            b.oY("R200_900_email");
        }
        this.yaK = false;
        this.xXp = new a();
    }

    public void onResume() {
        super.onResume();
        this.xZG.postDelayed(new Runnable() {
            public final void run() {
                RegSetInfoUI.this.yax.requestFocus();
                RegSetInfoUI.this.xZG.clearFocus();
            }
        }, 500);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sceneType == 1) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",2");
        } else if (this.sceneType == 2) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R4_QQ," + as.fJ("R4_QQ") + ",2");
        } else if (this.sceneType == 3) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R200_900_email," + as.fJ("R200_900_email") + ",2");
        }
        if (this.xXp != null) {
            this.xXp.close();
        }
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        this.yaJ = findViewById(R.h.cDk);
        this.yaE = findViewById(R.h.cLQ);
        this.yax = (ImageView) findViewById(R.h.cLP);
        this.xZG = (EditText) findViewById(R.h.cHq);
        this.yaF = (TextView) findViewById(R.h.cLS);
        this.yao = (EditText) findViewById(R.h.cHt);
        this.yat = (TextView) findViewById(R.h.bJZ);
        this.yau = findViewById(R.h.cHF);
        this.yaB = (ImageView) findViewById(R.h.cZn);
        this.lvk = (ProgressBar) findViewById(R.h.cEe);
        this.yaD = (ImageView) findViewById(R.h.cLR);
        this.lXK = (Button) findViewById(R.h.cAl);
        this.yaB.setVisibility(8);
        this.lvk.setVisibility(8);
        this.yaD.setVisibility(8);
        this.xYV = false;
        this.yaH = false;
        this.yaE.setVisibility(coV() ? 0 : 8);
        View view = this.yau;
        if (coW()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.yat;
        if (!coW()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (coV() && coW()) {
            this.yaF.setText(getString(R.l.eEB));
        } else if (coV() && !coW()) {
            this.yaF.setText(getString(R.l.eEz));
        } else if (coV() || !coW()) {
            this.yaF.setText(getString(R.l.eEy));
        } else {
            this.yaF.setText(getString(R.l.eEA));
        }
        as.Dt().a(new ah.a() {
            Bitmap mBitmap;
            String nqW;

            public final boolean JI() {
                if (!bi.oN(this.nqW) && bi.oN((RegSetInfoUI.this.xZG.getText()).trim())) {
                    RegSetInfoUI.this.xZG.setText(this.nqW);
                }
                if (f.zl()) {
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled() || RegSetInfoUI.this.xYV)) {
                        RegSetInfoUI.this.yax.setImageBitmap(this.mBitmap);
                        RegSetInfoUI.this.xYV = true;
                        RegSetInfoUI.this.yaD.setVisibility(0);
                    }
                    return true;
                }
                com.tencent.mm.sdk.platformtools.x.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
                return false;
            }

            public final boolean JH() {
                try {
                    this.nqW = c.bo(RegSetInfoUI.this);
                    this.mBitmap = c.bp(RegSetInfoUI.this);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
                }
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.gJm + "temp.avatar", false);
                    } catch (Throwable e2) {
                        com.tencent.mm.sdk.platformtools.x.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView";
            }
        });
        this.xZG.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                CharSequence trim = RegSetInfoUI.this.xZG.getText().toString().trim();
                if (trim == null || trim.length() <= 16) {
                    if (!RegSetInfoUI.this.yaL.cgx()) {
                        RegSetInfoUI.this.yaL.TN();
                    }
                    RegSetInfoUI.this.coU();
                    if (!RegSetInfoUI.this.yaK) {
                        RegSetInfoUI.this.yao.setText(trim);
                        return;
                    }
                    return;
                }
                RegSetInfoUI.this.xZG.setText(trim.substring(0, 16));
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RegSetInfoUI.p(RegSetInfoUI.this);
            }
        });
        this.yao.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    RegSetInfoUI.this.yaK = true;
                    RegSetInfoUI.this.yaL.K(200, 200);
                }
            }
        });
        this.yao.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                if (!RegSetInfoUI.this.yaL.cgx()) {
                    RegSetInfoUI.this.yaL.TN();
                }
                String trim = RegSetInfoUI.this.yao.getText().toString().trim();
                if (bi.oN(trim)) {
                    RegSetInfoUI.this.yat.setText(RegSetInfoUI.this.getString(R.l.eED));
                    RegSetInfoUI.this.S(false, false);
                    if (RegSetInfoUI.this.yaI != null) {
                        RegSetInfoUI.this.yaI.dismiss();
                        RegSetInfoUI.this.yaI = null;
                    }
                    RegSetInfoUI.this.yao.postDelayed(new Runnable() {
                        public final void run() {
                            RegSetInfoUI.this.yao.clearFocus();
                            RegSetInfoUI.this.yao.requestFocus();
                        }
                    }, 50);
                }
                if (!bi.oN(trim) && (RegSetInfoUI.this.coT() || !trim.equals(RegSetInfoUI.this.yaC))) {
                    RegSetInfoUI.this.S(false, false);
                    RegSetInfoUI.this.yaL.K(500, 500);
                }
                RegSetInfoUI.this.yaC = trim;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegSetInfoUI.this.bpd();
                return true;
            }
        });
        this.xZG.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.p(RegSetInfoUI.this);
                return true;
            }
        });
        this.xZG.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.p(RegSetInfoUI.this);
                return true;
            }
        });
        this.yao.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.p(RegSetInfoUI.this);
                return true;
            }
        });
        this.yao.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.p(RegSetInfoUI.this);
                return true;
            }
        });
        this.yax.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.c.a.ihO.d(RegSetInfoUI.this);
            }
        });
        File file = new File(com.tencent.mm.compatible.util.e.gJm);
        if (!file.exists()) {
            file.mkdir();
        }
        coU();
    }

    private void S(boolean z, boolean z2) {
        boolean z3 = false;
        if (bi.oN(this.yao.getText().toString().trim())) {
            z = false;
        }
        this.yaB.setImageResource(z2 ? R.g.bGq : R.g.bGn);
        this.yaB.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.yaH = z3;
    }

    private boolean coT() {
        return this.yaB.getVisibility() == 8 || this.yaH;
    }

    private void coU() {
        this.lXK.setEnabled(!bi.oN(this.xZG.getText().toString().trim()));
    }

    private boolean coV() {
        return (this.yay & 1) > 0;
    }

    private boolean coW() {
        return (this.yay & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap a = com.tencent.mm.plugin.c.a.ihO.a((Activity) this, i, i2, intent);
        if (a != null) {
            this.yax.setImageBitmap(a);
            this.xYV = true;
            this.yaD.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dqS;
    }

    private boolean coX() {
        return this.sceneType == 1;
    }

    private boolean coY() {
        return this.sceneType == 2;
    }

    private boolean coZ() {
        return this.sceneType == 3;
    }

    private int cpa() {
        if (coX()) {
            return 4;
        }
        if (coY() || !coZ()) {
            return 2;
        }
        return 6;
    }

    private String cpb() {
        if (coX()) {
            return this.yap;
        }
        if (coZ()) {
            return this.yaq;
        }
        return this.yas;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int Wo;
        com.tencent.mm.g.a eC;
        final k kVar2;
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 126) {
            as.CN().b(126, (e) this);
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                String str4;
                final k kVar3;
                final String str5;
                final String str6;
                final boolean z;
                final k kVar4;
                final String str7;
                final String str8;
                final int i3;
                this.yaG = null;
                final String cpb = cpb();
                final String Sp = ((y) kVar).Sp();
                final int Sq = ((y) kVar).Sq();
                String str9 = null;
                String str10 = null;
                boolean z2 = false;
                Map y = bj.y(((y) kVar).Sr(), "wording");
                if (y != null) {
                    str2 = (String) y.get(".wording.switch");
                    if (bi.oN(str2)) {
                        z2 = true;
                    } else {
                        Wo = bi.Wo(str2);
                        if (Wo == 0) {
                            z2 = false;
                        } else if (Wo == 1) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        str2 = (String) y.get(".wording.title");
                        if (!bi.oN(str2)) {
                            str9 = str2;
                        }
                        str2 = (String) y.get(".wording.desc");
                        if (bi.oN(str2)) {
                            str3 = str9;
                        } else {
                            str10 = str2;
                            str3 = str9;
                        }
                        com.tencent.mm.sdk.platformtools.x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                        as.unhold();
                        as.bA(true);
                        if (this.xYV) {
                            this.liu = ((y) kVar).So();
                            ar.hhz.S("login_user_name", cpb);
                            if (Sp == null && Sp.contains("0")) {
                                b.oZ("R300_100_phone");
                                if (z2) {
                                    intent = new Intent(this, FindMContactAlertUI.class);
                                    intent.putExtra("alert_title", str3);
                                    intent.putExtra("alert_message", str10);
                                } else {
                                    intent = new Intent(this, FindMContactIntroUI.class);
                                }
                                intent.addFlags(67108864);
                                intent.putExtra("regsetinfo_ticket", this.liu);
                                intent.putExtra("regsetinfo_NextStep", Sp);
                                intent.putExtra("regsetinfo_NextStyle", Sq);
                                Intent at = com.tencent.mm.plugin.c.a.ihN.at(this);
                                at.addFlags(67108864);
                                at.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, intent, at);
                                finish();
                            } else {
                                intent = com.tencent.mm.plugin.c.a.ihN.at(this);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(intent);
                                b.pa(as.CI() + "," + getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",4");
                                finish();
                            }
                        } else {
                            str4 = com.tencent.mm.compatible.util.e.gJm + "temp.avatar";
                            str2 = com.tencent.mm.compatible.util.e.gJm + "temp.avatar.hd";
                            new File(str4).renameTo(new File(str2));
                            com.tencent.mm.loader.stub.b.deleteFile(str4);
                            com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                            kVar3 = kVar;
                            str5 = cpb;
                            str6 = Sp;
                            z = z2;
                            kVar4 = kVar;
                            str7 = str3;
                            str8 = str10;
                            i3 = Sq;
                            new p(this, com.tencent.mm.compatible.util.e.gJm + "temp.avatar").a(new Runnable() {
                                public final void run() {
                                    RegSetInfoUI.this.liu = ((y) kVar3).So();
                                    ar.hhz.S("login_user_name", str5);
                                    com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gJm + "temp.avatar");
                                    Intent at;
                                    if (str6 == null || !str6.contains("0")) {
                                        at = com.tencent.mm.plugin.c.a.ihN.at(RegSetInfoUI.this);
                                        at.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(at);
                                        b.pa(as.CI() + "," + RegSetInfoUI.this.getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",4");
                                        RegSetInfoUI.this.finish();
                                        return;
                                    }
                                    b.oZ("R300_100_phone");
                                    if (z) {
                                        at = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        at.putExtra("alert_title", str3);
                                        at.putExtra("alert_message", str10);
                                    } else {
                                        at = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    at.addFlags(67108864);
                                    at.putExtra("regsetinfo_ticket", RegSetInfoUI.this.liu);
                                    at.putExtra("regsetinfo_NextStep", str6);
                                    at.putExtra("regsetinfo_NextStyle", Sq);
                                    Intent at2 = com.tencent.mm.plugin.c.a.ihN.at(RegSetInfoUI.this);
                                    at2.addFlags(67108864);
                                    MMWizardActivity.b(RegSetInfoUI.this, at, at2);
                                    RegSetInfoUI.this.finish();
                                }
                            }, new Runnable() {
                                public final void run() {
                                    RegSetInfoUI.this.liu = ((y) kVar4).So();
                                    ar.hhz.S("login_user_name", cpb);
                                    Intent at;
                                    if (Sp == null || !Sp.contains("0")) {
                                        at = com.tencent.mm.plugin.c.a.ihN.at(RegSetInfoUI.this);
                                        at.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(at);
                                        b.pa(as.CI() + "," + RegSetInfoUI.this.getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",4");
                                        RegSetInfoUI.this.finish();
                                        return;
                                    }
                                    b.oZ("R300_100_phone");
                                    if (z2) {
                                        at = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        at.putExtra("alert_title", str7);
                                        at.putExtra("alert_message", str8);
                                    } else {
                                        at = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    at.addFlags(67108864);
                                    at.putExtra("regsetinfo_ticket", RegSetInfoUI.this.liu);
                                    at.putExtra("regsetinfo_NextStep", Sp);
                                    at.putExtra("regsetinfo_NextStyle", i3);
                                    Intent at2 = com.tencent.mm.plugin.c.a.ihN.at(RegSetInfoUI.this);
                                    at2.addFlags(67108864);
                                    MMWizardActivity.b(RegSetInfoUI.this, at, at2);
                                    RegSetInfoUI.this.finish();
                                }
                            });
                        }
                    }
                }
                str3 = null;
                com.tencent.mm.sdk.platformtools.x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                as.unhold();
                as.bA(true);
                if (this.xYV) {
                    this.liu = ((y) kVar).So();
                    ar.hhz.S("login_user_name", cpb);
                    if (Sp == null) {
                    }
                    intent = com.tencent.mm.plugin.c.a.ihN.at(this);
                    intent.addFlags(67108864);
                    intent.putExtra("LauncherUI.enter_from_reg", true);
                    startActivity(intent);
                    b.pa(as.CI() + "," + getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",4");
                    finish();
                } else {
                    str4 = com.tencent.mm.compatible.util.e.gJm + "temp.avatar";
                    str2 = com.tencent.mm.compatible.util.e.gJm + "temp.avatar.hd";
                    new File(str4).renameTo(new File(str2));
                    com.tencent.mm.loader.stub.b.deleteFile(str4);
                    com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                    kVar3 = kVar;
                    str5 = cpb;
                    str6 = Sp;
                    z = z2;
                    kVar4 = kVar;
                    str7 = str3;
                    str8 = str10;
                    i3 = Sq;
                    new p(this, com.tencent.mm.compatible.util.e.gJm + "temp.avatar").a(/* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this, null, null);
                    return;
                } else if (o(i, i2, str)) {
                    return;
                }
            } else if (this.xSF == null) {
                kVar2 = kVar;
                kVar2 = kVar;
                this.xSF = SecurityImage.a.a(this.mController.xRr, R.l.eEv, 0, ((y) kVar).Ou(), ((y) kVar).Ov(), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = RegSetInfoUI.this.yao.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.xZG.getText().toString().trim();
                        if (trim2 == null || trim2.length() <= 0) {
                            h.h(RegSetInfoUI.this, R.l.eSV, R.l.eEe);
                            return;
                        }
                        int e = RegSetInfoUI.this.cpa();
                        as.CN().a(126, RegSetInfoUI.this);
                        final k yVar = new y("", RegSetInfoUI.this.mFy, trim2, RegSetInfoUI.this.yar, RegSetInfoUI.this.yaq, RegSetInfoUI.this.yap, "", "", RegSetInfoUI.this.liu, e, trim, ((y) kVar2).Ov(), RegSetInfoUI.this.xSF.cpt(), RegSetInfoUI.this.yav, RegSetInfoUI.this.xYV);
                        yVar.mB(RegSetInfoUI.this.xXB);
                        yVar.iv(RegSetInfoUI.this.yaz);
                        as.CN().a(yVar, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(R.l.dGZ);
                        regSetInfoUI.inI = h.a(context, RegSetInfoUI.this.getString(R.l.eEu), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(yVar);
                                as.CN().b(126, RegSetInfoUI.this);
                            }
                        });
                    }
                }, null, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        RegSetInfoUI.this.xSF = null;
                    }
                }, new SecurityImage.b() {
                    public final void cox() {
                        RegSetInfoUI.this.aWY();
                        String trim = RegSetInfoUI.this.yao.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.xZG.getText().toString().trim();
                        int e = RegSetInfoUI.this.cpa();
                        as.CN().a(126, RegSetInfoUI.this);
                        k yVar = new y("", RegSetInfoUI.this.mFy, trim2, RegSetInfoUI.this.yar, RegSetInfoUI.this.yaq, RegSetInfoUI.this.yap, "", "", RegSetInfoUI.this.liu, e, trim, ((y) kVar2).Ov(), "", RegSetInfoUI.this.yav, RegSetInfoUI.this.xYV);
                        yVar.mB(RegSetInfoUI.this.xXB);
                        yVar.iv(RegSetInfoUI.this.yaz);
                        as.CN().a(yVar, 0);
                    }
                });
                return;
            } else {
                this.xSF.a(0, ((y) kVar).Ou(), ((y) kVar).Ov(), "");
                return;
            }
        }
        if (kVar.getType() == 429) {
            as.CN().b(429, (e) this);
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            this.lvk.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.yaG = null;
                Wo = ((t.b) ((x) kVar).hoZ.Hv()).vIy.wuY;
                com.tencent.mm.sdk.platformtools.x.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", Integer.valueOf(Wo));
                if (Wo == -14 || Wo == -10 || Wo == -7) {
                    LinkedList linkedList = ((t.b) ((x) kVar).hoZ.Hv()).vIy.kyB;
                    eC = com.tencent.mm.g.a.eC(str);
                    if (eC != null) {
                        this.yat.setText(eC.desc);
                    }
                    this.yaA.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        final String[] strArr = new String[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            strArr[i4] = ((bet) linkedList.get(i4)).wRo;
                            this.yaA.add(strArr[i4]);
                        }
                        if (this.yaK) {
                            if (this.yaI != null) {
                                this.yaI.dismiss();
                                this.yaI = null;
                            }
                            this.yaI = g.a(this, this.yaJ, strArr, new OnItemClickListener() {
                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    if (RegSetInfoUI.this.yaI != null) {
                                        RegSetInfoUI.this.yaI.dismiss();
                                        RegSetInfoUI.this.yaI = null;
                                    }
                                    RegSetInfoUI.this.yao.setText(strArr[i]);
                                    RegSetInfoUI.this.yao.postDelayed(new Runnable() {
                                        public final void run() {
                                            RegSetInfoUI.this.yao.clearFocus();
                                            RegSetInfoUI.this.yao.requestFocus();
                                        }
                                    }, 50);
                                    RegSetInfoUI.this.yat.setText(RegSetInfoUI.this.getString(R.l.eED));
                                }
                            });
                        }
                    }
                    S(true, true);
                    return;
                } else if (bi.oN(this.yao.getText().toString().trim())) {
                    S(false, false);
                    return;
                } else {
                    S(true, false);
                    this.yat.setText(getString(R.l.eED));
                    if (this.yaI != null) {
                        this.yaI.dismiss();
                        this.yaI = null;
                    }
                    this.yao.postDelayed(new Runnable() {
                        public final void run() {
                            RegSetInfoUI.this.yao.clearFocus();
                            RegSetInfoUI.this.yao.requestFocus();
                        }
                    }, 50);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                S(true, true);
            } else if (this.xSF == null) {
                kVar2 = kVar;
                kVar2 = kVar;
                this.xSF = SecurityImage.a.a(this.mController.xRr, R.l.eEv, 0, ((x) kVar).Ou(), ((x) kVar).Ov(), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = RegSetInfoUI.this.xZG.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.yao.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            h.h(RegSetInfoUI.this, R.l.eSV, R.l.eEe);
                            return;
                        }
                        RegSetInfoUI.this.aWY();
                        int e = RegSetInfoUI.this.cpa();
                        String f = RegSetInfoUI.this.cpb();
                        as.CN().a(429, RegSetInfoUI.this);
                        final k xVar = new x(f, RegSetInfoUI.this.liu, e, trim, trim2, ((x) kVar2).Ov(), RegSetInfoUI.this.xSF.cpt());
                        as.CN().a(xVar, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(R.l.dGZ);
                        regSetInfoUI.inI = h.a(context, RegSetInfoUI.this.getString(R.l.eEu), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(xVar);
                                as.CN().b(429, RegSetInfoUI.this);
                            }
                        });
                    }
                }, null, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        RegSetInfoUI.this.xSF = null;
                    }
                }, new SecurityImage.b() {
                    public final void cox() {
                        RegSetInfoUI.this.aWY();
                        int e = RegSetInfoUI.this.cpa();
                        String f = RegSetInfoUI.this.cpb();
                        as.CN().a(429, RegSetInfoUI.this);
                        as.CN().a(new x(f, RegSetInfoUI.this.liu, e, "", "", ((x) kVar2).Ov(), ""), 0);
                    }
                });
                return;
            } else {
                this.xSF.a(0, ((x) kVar).Ou(), ((x) kVar).Ov(), "");
                return;
            }
        }
        if (!o(i, i2, str)) {
            if (i == 8) {
                this.yaG = getString(R.l.eiQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, this.yaG, 0).show();
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(R.l.ejm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean o(int i, int i2, String str) {
        if (this.xXp.a(this, new com.tencent.mm.pluginsdk.h.o(i, i2, str))) {
            return true;
        }
        if (com.tencent.mm.plugin.c.a.ihO.a(this.mController.xRr, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -100:
                as.hold();
                h.a(this.mController.xRr, TextUtils.isEmpty(as.Cp()) ? com.tencent.mm.bu.a.ac(this.mController.xRr, R.l.euH) : as.Cp(), this.mController.xRr.getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -75:
                h.h(this, R.l.dDR, R.l.eDj);
                return true;
            case -48:
                com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this, null, null);
                } else {
                    h.b(this, getString(R.l.eEC), "", true);
                }
                return true;
            case -10:
            case -7:
                h.h(this, R.l.eDi, R.l.eDj);
                return true;
            default:
                return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    private void bpd() {
        aWY();
        if (coX()) {
            h.a((Context) this, getString(R.l.eEx), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent;
                    b.oZ("R200_100");
                    if (com.tencent.mm.y.bi.HU().HV() == 0) {
                        intent = new Intent(RegSetInfoUI.this, MobileInputUI.class);
                        intent.putExtra("mobile_input_purpose", 2);
                    } else {
                        intent = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
                    }
                    intent.addFlags(67108864);
                    RegSetInfoUI.this.startActivity(intent);
                    RegSetInfoUI.this.finish();
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (!coY()) {
            if ((this.sceneType == 0 ? 1 : null) != null) {
                h.a((Context) this, getString(R.l.eEw), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.oZ("R400_100_signup");
                        Intent intent = new Intent(RegSetInfoUI.this, LoginUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI.this.startActivity(intent);
                        RegSetInfoUI.this.finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (coZ()) {
                h.a((Context) this, getString(R.l.eEw), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.oZ("R500_100");
                        Intent intent = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI.this.startActivity(intent);
                        RegSetInfoUI.this.finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                b.oZ("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }
}
