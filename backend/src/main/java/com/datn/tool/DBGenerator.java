package com.datn.tool;


import com.datn.backend.entity.*;
import com.datn.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.datn.backend.repository"
)
public class DBGenerator implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ShoesColarRepository shoesColarRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private SoleRepository soleRepository;

    @Override
    public void run(String... args) throws Exception {

        Brand brand1 = new Brand();
        brand1.setCode("BR1");
        brand1.setName("Nike");
        brand1.setId(brandRepository.save(brand1).getId());

        Brand brand2 = new Brand();
        brand2.setCode("BR2");
        brand2.setName("Adias");
        brand2.setId(brandRepository.save(brand2).getId());

        Brand brand3 = new Brand();
        brand3.setCode("BR3");
        brand3.setName("Puma");
        brand3.setId(brandRepository.save(brand3).getId());

        Brand brand4 = new Brand();
        brand4.setCode("BR4");
        brand4.setName("Vans");
        brand4.setId(brandRepository.save(brand4).getId());

        Brand brand5 = new Brand();
        brand5.setCode("BR5");
        brand5.setName("Converse");
        brand5.setId(brandRepository.save(brand5).getId());

        Color color1 = new Color();
        color1.setCode("CL1");
        color1.setName("Red");
        color1.setId(colorRepository.save(color1).getId());

        Color color2 = new Color();
        color2.setCode("CL2");
        color2.setName("White");
        color2.setId(colorRepository.save(color2).getId());

        Color color3 = new Color();
        color3.setCode("CL3");
        color3.setName("Blue");
        color3.setId(colorRepository.save(color3).getId());

        Color color4 = new Color();
        color4.setCode("CL4");
        color4.setName("Yellow");
        color4.setId(colorRepository.save(color4).getId());

        Color color5 = new Color();
        color5.setCode("CL5");
        color5.setName("Black");
        color5.setId(colorRepository.save(color5).getId());

        Material material1 = new Material();
        material1.setCode("MT1");
        material1.setName("da");
        material1.setId(materialRepository.save(material1).getId());

        Material material2 = new Material();
        material2.setCode("MT2");
        material2.setName("canvas");
        material2.setId(materialRepository.save(material2).getId());

        Material material3 = new Material();
        material3.setCode("MT3");
        material3.setName("cotton");
        material3.setId(materialRepository.save(material3).getId());

        Product product1 = new Product();
        product1.setCode("PR1");
        product1.setName("nike af1");
        product1.setDescriptions("không có");
        product1.setId(productRepository.save(product1).getId());

        Product         product2 = new Product();
        product2.setCode("PR2");
        product2.setName("nike low");
        product2.setDescriptions("không có");
        product2.setId(productRepository.save(product2).getId());

        Product product3 = new Product();
        product3.setCode("PR3");
        product3.setName("puma v1");
        product3.setDescriptions("không có");
        product3.setId(productRepository.save(product3).getId());

        Size size1 = new Size();
        size1.setCode("CL1");
        size1.setName("39");
        size1.setId(sizeRepository.save(size1).getId());

        Size size2 = new Size();
        size2.setCode("CL2");
        size2.setName("40");
        size2.setId(sizeRepository.save(size2).getId());

        Size size3 = new Size();
        size3.setCode("CL3");
        size3.setName("41");
        size3.setId(sizeRepository.save(size3).getId());

        ShoesColar shoesColar1 = new ShoesColar();
        shoesColar1.setCode("SCL1");
        shoesColar1.setName("High");
        shoesColar1.setId(shoesColarRepository.save(shoesColar1).getId());

        ShoesColar shoesColar2 = new ShoesColar();
        shoesColar2.setCode("SCL2");
        shoesColar2.setName("Mid");
        shoesColar2.setId(shoesColarRepository.save(shoesColar2).getId());

        ShoesColar shoesColar3 = new ShoesColar();
        shoesColar3.setCode("SCL3");
        shoesColar3.setName("low");
        shoesColar3.setId(shoesColarRepository.save(shoesColar3).getId());

        Sole sole1 = new Sole();
        sole1.setCode("Sl1");
        sole1.setName("cao su");
        sole1.setId(soleRepository.save(sole1).getId());

        Sole sole2 = new Sole();
        sole2.setCode("Sl2");
        sole2.setName("gỗ");
        sole2.setId(soleRepository.save(sole2).getId());

        Sole sole3 = new Sole();
        sole3.setCode("Sl3");
        sole3.setName("boot");
        sole3.setId(soleRepository.save(sole1).getId());

        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setPrice(new BigDecimal("100"));
        productDetail1.setQuantity(200);
        productDetail1.setStatus(1);
        productDetail1.setBrandId(brand1.getId());
        productDetail1.setColorId(color2.getId());
        productDetail1.setMaterialId(material1.getId());
        productDetail1.setProductId(product1.getId());
        productDetail1.setShoesColarId(shoesColar2.getId());
        productDetail1.setSizeId(size3.getId());
        productDetail1.setSoleId(sole2.getId());
        productDetail1.setId(productDetailRepository.save(productDetail1).getId());


        ProductDetail productDetail2 = new ProductDetail();
        productDetail2.setPrice(new BigDecimal("300"));
        productDetail2.setQuantity(100);
        productDetail2.setStatus(1);
        productDetail2.setBrandId(brand2.getId());
        productDetail2.setColorId(color1.getId());
        productDetail2.setMaterialId(material1.getId());
        productDetail2.setProductId(product3.getId());
        productDetail2.setShoesColarId(shoesColar3.getId());
        productDetail2.setSizeId(size2.getId());
        productDetail2.setSoleId(sole1.getId());
        productDetail2.setId(productDetailRepository.save(productDetail2).getId());

        ProductDetail productDetail3 = new ProductDetail();
        productDetail3.setPrice(new BigDecimal("50"));
        productDetail3.setQuantity(400);
        productDetail3.setStatus(1);
        productDetail3.setBrandId(brand3.getId());
        productDetail3.setColorId(color3.getId());
        productDetail3.setMaterialId(material3.getId());
        productDetail3.setProductId(product2.getId());
        productDetail3.setShoesColarId(shoesColar1.getId());
        productDetail3.setSizeId(size1.getId());
        productDetail3.setSoleId(sole3.getId());
        productDetail3.setId(productDetailRepository.save(productDetail3).getId());

        ProductDetail productDetail4 = new ProductDetail();
        productDetail4.setPrice(new BigDecimal("90"));
        productDetail4.setQuantity(300);
        productDetail4.setStatus(1);
        productDetail4.setBrandId(brand1.getId());
        productDetail4.setColorId(color2.getId());
        productDetail4.setMaterialId(material3.getId());
        productDetail4.setProductId(product3.getId());
        productDetail4.setShoesColarId(shoesColar1.getId());
        productDetail4.setSizeId(size2.getId());
        productDetail4.setSoleId(sole2.getId());
        productDetail4.setId(productDetailRepository.save(productDetail4).getId());

        ProductDetail productDetail5 = new ProductDetail();
        productDetail5.setPrice(new BigDecimal("90"));
        productDetail5.setQuantity(300);
        productDetail5.setStatus(1);
        productDetail5.setBrandId(brand1.getId());
        productDetail5.setColorId(color3.getId());
        productDetail5.setMaterialId(material2.getId());
        productDetail5.setProductId(product1.getId());
        productDetail5.setShoesColarId(shoesColar2.getId());
        productDetail5.setSizeId(size2.getId());
        productDetail5.setSoleId(sole3.getId());
        productDetail5.setId(productDetailRepository.save(productDetail5).getId());


    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();
    }
}
