import java.util.*;
import java.util.Map.Entry;

public class Interview {

	public static void main(String[] args) {
		ArrayList<Measurement> measurements = new ArrayList<Measurement>();
		Measurement a = new Measurement("speed",10.0,2.0);
		Measurement b = new Measurement("fuel",50.0,5.0);
		Measurement c = new Measurement("speed",40.0,3.0);
		measurements.add(a);
		measurements.add(b);
		measurements.add(c);
		System.out.println(calculateWeightedAverage(measurements));
	}
		
	public static Map<String, Double> calculateWeightedAverage(ArrayList<Measurement> measurements) {
        HashMap<String, ArrayList<Measurement>> measurementsByKey = new HashMap<>();
        for (Measurement m : measurements) 
        {
            ArrayList<Measurement> groupedMeasurements = (ArrayList<Measurement>) measurementsByKey.getOrDefault(m.getName(), new ArrayList<>());
            groupedMeasurements.add(m);
            measurementsByKey.put(m.getName(), groupedMeasurements);
        }

        HashMap<String, Double> weightedAverages = new HashMap<>();
        for (Entry<String, ArrayList<Measurement>> entry : measurementsByKey.entrySet()) {
            ArrayList<Measurement> group = entry.getValue();
            double sum = 0;
            double totalDuration = 0;

            for (Measurement m : group) 
            {
                if (m.getDuration() < 0) 
                {
                    System.out.println("Error, negative duration not accepted.");
                }
                else
                {
                    sum += m.getValue() * m.getDuration();
                    totalDuration += m.getDuration();
                }
            }

                weightedAverages.put(entry.getKey(), sum / totalDuration);
        }

        return weightedAverages;
    }

}
