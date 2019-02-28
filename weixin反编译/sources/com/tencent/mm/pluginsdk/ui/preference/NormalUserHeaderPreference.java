package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.be.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements a, g.a, b {
    MMActivity fnF;
    x jQP;
    private boolean lXm = false;
    private String mTU;
    private TextView nwk;
    private ClipboardManager oPD;
    private ImageView pmW;
    private TextView pmZ;
    private boolean poW;
    private boolean ppd = false;
    private boolean pqg = false;
    private ImageView qwK;
    int qxe;
    private boolean vAA = false;
    private boolean vAB = false;
    private String vAC;
    private ProfileMobilePhoneView vAD;
    private ProfileDescribeView vAE;
    private ProfileLabelView vAF;
    private TextView vAG;
    public OnClickListener vAH;
    public String vAI = null;
    private TextView vAf;
    private TextView vAg;
    private TextView vAh;
    private View vAi;
    private Button vAj;
    private Button vAk;
    private TextView vAl;
    private ImageView vAm;
    private CheckBox vAn;
    private ImageView vAo;
    private ImageView vAp;
    private LinearLayout vAq;
    private Button vAr;
    private FMessageListView vAs;
    private int vAt = 0;
    private boolean vAu = false;
    private boolean vAv = false;
    private boolean vAw = false;
    private boolean vAx = false;
    private boolean vAy = false;
    private boolean vAz = false;
    public String vrq;
    public String vrr;

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        init();
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnF = (MMActivity) context;
        init();
    }

    private void init() {
        this.lXm = false;
        this.oPD = (ClipboardManager) this.fnF.getSystemService("clipboard");
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        if (this.vAs != null) {
            this.vAs.detach();
        }
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        int i = 0;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.nwk = (TextView) view.findViewById(R.h.bXM);
        this.pmZ = (TextView) view.findViewById(R.h.bYd);
        this.vAl = (TextView) view.findViewById(R.h.bXn);
        this.vAf = (TextView) view.findViewById(R.h.bXs);
        this.vAg = (TextView) view.findViewById(R.h.bXN);
        this.vAj = (Button) view.findViewById(R.h.bXS);
        this.vAk = (Button) view.findViewById(R.h.bYa);
        this.vAD = (ProfileMobilePhoneView) view.findViewById(R.h.cwQ);
        ProfileMobilePhoneView profileMobilePhoneView = this.vAD;
        as.Hm();
        profileMobilePhoneView.vrA = ((Boolean) c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        this.vAE = (ProfileDescribeView) view.findViewById(R.h.caS);
        this.vAF = (ProfileLabelView) view.findViewById(R.h.csk);
        this.vAG = (TextView) view.findViewById(R.h.cLO);
        this.vAE.setOnClickListener(this.vAH);
        this.vAF.setOnClickListener(this.vAH);
        this.vAG.setOnClickListener(this.vAH);
        if (q.gt(this.jQP.field_username) || (!bi.oN(this.jQP.field_username) && s.hj(this.jQP.field_username))) {
            this.vAG.setVisibility(8);
            this.vAD.setVisibility(8);
            this.vAE.setVisibility(8);
            this.vAF.setVisibility(8);
        } else {
            ProfileMobilePhoneView profileMobilePhoneView2 = this.vAD;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", this.vrq, this.vrr);
            profileMobilePhoneView2.vrq = r3;
            profileMobilePhoneView2.vrr = r4;
            profileMobilePhoneView2.bks();
            if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                this.vAD.setVisibility(0);
            } else {
                this.vAD.setVisibility(8);
            }
            boolean M = this.vAE.M(this.jQP);
            boolean M2 = this.vAF.M(this.jQP);
            if (M || M2) {
                this.vAG.setVisibility(8);
            } else {
                if (this.vAA || this.vAy) {
                    this.vAG.setVisibility(8);
                } else {
                    this.vAG.setVisibility(0);
                }
                if (this.vAI != null && (this.vAI.equals("ContactWidgetBottleContact") || this.vAI.equals("ContactWidgetQContact"))) {
                    this.vAG.setVisibility(8);
                }
            }
        }
        this.vAh = (TextView) view.findViewById(R.h.bXA);
        this.vAr = (Button) view.findViewById(R.h.bXw);
        this.vAs = (FMessageListView) view.findViewById(R.h.bXx);
        a.a aVar = new a.a();
        aVar.talker = this.jQP.field_username;
        aVar.scene = this.qxe;
        aVar.mTU = this.mTU;
        aVar.vzN = this.jQP.fXA;
        aVar.type = 0;
        if (this.qxe == 18) {
            aVar.type = 1;
        } else if (bb.gV(this.qxe)) {
            aVar.type = 2;
        }
        this.vAs.vzH = aVar;
        a.vzH = aVar;
        this.vAi = view.findViewById(R.h.cOM);
        this.vAq = (LinearLayout) view.findViewById(R.h.col);
        this.pmW = (ImageView) view.findViewById(R.h.bXp);
        this.qwK = (ImageView) view.findViewById(R.h.bXX);
        this.vAm = (ImageView) view.findViewById(R.h.bYj);
        this.vAn = (CheckBox) view.findViewById(R.h.bYb);
        this.vAo = (ImageView) view.findViewById(R.h.bXZ);
        this.vAp = (ImageView) view.findViewById(R.h.bXY);
        this.lXm = true;
        initView();
        if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.vAs.setVisibility(8);
            if (this.vAs.getVisibility() == 8 && this.vAG.getVisibility() == 8 && this.vAF.getVisibility() == 8 && this.vAE.getVisibility() == 8 && this.vAh.getVisibility() == 8) {
                this.vAi.setVisibility(8);
            }
        } else if (this.mTU == null || this.mTU.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.qxe + ", verifyTicket = " + this.mTU);
            this.vAs.setVisibility(8);
            if (this.vAs.getVisibility() == 8 && this.vAG.getVisibility() == 8 && this.vAF.getVisibility() == 8 && this.vAE.getVisibility() == 8 && this.vAh.getVisibility() == 8) {
                this.vAi.setVisibility(8);
            }
        } else {
            b[] a;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.qxe);
            if (this.qxe == 18) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.fnF, l.TF().ne(this.jQP.field_username));
            } else if (bb.gV(this.qxe)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.fnF, l.TG().nj(this.jQP.field_username));
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.fnF, l.TD().mZ(this.jQP.field_username));
            }
            if (a == null || a.length == 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.vAs.setVisibility(8);
                if (this.vAs.getVisibility() == 8 && this.vAG.getVisibility() == 8 && this.vAF.getVisibility() == 8 && this.vAE.getVisibility() == 8 && this.vAh.getVisibility() == 8) {
                    this.vAi.setVisibility(8);
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.fqG + ", digest = " + bVar.hfQ + ", addScene = " + bVar.qxe);
                    }
                }
                this.vAs.setVisibility(x.Xg(this.jQP.field_username) ? 8 : 0);
                if (this.vAs.getVisibility() == 0 || this.vAG.getVisibility() == 0 || this.vAF.getVisibility() == 0 || this.vAE.getVisibility() == 0 || this.vAh.getVisibility() == 0) {
                    this.vAi.setVisibility(0);
                }
                int length = a.length;
                while (i < length) {
                    this.vAs.a(a[i]);
                    i++;
                }
            }
        }
        super.onBindView(view);
    }

    private boolean bjX() {
        return this.lXm && this.jQP != null;
    }

    private void bow() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.pmW, this.jQP.field_username);
        if (this.pmW != null) {
            int aa = com.tencent.mm.bu.a.aa(this.mContext, R.f.buq);
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.fnF, 88);
            if (aa <= fromDPToPix) {
                fromDPToPix = aa;
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.bu.a.ab(this.mContext, R.f.bvx), 0);
            this.pmW.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        int i = 0;
        if (!bjX()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
        } else if (this.ppd) {
            this.vAl.setVisibility(0);
            this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.AW()) + " ", this.nwk.getTextSize()));
            bow();
            this.vAr.setVisibility(8);
            this.pmZ.setVisibility(8);
            this.vAs.setVisibility(8);
            if (this.vAs.getVisibility() == 8 && this.vAG.getVisibility() == 8 && this.vAF.getVisibility() == 8 && this.vAE.getVisibility() == 8 && this.vAh.getVisibility() == 8) {
                this.vAi.setVisibility(8);
            }
            this.vAj.setVisibility(8);
            this.vAk.setVisibility(8);
            this.vAn.setVisibility(8);
            if (this.vAF != null) {
                this.vAF.setVisibility(8);
            }
            if (this.vAD != null) {
                this.vAD.setVisibility(8);
            }
            if (this.vAE != null) {
                this.vAE.setVisibility(8);
            }
            if (this.vAG != null) {
                this.vAG.setVisibility(8);
            }
            if (this.vAg != null) {
                this.vAg.setVisibility(8);
            }
        } else {
            boolean gB = x.gB(this.jQP.field_username);
            if (gB) {
                this.nwk.setText("");
                if (x.Xk(q.FY()).equals(this.jQP.field_username)) {
                    this.vAr.setVisibility(0);
                    this.vAr.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            d.y(NormalUserHeaderPreference.this.fnF, "bottle", ".ui.BottlePersonalInfoUI");
                        }
                    });
                }
            } else {
                this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.AW()) + " ", this.nwk.getTextSize()));
            }
            this.qwK.setVisibility(0);
            this.vAw = true;
            if (this.jQP.fXa == 1) {
                this.qwK.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.dyY));
                this.qwK.setContentDescription(this.mContext.getString(R.l.eBt));
            } else if (this.jQP.fXa == 2) {
                this.qwK.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.dyX));
                this.qwK.setContentDescription(this.mContext.getString(R.l.eBs));
            } else if (this.jQP.fXa == 0) {
                this.qwK.setVisibility(8);
                this.vAw = false;
            }
            if (this.jQP.field_verifyFlag != 0) {
                Bitmap b;
                this.vAm.setVisibility(0);
                if (ak.a.hhx != null) {
                    b = BackwardSupportUtil.b.b(ak.a.hhx.gP(this.jQP.field_verifyFlag), 2.0f);
                } else {
                    b = null;
                }
                this.vAm.setImageBitmap(b);
                this.vAt = b == null ? 0 : b.getWidth();
            }
            bow();
            this.pmW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String str = NormalUserHeaderPreference.this.jQP.field_username;
                    f fVar = new f(NormalUserHeaderPreference.this.fnF, str);
                    if (x.gB(str)) {
                        x.Xk(str);
                    }
                    fVar.caN();
                }
            });
            if (x.Xf(this.jQP.field_username)) {
                this.pmZ.setText(this.mContext.getString(R.l.dFk) + this.jQP.AY());
            } else if (x.Xd(this.jQP.field_username)) {
                this.pmZ.setText(this.mContext.getString(R.l.dFt) + this.jQP.AY());
            } else if (this.poW) {
                if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                    ccX();
                } else if (this.jQP.fXm == null || this.jQP.fXm.equals("")) {
                    this.pmZ.setText(R.l.dEU);
                } else {
                    this.pmZ.setText(this.jQP.fXm);
                }
            } else if (gB) {
                this.pmZ.setText((bi.oM(r.gy(this.jQP.getProvince())) + " " + bi.oM(this.jQP.getCity())).trim());
            } else {
                if (!x.Xe(this.jQP.field_username) && this.fnF.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (bi.oN(this.jQP.vU()) && (x.Xi(this.jQP.field_username) || s.gG(this.jQP.field_username))) {
                        this.pmZ.setVisibility(8);
                    } else if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                        ccX();
                    }
                }
                this.pmZ.setVisibility(8);
            }
            if (s.hj(this.jQP.field_username)) {
                this.vAh.setVisibility(0);
            } else {
                this.vAh.setVisibility(8);
            }
            ccZ();
            ccY();
            cda();
            if (bi.oN(this.vAC)) {
                this.vAf.setVisibility(8);
            } else {
                if (!q.gt(this.jQP.field_username) && bi.oM(this.jQP.field_conRemark).length() > 0) {
                    this.pmZ.setVisibility(8);
                }
                this.vAf.setVisibility(0);
                this.vAf.setText(i.b(this.fnF, this.fnF.getString(R.l.dUQ) + this.vAC, this.vAf.getTextSize()));
            }
            this.vAj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    NormalUserHeaderPreference.this.vAy = false;
                    Preference preference = NormalUserHeaderPreference.this;
                    as.Hm();
                    ag Xv = c.Ff().Xv(preference.jQP.field_username);
                    if (!(Xv == null || ((int) Xv.gKO) == 0 || !Xv.field_username.equals(preference.jQP.field_username))) {
                        preference.jQP = Xv;
                    }
                    Intent intent;
                    if (com.tencent.mm.k.a.ga(preference.jQP.field_type)) {
                        intent = new Intent();
                        intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                        intent.putExtra("Contact_Scene", preference.qxe);
                        intent.putExtra("Contact_User", preference.jQP.field_username);
                        intent.putExtra("Contact_RoomNickname", preference.fnF.getIntent().getStringExtra("Contact_RoomNickname"));
                        ((Activity) preference.mContext).startActivity(intent);
                        return;
                    }
                    intent = new Intent();
                    intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
                    intent.putExtra("Contact_Scene", preference.qxe);
                    intent.putExtra("Contact_mode_name_type", 0);
                    intent.putExtra("Contact_ModStrangerRemark", true);
                    intent.putExtra("Contact_User", preference.jQP.field_username);
                    intent.putExtra("Contact_Nick", preference.jQP.field_nickname);
                    intent.putExtra("Contact_RemarkName", preference.jQP.field_conRemark);
                    ((Activity) preference.mContext).startActivity(intent);
                }
            });
            this.vAk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserHeaderPreference.this.jQP.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 3);
                    d.b(NormalUserHeaderPreference.this.fnF, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            if (this.vAw) {
                i = com.tencent.mm.bu.a.fromDPToPix(this.fnF, 17) + 0;
            }
            int i2 = this.vAt + i;
            if (this.vAu) {
                i2 += com.tencent.mm.bu.a.fromDPToPix(this.fnF, 27);
            }
            if (this.vAv) {
                i2 += com.tencent.mm.bu.a.fromDPToPix(this.fnF, 27);
            }
            if (this.vAx) {
                i2 += com.tencent.mm.bu.a.fromDPToPix(this.fnF, 30);
            }
            this.nwk.setMaxWidth(this.fnF.getResources().getDisplayMetrics().widthPixels - ((com.tencent.mm.bu.a.ez(this.mContext) ? i2 + com.tencent.mm.bu.a.fromDPToPix(this.fnF, 88) : i2 + com.tencent.mm.bu.a.fromDPToPix(this.fnF, 64)) + com.tencent.mm.bu.a.fromDPToPix(this.fnF, 60)));
            this.pmZ.setLongClickable(true);
            this.pmZ.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (!(NormalUserHeaderPreference.this.pmZ.getText() == null || NormalUserHeaderPreference.this.oPD == null)) {
                        String charSequence = NormalUserHeaderPreference.this.pmZ.getText().toString();
                        int indexOf = charSequence.indexOf(58);
                        if (indexOf >= 0 && indexOf < charSequence.length()) {
                            charSequence = charSequence.substring(indexOf + 1).trim();
                        }
                        CharSequence spannableString = new SpannableString(NormalUserHeaderPreference.this.pmZ.getText());
                        spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.this.fnF.getResources().getColor(R.e.bsY)), indexOf + 1, NormalUserHeaderPreference.this.pmZ.getText().length(), 33);
                        NormalUserHeaderPreference.this.pmZ.setText(spannableString);
                        com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(NormalUserHeaderPreference.this.fnF, NormalUserHeaderPreference.this.pmZ);
                        iVar.zDq = new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                contextMenu.add(NormalUserHeaderPreference.this.fnF.getString(R.l.dED));
                            }
                        };
                        iVar.rQG = new p.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                if (i == 0) {
                                    NormalUserHeaderPreference.this.oPD.setText(charSequence);
                                    h.bt(NormalUserHeaderPreference.this.fnF, NormalUserHeaderPreference.this.fnF.getString(R.l.dEE));
                                }
                            }
                        };
                        iVar.zwh = new OnDismissListener() {
                            public final void onDismiss() {
                                NormalUserHeaderPreference.this.ccX();
                            }
                        };
                        iVar.bV(0, 0);
                    }
                    return true;
                }
            });
        }
    }

    public final void ccX() {
        x.ciM();
        this.pmZ.setVisibility(0);
        if (!bi.oN(this.jQP.vU())) {
            this.pmZ.setText(this.mContext.getString(R.l.dFp) + this.jQP.vU());
        } else if (x.Xi(this.jQP.field_username) || s.gG(this.jQP.field_username)) {
            this.pmZ.setVisibility(8);
        } else {
            this.pmZ.setText(this.mContext.getString(R.l.dFp) + bi.oM(this.jQP.AY()));
        }
    }

    public final void bd(String str, boolean z) {
        if (str != null && str.equals(this.jQP.field_username)) {
            this.vAy = z;
        }
    }

    public final void be(String str, boolean z) {
        if (str != null && str.equals(this.jQP.field_username)) {
            this.vAz = z;
        }
    }

    public final void a(x xVar, int i, String str) {
        boolean z;
        boolean z2 = true;
        onDetach();
        as.Hm();
        c.Ff().a(this);
        as.Hm();
        c.Fg().a(this);
        n.JF().d(this);
        this.jQP = xVar;
        this.qxe = i;
        this.mTU = str;
        this.poW = this.fnF.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.vAB = this.fnF.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.vAy = this.fnF.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.vAz = this.fnF.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.vAA = this.fnF.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.pqg = this.fnF.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.vAC = this.fnF.getIntent().getStringExtra("Contact_RoomNickname");
        if (xVar.field_deleteFlag == 1) {
            z = true;
        } else {
            z = false;
        }
        this.ppd = z;
        String str2 = "initView: contact username is null";
        if (bi.oM(xVar.field_username).length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        initView();
    }

    public final void onDetach() {
        if (this.vAs != null) {
            this.vAs.detach();
        }
        if (this.vAB) {
            l.TE().mW(this.jQP.field_username);
        }
        this.fnF.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.vAy);
        this.fnF.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.vAz);
        as.Hm();
        c.Ff().b(this);
        n.JF().e(this);
        as.Hm();
        c.Fg().b(this);
    }

    private void ccY() {
        int i = 0;
        if (this.vAo != null && s.gz(this.jQP.field_username)) {
            this.vAv = this.jQP.AR();
            this.vAo.setVisibility(this.vAv ? 0 : 8);
        }
        if (this.vAp != null && s.gz(this.jQP.field_username)) {
            boolean ac;
            String str = this.jQP.field_username;
            if (com.tencent.mm.plugin.sns.b.n.qWE != null) {
                ac = com.tencent.mm.plugin.sns.b.n.qWE.ac(str, 5);
            } else {
                ac = false;
            }
            this.vAu = ac;
            ImageView imageView = this.vAp;
            if (!this.vAu) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private void ccZ() {
        if (q.gt(this.jQP.field_username) || bi.oM(this.jQP.field_conRemark).length() <= 0) {
            this.vAg.setVisibility(8);
            this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.AW()) + " ", this.nwk.getTextSize()));
            if (this.vAA) {
                this.vAj.setVisibility(0);
                this.vAG.setVisibility(8);
            } else if (this.vAy) {
                this.vAj.setVisibility(0);
                this.vAG.setVisibility(8);
            } else {
                if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                    this.vAj.setVisibility(8);
                }
                boolean M = this.vAE.M(this.jQP);
                boolean M2 = this.vAF.M(this.jQP);
                if (M || M2) {
                    this.vAG.setVisibility(8);
                }
            }
        } else {
            this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.field_conRemark) + " ", this.nwk.getTextSize()));
            this.vAg.setVisibility(0);
            this.vAg.setText(i.b(this.fnF, this.mContext.getString(R.l.dVX) + this.jQP.AW(), this.vAg.getTextSize()));
            this.vAj.setVisibility(8);
        }
        if (x.Xg(this.jQP.field_username)) {
            this.vAG.setText(R.l.dXB);
            int i = R.h.cta;
            if (this.vAq != null) {
                View findViewById = this.vAq.findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
        if (this.pqg && !com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            this.vAk.setVisibility(0);
        } else if (this.vAz) {
            this.vAk.setVisibility(0);
            if (com.tencent.mm.bu.a.ez(this.fnF)) {
                this.vAk.setTextSize(0, (float) this.fnF.getResources().getDimensionPixelSize(R.f.bvt));
                this.vAj.setTextSize(0, (float) this.fnF.getResources().getDimensionPixelSize(R.f.bvt));
            }
        } else {
            this.vAk.setVisibility(8);
        }
        if (x.gB(this.jQP.field_username)) {
            this.nwk.setText("");
        }
        if (this.qxe == 76 && this.jQP.field_username != null && this.jQP.field_username.endsWith("@stranger")) {
            this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.field_nickname) + " ", this.nwk.getTextSize()));
        }
        if (this.vAk.getVisibility() == 0 && this.vAg.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.vAg.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bvT);
            this.vAg.setLayoutParams(layoutParams);
        }
    }

    private void cda() {
        this.vAn.setClickable(false);
        if ((s.gz(this.jQP.field_username) || x.Xg(this.jQP.field_username)) && com.tencent.mm.k.a.ga(this.jQP.field_type) && !q.gt(this.jQP.field_username)) {
            this.vAn.setVisibility(0);
            if (this.jQP.AO()) {
                this.vAn.setChecked(true);
                this.vAx = true;
                return;
            }
            this.vAn.setChecked(false);
            this.vAn.setVisibility(8);
            this.vAx = false;
            return;
        }
        this.vAx = false;
        this.vAn.setVisibility(8);
    }

    public final void jk(String str) {
        if (!bjX()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
        } else if (bi.oM(str).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + str);
        } else if (str.equals(this.jQP.field_username)) {
            initView();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        String str = (String) obj;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.jQP);
        if (!bjX()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
        } else if (bi.oM(str).length() > 0 && this.jQP != null && this.jQP.field_username.equals(str)) {
            as.Hm();
            this.jQP = c.Ff().Xv(str);
            ah.y(new Runnable() {
                public final void run() {
                    int i = 0;
                    NormalUserHeaderPreference.this.ccZ();
                    NormalUserHeaderPreference.this.cda();
                    NormalUserHeaderPreference.this.ccY();
                    if (NormalUserHeaderPreference.this.vAs != null) {
                        boolean z;
                        FMessageListView i2 = NormalUserHeaderPreference.this.vAs;
                        if (com.tencent.mm.k.a.ga(NormalUserHeaderPreference.this.jQP.field_type)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int childCount = i2.getChildCount();
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
                        if (childCount <= 2) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + childCount);
                            return;
                        }
                        if (i2.vzR != null) {
                            i2.vzR.setVisibility(z ? 0 : 8);
                        }
                        if (i2.vzS != null) {
                            a aVar = i2.vzS;
                            if (!z) {
                                i = 8;
                            }
                            aVar.setVisibility(i);
                        }
                    }
                }
            });
        }
    }

    public final void a(final bf bfVar) {
        ah.y(new Runnable() {
            public final void run() {
                if (NormalUserHeaderPreference.this.jQP != null && bfVar != null && NormalUserHeaderPreference.this.jQP.field_username.equals(bfVar.field_encryptUsername)) {
                    NormalUserHeaderPreference.this.jQP.da(bfVar.field_conRemark);
                    if (NormalUserHeaderPreference.this.bjX()) {
                        NormalUserHeaderPreference.this.ccZ();
                    } else {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.this.lXm + "contact = " + NormalUserHeaderPreference.this.jQP.field_username);
                    }
                }
            }
        });
    }
}
