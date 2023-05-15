public class Measurement {

private String name = null;
private double value = 0.0;
private double duration = 0.0;

	public Measurement(String name, double value, double duration)
	{
		this.name = name;
		this.value = value;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
}
