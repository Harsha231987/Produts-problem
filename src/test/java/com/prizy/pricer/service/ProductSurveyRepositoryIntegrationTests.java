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
import com.prizy.pricer.domain.ProductSurvey;
import com.prizy.pricer.service.repository.ProductSurveyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationEntry.class)
public class ProductSurveyRepositoryIntegrationTests {

	@Autowired
    ProductSurveyRepository repository;

    @Test
    public void getProductById(){
        ProductSurvey product = this.repository.findOne(1l);
        assertThat(product.getProductSurveyId(), is(equalTo(1l)));
        assertThat(product.getProductId(), is(equalTo(1l)));
    }

    @Test
    public void saveProductSurvey(){
        ProductSurvey survey = new ProductSurvey();
        survey.setProductId(1l);
        survey.setStoreName("Store 1");
        survey.setPrice(new BigDecimal(33.5));
        survey.setDescription("test survey");

        ProductSurvey savedSurvey = repository.save(survey);

        assertThat(savedSurvey.getProductSurveyId(), notNullValue());
        assertThat(savedSurvey.getProductId(), is(equalTo(survey.getProductId())));
        assertThat(savedSurvey.getStoreName(), is(equalTo(survey.getStoreName())));

    }
}
