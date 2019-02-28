package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.gridviewheaders.e;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map.Entry;

public final class a extends BaseAdapter implements e {
    private SimpleDateFormat lvE = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Context mContext;
    LinkedList<a> mXA = new LinkedList();
    boolean mXB = false;
    private OnClickListener mXC = new OnClickListener() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
            r9 = this;
            r2 = 1;
            r3 = 0;
            r0 = com.tencent.mm.R.h.cvB;
            r0 = r10.getTag(r0);
            r0 = (java.lang.Integer) r0;
            r1 = com.tencent.mm.plugin.gallery.ui.a.this;
            r1 = r1.mXw;
            r4 = r0.intValue();
            r1 = r1.get(r4);
            r1 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r1;
            if (r1 != 0) goto L_0x0026;
        L_0x001c:
            r0 = "MicroMsg.AlbumAdapter";
            r1 = "[onClick] null == item!";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        L_0x0025:
            return;
        L_0x0026:
            r4 = "MicroMsg.AlbumAdapter";
            r5 = new java.lang.StringBuilder;
            r6 = "click Image path:";
            r5.<init>(r6);
            r6 = r1.hQc;
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.x.i(r4, r5);
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXx;
            r4 = r4.contains(r1);
            if (r4 == 0) goto L_0x00a3;
        L_0x004a:
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXx;
            r4.indexOf(r1);
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXx;
            r4.remove(r1);
            r1 = r2;
            r4 = r3;
        L_0x005e:
            if (r4 != 0) goto L_0x0163;
        L_0x0060:
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXy;
            if (r4 == 0) goto L_0x007d;
        L_0x0068:
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXy;
            r5 = com.tencent.mm.plugin.gallery.ui.a.this;
            r5 = r5.mXx;
            r5 = r5.size();
            r0 = r0.intValue();
            r4.K(r5, r0, r1);
        L_0x007d:
            if (r2 != r1) goto L_0x0201;
        L_0x007f:
            r0 = com.tencent.mm.R.h.cvA;
            r0 = r10.getTag(r0);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r3);
            r0 = com.tencent.mm.R.h.cvF;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = com.tencent.mm.R.h.cvF;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r1 = com.tencent.mm.R.e.bsQ;
            r0.setBackgroundResource(r1);
            goto L_0x0025;
        L_0x00a3:
            r4 = com.tencent.mm.plugin.gallery.model.c.aOl();
            r4 = r4.aOO();
            r5 = 3;
            if (r4 != r5) goto L_0x013b;
        L_0x00ae:
            if (r1 == 0) goto L_0x013b;
        L_0x00b0:
            r4 = r1.mMimeType;
            r5 = "image/gif";
            r4 = r4.equalsIgnoreCase(r5);
            if (r4 == 0) goto L_0x013b;
        L_0x00bb:
            r4 = new com.tencent.mm.plugin.gif.e;
            r5 = r1.hQc;
            r4.<init>(r5);
            r5 = r1.hQc;
            r5 = com.tencent.mm.a.e.bN(r5);
            if (r5 == 0) goto L_0x00d6;
        L_0x00ca:
            r6 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r6 = r6.mXv;	 Catch:{ Exception -> 0x012e }
            r6 = r6.zM();	 Catch:{ Exception -> 0x012e }
            if (r5 > r6) goto L_0x00f8;
        L_0x00d6:
            r6 = r4.nEp;	 Catch:{ Exception -> 0x012e }
            r7 = 0;
            r6 = r6[r7];	 Catch:{ Exception -> 0x012e }
            r7 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r7 = r7.mXv;	 Catch:{ Exception -> 0x012e }
            r7 = r7.zL();	 Catch:{ Exception -> 0x012e }
            if (r6 > r7) goto L_0x00f8;
        L_0x00e7:
            r4 = r4.nEp;	 Catch:{ Exception -> 0x012e }
            r6 = 1;
            r4 = r4[r6];	 Catch:{ Exception -> 0x012e }
            r6 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r6 = r6.mXv;	 Catch:{ Exception -> 0x012e }
            r6 = r6.zL();	 Catch:{ Exception -> 0x012e }
            if (r4 <= r6) goto L_0x013b;
        L_0x00f8:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r0 = r0.mXv;	 Catch:{ Exception -> 0x012e }
            r1 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012e }
            r2.<init>();	 Catch:{ Exception -> 0x012e }
            r2 = r2.append(r5);	 Catch:{ Exception -> 0x012e }
            r3 = ",1,,0";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x012e }
            r2 = r2.toString();	 Catch:{ Exception -> 0x012e }
            r0.ap(r1, r2);	 Catch:{ Exception -> 0x012e }
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r0 = r0.mContext;	 Catch:{ Exception -> 0x012e }
            r1 = com.tencent.mm.plugin.gallery.ui.a.this;	 Catch:{ Exception -> 0x012e }
            r1 = r1.mContext;	 Catch:{ Exception -> 0x012e }
            r2 = com.tencent.mm.R.l.elI;	 Catch:{ Exception -> 0x012e }
            r1 = r1.getString(r2);	 Catch:{ Exception -> 0x012e }
            com.tencent.mm.ui.base.h.bu(r0, r1);	 Catch:{ Exception -> 0x012e }
            goto L_0x0025;
        L_0x012e:
            r0 = move-exception;
            r1 = "MicroMsg.AlbumAdapter";
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            com.tencent.mm.sdk.platformtools.x.e(r1, r0);
            goto L_0x0025;
        L_0x013b:
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXx;
            r4 = r4.size();
            r5 = com.tencent.mm.plugin.gallery.ui.a.this;
            r5 = r5.mXu;
            if (r4 >= r5) goto L_0x0226;
        L_0x014d:
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mXx;
            r4.add(r1);
            r1 = com.tencent.mm.plugin.gallery.ui.a.this;
            r1 = r1.mXx;
            r1.size();
            r1 = r3;
            r4 = r3;
            goto L_0x005e;
        L_0x0163:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;
            r0 = r0.mXz;
            if (r0 != r2) goto L_0x019a;
        L_0x016b:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;
            r0 = r0.mContext;
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.duH;
            r6 = com.tencent.mm.plugin.gallery.ui.a.this;
            r6 = r6.mXu;
            r7 = new java.lang.Object[r2];
            r8 = com.tencent.mm.plugin.gallery.ui.a.this;
            r8 = r8.mXu;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.h.bu(r0, r4);
            goto L_0x007d;
        L_0x019a:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;
            r0 = r0.mXz;
            r4 = 2;
            if (r0 != r4) goto L_0x01d2;
        L_0x01a3:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;
            r0 = r0.mContext;
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.duJ;
            r6 = com.tencent.mm.plugin.gallery.ui.a.this;
            r6 = r6.mXu;
            r7 = new java.lang.Object[r2];
            r8 = com.tencent.mm.plugin.gallery.ui.a.this;
            r8 = r8.mXu;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.h.bu(r0, r4);
            goto L_0x007d;
        L_0x01d2:
            r0 = com.tencent.mm.plugin.gallery.ui.a.this;
            r0 = r0.mContext;
            r4 = com.tencent.mm.plugin.gallery.ui.a.this;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.duI;
            r6 = com.tencent.mm.plugin.gallery.ui.a.this;
            r6 = r6.mXu;
            r7 = new java.lang.Object[r2];
            r8 = com.tencent.mm.plugin.gallery.ui.a.this;
            r8 = r8.mXu;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.h.bu(r0, r4);
            goto L_0x007d;
        L_0x0201:
            r0 = com.tencent.mm.R.h.cvA;
            r0 = r10.getTag(r0);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r2);
            r0 = com.tencent.mm.R.h.cvF;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = com.tencent.mm.R.h.cvF;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r1 = com.tencent.mm.R.e.bsK;
            r0.setBackgroundResource(r1);
            goto L_0x0025;
        L_0x0226:
            r1 = r2;
            r4 = r2;
            goto L_0x005e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.a.2.onClick(android.view.View):void");
        }
    };
    int mXu = 9;
    com.tencent.mm.plugin.gallery.stub.a mXv = null;
    ArrayList<MediaItem> mXw = new ArrayList();
    ArrayList<MediaItem> mXx = new ArrayList();
    private b mXy;
    int mXz;

    public interface b {
        void K(int i, int i2, int i3);
    }

    private static class d {
        public ImageView mXJ;
        public ImageView mXK;
        public RelativeLayout mXL;
        public TextView mXM;
        public TextView mXN;
        public CheckBox mXO;
        public View mXP;
        public ImageView mXQ;
        public ImageView mXR;
        public ImageView mXS;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public interface a {
        View getView();
    }

    private static class c implements Runnable {
        private static HashMap<TextView, c> mXH = new HashMap();
        private VideoMediaItem mXF;
        private a mXG;
        private WeakReference<TextView> mpg;

        private interface a {
            void a(c cVar, int i);
        }

        private c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
            this.mpg = new WeakReference(textView);
            this.mXF = videoMediaItem;
            this.mXG = aVar;
        }

        private void f(TextView textView) {
            this.mpg = new WeakReference(textView);
        }

        static void a(TextView textView, VideoMediaItem videoMediaItem) {
            Entry entry = null;
            if (textView == null || videoMediaItem == null) {
                x.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                return;
            }
            if (mXH.containsKey(textView)) {
                c cVar = (c) mXH.get(textView);
                if (!cVar.mXF.equals(videoMediaItem)) {
                    if (textView.equals(cVar.mpg.get())) {
                        cVar.f(null);
                    }
                } else {
                    return;
                }
            }
            if (videoMediaItem.hQf >= 0) {
                x.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", Integer.valueOf(videoMediaItem.hQf), videoMediaItem);
                c(textView, videoMediaItem.hQf);
                mXH.remove(textView);
                return;
            }
            textView.setText("");
            Runnable cVar2 = new c(textView, videoMediaItem, new a() {
                public final void a(c cVar, int i) {
                    if (cVar != null && cVar.mpg != null) {
                        TextView textView = (TextView) cVar.mpg.get();
                        if (textView != null) {
                            c.c(textView, i);
                            c.mXH.remove(textView);
                        }
                    }
                }
            });
            if (com.tencent.mm.sdk.f.e.V(cVar2)) {
                x.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
                for (Entry entry2 : mXH.entrySet()) {
                    if (cVar2.equals(entry2.getValue())) {
                        entry = entry2;
                        break;
                    }
                }
                if (entry == null || entry.getValue() == null) {
                    x.e("MicroMsg.AlbumAdapter", "no entry found");
                    return;
                }
                ((c) entry.getValue()).f(textView);
                mXH.remove(entry.getKey());
                mXH.put(textView, entry.getValue());
                return;
            }
            com.tencent.mm.sdk.f.e.post(cVar2, "load_duration_for_" + videoMediaItem.hQc);
            mXH.put(textView, cVar2);
        }

        private static void c(TextView textView, int i) {
            if (textView != null) {
                if (i < 0) {
                    textView.setText("--:--");
                    return;
                }
                int round = Math.round(((float) i) / 1000.0f);
                textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
            }
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.mXF.equals(((c) obj).mXF);
        }

        public final int hashCode() {
            return this.mXF.hashCode();
        }

        public final void run() {
            Throwable e;
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.mXF.aOC());
                    this.mXF.hQf = bi.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "%s", e2.getMessage());
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "Analysis duration of mediaItem %s error %s", this.mXF.hQc, e2.getMessage());
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "%s", e22.getMessage());
                            }
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    if (c.this.mXG != null) {
                                        c.this.mXG.a(c.this, c.this.mXF.hQf);
                                    }
                                }
                            });
                        } else if (this.mXG == null) {
                            this.mXG.a(this, this.mXF.hQf);
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.AlbumAdapter", e4, "%s", e4.getMessage());
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                mediaMetadataRetriever = null;
                x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "Analysis duration of mediaItem %s error %s", this.mXF.hQc, e22.getMessage());
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    ah.y(/* anonymous class already generated */);
                } else if (this.mXG == null) {
                    this.mXG.a(this, this.mXF.hQf);
                }
            } catch (Throwable th2) {
                e22 = th2;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw e22;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ah.y(/* anonymous class already generated */);
            } else if (this.mXG == null) {
                this.mXG.a(this, this.mXF.hQf);
            }
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return qK(i);
    }

    public a(Context context, b bVar) {
        this.mContext = context;
        this.mXy = bVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            return;
        }
        this.mXA.remove(aVar);
        this.mXA.add(aVar);
    }

    public final ArrayList<String> aOT() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.mXx.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).hQc);
        }
        return arrayList;
    }

    public final void y(ArrayList<String> arrayList) {
        x.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", this.mXx);
        this.mXx.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (com.tencent.mm.plugin.gallery.model.c.aOn() != null) {
                    int indexOf = com.tencent.mm.plugin.gallery.model.c.aOn().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aOn().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.mXx.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                x.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                int i = 1;
                long j = 0;
                String str2 = str;
                this.mXx.add(MediaItem.a(i, j, str2, "", ""));
            }
        }
        x.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", this.mXx);
    }

    public final ArrayList<MediaItem> qJ(int i) {
        ArrayList<MediaItem> arrayList = new ArrayList();
        Iterator it = this.mXw.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        return arrayList;
    }

    public final int getCount() {
        return this.mXA.size() + this.mXw.size();
    }

    public final int getViewTypeCount() {
        return this.mXA.size() + 1;
    }

    public final int getItemViewType(int i) {
        return i < this.mXA.size() ? i : this.mXA.size();
    }

    public final MediaItem qK(int i) {
        if (i < this.mXA.size()) {
            x.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", Integer.valueOf(i));
            return null;
        }
        int size = i - this.mXA.size();
        if (size < this.mXw.size()) {
            return (MediaItem) this.mXw.get(size);
        }
        x.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", Integer.valueOf(this.mXw.size()), Integer.valueOf(size));
        MediaItem imageMediaItem = new ImageMediaItem();
        imageMediaItem.mWS = bi.Wy();
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        x.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", Integer.valueOf(i), Integer.valueOf(this.mXA.size()));
        if (i < this.mXA.size()) {
            x.i("MicroMsg.AlbumAdapter", "position[%d], get header view", Integer.valueOf(i));
            return ((a) this.mXA.get(i)).getView();
        }
        String str;
        View inflate;
        d dVar;
        int size = i - this.mXA.size();
        MediaItem mediaItem = (MediaItem) this.mXw.get(size);
        x.i("MicroMsg.AlbumAdapter", "addtime:%s", Long.valueOf(mediaItem.mWS));
        if (view == null || !(view.getTag() instanceof d)) {
            String str2 = "MicroMsg.AlbumAdapter";
            str = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            x.d(str2, str, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(R.i.dru, viewGroup, false);
            d dVar2 = new d();
            dVar2.mXJ = (ImageView) inflate.findViewById(R.h.cvH);
            dVar2.mXK = (ImageView) inflate.findViewById(R.h.cvK);
            dVar2.mXL = (RelativeLayout) inflate.findViewById(R.h.cVl);
            dVar2.mXM = (TextView) inflate.findViewById(R.h.cVm);
            dVar2.mXO = (CheckBox) inflate.findViewById(R.h.cvA);
            dVar2.mXN = (TextView) inflate.findViewById(R.h.cLf);
            dVar2.mXP = inflate.findViewById(R.h.cvB);
            dVar2.mXQ = (ImageView) inflate.findViewById(R.h.cvF);
            dVar2.mXP.setOnClickListener(this.mXC);
            dVar2.mXP.setTag(R.h.cvA, dVar2.mXO);
            dVar2.mXP.setTag(R.h.cLf, dVar2.mXN);
            dVar2.mXP.setTag(R.h.cvF, dVar2.mXQ);
            if (com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 0 || com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 5 || com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 10 || com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 11) {
                dVar2.mXO.setVisibility(8);
                dVar2.mXN.setVisibility(8);
                dVar2.mXP.setVisibility(8);
                dVar2.mXQ.setVisibility(8);
            }
            dVar2.mXR = (ImageView) inflate.findViewById(R.h.cnF);
            dVar2.mXS = (ImageView) inflate.findViewById(R.h.cdj);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "get item failed");
            return inflate;
        }
        dVar.mXJ.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.mXL.setVisibility(0);
            c.a(dVar.mXM, (VideoMediaItem) mediaItem);
        } else {
            dVar.mXL.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            dVar.mXS.setVisibility(0);
        } else {
            dVar.mXS.setVisibility(8);
        }
        str = mediaItem.aOC();
        String str3 = mediaItem.hQc;
        if (bi.oN(str) && bi.oN(str3)) {
            x.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + size);
            return inflate;
        }
        dVar.mXP.setTag(R.h.cvB, Integer.valueOf(size));
        int i2 = R.l.eAp;
        if (mediaItem.getType() == 2) {
            i2 = R.l.cVG;
        }
        x.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", str, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.mXA.size()), this.lvE.format(new Date(mediaItem.mWS))}));
        dVar.mXK.setContentDescription(r2);
        final ImageView imageView = dVar.mXJ;
        h.a(dVar.mXK, mediaItem.getType(), str, str3, mediaItem.mWR, -1, new com.tencent.mm.plugin.gallery.ui.h.a() {
            public final void aOU() {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
        });
        if (this.mXB) {
            if (mediaItem.getType() == 2) {
                dVar.mXO.setVisibility(8);
                dVar.mXN.setVisibility(8);
                dVar.mXP.setVisibility(8);
                dVar.mXQ.setVisibility(8);
            } else if (this.mXx.contains(mediaItem)) {
                dVar.mXO.setChecked(true);
                dVar.mXN.setText((mediaItem == null ? -1 : this.mXx.indexOf(mediaItem)));
                dVar.mXQ.setBackgroundResource(R.e.bsK);
                dVar.mXP.setVisibility(0);
                dVar.mXO.setVisibility(0);
                dVar.mXQ.setVisibility(0);
            } else {
                dVar.mXN.setVisibility(8);
                dVar.mXO.setChecked(false);
                dVar.mXQ.setBackgroundResource(R.e.bsQ);
                dVar.mXO.setVisibility(0);
                dVar.mXP.setVisibility(0);
                dVar.mXQ.setVisibility(0);
            }
        } else if (this.mXx.contains(mediaItem)) {
            dVar.mXO.setChecked(true);
            dVar.mXQ.setVisibility(0);
            dVar.mXQ.setBackgroundResource(R.e.bsK);
        } else {
            dVar.mXO.setChecked(false);
            dVar.mXN.setVisibility(8);
            dVar.mXQ.setVisibility(0);
            dVar.mXQ.setBackgroundResource(R.e.bsQ);
        }
        if ((com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 3 || com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.mXR.setVisibility(0);
        } else {
            dVar.mXR.setVisibility(8);
        }
        return inflate;
    }

    public final long oE(int i) {
        if (i < this.mXA.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mXA.size();
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", Integer.valueOf(i), Long.valueOf(qK(i).mWS), r1, Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(qK(i).mWS))));
        return com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(qK(i).mWS));
    }

    public final String qL(int i) {
        if (i < this.mXA.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mXA.size();
        }
        return com.tencent.mm.ui.gridviewheaders.a.cyc().a(new Date(qK(i).mWS), this.mContext);
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (i < this.mXA.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mXA.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(R.g.bDq);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bvT);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.bvT);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.e.bsp));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.bvt));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", Integer.valueOf(i), Long.valueOf(r0.mWS), new Date(qK(i).mWS), com.tencent.mm.ui.gridviewheaders.a.cyc().a(new Date(qK(i).mWS), this.mContext));
        ((TextView) textView).setText(r3);
        return textView;
    }
}
