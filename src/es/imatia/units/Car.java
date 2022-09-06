package es.imatia.units;



public class Car {

	 String brand;
	 String model;
	 int maxSpeed;
	 String fuelType;
	 int speedometer;
	 int tachometer;
	 String gear = "N";
	 boolean reverse = false;
	 int steeringWheelAngle;
	
	public Car () {
	
		this.brand = "";
		this.model = "";
		this.maxSpeed = 120;
		this.fuelType = "" ;
		
	}
	
	public Car (String brand, String model , int maxSpeed , String fuelType) {
		this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
	}
	public static void main(String[] args) {
		Car myCar = new Car("Peugeot", "206", 15, "gasolina");

		
		String option = "";
		System.out.println();
		do {
			System.out.println(myCar.showDetails());
			option = Input.string(
					"Selección: \n     '+' - Acelerar\n     '-' - Frear\n     'n' - Marcha directa\n     'r' - Marcha atrás\n     'd' - Xirar a dereita\n     'i' - Xirar a esquerda\n     'end' - Acaba o programa\nQué opción desexa facer?: ");
			System.out.println();
			switch (option) {
			case "+":
				myCar.acelerate();
				break;
			case "-":
				myCar.brake();
				break;
			case "r":
				myCar.setReverse(true);
				break;
			case "n":
				myCar.setReverse(false);
				break;
			case "d":
				myCar.turnSteeringWheel(5);
				break;
			case "i":
				myCar.turnSteeringWheel(-5);
				break;
			case "end":
				break;
			default:
				System.out.println("Non existe esa opción");
				break;
			}
		} while (!option.equalsIgnoreCase("end"));
	}
	
	public String getBrand() {return brand;}
	public void setBrand(String brand) {this.brand = brand;}
	
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	
	public int getMaxSpeed() {return maxSpeed;}
	public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
	
	public String getFuelType() {return fuelType;}
	public void setFuelType(String fuelType) {this.fuelType = fuelType;}
	
	public int getSpeedometer() {return speedometer;}
	public void setSpeedometer(int speedometer) {this.speedometer = speedometer;}
	
	public int getTachometer() {return tachometer;}
	public void setTachometer(int tachometer) {this.tachometer = tachometer;}
	
	public String getGear() {return gear;}
	public void setGear(String gear) {this.gear = gear;}
	
	public boolean isReverse() {return reverse;}
	
	public void setReverse(boolean reverse) {
		if (this.speedometer == 0) {
			if (this.reverse) {
				this.reverse = reverse ;
				this.gear = "R";
			}else {
				System.out.println("la marcha atras ya esta puesta");
				this.gear = "N";
			}
		}else {
			System.out.println("Primero para el coche");
		}
	}
	
	public int getSteeringWheelAngle() {return steeringWheelAngle;}
	public void setSteeringWheelAngle(int steeringWheelAngle) {this.steeringWheelAngle = steeringWheelAngle;}
	
	
	
	
	public String showDetails() {
		return "Car [brand=" + brand + ", model=" + model + ", maxSpeed=" + maxSpeed + ", fuelType=" + fuelType
				+ ", speedometer=" + speedometer + ", tachometer=" + tachometer + ", gear=" + gear + ", reverse="
				+ reverse + ", steeringWheelAngle=" + steeringWheelAngle + "]";
	}

	public void start() {
		if(this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Vehículo encendido");
		}else {
			System.out.println("El vehículo ya está encendido");
		}
	}
	
	public void stop () {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			System.out.println("Vehículo apagado");
		}else {
			System.out.println("Primero detén el vehículo");
		}
	}
	
	
	public void acelerate() {
		
		if( (!isReverse() && this.speedometer < this.maxSpeed) || (isReverse() && this.speedometer < 25) ){
			 this.speedometer += 5; 
			 calculateTachometer();
		} else {
			System.out.println("No puedes acelerar más");
		}
	}
		
	
	private void calculateTachometer() {
			double gearVel = (float) this.speedometer / 25;
			double gearVelInt = Math.floor(gearVel);
			this.gear = Integer.toString((int) (gearVelInt) + 1);
			double fract = gearVel - gearVelInt;
			this.tachometer = (int) ((fract * 100 * 1500) / 100) + 1000;
	}
	
	public void brake() {
		if (this.speedometer > 0) {
			this.speedometer -= 5;
			if(!isReverse()){	
				calculateTachometer();
			}else {
				this.tachometer = 1000;
				this.gear = "N";
			}
		}else {
			System.out.println("Esta parado");
		}
	}
	
	public void turnSteeringWheel(int angle) {
		
		if (this.steeringWheelAngle + angle >= -45 && this.steeringWheelAngle + angle <= 45) {
			this.steeringWheelAngle += angle;
		} else {
			System.out.println("No se puede girar mas el volante");
		}
	}
	
	
	public void showSteeringWheel() {
		if (this.getSteeringWheelAngle() <0) { 
			System.out.println("El volante gira a la izquierda");
		}
		if (this.getSteeringWheelAngle() == 0) {
			System.out.println("El volante está recto");
		}else {
			System.out.println("El volante gira a la derecha");
		}
	}
	
	
}
