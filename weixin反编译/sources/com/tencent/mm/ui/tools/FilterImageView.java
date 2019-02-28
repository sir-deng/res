package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] zrp = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity fBA;
    int qWY = 0;
    int[] zrg;
    View zrh;
    ImageView zri;
    CropImageView zrj;
    Bitmap zrk;
    private MMHorList zrl;
    private a zrm;
    Runnable zrn;
    Runnable zro;

    class a extends BaseAdapter {
        int oda = 0;

        class a {
            TextView ioR;
            ImageView zrr;
            Bitmap zrs;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            return FilterImageView.zrp.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.zrp[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(FilterImageView.this.fBA, h.gYT, null);
                a aVar2 = new a();
                aVar2.ioR = (TextView) view.findViewById(g.gXg);
                aVar2.zrr = (ImageView) view.findViewById(g.gXf);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.zrs != null) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", aVar.zrs.toString());
                    aVar.zrs.recycle();
                }
            }
            TextView textView = aVar.ioR;
            b bVar = cVar.zrw;
            String cfV = w.cfV();
            CharSequence charSequence = cfV.equals("zh_CN") ? bVar.yNh : (cfV.equals("zh_TW") || cfV.equals("zh_HK")) ? bVar.zru : bVar.zrv;
            textView.setText(charSequence);
            try {
                InputStream open = FilterImageView.this.fBA.getAssets().open("filter/" + cVar.fED);
                aVar.zrs = d.decodeStream(open);
                open.close();
                aVar.zrr.setImageBitmap(aVar.zrs);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.oda) {
                view.findViewById(g.gXf).setBackgroundResource(f.gWC);
            } else {
                view.findViewById(g.gXf).setBackgroundResource(f.gWD);
            }
            return view;
        }
    }

    static class c {
        String fED;
        int zrA;
        b zrw;
        String zrx;
        int zry;
        int zrz;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.zrw = bVar;
            this.zrx = str;
            this.zry = i;
            this.zrz = i2;
            this.fED = str2;
            this.zrA = i3;
        }
    }

    static class b {
        String yNh;
        String zru;
        String zrv;

        b(String str, String str2, String str3) {
            this.yNh = str;
            this.zru = str2;
            this.zrv = str3;
        }
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBA = (Activity) context;
        View inflate = View.inflate(this.fBA, h.gYS, this);
        this.zrj = (CropImageView) inflate.findViewById(g.gXc);
        this.zri = (ImageView) inflate.findViewById(g.caa);
        this.zrh = inflate.findViewById(g.bZU);
        this.zrj.setOnTouchListener(null);
        this.zrl = (MMHorList) inflate.findViewById(g.bZR);
        this.zrm = new a();
        this.zrl.setAdapter(this.zrm);
        this.zrl.invalidate();
        this.zrl.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a a = FilterImageView.this.zrm;
                a.oda = i;
                a.notifyDataSetChanged();
                try {
                    FilterImageView.this.qWY = FilterImageView.zrp[i].zrA;
                    FilterImageView.this.ai(FilterImageView.zrp[i].zrx, FilterImageView.zrp[i].zry, FilterImageView.zrp[i].zrz);
                } catch (Throwable e) {
                    x.e("MicroMsg.FilterView", e.toString());
                    x.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
                } catch (Throwable e2) {
                    x.e("MicroMsg.FilterView", e2.toString());
                    x.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
                }
            }
        });
    }

    public final void dw(String str, int i) {
        x.i("MicroMsg.FilterView", "filePath before fiterBmp:" + str);
        if (this.zrk == null || this.zrk.isRecycled()) {
            this.zrk = d.b(d.d(str, 480, 480, false), (float) i);
        }
        x.d("MicroMsg.FilterView", "filterBmp w:" + this.zrk.getWidth() + " h:" + this.zrk.getHeight());
        this.zrg = new int[(this.zrk.getWidth() * this.zrk.getHeight())];
        this.zrk.getPixels(this.zrg, 0, this.zrk.getWidth(), 0, 0, this.zrk.getWidth(), this.zrk.getHeight());
        this.zrj.setImageBitmap(this.zrk);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.zrm.notifyDataSetChanged();
            this.zrl.invalidate();
        }
        super.setVisibility(i);
    }

    private boolean ai(String str, int i, int i2) {
        if (i2 == 0) {
            this.zrk.setPixels(this.zrg, 0, this.zrk.getWidth(), 0, 0, this.zrk.getWidth(), this.zrk.getHeight());
            this.zrj.invalidate();
            return true;
        }
        int width = this.zrk.getWidth() * this.zrk.getHeight();
        x.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        int i3 = 0;
        while (i3 < i) {
            InputStream inputStream = null;
            try {
                inputStream = this.fBA.getAssets().open("filter/" + String.format(str, new Object[]{Integer.valueOf(i3)}));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap bn = d.bn(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bn == null) {
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bn, this.zrk.getWidth(), this.zrk.getHeight(), true);
                if (bn != createScaledBitmap) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", bn.toString());
                    bn.recycle();
                }
                if (createScaledBitmap == null) {
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                i3++;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        PIntArray pIntArray = new PIntArray();
        x.e("MicroMsg.FilterView", "src.len:" + this.zrg.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            x.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        x.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, this.zrg, iArr, i, this.zrk.getWidth(), this.zrk.getHeight(), pIntArray);
        x.e("MicroMsg.FilterView", "after filter");
        this.zrk.setPixels(pIntArray.value, 0, this.zrk.getWidth(), 0, 0, this.zrk.getWidth(), this.zrk.getHeight());
        this.zrj.invalidate();
        return true;
    }
}
