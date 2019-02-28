package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import java.lang.reflect.Method;
import java.util.Iterator;

public final class b extends u {
    private eg jTF;
    private TextView jTG;
    private TextView jTH;
    private MMFormVerifyCodeInputView jTI;
    private AppBrandNumberKeyboardView jTJ;
    a jTe;
    private LinearLayout jTf;
    private View jTg;
    private Button jTj;
    private eh jTx;
    private TextView jbl;
    private com.tencent.mm.ui.b mActionBarHelper;

    protected final void dealContentView(View view) {
        if (this.jTe == null || this.jTe.alI() == null) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
        } else if (this.jTe.alI().vQm == null || this.jTe.alI().vQm.size() <= 0) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
        } else {
            this.jTf = (LinearLayout) view.findViewById(g.iwF);
            this.jbl = (TextView) view.findViewById(g.iwC);
            this.jTG = (TextView) view.findViewById(g.iwG);
            this.jTH = (TextView) view.findViewById(g.iwH);
            this.jTj = (Button) view.findViewById(g.iwr);
            this.jTI = (MMFormVerifyCodeInputView) view.findViewById(g.iwD);
            this.jTJ = (AppBrandNumberKeyboardView) view.findViewById(g.iwE);
            this.jTg = v.fw(getContext()).inflate(h.dac, null);
            this.jTg.setBackgroundColor(getResources().getColor(d.bre));
            this.mActionBarHelper = new com.tencent.mm.ui.b(this.jTg);
            this.jTf.addView(this.jTg, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.cj(getActivity())));
            this.jTx = this.jTe.alI();
            this.mActionBarHelper.setTitle(this.jTx.title);
            this.mActionBarHelper.o(new OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.jTe != null) {
                        b.this.jTe.back();
                    }
                }
            });
            this.jbl.setText(this.jTx.desc);
            this.jTF = (eg) this.jTx.vQm.get(0);
            this.jTG.setText(((eg) this.jTx.vQm.get(0)).vQl);
            this.jTH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.jTe != null) {
                        b.this.jTe.alG();
                    }
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(b.this.getContext(), com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new c() {
                        public final void a(n nVar) {
                            x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", Integer.valueOf(b.this.jTx.vQm.size()));
                            Iterator it = b.this.jTx.vQm.iterator();
                            while (it.hasNext()) {
                                eg egVar = (eg) it.next();
                                if (bi.oN(egVar.vQk) || bi.oN(egVar.vQl)) {
                                    x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                                } else {
                                    nVar.f(b.this.jTx.vQm.indexOf(egVar), egVar.vQl);
                                }
                            }
                        }
                    };
                    gVar.rQG = new p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            eg egVar = (eg) b.this.jTx.vQm.get(menuItem.getItemId());
                            if (egVar == null) {
                                x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", Integer.valueOf(menuItem.getItemId()));
                                return;
                            }
                            x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", Integer.valueOf(menuItem.getItemId()), egVar.vQk, egVar.vQl, egVar.pff);
                            b.this.jTF = egVar;
                            b.this.jTG.setText(egVar.vQl);
                        }
                    };
                    gVar.bUX();
                }
            });
            this.jTI.setVisibility(0);
            this.jTI.yjj = new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.ui.base.h.a(b.this.getContext(), b.this.getString(j.iCb) + b.this.jTF.vQl, b.this.getString(j.iCa), b.this.getString(j.dGf), b.this.getString(j.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.jTI.cpN();
                            x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
                            if (b.this.jTe != null) {
                                b.this.jTe.a(b.this.jTF);
                            }
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.jTI.reset();
                        }
                    });
                }
            };
            this.jTI.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    if (b.this.jTI.getText().toString().length() > 0) {
                        b.this.jTj.setEnabled(true);
                    } else {
                        b.this.jTj.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            View view2 = this.jTI.pwv;
            if (view2 != null) {
                if (VERSION.SDK_INT >= 21) {
                    view2.setShowSoftInputOnFocus(false);
                } else {
                    Class cls = EditText.class;
                    try {
                        Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(view2, new Object[]{Boolean.valueOf(false)});
                        method.setAccessible(false);
                    } catch (NoSuchMethodException e) {
                        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                        try {
                            Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                            method2.setAccessible(true);
                            method2.invoke(view2, new Object[]{Boolean.valueOf(false)});
                            method2.setAccessible(false);
                        } catch (Throwable e2) {
                            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", bi.i(e2));
                            if (view2.getContext() != null && (view2.getContext() instanceof MMActivity)) {
                                ((MMActivity) view2.getContext()).df(view2);
                            }
                        }
                    } catch (Throwable e22) {
                        x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", bi.i(e22));
                    }
                }
            }
            if (this.jTI.getText() == null || this.jTI.getText().toString().length() <= 0) {
                this.jTj.setEnabled(false);
            } else {
                this.jTj.setEnabled(true);
            }
            this.jTj.setVisibility(0);
            this.jTj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
                    if (b.this.jTe != null) {
                        b.this.jTe.a(b.this.jTI.getText().toString(), b.this.jTF);
                    }
                }
            });
            this.jTJ.setXMode(0);
            this.jTJ.setInputEditText(this.jTI.pwv);
        }
    }

    protected final int getLayoutId() {
        return h.izr;
    }

    public final void onResume() {
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().mEnable = true;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final void onSwipeBack() {
        if (this.jTe != null) {
            this.jTe.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().mEnable = false;
            }
        }
    }
}
