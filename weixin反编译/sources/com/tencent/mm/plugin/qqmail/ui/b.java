package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    int mode;
    private TextView pwr;
    private ImageView pws;
    ComposeUI pxT;
    ViewGroup pxU;
    Map<String, y> pxV;
    Map<String, o> pxW;
    Map<String, String> pxX;
    Map<String, String> pxY;
    b pxZ;
    private OnClickListener pya;

    public interface b {
        void blo();

        void onComplete();
    }

    private class a {
        ImageView jIs;
        TextView lmk;
        TextView pxC;
        ProgressBar pyj;
        TextView pyk;
        ImageView pyl;
        ImageView pym;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.blw()) {
            Object obj;
            for (String str : bVar.pxV.keySet()) {
                if (((y) bVar.pxV.get(str)).state != 2) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null && bVar.pxZ != null) {
                bVar.pxZ.onComplete();
            }
        } else if (bVar.pxZ != null) {
            b bVar2 = bVar.pxZ;
            bVar.pxV.size();
            for (String str2 : bVar.pxV.keySet()) {
                if (((y) bVar.pxV.get(str2)).state != 2) {
                    break;
                }
            }
            bVar2.blo();
        }
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        this.pxV = new HashMap();
        this.pxW = new HashMap();
        this.pxX = new LinkedHashMap();
        this.pxY = new LinkedHashMap();
        this.pxZ = null;
        this.pya = null;
        this.mode = 5;
        this.pxT = composeUI;
        this.pxU = viewGroup;
        this.pya = null;
        this.pwr = textView;
        this.pws = imageView;
        blx();
        as.CN().a(484, (e) this);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void bt(List<y> list) {
        if (list != null) {
            for (y yVar : list) {
                a(yVar);
                this.pxV.put(yVar.path, yVar);
            }
            if (this.mode == 6) {
                for (y yVar2 : list) {
                    this.pxX.put(yVar2.path, yVar2.pvJ);
                    this.pxY.put(yVar2.path, yVar2.name);
                }
            }
        }
    }

    public final void dP(String str, String str2) {
        if (str != null && str.length() != 0 && !this.pxV.containsKey(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                y yVar = new y();
                yVar.path = str;
                if (str2 == null) {
                    yVar.name = file.getName();
                } else {
                    yVar.name = str2;
                }
                yVar.size = file.length();
                yVar.state = 0;
                this.pxV.put(str, yVar);
                a(yVar);
            }
        }
    }

    private void a(final y yVar) {
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.pxT, R.i.dqc, null)).findViewById(R.h.cCZ);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.cCY);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cDa);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.cDc);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.h.cDd);
        TextView textView3 = (TextView) linearLayout.findViewById(R.h.cDe);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.cDb);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.h.cCX);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.Tr(yVar.name));
        textView.setText(yVar.name);
        textView2.setText(bi.by(yVar.size));
        a aVar = new a();
        aVar.jIs = imageView;
        aVar.lmk = textView;
        aVar.pxC = textView2;
        aVar.pyj = progressBar;
        aVar.pyk = textView3;
        aVar.pyl = imageView2;
        aVar.pym = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(yVar.path.hashCode() / 2));
        if (this.pya != null) {
            linearLayout.setOnClickListener(this.pya);
        }
        this.pxU.addView(linearLayout);
        blx();
        linearLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
            }
        });
        imageView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.mode == 5) {
                    yVar.pvI = b.this.Ix(yVar.path);
                } else if (b.this.mode == 6) {
                    yVar.pvI = b.this.dQ(yVar.path, yVar.name);
                }
            }
        });
        imageView3.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.a(b.this.pxT, R.l.eAv, R.l.dGZ, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (yVar.state == 0 || yVar.state == 1) {
                            b bVar = b.this;
                            y yVar = yVar;
                            if (bVar.mode == 5) {
                                w.bkZ().cancel(yVar.pvI);
                            } else if (bVar.mode == 6) {
                                k kVar = (o) bVar.pxW.get(yVar.path);
                                if (kVar != null) {
                                    as.CN().c(kVar);
                                }
                                bVar.pxX.remove(yVar.path);
                                bVar.pxY.remove(yVar.path);
                            }
                        }
                        b.this.pxV.remove(yVar.path);
                        b.this.pxW.remove(yVar.path);
                        b.this.pxX.remove(yVar.path);
                        b.this.pxY.remove(yVar.path);
                        b.this.pxU.removeView(linearLayout);
                        b.this.blx();
                    }
                }, null);
            }
        });
        this.pxU.post(new Runnable() {
            public final void run() {
                b.this.b(yVar);
            }
        });
        if (yVar.state != 0) {
            return;
        }
        if (this.mode == 5) {
            yVar.pvI = Ix(yVar.path);
        } else if (this.mode == 6) {
            yVar.pvI = dQ(yVar.path, yVar.name);
        }
    }

    public final String blt() {
        String str = "";
        for (String str2 : this.pxV.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((y) this.pxV.get(str2)).pvJ;
        }
        return str;
    }

    public final LinkedList<y> blu() {
        LinkedList<y> linkedList = new LinkedList();
        for (String str : this.pxV.keySet()) {
            linkedList.add(this.pxV.get(str));
        }
        return linkedList;
    }

    public final void blv() {
        y yVar;
        if (this.mode == 5) {
            for (String str : this.pxV.keySet()) {
                yVar = (y) this.pxV.get(str);
                if (yVar.state != 2) {
                    w.bkZ().cancel(yVar.pvI);
                    yVar.state = 3;
                    b(yVar);
                }
            }
        } else if (this.mode == 6) {
            for (String str2 : this.pxV.keySet()) {
                yVar = (y) this.pxV.get(str2);
                if (yVar.state != 2) {
                    k kVar = (o) this.pxW.get(yVar.path);
                    if (kVar != null) {
                        as.CN().c(kVar);
                        yVar.state = 3;
                        b(yVar);
                    }
                    this.pxX.remove(yVar.path);
                    this.pxY.remove(yVar.path);
                    this.pxW.remove(yVar.path);
                }
            }
        }
    }

    final long Ix(final String str) {
        c cVar = new c();
        cVar.puT = false;
        cVar.puS = true;
        return w.bkZ().a("/cgi-bin/uploaddata", 1, null, new d("UploadFile", str), cVar, new com.tencent.mm.plugin.qqmail.b.p.a() {
            public final boolean onReady() {
                y yVar = (y) b.this.pxV.get(str);
                if (yVar != null) {
                    yVar.state = 1;
                    b.this.b(yVar);
                }
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                String str2 = (String) map.get(".Response.result.DataID");
                y yVar = (y) b.this.pxV.get(str);
                if (yVar != null) {
                    yVar.state = 2;
                    yVar.pvJ = str2;
                    b.this.b(yVar);
                }
            }

            public final void onError(int i, String str) {
                x.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", Integer.valueOf(i), str);
                y yVar = (y) b.this.pxV.get(str);
                if (yVar != null) {
                    yVar.state = 3;
                    b.this.b(yVar);
                }
                if (i == -5) {
                    b.this.pxT.pwz.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                        public final void blc() {
                        }

                        public final void bld() {
                        }
                    });
                }
            }

            public final void onComplete() {
                b.a(b.this);
            }
        });
    }

    final long dQ(final String str, final String str2) {
        if (this.pxW.containsKey(str)) {
            return (long) ((o) this.pxW.get(str)).hashCode();
        }
        k oVar = new o(str, str, new f() {
            public final void a(int i, int i2, k kVar) {
                x.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                final y yVar;
                if (i < i2) {
                    x.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                    yVar = (y) b.this.pxV.get(str);
                    if (yVar != null) {
                        yVar.state = 1;
                        ah.y(new Runnable() {
                            public final void run() {
                                b.this.b(yVar);
                            }
                        });
                    }
                } else if (i >= i2) {
                    yVar = (y) b.this.pxV.get(str);
                    String str = ((o) kVar).bkT().wfk;
                    b.this.pxX.put(str, str);
                    b.this.pxY.put(str, str2);
                    b.this.pxW.remove(str);
                    x.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", str, str);
                    if (yVar != null) {
                        yVar.state = 2;
                        yVar.pvJ = str;
                        ah.y(new Runnable() {
                            public final void run() {
                                b.this.b(yVar);
                            }
                        });
                    }
                    b.a(b.this);
                }
            }
        });
        y yVar = (y) this.pxV.get(str);
        if (yVar != null) {
            yVar.state = 1;
        }
        b(yVar);
        as.CN().a(oVar, 0);
        this.pxW.put(str, oVar);
        return (long) oVar.hashCode();
    }

    public final boolean blw() {
        for (String str : this.pxV.keySet()) {
            y yVar = (y) this.pxV.get(str);
            if (yVar.state != 2 && yVar.state != 3) {
                return false;
            }
        }
        return true;
    }

    public final void blx() {
        if (this.pxV.size() == 0) {
            this.pwr.setText(this.pxT.getString(R.l.eAB) + " " + this.pxT.getString(R.l.eAE));
            this.pws.setImageResource(R.k.dAz);
            ((View) this.pxU.getParent()).setVisibility(8);
        } else {
            this.pwr.setText(this.pxT.getString(R.l.eAB) + this.pxT.getResources().getQuantityString(R.j.duS, this.pxV.size(), new Object[]{Integer.valueOf(this.pxV.size()), bi.by((long) bly())}));
            this.pws.setImageResource(R.k.dAA);
            ((View) this.pxU.getParent()).setVisibility(0);
        }
        int childCount = this.pxU.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.pxU.getChildAt(i).setBackgroundResource(R.g.bDB);
            } else if (i == 0) {
                this.pxU.getChildAt(i).setBackgroundResource(R.g.bDC);
            } else if (i <= 0 || i >= childCount - 1) {
                this.pxU.getChildAt(i).setBackgroundResource(R.g.bDE);
            } else {
                this.pxU.getChildAt(i).setBackgroundResource(R.g.bDD);
            }
            i++;
        }
    }

    public final int bly() {
        int i = 0;
        Iterator it = this.pxV.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long j = (long) i2;
            i = (int) (((y) this.pxV.get((String) it.next())).size + j);
        }
    }

    final void b(y yVar) {
        LinearLayout linearLayout = (LinearLayout) this.pxU.findViewById(Math.abs(yVar.path.hashCode() / 2));
        if (linearLayout != null) {
            a aVar = (a) linearLayout.getTag();
            switch (yVar.state) {
                case 0:
                case 1:
                    aVar.lmk.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.pyj.setVisibility(0);
                    aVar.pyk.setVisibility(8);
                    aVar.pyl.setVisibility(8);
                    aVar.pym.setVisibility(0);
                    return;
                case 2:
                    aVar.lmk.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.pyj.setVisibility(8);
                    aVar.pyk.setVisibility(8);
                    aVar.pyl.setVisibility(8);
                    aVar.pym.setVisibility(0);
                    return;
                case 3:
                    aVar.lmk.setTextColor(com.tencent.mm.bu.a.c(this.pxT, R.e.btc));
                    aVar.pyj.setVisibility(8);
                    aVar.pyk.setVisibility(0);
                    aVar.pyl.setVisibility(0);
                    aVar.pym.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 484) {
            kVar = (o) kVar;
            String str2 = kVar.filePath;
            final y yVar = (y) this.pxV.get(str2);
            if (yVar == null) {
                return;
            }
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", Integer.valueOf(i), Integer.valueOf(i2), str2);
                yVar.state = 3;
                this.pxW.remove(str2);
                as.CN().c(kVar);
                ah.y(new Runnable() {
                    public final void run() {
                        b.this.b(yVar);
                    }
                });
            }
        }
    }
}
