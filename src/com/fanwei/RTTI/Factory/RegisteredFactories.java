/**
 * 
 */
package com.fanwei.RTTI.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author fanwei
 *
 */
class Part {
	public String toString() {
		return getClass().getSimpleName();
	}
	
	static List<Factory<? extends Part>> partFactories = 
			new ArrayList<Factory<? extends Part>>();
	
	static {
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
	}
	
	private static Random rand = new Random(47);
	
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {}

class FuelFilter extends Filter {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<FuelFilter> {

		@Override
		public FuelFilter create() {
			// TODO Auto-generated method stub
			return new FuelFilter();
		}
		
	}
}

class AirFilter extends Filter {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<AirFilter> {

		@Override
		public AirFilter create() {
			// TODO Auto-generated method stub
			return new AirFilter();
		}
		
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<CabinAirFilter> {

		@Override
		public CabinAirFilter create() {
			// TODO Auto-generated method stub
			return new CabinAirFilter();
		}
		
	}
}

class OilFilter extends Filter {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<OilFilter> {

		@Override
		public OilFilter create() {
			// TODO Auto-generated method stub
			return new OilFilter();
		}
		
	}
}

class Belt extends Part {}

class FanBelt extends Belt {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<FanBelt> {

		@Override
		public FanBelt create() {
			// TODO Auto-generated method stub
			return new FanBelt();
		}
		
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<GeneratorBelt> {

		@Override
		public GeneratorBelt create() {
			// TODO Auto-generated method stub
			return new GeneratorBelt();
		}
		
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements com.fanwei.RTTI.Factory.Factory<PowerSteeringBelt> {

		@Override
		public PowerSteeringBelt create() {
			// TODO Auto-generated method stub
			return new PowerSteeringBelt();
		}
		
	}
}

public class RegisteredFactories {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
	}

}
