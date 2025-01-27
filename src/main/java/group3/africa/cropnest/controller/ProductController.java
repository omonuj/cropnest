//package group3.africa.cropnest.controller;
//
//import group3.africa.cropnest.dto.ProductRequestDTO;
//import group3.africa.cropnest.dto.ProductResponseDTO;
//import group3.africa.cropnest.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private ProductController productController;
//
//    public ProductController(ProductService productService, ProductController productController) {
//        this.productService = productService;
//        this.productController = productController;
//    }
//
//
//    @PostMapping("/admin/categories/{categoryId}/product")
//    public ResponseEntity<ProductResponseDTO> addProduct(@PathVariable Long categoryId, @RequestBody ProductRequestDTO productRequestDTO) {
//        ProductResponseDTO productResponseDTO = productService.addProduct(categoryId, productRequestDTO);
//        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
//    }
//
//
//
//    @GetMapping("/admin/product/{id}")
//    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
//        ProductResponseDTO productResponseDTO = productService.getProductById(id);
//        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/admin/product/getAllProducts")
//    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
//        List<ProductResponseDTO> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//
//}
