package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private int qCc = 1;
    SightDraftContainerView qCd;
    private LinkedList<String> qCe = new LinkedList();

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        b bVar = sightDraftUI.qCd.qBW;
        j jVar = bVar.qBK == null ? null : bVar.qBK.qBS;
        if (jVar != null) {
            String no = k.no(jVar.field_fileName);
            if (!sightDraftUI.qCe.contains(no)) {
                sightDraftUI.qCe.add(no);
                String str = e.gJf + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                x.i("MicroMsg.SightDraftUI", "save src %s dest %s ", no, str);
                FileOp.x(no, str);
                d.b(str, sightDraftUI);
                u.makeText(sightDraftUI, sightDraftUI.getString(R.l.ePZ, new Object[]{e.gJf}), 1).show();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eQa);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.black));
        this.qCd = new SightDraftContainerView(this);
        setContentView(this.qCd);
        this.qCd.btY();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SightDraftUI.this.finish();
                return false;
            }
        });
        SightDraftContainerView sightDraftContainerView = this.qCd;
        a anonymousClass2 = new a() {
            public final void btV() {
                SightDraftUI.this.addTextOptionMenu(SightDraftUI.this.qCc, SightDraftUI.this.getString(R.l.ePU), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        SightDraftUI.b(SightDraftUI.this);
                        return true;
                    }
                });
            }

            public final void btW() {
                SightDraftUI.this.removeOptionMenu(SightDraftUI.this.qCc);
            }
        };
        sightDraftContainerView.qBV = anonymousClass2;
        if (sightDraftContainerView.qBW != null) {
            sightDraftContainerView.qBW.qBE = anonymousClass2;
        }
    }
}
