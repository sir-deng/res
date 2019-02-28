package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.a.o.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> qfl = new ArrayList();
    private static int qfn = 1;
    private static int qfo = 1;
    private f inW;
    private o qfk;
    private r qfm;

    static /* synthetic */ void a(VcardContactUI vcardContactUI, Intent intent) {
        int i;
        int i2 = 2;
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        String Rm = vcardContactUI.qfk.pZl.Rm();
        if (bi.oN(Rm)) {
            x.e("MicroMsg.scanner.VardContactUI", "no contact user name");
        } else {
            intent.putExtra("name", Rm);
        }
        List list = vcardContactUI.qfk.pZu;
        if (list == null || list.size() <= 0) {
            i2 = 1;
        } else {
            a(list, intent, 2, 1);
        }
        List list2 = vcardContactUI.qfk.pZv;
        if (list2 != null && list2.size() > 0) {
            int i3 = i2 + 1;
            a(list2, intent, 1, i2);
            i2 = i3;
        }
        list = vcardContactUI.qfk.pZw;
        if (list != null && list.size() > 0) {
            i = i2 + 1;
            a(list, intent, 3, i2);
            i2 = i;
        }
        list = vcardContactUI.qfk.pZy;
        if (list != null && list.size() > 0) {
            i = i2 + 1;
            a(list, intent, 7, i2);
            i2 = i;
        }
        List list3 = vcardContactUI.qfk.pZx;
        if (list3 != null && list3.size() > 0) {
            a(list3, intent, 0, i2);
        }
        if (!bi.oN(vcardContactUI.qfk.iLp)) {
            intent.putExtra("company", vcardContactUI.qfk.iLp);
        }
        if (!bi.oN(vcardContactUI.qfk.pZB)) {
            intent.putExtra("notes", vcardContactUI.qfk.pZB);
        }
        if (!bi.oN(vcardContactUI.qfk.fXd)) {
            intent.putExtra("email", vcardContactUI.qfk.fXd);
        }
        if (!bi.oN(vcardContactUI.qfk.title)) {
            intent.putExtra("job_title", vcardContactUI.qfk.title);
        }
        o oVar = vcardContactUI.qfk;
        a aVar = (oVar.pZr == null || oVar.pZr.Rm().length() <= 0) ? (oVar.pZs == null || oVar.pZs.Rm().length() <= 0) ? (oVar.pZt == null || oVar.pZt.Rm().length() <= 0) ? (oVar.pZq == null || oVar.pZq.Rm().length() <= 0) ? null : oVar.pZq : oVar.pZt : oVar.pZs : oVar.pZr;
        if (aVar != null && aVar.Rm().length() > 0) {
            intent.putExtra("postal", aVar.Rm());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XK() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.equals("add_vcard_contact")) {
            h.a((Context) this, "", new String[]{getString(R.l.eSG), getString(R.l.eSF)}, "", new c() {
                public final void jo(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            bp.HY().c(10238, Integer.valueOf(1));
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            return;
                        case 1:
                            bp.HY().c(10239, Integer.valueOf(1));
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        String str;
        if (preference.idX.equals("v_contact_info_photo_uri") || preference.idX.equals("v_contact_info_home_page") || preference.idX.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                e eVar = this.qfm;
                if (!eVar.pra.cgx()) {
                    x.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    x.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    eVar.url = charSequence;
                    as.Hm();
                    str = (String) com.tencent.mm.y.c.Db().get(46, null);
                    if (str == null || str.length() == 0) {
                        eVar.b(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        as.CN().a(233, eVar);
                        eVar.qfw = new l(charSequence, null, 4, (int) System.currentTimeMillis(), new byte[0]);
                        as.CN().a(eVar.qfw, 0);
                        eVar.pra.K(3000, 3000);
                    }
                }
                return true;
            }
        } else if (qfl.contains(preference.idX) && !preference.idX.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                h.a((Context) this, "", new String[]{getString(R.l.dSI)}, "", new c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                                VcardContactUI.this.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        } else if (preference.idX.equals("v_contact_info_email")) {
            str = preference.getSummary().toString();
            h.a((Context) this, "", new String[]{this.mController.xRr.getString(R.l.eKc), this.mController.xRr.getString(R.l.eKb)}, "", new c() {
                public final void jo(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent();
                            String[] strArr = new String[]{str + " " + str};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            d.b(VcardContactUI.this, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
                            VcardContactUI.this.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        return false;
    }

    protected final void initView() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        this.qfm = new r(this);
        this.inW = this.yrJ;
        this.qfk = o.pZC;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VcardContactUI.this.finish();
                return true;
            }
        });
        setMMTitle("");
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcR);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.inW.Zu("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            o oVar = this.qfk;
            if (oVar != null) {
                if (!bi.oN(oVar.pZl.Rm())) {
                    vcardContactUserHeaderPreference.qfv = oVar.pZl.Rm();
                }
                if (!bi.oN(oVar.bgo)) {
                    vcardContactUserHeaderPreference.bgo = oVar.bgo;
                }
                if (!bi.oN(oVar.pZz)) {
                    vcardContactUserHeaderPreference.pZz = oVar.pZz;
                }
                if (!bi.oN(oVar.title)) {
                    vcardContactUserHeaderPreference.title = oVar.title;
                }
            }
        }
        this.inW.Zv("c_contact_info_wx_id");
        if (bi.oN(this.qfk.iLg)) {
            this.inW.Zv("v_contact_info_photo_uri");
            this.inW.Zv("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.inW.Zu("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.qfk.iLg);
                vcardContactLinkPreference.mE(false);
                vcardContactLinkPreference.yry = false;
                qfn += 2;
                qfo += 2;
            }
        }
        a aVar = this.qfk.pZs;
        if (aVar != null && aVar.Rm().length() > 0) {
            eb(aVar.Rm(), this.mController.xRr.getString(R.l.eSJ));
        }
        aVar = this.qfk.pZt;
        if (aVar != null && aVar.Rm().length() > 0) {
            eb(aVar.Rm(), this.mController.xRr.getString(R.l.eSQ));
        }
        aVar = this.qfk.pZq;
        if (aVar != null && aVar.Rm().length() > 0) {
            eb(aVar.Rm(), this.mController.xRr.getString(R.l.eSH));
        }
        aVar = this.qfk.pZr;
        if (aVar != null && aVar.Rm().length() > 0) {
            eb(aVar.Rm(), this.mController.xRr.getString(R.l.eSH));
        }
        List list = this.qfk.pZw;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.mController.xRr.getString(R.l.eSR));
        }
        list = this.qfk.pZv;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.mController.xRr.getString(R.l.eSK));
        }
        list = this.qfk.pZx;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.mController.xRr.getString(R.l.eSP));
        }
        list = this.qfk.pZy;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.mController.xRr.getString(R.l.eSM));
        }
        list = this.qfk.pZu;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.mController.xRr.getString(R.l.eSI));
        }
        if (bi.oN(this.qfk.iLp)) {
            this.inW.Zv("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.qfk.iLp);
                keyValuePreference.mE(false);
                keyValuePreference.yry = true;
            }
        }
        if (bi.oN(this.qfk.pZA)) {
            this.inW.Zv("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.qfk.pZA);
                keyValuePreference.mE(false);
                keyValuePreference.yry = true;
            }
        }
        if (bi.oN(this.qfk.url)) {
            this.inW.Zv("v_contact_info_home_page");
            this.inW.Zv("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.inW.Zu("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.qfk.url);
                vcardContactLinkPreference.mE(false);
                vcardContactLinkPreference.yry = true;
            }
        }
        if (bi.oN(this.qfk.fXd)) {
            this.inW.Zv("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.inW.Zu("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.qfk.fXd);
                vcardContactLinkPreference.mE(false);
                vcardContactLinkPreference.yry = true;
            }
        }
        if (bi.oN(this.qfk.pZp)) {
            this.inW.Zv("v_contact_info_birthday");
            this.inW.Zv("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.qfk.pZp);
                keyValuePreference.mE(false);
                keyValuePreference.yry = true;
            }
        }
        if (bi.oN(this.qfk.pZB)) {
            this.inW.Zv("v_contact_info_remark");
            this.inW.Zv("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.inW.Zu("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.qfk.pZB);
                keyValuePreference.mE(false);
                keyValuePreference.yry = true;
            }
        }
        if (this.qfk.pZn == null || !this.qfk.pZn.pZF.contains("uri")) {
            this.inW.Zv("v_contact_info_logo");
            this.inW.Zv("v_category_logo");
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.inW.Zu("v_contact_info_logo");
        vcardContactLinkPreference.setSummary(this.qfk.pZn.pZG);
        vcardContactLinkPreference.yry = false;
        vcardContactLinkPreference.mE(false);
    }

    private void b(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                Preference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!qfl.contains(str + String.valueOf(str3))) {
                    qfl.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle((CharSequence) str2);
                vcardContactLinkPreference.setLayoutResource(R.i.dnz);
                vcardContactLinkPreference.setSummary((CharSequence) str3);
                vcardContactLinkPreference.mE(false);
                vcardContactLinkPreference.yry = true;
                vcardContactLinkPreference.crc();
                this.inW.a(vcardContactLinkPreference, qfn);
            }
        }
    }

    private void eb(String str, String str2) {
        Preference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle((CharSequence) str2);
        keyValuePreference.setLayoutResource(R.i.dnz);
        keyValuePreference.mE(false);
        keyValuePreference.setSummary((CharSequence) str);
        keyValuePreference.yry = false;
        keyValuePreference.crc();
        this.inW.a(keyValuePreference, qfo);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
    }
}
