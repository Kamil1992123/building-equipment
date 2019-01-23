package pl.app.building.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.app.building.equipment.dao.DeviceDAO;
import pl.app.building.equipment.model.Category;
import pl.app.building.equipment.model.Customer;
import pl.app.building.equipment.model.Device;

@SpringBootApplication
public class BuildingEquipmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BuildingEquipmentApplication.class, args);
		DeviceDAO deviceDao = ctx.getBean(DeviceDAO.class);


		Device device = new Device();
		device.setName("Wiertarka udarowa");
		device.setDescription("Wiertarka udarowa o dużej mocy 3000W z zestawem wierteł w komplecie");
		device.setPrice(80);
		device.setAmount(5);

		Category category = new Category();
		category.setName("Elektronarzędzia");
		category.setDescription("Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia");

		Customer customer = new Customer();
		customer.setName("Jan");
		customer.setSurname("Kowalski");
		customer.setPesel("90908765123");
		customer.setDocumentNumber("ABC678123");

		device.setCategory(category);
		device.addCustomer(customer);

		deviceDao.create(device);


	}











}

