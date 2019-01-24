package pl.app.building.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.app.building.equipment.app.ApplicationController;
import pl.app.building.equipment.components.device.DeviceRepository;

import java.util.Scanner;

@SpringBootApplication
public class BuildingEquipmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BuildingEquipmentApplication.class, args);

		ApplicationController controller = ctx.getBean(ApplicationController.class);
		controller.mainLoop();
	}

		@Bean
		public Scanner scanner(){
			return new Scanner(System.in) ;
		}


}

