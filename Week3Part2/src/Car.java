public class Car {
	
		//default constructor
		public Car(String name){
			this.name = name;
		}
		
		
		private double speed= 0;
		private String name;
		private double distanceTraveled = 0;
		
		//car speed getter
		public double getSpeed() {	
			return this.speed;
		}
		
		//speed setter
		public void setSpeed(double num) {
			this.speed = num;
		}
		
		//car name getter
		public String getName() {
			return name;
		}
		
		//car name setter
		public void setName(String n) {
			name = n;
		}
		//get distance
		public double getDistance() {
			return distanceTraveled;
		}
		
		//set the distance that it traveled
		public void setDistanceTraveled(double m) {
			distanceTraveled = m * speed;
		}
		
		//only accelerate if the number is > 0
		public void accelerate(double number) {
			if(number > 0) {
				speed = speed + number;
			}
		}
		
		//only decelerate if the number is > 0
		public void decelerate(double number) {
			if(number > 0) {
				double num =  this.speed - number;
				setSpeed(num);
			}
		}
		
		//receives a number of hours traveled
		public void travel(double hours) {
			distanceTraveled = distanceTraveled + (speed * hours);	
		}	
	}