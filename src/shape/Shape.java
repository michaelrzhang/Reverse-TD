package src.shape;
public abstract class Shape{
	// SHOULD TEST/CONSIDER IMPROVEMENTs to overlap
	// Generic polygon class?
	double x_position;  // these should be the coordinates of the center
	double y_position;
	double apothem;
	String name;

	/**
	 * Returns whether or not two shapes overlap
	 */
	public static boolean overlaps(Shape a, Shape b){
	// two regular polygons hard
		double distance = getDistance(a, b);
		double delta_x = a.x_position - b.x_position;
		double delta_y = a.y_position - b.y_position;
		// should be the minimum of apothem/cos(theta_x) because
		// the direct distance that is inside the shape is shorter
		// when the ratio between delta_y/delta_x is more extreme
		double theta1 = Math.abs(Math.atan(delta_y/delta_x));
		double theta2 = Math.abs(Math.atan(delta_y/delta_x));
		double cosine_theta = Math.max(Math.cos(theta1), Math.cos(theta2));
		double a_distance, b_distance;
		if (a.name.equals("circle")){
			a_distance = a.apothem;
		}
		else{
			a_distance = a.apothem / cosine_theta;
		}
		if (b.name.equals("circle")){
			b_distance = b.apothem;
		}
		else{
			b_distance = b.apothem / cosine_theta;
		}

		if (a_distance + b_distance >= distance){
			return true;
		}
		return false;
	}

	/**
	 * Returns distance between two different shapes
	 */
	public static double getDistance(Shape a, Shape b){
		double delta_x = a.x_position - b.x_position;
		double delta_y = a.y_position - b.y_position;
		return Math.sqrt(delta_x * delta_x + delta_y * delta_y);
	}
	public void set_X(double x){
		this.x_position = x;
	}
	public void set_Y(double y){
		this.y_position = y;
	}
	public abstract void draw();
}