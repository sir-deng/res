package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.a.sq;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements com.tencent.mm.sdk.e.j.a {
    private MMActivity fnF;
    protected k<e, String> hmJ = new k<e, String>() {
        public final /* synthetic */ void a(Object obj, Looper looper) {
            e eVar = (e) obj;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.a(eVar, looper);
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            e eVar = (e) obj;
            String str = (String) obj2;
            if (str.equals("show_btn")) {
                eVar.au(NormalUserFooterPreference.this.jQP.field_username, true);
            } else if (str.equals("hide_btn")) {
                eVar.au(NormalUserFooterPreference.this.jQP.field_username, false);
            }
        }
    };
    public ProgressDialog inI = null;
    private x jQP;
    private String kBn = null;
    private boolean lXm;
    private String mTU = "";
    private Button oqb;
    private boolean pnl;
    private int pnn;
    private int poP;
    private String poX = "";
    private int pox = 0;
    private long ppA = 0;
    private boolean ppM = false;
    private boolean ppN;
    private boolean ppO;
    private boolean ppP = false;
    private boolean ppQ = false;
    private a ppR;
    private View ppS;
    private Button ppT;
    private Button ppU;
    private Button ppV;
    private View ppW;
    private Button ppX;
    private View ppY;
    private Button ppZ;
    private boolean ppd = false;
    private Button pqa;
    private Button pqb;
    private Button pqc;
    private Button pqd;
    private Button pqe;
    private TextView pqf;
    private boolean pqg = false;
    public boolean pqh = false;

    class h extends a {
        public h() {
            super();
        }

        protected final void bkm() {
        }

        protected final void bkk() {
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            NormalUserFooterPreference.this.oqb.setVisibility(0);
            if (NormalUserFooterPreference.this.bkh() || NormalUserFooterPreference.this.jQP.field_username.equals(q.FY()) || s.hq(NormalUserFooterPreference.this.jQP.field_username) || s.hj(NormalUserFooterPreference.this.jQP.field_username)) {
                NormalUserFooterPreference.this.pqc.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.pqc.setVisibility(0);
            }
            NormalUserFooterPreference.this.oqb.setText(R.l.dWC);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
        }
    }

    class i extends c implements com.tencent.mm.ad.e {
        private ProgressDialog inI;

        public i() {
            super();
        }

        protected void bkk() {
            onDetach();
            onStop();
            as.CN().a(30, (com.tencent.mm.ad.e) this);
            as.CN().a(667, (com.tencent.mm.ad.e) this);
            as.CN().a(853, (com.tencent.mm.ad.e) this);
            super.bkk();
        }

        final void onStop() {
            as.CN().b(30, (com.tencent.mm.ad.e) this);
            as.CN().b(667, (com.tencent.mm.ad.e) this);
            as.CN().b(853, (com.tencent.mm.ad.e) this);
        }

        protected void onDetach() {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (NormalUserFooterPreference.this.ppS != null) {
                NormalUserFooterPreference.this.ppS.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.ppY != null) {
                NormalUserFooterPreference.this.ppY.setVisibility(0);
            }
            if (NormalUserFooterPreference.this.oqb != null) {
                NormalUserFooterPreference.this.oqb.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.pqe != null) {
                NormalUserFooterPreference.this.pqe.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.pqc != null) {
                NormalUserFooterPreference.this.pqc.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.pqb != null) {
                NormalUserFooterPreference.this.pqb.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.pqf != null) {
                NormalUserFooterPreference.this.pqf.setVisibility(8);
            }
            onStop();
        }

        private void An() {
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            as.Hm();
            x Xv = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                ag a = NormalUserFooterPreference.this.jQP;
                as.Hm();
                if (com.tencent.mm.y.c.Ff().R(a)) {
                    as.Hm();
                    Xv = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + a.field_username);
                    Xv = null;
                }
            }
            normalUserFooterPreference.jQP = Xv;
            if (NormalUserFooterPreference.this.jQP != null) {
                s.p(NormalUserFooterPreference.this.jQP);
            }
        }

        protected void bkq() {
            if (NormalUserFooterPreference.this.ppR != null) {
                NormalUserFooterPreference.this.ppR.onDetach();
            }
            NormalUserFooterPreference.this.ppR = new c();
            NormalUserFooterPreference.this.ppR.EP();
        }

        public void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ad.k r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r7 = 853; // 0x355 float:1.195E-42 double:4.214E-321;
            r6 = 30;
            r5 = 4;
            r1 = 0;
            r2 = 1;
            r0 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "onSceneEnd, errType = ";
            r3.<init>(r4);
            r3 = r3.append(r9);
            r4 = ", errCode = ";
            r3 = r3.append(r4);
            r3 = r3.append(r10);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.x.d(r0, r3);
            r0 = r12.getType();
            if (r0 == r6) goto L_0x003d;
        L_0x002e:
            r0 = r12.getType();
            r3 = 667; // 0x29b float:9.35E-43 double:3.295E-321;
            if (r0 == r3) goto L_0x003d;
        L_0x0036:
            r0 = r12.getType();
            if (r0 == r7) goto L_0x003d;
        L_0x003c:
            return;
        L_0x003d:
            r8.onStop();
            r0 = r8.inI;
            if (r0 == 0) goto L_0x004c;
        L_0x0044:
            r0 = r8.inI;
            r0.dismiss();
            r0 = 0;
            r8.inI = r0;
        L_0x004c:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.mContext;
            r0 = com.tencent.mm.sdk.platformtools.bi.bF(r0);
            if (r0 == 0) goto L_0x003c;
        L_0x0056:
            if (r9 != 0) goto L_0x00f5;
        L_0x0058:
            if (r10 != 0) goto L_0x00f5;
        L_0x005a:
            r0 = r12.getType();
            if (r0 != r6) goto L_0x00c2;
        L_0x0060:
            r0 = r12;
            r0 = (com.tencent.mm.pluginsdk.model.o) r0;
            r0 = r0.fvG;
            r1 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "VerifyBaseHandler onSceneEnd, opCode = ";
            r3.<init>(r4);
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.x.d(r1, r3);
            if (r0 == r2) goto L_0x0080;
        L_0x007d:
            r1 = 3;
            if (r0 != r1) goto L_0x003c;
        L_0x0080:
            r12 = (com.tencent.mm.pluginsdk.model.o) r12;
            r0 = r12.vkg;
            if (r0 == 0) goto L_0x003c;
        L_0x0086:
            r1 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r1 = r1.jQP;
            r1 = r1.field_username;
            r1 = r0.contains(r1);
            if (r1 == 0) goto L_0x003c;
        L_0x0094:
            r1 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r1.pqg = true;
            r8.An();
            r8.bkq();
            r1 = r0.iterator();
        L_0x00a3:
            r0 = r1.hasNext();
            if (r0 == 0) goto L_0x00b9;
        L_0x00a9:
            r0 = r1.next();
            r0 = (java.lang.String) r0;
            r2 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r2 = r2.pnn;
            com.tencent.mm.pluginsdk.ui.preference.b.aV(r0, r2);
            goto L_0x00a3;
        L_0x00b9:
            r0 = com.tencent.mm.y.as.getNotification();
            r0.xf();
            goto L_0x003c;
        L_0x00c2:
            r0 = r12.getType();
            r3 = 667; // 0x29b float:9.35E-43 double:3.295E-321;
            if (r0 == r3) goto L_0x00d0;
        L_0x00ca:
            r0 = r12.getType();
            if (r0 != r7) goto L_0x00f5;
        L_0x00d0:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0.pqg = true;
            r8.An();
            r8.bkq();
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.jQP;
            r0 = r0.field_username;
            r1 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r1 = r1.pnn;
            com.tencent.mm.pluginsdk.ui.preference.b.aV(r0, r1);
            r0 = com.tencent.mm.y.as.getNotification();
            r0.xf();
            goto L_0x003c;
        L_0x00f5:
            if (r9 != r5) goto L_0x0161;
        L_0x00f7:
            r0 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
            if (r10 != r0) goto L_0x0161;
        L_0x00fb:
            r0 = r12.getType();
            if (r0 != r6) goto L_0x0248;
        L_0x0101:
            r0 = r12;
            r0 = (com.tencent.mm.pluginsdk.model.o) r0;
            r0 = r0.fvG;
        L_0x0106:
            r3 = "MicroMsg.NormalUserFooterPreference";
            r4 = "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d";
            r2 = new java.lang.Object[r2];
            r5 = java.lang.Integer.valueOf(r0);
            r2[r1] = r5;
            com.tencent.mm.sdk.platformtools.x.w(r3, r4, r2);
            r1 = 3;
            if (r0 == r1) goto L_0x0120;
        L_0x011a:
            r0 = r12.getType();
            if (r0 != r7) goto L_0x003c;
        L_0x0120:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r1 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r1 = r1.fnF;
            r2 = com.tencent.mm.R.l.dXr;
            r1 = r1.getString(r2);
            r2 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r2 = r2.fnF;
            r3 = com.tencent.mm.R.l.dGZ;
            r2 = r2.getString(r3);
            r3 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r3 = r3.fnF;
            r4 = com.tencent.mm.R.l.dDV;
            r3 = r3.getString(r4);
            r4 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r4 = r4.fnF;
            r5 = com.tencent.mm.R.l.dEy;
            r4 = r4.getString(r5);
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$3;
            r5.<init>();
            r6 = 0;
            com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5, r6);
            goto L_0x003c;
        L_0x0161:
            if (r9 != r5) goto L_0x017c;
        L_0x0163:
            r0 = -24;
            if (r10 != r0) goto L_0x017c;
        L_0x0167:
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
            if (r0 != 0) goto L_0x017c;
        L_0x016d:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r0 = android.widget.Toast.makeText(r0, r11, r2);
            r0.show();
            goto L_0x003c;
        L_0x017c:
            switch(r9) {
                case 1: goto L_0x0183;
                case 2: goto L_0x01b1;
                case 3: goto L_0x017f;
                case 4: goto L_0x01da;
                default: goto L_0x017f;
            };
        L_0x017f:
            if (r1 == 0) goto L_0x003c;
        L_0x0181:
            goto L_0x003c;
        L_0x0183:
            r0 = com.tencent.mm.y.as.CN();
            r0 = r0.Kt();
            if (r0 == 0) goto L_0x019e;
        L_0x018d:
            r0 = com.tencent.mm.y.as.CN();
            r0.getNetworkServerIp();
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0.append(r10);
            r1 = r2;
            goto L_0x017f;
        L_0x019e:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.mContext;
            r0 = com.tencent.mm.network.ab.bC(r0);
            if (r0 == 0) goto L_0x017f;
        L_0x01a8:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.mContext;
            com.tencent.mm.pluginsdk.ui.k.ep(r0);
            r1 = r2;
            goto L_0x017f;
        L_0x01b1:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.mContext;
            r3 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r3 = r3.mContext;
            r4 = com.tencent.mm.R.l.eiR;
            r5 = 2;
            r5 = new java.lang.Object[r5];
            r6 = 2;
            r6 = java.lang.Integer.valueOf(r6);
            r5[r1] = r6;
            r1 = java.lang.Integer.valueOf(r10);
            r5[r2] = r1;
            r1 = r3.getString(r4, r5);
            r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r0 = android.widget.Toast.makeText(r0, r1, r3);
            r0.show();
            r1 = r2;
            goto L_0x017f;
        L_0x01da:
            r0 = -100;
            if (r10 != r0) goto L_0x01ff;
        L_0x01de:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.mContext;
            r1 = com.tencent.mm.y.as.Cp();
            r3 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r3 = r3.mContext;
            r4 = com.tencent.mm.R.l.dGZ;
            r3 = com.tencent.mm.bu.a.ac(r3, r4);
            r4 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$1;
            r4.<init>();
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$2;
            r5.<init>();
            com.tencent.mm.ui.base.h.a(r0, r1, r3, r4, r5);
            r1 = r2;
            goto L_0x017f;
        L_0x01ff:
            if (r9 != r5) goto L_0x0220;
        L_0x0201:
            r0 = -34;
            if (r10 != r0) goto L_0x0220;
        L_0x0205:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r3 = com.tencent.mm.R.l.eix;
            r11 = r0.getString(r3);
        L_0x0211:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r0 = android.widget.Toast.makeText(r0, r11, r2);
            r0.show();
            goto L_0x017f;
        L_0x0220:
            if (r9 != r5) goto L_0x0233;
        L_0x0222:
            r0 = -94;
            if (r10 != r0) goto L_0x0233;
        L_0x0226:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r3 = com.tencent.mm.R.l.eiy;
            r11 = r0.getString(r3);
            goto L_0x0211;
        L_0x0233:
            if (r9 != r5) goto L_0x023b;
        L_0x0235:
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
            if (r0 == 0) goto L_0x0211;
        L_0x023b:
            r0 = com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.this;
            r0 = r0.fnF;
            r3 = com.tencent.mm.R.l.eKq;
            r11 = r0.getString(r3);
            goto L_0x0211;
        L_0x0248:
            r0 = r1;
            goto L_0x0106;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
        }
    }

    class j extends i implements com.tencent.mm.ad.e {
        public j() {
            super();
        }

        protected final void bkm() {
            if (NormalUserFooterPreference.this.jQP == null || !com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                v(false, true);
            } else {
                bkl();
            }
        }

        protected final void bkk() {
            super.bkk();
            NormalUserFooterPreference.this.ppS.setVisibility(0);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.oqb.setVisibility(8);
            NormalUserFooterPreference.this.pqe.setVisibility(8);
            NormalUserFooterPreference.this.pqc.setVisibility(8);
            NormalUserFooterPreference.this.pqd.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
            switch (NormalUserFooterPreference.this.pnn) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 18:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 34:
                case 58:
                case 59:
                case 60:
                    NormalUserFooterPreference.this.ppX.setVisibility(0);
                    NormalUserFooterPreference.this.ppW.setVisibility(0);
                    break;
                default:
                    NormalUserFooterPreference.this.ppX.setVisibility(8);
                    NormalUserFooterPreference.this.ppW.setVisibility(8);
                    break;
            }
            if (NormalUserFooterPreference.this.jQP.AM()) {
                NormalUserFooterPreference.this.ppV.setText(NormalUserFooterPreference.this.fnF.getString(R.l.dVW));
                NormalUserFooterPreference.this.pqf.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.ppV.setText(NormalUserFooterPreference.this.fnF.getString(R.l.dVT));
            }
            NormalUserFooterPreference.this.ppT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    NormalUserFooterPreference.this.fnF.getIntent().removeExtra("Accept_NewFriend_FromOutside");
                    Intent intent = new Intent(NormalUserFooterPreference.this.fnF, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
                    intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.jQP.field_nickname);
                    intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.jQP.field_conRemark);
                    if (NormalUserFooterPreference.this.pnn == 14 || NormalUserFooterPreference.this.pnn == 8) {
                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
                    intent.putExtra("Verify_ticket", NormalUserFooterPreference.this.mTU);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", true);
                    NormalUserFooterPreference.this.fnF.startActivity(intent);
                }
            });
            NormalUserFooterPreference.this.ppV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (NormalUserFooterPreference.this.jQP.AM()) {
                        s.i(NormalUserFooterPreference.this.jQP);
                        NormalUserFooterPreference.this.jQP.Aq();
                        j.this.bkk();
                        return;
                    }
                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(x.Xg(NormalUserFooterPreference.this.jQP.field_username) ? R.l.eIS : R.l.dVU), NormalUserFooterPreference.this.mContext.getString(R.l.dVT), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            s.h(NormalUserFooterPreference.this.jQP);
                            NormalUserFooterPreference.this.jQP.Ap();
                            j.this.bkk();
                        }
                    }, null);
                }
            });
        }

        protected final void onDetach() {
            super.onDetach();
        }

        protected final void bkq() {
            super.bkq();
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            super.a(i, i2, str, kVar);
        }
    }

    abstract class a implements com.tencent.mm.ad.e {
        boolean isDeleteCancel = false;
        private com.tencent.mm.ui.widget.g pqj = null;

        protected abstract void bkk();

        static /* synthetic */ void a(a aVar) {
            NormalUserFooterPreference.this.pqf.setVisibility(8);
            s.i(NormalUserFooterPreference.this.jQP);
            NormalUserFooterPreference.this.jQP.Aq();
            aVar.bkk();
        }

        static /* synthetic */ void b(a aVar) {
            NormalUserFooterPreference.this.pqf.setVisibility(0);
            s.h(NormalUserFooterPreference.this.jQP);
            NormalUserFooterPreference.this.jQP.Ap();
            aVar.bkk();
        }

        static /* synthetic */ void c(a aVar) {
            int i = 7;
            Intent intent = new Intent();
            switch (NormalUserFooterPreference.this.pnn) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 58:
                case 59:
                case 60:
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.x(45, NormalUserFooterPreference.this.jQP.field_username));
                    i = 45;
                    break;
                case 9:
                case 14:
                    i = 35;
                    break;
                case 18:
                    i = NormalUserFooterPreference.this.ppM ? 2 : 1;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.mT(NormalUserFooterPreference.this.jQP.field_username));
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    i = NormalUserFooterPreference.this.ppM ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.mU(NormalUserFooterPreference.this.jQP.field_username));
                    break;
                case 25:
                    i = NormalUserFooterPreference.this.ppM ? 6 : 5;
                    if (!NormalUserFooterPreference.this.ppM) {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.mV(!bi.oN(NormalUserFooterPreference.this.jQP.xGq) ? NormalUserFooterPreference.this.jQP.xGq : NormalUserFooterPreference.this.jQP.field_username));
                        break;
                    } else {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.x(i, NormalUserFooterPreference.this.jQP.field_username));
                        break;
                    }
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.be.a.x(7, NormalUserFooterPreference.this.jQP.field_username));
                    break;
                default:
                    i = 999;
                    break;
            }
            intent.putExtra("k_username", NormalUserFooterPreference.this.jQP.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            com.tencent.mm.bl.d.b(NormalUserFooterPreference.this.fnF, "webview", ".ui.tools.WebViewUI", intent);
        }

        protected void EP() {
            bkk();
            bkm();
            NormalUserFooterPreference.this.oqb.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a aVar;
                    if (NormalUserFooterPreference.this.ppO) {
                        aVar = a.this;
                        String str = NormalUserFooterPreference.this.jQP.field_username;
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        if (NormalUserFooterPreference.this.pnl) {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("Chat_Mode", 1);
                            ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent);
                            return;
                        }
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("Chat_Mode", 1);
                        com.tencent.mm.plugin.profile.a.ihN.e(intent, NormalUserFooterPreference.this.mContext);
                        return;
                    }
                    aVar = a.this;
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    if (NormalUserFooterPreference.this.pnl) {
                        intent2.putExtra("Chat_User", NormalUserFooterPreference.this.jQP.field_username);
                        intent2.putExtra("Chat_Mode", 1);
                        ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent2);
                        return;
                    }
                    intent2.putExtra("Chat_User", NormalUserFooterPreference.this.jQP.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    com.tencent.mm.plugin.profile.a.ihN.e(intent2, NormalUserFooterPreference.this.mContext);
                }
            });
            NormalUserFooterPreference.this.pqe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserFooterPreference.this.jQP.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 4);
                    com.tencent.mm.bl.d.b(NormalUserFooterPreference.this.fnF, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            NormalUserFooterPreference.this.pqc.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a aVar = a.this;
                    com.tencent.mm.sdk.b.b sqVar = new sq();
                    com.tencent.mm.sdk.b.a.xmy.m(sqVar);
                    if (!NormalUserFooterPreference.this.jQP.field_username.equals(sqVar.fLh.talker) && (sqVar.fLh.fLj || sqVar.fLh.fLk)) {
                        Toast.makeText(NormalUserFooterPreference.this.fnF.mController.xRr, sqVar.fLh.fLi ? R.l.dNB : R.l.dNC, 0).show();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                    } else if (!com.tencent.mm.o.a.aU(NormalUserFooterPreference.this.fnF)) {
                        sqVar = new rk();
                        sqVar.fJX.fJZ = true;
                        com.tencent.mm.sdk.b.a.xmy.m(sqVar);
                        String str = sqVar.fJY.fKb;
                        if (bi.oN(str)) {
                            aVar.bkn();
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: " + str);
                        com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.fnF, NormalUserFooterPreference.this.fnF.getString(R.l.eQN), "", NormalUserFooterPreference.this.fnF.getString(R.l.dGf), NormalUserFooterPreference.this.fnF.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.b rkVar = new rk();
                                rkVar.fJX.fKa = true;
                                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                                a.this.bkn();
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }
            });
            NormalUserFooterPreference.this.ppX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.c(a.this);
                }
            });
            NormalUserFooterPreference.this.ppZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.c(a.this);
                }
            });
            NormalUserFooterPreference.this.pqd.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.c(a.this);
                }
            });
        }

        protected void onDetach() {
        }

        public void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        }

        protected final void bkl() {
            NormalUserFooterPreference.this.fnF.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(NormalUserFooterPreference.this.fnF, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            com.tencent.mm.modelfriend.b bVar = null;
                            NormalUserFooterPreference normalUserFooterPreference;
                            Intent intent;
                            a aVar;
                            View inflate;
                            TextView textView;
                            final CheckBox checkBox;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    NormalUserFooterPreference.this.hmJ.cb("hide_btn");
                                    NormalUserFooterPreference.this.hmJ.doNotify();
                                    a aVar2 = a.this;
                                    normalUserFooterPreference = NormalUserFooterPreference.this;
                                    as.Hm();
                                    normalUserFooterPreference.jQP = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                                    if (com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                                        intent = new Intent();
                                        intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
                                        intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
                                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_RoomNickname"));
                                        intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.this.jQP.fXz);
                                        String str = "";
                                        if (!NormalUserFooterPreference.this.jQP.AT()) {
                                            String stringExtra = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_Mobile_MD5");
                                            String stringExtra2 = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                            if (bi.oN(stringExtra) && bi.oN(stringExtra2)) {
                                                if (!bi.oN(NormalUserFooterPreference.this.jQP.field_username)) {
                                                    bVar = af.OJ().kU(NormalUserFooterPreference.this.jQP.field_username);
                                                }
                                            } else if (!(bi.oN(stringExtra) && bi.oN(stringExtra2))) {
                                                bVar = af.OJ().kV(stringExtra);
                                                if (bVar == null || bi.oN(bVar.Nx())) {
                                                    bVar = af.OJ().kV(stringExtra2);
                                                }
                                            }
                                            if (!(bVar == null || bi.oN(bVar.Nx()))) {
                                                str = bi.oM(bVar.NF()).replace(" ", "");
                                            }
                                        }
                                        intent.putExtra("contact_phone_number_by_md5", str);
                                        com.tencent.mm.plugin.profile.a.ihN.p(intent, NormalUserFooterPreference.this.mContext);
                                        return;
                                    }
                                    aVar2.Ig(NormalUserFooterPreference.this.jQP.field_username);
                                    return;
                                case 2:
                                    if (NormalUserFooterPreference.this.jQP.AO()) {
                                        s.m(NormalUserFooterPreference.this.jQP);
                                        com.tencent.mm.ui.base.h.bu(NormalUserFooterPreference.this.fnF, NormalUserFooterPreference.this.fnF.getString(R.l.dXq));
                                    } else {
                                        s.l(NormalUserFooterPreference.this.jQP);
                                        com.tencent.mm.ui.base.h.bu(NormalUserFooterPreference.this.fnF, NormalUserFooterPreference.this.fnF.getString(R.l.dVk));
                                    }
                                    normalUserFooterPreference = NormalUserFooterPreference.this;
                                    as.Hm();
                                    normalUserFooterPreference.jQP = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                                    return;
                                case 3:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.this.jQP.field_username);
                                    intent2.putExtra("sns_permission_anim", true);
                                    intent2.putExtra("sns_permission_block_scene", 1);
                                    com.tencent.mm.bl.d.b(NormalUserFooterPreference.this.fnF, "sns", ".ui.SnsPermissionUI", intent2);
                                    return;
                                case 4:
                                    aVar = a.this;
                                    intent = new Intent();
                                    intent.putExtra("Select_Talker_Name", NormalUserFooterPreference.this.jQP.field_username);
                                    intent.putExtra("Select_block_List", NormalUserFooterPreference.this.jQP.field_username);
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("Select_Send_Card", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.a.ihN.a(intent, NormalUserFooterPreference.this.fnF);
                                    return;
                                case 5:
                                    if (NormalUserFooterPreference.this.jQP.AM()) {
                                        a.a(a.this);
                                        return;
                                    }
                                    inflate = View.inflate(NormalUserFooterPreference.this.mContext, R.i.dns, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.h.cwj);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(x.Xg(NormalUserFooterPreference.this.jQP.field_username) ? R.l.eIS : R.l.dVU);
                                    checkBox = (CheckBox) inflate.findViewById(R.h.cwh);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.h.cwi);
                                    textView.setText(R.l.dVV);
                                    if (NormalUserFooterPreference.this.jQP.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.dVT), inflate, NormalUserFooterPreference.this.mContext.getString(R.l.dGf), NormalUserFooterPreference.this.mContext.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            a.b(a.this);
                                            if (NormalUserFooterPreference.this.jQP.getSource() == 18) {
                                                NormalUserFooterPreference.this.pnn = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                        }
                                    }, null);
                                    return;
                                case 6:
                                    inflate = View.inflate(NormalUserFooterPreference.this.mContext, R.i.dns, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.h.cwj);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(s.gF(NormalUserFooterPreference.this.jQP.field_username) ? NormalUserFooterPreference.this.mContext.getString(R.l.dYy, new Object[]{NormalUserFooterPreference.this.jQP.AX()}) : NormalUserFooterPreference.this.mContext.getString(R.l.dYw, new Object[]{NormalUserFooterPreference.this.jQP.AX()}));
                                    checkBox = (CheckBox) inflate.findViewById(R.h.cwh);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.h.cwi);
                                    textView.setText(R.l.dVV);
                                    if (NormalUserFooterPreference.this.jQP.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.bXt), inflate, NormalUserFooterPreference.this.mContext.getString(R.l.dEH), NormalUserFooterPreference.this.mContext.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            a.this.bko();
                                            if (NormalUserFooterPreference.this.jQP.getSource() == 18) {
                                                NormalUserFooterPreference.this.pnn = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                        }
                                    }, null, R.e.brm);
                                    return;
                                case 7:
                                    aVar = a.this;
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.this.jQP.field_username);
                                    com.tencent.mm.plugin.base.model.b.M(NormalUserFooterPreference.this.fnF, NormalUserFooterPreference.this.jQP.field_username);
                                    ah.h(new Runnable() {
                                        public final void run() {
                                            com.tencent.mm.plugin.base.model.b.L(NormalUserFooterPreference.this.fnF, NormalUserFooterPreference.this.jQP.field_username);
                                        }
                                    }, 1000);
                                    return;
                                case 9:
                                    a.c(a.this);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                        public final void a(n nVar) {
                            CharSequence string;
                            if (x.Xg(NormalUserFooterPreference.this.jQP.field_username)) {
                                nVar.aj(1, R.l.dXB, R.k.dwY);
                            } else {
                                nVar.aj(1, R.l.dVQ, R.k.dwY);
                            }
                            if (NormalUserFooterPreference.this.jQP.AO()) {
                                string = NormalUserFooterPreference.this.fnF.getResources().getString(R.l.dXp);
                            } else {
                                string = NormalUserFooterPreference.this.fnF.getResources().getString(R.l.dVj);
                            }
                            nVar.a(2, string, R.k.dxa);
                            if (!x.Xg(NormalUserFooterPreference.this.jQP.field_username)) {
                                nVar.aj(3, R.l.dWa, R.k.dwQ);
                            }
                            nVar.aj(4, R.l.dWB, R.k.dxb);
                            nVar.aj(9, R.l.dMw, R.k.dwC);
                            if (NormalUserFooterPreference.this.jQP.AM()) {
                                string = NormalUserFooterPreference.this.fnF.getString(R.l.dVW);
                            } else {
                                string = NormalUserFooterPreference.this.fnF.getString(R.l.dVT);
                            }
                            nVar.a(5, string, R.k.dwz);
                            if (!NormalUserFooterPreference.this.ppQ) {
                                nVar.aj(6, R.l.dKZ, R.k.dwE);
                            }
                            nVar.aj(7, R.l.dUC, R.k.dwF);
                        }
                    };
                    gVar.bUX();
                    return true;
                }
            });
        }

        protected final void v(final boolean z, final boolean z2) {
            if (!z || !z2) {
                NormalUserFooterPreference.this.fnF.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(NormalUserFooterPreference.this.fnF, com.tencent.mm.ui.widget.g.zCt, false);
                        gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        a.this.Ig(NormalUserFooterPreference.this.jQP.field_username);
                                        return;
                                    case 5:
                                        com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(x.Xg(NormalUserFooterPreference.this.jQP.field_username) ? R.l.eIS : R.l.dVU), NormalUserFooterPreference.this.mContext.getString(R.l.dVT), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                a.b(a.this);
                                            }
                                        }, null);
                                        return;
                                    case 8:
                                        a.a(a.this);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                            public final void a(n nVar) {
                                if (!z) {
                                    if (x.Xg(NormalUserFooterPreference.this.jQP.field_username)) {
                                        nVar.aj(1, R.l.dXB, R.k.dwY);
                                    } else {
                                        nVar.aj(1, R.l.dVQ, R.k.dwY);
                                    }
                                }
                                if (!z2) {
                                    if (NormalUserFooterPreference.this.jQP.AM()) {
                                        nVar.aj(8, R.l.dVW, R.k.dwz);
                                    } else if (!s.gG(NormalUserFooterPreference.this.jQP.field_username)) {
                                        nVar.aj(5, R.l.dVT, R.k.dwz);
                                    }
                                }
                            }
                        };
                        gVar.bUX();
                        return true;
                    }
                });
            }
        }

        protected void bkm() {
            if (NormalUserFooterPreference.this.ppd) {
                NormalUserFooterPreference.this.fnF.showOptionMenu(false);
            } else if (!q.FY().equals(NormalUserFooterPreference.this.jQP.field_username)) {
                if (!com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                    v(false, false);
                } else if (!s.hj(NormalUserFooterPreference.this.jQP.field_username)) {
                    bkl();
                }
            }
        }

        final void bkn() {
            this.pqj = new com.tencent.mm.ui.widget.g(NormalUserFooterPreference.this.fnF, com.tencent.mm.ui.widget.g.zCt, false);
            this.pqj.rQF = new com.tencent.mm.ui.base.p.c() {
                public final void a(n nVar) {
                    nVar.aj(2, R.l.dFr, R.k.dAR);
                    nVar.aj(1, R.l.dFs, R.k.dAS);
                }
            };
            this.pqj.rQG = new com.tencent.mm.ui.base.p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            NormalUserFooterPreference.this.bki();
                            return;
                        case 2:
                            NormalUserFooterPreference.this.bkj();
                            return;
                        default:
                            return;
                    }
                }
            };
            this.pqj.bUX();
        }

        final void Ig(String str) {
            if (bi.oN(str)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
            intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.jQP.field_nickname);
            intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.jQP.field_conRemark);
            com.tencent.mm.plugin.profile.a.ihN.q(intent, NormalUserFooterPreference.this.mContext);
        }

        protected final void bko() {
            com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.this.jQP.field_username);
            final String str = NormalUserFooterPreference.this.jQP.field_username;
            if (s.gF(str)) {
                NormalUserFooterPreference.this.jQP.Ao();
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.c(str));
                as.Hm();
                com.tencent.mm.y.c.Ff().XB(str);
                as.Hm();
                com.tencent.mm.y.c.Fo().hM(str);
                return;
            }
            String str2;
            this.isDeleteCancel = false;
            Context context = NormalUserFooterPreference.this.mContext;
            NormalUserFooterPreference.this.mContext.getString(R.l.dGZ);
            final ProgressDialog a = com.tencent.mm.ui.base.h.a(context, NormalUserFooterPreference.this.mContext.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.isDeleteCancel = true;
                }
            });
            if (this.isDeleteCancel) {
                str2 = null;
            } else {
                str2 = com.tencent.mm.pluginsdk.wallet.e.TE(NormalUserFooterPreference.this.jQP.field_username);
            }
            if (bi.oN(str2)) {
                rp(str);
                return;
            }
            a.dismiss();
            com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(R.l.eWz, new Object[]{str2}), null, NormalUserFooterPreference.this.mContext.getString(R.l.enQ), NormalUserFooterPreference.this.mContext.getString(R.l.dYE), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.this.jQP.field_username);
                    a.this.isDeleteCancel = true;
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", NormalUserFooterPreference.this.jQP.field_username);
                    intent.addFlags(67108864);
                    com.tencent.mm.bl.d.a(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", intent);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.this.jQP.field_username);
                    a.show();
                    a.this.isDeleteCancel = false;
                    a.this.rp(str);
                }
            }, -1, R.e.brm);
        }

        final void rp(String str) {
            com.tencent.mm.modelfriend.h hVar = null;
            NormalUserFooterPreference.this.jQP.Ao();
            if (x.Xg(str)) {
                ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.openim.a.a.class)).ow(str);
            } else {
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.c(str));
            }
            bb.a(str, new com.tencent.mm.y.bb.a() {
                public final boolean HH() {
                    return a.this.isDeleteCancel;
                }

                public final void HG() {
                    if (NormalUserFooterPreference.this.inI != null) {
                        NormalUserFooterPreference.this.inI.dismiss();
                    }
                }
            });
            as.Hm();
            com.tencent.mm.y.c.Ff().a(str, NormalUserFooterPreference.this.jQP);
            as.Hm();
            com.tencent.mm.y.c.Fk().XE(str);
            switch (NormalUserFooterPreference.this.pnn) {
                case 10:
                    com.tencent.mm.modelsimple.d.C(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 12:
                    ad lf = af.OO().lf(str);
                    if (lf != null) {
                        lf.hyD = 1;
                        af.OO().a(lf.hyC, lf);
                        break;
                    }
                    break;
                case 13:
                    com.tencent.mm.modelfriend.b kU = af.OJ().kU(str);
                    if (!(kU == null || bi.oN(kU.hxd))) {
                        kU.status = 1;
                        af.OJ().a(kU.Nx(), kU);
                    }
                    com.tencent.mm.modelsimple.d.C(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 31:
                    com.tencent.mm.modelfriend.i OK = af.OK();
                    Cursor a = OK.hiZ.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
                    if (a != null) {
                        com.tencent.mm.modelfriend.h hVar2;
                        if (a.moveToFirst()) {
                            hVar2 = new com.tencent.mm.modelfriend.h();
                            hVar2.b(a);
                        } else {
                            hVar2 = null;
                        }
                        a.close();
                        hVar = hVar2;
                    }
                    if (hVar != null) {
                        hVar.status = 100;
                        af.OK().a(hVar);
                        break;
                    }
                    break;
                case 58:
                case 59:
                case 60:
                    af.OR().N(str, 2);
                    break;
            }
            if (NormalUserFooterPreference.this.pnn == 9) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.this.jQP.getSource());
                switch (NormalUserFooterPreference.this.jQP.getSource()) {
                    case 10:
                    case 13:
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                        com.tencent.mm.modelsimple.d.C(NormalUserFooterPreference.this.mContext, str);
                        break;
                }
            }
            if (NormalUserFooterPreference.this.poP == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.a.ihN.s(intent, NormalUserFooterPreference.this.mContext);
                return;
            }
            NormalUserFooterPreference.this.fnF.setResult(-1, NormalUserFooterPreference.this.fnF.getIntent().putExtra("_delete_ok_", true));
            ((Activity) NormalUserFooterPreference.this.mContext).finish();
        }
    }

    public interface e {
        void au(String str, boolean z);
    }

    class f extends a {
        public f() {
            super();
        }

        protected final void bkm() {
            if (NormalUserFooterPreference.this.jQP == null || !com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                v(false, true);
            } else {
                bkl();
            }
        }

        protected final void bkk() {
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(0);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.oqb.setVisibility(8);
            NormalUserFooterPreference.this.pqe.setVisibility(8);
            NormalUserFooterPreference.this.pqc.setVisibility(8);
            NormalUserFooterPreference.this.pqd.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
            NormalUserFooterPreference.this.pqa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.plugin.normsg.a.d.oXY.T(1, 1, 3);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
                    intent.putExtra(com.tencent.mm.ui.e.a.xML, NormalUserFooterPreference.this.jQP.fXA);
                    com.tencent.mm.plugin.profile.a.ihN.a(intent, NormalUserFooterPreference.this.mContext);
                }
            });
        }
    }

    class g extends a {
        public g() {
            super();
        }

        public final void bkm() {
        }

        protected final void bkk() {
            boolean z = true;
            Assert.assertTrue(!q.gt(NormalUserFooterPreference.this.jQP.field_username));
            if (s.hq(NormalUserFooterPreference.this.jQP.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(8);
            NormalUserFooterPreference.this.oqb.setText(R.l.dWD);
            NormalUserFooterPreference.this.oqb.setVisibility(0);
            NormalUserFooterPreference.this.pqc.setVisibility(8);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
        }
    }

    class c extends a {
        static /* synthetic */ void a(c cVar) {
            int i = 0;
            if (((int) NormalUserFooterPreference.this.jQP.gKO) == 0) {
                as.Hm();
                com.tencent.mm.y.c.Ff().T(NormalUserFooterPreference.this.jQP);
                as.Hm();
                com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
            }
            if (((int) NormalUserFooterPreference.this.jQP.gKO) <= 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                return;
            }
            if (!com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type) && NormalUserFooterPreference.this.pnn == 15) {
                com.tencent.mm.modelfriend.b kU = af.OJ().kU(NormalUserFooterPreference.this.jQP.field_username);
                if (kU != null) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    Object[] objArr = new Object[4];
                    objArr[0] = NormalUserFooterPreference.this.jQP.field_username;
                    objArr[1] = Integer.valueOf(3);
                    if (!bi.oN(kU.Nx())) {
                        i = 1;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(NormalUserFooterPreference.this.jQP.fXz.toString().split(",").length >= 5 ? 5 : NormalUserFooterPreference.this.jQP.fXz.toString().split(",").length);
                    gVar.h(12040, objArr);
                }
            }
            s.p(NormalUserFooterPreference.this.jQP);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            as.Hm();
            normalUserFooterPreference.jQP = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
            cVar.bkk();
        }

        public c() {
            super();
        }

        protected final void EP() {
            super.EP();
        }

        protected void onDetach() {
            super.onDetach();
        }

        protected void bkk() {
            Assert.assertTrue(!s.hq(NormalUserFooterPreference.this.jQP.field_username));
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(8);
            if (NormalUserFooterPreference.this.ppd) {
                NormalUserFooterPreference.this.ppU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        c.this.bko();
                    }
                });
                if (com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                    NormalUserFooterPreference.this.ppU.setVisibility(0);
                } else {
                    NormalUserFooterPreference.this.ppU.setVisibility(8);
                }
                NormalUserFooterPreference.this.pqb.setVisibility(8);
                NormalUserFooterPreference.this.oqb.setVisibility(8);
                NormalUserFooterPreference.this.pqe.setVisibility(8);
                NormalUserFooterPreference.this.pqc.setVisibility(8);
                NormalUserFooterPreference.this.pqf.setVisibility(8);
                return;
            }
            NormalUserFooterPreference.this.pqb.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    c.this.bkp();
                    if (NormalUserFooterPreference.this.pox != 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11263, Integer.valueOf(NormalUserFooterPreference.this.pox), NormalUserFooterPreference.this.jQP.field_username);
                    }
                }
            });
            if (com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type)) {
                NormalUserFooterPreference.this.pqb.setVisibility(8);
                NormalUserFooterPreference.this.oqb.setVisibility(0);
                if (NormalUserFooterPreference.this.bkh() || NormalUserFooterPreference.this.jQP.field_username.equals(q.FY()) || s.hq(NormalUserFooterPreference.this.jQP.field_username) || s.hj(NormalUserFooterPreference.this.jQP.field_username) || x.Xg(NormalUserFooterPreference.this.jQP.field_username)) {
                    NormalUserFooterPreference.this.pqc.setVisibility(8);
                } else {
                    NormalUserFooterPreference.this.pqc.setVisibility(0);
                }
                as.Hm();
                if (com.tencent.mm.y.c.Ff().Xy(NormalUserFooterPreference.this.jQP.field_username)) {
                    NormalUserFooterPreference.this.pqd.setVisibility(0);
                    NormalUserFooterPreference.this.pnn = NormalUserFooterPreference.this.jQP.getSource();
                }
            } else {
                NormalUserFooterPreference.this.pqb.setVisibility(0);
                NormalUserFooterPreference.this.oqb.setVisibility(8);
                NormalUserFooterPreference.this.pqe.setVisibility(8);
                NormalUserFooterPreference.this.pqc.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.jQP.AM()) {
                NormalUserFooterPreference.this.pqf.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.pqf.setVisibility(8);
            }
        }

        protected final void bkp() {
            if (((int) NormalUserFooterPreference.this.jQP.gKO) == 0) {
                as.Hm();
                if (com.tencent.mm.y.c.Ff().T(NormalUserFooterPreference.this.jQP) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
                    as.Hm();
                    normalUserFooterPreference.jQP = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                }
            }
            if (NormalUserFooterPreference.this.ppN || NormalUserFooterPreference.this.pnn == 12) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.this.ppA + " qqReamrk " + NormalUserFooterPreference.this.poX);
                if (!(NormalUserFooterPreference.this.ppA == 0 || NormalUserFooterPreference.this.poX == null || NormalUserFooterPreference.this.poX.equals(""))) {
                    ad bf = af.OO().bf(NormalUserFooterPreference.this.ppA);
                    if (bf == null) {
                        bf = new ad();
                        bf.fqG = "";
                        bf.hyC = NormalUserFooterPreference.this.ppA;
                        bf.hyK = NormalUserFooterPreference.this.poX;
                        bf.username = NormalUserFooterPreference.this.jQP.field_username;
                        bf.OH();
                        af.OO().a(bf);
                    } else {
                        bf.hyC = NormalUserFooterPreference.this.ppA;
                        bf.hyK = NormalUserFooterPreference.this.poX;
                        bf.username = NormalUserFooterPreference.this.jQP.field_username;
                        bf.OH();
                        af.OO().a(NormalUserFooterPreference.this.ppA, bf);
                    }
                }
            } else if (NormalUserFooterPreference.this.pnn == 58 || NormalUserFooterPreference.this.pnn == 59 || NormalUserFooterPreference.this.pnn == 60) {
                af.OR().N(NormalUserFooterPreference.this.jQP.field_username, 1);
            }
            String stringExtra = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String oM = bi.oM(stringExtra);
            stringExtra2 = bi.oM(stringExtra2);
            if (!(oM.equals("") && stringExtra2.equals(""))) {
                com.tencent.mm.modelfriend.b kV = af.OJ().kV(oM);
                if (kV == null) {
                    kV = af.OJ().kV(stringExtra2);
                } else {
                    stringExtra2 = oM;
                }
                if (kV != null) {
                    af.OJ().a(stringExtra2, kV);
                }
            }
            final com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        NormalUserFooterPreference.this.hmJ.cb("hide_btn");
                        NormalUserFooterPreference.this.hmJ.doNotify();
                        NormalUserFooterPreference.this.pqg = true;
                        c.a(c.this);
                    } else if (z2) {
                        l.TE().T(str, 2);
                    } else {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = " + str);
                    }
                    if (z || z2) {
                        Intent intent = NormalUserFooterPreference.this.fnF.getIntent();
                        int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                        int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                        if (intExtra > 0 && intExtra2 > 0) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10991, Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2));
                        }
                    }
                }
            });
            final LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(NormalUserFooterPreference.this.pnn));
            stringExtra = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra3 = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("source_from_nick_name");
            aVar.vtA = stringExtra;
            aVar.vtB = stringExtra3;
            aVar.vtw = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                public final boolean DD(String str) {
                    String stringExtra = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(NormalUserFooterPreference.this.fnF, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
                    intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.jQP.field_nickname);
                    intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.jQP.field_conRemark);
                    if (NormalUserFooterPreference.this.pnn == 14 || NormalUserFooterPreference.this.pnn == 8) {
                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", stringExtra);
                    intent.putExtra("source_from_nick_name", stringExtra3);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                    intent.putExtra(com.tencent.mm.ui.e.a.xML, str);
                    NormalUserFooterPreference.this.fnF.startActivity(intent);
                    return true;
                }
            };
            stringExtra3 = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra("room_name");
            Object stringExtra4 = NormalUserFooterPreference.this.fnF.getIntent().getStringExtra(com.tencent.mm.ui.e.a.xML);
            if (!TextUtils.isEmpty(stringExtra4)) {
                aVar.SP(stringExtra4);
                aVar.b(NormalUserFooterPreference.this.jQP.field_username, "", linkedList);
            } else if (TextUtils.isEmpty(stringExtra3)) {
                aVar.c(NormalUserFooterPreference.this.jQP.field_username, linkedList);
            } else if (TextUtils.isEmpty(aVar.mTU)) {
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                stringExtra4 = Xv != null ? bi.aD(Xv.fXA, "") : "";
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", NormalUserFooterPreference.this.jQP.field_username, stringExtra3, stringExtra4);
                if (TextUtils.isEmpty(stringExtra4)) {
                    com.tencent.mm.y.ak.a.hhv.a(NormalUserFooterPreference.this.jQP.field_username, stringExtra3, new com.tencent.mm.y.ak.b.a() {
                        public final void v(String str, boolean z) {
                            as.Hm();
                            ag Xv = com.tencent.mm.y.c.Ff().Xv(NormalUserFooterPreference.this.jQP.field_username);
                            aVar.SP(Xv != null ? bi.aD(Xv.fXA, "") : "");
                            aVar.b(NormalUserFooterPreference.this.jQP.field_username, stringExtra3, linkedList);
                        }
                    });
                    return;
                }
                aVar.SP(stringExtra4);
                aVar.b(NormalUserFooterPreference.this.jQP.field_username, stringExtra3, linkedList);
            } else {
                aVar.b(NormalUserFooterPreference.this.jQP.field_username, stringExtra3, linkedList);
            }
        }
    }

    class b extends c {
        public b() {
            super();
        }

        protected final void bkm() {
            if (NormalUserFooterPreference.this.jQP == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
            } else if (com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type) && (!com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type) || !x.gB(NormalUserFooterPreference.this.jQP.field_username))) {
                bkl();
            } else if (x.gB(NormalUserFooterPreference.this.jQP.field_username)) {
                v(true, true);
            } else {
                v(false, true);
            }
        }

        protected final void bkk() {
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            if (!com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type) || (com.tencent.mm.k.a.ga(NormalUserFooterPreference.this.jQP.field_type) && x.gB(NormalUserFooterPreference.this.jQP.field_username))) {
                NormalUserFooterPreference.this.ppY.setVisibility(0);
                NormalUserFooterPreference.this.oqb.setVisibility(8);
                NormalUserFooterPreference.this.pqe.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.ppY.setVisibility(8);
                NormalUserFooterPreference.this.oqb.setVisibility(0);
                if (!(NormalUserFooterPreference.this.bkh() || NormalUserFooterPreference.this.jQP.field_username.equals(q.FY()))) {
                    NormalUserFooterPreference.this.pqc.setVisibility(0);
                    NormalUserFooterPreference.this.pqb.setVisibility(8);
                    NormalUserFooterPreference.this.pqd.setVisibility(8);
                    NormalUserFooterPreference.this.pqf.setVisibility(8);
                    if (NormalUserFooterPreference.this.ppP) {
                        NormalUserFooterPreference.this.ppY.setVisibility(8);
                        NormalUserFooterPreference.this.pqb.setVisibility(0);
                        NormalUserFooterPreference.this.pqb.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                b.this.bkp();
                            }
                        });
                    }
                    NormalUserFooterPreference.this.pqa.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent;
                            if (NormalUserFooterPreference.this.ppQ && com.tencent.mm.bj.a.bYH()) {
                                intent = new Intent();
                                intent.putExtra("Chat_User", NormalUserFooterPreference.this.jQP.field_encryptUsername);
                                intent.putExtra("lbs_mode", true);
                                intent.putExtra("lbs_ticket", NormalUserFooterPreference.this.kBn);
                                intent.putExtra("add_scene", NormalUserFooterPreference.this.pnn);
                                com.tencent.mm.plugin.profile.a.ihN.e(intent, NormalUserFooterPreference.this.fnF);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("Contact_User", NormalUserFooterPreference.this.jQP.field_username);
                            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.pnn);
                            intent.putExtra(com.tencent.mm.ui.e.a.xML, NormalUserFooterPreference.this.jQP.fXA);
                            com.tencent.mm.plugin.profile.a.ihN.a(intent, NormalUserFooterPreference.this.mContext);
                        }
                    });
                }
            }
            NormalUserFooterPreference.this.pqc.setVisibility(8);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.pqd.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
            if (NormalUserFooterPreference.this.ppP) {
                NormalUserFooterPreference.this.ppY.setVisibility(8);
                NormalUserFooterPreference.this.pqb.setVisibility(0);
                NormalUserFooterPreference.this.pqb.setOnClickListener(/* anonymous class already generated */);
            }
            NormalUserFooterPreference.this.pqa.setOnClickListener(/* anonymous class already generated */);
        }
    }

    class d extends a {
        public d() {
            super();
        }

        protected final void bkm() {
        }

        protected final void bkk() {
            Assert.assertTrue(s.gU(NormalUserFooterPreference.this.jQP.field_username));
            NormalUserFooterPreference.this.ppS.setVisibility(8);
            NormalUserFooterPreference.this.ppY.setVisibility(8);
            NormalUserFooterPreference.this.pqb.setVisibility(8);
            NormalUserFooterPreference.this.oqb.setVisibility(0);
            NormalUserFooterPreference.this.pqe.setVisibility(8);
            NormalUserFooterPreference.this.pqc.setVisibility(8);
            NormalUserFooterPreference.this.pqd.setVisibility(8);
            NormalUserFooterPreference.this.pqf.setVisibility(8);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        this.fnF = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnF = (MMActivity) context;
        init();
    }

    private void init() {
        this.lXm = false;
        this.ppR = null;
    }

    private void initView() {
        if (!this.lXm || this.jQP == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lXm + " contact = " + this.jQP);
            if (this.ppR != null) {
                try {
                    this.ppR.bkm();
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            return;
        }
        if (this.ppR != null) {
            this.ppR.EP();
        }
        bkh();
    }

    public final void onBindView(View view) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.ppS = view.findViewById(R.h.bXO);
        this.ppT = (Button) view.findViewById(R.h.bYe);
        this.ppU = (Button) view.findViewById(R.h.bXt);
        this.ppX = (Button) view.findViewById(R.h.bYg);
        this.ppW = view.findViewById(R.h.bYh);
        this.ppV = (Button) view.findViewById(R.h.bYf);
        this.pqb = (Button) view.findViewById(R.h.bXo);
        this.ppY = view.findViewById(R.h.bXU);
        this.ppZ = (Button) view.findViewById(R.h.bXT);
        this.pqa = (Button) view.findViewById(R.h.bXV);
        this.oqb = (Button) view.findViewById(R.h.bXW);
        this.pqe = (Button) view.findViewById(R.h.bXK);
        this.pqc = (Button) view.findViewById(R.h.bYi);
        this.pqd = (Button) view.findViewById(R.h.bXr);
        this.pqf = (TextView) view.findViewById(R.h.bXL);
        this.lXm = true;
        initView();
        super.onBindView(view);
        if (this.fnF.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.ppT != null) {
            this.ppT.performClick();
        }
    }

    public final boolean a(x xVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        asz();
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bi.oM(xVar.field_username).length() > 0);
        if (x.Xk(q.FY()).equals(xVar.field_username)) {
            return false;
        }
        this.jQP = xVar;
        this.mTU = str;
        this.pnl = z;
        this.pnn = i;
        this.poP = i2;
        this.ppO = bi.a(Boolean.valueOf(s.gF(xVar.field_username)), false);
        this.ppM = z4;
        this.ppN = z5;
        this.ppA = j;
        this.poX = str2;
        this.pqh = false;
        this.ppd = xVar.field_deleteFlag == 1;
        this.pqg = this.fnF.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.pox = this.fnF.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.ppP = this.fnF.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.ppQ = this.fnF.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.kBn = this.fnF.getIntent().getStringExtra("lbs_ticket");
        if (!q.gt(xVar.field_username)) {
            as.Hm();
            if (!com.tencent.mm.y.c.Fn().has(xVar.field_username)) {
                if (x.Xd(xVar.field_username)) {
                    this.ppR = new h();
                } else if (s.gU(xVar.field_username)) {
                    this.ppR = new d();
                } else if (s.gF(xVar.field_username)) {
                    this.ppR = new g();
                } else if (x.Xe(xVar.field_username)) {
                    this.ppR = new f();
                } else if (com.tencent.mm.k.a.ga(xVar.field_type) && !x.gB(xVar.field_username)) {
                    this.ppR = new c();
                    this.pqh = true;
                } else if (z2) {
                    this.ppR = new j();
                    this.pqh = true;
                } else if (z3 || x.gB(xVar.field_username)) {
                    this.ppR = new b();
                } else {
                    this.ppR = new c();
                    this.pqh = true;
                }
                initView();
                return true;
            }
        }
        this.ppR = new c();
        this.pqh = true;
        initView();
        return true;
    }

    public final boolean bkh() {
        if (this.pqg && com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            this.pqe.setVisibility(0);
            return true;
        }
        this.pqe.setVisibility(8);
        return false;
    }

    public final boolean asz() {
        if (this.ppR != null) {
            this.ppR.onDetach();
        }
        this.hmJ.removeAll();
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        return true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (bi.oM(str).length() <= 0 || this.jQP == null) {
            return;
        }
        if (str.equals(this.jQP.field_username) || str.equals(this.jQP.field_encryptUsername)) {
            as.Hm();
            this.jQP = com.tencent.mm.y.c.Ff().Xv(this.jQP.field_username);
            ah.y(new Runnable() {
                public final void run() {
                    NormalUserFooterPreference.this.bkh();
                }
            });
        }
    }

    public final void bki() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.RECORD_AUDIO", 82, "", "")), bi.chl(), this.fnF);
        if (com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.RECORD_AUDIO", 82, "", "")) {
            com.tencent.mm.sdk.b.b srVar = new sr();
            srVar.fLl.fvG = 5;
            srVar.fLl.talker = this.jQP.field_username;
            srVar.fLl.context = this.fnF;
            srVar.fLl.fLg = 4;
            com.tencent.mm.sdk.b.a.xmy.m(srVar);
        }
    }

    public final void bkj() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.CAMERA", 19, "", "")), bi.chl(), this.fnF);
        if (com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.CAMERA", 19, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.RECORD_AUDIO", 19, "", "")), bi.chl(), this.fnF);
            if (com.tencent.mm.pluginsdk.g.a.a(this.fnF, "android.permission.RECORD_AUDIO", 19, "", "")) {
                com.tencent.mm.sdk.b.b srVar = new sr();
                srVar.fLl.fvG = 5;
                srVar.fLl.talker = this.jQP.field_username;
                srVar.fLl.context = this.fnF;
                srVar.fLl.fLg = 2;
                com.tencent.mm.sdk.b.a.xmy.m(srVar);
            }
        }
    }
}
