package com.relayr.productcomparisonservice.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.pojo.ProductDTO;

@Configuration
@EnableBatchProcessing
public class FileDataSourceConfig {

	@Bean
	Job job(JobBuilderFactory jobBuilderFactory,StepBuilderFactory stepBuilderFactory,
			ItemReader<ProductDTO> itemReader , ItemProcessor<ProductDTO, Product> itemProcessor,
			ItemWriter<Product> itemWriter) {
		
		Step step = stepBuilderFactory.get("CSV-fileLoader")
				.<ProductDTO,Product>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
				
		
		return jobBuilderFactory.get("FileDatasourceLoad")
		.incrementer( new RunIdIncrementer())
		.start(step)
		.build();
	}
	
	
	 @Bean
	    public FlatFileItemReader<ProductDTO> itemReader() {

	        FlatFileItemReader<ProductDTO> flatFileItemReader = new FlatFileItemReader<>();
	        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/product-data.csv"));
	        flatFileItemReader.setName("CSV-Reader");
	        flatFileItemReader.setLinesToSkip(1);
	        flatFileItemReader.setLineMapper(lineMapper());
	        return flatFileItemReader;
	    }
	 
	 
	 @Bean
	    public LineMapper<ProductDTO> lineMapper() {

	        DefaultLineMapper<ProductDTO> defaultLineMapper = new DefaultLineMapper<>();
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames("productname","description","sitename","siteurl","amount","category_name");

	        BeanWrapperFieldSetMapper<ProductDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(ProductDTO.class);

	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	        return defaultLineMapper;
	    }
	
}
