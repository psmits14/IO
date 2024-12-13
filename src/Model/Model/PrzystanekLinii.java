package Model.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class PrzystanekLinii extends Przystanek {

	private LiniaAutobusowa Linia;
	private Collection<LocalTime> GodzinyOdjazdow = new ArrayList<>();

}