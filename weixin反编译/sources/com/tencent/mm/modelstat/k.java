package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class k {
    private static final String hTT;
    int fEo = -2;
    public int hTA = 0;
    public int hTB = 0;
    public int hTC = 0;
    public int hTD = 0;
    public int hTE = 0;
    public int hTF = 0;
    public int hTG = 0;
    public int hTH = 0;
    public int hTI = 0;
    public int hTJ = 0;
    public int hTK = 0;
    public int hTL = 0;
    public int hTM = 0;
    public int hTN = 0;
    public int hTO = 0;
    public int hTP = 0;
    public int hTQ = 0;
    public int hTR = 0;
    public int hTS = 0;
    public int hTq = 0;
    public int hTr = 0;
    public int hTs = 0;
    public int hTt = 0;
    public int hTu = 0;
    public int hTv = 0;
    public int hTw = 0;
    public int hTx = 0;
    public int hTy = 0;
    public int hTz = 0;
    public int id = 0;

    public final void b(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.hTq = cursor.getInt(1);
        this.hTr = cursor.getInt(2);
        this.hTs = cursor.getInt(3);
        this.hTt = cursor.getInt(4);
        this.hTu = cursor.getInt(5);
        this.hTv = cursor.getInt(6);
        this.hTw = cursor.getInt(7);
        this.hTx = cursor.getInt(8);
        this.hTy = cursor.getInt(9);
        this.hTz = cursor.getInt(10);
        this.hTA = cursor.getInt(11);
        this.hTB = cursor.getInt(12);
        this.hTC = cursor.getInt(13);
        this.hTD = cursor.getInt(14);
        this.hTE = cursor.getInt(15);
        this.hTF = cursor.getInt(16);
        this.hTG = cursor.getInt(17);
        this.hTH = cursor.getInt(18);
        this.hTI = cursor.getInt(19);
        this.hTJ = cursor.getInt(20);
        this.hTK = cursor.getInt(21);
        this.hTL = cursor.getInt(22);
        this.hTM = cursor.getInt(23);
        this.hTN = cursor.getInt(24);
        this.hTO = cursor.getInt(25);
        this.hTP = cursor.getInt(26);
        this.hTQ = cursor.getInt(27);
        this.hTR = cursor.getInt(28);
        this.hTS = cursor.getInt(29);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        hTT = stringBuilder.toString();
    }

    public final String toString() {
        return String.format(hTT, new Object[]{Integer.valueOf(this.hTz), Integer.valueOf(this.hTP), Integer.valueOf(this.hTB), Integer.valueOf(this.hTL), Integer.valueOf(this.hTR), Integer.valueOf(this.hTN), Integer.valueOf(this.hTA), Integer.valueOf(this.hTQ), Integer.valueOf(this.hTC), Integer.valueOf(this.hTM), Integer.valueOf(this.hTS), Integer.valueOf(this.hTO), Integer.valueOf(this.hTr), Integer.valueOf(this.hTs), Integer.valueOf(this.hTD), Integer.valueOf(this.hTE), Integer.valueOf(this.hTt), Integer.valueOf(this.hTu), Integer.valueOf(this.hTF), Integer.valueOf(this.hTG), Integer.valueOf(this.hTv), Integer.valueOf(this.hTw), Integer.valueOf(this.hTH), Integer.valueOf(this.hTI), Integer.valueOf(this.hTx), Integer.valueOf(this.hTy), Integer.valueOf(this.hTJ), Integer.valueOf(this.hTK)});
    }
}
