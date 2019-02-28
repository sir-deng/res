package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    String jPV;
    private String mAppName;
    private Context mContext;
    c maL;
    private boolean maM;
    boolean maN;
    int maO;
    int maP;
    ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> maQ;
    List<ju> maR;
    private View maS;

    class e {
        ImageView lpW;
        View maV;
        NoMeasuredTextView maZ;
        TextView mba;

        e() {
        }
    }

    class f {
        ImageView lpW;

        f() {
        }
    }

    class b {
        TextView maU;
        View maW;

        b() {
        }
    }

    class d {
        Button maY;

        d() {
        }
    }

    class a {
        ImageView lXN;
        TextView maU;
        View maV;

        a() {
        }
    }

    class c {
        ImageView lXN;
        TextView maU;
        View maV;
        View maX;

        c() {
        }
    }

    public a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.jPV = str2;
        this.maM = z;
        this.mAppName = str;
    }

    public final int getCount() {
        if (this.maM) {
            return (this.maO + 5) + this.maP;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.maM) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.maO + 1) {
                return 1;
            }
            if (i == this.maO + 2) {
                return 2;
            }
            if (i == this.maO + 3) {
                return 5;
            }
            if (i <= this.maO + 3 || i > (this.maO + 3) + this.maP) {
                return i == (this.maO + this.maP) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        b bVar;
        b bVar2 = null;
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    bVar = null;
                    break;
                case 1:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    bVar = null;
                    break;
                case 2:
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 3:
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 4:
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    break;
                case 5:
                    view.getTag();
                    bVar = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar = null;
                    bVar2 = (b) view.getTag();
                    break;
                case 7:
                    bVar = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                if (this.maS == null) {
                    this.maS = LayoutInflater.from(this.mContext).inflate(R.i.dhb, viewGroup, false);
                }
                view = this.maS;
                f fVar2 = new f();
                fVar2.lpW = (ImageView) view.findViewById(R.h.cfi);
                view.setTag(fVar2);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = fVar2;
                cVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dha, viewGroup, false);
                e eVar2 = new e();
                eVar2.maZ = (NoMeasuredTextView) view.findViewById(R.h.cfs);
                eVar2.mba = (TextView) view.findViewById(R.h.cft);
                eVar2.lpW = (ImageView) view.findViewById(R.h.cfq);
                eVar2.maV = view.findViewById(R.h.cfr);
                eVar2.maZ.O(this.mContext.getResources().getDimension(R.f.buS));
                eVar2.maZ.setTextColor(this.mContext.getResources().getColor(R.e.bsk));
                eVar2.maZ.cqk();
                eVar2.maZ.yoG = true;
                view.setTag(eVar2);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = eVar2;
                fVar = null;
                cVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgX, viewGroup, false);
                a aVar2 = new a();
                aVar2.maU = (TextView) view.findViewById(R.h.cfm);
                aVar2.maV = view.findViewById(R.h.cfk);
                aVar2.lXN = (ImageView) view.findViewById(R.h.cfl);
                view.setTag(aVar2);
                bVar = null;
                aVar = aVar2;
                dVar = null;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgX, viewGroup, false);
                cVar = new c();
                cVar.maU = (TextView) view.findViewById(R.h.cfm);
                cVar.maV = view.findViewById(R.h.cfk);
                cVar.lXN = (ImageView) view.findViewById(R.h.cfl);
                cVar.maX = view.findViewById(R.h.cfj);
                view.setTag(cVar);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(R.i.cfp, viewGroup, false);
                d dVar2 = new d();
                dVar2.maY = (Button) view.findViewById(R.h.cfp);
                view.setTag(dVar2);
                bVar = null;
                aVar = null;
                dVar = dVar2;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgZ, viewGroup, false);
                view.setTag(new b());
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgZ, viewGroup, false);
                b bVar3 = new b();
                bVar3.maU = (TextView) view.findViewById(R.h.cfo);
                view.setTag(bVar3);
                bVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                b bVar4 = bVar3;
                cVar = null;
                bVar2 = bVar4;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgZ, viewGroup, false);
                bVar = new b();
                bVar.maW = view.findViewById(R.h.cfn);
                view.setTag(bVar);
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                com.tencent.mm.pluginsdk.ui.a.b.p(fVar.lpW, this.jPV);
                fVar.lpW.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", a.this.jPV);
                        com.tencent.mm.bl.d.b(a.this.mContext, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                break;
            case 1:
                if (i - 2 >= 0 && !bi.cC(this.maQ)) {
                    com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = (com.tencent.mm.plugin.exdevice.f.b.a.c) this.maQ.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        final String str = cVar2.field_username;
                        if (cVar2.field_step >= 10000) {
                            eVar.mba.setTextColor(this.mContext.getResources().getColor(R.e.bsj));
                        } else {
                            eVar.mba.setTextColor(this.mContext.getResources().getColor(R.e.bsi));
                        }
                        eVar.maZ.setText(i.b(this.mContext, r.gw(str), eVar.maZ.gu.getTextSize()));
                        eVar.mba.setText(String.valueOf(i2));
                        com.tencent.mm.pluginsdk.ui.a.b.o(eVar.lpW, str);
                        eVar.maV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                Context b = a.this.mContext;
                                Intent intent = new Intent(b, ExdeviceProfileUI.class);
                                intent.putExtra("username", str);
                                b.startActivity(intent);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                aVar.maU.setText(this.mContext.getResources().getText(R.l.edG));
                aVar.lXN.setImageResource(R.k.dyA);
                aVar.maV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.maL != null) {
                            a.this.maL.aFN();
                        }
                    }
                });
                break;
            case 3:
                if ((i - this.maO) - 4 >= 0 && !bi.cC(this.maR)) {
                    ju juVar = (ju) this.maR.get((i - this.maO) - 4);
                    if (juVar != null) {
                        CharSequence charSequence = juVar.title;
                        String str2 = juVar.fED;
                        final String str3 = juVar.url;
                        cVar.maU.setText(charSequence);
                        if ((i - this.maO) - 4 != this.maP - 1) {
                            cVar.maX.setVisibility(0);
                        }
                        com.tencent.mm.plugin.exdevice.f.a.e.a(this.mContext, cVar.lXN, str2, R.e.brW);
                        cVar.maV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                com.tencent.mm.plugin.sport.b.d.qq(8);
                                com.tencent.mm.plugin.exdevice.model.f.V(a.this.mContext, str3);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.maN) {
                    as.Hm();
                    if (com.tencent.mm.y.c.Ff().Xr(this.jPV)) {
                        dVar.maY.setVisibility(0);
                        dVar.maY.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                if (a.this.maL != null) {
                                    a.this.maL.aFO();
                                }
                            }
                        });
                        break;
                    }
                }
                dVar.maY.setVisibility(4);
                break;
            case 6:
                bVar2.maU.setText(this.mContext.getString(R.l.edM));
                break;
            case 7:
                bVar.maW.setVisibility(0);
                break;
        }
        return view;
    }
}
