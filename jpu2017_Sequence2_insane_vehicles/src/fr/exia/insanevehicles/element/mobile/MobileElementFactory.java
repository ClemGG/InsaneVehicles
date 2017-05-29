package fr.exia.insanevehicles.element.mobile;

public abstract class MobileElementFactory {


		/** The Constant Vehicle. */
		private static final MyVehicle VEHICLE = new MyVehicle();

		/**
		 * Creates a new ditch object.
		 *
		 * @return the motionless element
		 */
		public static MyVehicle createVehicle() {
			return VEHICLE;
		}
	}

