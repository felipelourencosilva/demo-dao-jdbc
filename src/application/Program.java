package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== Test 1: seller findById ====\n");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("==== Test 2: seller findByDepartment ====\n");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("==== Test 3: seller findAll ====\n");
        List<Seller> sellers = sellerDao.findAll();

        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("==== Test 4: seller insert ====\n");
        Seller sel = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);

        sellerDao.insert(sel);
        System.out.println("Id =" + sel.getId());
    }
}