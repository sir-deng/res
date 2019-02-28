package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.XWalkUpdater;

public final class f {
    public static final int jzB = 1;
    private static final /* synthetic */ int[] jzC = new int[]{jzB};

    public static void bL(int i, int i2) {
        x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo report VoiceJoint result starVoiceId: %d, result: %d", Integer.valueOf(i), Integer.valueOf(i2));
        g.pWK.h(15228, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void ahT() {
        g.pWK.h(818, 3);
    }

    public static void kP(int i) {
        if (i != 1) {
            x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo idKey report voiceSplitResult result: %d", Integer.valueOf(i));
            g.pWK.h(818, 9);
            if (i == -100) {
                g.pWK.h(818, 12);
            } else if (i == XWalkUpdater.ERROR_SET_VERNUM) {
                g.pWK.h(818, 8);
            } else if (i == -102) {
                g.pWK.h(818, 10);
            } else if (i == -103) {
                g.pWK.h(818, 33);
            } else if (i == -104) {
                g.pWK.h(818, 13);
            } else if (i == -105) {
                g.pWK.h(818, 14);
            } else if (i == -110) {
                g.pWK.h(818, 31);
            } else {
                g.pWK.h(818, 11);
            }
        }
    }

    public static void kQ(int i) {
        x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo idKey report voiceJointResult result: %d", Integer.valueOf(i));
        if (i == 1) {
            g.pWK.h(818, 29);
        } else if (i == -200) {
            g.pWK.h(818, 4);
        }
    }

    public static void ahU() {
        g.pWK.h(818, 28);
    }

    public static void ahV() {
        g.pWK.h(818, 26);
    }

    public static void kR(int i) {
        if (i == 8025) {
            g.pWK.h(818, 25);
        } else if (i == 8026) {
            g.pWK.h(818, 27);
        }
    }

    public static void x(int i, boolean z) {
        if (z) {
            g.pWK.h(818, 5);
        }
        if (i != 0) {
            g.pWK.h(818, z ? 6 : 7);
        }
    }

    public static void kS(int i) {
        x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo idKey report voiceUploadResult errCode: %d", Integer.valueOf(i));
        if (i == 8017) {
            g.pWK.h(818, 15);
        } else if (i == 8018) {
            g.pWK.h(818, 16);
        } else if (i == 8024) {
            g.pWK.h(818, 17);
        } else if (i == 8020) {
            g.pWK.h(818, 18);
        } else if (i == 8009) {
            g.pWK.h(818, 19);
        } else if (i == 8008) {
            g.pWK.h(818, 20);
        } else if (i == 8023) {
            g.pWK.h(818, 21);
        } else if (i == 8019) {
            g.pWK.h(818, 22);
        } else if (i == 8022) {
            g.pWK.h(818, 23);
        } else if (i == 8021) {
            g.pWK.h(818, 24);
        }
    }

    public static void kT(int i) {
        if (i == 1) {
            g.pWK.h(841, 0);
        } else if (i == 3) {
            g.pWK.h(841, 1);
        } else if (i == 2) {
            g.pWK.h(841, 2);
        }
    }

    public static void kU(int i) {
        if (i == 1) {
            g.pWK.h(841, 3);
        } else if (i == 2) {
            g.pWK.h(841, 4);
        } else if (i == 3) {
            g.pWK.h(841, 5);
        }
    }

    public static void kV(int i) {
        if (i == 1) {
            g.pWK.h(841, 6);
        } else if (i == 2) {
            g.pWK.h(841, 7);
        } else if (i == 3) {
            g.pWK.h(841, 8);
        }
    }

    public static void kW(int i) {
        x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo idKeyReportGetResPathResult %d", Integer.valueOf(i));
        if (i == 8015 || i == 8012) {
            g.pWK.h(841, 15);
        }
    }

    public static void kX(int i) {
        if (i == 1) {
            g.pWK.h(841, 9);
        } else if (i == 2) {
            g.pWK.h(841, 10);
        } else if (i == 3) {
            g.pWK.h(841, 11);
        }
    }

    public static void kY(int i) {
        if (i == 1) {
            g.pWK.h(841, 12);
        } else if (i == 2) {
            g.pWK.h(841, 13);
        } else if (i == 3) {
            g.pWK.h(841, 14);
        }
    }

    public static void ahW() {
        g.pWK.h(818, 32);
    }

    public static void kZ(int i) {
        x.i("MicroMsg.VoiceSplitJointReporter", "alvinluo kvReportGetResPathResult %d", Integer.valueOf(i));
        g.pWK.h(15316, Integer.valueOf(i));
    }
}
