package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.q;

@a(17)
public class SnsCommentUI extends MMActivity implements e {
    private int fvb;
    private int qXb;
    private SnsEditText rHu;
    private int rHv = 0;
    private boolean rHw = false;
    private boolean rHx = false;
    private r tipDialog = null;

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        m xG = ae.bwf().xG(snsCommentUI.qXb);
        if (xG != null) {
            snsCommentUI.rHw = true;
            if (xG.byZ()) {
                al.a.a(xG, 2, str, "", snsCommentUI.fvb);
            } else {
                al.a.a(xG.field_userName, 3, str, xG, snsCommentUI.fvb);
            }
            snsCommentUI.aWY();
            snsCommentUI.getString(j.dGZ);
            snsCommentUI.tipDialog = h.a((Context) snsCommentUI, snsCommentUI.getString(j.dGM), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        if (!snsCommentUI.isFinishing()) {
            q.FY();
            aw awVar = new aw(2);
            awVar.Le(str);
            if (snsCommentUI.rHu.rHB > com.tencent.mm.plugin.sns.c.a.qWI) {
                awVar.xe(2);
            }
            awVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qXb = getIntent().getIntExtra("sns_comment_localId", 0);
        this.rHv = getIntent().getIntExtra("sns_comment_type", 0);
        this.fvb = getIntent().getIntExtra("sns_source", 0);
        g.Dr();
        g.Dp().gRu.a((int) c.CTRL_INDEX, (e) this);
        initView();
    }

    public void onPause() {
        super.onPause();
        if (this.rHu != null) {
            String trim = this.rHu.getText().toString().trim();
            g.Dr();
            g.Dq().Db().set(68408, trim);
            if (bi.oN(trim)) {
                g.Dr();
                g.Dq().Db().set(7489, Integer.valueOf(0));
                return;
            }
            g.Dr();
            g.Dq().Db().set(7489, Integer.valueOf(this.rHu.rHB));
        }
    }

    public void onResume() {
        super.onResume();
        showVKB();
    }

    public void onDestroy() {
        super.onDestroy();
        g.Dr();
        g.Dp().gRu.b((int) c.CTRL_INDEX, (e) this);
    }

    protected final void initView() {
        this.rHu = (SnsEditText) findViewById(f.content);
        this.rHu.setTextSize(1, (ac.ev(this.mController.xRr) * this.rHu.getTextSize()) / com.tencent.mm.bu.a.getDensity(this.mController.xRr));
        a(0, getString(j.dGL), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                if (SnsCommentUI.this.rHv == 0) {
                    b.zI();
                }
                if (SnsCommentUI.this.rHv == 2) {
                    i = 200;
                } else {
                    i = b.zH();
                }
                com.tencent.mm.ui.tools.a.c Hg = com.tencent.mm.ui.tools.a.c.d(SnsCommentUI.this.rHu).Hg(i);
                Hg.zwQ = true;
                Hg.a(new com.tencent.mm.ui.tools.a.c.a() {
                    public final void vE(String str) {
                        String trim = SnsCommentUI.this.rHu.getText().toString().trim();
                        SnsCommentUI.this.rHu.setText("");
                        if (trim.length() > 0) {
                            switch (SnsCommentUI.this.rHv) {
                                case 0:
                                    SnsCommentUI.this.aWY();
                                    SnsCommentUI.a(SnsCommentUI.this, trim);
                                    return;
                                case 1:
                                    SnsCommentUI.this.aWY();
                                    SnsCommentUI.b(SnsCommentUI.this, trim);
                                    return;
                                case 2:
                                    SnsCommentUI.this.aWY();
                                    long longExtra = SnsCommentUI.this.getIntent().getLongExtra("sns_id", 0);
                                    long longExtra2 = SnsCommentUI.this.getIntent().getLongExtra("action_st_time", 0);
                                    String aD = bi.aD(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                                    trim = bi.aD(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    com.tencent.mm.plugin.sns.f.h bwY = ae.bvX().bwY();
                                    if (bwY != null && bwY.bwZ()) {
                                        String str2 = bwY.rfU;
                                        String str3 = bwY.rfT;
                                        x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + aD + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                                        com.tencent.mm.plugin.report.service.g.pWK.h(11988, str2, str3, "", "", i.er(longExtra), aD, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
                                        SnsCommentUI.this.rHx = true;
                                        SnsCommentUI.this.finish();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }

                    public final void anp() {
                    }

                    public final void aeD() {
                        h.h(SnsCommentUI.this, j.qSK, j.qSL);
                    }
                });
                return false;
            }
        }, p.b.xSe);
        if (this.rHv == 0) {
            setMMTitle(j.qQu);
        } else if (this.rHv == 1) {
            setMMTitle(j.qSQ);
            g.Dr();
            String aD = bi.aD((String) g.Dq().Db().get(68408, (Object) ""), "");
            g.Dr();
            this.rHu.rHB = bi.a((Integer) g.Dq().Db().get(7489, Integer.valueOf(0)), 0);
            this.rHu.append(bi.aD(aD, ""));
            if (aD == null || aD.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.rHv == 2) {
            setMMTitle(j.qQa);
            enableOptionMenu(false);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsCommentUI.this.aWY();
                SnsCommentUI.this.finish();
                return true;
            }
        });
        this.rHu.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (SnsCommentUI.this.rHu.getText().toString().trim().length() > 0) {
                    SnsCommentUI.this.enableOptionMenu(true);
                } else {
                    SnsCommentUI.this.enableOptionMenu(false);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qNo;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (kVar.getType()) {
            case c.CTRL_INDEX /*213*/:
                if (this.rHw) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        if (!this.rHx && this.rHv == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String aD = bi.aD(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = bi.aD(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.f.h bwY = ae.bvX().bwY();
            if (bwY != null && bwY.bwZ()) {
                String str2 = bwY.rfU;
                String str3 = bwY.rfT;
                x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + aD + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
                com.tencent.mm.plugin.report.service.g.pWK.h(11988, str2, str3, "", "", i.er(longExtra), aD, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aWY();
        finish();
        return true;
    }
}
