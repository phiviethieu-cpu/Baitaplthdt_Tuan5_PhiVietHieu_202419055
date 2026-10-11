public class Projector extends Device {
    private int doSang; // lumen
    private int soGioBongDen;

    public Projector(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                     int doSang, int soGioBongDen) {
        super(maThietBi, tenThietBi, namSuDung, giaMua);
        setLumens(doSang);
        setLampHours(soGioBongDen);
    }

    public int getLumens() {
        return doSang;
    }

    public void setLumens(int doSang) {
        if (doSang <= 0) {
            throw new IllegalArgumentException("Do sang khong hop le");
        }
        this.doSang = doSang;
    }

    public int getLampHours() {
        return soGioBongDen;
    }

    public void setLampHours(int soGioBongDen) {
        if (soGioBongDen < 0) {
            throw new IllegalArgumentException("So gio bong den < 0");
        }
        this.soGioBongDen = soGioBongDen;
    }

    @Override
    public double calculateMaintenanceCost() {
        double chiPhi = getPrice() * 0.03;
        if (soGioBongDen > 3000) {
            chiPhi += 1500000;
        }
        return chiPhi;
    }

    @Override
    public String toString() {
        return "May chieu " + super.toString()
                + String.format(" | Do sang: %d lumen | Bong den: %,d gio", doSang, soGioBongDen);
    }
}
