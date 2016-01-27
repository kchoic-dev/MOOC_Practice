package guimodule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet{

	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup(){
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBank.csv");
		// Load country polygons and adds them as markers
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		
		// Country markers are shaded according to life expectancy (only once)
		//shadeCountries();	
	}
	
	public void draw(){
		System.setProperty("java.net.useSystemProxies","true");
		System.setProperty("http.proxyHost", "70.10.15.10");
		System.setProperty("http.proxyPort", "8080");

		map.addMarkers(countryMarkers);
		map.draw();
		
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileNmae){
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileNmae);
		
		for (String row: rows){
			String[] columns = row.split(",");
			if(columns.length == 6 && !columns[5].equals("..")) {
				float value=  Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		
		
		
		return lifeExpMap;
	}
}
