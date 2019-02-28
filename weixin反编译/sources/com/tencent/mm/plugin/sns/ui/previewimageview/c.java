package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends b {
    private HashMap<String, Bitmap> rBY = new HashMap();
    boolean rCb;
    private int rWn;
    private boolean rWo;
    private boolean rWp;
    a rWq;

    public interface a {
        void dH(int i, int i2);

        void removeItem(int i);
    }

    private class b {
        ImageView fwa;
        View view;

        /* synthetic */ b(c cVar, View view, byte b) {
            this(view);
        }

        private b(View view) {
            this.view = view;
            this.fwa = (ImageView) view.findViewById(f.qIE);
        }
    }

    class c extends h<String, Integer, Boolean> {
        private ImageView fzb;
        private Bitmap hmD;
        private String path;

        public final /* synthetic */ Object bvz() {
            if (c.this.rCb) {
                return Boolean.valueOf(false);
            }
            this.hmD = com.tencent.mm.sdk.platformtools.d.d(this.path, ae.bwn(), ae.bwn(), true);
            x.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
            this.hmD = com.tencent.mm.sdk.platformtools.d.b(this.hmD, (float) r0);
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!c.this.rCb && i.m(this.hmD)) {
                c.this.rBY.put(this.path, this.hmD);
                if (this.fzb.getTag() != null && (this.fzb.getTag() instanceof String) && this.fzb.getTag().equals(this.path)) {
                    this.fzb.setImageBitmap(this.hmD);
                }
            }
        }

        public c(ImageView imageView, String str) {
            this.fzb = imageView;
            this.path = str;
        }

        public final ag bvy() {
            return ae.bvQ();
        }
    }

    private class d {
        public Object data;
        public int id;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b) {
            this();
        }

        public final String toString() {
            return this.data.toString();
        }

        public final int hashCode() {
            return this.id;
        }
    }

    public c(Context context, List<?> list, int i, boolean z, a aVar) {
        super(context, 4);
        super.cb(cc(list));
        this.rWn = 9;
        this.rWo = z;
        this.rWq = aVar;
        bCY();
        bCZ();
    }

    private List<d> cc(List<?> list) {
        List<d> arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            d dVar = new d();
            dVar.data = next;
            int i2 = i + 1;
            dVar.id = i;
            arrayList.add(dVar);
            i = i2;
        }
        return arrayList;
    }

    private void bCY() {
        for (int i = 0; i < this.rWm; i++) {
            d dVar = new d();
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i, dVar);
        }
    }

    public final void bCZ() {
        x.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", Boolean.valueOf(this.rWo), Integer.valueOf(getCount()), Integer.valueOf(this.rWm), Integer.valueOf(this.rWn), Boolean.valueOf(this.rWp));
        if (!this.rWo || bDa() >= this.rWn) {
            this.rWp = false;
        } else if (!this.rWp) {
            this.rWp = true;
            add("");
        }
    }

    public final void clear() {
        super.clear();
        this.rWp = false;
    }

    public final void cb(List<?> list) {
        super.cb(cc(list));
        bCY();
        bCZ();
    }

    public final int bDa() {
        return (getCount() - this.rWm) - (this.rWp ? 1 : 0);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(g.qNN, viewGroup, false);
            b bVar2 = new b(this, view, (byte) 0);
            view.setTag(f.qIA, bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag(f.qIA);
        }
        Object obj = getItem(i).toString();
        ImageView imageView = bVar.fwa;
        if (TextUtils.isEmpty(obj)) {
            imageView.setBackgroundColor(0);
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setBackgroundResource(e.qFL);
            imageView.setContentDescription(bVar.fwa.getContext().getString(j.qQi));
            if (i > 0) {
                bVar.view.setTag(Integer.valueOf(-1));
            } else if (i < bVar.rWr.rWm) {
                bVar.view.setTag(Integer.valueOf(Integer.MAX_VALUE));
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i - bVar.rWr.rWm));
            imageView.setBackgroundDrawable(null);
            imageView.setTag(obj);
            imageView.setContentDescription(bVar.fwa.getContext().getString(j.qRf));
            Bitmap bitmap = (Bitmap) bVar.rWr.rBY.get(obj);
            if (i.m(bitmap)) {
                imageView.setImageBitmap(bitmap);
            } else {
                new c(imageView, obj).m("");
            }
        }
        if (i < this.rWm) {
            bVar.fwa.setVisibility(4);
        } else {
            bVar.fwa.setVisibility(0);
            view.setVisibility(0);
        }
        return view;
    }

    public final int getItemViewType(int i) {
        if (TextUtils.isEmpty(getItem(i).toString())) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean yj(int i) {
        if (i < this.rWm) {
            return false;
        }
        if (!this.rWp) {
            return super.yj(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final boolean yk(int i) {
        if (i < this.rWm) {
            return false;
        }
        if (!this.rWp) {
            return super.yk(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final void dL(int i, int i2) {
        super.dL(i, i2);
        if (this.rWq != null) {
            this.rWq.dH(i - this.rWm, i2 - this.rWm);
        }
    }
}
