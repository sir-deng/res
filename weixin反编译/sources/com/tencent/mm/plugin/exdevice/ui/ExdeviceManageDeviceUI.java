package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.dc;
import com.tencent.mm.f.b.br;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView Fv;
    private a maA;

    private static final class a extends BaseAdapter implements e {
        private d kNb;
        private c lXC;
        private List<b> lXo;
        boolean maC;
        private WeakReference<Context> maD;
        private OnClickListener maE;
        private l maF;
        private volatile int maG = -1;
        private r tipDialog = null;

        private static class a {
            ImageView jIs;
            TextView lmk;
            View maJ;
            View maK;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        static /* synthetic */ void a(Context context, b bVar) {
            Intent intent = new Intent();
            intent.putExtra("device_type", bVar.field_deviceType);
            intent.putExtra("device_id", bVar.field_deviceID);
            intent.putExtra("device_mac", bVar.field_mac);
            intent.putExtra("device_brand_name", bVar.field_brandName);
            intent.putExtra("device_desc", bVar.ggN);
            intent.putExtra("device_title", bVar.ggM);
            intent.putExtra("device_icon_url", bVar.iconUrl);
            intent.putExtra("device_alias", bVar.ggL);
            intent.putExtra("device_jump_url", bVar.jumpUrl);
            intent.putExtra("subscribe_flag", 1);
            com.tencent.mm.bl.d.b(context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent, 1000);
        }

        static /* synthetic */ void a(a aVar, final b bVar) {
            if (bVar != null && aVar.maD != null) {
                Context context = (Context) aVar.maD.get();
                if (context == null) {
                    x.e("MicroMsg.ExdeviceManageDeviceUI", "context is null.");
                    return;
                }
                context.getString(R.l.dGZ);
                aVar.tipDialog = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                as.Dt().F(new Runnable() {
                    public final void run() {
                        ake ake = new ake();
                        ake.kyJ = bVar.field_deviceID;
                        ake.vQr = bVar.field_deviceType;
                        as.CN().a(new com.tencent.mm.plugin.exdevice.model.x(ake, 2), 0);
                    }
                });
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return pF(i);
        }

        public a(Context context) {
            this.maD = new WeakReference(context);
            this.lXo = new LinkedList();
            this.maF = new l(context);
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.g.bCa;
            this.lXC = aVar.PQ();
            this.kNb = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    x.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", Integer.valueOf(itemId), Integer.valueOf(a.this.getCount()));
                    if (itemId >= 0 && itemId < r1) {
                        a.this.maG = itemId;
                        a.a(a.this, (b) a.this.lXo.get(itemId));
                        a.this.notifyDataSetChanged();
                    }
                }
            };
            this.maE = new OnClickListener() {
                public final void onClick(View view) {
                    if (!a.this.maC) {
                        Object tag = view.getTag();
                        if (tag != null && (tag instanceof Integer)) {
                            int intValue = ((Integer) tag).intValue();
                            if (intValue >= 0 && intValue < a.this.getCount()) {
                                b pF = a.this.pF(intValue);
                                Context context = (Context) a.this.maD.get();
                                if (context == null) {
                                    x.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                                } else {
                                    a.a(context, pF);
                                }
                            }
                        }
                    }
                }
            };
            aF(ad.aER().aFw());
        }

        public final void aF(List<b> list) {
            this.lXo.clear();
            if (list != null && list.size() != 0) {
                this.lXo.addAll(list);
            }
        }

        public final int getCount() {
            return this.lXo.size();
        }

        public final b pF(int i) {
            return (b) this.lXo.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            br pF = pF(i);
            if (view == null) {
                aVar = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dgV, null);
                aVar.maJ = view.findViewById(R.h.bYH);
                aVar.lmk = (TextView) view.findViewById(R.h.cyF);
                aVar.maK = view.findViewById(R.h.caN);
                aVar.jIs = (ImageView) view.findViewById(R.h.coM);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (pF == null) {
                charSequence = "";
            } else {
                String cL = !bi.oN(pF.ggL) ? pF.ggL : !bi.oN(pF.ggM) ? pF.ggM : pF.field_mac != 0 ? com.tencent.mm.plugin.exdevice.j.b.cL(pF.field_mac) : !bi.oN(pF.field_deviceID) ? pF.field_deviceID : null;
                charSequence = bi.oM(cL);
            }
            x.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), charSequence, Long.valueOf(pF.field_mac));
            aVar.lmk.setText(charSequence);
            o.PG().a(pF.iconUrl, aVar.jIs, this.lXC);
            aVar.maK.setTag(Integer.valueOf(i));
            if (this.maC) {
                aVar.maK.setVisibility(0);
            } else {
                aVar.maK.setVisibility(8);
            }
            aVar.maJ.setTag(Integer.valueOf(i));
            aVar.maJ.setOnClickListener(this.maE);
            return view;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar == null) {
                x.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
            } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0 && this.maG >= 0 && this.maG < this.lXo.size()) {
                    ah.y(new Runnable() {
                        public final void run() {
                            a.this.lXo.remove(a.this.maG);
                            a.this.notifyDataSetChanged();
                            a.this.maG = -1;
                        }
                    });
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceManageDeviceUI.this.finish();
                return true;
            }
        });
        setMMTitle(R.l.edy);
        com.tencent.mm.sdk.b.b dcVar = new dc();
        dcVar.fsq.fsr = true;
        com.tencent.mm.sdk.b.a.xmy.m(dcVar);
        initView();
        as.CN().a(537, this.maA);
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctk);
        this.maA = new a(this);
        View.inflate(this, R.i.dgM, null);
        this.Fv.setAdapter(this.maA);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.maA.aF(ad.aER().aFw());
        this.maA.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(537, this.maA);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.maA.maC) {
            return super.onKeyDown(i, keyEvent);
        }
        updateOptionMenuText(0, getString(R.l.dEQ));
        a aVar = this.maA;
        if (aVar.maC) {
            aVar.maC = false;
            ah.y(new Runnable() {
                public final void run() {
                    a.this.notifyDataSetChanged();
                }
            });
        }
        return true;
    }
}
