package com.example.demo.Mappers;

import com.example.demo.DB.data.Product;
import com.example.demo.DTO.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper{
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDTO productDTO);

    @InheritInverseConfiguration
    ProductDTO  fromProduct(Product Product);

    List<Product> toProductList(List<ProductDTO> productDTO);

    List<ProductDTO> fromProductList(List<Product> products);

}
