package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.be.f;
import com.tencent.mm.be.j;
import com.tencent.mm.be.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.as;

public final class a extends LinearLayout implements e {
    static a vzH;
    private Context context;
    private TextView ipP;
    r tipDialog;
    private Button vzI;

    public static class a {
        public String mTU;
        public int scene;
        public String talker;
        public int type;
        public String vzN;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.ui.preference.a r12, java.lang.String r13) {
        /*
        r7 = 0;
        r11 = 0;
        r10 = 1;
        r0 = vzH;
        if (r0 != 0) goto L_0x0011;
    L_0x0007:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "FMessage Args is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0010:
        return;
    L_0x0011:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "try to reply verify content";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = vzH;
        r0 = r0.talker;
        r2.add(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = vzH;
        r0 = r0.scene;
        r0 = java.lang.Integer.valueOf(r0);
        r3.add(r0);
        r4 = new java.util.LinkedList;
        r4.<init>();
        r0 = vzH;
        r0 = r0.vzN;
        r4.add(r0);
        r0 = vzH;
        r0 = r0.type;
        r1 = vzH;
        r1 = r1.talker;
        r5 = "MicroMsg.FMessageItemView";
        r6 = new java.lang.StringBuilder;
        r8 = "getOpCode, type = ";
        r6.<init>(r8);
        r6 = r6.append(r0);
        r8 = ", talker = ";
        r6 = r6.append(r8);
        r6 = r6.append(r1);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.d(r5, r6);
        switch(r0) {
            case 0: goto L_0x00c1;
            case 1: goto L_0x0103;
            case 2: goto L_0x0120;
            default: goto L_0x006e;
        };
    L_0x006e:
        r1 = 6;
    L_0x006f:
        r0 = "MicroMsg.FMessageItemView";
        r5 = new java.lang.StringBuilder;
        r6 = "reply, final opcode = ";
        r5.<init>(r6);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = com.tencent.mm.y.as.CN();
        r5 = 30;
        r0.a(r5, r12);
        r0 = new com.tencent.mm.pluginsdk.model.o;
        r5 = vzH;
        r6 = r5.mTU;
        r9 = "";
        r5 = r13;
        r8 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r1 = com.tencent.mm.y.as.CN();
        r1.a(r0, r11);
        r1 = r12.context;
        r2 = r12.context;
        r3 = com.tencent.mm.R.l.dGZ;
        r2.getString(r3);
        r2 = r12.context;
        r3 = com.tencent.mm.R.l.dGM;
        r2 = r2.getString(r3);
        r3 = new com.tencent.mm.pluginsdk.ui.preference.a$2;
        r3.<init>(r0);
        r0 = com.tencent.mm.ui.base.h.a(r1, r2, r10, r3);
        r12.tipDialog = r0;
        goto L_0x0010;
    L_0x00c1:
        if (r1 == 0) goto L_0x00c9;
    L_0x00c3:
        r0 = r1.length();
        if (r0 != 0) goto L_0x00d7;
    L_0x00c9:
        r0 = "MicroMsg.FMessageLogic";
        r1 = "isVerifyReceiver, invalid argument";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x00d2:
        r0 = r11;
    L_0x00d3:
        if (r0 != 0) goto L_0x006e;
    L_0x00d5:
        r1 = 5;
        goto L_0x006f;
    L_0x00d7:
        r0 = com.tencent.mm.be.l.TD();
        r0 = r0.nb(r1);
        if (r0 != 0) goto L_0x00f8;
    L_0x00e1:
        r0 = "MicroMsg.FMessageLogic";
        r5 = new java.lang.StringBuilder;
        r6 = "isVerifyReceiver, lastRecvFmsg does not exist, talker = ";
        r5.<init>(r6);
        r1 = r5.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00d2;
    L_0x00f8:
        r1 = r0.field_type;
        if (r1 == r10) goto L_0x0101;
    L_0x00fc:
        r0 = r0.field_type;
        r1 = 2;
        if (r0 != r1) goto L_0x00d2;
    L_0x0101:
        r0 = r10;
        goto L_0x00d3;
    L_0x0103:
        r0 = com.tencent.mm.be.l.TF();
        r0 = r0.ng(r1);
        if (r0 != 0) goto L_0x0118;
    L_0x010d:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last lbsMsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x006e;
    L_0x0118:
        r0 = r0.field_content;
        r1 = Tj(r0);
        goto L_0x006f;
    L_0x0120:
        r0 = com.tencent.mm.be.l.TG();
        r0 = r0.ni(r1);
        if (r0 != 0) goto L_0x0135;
    L_0x012a:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last shakeMsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x006e;
    L_0x0135:
        r0 = r0.field_content;
        r1 = Tj(r0);
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.preference.a.a(com.tencent.mm.pluginsdk.ui.preference.a, java.lang.String):void");
    }

    public a(Context context) {
        super(context);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.diC, this);
        this.ipP = (TextView) inflate.findViewById(R.h.ciJ);
        this.vzI = (Button) inflate.findViewById(R.h.ciK);
        this.vzI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                View inflate = View.inflate(a.this.context, R.i.drZ, null);
                ((TextView) inflate.findViewById(R.h.cLI)).setVisibility(8);
                final TextView textView = (TextView) inflate.findViewById(R.h.cZN);
                textView.setVisibility(0);
                textView.setText("50");
                final EditText editText = (EditText) inflate.findViewById(R.h.cLH);
                editText.setSingleLine(false);
                c.d(editText).Hg(100).a(null);
                editText.addTextChangedListener(new TextWatcher() {
                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int be = h.be(100, editable.toString());
                        if (textView != null) {
                            textView.setText(String.valueOf(be));
                        }
                    }
                });
                com.tencent.mm.ui.base.h.a(a.this.context, a.this.context.getString(R.l.dGF), inflate, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = editText.getText().toString().trim();
                        if (trim != null && trim.length() > 0) {
                            a.a(a.this, trim);
                        }
                    }
                }, null);
                editText.post(new Runnable() {
                    public final void run() {
                        if (a.this.context instanceof MMActivity) {
                            ((MMActivity) a.this.context).showVKB();
                        }
                    }
                });
            }
        });
    }

    private static int Tj(String str) {
        if (str == null) {
            x.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            return 6;
        }
        switch (d.Yb(str).fvG) {
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    public final void Tk(String str) {
        this.ipP.setText(i.b(this.context, bi.oM(str), this.ipP.getTextSize()));
    }

    public final void CO(int i) {
        if (this.vzI != null) {
            this.vzI.setVisibility(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 30) {
            x.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                int i3 = ((o) kVar).fvG;
                String str2 = ((o) kVar).vkh;
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + vzH.type);
                switch (vzH.type) {
                    case 1:
                        com.tencent.mm.be.h hVar = new com.tencent.mm.be.h();
                        hVar.field_createtime = com.tencent.mm.be.i.nh(vzH.talker);
                        hVar.field_isSend = 1;
                        hVar.field_content = str2;
                        hVar.field_talker = "fmessage";
                        hVar.field_sayhiuser = vzH.talker;
                        hVar.field_svrid = System.currentTimeMillis();
                        hVar.field_status = 4;
                        l.TF().a(hVar);
                        break;
                    case 2:
                        j jVar = new j();
                        jVar.field_createtime = com.tencent.mm.be.k.nh(vzH.talker);
                        jVar.field_isSend = 1;
                        jVar.field_content = str2;
                        jVar.field_talker = "fmessage";
                        jVar.field_sayhiuser = vzH.talker;
                        jVar.field_svrid = System.currentTimeMillis();
                        jVar.field_status = 4;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + l.TG().a(jVar));
                        break;
                    default:
                        f fVar = new f();
                        fVar.field_createTime = com.tencent.mm.be.e.n(vzH.talker, 0);
                        fVar.field_isSend = 1;
                        fVar.field_msgContent = str2;
                        fVar.field_talker = vzH.talker;
                        fVar.field_type = i3 == 5 ? 2 : 3;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + l.TD().a(fVar));
                        break;
                }
            }
            CharSequence str3;
            if (i == 4 && i2 == -34) {
                str3 = this.context.getString(R.l.eix);
            } else if (i == 4 && i2 == -94) {
                str3 = this.context.getString(R.l.eiy);
            } else if (!(i == 4 && i2 == -24 && !bi.oN(str3))) {
                str3 = this.context.getString(R.l.eKq);
            }
            Toast.makeText(this.context, str3, 1).show();
            as.CN().b(30, (e) this);
        }
    }
}
