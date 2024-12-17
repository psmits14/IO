package Kontroler.Kontroler;

import Model.Model.ObslugaBiletow;

public interface StrategiaSprawdzaniaBiletow {

	public void wykonajStrategie(FasadaInterakcji fasadaInterakcji, ObslugaBiletow obslugaBiletow); // czy korzystać z interfejsow czy klas ktore je implementuja
}