package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements e {
    private ListView Fv;
    BroadcastReceiver jle = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent != null) {
                String action = intent.getAction();
                x.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", action);
                int intExtra;
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lXX) {
                    intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra == 12) {
                        if (!ExdeviceBindDeviceGuideUI.this.lXu || ExdeviceBindDeviceGuideUI.this.lXt.isProviderEnabled("gps")) {
                            ExdeviceBindDeviceGuideUI.this.pv(2);
                            return;
                        }
                    } else if (intExtra == 10) {
                        ExdeviceBindDeviceGuideUI.this.pv(3);
                        return;
                    } else {
                        return;
                    }
                } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lXW) {
                    intExtra = intent.getIntExtra("wifi_state", -1);
                    x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", Integer.valueOf(intExtra));
                    if (intExtra == 3) {
                        ExdeviceBindDeviceGuideUI.this.pv(1);
                        return;
                    } else if (intExtra == 1) {
                        ExdeviceBindDeviceGuideUI.this.pv(5);
                        return;
                    } else {
                        return;
                    }
                } else if (!ExdeviceBindDeviceGuideUI.this.lXu || !"android.location.MODE_CHANGED".equals(action)) {
                    return;
                } else {
                    if (ExdeviceBindDeviceGuideUI.this.lXt.isProviderEnabled("gps")) {
                        if (com.tencent.mm.plugin.g.a.e.a.asc()) {
                            ExdeviceBindDeviceGuideUI.this.pv(2);
                            return;
                        } else {
                            ExdeviceBindDeviceGuideUI.this.pv(3);
                            return;
                        }
                    }
                }
                ExdeviceBindDeviceGuideUI.this.pv(6);
            }
        }
    };
    private String lRC;
    private String lRD;
    private String lWS;
    private a lXI;
    private Button lXJ;
    private Button lXK;
    private TextView lXL;
    private ScrollView lXM;
    private ImageView lXN;
    private TextView lXO;
    private String lXP;
    private String lXQ;
    private String lXR;
    private String lXS;
    private long lXT;
    private ArrayList<String> lXU;
    private String lXV;
    private boolean lXW = false;
    private boolean lXX = false;
    private String lXk;
    private String lXl;
    private TextView lXq;
    private LocationManager lXt;
    private boolean lXu = false;
    private String mTitle;
    private String st;

    private static final class a extends BaseAdapter {
        private ArrayList<String> lXZ;

        private static class a {
            TextView lYa;
            TextView lYb;
            View lYc;
            View lYd;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public a(ArrayList<String> arrayList) {
            this.lXZ = arrayList;
        }

        public final int getCount() {
            if (this.lXZ != null) {
                return this.lXZ.size();
            }
            return 0;
        }

        private String kF(int i) {
            if (this.lXZ == null || this.lXZ.size() <= 0) {
                return null;
            }
            return (String) this.lXZ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.lXZ == null || this.lXZ.size() <= 0) {
                return null;
            }
            a aVar;
            CharSequence kF = kF(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dgI, null);
                aVar2.lYb = (TextView) view.findViewById(R.h.bYL);
                aVar2.lYa = (TextView) view.findViewById(R.h.cPC);
                aVar2.lYc = view.findViewById(R.h.cSH);
                aVar2.lYd = view.findViewById(R.h.bOP);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.lYa.setText(Integer.toString(i + 1));
            aVar.lYb.setText(kF);
            if (i == 0 && this.lXZ.size() == 1) {
                aVar.lYc.setVisibility(4);
                aVar.lYd.setVisibility(4);
                return view;
            } else if (i == 0) {
                aVar.lYc.setVisibility(4);
                aVar.lYd.setVisibility(0);
                return view;
            } else if (i != this.lXZ.size() - 1) {
                return view;
            } else {
                aVar.lYd.setVisibility(4);
                aVar.lYc.setVisibility(0);
                return view;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgJ;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceBindDeviceGuideUI.this.finish();
                return true;
            }
        });
        if (!(!f.fN(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", VERSION.RELEASE);
            this.lXu = true;
        }
        Intent intent = getIntent();
        this.lXP = intent.getStringExtra("device_scan_mode");
        this.lXQ = intent.getStringExtra("device_scan_conn_proto");
        this.lRD = intent.getStringExtra("device_id");
        this.lWS = intent.getStringExtra("device_type");
        this.lXR = intent.getStringExtra("device_title");
        this.lXk = intent.getStringExtra("device_desc");
        this.lXl = intent.getStringExtra("device_icon_url");
        this.st = intent.getStringExtra("device_category_id");
        this.lRC = intent.getStringExtra("device_brand_name");
        this.lXS = intent.getStringExtra("bind_ticket");
        this.lXT = intent.getLongExtra("device_ble_simple_proto", -1);
        this.lXU = intent.getStringArrayListExtra("device_airkiss_steps");
        this.lXV = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", Integer.valueOf(this.lXU.size()));
        this.lXt = (LocationManager) this.mController.xRr.getSystemService("location");
        this.Fv = (ListView) findViewById(R.h.bYK);
        View inflate = View.inflate(this, R.i.dgD, null);
        this.lXL = (TextView) inflate.findViewById(R.h.cSn);
        this.lXI = new a(this.lXU);
        this.Fv.addHeaderView(inflate);
        this.Fv.setDividerHeight(0);
        this.Fv.setClickable(false);
        this.Fv.setFooterDividersEnabled(false);
        this.Fv.setAdapter(this.lXI);
        this.lXN = (ImageView) findViewById(R.h.cuB);
        this.lXM = (ScrollView) findViewById(R.h.coe);
        this.lXJ = (Button) findViewById(R.h.bXa);
        this.lXK = (Button) findViewById(R.h.cAk);
        this.lXq = (TextView) findViewById(R.h.ceL);
        this.lXO = (TextView) findViewById(R.h.ceM);
        String str = "";
        if (this.lXP.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.lXQ.contains("wifi")) {
            this.lXW = true;
            str = this.mController.xRr.getString(R.l.dgO);
        } else if (this.lXQ.contains("blue")) {
            this.lXX = true;
            str = this.mController.xRr.getString(R.l.ecK);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lXX && !this.lXW) {
            if (!com.tencent.mm.plugin.g.a.e.a.cp(this.mController.xRr)) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                pv(4);
            } else if (!com.tencent.mm.plugin.g.a.e.a.asc()) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                pv(3);
            } else if (!(this.lXt == null || !this.lXu || this.lXt.isProviderEnabled("gps"))) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                pv(6);
            }
            this.lXJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lXP);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lXQ);
                    intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lRD);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lWS);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lXR);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lXk);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.lXl);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.st);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lRC);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lXS);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.lXT);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.lXV);
                    intent.putExtra("jumpToBindDevice", true);
                    if (ExdeviceBindDeviceGuideUI.this.lXX && !ExdeviceBindDeviceGuideUI.this.lXW) {
                        d.b(ExdeviceBindDeviceGuideUI.this.mController.xRr, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (ExdeviceBindDeviceGuideUI.this.lXW && !ExdeviceBindDeviceGuideUI.this.lXX) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        d.b(ExdeviceBindDeviceGuideUI.this.mController.xRr, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                }
            });
            this.lXK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (ExdeviceBindDeviceGuideUI.this.lXW && !ExdeviceBindDeviceGuideUI.this.lXX) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lXP);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lXQ);
                        intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lRD);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lWS);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lXR);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lXk);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.lXl);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.st);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lRC);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lXS);
                        d.b(ExdeviceBindDeviceGuideUI.this.mController.xRr, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                }
            });
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.xRr.registerReceiver(this.jle, intentFilter);
        }
        if (!this.lXX && this.lXW && !ao.isWifi(this.mController.xRr)) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            pv(5);
            this.lXJ.setOnClickListener(/* anonymous class already generated */);
            this.lXK.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.xRr.registerReceiver(this.jle, intentFilter);
        } else if (!this.lXW || this.lXX) {
            if (this.lXX && !this.lXW) {
                pv(2);
            }
            this.lXJ.setOnClickListener(/* anonymous class already generated */);
            this.lXK.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.xRr.registerReceiver(this.jle, intentFilter);
        } else {
            pv(1);
            this.lXJ.setOnClickListener(/* anonymous class already generated */);
            this.lXK.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.xRr.registerReceiver(this.jle, intentFilter);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mController.xRr.unregisterReceiver(this.jle);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    private void pv(int i) {
        switch (i) {
            case 1:
                this.lXJ.setText(this.mController.xRr.getString(R.l.dgO));
                this.lXK.setText(this.mController.xRr.getString(R.l.ecG));
                this.lXL.setText(this.mController.xRr.getString(R.l.edc));
                break;
            case 2:
                this.lXJ.setText(this.mController.xRr.getString(R.l.ecW));
                this.lXK.setVisibility(8);
                this.lXL.setText(this.mController.xRr.getString(R.l.ecV));
                break;
            case 3:
                this.lXN.setImageResource(R.k.dwu);
                this.lXq.setText(R.l.ecS);
                this.lXO.setText(R.l.ecH);
                break;
            case 4:
                this.lXN.setImageResource(R.k.dwu);
                this.lXq.setText(R.l.ecQ);
                this.lXO.setText("");
                break;
            case 5:
                this.lXN.setImageResource(R.k.dBW);
                this.lXq.setText(R.l.ecS);
                this.lXO.setText(R.l.ecO);
                break;
            case 6:
                this.lXN.setImageResource(R.k.dwu);
                this.lXq.setText(R.l.ecS);
                this.lXO.setText(R.l.edt);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.lXN.setVisibility(8);
                this.lXq.setVisibility(8);
                this.lXO.setVisibility(8);
                this.Fv.setVisibility(0);
                this.lXM.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.lXN.setVisibility(0);
                this.lXq.setVisibility(0);
                this.Fv.setVisibility(8);
                this.lXM.setVisibility(8);
                if (i == 4) {
                    this.lXO.setVisibility(8);
                    return;
                } else {
                    this.lXO.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
