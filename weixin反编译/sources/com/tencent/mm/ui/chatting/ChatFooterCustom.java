package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.af.d;
import com.tencent.mm.af.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.dv;
import com.tencent.mm.f.a.lz;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, com.tencent.mm.y.bt.a {
    public x fBc;
    private String jPV;
    private d kKo;
    private Object kOI;
    private LinearLayout lNK;
    public ChatFooter.d vwQ;
    private u xSC;
    private List<String> yzA;
    private final String yzB;
    private final String yzC;
    private j yzD;
    private ImageView yzs;
    public ImageView yzt;
    public g yzu;
    public com.tencent.mm.ui.chatting.b.c.a yzv;
    private int yzw;
    private bc yzx;
    private a yzy;
    private b yzz;

    private class a extends c<lz> {
        private a() {
            this.xmG = lz.class.getName().hashCode();
        }

        /* synthetic */ a(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            this.xmG = lz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lz lzVar = (lz) bVar;
            switch (lzVar.fEm.fEo) {
                case 0:
                    ChatFooterCustom.this.j(1005, lzVar);
                    break;
                case 1:
                    ChatFooterCustom.this.j(1006, lzVar);
                    break;
            }
            return false;
        }
    }

    private class b extends c<ma> {
        private b() {
            this.xmG = ma.class.getName().hashCode();
        }

        /* synthetic */ b(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            this.xmG = ma.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ma maVar = (ma) bVar;
            switch (maVar.fEq.fEo) {
                case 0:
                    ChatFooterCustom.this.j(1004, maVar);
                    break;
                case 1:
                    ChatFooterCustom.this.j(1003, maVar);
                    break;
            }
            return false;
        }
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lNK = null;
        this.yzs = null;
        this.yzt = null;
        this.yzu = null;
        this.vwQ = null;
        this.yzv = null;
        this.yzw = 0;
        this.yzA = new LinkedList();
        this.yzB = "qrcode";
        this.yzC = "barcode";
        this.kOI = new Object();
    }

    public final void a(u uVar, d dVar, String str) {
        com.tencent.mm.af.d.b.c LK = dVar.bK(false).LK();
        if (LK == null || LK.hqO == null || str == null) {
            throw new IllegalArgumentException(" menuInfo or username is null ! ");
        }
        this.yzw = Math.min(LK.hqO.size(), 6);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "setMenus, count:" + this.yzw);
        if (this.yzw <= 0) {
            throw new IllegalArgumentException(" mTabCount is invalid ! ");
        }
        if (this.yzw > 3) {
            this.yzs.setVisibility(0);
        } else {
            this.yzs.setVisibility(8);
        }
        this.lNK.setWeightSum((float) Math.min(this.yzw, 3));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            FrameLayout frameLayout = (FrameLayout) this.lNK.getChildAt(i2);
            TextView textView = (TextView) frameLayout.getChildAt(0).findViewById(R.h.bUb);
            frameLayout.getChildAt(0).findViewById(R.h.bUa).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(1);
            imageView.setVisibility(8);
            if (i2 < this.yzw) {
                j jVar = (j) LK.hqO.get(i2);
                frameLayout.setTag(jVar);
                textView.setText(i.a(getContext(), jVar.name));
                if (jVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i2 < 3 || this.yzw <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
            i = i2 + 1;
        }
        this.xSC = uVar;
        this.jPV = str;
        this.kKo = dVar;
        if (this.yzy != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.yzy);
        }
        if (this.yzz != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.yzz);
        }
        this.yzy = new a();
        this.yzz = new b();
        com.tencent.mm.sdk.b.a.xmy.b(this.yzy);
        com.tencent.mm.sdk.b.a.xmy.b(this.yzz);
    }

    public final void bBI() {
        if (this.yzy != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.yzy);
        }
        if (this.yzz != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.yzz);
        }
    }

    private void crX() {
        if (this.xSC != null && this.fBc != null && !t.oN(this.jPV)) {
            k.b(this.xSC, 9, this.jPV, this.fBc.field_username);
        }
    }

    private void crY() {
        File file = new File(e.gJf);
        if (!file.exists() && !file.mkdir()) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.dTp), 1).show();
        } else if (this.xSC != null && !k.a(this.xSC, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.eJI), 1).show();
        }
    }

    public final void crZ() {
        if (this.yzu != null) {
            this.yzu.csc();
        }
    }

    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            Object tag = view.getTag();
            if (tag instanceof j) {
                com.tencent.mm.pluginsdk.wallet.i.CU(8);
                j jVar = (j) tag;
                jVar.content = "";
                switch (jVar.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                        g gVar = this.yzu;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i = iArr[1];
                        if (!gVar.isShowing()) {
                            gVar.a(jVar, width, i, false);
                            break;
                        }
                        gVar.csc();
                        if (!(jVar == null || (gVar.yzL.id == jVar.id && gVar.yzL.aAM.equals(jVar.aAM)))) {
                            gVar.a(jVar, width, i, false);
                            break;
                        }
                    case 1:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "get latest message");
                        csb();
                        this.yzu.csc();
                        jVar.state = j.hrs;
                        b(jVar);
                        d(jVar);
                        this.yzv.ctZ();
                        break;
                    case 2:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "start webview url");
                        csb();
                        this.yzu.csc();
                        jVar.state = j.hrs;
                        b(jVar);
                        d(jVar);
                        if (!(com.tencent.mm.pluginsdk.q.a.vjg.b(getContext(), jVar.value, new Object[0]) || e.a(jVar.fMx, getContext(), this.xSC, this.jPV))) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.jPV);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.jPV);
                            intent.putExtra("preChatName", this.jPV);
                            intent.putExtra("preChatTYPE", com.tencent.mm.y.t.N(this.jPV, this.jPV));
                            intent.putExtra("rawUrl", jVar.value);
                            intent.putExtra("geta8key_username", this.jPV);
                            intent.putExtra("from_scence", 1);
                            com.tencent.mm.bl.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        }
                    case 3:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch to input");
                        this.yzu.csc();
                        csa();
                        jVar.state = j.hrs;
                        b(jVar);
                        d(jVar);
                        break;
                    case 4:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        csb();
                        this.yzu.csc();
                        jVar.state = j.hrt;
                        String str2 = jVar.id + jVar.aAM;
                        synchronized (this.kOI) {
                            this.yzA.add(str2);
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", str2, Integer.valueOf(this.yzA.size()));
                        g.pWK.h(10809, this.jPV, Integer.valueOf(jVar.id), jVar.aAM, j.hrt, "");
                        this.yzD = jVar;
                        Intent intent2;
                        com.tencent.mm.sdk.b.b dvVar;
                        switch (jVar.hrw) {
                            case 100:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", true);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.o.a.aV(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.at.a.Qq()) {
                                        com.tencent.mm.bl.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 101:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", false);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.o.a.aV(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.at.a.Qq()) {
                                        com.tencent.mm.bl.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 102:
                                crY();
                                break;
                            case 103:
                                as.Hm();
                                if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                                    com.tencent.mm.ui.base.u.fJ(getContext());
                                    break;
                                } else {
                                    h.a(getContext(), null, new String[]{getContext().getString(R.l.dQU), getContext().getString(R.l.dQT)}, null, new h.c() {
                                        public final void jo(int i) {
                                            switch (i) {
                                                case 0:
                                                    ChatFooterCustom.this.crY();
                                                    return;
                                                case 1:
                                                    ChatFooterCustom.this.crX();
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                    });
                                    break;
                                }
                            case 104:
                                crX();
                                break;
                            case 105:
                                Intent intent3 = new Intent();
                                intent3.putExtra("map_view_type", 0);
                                String str3 = "map_sender_name";
                                com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "getSender " + (this.yzx == null) + " " + (this.yzx == null ? q.FY() : this.yzx.name));
                                intent3.putExtra(str3, this.yzx == null ? q.FY() : this.yzx.name);
                                intent3.putExtra("map_talker_name", this.fBc == null ? null : this.fBc.field_username);
                                intent3.putExtra("view_type_key", 1);
                                intent3.putExtra("key_get_location_type", 1);
                                com.tencent.mm.bl.d.b(getContext(), "location", ".ui.RedirectUI", intent3);
                                break;
                            case 106:
                                dvVar = new dv();
                                dvVar.ftn.op = 1;
                                dvVar.ftn.userName = this.fBc.field_username;
                                dvVar.ftn.context = getContext();
                                com.tencent.mm.sdk.b.a.xmy.m(dvVar);
                                break;
                            case 107:
                                dvVar = new dv();
                                dvVar.ftn.op = 2;
                                dvVar.ftn.userName = this.fBc.field_username;
                                dvVar.ftn.context = getContext();
                                com.tencent.mm.sdk.b.a.xmy.m(dvVar);
                                break;
                        }
                        break;
                    case 5:
                        csb();
                        this.yzu.csc();
                        jVar.state = j.hrs;
                        b(jVar);
                        d(jVar);
                        if (!TextUtils.isEmpty(jVar.value)) {
                            try {
                                JSONObject jSONObject = new JSONObject(jVar.value);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1035;
                                appBrandStatObject.foi = this.jPV;
                                com.tencent.mm.plugin.appbrand.n.d dVar = (com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class);
                                Context context = getContext();
                                String optString = jSONObject.optString("userName");
                                String optString2 = jSONObject.optString("pagePath");
                                if (this.kKo != null) {
                                    str = this.kKo.field_appId;
                                }
                                dVar.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str);
                                break;
                            } catch (JSONException e) {
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }

    private boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        String str = jVar.id + jVar.aAM;
        synchronized (this.kOI) {
            int i;
            for (int i2 = 0; i2 < this.yzA.size(); i2++) {
                if (((String) this.yzA.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i >= 0) {
                this.yzA.remove(i);
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.yzA.size()));
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.yzA.size()));
            return false;
        }
    }

    private void b(j jVar) {
        g.pWK.h(10809, this.jPV, Integer.valueOf(jVar.id), jVar.aAM, j.hrs, "");
    }

    private void c(j jVar) {
        g.pWK.h(10809, this.jPV, Integer.valueOf(jVar.id), jVar.aAM, j.hru, jVar.content);
    }

    public final boolean j(int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case 201:
                case 203:
                    i = 1001;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX /*217*/:
                    i = 1002;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case 1001:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (!file.exists() || !file.isFile()) {
                            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", com.tencent.mm.a.g.i(file));
                        if (this.yzD != null && (this.yzD.hrw == 102 || this.yzD.hrw == 103)) {
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.yzD.state = j.hru;
                            this.yzD.e(arrayList);
                            if (a(this.yzD)) {
                                d(this.yzD);
                                c(this.yzD);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "return null path");
                    break;
                    break;
                case 1002:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "retrieving bitmap path %s", stringExtra);
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                    arrayList.add(com.tencent.mm.a.g.i(file2));
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", stringExtra);
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.yzD != null && (this.yzD.hrw == 104 || this.yzD.hrw == 103 || this.yzD.hrw == 102)) {
                            this.yzD.state = j.hru;
                            this.yzD.e(arrayList);
                            if (a(this.yzD)) {
                                d(this.yzD);
                                c(this.yzD);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    break;
                case 1003:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode wait msg");
                    if (ci(obj)) {
                        this.yzv.ctZ();
                        break;
                    }
                    break;
                case 1004:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode direct");
                    ci(obj);
                    break;
                case 1005:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send current");
                    ch(obj);
                    break;
                case 1006:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send selected");
                    ch(obj);
                    break;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        return true;
    }

    private boolean ch(Object obj) {
        if (obj instanceof lz) {
            lz lzVar = (lz) obj;
            double d = lzVar.fEm.lat;
            double d2 = lzVar.fEm.lng;
            int i = lzVar.fEm.fAq;
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), lzVar.fEm.label, lzVar.fEm.fEp);
            if (this.yzD == null || this.yzD.hrw != 105) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "cache lost or location type is not correct");
            } else {
                this.yzD.state = j.hru;
                j jVar = this.yzD;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", String.valueOf(d));
                    jSONObject.put("y", String.valueOf(d2));
                    jSONObject.put("scale", i);
                    jSONObject.put("label", r5);
                    jSONObject.put("poiname", r6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("location", jSONObject);
                    jVar.content = jSONObject2.toString();
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", jVar.content);
                } catch (JSONException e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
                }
                if (a(this.yzD)) {
                    d(this.yzD);
                    c(this.yzD);
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        }
        return true;
    }

    private boolean ci(Object obj) {
        if (obj instanceof ma) {
            ma maVar = (ma) obj;
            if (this.yzD == null || !(this.yzD.hrw == 100 || this.yzD.hrw == 101)) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "null pointer in cache or type error");
                return false;
            }
            Object obj2;
            switch (maVar.fEq.fEs) {
                case 0:
                    obj2 = "qrcode";
                    break;
                case 1:
                    obj2 = "barcode";
                    break;
                default:
                    obj2 = "";
                    break;
            }
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "scan type: %s , scan result:%s", obj2, maVar.fEq.scanResult);
            this.yzD.state = j.hru;
            j jVar = this.yzD;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "type is %s , result is %s", obj2, r3);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scan_type", obj2);
                jSONObject.put("scan_result", r3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_code", jSONObject);
                jVar.content = jSONObject2.toString();
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "content: %s", jVar.content);
            } catch (JSONException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
            }
            if (a(this.yzD)) {
                d(this.yzD);
                c(this.yzD);
            }
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        return false;
    }

    private void d(j jVar) {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", jVar.getInfo());
        as.CN().a(new com.tencent.mm.af.q(this.jPV, 1, jVar.getInfo(), null), 0);
    }

    public final void k(ViewGroup viewGroup) {
        this.lNK = (LinearLayout) findViewById(R.h.bTZ);
        this.yzt = (ImageView) findViewById(R.h.bUd);
        this.yzt.setVisibility(0);
        this.yzt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ChatFooterCustom.this.csa();
            }
        });
        this.yzs = (ImageView) findViewById(R.h.bTY);
        this.yzs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ChatFooterCustom.this.yzu.csc();
                ImageView imageView = (ImageView) view;
                int i;
                View childAt;
                int i2;
                if (imageView.getTag() == null) {
                    imageView.setTag(new Object());
                    imageView.setImageResource(R.g.bDM);
                    for (i = 0; i < ChatFooterCustom.this.yzw; i++) {
                        childAt = ChatFooterCustom.this.lNK.getChildAt(i);
                        if (i >= 3) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        childAt.setVisibility(i2);
                    }
                    return;
                }
                imageView.setTag(null);
                imageView.setImageResource(R.g.bDL);
                for (i = 0; i < ChatFooterCustom.this.yzw; i++) {
                    childAt = ChatFooterCustom.this.lNK.getChildAt(i);
                    if (i < 3) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    childAt.setVisibility(i2);
                }
            }
        });
        this.yzu = new g(getContext(), viewGroup);
        this.yzu.yzF = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ChatFooterCustom.this.onClick(view);
            }
        };
    }

    public final void a(com.tencent.mm.ad.d.a aVar) {
        String a = n.a(aVar.hoa.vNO);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "SysCmdMsgExtension:" + a);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!SlookAirButtonFrequentContactAdapter.DATA.equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!Columns.TYPE.equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
        }
    }

    private void csa() {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch footer");
        if (this.vwQ != null) {
            this.yzu.csc();
            this.vwQ.lu(true);
        }
    }

    private void csb() {
        if (this.fBc != null && this.fBc.fXs == 1) {
            as.Hm();
            com.tencent.mm.y.c.Fk().XJ(this.fBc.field_username);
        }
    }
}
