package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.d;
import com.tencent.mm.af.d.b;
import com.tencent.mm.af.n;
import com.tencent.mm.af.t;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.cu;
import com.tencent.mm.f.a.cy;
import com.tencent.mm.f.a.nf;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements e, com.tencent.mm.af.h.a, n, com.tencent.mm.pluginsdk.c.a {
    MMActivity fnF;
    private SharedPreferences hbz;
    private List<com.tencent.mm.af.d.a> hpZ;
    private b hqa;
    private boolean hqh;
    private String hqj;
    f inW;
    boolean isDeleteCancel;
    x jQP;
    d kKo;
    private boolean kYN;
    private CheckBoxPreference lfv;
    String mTU;
    private boolean pnl;
    private int pnn;
    private String pnr;
    i poA;
    private Bundle poB;
    SnsAdClick poC;
    private String poD;
    private j poq;
    private List<WxaEntryInfo> por;
    private py pot;
    private boolean pou;
    private boolean pov;
    boolean pow;
    private int pox;
    private String poy;
    private boolean poz;
    r tipDialog;

    private static class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
        private String url;

        public a(Resources resources, String str) {
            boolean z = true;
            Bitmap b = com.tencent.mm.y.ak.a.hhx != null ? BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(16), 2.0f) : null;
            String str2 = "MicroMsg.ContactWidgetBizInfo";
            String str3 = "verify bmp is null ? %B";
            Object[] objArr = new Object[1];
            if (b != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
            super(resources, b);
            this.url = str;
            com.tencent.mm.platformtools.j.a((com.tencent.mm.platformtools.j.a) this);
        }

        public final void draw(Canvas canvas) {
            Bitmap a = com.tencent.mm.platformtools.j.a(new com.tencent.mm.platformtools.i() {
                public final boolean Wt() {
                    return false;
                }

                public final boolean Ws() {
                    return false;
                }

                public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
                    if (com.tencent.mm.platformtools.i.a.NET == aVar) {
                        try {
                            com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactWidgetBizInfo", e, "", new Object[0]);
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "save bitmap fail");
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "get bitmap, from %s", aVar.toString());
                    return bitmap;
                }

                public final void Wv() {
                }

                public final void N(String str, boolean z) {
                }

                public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
                }

                public final com.tencent.mm.platformtools.i.b Wn() {
                    return null;
                }

                public final String Wo() {
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    return stringBuilder.append(com.tencent.mm.y.c.FC()).append(ac.VF(a.this.url)).toString();
                }

                public final String Wq() {
                    return a.this.url;
                }

                public final Bitmap Wu() {
                    return null;
                }

                public final String Wp() {
                    return a.this.url;
                }

                public final String Wr() {
                    return a.this.url;
                }
            });
            if (a == null || a.isRecycled()) {
                a = null;
            }
            Rect bounds = getBounds();
            if (a != null) {
                canvas.drawBitmap(a, null, bounds, null);
            }
        }

        public final void l(String str, Bitmap bitmap) {
            if (this.url.equals(str)) {
                invalidateSelf();
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        g gVar = new g(cVar.fnF, g.zCt, false);
        gVar.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(com.tencent.mm.ui.base.n nVar) {
                if (c.this.kKo != null && c.this.kKo.Lk()) {
                    nVar.eT(1, R.l.dWA);
                    nVar.eT(3, R.l.dMw);
                    nVar.eT(4, R.l.dUM);
                    nVar.eT(5, R.l.dUC);
                } else if (c.this.kKo == null || !c.this.kKo.Ll()) {
                    nVar.eT(1, R.l.dWA);
                    nVar.eT(2, R.l.dUH);
                    if (!c.this.Ie(c.this.jQP.field_username)) {
                        nVar.eT(3, R.l.dMw);
                        nVar.eT(4, R.l.dUM);
                    }
                    nVar.eT(5, R.l.dUC);
                } else {
                    nVar.eT(5, R.l.dUC);
                }
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                c cVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        cVar = c.this;
                        Intent intent = new Intent();
                        intent.putExtra("Select_Talker_Name", cVar.jQP.field_username);
                        intent.putExtra("Select_block_List", cVar.jQP.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        com.tencent.mm.plugin.profile.a.ihN.a(intent, cVar.fnF);
                        return;
                    case 2:
                        c.this.fnF.getString(R.l.eiL, new Object[]{c.this.jQP.AX()});
                        h.a(c.this.fnF, c.this.fnF.getString(R.l.dUI), "", c.this.fnF.getString(R.l.dUH), c.this.fnF.getString(R.l.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                c cVar = c.this;
                                String str = cVar.jQP.field_username;
                                as.Hm();
                                cg Fc = com.tencent.mm.y.c.Fh().Fc(str);
                                as.Hm();
                                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.d(str, Fc.field_msgSvrId));
                                cVar.isDeleteCancel = false;
                                Context context = cVar.fnF;
                                cVar.fnF.getString(R.l.dGZ);
                                cVar.tipDialog = h.a(context, cVar.fnF.getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        c.this.isDeleteCancel = true;
                                    }
                                });
                                bb.a(str, new com.tencent.mm.y.bb.a() {
                                    public final boolean HH() {
                                        return c.this.isDeleteCancel;
                                    }

                                    public final void HG() {
                                        if (c.this.tipDialog != null) {
                                            c.this.tipDialog.dismiss();
                                            c.this.tipDialog = null;
                                        }
                                    }
                                });
                            }
                        }, null);
                        return;
                    case 3:
                        c.this.bkd();
                        return;
                    case 4:
                        c cVar2 = c.this;
                        ((com.tencent.mm.pluginsdk.h) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.h.class)).a(cVar2.kKo, cVar2.fnF, cVar2.jQP, true, new Runnable() {
                            public final void run() {
                                c.this.aC(4, null);
                                if (c.this.fnF.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.bl.d.b(c.this.fnF, "shake", ".ui.ShakeReportUI", intent);
                                }
                            }
                        });
                        return;
                    case 5:
                        cVar = c.this;
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.jQP.field_username);
                        com.tencent.mm.plugin.base.model.b.M(cVar.fnF, cVar.jQP.field_username);
                        ah.h(new Runnable() {
                            public final void run() {
                                com.tencent.mm.plugin.base.model.b.L(c.this.fnF, c.this.jQP.field_username);
                            }
                        }, 1000);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    private c(MMActivity mMActivity) {
        this.pot = null;
        this.pou = false;
        this.pov = false;
        this.hqh = false;
        this.pow = false;
        this.pox = 0;
        this.poA = null;
        this.hbz = null;
        this.poC = null;
        this.poD = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        this.fnF = mMActivity;
    }

    public c(MMActivity mMActivity, String str, py pyVar) {
        this(mMActivity);
        this.pnr = str;
        this.pot = pyVar;
    }

    public final boolean ww(String str) {
        int i = 4;
        if (str == null) {
            return false;
        }
        String str2;
        String str3;
        Intent intent;
        String stringExtra;
        Context context;
        if (str.equals("contact_info_verifyuser_weibo")) {
            e aVar = new com.tencent.mm.plugin.profile.ui.a.a(this.fnF);
            str2 = this.jQP.fXo;
            str3 = this.jQP.field_username;
            if (str2 == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ViewTWeibo", "null weibo id");
                return true;
            }
            as.CN().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, aVar);
            aVar.pqZ = new com.tencent.mm.plugin.profile.a.a(bi.oM(str2).replace("http://t.qq.com/", "").trim(), str3);
            as.CN().a(aVar.pqZ, 0);
            aVar.pra.K(3000, 3000);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.poC != null) {
                com.tencent.mm.sdk.b.b nfVar = new nf();
                this.poC.hQl = 5;
                nfVar.fFY.fFZ = this.poC;
                com.tencent.mm.sdk.b.a.xmy.m(nfVar);
            }
            if (this.kKo == null || !(this.kKo.Lk() || this.kKo.Lm())) {
                intent = new Intent();
                if (this.fnF.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                if (this.pnl) {
                    intent.putExtra("Chat_User", this.jQP.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    this.fnF.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", this.jQP.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.ihN.e(intent, this.fnF);
                }
            } else {
                intent = new Intent();
                if (this.kKo.Lm()) {
                    str2 = this.kKo.Ls();
                    if (bi.oN(str2)) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    intent.putExtra("enterprise_biz_name", str2);
                    intent.putExtra("enterprise_biz_display_name", com.tencent.mm.y.r.gw(str2));
                } else {
                    intent.putExtra("enterprise_biz_name", this.jQP.field_username);
                    intent.putExtra("enterprise_biz_display_name", com.tencent.mm.y.r.gw(this.jQP.field_username));
                }
                intent.addFlags(67108864);
                com.tencent.mm.bl.d.a(this.fnF, ".ui.conversation.EnterpriseConversationUI", intent);
                this.fnF.finish();
            }
            aC(5, null);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (this.fnF.getIntent() != null && this.fnF.getIntent().getBooleanExtra("KIsHardDevice", false)) {
                stringExtra = this.fnF.getIntent().getStringExtra("KHardDeviceBindTicket");
                if (bi.oN(stringExtra)) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
                } else if (!bkc()) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                    as.CN().a(536, (e) this);
                    com.tencent.mm.sdk.b.b cuVar = new cu();
                    cuVar.frS.frU = stringExtra;
                    cuVar.frS.opType = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(cuVar);
                    final k kVar = cuVar.frT.frW;
                    context = this.fnF;
                    this.fnF.getString(R.l.dGZ);
                    this.tipDialog = h.a(context, this.fnF.getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().b(536, c.this);
                            com.tencent.mm.sdk.b.b cuVar = new cu();
                            cuVar.frS.opType = 2;
                            cuVar.frS.frW = kVar;
                            com.tencent.mm.sdk.b.a.xmy.m(cuVar);
                        }
                    });
                    if (this.pox != 0) {
                        return true;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(11263, Integer.valueOf(this.pox), this.jQP.field_username);
                    return true;
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.fnF, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(boolean r9, boolean r10, java.lang.String r11, java.lang.String r12) {
                    /*
                    r8 = this;
                    r1 = 0;
                    r3 = 0;
                    r2 = 1;
                    if (r9 == 0) goto L_0x011b;
                L_0x0005:
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r0 = r0.fnF;
                    r4 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r4.fnF;
                    r5 = com.tencent.mm.R.l.dUF;
                    r4 = r4.getString(r5);
                    com.tencent.mm.ui.base.h.bu(r0, r4);
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r0 = r0.inW;
                    r4 = "contact_info_time_expired";
                    r0.bl(r4, r2);
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r0.jQP;
                    if (r4 == 0) goto L_0x002c;
                L_0x0026:
                    r0 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
                    if (r0 == 0) goto L_0x011c;
                L_0x002c:
                    r0 = "MicroMsg.ContactWidgetBizInfo";
                    r5 = new java.lang.StringBuilder;
                    r6 = "respUsername == ";
                    r5.<init>(r6);
                    r5 = r5.append(r11);
                    r6 = ", contact = ";
                    r5 = r5.append(r6);
                    r4 = r5.append(r4);
                    r4 = r4.toString();
                    com.tencent.mm.sdk.platformtools.x.e(r0, r4);
                L_0x004d:
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r0.pow = r2;
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r0 = r0.poC;
                    if (r0 == 0) goto L_0x0070;
                L_0x0057:
                    r0 = new com.tencent.mm.f.a.nf;
                    r0.<init>();
                    r4 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r4.poC;
                    r5 = 4;
                    r4.hQl = r5;
                    r4 = r0.fFY;
                    r5 = com.tencent.mm.plugin.profile.ui.c.this;
                    r5 = r5.poC;
                    r4.fFZ = r5;
                    r4 = com.tencent.mm.sdk.b.a.xmy;
                    r4.m(r0);
                L_0x0070:
                    r0 = com.tencent.mm.af.y.Ml();
                    r4 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r4.jQP;
                    r4 = r4.field_username;
                    r0 = r0.jN(r4);
                    r0.field_status = r2;
                    r4 = r0.field_extInfo;
                    r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
                    if (r4 == 0) goto L_0x01de;
                L_0x0088:
                    r4 = r0.field_username;
                    r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
                    if (r4 != 0) goto L_0x01de;
                L_0x0090:
                    r4 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r4.kKo;
                    if (r4 == 0) goto L_0x01de;
                L_0x0096:
                    r4 = r0.field_username;
                    r5 = com.tencent.mm.plugin.profile.ui.c.this;
                    r5 = r5.kKo;
                    r5 = r5.field_username;
                    r5 = com.tencent.mm.sdk.platformtools.bi.oM(r5);
                    r4 = r4.equals(r5);
                    if (r4 == 0) goto L_0x01de;
                L_0x00a8:
                    r4 = com.tencent.mm.af.y.Ml();
                    r5 = com.tencent.mm.plugin.profile.ui.c.this;
                    r5 = r5.kKo;
                    r4.e(r5);
                L_0x00b3:
                    r4 = com.tencent.mm.plugin.profile.ui.c.this;
                    r4 = r4.fnF;
                    r4 = r4.getIntent();
                    r5 = "key_biz_profile_stay_after_follow_op";
                    r4 = r4.getBooleanExtra(r5, r3);
                    r5 = com.tencent.mm.plugin.profile.ui.c.this;
                    r5 = r5.fnF;
                    r5 = r5.getIntent();
                    r6 = "key_start_biz_profile_from_app_brand_profile";
                    r3 = r5.getBooleanExtra(r6, r3);
                    r0 = r0.Lk();
                    if (r0 == 0) goto L_0x01e7;
                L_0x00d7:
                    r0 = new android.content.Intent;
                    r0.<init>();
                    r2 = "enterprise_biz_name";
                    r3 = com.tencent.mm.plugin.profile.ui.c.this;
                    r3 = r3.jQP;
                    r3 = r3.field_username;
                    r0.putExtra(r2, r3);
                    r2 = "enterprise_biz_display_name";
                    r3 = com.tencent.mm.plugin.profile.ui.c.this;
                    r3 = r3.jQP;
                    r3 = r3.field_username;
                    r3 = com.tencent.mm.y.r.gw(r3);
                    r0.putExtra(r2, r3);
                    r2 = "enterprise_from_scene";
                    r3 = 7;
                    r0.putExtra(r2, r3);
                    r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
                    r0.addFlags(r2);
                    r2 = com.tencent.mm.plugin.profile.ui.c.this;
                    r2 = r2.fnF;
                    r3 = ".ui.conversation.EnterpriseConversationUI";
                    com.tencent.mm.bl.d.a(r2, r3, r0);
                L_0x010e:
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r0 = r0.fnF;
                    r0.finish();
                L_0x0115:
                    r0 = com.tencent.mm.plugin.profile.ui.c.this;
                    r2 = 3;
                    r0.aC(r2, r1);
                L_0x011b:
                    return;
                L_0x011c:
                    r0 = r4.field_username;
                    r0 = com.tencent.mm.y.s.gG(r0);
                    if (r0 == 0) goto L_0x021a;
                L_0x0124:
                    r0 = r4.field_username;
                    r5 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
                    r0 = com.tencent.mm.af.f.jV(r5);
                    if (r0 == 0) goto L_0x0132;
                L_0x0130:
                    r0.field_username = r11;
                L_0x0132:
                    r6 = com.tencent.mm.af.y.Ml();
                    r6.jO(r5);
                    r4.di(r5);
                L_0x013c:
                    r4.setUsername(r11);
                    r6 = r4.gKO;
                    r5 = (int) r6;
                    if (r5 != 0) goto L_0x014e;
                L_0x0144:
                    com.tencent.mm.y.as.Hm();
                    r5 = com.tencent.mm.y.c.Ff();
                    r5.T(r4);
                L_0x014e:
                    r6 = r4.gKO;
                    r5 = (int) r6;
                    if (r5 > 0) goto L_0x015e;
                L_0x0153:
                    r0 = "MicroMsg.ContactWidgetBizInfo";
                    r4 = "addContact : insert contact failed";
                    com.tencent.mm.sdk.platformtools.x.e(r0, r4);
                    goto L_0x004d;
                L_0x015e:
                    com.tencent.mm.y.s.p(r4);
                    com.tencent.mm.y.as.Hm();
                    r5 = com.tencent.mm.y.c.Ff();
                    r4 = r4.field_username;
                    r4 = r5.Xv(r4);
                    if (r0 == 0) goto L_0x0179;
                L_0x0170:
                    r4 = com.tencent.mm.af.y.Ml();
                    r4.d(r0);
                    goto L_0x004d;
                L_0x0179:
                    r0 = r4.field_username;
                    r5 = com.tencent.mm.af.f.jV(r0);
                    r0 = r4.ciN();
                    if (r0 == 0) goto L_0x01b0;
                L_0x0185:
                    r0 = com.tencent.mm.af.a.Lb();
                    if (r0 == 0) goto L_0x01b0;
                L_0x018b:
                    r0 = r2;
                L_0x018c:
                    if (r5 == 0) goto L_0x0196;
                L_0x018e:
                    r5 = r5.Le();
                    if (r5 == 0) goto L_0x01b2;
                L_0x0194:
                    if (r0 != 0) goto L_0x01b2;
                L_0x0196:
                    r0 = "MicroMsg.ContactWidgetBizInfo";
                    r5 = "shouldUpdate";
                    com.tencent.mm.sdk.platformtools.x.d(r0, r5);
                    r0 = com.tencent.mm.y.ak.a.hhv;
                    r5 = r4.field_username;
                    r6 = "";
                    r0.Q(r5, r6);
                    r0 = r4.field_username;
                    com.tencent.mm.ac.b.ja(r0);
                    goto L_0x004d;
                L_0x01b0:
                    r0 = r3;
                    goto L_0x018c;
                L_0x01b2:
                    r5 = r4.ciQ();
                    if (r5 == 0) goto L_0x004d;
                L_0x01b8:
                    if (r0 != 0) goto L_0x004d;
                L_0x01ba:
                    r0 = "MicroMsg.ContactWidgetBizInfo";
                    r5 = "update contact, last check time=%d";
                    r6 = new java.lang.Object[r2];
                    r7 = r4.fXr;
                    r7 = java.lang.Integer.valueOf(r7);
                    r6[r3] = r7;
                    com.tencent.mm.sdk.platformtools.x.d(r0, r5, r6);
                    r0 = com.tencent.mm.y.ak.a.hhv;
                    r5 = r4.field_username;
                    r6 = "";
                    r0.Q(r5, r6);
                    r0 = r4.field_username;
                    com.tencent.mm.ac.b.ja(r0);
                    goto L_0x004d;
                L_0x01de:
                    r4 = com.tencent.mm.af.y.Ml();
                    r4.e(r0);
                    goto L_0x00b3;
                L_0x01e7:
                    r0 = new android.content.Intent;
                    r0.<init>();
                    r5 = "Chat_User";
                    r6 = com.tencent.mm.plugin.profile.ui.c.this;
                    r6 = r6.jQP;
                    r6 = r6.field_username;
                    r0.putExtra(r5, r6);
                    r5 = "key_has_add_contact";
                    r0.putExtra(r5, r2);
                    r5 = "finish_direct";
                    r0.putExtra(r5, r2);
                    if (r3 == 0) goto L_0x020b;
                L_0x0206:
                    r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                    r0.addFlags(r2);
                L_0x020b:
                    r2 = com.tencent.mm.plugin.profile.a.ihN;
                    r5 = com.tencent.mm.plugin.profile.ui.c.this;
                    r5 = r5.fnF;
                    r2.e(r0, r5);
                    if (r4 != 0) goto L_0x010e;
                L_0x0216:
                    if (r3 == 0) goto L_0x0115;
                L_0x0218:
                    goto L_0x010e;
                L_0x021a:
                    r0 = r1;
                    goto L_0x013c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.c.5.a(boolean, boolean, java.lang.String, java.lang.String):void");
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.pnn));
            if (this.hqj != null) {
                aVar2.vty = this.hqj;
            }
            if (!bi.oN(this.mTU)) {
                aVar2.mTU = this.mTU;
            }
            aVar2.vtF = true;
            aVar2.a(this.jQP.field_username, linkedList, this.poD);
            if (this.pox != 0) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(11263, Integer.valueOf(this.pox), this.jQP.field_username);
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            return true;
        } else {
            if (!"contact_info_stick_biz".equals(str)) {
                int i2;
                if (!(!"contact_info_guarantee_info".equals(str) || this.hqa.LD() == null || bi.oN(this.hqa.LD().hrc))) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", this.hqa.LD().hrc);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bl.d.b(this.fnF, "webview", ".ui.tools.WebViewUI", intent);
                }
                if (str.startsWith("contact_info_bizinfo_external#")) {
                    i2 = bi.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                    if (i2 >= 0 && i2 < this.hpZ.size()) {
                        com.tencent.mm.af.d.a aVar3 = (com.tencent.mm.af.d.a) this.hpZ.get(i2);
                        str2 = aVar3.url;
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra("vertical_scroll", true);
                        intent2.putExtra("geta8key_scene", 3);
                        intent2.putExtra("KPublisherId", "brand_profile");
                        intent2.putExtra("prePublishId", "brand_profile");
                        if ((this.poB != null && (this.pnn == 39 || this.pnn == 56 || this.pnn == 35)) || this.pnn == 87 || this.pnn == 89 || this.pnn == 85 || this.pnn == 88) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("KFromBizSearch", true);
                            bundle.putBundle("KBizSearchExtArgs", this.poB);
                            intent2.putExtra("jsapiargs", bundle);
                            i = com.tencent.mm.k.a.ga(this.jQP.field_type) ? 7 : 6;
                            int identifier = this.fnF.getResources().getIdentifier(aVar3.hqd, "string", this.fnF.getPackageName());
                            stringExtra = aVar3.title;
                            if (identifier > 0) {
                                stringExtra = this.fnF.getString(identifier);
                            }
                            aC(i, stringExtra);
                        }
                        com.tencent.mm.bl.d.b(this.fnF, "webview", ".ui.tools.WebViewUI", intent2);
                        return true;
                    }
                }
                d dVar;
                Intent intent3;
                if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                    final d dVar2 = this.kKo;
                    if (dVar2 == null) {
                        return true;
                    }
                    if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                        if (!dVar2.Lj()) {
                            if (dVar2.Lc()) {
                                dVar2.field_brandFlag |= 1;
                                if (this.hqa == null && dVar2 != null) {
                                    this.hqa = dVar2.bK(false);
                                }
                                if (this.hqa != null && this.hqa.Lw() && com.tencent.mm.bl.d.Pu("brandservice")) {
                                    this.inW.bl("contact_info_template_recv", false);
                                } else {
                                    this.inW.bl("contact_info_template_recv", true);
                                }
                            } else {
                                dVar2.field_brandFlag &= -2;
                                this.inW.bl("contact_info_template_recv", true);
                            }
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[4];
                            objArr[0] = dVar2.field_username;
                            objArr[1] = Integer.valueOf(1);
                            if (dVar2.Lc()) {
                                i = 3;
                            }
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(0);
                            gVar.h(13307, objArr);
                        } else if (dVar2 != null) {
                            if (dVar2.Lm()) {
                                as.CN().a(1363, (e) this);
                                if (((CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo")).isChecked()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                }
                                final k bVar = new com.tencent.mm.plugin.profile.a.b(dVar2.field_username, i2);
                                as.CN().a(bVar, 0);
                                Context context2 = this.fnF;
                                this.fnF.getString(R.l.dGZ);
                                this.tipDialog = h.a(context2, this.fnF.getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(bVar);
                                        as.CN().b(1363, c.this);
                                    }
                                });
                            } else if (dVar2.Lk()) {
                                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
                                y.Ms();
                                final com.tencent.mm.af.x a = com.tencent.mm.af.c.a(dVar2.field_username, !checkBoxPreference.isChecked(), this);
                                context = this.fnF;
                                this.fnF.getString(R.l.dGZ);
                                this.tipDialog = h.a(context, this.fnF.getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        y.Ms();
                                        com.tencent.mm.af.c.a(a);
                                    }
                                });
                            }
                        }
                    } else if ("contact_info_show_brand".endsWith(str)) {
                        boolean z;
                        if ((dVar2.field_brandFlag & 2) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            dVar2.field_brandFlag |= 2;
                        } else {
                            dVar2.field_brandFlag &= -3;
                        }
                    } else if ("contact_info_locate".endsWith(str)) {
                        if (dVar2.Ld()) {
                            dVar2.field_brandFlag &= -5;
                        } else {
                            this.poA = h.a(this.fnF, this.fnF.getString(R.l.dQP, new Object[]{this.jQP.AX()}), this.fnF.getString(R.l.dGZ), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dVar2.field_hadAlert = 1;
                                    dVar2.field_brandFlag |= 4;
                                    c.this.a(dVar2, true);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dVar2.field_hadAlert = 1;
                                    c.this.a(dVar2, false);
                                }
                            });
                        }
                    }
                    if (dVar2.Lm() || dVar2.Lk()) {
                        return true;
                    }
                    a(dVar2, false);
                    return true;
                } else if ("contact_info_verifyuser".endsWith(str)) {
                    dVar = this.kKo;
                    if (dVar == null) {
                        return true;
                    }
                    b bK = dVar.bK(false);
                    if (bK == null) {
                        return true;
                    }
                    stringExtra = null;
                    if (bK.LF() != null && !bi.oN(bK.LF().hqX)) {
                        stringExtra = bK.LF().hqX;
                    } else if (!(bK.LG() == null || bi.oN(bK.LG().hrf))) {
                        stringExtra = bK.LG().hrf;
                    }
                    if (bi.oN(stringExtra)) {
                        return true;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", stringExtra);
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bl.d.b(this.fnF, "webview", ".ui.tools.WebViewUI", intent3);
                    return true;
                } else if ("contact_info_trademark".endsWith(str)) {
                    dVar = this.kKo;
                    if (dVar == null || dVar.bK(false) == null || bi.oN(dVar.bK(false).Ly())) {
                        return true;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", dVar.bK(false).Ly());
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bl.d.b(this.fnF, "webview", ".ui.tools.WebViewUI", intent3);
                    return true;
                } else {
                    if ("contact_is_mute".endsWith(str)) {
                        this.kYN = !this.kYN;
                        if (this.kYN) {
                            s.n(this.jQP);
                        } else {
                            s.o(this.jQP);
                        }
                        hl(this.kYN);
                    }
                    if ("enterprise_contact_info_enter".equals(str)) {
                        if (this.fnF == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                        } else if (this.kKo == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                        } else {
                            intent = new Intent();
                            intent.putExtra("enterprise_biz_name", this.kKo.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bl.d.b(this.fnF, "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                        }
                    }
                    if ("contact_info_biz_disable".equals(str)) {
                        h.a(this.fnF, this.fnF.getString(R.l.ebZ), "", this.fnF.getString(R.l.ebY), this.fnF.getString(R.l.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                c.this.hk(false);
                            }
                        }, null);
                    }
                    if ("contact_info_biz_enable".equals(str)) {
                        hk(true);
                    }
                    if ("contact_info_template_recv".equals(str)) {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.kKo.field_username);
                        com.tencent.mm.bl.d.b(this.fnF, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
                    }
                    if ("contact_info_service_phone".equals(str)) {
                        Preference Zu = this.inW.Zu("contact_info_service_phone");
                        if (!(Zu == null || Zu.getSummary() == null || bi.oN(Zu.getSummary().toString()))) {
                            str3 = Zu.getSummary().toString();
                            h.a(this.fnF, true, str3, "", this.fnF.getString(R.l.dUZ), this.fnF.getString(R.l.dEy), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent("android.intent.action.DIAL");
                                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str3).toString()));
                                    if (bi.k(c.this.fnF, intent)) {
                                        c.this.fnF.startActivity(intent);
                                    }
                                }
                            }, null);
                        }
                    }
                    if ("contact_info_expose_btn".equals(str)) {
                        bkd();
                    }
                    if (!str.equals("biz_placed_to_the_top")) {
                        return true;
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.hbz == null) {
                        this.hbz = this.fnF.getSharedPreferences(this.fnF.getPackageName() + "_preferences", 0);
                    }
                    if (this.jQP == null) {
                        return true;
                    }
                    if (this.jQP.AS()) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", this.jQP.field_username);
                        s.s(this.jQP.field_username, true);
                        this.hbz.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        return true;
                    }
                    com.tencent.mm.y.i.gb(this.jQP.field_username);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", this.jQP.field_username);
                    this.hbz.edit().putBoolean("biz_placed_to_the_top", true).commit();
                    return true;
                }
            } else if (((CheckBoxPreference) this.inW.Zu("contact_info_stick_biz")).isChecked()) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13307, this.jQP.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
                com.tencent.mm.y.i.gb(this.jQP.field_username);
                return true;
            } else {
                s.s(this.jQP.field_username, true);
                com.tencent.mm.plugin.report.service.g.pWK.h(13307, this.jQP.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
                return true;
            }
        }
    }

    final void hk(boolean z) {
        final k cVar = new com.tencent.mm.plugin.profile.a.c(this.kKo.field_username, !z);
        as.CN().a(1394, (e) this);
        as.CN().a(cVar, 0);
        Context context = this.fnF;
        this.fnF.getString(R.l.dGZ);
        this.tipDialog = h.a(context, this.fnF.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(cVar);
                as.CN().b(1394, c.this);
            }
        });
    }

    final void a(d dVar, boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("contact_info_locate");
        com.tencent.mm.bp.a arv = new arv();
        arv.hxs = dVar.field_brandFlag;
        arv.kyG = this.jQP.field_username;
        if (vi(this.pnn)) {
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(58, arv));
        } else {
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, arv));
        }
        y.Ml().c(dVar, new String[0]);
        checkBoxPreference.tYU = dVar.Lc();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.tYU = dVar.Ld();
        }
        if (z) {
            bka();
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        Assert.assertTrue(xVar != null);
        if (bi.oM(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.inW = fVar;
        this.jQP = xVar;
        this.pnl = z;
        this.pnn = i;
        this.pox = this.fnF.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.poC = (SnsAdClick) this.fnF.getIntent().getParcelableExtra("KSnsAdTag");
        this.poB = this.fnF.getIntent().getBundleExtra("Contact_Ext_Args");
        this.poD = this.fnF.getIntent().getStringExtra("key_add_contact_report_info");
        bka();
        String stringExtra = this.fnF.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bi.oN(stringExtra)) {
            this.fnF.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            h.a(this.fnF, stringExtra, "", this.fnF.getString(R.l.dGf), null);
        }
        if (xVar != null) {
            y.Mv().jz(xVar.field_username);
            if (com.tencent.mm.af.f.jY(xVar.field_username)) {
                stringExtra = xVar.field_username;
                if (com.tencent.mm.af.f.eG(stringExtra)) {
                    y.Mr();
                    com.tencent.mm.af.a.h.a(stringExtra, (n) this);
                    stringExtra = com.tencent.mm.af.f.jV(stringExtra).Ls();
                    if (stringExtra != null) {
                        y.Mv().jz(stringExtra);
                    }
                } else if (com.tencent.mm.af.f.ka(stringExtra)) {
                    y.Ms();
                    com.tencent.mm.af.c.a(stringExtra, (e) this);
                    y.Ml();
                    stringExtra = com.tencent.mm.af.e.jR(stringExtra);
                    if (stringExtra != null) {
                        y.Mv().jz(stringExtra);
                    }
                }
            }
        }
        return true;
    }

    private void bka() {
        d dVar;
        CheckBoxPreference checkBoxPreference;
        String str;
        boolean z;
        b bVar;
        Preference Zu;
        KeyValuePreference keyValuePreference;
        Bitmap b;
        String str2;
        String str3;
        Object[] objArr;
        boolean z2;
        Drawable bitmapDrawable;
        String string;
        Bitmap b2;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        com.tencent.mm.af.g kf;
        com.tencent.mm.af.h Mm;
        IconWidgetPreference iconWidgetPreference;
        com.tencent.mm.af.i Mk;
        com.tencent.mm.af.g ke;
        CheckBoxPreference checkBoxPreference2;
        String AX;
        int identifier;
        asz();
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbC);
        if (this.pow) {
            this.inW.bl("contact_info_time_expired", true);
        }
        d jV = com.tencent.mm.af.f.jV(this.jQP.field_username);
        this.hpZ = null;
        this.hqa = null;
        this.por = null;
        if ((jV == null || jV.bK(false) == null) && this.pot != null) {
            jV = new d();
            jV.field_username = this.jQP.field_username;
            jV.field_brandFlag = this.pot.hxs;
            jV.field_brandIconURL = this.pot.hxv;
            jV.field_brandInfo = this.pot.hxu;
            jV.field_extInfo = this.pot.hxt;
            dVar = jV;
        } else {
            dVar = jV;
        }
        if (dVar != null && dVar.field_brandInfo == null && dVar.field_extInfo == null && this.pot != null) {
            dVar.field_username = this.jQP.field_username;
            dVar.field_brandFlag = this.pot.hxs;
            dVar.field_brandIconURL = this.pot.hxv;
            dVar.field_brandInfo = this.pot.hxu;
            dVar.field_extInfo = this.pot.hxt;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.inW.Zu("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || bi.oN(this.jQP.field_username)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.inW.bl("contact_info_header_bizinfo", true);
        } else {
            ag agVar = this.jQP;
            bizInfoHeaderPreference.pna = this.pnr;
            bizInfoHeaderPreference.kKo = dVar;
            bizInfoHeaderPreference.onDetach();
            as.Hm();
            com.tencent.mm.y.c.Ff().a(bizInfoHeaderPreference);
            com.tencent.mm.ac.n.JF().d(bizInfoHeaderPreference);
            y.Mt().a(bizInfoHeaderPreference);
            bizInfoHeaderPreference.jQP = agVar;
            Assert.assertTrue("initView: contact username is null", bi.oM(agVar.field_username).length() > 0);
            bizInfoHeaderPreference.initView();
        }
        this.inW.bl("biz_placed_to_the_top", true);
        this.inW.bl("contact_info_biz_enable", true);
        this.inW.bl("contact_info_biz_disable", true);
        this.inW.bl("contact_info_stick_biz", true);
        if (dVar != null) {
            if (dVar.Ll()) {
                this.inW.bl("contact_info_biz_add", true);
                this.inW.bl("contact_info_expose_btn", true);
                this.inW.bl("contact_is_mute", false);
                this.kYN = this.jQP.AP();
                if (dVar.Lm()) {
                    this.inW.bl("contact_info_biz_go_chatting", true);
                    this.inW.bl("contact_info_stick_biz", !com.tencent.mm.k.a.ga(this.jQP.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_stick_biz");
                    checkBoxPreference.tYU = this.jQP.AS();
                    checkBoxPreference.setTitle(R.l.ebW);
                    bke();
                } else {
                    this.inW.bl("contact_info_subscribe_bizinfo", true);
                    this.inW.bl("contact_info_biz_go_chatting", true);
                    if (dVar.Lc()) {
                        this.inW.bl("contact_info_biz_enable", true);
                        this.inW.bl("contact_info_biz_disable", false);
                        this.inW.Zu("contact_info_biz_disable").setTitle(R.l.ebY);
                        this.inW.bl("contact_is_mute", false);
                        this.inW.bl("biz_placed_to_the_top", false);
                        this.lfv = (CheckBoxPreference) this.inW.Zu("biz_placed_to_the_top");
                        this.lfv.setTitle(R.l.ecn);
                        bke();
                        if (dVar.Ln()) {
                            this.inW.bl("contact_info_locate", true);
                        }
                    } else {
                        this.inW.bl("contact_info_biz_enable", false);
                        this.inW.bl("contact_info_biz_disable", true);
                        this.inW.Zu("contact_info_biz_enable").setTitle(R.l.eca);
                        this.inW.bl("contact_is_mute", true);
                        this.inW.bl("biz_placed_to_the_top", true);
                        this.inW.bl("contact_info_locate", true);
                    }
                }
                hl(this.kYN);
            } else if (dVar.Lk()) {
                this.inW.bl("contact_info_locate", true);
                this.inW.bl("contact_info_subscribe_bizinfo", false);
                this.inW.bl("enterprise_contact_info_enter", false);
                this.inW.Zu("contact_info_biz_go_chatting").setTitle(R.l.ecb);
                this.inW.bl("contact_info_stick_biz", !com.tencent.mm.k.a.ga(this.jQP.field_type));
                checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_stick_biz");
                checkBoxPreference.tYU = this.jQP.AS();
                checkBoxPreference.setTitle(R.l.ece);
                bke();
                this.inW.bl("contact_is_mute", true);
                this.kYN = this.jQP.AP();
                hl(this.kYN);
                this.inW.Zu("contact_is_mute").setSummary(R.l.dVb);
            } else {
                f fVar = this.inW;
                str = "contact_info_stick_biz";
                z = s.gU(this.jQP.field_username) || !com.tencent.mm.k.a.ga(this.jQP.field_type);
                fVar.bl(str, z);
                ((CheckBoxPreference) this.inW.Zu("contact_info_stick_biz")).tYU = this.jQP.AS();
                this.inW.bl("contact_is_mute", true);
                this.kYN = false;
            }
            this.kKo = dVar;
            this.hpZ = dVar.Lt();
            this.hqa = dVar.bK(false);
            this.por = this.hqa.Lu();
            if (this.hqa.Lv()) {
                this.inW.Zu("near_field_service").setSummary(R.l.eXU);
            } else {
                this.inW.bl("near_field_service", true);
            }
            if (this.hqa.LA() != null) {
                this.pov = true;
                if (Ic(this.hqa.LA())) {
                    this.pou = true;
                    if (!com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", this.jQP.field_username);
                        bkb();
                        if (s.ho(this.jQP.field_username) || Ie(this.jQP.field_username)) {
                            bkb();
                        }
                    }
                }
                this.inW.bl("contact_info_time_expired", true);
                bkb();
            } else {
                this.inW.bl("contact_info_time_expired", true);
            }
            if (this.hqa.Lx() != null && this.hqa.Lx().length() > 0) {
                this.hqj = this.hqa.Lx();
            }
            bVar = this.hqa;
            if (bVar.hqe != null) {
                bVar.hqh = "1".equals(bVar.hqe.optString("IsShowMember"));
            }
            this.hqh = bVar.hqh;
            if (bi.oN(this.hqa.LL())) {
                this.inW.bl("contact_info_service_phone", true);
            } else {
                this.inW.bl("contact_info_service_phone", false);
                Zu = this.inW.Zu("contact_info_service_phone");
                if (Zu != null) {
                    Zu.setSummary(this.hqa.LL());
                    Zu.ldF = this.fnF.getResources().getColor(R.e.btd);
                }
            }
        } else {
            this.inW.bl("contact_info_time_expired", true);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (bi.oN(this.jQP.signature)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.inW.bl("contact_info_user_desc", true);
            if (!this.pou) {
                this.inW.bl("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (bi.oM(this.jQP.signature).trim().length() <= 0) {
                    this.inW.bl("contact_info_user_desc", true);
                } else {
                    keyValuePreference.crc();
                    keyValuePreference.yry = false;
                    keyValuePreference.xRi = this.fnF.getString(R.l.dVv);
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a(this.fnF, this.jQP.signature));
                    keyValuePreference.mE(false);
                    if (com.tencent.mm.y.ak.a.hhx != null) {
                        b = BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(this.jQP.field_verifyFlag), 2.0f);
                    } else {
                        b = null;
                    }
                    str2 = "MicroMsg.ContactWidgetBizInfo";
                    str3 = "verify bmp is null ? %B";
                    objArr = new Object[1];
                    if (b == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[0] = Boolean.valueOf(z2);
                    com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
                    if (b != null) {
                        bitmapDrawable = new BitmapDrawable(this.fnF.getResources(), b);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.yrG = bitmapDrawable;
                    keyValuePreference.yrE = 8;
                }
            }
        }
        if (this.hqa != null && this.hqa.LF() != null && !bi.oN(this.hqa.LF().hqV)) {
            b.d LF = this.hqa.LF();
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.crc();
                keyValuePreference.yry = false;
                if (bi.oN(LF.hqW)) {
                    switch (LF.hqU) {
                        case 0:
                            string = this.fnF.getResources().getString(R.l.dXs);
                            break;
                        case 1:
                            string = this.fnF.getResources().getString(R.l.dNq);
                            break;
                        case 2:
                            string = this.fnF.getResources().getString(R.l.dNr);
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", Integer.valueOf(LF.hqU));
                            string = this.fnF.getResources().getString(R.l.dVv);
                            break;
                    }
                    keyValuePreference.xRi = string;
                } else {
                    keyValuePreference.xRi = LF.hqW;
                }
                if (com.tencent.mm.y.ak.a.hhx != null) {
                    b2 = BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(this.jQP.field_verifyFlag), 2.0f);
                } else {
                    b2 = null;
                }
                if (b2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.fnF.getResources(), b2);
                } else {
                    bitmapDrawable = null;
                }
                str3 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (b2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                com.tencent.mm.sdk.platformtools.x.i(str3, str4, objArr2);
                keyValuePreference.yrG = bitmapDrawable;
                if (LF.hqV != null) {
                    str3 = LF.hqY;
                    CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a(this.fnF, LF.hqV.trim());
                    if (bi.oN(str3)) {
                        charSequence = a;
                    } else {
                        try {
                            charSequence = new SpannableString(str3 + " " + a);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str3.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                                keyValuePreference.setSummary(charSequence);
                                if (this.hqa != null) {
                                }
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.inW.bl("contact_info_trademark", true);
                                if (this.hqa != null) {
                                }
                                this.inW.bl("contact_info_privilege", true);
                                indexOf = this.inW.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.pou) {
                                }
                                this.inW.bl("contact_info_verifyuser_weibo", true);
                                if (this.hqa != null) {
                                }
                                this.inW.bl("contact_info_reputation", true);
                                this.inW.bl("contact_info_guarantee_info", true);
                                this.inW.bl("contact_info_scope_of_business", true);
                                if (this.por != null) {
                                }
                                this.inW.bl("contact_info_bindwxainfo", true);
                                string = this.fnF.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", string, Boolean.valueOf(this.poz));
                                if (!this.poz) {
                                    this.poy = string;
                                    if (this.hqa != null) {
                                        bVar = this.hqa;
                                        if (bVar.hqe != null) {
                                            bVar.hqC = bVar.hqe.optInt("FunctionFlag");
                                        }
                                        if ((bVar.hqC & d.hpY) > 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (bi.oN(string)) {
                                            kf = y.Mk().kf(this.jQP.field_username);
                                            if (kf == null) {
                                                this.inW.bl("contact_info_kf_worker", true);
                                                y.Mm().a(this);
                                                Mm = y.Mm();
                                                string = this.jQP.field_username;
                                                str = q.FY();
                                                if (bi.oN(string)) {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                                } else {
                                                    com.tencent.mm.kernel.g.Dp().gRu.a(new t(string, str), 0);
                                                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", string, Integer.valueOf(Mm.hrr.size()));
                                                }
                                                this.poz = true;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", kf.field_openId);
                                                this.inW.bl("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(kf.field_nickname);
                                                b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                                                if (b2 == null) {
                                                    c(kf);
                                                    Id(kf.field_openId);
                                                } else {
                                                    iconWidgetPreference.A(b2);
                                                }
                                            }
                                        } else {
                                            Mk = y.Mk();
                                            ke = Mk.ke(string);
                                            y.Mm().a(this);
                                            y.Mm().af(this.jQP.field_username, string);
                                            this.poz = true;
                                            if (ke == null) {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                                kf = Mk.kf(this.jQP.field_username);
                                            } else {
                                                kf = ke;
                                            }
                                            if (kf == null) {
                                                this.inW.bl("contact_info_kf_worker", true);
                                            } else {
                                                this.inW.bl("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(kf.field_nickname);
                                                b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                                                if (b2 == null) {
                                                    c(kf);
                                                    Id(kf.field_openId);
                                                } else {
                                                    iconWidgetPreference.A(b2);
                                                }
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", kf.field_openId, kf.field_nickname);
                                            }
                                        }
                                    }
                                    this.inW.bl("contact_info_kf_worker", true);
                                }
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.fnF.getIntent().getBooleanExtra("KIsHardDevice", false)));
                                if (this.fnF.getIntent() == null) {
                                }
                                if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                                    if (dVar != null) {
                                        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
                                        checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("contact_info_locate");
                                        if (!dVar.Lm()) {
                                            checkBoxPreference.setTitle(R.l.ebX);
                                            this.poq = y.Mp().ca(y.Mp().cb(dVar.field_username));
                                            if (this.poq != null) {
                                                if (this.poq.hr(4)) {
                                                    z2 = false;
                                                } else {
                                                    z2 = true;
                                                }
                                                checkBoxPreference.tYU = z2;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                            }
                                        } else if (dVar.Lk()) {
                                            checkBoxPreference.setTitle(R.l.ebU);
                                            checkBoxPreference.tYU = y.Ms().jE(dVar.field_username);
                                        } else {
                                            checkBoxPreference.tYU = dVar.Lc();
                                        }
                                        if (dVar.Lc()) {
                                            this.hqa = dVar.bK(false);
                                            if (this.hqa == null) {
                                            }
                                            this.inW.bl("contact_info_template_recv", true);
                                        } else {
                                            this.inW.bl("contact_info_template_recv", true);
                                        }
                                        if (dVar.bK(false).Lg()) {
                                            checkBoxPreference2.tYU = dVar.Ld();
                                        } else {
                                            this.inW.bl("contact_info_locate", true);
                                            checkBoxPreference2.tYU = dVar.Ld();
                                        }
                                    } else {
                                        this.inW.bl("contact_info_subscribe_bizinfo", true);
                                        this.inW.bl("contact_info_locate", true);
                                        this.inW.bl("contact_info_template_recv", true);
                                    }
                                    this.inW.bl("contact_info_biz_read_msg_online", true);
                                    this.inW.bl("contact_info_biz_add", true);
                                    AX = this.jQP.AX();
                                    if (AX != null) {
                                        this.fnF.setMMTitle(AX);
                                    }
                                    if (s.gU(this.jQP.field_username)) {
                                        this.inW.Zu("contact_info_biz_go_chatting").setTitle(R.l.dWz);
                                        this.fnF.setMMTitle(R.l.dXo);
                                    }
                                    if (!s.ho(this.jQP.field_username)) {
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", this.jQP.field_username);
                                bkb();
                                Zu = this.inW.Zu("contact_info_biz_add");
                                Zu.setTitle(R.l.dUJ);
                                if (vi(this.pnn)) {
                                    if (dVar == null) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    } else {
                                        ((CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo")).tYU = dVar.Lc();
                                        this.inW.bl("contact_info_subscribe_bizinfo", false);
                                    }
                                }
                                this.fnF.showOptionMenu(false);
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            IndexOutOfBoundsException indexOutOfBoundsException = e3;
                            charSequence = a;
                            e = indexOutOfBoundsException;
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                            keyValuePreference.setSummary(charSequence);
                            if (this.hqa != null) {
                            }
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.inW.bl("contact_info_trademark", true);
                            if (this.hqa != null) {
                            }
                            this.inW.bl("contact_info_privilege", true);
                            indexOf = this.inW.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.pou) {
                            }
                            this.inW.bl("contact_info_verifyuser_weibo", true);
                            if (this.hqa != null) {
                            }
                            this.inW.bl("contact_info_reputation", true);
                            this.inW.bl("contact_info_guarantee_info", true);
                            this.inW.bl("contact_info_scope_of_business", true);
                            if (this.por != null) {
                            }
                            this.inW.bl("contact_info_bindwxainfo", true);
                            string = this.fnF.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", string, Boolean.valueOf(this.poz));
                            if (this.poz) {
                                this.poy = string;
                                if (this.hqa != null) {
                                    bVar = this.hqa;
                                    if (bVar.hqe != null) {
                                        bVar.hqC = bVar.hqe.optInt("FunctionFlag");
                                    }
                                    if ((bVar.hqC & d.hpY) > 0) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (bi.oN(string)) {
                                        Mk = y.Mk();
                                        ke = Mk.ke(string);
                                        y.Mm().a(this);
                                        y.Mm().af(this.jQP.field_username, string);
                                        this.poz = true;
                                        if (ke == null) {
                                            kf = ke;
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                            kf = Mk.kf(this.jQP.field_username);
                                        }
                                        if (kf == null) {
                                            this.inW.bl("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kf.field_nickname);
                                            b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                                            if (b2 == null) {
                                                iconWidgetPreference.A(b2);
                                            } else {
                                                c(kf);
                                                Id(kf.field_openId);
                                            }
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", kf.field_openId, kf.field_nickname);
                                        } else {
                                            this.inW.bl("contact_info_kf_worker", true);
                                        }
                                    } else {
                                        kf = y.Mk().kf(this.jQP.field_username);
                                        if (kf == null) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", kf.field_openId);
                                            this.inW.bl("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kf.field_nickname);
                                            b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                                            if (b2 == null) {
                                                iconWidgetPreference.A(b2);
                                            } else {
                                                c(kf);
                                                Id(kf.field_openId);
                                            }
                                        } else {
                                            this.inW.bl("contact_info_kf_worker", true);
                                            y.Mm().a(this);
                                            Mm = y.Mm();
                                            string = this.jQP.field_username;
                                            str = q.FY();
                                            if (bi.oN(string)) {
                                                com.tencent.mm.kernel.g.Dp().gRu.a(new t(string, str), 0);
                                                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", string, Integer.valueOf(Mm.hrr.size()));
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                            }
                                            this.poz = true;
                                        }
                                    }
                                }
                                this.inW.bl("contact_info_kf_worker", true);
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.fnF.getIntent().getBooleanExtra("KIsHardDevice", false)));
                            if (this.fnF.getIntent() == null) {
                            }
                            if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", this.jQP.field_username);
                                bkb();
                                Zu = this.inW.Zu("contact_info_biz_add");
                                Zu.setTitle(R.l.dUJ);
                                if (vi(this.pnn)) {
                                    if (dVar == null) {
                                        ((CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo")).tYU = dVar.Lc();
                                        this.inW.bl("contact_info_subscribe_bizinfo", false);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    }
                                }
                                this.fnF.showOptionMenu(false);
                            }
                            if (dVar != null) {
                                this.inW.bl("contact_info_subscribe_bizinfo", true);
                                this.inW.bl("contact_info_locate", true);
                                this.inW.bl("contact_info_template_recv", true);
                            } else {
                                checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
                                checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("contact_info_locate");
                                if (!dVar.Lm()) {
                                    checkBoxPreference.setTitle(R.l.ebX);
                                    this.poq = y.Mp().ca(y.Mp().cb(dVar.field_username));
                                    if (this.poq != null) {
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                    } else {
                                        if (this.poq.hr(4)) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        checkBoxPreference.tYU = z2;
                                    }
                                } else if (dVar.Lk()) {
                                    checkBoxPreference.tYU = dVar.Lc();
                                } else {
                                    checkBoxPreference.setTitle(R.l.ebU);
                                    if (y.Ms().jE(dVar.field_username)) {
                                    }
                                    checkBoxPreference.tYU = y.Ms().jE(dVar.field_username);
                                }
                                if (dVar.Lc()) {
                                    this.inW.bl("contact_info_template_recv", true);
                                } else {
                                    this.hqa = dVar.bK(false);
                                    if (this.hqa == null) {
                                    }
                                    this.inW.bl("contact_info_template_recv", true);
                                }
                                if (dVar.bK(false).Lg()) {
                                    this.inW.bl("contact_info_locate", true);
                                    checkBoxPreference2.tYU = dVar.Ld();
                                } else {
                                    checkBoxPreference2.tYU = dVar.Ld();
                                }
                            }
                            this.inW.bl("contact_info_biz_read_msg_online", true);
                            this.inW.bl("contact_info_biz_add", true);
                            AX = this.jQP.AX();
                            if (AX != null) {
                                this.fnF.setMMTitle(AX);
                            }
                            if (s.gU(this.jQP.field_username)) {
                                this.inW.Zu("contact_info_biz_go_chatting").setTitle(R.l.dWz);
                                this.fnF.setMMTitle(R.l.dXo);
                            }
                            if (!s.ho(this.jQP.field_username)) {
                                return;
                            }
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.inW.bl("contact_info_verifyuser", true);
            }
        } else if (this.hqa == null || this.hqa.LG() == null || bi.oN(this.hqa.LG().hre)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.inW.bl("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.hqa.LG().hre);
            }
        }
        if (this.hqa != null || bi.oN(this.hqa.Lz())) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.inW.bl("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.crc();
                keyValuePreference.yry = false;
                if (com.tencent.mm.y.ak.a.hhx != null) {
                    b = com.tencent.mm.sdk.platformtools.d.Ds(R.k.dwt);
                } else {
                    b = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                str3 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (b == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
                if (b != null) {
                    bitmapDrawable = new BitmapDrawable(this.fnF.getResources(), b);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yrG = bitmapDrawable;
                keyValuePreference.setSummary(this.hqa.Lz());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", this.hqa.Lz(), this.hqa.Ly());
            }
        }
        if (this.hqa != null || this.hqa.LB() == null || this.hqa.LB().size() <= 0) {
            this.inW.bl("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_privilege");
            keyValuePreference.crc();
            keyValuePreference.mE(false);
            keyValuePreference.yrH.clear();
            for (b.f fVar2 : this.hqa.LB()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.fnF, R.i.dmC, null);
                ((ImageView) linearLayout.findViewById(R.h.cpm)).setImageDrawable(new a(this.fnF.getResources(), fVar2.iconUrl));
                CharSequence charSequence2 = fVar2.description;
                identifier = this.fnF.getResources().getIdentifier(fVar2.hrd, "string", this.fnF.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.fnF.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(R.h.summary)).setText(charSequence2);
                keyValuePreference.yrH.add(linearLayout);
            }
        }
        indexOf = this.inW.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.hpZ == null || this.hpZ.size() <= 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.hpZ.size() - 1;
            while (size >= 0) {
                if (this.hpZ.get(size) != null && ((!this.fnF.getString(R.l.dUL).equals(((com.tencent.mm.af.d.a) this.hpZ.get(size)).title) || this.hqh) && !(bi.oN(((com.tencent.mm.af.d.a) this.hpZ.get(size)).title) && bi.oN(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd)))) {
                    Preference preference = new Preference(this.fnF);
                    preference.setKey("contact_info_bizinfo_external#" + size);
                    charSequence = ((com.tencent.mm.af.d.a) this.hpZ.get(size)).title;
                    int identifier2 = this.fnF.getResources().getIdentifier(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd, "string", this.fnF.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.fnF.getString(identifier2);
                    }
                    if (this.kKo.Lj() && ("__mp_wording__brandinfo_history_massmsg".equals(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd) || r1.equals(this.fnF.getString(R.l.dCc)))) {
                        charSequence = this.fnF.getString(R.l.ebT);
                    }
                    preference.setTitle(charSequence);
                    if (!bi.oN(((com.tencent.mm.af.d.a) this.hpZ.get(size)).description)) {
                        preference.setSummary(((com.tencent.mm.af.d.a) this.hpZ.get(size)).description);
                    }
                    if (bi.oM(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.inW.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.inW.a(preference, identifier);
                            if (bi.oM(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.inW.a(new PreferenceSmallCategory(this.fnF), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.inW.a(preference, identifier);
                    if (bi.oM(((com.tencent.mm.af.d.a) this.hpZ.get(size)).hqd).equals("__mp_wording__brandinfo_biz_detail")) {
                        this.inW.a(new PreferenceSmallCategory(this.fnF), identifier);
                    }
                }
                size--;
            }
        }
        if (this.pou || !s.v(this.jQP) || this.jQP.fXo == null || this.jQP.fXo.equals("")) {
            this.inW.bl("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(bi.aD(this.jQP.field_weiboNickname, "") + this.fnF.getString(R.l.eNl, new Object[]{s.hx(this.jQP.fXo)}));
                keyValuePreference.ldF = com.tencent.mm.bu.a.c(this.fnF, R.e.btd);
                keyValuePreference.mE(false);
            }
        }
        if (this.hqa != null || this.hqa.LD() == null) {
            this.inW.bl("contact_info_reputation", true);
            this.inW.bl("contact_info_guarantee_info", true);
            this.inW.bl("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.inW.Zu("contact_info_reputation");
            if (this.hqa.LD().hqZ > 0) {
                bizInfoPayInfoIconPreference.vb(this.hqa.LD().hqZ);
            } else {
                this.inW.bl("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.inW.Zu("contact_info_guarantee_info");
            if (this.hqa.LD().hrb == null || this.hqa.LD().hrb.size() <= 0) {
                this.inW.bl("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.bq(this.hqa.LD().hrb);
            }
            keyValuePreference = (KeyValuePreference) this.inW.Zu("contact_info_scope_of_business");
            if (bi.oN(this.hqa.LD().hra)) {
                this.inW.bl("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary(this.hqa.LD().hra);
                keyValuePreference.yrE = 4;
                keyValuePreference.mE(false);
            }
        }
        if (this.por != null || this.por.size() <= 0) {
            this.inW.bl("contact_info_bindwxainfo", true);
        } else {
            this.inW.bl("contact_info_bindwxainfo", false);
            BizBindWxaInfoPreference bizBindWxaInfoPreference = (BizBindWxaInfoPreference) this.inW.Zu("contact_info_bindwxainfo");
            d dVar2 = this.kKo;
            Collection collection = this.por;
            bizBindWxaInfoPreference.pmO = true;
            bizBindWxaInfoPreference.ios = dVar2;
            if (bizBindWxaInfoPreference.kaZ == null) {
                bizBindWxaInfoPreference.kaZ = new LinkedList();
            } else {
                bizBindWxaInfoPreference.kaZ.clear();
            }
            if (!(collection == null || collection.isEmpty())) {
                bizBindWxaInfoPreference.kaZ.addAll(collection);
            }
            bizBindWxaInfoPreference.acU();
        }
        string = this.fnF.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", string, Boolean.valueOf(this.poz));
        if (this.poz) {
            this.poy = string;
            if (this.hqa != null) {
                bVar = this.hqa;
                if (bVar.hqe != null) {
                    bVar.hqC = bVar.hqe.optInt("FunctionFlag");
                }
                if ((bVar.hqC & d.hpY) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && this.jQP != null) {
                    if (bi.oN(string)) {
                        kf = y.Mk().kf(this.jQP.field_username);
                        if (kf == null) {
                            this.inW.bl("contact_info_kf_worker", true);
                            y.Mm().a(this);
                            Mm = y.Mm();
                            string = this.jQP.field_username;
                            str = q.FY();
                            if (bi.oN(string)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                            } else {
                                com.tencent.mm.kernel.g.Dp().gRu.a(new t(string, str), 0);
                                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", string, Integer.valueOf(Mm.hrr.size()));
                            }
                            this.poz = true;
                        } else {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", kf.field_openId);
                            this.inW.bl("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(kf.field_nickname);
                            b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                            if (b2 == null) {
                                c(kf);
                                Id(kf.field_openId);
                            } else {
                                iconWidgetPreference.A(b2);
                            }
                        }
                    } else {
                        Mk = y.Mk();
                        ke = Mk.ke(string);
                        if (ke == null || com.tencent.mm.af.i.a(ke)) {
                            y.Mm().a(this);
                            y.Mm().af(this.jQP.field_username, string);
                            this.poz = true;
                        }
                        if (ke == null) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                            kf = Mk.kf(this.jQP.field_username);
                        } else {
                            kf = ke;
                        }
                        if (kf == null) {
                            this.inW.bl("contact_info_kf_worker", true);
                        } else {
                            this.inW.bl("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.inW.Zu("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(kf.field_nickname);
                            b2 = com.tencent.mm.ac.b.a(kf.field_openId, false, -1);
                            if (b2 == null) {
                                c(kf);
                                Id(kf.field_openId);
                            } else {
                                iconWidgetPreference.A(b2);
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", kf.field_openId, kf.field_nickname);
                        }
                    }
                }
            }
            this.inW.bl("contact_info_kf_worker", true);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.fnF.getIntent().getBooleanExtra("KIsHardDevice", false)));
        if (this.fnF.getIntent() == null && this.fnF.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z = bkc();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.k.a.ga(this.jQP.field_type)), Boolean.valueOf(z));
            if (com.tencent.mm.k.a.ga(this.jQP.field_type) && z) {
                if (dVar != null) {
                    checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("contact_info_locate");
                    if (dVar.Lm()) {
                        this.poq = y.Mp().ca(y.Mp().cb(dVar.field_username));
                        if (this.poq != null) {
                            checkBoxPreference.tYU = !this.poq.hr(4);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.tYU = dVar.Lc();
                    }
                    if (dVar.Lc()) {
                        if (this.hqa == null && dVar != null) {
                            this.hqa = dVar.bK(false);
                        }
                        if (this.hqa != null && this.hqa.Lw() && com.tencent.mm.bl.d.Pu("brandservice")) {
                            this.inW.bl("contact_info_template_recv", false);
                        } else {
                            this.inW.bl("contact_info_template_recv", true);
                        }
                    } else {
                        this.inW.bl("contact_info_template_recv", true);
                    }
                    if (dVar.bK(false).Lg()) {
                        checkBoxPreference2.tYU = dVar.Ld();
                    } else {
                        this.inW.bl("contact_info_locate", true);
                        checkBoxPreference2.tYU = dVar.Ld();
                    }
                } else {
                    this.inW.bl("contact_info_subscribe_bizinfo", true);
                    this.inW.bl("contact_info_locate", true);
                    this.inW.bl("contact_info_template_recv", true);
                }
                this.inW.bl("contact_info_biz_read_msg_online", true);
                this.inW.bl("contact_info_biz_add", true);
                AX = this.jQP.AX();
                if (AX != null) {
                    this.fnF.setMMTitle(AX);
                }
                if (s.gU(this.jQP.field_username)) {
                    this.inW.Zu("contact_info_biz_go_chatting").setTitle(R.l.dWz);
                    this.fnF.setMMTitle(R.l.dXo);
                }
                if (!s.ho(this.jQP.field_username) && this.kKo != null && !this.kKo.Ll()) {
                    this.fnF.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            c.a(c.this);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", this.jQP.field_username);
            bkb();
            Preference Zu2 = this.inW.Zu("contact_info_biz_add");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", Boolean.valueOf(this.pov));
            if (Zu2 != null) {
                if (z) {
                    Zu2.setTitle(R.l.dUJ);
                } else {
                    Zu2.setTitle(R.l.dUG);
                }
            }
            if (vi(this.pnn)) {
                if (dVar == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo")).tYU = dVar.Lc();
                    this.inW.bl("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fnF.showOptionMenu(false);
        } else if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            if (dVar != null) {
                checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("contact_info_locate");
                if (!dVar.Lm()) {
                    checkBoxPreference.setTitle(R.l.ebX);
                    this.poq = y.Mp().ca(y.Mp().cb(dVar.field_username));
                    if (this.poq != null) {
                        if (this.poq.hr(4)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        checkBoxPreference.tYU = z2;
                    } else {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (dVar.Lk()) {
                    checkBoxPreference.setTitle(R.l.ebU);
                    if (y.Ms().jE(dVar.field_username)) {
                    }
                    checkBoxPreference.tYU = y.Ms().jE(dVar.field_username);
                } else {
                    checkBoxPreference.tYU = dVar.Lc();
                }
                if (dVar.Lc()) {
                    if (this.hqa == null && dVar != null) {
                        this.hqa = dVar.bK(false);
                    }
                    if (this.hqa == null && this.hqa.Lw() && com.tencent.mm.bl.d.Pu("brandservice")) {
                        this.inW.bl("contact_info_template_recv", false);
                    } else {
                        this.inW.bl("contact_info_template_recv", true);
                    }
                } else {
                    this.inW.bl("contact_info_template_recv", true);
                }
                if (dVar.bK(false).Lg()) {
                    checkBoxPreference2.tYU = dVar.Ld();
                } else {
                    this.inW.bl("contact_info_locate", true);
                    checkBoxPreference2.tYU = dVar.Ld();
                }
            } else {
                this.inW.bl("contact_info_subscribe_bizinfo", true);
                this.inW.bl("contact_info_locate", true);
                this.inW.bl("contact_info_template_recv", true);
            }
            this.inW.bl("contact_info_biz_read_msg_online", true);
            this.inW.bl("contact_info_biz_add", true);
            AX = this.jQP.AX();
            if (AX != null) {
                this.fnF.setMMTitle(AX);
            }
            if (s.gU(this.jQP.field_username)) {
                this.inW.Zu("contact_info_biz_go_chatting").setTitle(R.l.dWz);
                this.fnF.setMMTitle(R.l.dXo);
            }
            if (!s.ho(this.jQP.field_username) && this.kKo != null) {
                this.fnF.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        c.a(c.this);
                        return true;
                    }
                });
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", this.jQP.field_username);
            bkb();
            Zu = this.inW.Zu("contact_info_biz_add");
            if (Zu != null && this.pov) {
                Zu.setTitle(R.l.dUJ);
            }
            if (vi(this.pnn)) {
                if (dVar == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo")).tYU = dVar.Lc();
                    this.inW.bl("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fnF.showOptionMenu(false);
        }
    }

    private void bkb() {
        if (this.jQP == null || !com.tencent.mm.k.a.ga(this.jQP.field_type) || s.gU(this.jQP.field_username) || Ie(this.jQP.field_username)) {
            this.inW.bl("contact_is_mute", true);
            if (this.jQP == null || com.tencent.mm.k.a.ga(this.jQP.field_type) || !vi(this.pnn)) {
                this.inW.bl("contact_info_expose_btn", true);
            } else {
                this.inW.bl("contact_info_expose_btn", false);
            }
        } else {
            this.inW.bl("contact_is_mute", false);
        }
        this.inW.bl("contact_info_verifyuser_weibo", true);
        this.inW.bl("contact_info_subscribe_bizinfo", true);
        this.inW.bl("contact_info_template_recv", true);
        this.inW.bl("contact_info_locate", true);
        if (this.pou) {
            this.inW.bl("contact_info_biz_add", true);
        } else {
            this.inW.bl("contact_info_time_expired", true);
        }
        if (this.jQP == null || !((s.ho(this.jQP.field_username) || Ie(this.jQP.field_username)) && com.tencent.mm.k.a.ga(this.jQP.field_type))) {
            this.inW.bl("contact_info_biz_go_chatting", true);
        } else {
            this.inW.bl("contact_info_biz_go_chatting", false);
        }
        if (Ie(this.jQP.field_username)) {
            this.inW.bl("contact_info_user_desc", true);
        }
    }

    public final boolean asz() {
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.inW.Zu("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.fnF == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZN().l(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.h(this.fnF, this.fnF.getString(R.l.eip));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static boolean Ic(String str) {
        try {
            long j = bi.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void aC(int i, String str) {
        if (this.poB == null || !(this.pnn == 39 || this.pnn == 56 || this.pnn == 35 || this.pnn == 87 || this.pnn == 88 || this.pnn == 89 || this.pnn == 85)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.jQP == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.poB.getString("Contact_Ext_Args_Search_Id");
            String oM = bi.oM(this.poB.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.poB.getInt("Contact_Ext_Args_Index");
            switch (this.pnn) {
                case 35:
                    i2 = 1;
                    break;
                case 85:
                    i2 = 5;
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    i2 = 2;
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                    i2 = 3;
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String oM2 = bi.oM(this.poB.getString("Contact_Ext_Extra_Params"));
            String str2 = oM + "," + i + "," + bi.oM(this.jQP.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bi.oN(str)) {
                str2 = str2 + ",," + oM2;
            } else {
                str2 = str2 + "," + str + "," + oM2;
            }
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", str2);
            com.tencent.mm.plugin.report.service.g.pWK.k(10866, str2);
        }
    }

    private boolean bkc() {
        if (this.fnF.getIntent() == null) {
            return false;
        }
        String stringExtra = this.fnF.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.fnF.getIntent().getStringExtra("device_type");
        com.tencent.mm.sdk.b.b cyVar = new cy();
        cyVar.fsd.ffG = stringExtra;
        cyVar.fsd.fsb = stringExtra2;
        com.tencent.mm.sdk.b.a.xmy.m(cyVar);
        return cyVar.fse.fsf;
    }

    final void bkd() {
        if (this.jQP != null && !bi.oN(this.jQP.field_username)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.jQP.field_username}));
            intent.putExtra("showShare", false);
            com.tencent.mm.bl.d.b(this.fnF, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private void hl(boolean z) {
        if (this.jQP != null) {
            if (this.fnF != null) {
                if (!z || com.tencent.mm.af.f.eG(this.jQP.field_username)) {
                    this.fnF.setTitleMuteIconVisibility(8);
                } else {
                    this.fnF.setTitleMuteIconVisibility(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.tYU = z;
            }
        }
    }

    private void Id(final String str) {
        ah.h(new Runnable() {
            public final void run() {
                if (c.this.inW == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) c.this.inW.Zu("contact_info_kf_worker");
                if (iconWidgetPreference != null && c.this.inW != null) {
                    Bitmap a = com.tencent.mm.ac.b.a(str, false, -1);
                    if (a != null) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", str);
                        iconWidgetPreference.A(a);
                        c.this.inW.notifyDataSetChanged();
                    }
                }
            }
        }, 2000);
    }

    private static void c(com.tencent.mm.af.g gVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.ac.i JW = com.tencent.mm.ac.n.JW();
        if (JW.jp(gVar.field_openId) == null) {
            com.tencent.mm.ac.h hVar = new com.tencent.mm.ac.h();
            hVar.username = gVar.field_openId;
            hVar.hnh = gVar.field_headImgUrl;
            hVar.bC(false);
            hVar.fWZ = 3;
            JW.a(hVar);
        }
        com.tencent.mm.ac.n.JY().jc(gVar.field_openId);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(int i, int i2, String str, k kVar) {
        bij bij = null;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.poz = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (kVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            return;
        }
        as.CN().b(kVar.getType(), (e) this);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            if (kVar.getType() == 536) {
                as.CN().b(536, (e) this);
                bka();
                return;
            } else if (kVar.getType() == 1363) {
                bik bik;
                com.tencent.mm.plugin.profile.a.b bVar = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (bVar.gLB == null || bVar.gLB.hnR.hnY == null) {
                    bik = null;
                } else {
                    bik = (bik) bVar.gLB.hnR.hnY;
                }
                com.tencent.mm.plugin.profile.a.b bVar2 = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (!(bVar2.gLB == null || bVar2.gLB.hnQ.hnY == null)) {
                    bij = (bij) bVar2.gLB.hnQ.hnY;
                }
                if (bik == null || bik.vUn == null || bik.vUn.ret != 0 || bik.vUk == null || bi.oN(bik.vUk.vUi)) {
                    if (bik == null || bik.vUn == null) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", Integer.valueOf(bik.vUn.ret));
                    return;
                } else if (bik.vUk == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    return;
                } else {
                    j ca = y.Mp().ca(bik.vUk.vUi);
                    if (ca == null) {
                        ca = new j();
                        ca.field_userId = bik.vUk.vUi;
                    }
                    ca.field_userName = bik.vUk.kTk;
                    ca.field_brandUserName = bij.vUh;
                    ca.field_UserVersion = bik.vUk.ver;
                    ca.field_headImageUrl = bik.vUk.vUc;
                    ca.field_profileUrl = bik.vUk.vUq;
                    ca.field_bitFlag = bik.vUk.vUd;
                    ca.field_addMemberUrl = bik.vUk.vUg;
                    ca.field_needToUpdate = false;
                    if (!y.Mp().b(ca)) {
                        y.Mp().a(ca);
                        return;
                    }
                    return;
                }
            } else if (kVar.getType() == 1394) {
                bnz bjW = ((com.tencent.mm.plugin.profile.a.c) kVar).bjW();
                boa bjV = ((com.tencent.mm.plugin.profile.a.c) kVar).bjV();
                if (bjV != null && bjV.vUn != null && bjV.vUn.ret == 0) {
                    boolean z;
                    if (bjW.wXJ) {
                        z = false;
                    } else {
                        z = true;
                    }
                    d dVar;
                    if (z) {
                        ae aeVar;
                        dVar = this.kKo;
                        dVar.field_brandFlag &= -2;
                        a(dVar, true);
                        as.Hm();
                        if (com.tencent.mm.y.c.Fk().XF(dVar.field_username) == null) {
                            aeVar = new ae(dVar.field_username);
                            aeVar.dJ(bi.oM(this.kKo.Ls()));
                            as.Hm();
                            au Fd = com.tencent.mm.y.c.Fh().Fd(dVar.field_username);
                            if (Fd != null) {
                                as.Hm();
                                com.tencent.mm.y.c.Fk().d(aeVar);
                                as.Hm();
                                com.tencent.mm.y.c.Fk().ad(Fd);
                            } else {
                                aeVar.cjn();
                                as.Hm();
                                com.tencent.mm.y.c.Fk().d(aeVar);
                            }
                        }
                        as.Hm();
                        if (com.tencent.mm.y.c.Fk().XF(dVar.field_enterpriseFather) == null) {
                            aeVar = new ae(dVar.field_enterpriseFather);
                            aeVar.cjn();
                            as.Hm();
                            com.tencent.mm.y.c.Fk().d(aeVar);
                            return;
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Fj().WZ(dVar.field_enterpriseFather);
                        return;
                    }
                    dVar = this.kKo;
                    dVar.field_brandFlag |= 1;
                    a(dVar, true);
                    as.Hm();
                    com.tencent.mm.y.c.Fk().XE(dVar.field_username);
                    as.Hm();
                    if (com.tencent.mm.y.c.Fk().XP(dVar.field_enterpriseFather) <= 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Fk().XE(dVar.field_enterpriseFather);
                        return;
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Fj().WZ(dVar.field_enterpriseFather);
                    return;
                } else if (bjV == null || bjV.vUn == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(kVar.getType()));
                    return;
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(bjV.vUn.ret));
                    return;
                }
            } else if (kVar.getType() == 1343) {
                bka();
                return;
            } else if (kVar.getType() == 1228) {
                bka();
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
    }

    public final void c(LinkedList<cby> linkedList) {
        y.Mm().b((com.tencent.mm.af.h.a) this);
        if (this.inW == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
        } else if (this.jQP == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
        } else {
            if (!bi.oN(this.poy)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cby cby = (cby) it.next();
                    if (cby.xhQ != null && cby.xhQ.equals(this.poy)) {
                        this.inW.bl("contact_info_kf_worker", false);
                        this.inW.Zu("contact_info_kf_worker").setSummary(cby.wDh);
                        return;
                    }
                }
            }
            this.inW.bl("contact_info_kf_worker", false);
            this.inW.Zu("contact_info_kf_worker").setSummary(((cby) linkedList.get(0)).wDh);
        }
    }

    public final void a(int i, k kVar) {
        if (this.kKo != null && this.kKo.Lm() && kVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_subscribe_bizinfo");
            this.poq = y.Mp().ca(y.Mp().cb(this.kKo.field_username));
            if (this.poq != null) {
                checkBoxPreference.tYU = !this.poq.hr(4);
                this.inW.notifyDataSetChanged();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
    }

    final boolean Ie(String str) {
        return str.equals("weixinsrc") || this.jQP.field_username.equalsIgnoreCase("gh_6e99ff560306");
    }

    public final String Md() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void bke() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.hbz == null) {
            this.hbz = this.fnF.getSharedPreferences(this.fnF.getPackageName() + "_preferences", 0);
        }
        if (this.lfv != null) {
            if (this.jQP != null) {
                this.hbz.edit().putBoolean("biz_placed_to_the_top", this.jQP.AS()).commit();
            } else {
                this.hbz.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.inW.notifyDataSetChanged();
    }

    private static boolean vi(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }
}
