package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.c.ada;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements com.tencent.mm.ad.e, com.tencent.mm.plugin.exdevice.model.e.b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ListView Fv;
    private ProgressDialog inI;
    private ScrollView jmE;
    private TextView kZc;
    private String lRC;
    private com.tencent.mm.plugin.exdevice.model.j.a lSp;
    private String lWS;
    private TextView lXq;
    private TextView lXr;
    private a lYe;
    private View lYf;
    private TextView lYg;
    private ImageView lYh;
    private View lYi;
    private int lYj;
    private String lYk;
    private String lYl;
    private boolean lYm = false;
    private com.tencent.mm.plugin.exdevice.model.j.a lYn;
    private boolean lYo = false;
    private boolean lYp = false;

    private class d {
        public String lRD;
        public String lWS;

        private d() {
        }

        /* synthetic */ d(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    private enum e {
        ;

        static {
            lYF = 1;
            lYG = 2;
            lYH = 3;
            lYI = new int[]{lYF, lYG, lYH};
        }
    }

    private class f {
        public String lXS;
        public boolean lYJ;
        public int lYK;
        public c lYL;
        public d lYM;
        public ake lYN;
        public akf lYO;
        public int lYP;
        public asc lYQ;
        public String lYR;

        private f() {
            this.lYJ = false;
            this.lYK = b.lYB;
        }

        /* synthetic */ f(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }

        public final String getKey() {
            if (this.lYK == b.lYB) {
                return this.lYM.lWS + this.lYM.lRD;
            }
            return this.lYL.bpq;
        }

        public final String aFA() {
            if (this.lYK != b.lYB) {
                return this.lYL.bpq;
            }
            if (this.lYO == null) {
                return null;
            }
            return this.lYO.vSj;
        }
    }

    private static final class a extends BaseAdapter {
        private com.tencent.mm.ap.a.a.c lXC;
        private String lYA;
        List<f> lYx = new ArrayList();
        private String lYy;
        private int lYz;

        private static class a {
            ImageView jIs;
            TextView lmk;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return py(i);
        }

        public a(String str, int i, String str2) {
            this.lYy = str;
            this.lYz = i;
            this.lYA = str2;
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFE = R.e.btQ;
            this.lXC = aVar.PQ();
        }

        public final void aFz() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lYx.size()) {
                    f fVar = (f) this.lYx.get(i2);
                    fVar.lYJ = c(fVar);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public final boolean b(f fVar) {
            if (zU(fVar.getKey()) < 0) {
                return false;
            }
            fVar.lYJ = c(fVar);
            return true;
        }

        public final boolean zS(String str) {
            return zU(str) >= 0;
        }

        public final f zT(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lYx.size()) {
                    return null;
                }
                f fVar = (f) this.lYx.get(i2);
                if (!zV(fVar.aFA()) && str.equalsIgnoreCase(fVar.aFA())) {
                    return fVar;
                }
                i = i2 + 1;
            }
        }

        public final int getCount() {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 >= this.lYx.size()) {
                    return i3;
                }
                if (((f) this.lYx.get(i2)).lYJ) {
                    i3++;
                }
                i = i2 + 1;
            }
        }

        public final f py(int i) {
            int i2 = 0;
            int i3 = -1;
            while (true) {
                int i4 = i2;
                if (i4 >= this.lYx.size()) {
                    return null;
                }
                if (((f) this.lYx.get(i4)).lYJ) {
                    i3++;
                }
                if (i3 == i) {
                    return (f) this.lYx.get(i4);
                }
                i2 = i4 + 1;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            View view2;
            f py = py(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dgK, null);
                aVar2.lmk = (TextView) view.findViewById(R.h.cyF);
                aVar2.jIs = (ImageView) view.findViewById(R.h.coM);
                view.setTag(aVar2);
                aVar = aVar2;
                view2 = view;
            } else {
                aVar = (a) view.getTag();
                view2 = view;
            }
            if (py == null || py.lYO == null) {
                Assert.assertTrue(false);
                return view2;
            }
            String str;
            String str2;
            Object obj;
            CharSequence spannableString;
            if (py.lYK == b.lYC) {
                x.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", Integer.valueOf(i), py.lYL.lYE, py.lYL.bpq, py.lYO.wyb);
                str = "";
                str2 = py.lYO.ggT;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (py.lYL.bpq != null && py.lYL.bpq.length() >= 4) {
                    str = py.lYL.bpq;
                    str = str.substring(str.length() - 4, str.length());
                }
                obj = py.lYO.wyb + " " + str;
                spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.bsO)), py.lYO.wyb.length() + 1, obj.length(), 17);
                aVar.lmk.setText(spannableString);
            } else if (py.lYK == b.lYB) {
                str = "";
                str2 = py.lYO.ggT;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (py.lYO.vSj != null && py.lYO.vSj.length() >= 4) {
                    str = py.lYO.vSj;
                    str = str.substring(str.length() - 4, str.length());
                }
                obj = py.lYO.wyb + " " + str;
                spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.bsO)), py.lYO.wyb.length() + 1, obj.length(), 17);
                aVar.lmk.setText(spannableString);
            } else {
                Assert.assertTrue(false);
            }
            str = py.lYO.nlA;
            if (!zV(str)) {
                o.PG().a(str, aVar.jIs, this.lXC);
            }
            return view2;
        }

        private int zU(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lYx.size()) {
                    return -1;
                }
                if (((f) this.lYx.get(i2)).getKey().compareTo(str) == 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        final int cy(String str, String str2) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lYx.size()) {
                    return -1;
                }
                f fVar = (f) this.lYx.get(i2);
                String str3 = fVar.lYN != null ? fVar.lYN.vQr : fVar.lYK == b.lYB ? fVar.lYM.lWS : null;
                String str4 = fVar.lYN != null ? fVar.lYN.kyJ : fVar.lYK == b.lYB ? fVar.lYM.lRD : null;
                if (!zV(str3) && !zV(str4) && str.compareTo(str3) == 0 && str2.compareTo(str4) == 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        final boolean c(f fVar) {
            if (fVar.lYO == null) {
                return false;
            }
            if (this.lYz == e.lYH) {
                if (fVar.lYO.wxU == null || fVar.lYO.wxU.compareTo(this.lYy) != 0 || fVar.lYO.wyd == null || fVar.lYO.wyd.compareTo(this.lYA) != 0) {
                    return false;
                }
            } else if (this.lYz != e.lYG) {
                Assert.assertTrue(false);
                return false;
            } else if (fVar.lYO.ggP == 0) {
                return false;
            }
            return true;
        }

        private static boolean zV(String str) {
            return str == null || str.length() == 0;
        }
    }

    enum b {
        ;

        static {
            lYB = 1;
            lYC = 2;
            lYD = new int[]{lYB, lYC};
        }
    }

    private class c {
        public String bpq;
        public String lYE;

        private c() {
        }

        /* synthetic */ c(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, k kVar) {
        f zT;
        if (kVar instanceof p) {
            if (exdeviceBindDeviceUI.inI != null && exdeviceBindDeviceUI.inI.isShowing()) {
                exdeviceBindDeviceUI.inI.dismiss();
            }
            exdeviceBindDeviceUI.lYm = false;
            p pVar = (p) kVar;
            if (!(i == 0 && i2 == 0)) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
            exdeviceBindDeviceUI.lYl = ((ada) pVar.gLB.hnR.hnY).wst;
            String str2 = exdeviceBindDeviceUI.lYl;
            if (bi.oN(str2)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bl.d.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
        } else if (kVar instanceof t) {
            bfo aEN = ((t) kVar).aEN();
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            } else if (aEN.vSJ == null) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
            } else {
                zT = exdeviceBindDeviceUI.lYe.zT(aEN.vSJ.vSj);
                if (zT == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                } else if (zT.lYN != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                } else {
                    zT.lYO = aEN.vSJ;
                    zT.lYN = aEN.vSI;
                    zT.lXS = aEN.vSo;
                    zT.lYQ = aEN.vSp;
                    exdeviceBindDeviceUI.lYe.b(zT);
                    exdeviceBindDeviceUI.lYe.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", aEN.vSI.vQr, aEN.vSI.kyJ, aEN.vSJ.wyb, aEN.vSJ.vSj, Integer.valueOf(aEN.vSJ.ggP));
                }
            }
        } else if (!(kVar instanceof v)) {
        } else {
            if (i == 0 && i2 == 0) {
                bgs bgs = (bgs) ((v) kVar).gLB.hnR.hnY;
                if (bgs.vSI == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                    return;
                }
                a aVar = exdeviceBindDeviceUI.lYe;
                String str3 = bgs.vSI.vQr;
                String str4 = bgs.vSI.kyJ;
                if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                    zT = null;
                } else {
                    int cy = aVar.cy(str3, str4);
                    zT = cy < 0 ? null : (f) aVar.lYx.get(cy);
                }
                if (zT == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    return;
                } else if (zT.lYN != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    return;
                } else {
                    zT.lYO = bgs.vSJ;
                    zT.lYN = bgs.vSI;
                    zT.lXS = bgs.vSo;
                    zT.lYQ = bgs.vSp;
                    exdeviceBindDeviceUI.lYe.b(zT);
                    exdeviceBindDeviceUI.lYe.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", bgs.vSI.vQr, bgs.vSI.kyJ, bgs.vSJ.wyb, Integer.valueOf(bgs.vSJ.ggP));
                    return;
                }
            }
            x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        akf akf = fVar.lYO;
        intent.putExtra("device_mac", akf.vSj);
        intent.putExtra("device_brand_name", akf.wxU);
        intent.putExtra("device_desc", akf.wyc);
        intent.putExtra("device_title", akf.wyb);
        intent.putExtra("device_icon_url", akf.nlA);
        intent.putExtra("device_alias", akf.hxj);
        intent.putExtra("device_jump_url", akf.nkN);
        intent.putExtra("bind_ticket", fVar.lXS);
        intent.putExtra("device_type", fVar.lYN.vQr);
        intent.putExtra("device_id", fVar.lYN.kyJ);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.lYP);
        if (fVar.lYK == b.lYC) {
            intent.putExtra("device_ble_simple_proto", akf.ggQ);
        } else if (fVar.lYK != b.lYB) {
            Assert.assertTrue(false);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
        } else if (fVar.lYQ == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
        } else {
            asc asc = fVar.lYQ;
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(n.a(asc.wfM));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.lYN.kyJ);
            intent.putExtra("device_type", fVar.lYN.vQr);
            intent.putExtra("Contact_User", n.a(asc.wfM));
            intent.putExtra("Contact_Scene", asc.wfb);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.lXS);
            if (Xv != null) {
                if (!com.tencent.mm.k.a.ga(Xv.field_type)) {
                    intent.putExtra("Contact_Alias", asc.hxj);
                    intent.putExtra("Contact_Nick", asc.wzM.toString());
                    intent.putExtra("Contact_Signature", asc.hxh);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(asc.hxn, asc.hxf, asc.hxg));
                    intent.putExtra("Contact_Sex", asc.hxe);
                    intent.putExtra("Contact_VUser_Info", asc.wCr);
                    intent.putExtra("Contact_VUser_Info_Flag", asc.wCq);
                    intent.putExtra("Contact_KWeibo_flag", asc.wCu);
                    intent.putExtra("Contact_KWeibo", asc.wCs);
                    intent.putExtra("Contact_KWeiboNick", asc.wCt);
                    if (asc.wCx != null) {
                        try {
                            intent.putExtra("Contact_customInfo", asc.wCx.toByteArray());
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.bl.d.b(exdeviceBindDeviceUI.mController.xRr, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceBindDeviceUI.this.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.lYk = intent.getStringExtra("device_category_id");
        this.lRC = intent.getStringExtra("device_brand_name");
        this.lWS = intent.getStringExtra("device_type");
        if (this.lWS == null || this.lWS.length() == 0) {
            this.lWS = this.lRC;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (bi.oN(stringExtra3)) {
            stringExtra3 = this.mController.xRr.getString(R.l.edm);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.lYj = e.lYG;
            str = this.mController.xRr.getString(R.l.ecD);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.lYj = e.lYH;
            str = this.mController.xRr.getString(R.l.ecB);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lYj == e.lYH) {
            this.lYo = stringExtra.contains("wifi");
            this.lYp = stringExtra.contains("blue");
            x.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", Boolean.valueOf(this.lYo), Boolean.valueOf(this.lYp));
        } else if (this.lYj == e.lYG) {
            this.lYp = true;
            this.lYo = true;
        }
        this.lSp = new com.tencent.mm.plugin.exdevice.model.j.a() {
            public final void e(int i, Object... objArr) {
                Throwable e;
                if (i == 10 && objArr != null) {
                    String string;
                    String string2;
                    String string3;
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            string3 = jSONObject2.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                            string3 = null;
                        }
                        try {
                            if (!jSONObject.isNull("manufacturerData")) {
                                string2 = jSONObject.getString("manufacturerData");
                                if (string != null && string3 != null) {
                                    final f fVar = new f(ExdeviceBindDeviceUI.this, (byte) 0);
                                    fVar.lYK = b.lYB;
                                    fVar.lYM = new d(ExdeviceBindDeviceUI.this, (byte) 0);
                                    fVar.lYM.lWS = string;
                                    fVar.lYM.lRD = string3;
                                    if (bi.oN(string2)) {
                                        fVar.lYR = null;
                                    } else {
                                        fVar.lYR = Base64.encodeToString(string2.getBytes(), 2);
                                        x.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", fVar.lYR);
                                    }
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            ExdeviceBindDeviceUI.this.a(fVar);
                                        }
                                    });
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            x.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            string2 = null;
                            if (string != null) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        string3 = null;
                        string = null;
                    }
                    string2 = null;
                    if (string != null) {
                    }
                }
            }
        };
        this.lYn = new com.tencent.mm.plugin.exdevice.model.j.a() {
            public final void e(int i, Object... objArr) {
            }
        };
        initView();
        this.kZc.setText(this.mController.xRr.getString(R.l.edW, new Object[]{stringExtra3}));
        as.CN().a(1264, (com.tencent.mm.ad.e) this);
        as.CN().a(1706, (com.tencent.mm.ad.e) this);
        as.CN().a(1270, (com.tencent.mm.ad.e) this);
        as.CN().a(1719, (com.tencent.mm.ad.e) this);
        if (this.lYp) {
            ad.aFc().a((com.tencent.mm.plugin.exdevice.model.e.b) this);
        }
        if (this.lYo) {
            j.aEI().a(10, this.lSp);
            j.aEI().a(11, this.lYn);
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.lYp) {
            ad.aFc();
            com.tencent.mm.plugin.exdevice.model.e.aEE();
        }
        if (this.lYo) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.lYe.aFz();
        this.lYe.notifyDataSetChanged();
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctk);
        View inflate = View.inflate(this, R.i.dgN, null);
        this.lYi = View.inflate(this, R.i.dhp, null);
        this.lYf = this.lYi.findViewById(R.h.cKn);
        this.kZc = (TextView) this.lYi.findViewById(R.h.cSg);
        this.lYg = (TextView) findViewById(R.h.cIV);
        this.lYh = (ImageView) findViewById(R.h.cuB);
        this.lXq = (TextView) findViewById(R.h.ceL);
        this.lXr = (TextView) findViewById(R.h.ceM);
        this.jmE = (ScrollView) findViewById(R.h.cbu);
        this.Fv.addHeaderView(inflate, null, false);
        this.Fv.addFooterView(this.lYi, null, false);
        this.lYe = new a(this.lRC, this.lYj, this.lYk);
        this.Fv.setAdapter(this.lYe);
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f py = ExdeviceBindDeviceUI.this.lYe.py(i - ((ListView) adapterView).getHeaderViewsCount());
                if (py.lYO.ggP != 0) {
                    ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, py);
                } else {
                    ExdeviceBindDeviceUI.b(ExdeviceBindDeviceUI.this, py);
                }
            }
        });
        if (this.lYp && !this.lYo) {
            if (!com.tencent.mm.plugin.g.a.e.a.cp(this.mController.xRr)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                pv(4);
                return;
            } else if (!com.tencent.mm.plugin.g.a.e.a.asc()) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                pv(3);
                return;
            }
        }
        if (!this.lYp && this.lYo && !ao.isWifi(this.mController.xRr)) {
            x.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            pv(5);
        } else if (this.lYj == e.lYG) {
            pv(0);
        } else if (this.lYj != e.lYH) {
            int i = e.lYF;
            Assert.assertTrue(false);
        } else if (this.lYp && this.lYo) {
            Assert.assertTrue(false);
            pv(1);
        } else if (this.lYp) {
            pv(2);
        } else if (this.lYo) {
            pv(1);
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.lYo) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.lYp) {
            ad.aFd().arM();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lYo) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    Java2CExDevice.stopScanWCLanDevice();
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            j.aEI().b(10, this.lSp);
            j.aEI().b(11, this.lYn);
        }
        if (this.lYp) {
            ad.aFc().b(this);
            ad.aFd().arM();
        }
        as.CN().b(1264, (com.tencent.mm.ad.e) this);
        as.CN().b(1706, (com.tencent.mm.ad.e) this);
        as.CN().b(1270, (com.tencent.mm.ad.e) this);
        as.CN().b(1719, (com.tencent.mm.ad.e) this);
    }

    public final void k(String str, String str2, boolean z) {
        x.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (bi.oN(str2)) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            return;
        }
        final f fVar = new f();
        fVar.lYK = b.lYC;
        fVar.lYL = new c();
        fVar.lYL.lYE = str;
        fVar.lYL.bpq = com.tencent.mm.plugin.exdevice.j.b.cM(com.tencent.mm.plugin.exdevice.j.b.Aa(str2));
        ah.y(new Runnable() {
            public final void run() {
                ExdeviceBindDeviceUI.this.a(fVar);
            }
        });
    }

    public final void c(String str, int i, long j) {
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            return;
        }
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final k kVar2 = kVar;
        ah.y(new Runnable() {
            public final void run() {
                ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, i3, i4, str2, kVar2);
            }
        });
    }

    final void a(f fVar) {
        if (!this.lYe.zS(fVar.getKey())) {
            x.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.aFA());
            a aVar = this.lYe;
            if (!(fVar == null || aVar.zS(fVar.getKey()))) {
                fVar.lYJ = aVar.c(fVar);
                aVar.lYx.add(fVar);
            }
            this.lYe.notifyDataSetChanged();
            if (fVar.lYK == b.lYC) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", fVar.lYL.bpq, this.lRC, this.lYk);
                as.CN().a(new t(fVar.lYL.bpq, this.lRC, this.lYk), 0);
            } else if (fVar.lYK == b.lYB) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", fVar.lYM.lWS, fVar.lYM.lRD);
                as.CN().a(new v(fVar.lYM.lWS, fVar.lYM.lRD, fVar.lYR), 0);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lYe.aFz();
        this.lYe.notifyDataSetChanged();
    }

    private void pv(int i) {
        String string;
        String string2;
        CharSequence spannableString;
        switch (i) {
            case 0:
                string = getString(R.l.ecJ);
                CharSequence spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(R.e.btd), 0, string.length(), 33);
                spannableString2.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.exdevice.model.f.V(ExdeviceBindDeviceUI.this.mController.xRr, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, 0, string.length(), 33);
                this.lYg.setMovementMethod(LinkMovementMethod.getInstance());
                this.lYg.setText(spannableString2);
                break;
            case 1:
                string = getString(R.l.ecM);
                string2 = getString(R.l.dgO);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.btd), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        ExdeviceBindDeviceUI.this.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.lYg.setMovementMethod(LinkMovementMethod.getInstance());
                this.lYg.setText(spannableString);
                break;
            case 2:
                string = getString(R.l.ecL);
                string2 = getString(R.l.ecK);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.btd), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        ExdeviceBindDeviceUI.this.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.lYg.setMovementMethod(LinkMovementMethod.getInstance());
                this.lYg.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.lYh.setImageResource(R.k.dwu);
                this.lXq.setText(R.l.ecS);
                this.lXr.setText(R.l.ecH);
                break;
            case 4:
                this.lYh.setImageResource(R.k.dwu);
                this.lXq.setText(R.l.ecQ);
                this.lXr.setText("");
                break;
            case 5:
                this.lYh.setImageResource(R.k.dBW);
                this.lXq.setText(R.l.ecS);
                this.lXr.setText(R.l.ecO);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.lYf.setVisibility(0);
                this.Fv.setVisibility(0);
                this.lYg.setVisibility(0);
                this.lYh.setVisibility(8);
                this.lXq.setVisibility(8);
                this.lXr.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
                this.jmE.setVisibility(8);
                this.lYf.setVisibility(8);
                this.Fv.setVisibility(8);
                this.lYg.setVisibility(8);
                this.lYh.setVisibility(0);
                this.lXq.setVisibility(0);
                if (i == 4) {
                    this.lXr.setVisibility(8);
                    return;
                } else {
                    this.lXr.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
