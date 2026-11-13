package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private IBrandService brandService;
    private IImageService imageService;
    private Slugger slugger;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();
        product.setLabel(dto.label);
        product.setSlug(slugger.slugify(dto.label));
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setBrand(brandService.getById(dto.brandId));
        productRepository.saveAndFlush(product);

        for(ImageDTO imageDTO : dto.images) {
            Image image = imageService.create(imageDTO,  product);
            product.addImage(image);
        }

        imageService.flush();
        return product;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Product update(String id, ProductDTO dto) {
        return null;
    }

}
