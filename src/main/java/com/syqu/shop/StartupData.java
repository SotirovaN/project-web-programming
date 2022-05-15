package com.syqu.shop;

import com.syqu.shop.domain.Category;
import com.syqu.shop.domain.Product;
import com.syqu.shop.repository.CategoryRepository;
import com.syqu.shop.service.ProductService;
import com.syqu.shop.domain.User;
import com.syqu.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        category1.setId(1);
        category1.setCategoryName("Dress");
        category2.setId(2);
        category2.setCategoryName("Shirt");
        category3.setId(3);
        category3.setCategoryName("Jeans");

        categoryRepository.save(category1);
       categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    private void exampleProducts(){
        final String NAME = "Example Name";
        final String IMAGE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        final String DESCRIPTION = "Example Description";
        final BigDecimal PRICE = BigDecimal.valueOf(22);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();

        product1.setName("Guess");
        product1.setImageUrl("https://img.guess.com/image/upload/f_auto,q_auto:eco,fl_strip_profile,dpr_1.5,fl_advanced_resize,fl_progressive,w_392,c_scale/v1/NA/Style/ECOMM/W1YK85Z2U00-A10L");
        product1.setDescription("Dress");
        product1.setCategory(categoryRepository.findByCategoryName("Dresses"));
        product1.setPrice(BigDecimal.valueOf(5500));

        product2.setName("Polo Ralph Lauren");
        product2.setImageUrl("https://images.bloomingdalesassets.com/is/image/BLM/products/9/optimized/10610769_fpx.tif?$2014_BROWSE_FASHION$&fmt=jpeg&op_usm=0.7,1.0,0.5,0&resMode=sharp2&qlt=85,0&wid=280&hei=350");
        product2.setDescription("Jeans");
        product2.setCategory(categoryRepository.findByCategoryName("Jeans"));
        product2.setPrice(BigDecimal.valueOf(6000));

        product3.setName("Guess");
        product3.setImageUrl("https://img.guess.com/image/upload/f_auto,q_auto,fl_strip_profile,e_sharpen:50,,w_300,c_scale/v1/EU/Style/ECOMM/W1YI0YI3Z00-G011");
        product3.setDescription("Shirt");
        product3.setCategory(categoryRepository.findByCategoryName("Shirt"));
        product3.setPrice(BigDecimal.valueOf(3500));

        product4.setName("Hugo Boss");
        product4.setImageUrl("https://images.hugoboss.com/is/image/boss/hbeu50465225_402_350?$large$=&fit=crop,1&align=1,1&wid=270&qlt=80");
        product4.setDescription("Jacket");
        product4.setCategory(categoryRepository.findByCategoryName("Jackets"));
        product4.setPrice(BigDecimal.valueOf(12000));

        product5.setName("Guess");
        product5.setImageUrl("https://img.guess.com/image/upload/f_auto,q_auto,fl_strip_profile,w_800,c_scale/v1/NA/Style/ECOMM/WB9AJ3D3KI1-CUMB-ALT1");
        product5.setDescription("Jeans");
        product5.setCategory(categoryRepository.findByCategoryName("Jeans"));
        product5.setPrice(BigDecimal.valueOf(6800));

        product6.setName("Liu Jo");
        product6.setImageUrl("https://www.liujo.com/dw/image/v2/BDNR_PRD/on/demandware.static/-/Sites-liujo-master-catalog/default/dwd0903f43/images/8053473372572-Dresses-evening%20dresses-IF0026J185841311-I-AF-N-R-01-N.jpg?sw=742&sh=1032");
        product6.setDescription("Dress");
        product6.setCategory(categoryRepository.findByCategoryName("Dresses"));
        product6.setPrice(BigDecimal.valueOf(18000));

        product7.setName("Tommy Hilfiger");
        product7.setImageUrl("https://i.pinimg.com/736x/98/f8/94/98f89415dc17f4750cc710a687c6821f.jpg");
        product7.setDescription("Jacket");
        product7.setCategory(categoryRepository.findByCategoryName("Jackets"));
        product7.setPrice(BigDecimal.valueOf(10500));

        product8.setName("Calvin Klein");
        product8.setImageUrl("https://calvinklein-eu.scene7.com/is/image/CalvinKleinEU/J30J320717_BEH_main?$listing$");
        product8.setDescription("Shirt");
        product8.setCategory(categoryRepository.findByCategoryName("Shirt"));
        product8.setPrice(BigDecimal.valueOf(2250));


        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);
        productService.save(product7);
        productService.save(product8);
    }
}
