import java.awt.*;

public class OgrenciKredi implements KrediYonetici {

    private String krediAdi = "Öğrenci Kredisi";
    final float faiz = 1.65f;

    @Override
    public String krediTuru() {
        return krediAdi;
    }

    @Override
    public float faizOrani() {
        return faiz;
    }
}