package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c extends o<com.tencent.mm.plugin.masssend.a.a> {
    private static short osR = (short) 1;
    private static short osS = (short) 2;
    private static short osT = (short) 3;
    private static short osU = (short) 4;
    private MMActivity fnF;
    int hLP;
    int las;
    private LayoutInflater ntf;
    private short[] osV;
    private List<String> osW;
    String osX = "";
    e osY;

    class a implements OnClickListener {
        private String fileName;
        private int osy;

        public a(String str, int i) {
            this.fileName = str;
            this.osy = i;
        }

        public final void onClick(View view) {
            x.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.y.c.Fp()).append(this.fileName).toString();
                if (stringBuilder2 == null || stringBuilder2.equals("") || !com.tencent.mm.a.e.bO(stringBuilder2)) {
                    x.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_compress_type", this.osy);
                intent.putExtra("key_favorite", false);
                intent.putExtra("key_image_path", stringBuilder2);
                com.tencent.mm.plugin.masssend.a.ihN.d(c.this.fnF, intent);
                return;
            }
            u.fJ(c.this.fnF);
        }
    }

    class c implements OnClickListener {
        private String fileName;
        private int length;
        private int osx;
        private int size;

        public c(String str, int i, int i2, int i3) {
            this.fileName = str;
            this.osx = i;
            this.length = i3;
            this.size = i2;
        }

        public final void onClick(View view) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                boolean z = this.osx == 2;
                com.tencent.mm.modelvideo.o.Ub();
                x.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", this.fileName, Boolean.valueOf(z), Boolean.valueOf(q.nq(s.nx(this.fileName))));
                com.tencent.mm.plugin.masssend.a.ihN.a(z, r2, c.this.fnF, this.fileName, this.length, this.size);
                return;
            }
            u.fJ(c.this.fnF);
        }
    }

    class d implements OnClickListener {
        private String id;

        public d(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            x.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
            if (c.this.osY != null) {
                c.this.osX = c.this.osY.EO(this.id);
                c.this.notifyDataSetChanged();
            }
        }
    }

    static class f {
        ImageView myi;
        TextView nub;
        TextView ota;
        TextView otb;
        TextView otc;
        TextView otd;
        TextView ote;
        AnimImageView otf;
        View otg;
        short oth;

        f() {
        }
    }

    class b implements OnClickListener {
        private String id;

        public b(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.masssend.a.a EK = h.aZj().EK(this.id);
            Intent intent = new Intent(c.this.fnF, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", EK.aZe());
            intent.putExtra("mass_send_again", true);
            c.this.fnF.startActivity(intent);
        }
    }

    interface e {
        String EO(String str);
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.masssend.a.a();
        }
        aVar.b(cursor);
        return aVar;
    }

    public c(Context context) {
        super(context, new com.tencent.mm.plugin.masssend.a.a());
        this.fnF = (MMActivity) context;
        this.osW = new LinkedList();
        this.las = 10;
        this.hLP = this.las;
        this.ntf = v.fw(context);
    }

    protected final void XI() {
        XH();
    }

    public final boolean awL() {
        return this.las >= this.hLP;
    }

    public final void XH() {
        int i;
        Cursor a = h.aZj().hiZ.a("SELECT count(*) FROM massendinfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        this.hLP = i;
        com.tencent.mm.plugin.masssend.a.b aZj = h.aZj();
        int i2 = this.las;
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        x.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
        setCursor(aZj.hiZ.a(str, null, 0));
        i = getCount();
        if (i > 0) {
            this.osV = new short[i];
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        com.tencent.mm.plugin.masssend.a.a aVar;
        CharSequence charSequence;
        int i2;
        com.tencent.mm.plugin.masssend.a.a aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
        if (i != 0) {
            long j = ((com.tencent.mm.plugin.masssend.a.a) getItem(i - 1)).hXs;
            aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
            long j2 = aVar2.hXs;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.osV[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.osV[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.osV[i] = (short) 1;
            aVar = aVar2;
        }
        obj = (this.osV[i] != (short) 1 || aVar.hXs <= 1000) ? null : 1;
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).oth != osR) {
                    view = this.ntf.inflate(R.i.dnh, null);
                    fVar.ota = (TextView) view.findViewById(R.h.cvj);
                    fVar.otb = (TextView) view.findViewById(R.h.cvl);
                    fVar.otc = (TextView) view.findViewById(R.h.cvm);
                    fVar.ote = (TextView) view.findViewById(R.h.cvh);
                    fVar.nub = (TextView) view.findViewById(R.h.cvr);
                    fVar.otg = view.findViewById(R.h.cvi);
                    fVar.oth = osR;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).oth != osS) {
                    view = this.ntf.inflate(R.i.dng, null);
                    fVar.ota = (TextView) view.findViewById(R.h.cvj);
                    fVar.otb = (TextView) view.findViewById(R.h.cvl);
                    fVar.myi = (ImageView) view.findViewById(R.h.cvn);
                    fVar.ote = (TextView) view.findViewById(R.h.cvh);
                    fVar.nub = (TextView) view.findViewById(R.h.cvr);
                    fVar.otg = view.findViewById(R.h.cvi);
                    fVar.oth = osS;
                    view.setTag(fVar);
                    break;
                }
            case 34:
                fVar = new f();
                if (view == null || ((f) view.getTag()).oth != osU) {
                    view = this.ntf.inflate(R.i.dnj, null);
                    fVar.ota = (TextView) view.findViewById(R.h.cvj);
                    fVar.otb = (TextView) view.findViewById(R.h.cvl);
                    fVar.otd = (TextView) view.findViewById(R.h.cvk);
                    fVar.otc = (TextView) view.findViewById(R.h.cvq);
                    fVar.otf = (AnimImageView) view.findViewById(R.h.cvp);
                    fVar.ote = (TextView) view.findViewById(R.h.cvh);
                    fVar.nub = (TextView) view.findViewById(R.h.cvr);
                    fVar.otg = view.findViewById(R.h.cvi);
                    fVar.oth = osU;
                    view.setTag(fVar);
                    break;
                }
            case org.xwalk.core.R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                fVar = new f();
                if (view == null || ((f) view.getTag()).oth != osT) {
                    view = this.ntf.inflate(R.i.dni, null);
                    fVar.ota = (TextView) view.findViewById(R.h.cvj);
                    fVar.otb = (TextView) view.findViewById(R.h.cvl);
                    fVar.myi = (ImageView) view.findViewById(R.h.cvn);
                    fVar.otd = (TextView) view.findViewById(R.h.cvo);
                    fVar.ote = (TextView) view.findViewById(R.h.cvh);
                    fVar.nub = (TextView) view.findViewById(R.h.cvr);
                    fVar.otg = view.findViewById(R.h.cvi);
                    fVar.oth = osT;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.nub.setVisibility(0);
            fVar2.nub.setText(n.c(this.fnF, aVar.hXs, false));
        } else {
            fVar2.nub.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.otc.setText(aVar.aZc());
                i.f(fVar2.otc, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                as.Hm();
                if (com.tencent.mm.y.c.isSDCardAvailable()) {
                    h.aZj();
                    Bitmap EJ = com.tencent.mm.plugin.masssend.a.b.EJ(aVar.aZc());
                    if (EJ != null) {
                        fVar2.myi.setImageBitmap(EJ);
                    } else {
                        h.aZj();
                        fVar2.myi.setImageBitmap(com.tencent.mm.plugin.masssend.a.b.a(aVar.aZd(), com.tencent.mm.bu.a.getDensity(fVar2.myi.getContext())));
                    }
                } else {
                    fVar2.myi.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.g.bEj));
                }
                fVar2.myi.setOnClickListener(new a(aVar.aZc(), aVar.osy));
                break;
            case 34:
                fVar2 = (f) view.getTag();
                float bw = com.tencent.mm.modelvoice.q.bw((long) aVar.osu);
                if (aVar.aZb().equals(this.osX)) {
                    fVar2.otf.setVisibility(0);
                    fVar2.otf.cpw();
                    fVar2.otc.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.otf.setVisibility(8);
                    fVar2.otf.bnQ();
                    fVar2.otc.setCompoundDrawablesWithIntrinsicBounds(null, null, this.fnF.getResources().getDrawable(R.k.dxV), null);
                }
                fVar2.otd.setText(this.fnF.getString(R.l.ejB, new Object[]{Integer.valueOf((int) bw)}));
                fVar2.otc.setWidth(com.tencent.mm.bu.a.fromDPToPix(fVar2.otc.getContext(), nJ((int) bw)));
                fVar2.otf.setWidth(com.tencent.mm.bu.a.fromDPToPix(fVar2.otc.getContext(), nJ((int) bw)));
                fVar2.otc.setOnClickListener(new d(aVar.aZb()));
                break;
            case org.xwalk.core.R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                f fVar3 = (f) view.getTag();
                com.tencent.mm.modelvideo.o.Ub();
                Bitmap a = com.tencent.mm.ap.o.PC().a(s.ny(aVar.aZc()), com.tencent.mm.bu.a.getDensity(fVar3.myi.getContext()), this.fnF);
                if (a == null) {
                    as.Hm();
                    if (com.tencent.mm.y.c.isSDCardAvailable()) {
                        fVar3.myi.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.e.bsI));
                    } else {
                        fVar3.myi.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.dBH));
                    }
                } else {
                    fVar3.myi.setImageBitmap(a);
                }
                fVar3.myi.setOnClickListener(new c(aVar.aZc(), aVar.osx, aVar.feh, aVar.osu));
                if (aVar.osx != 2) {
                    fVar3.otd.setVisibility(0);
                    fVar3.otd.setText(bi.iZ(aVar.osu));
                    break;
                }
                fVar3.otd.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.ota.setText(this.fnF.getResources().getQuantityString(R.j.duL, aVar.ost, new Object[]{Integer.valueOf(aVar.ost)}));
        if (this.osW.contains(aVar.aZb())) {
            fVar2.otb.setSingleLine(false);
            fVar2.otb.setEllipsize(null);
        } else {
            fVar2.otb.setSingleLine(true);
            fVar2.otb.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.otb;
        Context context = this.fnF;
        ArrayList arrayList = new ArrayList();
        if (aVar.aZe() == null || aVar.aZe().equals("")) {
            charSequence = "";
        } else {
            List F;
            String[] split = aVar.aZe().split(";");
            if (split == null || split.length <= 0) {
                Object F2 = arrayList;
            } else {
                F2 = bi.F(split);
            }
            if (F2 == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < F2.size()) {
                        String gw = r.gw((String) F2.get(i3));
                        if (i3 == F2.size() - 1) {
                            stringBuilder.append(gw);
                        } else {
                            stringBuilder.append(gw + ", ");
                        }
                        i2 = i3 + 1;
                    } else {
                        charSequence = stringBuilder.toString();
                    }
                }
            }
        }
        textView.setText(i.b(context, charSequence, fVar2.otb.getTextSize()));
        i2 = (int) fVar2.otb.getTextSize();
        String charSequence2 = fVar2.otb.getText().toString();
        com.tencent.mm.bu.a.fromDPToPix(this.fnF, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) i2);
        paint.measureText(charSequence2);
        fVar2.ote.setOnClickListener(new b(aVar.aZb()));
        return view;
    }

    public final void EN(String str) {
        this.osX = str;
        notifyDataSetChanged();
    }

    private static int nJ(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
    }
}
