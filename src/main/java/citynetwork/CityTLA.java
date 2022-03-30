package citynetwork;

public class CityTLA {
    public final String _cityName;
    public final String _cityCode;

    public CityTLA(String cityName, String cityCode) {
        _cityName = cityName;
        _cityCode = cityCode;
    }

    public boolean checkRep() {
        return Utils.isValidCode(_cityName, _cityCode);
    }
}
