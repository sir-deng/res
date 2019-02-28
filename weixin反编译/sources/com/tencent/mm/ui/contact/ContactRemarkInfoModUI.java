package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements e {
    private String bgp;
    private String fXt;
    private String hMh;
    private x jQP;
    private ProgressDialog laU;
    private String nVw;
    private int pnn;
    private MMTagPanel pqQ;
    private List<String> pqR;
    private com.tencent.mm.sdk.e.m.b pqS = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, m mVar, Object obj) {
            com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            ContactRemarkInfoModUI.this.bkt();
        }
    };
    private String username;
    private String vAC;
    private MMEditText zaA;
    private TextView zaB;
    private TextView zaC;
    private TextView zaD;
    private TextView zaE;
    private ImageView zaF;
    private ImageView zaG;
    private TextView zaH;
    private View zaI;
    private View zaJ;
    private String zaK;
    private boolean zaL = false;
    private boolean zaM = false;
    private boolean zaN = false;
    private boolean zaO = false;
    private boolean zaP = false;
    private a zaQ = new a();
    private TextView zaR;
    private ScrollView zaS;
    private ProfileEditPhoneNumberView zaT;
    private String zaU;
    private String zaV;
    private String zaW;
    boolean zaX = true;
    boolean zaY = false;
    private boolean zaZ = false;
    private MMClearEditText zay;
    private TextView zaz;

    private class c extends ClickableSpan {
        public String iLo;

        public c(String str) {
            this.iLo = str;
        }

        public final void onClick(View view) {
            ContactRemarkInfoModUI.this.zaN = true;
            ContactRemarkInfoModUI.this.A(true, -1);
            ContactRemarkInfoModUI.this.zay.setText(i.b(ContactRemarkInfoModUI.this, t.oM(this.iLo), ContactRemarkInfoModUI.this.zay.getTextSize()));
            ContactRemarkInfoModUI.this.zay.setSelection(ContactRemarkInfoModUI.this.zay.getText().length());
            ContactRemarkInfoModUI.this.zaI.setVisibility(8);
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(R.e.brA));
            textPaint.setUnderlineText(false);
        }
    }

    private class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void onClick(View view) {
            ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
        }
    }

    private class b implements TextWatcher {
        private int qmT;
        private String zbc;

        private b() {
            this.qmT = 800;
            this.zbc = "";
        }

        /* synthetic */ b(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            this.qmT = h.be(800, editable.toString());
            if (this.qmT < 0) {
                this.qmT = 0;
            }
            if (ContactRemarkInfoModUI.this.zaE != null) {
                ContactRemarkInfoModUI.this.zaE.setText(this.qmT);
            }
            ContactRemarkInfoModUI.this.ayv();
        }
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        as.Hm();
        if (!com.tencent.mm.y.c.isSDCardAvailable()) {
            u.fJ(contactRemarkInfoModUI);
        }
        if (z) {
            com.tencent.mm.ui.base.h.a((Context) contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.l.eJH), contactRemarkInfoModUI.getString(R.l.dEH)}, "", new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                            Intent intent = new Intent();
                            intent.putExtra("max_select_count", 1);
                            intent.putExtra("query_source_type", 0);
                            intent.putExtra("send_btn_string", " ");
                            intent.addFlags(67108864);
                            d.b(ContactRemarkInfoModUI.this, "gallery", ".ui.GalleryEntryUI", intent, 200);
                            return;
                        case 1:
                            com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                            ContactRemarkInfoModUI.this.cwI();
                            return;
                        default:
                            return;
                    }
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        d.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.nVw);
        if (contactRemarkInfoModUI.pqR != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.pqR);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        d.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.zay).Hg(100).a(new com.tencent.mm.ui.tools.a.c.a() {
            public final void vE(String str) {
            }

            public final void anp() {
            }

            public final void aeD() {
                com.tencent.mm.ui.base.h.h(ContactRemarkInfoModUI.this, R.l.eMj, R.l.eMh);
                ContactRemarkInfoModUI.this.zaX = false;
            }
        });
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.zaA).Hg(800).a(new com.tencent.mm.ui.tools.a.c.a() {
            public final void vE(String str) {
            }

            public final void anp() {
            }

            public final void aeD() {
                com.tencent.mm.ui.base.h.h(ContactRemarkInfoModUI.this, R.l.eMc, R.l.eMh);
                ContactRemarkInfoModUI.this.zaX = false;
            }
        });
        if (contactRemarkInfoModUI.zaX) {
            String obj;
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.cwG()) {
                obj = contactRemarkInfoModUI.zaA.getText().toString();
                contactRemarkInfoModUI.fXt = obj;
                com.tencent.mm.bp.a asd = new asd();
                asd.wGI = contactRemarkInfoModUI.username;
                asd.nkL = obj;
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(54, asd));
            }
            String obj2 = contactRemarkInfoModUI.zay.getText().toString();
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.pnn);
            g.pWK.h(10448, Integer.valueOf(contactRemarkInfoModUI.pnn));
            switch (contactRemarkInfoModUI.jQP.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.modelfriend.b kU = af.OJ().kU(contactRemarkInfoModUI.jQP.field_username);
                    if (!(kU == null || t.oN(kU.Nz()))) {
                        if (t.oN(obj2)) {
                            kU.NH();
                        } else {
                            kU.hxa &= -2;
                        }
                        af.OJ().a(kU.Nx(), kU);
                        break;
                    }
            }
            as.Hm();
            bf FF = com.tencent.mm.y.c.Fg().FF(contactRemarkInfoModUI.jQP.field_username);
            if ((FF == null || t.oN(FF.field_encryptUsername)) && !t.oN(contactRemarkInfoModUI.jQP.field_encryptUsername)) {
                as.Hm();
                FF = com.tencent.mm.y.c.Fg().FF(contactRemarkInfoModUI.jQP.field_encryptUsername);
            }
            if (!(FF == null || t.oN(FF.field_encryptUsername))) {
                as.Hm();
                com.tencent.mm.y.c.Fg().FG(FF.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.ni(false)) {
                contactRemarkInfoModUI.bgp = obj2;
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.jQP.field_username, obj2);
                s.b(contactRemarkInfoModUI.jQP, obj2);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.ni(false)));
            }
            contactRemarkInfoModUI.cwF();
            obj = contactRemarkInfoModUI.bgp;
            obj2 = contactRemarkInfoModUI.fXt;
            String str = contactRemarkInfoModUI.hMh;
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, obj);
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(contactRemarkInfoModUI.username);
            if (Xv == null || ((int) Xv.gKO) <= 0 || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                contactRemarkInfoModUI.jQP.da(obj);
                contactRemarkInfoModUI.jQP.dw(obj2);
                contactRemarkInfoModUI.jQP.dx(str);
                contactRemarkInfoModUI.jQP.AT();
                as.Hm();
                boolean R = com.tencent.mm.y.c.Ff().R(contactRemarkInfoModUI.jQP);
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(R));
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                objArr[1] = Integer.valueOf(obj2 == null ? 0 : obj2.length());
                objArr[2] = obj2 == null ? "" : bi.Wz(obj2);
                com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
                com.tencent.mm.sdk.b.a.xmy.m(new se());
            }
            if (!contactRemarkInfoModUI.cwH()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.zaP) {
                as.CN().a(new com.tencent.mm.ba.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.l.dGZ);
                contactRemarkInfoModUI.laU = com.tencent.mm.ui.base.h.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dUO), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            } else {
                as.CN().a(new com.tencent.mm.ba.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.zaK), 0);
                contactRemarkInfoModUI.getString(R.l.dGZ);
                contactRemarkInfoModUI.laU = com.tencent.mm.ui.base.h.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dUP), false, null);
            }
        }
    }

    private void ayv() {
        boolean z;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.zaT;
        ArrayList cba = profileEditPhoneNumberView.cba();
        if (cba == null || cba.isEmpty()) {
            if (profileEditPhoneNumberView.vrs != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.vrs == null) {
            z = true;
        } else if (cba.size() != profileEditPhoneNumberView.vrs.length) {
            z = true;
        } else {
            Iterator it = cba.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.vrs[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.zaZ = z;
        if (cwG() || cwH() || ni(false) || this.zaZ) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        as.CN().a(575, (e) this);
        as.CN().a(576, (e) this);
        this.pnn = getIntent().getIntExtra("Contact_Scene", 9);
        this.vAC = getIntent().getStringExtra("Contact_RoomNickname");
        this.zaO = getIntent().getBooleanExtra("view_mode", false);
        this.zaW = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.zaU = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.zaV = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.oN(this.username)) {
            finish();
            return;
        }
        int i2;
        as.Hm();
        this.jQP = com.tencent.mm.y.c.Ff().Xv(this.username);
        this.bgp = this.jQP.field_conRemark;
        this.fXt = this.jQP.fXt;
        this.hMh = this.jQP.fXu;
        this.nVw = this.jQP.field_contactLabelIds;
        this.pqR = com.tencent.mm.plugin.label.a.a.aVD().DW(this.nVw);
        initView();
        ayv();
        if (this.jQP == null || !x.Xg(this.jQP.field_username)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0 && this.zay != null) {
            View view = (ViewGroup) this.zay.getParent();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != view) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
    }

    public void onResume() {
        super.onResume();
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.pqS);
        bkt();
    }

    protected void onPause() {
        as.Hm();
        com.tencent.mm.y.c.Ff().b(this.pqS);
        super.onPause();
    }

    public void onDestroy() {
        as.CN().b(575, (e) this);
        as.CN().b(576, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dfc;
    }

    private void A(boolean z, int i) {
        if (this.zaN) {
            this.zaB.setVisibility(8);
            if (z && t.oN(this.fXt)) {
                this.zaC.setVisibility(0);
                this.zaJ.setVisibility(8);
            } else if (i == R.h.bXP) {
                this.zaC.setVisibility(8);
                this.zaJ.setVisibility(0);
            }
            this.zay.setVisibility(0);
            return;
        }
        this.zaB.setVisibility(0);
        this.zaC.setVisibility(0);
        this.zay.setVisibility(8);
        this.zaJ.setVisibility(8);
    }

    protected final void initView() {
        boolean z;
        CharSequence jVar;
        this.zaz = (TextView) findViewById(R.h.bXJ);
        this.zaB = (TextView) findViewById(R.h.bXR);
        this.zaC = (TextView) findViewById(R.h.bXP);
        this.zaD = (TextView) findViewById(R.h.bXQ);
        this.zay = (MMClearEditText) findViewById(R.h.bXI);
        this.zaA = (MMEditText) findViewById(R.h.bXH);
        this.zaF = (ImageView) findViewById(R.h.cHI);
        this.zaG = (ImageView) findViewById(R.h.cHJ);
        this.zaE = (TextView) findViewById(R.h.cZN);
        this.zaJ = findViewById(R.h.bXG);
        this.zaT = (ProfileEditPhoneNumberView) findViewById(R.h.cwY);
        this.zaT.lLc = this.jQP;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.zaT;
        String str = this.zaU;
        String str2 = this.zaV;
        profileEditPhoneNumberView.vrq = str;
        profileEditPhoneNumberView.vrr = str2;
        profileEditPhoneNumberView.bks();
        this.zaT.vrv = new com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a() {
            public final void asP() {
                ContactRemarkInfoModUI.this.ayv();
            }

            public final void cbc() {
                s.r(ContactRemarkInfoModUI.this.jQP);
                q.Qj().ig(7);
            }
        };
        this.pqQ = (MMTagPanel) findViewById(R.h.bXF);
        this.pqQ.niO = false;
        this.zaS = (ScrollView) findViewById(R.h.cJo);
        this.zaR = (TextView) findViewById(R.h.bXD);
        this.zaR.setText(R.l.evH);
        this.pqQ.setOnClickListener(this.zaQ);
        this.zaR.setOnClickListener(this.zaQ);
        setMMTitle(R.l.dVR);
        if (t.oN(this.bgp)) {
            this.zay.setText(i.b(this, t.oM(this.jQP.AW()), this.zay.getTextSize()));
            this.zaB.setText(i.b(this, t.oM(this.jQP.AW()), this.zay.getTextSize()));
        } else {
            this.zay.setText(i.b(this, t.oM(this.bgp), this.zay.getTextSize()));
            this.zaB.setText(i.b(this, t.oM(this.bgp), this.zaB.getTextSize()));
        }
        this.zay.setSelection(this.zay.getText().length());
        this.zaA.setText(i.b(this, t.oM(this.fXt), this.zaC.getTextSize()));
        this.zaA.setSelection(this.zaA.getText().length());
        if (!t.oN(this.fXt)) {
            this.zaC.setText(i.b(this, t.oM(this.fXt), this.zaC.getTextSize()));
            this.zaC.setTextColor(getResources().getColor(R.e.btv));
        }
        this.zaB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ContactRemarkInfoModUI.this.zaN = true;
                ContactRemarkInfoModUI.this.A(false, view.getId());
                ContactRemarkInfoModUI.this.zay.performClick();
                ContactRemarkInfoModUI.this.zay.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
            }
        });
        this.zaC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ContactRemarkInfoModUI.this.zaN = true;
                ContactRemarkInfoModUI.this.A(false, view.getId());
                ContactRemarkInfoModUI.this.zaA.performClick();
                ContactRemarkInfoModUI.this.zaA.requestFocus();
                ContactRemarkInfoModUI.this.showVKB();
            }
        });
        this.zay.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                ContactRemarkInfoModUI.this.ayv();
            }
        });
        this.zaE.setText(h.be(800, this.zaA.getEditableText().toString()));
        this.zaA.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    ContactRemarkInfoModUI.this.zaJ.setBackgroundResource(R.g.bDg);
                } else {
                    ContactRemarkInfoModUI.this.zaJ.setBackgroundResource(R.g.bDh);
                }
            }
        });
        this.zaA.addTextChangedListener(new b());
        if (t.oN(this.hMh)) {
            this.zaD.setVisibility(0);
            this.zaF.setVisibility(8);
        } else {
            this.zaD.setVisibility(8);
            this.zaF.setVisibility(0);
            com.tencent.mm.ba.c.QS();
            if (com.tencent.mm.ba.c.lS(this.username)) {
                cwE();
            } else {
                com.tencent.mm.ba.c.QS().a(this.username, this.hMh, new com.tencent.mm.ba.c.a() {
                    public final void bS(final boolean z) {
                        ContactRemarkInfoModUI.this.zaF.post(new Runnable() {
                            public final void run() {
                                if (z) {
                                    ContactRemarkInfoModUI.this.cwE();
                                    return;
                                }
                                com.tencent.mm.ui.base.h.bu(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.l.dFa));
                                ContactRemarkInfoModUI.this.zaG.setVisibility(0);
                                ContactRemarkInfoModUI.this.zaD.setVisibility(8);
                                ContactRemarkInfoModUI.this.zaF.setVisibility(8);
                            }
                        });
                    }
                });
            }
        }
        this.zaF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ContactRemarkInfoModUI.this.zaL) {
                    String o;
                    ContactRemarkInfoModUI.this.cwD();
                    Intent intent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", ContactRemarkInfoModUI.this.username);
                    if (t.oN(ContactRemarkInfoModUI.this.hMh) || ContactRemarkInfoModUI.this.zaM) {
                        o = ContactRemarkInfoModUI.this.zaK;
                    } else {
                        com.tencent.mm.ba.c.QS();
                        o = com.tencent.mm.ba.c.lR(ContactRemarkInfoModUI.this.username);
                    }
                    intent.putExtra("remark_image_path", o);
                    intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.this.zaM);
                    ContactRemarkInfoModUI.this.startActivityForResult(intent, 400);
                }
            }
        });
        this.zaD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (t.oN(ContactRemarkInfoModUI.this.hMh) || ContactRemarkInfoModUI.this.zaP) {
                    ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
                    ContactRemarkInfoModUI.this.cwD();
                }
            }
        });
        com.tencent.mm.modelfriend.b kU = af.OJ().kU(this.jQP.field_username);
        if (kU == null || t.oN(kU.Nz()) || kU.Nz().equals(this.zay.getText().toString())) {
            z = false;
        } else {
            this.zaH = (TextView) findViewById(R.h.cxe);
            this.zaI = findViewById(R.h.cwZ);
            this.zaI.setVisibility(0);
            this.zaH.setText(t.oM(getString(R.l.dWF, new Object[]{kU.Nz()})));
            jVar = new j(getString(R.l.eYg));
            jVar.setSpan(new c(kU.Nz()), 0, jVar.length(), 17);
            this.zaH.append(" ");
            this.zaH.append(jVar);
            this.zaH.setMovementMethod(LinkMovementMethod.getInstance());
            z = true;
        }
        if (!(z || this.pnn != 14 || t.oN(this.vAC) || this.vAC.equals(this.zay.getText().toString()))) {
            this.zaH = (TextView) findViewById(R.h.cxe);
            this.zaI = findViewById(R.h.cwZ);
            this.zaI.setVisibility(0);
            this.zaH.setText(i.b(this, t.oM(getString(R.l.dWE, new Object[]{this.vAC})), this.zaH.getTextSize()));
            jVar = new j(getString(R.l.eYg));
            jVar.setSpan(new c(this.vAC), 0, jVar.length(), 17);
            this.zaH.append(" ");
            this.zaH.append(jVar);
            this.zaH.setMovementMethod(LinkMovementMethod.getInstance());
        }
        a(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
                ContactRemarkInfoModUI.this.aWY();
                return false;
            }
        }, com.tencent.mm.ui.p.b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactRemarkInfoModUI.this.goBack();
                return true;
            }
        });
        if (t.oN(this.bgp)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.zaG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
                ContactRemarkInfoModUI.this.cwD();
            }
        });
        if (!this.zaO) {
            this.zaN = true;
            A(true, -1);
        }
        cwD();
    }

    private void cwD() {
        this.zaz.setFocusableInTouchMode(true);
        this.zaz.requestFocus();
        this.zay.clearFocus();
        this.zaA.clearFocus();
        this.zaT.clearFocus();
        aWY();
    }

    private void cwE() {
        Bitmap lU = com.tencent.mm.ba.c.QS().lU(this.username);
        if (lU != null) {
            this.zaD.setVisibility(8);
            this.zaG.setVisibility(8);
            this.zaF.setVisibility(0);
            this.zaF.setImageBitmap(lU);
        }
        this.zaL = true;
    }

    private void aah(String str) {
        if (!t.oN(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.length() > 204800) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.dUN), null, true);
                return;
            }
            Bitmap b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.zaK, com.tencent.mm.bu.a.getDensity(this));
            if (b != null) {
                this.zaD.setVisibility(8);
                this.zaG.setVisibility(8);
                this.zaF.setVisibility(0);
                this.zaF.setImageBitmap(b);
                this.zaL = true;
            }
        }
    }

    private void cwF() {
        if (this.zaZ) {
            String str;
            com.tencent.mm.bp.a asp = new asp();
            asp.wGI = this.username;
            ayc ayc = new ayc();
            ArrayList cba = this.zaT.cba();
            ayc.kyA = cba == null ? 0 : cba.size();
            ayc.wLQ = new LinkedList();
            if (cba != null) {
                Iterator it = cba.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    ayb ayb = new ayb();
                    ayb.wLP = str;
                    ayc.wLQ.add(ayb);
                }
            }
            asp.wGE = ayc;
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, asp));
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(this.username);
            if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                String str2;
                str = "";
                if (cba != null) {
                    Iterator it2 = cba.iterator();
                    while (true) {
                        str2 = str;
                        if (!it2.hasNext()) {
                            break;
                        }
                        str = (str2 + ((String) it2.next())) + ",";
                    }
                } else {
                    str2 = str;
                }
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, str2);
                this.jQP.dC(str2);
                as.Hm();
                com.tencent.mm.y.c.Ff().R(this.jQP);
            }
        }
    }

    private boolean ni(boolean z) {
        String obj = this.zay.getText().toString();
        if (z) {
            boolean z2;
            if ((this.bgp == null || !this.bgp.equals(obj)) && !(t.oN(this.bgp) && t.oN(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.jQP.field_nickname))) {
                return false;
            }
            return true;
        } else if ((this.bgp == null || !this.bgp.equals(obj)) && (!t.oN(this.bgp) || !t.oN(obj))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cwG() {
        String obj = this.zaA.getText().toString();
        return (this.fXt == null || !this.fXt.equals(obj)) && !(t.oN(this.fXt) && t.oN(obj));
    }

    private boolean cwH() {
        return !t.oN(this.zaK) || this.zaP;
    }

    private void goBack() {
        boolean cwH = cwH();
        boolean ni = ni(true);
        boolean cwG = cwG();
        if (cwH || ni || cwG) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dWq), null, getString(R.l.dWs), getString(R.l.dWr), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactRemarkInfoModUI.this.finish();
                }
            });
            return;
        }
        aWY();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            return;
        }
        Context applicationContext;
        String b;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                as.Hm();
                b = k.b(applicationContext, intent, com.tencent.mm.y.c.Fp());
                if (b != null) {
                    this.zaK = aai(b);
                    aah(this.zaK);
                    this.zaM = true;
                    this.zaP = false;
                    ayv();
                    return;
                }
                return;
            case 200:
                applicationContext = getApplicationContext();
                as.Hm();
                b = com.tencent.mm.ui.tools.a.c(applicationContext, intent, com.tencent.mm.y.c.Fp());
                if (b != null) {
                    this.zaK = aai(b);
                    aah(this.zaK);
                    this.zaM = true;
                    this.zaP = false;
                    ayv();
                    return;
                }
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    cwI();
                    return;
                }
                return;
            case 600:
                if (ni(true) || cwG() || cwH() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    return;
                } else {
                    enableOptionMenu(false);
                    return;
                }
            default:
                return;
        }
    }

    private void cwI() {
        this.zaP = true;
        this.zaG.setVisibility(8);
        this.zaD.setVisibility(0);
        this.zaF.setVisibility(8);
        this.zaF.setImageBitmap(null);
        ayv();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.laU != null) {
            this.laU.dismiss();
            this.laU = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 575) {
                if (this.zaK != null) {
                    File file = new File(this.zaK);
                    if (file.exists()) {
                        com.tencent.mm.ba.c.QS();
                        file.renameTo(new File(com.tencent.mm.ba.c.lR(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.ba.b) kVar).hMh;
                if (!t.oN(str2)) {
                    this.hMh = str2;
                }
            } else if (kVar.getType() == 576) {
                this.zaK = null;
                this.hMh = null;
                this.zaL = false;
                as.Hm();
                this.jQP = com.tencent.mm.y.c.Ff().Xv(this.username);
                this.jQP.dx("");
                as.Hm();
                com.tencent.mm.y.c.Ff().a(this.username, this.jQP);
            }
            finish();
            return;
        }
        com.tencent.mm.ui.base.h.b(this, getString(R.l.dEZ), null, true);
    }

    private String aai(String str) {
        if (!com.tencent.mm.a.e.bO(str)) {
            return null;
        }
        int Vo = ExifHelper.Vo(str);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.ba.c.QS();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.ba.c.lR(this.username)).append(".tmp").toString();
        if (!com.tencent.mm.sdk.platformtools.d.a(str, 960, 960, CompressFormat.JPEG, 70, stringBuilder2)) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            return null;
        } else if (Vo == 0 || com.tencent.mm.sdk.platformtools.d.a(stringBuilder2, Vo, CompressFormat.JPEG, 70, stringBuilder2)) {
            return stringBuilder2;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            return null;
        }
    }

    private void bkt() {
        as.Hm();
        this.jQP = com.tencent.mm.y.c.Ff().Xv(this.username);
        this.nVw = this.jQP.field_contactLabelIds;
        this.pqR = com.tencent.mm.plugin.label.a.a.aVD().DW(this.nVw);
        if (t.oN(this.nVw)) {
            this.pqQ.setVisibility(8);
            this.zaR.setVisibility(0);
            return;
        }
        this.pqQ.setVisibility(0);
        this.zaR.setVisibility(8);
        this.pqQ.a(this.pqR, this.pqR);
    }
}
