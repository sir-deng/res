package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.ar;
import java.io.File;

public class FaceDebugUI extends MMPreference {
    private f inW;
    private View lHV;
    private CheckBoxPreference moj = null;
    private CheckBoxPreference mok = null;
    private CheckBoxPreference mol = null;
    private CheckBoxPreference mom = null;
    private CheckBoxPreference mon = null;
    private CheckBoxPreference moo = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lHV = findViewById(e.cws);
        this.lHV.setBackgroundResource(b.white);
        aHL();
        setMMTitle(getString(h.mjD));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FaceDebugUI.this.finish();
                return false;
            }
        });
    }

    private void aHL() {
        this.inW = this.yrJ;
        this.moj = (CheckBoxPreference) this.inW.Zu("face_debug_switch");
        this.mok = (CheckBoxPreference) this.inW.Zu("face_debug_save_pic_switch");
        this.mol = (CheckBoxPreference) this.inW.Zu("face_debug_save_final_switch");
        this.mom = (CheckBoxPreference) this.inW.Zu("face_debug_save_lipreading_switch");
        this.mon = (CheckBoxPreference) this.inW.Zu("face_debug_save_voice_switch");
        this.moo = (CheckBoxPreference) this.inW.Zu("face_debug_force_upload_video");
        this.inW.notifyDataSetChanged();
    }

    protected void onResume() {
        super.onResume();
        aHM();
    }

    protected void onStop() {
        super.onStop();
    }

    private void aHM() {
        boolean aHb = com.tencent.mm.plugin.facedetect.model.e.aHb();
        boolean aHd = com.tencent.mm.plugin.facedetect.model.e.aHd();
        boolean aHe = com.tencent.mm.plugin.facedetect.model.e.aHe();
        boolean aHf = com.tencent.mm.plugin.facedetect.model.e.aHf();
        boolean aHg = com.tencent.mm.plugin.facedetect.model.e.aHg();
        boolean aHc = com.tencent.mm.plugin.facedetect.model.e.aHc();
        if (aHb) {
            this.moj.mC(true);
            this.inW.bl("face_debug_save_pic_switch", false);
            this.inW.bl("face_debug_save_final_switch", false);
            this.inW.bl("face_debug_save_lipreading_switch", false);
            this.inW.bl("face_debug_save_voice_switch", false);
            this.inW.bl("face_debug_force_upload_video", false);
            this.mok.mC(aHd);
            this.mol.mC(aHe);
            this.mom.mC(aHf);
            this.mon.mC(aHg);
            this.moo.mC(aHc);
        } else {
            this.moj.mC(false);
            this.inW.bl("face_debug_save_pic_switch", true);
            this.inW.bl("face_debug_save_final_switch", true);
            this.inW.bl("face_debug_save_lipreading_switch", true);
            this.inW.bl("face_debug_save_voice_switch", true);
            this.inW.bl("face_debug_force_upload_video", true);
        }
        this.inW.notifyDataSetChanged();
    }

    public final int XK() {
        return i.mkq;
    }

    public final boolean a(f fVar, Preference preference) {
        aHL();
        File file;
        if ("face_debug_switch".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eR(this.moj.isChecked());
            aHM();
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eS(this.mok.isChecked());
            aHM();
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eT(this.mol.isChecked());
            aHM();
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eU(this.mom.isChecked());
            aHM();
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eV(this.mon.isChecked());
            aHM();
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.idX)) {
            com.tencent.mm.plugin.facedetect.model.e.eW(this.moo.isChecked());
            aHM();
            return true;
        } else if ("face_debug_clear_resource".equals(preference.idX)) {
            file = new File(o.pQ(0));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(o.pQ(1));
            if (file2.exists()) {
                file2.delete();
            }
            ar.hhz.S("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            ar.hhz.S("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            return true;
        } else if (!"face_debug_check_resource".equals(preference.idX)) {
            return false;
        } else {
            file = new File(o.pQ(0));
            File file3 = new File(o.pQ(1));
            u.makeText(this.mController.xRr, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(file.exists()), Boolean.valueOf(file3.exists())}), 0).show();
            x.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", g.i(file));
            x.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", g.i(file3));
            return true;
        }
    }
}
