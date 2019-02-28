package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements com.tencent.mm.plugin.gallery.model.g.a {
    ArrayList<AlbumItem> mYL = new ArrayList(0);
    private String naA;
    private a nax;
    private RecyclerView nay;
    AlbumItem naz;

    class a extends android.support.v7.widget.RecyclerView.a<b> implements OnClickListener {
        Context mContext;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.i.drv, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI = SelectAlbumPreviewFolderUI.this;
            AlbumItem albumItem = i == 0 ? selectAlbumPreviewFolderUI.naz : (AlbumItem) selectAlbumPreviewFolderUI.mYL.get(i - 1);
            bVar.nav.setOnClickListener(this);
            bVar.nav.setTag(albumItem);
            if (SelectAlbumPreviewFolderUI.this.naA == null || !(SelectAlbumPreviewFolderUI.this.naA.equals(albumItem.mWN) || (SelectAlbumPreviewFolderUI.this.naA.equals(SelectAlbumPreviewFolderUI.d(SelectAlbumPreviewFolderUI.this)) && i == 0))) {
                bVar.mYQ.setVisibility(4);
            } else {
                bVar.mYQ.setVisibility(0);
            }
            if (i == 0) {
                bVar.mXK.setImageResource(R.g.bEG);
                if (albumItem.mWO != null) {
                    h.a(bVar.mXK, albumItem.mWO.getType(), albumItem.aOC(), albumItem.mWO.hQc, albumItem.aOD());
                }
                bVar.ikM.setText(SelectAlbumPreviewFolderUI.d(SelectAlbumPreviewFolderUI.this));
                bVar.mXK.setVisibility(0);
                bVar.ikM.setVisibility(0);
                bVar.mYP.setVisibility(8);
                return;
            }
            bVar.mXK.setVisibility(0);
            bVar.ikM.setVisibility(0);
            bVar.ikM.setText(albumItem.mWN);
            bVar.mYP.setVisibility(0);
            bVar.mYP.setText(this.mContext.getString(R.l.elr, new Object[]{Integer.valueOf(albumItem.fuA)}));
            if (!(bVar.mDW == null || albumItem.mWO == null)) {
                bVar.mDW.setVisibility(albumItem.mWO.getType() == 2 ? 0 : 8);
            }
            String aOC = albumItem.aOC();
            if (!bi.oN(aOC) && albumItem.mWO != null) {
                h.a(bVar.mXK, albumItem.mWO.getType(), aOC, albumItem.mWO.hQc, albumItem.aOD());
            } else if (albumItem.mWO == null || albumItem.mWO.getType() != 2) {
                x.e("MicroMsg.SelectAlbumPreviewFolderUI", "get folder failed");
                bVar.mXK.setVisibility(8);
                bVar.ikM.setVisibility(8);
            } else {
                h.a(bVar.mXK, albumItem.mWO.getType(), null, albumItem.mWO.hQc, albumItem.aOD());
            }
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getItemCount() {
            return SelectAlbumPreviewFolderUI.this.mYL.size() + 1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
            intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
            intent.setFlags(67108864);
            SelectAlbumPreviewFolderUI.this.setResult(-1, intent);
            SelectAlbumPreviewFolderUI.this.finish();
        }
    }

    class b extends t {
        public TextView ikM = ((TextView) this.nav.findViewById(R.h.ciR));
        public ImageView mDW = ((ImageView) this.nav.findViewById(R.h.cVl));
        public ImageView mXK = ((ImageView) this.nav.findViewById(R.h.ciU));
        public TextView mYP = ((TextView) this.nav.findViewById(R.h.ciQ));
        public ImageView mYQ = ((ImageView) this.nav.findViewById(R.h.ciT));
        public View nav;

        public b(View view) {
            super(view);
            this.nav = view;
        }
    }

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        if (c.aOl().aOP() == 1) {
            return selectAlbumPreviewFolderUI.getString(R.l.eli);
        }
        return c.aOl().aOP() == 3 ? selectAlbumPreviewFolderUI.getString(R.l.elj) : selectAlbumPreviewFolderUI.getString(R.l.elk);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.aOl().b(this);
        c.aOl().a(this);
        c.aOl().aOQ();
        this.nay = (RecyclerView) findViewById(R.h.ciS);
        this.nax = new a(this);
        this.nay.a(new LinearLayoutManager());
        this.nay.a(this.nax);
        this.naA = getIntent().getStringExtra("select_folder_name");
        this.naz = new AlbumItem("", 0);
        this.naz.mWO = new ImageMediaItem();
        setMMTitle(bi.oM(getString(R.l.dFj)));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectAlbumPreviewFolderUI.this.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        c.aOl().b(this);
    }

    protected final int getLayoutId() {
        return R.i.drN;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public final void x(final ArrayList<AlbumItem> arrayList) {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                SelectAlbumPreviewFolderUI.this.mYL.addAll(arrayList);
                SelectAlbumPreviewFolderUI.this.nax.UR.notifyChanged();
            }
        });
    }
}
