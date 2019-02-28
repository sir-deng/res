package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;
import java.util.Map;

public class AppGrid extends GridView {
    Context context;
    private SharedPreferences hbz;
    OnItemClickListener kMo = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppGrid.this.vvm.a(AppGrid.this.vvm.Cw((AppGrid.this.vvq * AppGrid.this.vvo) + i), AppGrid.this.vvs.yy(i));
        }
    };
    OnItemLongClickListener mzB = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b c = AppGrid.this.vvm;
            int Cw = AppGrid.this.vvm.Cw((AppGrid.this.vvq * AppGrid.this.vvo) + i);
            AppGrid.this.vvs.yy(i);
            c.Cx(Cw);
            return true;
        }
    };
    b vvm;
    int vvn;
    int vvo = 0;
    int vvp = 0;
    int vvq;
    int vvr;
    a vvs;

    public interface b {
        int Cw(int i);

        void Cx(int i);

        void a(int i, f fVar);
    }

    class a extends BaseAdapter {
        List<f> idy;
        private int vvu;
        private int vvv;
        private Map<String, f> vvw = null;

        class a {
            ImageView jSg;
            TextView jSh;
            TextView vvx;
            View vvy;
            View vvz;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return yy(i);
        }

        public a(Context context, List<f> list, Map<String, f> map) {
            this.idy = list;
            this.vvw = map;
            this.vvu = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 56.0f);
            this.vvv = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 53.3f);
        }

        public final int getCount() {
            if (AppGrid.this.vvq == AppGrid.this.vvp - 1) {
                return AppGrid.this.vvn - (AppGrid.this.vvq * AppGrid.this.vvo);
            }
            return AppGrid.this.vvo;
        }

        public final f yy(int i) {
            if ((i < AppGrid.this.vvr && AppGrid.this.vvq == 0) || (AppGrid.this.vvq * AppGrid.this.vvo) + i < AppGrid.this.vvr || (i - AppGrid.this.vvr) + (AppGrid.this.vvq * AppGrid.this.vvo) >= this.idy.size()) {
                return null;
            }
            x.v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf((i - AppGrid.this.vvr) + (AppGrid.this.vvq * AppGrid.this.vvo)));
            return (f) this.idy.get((i - AppGrid.this.vvr) + (AppGrid.this.vvq * AppGrid.this.vvo));
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a();
                view = View.inflate(AppGrid.this.context, R.i.dax, null);
                aVar.jSg = (ImageView) view.findViewById(R.h.bKu);
                aVar.vvy = view.findViewById(R.h.bKv);
                aVar.jSh = (TextView) view.findViewById(R.h.bKw);
                aVar.vvx = (TextView) view.findViewById(R.h.bKx);
                aVar.vvz = view.findViewById(R.h.bKy);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            x.v("MicroMsg.AppGrid", "pos:" + i + " page:" + AppGrid.this.vvq);
            aVar.jSh.setVisibility(0);
            aVar.vvz.setVisibility(8);
            aVar.vvx.setVisibility(8);
            aVar.vvy.setVisibility(0);
            LayoutParams layoutParams = aVar.jSg.getLayoutParams();
            layoutParams.width = this.vvu;
            layoutParams.height = this.vvu;
            aVar.jSg.setLayoutParams(layoutParams);
            int a = (AppGrid.this.vvq * AppGrid.this.vvo) + i;
            int Cw = AppGrid.this.vvm.Cw(a);
            if (a < AppGrid.this.vvr) {
                switch (Cw) {
                    case 0:
                        aVar.jSg.setImageResource(R.k.dAo);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFj));
                        break;
                    case 1:
                        if (!r.igH) {
                            aVar.jSg.setImageResource(R.k.dAh);
                            aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFh));
                            break;
                        }
                        aVar.jSg.setImageResource(R.k.dAq);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFn));
                        break;
                    case 2:
                        aVar.jSg.setImageResource(R.k.dvV);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFr));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(54, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 3:
                        aVar.jSg.setImageResource(R.k.dAn);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFs));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(81, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    case 4:
                        aVar.jSg.setImageResource(R.k.dAs);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFs));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(62, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            break;
                        } catch (Exception e3) {
                            break;
                        }
                    case 5:
                        aVar.jSg.setImageResource(R.k.dAt);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFo));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(67, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                    case 6:
                        aVar.jSg.setImageResource(R.k.dAm);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFg));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(290817, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvz.setVisibility(8);
                                break;
                            }
                            aVar.vvz.setVisibility(0);
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    case 7:
                        a(aVar, f.vkP);
                        break;
                    case 8:
                        a(aVar, f.vkN);
                        break;
                    case 9:
                        a(aVar, f.vkQ);
                        break;
                    case 10:
                        aVar.jSg.setImageResource(R.k.dAr);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.epd));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(73, Boolean.valueOf(false))).booleanValue()) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    case 11:
                        aVar.jSg.setImageResource(R.k.dAl);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFb));
                        break;
                    case 12:
                        aVar.jSg.setImageResource(R.k.dAj);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFe));
                        break;
                    case 13:
                        aVar.jSg.setImageResource(R.k.dvU);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.ebl));
                        try {
                            as.Hm();
                            boolean booleanValue = ((Boolean) c.Db().get(208899, Boolean.valueOf(false))).booleanValue();
                            as.Hm();
                            boolean booleanValue2 = ((Boolean) c.Db().get(208913, Boolean.valueOf(false))).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                aVar.vvx.setVisibility(8);
                                break;
                            }
                            aVar.vvx.setVisibility(0);
                            if (!booleanValue2) {
                                aVar.vvx.setText(R.l.dGa);
                                break;
                            }
                            aVar.vvx.setText(R.l.dFx);
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                        break;
                    case 14:
                        aVar.jSg.setImageResource(R.k.dAp);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFm));
                        try {
                            as.Hm();
                            if (!((Boolean) c.Db().get(327744, Boolean.valueOf(true))).booleanValue()) {
                                aVar.vvz.setVisibility(8);
                                break;
                            }
                            aVar.vvz.setVisibility(0);
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    case 15:
                        aVar.jSg.setImageResource(R.k.dAi);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFd));
                        try {
                            aVar.vvz.setVisibility(8);
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                    case 16:
                        aVar.jSg.setImageResource(R.k.dAk);
                        aVar.jSh.setText(AppGrid.this.context.getString(R.l.dFf));
                        break;
                }
            }
            layoutParams.width = this.vvv;
            layoutParams.height = this.vvv;
            aVar.jSg.setLayoutParams(layoutParams);
            f yy = yy(i);
            if (yy != null) {
                as.Hm();
                if (c.isSDCardAvailable()) {
                    Bitmap b;
                    if (yy.field_status == 5) {
                        b = g.b(yy.field_appId, 3, com.tencent.mm.bu.a.getDensity(AppGrid.this.context));
                    } else if (yy.bZq()) {
                        b = g.b(yy.field_appId, 4, com.tencent.mm.bu.a.getDensity(AppGrid.this.context));
                    } else {
                        b = g.b(yy.field_appId, 1, com.tencent.mm.bu.a.getDensity(AppGrid.this.context));
                    }
                    if (b != null) {
                        aVar.jSg.setBackgroundDrawable(new BitmapDrawable(b));
                    } else if (f.vkN.equals(yy.field_appId)) {
                        aVar.jSg.setImageResource(R.g.bEB);
                    } else if (f.vkP.equals(yy.field_appId)) {
                        aVar.jSg.setImageResource(R.g.bEA);
                    } else if (f.vkO.equals(yy.field_appId)) {
                        aVar.jSg.setImageResource(R.g.bEz);
                    } else if (f.vkQ.equals(yy.field_appId)) {
                        aVar.jSg.setImageResource(R.k.dAg);
                    } else {
                        aVar.jSg.setBackgroundResource(R.g.byX);
                    }
                } else {
                    aVar.jSg.setBackgroundResource(R.g.bGf);
                }
                aVar.jSh.setText(g.a(AppGrid.this.context, yy, null));
                if ((yy.bZq() && yy.bZr()) || yy.bZs()) {
                    if (AppGrid.this.hbz == null) {
                        AppGrid.this.hbz = AppGrid.this.context.getSharedPreferences(ad.cgf(), 0);
                    }
                    if (AppGrid.this.hbz.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + yy.field_appId, true)) {
                        aVar.vvx.setVisibility(0);
                    }
                }
            }
            f yy2 = yy(i);
            if (yy2 != null && g.j(yy2)) {
                aVar.vvx.setVisibility(0);
            }
            return view;
        }

        private void a(a aVar, String str) {
            if (this.vvw == null) {
                x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                return;
            }
            f fVar = (f) this.vvw.get(str);
            if (fVar == null) {
                x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                return;
            }
            as.Hm();
            if (c.isSDCardAvailable()) {
                Bitmap b;
                if (fVar.bZq()) {
                    b = g.b(fVar.field_appId, 4, com.tencent.mm.bu.a.getDensity(AppGrid.this.context));
                } else {
                    b = null;
                }
                if (b != null) {
                    aVar.jSg.setBackgroundDrawable(new BitmapDrawable(b));
                } else if (f.vkN.equals(fVar.field_appId)) {
                    aVar.jSg.setImageResource(R.g.bEB);
                } else if (f.vkP.equals(fVar.field_appId)) {
                    aVar.jSg.setImageResource(R.g.bEA);
                } else if (f.vkO.equals(fVar.field_appId)) {
                    aVar.jSg.setImageResource(R.g.bEz);
                } else if (f.vkQ.equals(fVar.field_appId)) {
                    aVar.jSg.setImageResource(R.k.dAg);
                } else {
                    aVar.jSg.setImageResource(R.g.byX);
                }
            } else {
                aVar.jSg.setImageResource(R.g.bGf);
            }
            aVar.jSh.setText(g.a(AppGrid.this.context, fVar, null));
            if (fVar.bZq() && fVar.bZr()) {
                if (AppGrid.this.hbz == null) {
                    AppGrid.this.hbz = AppGrid.this.context.getSharedPreferences(ad.cgf(), 0);
                }
                if (AppGrid.this.hbz.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                    aVar.vvx.setVisibility(0);
                }
            }
            int intValue;
            if (f.vkN.equals(fVar.field_appId)) {
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue > 1) {
                    as.Hm();
                    if (!bi.F(((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                        aVar.vvx.setVisibility(0);
                    }
                }
            } else if (f.vkP.equals(fVar.field_appId)) {
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue > 1) {
                    as.Hm();
                    if (!bi.F(((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                        aVar.vvx.setVisibility(0);
                    }
                }
            }
        }
    }

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public int getCount() {
        return this.vvs.getCount();
    }
}
