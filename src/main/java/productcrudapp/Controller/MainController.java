package productcrudapp.Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products= productDao.getProducts();
		m.addAttribute("product",products);
		return "index";
	}
	

	@RequestMapping("/addProduct")
	public String addProduct() {
		return"add_Product_form";
	}
	
	
	//handle add product
	@RequestMapping(value="/handle_product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView  redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
		
	}
	
	@RequestMapping("/delete/{ProductId}")
	public RedirectView deleteProduct(@PathVariable("ProductId") int ProductId,HttpServletRequest request) {
		this.productDao.deleteProduct(ProductId);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
		
		
	}
	
	@RequestMapping("/update/{ProductId}")
	public String update(@PathVariable("ProductId") int pid,Model model) {
		
		Product product = this.productDao.getproduct(pid);
		model.addAttribute("product",product);
		return "update_form";
	}

}
