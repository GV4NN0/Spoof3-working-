package com.example.spoof;

public class Presets {
    // name, manufacturer, brand, model, device, product, hardware, board, fingerprint
    public static final String[][] ALL = {
        {"Galaxy S24", "samsung", "samsung", "SM-S921B", "e1s", "e1sxeea", "s5e9945", "s5e9945",
         "samsung/e1sxeea/e1s:14/UP1A.231005.007/S921BXXU1AXBA:user/release-keys"},
        {"Galaxy S24 Ultra", "samsung", "samsung", "SM-S928B", "e3s", "e3sxeea", "qcom", "pineapple",
         "samsung/e3sxeea/e3s:14/UP1A.231005.007/S928BXXU1AXBA:user/release-keys"},
        {"Galaxy S23 Ultra", "samsung", "samsung", "SM-S918B", "dm3q", "dm3qxeea", "qcom", "kalama",
         "samsung/dm3qxeea/dm3q:14/UP1A.231005.007/S918BXXU3CXBA:user/release-keys"},
        {"Pixel 8 Pro", "Google", "google", "Pixel 8 Pro", "husky", "husky", "husky", "husky",
         "google/husky/husky:14/UP1A.231005.007/10754064:user/release-keys"},
        {"Pixel 9 Pro", "Google", "google", "Pixel 9 Pro", "caiman", "caiman", "caiman", "caiman",
         "google/caiman/caiman:14/AD1A.240905.004/12150698:user/release-keys"},
        {"Redmi Note 13 Pro+", "Xiaomi", "Redmi", "23090RA98G", "zircon", "zircon_global", "mt6886", "mt6886",
         "Redmi/zircon_global/zircon:14/UP1A.230905.011/V816.0.9.0.UNRMIXM:user/release-keys"},
        {"RedMagic 10 Pro", "nubia", "nubia", "NX789J", "NX789J", "NX789J", "qcom", "sun",
         "nubia/NX789J/NX789J:15/AP3A.240905.015.A2/20241210.123456:user/release-keys"},
        {"Razer Phone 2", "Razer", "razer", "Razer Phone 2", "aura", "aura", "qcom", "sdm845",
         "razer/aura/aura:9/PQ2A.190405.003/1005:user/release-keys"},
        {"iPhone 17 Pro Max (novelty)", "Apple", "Apple", "iPhone 17 Pro Max", "iPhone18,2", "iPhone18,2", "apple", "apple",
         "Apple/iPhone18,2/iPhone18,2:26/23A000/1:user/release-keys"},
    };

    public static String[] names() {
        String[] n = new String[ALL.length];
        for (int i = 0; i < ALL.length; i++) n[i] = ALL[i][0];
        return n;
    }
}
