package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.j.g;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import org.json.JSONObject;

public class ContactMoreInfoUI extends MMActivity implements k {
    private String gBJ;
    private ag handler = new ag(Looper.getMainLooper());
    private x lLc;
    q lfE;
    private String lgQ;
    boolean lhi = false;
    private String nFd;
    private ProfileNormalItemView pnL;
    private ProfileNormalItemView pnM;
    private ProfileNormalItemView pnN;
    private ProfileNormalItemView pnO;
    private ProfileNormalItemView pnP;
    private ProfileNormalItemView pnQ;
    private ProfileNormalItemView pnR;
    private String pnS;
    private String pnT;
    private String pnU;
    private long pnV;
    private String pnW;
    String pnX = null;

    protected final int getLayoutId() {
        return R.i.deS;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjY();
        initView();
    }

    protected final void initView() {
        ProfileNormalItemView profileNormalItemView;
        boolean z = false;
        super.initView();
        this.pnL = (ProfileNormalItemView) findViewById(R.h.ctc);
        this.pnM = (ProfileNormalItemView) findViewById(R.h.cnO);
        this.pnN = (ProfileNormalItemView) findViewById(R.h.cEt);
        this.pnQ = (ProfileNormalItemView) findViewById(R.h.cOE);
        this.pnQ.vk(R.l.dWI);
        this.pnQ.pkT.setSingleLine(false);
        this.pnR = (ProfileNormalItemView) findViewById(R.h.cke);
        this.pnR.vk(R.l.dXl);
        this.pnP = (ProfileNormalItemView) findViewById(R.h.cZx);
        this.pnO = (ProfileNormalItemView) findViewById(R.h.bWK);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactMoreInfoUI.this.finish();
                return true;
            }
        });
        bjY();
        as.Hm();
        this.lfE = c.Fo().hG(this.lgQ);
        String value = g.Af().getValue("LinkedinPluginClose");
        boolean z2 = bi.oN(value) || Integer.valueOf(value).intValue() == 0;
        boolean z3;
        if (!z2 || bi.oN(this.lLc.fXv)) {
            this.pnL.setVisibility(8);
            z3 = false;
        } else {
            this.pnL.setVisibility(0);
            if (bi.oN(this.pnS)) {
                this.pnS = this.lLc.fXw;
            }
            profileNormalItemView = this.pnL;
            profileNormalItemView.pqE = this.pnS;
            profileNormalItemView.pqF = new OnClickListener() {
                public final void onClick(View view) {
                    if (bi.oN(ContactMoreInfoUI.this.pnT)) {
                        ContactMoreInfoUI.this.pnT = ContactMoreInfoUI.this.lLc.fXx;
                    }
                    if (!bi.oN(ContactMoreInfoUI.this.pnT)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", ContactMoreInfoUI.this.pnT);
                        intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                        d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            };
            z3 = profileNormalItemView.vm(getResources().getColor(R.e.btz)).bks();
        }
        this.pnM.setVisibility(0);
        profileNormalItemView = this.pnM;
        profileNormalItemView.pqE = this.nFd;
        boolean bks = profileNormalItemView.bks();
        as.Hm();
        int e = bi.e((Integer) c.Db().get(9, null));
        this.pnV = getIntent().getLongExtra("Contact_Uin", 0);
        this.pnW = getIntent().getStringExtra("Contact_QQNick");
        boolean z4;
        if (this.pnV == 0 || e == 0) {
            this.pnN.setVisibility(8);
            z4 = false;
        } else {
            if (this.pnW == null || this.pnW.length() == 0) {
                ad bf = af.OO().bf(this.pnV);
                if (bf == null) {
                    bf = null;
                }
                if (bf != null) {
                    this.pnW = bf.getDisplayName();
                }
            }
            CharSequence charSequence = bi.oM(this.pnW) + " " + new o(this.pnV).longValue();
            this.pnN.setVisibility(0);
            ProfileNormalItemView profileNormalItemView2 = this.pnN;
            profileNormalItemView2.pqE = charSequence;
            profileNormalItemView2.pqF = new OnClickListener() {
                public final void onClick(View view) {
                }
            };
            z4 = profileNormalItemView2.bks();
        }
        profileNormalItemView = this.pnQ;
        profileNormalItemView.pqE = i.a((Context) this, this.lLc.signature);
        boolean bks2 = profileNormalItemView.bks();
        switch (this.lLc.getSource()) {
            case 1:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXd);
                    break;
                } else {
                    this.pnR.vl(R.l.dXe);
                    break;
                }
            case 3:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXf);
                    break;
                } else {
                    this.pnR.vl(R.l.dXg);
                    break;
                }
            case 4:
            case 12:
                this.pnR.vl(R.l.eir);
                break;
            case 8:
            case 14:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dWS);
                    break;
                } else {
                    this.pnR.vl(R.l.dWT);
                    break;
                }
            case 10:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXj);
                    break;
                } else {
                    this.pnR.vl(R.l.dXk);
                    break;
                }
            case 13:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXj);
                    break;
                } else {
                    this.pnR.vl(R.l.dXk);
                    break;
                }
            case 15:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXb);
                    break;
                } else {
                    this.pnR.vl(R.l.dXc);
                    break;
                }
            case 17:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dWP);
                    break;
                } else {
                    this.pnR.vl(R.l.dWR);
                    break;
                }
            case 18:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dWV);
                    break;
                } else {
                    this.pnR.vl(R.l.dWW);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dXh);
                    break;
                } else {
                    this.pnR.vl(R.l.dXi);
                    break;
                }
            case 25:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dWN);
                    break;
                } else {
                    this.pnR.vl(R.l.dWO);
                    break;
                }
            case 30:
                if (this.lLc.AZ() <= Constants.MAX_BUFFER_SIZE) {
                    this.pnR.vl(R.l.dWY);
                    break;
                } else {
                    this.pnR.vl(R.l.dWZ);
                    break;
                }
            case 34:
                this.pnR.vl(R.l.dWM);
                break;
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                this.pnR.vl(R.l.dXa);
                break;
            case 58:
            case 59:
            case 60:
                this.pnR.vl(R.l.enC);
                break;
            case org.xwalk.core.R.styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                this.pnR.vl(R.l.dWX);
                break;
            default:
                this.pnR.pqE = null;
                break;
        }
        boolean bks3 = this.pnR.bks();
        boolean G = G(this.lLc);
        if (!this.lLc.field_username.equals(com.tencent.mm.y.q.FY())) {
            com.tencent.mm.f.b.ag agVar = this.lLc;
            if (x.Xg(agVar.field_username) || agVar.field_username.equals(com.tencent.mm.y.q.FY())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.pnO.setVisibility(8);
            } else {
                if (agVar.fXa == 1) {
                    this.pnO.vk(R.l.dUV);
                } else if (agVar.fXa == 2) {
                    this.pnO.vk(R.l.dUU);
                } else {
                    this.pnO.vk(R.l.dUX);
                }
                this.pnO.bks();
                com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                gVar.fEe = agVar.field_username;
                gVar.mRK = this;
                gVar.handler = this.handler;
                gVar.mRC = 5;
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
                z = true;
            }
        }
        if (!bks2 && !bks3 && !G && !z3 && !bks && !z4 && !z) {
            finish();
        }
    }

    private boolean G(x xVar) {
        String str;
        CharSequence optString;
        ProfileNormalItemView profileNormalItemView;
        if (com.tencent.mm.y.q.FY().equals(xVar.field_username)) {
            as.Hm();
            str = (String) c.Db().get(a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
        } else {
            str = xVar.fXy;
        }
        if (!bi.oN(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.pnX = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (bi.oN(this.pnX)) {
                this.pnP.setVisibility(0);
                this.pnP.pqE = optString;
                this.pnP.vm(getResources().getColor(R.e.btz));
                profileNormalItemView = this.pnP;
                profileNormalItemView.pqF = new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", ContactMoreInfoUI.this.pnX);
                        intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                        d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                };
                profileNormalItemView.bks();
                return true;
            }
            this.pnP.setVisibility(8);
            return false;
        }
        optString = null;
        if (bi.oN(this.pnX)) {
            this.pnP.setVisibility(8);
            return false;
        }
        this.pnP.setVisibility(0);
        this.pnP.pqE = optString;
        this.pnP.vm(getResources().getColor(R.e.btz));
        profileNormalItemView = this.pnP;
        profileNormalItemView.pqF = /* anonymous class already generated */;
        profileNormalItemView.bks();
        return true;
    }

    private void bjY() {
        this.lhi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lgQ = getIntent().getStringExtra("Contact_ChatRoomId");
        this.gBJ = getIntent().getStringExtra("Contact_User");
        as.Hm();
        this.lLc = c.Ff().Xv(this.gBJ);
        this.pnS = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.pnT = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.nFd = getIntent().getStringExtra("verify_gmail");
        this.pnU = getIntent().getStringExtra("profileName");
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            final int intValue = ((Integer) ((j) hVar.mRN.get(0)).userData).intValue();
            this.pnO.pqE = getString(R.l.dUW, new Object[]{Integer.valueOf(intValue)});
            this.pnO.pqF = new OnClickListener() {
                public final void onClick(View view) {
                    e.qu(intValue);
                    if (intValue > 0) {
                        Intent intent = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
                        intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.this.lLc.field_username);
                        ContactMoreInfoUI.this.startActivity(intent);
                    }
                }
            };
        } else {
            this.pnO.pqE = getString(R.l.dUW, new Object[]{Integer.valueOf(0)});
        }
        this.pnO.bks();
    }
}
