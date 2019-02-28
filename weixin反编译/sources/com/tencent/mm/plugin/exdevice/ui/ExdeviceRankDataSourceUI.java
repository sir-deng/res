package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.br;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI extends MMActivity implements e {
    private ListView Fv;
    private b mcv;

    private static class a {
        String mac;
        btf mcy;
        com.tencent.mm.plugin.exdevice.h.b mcz;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends BaseAdapter {
        private c lXC;
        List<a> mcA = new LinkedList();

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
            return pH(i);
        }

        public b() {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.g.bCb;
            this.lXC = aVar.PQ();
        }

        public final synchronized a zX(String str) {
            a aVar;
            if (!bi.oN(str)) {
                for (a aVar2 : this.mcA) {
                    if (str.equals(aVar2.mac)) {
                        break;
                    }
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final synchronized a cz(String str, String str2) {
            a aVar;
            for (a aVar2 : this.mcA) {
                if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.mcy)) {
                    break;
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final int getCount() {
            return this.mcA.size();
        }

        private a pH(int i) {
            return (a) this.mcA.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a pH = pH(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dhf, null);
                aVar2.lmk = (TextView) view.findViewById(R.h.cyF);
                aVar2.jIs = (ImageView) view.findViewById(R.h.coM);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            x.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), ExdeviceRankDataSourceUI.a(pH), pH.mac);
            aVar.lmk.setText(r1);
            o.PG().a(pH.mcy.nlA, aVar.jIs, this.lXC);
            return view;
        }
    }

    static /* synthetic */ a a(btf btf) {
        a aVar = new a();
        aVar.mcz = null;
        if (btf == null) {
            aVar.mcy = null;
        } else {
            aVar.mcy = btf;
        }
        return aVar;
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar == null || aVar.mcy == null) {
            return "";
        }
        if (!bi.oN(aVar.mcy.kyK)) {
            return aVar.mcy.kyK;
        }
        br brVar = aVar.mcz;
        String str = null;
        if (brVar == null) {
            return "";
        }
        if (!bi.oN(brVar.ggL)) {
            str = brVar.ggL;
        } else if (!bi.oN(brVar.ggM)) {
            str = brVar.ggM;
        } else if (brVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.cL(brVar.field_mac);
        } else if (!bi.oN(brVar.field_deviceID)) {
            str = brVar.field_deviceID;
        }
        return bi.oM(str);
    }

    static /* synthetic */ boolean a(String str, String str2, btf btf) {
        return (btf == null || str == null || str2 == null || !str.equals(btf.weM) || !str2.equals(btf.vQr)) ? false : true;
    }

    protected final int getLayoutId() {
        return R.i.dhg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceRankDataSourceUI.this.finish();
                return true;
            }
        });
        setMMTitle(R.l.dWp);
        as.CN().a(1267, (e) this);
        initView();
        as.CN().a(new q(), 0);
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctk);
        View inflate = View.inflate(this, R.i.dhi, null);
        View inflate2 = View.inflate(this, R.i.dhh, null);
        this.Fv.addHeaderView(inflate, null, false);
        this.Fv.addFooterView(inflate2, null, false);
        this.mcv = new b();
        this.Fv.setAdapter(this.mcv);
        ((ScrollView) findViewById(R.h.cJo)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ExdeviceRankDataSourceUI.this.startActivityForResult(new Intent(ExdeviceRankDataSourceUI.this.mController.xRr, ExdeviceAddDataSourceUI.class), 1);
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(1267, (e) this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                return;
            }
            String cL = com.tencent.mm.plugin.exdevice.j.b.cL(longExtra);
            if (cL == null) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", cL);
            } else if (this.mcv.zX(cL) != null) {
                x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
            } else {
                com.tencent.mm.plugin.exdevice.h.b cK = ad.aER().cK(longExtra);
                if (cK == null) {
                    x.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                } else if (this.mcv.cz(cK.field_deviceID, cK.field_deviceType) != null) {
                    x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                } else {
                    as.CN().a(1267, (e) this);
                    as.CN().a(new q(), 0);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
        } else if (kVar instanceof q) {
            as.CN().b(1267, (e) this);
            if (i == 0 && i2 == 0) {
                int size;
                agp agp = (agp) ((q) kVar).gLB.hnR.hnY;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                if (agp.wqu != null) {
                    size = agp.wqu.size();
                } else {
                    size = 0;
                }
                objArr[0] = Integer.valueOf(size);
                x.d(str2, str3, objArr);
                final List list = agp.wqu;
                runOnUiThread(new Runnable() {
                    public final void run() {
                        b b = ExdeviceRankDataSourceUI.this.mcv;
                        List<btf> list = list;
                        b.mcA.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (btf btf : list) {
                                if (btf != null) {
                                    b.mcA.add(ExdeviceRankDataSourceUI.a(btf));
                                }
                            }
                        }
                        ExdeviceRankDataSourceUI.this.mcv.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}
