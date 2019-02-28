package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static class b {
        public List<String[]> pIc;
        public com.tencent.mm.plugin.recharge.model.a pId = null;
        public MallFormView pJK = null;
        public d pJL;
        boolean pJM = false;

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$3 */
        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pJO;

            public AnonymousClass3(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pJO = instantAutoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.pId = b.this.pJL.vD(i);
                if (b.this.pId != null) {
                    x.i(c.TAG, "onItemClick record.record " + b.this.pId.pHq + ", record.name " + b.this.pId.name);
                    b.this.pJM = true;
                    b.this.b(b.this.pId);
                } else {
                    x.w(c.TAG, "record is null");
                }
                this.pJO.dismissDropDown();
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$5 */
        class AnonymousClass5 implements OnClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pJO;

            public AnonymousClass5(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pJO = instantAutoCompleteTextView;
            }

            public final void onClick(View view) {
                this.pJO.requestFocus();
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$4 */
        class AnonymousClass4 implements OnFocusChangeListener {
            final /* synthetic */ InstantAutoCompleteTextView pJO;

            public AnonymousClass4(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pJO = instantAutoCompleteTextView;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.pJO.setHintTextColor(view.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhg));
                    if (b.this.pId != null && b.this.pId.fqY == 2 && !b.this.pJM) {
                        x.d(c.TAG, "clear input");
                        b.this.pJK.bnq();
                        b.this.pId = null;
                    } else if (b.this.pJM) {
                        b.this.pJM = false;
                    }
                    if (bi.oN(this.pJO.getText().toString())) {
                        this.pJO.showDropDown();
                    }
                }
            }
        }

        public b(MallFormView mallFormView) {
            this.pJK = mallFormView;
        }

        public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
            this.pId = aVar;
            if (aVar != null) {
                if (bi.oN(this.pJK.getText()) || !this.pJK.getText().equals(aVar.pHq)) {
                    this.pJK.pJQ.setText(com.tencent.mm.plugin.recharge.model.b.IJ(aVar.pHq));
                }
                this.pJK.pJQ.setSelection(this.pJK.pJQ.getText().length());
                x.d(c.TAG, "editTv.setText %s, name: %s, location: %s, type: %s", aVar.pHq, aVar.name, aVar.pHr, Integer.valueOf(aVar.fqY));
                Context context = this.pJK.getContext();
                if (this.pId.fqY == 3) {
                    this.pJK.pJS.setText(this.pId.name);
                    this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhK));
                    return;
                } else if (this.pId.fqY == 1) {
                    CharSequence string;
                    if (bi.oN(this.pId.name)) {
                        string = context.getString(i.vcy);
                        if (!bi.oN(this.pId.pHr)) {
                            string = string + context.getString(i.vcq, new Object[]{this.pId.pHr});
                        }
                        this.pJK.pJS.setText(string);
                        this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhG));
                        return;
                    }
                    string = this.pId.name;
                    if (!bi.oN(this.pId.pHr)) {
                        string = string + context.getString(i.vcq, new Object[]{this.pId.pHr});
                    }
                    this.pJK.pJS.setText(string);
                    this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    return;
                } else if (this.pId.fqY == 2) {
                    if (bi.oN(this.pId.pHr)) {
                        this.pJK.pJS.setText("");
                        this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhG));
                        return;
                    }
                    this.pJK.pJS.setText(this.pId.pHr);
                    this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    return;
                } else if (this.pId.fqY != 0) {
                    return;
                } else {
                    if (bi.oN(this.pId.pHr)) {
                        if (bi.oN(this.pId.name)) {
                            this.pJK.pJS.setText("");
                            this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                            return;
                        }
                        this.pJK.pJS.setText(this.pId.name);
                        this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhG));
                        return;
                    } else if (bi.oN(this.pId.name)) {
                        this.pJK.pJS.setText(this.pId.pHr);
                        this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                        return;
                    } else {
                        this.pJK.pJS.setText(this.pId.name + context.getString(i.vcq, new Object[]{this.pId.pHr}));
                        this.pJK.pJS.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhG));
                        return;
                    }
                }
            }
            this.pJK.pJQ.setText("");
            x.d(c.TAG, "editTv.setText null");
            this.pJK.pJS.setText("");
        }

        public final void hC(boolean z) {
            List arrayList;
            x.d(c.TAG, "needSetInput: %s", Boolean.valueOf(z));
            List bmY = com.tencent.mm.plugin.recharge.a.a.bmX().bmY();
            com.tencent.mm.plugin.recharge.model.a bmZ;
            if (bmY == null) {
                arrayList = new ArrayList();
                bmZ = com.tencent.mm.plugin.recharge.a.a.bmZ();
                if (bmZ != null) {
                    arrayList.add(bmZ);
                    com.tencent.mm.plugin.recharge.a.a.bmX().a(bmZ);
                }
            } else {
                String str = (String) g.Dq().Db().get(6, null);
                for (int i = 0; i < bmY.size(); i++) {
                    bmZ = (com.tencent.mm.plugin.recharge.model.a) bmY.get(i);
                    if (bi.oN(bmZ.pHq) || !bmZ.pHq.equals(str)) {
                        if (!(bi.oN(bmZ.pHq) || !bi.oN(bmZ.name) || this.pIc == null)) {
                            for (String[] strArr : this.pIc) {
                                if (bmZ.pHq.equals(com.tencent.mm.plugin.recharge.model.b.II(strArr[2]))) {
                                    bmZ.name = strArr[1];
                                    x.i(c.TAG, "add name: %s", strArr[1]);
                                    break;
                                }
                            }
                        }
                    } else if (bi.oN(bmZ.name) || !bmZ.name.equals(this.pJK.getContext().getString(i.vcw))) {
                        bmZ.name = this.pJK.getContext().getString(i.vcw);
                    } else {
                    }
                    com.tencent.mm.plugin.recharge.a.a.bmX().bv(bmY);
                }
                arrayList = bmY;
            }
            this.pJL.bv(arrayList);
            if (arrayList != null && arrayList.size() > 0 && z) {
                this.pId = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                b(this.pId);
            }
        }
    }

    private static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public boolean a(MallFormView mallFormView) {
            return true;
        }

        public boolean bnn() {
            return false;
        }

        public String IN(String str) {
            return null;
        }
    }

    public static void b(MallFormView mallFormView) {
        if (mallFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            mallFormView.pJX = new a() {
                public final boolean a(MallFormView mallFormView) {
                    return PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.II(mallFormView.getText().toString()));
                }

                public final boolean bnn() {
                    return true;
                }

                public final String IN(String str) {
                    return str == null ? "" : str.replaceAll(" ", "");
                }
            };
        }
    }
}
