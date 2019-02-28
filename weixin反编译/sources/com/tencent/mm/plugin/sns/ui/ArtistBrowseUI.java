package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ay.n;
import com.tencent.mm.ay.r;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String nWh = "";
    private String rwO = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        if (this.rFb != null) {
            this.rFb.bBI();
            this.rFb.onDestroy();
        }
        ae.bwc().K(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.rFb != null) {
            this.rFb.aHX();
        }
    }

    protected final int getLayoutId() {
        return g.qNr;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rEY.rzl);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        this.nWh = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        r.QO();
        this.rwO = n.QL();
        u(false, 2);
        this.rFb = new SnsInfoFlip(this);
        List eh = ai.eh(this.nWh, this.rwO);
        this.rFb.rIf = true;
        this.rFb.a(eh, "", intExtra, this.rEW, this);
        addView(this.rFb);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ArtistBrowseUI.this.rEY.bzZ();
                return true;
            }
        });
        setMMTitle(j.qSH);
        showOptionMenu(false);
        this.rEW.ryQ = new s.a() {
            public final void bzG() {
                are bzY = ArtistBrowseUI.this.rFb.bzY();
                if (bzY != null) {
                    x.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + bzY.nMq);
                    b ix = b.ix(723);
                    ix.mF(bzY.nlE);
                    ix.SE();
                    if (FileOp.bO(am.r(ae.getAccSnsPath(), bzY.nMq) + i.l(bzY))) {
                        av bwb = ae.bwb();
                        if (!(bwb.bvL() == null || bwb.bvL().equals(""))) {
                            String str = am.r(ae.getAccSnsPath(), bzY.nMq) + i.l(bzY);
                            String r = am.r(ae.getAccSnsPath(), bwb.bvL());
                            if (FileOp.bO(str)) {
                                x.d("MicroMsg.UploadManager", "bg file is exist!'");
                                FileOp.ml(r);
                                FileOp.deleteFile(r + bwb.bvL() + "bg_");
                                FileOp.deleteFile(r + bwb.bvL() + "tbg_");
                                FileOp.x(str, r + bwb.bvL() + "bg_");
                            } else {
                                FileOp.deleteFile(r + bwb.bvL() + "bg_");
                                FileOp.deleteFile(r + bwb.bvL() + "tbg_");
                                x.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                            }
                            l bwj = ae.bwj();
                            r = bwb.bvL();
                            String str2 = bzY.nMq;
                            k LV = bwj.LV(r);
                            LV.field_bgId = str2;
                            bwj.c(LV);
                        }
                        bwb.bwN();
                        aw awVar = new aw(7);
                        bzY.wEV = 1;
                        awVar.reu.wYj.wfh.add(bzY);
                        awVar.xf(2);
                        awVar.commit();
                        Intent intent = new Intent();
                        intent.setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
                        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.addFlags(67108864);
                        ArtistBrowseUI.this.startActivity(intent);
                        ArtistBrowseUI.this.finish();
                    }
                }
            }
        };
    }

    protected void onPause() {
        if (this.rFb != null) {
            this.rFb.onPause();
        }
        super.onPause();
    }

    public final void ck(String str, int i) {
        if (this.rFb != null) {
            this.rFb.aHX();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            this.rEY.xJ(intent.getIntExtra("sns_gallery_op_id", 0));
        }
    }

    public final void cl(String str, int i) {
    }
}
