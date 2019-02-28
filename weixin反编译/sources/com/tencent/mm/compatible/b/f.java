package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.f.a.jl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class f {
    private static volatile f gDL = null;
    private static boolean gDO = false;
    public static boolean gDP = false;
    private static boolean gDQ = false;
    private static boolean gDR = false;
    private static int gDX = 0;
    private static int gDY = 0;
    private static HashMap<Integer, String> gDZ = new HashMap();
    private static int gEa = 0;
    private static int gEb = 0;
    private static HashMap<Integer, String> gEc = new HashMap();
    private static int gEd = 0;
    private static int gEe = 0;
    private static HashMap<Integer, String> gEf = new HashMap();
    public final AudioManager gDM;
    private int gDN = -1;
    private int gDS = 0;
    private final Set<a> gDT = new HashSet();
    private final int gDU = 1000;
    private ag gDV = new ag() {
        public final void handleMessage(Message message) {
            x.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            f.this.fy(3);
        }
    };
    private int gDW = -1;

    public interface a {
        void er(int i);
    }

    public static f xN() {
        if (gDL == null) {
            synchronized (f.class) {
                if (gDL == null) {
                    gDL = new f(ad.getContext());
                }
            }
        }
        return gDL;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.gDT.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.gDT.remove(aVar);
        }
    }

    public final void fy(int i) {
        x.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.gDN));
        for (a er : this.gDT) {
            er.er(i);
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public f(Context context) {
        this.gDM = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        x.i("MicroMsg.MMAudioManager", "init dkbt %s", xW());
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
                f.this.fy(7);
            }
        }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("state", -1);
                int intExtra2 = intent.getIntExtra("microphone", -1);
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 0) {
                    f.this.fy(6);
                } else if (intExtra == 1) {
                    f.this.xQ();
                }
            }
        }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    f.gDQ = intent.getBooleanExtra("existing", false);
                    x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + f.gDQ);
                }
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                if (com.tencent.mm.compatible.util.f.fO(11)) {
                    f.gDO = true;
                    f.this.gDV.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                f.gDO = false;
                if (q.gHP.gGo == 1) {
                    com.tencent.mm.compatible.c.a.a(f.this.gDM);
                }
                f.this.fy(4);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (com.tencent.mm.compatible.util.f.fN(11)) {
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                        if (intExtra == 2) {
                            f.gDO = true;
                            f.this.gDV.sendEmptyMessageDelayed(0, 1000);
                        } else if (intExtra == 0) {
                            f.gDO = false;
                            if (q.gHP.gGo == 1) {
                                com.tencent.mm.compatible.c.a.a(f.this.gDM);
                            }
                            f.this.fy(4);
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    public final void xO() {
        x.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", xW());
        gDP = false;
        fy(2);
    }

    public final int xP() {
        this.gDN = -1;
        if (!xV()) {
            return -1;
        }
        boolean z;
        x.k("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", xW());
        AudioManager audioManager = this.gDM;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            z = false;
        } else if (ar.ve()) {
            z = false;
        } else {
            x.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(q.gHP.gGq));
            if ((q.gHP.gGq == 1 || q.gHP.gGq == -1) && !audioManager.isBluetoothScoOn()) {
                x.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", bi.chl());
                audioManager.startBluetoothSco();
            }
            z = true;
        }
        x.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", xW(), Boolean.valueOf(z));
        x.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + xW() + " ret:" + z);
        x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(xS()));
        if (xS()) {
            return 1;
        }
        return 0;
    }

    public final void xQ() {
        gDP = false;
        x.k("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", xW());
        com.tencent.mm.compatible.c.a.a(this.gDM);
        this.gDV.removeCallbacksAndMessages(Integer.valueOf(1));
        x.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", xW());
    }

    public static boolean xR() {
        return false;
    }

    public final boolean xS() {
        return this.gDM.isBluetoothScoOn() || this.gDM.isBluetoothA2dpOn() || gDP;
    }

    @TargetApi(14)
    private static boolean xT() {
        try {
            if (VERSION.SDK_INT >= 14) {
                x.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    return true;
                }
                return false;
            } else if (gDO) {
                return true;
            } else {
                if (q.gHP.gGz == 1) {
                    return BluetoothAdapter.getDefaultAdapter().isEnabled();
                }
                return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int bc(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        return xS() ? 0 : i;
    }

    public static int xU() {
        ((AudioManager) ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isBluetoothScoOn();
        return 0;
    }

    public static boolean xV() {
        x.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + gDQ + " , isUseHTCAccessory = " + gDR);
        if (gDQ && !gDR) {
            return false;
        }
        x.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + gDO);
        if (xT()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                x.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                return false;
            } else if (defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices == null || bondedDevices.size() == 0) {
                    x.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                    return false;
                }
                boolean z;
                for (BluetoothDevice bondState : bondedDevices) {
                    if (bondState.getBondState() == 12) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.valueOf(true));
                    return true;
                }
                x.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                return false;
            } else {
                x.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                return false;
            }
        }
        x.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + gDO + " , isConnectHeadset() = " + xT());
        return false;
    }

    public final String xW() {
        return "mode:" + (this.gDM != null ? this.gDM.getMode() : 0) + " isSpeakerphoneOn:" + this.gDM.isSpeakerphoneOn() + " isBluetoothOn:" + xS() + " btStatus:" + this.gDN;
    }

    public final boolean xX() {
        return this.gDM.getMode() == 0;
    }

    @TargetApi(11)
    public final boolean h(boolean z, boolean z2) {
        boolean z3 = true;
        int i = 0;
        int mode = this.gDM.getMode();
        x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(xX()), Boolean.valueOf(z), xW());
        if (ar.ve()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.gDN));
            return false;
        } else if (xS() || gDP) {
            x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                x.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            return false;
        } else {
            yb();
            if (z2) {
                if (q.gHG.gEr) {
                    if (q.gHG.yi()) {
                        if (q.gHG.gEt >= 0) {
                            setMode(q.gHG.gEt);
                        } else if (q.gHG.gEu >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.gHG.gEv <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.gHG.yj()) {
                        if (z) {
                            if (q.gHG.ym()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.gHG.yl() < 0) {
                                return z;
                            }
                            setMode(q.gHG.yl());
                            return z;
                        }
                        if (q.gHG.yo()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.gHG.yn() < 0) {
                            return z;
                        }
                        setMode(q.gHG.yn());
                        return z;
                    }
                }
            } else if (q.gHG.gEr && q.gHG.yk()) {
                b bVar;
                if (z) {
                    boolean z4;
                    bVar = q.gHG;
                    if (bVar.yk()) {
                        mode = bVar.gEx & 16;
                        x.d("VoipAudioInfo", "enableSpeaker " + (mode > 0));
                        if (mode > 0) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        setSpeakerphoneOn(true);
                    }
                    if (q.gHG.yp() < 0) {
                        return z;
                    }
                    setMode(q.gHG.yp());
                    return z;
                }
                bVar = q.gHG;
                if (bVar.yk()) {
                    mode = bVar.gEx & 1;
                    x.d("VoipAudioInfo", "disableSpeaker " + (mode > 0));
                    if (mode <= 0) {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    setSpeakerphoneOn(false);
                }
                if (q.gHG.yq() < 0) {
                    return z;
                }
                setMode(q.gHG.yq());
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (xX() == z) {
                    return z;
                }
                if (z) {
                    setMode(0);
                    return z;
                } else if (VERSION.SDK_INT >= 11 && l.xn() && 2 != q.gHP.gGA) {
                    setMode(3);
                    return z;
                } else if (VERSION.SDK_INT >= 11) {
                    setMode(3);
                    return z;
                } else {
                    setMode(2);
                    return z;
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (q.gHG.gER >= 0) {
                    i = q.gHG.gER;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
                if (i != this.gDM.getMode()) {
                    setMode(i);
                }
                if (i != this.gDM.getMode()) {
                    if (this.gDS == 0) {
                        this.gDS = 1;
                    } else if (this.gDS == 2) {
                        this.gDS = 3;
                    }
                }
                if (this.gDM.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (q.gHP.gGz == 1) {
                    x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.xn() && 2 == q.gHP.gGA) {
                    mode = 2;
                }
                if (q.gHG.gES >= 0) {
                    mode = q.gHG.gES;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + mode);
                if (mode != this.gDM.getMode()) {
                    setMode(mode);
                }
                if (mode != this.gDM.getMode()) {
                    if (this.gDS == 0) {
                        this.gDS = 2;
                    } else if (this.gDS == 1) {
                        this.gDS = 3;
                    }
                }
                if (!this.gDM.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    @TargetApi(11)
    public final boolean bd(boolean z) {
        int i = 3;
        int i2 = 0;
        x.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(xX()), Boolean.valueOf(z), xW());
        if (ar.ve()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.gDN));
            return false;
        } else if (gDP) {
            setMode(3);
            return false;
        } else {
            yb();
            if (!q.gHG.gFq) {
                if (q.gHG.gEr) {
                    if (q.gHG.yi()) {
                        if (q.gHG.gEt >= 0) {
                            setMode(q.gHG.gEt);
                        } else if (q.gHG.gEu >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.gHG.gEv <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.gHG.yj()) {
                        if (z) {
                            if (q.gHG.ym()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.gHG.yl() < 0) {
                                return z;
                            }
                            setMode(q.gHG.yl());
                            return z;
                        }
                        if (q.gHG.yo()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.gHG.yn() < 0) {
                            return z;
                        }
                        setMode(q.gHG.yn());
                        return z;
                    }
                }
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (q.gHG.gER >= 0) {
                        i2 = q.gHG.gER;
                    }
                    x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                    if (i2 != this.gDM.getMode()) {
                        setMode(i2);
                    }
                    if (this.gDM.isSpeakerphoneOn()) {
                        return z;
                    }
                    setSpeakerphoneOn(true);
                    return z;
                }
                if (VERSION.SDK_INT < 11) {
                    if (q.gHP.gGz == 1) {
                        x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.xn() && 2 == q.gHP.gGA) {
                    i = 2;
                }
                if (q.gHG.gES >= 0) {
                    i = q.gHG.gES;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gDM.getMode()) {
                    setMode(i);
                }
                if (!this.gDM.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (q.gHG.gFr >= 0) {
                    i2 = q.gHG.gFr;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                if (i2 != this.gDM.getMode()) {
                    setMode(i2);
                }
                if (this.gDM.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (q.gHP.gGz == 1) {
                        x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (q.gHG.gFs >= 0) {
                    i = q.gHG.gFs;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gDM.getMode()) {
                    setMode(i);
                }
                if (!this.gDM.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    public final boolean b(boolean z, int i) {
        int streamMaxVolume = this.gDM.getStreamMaxVolume(i);
        x.d("MicroMsg.MMAudioManager", "maxVolumn:" + streamMaxVolume);
        streamMaxVolume /= 3;
        int streamVolume = this.gDM.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            this.gDM.setStreamVolume(i, streamMaxVolume, 0);
        }
        x.i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        return h(z, true);
    }

    public final boolean xY() {
        if (this.gDM != null) {
            return this.gDM.isWiredHeadsetOn();
        }
        return false;
    }

    public final void fz(int i) {
        if (this.gDM != null) {
            this.gDM.adjustStreamVolume(i, 1, 5);
        }
    }

    public final void fA(int i) {
        if (this.gDM != null) {
            this.gDM.adjustStreamVolume(i, -1, 5);
        }
    }

    public final void xZ() {
        if (this.gDM != null) {
            this.gDM.setStreamMute(3, true);
        }
    }

    public final void ya() {
        if (this.gDM != null) {
            this.gDM.setStreamMute(3, false);
        }
    }

    private void yb() {
        if (this.gDM != null) {
            int mode = this.gDM.getMode();
            boolean isSpeakerphoneOn = this.gDM.isSpeakerphoneOn();
            Object fI = com.tencent.mm.compatible.e.l.yu().fI(98305);
            Object fI2 = com.tencent.mm.compatible.e.l.yu().fI(94209);
            if (fI == null) {
                com.tencent.mm.compatible.e.l.yu().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + isSpeakerphoneOn);
            }
            if (fI2 == null) {
                com.tencent.mm.compatible.e.l.yu().set(94209, Integer.valueOf(mode));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + mode);
            }
        }
    }

    @Deprecated
    public final void yc() {
        if (this.gDM != null) {
            Object fI = com.tencent.mm.compatible.e.l.yu().fI(98305);
            Object fI2 = com.tencent.mm.compatible.e.l.yu().fI(94209);
            if (fI != null) {
                x.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + fI);
                setSpeakerphoneOn(((Boolean) fI).booleanValue());
                com.tencent.mm.compatible.e.l.yu().set(98305, null);
            }
            if (fI2 != null) {
                int i;
                try {
                    x.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + fI2 + ",inmode:0");
                    i = bi.getInt(String.valueOf(fI2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                com.tencent.mm.compatible.e.l.yu().set(94209, null);
            }
        }
    }

    public final void setMode(int i) {
        if (this.gDM != null) {
            x.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.gDM.getMode()), Integer.valueOf(i));
            this.gDM.setMode(i);
        }
    }

    public final void setSpeakerphoneOn(boolean z) {
        x.k("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + z, new Object[0]);
        if (this.gDM != null) {
            x.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + z);
            this.gDM.setSpeakerphoneOn(z);
        }
    }

    public final int yd() {
        int i = this.gDS;
        this.gDS = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        if (this.gDM != null) {
            return this.gDM.getStreamMaxVolume(i);
        }
        return 5;
    }

    public final int getStreamVolume(int i) {
        if (this.gDM != null) {
            return this.gDM.getStreamVolume(i);
        }
        return -1;
    }

    public final void aM(int i, int i2) {
        if (this.gDM != null) {
            x.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            this.gDM.setStreamVolume(i, i2, 0);
        }
    }

    public final int ye() {
        if (this.gDW == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.gDM == null)) {
                    this.gDW = field.getInt(this.gDM);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.gDW = 6;
            }
        }
        return this.gDW;
    }

    public static void fB(int i) {
        gDX++;
        x.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gDX), Integer.valueOf(gDY));
        gDZ.put(Integer.valueOf(i), new aj().toString());
        yf();
    }

    public static void fC(int i) {
        gDY++;
        x.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gDX), Integer.valueOf(gDY));
        gDZ.remove(Integer.valueOf(i));
    }

    public static void fD(int i) {
        gEa++;
        x.k("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gEa), Integer.valueOf(gEb));
        gEc.put(Integer.valueOf(i), new aj().toString());
        yf();
    }

    public static void fE(int i) {
        if (gEc.containsKey(Integer.valueOf(i))) {
            gEb++;
            x.k("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gEa), Integer.valueOf(gEb));
            gEc.remove(Integer.valueOf(i));
        }
    }

    public static void fF(int i) {
        gEd++;
        x.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gEd), Integer.valueOf(gEe));
        gEf.put(Integer.valueOf(i), new aj().toString());
        yf();
    }

    public static void fG(int i) {
        gEe++;
        x.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gEd), Integer.valueOf(gEe));
        gEf.remove(Integer.valueOf(i));
    }

    private static void yf() {
        com.tencent.mm.sdk.b.b jlVar = new jl();
        if (gDX - gDY > 1) {
            jlVar.fAS.fAT = true;
            jlVar.fAS.fAU = gDZ.size();
        }
        if (gEd - gEe > 1) {
            jlVar.fAS.fAV = true;
            jlVar.fAS.fAW = gEf.size();
        }
        if (gEa - gEb > 1) {
            jlVar.fAS.fAX = true;
            jlVar.fAS.fAY = gEc.size();
        }
        if (jlVar.fAS.fAV || jlVar.fAS.fAT || jlVar.fAS.fAX) {
            x.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(jlVar.fAS.fAT), Integer.valueOf(jlVar.fAS.fAU), Boolean.valueOf(jlVar.fAS.fAV), Integer.valueOf(jlVar.fAS.fAW), Boolean.valueOf(jlVar.fAS.fAX), Integer.valueOf(jlVar.fAS.fAY));
            com.tencent.mm.sdk.b.a.xmy.m(jlVar);
        }
    }

    public static String yg() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(gDZ.size()).append("init: ").append(gDX).append("release: ").append(gDY).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gDZ.isEmpty()) {
            for (String append : gDZ.values()) {
                stringBuffer.append(append).append("\r\n");
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(gEf.size()).append("init: ").append(gEd).append("release: ").append(gEe).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gEf.isEmpty()) {
            for (String append2 : gEf.values()) {
                stringBuffer.append(append2).append("\r\n");
            }
        }
        stringBuffer.append("AudioRecord: \r\n");
        stringBuffer.append("leak: ").append(gEc.size()).append("init: ").append(gEa).append("release: ").append(gEa).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gEc.isEmpty()) {
            for (String append22 : gEc.values()) {
                stringBuffer.append(append22).append("\r\n");
            }
        }
        x.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        return stringBuffer.toString();
    }
}
