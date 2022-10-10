import java.awt.*;

public class YatirimciKredi implements KrediYonetici{
    public String krediAdi = "Yatırımcı Kredisi";
    final float faiz = 1.40f;

    @Override
    public String krediTuru() {
        return krediAdi;
    }

    @Override
    public float faizOrani() {
        return faiz;
    }
}
