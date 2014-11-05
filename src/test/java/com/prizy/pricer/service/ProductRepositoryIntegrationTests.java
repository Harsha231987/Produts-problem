/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prizy.pricer.service;

import com.prizy.pricer.ApplicationEntry;
import com.prizy.pricer.domain.Product;
import com.prizy.pricer.service.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationEntry.class)
public class ProductRepositoryIntegrationTests {

	@Autowired
    ProductRepository repository;

    @Test
    public void getProductById(){
        Product product = this.repository.findOne(1l);
        assertThat(product.getProductId(), is(equalTo(1l)));
        assertThat(product.getBarcode(), is(equalTo("B12A33")));
    }

    @Test
    public void saveProduct(){
        Product product = new Product();
        product.setBarcode("BXXXLL2222L");
        product.setName("Demo Product");

        Product savedProduct = repository.save(product);

        assertThat(savedProduct.getProductId(), notNullValue());
        assertThat(savedProduct.getBarcode(), is(equalTo(product.getBarcode())));
        assertThat(savedProduct.getName(), is(equalTo(product.getName())));

    }
}
