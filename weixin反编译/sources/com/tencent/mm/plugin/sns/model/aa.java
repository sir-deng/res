package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class aa {
    public static boolean nYp = false;
    public static char[] rba = new char[36];
    private ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (aa.this.raZ >= 5 || System.currentTimeMillis() - aa.this.raY > 300000) {
                x.d("MicroMsg.RemoveSnsTask", "cleanCount: " + aa.this.raZ);
                aa.nYp = false;
            } else if (!aa.this.raX && aa.nYp) {
                new a().m("");
            }
        }
    };
    public boolean raX = false;
    public long raY = 0;
    private int raZ = 0;

    class a extends l<String, String, Boolean> {
        private String aAM;
        private SharedPreferences hbz;
        private String rbc;
        PInt rbd;
        PInt rbe;
        private String rbf;
        private String username;

        public final /* synthetic */ Object bvz() {
            return bvE();
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            x.d("MicroMsg.RemoveSnsTask", "onPostExecute " + bool);
            aa.this.raZ = aa.this.raZ + 1;
            if (bool.booleanValue()) {
                aa.b(this.rbd, this.rbe);
                if (this.hbz != null) {
                    this.hbz.edit().putInt(this.rbc, this.rbd.value).commit();
                    this.hbz.edit().putInt(this.aAM, this.rbe.value).commit();
                    x.d("MicroMsg.RemoveSnsTask", "update dir " + this.rbd.value + " " + this.rbe.value + " cleanCount: " + aa.this.raZ);
                }
                aa.this.handler.sendEmptyMessageDelayed(0, 20000);
            }
            aa.this.raX = false;
        }

        public a() {
            this.hbz = null;
            this.rbc = "";
            this.aAM = "";
            this.rbd = new PInt();
            this.rbe = new PInt();
            this.hbz = ad.getContext().getSharedPreferences("preferences_remove_task", 0);
            g.Dr();
            if (g.Do().CF()) {
                this.username = q.FY();
                this.rbc = "remove_key_base" + this.username;
                this.aAM = "remove_key" + this.username;
                g.Dr();
                if (g.Do().CF() && !ae.bvO() && ae.Fc() != null && ae.bwj() != null) {
                    k LV = ae.bwj().LV(this.username);
                    if (LV != null) {
                        this.rbf = LV.field_bgId;
                    }
                    x.d("MicroMsg.RemoveSnsTask", "my bgid %s", this.rbf);
                    aa.this.raX = true;
                }
            }
        }

        private Boolean bvE() {
            x.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            if (!aa.nYp) {
                return Boolean.valueOf(false);
            }
            if (!aa.this.raX) {
                return Boolean.valueOf(false);
            }
            if (ae.bvO()) {
                aa.nYp = false;
                return Boolean.valueOf(false);
            }
            this.rbd.value = this.hbz.getInt(this.rbc, 0);
            this.rbe.value = this.hbz.getInt(this.aAM, 0);
            String accSnsPath = ae.getAccSnsPath();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!aa.T(accSnsPath + aa.rba[this.rbd.value % 36] + "/" + aa.rba[this.rbe.value % 36], this.rbf, this.username)) {
                    return Boolean.valueOf(false);
                }
                x.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.rbd.value + " " + this.rbe.value);
                return Boolean.valueOf(true);
            } catch (Exception e) {
            }
        }

        public final ag bvy() {
            return ae.bvR();
        }
    }

    static /* synthetic */ boolean T(String str, String str2, String str3) {
        for (FileEntry fileEntry : FileOp.F(str, true)) {
            if (!nYp) {
                x.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                return false;
            } else if (fileEntry.name != null && !bi.oN(str2) && str3 != null && (fileEntry.name.contains(str2) || fileEntry.name.contains(str3))) {
                x.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", str2);
            } else if (bi.bA(fileEntry.timestamp) > 604800000) {
                FileOp.deleteFile(fileEntry.name);
            }
        }
        return true;
    }

    static {
        int i = 0;
        int i2 = 48;
        while (i2 <= 57) {
            rba[i] = (char) i2;
            i2++;
            i++;
        }
        i2 = 97;
        while (i2 <= 122) {
            rba[i] = (char) i2;
            i2++;
            i++;
        }
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }
}
