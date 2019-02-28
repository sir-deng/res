package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private int rFd = 0;
    private ArrayList<String> rRr = new ArrayList();
    private HashMap<Integer, Boolean> rRs = new HashMap();

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

    protected void onPause() {
        if (this.rFb != null) {
            this.rFb.onPause();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return g.qNh;
    }

    public final void bCI() {
        Intent intent = new Intent();
        List<b> list = this.rFb.hkf;
        if (list != null) {
            this.rRr.clear();
            for (b bVar : list) {
                Object substring;
                String str = ae.getAccSnsTmpPath() + bVar.fIx.nMq;
                if (bVar.fIx.nMq.startsWith("pre_temp_extend_pic")) {
                    substring = bVar.fIx.nMq.substring(19);
                } else {
                    String substring2 = str;
                }
                this.rRr.add(substring2);
            }
            intent.putExtra("sns_gallery_temp_paths", this.rRr);
            intent.putExtra("sns_update_preview_image_count", this.rRs.size());
            this.rRs.clear();
            setResult(-1, intent);
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
        bCI();
        return true;
    }

    protected final void initView() {
        String aD = bi.aD(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.rRr = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.rRr != null) {
            this.rFd = getIntent().getIntExtra("sns_gallery_position", 0);
            this.rFb = new SnsInfoFlip(this);
            this.rFb.rIg = false;
            this.rFb.rIf = true;
            ae.getAccSnsTmpPath();
            this.rFb.a(ai.bN(this.rRr), aD, this.rFd, this.rEW, this);
            this.rFb.rIw = new c() {
                public final void xZ(int i) {
                    SnsUploadBrowseUI.this.rRs.put(Integer.valueOf(i), Boolean.valueOf(true));
                }
            };
            addView(this.rFb);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    SnsUploadBrowseUI.this.bCI();
                    return true;
                }
            });
            addIconOptionMenu(0, j.dEH, e.qFs, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    h.a(SnsUploadBrowseUI.this, j.qQX, j.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (SnsUploadBrowseUI.this.rFb.bBJ() == 0) {
                                SnsUploadBrowseUI.this.bCI();
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    public final void ck(String str, int i) {
        if (this.rFb != null) {
            this.rFb.aHX();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int getForceOrientation() {
        return 4;
    }

    public final void cl(String str, int i) {
    }
}
