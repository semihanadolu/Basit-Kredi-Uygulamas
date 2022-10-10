import java.awt.*;

public class CiftciKredi implements KrediYonetici{
    public String krediAdi = "Çiftçi Kredisi";
    final float faiz = 1.20f;

    @Override
    public String krediTuru() {
        return krediAdi;
    }

    @Override
    public float faizOrani() {
        return faiz;
    }
}
