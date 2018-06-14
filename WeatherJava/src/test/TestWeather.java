/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.weatherlibrary.datamodel.Forecastday;
import com.weatherlibrary.datamodel.Hour;
import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.IRepository;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks;

/**
 *
 * @author jccdiaz
 */
public class TestWeather {

	public static void main(String[] args) {
		
		String key = "API_KEY";
		try {
			TestWeather.testHistoricalData(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testHistoricalData(String key)
	{
		IRepository repo = new Repository();
		
		try {
			WeatherModel weatherModel = repo.GetWeatherDataByDate(key, RequestBlocks.GetBy.CityName, "Porto%20Alegre", "2018-06-12");

			System.out.println("WeatherTestJava : location name==============>" + weatherModel.location.name);
			System.out.println("WeatherTestJava : Temperature==============>" + weatherModel.forecast.forecastday.get(0).getHour().get(0).temp_c);

			for (Forecastday forecastday : weatherModel.forecast.forecastday) {
				for (Hour hour : forecastday.getHour()) {

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}			
}
