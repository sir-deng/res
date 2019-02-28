package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.ap.p;
import com.tencent.mm.bb.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gt;
import com.tencent.mm.f.a.hs;
import com.tencent.mm.f.a.in;
import com.tencent.mm.f.a.iq;
import com.tencent.mm.f.a.iv;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.f.a.md;
import com.tencent.mm.f.a.ng;
import com.tencent.mm.f.a.ni;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.a.pd;
import com.tencent.mm.f.a.pe;
import com.tencent.mm.f.a.ph;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.a.rw;
import com.tencent.mm.f.a.tq;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.webview.fts.l;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.account.FacebookFriendUI;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.friend.FriendSnsPreference;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.an;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a implements a, b, an, ao {
    private long lrE;
    private ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (h.this.xNy != null) {
                        h.this.lX(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private CheckBox oTV;
    private i oTX = null;
    private c<tq> qjh = new c<tq>() {
        {
            this.xmG = tq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            h.this.getContentView().post(new Runnable() {
                public final void run() {
                    if (h.this.isAdded()) {
                        h.this.cmZ();
                    }
                }
            });
            return false;
        }
    };
    private int qpN;
    c rcw = new c<qy>() {
        {
            this.xmG = qy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(((qy) bVar).fJC.fvo));
            if (((qy) bVar).fJC.fvo == 9) {
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(68377, "");
                        if (h.this.xNy != null) {
                            h.this.xNy.notifyDataSetChanged();
                        }
                    }
                });
            }
            return true;
        }
    };
    private int status;
    private com.tencent.mm.pluginsdk.d.a vzO = new com.tencent.mm.pluginsdk.d.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            x.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", bVar);
            if (bVar instanceof iq) {
                h.this.cnf();
            }
        }
    };
    private boolean xNA = false;
    private String xNB = "";
    private int xNC = 0;
    private String xND = null;
    private String xNE = null;
    private String xNF = null;
    private String xNG = null;
    private boolean xNH = false;
    private boolean xNI = false;
    private boolean xNJ = false;
    private boolean xNK = true;
    private int xNL;
    private View xNM;
    private TextView xNN;
    private c<oq> xNO = new c<oq>() {
        {
            this.xmG = oq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            h.this.cmZ();
            return false;
        }
    };
    c xNP = new c<in>() {
        {
            this.xmG = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (z.vjl != null) {
                g.pWK.h(11178, bi.oM(r0.bEH()), r0.bEI().bEt(), Integer.valueOf(h.cna()));
            }
            h.this.lX(true);
            h.this.xNy.notifyDataSetChanged();
            return true;
        }
    };
    c xNQ = new c<cl>() {
        {
            this.xmG = cl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            h.this.mHandler.sendEmptyMessage(1);
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.d.a xNR = new com.tencent.mm.pluginsdk.d.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof gs) {
                h.f(h.this);
                h.this.xNy.notifyDataSetChanged();
            }
        }
    };
    private com.tencent.mm.pluginsdk.d.a xNS = new com.tencent.mm.pluginsdk.d.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof pe) {
                h.this.cne();
                h.this.xNy.notifyDataSetChanged();
            }
        }
    };
    private c xNT = new c<pd>() {
        {
            this.xmG = pd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((pd) bVar) instanceof pd) {
                h.this.cne();
                h.this.xNy.notifyDataSetChanged();
            }
            return false;
        }
    };
    p.a xNU = new p.a() {
        public final void h(final String str, final Bitmap bitmap) {
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.FindMoreFriendsUI", "download url " + str + " , result " + (bitmap == null));
                    IconPreference iconPreference = (IconPreference) h.this.xNy.Zu("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(h.this.xND)) {
                            iconPreference.drawable = new BitmapDrawable(h.this.getContext().getResources(), bitmap);
                            h.this.xND = null;
                        } else if (str.equals(h.this.xNG)) {
                            iconPreference.V(bitmap);
                            h.this.xNG = null;
                        }
                        h.this.xNy.notifyDataSetChanged();
                    }
                    if (str.equals(h.this.xNE)) {
                        ((IconPreference) h.this.xNy.Zu("find_friends_by_look")).drawable = new BitmapDrawable(h.this.getContext().getResources(), bitmap);
                        h.this.xNE = null;
                        h.this.xNy.notifyDataSetChanged();
                    }
                    if (str.equals(h.this.xNF)) {
                        ((IconPreference) h.this.xNy.Zu("find_friends_by_search")).drawable = new BitmapDrawable(h.this.getContext().getResources(), bitmap);
                        h.this.xNF = null;
                        h.this.xNy.notifyDataSetChanged();
                    }
                }
            });
        }
    };
    private com.tencent.mm.ui.base.preference.h xNy;
    private View xNz;

    static /* synthetic */ void f(h hVar) {
        hVar.cnc();
        hVar.xNy.notifyDataSetChanged();
    }

    public final int XK() {
        return R.o.fcb;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    private void cmZ() {
        Object obj = null;
        Object obj2 = 1;
        if (this.ysb) {
            try {
                JSONObject Oy = com.tencent.mm.plugin.aj.a.h.Oy("discoverRecommendEntry");
                if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.a.class)).Rh("labs_browse")) {
                    Object obj3;
                    if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.a.class)).Rf("labs_browse")) {
                        obj3 = ((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.a.class)).Rg("labs_browse") ? 1 : null;
                    } else {
                        obj3 = null;
                        obj2 = null;
                    }
                    obj = obj3;
                } else if (Oy.optInt("entrySwitch") != 1) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    CharSequence optString = Oy.optString("wording");
                    String optString2 = Oy.optString("androidIcon");
                    IconPreference iconPreference = (IconPreference) this.xNy.Zu("find_friends_by_look");
                    if (bi.oN(optString)) {
                        iconPreference.setTitle(getString(R.l.ehK));
                    } else {
                        iconPreference.setTitle(optString);
                    }
                    if (bi.oN(optString2)) {
                        iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dyK);
                        this.xNE = null;
                    } else {
                        o.PB();
                        Bitmap iJ = com.tencent.mm.ap.c.iJ(optString2);
                        if (iJ != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iJ);
                            this.xNE = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load look icon from disk and net %s ", optString2);
                            iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dyK);
                            o.PF().a(optString2, this.xNU);
                            this.xNE = optString2;
                        }
                    }
                    this.xNL++;
                    this.xNy.bl("find_friends_by_look", false);
                    if (obj != null) {
                        iconPreference.Fq(0);
                        iconPreference.dk(getString(R.l.dGa), R.g.bEg);
                    } else {
                        iconPreference.Fq(8);
                        a(k.Rl().hMS, iconPreference);
                    }
                    com.tencent.mm.bb.b.QX();
                    return;
                }
                this.xNy.bl("find_friends_by_look", true);
            } catch (Throwable e) {
                x.e("MicroMsg.FindMoreFriendsUI", bi.i(e));
            }
        }
    }

    private void a(final k.a aVar, final IconPreference iconPreference) {
        ah.y(new Runnable() {
            public final void run() {
                if (iconPreference != null) {
                    if (aVar == null) {
                        iconPreference.Fs(8);
                        return;
                    }
                    if (aVar.isValid()) {
                        x.i("MicroMsg.FindMoreFriendsUI", "show red %s", iconPreference.getTitle());
                        switch (aVar.type) {
                            case 1:
                                iconPreference.Fs(0);
                                iconPreference.Fr(8);
                                break;
                            case 2:
                                iconPreference.Fs(8);
                                iconPreference.Fr(0);
                                iconPreference.af(aVar.text, -1, Color.parseColor("#8c8c8c"));
                                iconPreference.mD(true);
                                iconPreference.Fv(8);
                                break;
                            default:
                                x.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(aVar.type));
                                break;
                        }
                    }
                    x.i("MicroMsg.FindMoreFriendsUI", "hide red %s", iconPreference.getTitle());
                    iconPreference.Fs(8);
                    iconPreference.Fr(8);
                    h.this.xNy.notifyDataSetChanged();
                }
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        x.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
    }

    private void alq() {
        this.xNL = 0;
        if (this.xNM != null) {
            this.xNM.setVisibility(8);
        }
        if (this.ysb) {
            boolean z;
            String optString;
            IconPreference iconPreference;
            cnd();
            boolean wm = wm(1048576);
            boolean Pu = d.Pu("scanner");
            String str = "MicroMsg.FindMoreFriendsUI";
            String str2 = "openScan %s, plugin installed %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!wm);
            objArr[1] = Boolean.valueOf(Pu);
            x.i(str, str2, objArr);
            if (wm || !Pu) {
                this.xNy.bl("find_friends_by_qrcode", true);
            } else {
                this.xNy.bl("find_friends_by_qrcode", false);
                this.xNL++;
            }
            cne();
            wm = wm(2097152);
            Pu = d.Pu("search");
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "openSearch %s, plugin installed %s";
            objArr = new Object[2];
            if (wm) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(Pu);
            x.i(str, str2, objArr);
            if (wm || !Pu) {
                this.xNy.bl("find_friends_by_search", true);
            } else {
                this.xNL++;
                this.xNy.bl("find_friends_by_search", false);
                try {
                    JSONObject Oy = com.tencent.mm.plugin.aj.a.h.Oy("discoverSearchEntry");
                    CharSequence optString2 = Oy.optString("wording");
                    optString = Oy.optString("androidIcon");
                    iconPreference = (IconPreference) this.xNy.Zu("find_friends_by_search");
                    if (bi.oN(optString2)) {
                        iconPreference.setTitle(getString(R.l.ehO));
                    } else {
                        iconPreference.setTitle(optString2);
                    }
                    if (bi.oN(optString)) {
                        iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dyN);
                        this.xNF = null;
                    } else {
                        o.PB();
                        Bitmap iJ = com.tencent.mm.ap.c.iJ(optString);
                        if (iJ != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iJ);
                            this.xNF = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load search icon from disk and net %s ", optString);
                            iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dyN);
                            o.PF().a(optString, this.xNU);
                            this.xNF = optString;
                        }
                    }
                    iconPreference.Fq(8);
                    a(k.Rl().hMR, iconPreference);
                    com.tencent.mm.bb.b.QZ();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e, "update search entry exception!", new Object[0]);
                }
            }
            cnf();
            if ((this.qpN & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.FindMoreFriendsUI", "openBottle %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(d.Pu("bottle")));
            if (z && r1) {
                this.xNL++;
                this.xNy.bl("voice_bottle", false);
                iconPreference = (IconPreference) this.xNy.Zu("voice_bottle");
                if (iconPreference != null) {
                    int FU = com.tencent.mm.y.k.FU();
                    if (FU > 0) {
                        iconPreference.dk(String.valueOf(FU), s.ge(getContext()));
                    }
                    if (FU <= 0 || (this.status & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                        iconPreference.Fq(8);
                    } else {
                        iconPreference.Fq(0);
                    }
                }
            } else {
                this.xNy.bl("voice_bottle", true);
            }
            wm = wm(4194304);
            optString = "MicroMsg.FindMoreFriendsUI";
            str = "openShoppingEntry %s";
            Object[] objArr2 = new Object[1];
            if (wm) {
                z = false;
            } else {
                z = true;
            }
            objArr2[0] = Boolean.valueOf(z);
            x.i(optString, str, objArr2);
            if (wm) {
                this.xNy.bl("jd_market_entrance", true);
            } else {
                lX(false);
            }
            j jVar = q.a.vjc;
            if (jVar != null) {
                getContext();
                z = jVar.aRR();
            } else {
                z = false;
            }
            Pu = wm(8388608);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "shouldShowGame %s, openGameEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(z);
            if (Pu) {
                wm = false;
            } else {
                wm = true;
            }
            objArr[1] = Boolean.valueOf(wm);
            x.i(str, str2, objArr);
            if (!z || Pu) {
                this.xNy.bl("more_tab_game_recommend", true);
            } else {
                this.xNy.bl("more_tab_game_recommend", false);
                cnc();
                this.xNL++;
            }
            com.tencent.mm.sdk.b.b phVar = new ph();
            phVar.fHU.fHW = true;
            com.tencent.mm.sdk.b.a.xmy.m(phVar);
            wm = phVar.fHV.fHX;
            boolean wm2 = wm(16777216);
            str2 = "MicroMsg.FindMoreFriendsUI";
            String str3 = "shouldShowMiniProgram %s, openMiniProgramEntry %s";
            Object[] objArr3 = new Object[2];
            objArr3[0] = Boolean.valueOf(wm);
            if (wm2) {
                z = false;
            } else {
                z = true;
            }
            objArr3[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr3);
            if (!wm || wm2) {
                this.xNy.bl("app_brand_entrance", true);
            } else {
                this.xNL++;
                this.xNy.bl("app_brand_entrance", false);
                iconPreference = (IconPreference) this.xNy.Zu("app_brand_entrance");
                iconPreference.Fq(phVar.fHV.fHZ ? 0 : 8);
                iconPreference.dk(getString(R.l.dGa), R.g.bEg);
                iconPreference.Fs(phVar.fHV.fHY ? 0 : 8);
            }
            wm = com.tencent.mm.plugin.ipcall.d.aTK();
            Pu = wm(33554432);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "showShowWeChatOut %s, openWeChatOutEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(wm);
            if (Pu) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (!wm || Pu) {
                this.xNy.bl("ip_call_entrance", true);
            } else {
                this.xNL++;
                this.xNy.bl("ip_call_entrance", false);
                iconPreference = (IconPreference) this.xNy.Zu("ip_call_entrance");
                as.Hm();
                if (((Integer) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.j.g.Af().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.Fq(0);
                    iconPreference.dk(getString(R.l.dGa), R.g.bEg);
                } else {
                    iconPreference.Fq(8);
                }
                iconPreference.Fv(8);
                as.Hm();
                if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.mD(true);
                    iconPreference.Fq(8);
                    Pu = true;
                } else {
                    iconPreference.mD(false);
                    Pu = false;
                }
                as.Hm();
                String str4 = (String) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.af(str4, -1, -7566196);
                if (!bi.oN(str4)) {
                    Pu = true;
                }
                if (Pu) {
                    iconPreference.Fr(0);
                } else {
                    iconPreference.Fr(8);
                }
                this.xNy.a(new PreferenceSmallCategory(getContext()), -1);
            }
            cmZ();
            this.xNy.bl("find_friends_by_facebook", true);
            this.xNy.bl("settings_emoji_store", true);
            if (this.xNL == 0) {
                ViewGroup viewGroup = (ViewGroup) findViewById(16908298).getParent();
                if (this.xNM == null) {
                    this.xNM = getContext().getLayoutInflater().inflate(R.i.diq, null);
                    this.xNN = (TextView) this.xNM.findViewById(R.h.cnQ);
                    this.xNN.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            h.this.startActivity(new Intent(h.this.getContext(), SettingsManageFindMoreUI.class));
                        }
                    });
                    viewGroup.addView(this.xNM, new LayoutParams(-1, -1));
                } else {
                    this.xNM.setVisibility(0);
                }
            }
            this.xNy.notifyDataSetChanged();
        }
    }

    private void lX(boolean z) {
        String value;
        if (com.tencent.mm.sdk.platformtools.w.cfS()) {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigName");
        } else if (com.tencent.mm.sdk.platformtools.w.cfT()) {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigIconUrl");
        q.k kVar = z.vjl;
        boolean z2 = true;
        if (kVar != null) {
            String bEH = kVar.bEH();
            if (!(bi.oN(value) || bi.oN(value2) || bi.oN(bEH))) {
                Object obj;
                CharSequence charSequence;
                IconPreference iconPreference;
                Bitmap iJ;
                Bitmap iJ2;
                this.xNL++;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar = (com.tencent.mm.plugin.subapp.jdbiz.b) kVar.bEI();
                if ((bVar.sbU < System.currentTimeMillis() / 1000 ? 1 : null) != null) {
                    if (bVar.sbV == 0 || bVar.sbV >= System.currentTimeMillis() / 1000) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        if (!bi.oN(bVar.iconUrl)) {
                            value2 = bVar.iconUrl;
                        }
                        if (!bi.oN(bVar.title)) {
                            charSequence = bVar.title;
                            iconPreference = (IconPreference) this.xNy.Zu("jd_market_entrance");
                            o.PB();
                            iJ = com.tencent.mm.ap.c.iJ(value2);
                            if (iJ == null) {
                                iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iJ);
                                this.xND = null;
                            } else {
                                iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dzd);
                                o.PF().a(value2, this.xNU);
                                this.xND = value2;
                            }
                            iconPreference.setTitle(charSequence);
                            iconPreference.Fq(8);
                            iconPreference.Fs(8);
                            iconPreference.Fr(8);
                            iconPreference.mD(false);
                            iconPreference.Fv(8);
                            if (kVar.bEz() && bVar.agz() && !bVar.bEr()) {
                                if (!bi.oN(bVar.sbQ)) {
                                    iconPreference.Fq(8);
                                    iconPreference.Fs(8);
                                    iconPreference.af(bVar.sbQ, -1, -7566196);
                                    iconPreference.Fr(0);
                                }
                                if (!bi.oN(bVar.sbR)) {
                                    o.PB();
                                    iJ2 = com.tencent.mm.ap.c.iJ(bVar.sbR);
                                    iconPreference.Fv(0);
                                    iconPreference.Fu(0);
                                    iconPreference.Fw(0);
                                    iconPreference.mD(false);
                                    if (iJ2 == null) {
                                        this.xNG = null;
                                        iconPreference.V(iJ2);
                                    } else {
                                        o.PF().a(bVar.sbR, this.xNU);
                                        this.xNG = bVar.sbR;
                                    }
                                } else if (!bi.oN(bVar.sbQ)) {
                                    iconPreference.mD(true);
                                } else if (bVar.sbP) {
                                    iconPreference.Fs(0);
                                    iconPreference.dk("", -1);
                                    iconPreference.Fq(8);
                                }
                            }
                            if (z) {
                                this.xNy.notifyDataSetChanged();
                            }
                            if (!this.xNH) {
                                g.pWK.h(11178, bEH, kVar.bEI().bEt(), Integer.valueOf(cna()));
                                this.xNH = true;
                            }
                            z2 = false;
                        }
                    }
                }
                obj = value;
                iconPreference = (IconPreference) this.xNy.Zu("jd_market_entrance");
                o.PB();
                iJ = com.tencent.mm.ap.c.iJ(value2);
                if (iJ == null) {
                    iconPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dzd);
                    o.PF().a(value2, this.xNU);
                    this.xND = value2;
                } else {
                    iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iJ);
                    this.xND = null;
                }
                iconPreference.setTitle(charSequence);
                iconPreference.Fq(8);
                iconPreference.Fs(8);
                iconPreference.Fr(8);
                iconPreference.mD(false);
                iconPreference.Fv(8);
                if (bi.oN(bVar.sbQ)) {
                    iconPreference.Fq(8);
                    iconPreference.Fs(8);
                    iconPreference.af(bVar.sbQ, -1, -7566196);
                    iconPreference.Fr(0);
                }
                if (!bi.oN(bVar.sbR)) {
                    o.PB();
                    iJ2 = com.tencent.mm.ap.c.iJ(bVar.sbR);
                    iconPreference.Fv(0);
                    iconPreference.Fu(0);
                    iconPreference.Fw(0);
                    iconPreference.mD(false);
                    if (iJ2 == null) {
                        o.PF().a(bVar.sbR, this.xNU);
                        this.xNG = bVar.sbR;
                    } else {
                        this.xNG = null;
                        iconPreference.V(iJ2);
                    }
                } else if (!bi.oN(bVar.sbQ)) {
                    iconPreference.mD(true);
                } else if (bVar.sbP) {
                    iconPreference.Fs(0);
                    iconPreference.dk("", -1);
                    iconPreference.Fq(8);
                }
                if (z) {
                    this.xNy.notifyDataSetChanged();
                }
                if (this.xNH) {
                    g.pWK.h(11178, bEH, kVar.bEI().bEt(), Integer.valueOf(cna()));
                    this.xNH = true;
                }
                z2 = false;
            }
        }
        this.xNy.bl("jd_market_entrance", z2);
    }

    private static int cna() {
        q.k kVar = z.vjl;
        if (kVar == null) {
            return 1;
        }
        q.d bEI = kVar.bEI();
        if (!kVar.bEz() || !bEI.agz() || bEI.bEr()) {
            return 1;
        }
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bEI.bEw()) && !bi.oN(bEI.bEx())) {
            return 6;
        }
        if (!bi.oN(bEI.bEu())) {
            return 3;
        }
        if (bEI.bEv()) {
            return 2;
        }
        return 1;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str;
        com.tencent.mm.sdk.b.b hsVar;
        IconPreference iconPreference;
        String aD;
        Intent intent2;
        String str2;
        k Rl;
        if ("album_dyna_photo_ui_title".equals(preference.idX)) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                com.tencent.mm.plugin.report.service.f.vR(10);
                as.Hm();
                this.xNB = (String) com.tencent.mm.y.c.Db().get(68377, null);
                intent = new Intent();
                com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b(701, 1);
                bVar.bW(!bi.oN(this.xNB));
                bVar.mF(this.xNC);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.putExtra("is_from_find_more", true);
                str = "enter_by_red";
                boolean z = !bi.oN(this.xNB) || this.xNC > 0;
                intent.putExtra(str, z);
                as.Hm();
                intent.putExtra("is_sns_notify_open", bi.a((Boolean) com.tencent.mm.y.c.Db().get(68384, null), true));
                intent.putExtra("sns_unread_count", n.qWD.Tx());
                if (!bi.oN(this.xNB)) {
                    as.Hm();
                    intent.putExtra("new_feed_id", bi.aD((String) com.tencent.mm.y.c.Db().get(68418, null), ""));
                }
                bVar.b(intent, "enter_log");
                hsVar = new hs();
                com.tencent.mm.sdk.b.a.xmy.m(hsVar);
                z = true;
                if (!hsVar.fyU.isResume) {
                    if (!bi.oN(this.xNB)) {
                        z = false;
                    }
                    if (n.qWD != null) {
                        this.xNC = n.qWD.Tx();
                        if (this.xNC > 0) {
                            z = false;
                        }
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(68377, "");
                }
                as.Hm();
                com.tencent.mm.y.c.Db().set(589825, Boolean.valueOf(false));
                intent.putExtra("sns_resume_state", z);
                d.b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
                g.pWK.k(10958, "1");
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        h.this.sendBroadcast(intent);
                    }
                }, 500);
                return true;
            }
            u.fJ(getContext());
            return true;
        } else if ("find_friends_by_near".equals(preference.idX)) {
            x.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
            if (!com.tencent.mm.pluginsdk.g.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                return true;
            }
            cnb();
            return true;
        } else if ("find_friends_by_shake".equals(preference.idX)) {
            if (!this.xNI && com.tencent.mm.y.q.GG().booleanValue()) {
                iconPreference = (IconPreference) fVar.Zu("find_friends_by_shake");
                if (iconPreference != null) {
                    iconPreference.Fs(8);
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(340231, Boolean.valueOf(true));
                    as.Hm();
                    com.tencent.mm.y.c.Db().lO(true);
                    g.pWK.a(232, 4, 1, false);
                }
            }
            g.pWK.k(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            as.Hm();
            aD = bi.aD((String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            as.Hm();
            Boolean valueOf = (!Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false)).booleanValue() || aD == null || aD.equals("")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            if (valueOf.booleanValue()) {
                g.pWK.h(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            com.tencent.mm.sdk.b.a.xmy.m(new ng());
            d.y(getContext(), "shake", ".ui.ShakeReportUI");
            return true;
        } else if ("voice_bottle".equals(preference.idX)) {
            g.pWK.k(10958, "5");
            bj HW = bj.HW();
            if (bi.a(Integer.valueOf(HW.fXa), 0) <= 0 || bi.oN(HW.getProvince())) {
                d.y(getContext(), "bottle", ".ui.BottleWizardStep1");
            } else {
                d.y(getContext(), "bottle", ".ui.BottleBeachUI");
            }
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.idX)) {
            if (!com.tencent.mm.o.a.aV(getContext())) {
                getContext();
                if (!com.tencent.mm.at.a.Qq()) {
                    g.pWK.k(10958, "2");
                    intent2 = new Intent();
                    intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    g.pWK.h(11265, Integer.valueOf(2));
                    d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                    return true;
                }
            }
            return true;
        } else if (preference.idX.equals("more_tab_game_recommend")) {
            g.pWK.k(10958, "6");
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.xNK);
                intent.putExtra("game_report_from_scene", 901);
                if (this.xNK) {
                    hsVar = new md();
                    com.tencent.mm.sdk.b.a.xmy.m(hsVar);
                    iconPreference = (IconPreference) fVar.Zu("more_tab_game_recommend");
                    if (!(hsVar.fEC.fED == null || iconPreference == null)) {
                        o.PG().hEC.a(new com.tencent.mm.ap.a.c(iconPreference.ori, hsVar.fEC.fED));
                    }
                }
                d.b(getContext(), "game", ".ui.GameCenterUI", intent);
                return true;
            }
            u.fJ(getContext());
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.idX)) {
            d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            return true;
        } else if ("find_friends_by_mobile".equals(preference.idX)) {
            if (m.NT() != m.a.SUCC) {
                intent2 = new Intent(getContext(), BindMContactIntroUI.class);
                intent2.putExtra("key_upload_scene", 6);
                MMWizardActivity.A(getContext(), intent2);
                return true;
            }
            startActivity(new Intent(getContext(), MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_facebook".equals(preference.idX)) {
            startActivity(new Intent(getContext(), FacebookFriendUI.class));
            return true;
        } else if ("settings_mm_card_package".equals(preference.idX)) {
            x.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            d.y(getContext(), "card", ".ui.CardHomePageUI");
            return true;
        } else if (preference.idX.equals("jd_market_entrance")) {
            str2 = null;
            com.tencent.mm.pluginsdk.wallet.i.CU(9);
            q.k kVar = z.vjl;
            if (kVar != null) {
                str2 = z.vjl.bEH();
                g.pWK.h(11179, str2, kVar.bEI().bEt(), Integer.valueOf(cna()));
                kVar.bEC();
                kVar.bEB();
                ((IconPreference) preference).dk("", -1);
                if (!bi.oN(str2)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("KPublisherId", "jd_store");
                    d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            x.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + str2);
            return true;
        } else if ("ip_call_entrance".equals(preference.idX)) {
            iconPreference = (IconPreference) fVar.Zu("ip_call_entrance");
            iconPreference.Fs(8);
            iconPreference.Fr(8);
            iconPreference.mD(false);
            iconPreference.Fv(8);
            Object obj = null;
            as.Hm();
            str2 = (String) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            as.Hm();
            if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                com.tencent.mm.plugin.ipcall.a.e.i.N(1, -1, -1);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                obj = 1;
            }
            as.Hm();
            if (((Integer) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.j.g.Af().getInt("WCOEntranceRedDot", 0)) {
                obj = 1;
                g.pWK.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.j.g.Af().getInt("WCOEntranceRedDot", 0)));
            }
            if (!bi.oN(str2)) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            }
            if (obj != null) {
                com.tencent.mm.sdk.b.a.xmy.m(new rw());
            }
            if (com.tencent.mm.o.a.Bd()) {
                com.tencent.mm.ui.base.h.a(getContext(), R.l.ewD, 0, null, null);
            } else {
                g.pWK.h(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            }
            return true;
        } else if ("app_brand_entrance".equals(preference.idX)) {
            ((com.tencent.mm.plugin.appbrand.n.f) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.f.class)).w(getContext(), 1);
            return true;
        } else if ("find_friends_by_search".equals(preference.idX)) {
            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                aD = com.tencent.mm.plugin.aj.a.h.Oy("discoverSearchEntry").optString("wording");
                if (bi.oN(aD)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty title");
                } else {
                    Rl = k.Rl();
                    Rl.hMR = new k.a();
                    Rl.save();
                    ((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                    com.tencent.mm.bb.g.d("", 0, 0, 20);
                    intent2 = com.tencent.mm.bb.b.QT();
                    intent2.putExtra("ftsbizscene", 20);
                    String zZ = com.tencent.mm.plugin.aj.a.g.zZ(20);
                    str = com.tencent.mm.bb.b.ar(zZ, com.tencent.mm.plugin.webview.modeltools.f.bSl().bPT());
                    intent2.putExtra("key_session_id", zZ);
                    intent2.putExtra("title", aD);
                    intent2.putExtra("ftsneedkeyboard", true);
                    intent2.putExtra("sessionId", zZ);
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("key_load_js_without_delay", true);
                    intent2.putExtra("zoom", false);
                    intent2.putExtra("key_preload_biz", 1);
                    d.b(getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", intent2);
                    com.tencent.mm.plugin.aj.a.g.Ac(0);
                }
            } else {
                x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if (!"find_friends_by_look".equals(preference.idX)) {
            return false;
        } else {
            if (com.tencent.mm.plugin.aj.a.g.Ae(1)) {
                aD = com.tencent.mm.plugin.aj.a.h.Oy("discoverRecommendEntry").optString("wording");
                if (bi.oN(aD)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty query");
                } else {
                    x.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                    Rl = k.Rl();
                    Rl.hMS = new k.a();
                    Rl.save();
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    String zZ2 = com.tencent.mm.plugin.aj.a.g.zZ(21);
                    String zZ3 = com.tencent.mm.plugin.aj.a.g.zZ(21);
                    l bPY = l.bPY();
                    if (!bPY.ttz) {
                        x.w("RecommendLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(1)), valueOf2, zZ2, zZ3);
                    } else if (System.currentTimeMillis() - bPY.ttx <= l.ttq) {
                        x.w("RecommendLogic", "pre get data fail for time interval limit");
                    } else {
                        x.w("RecommendLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(1)), valueOf2, zZ2, zZ3);
                        bPY.ttt = true;
                        if (bPY.ttv != null) {
                            bPY.ttv.countDown();
                        }
                        bPY.ttv = new CountDownLatch(1);
                        x.i("RecommendLogic", "preGetSearchData");
                        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
                        dVar.tqz = 2;
                        dVar.foW = com.tencent.mm.bb.b.QW();
                        dVar.ael = com.tencent.mm.sdk.platformtools.w.eM(ad.getContext());
                        dVar.scene = 21;
                        dVar.tqu = 2;
                        LinkedList linkedList = new LinkedList();
                        oz ozVar = new oz();
                        ozVar.aAM = DownloadInfo.NETTYPE;
                        ozVar.weC = com.tencent.mm.plugin.aj.a.g.bgl();
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "time_zone_min";
                        ozVar.weC = String.valueOf(((-TimeZone.getDefault().getRawOffset()) / 1000) / 60);
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "currentPage";
                        ozVar.weB = 1;
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "is_prefetch";
                        ozVar.weB = 0;
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = TencentLocation.EXTRA_DIRECTION;
                        ozVar.weB = 2;
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "seq";
                        ozVar.weC = valueOf2;
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "client_exposed_info";
                        ozVar.weC = "";
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "requestId";
                        ozVar.weC = valueOf2;
                        linkedList.add(ozVar);
                        ozVar = new oz();
                        ozVar.aAM = "recType";
                        ozVar.weB = 0;
                        linkedList.add(ozVar);
                        dVar.tqD = linkedList;
                        dVar.tqL = true;
                        dVar.hMN = valueOf2;
                        if (bPY.aq(linkedList)) {
                            dVar.frp = zZ2;
                            dVar.tpV = zZ3;
                            bPY.tts.b(dVar);
                            bPY.ttx = System.currentTimeMillis();
                        } else {
                            throw new IllegalStateException("pre get data must use same commKvSets with hardcode set");
                        }
                    }
                    ((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                    com.tencent.mm.plugin.aj.a.g.Ac(1);
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_preload_biz", 2);
                    com.tencent.mm.bb.b.a(getContext(), aD, intent3, aD, valueOf2, zZ2, zZ3);
                    com.tencent.mm.sdk.b.b kxVar = new kx();
                    kxVar.fCZ.scene = 0;
                    com.tencent.mm.sdk.b.a.xmy.m(kxVar);
                    com.tencent.mm.bb.g.u(21, aD);
                    com.tencent.mm.bb.g.bk(21, 0);
                    if (com.tencent.mm.plugin.aj.a.g.Af(1) > com.tencent.mm.plugin.aj.a.g.Ad(1)) {
                        com.tencent.mm.bb.g.bk(21, 15);
                    } else {
                        com.tencent.mm.bb.g.bk(21, 14);
                    }
                }
            } else {
                x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        }
    }

    public final void cnb() {
        g.pWK.k(10958, "4");
        as.Hm();
        if (bi.c((Boolean) com.tencent.mm.y.c.Db().get(4103, null))) {
            bj HX = bj.HX();
            if (HX == null) {
                d.y(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            String oM = bi.oM(HX.getProvince());
            int a = bi.a(Integer.valueOf(HX.fXa), 0);
            if (bi.oN(oM) || a == 0) {
                d.y(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            as.Hm();
            Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) getContext();
                if (launcherUI != null) {
                    launcherUI.xPu.xOK.YW("tab_find_friend");
                }
                com.tencent.mm.bj.a.dW(getContext());
                return;
            }
            if (this.xNz == null) {
                this.xNz = View.inflate(getContext(), R.i.dmH, null);
                this.oTV = (CheckBox) this.xNz.findViewById(R.h.csL);
                this.oTV.setChecked(false);
            }
            if (this.oTX == null) {
                this.oTX = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.dGZ), this.xNz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (h.this.oTV != null) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().set(4104, Boolean.valueOf(!h.this.oTV.isChecked()));
                        }
                        LauncherUI launcherUI = (LauncherUI) h.this.getContext();
                        if (launcherUI != null) {
                            launcherUI.xPu.xOK.YW("tab_find_friend");
                        }
                        com.tencent.mm.bj.a.dW(h.this.getContext());
                    }
                }, null);
                return;
            } else {
                this.oTX.show();
                return;
            }
        }
        d.y(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
    }

    private void cnc() {
        IconPreference iconPreference = (IconPreference) this.xNy.Zu("more_tab_game_recommend");
        if (iconPreference != null) {
            com.tencent.mm.sdk.b.b mdVar = new md();
            com.tencent.mm.sdk.b.a.xmy.m(mdVar);
            iconPreference.Fs(8);
            String str = mdVar.fEC.fEE;
            String str2 = mdVar.fEC.appId;
            int i = mdVar.fEC.msgType;
            String str3 = mdVar.fEC.fpi;
            if (mdVar.fEC.showType == 1) {
                iconPreference.dk(getString(R.l.dGa), R.g.bEg);
                a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                b(str2, i, str, str3, mdVar.fEC.showType);
            } else if (mdVar.fEC.showType == 2) {
                iconPreference.af(fQ(mdVar.fEC.appName, mdVar.fEC.appId), -1, Color.parseColor("#8c8c8c"));
                a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                b(str2, i, str, str3, mdVar.fEC.showType);
            } else if (mdVar.fEC.showType == 3) {
                if (bi.oN(mdVar.fEC.fED)) {
                    iconPreference.V(com.tencent.mm.pluginsdk.model.app.g.b(mdVar.fEC.appId, 1, com.tencent.mm.bu.a.getDensity(getContext())));
                    a(iconPreference, 8, 8, 8, false, 0, 0, 0);
                    return;
                }
                a(mdVar.fEC.fED, iconPreference, mdVar, "");
            } else if (mdVar.fEC.showType == 4) {
                String fQ = fQ(mdVar.fEC.appName, mdVar.fEC.appId);
                if (bi.oN(fQ)) {
                    this.xNK = true;
                    a(iconPreference, 8, 8, 8, false, 8, 8, 8);
                    return;
                }
                iconPreference.af(fQ, -1, Color.parseColor("#8c8c8c"));
                if (bi.oN(mdVar.fEC.fED)) {
                    iconPreference.V(com.tencent.mm.pluginsdk.model.app.g.b(mdVar.fEC.appId, 1, com.tencent.mm.bu.a.getDensity(getContext())));
                    a(iconPreference, 8, 8, 0, false, 0, 0, 0);
                    return;
                }
                a(mdVar.fEC.fED, iconPreference, mdVar, fQ);
            } else if (mdVar.fEC.showType == 5) {
                this.xNK = true;
                a(iconPreference, 8, 0, 8, false, 8, 8, 8);
                b(str2, i, str, str3, mdVar.fEC.showType);
            } else {
                this.xNK = true;
                a(iconPreference, 8, 8, 8, false, 8, 8, 8);
            }
        }
    }

    private synchronized void a(String str, IconPreference iconPreference, md mdVar, String str2) {
        if (!(bi.oN(str) || iconPreference == null || iconPreference.ori == null)) {
            x.d("MicroMsg.FindMoreFriendsUI", "download entrance image : %s", str);
            final String str3 = mdVar.fEC.fEE;
            final String str4 = mdVar.fEC.appId;
            final int i = mdVar.fEC.msgType;
            final String str5 = mdVar.fEC.fpi;
            final int i2 = mdVar.fEC.showType;
            final com.tencent.mm.sdk.b.b gtVar = new gt();
            gtVar.fxJ.pK = 1;
            gtVar.fxJ.url = str;
            com.tencent.mm.sdk.b.a.xmy.m(gtVar);
            if (gtVar.fxK.fxM) {
                String str6 = gtVar.fxK.fxL + com.tencent.mm.a.g.s(str.getBytes());
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFl = true;
                aVar.hFn = str6;
                com.tencent.mm.ap.a.a.c PQ = aVar.PQ();
                final IconPreference iconPreference2 = iconPreference;
                final String str7 = str2;
                o.PG().a(str, iconPreference.ori, PQ, new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        gtVar.fxJ.pK = 2;
                        gtVar.fxJ.url = str;
                        com.tencent.mm.sdk.b.a.xmy.m(gtVar);
                    }
                }, new com.tencent.mm.ap.a.c.g() {
                    public final void lF(String str) {
                        ah.y(new Runnable() {
                            public final void run() {
                                h.this.xNK = false;
                                h.a((IconPreference) h.this.xNy.Zu("more_tab_game_recommend"), 8, 8, 8, false, 8, 8, 8);
                            }
                        });
                    }

                    public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
                        return null;
                    }

                    public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
                        gtVar.fxJ.pK = 2;
                        gtVar.fxJ.url = str;
                        com.tencent.mm.sdk.b.a.xmy.m(gtVar);
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    h.this.xNK = true;
                                    IconPreference iconPreference = (IconPreference) h.this.xNy.Zu("more_tab_game_recommend");
                                    if (i2 == 3) {
                                        iconPreference.dk(h.this.getString(R.l.dGa), R.g.bEg);
                                        h.a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                                        h.b(str4, i, str3, str5, 1);
                                    } else if (i2 == 4) {
                                        iconPreference.af(str7, -1, Color.parseColor("#8c8c8c"));
                                        h.a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                                        h.b(str4, i, str3, str5, 2);
                                    }
                                }
                            });
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        ah.y(new Runnable() {
                            public final void run() {
                                h.this.xNK = true;
                                iconPreference2.V(bitmap);
                                if (i2 == 3) {
                                    h.a(iconPreference2, 8, 8, 8, false, 0, 0, 0);
                                } else if (i2 == 4) {
                                    h.a(iconPreference2, 8, 8, 0, false, 0, 0, 0);
                                }
                                h.b(str4, i, str3, str5, i2);
                            }
                        });
                    }
                });
            }
        }
    }

    private static void b(String str, int i, String str2, String str3, int i2) {
        com.tencent.mm.kernel.g.Dr();
        String str4 = (String) com.tencent.mm.kernel.g.Dq().Db().get(w.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) "");
        if (str2 != null && !str2.equals(str4)) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) str2);
            com.tencent.mm.sdk.b.b niVar = new ni();
            niVar.fGd.scene = 9;
            niVar.fGd.fGe = 901;
            niVar.fGd.action = 1;
            niVar.fGd.appId = str;
            niVar.fGd.msgType = i;
            niVar.fGd.fEE = str2;
            niVar.fGd.fpi = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                x.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                str4 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                str4 = "";
                x.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            niVar.fGd.fGf = str4;
            com.tencent.mm.sdk.b.a.xmy.m(niVar);
        }
    }

    private String fQ(String str, String str2) {
        return !bi.oN(str) ? str : com.tencent.mm.pluginsdk.model.app.g.l(getContext(), str2);
    }

    private static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        iconPreference.Fq(i);
        iconPreference.Fs(i2);
        iconPreference.Fr(i3);
        iconPreference.mD(z);
        iconPreference.Fv(i4);
        iconPreference.Fu(i5);
        iconPreference.Fw(i6);
    }

    public final void GZ() {
        if ((com.tencent.mm.y.q.Gj() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            this.xNC++;
            cnd();
            this.xNy.notifyDataSetChanged();
        }
    }

    public final void Ha() {
        if ((com.tencent.mm.y.q.Gj() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            cnd();
            this.xNy.notifyDataSetChanged();
        }
    }

    public final void Hb() {
    }

    public final void Hd() {
        if (this.xNy != null) {
            this.status = com.tencent.mm.y.q.Gc();
            alq();
        }
    }

    protected final void cmi() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.xNy = this.yrJ;
        this.status = com.tencent.mm.y.q.Gc();
        this.qpN = com.tencent.mm.y.q.Gj();
        this.lrE = com.tencent.mm.y.q.Gd();
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    }

    protected final void cmj() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        com.tencent.mm.pluginsdk.d.a.a(iq.class.getName(), this.vzO);
        com.tencent.mm.pluginsdk.d.a.a(gs.class.getName(), this.xNR);
        com.tencent.mm.pluginsdk.d.a.a(pe.class.getName(), this.xNS);
        com.tencent.mm.sdk.b.a.xmy.b(this.xNP);
        com.tencent.mm.sdk.b.a.xmy.b(this.xNO);
        com.tencent.mm.sdk.b.a.xmy.b(this.xNQ);
        com.tencent.mm.sdk.b.a.xmy.b(this.rcw);
        com.tencent.mm.sdk.b.a.xmy.b(this.xNT);
        com.tencent.mm.sdk.b.a.xmy.a(this.qjh);
        com.tencent.mm.be.l.TG().c(this);
        as.Hm();
        com.tencent.mm.y.c.Fk().a(this);
        as.Hm();
        com.tencent.mm.y.c.a(this);
        as.Hm();
        com.tencent.mm.y.c.Db().a(this);
        if (n.qWF != null) {
            n.qWF.a(this);
        }
        final View findViewById = findViewById(R.h.ctH);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(h.this.getContext(), R.a.bqa));
                }
            });
        }
        if (isAdded()) {
            com.tencent.mm.blink.b.wv().f(new Runnable() {
                public final void run() {
                    h.this.lrE = com.tencent.mm.y.q.Gd();
                    h.this.alq();
                }
            });
        }
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    }

    private boolean wm(int i) {
        return (this.lrE & ((long) i)) != 0;
    }

    private void cnd() {
        boolean z = (this.qpN & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        x.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(d.Pu("sns")));
        SharedPreferences sharedPreferences = getSharedPreferences(ad.cgf(), 0);
        String string = sharedPreferences.getString(com.tencent.mm.y.q.FY() + "_sns_entrance_disappear", "");
        if (!z) {
            boolean z2 = sharedPreferences.getBoolean(com.tencent.mm.y.q.FY() + "_has_mod_userinfo", false);
            if (string != null && string.equals("on")) {
                g.pWK.a(150, (long) (z2 ? 110 : 111), 1, true);
                x.e("MicroMsg.FindMoreFriendsUI", "sns entrance disappear autoly, hasModUserInfo:%b", Boolean.valueOf(z2));
                g.pWK.h(15179, Integer.valueOf(r9));
            } else if (string != null && string.equals("on_close")) {
                g.pWK.a(150, (long) (z2 ? MMGIFException.D_GIF_ERR_IMAGE_DEFECT : 113), 1, true);
                x.i("MicroMsg.FindMoreFriendsUI", "sns entrance close by user, hasModUserInfo:%b", Boolean.valueOf(z2));
                g.pWK.h(15179, Integer.valueOf(r9));
            }
            if (sharedPreferences.contains(com.tencent.mm.y.q.FY() + "_has_mod_userinfo") || sharedPreferences.contains(com.tencent.mm.y.q.FY() + "_sns_entrance_disappear")) {
                sharedPreferences.edit().remove(com.tencent.mm.y.q.FY() + "_has_mod_userinfo").remove(com.tencent.mm.y.q.FY() + "_sns_entrance_disappear").commit();
            }
        } else if (bi.oN(string)) {
            sharedPreferences.edit().putString(com.tencent.mm.y.q.FY() + "_sns_entrance_disappear", "on").commit();
        }
        if (z && r10) {
            this.xNL++;
            this.xNy.bl("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.xNy.Zu("album_dyna_photo_ui_title");
            friendSnsPreference.drawable = com.tencent.mm.bu.a.b(getContext(), R.k.dyM);
            as.Hm();
            boolean c = bi.c((Boolean) com.tencent.mm.y.c.Db().get(48, null));
            friendSnsPreference.Fq(8);
            friendSnsPreference.Fw(8);
            if (c) {
                friendSnsPreference.Fq(0);
                friendSnsPreference.dk(getString(R.l.dGa), R.g.bEg);
            }
            as.Hm();
            this.xNB = (String) com.tencent.mm.y.c.Db().get(68377, null);
            x.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", bi.aD(this.xNB, ""));
            friendSnsPreference.Fv(0);
            if (bi.oN(this.xNB)) {
                as.Hm();
                if (((Boolean) com.tencent.mm.y.c.Db().get(589825, Boolean.valueOf(false))).booleanValue()) {
                    friendSnsPreference.Ft(R.k.dzD);
                    friendSnsPreference.Fu(0);
                    friendSnsPreference.Fw(8);
                } else {
                    friendSnsPreference.Fu(8);
                }
            } else {
                friendSnsPreference.Fu(0);
                as.Hm();
                friendSnsPreference.Fw(bi.a((Boolean) com.tencent.mm.y.c.Db().get(68384, null), true) ? 0 : 8);
                string = this.xNB;
                friendSnsPreference.yra = null;
                friendSnsPreference.yrb = -1;
                friendSnsPreference.zlG = string;
                if (friendSnsPreference.ori != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(friendSnsPreference.ori, string);
                }
            }
            if (n.qWD != null) {
                this.xNC = n.qWD.Tx();
            }
            if (this.xNC != 0) {
                friendSnsPreference.Fq(0);
                friendSnsPreference.dk(this.xNC, s.ge(getContext()));
            }
            friendSnsPreference.Fs(8);
            friendSnsPreference.Fr(8);
            com.tencent.mm.sdk.b.a.xmy.m(new rw());
            return;
        }
        this.xNy.bl("album_dyna_photo_ui_title", true);
    }

    private void cne() {
        x.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", Boolean.valueOf((this.qpN & 256) == 0), Boolean.valueOf(d.Pu("shake")));
        if (((this.qpN & 256) == 0) && r1) {
            boolean aR;
            this.xNL++;
            this.xNy.bl("find_friends_by_shake", false);
            IconPreference iconPreference = (IconPreference) this.xNy.Zu("find_friends_by_shake");
            int Tx = com.tencent.mm.be.l.TG().Tx() + q.a.bYL().bsf();
            if (Tx > 0) {
                iconPreference.Fq(0);
                iconPreference.dk(String.valueOf(Tx), R.g.bHe);
            } else {
                iconPreference.Fq(8);
                iconPreference.dk("", -1);
            }
            iconPreference.Fu(8);
            q.a.bYL().bsg();
            if (q.a.bYL().bsh()) {
                aR = com.tencent.mm.r.c.Bx().aR(262154, 266258);
            } else {
                aR = false;
            }
            if (aR) {
                as.Hm();
                String str = (String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                if (!TextUtils.isEmpty(str)) {
                    iconPreference.Fs(8);
                    iconPreference.Fq(0);
                    iconPreference.dk(str, R.g.bHe);
                } else if (Tx > 0) {
                    iconPreference.Fs(0);
                } else {
                    iconPreference.Fs(0);
                    iconPreference.Fq(8);
                    iconPreference.dk("", -1);
                }
            } else {
                iconPreference.Fs(8);
            }
            as.Hm();
            String aD = bi.aD((String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            as.Hm();
            Boolean valueOf = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            as.Hm();
            int intValue = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
            if (!valueOf.booleanValue() || aD == null || aD.equals("") || Tx > 0 || aR) {
                iconPreference.Fr(8);
                return;
            } else if (intValue == 0) {
                iconPreference.Fs(8);
                iconPreference.Fr(0);
                String[] split = aD.split(",");
                if (split.length > 0) {
                    iconPreference.af(split[0], -1, Color.parseColor("#8c8c8c"));
                }
                iconPreference.mD(true);
                iconPreference.Fv(8);
                return;
            } else if (intValue == 1) {
                iconPreference.Fr(8);
                iconPreference.Fq(0);
                iconPreference.yrl = true;
                return;
            } else {
                return;
            }
        }
        this.xNy.bl("find_friends_by_shake", true);
    }

    private void cnf() {
        x.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", Boolean.valueOf((this.qpN & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0), Boolean.valueOf(d.Pu("nearby")));
        if (((this.qpN & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0) && r3) {
            this.xNL++;
            this.xNy.bl("find_friends_by_near", false);
            IconPreference iconPreference = (IconPreference) this.xNy.Zu("find_friends_by_near");
            if (iconPreference != null) {
                com.tencent.mm.sdk.b.b ivVar = new iv();
                ivVar.fAg.fvo = 7;
                com.tencent.mm.sdk.b.a.xmy.m(ivVar);
                if (ivVar.fAh.fqR) {
                    iconPreference.Fu(8);
                } else {
                    iconPreference.Fu(0);
                    iconPreference.Ft(R.g.bDH);
                    iconPreference.fa(-2, -2);
                }
                int Tx = com.tencent.mm.be.l.TF().Tx();
                if (com.tencent.mm.bj.a.bYH()) {
                    if (Tx > 0) {
                        iconPreference.Fs(0);
                        return;
                    } else {
                        iconPreference.Fs(8);
                        return;
                    }
                } else if (Tx > 0) {
                    iconPreference.Fq(0);
                    iconPreference.dk(String.valueOf(Tx), s.ge(getContext()));
                    return;
                } else {
                    iconPreference.Fq(8);
                    iconPreference.dk("", -1);
                    return;
                }
            }
            return;
        }
        this.xNy.bl("find_friends_by_near", true);
    }

    protected final void cmk() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    }

    protected final void cml() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        if (as.Hp()) {
            com.tencent.mm.pluginsdk.d.a.b(iq.class.getName(), this.vzO);
            com.tencent.mm.pluginsdk.d.a.b(gs.class.getName(), this.xNR);
            com.tencent.mm.pluginsdk.d.a.b(pe.class.getName(), this.xNS);
            com.tencent.mm.sdk.b.a.xmy.c(this.xNP);
            com.tencent.mm.sdk.b.a.xmy.c(this.xNO);
            com.tencent.mm.sdk.b.a.xmy.c(this.xNQ);
            com.tencent.mm.sdk.b.a.xmy.c(this.rcw);
            com.tencent.mm.sdk.b.a.xmy.c(this.xNT);
            com.tencent.mm.sdk.b.a.xmy.c(this.qjh);
            com.tencent.mm.be.l.TG().j(this);
            as.Hm();
            com.tencent.mm.y.c.Fk().b(this);
            as.Hm();
            com.tencent.mm.y.c.b(this);
            as.Hm();
            com.tencent.mm.y.c.Db().b(this);
            if (this.xND != null) {
                o.PB().lh(this.xND);
            }
            if (this.xNG != null) {
                o.PB().lh(this.xNG);
            }
        }
        if (n.qWF != null) {
            n.qWF.b(this);
        }
    }

    protected final void cmm() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    }

    protected final void cmn() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    }

    public final void cmp() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    }

    public final void cmq() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    }

    public final void cms() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        Object obj = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cnv() == 2) {
            Object obj2 = null;
            if (this.status != com.tencent.mm.y.q.Gc()) {
                this.status = com.tencent.mm.y.q.Gc();
                obj2 = 1;
            }
            if (this.lrE != com.tencent.mm.y.q.Gd()) {
                this.lrE = com.tencent.mm.y.q.Gd();
                obj2 = 1;
            }
            if (this.qpN != com.tencent.mm.y.q.Gj()) {
                this.qpN = com.tencent.mm.y.q.Gj();
            } else {
                obj = obj2;
            }
            if (obj != null) {
                alq();
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        Object obj2 = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cnv() == 2) {
            Object obj3 = null;
            if (this.status != com.tencent.mm.y.q.Gc()) {
                this.status = com.tencent.mm.y.q.Gc();
                obj3 = 1;
            }
            if (this.lrE != com.tencent.mm.y.q.Gd()) {
                this.lrE = com.tencent.mm.y.q.Gd();
                obj3 = 1;
            }
            if (this.qpN != com.tencent.mm.y.q.Gj()) {
                this.qpN = com.tencent.mm.y.q.Gj();
            } else {
                obj2 = obj3;
            }
            if (obj2 != null) {
                alq();
            }
        }
    }

    public final void cng() {
        x.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                h.this.status = com.tencent.mm.y.q.Gc();
                h.this.qpN = com.tencent.mm.y.q.Gj();
                h.this.lrE = com.tencent.mm.y.q.Gd();
                h.this.alq();
            }
        });
        com.tencent.mm.plugin.aj.a.h.Ao(20);
    }

    public final void cnh() {
    }

    public final void Hc() {
        x.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((com.tencent.mm.y.q.Gj() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            if (n.qWD != null) {
                this.xNC = n.qWD.Tx();
            }
            cnd();
            this.xNy.notifyDataSetChanged();
        }
    }
}
