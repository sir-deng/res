package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI extends MMActivity implements b {
    static long start = 0;
    private String fAJ;
    private int hGs;
    private ProgressDialog inI;
    private ServiceConnection lwY = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            AlbumPreviewUI.this.mXv = com.tencent.mm.plugin.gallery.stub.a.a.Q(iBinder);
            if (AlbumPreviewUI.this.mXY != null) {
                AlbumPreviewUI.this.mXY.mXv = AlbumPreviewUI.this.mXv;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            AlbumPreviewUI.this.mXv = null;
        }
    };
    private GridView mXT;
    private TextView mXU;
    private boolean mXV;
    private boolean mXW;
    private TextView mXX;
    private a mXY;
    private TextView mXZ;
    private com.tencent.mm.plugin.gallery.stub.a mXv = null;
    private HashMap<String, Integer> mYA = new HashMap();
    private TextView mYa;
    private ImageFolderMgrView mYb;
    private TextView mYc;
    private ImageButton mYd;
    private String mYe;
    private String mYf;
    private int mYg;
    private String mYh;
    private boolean mYi = false;
    private boolean mYj = false;
    private boolean mYk = false;
    private boolean mYl = false;
    private boolean mYm = false;
    private boolean mYn = false;
    private boolean mYo = false;
    private int mYp;
    private int mYq;
    boolean mYr = false;
    private int mYs = 0;
    private int mYt = 0;
    private long mYu = 0;
    private long mYv;
    private int mYw = -1;
    private long mYx = -1;
    private com.tencent.mm.plugin.gallery.ui.a.a mYy = new com.tencent.mm.plugin.gallery.ui.a.a() {
        private OnClickListener myR = new OnClickListener() {
            private void aOY() {
                String stringExtra = AlbumPreviewUI.this.getIntent().getStringExtra("to_user");
                String stringExtra2 = AlbumPreviewUI.this.getIntent().getStringExtra("file_name");
                String stringExtra3 = AlbumPreviewUI.this.getIntent().getStringExtra("video_path");
                String stringExtra4 = AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path");
                String stringExtra5 = AlbumPreviewUI.this.getIntent().getStringExtra("video_thumb_path");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(AlbumPreviewUI.this.mController.xRr.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
                    intent.putExtra("VideoRecorder_ToUser", stringExtra);
                    intent.putExtra("VideoRecorder_FileName", stringExtra2);
                    intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
                    intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
                    intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
                    x.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", intent);
                    AlbumPreviewUI.this.startActivityForResult(intent, 4371);
                } catch (Exception e) {
                    x.w("MicroMsg.AlbumPreviewUI", e.toString());
                    if (!com.tencent.mm.o.a.aV(AlbumPreviewUI.this.mController.xRr) && !com.tencent.mm.o.a.aU(AlbumPreviewUI.this.mController.xRr)) {
                        com.tencent.mm.compatible.j.b.b(AlbumPreviewUI.this.mController.xRr, 4372);
                    }
                }
            }

            public final void onClick(View view) {
                x.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", Integer.valueOf(AlbumPreviewUI.this.mYs));
                if (AlbumPreviewUI.this.mYo) {
                    x.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
                    return;
                }
                AlbumPreviewUI.D(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mYo = true;
                if (c.aOl().aOP() == 2 || c.aOl().aOO() == 13) {
                    if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                        int intExtra = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_quality", 0);
                        int intExtra2 = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_time_limit", 0);
                        k.a(AlbumPreviewUI.this.mController.xRr, AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
                    } else if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                        if (((SightParams) AlbumPreviewUI.this.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                            x.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                        }
                        if (c.aOl().aOO() != 13) {
                            k.a(AlbumPreviewUI.this.mController.xRr, 4375, AlbumPreviewUI.this.getIntent(), 3, 1);
                        } else {
                            k.a(AlbumPreviewUI.this.mController.xRr, 4375, AlbumPreviewUI.this.getIntent(), 4, 1);
                        }
                    } else if (q.gHP.gGD == 2) {
                        aOY();
                    } else if (q.gHP.gGD != 1 || com.tencent.mm.o.a.aV(AlbumPreviewUI.this.mController.xRr) || com.tencent.mm.o.a.aU(AlbumPreviewUI.this.mController.xRr)) {
                        aOY();
                    } else {
                        com.tencent.mm.compatible.j.b.b(AlbumPreviewUI.this.mController.xRr, 4372);
                    }
                } else if (c.aOl().aOP() == 1 || c.aOl().aOP() == 3) {
                    File file = new File(e.gJf);
                    if (file.exists() || file.mkdir()) {
                        x.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(AlbumPreviewUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")), bi.chl(), AlbumPreviewUI.this.mController.xRr);
                        if (com.tencent.mm.pluginsdk.g.a.a(AlbumPreviewUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")) {
                            AlbumPreviewUI.this.asx();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(AlbumPreviewUI.this.mController.xRr, AlbumPreviewUI.this.getString(R.l.dTp), 1).show();
                }
            }
        };

        public final View getView() {
            View inflate = View.inflate(AlbumPreviewUI.this.mController.xRr, R.i.dcR, null);
            inflate.setOnClickListener(this.myR);
            TextView textView = (TextView) inflate.findViewById(R.h.cvK);
            if (c.aOl().aOP() == 2 || c.aOl().aOO() == 13) {
                textView.setText(R.l.elX);
            } else if (c.aOl().aOP() == 1) {
                textView.setText(R.l.elW);
            }
            inflate.setLayerType(1, null);
            return inflate;
        }
    };
    private boolean mYz = false;
    private String toUser;

    private static class a implements Runnable {
        public WeakReference<a> mYI;
        public WeakReference<ProgressDialog> mYJ;
        public ArrayList<MediaItem> mYK;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            String str = "MicroMsg.AlbumPreviewUI";
            String str2 = "on NotifyMediaItemsChanged, size %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.mYK == null ? -1 : this.mYK.size());
            x.d(str, str2, objArr);
            if (this.mYI != null) {
                a aVar = (a) this.mYI.get();
                if (aVar != null) {
                    AlbumPreviewUI.A(this.mYK);
                    aVar.mXw.addAll(this.mYK);
                    aVar.notifyDataSetChanged();
                    if (this.mYJ != null) {
                        ProgressDialog progressDialog = (ProgressDialog) this.mYJ.get();
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            x.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start));
                        }
                    }
                }
            }
        }

        public final String toString() {
            return super.toString() + "|notifyRunnable";
        }
    }

    static /* synthetic */ void A(ArrayList arrayList) {
        if (arrayList == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] mMediaItems is null!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            Iterator it2 = c.aOo().iterator();
            while (it2.hasNext()) {
                MediaItem mediaItem2 = (MediaItem) it2.next();
                if (mediaItem2.mWP.equals(mediaItem.hQc)) {
                    x.d("MicroMsg.AlbumPreviewUI", "item:%s replace editItem:%s", mediaItem, mediaItem2);
                    arrayList.set(i, mediaItem2);
                }
                if (mediaItem2.hQc.equals(mediaItem.hQc)) {
                    x.d("MicroMsg.AlbumPreviewUI", "remove editItem:%s", mediaItem2);
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            i++;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList.remove(((Integer) it3.next()).intValue());
        }
        x.d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    static /* synthetic */ int D(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mYs + 1;
        albumPreviewUI.mYs = i;
        return i;
    }

    static /* synthetic */ void a(AlbumPreviewUI albumPreviewUI, MediaItem mediaItem) {
        if (c.aOl().aOO() == 3 && albumPreviewUI.mYm && 26214400 < com.tencent.mm.a.e.bN(mediaItem.hQc)) {
            x.w("MicroMsg.AlbumPreviewUI", "[checkRawImageItem] item:%s file size:%s", mediaItem, Integer.valueOf(com.tencent.mm.a.e.bN(mediaItem.hQc)));
            h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elM));
        }
    }

    static /* synthetic */ void e(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mYm) {
            Iterator it = albumPreviewUI.mXY.mXx.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem != null && mediaItem.getType() == 1) {
                    if (26214400 < com.tencent.mm.a.e.bN(mediaItem.hQc)) {
                        x.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", mediaItem, Integer.valueOf(com.tencent.mm.a.e.bN(mediaItem.hQc)));
                        i2++;
                    }
                    i++;
                }
                i2 = i2;
                i = i;
            }
            if (i2 <= 0) {
                return;
            }
            if (i == i2) {
                h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elM));
            } else {
                h.bt(albumPreviewUI, albumPreviewUI.getString(R.l.elJ));
            }
        }
    }

    static /* synthetic */ void g(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mXY.mXx.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
        } else {
            albumPreviewUI.enableOptionMenu(false);
        }
    }

    static /* synthetic */ void s(AlbumPreviewUI albumPreviewUI) {
        h.h(albumPreviewUI, R.l.eTn, R.l.elU);
        x.w("MicroMsg.AlbumPreviewUI", "video is import error");
    }

    static /* synthetic */ void t(AlbumPreviewUI albumPreviewUI) {
        h.h(albumPreviewUI, R.l.elT, R.l.elU);
        x.w("MicroMsg.AlbumPreviewUI", "video is over size");
    }

    static /* synthetic */ int u(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mYt + 1;
        albumPreviewUI.mYt = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mYv = System.currentTimeMillis();
        x.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            x.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.mYq = bundle.getInt("constants_key");
            c.aOl().qH(this.mYq);
        }
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        x.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        c.aOl().qG(intExtra2);
        c.aOl().qH(intExtra);
        initView();
        c.aOl().mXh.add(this);
        this.mYx = System.currentTimeMillis();
        l aOl = c.aOl();
        aOl.d(this.mYf, aOl.mXj, this.mYx);
        bindService(new Intent(this.mController.xRr, GalleryStubService.class), this.lwY, 1);
    }

    protected void onPause() {
        super.onPause();
        this.mYo = true;
        c.aOm().aOA().removeCallbacksAndMessages(null);
        c.aOm().aOB();
        x.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.mYj);
        if (this.mYj) {
            aOW();
        }
        if (this.mYb.Od) {
            ImageFolderMgrView imageFolderMgrView = this.mYb;
            if (!imageFolderMgrView.Od) {
                x.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.mZj) {
                x.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.mZf.setVisibility(8);
                imageFolderMgrView.Od = false;
            }
        }
        try {
            this.mXv.qI(this.hGs);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
        }
        this.hGs = 0;
    }

    protected void onResume() {
        super.onResume();
        x.d("MicroMsg.AlbumPreviewUI", "on resume");
        this.mYo = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        c.aOl().b(this.mYb);
        c.aOl().mXh.remove(this);
        if (this.mYs > 0 || this.mYt > 0) {
            x.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", Integer.valueOf(this.mYs), Integer.valueOf(this.mYt));
            try {
                this.mXv.ap(11187, this.mYs + "," + this.mYt);
            } catch (Throwable e) {
                x.e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            x.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            if (this.mYu > 0 || this.mXW) {
                c.a(this.mXv, this.mYh, z(this.mXY.mXx), this.mYm, this.mXV);
            }
            c.a(this.mXv, this.mXY.mXx.size(), this.mYm);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        c.aOo().clear();
        c.aOp().clear();
        c.aOq().clear();
        try {
            unbindService(this.lwY);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e22, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mYq = c.aOl().aOO();
        bundle.putInt("constants_key", this.mYq);
    }

    protected final int getLayoutId() {
        return R.i.drt;
    }

    private void updateTitle() {
        if (c.aOl().aOP() == 3) {
            setMMTitle(R.l.elj);
            this.mXX.setText(R.l.elj);
        } else if (c.aOl().aOP() == 1) {
            setMMTitle(R.l.elS);
            this.mXX.setText(R.l.eli);
        } else {
            setMMTitle(R.l.elk);
            this.mXX.setText(R.l.elk);
        }
    }

    private static int[] z(ArrayList<MediaItem> arrayList) {
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!bi.oN(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        return iArr;
    }

    private void a(AlbumItem albumItem) {
        if (albumItem != null) {
            if (bi.aD(this.mYf, "").equals(albumItem.mWN)) {
                x.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
                return;
            }
            c.aOq().addAll(this.mXY.mXx);
            x.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", albumItem.mWN, albumItem.aOC());
            this.mYe = albumItem.aOC();
            this.mYf = albumItem.mWN;
            if (albumItem.mWO != null) {
                this.mYg = albumItem.mWO.getType();
            }
            if (bi.oN(this.mYe)) {
                x.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.mYe = this.mYf;
            }
            if (bi.oN(this.mYf)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.mXY.a(this.mYy);
                }
                updateTitle();
                this.mYg = c.aOl().aOP();
            } else {
                a aVar = this.mXY;
                com.tencent.mm.plugin.gallery.ui.a.a aVar2 = this.mYy;
                if (aVar2 == null) {
                    x.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar.mXA.remove(aVar2);
                }
                this.mXX.setText(this.mYf);
            }
            this.mXY.mXw.clear();
            qM(this.mXY.mXx.size());
            this.mXY.notifyDataSetChanged();
            if (this.inI != null) {
                this.inI.dismiss();
            }
            getString(R.l.dGZ);
            this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            start = System.currentTimeMillis();
            String str = this.mYf;
            if (albumItem.mWO != null) {
                int type = albumItem.mWO.getType();
                x.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", Integer.valueOf(type), Integer.valueOf(c.aOl().aOP()));
                if (c.aOl().aOP() != 2 && albumItem.mWO.getType() == 2) {
                    str = "";
                }
                if (bi.oN(albumItem.mWN)) {
                    type = 3;
                }
                this.mYx = System.currentTimeMillis();
                c.aOl().d(str, type, this.mYx);
            }
        }
    }

    public final void F(int i, boolean z) {
        boolean z2 = true;
        switch (c.aOl().aOP()) {
            case 3:
                if (!bi.oN(this.fAJ) && !"medianote".equals(this.toUser)) {
                    if (bi.Wz() - this.mYu < 1000) {
                        x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        return;
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    MediaItem mediaItem = (MediaItem) this.mXY.mXw.get(i);
                    if (mediaItem.getType() != 2) {
                        try {
                            com.tencent.mm.plugin.gallery.stub.a aVar = this.mXv;
                            String str = mediaItem.hQc;
                            String str2 = this.toUser;
                            if (!this.mYi && this.mYm) {
                                z2 = false;
                            }
                            aVar.a(str, str2, z2, 0, z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void initView() {
        boolean z;
        for (String str : getIntent().getExtras().keySet()) {
            x.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", str, getIntent().getExtras().get(str));
        }
        this.fAJ = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.mYp = getIntent().getIntExtra("max_select_count", 9);
        this.mYi = c.aOl().aOO() == 4;
        if (c.aOl().aOO() == 5) {
            z = true;
        } else {
            z = false;
        }
        this.mYk = z;
        if (c.aOl().aOO() == 9) {
            z = true;
        } else {
            z = false;
        }
        this.mYl = z;
        this.mYe = getIntent().getStringExtra("folder_path");
        this.mYf = getIntent().getStringExtra("folder_name");
        if (bi.oN(this.mYe)) {
            x.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.mYe = this.mYf;
        }
        this.mYm = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.mYn = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.mYc = (TextView) findViewById(R.h.cBX);
        this.mYd = (ImageButton) findViewById(R.h.cBW);
        this.mYc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AlbumPreviewUI.this.mYd.performClick();
            }
        });
        if (c.aOl().aOO() == 3) {
            this.mYd.setVisibility(0);
            this.mYc.setVisibility(0);
        } else {
            this.mYd.setVisibility(8);
            this.mYc.setVisibility(8);
        }
        if (this.mYm) {
            this.mYd.setImageResource(R.k.dAC);
        } else {
            this.mYd.setImageResource(R.k.dAB);
        }
        this.mYd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AlbumPreviewUI.this.mYm = !AlbumPreviewUI.this.mYm;
                AlbumPreviewUI.e(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mYc.setText(AlbumPreviewUI.this.mController.xRr.getString(R.l.elu) + "");
                if (AlbumPreviewUI.this.mYm) {
                    AlbumPreviewUI.this.mYd.setImageResource(R.k.dAC);
                } else {
                    AlbumPreviewUI.this.mYd.setImageResource(R.k.dAB);
                }
                AlbumPreviewUI.g(AlbumPreviewUI.this);
            }
        });
        this.mXZ = (TextView) findViewById(R.h.bJV);
        this.mYa = (TextView) findViewById(R.h.bJU);
        this.mXU = (TextView) findViewById(R.h.cvJ);
        if (c.aOl().aOO() == 0 || c.aOl().aOO() == 5 || c.aOl().aOO() == 10 || c.aOl().aOO() == 11) {
            findViewById(R.h.cjb).setVisibility(8);
            this.mXU.setVisibility(8);
        } else {
            this.mXU.setVisibility(0);
            this.mXU.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AlbumPreviewUI.this.mXV = true;
                    Intent intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    c.w(AlbumPreviewUI.this.mXY.mXw);
                    intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mXY.aOT());
                    intent.putExtra("max_select_count", AlbumPreviewUI.this.mYp);
                    intent.putExtra("send_raw_img", AlbumPreviewUI.this.mYm);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    AlbumPreviewUI.this.startActivityForResult(intent, 0);
                }
            });
            if ((c.aOl().aOP() == 1 || c.aOl().aOP() == 2 || c.aOl().aOP() == 3) && this.mYp > 0) {
                OnMenuItemClickListener anonymousClass15 = new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean z = false;
                        x.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", Integer.valueOf(c.aOs()), Boolean.valueOf(AlbumPreviewUI.this.mYi));
                        try {
                            AlbumPreviewUI.this.mXv.ap(11610, (AlbumPreviewUI.this.mYi ? 3 : 2) + "," + c.aOs());
                        } catch (Throwable e) {
                            x.e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                        }
                        if (AlbumPreviewUI.this.mYw < 0) {
                            try {
                                AlbumPreviewUI.this.mYw = AlbumPreviewUI.this.mXv.zO();
                            } catch (Throwable e2) {
                                AlbumPreviewUI.this.mYw = JceStruct.JCE_MAX_STRING_LENGTH;
                                x.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", e2.getMessage());
                                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
                            }
                        }
                        c.aOr();
                        if (AlbumPreviewUI.this.mXY.aOT().size() == 0) {
                            x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
                            AlbumPreviewUI.this.setResult(-2);
                            AlbumPreviewUI.this.finish();
                        } else {
                            Intent intent = new Intent();
                            int aOP = c.aOl().aOP();
                            if (AlbumPreviewUI.this.mYi) {
                                aOP = 1;
                            }
                            if (AlbumPreviewUI.this.mYn) {
                                aOP = 1;
                            }
                            ArrayList arrayList;
                            MediaItem mediaItem;
                            if (aOP == 1) {
                                String str = "CropImage_Compress_Img";
                                boolean z2 = AlbumPreviewUI.this.mYi ? true : !AlbumPreviewUI.this.mYm;
                                intent.putExtra(str, z2);
                                arrayList = AlbumPreviewUI.this.mXY.mXx;
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    mediaItem = (MediaItem) it.next();
                                    if (!mediaItem.mMimeType.equals("edit") || bi.oN(mediaItem.mWQ)) {
                                        arrayList2.add(mediaItem.hQc);
                                    } else {
                                        arrayList2.add(mediaItem.mWQ);
                                    }
                                }
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mYv);
                                AlbumPreviewUI.this.mYv = 0;
                                AlbumPreviewUI.this.setResult(-1, intent);
                                AlbumPreviewUI.this.mYj = true;
                                if (bi.oN(AlbumPreviewUI.this.fAJ) || "medianote".equals(AlbumPreviewUI.this.toUser)) {
                                    AlbumPreviewUI.this.finish();
                                } else if (bi.Wz() - AlbumPreviewUI.this.mYu < 1000) {
                                    x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                                } else {
                                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    AlbumPreviewUI.this.mYu = bi.Wz();
                                    intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                                    AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                                }
                            } else if (aOP == 2) {
                                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                                com.tencent.mm.pluginsdk.ui.c.a Ti = com.tencent.mm.pluginsdk.ui.c.a.Ti((String) AlbumPreviewUI.this.mXY.aOT().get(0));
                                Ti.hX = AlbumPreviewUI.this.mYw;
                                aOP = Ti.ccV();
                                if (aOP == 0) {
                                    intent.setData(Uri.fromFile(new File((String) AlbumPreviewUI.this.mXY.aOT().get(0))));
                                    intent.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.this.mXY.aOT());
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                    AlbumPreviewUI.this.mYj = true;
                                    AlbumPreviewUI.this.finish();
                                } else if (aOP == 2) {
                                    AlbumPreviewUI.s(AlbumPreviewUI.this);
                                } else {
                                    AlbumPreviewUI.t(AlbumPreviewUI.this);
                                }
                            } else if (aOP != 3) {
                                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                                AlbumPreviewUI.this.setResult(-2);
                                AlbumPreviewUI.this.finish();
                            } else if (bi.Wz() - AlbumPreviewUI.this.mYu < 1000) {
                                x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                            } else {
                                AlbumPreviewUI.this.mYu = bi.Wz();
                                arrayList = AlbumPreviewUI.this.mXY.mXx;
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    mediaItem = (MediaItem) it2.next();
                                    if (mediaItem.getType() == 1) {
                                        if (!mediaItem.mMimeType.equals("edit") || bi.oN(mediaItem.mWQ)) {
                                            arrayList4.add(mediaItem.hQc);
                                        } else {
                                            arrayList4.add(mediaItem.mWQ);
                                        }
                                    } else if (mediaItem.getType() == 2) {
                                        arrayList3.add(mediaItem.hQc);
                                    }
                                }
                                String str2 = "CropImage_Compress_Img";
                                if (AlbumPreviewUI.this.mYi) {
                                    z = true;
                                } else if (!AlbumPreviewUI.this.mYm) {
                                    z = true;
                                }
                                intent.putExtra(str2, z);
                                intent.putStringArrayListExtra("key_select_video_list", arrayList3);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mYv);
                                AlbumPreviewUI.this.mYv = 0;
                                if (arrayList4.size() > 0) {
                                    intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                                    intent.putExtra("CropImage_limit_Img_Size", 26214400);
                                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                                } else {
                                    x.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                    AlbumPreviewUI.this.finish();
                                }
                            }
                        }
                        return true;
                    }
                };
                if (bi.oN(this.mYh)) {
                    a(0, qN(0), anonymousClass15, p.b.xSe);
                } else {
                    addTextOptionMenu(0, this.mYh, anonymousClass15);
                }
            }
        }
        this.mYb = (ImageFolderMgrView) findViewById(R.h.cpa);
        com.tencent.mm.plugin.gallery.model.g.a aVar = this.mYb;
        c.aOl().b(aVar);
        c.aOl().a(aVar);
        c.aOl().aOQ();
        this.mYb.mZe = new com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.a() {
            public final void b(AlbumItem albumItem) {
                AlbumPreviewUI.this.a(albumItem);
            }
        };
        this.mYh = getIntent().getStringExtra("send_btn_string");
        findViewById(R.h.cvC).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AlbumPreviewUI.u(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mYb.aOZ();
                x.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", Integer.valueOf(AlbumPreviewUI.this.mYt));
            }
        });
        this.mXX = (TextView) findViewById(R.h.cvD);
        if (this.mYk) {
            showOptionMenu(false);
        }
        enableOptionMenu(false);
        this.mXT = (GridView) findViewById(R.h.cvE);
        this.mXT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                int i2 = 1;
                MediaItem qK;
                ArrayList qJ;
                Intent intent;
                if (c.aOl().aOO() == 0 || c.aOl().aOO() == 5 || c.aOl().aOO() == 10 || c.aOl().aOO() == 11) {
                    if (c.aOl().aOP() == 2) {
                        h.a(AlbumPreviewUI.this, true, AlbumPreviewUI.this.getString(R.l.elV), "", AlbumPreviewUI.this.getString(R.l.dGL), AlbumPreviewUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                MediaItem qK = AlbumPreviewUI.this.mXY.qK(i);
                                if (qK == null) {
                                    x.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", Integer.valueOf(i));
                                    AlbumPreviewUI.this.setResult(0);
                                } else {
                                    x.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                                    Intent intent = new Intent();
                                    intent.setData(Uri.parse("file://" + Uri.encode(qK.hQc)));
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                }
                                AlbumPreviewUI.this.finish();
                            }
                        }, null);
                        return;
                    }
                    qK = AlbumPreviewUI.this.mXY.qK(i);
                    if (qK == null) {
                        x.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", Integer.valueOf(i));
                        AlbumPreviewUI.this.setResult(0);
                    } else {
                        Intent intent2 = new Intent();
                        if (qK.getType() == 2) {
                            intent2.putExtra("is_video", true);
                            intent2.putExtra("video_full_path", qK.hQc);
                        }
                        if (c.aOl().aOO() == 10) {
                            intent2.putExtra("CropImage_OutputPath", qK.hQc);
                        }
                        intent2.setData(Uri.parse(Uri.encode(qK.hQc)));
                        x.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                        AlbumPreviewUI.this.setResult(-1, intent2);
                    }
                    AlbumPreviewUI.this.finish();
                } else if (c.aOl().aOO() == 4) {
                    if (i < AlbumPreviewUI.this.mXY.mXA.size()) {
                        x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        return;
                    }
                    qK = AlbumPreviewUI.this.mXY.qK(i);
                    if (qK == null) {
                        x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    } else if (qK.getType() != 2 || AlbumPreviewUI.this.mXY.mXx.size() == 0) {
                        qJ = AlbumPreviewUI.this.mXY.qJ(qK.getType());
                        c.w(qJ);
                        intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                        intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mXY.aOT());
                        intent.putExtra("preview_all", true);
                        intent.putExtra("preview_position", qJ.indexOf(qK));
                        AlbumPreviewUI.this.F(i - AlbumPreviewUI.this.mXY.mXA.size(), true);
                        intent.putExtra("send_raw_img", AlbumPreviewUI.this.mYm);
                        intent.putExtra("max_select_count", AlbumPreviewUI.this.mYp);
                        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        AlbumPreviewUI.this.startActivityForResult(intent, 0);
                    } else {
                        h.bu(AlbumPreviewUI.this.mController.xRr, com.tencent.mm.bu.a.ac(AlbumPreviewUI.this.mController.xRr, R.l.elp));
                    }
                } else if (AlbumPreviewUI.this.mYn) {
                    if (i < AlbumPreviewUI.this.mXY.mXA.size()) {
                        x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        return;
                    }
                    qK = AlbumPreviewUI.this.mXY.qK(i);
                    if (qK == null) {
                        x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    } else if (qK.getType() != 2 || AlbumPreviewUI.this.mXY.mXx.size() == 0) {
                        qJ = AlbumPreviewUI.this.mXY.qJ(qK.getType());
                        c.w(qJ);
                        intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                        intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mXY.aOT());
                        intent.putExtra("preview_all", true);
                        intent.putExtra("preview_position", qJ.indexOf(qK));
                        AlbumPreviewUI.this.F(i - AlbumPreviewUI.this.mXY.mXA.size(), true);
                        intent.putExtra("send_raw_img", AlbumPreviewUI.this.mYm);
                        String str = "max_select_count";
                        if (qK.getType() != 2) {
                            i2 = AlbumPreviewUI.this.mYp;
                        }
                        intent.putExtra(str, i2);
                        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        AlbumPreviewUI.this.startActivityForResult(intent, 0);
                    } else {
                        h.bu(AlbumPreviewUI.this.mController.xRr, com.tencent.mm.bu.a.ac(AlbumPreviewUI.this.mController.xRr, R.l.elp));
                    }
                } else if (i < AlbumPreviewUI.this.mXY.mXA.size()) {
                    x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                } else {
                    c.w(AlbumPreviewUI.this.mXY.mXw);
                    Intent intent3 = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    intent3.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mXY.aOT());
                    intent3.putExtra("preview_all", true);
                    intent3.putExtra("preview_position", i - AlbumPreviewUI.this.mXY.mXA.size());
                    AlbumPreviewUI.this.F(i - AlbumPreviewUI.this.mXY.mXA.size(), true);
                    intent3.putExtra("send_raw_img", AlbumPreviewUI.this.mYm);
                    intent3.putExtra("max_select_count", AlbumPreviewUI.this.mYp);
                    intent3.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fAJ);
                    intent3.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    AlbumPreviewUI.this.startActivityForResult(intent3, 0);
                }
            }
        });
        this.mXY = new a(this, new a.b() {
            public final void K(int i, int i2, int i3) {
                if (i3 == 0) {
                    MediaItem qK = AlbumPreviewUI.this.mXY.qK(AlbumPreviewUI.this.mXY.mXA.size() + i2);
                    if (qK != null && qK.getType() == 1) {
                        AlbumPreviewUI.a(AlbumPreviewUI.this, qK);
                    } else if (qK != null && qK.getType() == 2) {
                        if (AlbumPreviewUI.this.b(qK)) {
                            AlbumPreviewUI.this.qM(i);
                            AlbumPreviewUI.this.F(i2, true);
                            return;
                        }
                        AlbumPreviewUI.this.mXY.mXx.remove(qK);
                        AlbumPreviewUI.this.mXY.notifyDataSetChanged();
                        return;
                    }
                    AlbumPreviewUI.this.qM(i);
                    AlbumPreviewUI.this.F(i2, true);
                    return;
                }
                AlbumPreviewUI.this.qM(i);
                AlbumPreviewUI.this.F(i2, false);
            }
        });
        if (this.mYi) {
            this.mXY.mXB = true;
        }
        if (this.mYn) {
            this.mXY.mXB = true;
        }
        this.mXT.setNumColumns(4);
        this.mXT.setOnScrollListener(new OnScrollListener() {
            private Runnable mYD = new Runnable() {
                public final void run() {
                    AlbumPreviewUI.this.mXZ.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.xRr, R.a.bqa));
                    AlbumPreviewUI.this.mXZ.setVisibility(8);
                }
            };

            private void fu(boolean z) {
                if (z) {
                    AlbumPreviewUI.this.mXZ.removeCallbacks(this.mYD);
                    if (AlbumPreviewUI.this.mXZ.getVisibility() != 0) {
                        AlbumPreviewUI.this.mXZ.setText(AlbumPreviewUI.this.mXY.qL(AlbumPreviewUI.this.mXT.getFirstVisiblePosition()));
                        AlbumPreviewUI.this.mXZ.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.xRr, R.a.bpZ);
                        AlbumPreviewUI.this.mXZ.setVisibility(0);
                        AlbumPreviewUI.this.mXZ.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                AlbumPreviewUI.this.mXZ.removeCallbacks(this.mYD);
                AlbumPreviewUI.this.mXZ.postDelayed(this.mYD, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                x.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", Integer.valueOf(i));
                if (1 == i) {
                    fu(true);
                } else if (i == 0) {
                    fu(false);
                }
                if (2 == i) {
                    try {
                        AlbumPreviewUI.this.mXv.qI(AlbumPreviewUI.this.hGs);
                        AlbumPreviewUI.this.hGs = AlbumPreviewUI.this.mXv.aOS();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AlbumPreviewUI.this.mXZ.setText(AlbumPreviewUI.this.mXY.qL(i));
            }
        });
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.mXY.a(this.mYy);
        }
        this.mXY.mXz = c.aOl().aOP();
        this.mXY.mXu = this.mYp;
        x.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.mXT.setAdapter(this.mXY);
        updateTitle();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.i("MicroMsg.AlbumPreviewUI", "backBtn");
                AlbumPreviewUI.this.setResult(-2);
                if (AlbumPreviewUI.this.mYb.Od) {
                    AlbumPreviewUI.this.mYb.aOZ();
                } else {
                    AlbumPreviewUI.this.finish();
                }
                return true;
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cIB);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).ygq = new com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a() {
                public final void aOR() {
                    try {
                        AlbumPreviewUI.this.mXv.aOR();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (AlbumPreviewUI.this.mYr) {
                        try {
                            AlbumPreviewUI.this.unbindService(AlbumPreviewUI.this.lwY);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        AlbumPreviewUI.this.mYr = false;
                    }
                }
            };
        }
    }

    private void asx() {
        if (k.c(this.mController.xRr, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            c.aOm().qF(0);
            System.gc();
            return;
        }
        Toast.makeText(this.mController.xRr, getString(R.l.eJI), 1).show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            x.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.mYb.Od) {
                this.mYb.aOZ();
                return true;
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.mYt++;
            this.mYb.aOZ();
            return true;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            x.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.mXY.aOT());
                                            }
                                            x.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.mXW = true;
                                            setResult(-1, intent);
                                            aOW();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.mXY.y(stringArrayListExtra);
                                                    this.mXY.notifyDataSetChanged();
                                                    qM(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.mYm = z;
                                                if (!this.mYm) {
                                                    this.mYd.setImageResource(R.k.dAB);
                                                    break;
                                                } else {
                                                    this.mYd.setImageResource(R.k.dAC);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    x.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    a(albumItem);
                                    setMMTitle(bi.aD(albumItem.mWN, getString(R.l.elj)));
                                }
                            } else if (-1 == i2) {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                x.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", intent);
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    x.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    return;
                                }
                                Serializable arrayList2 = new ArrayList();
                                String str = sightCaptureResult.owh;
                                if (!bi.oN(str)) {
                                    arrayList2.add(str);
                                    intent.putExtra("key_select_video_list", arrayList2);
                                }
                                if (sightCaptureResult.owf && !bi.oN(sightCaptureResult.own)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.own);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            } else {
                                return;
                            }
                        }
                        if (intent != null) {
                            intent.putExtra("GalleryUI_IsSendImgBackground", true);
                            x.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                        setResult(-1, intent);
                        this.mYr = true;
                        finish();
                    } else if (-1 == i2) {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", intent);
                        Serializable arrayList3 = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!bi.oN(stringExtra)) {
                            arrayList3.add(stringExtra);
                            intent.putExtra("key_select_video_list", arrayList3);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    } else {
                        return;
                    }
                } else if (-1 == i2) {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", intent);
                    setResult(-1, intent);
                    finish();
                } else {
                    return;
                }
            } else if (-1 != i2) {
                return;
            } else {
                if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                    x.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                    setResult(-1, intent);
                    finish();
                    return;
                }
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    x.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    return;
                }
                x.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", stringArrayListExtra);
                setResult(-1, intent);
                finish();
            }
        } else if (-1 == i2) {
            String b = k.b(this.mController.xRr.getApplicationContext(), intent, e.gJf);
            if (bi.oN(b)) {
                x.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                return;
            }
            x.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", b);
            if (c.aOl().aOO() == 0 || c.aOl().aOO() == 5 || c.aOl().aOO() == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(b)));
                x.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(b);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.mYm);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.fAJ);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        } else {
            return;
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.mYa.setVisibility(0);
                this.mYa.setText(getString(R.l.eAo));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mController.xRr, R.a.bpZ);
                this.mYa.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    private Runnable mYG = new Runnable() {
                        public final void run() {
                            AlbumPreviewUI.this.mYa.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.xRr, R.a.bqa));
                            AlbumPreviewUI.this.mYa.setVisibility(8);
                        }
                    };

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AlbumPreviewUI.this.mYa.setVisibility(0);
                        AlbumPreviewUI.this.mYa.postDelayed(this.mYG, 4000);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
    }

    private void qM(int i) {
        if (i == 0) {
            this.mXU.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.mXU.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i == 0) {
            this.mXU.setText(R.l.elv);
        } else {
            this.mXU.setText(getString(R.l.elv) + "(" + i + ")");
        }
        updateOptionMenuText(0, qN(i));
    }

    private String qN(int i) {
        switch (c.aOl().aOO()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (i == 0 || this.mYp <= 1) {
                    return getString(R.l.elw);
                }
                return getString(R.l.elw) + "(" + i + "/" + this.mYp + ")";
            default:
                if (i == 0 || this.mYp <= 1) {
                    return getString(R.l.dGL);
                }
                return getString(R.l.elq, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mYp)});
        }
    }

    public final void a(ArrayList<MediaItem> arrayList, long j) {
        if (j != this.mYx) {
            x.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j), Long.valueOf(this.mYx));
            x.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((MediaItem) it.next());
            }
        }
        if (this.mXY != null) {
            Runnable aVar = new a();
            aVar.mYI = new WeakReference(this.mXY);
            aVar.mYJ = new WeakReference(this.inI);
            aVar.mYK = arrayList2;
            c.aOm().y(aVar);
        }
    }

    private void aOW() {
        if (this.mYz) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            x.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.mYf + ", " + this.mYe);
            sharedPreferences.edit().putString(c.aOl().aOP(), this.mYf + "|" + this.mYe + "|" + this.mYg).commit();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    asx();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AlbumPreviewUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private boolean b(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            return false;
        } else if (this.mXv == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            return false;
        } else if (c.aOl().aOO() != 3) {
            return true;
        } else {
            if (new File(mediaItem.hQc).exists()) {
                try {
                    if (this.mXv.Cb(mediaItem.hQc) > 300) {
                        h.bt(this, getString(R.l.elO));
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                }
                return true;
            }
            h.bt(this, getString(R.l.elN));
            return false;
        }
    }
}
