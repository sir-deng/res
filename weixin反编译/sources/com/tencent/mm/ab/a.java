package com.tencent.mm.ab;

public final class a {
    public String appId = "";
    public String filePath = "";
    public String foy = "";
    public int foz = 0;
    public int fromScene = 0;
    public String hmc = "";
    public int hmd = 0;
    public int hme = 0;
    public boolean hmf = false;
    public boolean hmg = false;
    public long hmh = 0;
    public double hmi = 1.0d;
    public d hmj;
    public String processName = "";

    public final boolean a(a aVar) {
        if (aVar == null || this.foy == null || !this.foy.equalsIgnoreCase(aVar.foy) || this.hmc == null || !this.hmc.equalsIgnoreCase(aVar.hmc)) {
            return false;
        }
        return true;
    }
}
