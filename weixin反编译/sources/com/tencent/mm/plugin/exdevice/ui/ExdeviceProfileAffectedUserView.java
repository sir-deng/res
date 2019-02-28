package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.i;
import com.tencent.mm.ac.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.y.q;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    String jPV;
    private TextView mbb;
    private MMHorList mbc;
    private a mbd;
    private ArrayList<String> mbe;

    private class a extends BaseAdapter {
        private Runnable mbg;

        class a {
            ImageView hxJ;

            a() {
            }
        }

        private a() {
            this.mbg = new Runnable() {
                public final void run() {
                    a.this.notifyDataSetChanged();
                }
            };
        }

        /* synthetic */ a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public final int getCount() {
            return ExdeviceProfileAffectedUserView.this.mbe == null ? 0 : ExdeviceProfileAffectedUserView.this.mbe.size();
        }

        private String kF(int i) {
            return (String) ExdeviceProfileAffectedUserView.this.mbe.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String kF = kF(i);
            if (view == null) {
                view = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(R.i.dhd, viewGroup, false);
                a aVar2 = new a();
                aVar2.hxJ = (ImageView) view.findViewById(R.h.bLD);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            Runnable runnable = this.mbg;
            i JW = n.JW();
            if (JW != null) {
                h jp = JW.jp(kF);
                if (jp == null || bi.oN(jp.JN())) {
                    com.tencent.mm.y.ak.a.hhv.a(kF, "", new com.tencent.mm.plugin.exdevice.model.f.AnonymousClass1(bi.Wy(), runnable));
                }
            }
            b.p(aVar.hxJ, kF);
            return view;
        }
    }

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dgY, this, true);
        this.mbb = (TextView) inflate.findViewById(R.h.cDS);
        this.mbc = (MMHorList) inflate.findViewById(R.h.cDR);
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(context, 44);
        this.mbc.ykp = true;
        this.mbc.ykq = fromDPToPix;
        this.mbc.yko = true;
        this.mbd = new a();
        this.mbc.setAdapter(this.mbd);
        this.mbc.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) adapterView.getAdapter().getItem(i);
                x.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", str);
                if (bi.oN(str)) {
                    x.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", str);
                context.startActivity(intent);
            }
        });
        this.mbb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String FY = q.FY();
                if (FY != null && FY.equals(ExdeviceProfileAffectedUserView.this.jPV)) {
                    ExdeviceProfileAffectedUserView.this.mbc.setVisibility(ExdeviceProfileAffectedUserView.this.mbc.getVisibility() == 0 ? 8 : 0);
                }
            }
        });
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ExdeviceProfileAffectedUserView.this.mbb.performClick();
            }
        });
        setVisibility(8);
    }

    public final void v(ArrayList<String> arrayList) {
        this.mbe = arrayList;
        if (this.mbe == null || this.mbe.size() == 0) {
            this.mbb.setText("");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mbb.setText(getResources().getString(R.l.edI, new Object[]{Integer.valueOf(this.mbe.size())}));
        this.mbd.notifyDataSetChanged();
    }
}
