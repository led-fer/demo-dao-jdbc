package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Progrma2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: Department findById====");
		Department dep = depDao.findById(2);

		System.out.println(dep);

		System.out.println("\n=== TEST 2: Department findAll====");
		List<Department> listDep = new ArrayList<Department>();
		listDep = depDao.findAll();

		for (Department d : listDep) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: seller insert====");
		Department newDep = new Department(null, "Electrical Appliance");
		depDao.insert(newDep);
		System.out.println("Inserted! new Id = " + newDep.getId());
		

		System.out.println("\n=== TEST 4: Department update====");
		dep = depDao.findById(1);
		dep.setName("Computers");
		depDao.update(dep);
		System.out.println("Update Complet");
		
		System.out.println("\n=== TEST 5: Department delete====");
		System.out.println("Enter id for delete test: ");
		
		int id = sc.nextInt();
		
		depDao.deleteById(id);
		
		System.out.println("Delete completed");

	}

}
