package com.tencent.mm.plugin.backup.a;

import android.content.SharedPreferences;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean gQS = false;
    private static int kor = 0;
    private static byte[] kos = "key".getBytes();
    private static SharedPreferences kou;
    public String kon = SlookAirButtonFrequentContactAdapter.ID;
    public String koo = "hello";
    public String kop = "ok";
    public e koq;
    public byte[] kot;

    public abstract void aoT();

    public abstract void aoU();

    public abstract void j(Object... objArr);

    public final e aoS() {
        if (this.koq == null) {
            this.koq = new e();
        }
        return this.koq;
    }

    public static int aoV() {
        return kor;
    }

    public static void mS(int i) {
        kor = i;
    }

    public static byte[] aoW() {
        return kos;
    }

    public static void Z(byte[] bArr) {
        kos = bArr;
    }

    public static SharedPreferences aoX() {
        if (kou == null) {
            kou = ad.getContext().getSharedPreferences("BACKUP_CONFIG", 4);
        }
        return kou;
    }

    public static void aoY() {
        x.i(TAG, "holdReset");
        gQS = true;
    }

    public static boolean aoZ() {
        return gQS;
    }

    public static void apa() {
        kos = "key".getBytes();
        kor = 0;
        kou = null;
        gQS = false;
    }
}
