package group3.africa.cropnest.service;

import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;
import group3.africa.cropnest.exception.InvalidPaginationOrSortException;
import group3.africa.cropnest.exception.ProductNotFoundException;
import group3.africa.cropnest.exception.ProductServiceException;
import group3.africa.cropnest.model.Category;
import group3.africa.cropnest.repository.CategoryRepository;
import group3.africa.cropnest.repository.ProductRepository;
import group3.africa.cropnest.model.Product;
import group3.africa.cropnest.exception.CategoryNotFoundException;
import group3.africa.cropnest.Utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findByCategoryId(categoryId)
                . orElseThrow(() -> new CategoryNotFoundException("Category with ID " + categoryId + " not found."));

        Product product = new Product();
        product.setCategoryId(category);
        product.setProductName(productRequestDTO.getProductName());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductImageUrl(productRequestDTO.getProductImageUrl());
        product.setProductQuantity(productRequestDTO.getProductQuantity());
        product.setDiscountedPrice(productRequestDTO.getDiscountedPrice());

        try {
            Product savedProduct = productRepository.save(product);
            return productMapper.toProductResponseDTO(savedProduct);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while saving the product.", e);
        }
    }



    @Override
    public ProductResponseDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productMapper.toProductResponseDTO(product.get());
        }
        else
            throw new ProductNotFoundException("Product With ID " + id + " not found.");
    }


    @Override
    public ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product productToUpdate = product.get();
            productToUpdate.setProductName(productRequestDTO.getProductName());
            productToUpdate.setProductDescription(productRequestDTO.getProductDescription());
            productToUpdate.setProductPrice(productRequestDTO.getProductPrice());
            productToUpdate.setProductImageUrl(productRequestDTO.getProductImageUrl());
            productToUpdate.setProductQuantity(productRequestDTO.getProductQuantity());
            productToUpdate.setDiscountedPrice(productRequestDTO.getDiscountedPrice());
            return productMapper.toProductResponseDTO(productRepository.save(productToUpdate));
        }
        else
            throw new ProductNotFoundException("Product With ID " + id + " not found.");
    }


    @Override
    public ProductResponseDTO deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product With ID " + id + " not found.");
        }
        productRepository.delete(product.get());
        return productMapper.toProductResponseDTO(product.get());
    }



    public Page<ProductResponseDTO> getAllProducts(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        try {
            Sort sort = sortOrder.equalsIgnoreCase("desc") ?
                    Sort.by(sortBy).descending() :
                    Sort.by(sortBy).ascending();

            Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

            return productRepository.findAll(pageable).map(productMapper::toProductResponseDTO);

        } catch (IllegalArgumentException e) {
            throw new InvalidPaginationOrSortException("Invalid pagination or sorting parameter: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ProductServiceException("An unexpected error occurred while fetching products.", e);
        }
    }


    }



