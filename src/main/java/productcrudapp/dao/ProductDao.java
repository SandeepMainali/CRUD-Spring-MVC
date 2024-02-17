package productcrudapp.dao;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.transaction.Transactional;

import productcrudapp.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;


@Component
public class ProductDao {
	
@Autowired
private HibernateTemplate  hibernatetemplate ;

//create
@Transactional
public void createProduct(Product product) {
	
	this.hibernatetemplate.saveOrUpdate(product);
	
	}

//get all products
public List<Product> getProducts(){
	
	List<Product> products=this.hibernatetemplate.loadAll(Product.class);
	return products;
}

//delete
@Transactional
public void deleteProduct(int pid) {
	Product p=this.hibernatetemplate.load(Product.class, pid);
	this.hibernatetemplate.delete(p);
}

//get the single product
public Product getproduct(int pid) {
	return this.hibernatetemplate.get(Product.class,pid);
}


	
}
