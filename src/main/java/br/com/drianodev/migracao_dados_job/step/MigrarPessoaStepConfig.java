package br.com.drianodev.migracao_dados_job.step;

import br.com.drianodev.migracao_dados_job.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MigrarPessoaStepConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    Step migrarPessoaStep(
            ItemReader<Pessoa> arquivoPessoaReader,
            ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter,
            FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter,
            TaskExecutor taskExecutor) {
        return new StepBuilder("migrarPessoaStep", jobRepository)
                .<Pessoa, Pessoa>chunk(10000, transactionManager)
                .reader(arquivoPessoaReader)
                .writer(pessoaClassifierWriter)
                .taskExecutor(taskExecutor)
                .stream(arquivoPessoasInvalidasWriter)
                .build();
    }
}
