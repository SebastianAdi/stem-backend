package com.stemMedics.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.stemMedics.dao.HospitalRepository;
import com.stemMedics.entity.Hospital;
import com.stemMedics.pojo.HospitalInput;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	private String[] fields = new String[] { "name", "state", "city", "address", "pincode"};

	@Bean
	public FlatFileItemReader<HospitalInput> reader() {
	  return new FlatFileItemReaderBuilder<HospitalInput>()
	    .name("HospitalReader")
	    .resource(new ClassPathResource("hospital.csv"))
	    .delimited()
	    .names(fields)
	    .linesToSkip(1)
	    .fieldSetMapper(new BeanWrapperFieldSetMapper<HospitalInput>() {{
	      setTargetType(HospitalInput.class);
	    }})
	    .build();
	}

	@Bean
	public HospitalProcessor processor() {
		return new HospitalProcessor();
	}
	
	@Bean
    public RepositoryItemWriter<Hospital> writer() {
        RepositoryItemWriter<Hospital> writer = new RepositoryItemWriter<>();
        writer.setRepository(hospitalRepository);
        writer.setMethodName("save");
        return writer;
    }
	
	@Bean
	public Job importUserJob(JobRepository jobRepository,
	    JobCompletionNotificationListener listener, Step step1) {
	  return new JobBuilder("importUserJob", jobRepository)
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(JobRepository jobRepository,
	    PlatformTransactionManager transactionManager, RepositoryItemWriter<Hospital> writer) {
	  return new StepBuilder("step1", jobRepository)
	    .<HospitalInput, Hospital> chunk(10, transactionManager)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .build();
	}

}
