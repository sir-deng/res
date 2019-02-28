package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.q;
import com.tencent.rtmp.TXLiveConstants;

public class RemittanceDetailUI extends WalletBaseUI {
    public TextView omB = null;
    private String pRX = null;
    private int pRY;
    public String pSc = null;
    public int pUA;
    public int pUB;
    public String pUC = null;
    public String pUD = null;
    protected String pUE = null;
    public int pUF = 3;
    protected boolean pUG = false;
    protected int pUH;
    private int pUI;
    private t pUJ;
    private c<nd> pUK = new c<nd>() {
        {
            this.xmG = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final nd ndVar = (nd) bVar;
            if (!(bi.oN(ndVar.fFT.fvD) || bi.oN(ndVar.fFT.fFn))) {
                h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(i.uTT, new Object[]{RemittanceDetailUI.ax(RemittanceDetailUI.this.pgB, false)}), RemittanceDetailUI.this.getString(i.dGE), RemittanceDetailUI.this.getString(i.uTY), RemittanceDetailUI.this.getString(i.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        k tVar = new t(ndVar.fFT.fvD, ndVar.fFT.fFn, ndVar.fFT.fFU, "refuse", ndVar.fFT.fFV, ndVar.fFT.fFW);
                        tVar.gQd = "RemittanceProcess";
                        RemittanceDetailUI.this.l(tVar);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            return false;
        }
    };
    public ImageView pUu = null;
    public TextView pUv = null;
    public TextView pUw = null;
    public Button pUx = null;
    public TextView pUy = null;
    public TextView pUz = null;
    private String pgB;
    private String pgu;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pUA = getIntent().getIntExtra("invalid_time", 0);
        this.pUB = getIntent().getIntExtra("appmsg_type", 0);
        this.pUC = getIntent().getStringExtra("transaction_id");
        this.pUE = getIntent().getStringExtra("bill_id");
        this.pSc = getIntent().getStringExtra("transfer_id");
        this.pUD = getIntent().getStringExtra("sender_name");
        this.pUF = getIntent().getIntExtra("effective_date", 3);
        this.pUG = getIntent().getBooleanExtra("is_sender", false);
        this.pUH = getIntent().getIntExtra("total_fee", 0);
        initView();
        vN(0);
        getIntent();
        a.xmy.b(this.pUK);
    }

    public void onDestroy() {
        a.xmy.c(this.pUK);
        super.onDestroy();
    }

    public void vN(int i) {
        b(new w(i, this.pUC, this.pSc, this.pUA), true);
    }

    protected final void initView() {
        setMMTitle(i.uUK);
        this.pUu = (ImageView) findViewById(f.uCf);
        this.pUv = (TextView) findViewById(f.uCi);
        this.pUw = (TextView) findViewById(f.uCg);
        this.pUx = (Button) findViewById(f.uCe);
        this.omB = (TextView) findViewById(f.uCh);
        this.pUy = (TextView) findViewById(f.uCj);
        this.pUz = (TextView) findViewById(f.uCk);
    }

    public void vO(int i) {
        k hVar;
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new com.tencent.mm.plugin.order.model.h(this.pUC, this.pUE, i);
        } else {
            hVar = new com.tencent.mm.plugin.order.model.h(this.pSc, this.pUE, i);
        }
        hVar.gQd = "RemittanceProcess";
        l(hVar);
    }

    public void T(Intent intent) {
        d.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }

    public void boD() {
        k tVar = new t(this.pUC, this.pSc, this.pUH, "confirm", this.pUD, this.pUA);
        tVar.gQd = "RemittanceProcess";
        l(tVar);
    }

    public void boE() {
        k tVar = new t(this.pUC, this.pSc, this.pUH, "refuse", this.pUD, this.pUA);
        tVar.gQd = "RemittanceProcess";
        l(tVar);
    }

    private void bos() {
        if (this.pUI == 0 || this.pRY != 1 || bi.oN(this.pRX)) {
            x.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", Integer.valueOf(this.pUI), Boolean.valueOf(bi.oN(this.pRX)));
            this.mController.removeAllOptionMenu();
            return;
        }
        addIconOptionMenu(0, e.ukw, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.wallet_core.ui.e.l(RemittanceDetailUI.this.mController.xRr, RemittanceDetailUI.this.pRX, false);
                return false;
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof w) {
            final w wVar = (w) kVar;
            if (i == 0 && i2 == 0) {
                if (wVar != null) {
                    if (wVar.pRh) {
                        this.pgB = q.FY();
                        this.pgu = this.pUD;
                    } else {
                        this.pgB = this.pUD;
                        this.pgu = q.FY();
                    }
                    boolean equals = q.FY().equals(this.pgu);
                    this.pUx.setVisibility(8);
                    this.pUw.setText(com.tencent.mm.wallet_core.ui.e.d(wVar.loS, wVar.pgf));
                    CharSequence charSequence = wVar.pRj;
                    if (!bi.oN(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", ax(this.pgu, true));
                    }
                    CharSequence charSequence2 = wVar.pRk;
                    Object bundle = new Bundle();
                    bundle.putString("transaction_id", this.pUC);
                    bundle.putString("receiver_name", this.pgu);
                    bundle.putString("transfer_id", this.pSc);
                    bundle.putInt("total_fee", this.pUH);
                    bundle.putString("sender_name", this.pUD);
                    bundle.putInt("invalid_time", this.pUA);
                    this.omB.setClickable(true);
                    this.pUv.setClickable(true);
                    int i3 = wVar.status;
                    x.d("MicroMsg.RemittanceDetailUI", "status: %d", Integer.valueOf(i3));
                    String string;
                    String string2;
                    CharSequence spannableString;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            com.tencent.mm.plugin.order.c.a aVar;
                            if (equals) {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNj);
                                this.pUx.setVisibility(0);
                                this.pUx.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        o.bLX();
                                        if (!o.a(RemittanceDetailUI.this, RemittanceDetailUI.this.zSi, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                                            public final boolean b(int i, int i2, String str, boolean z) {
                                                if (i == 2) {
                                                    RemittanceDetailUI.this.boD();
                                                } else if (i == 0 && z) {
                                                    RemittanceDetailUI.this.boD();
                                                }
                                                return true;
                                            }
                                        })) {
                                            RemittanceDetailUI.this.boD();
                                        }
                                    }
                                });
                                if (bi.oN(charSequence) || bi.oN(charSequence2)) {
                                    this.pUv.setText(i.uUf);
                                    if (wVar.pRl == 0) {
                                        string = getString(i.uUi, new Object[]{Integer.valueOf(this.pUF)});
                                    } else if (bi.oN(wVar.pRk)) {
                                        x.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = wVar.pRl == 1 ? "24" : "2";
                                        string = getString(i.uUh, new Object[]{string}) + getString(i.uUi, new Object[]{Integer.valueOf(this.pUF)});
                                    } else {
                                        string = wVar.pRk;
                                    }
                                    string2 = getString(i.uTX);
                                    charSequence2 = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.piR = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(i.uTT, new Object[]{RemittanceDetailUI.ax(wVar.pRg, false)}), RemittanceDetailUI.this.getString(i.dGE), RemittanceDetailUI.this.getString(i.uTY), RemittanceDetailUI.this.getString(i.dEy), new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    RemittanceDetailUI.this.boE();
                                                }
                                            }, new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            });
                                        }
                                    };
                                    charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.omB.setText(charSequence2);
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                    this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                    this.pUv.setOnTouchListener(new l());
                                    this.omB.setOnTouchListener(new l());
                                }
                            } else if (bi.oN(charSequence) || bi.oN(charSequence2)) {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(i.uUg, new Object[]{ax(this.pgu, true)}), this.pUv.getTextSize()));
                                string = getString(i.uUm, new Object[]{Integer.valueOf(this.pUF)});
                                string2 = getString(i.uUF);
                                charSequence2 = new SpannableString(string + string2);
                                aVar = new com.tencent.mm.plugin.order.c.a(this);
                                aVar.piR = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(i.uTH), RemittanceDetailUI.this.getString(i.dGE), RemittanceDetailUI.this.getString(i.uUE), RemittanceDetailUI.this.getString(i.dEy), new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", RemittanceDetailUI.this.pUC);
                                                intent.putExtra("receiver_name", RemittanceDetailUI.this.pgu);
                                                RemittanceDetailUI.this.T(intent);
                                            }
                                        }, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(charSequence2);
                            } else {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                this.pUv.setOnTouchListener(new l());
                                this.omB.setOnTouchListener(new l());
                            }
                            this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNj);
                            this.pUy.setText(getString(i.uUo, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRe)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setVisibility(8);
                            break;
                        case 2001:
                            this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNg);
                            if (!bi.oN(charSequence) && !bi.oN(charSequence2)) {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                this.pUv.setOnTouchListener(new l());
                                this.omB.setOnTouchListener(new l());
                            } else if (equals) {
                                this.pUv.setText(i.uUa);
                                charSequence = new SpannableStringBuilder(getString(i.uTL));
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(this);
                                aVar2.piR = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.h.Y(RemittanceDetailUI.this, 0);
                                    }
                                };
                                charSequence.setSpan(aVar2, 0, charSequence.length(), 18);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(charSequence);
                                this.omB.setVisibility(0);
                            } else {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, ax(this.pgu, true) + getString(i.uUa), this.pUv.getTextSize()));
                                this.omB.setText(i.uUl);
                                this.omB.setVisibility(0);
                            }
                            this.pUy.setText(getString(i.uUo, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRe)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setText(getString(i.uTP, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRi)}));
                            this.pUz.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNh);
                                if (!bi.oN(charSequence)) {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                    this.pUv.setOnTouchListener(new l());
                                } else if (equals) {
                                    this.pUv.setText(i.uUc);
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, ax(this.pgu, true) + getString(i.uUc), this.pUv.getTextSize()));
                                }
                            } else {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNi);
                                if (bi.oN(charSequence)) {
                                    this.pUv.setText(i.uUe);
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                    this.pUv.setOnTouchListener(new l());
                                }
                            }
                            if (equals) {
                                this.omB.setVisibility(8);
                            } else {
                                if (!bi.oN(charSequence2)) {
                                    this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                    this.omB.setOnTouchListener(new l());
                                } else if ("CFT".equals(wVar.pgD) || "LQT".equals(wVar.pgD)) {
                                    final boolean equals2 = "LQT".equals(wVar.pgD);
                                    string2 = equals2 ? getString(i.uTW) : getString(i.uTU);
                                    string = equals2 ? getString(i.uTM) : getString(i.uTL);
                                    spannableString = new SpannableString(string2 + string);
                                    com.tencent.mm.plugin.order.c.a aVar3 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar3.piR = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            if (equals2) {
                                                d.y(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                            } else {
                                                com.tencent.mm.pluginsdk.wallet.h.Y(RemittanceDetailUI.this, 0);
                                            }
                                        }
                                    };
                                    spannableString.setSpan(aVar3, string2.length(), string.length() + string2.length(), 33);
                                    this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.omB.setText(spannableString);
                                } else {
                                    this.omB.setText(i.uTV);
                                }
                                this.omB.setVisibility(0);
                            }
                            this.pUy.setText(getString(i.uUo, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRe)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setText(getString(i.uTS, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRi)}));
                            this.pUz.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                            if (equals) {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNj);
                                if (bi.oN(charSequence) || bi.oN(charSequence2)) {
                                    if (bi.oN(wVar.pRj)) {
                                        this.pUv.setText(i.uUb);
                                    } else {
                                        this.pUv.setText(wVar.pRj);
                                    }
                                    if (bi.oN(wVar.pRk)) {
                                        this.omB.setText(i.uTR);
                                    } else {
                                        this.omB.setText(wVar.pRk);
                                    }
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                    this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                    this.pUv.setOnTouchListener(new l());
                                    this.omB.setOnTouchListener(new l());
                                }
                            } else {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNj);
                                if (bi.oN(charSequence) || bi.oN(charSequence2)) {
                                    if (!bi.oN(wVar.pRj)) {
                                        try {
                                            this.pUv.setText(String.format(wVar.pRj, new Object[]{ax(this.pgu, true)}));
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (bi.oN(wVar.pRk)) {
                                            this.omB.setText(wVar.pRk);
                                        } else {
                                            this.omB.setText("");
                                        }
                                    }
                                    this.pUv.setText(getString(i.uUd, new Object[]{ax(this.pgu, true)}));
                                    if (bi.oN(wVar.pRk)) {
                                        this.omB.setText("");
                                    } else {
                                        this.omB.setText(wVar.pRk);
                                    }
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                    this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                    this.pUv.setOnTouchListener(new l());
                                    this.omB.setOnTouchListener(new l());
                                }
                            }
                            this.pUy.setText(getString(i.uUo, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRe)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setText(getString(i.uTP, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRi)}));
                            this.pUz.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                            this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNf);
                            if (bi.oN(charSequence) || bi.oN(charSequence2)) {
                                if (bi.oN(wVar.pRj)) {
                                    this.pUv.setText(i.uTZ);
                                } else {
                                    this.pUv.setText(wVar.pRj);
                                }
                                if (bi.oN(wVar.pRk)) {
                                    if (equals) {
                                        this.omB.setText(i.uTQ);
                                    } else {
                                        this.omB.setText(i.uUk);
                                    }
                                } else if ("CFT".equals(wVar.pgD) || "LQT".equals(wVar.pgD)) {
                                    equals = "LQT".equals(wVar.pgD);
                                    Object obj = wVar.pRk;
                                    charSequence = equals ? getString(i.uTM) : getString(i.uTL);
                                    spannableString = new SpannableStringBuilder();
                                    spannableString.append(obj);
                                    spannableString.append(charSequence);
                                    com.tencent.mm.plugin.order.c.a aVar4 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar4.piR = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            if (equals) {
                                                d.y(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                            } else {
                                                com.tencent.mm.pluginsdk.wallet.h.Y(RemittanceDetailUI.this, 0);
                                            }
                                        }
                                    };
                                    spannableString.setSpan(aVar4, obj.length(), spannableString.length(), 18);
                                    this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.omB.setText(spannableString);
                                } else {
                                    this.omB.setText(wVar.pRk);
                                }
                            } else {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence, (int) this.pUv.getTextSize(), bundle));
                                this.omB.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence2, (int) this.omB.getTextSize(), bundle));
                                this.pUv.setOnTouchListener(new l());
                                this.omB.setOnTouchListener(new l());
                            }
                            this.pUy.setText(getString(i.uUo, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRe)}));
                            this.pUy.setVisibility(0);
                            if (wVar.pRi <= 0) {
                                this.pUz.setVisibility(8);
                                break;
                            }
                            this.pUz.setText(getString(i.uTK, new Object[]{com.tencent.mm.wallet_core.ui.e.gT(wVar.pRi)}));
                            this.pUz.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    if (!bi.oN(wVar.pRm)) {
                        com.tencent.mm.wallet_core.ui.e.a((TextView) findViewById(f.ulY), "7", wVar.pRm, wVar.pRn);
                    }
                }
                this.pUI = wVar.pRl;
                g.Dr();
                this.pRX = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
                g.Dr();
                this.pRY = ((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
                if (bi.oN(this.pRX)) {
                    ae.a(true, this.zSi);
                } else {
                    ae.a(false, this.zSi);
                }
                bos();
                if (wVar.pgN == 1) {
                    g.Dr();
                    if (((String) g.Dq().Db().get(327729, (Object) "0")).equals("0")) {
                        h.a(this.mController.xRr, q.Gl() ? i.uOG : i.vcE, i.vcF, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                h.bu(RemittanceDetailUI.this.mController.xRr, RemittanceDetailUI.this.getString(i.uTN));
                            }
                        });
                        g.Dr();
                        g.Dq().Db().set(327729, "1");
                    } else if (this.pUI == 0) {
                        h.bu(this.mController.xRr, getString(i.uTN));
                    }
                }
                return true;
            }
        } else if (kVar instanceof t) {
            if (i == 0 && i2 == 0) {
                this.pUJ = (t) kVar;
                if ("confirm".equals(this.pUJ.pQt)) {
                    vN(1);
                } else {
                    aE(0, getString(i.uTO));
                }
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle2, 1008);
            } else {
                aE(i2, str);
                return true;
            }
        } else if (kVar instanceof ae) {
            if (i == 0 && i2 == 0) {
                this.pRX = ((ae) kVar).sPg;
                this.pRY = ((ae) kVar).sPh;
                bos();
            } else {
                x.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uKB;
    }

    public final void aE(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
    }

    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.pUJ == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, this.pUJ, bundle, true, null, 1008, 1)) {
            super.finish();
        } else {
            this.pUJ = null;
        }
    }

    public static String ax(String str, boolean z) {
        String gw = com.tencent.mm.wallet_core.ui.e.gw(str);
        if (gw == null) {
            return "";
        }
        if (gw.length() <= 10 || !z) {
            return gw;
        }
        return gw.substring(0, 8) + "...";
    }
}
